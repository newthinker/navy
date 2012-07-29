/*    */ package cn.com.hd.database;
/*    */ 
/*    */ import cn.com.hd.error.Debug;
/*    */ import java.sql.Connection;
/*    */ import java.util.Enumeration;
/*    */ import java.util.Hashtable;
/*    */ 









/*    */ public class DBConnectionManager
/*    */ {
/*    */   private static DBConnectionManager instance;
/*    */   private Hashtable dbConnectionPools;
/* 21 */   private SystemClear P_SystemClear = null;
/*    */ 
/*    */   public static synchronized DBConnectionManager getInstance() {
/* 24 */     if (instance == null)
/* 25 */       instance = new DBConnectionManager();
/* 26 */     return instance;
/*    */   }
/*    */ 
/*    */   private DBConnectionManager() {
/* 30 */     this.dbConnectionPools = new Hashtable();
/* 31 */     this.P_SystemClear = new SystemClear();
/* 32 */     this.P_SystemClear.start();
/*    */   }
/*    */ 
/*    */   public void registerDBConnectionPool(String sSubSystemName) {
/* 36 */     DBConnectionPool dbConnectionPool = (DBConnectionPool)this.dbConnectionPools.get(sSubSystemName);
/* 37 */     if (dbConnectionPool != null) {
/* 38 */       Debug.debugMessage(1, "", sSubSystemName, "registerDBConnectionPool", String.valueOf(
/* 39 */         new StringBuffer("连接名(").append(sSubSystemName).append(")已经存在。")));
/*    */     } else {
/* 41 */       dbConnectionPool = new DBConnectionPool(sSubSystemName);
/* 42 */       this.dbConnectionPools.put(sSubSystemName, dbConnectionPool);
/*    */     }
/*    */   }
/*    */ 
/*    */   public Connection getConnection(String connectionName) {
/* 47 */     DBConnectionPool pool = 
/* 48 */       (DBConnectionPool)this.dbConnectionPools.get(connectionName);
/* 49 */     if (pool != null) {
/* 50 */       return pool.getConnection(500L);
/*    */     }
/* 52 */     return null;
/*    */   }
/*    */ 
/*    */   public Connection getConnection(String connectionName, long timeout) {
/* 56 */     DBConnectionPool pool = 
/* 57 */       (DBConnectionPool)this.dbConnectionPools.get(connectionName);
/* 58 */     if (pool != null) {
/* 59 */       return pool.getConnection(timeout);
/*    */     }
/* 61 */     return null;
/*    */   }
/*    */ 
/*    */   public void freeConnection(String connectionName, Connection connection) {
/* 65 */     DBConnectionPool pool = 
/* 66 */       (DBConnectionPool)this.dbConnectionPools.get(connectionName);
/* 67 */     if (pool != null)
/* 68 */       pool.freeConnection(connection);
/*    */   }
/*    */ 








/*    */   public void freeAllConections()
/*    */   {
/* 81 */     Enumeration V_Sets = this.dbConnectionPools.keys();
/* 82 */     while (V_Sets.hasMoreElements()) {
/* 83 */       DBConnectionPool dbConnectionPool = 
/* 84 */         (DBConnectionPool)this.dbConnectionPools.get(V_Sets.nextElement());
/* 85 */       dbConnectionPool.closeAllConnection();
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getConnectionAmount(String connectionName) {
/* 90 */     DBConnectionPool pool = 
/* 91 */       (DBConnectionPool)this.dbConnectionPools.get(connectionName);
/* 92 */     if (pool != null) {
/* 93 */       return pool.getConnectionAmount();
/*    */     }
/* 95 */     return -1;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.database.DBConnectionManager
 * JD-Core Version:    0.6.0
 */