/*    */ package cn.com.hd.servlet;
/*    */ 
/*    */ import cn.com.hd.error.Debug;
/*    */ import cn.com.hd.security.impl.Huadi;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.net.URLEncoder;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletOutputStream;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 












/*    */ public class DownloadServlet extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */ 
/*    */   public void destroy()
/*    */   {
/* 34 */     super.destroy();
/*    */   }
/*    */ 










/*    */   public void doGet(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 50 */     doPost(request, response);
/*    */   }
/*    */ 









/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response)
/*    */     throws ServletException, IOException
/*    */   {
/* 65 */     String path = Huadi.getDecrypt(request.getParameter("download"));
/* 66 */     String filename = Huadi.getDecrypt(request.getParameter("filename"));
/*    */ 
/* 68 */     if (path == null) {
/* 69 */       response.getOutputStream().println("<script language='javascript'>alert('下载失败');</script>");
/* 70 */       return;
/*    */     }
/*    */ 
/* 73 */     File file = new File(path);
/* 74 */     Debug.debugMessage("download file ====== " + file.getAbsolutePath());
/* 75 */     if (!file.exists()) {
/* 76 */       response.getOutputStream().println("<script language='javascript'>alert('未找到文件');</script>");
/* 77 */       return;
/*    */     }
/*    */ 
/* 80 */     if ((filename == null) || (filename.equals(""))) {
/* 81 */       filename = Huadi.getFileName(path);
/*    */     }
/*    */ 
/* 84 */     filename = URLEncoder.encode(filename, "UTF-8");
/* 85 */     if (filename.length() > 150) {
/* 86 */       filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
/*    */     }
/*    */ 
/* 89 */     FileInputStream is = new FileInputStream(file);
/* 90 */     response.addHeader("Content-Disposition", "attachment;filename=" + filename);
/*    */     try
/*    */     {
/* 93 */       byte[] b = new byte[1024];
/* 94 */       int i = 0;
/*    */ 
/* 96 */       while ((i = is.read(b)) > 0) {
/* 97 */         response.getOutputStream().write(b, 0, i);
/*    */       }
/*    */ 
/* 100 */       response.getOutputStream().flush();
/*    */     } catch (Exception e) {
/* 102 */       System.out.println("Error!");
/* 103 */       e.printStackTrace();
/*    */     } finally {
/* 105 */       if (is != null)
/* 106 */         is.close();
/*    */     }
/*    */   }
/*    */ 
/*    */   public void init()
/*    */     throws ServletException
/*    */   {
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.servlet.DownloadServlet
 * JD-Core Version:    0.6.0
 */