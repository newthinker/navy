/*    */ package cn.com.hd.error;
/*    */ 
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import java.io.PrintStream;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class Debug
/*    */ {
/* 12 */   static int iShowLevel = 12;
/* 13 */   private static Logger logger = Logger.getLogger("Debug");
/*    */ 
/*    */   public static void debugMessage(int iDebugLevel, String sSystemName, String sSubSystemName, String sServiceName, String sMsg) {
/* 16 */     if (!canShowDebug())
/* 17 */       return;
/* 18 */     if (iDebugLevel <= iShowLevel) {
/* 19 */       StringBuffer sbMessage = new StringBuffer("");
/* 20 */       String sTime = String.valueOf(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS").format(new Date()));
/* 21 */       sbMessage.append(sTime).append("> SystemName : " + sSystemName + "\n");
/* 22 */       sbMessage.append(sTime).append("> SubSystemName : " + sSubSystemName + "\n");
/* 23 */       sbMessage.append(sTime).append("> ServiceName : " + sServiceName + "\n");
/* 24 */       sbMessage.append(sTime).append("> Message : " + sMsg + "\n");
/* 25 */       debugMessage(sbMessage.toString());
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void debugMessage(int iDebugLevel, Request request, String sMsg) {
/* 30 */     if (!canShowDebug())
/* 31 */       return;
/* 32 */     if (iDebugLevel <= iShowLevel) {
/* 33 */       StringBuffer sbMessage = new StringBuffer("");
/* 34 */       String sTime = String.valueOf(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS").format(new Date()));
/* 35 */       sbMessage.append(sTime).append("> SystemName : " + request.getResponseSystemName() + "\n");
/* 36 */       sbMessage.append(sTime).append("> SubSystemName : " + request.getResponseSubsystemName() + "\n");
/* 37 */       sbMessage.append(sTime).append("> ServiceName : " + request.getResponseServiceName() + "\n");
/* 38 */       sbMessage.append(sTime).append("> Message : " + sMsg + "\n");
/* 39 */       debugMessage(sbMessage.toString());
/*    */     }
/*    */   }
/*    */ 
/*    */   public static void errorMessage(String sErrorMessage) {
/* 44 */     logger.info(sErrorMessage);
/* 45 */     if ((sErrorMessage != null) && (sErrorMessage.getBytes().length > 4000))
/* 46 */       System.out.println(sErrorMessage.substring(0, 3999));
/*    */     else
/* 48 */       System.out.println(sErrorMessage);
/*    */   }
/*    */ 
/*    */   public static void debugMessage(String sMsg) {
/*    */     try {
/* 53 */       logger.info(sMsg);
/* 54 */       if (!canShowDebug())
/* 55 */         return;
/*    */     }
/*    */     catch (Throwable localThrowable) {
/* 58 */       if ((sMsg != null) && (sMsg.getBytes().length > 4000))
/* 59 */         System.out.println(String.valueOf(String.valueOf(
/* 60 */           new StringBuffer(String.valueOf(String.valueOf(new SimpleDateFormat(
/* 61 */           "yyyy.MM.dd HH:mm:ss.SSS").format(new Date())))).append(">   ")
/* 62 */           .append(sMsg.substring(0, 3999)))));
/*    */       else
/* 64 */         System.out.println(String.valueOf(String.valueOf(
/* 65 */           new StringBuffer(String.valueOf(String.valueOf(new SimpleDateFormat(
/* 66 */           "yyyy.MM.dd HH:mm:ss.SSS").format(new Date())))).append(">   ")
/* 67 */           .append(sMsg)))); 
/*    */     }
/*    */   }
/*    */ 
/*    */   private static boolean canShowDebug() {
/* 71 */     String V_Show = SystemParam.getParam("ShowDebugMessage");
/* 72 */     if (V_Show == null)
/* 73 */       V_Show = "TRUE";
/* 74 */     return V_Show.equalsIgnoreCase("TRUE");
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.error.Debug
 * JD-Core Version:    0.6.0
 */