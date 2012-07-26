/*    */ package cn.com.hd.priv.usermanage;
/*    */ 
/*    */ import cn.com.hd.dto.priv.TUser;
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.Date;
/*    */ import java.util.UUID;
/*    */ 
/*    */ public class UserAddService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 16 */     Response response = new Response();
/*    */ 
/* 19 */     TUser user = new TUser();
/* 20 */     super.getData(request.getDto(), user);
/*    */ 
/* 22 */     Debug.debugMessage(1, request, user.toString());
/*    */ 
/* 25 */     user.setUserid(UUID.randomUUID().toString());
/* 26 */     user.setCreatorid(this.loginInfo.getUserid());
/* 27 */     user.setCreator(this.loginInfo.getUsername());
/* 28 */     user.setCreatordate(new Date());
/* 29 */     user.setValidated("Y");
/*    */ 
/* 31 */     int result = super.save(user);
/*    */ 
/* 33 */     response.setRequestParam(request.getDto());
/* 34 */     response.getDto().setList("RESULT", getDTO(user));
/* 35 */     response.setResult(Integer.valueOf(result));
/*    */ 
/* 37 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.usermanage.UserAddService
 * JD-Core Version:    0.6.0
 */