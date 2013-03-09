package cn.com.hd.navy.supmanager;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TStockholder;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorStockQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TStockholder stock = new TStockholder();
		getData(request.getDto(), stock);
		
		String supid = stock.getSupid();

		Conditions cons = new Conditions();
		cons.addCondition(new TStockholder());
		cons.addExpression("SUP_ID = '" + supid + "'");
		
		SelectResultSet rs = queryResultSet(cons);
		List retList = getDTO(rs);
		
		response.getDto().setList("RESULT", retList);
		
		return response;
	}

}
