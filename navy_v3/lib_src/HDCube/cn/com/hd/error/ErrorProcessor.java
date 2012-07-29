/*    */ package cn.com.hd.error;
/*    */ 
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.OutputStreamWriter;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 


/*    */ public class ErrorProcessor
/*    */ {
/* 14 */   static int defaultclassType = 0;
/*    */ 



/*    */   public static void prompt(String className, String errorMessage, Exception ex)
/*    */   {
/* 21 */     StringBuffer sbMessage = new StringBuffer("");
/* 22 */     String sTime = String.valueOf(new SimpleDateFormat(
/* 23 */       "yyyy.MM.dd HH:mm:ss.SSS").format(new Date()));
/* 24 */     sbMessage.append(sTime).append("> className : " + className + "\n");
/* 25 */     sbMessage.append(sTime).append(
/* 26 */       "> errorMessage : " + errorMessage + "\n");
/* 27 */     if (ex != null) {
/* 28 */       sbMessage.append(sTime).append(
/* 29 */         "> error : " + ex.getCause() + " ---- " + ex.getMessage() + "\n");
/*    */ 
/* 31 */       sbMessage.append(sTime).append(
/* 32 */         "> ======================================== \n");
/*    */ 
/* 34 */       sbMessage.append(sTime).append("> exeption : " + ex + "\n");
/*    */ 
/* 36 */       StackTraceElement[] stackelem = ex.getStackTrace();
/* 37 */       for (int i = 0; i < stackelem.length; i++) {
/* 38 */         sbMessage.append(sTime).append("> " + stackelem[i] + " \n");
/*    */       }
/*    */ 
/* 41 */       sbMessage.append(sTime).append(
/* 42 */         "> ======================================== \n");
/*    */     }
/* 44 */     Debug.errorMessage(sbMessage.toString());
/*    */   }
/*    */ 
/*    */   public static void setErrorProcessorClass(int classtype) {
/* 48 */     defaultclassType = classtype;
/*    */   }
/*    */ 
/*    */   public static void prompt(String className, String errorMessage, int classtype, Exception ex)
/*    */   {
/* 53 */     if (defaultclassType < classtype) {
/* 54 */       System.out.println("========================================");
/* 55 */       System.out.println("Error in: ".concat(String.valueOf(
/* 56 */         String.valueOf(className))));
/* 57 */       System.out.println(errorMessage);
/* 58 */       System.out.println("====================");
/* 59 */       ex.printStackTrace();
/*    */     }
/* 61 */     String errorString = "==================================================\r\n";
/* 62 */     errorString = String.valueOf(String.valueOf(new StringBuffer(
/* 63 */       String.valueOf(String.valueOf(errorString))).append(new Date())
/* 64 */       .append("\r\n")));
/* 65 */     errorString = String.valueOf(String.valueOf(new StringBuffer(
/* 66 */       String.valueOf(String.valueOf(errorString))).append("Error in: ")
/* 67 */       .append(className).append("\r\n")));
/* 68 */     errorString = String.valueOf(String.valueOf(new StringBuffer(
/* 69 */       String.valueOf(String.valueOf(errorString))).append(errorMessage)
/* 70 */       .append("\r\n")));
/* 71 */     errorString = String.valueOf(String.valueOf(errorString)).concat(
/* 72 */       "==============================\r\n");
/*    */     try {
/* 74 */       String fileName = "huadiError.log";
/* 75 */       OutputStreamWriter osw = new OutputStreamWriter(
/* 76 */         new FileOutputStream(fileName, true), "GBK");
/* 77 */       osw.write(errorString, 0, errorString.length());
/* 78 */       ex.printStackTrace(new PrintWriter(osw));
/* 79 */       osw.close();
/*    */     } catch (Exception ex1) {
/* 81 */       System.out.println("无法写错误日志文件！");
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.error.ErrorProcessor
 * JD-Core Version:    0.6.0
 */