package cn.com.hd.dict;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class DictUpdateService extends BaseService implements IService {
	
	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		TDictDetail dictdetail = new TDictDetail();
		super.getData(request.getDto(), dictdetail);

		if (dictdetail.getDictcode() == null || dictdetail.getTypeid() == null) {
			return error("字典代码或字典分类代码为空，修改失败", getDTO(dictdetail));
		}
		
		Conditions cons = new Conditions();
		cons.addCondition(new TDictDetail());
		cons.addExpression("TYPE_ID = '" + dictdetail.getTypeid() + "' AND DICT_NAME = '" + dictdetail.getDictname() + "' AND DICT_CODE != '" + dictdetail.getDictcode() + "'");
		SelectResultSet rs = queryResultSet(cons);
		if (rs.getRowCount() > 0) {
			return error("名称已存在，请重新填写", getDTO(dictdetail));
		}
		
		dictdetail.setOperatorid(loginInfo.getUserid());
		dictdetail.setOperatorname(loginInfo.getUsername());
		dictdetail.setOperatdate(new Date());
		int result = super.update(dictdetail);

		response.getDto().put("REQUEST_PARAM", request.getDto());
		response.getDto().setList("RESULT", getDTO(dictdetail));
		response.getDto().put("RESULT", result);
		
		return response;
	}
	
	@SuppressWarnings("unchecked")
	public Response error(String message, DTO dto) throws Exception {
		Response response = new Response();
		List dictList = new ArrayList();
		DTO dictDTO = new DTO();
		Conditions cons = new Conditions();
		cons.addCondition(new TDictDetail());
		cons.addExpression("type_id = '3'");
		SelectResultSet rs = queryResultSet(cons);
		List dictlist = super.getDTO(rs);
		dictDTO.setList("RESULT", dictlist);
		dictList.add(dictDTO);
		
		dictDTO = new DTO();
		cons = new Conditions();
		cons.addCondition(new TDictDetail());
		cons.addExpression("type_id = '8'");
		rs = queryResultSet(cons);
		dictlist = super.getDTO(rs);
		dictDTO.setList("RESULT", dictlist);
		dictList.add(dictDTO);
		
		response.getDto().setSelectItems(dictList);
		response.setRequestParam(request.getDto());
		response.setResult(0);
		response.getDto().setList("RESULT", dto);
		response.setErrorInfo(message);
		return response;
	}
}
