/*     */ package cn.com.hd.security.impl;
/*     */ 
/*     */ import cn.com.hd.security.DataSecurity;
/*     */ import java.security.SecureRandom;
/*     */ import javax.crypto.Cipher;
/*     */ import javax.crypto.SecretKey;
/*     */ import javax.crypto.SecretKeyFactory;
/*     */ import javax.crypto.spec.DESKeySpec;
/*     */ 
/*     */ public class Huadi implements DataSecurity {
/*     */   private static final String PASSWORD_CRYPT_KEY = "huadi";
/*     */   private static final String DES = "DES";
/*     */ 
/*     */   public String decrypt(String value) {
/*  15 */     return getDecrypt(value);
/*     */   }
/*     */ 
/*     */   public String encrypt(String value) {
/*  19 */     return getEncrypt(value);
/*     */   }
/*     */ 
















/*     */   public static String byte2hex(byte[] b)
/*     */   {
/*  40 */     String hs = "";
/*     */ 
/*  42 */     String stmp = "";
/*     */ 
/*  44 */     for (int n = 0; n < b.length; n++) {
/*  45 */       stmp = Integer.toHexString(b[n] & 0xFF);
/*     */ 
/*  47 */       if (stmp.length() == 1)
/*  48 */         hs = hs + "0" + stmp;
/*     */       else {
/*  50 */         hs = hs + stmp;
/*     */       }
/*     */     }
/*     */ 
/*  54 */     return hs.toUpperCase();
/*     */   }
/*     */ 










/*     */   public static byte[] decrypt(byte[] src, byte[] key)
/*     */     throws Exception
/*     */   {
/*  70 */     SecureRandom sr = new SecureRandom();
/*     */ 

/*  73 */     DESKeySpec dks = new DESKeySpec(key);
/*     */ 

/*  76 */     SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
/*  77 */     SecretKey securekey = keyFactory.generateSecret(dks);
/*     */ 

/*  80 */     Cipher cipher = Cipher.getInstance("DES");
/*     */ 

/*  83 */     cipher.init(2, securekey, sr);
/*     */ 


/*  87 */     return cipher.doFinal(src);
/*     */   }
/*     */ 








/*     */   public static final String getDecrypt(String data)
/*     */   {
/*     */     try
/*     */     {
/* 102 */       return new String(
/* 103 */         decrypt(hex2byte(data.getBytes()), 
/* 103 */         "huadi".getBytes()));
/*     */     } catch (Exception e) {
/* 105 */       e.printStackTrace();
/*     */     }
/* 108 */     return null;
/*     */   }
/*     */ 










/*     */   public static byte[] encrypt(byte[] src, byte[] key)
/*     */     throws Exception
/*     */   {
/* 124 */     SecureRandom sr = new SecureRandom();
/*     */ 

/* 127 */     DESKeySpec dks = new DESKeySpec(key);
/*     */ 

/* 130 */     SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
/* 131 */     SecretKey securekey = keyFactory.generateSecret(dks);
/*     */ 

/* 134 */     Cipher cipher = Cipher.getInstance("DES");
/*     */ 

/* 137 */     cipher.init(1, securekey, sr);
/*     */ 


/* 141 */     return cipher.doFinal(src);
/*     */   }
/*     */ 







/*     */   public static final String getEncrypt(String password)
/*     */   {
/*     */     try
/*     */     {
/* 155 */       return byte2hex(encrypt(password.getBytes(), 
/* 156 */         "huadi".getBytes()));
/*     */     } catch (Exception e) {
/* 158 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 161 */     return null;
/*     */   }
/*     */ 






/*     */   public static String getFileExtName(String name)
/*     */   {
/* 172 */     int index = name.lastIndexOf(".");
/* 173 */     if (index == -1) {
/* 174 */       return name;
/*     */     }
/*     */ 
/* 177 */     return name.substring(index + 1, name.length());
/*     */   }
/*     */ 







/*     */   public static String getFileFullName(String name, String pattern)
/*     */   {
/* 189 */     int index = name.lastIndexOf(pattern);
/*     */ 
/* 191 */     if (index == -1) {
/* 192 */       return name;
/*     */     }
/*     */ 
/* 195 */     return name.substring(index + 1, name.length());
/*     */   }
/*     */ 






/*     */   public static String getFileFullPath(String name, String pattern)
/*     */   {
/* 206 */     int index = name.lastIndexOf(pattern);
/* 207 */     if (index == -1) {
/* 208 */       return name;
/*     */     }
/*     */ 
/* 211 */     return name.substring(0, index);
/*     */   }
/*     */ 





/*     */   public static String getFileName(String name)
/*     */   {
/* 221 */     int index = name.lastIndexOf(".");
/* 222 */     if (index == -1) {
/* 223 */       return name;
/*     */     }
/*     */ 
/* 226 */     return name.substring(0, index);
/*     */   }
/*     */ 






/*     */   public static byte[] hex2byte(byte[] b)
/*     */   {
/* 237 */     if (b.length % 2 != 0) {
/* 238 */       throw new IllegalArgumentException("长度不是偶数");
/*     */     }
/*     */ 
/* 241 */     byte[] b2 = new byte[b.length / 2];
/*     */ 
/* 243 */     for (int n = 0; n < b.length; n += 2) {
/* 244 */       String item = new String(b, n, 2);
/*     */ 
/* 246 */       b2[(n / 2)] = (byte)Integer.parseInt(item, 16);
/*     */     }
/*     */ 
/* 249 */     return b2;
/*     */   }
/*     */ 
/*     */   public static String toCapitalLower(String string)
/*     */   {
/* 260 */     String first = new String(new char[] { string.charAt(0) });
/* 261 */     return string.replaceFirst(first, first.toLowerCase());
/*     */   }
/*     */ 












/*     */   public static String toCapitalUpper(String string)
/*     */   {
/* 272 */     String first = new String(new char[] { string.charAt(0) });
/* 273 */     return string.replaceFirst(first, first.toUpperCase());
/*     */   }
/*     */ 
/*     */   public static int realLength(String str)
/*     */   {
/* 278 */     if (str == null) {
/* 279 */       return 0;
/*     */     }
/*     */ 
/* 282 */     str = str;
/* 283 */     int len = str.length();
/*     */ 
/* 285 */     int ret = 0;
/* 286 */     for (int i = 0; i < len; i++) {
/* 287 */       if (str.charAt(i) < '')
/* 288 */         ret++;
/*     */       else {
/* 290 */         ret += 2;
/*     */       }
/*     */     }
/*     */ 
/* 294 */     return ret;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.security.impl.Huadi
 * JD-Core Version:    0.6.0
 */