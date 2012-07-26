/*     */ package cn.com.hd.transfer;
/*     */ 
/*     */ import cn.com.hd.service.BaseDTO;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Conditions
/*     */ {
/*     */   public static final String CON_STAT_SUM = "sum";
/*     */   public static final String CON_STAT_AVG = "avg";
/*     */   public static final String CON_STAT_COUNT = "count";
/*     */   public static final String CON_STAT_MAX = "max";
/*     */   public static final String CON_STAT_MIN = "min";
/*     */   private List<Condition> conditions;
/*     */   private List<Object> expParam;
/*     */   private List<String> expression;
/*     */ 
/*     */   public Conditions()
/*     */   {
/*  51 */     this.conditions = new ArrayList();
/*  52 */     this.expression = new ArrayList();
/*  53 */     this.expParam = new ArrayList();
/*     */   }
/*     */ 
/*     */   public void addCondition(BaseDTO dto)
/*     */   {
/*  62 */     Condition condition = new Condition();
/*  63 */     condition.setCondition(dto);
/*  64 */     this.conditions.add(condition);
/*     */   }
/*     */ 
/*     */   public void addCondition(BaseDTO dto, String orderField, boolean asc)
/*     */   {
/*  75 */     addCondition(dto, new String[0], new String[] { orderField }, new boolean[] { asc });
/*     */   }
/*     */ 
/*     */   public void addCondition(BaseDTO dto, String[] selectedFields)
/*     */   {
/*  85 */     addCondition(dto, selectedFields, null, null);
/*     */   }
/*     */ 
/*     */   public void addCondition(BaseDTO dto, String[] orderFields, boolean[] ascs)
/*     */   {
/*  96 */     addCondition(dto, new String[0], orderFields, ascs);
/*     */   }
/*     */ 
/*     */   public void addCondition(BaseDTO dto, String[] selectedFields, String[] orderFields, boolean[] ascs)
/*     */   {
/* 108 */     Condition condition = new Condition();
/* 109 */     condition.setCondition(dto);
/* 110 */     if (selectedFields == null)
/* 111 */       condition.setSelectField(null);
/*     */     else {
/* 113 */       for (String field : selectedFields) {
/* 114 */         condition.addSelectField(field);
/*     */       }
/*     */     }
/*     */ 
/* 118 */     if (orderFields == null)
/* 119 */       condition.setOrderField(null);
/*     */     else {
/* 121 */       for (int i = 0; i < orderFields.length; i++) {
/* 122 */         boolean asc = true;
/*     */         int j;
/* 123 */         if ((ascs != null) && (i < ascs.length)) {
/* 124 */           j = ascs[i];
/*     */         }
/*     */ 
/* 127 */         condition.addOrderField(orderFields[i], j);
/*     */       }
/*     */     }
/*     */ 
/* 131 */     this.conditions.add(condition);
/*     */   }
/*     */ 
/*     */   public void addCondition(Condition condition)
/*     */   {
/* 140 */     this.conditions.add(condition);
/*     */   }
/*     */ 
/*     */   public void addExpression(String expression)
/*     */   {
/* 149 */     this.expression.add(expression);
/*     */   }
/*     */ 
/*     */   public void addExpression(String expression, Object param)
/*     */   {
/* 158 */     this.expression.add(expression);
/*     */ 
/* 160 */     if ((param != null) && (!param.equals("")))
/* 161 */       this.expParam.add(param);
/*     */   }
/*     */ 
/*     */   public void addStatCondition(BaseDTO dto, String selectedField, String statType)
/*     */   {
/* 166 */     String[] selectedFields = { selectedField == null ? null : selectedField };
/* 167 */     String[] statTypes = { statType == null ? null : statType };
/* 168 */     String[] groupFields = (String[])null;
/* 169 */     addStatCondition(dto, selectedFields, statTypes, groupFields);
/*     */   }
/*     */ 
/*     */   public void addStatCondition(BaseDTO dto, String selectedField, String statType, String groupField) {
/* 173 */     String[] selectedFields = { selectedField == null ? null : selectedField };
/* 174 */     String[] statTypes = { statType == null ? null : statType };
/* 175 */     String[] groupFields = { groupField == null ? null : groupField };
/*     */ 
/* 177 */     addStatCondition(dto, selectedFields, statTypes, groupFields);
/*     */   }
/*     */ 
/*     */   public void addStatCondition(BaseDTO dto, String selectedField, String statType, String[] groupFields) {
/* 181 */     String[] selectedFields = { selectedField == null ? null : selectedField };
/* 182 */     String[] statTypes = { statType == null ? null : statType };
/*     */ 
/* 184 */     addStatCondition(dto, selectedFields, statTypes, groupFields);
/*     */   }
/*     */ 
/*     */   public void addStatCondition(BaseDTO dto, String[] selectedFields, String[] statTypes) {
/* 188 */     String[] groupFields = (String[])null;
/*     */ 
/* 190 */     addStatCondition(dto, selectedFields, statTypes, groupFields);
/*     */   }
/*     */ 
/*     */   public void addStatCondition(BaseDTO dto, String[] selectedFields, String[] statTypes, String groupField) {
/* 194 */     String[] groupFields = { groupField == null ? null : groupField };
/*     */ 
/* 196 */     addStatCondition(dto, selectedFields, statTypes, groupFields);
/*     */   }
/*     */ 
/*     */   public void addStatCondition(BaseDTO dto, String[] selectedFields, String[] statTypes, String[] groupFields) {
/* 200 */     Condition con = new Condition();
/* 201 */     con.setCondition(dto);
/*     */ 
/* 203 */     if (selectedFields != null) {
/* 204 */       for (int i = 0; i < selectedFields.length; i++) {
/* 205 */         con.addStatSelectField(selectedFields[i], statTypes[i]);
/*     */       }
/*     */     }
/*     */ 
/* 209 */     if (groupFields != null) {
/* 210 */       for (int i = 0; i < groupFields.length; i++)
/* 211 */         con.addGroupField(groupFields[i]);
/*     */     }
/*     */     else {
/* 214 */       con.setGroupField(null);
/*     */     }
/*     */ 
/* 217 */     this.conditions.add(con);
/*     */   }
/*     */ 
/*     */   public void clear() {
/* 221 */     clearCondition();
/* 222 */     clearExpression();
/*     */   }
/*     */ 
/*     */   public void clearCondition()
/*     */   {
/* 229 */     this.conditions.clear();
/*     */   }
/*     */ 
/*     */   public void clearExpression()
/*     */   {
/* 236 */     this.expression.clear();
/* 237 */     this.expParam.clear();
/*     */   }
/*     */ 
/*     */   public List<Condition> getConditions()
/*     */   {
/* 246 */     return this.conditions;
/*     */   }
/*     */ 
/*     */   public List<Object> getExpParam() {
/* 250 */     return this.expParam;
/*     */   }
/*     */ 
/*     */   public List<String> getExpression()
/*     */   {
/* 259 */     return this.expression;
/*     */   }
/*     */ 
/*     */   public void setConditions(List<Condition> conditions)
/*     */   {
/* 268 */     this.conditions = conditions;
/*     */   }
/*     */ 
/*     */   public void setExpParam(List<Object> expParam) {
/* 272 */     this.expParam = expParam;
/*     */   }
/*     */ 
/*     */   public void setExpression(List<String> expression)
/*     */   {
/* 281 */     this.expression = expression;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.Conditions
 * JD-Core Version:    0.6.0
 */