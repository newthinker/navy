/*    */ package cn.com.hd.dict.dictmanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.dict.TDictDetail;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DictQueryByIDService extends BaseService  implements IService {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 16 */     TDictDetail dictdetail = new TDictDetail();
/*    */ 
/* 18 */     super.getData(request.getDto(), dictdetail);
/* 19 */     if (dictdetail.getDictcode() == null) {
/* 20 */       dictdetail.setDictcode("-1");
/*    */     }
/*    */ 
/* 23 */     if (dictdetail.getTypeid() == null) {
/* 24 */       dictdetail.setTypeid("-1");
/*    */     }
/*    */ 
/* 27 */     SelectResultSet result = super.queryResultSet(dictdetail);
/*    */ 
/* 29 */     List list = super.getDTO(result);
/*    */ 
/* 31 */     Response resp = new Response();
/* 32 */     resp.getDto().setList("RESULT", list);
/* 33 */     resp.setRequestParam(request.getDto());
/*    */ 
/* 35 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.dictmanage.DictQueryByIDService
 * JD-Core Version:    0.6.0
 */