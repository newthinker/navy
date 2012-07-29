/*    */ package cn.com.hd.log.logmanage;
/*    */ 
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class LogClearService extends BaseService implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 15 */     int result = super.executeSql("DELETE FROM T_LOG", null, null);
/*    */ 
/* 17 */     HashMap dbOperatorMap = new HashMap();
/* 18 */     dbOperatorMap.put("LogManage", this.dbOperator);
/*    */ 
/* 20 */     Request req = new Request();
/* 21 */     req.setDto(new DTO());
/* 22 */     req.setResponseSystemName("HDLog");
/* 23 */     req.setResponseSubsystemName("LogManage");
/* 24 */     req.setResponseServiceName("LogQueryService");
/* 25 */     req.setDispatcherUrl("/logManage/logQuery.jsp");
/*    */ 
/* 27 */     if (request.getDto().getString("operatorname".toUpperCase()) != null) {
/* 28 */       req.getDto().setString("operatorname".toUpperCase(), request.getDto().getString("operatorname".toUpperCase()));
/*    */     }
/*    */ 
/* 31 */     if (request.getDto().getString("operatordept".toUpperCase()) != null) {
/* 32 */       req.getDto().setString("operatordept".toUpperCase(), request.getDto().getString("operatordept".toUpperCase()));
/*    */     }
/*    */ 
/* 35 */     if (request.getDto().getInt("ROWNUMBER") != null) {
/* 36 */       req.getDto().put("INT_ROWNUMBER", request.getDto().getInt("ROWNUMBER").toString());
/*    */     }
/*    */ 
/* 39 */     req.getDto().put("INT_PAGE", "1");
/*    */ 
/* 41 */     Response response = requestService(req);
/* 42 */     response.getDto().setInt("RESULT", Integer.valueOf(result));
/*    */ 
/* 44 */     if (result > 0)
/* 45 */       response.setErrorInfo("删除成功");
/*    */     else {
/* 47 */       response.setErrorInfo("删除失败");
/*    */     }
/*    */ 
/* 50 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDLog.jar
 * Qualified Name:     cn.com.hd.log.logmanage.LogClearService
 * JD-Core Version:    0.6.0
 */