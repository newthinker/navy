package cn.com.hd.navy.supmanager;

import cn.com.hd.dto.navy.TAftersaleOrg;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorSaleOrgDeleteService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TAftersaleOrg org = new TAftersaleOrg();
		getData(request.getDto(), org);

		delete(org);
		
		response.getDto().setList("RESULT", getDTO(org));
		response.setResult(1);
		
		return response;
	}

}
