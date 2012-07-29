/*    */ package cn.com.hd.filter;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import javax.servlet.Filter;
/*    */ import javax.servlet.FilterChain;
/*    */ import javax.servlet.FilterConfig;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ 
/*    */ public class ChineseFilter implements Filter
/*    */ {
/*    */   private String encodeing;
/*    */   private String enable;
/*    */ 
/*    */   public void destroy()
/*    */   {
/*    */   }
/*    */ 
/*    */   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
/*    */     throws IOException, ServletException
/*    */   {
/* 23 */     if (this.enable.equalsIgnoreCase("TRUE")) {
/* 24 */       request.setCharacterEncoding(this.encodeing);
/*    */     }
/* 26 */     chain.doFilter(request, response);
/*    */   }
/*    */ 
/*    */   public void init(FilterConfig fcParam) throws ServletException {
/* 30 */     this.encodeing = fcParam.getInitParameter("ENCODING");
/* 31 */     this.enable = fcParam.getInitParameter("ENABLE");
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.filter.ChineseFilter
 * JD-Core Version:    0.6.0
 */