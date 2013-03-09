package cn.com.hd.dict;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.error.Debug;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class DictAddService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		//获取数据
		TDictDetail dictdetail = new TDictDetail();
		super.getData(request.getDto(), dictdetail);
			
		Debug.debugMessage(1, request, dictdetail.toString());
		
		if (dictdetail.getTypeid() == null) {
			return error("字典代码或字典分类代码为空，保存失败", getDTO(dictdetail));
		}
		
		Conditions cons = new Conditions();
		cons.addCondition(new TDictDetail());
		cons.addExpression("TYPE_ID = '" + dictdetail.getTypeid() + "' AND DICT_NAME = '" + dictdetail.getDictname() + "'");
		SelectResultSet rs = queryResultSet(cons);
		if (rs.getRowCount() > 0) {
			return error("名称已存在，请重新填写", getDTO(dictdetail));
		}
		
		//保存数据
		dictdetail.setDictcode(UUID.randomUUID().toString());
		dictdetail.setCreatorid(loginInfo.getUserid());
		dictdetail.setCreatorname(loginInfo.getUsername());
		dictdetail.setCreatedate(new Date());
		
		dictdetail.setOperatorid(loginInfo.getUserid());
		dictdetail.setOperatorname(loginInfo.getUsername());
		dictdetail.setOperatdate(new Date());
				
		int result = super.save(dictdetail);
		
		response.setRequestParam(request.getDto());
		response.getDto().setList("RESULT", getDTO(dictdetail));
		response.setResult(result);
		
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
