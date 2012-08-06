package cn.com.hd.dict.dictmanage;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import java.util.List;

public class AreaQueryByIDService extends BaseService implements IService {
	public Response service(Request request) throws Exception {
		TDictDetail dictdetail = new TDictDetail();

		super.getData(request.getDto(), dictdetail);
		if (dictdetail.getDictcode() == null) {
			dictdetail.setDictcode("-1");
		}

		if (dictdetail.getTypeid() == null) {
			dictdetail.setTypeid("-1");
		}

		SelectResultSet result = super.queryResultSet(dictdetail);

		List list = super.getDTO(result);

		Response resp = new Response();
		resp.getDto().setList("RESULT", list);
		resp.setRequestParam(request.getDto());

		return resp;
	}
}
