/*     */ package cn.com.hd.test;
/*     */ 
/*     */ import cn.com.hd.error.ErrorProcessor;
/*     */ import cn.com.hd.transfer.DTO;
/*     */ import cn.com.hd.transfer.Request;
/*     */ import cn.com.hd.transfer.Response;
/*     */ import cn.com.hd.xmlparser.DataXMLParser;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import org.jdom.Document;
/*     */ import org.jdom.Element;
/*     */ import org.jdom.input.SAXBuilder;
/*     */ 
/*     */ public class BaseTest
/*     */ {
/*     */   public static Response remoteService(String urlString, Request request)
/*     */     throws Exception
/*     */   {
/*  28 */     URL url = new URL(urlString);
/*  29 */     HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/*  30 */     request.setIsremote("true");
/*  31 */     connection.setDoOutput(true);
/*  32 */     connection.setDoInput(true);
/*  33 */     connection.setRequestMethod("POST");
/*  34 */     connection.setUseCaches(false);
/*  35 */     connection.setInstanceFollowRedirects(true);
/*  36 */     connection.setRequestProperty("Content-Type", 
/*  37 */       "application/x-java-serialized-object");
/*  38 */     connection.connect();
/*  39 */     connection.setConnectTimeout(1);
/*  40 */     connection.setReadTimeout(1);
/*  41 */     OutputStream outputStream = connection.getOutputStream();
/*  42 */     outputStream.write(request.toXMLString().getBytes());
/*  43 */     outputStream.flush();
/*  44 */     outputStream.close();
/*     */ 
/*  46 */     BufferedReader br = new BufferedReader(
/*  47 */       new InputStreamReader(connection.getInputStream()));
/*     */ 
/*  49 */     String result = "";
/*     */     String line;
/*  50 */     while ((line = br.readLine()) != null)
/*     */     {
/*     */       String line;
/*  51 */       result = result + line;
/*     */     }
/*  53 */     br.close();
/*     */ 
/*  55 */     System.out.println(result);
/*  56 */     Response response = buildResponse(result);
/*     */ 
/*  58 */     return response;
/*     */   }
/*     */ 
/*     */   public static Response buildResponse(String xmlString) {
/*     */     try {
/*  63 */       Response response = new Response();
/*     */ 
/*  65 */       String fileName = String.valueOf(new StringBuffer(System.getProperty("java.io.tmpdir"))
/*  66 */         .append(UUID.randomUUID()).append(".xml"));
/*     */ 
/*  68 */       System.out.println("before parser : " + xmlString);
/*     */ 
/*  70 */       FileOutputStream file = new FileOutputStream(fileName);
/*  71 */       file.write(xmlString.getBytes("UTF-8"));
/*     */ 
/*  73 */       file.close();
/*     */ 
/*  75 */       SAXBuilder saxBuilder = new SAXBuilder();
/*  76 */       Document doc = saxBuilder.build(fileName);
/*  77 */       Element elemRoot = doc.getRootElement();
/*     */ 
/*  81 */       Element elemHeader = elemRoot.getChild("header");
/*     */ 
/*  83 */       response.setErrorInfo(elemHeader.getChildText("errorInfo"));
/*     */ 
/*  88 */       DTO dto = new DTO();
/*     */ 
/*  90 */       Element elemDTO = elemRoot.getChild("DTO");
/*     */ 
/*  92 */       if (elemDTO != null) {
/*  93 */         List listData = elemDTO.getChildren();
/*  94 */         for (int i = 0; i < listData.size(); i++) {
/*  95 */           Element elemData = (Element)listData.get(i);
/*     */ 
/*  97 */           String type = elemData.getName().split("_")[0];
/*  98 */           if (type.equalsIgnoreCase("LIS"))
/*  99 */             dto.put(elemData.getName(), buildList(elemData));
/*     */           else {
/* 101 */             dto.put(elemData.getName(), elemData.getTextTrim());
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 107 */       response.setDto(dto);
/*     */ 
/* 109 */       File f = new File(fileName);
/* 110 */       f.delete();
/*     */ 
/* 112 */       return response;
/*     */     } catch (Exception ex) {
/* 114 */       ErrorProcessor.prompt(DataXMLParser.class.getName(), "build Response error.", ex);
/*     */     }
/*     */ 
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */   private static List buildList(Element element) {
/* 121 */     List list = new ArrayList();
/* 122 */     List listRow = element.getChildren("Row");
/*     */ 
/* 124 */     for (int i = 0; i < listRow.size(); i++) {
/* 125 */       DTO dto = new DTO();
/* 126 */       Element elemRow = (Element)listRow.get(i);
/*     */ 
/* 128 */       List listData = elemRow.getChildren();
/*     */ 
/* 130 */       if (listData.size() == 0)
/* 131 */         list.add(elemRow.getTextTrim());
/*     */       else {
/* 133 */         for (int j = 0; j < listData.size(); j++) {
/* 134 */           Element elemData = (Element)listData.get(j);
/*     */ 
/* 136 */           String type = elemData.getName().split("_")[0];
/* 137 */           if (type.equalsIgnoreCase("LIS"))
/* 138 */             dto.put(elemData.getName(), buildList(elemData));
/*     */           else {
/* 140 */             dto.put(elemData.getName(), elemData.getTextTrim());
/*     */           }
/*     */         }
/*     */       }
/* 144 */       list.add(dto);
/*     */     }
/* 146 */     return list;
/*     */   }
/*     */ 
/*     */   public static void showRequest(Request request) {
/* 150 */     System.out.println("request parameter :" + request.toXMLString());
/*     */   }
/*     */ 
/*     */   public static void showResponse(Response response) {
/* 154 */     System.out.println("response result :" + response.toXMLString());
/*     */   }
/*     */ 
/*     */   public static Response invoke(String systemName, String subSystemName, String serviceName, String url, DTO dto) {
/* 158 */     Request request = new Request();
/* 159 */     request.setResponseSystemName(systemName);
/* 160 */     request.setResponseSubsystemName(subSystemName);
/* 161 */     request.setResponseServiceName(serviceName);
/*     */ 
/* 163 */     request.setDto(dto);
/*     */     try
/*     */     {
/* 166 */       Response response = remoteService(url, request);
/* 167 */       return response;
/*     */     } catch (Exception e) {
/* 169 */       e.printStackTrace();
/* 170 */     }return null;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.test.BaseTest
 * JD-Core Version:    0.6.0
 */