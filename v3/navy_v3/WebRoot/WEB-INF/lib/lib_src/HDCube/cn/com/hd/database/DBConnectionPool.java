/*    */ package cn.com.hd.database;
/*    */ 
/*    */ import cn.com.hd.error.ErrorProcessor;
/*    */ import cn.com.hd.xmlparser.DBLinkXMLParser;
/*    */ import java.sql.Connection;
/*    */ import java.util.Date;
/*    */ import java.util.Vector;
/*    */ 
/*    */ public class DBConnectionPool
/*    */ {
/*    */   private Vector connections;
/*    */   private String sSubSystemName;
/*    */ 
/*    */   public DBConnectionPool(String sSubSystemName)
/*    */   {
/* 24 */     this.sSubSystemName = sSubSystemName;
/* 25 */     String sJndiName = DBLinkXMLParser.getJndiName(sSubSystemName);
/* 26 */     if (sJndiName == null) {
/* 27 */       ErrorProcessor.prompt(getClass().getName(), "not found JNDI Name for " + sSubSystemName, null);
/*    */     }
/* 29 */     Database.sName = sJndiName;
/* 30 */     this.connections = new Vector();
/*    */   }
/*    */ 
/*    */   public synchronized Connection getConnection(long timeout)
/*    */   {
/* 35 */     long startTime = new Date().getTime();
/*    */ 
/* 37 */     for (Connection connection = null; (connection = Database.borrowConnection(this.sSubSystemName)) == null; ) {
/*    */       try {
/* 39 */         wait(timeout);
/*    */       } catch (InterruptedException localInterruptedException) {
/*    */       }
/* 42 */       if (new Date().getTime() - startTime >= timeout) {
/* 43 */         return null;
/*    */       }
/*    */     }
/* 46 */     return connection;
/*    */   }
/*    */ 
/*    */   public synchronized void freeConnection(Connection connection) {
/* 50 */     if (connection == null)
/* 51 */       return;
/*    */     try {
/* 53 */       Database.returnConnection(connection, this.sSubSystemName);
/* 54 */       notifyAll();
/*    */     } catch (Exception ex) {
/* 56 */       ErrorProcessor.prompt(getClass().getName(), "freeConnection() error.", ex);
/*    */       try {
/* 58 */         connection.close();
/*    */       } catch (Exception localException1) {
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public synchronized void closeAllConnection() {
/* 65 */     while (this.connections.size() > 0) {
/* 66 */       Connection connection = (Connection)this.connections.remove(0);
/*    */       try {
/* 68 */         connection.close();
/*    */       }
/*    */       catch (Exception localException)
/*    */       {
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getConnectionAmount() {
/* 77 */     return this.connections.size();
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.database.DBConnectionPool
 * JD-Core Version:    0.6.0
 */