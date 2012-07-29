/*    */ package cn.com.hd.servlet;
/*    */ 
/*    */ import cn.com.hd.database.DBOperator;
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.manager.SystemServiceManager;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Request;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import cn.com.hd.transfer.SystemParam;
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
/*    */ import javax.servlet.http.HttpSession;
/*    */ 












/*    */ public class LoginServiceServlet extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = -434744493964889807L;
/*    */ 
/*    */   public void destroy()
/*    */   {
/* 43 */     super.destroy();
/*    */   }
/*    */ 










/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 59 */     doPost(request, response);
/*    */   }
/*    */ 









/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 74 */     String encoding = SystemParam.getParam("ENCODING");
/* 75 */     if (encoding == null) {
/* 76 */       encoding = "UTF-8";
/*    */     }
/*    */ 
/* 79 */     request.setCharacterEncoding(encoding);
/* 81 */     String xml = request.getParameter("XML_DATA");
/* 82 */     Request req = null;
/* 83 */     List dbOperatorList = new ArrayList();
/*    */     try {
/*    */       StringBuilder sb;
/* 85 */       if (xml == null) {
/* 86 */         BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
/* 87 */         String line = null;
/* 88 */         sb = new StringBuilder();
/* 89 */         while ((line = br.readLine()) != null) {
/* 90 */           sb.append(line);
/*    */         }
/* 92 */         br.close();
/*    */ 
/* 94 */         xml = sb.toString();
/*    */       }
/*    */ 
/* 97 */       req = DataXMLParser.buildRequest(xml);
/*    */ 
/* 99 */       req.getDto().put("SESSION", request.getSession());
/* 100 */       req.getDto().put("LOGININFO", new LoginInfo(request));
/* 101 */       Response resp = SystemServiceManager.service(req, dbOperatorList);
/*    */ 
/* 103 */       for (DBOperator dbOperator : dbOperatorList) {
/* 104 */         dbOperator.commit();
/*    */       }
/*    */ 
/* 107 */       if (resp == null) {
/* 108 */         resp = new Response();
/*    */       }
/*    */ 
/* 111 */       String sKeyUserid = SystemParam.getParam("SessionUserid");
/* 112 */       if (sKeyUserid == null) {
/* 113 */         sKeyUserid = "USER_ID";
/*    */       }
/*    */ 
/* 116 */       sKeyUsername = SystemParam.getParam("SessionUserid");
/* 117 */       if (sKeyUsername == null) {
/* 118 */         sKeyUsername = "USER_NAME";
/*    */       }
/*    */ 
/* 121 */       String sKeyDeptid = SystemParam.getParam("SessionUserid");
/* 122 */       if (sKeyDeptid == null) {
/* 123 */         sKeyDeptid = "DEPT_ID";
/*    */       }
/*    */ 
/* 126 */       String sKeyDeptname = SystemParam.getParam("SessionUserid");
/* 127 */       if (sKeyDeptname == null) {
/* 128 */         sKeyDeptname = "DEPT_NAME";
/*    */       }
/*    */ 
/* 131 */       String userid = resp.getDto().getString(sKeyUserid);
/* 132 */       String username = resp.getDto().getString(sKeyUsername);
/* 133 */       String deptid = resp.getDto().getString(sKeyDeptid);
/* 134 */       String deptname = resp.getDto().getString(sKeyDeptname);
/*    */ 
/* 136 */       if (userid != null) {
/* 137 */         request.getSession().setAttribute(sKeyUserid, userid);
/* 138 */         request.getSession().setAttribute(sKeyUsername, username);
/* 139 */         request.getSession().setAttribute(sKeyDeptid, deptid);
/* 140 */         request.getSession().setAttribute(sKeyDeptname, deptname);
/*    */       }
/*    */ 
/* 143 */       if ((req != null) && (req.getIsremote() != null) && (req.getIsremote().equalsIgnoreCase("true"))) {
/* 144 */         OutputStream os = response.getOutputStream();
/* 145 */         os.write(resp.toXMLString().getBytes());
/*    */ 
/* 147 */         req.setIsremote("false");
/*    */       }
/*    */       else {
/* 150 */         request.setAttribute("XML_DATA", resp);
/*    */ 
/* 152 */         if ((req != null) && (req.getDispatcherUrl() != null))
/* 153 */           request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
/*    */       }
/*    */     }
/*    */     catch (Exception ex) {
/*    */       String sKeyUsername;
/* 158 */       for (DBOperator dbOperator : dbOperatorList) {
/*    */         try {
/* 160 */           dbOperator.rollback();
/*    */         } catch (Exception e) {
/* 162 */           ErrorProcessor.prompt(LoginServiceServlet.class.getName(), e.getMessage(), e);
/* 163 */           Response resp = new Response();
/* 164 */           resp.setErrorInfo(e.getMessage());
/* 165 */           if ((req != null) && (req.getIsremote() != null) && (req.getIsremote().equalsIgnoreCase("true"))) {
/* 166 */             OutputStream os = response.getOutputStream();
/* 167 */             os.write(resp.toXMLString().getBytes());
/*    */ 
/* 169 */             req.setIsremote("false");
/*    */           }
/*    */           else {
/* 172 */             request.setAttribute("XML_DATA", resp);
/*    */ 
/* 174 */             if ((req != null) && (req.getDispatcherUrl() != null)) {
/* 175 */               request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/* 180 */       ErrorProcessor.prompt(LoginServiceServlet.class.getName(), ex.getMessage(), ex);
/* 181 */       Response resp = new Response();
/* 182 */       resp.setErrorInfo(ex.getMessage());
/* 183 */       if ((req != null) && (req.getIsremote() != null) && (req.getIsremote().equalsIgnoreCase("true"))) {
/* 184 */         OutputStream os = response.getOutputStream();
/* 185 */         os.write(resp.toXMLString().getBytes());
/*    */ 
/* 187 */         req.setIsremote("false");
/*    */       }
/*    */       else {
/* 190 */         request.setAttribute("XML_DATA", resp);
/*    */ 
/* 192 */         if ((req != null) && (req.getDispatcherUrl() != null))
/* 193 */           request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
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
 * Qualified Name:     cn.com.hd.servlet.LoginServiceServlet
 * JD-Core Version:    0.6.0
 */