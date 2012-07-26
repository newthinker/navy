/*    */ package cn.com.hd.security.impl;
/*    */ 
/*    */ import cn.com.hd.security.DataSecurity;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ 
/*    */ public class MD5
/*    */   implements DataSecurity
/*    */ {
/*    */   public String decrypt(String value)
/*    */   {
/* 11 */     return value;
/*    */   }
/*    */ 
/*    */   public String encrypt(String value) {
/* 15 */     return getMD5Digest(value);
/*    */   }
/*    */ 
/*    */   public static String getMD5Digest(String sourceData)
/*    */   {
/*    */     try
/*    */     {
/* 28 */       MessageDigest alga = MessageDigest.getInstance("MD5");
/*    */ 
/* 30 */       alga.update(sourceData.getBytes());
/* 31 */       byte[] digesta = alga.digest();
/* 32 */       return byteToHexString(digesta);
/*    */     } catch (NoSuchAlgorithmException ex) {
/* 34 */       ex.printStackTrace();
/*    */     }
/* 36 */     return null;
/*    */   }
/*    */ 
/*    */   public static String byteToHexString(byte[] b)
/*    */   {
/* 41 */     String hs = "";
/* 42 */     String stmp = "";
/* 43 */     for (int n = 0; n < b.length; n++) {
/* 44 */       stmp = Integer.toHexString(b[n] & 0xFF);
/* 45 */       if (stmp.length() == 1)
/* 46 */         hs = hs + "0" + stmp;
/*    */       else {
/* 48 */         hs = hs + stmp;
/*    */       }
/*    */ 
/* 51 */       if (n < b.length - 1) {
/* 52 */         hs = hs;
/*    */       }
/*    */     }
/* 55 */     return hs;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.security.impl.MD5
 * JD-Core Version:    0.6.0
 */