package cn.com.hd.navy.supportormanage;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		
		TSupportor supportor = new TSupportor();
		super.getQueryData(request.getDto(), supportor);
		
		PageInfo page = super.getPageInfo();
		
		String supname = supportor.getSupname();
		supportor.setSupname(null);
		
		Conditions cons = new Conditions();
		cons.addCondition(supportor);
		
		if (supname != null && !supname.trim().equals("")) {
			cons.addExpression("SUP_NAME like '%" + supname + "%' OR SUP_EN_NAME like '%" + supname + "%'");
		}
		SelectResultSet result = super.queryResultSet(page, cons);
		
		List list = super.getDTO(result);
		
		resp.getDto().setList("RESULT", list);
		resp.setPageInfo(page);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
