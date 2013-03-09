package cn.com.hd.dict;

import java.util.ArrayList;
import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class DictQueryByIDService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		TDictDetail dictdetail = new TDictDetail();
		
		super.getData(request.getDto(), dictdetail);
		if (dictdetail.getDictcode() == null) {
			dictdetail.setDictcode("-1");
		}
		
		if (dictdetail.getTypeid() == null) {
			dictdetail.setTypeid("-1");
		}

		if (dictdetail.getFathercode() == null) {
			dictdetail.setFathercode("-1");
		}
		
		Conditions cons = new Conditions();
		cons.addCondition(new TDictDetail());
		cons.addExpression("dict_code = '" + dictdetail.getDictcode()
				+ "' and father_code = '" + dictdetail.getFathercode()
				+ "' and type_id = '" + dictdetail.getTypeid() + "'");
		SelectResultSet result = super.queryResultSet(cons);
		
		List list = super.getDTO(result);
		
		List dictList = new ArrayList();
		DTO dictDTO = new DTO();
		cons = new Conditions();
		cons.addCondition(new TDictDetail());
		cons.addExpression("type_id = '3'");
		result = super.queryResultSet(cons);
		List dictlist = super.getDTO(result);
		dictDTO.setList("RESULT", dictlist);
		dictList.add(dictDTO);
		
		dictDTO = new DTO();
		cons = new Conditions();
		cons.addCondition(new TDictDetail());
		cons.addExpression("type_id = '8'");
		result = super.queryResultSet(cons);
		dictlist = super.getDTO(result);
		dictDTO.setList("RESULT", dictlist);
		dictList.add(dictDTO);
		
		Response resp = new Response();
		resp.getDto().setSelectItems(dictList);
		resp.getDto().setList("RESULT", list);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
