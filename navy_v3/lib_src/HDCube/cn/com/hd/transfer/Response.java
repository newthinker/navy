/*    */ package cn.com.hd.transfer;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Response implements Serializable {
/*    */   private static final long serialVersionUID = 1616744329809564283L;
/*    */   String errorInfo;
/*    */   DTO dto;
/*    */ 
/*    */   public Response()
/*    */   {
/* 12 */     this.errorInfo = null;
/* 13 */     this.dto = new DTO();
/*    */   }
/*    */ 
/*    */   public String toXMLString() {
/* 17 */     StringBuffer strBuffer = new StringBuffer();
/* 18 */     strBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
/* 19 */     strBuffer.append("<Response>");
/*    */ 
/* 21 */     strBuffer.append("<header>");
/* 22 */     strBuffer.append("<errorInfo>" + this.errorInfo + "</errorInfo>");
/* 23 */     strBuffer.append("</header>");
/*    */ 
/* 25 */     if (this.dto != null) {
/* 26 */       strBuffer.append(this.dto.toXMLString());
/*    */     }
/* 28 */     strBuffer.append("</Response>");
/* 29 */     return strBuffer.toString();
/*    */   }
/*    */ 
/*    */   public DTO getRequestParam() {
/* 33 */     return (DTO)this.dto.get("REQUEST_PARAM");
/*    */   }
/*    */ 
/*    */   public void setRequestParam(DTO dtoParam) {
/* 37 */     this.dto.put("REQUEST_PARAM", dtoParam);
/*    */   }
/*    */ 
/*    */   public Integer getResult() {
/* 41 */     return (Integer)this.dto.get("RESULT");
/*    */   }
/*    */ 
/*    */   public void setResult(Integer result) {
/* 45 */     this.dto.put("RESULT", result);
/*    */   }
/*    */ 
/*    */   public PageInfo getPageInfo() {
/* 49 */     return (PageInfo)this.dto.get("PAGEINFO");
/*    */   }
/*    */ 
/*    */   public void setPageInfo(PageInfo pageinfo) {
/* 53 */     this.dto.put("PAGEINFO", pageinfo);
/*    */   }
/*    */ 
/*    */   public DTO getDto() {
/* 57 */     return this.dto;
/*    */   }
/*    */   public void setDto(DTO dto) {
/* 60 */     this.dto = dto;
/*    */   }
/*    */   public String getErrorInfo() {
/* 63 */     return this.errorInfo;
/*    */   }
/*    */   public void setErrorInfo(String errorInfo) {
/* 66 */     if (errorInfo != null)
/* 67 */       this.errorInfo = errorInfo.replaceAll("\n", "");
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.Response
 * JD-Core Version:    0.6.0
 */