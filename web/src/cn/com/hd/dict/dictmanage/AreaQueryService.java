package cn.com.hd.dict.dictmanage;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictArea;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import java.util.List;

public class AreaQueryService extends BaseService implements IService {
	public Response service(Request request) throws Exception {
		TDictArea dictarea = new TDictArea();

		super.getQueryData(request.getDto(), dictarea);

		PageInfo page = super.getPageInfo();

		Conditions cons = new Conditions();
		cons.addCondition(dictarea, "area_code", true);
		SelectResultSet result = super.queryResultSet(page, cons);

		List list = super.getDTO(result);

		Response resp = new Response();
		resp.getDto().setList("RESULT", list);
		resp.setPageInfo(page);
		resp.setRequestParam(request.getDto());

		return resp;
	}
}
