/*     */ package cn.com.hd.dto.log;
/*     */ 
/*     */ import cn.com.hd.service.BaseDTO;
/*     */ import java.util.Date;
/*     */ 









/*     */ public class TLog extends BaseDTO
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   private String logid;
/*     */   private String systemname;
/*     */   private String subsystemname;
/*     */   private String servicename;
/*     */   private String classname;
/*     */   private String operatorid;
/*     */   private String operatorname;
/*     */   private String operatordept;
/*     */   private String logtype;
/*     */   private Date logdate;
/*     */   private String logcontent;
/*     */   private String attributea;
/*     */   private String attributeb;
/*     */   private String attributec;
/*     */   private String attributed;
/*     */   private String attributee;
/*     */ 
/*     */   public String getLogid()
/*     */   {
/*  37 */     return this.logid;
/*     */   }
/*     */ 
/*     */   public void setLogid(String logid) {
/*  41 */     this.logid = logid;
/*     */   }
/*     */ 
/*     */   public String getSystemname() {
/*  45 */     return this.systemname;
/*     */   }
/*     */ 
/*     */   public void setSystemname(String systemname) {
/*  49 */     this.systemname = systemname;
/*     */   }
/*     */ 
/*     */   public String getSubsystemname() {
/*  53 */     return this.subsystemname;
/*     */   }
/*     */ 
/*     */   public void setSubsystemname(String subsystemname) {
/*  57 */     this.subsystemname = subsystemname;
/*     */   }
/*     */ 
/*     */   public String getServicename() {
/*  61 */     return this.servicename;
/*     */   }
/*     */ 
/*     */   public void setServicename(String servicename) {
/*  65 */     this.servicename = servicename;
/*     */   }
/*     */ 
/*     */   public String getClassname() {
/*  69 */     return this.classname;
/*     */   }
/*     */ 
/*     */   public void setClassname(String classname) {
/*  73 */     this.classname = classname;
/*     */   }
/*     */ 
/*     */   public String getOperatorid() {
/*  77 */     return this.operatorid;
/*     */   }
/*     */ 
/*     */   public void setOperatorid(String operatorid) {
/*  81 */     this.operatorid = operatorid;
/*     */   }
/*     */ 
/*     */   public String getOperatorname() {
/*  85 */     return this.operatorname;
/*     */   }
/*     */ 
/*     */   public void setOperatorname(String operatorname) {
/*  89 */     this.operatorname = operatorname;
/*     */   }
/*     */ 
/*     */   public String getOperatordept() {
/*  93 */     return this.operatordept;
/*     */   }
/*     */ 
/*     */   public void setOperatordept(String operatordept) {
/*  97 */     this.operatordept = operatordept;
/*     */   }
/*     */ 
/*     */   public String getLogtype() {
/* 101 */     return this.logtype;
/*     */   }
/*     */ 
/*     */   public void setLogtype(String logtype) {
/* 105 */     this.logtype = logtype;
/*     */   }
/*     */ 
/*     */   public Date getLogdate() {
/* 109 */     return this.logdate;
/*     */   }
/*     */ 
/*     */   public void setLogdate(Date logdate) {
/* 113 */     this.logdate = logdate;
/*     */   }
/*     */ 
/*     */   public String getLogcontent() {
/* 117 */     return this.logcontent;
/*     */   }
/*     */ 
/*     */   public void setLogcontent(String logcontent) {
/* 121 */     this.logcontent = logcontent;
/*     */   }
/*     */ 
/*     */   public String getAttributea() {
/* 125 */     return this.attributea;
/*     */   }
/*     */ 
/*     */   public void setAttributea(String attributea) {
/* 129 */     this.attributea = attributea;
/*     */   }
/*     */ 
/*     */   public String getAttributeb() {
/* 133 */     return this.attributeb;
/*     */   }
/*     */ 
/*     */   public void setAttributeb(String attributeb) {
/* 137 */     this.attributeb = attributeb;
/*     */   }
/*     */ 
/*     */   public String getAttributec() {
/* 141 */     return this.attributec;
/*     */   }
/*     */ 
/*     */   public void setAttributec(String attributec) {
/* 145 */     this.attributec = attributec;
/*     */   }
/*     */ 
/*     */   public String getAttributed() {
/* 149 */     return this.attributed;
/*     */   }
/*     */ 
/*     */   public void setAttributed(String attributed) {
/* 153 */     this.attributed = attributed;
/*     */   }
/*     */ 
/*     */   public String getAttributee() {
/* 157 */     return this.attributee;
/*     */   }
/*     */ 
/*     */   public void setAttributee(String attributee) {
/* 161 */     this.attributee = attributee;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDLog.jar
 * Qualified Name:     cn.com.hd.dto.log.TLog
 * JD-Core Version:    0.6.0
 */