package cn.com.hd.navy.importmanage;

import java.io.File;
import java.util.UUID;

import com.jspsmart.upload.Files;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImage;
import cn.com.hd.error.Debug;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.transfer.SystemParam;

public class ImportUploadService extends BaseService implements IService {

	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		//获取数据
		TImage img = new TImage();
		super.getData(request.getDto(), img);
		
		Debug.debugMessage(1, request, img.toString());
		
		int result = 0;
		
		Conditions cons = new Conditions();
		cons.addCondition(new TImage());
		String exp = "import_id = '" + img.getImportid() + "' and image_type_id = '" 
				+ img.getImagetypeid() + "' and image_type = '" + img.getImagetype() + "'";
		cons.addExpression(exp);
		
		SelectResultSet rs = queryResultSet(cons);
		int cnt = rs.getRowCount();
		
		Files files = request.getUpload().getFiles();
		
		for (int i = 0; i < files.getCount(); i ++) {
			if (files.getFile(i).getFileName() == null || files.getFile(i).getFileName().equals("")) {
				continue;
			}
			
			String path = "navy/import/" + img.getImportid() + "/" + img.getImagetype().toLowerCase() + "/" + files.getFile(i).getFileName();
			String target = SystemParam.getParam("AbsolutePath") + path;
			new File(target).getParentFile().mkdirs();
			files.getFile(i).saveAs(target);
			TImage image = new TImage();
			image.setImageid(UUID.randomUUID().toString());
			image.setImportid(img.getImportid());
			image.setImagename(files.getFile(i).getFileName());
			image.setImageorder(cnt + i + 1);
			image.setImagepath(path);
			image.setImagetype(img.getImagetype());
			image.setImagetypeid(img.getImagetypeid());
			
			result = save(image);
		}
		
		response.setRequestParam(request.getDto());
		response.setResult(result > 0 ? 1 : 0);
		
		return response;
	}

}
