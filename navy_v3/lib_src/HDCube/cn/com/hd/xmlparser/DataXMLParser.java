/*     */ package cn.com.hd.xmlparser;
/*     */ 
/*     */ import cn.com.hd.error.Debug;
/*     */ import cn.com.hd.error.ErrorProcessor;
/*     */ import cn.com.hd.transfer.DTO;
/*     */ import cn.com.hd.transfer.Request;
/*     */ import cn.com.hd.transfer.Response;
/*     */ import cn.com.hd.transfer.SystemParam;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.input.SAXBuilder;
/*     */ 
/*     */ public class DataXMLParser
/*     */ {
/*     */   public static Request buildRequest(String xmlString)
/*     */   {
/*     */     try
/*     */     {
/*  24 */       Request request = new Request();
/*     */ 
/*  26 */       String fileName = String.valueOf(new StringBuffer(
/*  27 */         SystemParam.getParam("AbsolutePath")).append("temp/xml/").append(UUID.randomUUID()).append(".xml"));
/*     */ 
/*  29 */       FileOutputStream file = new FileOutputStream(fileName);
/*  30 */       Debug.debugMessage("before parser : " + xmlString);
/*  31 */       file.write(xmlString.getBytes("UTF-8"));
/*     */ 
/*  33 */       file.close();
/*     */ 
/*  35 */       SAXBuilder saxBuilder = new SAXBuilder();
/*  36 */       Document doc = saxBuilder.build(fileName);
/*  37 */       Element elemRoot = doc.getRootElement();
/*     */ 
/*  41 */       Element elemHeader = elemRoot.getChild("header");
/*     */ 
/*  43 */       request.setResponseSystemName(elemHeader.getChildText("responseSystemName"));
/*  44 */       request.setResponseSubsystemName(elemHeader.getChildText("responseSubsystemName"));
/*  45 */       request.setResponseServiceName(elemHeader.getChildText("responseService"));
/*     */ 
/*  47 */       request.setRequestSystemName(elemHeader.getChildText("requestSystemName"));
/*  48 */       request.setRequestSubsystemName(elemHeader.getChildText("requestSubsystemName"));
/*  49 */       request.setRequestActorID(elemHeader.getChildText("requestActorID"));
/*     */ 
/*  51 */       request.setIsremote(elemHeader.getChildText("isremote"));
/*  52 */       request.setDispatcherUrl(elemHeader.getChildText("dispatcherUrl"));
/*     */ 
/*  56 */       DTO dto = new DTO();
/*     */ 
/*  58 */       Element elemDTO = elemRoot.getChild("DTO");
/*     */ 
/*  60 */       if (elemDTO != null) {
/*  61 */         List listData = elemDTO.getChildren();
/*  62 */         for (int i = 0; i < listData.size(); i++) {
/*  63 */           Element elemData = (Element)listData.get(i);
/*     */ 
/*  65 */           String type = elemData.getName().split("_")[0];
/*  66 */           if (type.equalsIgnoreCase("LIS"))
/*  67 */             dto.put(elemData.getName(), buildList(elemData));
/*     */           else {
/*  69 */             dto.put(elemData.getName(), elemData.getTextTrim());
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  75 */       request.setDto(dto);
/*     */ 
/*  77 */       File f = new File(fileName);
/*  78 */       f.delete();
/*     */ 
/*  80 */       return request;
/*     */     } catch (Exception ex) {
/*  82 */       ErrorProcessor.prompt(DataXMLParser.class.getName(), "build Request error.", ex);
/*     */     }
/*     */ 
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */   private static List buildList(Element element) {
/*  89 */     List list = new ArrayList();
/*  90 */     List listRow = element.getChildren("Row");
/*     */ 
/*  92 */     for (int i = 0; i < listRow.size(); i++) {
/*  93 */       DTO dto = new DTO();
/*  94 */       Element elemRow = (Element)listRow.get(i);
/*     */ 
/*  96 */       List listData = elemRow.getChildren();
/*     */ 
/*  98 */       if (listData.size() == 0)
/*  99 */         list.add(elemRow.getTextTrim());
/*     */       else {
/* 101 */         for (int j = 0; j < listData.size(); j++) {
/* 102 */           Element elemData = (Element)listData.get(j);
/*     */ 
/* 104 */           String type = elemData.getName().split("_")[0];
/* 105 */           if (type.equalsIgnoreCase("LIS"))
/* 106 */             dto.put(elemData.getName(), buildList(elemData));
/*     */           else {
/* 108 */             dto.put(elemData.getName(), elemData.getTextTrim());
/*     */           }
/*     */         }
/*     */       }
/* 112 */       list.add(dto);
/*     */     }
/* 114 */     return list;
/*     */   }
/*     */ 
/*     */   public static Response buildResponse(String xmlString) {
/*     */     try {
/* 119 */       Response response = new Response();
/*     */ 
/* 121 */       String fileName = String.valueOf(new StringBuffer(
/* 122 */         SystemParam.getParam("AbsolutePath")).append("temp/xml/").append(UUID.randomUUID()).append(".xml"));
/*     */ 
/* 124 */       FileOutputStream file = new FileOutputStream(fileName);
/* 125 */       Debug.debugMessage("before parser : " + xmlString);
/* 126 */       file.write(xmlString.getBytes("UTF-8"));
/*     */ 
/* 128 */       file.close();
/*     */ 
/* 130 */       SAXBuilder saxBuilder = new SAXBuilder();
/* 131 */       Document doc = saxBuilder.build(fileName);
/* 132 */       Element elemRoot = doc.getRootElement();
/*     */ 
/* 136 */       Element elemHeader = elemRoot.getChild("header");
/*     */ 
/* 138 */       response.setErrorInfo(elemHeader.getChildText("errorInfo"));
/*     */ 
/* 143 */       DTO dto = new DTO();
/*     */ 
/* 145 */       Element elemDTO = elemRoot.getChild("DTO");
/*     */ 
/* 147 */       if (elemDTO != null) {
/* 148 */         List listData = elemDTO.getChildren();
/* 149 */         for (int i = 0; i < listData.size(); i++) {
/* 150 */           Element elemData = (Element)listData.get(i);
/*     */ 
/* 152 */           String type = elemData.getName().split("_")[0];
/* 153 */           if (type.equalsIgnoreCase("LIS"))
/* 154 */             dto.put(elemData.getName(), buildList(elemData));
/*     */           else {
/* 156 */             dto.put(elemData.getName(), elemData.getTextTrim());
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 162 */       response.setDto(dto);
/*     */ 
/* 164 */       File f = new File(fileName);
/* 165 */       f.delete();
/*     */ 
/* 167 */       return response;
/*     */     } catch (Exception ex) {
/* 169 */       ErrorProcessor.prompt(DataXMLParser.class.getName(), "build Response error.", ex);
/*     */     }
/*     */ 
/* 172 */     return null;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.xmlparser.DataXMLParser
 * JD-Core Version:    0.6.0
 */