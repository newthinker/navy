package cn.com.hd.navy.supportormanage;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TAftersaleOrg;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorSaleOrgQueryByIdService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TAftersaleOrg org = new TAftersaleOrg();
		getData(request.getDto(), org);
		String orgid = org.getOrgid();
		
		Conditions cons = new Conditions();
		cons.addCondition(new TAftersaleOrg());
		cons.addExpression("ORG_ID = '" + orgid + "'");
		
		SelectResultSet rs = queryResultSet(cons);
		List retList = getDTO(rs);
		if (retList.size() == 0) {
			response.getDto().setList("RESULT", new DTO());
		} else {
			response.getDto().setList("RESULT", (DTO) retList.get(0));
		}
		
		return response;
	}

}
