/*    */ package cn.com.hd.priv.usermanage;
/*    */ 
/*    */ import cn.com.hd.dto.priv.TUser;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class UserUpdateService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 15 */     Response response = new Response();
/*    */ 
/* 17 */     TUser user = new TUser();
/* 18 */     super.getData(request.getDto(), user);
/*    */ 
/* 20 */     if (user.getUserid() == null) {
/* 21 */       response.setRequestParam(request.getDto());
/* 22 */       response.setResult(Integer.valueOf(0));
/* 23 */       response.getDto().setList("RESULT", getDTO(user));
/* 24 */       response.setErrorInfo("user id 为空，修改失败");
/* 25 */       return response;
/*    */     }
/*    */ 
/* 28 */     user.setOperatorid(this.loginInfo.getUserid());
/* 29 */     user.setOperator(this.loginInfo.getUsername());
/* 30 */     user.setOpdate(new Date());
/* 31 */     int result = super.update(user);
/*    */ 
/* 33 */     response.getDto().put("REQUEST_PARAM", request.getDto());
/* 34 */     response.getDto().setList("RESULT", getDTO(user));
/* 35 */     response.getDto().put("RESULT", Integer.valueOf(result));
/*    */ 
/* 37 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.usermanage.UserUpdateService
 * JD-Core Version:    0.6.0
 */