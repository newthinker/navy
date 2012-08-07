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

public class SupSupportorQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/// 供应商表查询结果
		TSupportor supportor = new TSupportor();
		super.getQueryData(request.getDto(), supportor);
		
		PageInfo page = super.getPageInfo();
		
		// 供应商名称
		String supname = supportor.getSupname();
		supportor.setSupname(null);		
		// 供应商位置
		String l1Area = supportor.getL1Loc();
		String l2Area = supportor.getL2Loc();		
		// 供应商注册资金
		double capital = supportor.getLiccapital();
		
		Conditions cons = new Conditions();
		cons.addCondition(supportor);
		
		// 首先根据供应商提交的条件查询出符合范围的供应商
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
		/// 产品表
		TSupProduct supProduct = new TSupProduct();
		super.getQueryData(request.getDto(), supProduct);
		
		// 生产范围--产品类型
		String dictcode = supProduct.getProdid();
		// 产品产能--年产量
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
		/// 运输表
		TTransport transport = new TTransport();
		super.getQueryData(request.getDto(), transport);
		
		// 相应运力
		Double capacity = transport.getDeadweight();		/// 将用户输入的运力条件保存到载重量字段中
		exp = null;
		if (capacity>0) {
			exp = "exists (select 1 from T_SUP_TRANS dto3, T_TRANSPORT dto4 where dto1.SUP_ID=dto3.SUP_ID and dto3.COM_ID=dto4.COM_ID and " + 
				"dto4.DEADWEIGHT×dto4.COUNT>=" + capacity + ")";
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
