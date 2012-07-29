/*    */ package cn.com.hd.dto.priv;
/*    */ 
/*    */ import cn.com.hd.service.BaseDTO;
/*    */ 







/*    */ public class TUserRole extends BaseDTO
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private String userid;
/*    */   private String roleid;
/*    */ 
/*    */   public String getUserid()
/*    */   {
/* 20 */     return this.userid;
/*    */   }
/*    */ 
/*    */   public void setUserid(String userid) {
/* 24 */     this.userid = userid;
/*    */   }
/*    */ 
/*    */   public String getRoleid() {
/* 28 */     return this.roleid;
/*    */   }
/*    */ 
/*    */   public void setRoleid(String roleid) {
/* 32 */     this.roleid = roleid;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.dto.priv.TUserRole
 * JD-Core Version:    0.6.0
 */