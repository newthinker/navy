/*     */ package cn.com.hd.manager;
/*     */ 
/*     */ import cn.com.hd.database.DBOperator;
/*     */ import cn.com.hd.error.Debug;
/*     */ import cn.com.hd.error.SystemException;
/*     */ import cn.com.hd.transfer.DTO;
/*     */ import cn.com.hd.transfer.RegisterObject;
/*     */ import cn.com.hd.transfer.Request;
/*     */ import cn.com.hd.transfer.Response;
/*     */ import cn.com.hd.xmlparser.DataXMLParser;
/*     */ import cn.com.hd.xmlparser.dto.SystemDTO;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ 
/*     */ public class SystemServiceManager
/*     */ {
/*     */   public static Response service(Request request, List<DBOperator> dbOperatorList) throws Exception {
/*  25 */     Response response = null;
/*     */     try
/*     */     {
/*  28 */       Debug.debugMessage(1, request, "SystemServiceManager start.");
/*  29 */       SystemDTO system = (SystemDTO)RegisterObject.systemInfo.get(
/*  30 */         request.getResponseSystemName());
/*  31 */       if (system == null) {
/*  32 */         response = new Response();
/*  33 */         response.setErrorInfo("not found system : " + 
/*  34 */           request.getResponseSystemName() + ".");
/*  35 */         Debug.debugMessage(1, request, "not found system : " + 
/*  36 */           request.getResponseSystemName() + ".");
/*  37 */       } else if (system.getType().equalsIgnoreCase("local")) {
/*  38 */         response = SubsystemServiceManager.service(request, dbOperatorList);
/*     */       } else {
/*  40 */         Debug.debugMessage(1, request, "call remote system : " + 
/*  41 */           request.getResponseSystemName() + " " + 
/*  42 */           system.getUrl() + ".");
/*  43 */         response = remoteService(system.getUrl(), request);
/*     */       }
/*  45 */       Debug.debugMessage(1, request, "SystemServiceManager down.");
/*     */     } catch (Exception e) {
/*  47 */       throw new SystemException(e.getMessage());
/*     */     }
/*  49 */     return response;
/*     */   }
/*     */ 
/*     */   private static Response remoteService(String urlString, Request request) throws Exception
/*     */   {
/*  54 */     URL url = new URL(urlString);
/*  55 */     HttpURLConnection connection = (HttpURLConnection)url.openConnection();
/*  56 */     request.setIsremote("true");
/*  57 */     connection.setDoOutput(true);
/*  58 */     connection.setDoInput(true);
/*  59 */     connection.setRequestMethod("POST");
/*  60 */     connection.setUseCaches(false);
/*  61 */     connection.setInstanceFollowRedirects(true);
/*  62 */     connection.setRequestProperty("Content-Type", 
/*  63 */       "application/x-java-serialized-object");
/*  64 */     connection.connect();
/*  65 */     connection.setConnectTimeout(1);
/*  66 */     connection.setReadTimeout(1);
/*  67 */     OutputStream outputStream = connection.getOutputStream();
/*  68 */     outputStream.write(request.toXMLString().getBytes());
/*  69 */     outputStream.flush();
/*  70 */     outputStream.close();
/*     */ 
/*  72 */     BufferedReader br = new BufferedReader(
/*  73 */       new InputStreamReader(connection.getInputStream()));
/*     */ 
/*  75 */     String result = "";   String line;
/*  76 */     while ((line = br.readLine()) != null) {
/*     */       String line;        result = result + "\n" + line;
/*     */     }
/*  79 */     br.close();
/*     */ 
/*  81 */     Response response = DataXMLParser.buildResponse(result);
/*     */ 
/*  83 */     return response;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) {
/*  87 */     Request request = new Request();
/*  88 */     request.setResponseSystemName("SystemManage");
/*  89 */     request.setResponseSubsystemName("PrivManage");
/*  90 */     request.setResponseServiceName("UserManageService");
/*     */ 
/*  92 */     DTO dto = new DTO();
/*  93 */     dto.setString("USERID", "123");
/*  94 */     dto.setString("USERNAME", "FISH");
/*     */ 
/*  96 */     List list = new ArrayList();
/*  97 */     for (int i = 0; i < 10; i++) {
/*  98 */       DTO d = new DTO();
/*  99 */       d.setString("test", "test" + String.valueOf(i));
/*     */ 
/* 101 */       list.add(d);
/*     */     }
/*     */ 
/* 104 */     dto.setList("list", list);
/*     */ 
/* 106 */     request.setDto(dto);
/*     */ 
/* 108 */     System.out.println(request.toXMLString());
/*     */     try
/*     */     {
/* 111 */       response = remoteService( 
/* 112 */         "http://127.0.0.1:8080/HDCube/system", request);
/*     */     } catch (Exception e) {
/*     */       Response response;
/* 114 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.manager.SystemServiceManager
 * JD-Core Version:    0.6.0
 */