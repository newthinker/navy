/*    */ package cn.com.hd.dict.dictmanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.dict.TDictDetail;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Conditions;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class DictUpdateService extends BaseService implements IService {
/*    */   public Response service(Request request) throws Exception
/*    */   {
/* 17 */     Response response = new Response();
/*    */ 
/* 19 */     TDictDetail dictdetail = new TDictDetail();
/* 20 */     super.getData(request.getDto(), dictdetail);
/*    */ 
/* 22 */     if ((dictdetail.getDictcode() == null) || (dictdetail.getTypeid() == null)) {
/* 23 */       response.setRequestParam(request.getDto());
/* 24 */       response.setResult(Integer.valueOf(0));
/* 25 */       response.getDto().setList("RESULT", getDTO(dictdetail));
/* 26 */       response.setErrorInfo("字典代码或字典分类代码为空，修改失败");
/* 27 */       return response;
/*    */     }
/*    */ 
/* 30 */     Conditions cons = new Conditions();
/* 31 */     cons.addCondition(new TDictDetail());
/* 32 */     cons.addExpression("TYPE_ID = '" + dictdetail.getTypeid() + "' AND DICT_NAME = '" + dictdetail.getDictname() + "' AND DICT_CODE != '" + dictdetail.getDictcode() + "'");
/* 33 */     SelectResultSet rs = queryResultSet(cons);
/* 34 */     if (rs.getRowCount() > 0) {
/* 35 */       response.setRequestParam(request.getDto());
/* 36 */       response.setResult(Integer.valueOf(0));
/* 37 */       response.getDto().setList("RESULT", getDTO(dictdetail));
/* 38 */       response.setErrorInfo("名称已存在，请重新填写");
/* 39 */       return response;
/*    */     }
/*    */ 
/* 42 */     dictdetail.setOperatorid(this.loginInfo.getUserid());
/* 43 */     dictdetail.setOperatorname(this.loginInfo.getUsername());
/* 44 */     dictdetail.setOperatdate(new Date());
/* 45 */     int result = super.update(dictdetail);
/*    */ 
/* 47 */     response.getDto().put("REQUEST_PARAM", request.getDto());
/* 48 */     response.getDto().setList("RESULT", getDTO(dictdetail));
/* 49 */     response.getDto().put("RESULT", Integer.valueOf(result));
/*    */ 
/* 51 */     return response;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.dictmanage.DictUpdateService
 * JD-Core Version:    0.6.0
 */