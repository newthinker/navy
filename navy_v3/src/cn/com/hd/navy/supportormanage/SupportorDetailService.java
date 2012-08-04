package cn.com.hd.navy.supportormanage;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorDetailService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		
		TSupportor supportor = new TSupportor();
		super.getData(request.getDto(), supportor);
		
		if (supportor.getSupid() == null) {
			resp.setRequestParam(request.getDto());
			return resp;
		}
		
		PageInfo page = super.getPageInfo();
		
		Conditions cons = new Conditions();
		cons.addCondition(new TSupportor());
		cons.addExpression("sup_id = '" + supportor.getSupid() + "'");
		SelectResultSet result = super.queryResultSet(cons);
		
		List list = super.getDTO(result);
		
		cons = new Conditions();
		cons.addCondition(new TImport());
		cons.addExpression("supportor_id = '" + supportor.getSupid() + "'");
		
		result = super.queryResultSet(page, cons);
		List implist = super.getDTO(result);
		
		((DTO)list.get(0)).setList("RESULT", implist);
		
		resp.getDto().setList("RESULT", list);
		resp.setPageInfo(page);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
