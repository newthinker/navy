/*    */ package cn.com.hd.filter;
/*    */ 
/*    */ import cn.com.hd.database.DBConnectionManager;
/*    */ import cn.com.hd.transfer.SpringContext;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import cn.com.hd.xmlparser.DBLinkXMLParser;
/*    */ import cn.com.hd.xmlparser.DTOXMLParser;
/*    */ import cn.com.hd.xmlparser.ParamXMLParser;
/*    */ import cn.com.hd.xmlparser.SubsystemXMLParser;
/*    */ import cn.com.hd.xmlparser.SystemXMLParser;
/*    */ import java.io.IOException;
/*    */ import java.util.Enumeration;
/*    */ import java.util.List;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ 
/*    */ public class SystemFilter
/*    */   implements Filter
/*    */ {
/*    */   public void destroy() {}
/*    */ 
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*    */     throws IOException, ServletException
/*    */   {
/* 30 */     chain.doFilter(request, response);
/*    */   }
/*    */ 
/*    */   public void init(FilterConfig fcParam) throws ServletException {
/* 34 */     SystemParam.setParam("AbsolutePath", fcParam.getServletContext().getRealPath("/").replaceAll("\\\\", "/"));
/* 35 */     Enumeration enumParamNames = fcParam.getInitParameterNames();
/* 36 */     while (enumParamNames.hasMoreElements()) {
/* 37 */       String sKey = (String)enumParamNames.nextElement();
/* 38 */       SystemParam.setParam(sKey, fcParam.getInitParameter(sKey));
/*    */     }
/*    */ 
/* 41 */     ParamXMLParser.initSystemParam();
/*    */ 
/* 43 */     List listSubSystem = DBLinkXMLParser.getAllSubSystem();
/* 44 */     for (int i = 0; i < listSubSystem.size(); i++) {
/* 45 */       DBConnectionManager.getInstance().registerDBConnectionPool((String)listSubSystem.get(i));
/*    */     }
/*    */ 
/* 48 */     SpringContext.initApplicationContext(fcParam.getServletContext());
/*    */ 
/* 50 */     SystemXMLParser.registSystem();
/* 51 */     SubsystemXMLParser.registSubsystem();
/* 52 */     DTOXMLParser.registDTO();
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.filter.SystemFilter
 * JD-Core Version:    0.6.0
 */