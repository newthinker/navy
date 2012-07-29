/*    */ package cn.com.hd.dto.priv;
/*    */ 
/*    */ import cn.com.hd.service.BaseDTO;
/*    */ 







/*    */ public class TRoleFunc extends BaseDTO
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String roleid;
/*    */   private String functionid;
/*    */ 
/*    */   public String getRoleid()
/*    */   {
/* 20 */     return this.roleid;
/*    */   }
/*    */ 
/*    */   public void setRoleid(String roleid) {
/* 24 */     this.roleid = roleid;
/*    */   }
/*    */ 
/*    */   public String getFunctionid() {
/* 28 */     return this.functionid;
/*    */   }
/*    */ 
/*    */   public void setFunctionid(String functionid) {
/* 32 */     this.functionid = functionid;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.dto.priv.TRoleFunc
 * JD-Core Version:    0.6.0
 */