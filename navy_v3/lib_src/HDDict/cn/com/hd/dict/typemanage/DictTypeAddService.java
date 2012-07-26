/*    */ package cn.com.hd.dict.typemanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.dict.TDictType;
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.error.ErrorProcessor;
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
/*    */ public class DictTypeAddService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 19 */     Response response = new Response();
/*    */ 
/* 22 */     TDictType dicttype = new TDictType();
/* 23 */     super.getData(request.getDto(), dicttype);
/* 24 */     Debug.debugMessage(1, request, dicttype.toString());
/*    */ 
/* 26 */     Conditions cons = new Conditions();
/* 27 */     cons.addCondition(new TDictType());
/* 28 */     cons.addExpression("dto1.type_name = '" + dicttype.getTypename() + "'");
/*    */ 
/* 30 */     SelectResultSet selectResultSet = super.queryResultSet(cons);
/* 31 */     if (selectResultSet.getRowCount() > 0) {
/* 32 */       response.setRequestParam(request.getDto());
/* 33 */       response.setResult(Integer.valueOf(0));
/* 34 */       response.getDto().setList("RESULT", getDTO(dicttype));
/* 35 */       response.setErrorInfo("分类名称已存在！");
/* 36 */       return response;
/*    */     }
/*    */ 
/* 40 */     dicttype.setTypeid(UUID.randomUUID().toString());
/* 41 */     dicttype.setCreatorid(this.loginInfo.getUserid());
/* 42 */     dicttype.setCreatorname(this.loginInfo.getUsername());
/* 43 */     dicttype.setCreatedate(new Date());
/* 44 */     dicttype.setValidated("Y");
/*    */ 
/* 46 */     int result = 0;
/*    */     try {
/* 48 */       result = super.save(dicttype);
/*    */     } catch (Exception ex) {
/* 50 */       ErrorProcessor.prompt(getClass().getName(), "保存失败", ex);
/*    */     }
/*    */ 
/* 53 */     response.setRequestParam(request.getDto());
/* 54 */     response.setResult(Integer.valueOf(result));
/* 55 */     response.getDto().setList("RESULT", getDTO(dicttype));
/*    */ 
/* 57 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.typemanage.DictTypeAddService
 * JD-Core Version:    0.6.0
 */