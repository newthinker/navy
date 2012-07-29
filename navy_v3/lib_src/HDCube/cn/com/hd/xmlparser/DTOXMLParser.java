/*    */ package cn.com.hd.xmlparser;
/*    */ 
/*    */ import cn.com.hd.dto.ClassMapping;
/*    */ import cn.com.hd.dto.PropertyMapping;
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.transfer.RegisterObject;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import java.io.File;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import org.jdom.Attribute;
/*    */ import org.jdom.Document;
/*    */ import org.jdom.Element;
/*    */ import org.jdom.input.SAXBuilder;
/*    */ 
/*    */ public class DTOXMLParser {
/*    */   public static void registDTO()
/*    */   {
/*    */     try
/*    */     {
/* 22 */       SAXBuilder saxBuilder = new SAXBuilder();
/* 23 */       Document doc = saxBuilder.build(String.valueOf(
/* 24 */         new StringBuffer(SystemParam.getParam("AbsolutePath")).append(SystemParam.getParam("DTOConfigPath"))));
/*    */ 
/* 26 */       Element elemRoot = doc.getRootElement();
/* 27 */       List listDTOPath = elemRoot.getChildren("path");
/* 28 */       for (int i = 0; i < listDTOPath.size(); i++) {
/* 29 */         Element elemDTOPath = (Element)listDTOPath.get(i);
/* 30 */         String sDTOPath = elemDTOPath.getTextTrim();
/*    */ 
/* 32 */         buildDTO(sDTOPath);
/*    */       }
/*    */     } catch (Exception ex) {
/* 35 */       ErrorProcessor.prompt(DBLinkXMLParser.class.getName(), "regist DTO error.", ex);
/*    */     }
/*    */   }
/*    */ 
/*    */   private static void buildDTO(String path) {
/* 40 */     String xmlpath = String.valueOf(new StringBuffer(SystemParam.getParam("AbsolutePath")).append(path));
/* 41 */     File file = new File(xmlpath);
/* 42 */     SAXBuilder saxBuilder = new SAXBuilder();
/*    */     try
/*    */     {
/* 45 */       Document doc = saxBuilder.build(file);
/* 46 */       Element elemRoot = doc.getRootElement();
/* 47 */       Element elemClass = elemRoot.getChild("class");
/*    */ 
/* 49 */       ClassMapping classMapping = new ClassMapping();
/* 50 */       classMapping.setClassName(elemClass.getAttributeValue("name"));
/* 51 */       classMapping.setTableName(elemClass.getAttributeValue("table"));
/* 52 */       classMapping.setSchema(elemClass.getAttributeValue("schema"));
/*    */ 
/* 54 */       List listId = elemClass.getChildren("id");
/* 55 */       PropertyMapping[] ids = new PropertyMapping[listId.size()];
/* 56 */       for (int i = 0; i < listId.size(); i++) {
/* 57 */         Element elemId = (Element)listId.get(i);
/* 58 */         ids[i] = new PropertyMapping();
/* 59 */         ids[i].setName(elemId.getAttributeValue("name"));
/* 60 */         ids[i].setType(elemId.getAttributeValue("type"));
/* 61 */         ids[i].setColumnName(elemId.getChild("column").getAttributeValue("name"));
/* 62 */         if (elemId.getChild("column").getAttributeValue("length") != null) {
/* 63 */           ids[i].setColunmLength(Integer.valueOf(elemId.getChild("column").getAttributeValue("length")));
/*    */         }
/*    */ 
/* 66 */         Element genElem = elemId.getChild("generate");
/* 67 */         if (genElem != null) {
/* 68 */           ids[i].setGenerate(genElem.getAttribute("type").getValue());
/* 69 */           ids[i].setGeneratevalue(genElem.getTextTrim());
/*    */         }
/*    */       }
/*    */ 
/* 73 */       classMapping.setId(ids);
/*    */ 
/* 75 */       List listProperty = elemClass.getChildren("property");
/* 76 */       List properties = new ArrayList();
/* 77 */       for (int i = 0; i < listProperty.size(); i++) {
/* 78 */         Element elemProperty = (Element)listProperty.get(i);
/* 79 */         PropertyMapping property = new PropertyMapping();
/* 80 */         property.setName(elemProperty.getAttributeValue("name"));
/* 81 */         property.setType(elemProperty.getAttributeValue("type"));
/* 82 */         property.setColumnName(elemProperty.getChild("column").getAttributeValue("name"));
/* 83 */         if (elemProperty.getChild("column").getAttributeValue("length") != null) {
/* 84 */           property.setColunmLength(Integer.valueOf(elemProperty.getChild("column").getAttributeValue("length")));
/*    */         }
/*    */ 
/* 87 */         properties.add(property);
/*    */       }
/*    */ 
/* 90 */       classMapping.setListProperty(properties);
/*    */ 
/* 92 */       RegisterObject.DTOInfo.put(classMapping.getClassName(), classMapping);
/*    */     } catch (Exception ex) {
/* 94 */       ErrorProcessor.prompt(DBLinkXMLParser.class.getName(), "build DTO error.", ex);
/*    */     } finally {
/* 96 */       saxBuilder = null;
/*    */     }
/* 98 */     HashMap d = RegisterObject.DTOInfo;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.xmlparser.DTOXMLParser
 * JD-Core Version:    0.6.0
 */