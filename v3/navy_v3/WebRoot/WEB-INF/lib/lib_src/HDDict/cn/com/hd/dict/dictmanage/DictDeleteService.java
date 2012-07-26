/*    */ package cn.com.hd.dict.dictmanage;
/*    */ 
/*    */ import cn.com.hd.dto.dict.TDictDetail;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ 
/*    */ public class DictDeleteService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 12 */     Response response = new Response();
/*    */ 
/* 14 */     TDictDetail dictdetail = new TDictDetail();
/* 15 */     super.getData(request.getDto(), dictdetail);
/* 16 */     String typeid = dictdetail.getTypeid();
/*    */ 
/* 18 */     if ((dictdetail.getDictcode() == null) || (dictdetail.getTypeid() == null)) {
/* 19 */       response.setRequestParam(request.getDto());
/* 20 */       response.setResult(Integer.valueOf(0));
/* 21 */       response.getDto().setList("RESULT", getDTO(dictdetail));
/* 22 */       response.setErrorInfo("字典代码或字典分类代码为空，删除失败");
/* 23 */       return response;
/*    */     }
/*    */ 
/* 26 */     int result = super.delete(dictdetail);
/*    */ 
/* 28 */     dictdetail = new TDictDetail();
/* 29 */     dictdetail.setTypeid(typeid);
/*    */ 
/* 31 */     response.setRequestParam(request.getDto());
/* 32 */     response.getDto().setList("RESULT", getDTO(dictdetail));
/* 33 */     response.setResult(Integer.valueOf(result));
/*    */ 
/* 35 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.dictmanage.DictDeleteService
 * JD-Core Version:    0.6.0
 */