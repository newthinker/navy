/*    */ package cn.com.hd.transfer;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class SystemParam {
/*  7 */   private static Map<String, String> param = null;
/*    */ 
/*    */   static {
/* 10 */     param = new HashMap();
/*    */   }
/*    */ 
/*    */   public static void setParam(String key, String value) {
/* 14 */     param.put(key, value);
/*    */   }
/*    */ 
/*    */   public static String getParam(String key) {
/* 18 */     return (String)param.get(key);
/*    */   }
/*    */ 
/*    */   public static String getAbsolutePath() {
/* 22 */     return (String)param.get("AbsolutePath");
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.SystemParam
 * JD-Core Version:    0.6.0
 */