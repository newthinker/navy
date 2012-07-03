package cn.com.hd.navy.supportormanage;

import cn.com.hd.dto.navy.TImport;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorDeleteService extends BaseService implements IService {

	public Response service(Request request) throws Exception {
		Response response = new Response();
		TSupportor supportor = new TSupportor();
		
		super.getData(request.getDto(), supportor);
		
		if (supportor.getSupid() == null) {
			response = new Response();
			response.setRequestParam(request.getDto());
			response.setResult(0);
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("字典代码或字典分类代码为空，删除失败");
			return response;
		}
		
		Conditions cons = new Conditions();
		cons.addCondition(new TImport());
		cons.addExpression("SUPPORTOR_ID = '" + supportor.getSupid() + "'");
		if (queryResultSet(cons).getRowCount() > 0) {
			response = new Response();
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setResult(0);
			response.setErrorInfo("已有采购项目选择该供应商，不能删除");
			
			return response;
		}
		
		int result = super.delete(supportor);
		
		response.setRequestParam(request.getDto());
		response.getDto().setList("RESULT", getDTO(supportor));
		response.setResult(result);
		
		return response;
	}

}
