/*    */ package cn.com.hd.dict.dictmanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.dict.TDictDetail;
/*    */ import cn.com.hd.dto.dict.TDictType;
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Conditions;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DictTreeService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 21 */     Response response = new Response();
/*    */ 
/* 24 */     TDictDetail dictdetail = new TDictDetail();
/* 25 */     super.getData(request.getDto(), dictdetail);
/*    */ 
/* 27 */     Debug.debugMessage(1, request, dictdetail.toString());
/*    */ 
/* 29 */     Conditions cons = new Conditions();
/* 30 */     cons.addCondition(new TDictType(), "type_order", true);
/* 31 */     SelectResultSet rs = queryResultSet(cons);
/* 32 */     List list = getDTO(rs);
/*    */ 
/* 34 */     List dtoList = new ArrayList();
/* 35 */     for (int i = 0; i < list.size(); i++) {
/* 36 */       DTO dto = (DTO)list.get(i);
/*    */ 
/* 38 */       DTO newdto = new DTO();
/* 39 */       createTree(newdto, dto.getString("TYPEID"), "-1");
/*    */ 
/* 41 */       dto.setList("TREE", newdto.getList("TREE"));
/*    */ 
/* 43 */       dtoList.add(dto);
/*    */     }
/*    */ 
/* 46 */     response.getDto().setList("TREE", dtoList);
/*    */ 
/* 48 */     response.setRequestParam(request.getDto());
/*    */ 
/* 50 */     return response;
/*    */   }
/*    */ 
/*    */   protected void createTree(DTO dto, String typeid, String fathercode) throws Exception
/*    */   {
/* 55 */     TDictDetail dictDetail = new TDictDetail();
/* 56 */     dictDetail.setTypeid(typeid);
/* 57 */     Conditions cons = new Conditions();
/* 58 */     cons.addCondition(dictDetail, "dict_order", true);
/* 59 */     cons.addExpression("dto1.father_code = '" + fathercode + "'");
/* 60 */     SelectResultSet result = queryResultSet(cons);
/*    */ 
/* 62 */     List list = getDTO(result);
/* 63 */     for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 64 */       DTO subDTO = (DTO)object;
/*    */ 
/* 66 */       String subid = subDTO.getString("DICTCODE");
/*    */ 
/* 68 */       createTree(subDTO, typeid, subid);
/*    */     }
/*    */ 
/* 71 */     dto.setList("TREE", list);
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.dictmanage.DictTreeService
 * JD-Core Version:    0.6.0
 */