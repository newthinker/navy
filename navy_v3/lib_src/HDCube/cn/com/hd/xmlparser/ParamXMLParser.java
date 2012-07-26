/*    */ package cn.com.hd.xmlparser;
/*    */ 
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import java.util.List;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.Element;
/*    */ import org.jdom.input.SAXBuilder;
/*    */ 
/*    */ public class ParamXMLParser
/*    */ {
/*    */   public static String initSystemParam()
/*    */   {
/*    */     try
/*    */     {
/* 16 */       SAXBuilder saxBuilder = new SAXBuilder();
/* 17 */       Document doc = saxBuilder.build(String.valueOf(
/* 18 */         new StringBuffer(SystemParam.getParam("AbsolutePath")).append("/config/systemconfig/param.xml")));
/*    */ 
/* 20 */       Element elemRoot = doc.getRootElement();
/* 21 */       List listDatabase = elemRoot.getChildren("param");
/* 22 */       for (int i = 0; i < listDatabase.size(); i++) {
/* 23 */         Element elemDatabase = (Element)listDatabase.get(i);
/* 24 */         String key = elemDatabase.getAttributeValue("key");
/* 25 */         String value = elemDatabase.getAttributeValue("value");
/* 26 */         SystemParam.setParam(key, value);
/*    */       }
/*    */     } catch (Exception ex) {
/* 29 */       ErrorProcessor.prompt(ParamXMLParser.class.getName(), "read Parameter file error.", ex);
/*    */     }
/*    */ 
/* 32 */     return null;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.xmlparser.ParamXMLParser
 * JD-Core Version:    0.6.0
 */