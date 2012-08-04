package cn.com.hd.navy.supportormanage;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorProdQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TSupProduct prod = new TSupProduct();
		getData(request.getDto(), prod);
		
		String supid = prod.getSupid();

		Conditions cons = new Conditions();
		cons.addCondition(new TSupProduct());
		cons.addExpression("SUP_ID = '" + supid + "'");
		
		SelectResultSet rs = queryResultSet(cons);
		List retList = getDTO(rs);
		
		response.getDto().setList("RESULT", retList);
		
		return response;
	}

}
