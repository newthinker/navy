/*    */ package cn.com.hd.servlet;
/*    */ 
/*    */ import cn.com.hd.database.DBOperator;
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.manager.SystemServiceManager;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import cn.com.hd.xmlparser.DataXMLParser;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.OutputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class SystemServiceServlet extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = -434744493964889807L;
/*    */ 
/*    */   public void destroy()
/*    */   {
/* 47 */     super.destroy();
/*    */   }
/*    */ 
/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 63 */     doPost(request, response);
/*    */   }
/*    */ 
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 84 */     String xml = request.getParameter("XML_DATA");
/* 85 */     Request req = null;
/* 86 */     List dbOperatorList = new ArrayList();
/*    */     try {
/* 88 */       if (xml == null) {
/* 89 */         BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
/* 90 */         String line = null;
/* 91 */         sb = new StringBuilder();
/* 92 */         while ((line = br.readLine()) != null) {
/* 93 */           sb.append(line);
/*    */         }
/* 95 */         br.close();
/*    */ 
/* 97 */         xml = sb.toString();
/*    */       }
/*    */ 
/* 100 */       req = DataXMLParser.buildRequest(xml);
/*    */ 
/* 102 */       req.getDto().put("SESSION", request.getSession());
/* 103 */       req.getDto().put("LOGININFO", new LoginInfo(request));
/*    */ 
/* 105 */       Response resp = SystemServiceManager.service(req, dbOperatorList);
/*    */ 
/* 107 */       for (DBOperator dbOperator : dbOperatorList) {
/* 108 */         int i = dbOperator.commit();
/*    */       }
/*    */ 
/* 111 */       if (resp == null) {
/* 112 */         resp = new Response();
/*    */       }
/*    */ 
/* 115 */       if ((req != null) && (req.getIsremote() != null) && (req.getIsremote().equalsIgnoreCase("true"))) {
/* 116 */         OutputStream os = response.getOutputStream();
/* 117 */         os.write(resp.toXMLString().getBytes());
/*    */ 
/* 119 */         req.setIsremote("false");
/*    */       }
/*    */       else {
/* 122 */         request.setAttribute("XML_DATA", resp);
/*    */ 
/* 124 */         if ((req != null) && (req.getDispatcherUrl() != null))
/* 125 */           request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
/*    */       }
/*    */     }
/*    */     catch (Exception ex)
/*    */     {
/*    */       StringBuilder sb;
/* 130 */       for (DBOperator dbOperator : dbOperatorList) {
/*    */         try {
/* 132 */           dbOperator.rollback();
/*    */         } catch (Exception e) {
/* 134 */           ErrorProcessor.prompt(SystemServiceServlet.class.getName(), e.getMessage(), e);
/* 135 */           Response resp = new Response();
/* 136 */           resp.setErrorInfo(e.getMessage());
/* 137 */           if ((req != null) && (req.getIsremote() != null) && (req.getIsremote().equalsIgnoreCase("true"))) {
/* 138 */             OutputStream os = response.getOutputStream();
/* 139 */             os.write(resp.toXMLString().getBytes());
/*    */ 
/* 141 */             req.setIsremote("false");
/*    */           }
/*    */           else {
/* 144 */             request.setAttribute("XML_DATA", resp);
/*    */ 
/* 146 */             if ((req != null) && (req.getDispatcherUrl() != null)) {
/* 147 */               request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/* 152 */       ErrorProcessor.prompt(SystemServiceServlet.class.getName(), ex.getMessage(), ex);
/* 153 */       Response resp = new Response();
/* 154 */       resp.setErrorInfo(ex.getMessage());
/* 155 */       if ((req != null) && (req.getIsremote() != null) && (req.getIsremote().equalsIgnoreCase("true"))) {
/* 156 */         OutputStream os = response.getOutputStream();
/* 157 */         os.write(resp.toXMLString().getBytes());
/*    */ 
/* 159 */         req.setIsremote("false");
/*    */       }
/*    */       else {
/* 162 */         request.setAttribute("XML_DATA", resp);
/*    */ 
/* 164 */         if ((req != null) && (req.getDispatcherUrl() != null))
/* 165 */           request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public void init()
/*    */     throws ServletException
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.servlet.SystemServiceServlet
 * JD-Core Version:    0.6.0
 */