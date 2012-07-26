package cn.com.hd.navy.importmanage;

import cn.com.hd.dto.navy.TImage;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ImportImageDeleteService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TImage image = new TImage();
		super.getData(request.getDto(), image);
		
		if (image.getImageid() == null) {
			response.setRequestParam(request.getDto());
			response.setResult(0);
			response.getDto().setList("RESULT", getDTO(image));
			response.setErrorInfo("×Öµä´úÂë»ò×Öµä·ÖÀà´úÂëÎª¿Õ£¬É¾³ıÊ§°Ü");
			return response;
		}
		
		int result = super.delete(image);
		
		response.setRequestParam(request.getDto());
		response.getDto().setList("RESULT", getDTO(image));
		response.setResult(result > 0 ? 2 : 0);
		
		return response;
	}

}
