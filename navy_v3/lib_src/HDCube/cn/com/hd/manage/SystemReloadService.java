/*    */ package cn.com.hd.manage;
/*    */ 
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import cn.com.hd.xmlparser.SystemXMLParser;
/*    */ 
/*    */ public class SystemReloadService extends BaseService implements IService {
/*    */   public Response service(Request request) throws Exception
/*    */   {
/* 14 */     Debug.debugMessage("---- System reload start ----");
/*    */ 
/* 16 */     Response resp = new Response();
/*    */     try {
/* 18 */       SystemXMLParser.registSystem();
/* 19 */       resp.setResult(Integer.valueOf(1));
/*    */     } catch (Exception ex) {
/* 21 */       ErrorProcessor.prompt(getClass().getName(), "System reload error!", ex);
/* 22 */       resp.setResult(Integer.valueOf(0));
/* 23 */       resp.setErrorInfo(ex.getMessage());
/*    */     }
/*    */ 
/* 26 */     Debug.debugMessage("---- System reload end ----");
/* 27 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.manage.SystemReloadService
 * JD-Core Version:    0.6.0
 */