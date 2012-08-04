package cn.com.hd.navy.supportormanage;

import java.util.UUID;

import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.error.Debug;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorAddService extends BaseService implements IService {

	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		//获取数据
		TSupportor supportor = new TSupportor();
		super.getData(request.getDto(), supportor);
		
		Debug.debugMessage(1, request, supportor.toString());
		
		Conditions cons = new Conditions();
		cons.addCondition(new TSupportor());
		cons.addExpression("SUP_NAME = '" + supportor.getSupname() + "' OR SUP_EN_NAME = '" + supportor.getSupenname() + "'");
		
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
		cons.addExpression("ORGANIZE_CODE = '" + supportor.getOrganizecode() + "'");
		
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
			supportor.setSupid(UUID.randomUUID().toString());
		}
		
		//保存数据
		
		int result = super.save(supportor);
		
		response.setRequestParam(request.getDto());
		response.getDto().setList("RESULT", getDTO(supportor));
		response.setResult(result);
		
		return response;
	}

}
