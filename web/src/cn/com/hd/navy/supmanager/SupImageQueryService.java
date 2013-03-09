package cn.com.hd.navy.supmanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImage;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.transfer.SystemParam;
import cn.com.hd.utils.StringUtils;

public class SupImageQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		
		TImage image = new TImage();
		super.getData(request.getDto(), image);

		Conditions cons = new Conditions();
		cons.addCondition(new TImage(), "image_order", true);
		String exp = "image_id = '" + image.getImageid() + "'";
		cons.addExpression(exp);
		
		PageInfo page = getPageInfo();
		
		SelectResultSet result = super.queryResultSet(page, cons);
		
		List list = super.getDTO(result);
		
		for (int i=0; i<list.size(); ++i) {
//			TImage img = new TImage();
//			super.getData((DTO)list.get(i), img);
//			if (img.getImagename() == null || 
//					img.getImagename().equals("")) {
//				continue;
//			}
//			if (img.getImagepath() == null || 
//					img.getImagepath().equals("")) {
//				img.setImagepath("ImgDir/" + img.getImagename());
//			}
			DTO dto = (DTO)list.get(i);
			if (dto.getString("IMAGENAME") == null || 
					dto.getString("IMAGENAME").equals("")) {
				continue;
			}
			if (dto.getString("IMAGEPATH") == null || 
					dto.getString("IMAGEPATH").equals("")) {
				dto.setString("IMAGEPATH", "ImgDir/" + dto.getString("IMAGENAME"));
			}

			String base = SystemParam.getParam("AbsolutePath");
			String file = dto.getString("IMAGEPATH");
			if (file.endsWith("zip") || file.endsWith("rar")) {
				resp.getDto().put("DOWNLOAD", StringUtils.encrypt(base+"/"+file));
				resp.getDto().put("DOWNLOAD_FILENAME", StringUtils.encrypt(dto.getString("IMAGENAME")));
			}
		}
		
		resp.setPageInfo(page);
		resp.getDto().setList("RESULT", list);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
