/*    */ package cn.com.hd.dict.dictmanage;
/*    */ 
/*    */ import cn.com.hd.database.SelectResultSet;
/*    */ import cn.com.hd.dto.dict.TDictDetail;
/*    */ import cn.com.hd.service.BaseService;
/*    */ import cn.com.hd.service.IService;
/*    */ import cn.com.hd.transfer.Conditions;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DictExportService extends BaseService
/*    */   implements IService
/*    */ {
/*    */   public Response service(Request request)
/*    */     throws Exception
/*    */   {
/* 23 */     TDictDetail dictdetail = new TDictDetail();
/*    */ 
/* 25 */     super.getQueryData(request.getDto(), dictdetail);
/*    */ 
/* 27 */     Conditions cons = new Conditions();
/* 28 */     cons.addCondition(dictdetail, "type_id, dict_order", true);
/* 29 */     SelectResultSet result = super.queryResultSet(cons);
/*    */ 
/* 31 */     List list = super.getDTO(result);
/* 32 */     StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n<dictlist>\n");
/* 33 */     String cur_type_id = "-1";
/* 34 */     int cnt1 = 0;
/* 35 */     int cnt2 = 0;
/* 36 */     for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/* 37 */       DTO dto = (DTO)object;
/* 38 */       String name = dto.getString("DICTNAME");
/*    */ 
/* 40 */       if (dto.getString("TYPEID").equals("5")) {
/* 41 */         name = name + "#hd#" + dto.getString("EXPINFOA");
/*    */       }
/*    */ 
/* 44 */       if (cur_type_id.equals(dto.getString("TYPEID"))) {
/* 45 */         xml.append("\t\t<row DICT_NAME=\"" + name + "\" DICT_CODE=\"" + 
/* 46 */           dto.getString("DICTCODE") + "\"");
/* 47 */         if ((dto.getString("RELEVANCECODE") != null) && (!dto.getString("RELEVANCECODE").equals("")))
/* 48 */           xml.append(" RELEVANCE_CODE=\"" + dto.getString("RELEVANCECODE") + "\"");
/*    */         else {
/* 50 */           xml.append(" RELEVANCE_CODE=\"0\"");
/*    */         }
/*    */ 
/* 53 */         xml.append(" />\n");
/*    */       } else {
/* 55 */         if (!cur_type_id.equals("-1")) {
/* 56 */           xml.append("\t</dict>\n");
/*    */         }
/*    */ 
/* 59 */         xml.append("\t<dict TYPE_ID=\"" + dto.getString("TYPEID") + "\">\n");
/* 60 */         xml.append("\t\t<row DICT_NAME=\"" + name + "\" DICT_CODE=\"" + 
/* 61 */           dto.getString("DICTCODE") + "\"");
/* 62 */         if ((dto.getString("RELEVANCECODE") != null) && (!dto.getString("RELEVANCECODE").equals("")))
/* 63 */           xml.append(" RELEVANCE_CODE=\"" + dto.getString("RELEVANCECODE") + "\"");
/*    */         else {
/* 65 */           xml.append(" RELEVANCE_CODE=\"0\"");
/*    */         }
/*    */ 
/* 68 */         xml.append(" />\n");
/*    */       }
/*    */ 
/* 71 */       cur_type_id = dto.getString("TYPEID");
/*    */     }
/*    */ 
/* 74 */     xml.append("\t</dict>\n");
/* 75 */     xml.append("</dictlist>");
/* 76 */     String path = SystemParam.getParam("AbsolutePath") + "xml/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".xml";
/* 77 */     System.out.println(cnt1 + " --- " + cnt2);
/* 78 */     FileOutputStream fos = new FileOutputStream(path);
/* 79 */     fos.write(xml.toString().getBytes("UTF-8"));
/* 80 */     fos.close();
/*    */ 
/* 82 */     Response resp = new Response();
/* 83 */     resp.getDto().put("DOWNLOAD", new FileInputStream(path));
/* 84 */     resp.getDto().setList("RESULT", list);
/* 85 */     resp.setRequestParam(request.getDto());
/*    */ 
/* 87 */     return resp;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDDict.jar
 * Qualified Name:     cn.com.hd.dict.dictmanage.DictExportService
 * JD-Core Version:    0.6.0
 */