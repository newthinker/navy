/*    */ package cn.com.hd.manage;
/*    */ 
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import cn.com.hd.transfer.SpringContext;
/*    */ import cn.com.hd.xmlparser.SubsystemXMLParser;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class ServiceReloadService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 15 */     Debug.debugMessage("---- Sub System reload start ----");
/*    */ 
/* 17 */     Response resp = new Response();
/*    */     try {
/* 19 */       SpringContext.initApplicationContext(this.session.getServletContext());
/* 20 */       SubsystemXMLParser.registSubsystem();
/* 21 */       resp.setResult(Integer.valueOf(1));
/*    */     } catch (Exception ex) {
/* 23 */       ErrorProcessor.prompt(getClass().getName(), "Sub System reload error!", ex);
/* 24 */       resp.setResult(Integer.valueOf(0));
/* 25 */       resp.setErrorInfo(ex.getMessage());
/*    */     }
/*    */ 
/* 28 */     Debug.debugMessage("---- Sub System reload end ----");
/* 29 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.manage.ServiceReloadService
 * JD-Core Version:    0.6.0
 */