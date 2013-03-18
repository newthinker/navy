package cn.com.hd.navy.importmanage;

import java.util.List;
import java.util.UUID;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.error.Debug;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ImportUpdateService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		//获取数据
		TImport navyImp = new TImport();
		super.getData(request.getDto(), navyImp);
		
		Debug.debugMessage(1, request, navyImp.toString());

		if (navyImp.getImportid() == null) {
			response.setResult(0);
			response.setErrorInfo("采购合同/项目不存在");
			return response;
		}
		
		Conditions cons = new Conditions();
		cons.addCondition(new TImport());
		cons.addExpression("IMPORTID = '" + navyImp.getImportid() + "'");
		SelectResultSet tmpresult = super.queryResultSet(cons);
		if (tmpresult.getRowCount() <= 0) {
			response.setResult(0);
			response.setErrorInfo("采购合同/项目不存在");
			return response;
		}

		TImport tmp = new TImport();
		List list = super.getDTO(tmpresult);
		super.getData((DTO)list.get(0), tmp);

		//保存数据
		if (navyImp.getCompactmoney() != null && tmp.getRate() != null) {
			navyImp.setDollar(navyImp.getCompactmoney() * tmp.getRate());
		}
		
		if (navyImp.getCompactmoney() != null && tmp.getRmbrate() != null) {
			navyImp.setRmb(navyImp.getCompactmoney() * tmp.getRmbrate());
		}
		
		if (navyImp.getBudget() != null && navyImp.getCompactmoney() != null) {
			navyImp.setEconomize(navyImp.getBudget() - navyImp.getCompactmoney());
		}
		
		int result = super.update(navyImp);
		
		response.setRequestParam(request.getDto());
		response.getDto().setList("RESULT", getDTO(navyImp));
		response.setResult(result);
		
		return response;
	}

}
