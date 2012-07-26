package cn.com.hd.navy.importmanage;

import java.util.UUID;

import cn.com.hd.dto.navy.TImport;
import cn.com.hd.error.Debug;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ImportAddService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		//获取数据
		TImport navyImp = new TImport();
		super.getData(request.getDto(), navyImp);
		
		Debug.debugMessage(1, request, navyImp.toString());
		
		Conditions cons = new Conditions();
		cons.addCondition(new TImport());
		cons.addExpression("COMPACT = '" + navyImp.getCompact() + "'");
		if (queryResultSet(cons).getRowCount() > 0) {
			Request req = new Request();
			req.setResponseSystemName("HDDict");
			req.setResponseSubsystemName("DictManage");
			req.setResponseServiceName("ImportDictQueryService");
			Response resp = requestService(req);
			
			req = new Request();
			req.setResponseSystemName("Navy");
			req.setResponseSubsystemName("NavyManage");
			req.setResponseServiceName("SupportorQueryService");
			req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
			Response supResp = requestService(req);
			resp.getDto().getList("RESULT").add(supResp.getDto());
			
			response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(navyImp));
			response.setResult(0);
			response.setErrorInfo("采购合同已存在");
			return response;
		}
		
		cons = new Conditions();
		cons.addCondition(new TImport());
		cons.addExpression("PROJECT = '" + navyImp.getProject() + "'");
		
		if (queryResultSet(cons).getRowCount() > 0) {
			Request req = new Request();
			req.setResponseSystemName("HDDict");
			req.setResponseSubsystemName("DictManage");
			req.setResponseServiceName("ImportDictQueryService");
			Response resp = requestService(req);
			
			req = new Request();
			req.setResponseSystemName("Navy");
			req.setResponseSubsystemName("NavyManage");
			req.setResponseServiceName("SupportorQueryService");
			req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
			Response supResp = requestService(req);
			resp.getDto().getList("RESULT").add(supResp.getDto());
			
			response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(navyImp));
			response.setResult(0);
			response.setErrorInfo("采购项目已存在");
			return response;
		}
		
		if (navyImp.getImportid() == null) {
			navyImp.setImportid(UUID.randomUUID().toString());
		}
		
		//保存数据
		if (navyImp.getCompactmoney() != null && navyImp.getRate() != null) {
			navyImp.setDollar(navyImp.getCompactmoney() * navyImp.getRate());
		}
		
		if (navyImp.getCompactmoney() != null && navyImp.getRmbrate() != null) {
			navyImp.setRmb(navyImp.getCompactmoney() * navyImp.getRmbrate());
		}
		
		if (navyImp.getBudget() != null && navyImp.getCompactmoney() != null) {
			navyImp.setEconomize(navyImp.getBudget() - navyImp.getCompactmoney());
		}
		
		int result = super.save(navyImp);
		
		response.setRequestParam(request.getDto());
		response.getDto().setList("RESULT", getDTO(navyImp));
		response.setResult(result);
		return response;
	}

}
