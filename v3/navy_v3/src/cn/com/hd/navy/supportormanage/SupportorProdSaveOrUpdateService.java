package cn.com.hd.navy.supportormanage;

import java.util.UUID;

import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorProdSaveOrUpdateService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TSupProduct prod = new TSupProduct();
		getData(request.getDto(), prod);

		if (prod.getProdid() == null || prod.getProdid().equals("")) {
			prod.setProdid(UUID.randomUUID().toString());
			save(prod);
		} else {
			update(prod);
		}
		
		response.getDto().setList("RESULT", getDTO(prod));
		response.setResult(1);
		
		return response;
	}

}
