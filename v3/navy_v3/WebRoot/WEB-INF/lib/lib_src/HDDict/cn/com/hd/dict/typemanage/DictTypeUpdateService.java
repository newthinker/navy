/*    */ package cn.com.hd.dict.typemanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.dict.TDictType;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Conditions;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class DictTypeUpdateService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 17 */     Response response = new Response();
/*    */ 
/* 19 */     TDictType dicttype = new TDictType();
/* 20 */     super.getData(request.getDto(), dicttype);
/*    */ 
/* 22 */     if (dicttype.getTypeid() == null) {
/* 23 */       response.setRequestParam(request.getDto());
/* 24 */       response.setResult(Integer.valueOf(0));
/* 25 */       response.getDto().setList("RESULT", getDTO(dicttype));
/* 26 */       response.setErrorInfo("字典分类代码为空，修改失败");
/* 27 */       return response;
/*    */     }
/*    */ 
/* 30 */     Conditions cons = new Conditions();
/* 31 */     cons.addCondition(new TDictType());
/* 32 */     cons.addExpression("dto1.type_name = '" + dicttype.getTypename() + "' and dto1.type_id <> '" + dicttype.getTypeid() + "'");
/*    */ 
/* 34 */     SelectResultSet selectResultSet = super.queryResultSet(cons);
/* 35 */     if (selectResultSet.getRowCount() > 0) {
/* 36 */       response.setRequestParam(request.getDto());
/* 37 */       response.setResult(Integer.valueOf(0));
/* 38 */       response.getDto().setList("RESULT", getDTO(dicttype));
/* 39 */       response.setErrorInfo("分类名称已存在！");
/* 40 */       return response;
/*    */     }
/*    */ 
/* 43 */     dicttype.setOperatorid(this.loginInfo.getUserid());
/* 44 */     dicttype.setOperatorname(this.loginInfo.getUsername());
/* 45 */     dicttype.setOperatdate(new Date());
/* 46 */     int result = super.update(dicttype);
/*    */ 
/* 48 */     response.getDto().put("REQUEST_PARAM", request.getDto());
/* 49 */     response.getDto().put("RESULT", Integer.valueOf(result));
/* 50 */     response.getDto().setList("RESULT", getDTO(dicttype));
/*    */ 
/* 52 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.typemanage.DictTypeUpdateService
 * JD-Core Version:    0.6.0
 */