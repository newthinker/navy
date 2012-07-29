/*    */ package cn.com.hd.security;
/*    */ 
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ 
/*    */ public class Security
/*    */ {
/*    */   public static String encrypt(String value) throws Exception {
/*  8 */     String classname = SystemParam.getParam("PasswordSecurity");
/*  9 */     if (classname != null) {
/* 10 */       DataSecurity security = (DataSecurity)Class.forName(classname).newInstance();
/* 11 */       value = security.encrypt(value);
/*    */     }
/*    */     return value;
/*    */   }
/*    */ 

/*    */   public static String decrypt(String value) throws Exception {
/* 18 */     String classname = SystemParam.getParam("PasswordSecurity");
/* 19 */     if (classname != null) {
/* 20 */       DataSecurity security = (DataSecurity)Class.forName(classname).newInstance();
/* 21 */       value = security.decrypt(value);
/*    */     }
/*    */ 
/* 24 */     return value;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.security.Security
 * JD-Core Version:    0.6.0
 */