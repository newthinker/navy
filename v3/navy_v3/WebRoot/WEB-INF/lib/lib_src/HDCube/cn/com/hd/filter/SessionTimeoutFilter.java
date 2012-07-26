/*     */ package cn.com.hd.filter;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import javax.servlet.Filter;
/*     */ import javax.servlet.FilterChain;
/*     */ import javax.servlet.FilterConfig;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.ServletRequest;
/*     */ import javax.servlet.ServletResponse;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class SessionTimeoutFilter
/*     */   implements Filter
/*     */ {
/*     */   private FilterConfig filterConfig;
/*     */   private String enable;
/*     */   private String redirectURL;
/*     */   private String exceptFiles;
/*     */   private String userSession;
/*     */ 
/*     */   public SessionTimeoutFilter()
/*     */   {
/*  56 */     this.filterConfig = null;
/*  57 */     this.enable = null;
/*  58 */     this.redirectURL = null;
/*  59 */     this.exceptFiles = null;
/*  60 */     this.userSession = null;
/*     */   }
/*     */ 
/*     */   private boolean checkSession(HttpServletRequest request)
/*     */   {
/*  71 */     String requestURI = request.getRequestURI();
/*  72 */     String contextPath = request.getContextPath();
/*  73 */     requestURI = requestURI.substring(contextPath.length());
/*     */ 
/*  75 */     String[] exceptFileList = this.exceptFiles.split("#");
/*  76 */     for (int i = 0; i < exceptFileList.length; i++) {
/*  77 */       if (requestURI.indexOf(exceptFileList[i]) != -1) {
/*  78 */         return true;
/*     */       }
/*     */     }
/*     */ 
/*  82 */     HttpSession session = request.getSession(false);
/*  83 */     if (session == null)
/*  84 */       System.out.println("The Session is null.......................");
/*  85 */     else if (session.getAttribute(this.userSession) == null) {
/*  86 */       System.out.println("The Session isn't null, but user is null.......................");
/*     */     }
/*     */ 
/*  89 */     return (session != null) && (session.getAttribute(this.userSession) != null);
/*     */   }
/*     */ 
/*     */   public void destroy()
/*     */   {
/*  96 */     this.filterConfig = null;
/*  97 */     this.enable = null;
/*  98 */     this.exceptFiles = null;
/*  99 */     this.userSession = null;
/*     */   }
/*     */ 
/*     */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
/*     */     throws IOException, ServletException
/*     */   {
/* 113 */     if (this.enable.equalsIgnoreCase("false")) {
/* 114 */       filterChain.doFilter(request, response);
/* 115 */       return;
/*     */     }
/*     */ 
/* 118 */     HttpServletRequest httpRequest = (HttpServletRequest)request;
/* 119 */     HttpServletResponse httpResponse = (HttpServletResponse)response;
/* 120 */     if (checkSession(httpRequest))
/* 121 */       filterChain.doFilter(request, response);
/*     */     else
/* 123 */       httpResponse.getWriter().println("<script language='javascript'>window.top.location = '" + this.redirectURL + "';</script>");
/*     */   }
/*     */ 
/*     */   public void init(FilterConfig filterConfig)
/*     */     throws ServletException
/*     */   {
/* 135 */     this.filterConfig = filterConfig;
/* 136 */     this.enable = this.filterConfig.getInitParameter("enable");
/* 137 */     if (this.enable == null) {
/* 138 */       this.enable = "true";
/*     */     }
/*     */ 
/* 141 */     this.redirectURL = this.filterConfig.getInitParameter("redirectURL");
/* 142 */     if (this.redirectURL == null) {
/* 143 */       this.redirectURL = "/";
/*     */     }
/*     */ 
/* 146 */     this.exceptFiles = this.filterConfig.getInitParameter("exceptFiles");
/* 147 */     if (this.exceptFiles == null) {
/* 148 */       this.exceptFiles = "";
/*     */     }
/*     */ 
/* 151 */     this.userSession = this.filterConfig.getInitParameter("userSession");
/* 152 */     if (this.userSession == null)
/* 153 */       this.userSession = "USER_ID";
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.filter.SessionTimeoutFilter
 * JD-Core Version:    0.6.0
 */