/*    */ package cn.com.hd.database;
/*    */ 
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.transfer.SystemParam;
/*    */ import cn.com.hd.xmlparser.DBLinkXMLParser;
/*    */ import java.sql.Connection;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Vector;
/*    */ import javax.naming.InitialContext;
/*    */ import javax.sql.DataSource;
/*    */ 







/*    */ public class Database
/*    */ {
/* 22 */   static Map<String, Vector> mConnections = new HashMap();
/* 23 */   static String sName = null;
/*    */ 
/*    */   private static void createConnection(int amount, String sSubSystemame)
/*    */   {

/*    */     try
/*    */     {
/* 30 */       String sJndiName = DBLinkXMLParser.getJndiName(sSubSystemame);
/* 31 */       Connection conn = null;
/* 32 */       for (int i = 0; i < amount; i++) {
/* 33 */         InitialContext cx = new InitialContext();
/* 34 */         DataSource dataSource = (DataSource)cx.lookup(SystemParam.getParam("ApplicationServiceName") + sJndiName);
/* 35 */         conn = dataSource.getConnection();
/* 36 */         conn.setAutoCommit(false);
/*    */ 
/* 38 */         Vector vConnections = (Vector)mConnections.get(sSubSystemame);
/* 39 */         if (vConnections == null) {
/* 40 */           vConnections = new Vector();
/*    */         }
/* 42 */         vConnections.add(conn);
/* 43 */         mConnections.put(sSubSystemame, vConnections);
/*    */       }
/*    */     }
/*    */     catch (Exception ex) {
/* 47 */       ErrorProcessor.prompt("Database", "createConnection() error!", ex);
/*    */     }
/*    */   }
/*    */ 
/*    */   public static Connection borrowConnection(String sSubSystemname) {
/* 52 */     Connection conn = null;
/* 53 */     Vector vConnections = (Vector)mConnections.get(sSubSystemname);
/* 54 */     if ((vConnections != null) && (vConnections.size() > 0)) {
/* 55 */       conn = (Connection)vConnections.remove(0);
/*    */     } else {
/* 57 */       createConnection(1, sSubSystemname);
/* 58 */       vConnections = (Vector)mConnections.get(sSubSystemname);
/* 59 */       conn = (Connection)vConnections.remove(0);
/*    */     }
/* 61 */     return conn;
/*    */   }
/*    */ 
/*    */   public static void returnConnection(Connection conn, String sSubSystemname) {
/*    */     try {
/* 66 */       conn.rollback();
/* 67 */       Vector vConnections = (Vector)mConnections.get(sSubSystemname);
/* 68 */       vConnections.addElement(conn);
/* 69 */       mConnections.put(sSubSystemname, vConnections);
/*    */     } catch (Exception ex) {
/* 71 */       createConnection(1, sSubSystemname);
/* 72 */       ErrorProcessor.prompt("Database", "returnConnection() error!", ex);
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.database.Database
 * JD-Core Version:    0.6.0
 */