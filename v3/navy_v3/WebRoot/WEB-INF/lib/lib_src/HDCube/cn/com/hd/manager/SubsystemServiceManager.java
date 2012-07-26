/*    */ package cn.com.hd.manager;
/*    */ 
/*    */ import cn.com.hd.database.DBOperator;
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.error.SystemException;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import cn.com.hd.transfer.SpringContext;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpSession;
/*    */ 
/*    */ public class SubsystemServiceManager
/*    */ {
/*    */   public static Response service(Request request, List<DBOperator> dbOperatorList)
/*    */     throws Exception
/*    */   {
/* 21 */     Debug.debugMessage(1, request, "SubsystemServiceManager start.");
/*    */ 
/* 24 */     IService service = null;
/*    */     Response response;
/*    */     try
/*    */     {
/* 27 */       service = SpringContext.getService(request
/* 28 */         .getResponseSubsystemName() + 
/* 29 */         "." + request.getResponseServiceName());
/*    */ 
/* 31 */       BaseService bService = (BaseService)SpringContext.getService(request
/* 32 */         .getResponseSubsystemName() + 
/* 33 */         "." + request.getResponseServiceName());
/*    */ 
/* 35 */       bService.setSession((HttpSession)request.getDto().remove("SESSION"));
/* 36 */       bService.setLoginInfo((LoginInfo)request.getDto().remove("LOGININFO"));
/* 37 */       DBOperator dbOperator = new DBOperator(request.getResponseSystemName(), request.getResponseServiceName(), request.getResponseSubsystemName());
/* 38 */       bService.setDbOperator(dbOperator);
/* 39 */       bService.setRequest(request);
/* 40 */       bService.setDbOperatorList(dbOperatorList);
/* 41 */       if (dbOperator.getConnection() != null) {
/* 42 */         dbOperatorList.add(dbOperator);
/*    */       }
/*    */       try
/*    */       {
/* 46 */         response = service.service(request);
/*    */       }
/*    */       catch (Exception ex)
/*    */       {
/*    */         Response response;
/* 48 */         Response response = new Response();
/* 49 */         response.setErrorInfo(ex.toString());
/* 50 */         ErrorProcessor.prompt(SubsystemServiceManager.class.getName(), 
/* 51 */           "service launch error!", ex);
/* 52 */         throw new SystemException(ex.getMessage());
/*    */       }
/*    */     } catch (Exception ex) {
/* 55 */       response = new Response();
/* 56 */       response.setErrorInfo("not found service :" + 
/* 57 */         request.getResponseSubsystemName() + "/" + 
/* 58 */         request.getResponseServiceName() + "." + ex.toString());
/* 59 */       ErrorProcessor.prompt(SubsystemServiceManager.class.getName(), 
/* 60 */         "not found service : " + request.getResponseSubsystemName() + 
/* 61 */         "/" + request.getResponseServiceName() + ".", ex);
/* 62 */       throw new SystemException(ex.getMessage());
/*    */     }
/*    */ 
/* 65 */     Debug.debugMessage(1, request, "SubsystemServiceManager down.");
/*    */ 
/* 67 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.manager.SubsystemServiceManager
 * JD-Core Version:    0.6.0
 */