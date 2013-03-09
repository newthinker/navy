package cn.com.hd.navy.importmanage;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImage;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ImportImageQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		
		TImage image = new TImage();
		super.getData(request.getDto(), image);

		Conditions cons = new Conditions();
		cons.addCondition(new TImage(), "image_order", true);
		String exp = "import_id = '" + image.getImportid() + "' and image_type_id = '" 
				+ image.getImagetypeid() + "' and image_type = '" + image.getImagetype() + "'";
		cons.addExpression(exp);
		
		PageInfo page = getPageInfo();
		
		SelectResultSet result = super.queryResultSet(page, cons);
		
		List list = super.getDTO(result);
		
		resp.setPageInfo(page);
		resp.getDto().setList("RESULT", list);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
