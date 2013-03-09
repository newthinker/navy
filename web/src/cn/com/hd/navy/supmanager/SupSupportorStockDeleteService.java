package cn.com.hd.navy.supmanager;

import cn.com.hd.dto.navy.TStockholder;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorStockDeleteService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TStockholder stock = new TStockholder();
		getData(request.getDto(), stock);

		delete(stock);
		
		response.getDto().setList("RESULT", getDTO(stock));
		response.setResult(1);
		
		return response;
	}

}
