package cn.com.hd.navy.supportormanage;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.dto.navy.TTransport;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorSuperQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/// ��Ӧ�̱��ѯ���
		TSupportor supportor = new TSupportor();
		super.getQueryData(request.getDto(), supportor);
		
		PageInfo page = super.getPageInfo();
		
		// ��Ӧ������
		String supname = supportor.getSupname();
		supportor.setSupname(null);		
		// ��Ӧ��λ��
		String l1Area = supportor.getL1Loc();
		String l2Area = supportor.getL2Loc();		
		// ��Ӧ��ע���ʽ�
		double capital = supportor.getLiccapital();
		
		Conditions cons = new Conditions();
		cons.addCondition(supportor);
		
		// ���ȸ��ݹ�Ӧ���ύ��������ѯ�����Ϸ�Χ�Ĺ�Ӧ��
		if (supname != null && !supname.trim().equals("")) {
			cons.addExpression("SUP_NAME like '%" + supname + "%' OR SUP_EN_NAME like '%" + supname + "%'");
		}
		if (l1Area!=null) {
			cons.addExpression("L1_LOC = '" + l1Area + "'");
		}
		if (l2Area!=null) {
			cons.addExpression("L2_LOC = '" + l2Area + "'");
		}
		if (capital>0 && capital<6) {
			if(capital<5) {
				cons.addExpression("LIC_CAPITAL>" + Math.pow(10, capital-1) + " and LIC_CAPITAL<" + Math.pow(10,capital));
			} else {
				cons.addExpression("LIC_CAPITAL>" + Math.pow(10, 5));
			}
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/// ��Ʒ��
		TSupProduct supProduct = new TSupProduct();
		super.getQueryData(request.getDto(), supProduct);
		
		// ������Χ--��Ʒ����
		String dictcode = supProduct.getProdid();
		// ��Ʒ����--�����
		Double output = supProduct.getAvgoutput();
		String exp = null;
		if (dictcode!=null || output>0) {
			exp = "exists (select 1 from T_SUP_PRODUCT dto2 where dto1.SUP_ID=dto2.SUP_ID";
			
			if(dictcode!=null) {
				exp += " and dto2.PROD_ID=" + dictcode;
			}
			if(output>0) {
				exp += " and dto2.AVG_OUTPUT>=" + output;
			}
			
			exp += ")";
		}
		if (exp!=null) {
			cons.addExpression(exp);
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/// �����
		TTransport transport = new TTransport();
		super.getQueryData(request.getDto(), transport);
		
		// ��Ӧ����
		Double capacity = transport.getDeadweight();		/// ���û�����������������浽�������ֶ���
		exp = null;
		if (capacity>0) {
			exp = "exists (select 1 from T_SUP_TRANS dto3, T_TRANSPORT dto4 where dto1.SUP_ID=dto3.SUP_ID and dto3.COM_ID=dto4.COM_ID and " + 
				"dto4.DEADWEIGHT��dto4.COUNT>=" + capacity + ")";
		}
		if(exp!=null) {
			cons.addExpression(exp);
		}
		
		SelectResultSet result = super.queryResultSet(page, cons);
		
		List list = super.getDTO(result);
		
		resp.getDto().setList("RESULT", list);
		resp.setPageInfo(page);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
