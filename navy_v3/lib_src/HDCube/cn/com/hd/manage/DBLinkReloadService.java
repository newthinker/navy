/*    */ package cn.com.hd.manage;
/*    */ 
/*    */ import cn.com.hd.database.DBConnectionManager;
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import cn.com.hd.transfer.SpringContext;
/*    */ import cn.com.hd.xmlparser.DBLinkXMLParser;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class DBLinkReloadService extends BaseService implements IService
/*    */ {
/*    */   public Response service(Request request) throws Exception {
/* 18 */     Debug.debugMessage("---- DBLink reload start ----");
/*    */ 
/* 20 */     Response resp = new Response();
/*    */     try {
/* 22 */       SpringContext.initApplicationContext(this.session.getServletContext());
/* 23 */       List listSubSystem = DBLinkXMLParser.getAllSubSystem();
/* 24 */       for (int i = 0; i < listSubSystem.size(); i++) {
/* 25 */         DBConnectionManager.getInstance().registerDBConnectionPool((String)listSubSystem.get(i));
/*    */       }
/*    */ 
/* 28 */       resp.setResult(Integer.valueOf(1));
/*    */     } catch (Exception ex) {
/* 30 */       ErrorProcessor.prompt(getClass().getName(), "DBLink reload error!", ex);
/* 31 */       resp.setResult(Integer.valueOf(0));
/* 32 */       resp.setErrorInfo(ex.getMessage());
/*    */     }
/*    */ 
/* 35 */     Debug.debugMessage("---- DBLink reload end ----");
/* 36 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.manage.DBLinkReloadService
 * JD-Core Version:    0.6.0
 */