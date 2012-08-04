package cn.com.hd.dict;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ImportDictQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		List<DTO> dtoList = new ArrayList<DTO>();

		Request req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "1");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "2");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "3");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());

		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "4");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "5");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "6");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "7");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "8");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "9");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "10");
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		dtoList.add(resp.getDto());
		
		List list = new ArrayList();
		int iYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = iYear - 10; i < iYear + 10; i ++) {
			DTO dto = new DTO();
			dto.setString("IMPORTYEAR", String.valueOf(i));
			list.add(dto);
		}
		
		DTO dto = new DTO();
		dto.setList("RESULT", list);
		dtoList.add(dto);
		
		resp = new Response();
		resp.getDto().setList("RESULT", dtoList);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
