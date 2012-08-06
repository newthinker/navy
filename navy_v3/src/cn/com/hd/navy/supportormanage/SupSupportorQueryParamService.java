package cn.com.hd.navy.supportormanage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorQueryParamService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		List<DTO> dtoList = new ArrayList<DTO>();

		Request req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "11");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "12");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "13");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "14");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());

		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "17");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());

		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "18");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());

		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("AreaQueryService");
		req.getDto().setString("QUERY_PARENTCODEID", "0");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		resp = new Response();
		resp.getDto().setList("RESULT", dtoList);
		resp.setRequestParam(request.getDto());

		Response response = new Response();
		response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
		response.setRequestParam(request.getDto());
		
		return response;
	}

}
