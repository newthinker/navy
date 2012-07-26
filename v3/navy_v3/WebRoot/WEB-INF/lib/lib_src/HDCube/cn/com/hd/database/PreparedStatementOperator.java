/*     */ package cn.com.hd.database;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Clob;
/*     */ import java.util.Date;
/*     */ import java.util.Vector;
/*     */ 
/*     */ public class PreparedStatementOperator
/*     */ {
/*     */   String sql;
/*     */   Vector parameterTypes;
/*     */   Vector parameters;
/*     */   Vector parameterLength;
/*     */   int size;
/*     */ 
/*     */   public PreparedStatementOperator()
/*     */   {
/*  25 */     this.parameterTypes = new Vector();
/*  26 */     this.parameters = new Vector();
/*  27 */     this.parameterLength = new Vector();
/*  28 */     this.size = 0;
/*     */   }
/*     */ 
/*     */   public PreparedStatementOperator(String sql)
/*     */   {
/*  33 */     this.sql = sql;
/*  34 */     this.parameterTypes = new Vector();
/*  35 */     this.parameters = new Vector();
/*  36 */     this.parameterLength = new Vector();
/*  37 */     this.size = 0;
/*     */   }
/*     */ 
/*     */   public void setSql(String sql)
/*     */   {
/*  42 */     this.sql = sql;
/*     */   }
/*     */ 
/*     */   public void setSqlStr(String sql)
/*     */   {
/*  47 */     this.sql = sql;
/*     */   }
/*     */ 
/*     */   public String getSql()
/*     */   {
/*  52 */     return this.sql;
/*     */   }
/*     */ 
/*     */   public int size()
/*     */   {
/*  57 */     return this.size;
/*     */   }
/*     */ 
/*     */   public void addParameter(int index, int parameterType, Object parameter)
/*     */   {
/*  62 */     this.parameterTypes.add(index, new Integer(parameterType));
/*  63 */     this.parameters.add(index, parameter);
/*  64 */     this.parameterLength.add(Integer.valueOf(-1));
/*  65 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public void addParameter(int parameterType, Object parameter)
/*     */   {
/*  71 */     this.parameterTypes.add(new Integer(parameterType));
/*  72 */     this.parameters.add(parameter);
/*  73 */     this.parameterLength.add(Integer.valueOf(-1));
/*  74 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public void addParameter(int parameterType, InputStream parameter, int length)
/*     */   {
/*  79 */     this.parameterTypes.add(new Integer(parameterType));
/*  80 */     this.parameters.add(parameter);
/*  81 */     this.parameterLength.add(Integer.valueOf(length));
/*  82 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public void addParameter(int index, int parameterType, InputStream parameter, int length)
/*     */   {
/*  87 */     this.parameterTypes.add(index, new Integer(parameterType));
/*  88 */     this.parameters.add(index, parameter);
/*  89 */     this.parameterLength.add(index, Integer.valueOf(length));
/*  90 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public void addParameter(int index, int parameterType, int parameter)
/*     */   {
/*  95 */     this.parameterTypes.add(index, new Integer(parameterType));
/*  96 */     this.parameters.add(index, new Integer(parameter));
/*  97 */     this.parameterLength.add(Integer.valueOf(-1));
/*  98 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public void addParameter(int index, int parameterType, long parameter)
/*     */   {
/* 103 */     this.parameterTypes.add(index, new Integer(parameterType));
/* 104 */     this.parameters.add(index, new Long(parameter));
/* 105 */     this.parameterLength.add(Integer.valueOf(-1));
/* 106 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public void addParameter(int index, int parameterType, double parameter)
/*     */   {
/* 111 */     this.parameterTypes.add(index, new Integer(parameterType));
/* 112 */     this.parameters.add(index, new Double(parameter));
/* 113 */     this.parameterLength.add(Integer.valueOf(-1));
/* 114 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public void addParameter(int parameterType, int parameter)
/*     */   {
/* 119 */     this.parameterTypes.add(new Integer(parameterType));
/* 120 */     this.parameters.add(new Integer(parameter));
/* 121 */     this.parameterLength.add(Integer.valueOf(-1));
/* 122 */     this.size += 1;
/*     */   }
/*     */ 
/*     */   public int parameterTypeAt(int index)
/*     */   {
/* 127 */     return ((Integer)this.parameterTypes.elementAt(index)).intValue();
/*     */   }
/*     */ 
/*     */   public int parameterLengthAt(int index) {
/* 131 */     return ((Integer)this.parameterLength.elementAt(index)).intValue();
/*     */   }
/*     */ 
/*     */   public Object parameterAt(int index)
/*     */   {
/* 136 */     return this.parameters.elementAt(index);
/*     */   }
/*     */ 
/*     */   public String stringParameterAt(int index)
/*     */   {
/* 141 */     return (String)this.parameters.elementAt(index);
/*     */   }
/*     */ 
/*     */   public Blob blobParameterAt(int index) {
/* 145 */     return (Blob)this.parameters.elementAt(index);
/*     */   }
/*     */ 
/*     */   public Clob clobParameterAt(int index) {
/* 149 */     return (Clob)this.parameters.elementAt(index);
/*     */   }
/*     */ 
/*     */   public Date dateParameterAt(int index)
/*     */   {
/* 154 */     return (Date)this.parameters.elementAt(index);
/*     */   }
/*     */ 
/*     */   public int intParameterAt(int index)
/*     */   {
/* 159 */     return ((Integer)this.parameters.elementAt(index)).intValue();
/*     */   }
/*     */ 
/*     */   public long longParameterAt(int index)
/*     */   {
/* 164 */     return ((Long)this.parameters.elementAt(index)).longValue();
/*     */   }
/*     */ 
/*     */   public double doubleParameterAt(int index)
/*     */   {
/* 169 */     return ((Double)this.parameters.elementAt(index)).doubleValue();
/*     */   }
/*     */ 
/*     */   public InputStream inputStreamParameterAt(int index) {
/* 173 */     return (InputStream)this.parameters.elementAt(index);
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.database.PreparedStatementOperator
 * JD-Core Version:    0.6.0
 */