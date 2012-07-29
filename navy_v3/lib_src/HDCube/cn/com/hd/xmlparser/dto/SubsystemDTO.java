/*    */ package cn.com.hd.xmlparser.dto;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class SubsystemDTO {
/*  6 */   private HashMap<String, String> serviceList = new HashMap();
/*    */ 
/*    */   public HashMap<String, String> getServiceList() {
/*  9 */     return this.serviceList;
/*    */   }
/*    */ 
/*    */   public void setServiceList(HashMap<String, String> subsystemList) {
/* 13 */     this.serviceList = subsystemList;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.xmlparser.dto.SubsystemDTO
 * JD-Core Version:    0.6.0
 */