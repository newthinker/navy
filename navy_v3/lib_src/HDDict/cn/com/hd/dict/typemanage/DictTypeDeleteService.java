/*    */ package cn.com.hd.dict.typemanage;
/*    */ 
/*    */ import cn.com.hd.dto.dict.TDictType;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ 
/*    */ public class DictTypeDeleteService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 12 */     Response response = new Response();
/*    */ 
/* 15 */     TDictType dicttype = new TDictType();
/* 16 */     super.getData(request.getDto(), dicttype);
/*    */ 
/* 18 */     if (dicttype.getTypeid() == null) {
/* 19 */       response.setRequestParam(request.getDto());
/* 20 */       response.setResult(Integer.valueOf(0));
/* 21 */       response.getDto().setList("RESULT", getDTO(dicttype));
/* 22 */       response.setErrorInfo("字典分类代码为空，删除失败");
/* 23 */       return response;
/*    */     }
/*    */ 
/* 26 */     int result = super.delete(dicttype);
/*    */ 
/* 28 */     response.setRequestParam(request.getDto());
/* 29 */     response.setResult(Integer.valueOf(result));
/*    */ 
/* 31 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.typemanage.DictTypeDeleteService
 * JD-Core Version:    0.6.0
 */