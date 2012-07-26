/*     */ package cn.com.hd.service;
/*     */ 
/*     */ import cn.com.hd.database.DBOperator;
/*     */ import cn.com.hd.database.SelectResultSet;
/*     */ import cn.com.hd.dto.ClassMapping;
/*     */ import cn.com.hd.dto.PropertyMapping;
/*     */ import cn.com.hd.error.Debug;
/*     */ import cn.com.hd.error.ErrorProcessor;
/*     */ import cn.com.hd.error.SystemException;
/*     */ import cn.com.hd.transfer.RegisterObject;
/*     */ import cn.com.hd.transfer.SystemParam;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ 
/*     */ public class OracleBaseService extends BaseService
/*     */ {
/*     */   protected int save(BaseDTO dto)
/*     */     throws Exception
/*     */   {
/*  26 */     StringBuffer sStrBuf = new StringBuffer();
/*  27 */     StringBuffer sStrBufColumn = new StringBuffer();
/*  28 */     StringBuffer sStrBufValue = new StringBuffer();
/*  29 */     StringBuffer sStrParameter = new StringBuffer();
/*     */ 
/*  31 */     StringBuffer sStrBufQuery = new StringBuffer();
/*  32 */     StringBuffer sStrBufSelect = new StringBuffer();
/*  33 */     StringBuffer sStrBufWhere = new StringBuffer();
/*     */ 
/*  35 */     List values = new ArrayList();
/*  36 */     List params = new ArrayList();
/*  37 */     List isList = new ArrayList();
/*     */     try
/*     */     {
/*  40 */       ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/*  41 */       if (cmMap == null) {
/*  42 */         throw new Exception("no registed class name as " + dto.getClass().getName());
/*     */       }
/*     */ 
/*  45 */       sStrBuf.append("INSERT INTO ").append(cmMap.getTableName()).append(" ");
/*  46 */       PropertyMapping[] ids = cmMap.getId();
/*  47 */       List props = cmMap.getListProperty();
/*  48 */       for (int i = 0; i < ids.length; i++) {
/*  49 */         PropertyMapping id = ids[i];
/*  50 */         Object value = dto.getPropertyValue(id.getName());
/*  51 */         if ((value == null) && (id.getGenerate() != null)) {
/*  52 */           if (id.getGenerate().equals("UUID")) {
/*  53 */             value = UUID.randomUUID().toString();
/*  54 */           } else if (id.getGenerate().equals("SEQUENCE")) {
/*  55 */             String seqSql = "SELECT " + id.getGeneratevalue() + ".NEXTVAL FROM DUAL";
/*  56 */             Debug.debugMessage("id sequence gengerate sql: " + seqSql);
/*  57 */             SelectResultSet idResultSet = this.dbOperator.executeSelect(seqSql);
/*  58 */             value = Long.valueOf(idResultSet.getLongValue(0, 0));
/*  59 */             dto.setPropertyValue(id.getName(), value);
/*  60 */             Debug.debugMessage("id sequence gengerate value: " + value);
/*     */           }
/*     */ 
/*  63 */           dto.setPropertyValue(id.getName(), value);
/*     */         }
/*     */ 
/*  66 */         sStrBufColumn.append(sStrBufColumn.length() == 0 ? "" : ", ").append(id.getColumnName());
/*  67 */         sStrBufValue.append(sStrBufValue.length() == 0 ? "" : ", ").append("?");
/*     */ 
/*  69 */         values.add(value);
/*  70 */         Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*  71 */         sStrParameter.append(sStrParameter.length() == 0 ? "" : ", ").append(id.getName()).append(":").append(value);
/*     */ 
/*  73 */         sStrBufWhere.append(" AND " + id.getColumnName() + " = ?");
/*  74 */         params.add(value);
/*     */       }
/*     */ 
/*  77 */       for (int i = 0; i < props.size(); i++) {
/*  78 */         PropertyMapping prop = (PropertyMapping)props.get(i);
/*  79 */         Object value = dto.getPropertyValue(prop.getName());
/*  80 */         if (value != null) {
/*  81 */           sStrBufColumn.append(sStrBufColumn.length() == 0 ? "" : ", ").append(prop.getColumnName());
/*     */ 
/*  83 */           if (prop.getType().equalsIgnoreCase("BLOB")) {
/*  84 */             sStrBufValue.append(sStrBufValue.length() == 0 ? "" : ", ").append("empty_blob()");
/*  85 */             sStrBufSelect.append(sStrBufSelect.length() == 0 ? "" : ", ").append(prop.getColumnName());
/*  86 */             isList.add((InputStream)value);
/*  87 */           } else if (prop.getType().equalsIgnoreCase("CLOB")) {
/*  88 */             sStrBufValue.append(sStrBufValue.length() == 0 ? "" : ", ").append("empty_clob()");
/*  89 */             sStrBufSelect.append(sStrBufSelect.length() == 0 ? "" : ", ").append(prop.getColumnName());
/*  90 */             isList.add((InputStream)value);
/*     */           } else {
/*  92 */             sStrBufValue.append(sStrBufValue.length() == 0 ? "" : ", ").append("?");
/*  93 */             values.add(value);
/*     */           }
/*     */ 
/*  96 */           sStrParameter.append(prop.getName()).append(":").append(value);
/*  97 */           Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*     */         }
/*     */       }
/*     */ 
/* 101 */       sStrBuf.append(" ( ").append(sStrBufColumn).append(" ) VALUES (").append(sStrBufValue).append(" ) ");
/*     */ 
/* 103 */       Debug.debugMessage("sql ====== " + sStrBuf.toString());
/*     */ 
/* 105 */       Connection conn = this.dbOperator.getConnection();
/* 106 */       PreparedStatement pstmt = conn.prepareStatement(sStrBuf.toString());
/* 107 */       for (int i = 0; i < values.size(); i++) {
/* 108 */         pstmt.setObject(i + 1, values.get(i));
/*     */       }
/*     */ 
/* 111 */       pstmt.executeUpdate();
/*     */ 
/* 113 */       sStrBufQuery.append("SELECT ").append(sStrBufSelect).append(" FROM ").append(cmMap.getTableName()).append(" WHERE 1 = 1 ").append(sStrBufWhere).append(" FOR UPDATE");
/*     */ 
/* 115 */       Debug.debugMessage("sql ====== " + sStrBufQuery.toString());
/*     */ 
/* 117 */       pstmt = conn.prepareStatement(sStrBufQuery.toString());
/* 118 */       for (int i = 0; i < params.size(); i++) {
/* 119 */         pstmt.setObject(i + 1, params.get(i));
/*     */       }
/*     */ 
/* 122 */       ResultSet rs = pstmt.executeQuery();
/*     */ 
/* 124 */       if (rs.next()) {
/* 125 */         for (int i = 0; i < isList.size(); i++) {
/* 126 */           InputStream is = (InputStream)isList.get(i);
/* 127 */           Object value = rs.getObject(i + 1);
/* 128 */           Method method = value.getClass().getMethod("getBinaryOutputStream", null);
/* 129 */           OutputStream out = (OutputStream)method.invoke(value, null);
/* 130 */           BufferedOutputStream bos = new BufferedOutputStream(out);
/*     */ 
/* 132 */           byte[] buf = new byte[1024];
/* 133 */           int len = 0;
/* 134 */           while ((len = is.read(buf)) != -1) {
/* 135 */             bos.write(buf, 0, len);
/*     */           }
/*     */ 
/* 138 */           bos.close();
/*     */         }
/*     */       }
/*     */ 
/* 142 */       this.dbOperator.getConnection().commit();
/*     */ 
/* 144 */       String sAutoLog = SystemParam.getParam("AutoRecordLog");
/* 145 */       if ((sAutoLog != null) && (sAutoLog.equalsIgnoreCase("true"))) {
/* 146 */         log("insert " + dto.getClass().getName() + ";sql:" + sStrBuf.toString() + ";parameter:{" + sStrParameter.toString() + "}");
/*     */       }
/*     */ 
/* 149 */       return this.result; } catch (Exception ex) {
/*     */     }
/* 151 */     throw ex;
/*     */   }
/*     */ 
/*     */   protected int update(BaseDTO dto) throws Exception
/*     */   {
/* 156 */     StringBuffer sStrBuf = new StringBuffer();
/* 157 */     StringBuffer sStrBufCol = new StringBuffer();
/* 158 */     StringBuffer sStrParameter = new StringBuffer();
/*     */ 
/* 160 */     StringBuffer sStrBufQuery = new StringBuffer();
/* 161 */     StringBuffer sStrBufSelect = new StringBuffer();
/* 162 */     StringBuffer sStrBufWhere = new StringBuffer();
/*     */ 
/* 164 */     List values = new ArrayList();
/* 165 */     List params = new ArrayList();
/* 166 */     List isList = new ArrayList();
/*     */     try
/*     */     {
/* 169 */       ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/* 170 */       if (cmMap == null) {
/* 171 */         throw new Exception("no registed class name as " + dto.getClass().getName());
/*     */       }
/*     */ 
/* 174 */       sStrBuf.append("UPDATE ").append(cmMap.getTableName()).append(" SET ");
/*     */ 
/* 176 */       List props = cmMap.getListProperty();
/* 177 */       for (int i = 0; i < props.size(); i++) {
/* 178 */         PropertyMapping prop = (PropertyMapping)props.get(i);
/* 179 */         Object value = dto.getPropertyValue(prop.getName());
/* 180 */         if (value != null) {
/* 181 */           if (prop.getType().equalsIgnoreCase("BLOB")) {
/* 182 */             sStrBufCol.append(sStrBufCol.length() == 0 ? "" : ", ").append(prop.getColumnName()).append(" = empty_blob() ");
/* 183 */             sStrBufSelect.append(sStrBufSelect.length() == 0 ? "" : ", ").append(prop.getColumnName());
/* 184 */             isList.add((InputStream)value);
/* 185 */           } else if (prop.getType().equalsIgnoreCase("CLOB")) {
/* 186 */             sStrBufCol.append(sStrBufCol.length() == 0 ? "" : ", ").append(prop.getColumnName()).append(" = empty_clob() ");
/* 187 */             sStrBufSelect.append(sStrBufSelect.length() == 0 ? "" : ", ").append(prop.getColumnName());
/* 188 */             isList.add((InputStream)value);
/*     */           } else {
/* 190 */             sStrBufCol.append(sStrBufCol.length() == 0 ? "" : ", ").append(prop.getColumnName()).append(" = ? ");
/* 191 */             values.add(value);
/* 192 */             sStrParameter.append(sStrParameter.length() == 0 ? "" : ", ").append(prop.getName()).append(":").append(value);
/* 193 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 198 */       sStrBuf.append(sStrBufCol).append(" WHERE 1 = 1");
/*     */ 
/* 200 */       PropertyMapping[] ids = cmMap.getId();
/* 201 */       for (int i = 0; i < ids.length; i++) {
/* 202 */         PropertyMapping id = ids[i];
/* 203 */         Object value = dto.getPropertyValue(id.getName());
/* 204 */         if (value != null) {
/* 205 */           sStrBuf.append(" AND ").append(id.getColumnName()).append(" = ? ");
/* 206 */           sStrBufWhere.append(" AND ").append(id.getColumnName()).append(" = ? ");
/* 207 */           values.add(value);
/* 208 */           params.add(value);
/* 209 */           sStrParameter.append(", ").append(id.getName()).append(":").append(value);
/* 210 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*     */         }
/*     */       }
/*     */ 
/* 214 */       Debug.debugMessage("sql ====== " + sStrBuf.toString());
/*     */ 
/* 216 */       Connection conn = this.dbOperator.getConnection();
/* 217 */       PreparedStatement pstmt = conn.prepareStatement(sStrBuf.toString());
/* 218 */       for (int i = 0; i < values.size(); i++) {
/* 219 */         pstmt.setObject(i + 1, values.get(i));
/*     */       }
/*     */ 
/* 222 */       pstmt.executeUpdate();
/*     */ 
/* 224 */       sStrBufQuery.append("SELECT ").append(sStrBufSelect).append(" FROM ").append(cmMap.getTableName()).append(" WHERE 1 = 1 ").append(sStrBufWhere).append(" FOR UPDATE");
/*     */ 
/* 226 */       Debug.debugMessage("sql ====== " + sStrBufQuery.toString());
/*     */ 
/* 228 */       pstmt = conn.prepareStatement(sStrBufQuery.toString());
/* 229 */       for (int i = 0; i < params.size(); i++) {
/* 230 */         pstmt.setObject(i + 1, params.get(i));
/*     */       }
/*     */ 
/* 233 */       ResultSet rs = pstmt.executeQuery();
/*     */ 
/* 235 */       if (rs.next()) {
/* 236 */         for (int i = 0; i < isList.size(); i++) {
/* 237 */           Object value = rs.getObject(i + 1);
/* 238 */           InputStream is = (InputStream)isList.get(i);
/* 239 */           Method method = value.getClass().getMethod("getBinaryOutputStream", null);
/* 240 */           OutputStream out = (OutputStream)method.invoke(value, null);
/* 241 */           BufferedOutputStream bos = new BufferedOutputStream(out);
/*     */ 
/* 243 */           byte[] buf = new byte[1024];
/* 244 */           int len = 0;
/* 245 */           while ((len = is.read(buf)) != -1) {
/* 246 */             bos.write(buf, 0, len);
/*     */           }
/*     */ 
/* 249 */           bos.close();
/*     */         }
/*     */       }
/*     */ 
/* 253 */       this.dbOperator.getConnection().commit();
/*     */ 
/* 255 */       String sAutoLog = SystemParam.getParam("AutoRecordLog");
/* 256 */       if ((sAutoLog != null) && (sAutoLog.equalsIgnoreCase("true"))) {
/* 257 */         log("update " + dto.getClass().getName() + ";sql:" + sStrBuf.toString() + ";parameter:{" + sStrParameter.toString() + "}");
/*     */       }
/*     */ 
/* 260 */       return this.result;
/*     */     } catch (Exception ex) {
/* 262 */       ErrorProcessor.prompt(getClass().getName(), "update() error", ex);
/* 263 */     }throw new SystemException(ex.getMessage());
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.service.OracleBaseService
 * JD-Core Version:    0.6.0
 */