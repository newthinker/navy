package cn.com.hd.navy.supportormanage;

import java.util.UUID;

import cn.com.hd.dto.navy.TStockholder;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorStockSaveOrUpdateService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TStockholder stock = new TStockholder();
		getData(request.getDto(), stock);

		if (stock.getStockholderid() == null || stock.getStockholderid().equals("")) {
			stock.setStockholderid(UUID.randomUUID().toString());
			save(stock);
		} else {
			update(stock);
		}
		
		response.getDto().setList("RESULT", getDTO(stock));
		response.setResult(1);
		
		return response;
	}

}
