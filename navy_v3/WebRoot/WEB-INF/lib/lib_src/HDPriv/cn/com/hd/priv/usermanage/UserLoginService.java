/*    */ package cn.com.hd.priv.usermanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.priv.TUser;
/*    */ import cn.com.hd.security.Security;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Conditions;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class UserLoginService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 20 */     Response resp = new Response();
/* 21 */     TUser user = new TUser();
/* 22 */     super.getData(request.getDto(), user);
/*    */ 
/* 24 */     if (user.getLoginname() == null) {
/* 25 */       resp.setErrorInfo("用户名不能为空！");
/* 26 */       return resp;
/*    */     }
/*    */ 
/* 29 */     Conditions cons = new Conditions();
/* 30 */     cons.addCondition(new TUser());
/* 31 */     cons.addExpression("login_name = '" + user.getLoginname() + "'");
/*    */ 
/* 33 */     SelectResultSet result = super.queryResultSet(cons);
/* 34 */     List list = super.getDTO(result);
/*    */ 
/* 36 */     if (list.size() == 0) {
/* 37 */       resp.setErrorInfo("用户不存在！");
/* 38 */       return resp;
/* 39 */     }if (list.size() > 1) {
/* 40 */       resp.setErrorInfo("发现多个" + user.getLoginname() + "用户，不能登录，请与管理员联系！");
/* 41 */       return resp;
/*    */     }
/*    */ 
/* 44 */     TUser loginUser = new TUser();
/* 45 */     getData((DTO)list.get(0), loginUser);
/*    */ 
/* 47 */     String pass = user.getLoginpass();
/*    */     try {
/* 49 */       pass = Security.encrypt(user.getLoginpass());
/*    */     } catch (Exception ex) {
/* 51 */       resp.setErrorInfo("密码加密错误！");
/* 52 */       return resp;
/*    */     }
/*    */ 
/* 55 */     if (!loginUser.getLoginpass().equals(pass)) {
/* 56 */       resp.setErrorInfo("密码错误！");
/* 57 */       return resp;
/*    */     }
/*    */ 
/* 60 */     if (!loginUser.getValidated().equals("Y")) {
/* 61 */       resp.setErrorInfo("用户已失效！");
/* 62 */       return resp;
/*    */     }
/*    */ 
/* 65 */     String sKeyUserid = SystemParam.getParam("SessionUserid");
/* 66 */     if (sKeyUserid == null) {
/* 67 */       sKeyUserid = "USER_ID";
/*    */     }
/*    */ 
/* 70 */     String sKeyUsername = SystemParam.getParam("SessionUsername");
/* 71 */     if (sKeyUsername == null) {
/* 72 */       sKeyUsername = "USER_NAME";
/*    */     }
/*    */ 
/* 75 */     this.loginInfo.setUserid(loginUser.getUserid());
/* 76 */     this.loginInfo.setUsername(loginUser.getUsername());
/*    */ 
/* 78 */     this.session.setAttribute(sKeyUserid, loginUser.getUserid());
/* 79 */     this.session.setAttribute(sKeyUsername, loginUser.getUsername());
/*    */ 
/* 81 */     Request req = new Request();
/* 82 */     req.setResponseSystemName("HDPriv");
/* 83 */     req.setResponseSubsystemName("PrivManage");
/* 84 */     req.setResponseServiceName("LoginSuccessService");
/* 85 */     req.setDto(getDTO(loginUser));
/* 86 */     resp = requestService(req);
/*    */ 
/* 88 */     resp.setResult(Integer.valueOf(1));
/* 89 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.usermanage.UserLoginService
 * JD-Core Version:    0.6.0
 */