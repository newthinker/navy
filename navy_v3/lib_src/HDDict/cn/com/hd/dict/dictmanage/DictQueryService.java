/*    */ package cn.com.hd.dict.dictmanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.dict.TDictDetail;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Conditions;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.PageInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DictQueryService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 18 */     TDictDetail dictdetail = new TDictDetail();
/*    */ 
/* 20 */     super.getQueryData(request.getDto(), dictdetail);
/*    */ 
/* 22 */     PageInfo page = super.getPageInfo();
/*    */ 
/* 24 */     Conditions cons = new Conditions();
/* 25 */     cons.addCondition(dictdetail, "dict_order", true);
/* 26 */     SelectResultSet result = super.queryResultSet(page, cons);
/*    */ 
/* 28 */     List list = super.getDTO(result);
/*    */ 
/* 30 */     Response resp = new Response();
/* 31 */     resp.getDto().setList("RESULT", list);
/* 32 */     resp.setPageInfo(page);
/* 33 */     resp.setRequestParam(request.getDto());
/*    */ 
/* 35 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.dictmanage.DictQueryService
 * JD-Core Version:    0.6.0
 */