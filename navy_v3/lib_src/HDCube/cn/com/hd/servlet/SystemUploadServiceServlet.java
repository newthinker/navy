/*    */ package cn.com.hd.servlet;
/*    */ 
/*    */ import cn.com.hd.database.DBOperator;
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.manager.SystemServiceManager;
/*    */ import cn.com.hd.transfer.DTO;
/*    */ import cn.com.hd.transfer.LoginInfo;
/*    */ import cn.com.hd.transfer.Response;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import cn.com.hd.xmlparser.DataXMLParser;
/*    */ import com.jspsmart.upload.SmartUpload;
/*    */ import com.jspsmart.upload.SmartUploadException;
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














/*    */ public class SystemUploadServiceServlet extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = -434744493964889807L;
/*    */ 
/*    */   public void destroy()
/*    */   {
/* 46 */     super.destroy();
/*    */   }
/*    */ 










/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 62 */     doPost(request, response);
/*    */   }
/*    */ 









/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 77 */     String encoding = SystemParam.getParam("ENCODING");
/* 78 */     if (encoding == null) {
/* 79 */       encoding = "GB18030";
/*    */     }
/*    */ 
/* 82 */     request.setCharacterEncoding(encoding);
/*    */ 
/* 84 */     SmartUpload su = new SmartUpload();
/* 85 */     su.initialize(getServletConfig(), request, response);
/*    */     try {
/* 87 */       su.upload();
/*    */     } catch (SmartUploadException ex) {
/* 89 */       ex.printStackTrace();
/*    */     }
/* 92 */     String xml = su.getRequest().getParameter("XML_DATA");
/* 93 */     cn.com.hd.transfer.Request req = null;
/* 94 */     List dbOperatorList = new ArrayList();
/*    */     try {
/*    */       StringBuilder sb;
/* 96 */       if (xml == null) {
/* 97 */         BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
/* 98 */         String line = null;
/* 99 */         sb = new StringBuilder();
/* 100 */         while ((line = br.readLine()) != null) {
/* 101 */           sb.append(line);
/*    */         }
/* 103 */         br.close();
/*    */ 
/* 105 */         xml = sb.toString();
/*    */       }
/*    */ 
/* 108 */       req = DataXMLParser.buildRequest(xml);
/*    */ 
/* 110 */       req.getDto().put("SESSION", request.getSession());
/* 111 */       req.getDto().put("LOGININFO", new LoginInfo(request));
/* 112 */       req.setUpload(su);
/* 113 */       Response resp = SystemServiceManager.service(req, dbOperatorList);
/*    */ 
/* 115 */       for (DBOperator dbOperator : dbOperatorList) {
/* 116 */         int i = dbOperator.commit();
/*    */       }
/*    */ 
/* 119 */       if (resp == null) {
/* 120 */         resp = new Response();
/*    */       }
/*    */ 
/* 123 */       String sKeyUserid = SystemParam.getParam("SessionUserid");
/* 124 */       if (sKeyUserid == null) {
/* 125 */         sKeyUserid = "USER_ID";
/*    */       }
/*    */ 
/* 128 */       sKeyUsername = SystemParam.getParam("SessionUserid");
/* 129 */       if (sKeyUsername == null) {
/* 130 */         sKeyUsername = "USER_NAME";
/*    */       }
/*    */ 
/* 133 */       String sKeyDeptid = SystemParam.getParam("SessionUserid");
/* 134 */       if (sKeyDeptid == null) {
/* 135 */         sKeyDeptid = "DEPT_ID";
/*    */       }
/*    */ 
/* 138 */       String sKeyDeptname = SystemParam.getParam("SessionUserid");
/* 139 */       if (sKeyDeptname == null) {
/* 140 */         sKeyDeptname = "DEPT_NAME";
/*    */       }
/*    */ 
/* 143 */       String userid = resp.getDto().getString(sKeyUserid);
/* 144 */       String username = resp.getDto().getString(sKeyUsername);
/* 145 */       String deptid = resp.getDto().getString(sKeyDeptid);
/* 146 */       String deptname = resp.getDto().getString(sKeyDeptname);
/*    */ 
/* 148 */       if (userid != null) {
/* 149 */         request.getSession().setAttribute(sKeyUserid, userid);
/* 150 */         request.getSession().setAttribute(sKeyUsername, username);
/* 151 */         request.getSession().setAttribute(sKeyDeptid, deptid);
/* 152 */         request.getSession().setAttribute(sKeyDeptname, deptname);
/*    */       }
/*    */ 
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
/*    */     catch (Exception ex) {
/*    */       String sKeyUsername;
/* 170 */       for (DBOperator dbOperator : dbOperatorList) {
/*    */         try {
/* 172 */           dbOperator.rollback();
/*    */         } catch (Exception e) {
/* 174 */           ErrorProcessor.prompt(SystemUploadServiceServlet.class.getName(), e.getMessage(), e);
/* 175 */           Response resp = new Response();
/* 176 */           resp.setErrorInfo(e.getMessage());
/* 177 */           if ((req != null) && (req.getIsremote() != null) && (req.getIsremote().equalsIgnoreCase("true"))) {
/* 178 */             OutputStream os = response.getOutputStream();
/* 179 */             os.write(resp.toXMLString().getBytes());
/*    */ 
/* 181 */             req.setIsremote("false");
/*    */           }
/*    */           else {
/* 184 */             request.setAttribute("XML_DATA", resp);
/*    */ 
/* 186 */             if ((req != null) && (req.getDispatcherUrl() != null)) {
/* 187 */               request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/* 192 */       ErrorProcessor.prompt(SystemUploadServiceServlet.class.getName(), ex.getMessage(), ex);
/* 193 */       Response resp = new Response();
/* 194 */       resp.setErrorInfo(ex.getMessage());
/* 195 */       if ((req != null) && (req.getIsremote() != null) && (req.getIsremote().equalsIgnoreCase("true"))) {
/* 196 */         OutputStream os = response.getOutputStream();
/* 197 */         os.write(resp.toXMLString().getBytes());
/*    */ 
/* 199 */         req.setIsremote("false");
/*    */       }
/*    */       else {
/* 202 */         request.setAttribute("XML_DATA", resp);
/*    */ 
/* 204 */         if ((req != null) && (req.getDispatcherUrl() != null))
/* 205 */           request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
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
 * Qualified Name:     cn.com.hd.servlet.SystemUploadServiceServlet
 * JD-Core Version:    0.6.0
 */