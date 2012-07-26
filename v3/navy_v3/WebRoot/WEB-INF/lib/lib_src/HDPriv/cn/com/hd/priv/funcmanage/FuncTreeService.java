/*    */ package cn.com.hd.priv.funcmanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.priv.TFunction;
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Conditions;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class FuncTreeService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 19 */     Response response = new Response();
/*    */ 
/* 22 */     TFunction func = new TFunction();
/* 23 */     super.getData(request.getDto(), func);
/*    */ 
/* 25 */     if (func.getFunctionid() == null) {
/* 26 */       func.setFunctionid("-1");
/*    */     }
/*    */ 
/* 29 */     Debug.debugMessage(1, request, func.toString());
/*    */ 
/* 31 */     createTree(response.getDto(), func.getFunctionid());
/*    */ 
/* 33 */     response.setRequestParam(request.getDto());
/*    */ 
/* 35 */     return response;
/*    */   }
/*    */ 
/*    */   protected void createTree(DTO dto, String fathercode) throws Exception
/*    */   {
/* 40 */     Conditions cons = new Conditions();
/* 41 */     cons.addCondition(new TFunction(), "function_order", true);
/*    */ 
/* 43 */     String sExp = "exists (select 1 from t_role_func dto2, t_user_role dto3, t_role dto4 where dto1.function_id = dto2.function_id and dto2.role_id = dto3.role_id and dto3.role_id = dto4.role_id and dto1.validated = 'Y' and dto4.validated = 'Y' and dto3.user_id = '" + 
/* 50 */       this.loginInfo.getUserid() + "' " + 
/* 51 */       "and dto1.super_function_id = '" + fathercode + "')";
/*    */ 
/* 53 */     cons.addExpression(sExp);
/* 54 */     SelectResultSet result = queryResultSet(cons);
/*    */ 
/* 56 */     List list = getDTO(result);
/* 57 */     for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 58 */       DTO subDTO = (DTO)object;
/*    */ 
/* 60 */       String subid = subDTO.getString("FUNCTIONID");
/*    */ 
/* 62 */       createTree(subDTO, subid);
/*    */     }
/*    */ 
/* 65 */     dto.setList("TREE", list);
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.funcmanage.FuncTreeService
 * JD-Core Version:    0.6.0
 */