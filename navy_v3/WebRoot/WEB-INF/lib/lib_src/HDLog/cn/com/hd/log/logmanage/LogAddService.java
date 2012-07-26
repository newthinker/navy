/*     */ package cn.com.hd.log.logmanage;
/*     */ 
/*     */ import cn.com.hd.database.DBOperator;
/*     */ import cn.com.hd.database.PreparedStatementOperator;
/*     */ import cn.com.hd.database.SelectResultSet;
/*     */ import cn.com.hd.dto.ClassMapping;
/*     */ import cn.com.hd.dto.PropertyMapping;
/*     */ import cn.com.hd.dto.log.TLog;
/*     */ import cn.com.hd.error.Debug;
/*     */ import cn.com.hd.error.ErrorProcessor;
/*     */ import cn.com.hd.error.SystemException;
/*     */ import cn.com.hd.service.BaseDTO;
/*     */ import cn.com.hd.service.BaseService;
/*     */ import cn.com.hd.service.IService;
/*     */ import cn.com.hd.transfer.RegisterObject;
/*     */ import cn.com.hd.transfer.Request;
/*     */ import cn.com.hd.transfer.Response;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ 
/*     */ public class LogAddService extends BaseService
/*     */   implements IService
/*     */ {
/*     */   public Response service(Request request)
/*     */     throws Exception
/*     */   {
/*  27 */     TLog logInfo = new TLog();
/*     */ 
/*  29 */     super.getData(request.getDto(), logInfo);
/*     */ 
/*  32 */     if (logInfo.getLogid() == null) {
/*  33 */       logInfo.setLogid(UUID.randomUUID().toString());
/*     */     }
/*     */ 
/*  36 */     if (logInfo.getLogdate() == null) {
/*  37 */       logInfo.setLogdate(new Date());
/*     */     }
/*     */ 
/*  40 */     int result = save(logInfo);
/*     */ 
/*  42 */     Response response = new Response();
/*  43 */     response.setResult(Integer.valueOf(result));
/*     */ 
/*  45 */     return response;
/*     */   }
/*     */ 
/*     */   protected int save(BaseDTO dto) throws Exception {
/*  49 */     PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*  50 */     StringBuffer sStrBuf = new StringBuffer();
/*  51 */     StringBuffer sStrBufColumn = new StringBuffer();
/*  52 */     StringBuffer sStrBufValue = new StringBuffer();
/*  53 */     StringBuffer sStrParameter = new StringBuffer();
/*     */     try
/*     */     {
/*  56 */       ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/*  57 */       if (cmMap == null) {
/*  58 */         Debug.errorMessage("no registed class name as " + dto.getClass().getName());
/*  59 */         return -1;
/*     */       }
/*     */ 
/*  62 */       sStrBuf.append("INSERT INTO ").append(cmMap.getTableName()).append(" ");
/*  63 */       PropertyMapping[] ids = cmMap.getId();
/*  64 */       List props = cmMap.getListProperty();
/*  65 */       for (int i = 0; i < ids.length; i++) {
/*  66 */         PropertyMapping id = ids[i];
/*  67 */         Object value = dto.getPropertyValue(id.getName());
/*  68 */         if ((value == null) && (id.getGenerate() != null)) {
/*  69 */           if (id.getGenerate().equals("UUID")) {
/*  70 */             value = UUID.randomUUID().toString();
/*  71 */           } else if (id.getGenerate().equals("SEQUENCE")) {
/*  72 */             String seqSql = "SELECT " + id.getGeneratevalue() + ".NEXTVAL FROM DUAL";
/*  73 */             Debug.debugMessage("id sequence gengerate sql: " + seqSql);
/*  74 */             SelectResultSet idResultSet = this.dbOperator.executeSelect(seqSql);
/*  75 */             value = Long.valueOf(idResultSet.getLongValue(0, 0));
/*  76 */             Debug.debugMessage("id sequence gengerate value: " + value);
/*     */           }
/*     */         }
/*     */ 
/*  80 */         if (sStrBufColumn.length() == 0) {
/*  81 */           sStrBufColumn.append(id.getColumnName());
/*  82 */           sStrBufValue.append("?");
/*     */ 
/*  84 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(id.getType()).getInt(null)).intValue(), value);
/*  85 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*  86 */           sStrParameter.append(id.getName()).append(":").append(value);
/*     */         } else {
/*  88 */           sStrBufColumn.append(", ").append(id.getColumnName());
/*  89 */           sStrBufValue.append(", ?");
/*  90 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(id.getType()).getInt(null)).intValue(), value);
/*  91 */           sStrParameter.append(", ").append(id.getName()).append(":").append(value);
/*  92 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*     */         }
/*     */       }
/*     */ 
/*  96 */       for (int i = 0; i < props.size(); i++) {
/*  97 */         PropertyMapping prop = (PropertyMapping)props.get(i);
/*  98 */         if (dto.getPropertyValue(prop.getName()) != null) {
/*  99 */           Object value = dto.getPropertyValue(prop.getName());
/* 100 */           if (sStrBufColumn.length() == 0) {
/* 101 */             sStrBufColumn.append(prop.getColumnName());
/* 102 */             sStrBufValue.append("?");
/* 103 */             psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/* 104 */             sStrParameter.append(prop.getName()).append(":").append(value);
/* 105 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*     */           } else {
/* 107 */             sStrBufColumn.append(", ").append(prop.getColumnName());
/* 108 */             sStrBufValue.append(", ?");
/* 109 */             psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/* 110 */             sStrParameter.append(", ").append(prop.getName()).append(":").append(value);
/* 111 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 116 */       sStrBuf.append(" ( ").append(sStrBufColumn).append(" ) VALUES (").append(sStrBufValue).append(" ) ");
/*     */ 
/* 118 */       Debug.debugMessage("sql ====== " + sStrBuf.toString());
/*     */ 
/* 120 */       psOperator.setSql(sStrBuf.toString());
/*     */ 
/* 122 */       int result = this.dbOperator.executePreparedStatement(psOperator);
/*     */ 
/* 124 */       return result;
/*     */     } catch (Exception ex) {
/* 126 */       ErrorProcessor.prompt(getClass().getName(), "save() error", ex);
/* 127 */     }throw new SystemException(ex.getMessage());
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDLog.jar
 * Qualified Name:     cn.com.hd.log.logmanage.LogAddService
 * JD-Core Version:    0.6.0
 */