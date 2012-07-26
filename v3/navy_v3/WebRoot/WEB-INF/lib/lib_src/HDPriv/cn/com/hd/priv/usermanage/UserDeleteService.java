/*    */ package cn.com.hd.priv.usermanage;
/*    */ 
/*    */ import cn.com.hd.dto.priv.TUser;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ 
/*    */ public class UserDeleteService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 12 */     Response response = new Response();
/*    */ 
/* 14 */     TUser user = new TUser();
/* 15 */     super.getData(request.getDto(), user);
/*    */ 
/* 17 */     if (user.getUserid() == null) {
/* 18 */       response.setRequestParam(request.getDto());
/* 19 */       response.setResult(Integer.valueOf(0));
/* 20 */       response.getDto().setList("RESULT", getDTO(user));
/* 21 */       response.setErrorInfo("User ID 为空，删除失败");
/* 22 */       return response;
/*    */     }
/*    */ 
/* 25 */     int result = super.delete(user);
/*    */ 
/* 27 */     response.setRequestParam(request.getDto());
/* 28 */     response.setResult(Integer.valueOf(result));
/*    */ 
/* 30 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.usermanage.UserDeleteService
 * JD-Core Version:    0.6.0
 */