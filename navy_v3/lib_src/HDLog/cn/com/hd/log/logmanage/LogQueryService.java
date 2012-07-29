/*    */ package cn.com.hd.log.logmanage;
/*    */ 
/*    */ import cn.com.hd.dto.log.TLog;
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.PageInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.List;
/*    */ 
/*    */ public class LogQueryService extends BaseService implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 18 */     Debug.debugMessage("********* LogQueryService start **********");
/* 19 */     TLog logInfo = new TLog();
/*    */ 
/* 21 */     super.getData(request.getDto(), logInfo);
/* 22 */     logInfo.setOperatorname((String)request.getDto().get("STR_QUERY_OPERATORNAME"));
/* 23 */     logInfo.setOperatorname((String)request.getDto().get("STR_QUERY_OPERATORNAME"));
/*    */ 
/* 25 */     PageInfo page = new PageInfo();
/* 26 */     super.getData(request.getDto(), page);
/*    */ 
/* 28 */     List result = super.queryList(page, logInfo);
/*    */ 
/* 30 */     Debug.debugMessage("********* LogQueryService success **********");
/* 31 */     DTO dto = new DTO();
/*    */ 
/* 33 */     dto.setList("RESULT", result);
/* 34 */     dto.put("PAGEINFO", page);
/* 35 */     dto.put("QUERY_PARAM", logInfo);
/*    */ 
/* 37 */     Response resp = new Response();
/* 38 */     resp.setDto(dto);
/*    */ 
/* 40 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDLog.jar
 * Qualified Name:     cn.com.hd.log.logmanage.LogQueryService
 * JD-Core Version:    0.6.0
 */