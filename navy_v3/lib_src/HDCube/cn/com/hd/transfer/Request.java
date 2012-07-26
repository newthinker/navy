/*     */ package cn.com.hd.transfer;
/*     */ 
/*     */ import com.jspsmart.upload.SmartUpload;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Request
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -3315819707954468662L;
/*     */   String responseSystemName;
/*     */   String responseSubsystemName;
/*     */   String responseServiceName;
/*     */   String requestSystemName;
/*     */   String requestSubsystemName;
/*     */   String requestActorID;
/*  17 */   DTO dto = null;
/*     */   SmartUpload upload;
/*  20 */   String isremote = "false";
/*     */   String dispatcherUrl;
/*     */ 
/*     */   public Request()
/*     */   {
/*  25 */     this.requestSystemName = null;
/*  26 */     this.requestSubsystemName = null;
/*  27 */     this.requestActorID = null;
/*  28 */     this.dto = new DTO();
/*  29 */     this.upload = null;
/*     */   }
/*     */ 
/*     */   public String toXMLString() {
/*  33 */     StringBuffer strBuffer = new StringBuffer();
/*  34 */     strBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
/*  35 */     strBuffer.append("<Request>");
/*     */ 
/*  37 */     strBuffer.append("<header>");
/*  38 */     strBuffer.append("<responseSystemName>" + this.responseSystemName + "</responseSystemName>");
/*  39 */     strBuffer.append("<responseSubsystemName>" + this.responseSubsystemName + "</responseSubsystemName>");
/*  40 */     strBuffer.append("<responseService>" + this.responseServiceName + "</responseService>");
/*     */ 
/*  42 */     strBuffer.append("<requestSystemName>" + this.requestSystemName + "</requestSystemName>");
/*  43 */     strBuffer.append("<requestSubsystemName>" + this.requestSubsystemName + "</requestSubsystemName>");
/*  44 */     strBuffer.append("<requestActorID>" + this.requestActorID + "</requestActorID>");
/*  45 */     strBuffer.append("<isremote>" + this.isremote + "</isremote>");
/*  46 */     strBuffer.append("<dispatcherUrl>" + this.dispatcherUrl + "</dispatcherUrl>");
/*     */ 
/*  48 */     strBuffer.append("</header>");
/*     */ 
/*  50 */     if (this.dto != null) {
/*  51 */       strBuffer.append(this.dto.toXMLString());
/*     */     }
/*     */ 
/*  54 */     strBuffer.append("</Request>");
/*  55 */     return strBuffer.toString();
/*     */   }
/*     */ 
/*     */   public DTO getDto() {
/*  59 */     return this.dto;
/*     */   }
/*     */ 
/*     */   public void setDto(DTO dto) {
/*  63 */     this.dto = dto;
/*     */   }
/*     */ 
/*     */   public String getRequestActorID() {
/*  67 */     return this.requestActorID;
/*     */   }
/*     */ 
/*     */   public void setRequestActorID(String requestActorID) {
/*  71 */     this.requestActorID = requestActorID;
/*     */   }
/*     */ 
/*     */   public String getRequestSubsystemName() {
/*  75 */     return this.requestSubsystemName;
/*     */   }
/*     */ 
/*     */   public void setRequestSubsystemName(String requestSubsystemName) {
/*  79 */     this.requestSubsystemName = requestSubsystemName;
/*     */   }
/*     */ 
/*     */   public String getRequestSystemName() {
/*  83 */     return this.requestSystemName;
/*     */   }
/*     */ 
/*     */   public void setRequestSystemName(String requestSystemName) {
/*  87 */     this.requestSystemName = requestSystemName;
/*     */   }
/*     */ 
/*     */   public String getResponseServiceName() {
/*  91 */     return this.responseServiceName;
/*     */   }
/*     */ 
/*     */   public void setResponseServiceName(String responseServiceName) {
/*  95 */     this.responseServiceName = responseServiceName;
/*     */   }
/*     */ 
/*     */   public String getResponseSubsystemName() {
/*  99 */     return this.responseSubsystemName;
/*     */   }
/*     */ 
/*     */   public void setResponseSubsystemName(String responseSubsystemName) {
/* 103 */     this.responseSubsystemName = responseSubsystemName;
/*     */   }
/*     */ 
/*     */   public String getResponseSystemName() {
/* 107 */     return this.responseSystemName;
/*     */   }
/*     */ 
/*     */   public void setResponseSystemName(String responseSystemName) {
/* 111 */     this.responseSystemName = responseSystemName;
/*     */   }
/*     */ 
/*     */   public SmartUpload getUpload() {
/* 115 */     return this.upload;
/*     */   }
/*     */ 
/*     */   public void setUpload(SmartUpload upload) {
/* 119 */     this.upload = upload;
/*     */   }
/*     */ 
/*     */   public String getIsremote() {
/* 123 */     return this.isremote;
/*     */   }
/*     */ 
/*     */   public void setIsremote(String isremote) {
/* 127 */     this.isremote = isremote;
/*     */   }
/*     */ 
/*     */   public String getDispatcherUrl() {
/* 131 */     return this.dispatcherUrl;
/*     */   }
/*     */ 
/*     */   public void setDispatcherUrl(String dispatcherUrl) {
/* 135 */     this.dispatcherUrl = dispatcherUrl;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.Request
 * JD-Core Version:    0.6.0
 */