/*    */ package cn.com.hd.xmlparser;
/*    */ 
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.transfer.RegisterObject;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import cn.com.hd.xmlparser.dto.SystemDTO;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.Element;
/*    */ import org.jdom.input.SAXBuilder;
/*    */ 
/*    */ public class SystemXMLParser {
/*    */   public static void registSystem()
/*    */   {
/*    */     try
/*    */     {
/* 18 */       SAXBuilder saxBuilder = new SAXBuilder();
/* 19 */       Document doc = saxBuilder.build(String.valueOf(
/* 20 */         new StringBuffer(SystemParam.getParam("AbsolutePath")).append("/config/systemconfig/SystemRegister.xml")));
/*    */ 
/* 22 */       Element elemRoot = doc.getRootElement();
/* 23 */       List listSystem = elemRoot.getChildren("system");
/* 24 */       for (int i = 0; i < listSystem.size(); i++) {
/* 25 */         Element elemSystem = (Element)listSystem.get(i);
/* 26 */         String sSystemName = elemSystem.getAttributeValue("name");
/* 27 */         String sType = elemSystem.getAttributeValue("type");
/*    */ 
/* 29 */         SystemDTO system = new SystemDTO();
/* 30 */         system.setType(sType);
/*    */ 
/* 32 */         String sProtocol = elemSystem.getChildTextTrim("protocol");
/* 33 */         String sIp = elemSystem.getChildTextTrim("ip");
/* 34 */         String sPort = elemSystem.getChildTextTrim("port");
/* 35 */         String sServerName = elemSystem.getChildTextTrim("server-name");
/* 36 */         String sEntryAddress = elemSystem.getChildTextTrim("entry-address");
/*    */ 
/* 38 */         system.setUrl(sProtocol + "://" + sIp + ":" + sPort + "/" + sServerName + sEntryAddress);
/*    */ 
/* 40 */         RegisterObject.systemInfo.put(sSystemName, system);
/*    */       }
/*    */     } catch (Exception ex) {
/* 43 */       ErrorProcessor.prompt(DBLinkXMLParser.class.getName(), "read SystemRegister file error.", ex);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.xmlparser.SystemXMLParser
 * JD-Core Version:    0.6.0
 */