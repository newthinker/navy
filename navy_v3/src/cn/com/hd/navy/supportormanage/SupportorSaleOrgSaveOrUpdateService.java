package cn.com.hd.navy.supportormanage;

import java.util.UUID;

import cn.com.hd.dto.navy.TAftersaleOrg;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorSaleOrgSaveOrUpdateService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TAftersaleOrg org = new TAftersaleOrg();
		getData(request.getDto(), org);

		if (org.getOrgid() == null || org.getOrgid().equals("")) {
			org.setOrgid(UUID.randomUUID().toString());
			save(org);
		} else {
			update(org);
		}
		
		response.getDto().setList("RESULT", getDTO(org));
		response.setResult(1);
		
		return response;
	}

}
