package cn.com.hd.navy.supmanager;

import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorProdDeleteService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TSupProduct prod = new TSupProduct();
		getData(request.getDto(), prod);

		delete(prod);
		
		response.getDto().setList("RESULT", getDTO(prod));
		response.setResult(1);
		
		return response;
	}

}
