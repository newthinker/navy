package cn.com.hd.dict;

import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class NavyDictUpdateService extends BaseService implements IService {

	/**
	 *  1	计划类别		TYPE_NAME		TYPE_CODE
	 *	2	采购机构		UNIT			UNIT_ID
	 *	3	需求单位		DEPT			DEPT_ID
	 *	4	专业类别		CLASS_NAME		CLASS_ID
	 *	5	币种			CURRENCY		CURRENCY_ID
	 *	6	采购方式		MODE_NAME		MODE_ID
	 *	7	委托代理公司	AGREE			AGREE_ID
	 *	8	进口类别		IMPORT_CLASS	IMPORT_CLASS_ID
	 *	9	免税目录		DIRECTORY		DIRECTORY_ID
	 *	10	使用情况		USE_STATE		USE_STATE
	 *	11	供应商类型	TYPE			TYPE_CODE
	 *	13	信用等级		CREDIT			CREDIT_ID
	 *	14	经营性质		ECONOMY			ECONOMY
	 */
	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		
		Request req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictUpdateService");
		req.setDto(request.getDto());
		req.getDto().put("SESSION", session);
		req.getDto().put("LOGININFO", loginInfo);
		resp = requestService(req);
		
		if (resp.getResult() == 0) {
			return resp;
		}
		
		String sql = "";
		TDictDetail dictdetail = new TDictDetail();
		getData(request.getDto(), dictdetail);
		String old_name = dictdetail.getExpinfoa();
		
		if (dictdetail.getTypeid().equals("1")) {
			sql = "UPDATE T_IMPORT IM SET TYPE_NAME = '" + dictdetail.getDictname() + "' WHERE TYPE_CODE = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("2")) {
			sql = "UPDATE T_IMPORT IM SET UNIT = '" + dictdetail.getDictname() + "' WHERE UNIT_ID = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("3")) {
			sql = "UPDATE T_IMPORT IM SET DEPT = '" + dictdetail.getDictname() + "' WHERE DEPT_ID = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("4")) {
			sql = "UPDATE T_IMPORT IM SET CLASS_NAME = '" + dictdetail.getDictname() + "' WHERE CLASS_ID = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("5")) {
			sql = "UPDATE T_IMPORT IM SET CURRENCY = '" + dictdetail.getDictname() + "' WHERE CURRENCY_ID = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("6")) {
			sql = "UPDATE T_IMPORT IM SET MODE_NAME = '" + dictdetail.getDictname() + "' WHERE MODE_ID = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("7")) {
			sql = "UPDATE T_IMPORT IM SET AGREE = '" + dictdetail.getDictname() + "' WHERE AGREE_ID = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("8")) {
			sql = "UPDATE T_IMPORT IM SET IMPORT_CLASS = '" + dictdetail.getDictname() + "' WHERE IMPORT_CLASS_ID = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("9")) {
			sql = "UPDATE T_IMPORT IM SET DIRECTORY = '" + dictdetail.getDictname() + "' WHERE DIRECTORY_ID = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("10")) {
			sql = "UPDATE T_IMPORT IM SET USE_STATE = '" + dictdetail.getDictname() + "' WHERE USE_STATE = '" + old_name + "'";
		} else if (dictdetail.getTypeid().equals("11")) {
			sql = "UPDATE T_SUPPORTOR IM SET TYPE = '" + dictdetail.getDictname() + "' WHERE TYPE_CODE = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("13")) {
			sql = "UPDATE T_SUPPORTOR IM SET CREDIT = '" + dictdetail.getDictname() + "' WHERE CREDIT_ID = '" + dictdetail.getDictcode() + "'";
		} else if (dictdetail.getTypeid().equals("14")) {
			sql = "UPDATE T_SUPPORTOR IM SET ECONOMY = '" + dictdetail.getDictname() + "' WHERE ECONOMY = '" + old_name + "'";
		}
		
		int result = executeSql(sql, new int[] {}, new Object[] {});
		
		resp.setRequestParam(new DTO());
		resp.setResult(result);
		return resp;
	}

}
