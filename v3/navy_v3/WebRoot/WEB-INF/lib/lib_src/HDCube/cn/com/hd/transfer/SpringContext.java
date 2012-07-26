/*    */ package cn.com.hd.transfer;
/*    */ 
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.xmlparser.dto.SubsystemDTO;
/*    */ import java.util.HashMap;
/*    */ import javax.servlet.ServletContext;
/*    */ import org.springframework.context.ApplicationContext;
/*    */ import org.springframework.web.context.support.WebApplicationContextUtils;
/*    */ 
/*    */ public class SpringContext
/*    */ {
/*    */   private static ApplicationContext appContext;
/*    */ 
/*    */   public static void initApplicationContext(ServletContext setvletContext)
/*    */   {
/* 20 */     appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(setvletContext);
/*    */   }
/*    */ 
/*    */   public static ApplicationContext getInstance() {
/* 24 */     return appContext;
/*    */   }
/*    */ 
/*    */   public static IService getService(String serviceName) throws Exception {
/* 28 */     String subsystemName = serviceName.split("\\.")[0];
/* 29 */     SubsystemDTO service = (SubsystemDTO)RegisterObject.subsystemInfo.get(subsystemName);
/*    */ 
/* 31 */     if (service.getServiceList().get(serviceName) == null) {
/* 32 */       throw new Exception("not found service!");
/*    */     }
/*    */ 
/* 35 */     return (IService)appContext.getBean(serviceName);
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.SpringContext
 * JD-Core Version:    0.6.0
 */