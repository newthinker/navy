package cn.com.hd.dict.dictmanage;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictArea;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import java.util.List;

public class AreaQueryByIDService extends BaseService implements IService {
	public Response service(Request request) throws Exception {
		TDictArea dictarea = new TDictArea();

		super.getData(request.getDto(), dictarea);
		String areacode = dictarea.getAreacode();

		Conditions cons = new Conditions();
		cons.addCondition(new TDictArea());
		cons.addExpression("AREA_CODE = '" + areacode + "'");
		
		SelectResultSet rs = queryResultSet(cons);
		List retList = getDTO(rs);
		if (retList.size() == 0) {
			response.getDto().setList("RESULT", new DTO());
		} else {
			response.getDto().setList("RESULT", (DTO) retList.get(0));
		}
		
		return response;		
	}
}
