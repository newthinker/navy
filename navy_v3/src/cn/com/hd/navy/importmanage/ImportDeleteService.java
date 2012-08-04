package cn.com.hd.navy.importmanage;

import java.io.File;
import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImage;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.transfer.SystemParam;

public class ImportDeleteService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TImport navyImp = new TImport();
		super.getData(request.getDto(), navyImp);
		
		if (navyImp.getImportid() == null) {
			response.setRequestParam(request.getDto());
			response.setResult(0);
			response.getDto().setList("RESULT", getDTO(navyImp));
			response.setErrorInfo("字典代码或字典分类代码为空，删除失败");
			return response;
		}
		
		Conditions cons = new Conditions();
		cons.addCondition(new TImage());
		cons.addExpression("IMPORT_ID = '" + navyImp.getImportid() + "'");
		SelectResultSet rs = queryResultSet(cons);
		List imgList = getDTO(rs);
		for (Object obj : imgList) {
			DTO imgDTO = (DTO) obj;
			TImage img = new TImage();
			getData(imgDTO, img);
			File file = new File(SystemParam.getAbsolutePath() + img.getImagepath());
			if (file.exists()) {
				file.delete();
			}
			
			TImage delImg = new TImage();
			delImg.setImageid(img.getImageid());
			delete(delImg);
		}
		
		int result = super.delete(navyImp);
		
		response.setRequestParam(request.getDto());
		response.getDto().setList("RESULT", getDTO(navyImp));
		response.setResult(result);
		
		return response;
	}

}
