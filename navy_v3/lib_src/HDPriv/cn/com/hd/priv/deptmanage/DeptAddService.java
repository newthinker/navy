/*    */ package cn.com.hd.priv.deptmanage;
/*    */ 
/*    */ import cn.com.hd.dto.priv.TDept;
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.Date;
/*    */ import java.util.UUID;
/*    */ 
/*    */ public class DeptAddService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 16 */     Response response = new Response();
/*    */ 
/* 19 */     TDept dept = new TDept();
/* 20 */     super.getData(request.getDto(), dept);
/*    */ 
/* 22 */     Debug.debugMessage(1, request, dept.toString());
/*    */ 
/* 25 */     dept.setDeptid(UUID.randomUUID().toString());
/* 26 */     dept.setCreatorid(this.loginInfo.getUserid());
/* 27 */     dept.setCreatorname(this.loginInfo.getUsername());
/* 28 */     dept.setCreatedate(new Date());
/* 29 */     dept.setValidated("Y");
/*    */ 
/* 31 */     int result = super.save(dept);
/*    */ 
/* 33 */     response.setRequestParam(request.getDto());
/* 34 */     response.getDto().setList("RESULT", getDTO(dept));
/* 35 */     response.setResult(Integer.valueOf(result));
/*    */ 
/* 37 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.deptmanage.DeptAddService
 * JD-Core Version:    0.6.0
 */