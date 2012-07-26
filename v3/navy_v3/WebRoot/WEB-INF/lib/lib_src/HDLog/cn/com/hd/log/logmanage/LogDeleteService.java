/*    */ package cn.com.hd.log.logmanage;
/*    */ 
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ 
/*    */ public class LogDeleteService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 12 */     String ids = request.getDto().getString("STR_IDS");
/* 13 */     int result = super.executeSql("DELETE FROM T_LOG WHERE LOGID IN (" + ids + ")", null, null);
/*    */ 
/* 15 */     Request req = new Request();
/* 16 */     req.setDto(new DTO());
/* 17 */     req.setResponseSystemName("HDLog");
/* 18 */     req.setResponseSubsystemName("LogManage");
/* 19 */     req.setResponseServiceName("LogQueryService");
/* 20 */     req.setDispatcherUrl("/logManage/logQuery.jsp");
/*    */ 
/* 22 */     if (request.getDto().getString("operatorname".toUpperCase()) != null) {
/* 23 */       req.getDto().setString("operatorname".toUpperCase(), request.getDto().getString("operatorname".toUpperCase()));
/*    */     }
/*    */ 
/* 26 */     if (request.getDto().getString("operatordept".toUpperCase()) != null) {
/* 27 */       req.getDto().setString("operatordept".toUpperCase(), request.getDto().getString("operatordept".toUpperCase()));
/*    */     }
/*    */ 
/* 30 */     if (request.getDto().getInt("ROWNUMBER") != null) {
/* 31 */       req.getDto().put("INT_ROWNUMBER", request.getDto().getInt("ROWNUMBER").toString());
/*    */     }
/*    */ 
/* 34 */     req.getDto().put("INT_PAGE", "1");
/*    */ 
/* 36 */     Response response = requestService(req);
/* 37 */     response.getDto().setInt("RESULT", Integer.valueOf(result));
/*    */ 
/* 39 */     if (result > 0)
/* 40 */       response.setErrorInfo("删除成功");
/*    */     else {
/* 42 */       response.setErrorInfo("删除失败");
/*    */     }
/*    */ 
/* 45 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDLog.jar
 * Qualified Name:     cn.com.hd.log.logmanage.LogDeleteService
 * JD-Core Version:    0.6.0
 */