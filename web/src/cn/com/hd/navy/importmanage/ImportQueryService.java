package cn.com.hd.navy.importmanage;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ImportQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Request res = new Request();
		res.setResponseSystemName("HDDict");
		res.setResponseSubsystemName("DictManage");
		res.setResponseServiceName("ImportDictQueryService");
		Response response = requestService(res);
		
		Response resp = new Response();
		
		TImport navyImp = new TImport();
		
		super.getQueryData(request.getDto(), navyImp);
		
		PageInfo page = super.getPageInfo();
		
		String exp = null;
		if (navyImp.getTypecode() != null) {
			if (navyImp.getTypecode().equals("140000000")) {
				navyImp.setTypecode(null);
				exp = "TYPE_CODE IN ('110000000', '120000000')";
			} else if (navyImp.getTypecode().equals("150000000")) {
				navyImp.setTypecode(null);
				exp = "TYPE_CODE IN ('120000000', '130000000')";
			}
		}
		
		String order = (String) request.getDto().get("ORDER");
		String order_asc = (String) request.getDto().get("ORDER_ASC");
		
		Conditions cons = new Conditions();
		if (order != null && !order.equals("") && order_asc != null && !order_asc.equals("")) {
			boolean asc = true;
			if (order_asc != null && !order_asc.equals("")) {
				asc = Boolean.valueOf(order_asc);
			}
			
			cons.addCondition(navyImp, order, asc);
		} else {
			cons.addCondition(navyImp);
		}
		
		if (exp != null) {
			cons.addExpression(exp);
		}
		
		SelectResultSet result = super.queryResultSet(page, cons);
		List list = super.getDTO(result);
		
		SelectResultSet statResult = super.queryStatResultSet(cons, "COUNT(1), SUM(RMB)", null);
		Integer count = statResult.getIntValue(0, 0);
		Double sum = statResult.getDoubleValue(1, 0);
		if (sum < 0) {
			sum = Double.valueOf(0);
		}
		
		resp.getDto().setInt("COUNT", count);
		resp.getDto().setDouble("SUM", sum);
		resp.getDto().setString("ORDER", order);
		resp.getDto().setString("ORDER_ASC", order_asc);
		resp.getDto().setSelectItems(response.getDto().getList("RESULT"));
		resp.getDto().setList("RESULT", list);
		resp.setPageInfo(page);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
