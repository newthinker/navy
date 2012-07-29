/*    */ package cn.com.hd.priv.usermanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.priv.TUser;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.List;
/*    */ 
/*    */ public class UserQueryByIDService extends BaseService implements IService {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 16 */     Response resp = new Response();
/* 17 */     TUser user = new TUser();
/*    */ 
/* 19 */     super.getData(request.getDto(), user);
/*    */ 
/* 21 */     if (user.getUserid() == null) {
/* 22 */       user.setUserid("-1");
/*    */     }
/*    */ 
/* 25 */     SelectResultSet result = super.queryResultSet(user);
/*    */ 
/* 27 */     List list = super.getDTO(result);
/*    */ 
/* 29 */     resp.getDto().setList("RESULT", list);
/* 30 */     resp.setRequestParam(request.getDto());
/*    */ 
/* 32 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.usermanage.UserQueryByIDService
 * JD-Core Version:    0.6.0
 */