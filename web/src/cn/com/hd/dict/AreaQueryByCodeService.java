package cn.com.hd.dict;

import java.util.ArrayList;
import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictArea;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class AreaQueryByCodeService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		TDictArea dictarea = new TDictArea();
		
		super.getData(request.getDto(), dictarea);
		
		List dictList = new ArrayList();
		DTO dictDTO = new DTO();
		Conditions cons = new Conditions();
		cons.addCondition(new TDictArea());
		cons.addExpression("parent_codeid = '" + dictarea.getAreacode() + "' order by area_code asc");
		SelectResultSet result = super.queryResultSet(cons);
		List dictlist = super.getDTO(result);
		dictDTO.setList("RESULT", dictlist);
		dictList.add(dictDTO);
		
		Response resp = new Response();
		resp.getDto().setSelectItems(dictList);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
