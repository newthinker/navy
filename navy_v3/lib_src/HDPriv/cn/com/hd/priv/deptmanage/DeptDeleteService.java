/*    */ package cn.com.hd.priv.deptmanage;
/*    */ 
/*    */ import cn.com.hd.dto.priv.TDept;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ 
/*    */ public class DeptDeleteService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 12 */     Response response = new Response();
/*    */ 
/* 14 */     TDept dept = new TDept();
/* 15 */     super.getData(request.getDto(), dept);
/*    */ 
/* 17 */     if (dept.getDeptid() == null) {
/* 18 */       response.setRequestParam(request.getDto());
/* 19 */       response.setResult(Integer.valueOf(0));
/* 20 */       response.getDto().setList("RESULT", getDTO(dept));
/* 21 */       response.setErrorInfo("部门 ID 为空，删除失败");
/* 22 */       return response;
/*    */     }
/*    */ 
/* 25 */     int result = super.delete(dept);
/*    */ 
/* 27 */     response.setRequestParam(request.getDto());
/* 28 */     response.setResult(Integer.valueOf(result));
/*    */ 
/* 30 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.deptmanage.DeptDeleteService
 * JD-Core Version:    0.6.0
 */