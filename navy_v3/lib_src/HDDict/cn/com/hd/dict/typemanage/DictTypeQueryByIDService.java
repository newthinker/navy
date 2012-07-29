/*    */ package cn.com.hd.dict.typemanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.dict.TDictType;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DictTypeQueryByIDService extends BaseService implements IService {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 16 */     TDictType dicttype = new TDictType();
/*    */ 
/* 18 */     super.getData(request.getDto(), dicttype);
/*    */ 
/* 20 */     if (dicttype.getTypeid() == null) {
/* 21 */       dicttype.setTypeid("-1");
/*    */     }
/*    */ 
/* 24 */     SelectResultSet result = super.queryResultSet(dicttype);
/*    */ 
/* 26 */     List list = super.getDTO(result);
/*    */ 
/* 28 */     Response resp = new Response();
/* 29 */     resp.getDto().setList("RESULT", list);
/* 30 */     resp.setRequestParam(request.getDto());
/*    */ 
/* 32 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.typemanage.DictTypeQueryByIDService
 * JD-Core Version:    0.6.0
 */