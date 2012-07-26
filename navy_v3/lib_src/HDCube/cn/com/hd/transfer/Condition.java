/*     */ package cn.com.hd.transfer;
/*     */ 
/*     */ import cn.com.hd.dto.ClassMapping;
/*     */ import cn.com.hd.dto.PropertyMapping;
/*     */ import cn.com.hd.error.Debug;
/*     */ import cn.com.hd.service.BaseDTO;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Condition
/*     */ {
/*     */   private BaseDTO condition;
/*     */   private List<String> orderField;
/*     */   private List<String> selectField;
/*     */   private List<String[]> statSelectField;
/*     */   private List<String> groupField;
/*     */ 
/*     */   public Condition()
/*     */   {
/*  56 */     this.orderField = new ArrayList();
/*  57 */     this.selectField = new ArrayList();
/*  58 */     this.statSelectField = new ArrayList();
/*  59 */     this.groupField = new ArrayList();
/*     */   }
/*     */ 
/*     */   public void addStatSelectField(String fieldName, String statType)
/*     */   {
/*  64 */     this.statSelectField.add(new String[] { fieldName, statType });
/*     */   }
/*     */ 
/*     */   public void addGroupField(String fieldName) {
/*  68 */     this.groupField.add(fieldName);
/*     */   }
/*     */ 
/*     */   public void addOrderField(String fieldName, boolean asc)
/*     */   {
/*  78 */     this.orderField.add(fieldName + " " + (asc ? "asc" : "desc"));
/*     */   }
/*     */ 
/*     */   public void addSelectField(String fieldName)
/*     */   {
/*  87 */     this.selectField.add(fieldName);
/*     */   }
/*     */ 
/*     */   public void clearOrderField()
/*     */   {
/*  94 */     this.orderField.clear();
/*     */   }
/*     */ 
/*     */   public void clearSelectField()
/*     */   {
/* 101 */     this.selectField.clear();
/*     */   }
/*     */ 
/*     */   public String getDTOName()
/*     */   {
/* 110 */     return ((ClassMapping)RegisterObject.DTOInfo.get(this.condition.getClass().getName())).getTableName();
/*     */   }
/*     */ 
/*     */   public BaseDTO getCondition()
/*     */   {
/* 119 */     return this.condition;
/*     */   }
/*     */ 
/*     */   public List<String> getOrderField()
/*     */   {
/* 128 */     return this.orderField;
/*     */   }
/*     */ 
/*     */   public String getOrderHql(String alias)
/*     */   {
/* 139 */     if (this.orderField == null) {
/* 140 */       return "";
/*     */     }
/*     */ 
/* 143 */     StringBuffer orderHql = new StringBuffer();
/* 144 */     for (int i = 0; i < this.orderField.size(); i++) {
/* 145 */       String order = (String)this.orderField.get(i);
/* 146 */       if (orderHql.length() == 0)
/* 147 */         orderHql.append(alias).append(".").append(order);
/*     */       else {
/* 149 */         orderHql.append(", ").append(alias).append(".").append(order);
/*     */       }
/*     */     }
/*     */ 
/* 153 */     return orderHql.toString();
/*     */   }
/*     */ 
/*     */   public List<String> getSelectField()
/*     */   {
/* 162 */     return this.selectField;
/*     */   }
/*     */ 
/*     */   public String getWhereHql(String alias, List<Object> params)
/*     */   {
/* 174 */     StringBuffer whereHql = new StringBuffer();
/* 175 */     createHqlAndPara(this.condition, whereHql, params, alias + ".");
/*     */ 
/* 177 */     return whereHql.toString();
/*     */   }
/*     */ 
/*     */   public String getSelectHql(String alias)
/*     */   {
/* 188 */     StringBuffer selectHql = new StringBuffer();
/* 189 */     ClassMapping cMap = (ClassMapping)RegisterObject.DTOInfo.get(this.condition.getClass().getName());
/*     */ 
/* 191 */     if (this.selectField == null) {
/* 192 */       return null;
/*     */     }
/*     */ 
/* 195 */     if (this.selectField.size() == 0) {
/* 196 */       return alias + ".*";
/*     */     }
/*     */ 
/* 199 */     for (int i = 0; i < this.selectField.size(); i++) {
/* 200 */       String select = (String)this.selectField.get(i);
/*     */ 
/* 202 */       if ((select.endsWith("Before")) || (select.endsWith("After"))) {
/*     */         continue;
/*     */       }
/* 205 */       for (int j = 0; j < cMap.getId().length; j++) {
/* 206 */         if (cMap.getId()[j].getName().equals(select)) {
/* 207 */           if (selectHql.length() == 0)
/* 208 */             selectHql.append(alias).append(".").append(cMap.getId()[j].getColumnName());
/*     */           else {
/* 210 */             selectHql.append(", ").append(alias).append(".").append(cMap.getId()[j].getColumnName());
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 215 */       for (int j = 0; j < cMap.getListProperty().size(); j++) {
/* 216 */         if (((PropertyMapping)cMap.getListProperty().get(j)).getName().equals(select)) {
/* 217 */           if (selectHql.length() == 0)
/* 218 */             selectHql.append(alias).append(".").append(((PropertyMapping)cMap.getListProperty().get(j)).getColumnName());
/*     */           else {
/* 220 */             selectHql.append(", ").append(alias).append(".").append(((PropertyMapping)cMap.getListProperty().get(j)).getColumnName());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 226 */     return selectHql.toString();
/*     */   }
/*     */ 
/*     */   public String getGroupHql(String alias)
/*     */   {
/* 237 */     StringBuffer groupHql = new StringBuffer();
/* 238 */     ClassMapping cMap = (ClassMapping)RegisterObject.DTOInfo.get(this.condition.getClass().getName());
/*     */ 
/* 240 */     if (this.groupField == null) {
/* 241 */       return null;
/*     */     }
/*     */ 
/* 244 */     if (this.groupField.size() == 0) {
/* 245 */       return null;
/*     */     }
/*     */ 
/* 248 */     for (int i = 0; i < this.groupField.size(); i++) {
/* 249 */       String group = (String)this.groupField.get(i);
/*     */ 
/* 251 */       for (int j = 0; j < cMap.getId().length; j++) {
/* 252 */         if (cMap.getId()[j].getName().equals(group)) {
/* 253 */           if (i == 0)
/* 254 */             groupHql.append(alias).append(".").append(cMap.getId()[j].getColumnName());
/*     */           else {
/* 256 */             groupHql.append(", ").append(alias).append(".").append(cMap.getId()[j].getColumnName());
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 261 */       for (int j = 0; j < cMap.getListProperty().size(); j++) {
/* 262 */         if (((PropertyMapping)cMap.getListProperty().get(j)).getName().equals(group)) {
/* 263 */           if (i == 0)
/* 264 */             groupHql.append(alias).append(".").append(((PropertyMapping)cMap.getListProperty().get(j)).getColumnName());
/*     */           else {
/* 266 */             groupHql.append(", ").append(alias).append(".").append(((PropertyMapping)cMap.getListProperty().get(j)).getColumnName());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 272 */     return groupHql.toString();
/*     */   }
/*     */ 
/*     */   public String getStatSelectHql(String alias) {
/* 276 */     if (this.statSelectField == null) {
/* 277 */       return null;
/*     */     }
/*     */ 
/* 280 */     if (this.statSelectField.size() == 0) {
/* 281 */       return null;
/*     */     }
/*     */ 
/* 284 */     StringBuffer statSelectHql = new StringBuffer();
/* 285 */     for (int i = 0; i < this.statSelectField.size(); i++) {
/* 286 */       String[] strs = (String[])this.statSelectField.get(i);
/*     */ 
/* 288 */       if (i == 0)
/* 289 */         statSelectHql.append(strs[1]).append("(").append(alias).append(".").append(strs[0]).append(")");
/*     */       else {
/* 291 */         statSelectHql.append(", ").append(strs[1]).append("(").append(alias).append(".").append(strs[0]).append(")");
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 296 */     return statSelectHql.toString();
/*     */   }
/*     */ 
/*     */   public void setCondition(BaseDTO condition)
/*     */   {
/* 305 */     this.condition = condition;
/*     */   }
/*     */ 
/*     */   public void setOrderField(List<String> orderField)
/*     */   {
/* 314 */     this.orderField = orderField;
/*     */   }
/*     */ 
/*     */   public void setSelectField(List<String> selectField)
/*     */   {
/* 323 */     this.selectField = selectField;
/*     */   }
/*     */ 
/*     */   private void createHqlAndPara(BaseDTO dto, StringBuffer hql, List<Object> params, String align)
/*     */   {
/* 336 */     Field[] fields = dto.getClass().getDeclaredFields();
/* 337 */     ClassMapping cMap = (ClassMapping)RegisterObject.DTOInfo.get(this.condition.getClass().getName());
/* 338 */     for (int i = 0; i < fields.length; i++)
/*     */       try {
/* 340 */         Field field = fields[i];
/*     */ 
/* 342 */         Object obj = dto.getPropertyValue(field.getName());
/*     */ 
/* 344 */         if ((obj instanceof Collection))
/*     */         {
/*     */           continue;
/*     */         }
/* 348 */         if ((obj != null) && (!obj.equals(""))) {
/* 349 */           StringBuffer bufName = new StringBuffer(fields[i].getName());
/* 350 */           if (((obj instanceof String)) && 
/* 351 */             (!bufName.toString().toLowerCase().endsWith("id"))) {
/* 352 */             for (int j = 0; j < cMap.getId().length; j++) {
/* 353 */               if (cMap.getId()[j].getName().equals(fields[i].getName())) {
/* 354 */                 hql.append(" and " + align + cMap.getId()[j].getColumnName() + " = ?");
/* 355 */                 params.add(obj);
/*     */               }
/*     */             }
/*     */ 
/* 359 */             for (int j = 0; j < cMap.getListProperty().size(); j++) {
/* 360 */               if (((PropertyMapping)cMap.getListProperty().get(j)).getName().equals(fields[i].getName()))
/* 361 */                 if (((PropertyMapping)cMap.getListProperty().get(j)).getName().toUpperCase().endsWith("ID")) {
/* 362 */                   hql.append(" and " + align + ((PropertyMapping)cMap.getListProperty().get(j)).getColumnName() + " = ?");
/* 363 */                   params.add(obj);
/*     */                 } else {
/* 365 */                   hql.append(" and " + align + ((PropertyMapping)cMap.getListProperty().get(j)).getColumnName() + " like ?");
/* 366 */                   params.add("%" + obj + "%");
/*     */                 }
/*     */             }
/*     */           }
/* 370 */           else if ((obj instanceof Date)) {
/* 371 */             String exp = " = ?";
/* 372 */             if (field.getName().endsWith("Before")) {
/* 373 */               exp = " >= ?";
/*     */             }
/*     */ 
/* 376 */             if (field.getName().endsWith("After")) {
/* 377 */               exp = " <= ?";
/*     */             }
/*     */ 
/* 380 */             for (int j = 0; j < cMap.getId().length; j++) {
/* 381 */               if (cMap.getId()[j].getName().equals(fields[i].getName())) {
/* 382 */                 hql.append(" and " + align + cMap.getId()[j].getColumnName() + exp);
/* 383 */                 params.add(obj);
/*     */               }
/*     */             }
/*     */ 
/* 387 */             for (int j = 0; j < cMap.getListProperty().size(); j++)
/* 388 */               if (((PropertyMapping)cMap.getListProperty().get(j)).getName().equals(fields[i].getName())) {
/* 389 */                 hql.append(" and " + align + ((PropertyMapping)cMap.getListProperty().get(j)).getColumnName() + exp);
/* 390 */                 params.add(obj);
/*     */               }
/*     */           }
/*     */           else {
/* 394 */             for (int j = 0; j < cMap.getId().length; j++) {
/* 395 */               if (cMap.getId()[j].getName().equals(fields[i].getName())) {
/* 396 */                 hql.append(" and " + align + cMap.getId()[j].getColumnName() + " = ?");
/* 397 */                 params.add(obj);
/*     */               }
/*     */             }
/*     */ 
/* 401 */             for (int j = 0; j < cMap.getListProperty().size(); j++) {
/* 402 */               if (((PropertyMapping)cMap.getListProperty().get(j)).getName().equals(fields[i].getName())) {
/* 403 */                 hql.append(" and " + align + ((PropertyMapping)cMap.getListProperty().get(j)).getColumnName() + " = ?");
/* 404 */                 params.add(obj);
/*     */               }
/*     */             }
/*     */           }
/*     */ 
/* 409 */           if (!(obj instanceof BaseDTO))
/* 410 */             Debug.debugMessage("add param " + fields[i].getName() + " = " + obj.toString());
/*     */         }
/*     */       }
/*     */       catch (Exception e) {
/* 414 */         e.printStackTrace();
/*     */       }
/*     */   }
/*     */ 
/*     */   public List<String> getGroupField()
/*     */   {
/* 420 */     return this.groupField;
/*     */   }
/*     */ 
/*     */   public void setGroupField(List<String> groupField) {
/* 424 */     this.groupField = groupField;
/*     */   }
/*     */ 
/*     */   public List<String[]> getStatSelectField() {
/* 428 */     return this.statSelectField;
/*     */   }
/*     */ 
/*     */   public void setStatSelectField(List<String[]> statSelectField) {
/* 432 */     this.statSelectField = statSelectField;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.Condition
 * JD-Core Version:    0.6.0
 */