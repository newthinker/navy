/*    */ package cn.com.hd.database;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class SystemClear extends Thread
/*    */ {
/*    */   protected long P_LastGarbageCollectTime;
/*    */   protected long P_LastAccessTime;
/* 15 */   protected int P_GarbageCollectTimeOut = 600000;
/* 16 */   protected int P_ResetMemoryTimeOut = 7200000;
/* 17 */   protected boolean P_IsExited = false;
/*    */ 
/*    */   public SystemClear()
/*    */   {
/* 21 */     this.P_LastGarbageCollectTime = System.currentTimeMillis();
/* 22 */     this.P_LastAccessTime = System.currentTimeMillis();
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 27 */     int V_SleepTime = 60000;
/* 28 */     while (!isExited())
/*    */     {
/* 30 */       Sleep(V_SleepTime);
/* 31 */       garbageCollect();
/*    */     }
/*    */   }
/*    */ 
/*    */   private void garbageCollect() {
/* 36 */     if (System.currentTimeMillis() - this.P_LastGarbageCollectTime < this.P_GarbageCollectTimeOut) {
/* 37 */       return;
/*    */     }
/*    */ 
/* 40 */     Runtime V_Runtime = Runtime.getRuntime();
/* 41 */     StringBuffer V_Msg = new StringBuffer();
/*    */ 
/* 43 */     V_Msg.append(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
/* 44 */     V_Msg.append(">>  runFinalization and GarbageCollector running...");
/*    */ 
/* 47 */     V_Runtime.runFinalization();
/* 48 */     V_Runtime.gc();
/*    */ 
/* 50 */     V_Msg.setLength(0);
/* 51 */     V_Msg.append(new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()));
/* 52 */     V_Msg.append(">>  end of runFinalization and  GarbageCollector running");
/*    */ 
/* 54 */     this.P_LastGarbageCollectTime = System.currentTimeMillis();
/*    */   }
/*    */ 
/*    */   private void resetMemory()
/*    */   {
/* 59 */     if (System.currentTimeMillis() - this.P_LastAccessTime < this.P_ResetMemoryTimeOut)
/* 60 */       return;
/*    */   }
/*    */ 
/*    */   public synchronized void setSystemRunning()
/*    */   {
/* 65 */     this.P_LastAccessTime = System.currentTimeMillis();
/*    */   }
/*    */ 
/*    */   public boolean isExited()
/*    */   {
/* 70 */     return this.P_IsExited;
/*    */   }
/*    */   private synchronized void Sleep(int I_MillSec) {
/*    */     try {
/* 74 */       sleep(I_MillSec);
/*    */     }
/*    */     catch (Exception localException)
/*    */     {
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.database.SystemClear
 * JD-Core Version:    0.6.0
 */