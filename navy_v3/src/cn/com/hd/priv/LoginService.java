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
import cn.com.hd.transfer.SystemParam;
import cn.com.hd.utils.MD5;

public class LoginService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		TUser user = new TUser();
		super.getData(request.getDto(), user);

		if (user.getLoginname() == null) {
			resp.setErrorInfo("用户名不能为空！");
			return resp;
		}
		
		Conditions cons = new Conditions();
		cons.addCondition(new TUser());
		cons.addExpression("login_name = '" + user.getLoginname() + "'");
		
		SelectResultSet result = super.queryResultSet(cons);
		List list = super.getDTO(result);
		
		if (list.size() == 0) {
			resp.setErrorInfo("用户不存在！");
			return resp;
		} else if (list.size() > 1) {
			resp.setErrorInfo("发现多个" + user.getLoginname() + "用户，不能登录，请与管理员联系！");
			return resp;
		}
		
		TUser loginUser = new TUser();
		getData((DTO) list.get(0), loginUser);
		
		if (!loginUser.getLoginpass().equals(MD5.encrypt(user.getLoginpass()))) {
			resp.setErrorInfo("密码错误！");
			return resp;
		}
		
		if (!loginUser.getValidated().equals("Y")) {
			resp.setErrorInfo("用户已失效！");
			return resp;
		}
		
		String sKeyUserid = SystemParam.getParam("SessionUserid");
		if (sKeyUserid == null) {
			sKeyUserid = "USER_ID";
		}
		
		String sKeyUsername = SystemParam.getParam("SessionUserid");
		if (sKeyUsername == null) {
			sKeyUsername = "USER_NAME";
		}
		
		String sKeyDeptid = SystemParam.getParam("SessionUserid");
		if (sKeyDeptid == null) {
			sKeyDeptid = "DEPT_ID";
		}
		
		String sKeyDeptname = SystemParam.getParam("SessionUserid");
		if (sKeyDeptname == null) {
			sKeyDeptname = "DEPT_NAME";
		}
		
		resp.getDto().setString(sKeyUserid, loginUser.getUserid());
		resp.getDto().setString(sKeyUsername, loginUser.getUsername());
		resp.getDto().setString(sKeyDeptid, "");
		resp.getDto().setString(sKeyDeptname, "");
		
		resp.setResult(1);
		return resp;
	}

}
