package cn.com.hd.navy.supportormanage;

import java.util.List;
import java.util.UUID;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorQueryByIDService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Request res = new Request();
		res.setResponseSystemName("HDDict");
		res.setResponseSubsystemName("DictManage");
		res.setResponseServiceName("SupportorDictQueryService");
		Response response = requestService(res);
		
		Response resp = new Response();
		
		TSupportor supportor = new TSupportor();
		super.getData(request.getDto(), supportor);
		
		if (supportor.getSupid() == null) {
			supportor.setSupid("-1");
		}
		
		SelectResultSet result = super.queryResultSet(supportor);
		
		List list = super.getDTO(result);
		
		if (list.size() == 0) {
			supportor = new TSupportor();
			supportor.setSupid(UUID.randomUUID().toString());
			list.add(getDTO(supportor));
		}
		
		resp.getDto().setSelectItems(response.getDto().getList("RESULT"));
		resp.getDto().setList("RESULT", list);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
