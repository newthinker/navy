/*     */ package cn.com.hd.database;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Clob;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class SelectResultSet
/*     */ {
/*     */   int columnCount;
/*     */   int rowCount;
/*     */   String[] columnNames;
/*     */   int[] columnTypes;
/*     */   String[] columnTypeNames;
/*     */   Vector values;
/*     */ 
/*     */   public SelectResultSet(int columnCount)
/*     */   {
/*  30 */     this.columnCount = columnCount;
/*  31 */     this.rowCount = 0;
/*  32 */     this.columnNames = new String[columnCount];
/*  33 */     this.columnTypes = new int[columnCount];
/*  34 */     this.columnTypeNames = new String[columnCount];
/*  35 */     this.values = new Vector();
/*     */   }
/*     */ 
/*     */   public int getColumnCount() {
/*  39 */     return this.columnCount;
/*     */   }
/*     */ 
/*     */   public int getRowCount() {
/*  43 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   public Object getObjectValue(int columnIndex, int rowIndex) {
/*  47 */     Vector rowValues = (Vector)this.values.elementAt(rowIndex);
/*  48 */     return rowValues.elementAt(columnIndex);
/*     */   }
/*     */ 
/*     */   public int getIntValue(int columnIndex, int rowIndex) {
/*  52 */     int tempValue = 0;
/*     */     try {
/*  54 */       tempValue = ((BigDecimal)getObjectValue(columnIndex, rowIndex))
/*  55 */         .intValue();
/*     */     } catch (Exception e) {
/*  57 */       tempValue = 0;
/*     */     }
/*  59 */     return tempValue;
/*     */   }
/*     */ 
/*     */   public long getLongValue(int columnIndex, int rowIndex) {
/*  63 */     long tempValue = 0L;
/*     */     try {
/*  65 */       tempValue = ((BigDecimal)getObjectValue(columnIndex, rowIndex))
/*  66 */         .longValue();
/*     */     } catch (Exception e) {
/*  68 */       tempValue = 0L;
/*     */     }
/*  70 */     return tempValue;
/*     */   }
/*     */ 
/*     */   public double getDoubleValue(int columnIndex, int rowIndex) {
/*  74 */     double tempValue = 0.0D;
/*     */     try {
/*  76 */       tempValue = ((BigDecimal)getObjectValue(columnIndex, rowIndex))
/*  77 */         .doubleValue();
/*     */     } catch (Exception e) {
/*  79 */       tempValue = -1.0D;
/*     */     }
/*  81 */     return tempValue;
/*     */   }
/*     */ 
/*     */   public String getStringValue(int columnIndex, int rowIndex) {
/*  85 */     if ((String)getObjectValue(columnIndex, rowIndex) == null) {
/*  86 */       return "";
/*     */     }
/*  88 */     return (String)getObjectValue(columnIndex, rowIndex);
/*     */   }
/*     */ 
/*     */   public BigDecimal getBigDecimalValue(int columnIndex, int rowIndex) {
/*  92 */     return (BigDecimal)getObjectValue(columnIndex, rowIndex);
/*     */   }
/*     */ 
/*     */   public java.sql.Date getDateValue(int columnIndex, int rowIndex) {
/*  96 */     java.util.Date tempDate = null;
/*     */     try {
/*  98 */       tempDate = (java.util.Date)getObjectValue(columnIndex, rowIndex);
/*     */     } catch (Exception e) {
/* 100 */       tempDate = null;
/*     */     }
/* 102 */     if (tempDate == null) {
/* 103 */       return null;
/*     */     }
/* 105 */     return new java.sql.Date(tempDate.getTime());
/*     */   }
/*     */ 
/*     */   public java.util.Date getUtilDateValue(int columnIndex, int rowIndex) {
/* 109 */     java.util.Date tempDate = null;
/*     */     try {
/* 111 */       tempDate = (java.util.Date)getObjectValue(columnIndex, rowIndex);
/*     */     } catch (Exception e) {
/* 113 */       e.printStackTrace();
/* 114 */       tempDate = null;
/*     */     }
/* 116 */     if (tempDate == null) {
/* 117 */       return null;
/*     */     }
/* 119 */     return tempDate;
/*     */   }
/*     */ 
/*     */   public Blob getBlobValue(int columnIndex, int rowIndex) {
/* 123 */     Blob tempBlob = null;
/*     */     try {
/* 125 */       tempBlob = (Blob)getObjectValue(columnIndex, rowIndex);
/*     */     } catch (Exception e) {
/* 127 */       e.printStackTrace();
/* 128 */       tempBlob = null;
/*     */     }
/*     */ 
/* 131 */     if (tempBlob == null) {
/* 132 */       return null;
/*     */     }
/* 134 */     return tempBlob;
/*     */   }
/*     */ 
/*     */   public Clob getClobValue(int columnIndex, int rowIndex) {
/* 138 */     Clob tempClob = null;
/*     */     try {
/* 140 */       tempClob = (Clob)getObjectValue(columnIndex, rowIndex);
/*     */     } catch (Exception e) {
/* 142 */       e.printStackTrace();
/* 143 */       tempClob = null;
/*     */     }
/*     */ 
/* 146 */     if (tempClob == null) {
/* 147 */       return null;
/*     */     }
/* 149 */     return tempClob;
/*     */   }
/*     */ 
/*     */   public void setColumnName(int columnIndex, String columnName) {
/* 153 */     this.columnNames[columnIndex] = columnName;
/*     */   }
/*     */ 
/*     */   public String getColumnName(int columnIndex) {
/* 157 */     return this.columnNames[columnIndex];
/*     */   }
/*     */ 
/*     */   public void setColumnType(int columnIndex, int columnType) {
/* 161 */     this.columnTypes[columnIndex] = columnType;
/*     */   }
/*     */ 
/*     */   public int getColumnType(int columnIndex) {
/* 165 */     return this.columnTypes[columnIndex];
/*     */   }
/*     */ 
/*     */   public void setColumnTypeName(int columnIndex, String columnTypeName) {
/* 169 */     this.columnTypeNames[columnIndex] = columnTypeName;
/*     */   }
/*     */ 
/*     */   public String getColumnTypeName(int columnIndex) {
/* 173 */     return this.columnTypeNames[columnIndex];
/*     */   }
/*     */ 
/*     */   public void addRowValues(Vector rowValues) {
/* 177 */     this.values.addElement(rowValues);
/* 178 */     this.rowCount += 1;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.database.SelectResultSet
 * JD-Core Version:    0.6.0
 */