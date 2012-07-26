/*     */ package cn.com.hd.transfer;
/*     */ 
/*     */ import cn.com.hd.error.ErrorProcessor;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Clob;
/*     */ import java.sql.SQLException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ 
/*     */ public class DTO extends HashMap<String, Object>
/*     */ {
/*     */   String tableName;
/*     */ 
/*     */   public void setString(String key, String value)
/*     */   {
/*  24 */     put("STR_" + key, value);
/*     */   }
/*     */ 
/*     */   public String getString(String key) {
/*  28 */     return (String)get("STR_" + key);
/*     */   }
/*     */ 
/*     */   public void setInt(String key, Integer value) {
/*  32 */     put("INT_" + key, new Integer(value.intValue()));
/*     */   }
/*     */ 
/*     */   public Integer getInt(String key) {
/*  36 */     if (get("INT_" + key) == null) {
/*  37 */       return null;
/*     */     }
/*     */ 
/*  40 */     if ((get("INT_" + key) instanceof String)) {
/*  41 */       return Integer.valueOf((String)get("INT_" + key));
/*     */     }
/*     */ 
/*  44 */     return (Integer)get("INT_" + key);
/*     */   }
/*     */ 
/*     */   public void setLong(String key, Long value)
/*     */   {
/*  49 */     put("LON_" + key, new Long(value.longValue()));
/*     */   }
/*     */ 
/*     */   public Long getLong(String key) {
/*  53 */     if (get("LON_" + key) == null) {
/*  54 */       return null;
/*     */     }
/*     */ 
/*  57 */     if ((get("LON_" + key) instanceof String)) {
/*  58 */       return Long.valueOf((String)get("LON_" + key));
/*     */     }
/*     */ 
/*  61 */     return (Long)get("LON_" + key);
/*     */   }
/*     */ 
/*     */   public void setDouble(String key, Double value) {
/*  65 */     put("DOU_" + key, new Double(value.doubleValue()));
/*     */   }
/*     */ 
/*     */   public Double getDouble(String key) {
/*  69 */     if (get("DOU_" + key) == null) {
/*  70 */       return null;
/*     */     }
/*     */ 
/*  73 */     if ((get("DOU_" + key) instanceof String)) {
/*  74 */       return Double.valueOf((String)get("DOU_" + key));
/*     */     }
/*     */ 
/*  77 */     return (Double)get("DOU_" + key);
/*     */   }
/*     */ 
/*     */   public void setBoolean(String key, Boolean value) {
/*  81 */     put("BOO_" + key, new Boolean(value.booleanValue()));
/*     */   }
/*     */ 
/*     */   public Boolean getBoolean(String key) {
/*  85 */     if (get("BOO_" + key) == null) {
/*  86 */       return null;
/*     */     }
/*     */ 
/*  89 */     if ((get("BOO_" + key) instanceof String)) {
/*  90 */       return Boolean.valueOf((String)get("BOO_" + key));
/*     */     }
/*     */ 
/*  93 */     return (Boolean)get("BOO_" + key);
/*     */   }
/*     */ 
/*     */   public void setDate(String key, Date value) {
/*  97 */     put("DAT_" + key, value);
/*     */   }
/*     */ 
/*     */   public Date getDate(String key) {
/* 101 */     if (get("DAT_" + key) == null) {
/* 102 */       return null;
/*     */     }
/* 104 */     if ((get("DAT_" + key) instanceof String)) {
/* 105 */       Date date = null;
/*     */       try {
/* 107 */         date = new SimpleDateFormat("yyyy-MM-dd").parse(
/* 108 */           (String)get("DAT_" + key));
/*     */       } catch (Exception ex) {
/* 110 */         ErrorProcessor.prompt(getClass().getName(), "getDate() error!", ex);
/*     */       }
/* 112 */       return date;
/*     */     }
/*     */ 
/* 115 */     return (Date)get("DAT_" + key);
/*     */   }
/*     */ 
/*     */   public void setInputStream(String key, InputStream value) {
/* 119 */     put("IS_" + key, value);
/*     */   }
/*     */ 
/*     */   public InputStream getInputStream(String key) {
/* 123 */     return (InputStream)get("IS_" + key);
/*     */   }
/*     */ 
/*     */   public void setHashMap(String key, HashMap value) {
/* 127 */     put("HAS_" + key, value);
/*     */   }
/*     */ 
/*     */   public HashMap getHashMap(String key) {
/* 131 */     return (HashMap)get("HAS_" + key);
/*     */   }
/*     */ 
/*     */   public void setSelectItems(List value) {
/* 135 */     put("DICT_LIST", value);
/*     */   }
/*     */ 
/*     */   public List getSelectItems() {
/* 139 */     return (List)get("DICT_LIST");
/*     */   }
/*     */ 
/*     */   public void setList(String key, DTO value) {
/* 143 */     List dtoList = new ArrayList();
/* 144 */     dtoList.add(value);
/* 145 */     setList(key, dtoList);
/*     */   }
/*     */ 
/*     */   public void setList(String key, List<DTO> value) {
/* 149 */     put("LIS_" + key, value);
/*     */   }
/*     */ 
/*     */   public List<DTO> getList(String key) {
/* 153 */     return (List)get("LIS_" + key);
/*     */   }
/*     */ 
/*     */   public String toXMLString() {
/* 157 */     StringBuffer strBuffer = new StringBuffer();
/* 158 */     strBuffer.append("<DTO>");
/* 159 */     strBuffer.append(hashMapToXMLString(this));
/* 160 */     strBuffer.append("</DTO>");
/* 161 */     return strBuffer.toString();
/*     */   }
/*     */ 
/*     */   public String hashMapToXMLString(HashMap hashMap)
/*     */   {
/* 166 */     StringBuffer strBuffer = new StringBuffer();
/*     */ 
/* 169 */     Iterator iter = hashMap.entrySet().iterator();
/* 170 */     while (iter.hasNext()) {
/* 171 */       Map.Entry entry = (Map.Entry)iter.next();
/*     */ 
/* 173 */       String key = (String)entry.getKey();
/* 174 */       strBuffer.append("<" + key + ">");
/*     */ 
/* 176 */       Object object = entry.getValue();
/* 177 */       if ((object instanceof HashMap)) {
/* 178 */         strBuffer.append(hashMapToXMLString((HashMap)object));
/* 179 */       } else if ((object instanceof List)) {
/* 180 */         strBuffer.append(listToXMLString((List)object));
/*     */       }
/* 182 */       else if (object != null) {
/* 183 */         String xml = object.toString();
/* 184 */         xml = xml.replaceAll("&", "&amp;");
/* 185 */         xml = xml.replaceAll("<", "&lt;");
/* 186 */         xml = xml.replaceAll(">", "&gt;");
/* 187 */         xml = xml.replaceAll("'", "&apos;");
/* 188 */         xml = xml.replaceAll("\"", "&quot;");
/* 189 */         strBuffer.append(xml);
/*     */       } else {
/* 191 */         strBuffer.append(object);
/*     */       }
/*     */ 
/* 195 */       strBuffer.append("</" + key + ">");
/*     */     }
/*     */ 
/* 198 */     return strBuffer.toString();
/*     */   }
/*     */ 
/*     */   public String listToXMLString(List list)
/*     */   {
/* 203 */     StringBuffer strBuffer = new StringBuffer();
/*     */ 
/* 206 */     for (int i = 0; i < list.size(); i++) {
/* 207 */       strBuffer.append("<Row>");
/* 208 */       Object object = list.get(i);
/* 209 */       if ((object instanceof HashMap)) {
/* 210 */         strBuffer.append(hashMapToXMLString((HashMap)object));
/* 211 */       } else if ((object instanceof List)) {
/* 212 */         strBuffer.append(listToXMLString((List)object));
/*     */       }
/* 214 */       else if (object != null) {
/* 215 */         String xml = object.toString();
/* 216 */         xml = xml.replaceAll("&", "&amp;");
/* 217 */         xml = xml.replaceAll("<", "&lt;");
/* 218 */         xml = xml.replaceAll(">", "&gt;");
/* 219 */         xml = xml.replaceAll("'", "&apos;");
/* 220 */         xml = xml.replaceAll("\"", "&quot;");
/* 221 */         strBuffer.append(xml);
/*     */       } else {
/* 223 */         strBuffer.append(object);
/*     */       }
/*     */ 
/* 227 */       strBuffer.append("</Row>");
/*     */     }
/*     */ 
/* 230 */     return strBuffer.toString();
/*     */   }
/*     */ 
/*     */   public void setNumber(String key, BigDecimal value) {
/* 234 */     put("NUM_" + key, value);
/*     */   }
/*     */ 
/*     */   public BigDecimal getNumber(String key) {
/* 238 */     return (BigDecimal)get("NUM_" + key);
/*     */   }
/*     */ 
/*     */   public void setObject(String key, Object value) {
/* 242 */     put(key, value);
/*     */   }
/*     */ 
/*     */   public Object getObject(String key) {
/* 246 */     return get(key);
/*     */   }
/*     */ 
/*     */   public void setBlob(String key, Blob value) {
/* 250 */     put("BLOB_" + key, value);
/*     */   }
/*     */ 
/*     */   public Blob getBlob(String key) {
/* 254 */     return (Blob)get("BLOB_" + key);
/*     */   }
/*     */ 
/*     */   public void setClob(String key, Clob value) {
/* 258 */     put("CLOB_" + key, value);
/*     */   }
/*     */ 
/*     */   public Clob getClob(String key) {
/* 262 */     return (Clob)get("CLOB_" + key);
/*     */   }
/*     */ 
/*     */   public String showBlob(String key) {
/* 266 */     Blob blob = getBlob(key);
/* 267 */     StringBuffer sb = new StringBuffer();
/*     */     try {
/* 269 */       InputStream is = blob.getBinaryStream();
/* 270 */       byte[] buf = new byte[1024];
/* 271 */       int len = 0;
/*     */ 
/* 273 */       while ((len = is.read(buf)) != -1)
/* 274 */         sb.append(new String(buf, 0, len));
/*     */     }
/*     */     catch (SQLException e) {
/* 277 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 279 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 282 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String showClob(String key) {
/* 286 */     Clob clob = getClob(key);
/* 287 */     StringBuffer sb = new StringBuffer();
/*     */     try {
/* 289 */       InputStream is = clob.getAsciiStream();
/* 290 */       byte[] buf = new byte[1024];
/* 291 */       int len = 0;
/*     */ 
/* 293 */       while ((len = is.read(buf)) != -1)
/* 294 */         sb.append(new String(buf, 0, len));
/*     */     }
/*     */     catch (SQLException e) {
/* 297 */       e.printStackTrace();
/*     */     } catch (IOException e) {
/* 299 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 302 */     return sb.toString();
/*     */   }
/*     */ 
/*     */   public String showString(String key) {
/* 306 */     String value = getString(key);
/* 307 */     return value == null ? "" : value;
/*     */   }
/*     */ 
/*     */   public String showDouble(String key) {
/* 311 */     Double value = getDouble(key);
/* 312 */     return value == null ? "" : value.toString();
/*     */   }
/*     */ 
/*     */   public String showLong(String key) {
/* 316 */     Long value = getLong(key);
/* 317 */     return value == null ? "" : value.toString();
/*     */   }
/*     */ 
/*     */   public String showInt(String key) {
/* 321 */     Integer value = getInt(key);
/* 322 */     return value == null ? "" : value.toString();
/*     */   }
/*     */ 
/*     */   public String showNumber(String key) {
/* 326 */     BigDecimal value = getNumber(key);
/* 327 */     return value == null ? "" : value.toString();
/*     */   }
/*     */ 
/*     */   public String showDate(String key) {
/* 331 */     Date value = getDate(key);
/* 332 */     return value == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(value);
/*     */   }
/*     */ 
/*     */   public String showString(String key, String defaultValue) {
/* 336 */     if (defaultValue == null) {
/* 337 */       return "";
/*     */     }
/*     */ 
/* 340 */     String value = getString(key);
/* 341 */     return value == null ? defaultValue : value;
/*     */   }
/*     */ 
/*     */   public String showDouble(String key, String defaultValue) {
/* 345 */     if (defaultValue == null) {
/* 346 */       return "";
/*     */     }
/*     */ 
/* 349 */     Double value = getDouble(key);
/* 350 */     return value == null ? defaultValue : value.toString();
/*     */   }
/*     */ 
/*     */   public String showLong(String key, String defaultValue) {
/* 354 */     if (defaultValue == null) {
/* 355 */       return "";
/*     */     }
/*     */ 
/* 358 */     Long value = getLong(key);
/* 359 */     return value == null ? defaultValue : value.toString();
/*     */   }
/*     */ 
/*     */   public String showInt(String key, String defaultValue) {
/* 363 */     if (defaultValue == null) {
/* 364 */       return "";
/*     */     }
/*     */ 
/* 367 */     Integer value = getInt(key);
/* 368 */     return value == null ? defaultValue : value.toString();
/*     */   }
/*     */ 
/*     */   public String showNumber(String key, String defaultValue) {
/* 372 */     if (defaultValue == null) {
/* 373 */       return "";
/*     */     }
/*     */ 
/* 376 */     BigDecimal value = getNumber(key);
/* 377 */     return value == null ? defaultValue : value.toString();
/*     */   }
/*     */ 
/*     */   public String showDate(String key, String defaultValue) {
/* 381 */     if (defaultValue == null) {
/* 382 */       return "";
/*     */     }
/*     */ 
/* 385 */     Date value = getDate(key);
/* 386 */     return value == null ? defaultValue : new SimpleDateFormat("yyyy-MM-dd").format(value);
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.DTO
 * JD-Core Version:    0.6.0
 */