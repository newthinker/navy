/*     */ package cn.com.hd.transfer;
/*     */ 
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ 
/*     */ public class LoginInfo
/*     */ {
/*     */   private String userid;
/*     */   private String username;
/*     */   private String deptid;
/*     */   private String deptname;
/*     */   private String remoteaddr;
/*     */   private Integer remoteport;
/*     */   private String localaddr;
/*     */   private Integer localpost;
/*     */   private Map<String, Object> info;
/*     */ 
/*     */   public LoginInfo(HttpServletRequest request)
/*     */   {
/*  29 */     String sKeyInfo = "sKeyInfo";
/*  30 */     this.info = ((Map)request.getSession().getAttribute(sKeyInfo));
/*  31 */     String key = SystemParam.getParam("SessionUsername");
/*  32 */     if (key == null) {
/*  33 */       key = "USER_NAME";
/*     */     }
/*     */ 
/*  36 */     this.username = ((String)request.getSession().getAttribute(key));
/*     */ 
/*  38 */     key = SystemParam.getParam("SessionUserid");
/*  39 */     if (key == null) {
/*  40 */       key = "USER_ID";
/*     */     }
/*     */ 
/*  43 */     this.userid = ((String)request.getSession().getAttribute(key));
/*     */ 
/*  45 */     key = SystemParam.getParam("SessionDeptname");
/*  46 */     if (key == null) {
/*  47 */       key = "DEPT_NAME";
/*     */     }
/*     */ 
/*  50 */     this.deptname = ((String)request.getSession().getAttribute(key));
/*     */ 
/*  52 */     key = SystemParam.getParam("SessionDeptid");
/*  53 */     if (key == null) {
/*  54 */       key = "DEPT_ID";
/*     */     }
/*     */ 
/*  57 */     this.deptid = ((String)request.getSession().getAttribute(key));
/*     */ 
/*  59 */     this.remoteaddr = request.getRemoteAddr();
/*     */ 
/*  61 */     this.remoteport = Integer.valueOf(request.getRemotePort());
/*     */ 
/*  63 */     this.localaddr = request.getLocalAddr();
/*     */ 
/*  65 */     this.localpost = Integer.valueOf(request.getLocalPort());
/*     */   }
/*     */ 
/*     */   public String getUserid() {
/*  69 */     return this.userid;
/*     */   }
/*     */ 
/*     */   public void setUserid(String userid) {
/*  73 */     this.userid = userid;
/*     */   }
/*     */ 
/*     */   public String getUsername() {
/*  77 */     return this.username;
/*     */   }
/*     */ 
/*     */   public void setUsername(String username) {
/*  81 */     this.username = username;
/*     */   }
/*     */ 
/*     */   public String getDeptid() {
/*  85 */     return this.deptid;
/*     */   }
/*     */ 
/*     */   public void setDeptid(String deptid) {
/*  89 */     this.deptid = deptid;
/*     */   }
/*     */ 
/*     */   public String getDeptname() {
/*  93 */     return this.deptname;
/*     */   }
/*     */ 
/*     */   public void setDeptname(String deptname) {
/*  97 */     this.deptname = deptname;
/*     */   }
/*     */ 
/*     */   public String getRemoteaddr() {
/* 101 */     return this.remoteaddr;
/*     */   }
/*     */ 
/*     */   public void setRemoteaddr(String remoteaddr) {
/* 105 */     this.remoteaddr = remoteaddr;
/*     */   }
/*     */ 
/*     */   public Integer getRemoteport() {
/* 109 */     return this.remoteport;
/*     */   }
/*     */ 
/*     */   public void setRemoteport(Integer remoteport) {
/* 113 */     this.remoteport = remoteport;
/*     */   }
/*     */ 
/*     */   public String getLocaladdr() {
/* 117 */     return this.localaddr;
/*     */   }
/*     */ 
/*     */   public void setLocaladdr(String localaddr) {
/* 121 */     this.localaddr = localaddr;
/*     */   }
/*     */ 
/*     */   public Integer getLocalpost() {
/* 125 */     return this.localpost;
/*     */   }
/*     */ 
/*     */   public void setLocalpost(Integer localpost) {
/* 129 */     this.localpost = localpost;
/*     */   }
/*     */ 
/*     */   public Map<String, Object> getInfo() {
/* 133 */     return this.info;
/*     */   }
/*     */ 
/*     */   public void setInfo(Map<String, Object> info) {
/* 137 */     this.info = info;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.LoginInfo
 * JD-Core Version:    0.6.0
 */