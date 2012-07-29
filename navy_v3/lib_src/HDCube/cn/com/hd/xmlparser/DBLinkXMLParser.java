/*    */ package cn.com.hd.xmlparser;
/*    */ 
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.Element;
/*    */ import org.jdom.input.SAXBuilder;
/*    */ 
/*    */ public class DBLinkXMLParser {
/*    */   public static String getJndiName(String sSubsystemName)
/*    */   {
/*    */     try
/*    */     {
/* 16 */       SAXBuilder saxBuilder = new SAXBuilder();
/* 17 */       Document doc = saxBuilder.build(String.valueOf(
/* 18 */         new StringBuffer(SystemParam.getParam("AbsolutePath")).append("/config/systemconfig/DBLink.xml")));
/*    */ 
/* 20 */       Element elemRoot = doc.getRootElement();
/* 21 */       List listDatabase = elemRoot.getChildren("database");
/* 22 */       for (int i = 0; i < listDatabase.size(); i++) {
/* 23 */         Element elemDatabase = (Element)listDatabase.get(i);
/* 24 */         String sname = elemDatabase.getAttributeValue("subSystemName");
/* 25 */         if (sname.equals(sSubsystemName))
/* 26 */           return elemDatabase.getChildTextTrim("jndi-name");
/*    */       }
/*    */     }
/*    */     catch (Exception ex) {
/* 30 */       ErrorProcessor.prompt(DBLinkXMLParser.class.getName(), "read DBLink file error.", ex);
/*    */     }
/*    */ 
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */   public static List<String> getAllSubSystem() {
/* 37 */     List listSubSystem = new ArrayList();
/*    */     try
/*    */     {
/* 40 */       SAXBuilder saxBuilder = new SAXBuilder();
/* 41 */       Document doc = saxBuilder.build(String.valueOf(
/* 42 */         new StringBuffer(SystemParam.getParam("AbsolutePath")).append("/config/systemconfig/DBLink.xml")));
/*    */ 
/* 44 */       Element elemRoot = doc.getRootElement();
/* 45 */       List listDatabase = elemRoot.getChildren("database");
/* 46 */       for (int i = 0; i < listDatabase.size(); i++) {
/* 47 */         Element elemDatabase = (Element)listDatabase.get(i);
/* 48 */         String sname = elemDatabase.getAttributeValue("subSystemName");
/* 49 */         listSubSystem.add(sname);
/*    */       }
/*    */     } catch (Exception ex) {
/* 52 */       ErrorProcessor.prompt(DBLinkXMLParser.class.getName(), "read DBLink file error.", ex);
/* 53 */       return new ArrayList();
/*    */     }
/*    */ 
/* 56 */     return listSubSystem;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.xmlparser.DBLinkXMLParser
 * JD-Core Version:    0.6.0
 */