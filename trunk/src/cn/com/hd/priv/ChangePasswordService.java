package cn.com.hd.priv;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.priv.TUser;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.utils.MD5;

public class ChangePasswordService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		TUser user = new TUser();
		super.getQueryData(request.getDto(), user);

		Conditions cons = new Conditions();
		cons.addCondition(new TUser());
		cons.addExpression("user_id = '" + loginInfo.getUserid() + "'");
		
		SelectResultSet selectResult = super.queryResultSet(cons);
		List list = super.getDTO(selectResult);
		
		if (list.size() == 0) {
			resp.setResult(0);
			resp.setErrorInfo("�û������ڣ�");
			return resp;
		} else if (list.size() > 1) {
			resp.setResult(0);
			resp.setErrorInfo("���ֶ��" + user.getLoginname() + "�û������ܵ�¼���������Ա��ϵ��");
			return resp;
		}
		
		TUser loginUser = new TUser();
		getData((DTO) list.get(0), loginUser);
		
		if (!loginUser.getLoginpass().equals(MD5.encrypt(user.getLoginpass()))) {
			resp.setResult(0);
			resp.setErrorInfo("�������");
			return resp;
		}
		
		if (!loginUser.getValidated().equals("Y")) {
			resp.setResult(0);
			resp.setErrorInfo("�û���ʧЧ��");
			return resp;
		}
		
		user = new TUser();
		super.getData(request.getDto(), user);
		user.setUserid(loginInfo.getUserid());
		user.setLoginpass(MD5.encrypt(user.getLoginpass()));
		System.out.println(user);
		int result = update(user);
		
		resp.setResult(result);
		return resp;
	}

}
