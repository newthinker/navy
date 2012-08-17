package cn.com.hd.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictArea;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.dto.dict.TProductType;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ProductTypeQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		TDictDetail dictdetail = new TDictDetail();
		super.getData(request.getDto(), dictdetail);
		dictdetail.setTypeid("15");
		if (dictdetail.getFathercode() == null) {
			dictdetail.setFathercode("-1");
		}
		
		Conditions cons = new Conditions();
		cons.addCondition(new TDictDetail());
		cons.addExpression("type_id = '" + dictdetail.getTypeid()
				+ "' and father_code = '" + dictdetail.getFathercode() + "'");
		SelectResultSet result = super.queryResultSet(cons);
		List listtmp = super.getDTO(result);

		List dictlist = new ArrayList();
		for (Object item : listtmp) {
			DTO itemdto = (DTO)item;
			TProductType tp1 = new TProductType();
			tp1.setDictname(itemdto.getString("DICTNAME"));
			tp1.setDictcode(itemdto.getString("DICTCODE"));
			dictlist.add(super.getDTO(tp1));
		}

		DTO dictDTO = new DTO();
		dictDTO.setList("RESULT", dictlist);
		
		List dictList = new ArrayList();
		dictList.add(dictDTO);
		
		Response resp = new Response();
		resp.getDto().setSelectItems(dictList);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
