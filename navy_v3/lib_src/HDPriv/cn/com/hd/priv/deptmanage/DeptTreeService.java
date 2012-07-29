/*    */ package cn.com.hd.priv.deptmanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.priv.TUser;
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
/*    */ public class DeptTreeService extends BaseService implements IService {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 20 */     Response response = new Response();
/*    */ 

/* 23 */     TUser user = new TUser();
/* 24 */     super.getData(request.getDto(), user);
/*    */ 
/* 26 */     Debug.debugMessage(1, request, user.toString());
/*    */ 
/* 28 */     Conditions cons = new Conditions();
/* 29 */     cons.addCondition(new TUser(), "type_order", true);
/* 30 */     SelectResultSet rs = queryResultSet(cons);
/* 31 */     List list = getDTO(rs);
/*    */ 
/* 33 */     List dtoList = new ArrayList();
/* 34 */     for (int i = 0; i < list.size(); i++) {
/* 35 */       DTO dto = (DTO)list.get(i);
/*    */ 
/* 37 */       DTO newdto = new DTO();
/* 38 */       createTree(newdto, dto.getString("TYPEID"), "-1");
/*    */ 
/* 40 */       dto.setList("TREE", newdto.getList("TREE"));
/*    */ 
/* 42 */       dtoList.add(dto);
/*    */     }
/*    */ 
/* 45 */     response.getDto().setList("TREE", dtoList);
/*    */ 
/* 47 */     response.setRequestParam(request.getDto());
/*    */ 
/* 49 */     return response;
/*    */   }
/*    */ 
/*    */   protected void createTree(DTO dto, String typeid, String fathercode) throws Exception
/*    */   {
/* 54 */     TUser user = new TUser();
/* 55 */     user.setUserid(typeid);
/* 56 */     Conditions cons = new Conditions();
/* 57 */     cons.addCondition(user, "dict_order", true);
/* 58 */     cons.addExpression("dto1.father_code = '" + fathercode + "'");
/* 59 */     SelectResultSet result = queryResultSet(cons);
/*    */ 
/* 61 */     List list = getDTO(result);
/* 62 */     for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 63 */       DTO subDTO = (DTO)object;
/*    */ 
/* 65 */       String subid = subDTO.getString("DICTCODE");
/*    */ 
/* 67 */       createTree(subDTO, typeid, subid);
/*    */     }
/*    */ 
/* 70 */     dto.setList("TREE", list);
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDPriv.jar
 * Qualified Name:     cn.com.hd.priv.deptmanage.DeptTreeService
 * JD-Core Version:    0.6.0
 */