/*    */ package cn.com.hd.xmlparser;
/*    */ 
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.transfer.RegisterObject;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import cn.com.hd.xmlparser.dto.SubsystemDTO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.Element;
/*    */ import org.jdom.input.SAXBuilder;
/*    */ 
/*    */ public class SubsystemXMLParser
/*    */ {
/*    */   public static void registSubsystem()
/*    */   {
/*    */     try
/*    */     {
/* 19 */       SAXBuilder saxBuilder = new SAXBuilder();
/* 20 */       Document doc = saxBuilder.build(String.valueOf(
/* 21 */         new StringBuffer(SystemParam.getParam("AbsolutePath")).append("/config/systemconfig/SubSystemRegister.xml")));
/*    */ 
/* 23 */       Element elemRoot = doc.getRootElement();
/* 24 */       List listSubsystem = elemRoot.getChildren("subsystem");
/* 25 */       for (int i = 0; i < listSubsystem.size(); i++) {
/* 26 */         Element elemSubsystem = (Element)listSubsystem.get(i);
/* 27 */         String sSubsystemName = elemSubsystem.getAttributeValue("name");
/*    */ 
/* 29 */         HashMap service = new HashMap();
/*    */ 
/* 31 */         List listService = elemSubsystem.getChildren("service");
/* 32 */         for (int j = 0; j < listService.size(); j++) {
/* 33 */           Element elemService = (Element)listService.get(j);
/* 34 */           service.put(elemService.getChildText("name"), elemService.getChildText("class"));
/*    */         }
/*    */ 
/* 37 */         SubsystemDTO subsystem = new SubsystemDTO();
/* 38 */         subsystem.setServiceList(service);
/*    */ 
/* 40 */         RegisterObject.subsystemInfo.put(sSubsystemName, subsystem);
/*    */       }
/*    */     } catch (Exception ex) {
/* 43 */       ErrorProcessor.prompt(DBLinkXMLParser.class.getName(), "read SubsystemRegister file error.", ex);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.xmlparser.SubsystemXMLParser
 * JD-Core Version:    0.6.0
 */