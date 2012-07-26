/*    */ package cn.com.hd.priv.usermanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.priv.TUser;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.PageInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.List;
/*    */ 
/*    */ public class UserQueryService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 17 */     TUser user = new TUser();
/*    */ 
/* 19 */     super.getQueryData(request.getDto(), user);
/*    */ 
/* 21 */     PageInfo page = super.getPageInfo();
/*    */ 
/* 23 */     SelectResultSet result = super.queryResultSet(page, user);
/*    */ 
/* 25 */     List list = super.getDTO(result);
/*    */ 
/* 27 */     Response resp = new Response();
/* 28 */     resp.getDto().setList("RESULT", list);
/* 29 */     resp.setPageInfo(page);
/* 30 */     resp.setRequestParam(request.getDto());
/*    */ 
/* 32 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.usermanage.UserQueryService
 * JD-Core Version:    0.6.0
 */