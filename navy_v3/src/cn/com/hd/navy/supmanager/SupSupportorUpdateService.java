package cn.com.hd.navy.supmanager;

import cn.com.hd.dto.navy.THighWay;
import cn.com.hd.dto.navy.TSupTrans;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.dto.navy.TTransport;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;


public class SupSupportorUpdateService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TSupportor supportor = new TSupportor();
		super.getData(request.getDto(), supportor);

		Conditions cons = new Conditions();
		cons.addCondition(new TSupportor());
		cons.addExpression("SUP_NAME = '" + supportor.getSupname() + "' AND SUP_ID != '" + supportor.getSupid() + "'");
		
		if (queryResultSet(cons).getRowCount() > 0) {
			Request res = new Request();
			res.setResponseSystemName("HDDict");
			res.setResponseSubsystemName("DictManage");
			res.setResponseServiceName("SupportorDictQueryService");
			Response resp = requestService(res);
			
			response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("供应商名称已存在");
			response.setResult(0);
			
			return response;
		}
		
		cons = new Conditions();
		cons.addCondition(new TSupportor());
		cons.addExpression("ORGANIZE_CODE = '" + supportor.getOrganizecode() + "' AND SUP_ID != '" + supportor.getSupid() + "'");
		
		if (queryResultSet(cons).getRowCount() > 0) {
			Request res = new Request();
			res.setResponseSystemName("HDDict");
			res.setResponseSubsystemName("DictManage");
			res.setResponseServiceName("SupportorDictQueryService");
			Response resp = requestService(res);
			
			response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("组织机构代码已存在");
			response.setResult(0);
			
			return response;
		}
		
		if (supportor.getSupid() == null) {
			response.setRequestParam(request.getDto());
			response.setResult(0);
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("供应商ID为空，修改失败");
			return response;
		}
		
		int result = super.update(supportor);
		
		String sql = "UPDATE T_IMPORT IM SET SUPPORTOR = '" + supportor.getSupname() + 
				"', SUPPORTOR_ADDR = '" + supportor.getAddress() + 
				"' WHERE SUPPORTOR_ID = '" + supportor.getSupid() + "'";
		
		result = executeSql(sql, null, null);
		
		/////////////////////////////////////////////////////////////////////////////////
		// 更新运输信息
		TSupTrans supTrans = new TSupTrans();
		super.getData(request.getDto(), supTrans);
		if(supTrans.getComid()==null || supTrans.getComid().equals("")) {
			super.save(supTrans);		
		} else {
			super.update(supTrans);
		}
		
		TTransport trans = new TTransport();
		super.getData(request.getDto(), trans);
		cons = new Conditions();
		cons.addCondition(trans);
		cons.addExpression("COM_NAME='" + trans.getComname() + "' AND COM_ID!=" + trans.getComid() + "'");
		if(queryResultSet(cons).getRowCount()>0) {
			Request res = new Request();
			res.setResponseSystemName("HDDict");
			res.setResponseSubsystemName("DictManage");
			res.setResponseServiceName("SupportorDictQueryService");
			Response resp = requestService(res);
			
			response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("运输服务企业已存在");
			response.setResult(0);
			
			return response;			
		}
		super.update(trans);
		
		THighWay hiw = new THighWay();
		super.getData(request.getDto(), hiw);
		cons = new Conditions();
		cons.addCondition(hiw);
		cons.addExpression("COM_ID='" + hiw.getComid() + "' AND HIW_ID='" + hiw.getHiwid() + "'");
		if(queryResultSet(cons).getRowCount()==0) {
			super.save(hiw);
		} else {
			super.update(hiw);
		}
		
		response.getDto().put("REQUEST_PARAM", request.getDto());
		response.getDto().setList("RESULT", getDTO(supportor));
		response.getDto().put("RESULT", result);
		
		return response;
	}

}		