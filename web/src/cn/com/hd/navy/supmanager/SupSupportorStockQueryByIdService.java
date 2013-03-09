package cn.com.hd.navy.supmanager;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TStockholder;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorStockQueryByIdService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TStockholder stock = new TStockholder();
		getData(request.getDto(), stock);
		String stockid = stock.getStockholderid();
		
		Conditions cons = new Conditions();
		cons.addCondition(new TStockholder());
		cons.addExpression("STOCKHOLDER_ID = '" + stockid + "'");
		
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
