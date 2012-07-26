/*    */ package cn.com.hd.dict.dictmanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.dict.TDictDetail;
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Conditions;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.Date;
/*    */ import java.util.UUID;
/*    */ 
/*    */ public class DictAddService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 18 */     Response response = new Response();
/*    */ 
/* 21 */     TDictDetail dictdetail = new TDictDetail();
/* 22 */     super.getData(request.getDto(), dictdetail);
/*    */ 
/* 24 */     Debug.debugMessage(1, request, dictdetail.toString());
/*    */ 
/* 26 */     if (dictdetail.getTypeid() == null) {
/* 27 */       response.setRequestParam(request.getDto());
/* 28 */       response.setResult(Integer.valueOf(0));
/* 29 */       response.getDto().setList("RESULT", getDTO(dictdetail));
/* 30 */       response.setErrorInfo("字典代码或字典分类代码为空，保存失败");
/* 31 */       return response;
/*    */     }
/*    */ 
/* 34 */     Conditions cons = new Conditions();
/* 35 */     cons.addCondition(new TDictDetail());
/* 36 */     cons.addExpression("TYPE_ID = '" + dictdetail.getTypeid() + "' AND DICT_NAME = '" + dictdetail.getDictname() + "'");
/* 37 */     SelectResultSet rs = queryResultSet(cons);
/* 38 */     if (rs.getRowCount() > 0) {
/* 39 */       response.setRequestParam(request.getDto());
/* 40 */       response.setResult(Integer.valueOf(0));
/* 41 */       response.getDto().setList("RESULT", getDTO(dictdetail));
/* 42 */       response.setErrorInfo("名称已存在，请重新填写");
/* 43 */       return response;
/*    */     }
/*    */ 
/* 47 */     dictdetail.setDictcode(UUID.randomUUID().toString());
/* 48 */     dictdetail.setCreatorid(this.loginInfo.getUserid());
/* 49 */     dictdetail.setCreatorname(this.loginInfo.getUsername());
/* 50 */     dictdetail.setCreatedate(new Date());
/*    */ 
/* 52 */     dictdetail.setOperatorid(this.loginInfo.getUserid());
/* 53 */     dictdetail.setOperatorname(this.loginInfo.getUsername());
/* 54 */     dictdetail.setOperatdate(new Date());
/*    */ 
/* 56 */     int result = super.save(dictdetail);
/*    */ 
/* 58 */     response.setRequestParam(request.getDto());
/* 59 */     response.getDto().setList("RESULT", getDTO(dictdetail));
/* 60 */     response.setResult(Integer.valueOf(result));
/*    */ 
/* 62 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.dictmanage.DictAddService
 * JD-Core Version:    0.6.0
 */