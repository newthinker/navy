/*     */ package cn.com.hd.dto.dict;
/*     */ 
/*     */ import cn.com.hd.service.BaseDTO;
/*     */ import java.util.Date;
/*     */ 
























/*     */ public class TDictType extends BaseDTO
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String typeid;
/*     */   private String typename;
/*     */   private String typeowner;
/*     */   private String typeexplain;
/*     */   private String validated;
/*     */   private Integer typeorder;
/*     */   private String creatorid;
/*     */   private String creatorname;
/*     */   private Date createdate;
/*     */   private String operatorid;
/*     */   private String operatorname;
/*     */   private Date operatdate;
/*     */ 
/*     */   public String getTypename()
/*     */   {
/*  48 */     return this.typename;
/*     */   }
/*     */ 
/*     */   public void setTypename(String typename) {
/*  52 */     this.typename = typename;
/*     */   }
/*     */ 
/*     */   public String getTypeowner() {
/*  56 */     return this.typeowner;
/*     */   }
/*     */ 
/*     */   public void setTypeowner(String typeowner) {
/*  60 */     this.typeowner = typeowner;
/*     */   }
/*     */ 
/*     */   public String getTypeexplain() {
/*  64 */     return this.typeexplain;
/*     */   }
/*     */ 
/*     */   public void setTypeexplain(String typeexplain) {
/*  68 */     this.typeexplain = typeexplain;
/*     */   }
/*     */ 
/*     */   public String getValidated() {
/*  72 */     return this.validated;
/*     */   }
/*     */ 
/*     */   public void setValidated(String validated) {
/*  76 */     this.validated = validated;
/*     */   }
/*     */ 
/*     */   public Integer getTypeorder() {
/*  80 */     return this.typeorder;
/*     */   }
/*     */ 
/*     */   public void setTypeorder(Integer typeorder) {
/*  84 */     this.typeorder = typeorder;
/*     */   }
/*     */ 
/*     */   public String getCreatorid() {
/*  88 */     return this.creatorid;
/*     */   }
/*     */ 
/*     */   public void setCreatorid(String creatorid) {
/*  92 */     this.creatorid = creatorid;
/*     */   }
/*     */ 
/*     */   public String getCreatorname() {
/*  96 */     return this.creatorname;
/*     */   }
/*     */ 
/*     */   public void setCreatorname(String creatorname) {
/* 100 */     this.creatorname = creatorname;
/*     */   }
/*     */ 
/*     */   public Date getCreatedate() {
/* 104 */     return this.createdate;
/*     */   }
/*     */ 
/*     */   public void setCreatedate(Date createdate) {
/* 108 */     this.createdate = createdate;
/*     */   }
/*     */ 
/*     */   public String getOperatorid() {
/* 112 */     return this.operatorid;
/*     */   }
/*     */ 
/*     */   public void setOperatorid(String operatorid) {
/* 116 */     this.operatorid = operatorid;
/*     */   }
/*     */ 
/*     */   public String getOperatorname() {
/* 120 */     return this.operatorname;
/*     */   }
/*     */ 
/*     */   public void setOperatorname(String operatorname) {
/* 124 */     this.operatorname = operatorname;
/*     */   }
/*     */ 
/*     */   public Date getOperatdate() {
/* 128 */     return this.operatdate;
/*     */   }
/*     */ 
/*     */   public void setOperatdate(Date operatdate) {
/* 132 */     this.operatdate = operatdate;
/*     */   }
/*     */ 
/*     */   public String getTypeid() {
/* 136 */     return this.typeid;
/*     */   }
/*     */ 
/*     */   public void setTypeid(String typeid) {
/* 140 */     this.typeid = typeid;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dto.dict.TDictType
 * JD-Core Version:    0.6.0
 */