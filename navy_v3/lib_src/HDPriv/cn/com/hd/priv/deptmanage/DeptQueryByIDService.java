/*    */ package cn.com.hd.priv.deptmanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.priv.TDept;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DeptQueryByIDService extends BaseService implements IService {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 16 */     Response resp = new Response();
/* 17 */     TDept dept = new TDept();
/*    */ 
/* 19 */     super.getData(request.getDto(), dept);
/*    */ 
/* 21 */     SelectResultSet result = super.queryResultSet(dept);
/*    */ 
/* 23 */     List list = super.getDTO(result);
/*    */ 
/* 25 */     resp.getDto().setList("RESULT", list);
/* 26 */     resp.setRequestParam(request.getDto());
/*    */ 
/* 28 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.deptmanage.DeptQueryByIDService
 * JD-Core Version:    0.6.0
 */