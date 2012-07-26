/*    */ package cn.com.hd.priv.deptmanage;
/*    */ 
/*    */ import cn.com.hd.dto.priv.TDept;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class DeptUpdateService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 15 */     Response response = new Response();
/*    */ 
/* 17 */     TDept dept = new TDept();
/* 18 */     super.getData(request.getDto(), dept);
/*    */ 
/* 20 */     if (dept.getDeptid() == null) {
/* 21 */       response.setRequestParam(request.getDto());
/* 22 */       response.setResult(Integer.valueOf(0));
/* 23 */       response.getDto().setList("RESULT", getDTO(dept));
/* 24 */       response.setErrorInfo("user id 为空，修改失败");
/* 25 */       return response;
/*    */     }
/*    */ 
/* 28 */     dept.setOperatorid(this.loginInfo.getUserid());
/* 29 */     dept.setOperatorname(this.loginInfo.getUsername());
/* 30 */     dept.setOperatdate(new Date());
/* 31 */     int result = super.update(dept);
/*    */ 
/* 33 */     response.getDto().put("REQUEST_PARAM", request.getDto());
/* 34 */     response.getDto().setList("RESULT", getDTO(dept));
/* 35 */     response.getDto().put("RESULT", Integer.valueOf(result));
/*    */ 
/* 37 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.deptmanage.DeptUpdateService
 * JD-Core Version:    0.6.0
 */