package cn.com.hd.navy.supportormanage;

import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorUpdateService extends BaseService implements IService {

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
			response.setErrorInfo("��Ӧ�������Ѵ���");
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
			response.setErrorInfo("��֯���������Ѵ���");
			response.setResult(0);
			
			return response;
		}
		
		if (supportor.getSupid() == null) {
			response.setRequestParam(request.getDto());
			response.setResult(0);
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("��Ӧ��IDΪ�գ��޸�ʧ��");
			return response;
		}
		
		int result = super.update(supportor);
		
		String sql = "UPDATE T_IMPORT IM SET SUPPORTOR = '" + supportor.getSupname() + 
				"', SUPPORTOR_ADDR = '" + supportor.getAddress() + 
				"' WHERE SUPPORTOR_ID = '" + supportor.getSupid() + "'";
		
		result = executeSql(sql, null, null);

		response.getDto().put("REQUEST_PARAM", request.getDto());
		response.getDto().setList("RESULT", getDTO(supportor));
		response.getDto().put("RESULT", result);
		
		return response;
	}

}
