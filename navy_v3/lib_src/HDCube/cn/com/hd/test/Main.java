/*    */ package cn.com.hd.test;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.PrintStream;
/*    */ import jxl.Sheet;
/*    */ import jxl.Workbook;
/*    */ 
/*    */ public class Main
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 11 */       Workbook excel = Workbook.getWorkbook(new File("e:/supportor1.txt"));
/* 12 */       System.out.println(excel.getSheets().length);
/* 13 */       sheet = excel.getSheet(0);
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/*    */       Sheet sheet;
/* 15 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.test.Main
 * JD-Core Version:    0.6.0
 */