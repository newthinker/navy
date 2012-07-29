/*     */ package cn.com.hd.database;
/*     */ 
/*     */ import cn.com.hd.error.Debug;
/*     */ import cn.com.hd.error.ErrorProcessor;
/*     */ import cn.com.hd.error.SystemException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.StringReader;
/*     */ import java.math.BigDecimal;
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.Statement;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Vector;
/*     */ import oracle.sql.BLOB;
/*     */ 










/*     */ public class DBOperator
/*     */ {
/*  34 */   public static int NUMBER = 2;
/*  35 */   public static int LONGNUMBER = 3;
/*  36 */   public static int DOUBLENUMBER = 4;
/*  37 */   public static int BIGDECIMAL = 5;
/*  38 */   public static int VARCHAR2 = 12;
/*  39 */   public static int DATE = 93;
/*  40 */   public static int BLOB = 2004;
/*  41 */   public static int CLOB = 2005;
/*     */   String sSubSystemName;
/*     */   String sSystemName;
/*     */   String sServiceName;
/*     */   Connection connection;
/*     */   DBConnectionManager dbConnectionManager;
/*     */   public DBOperator(String sSystemName, String sServiceName, String sSubSystemName)
/*     */   {
/*  49 */     this.connection = null;
/*     */     try {
/*  51 */       this.sSystemName = sSystemName;
/*  52 */       this.sSubSystemName = sSubSystemName;
/*  53 */       this.sServiceName = sServiceName;
/*  54 */       this.dbConnectionManager = DBConnectionManager.getInstance();
/*  55 */       this.connection = this.dbConnectionManager.getConnection(sSubSystemName);
/*     */     } catch (Exception ex) {
/*  57 */       ErrorProcessor.prompt(getClass().getName(), 
/*  58 */         String.valueOf(String.valueOf(new StringBuffer("DBOperator(")
/*  59 */         .append(sSubSystemName)
/*  60 */         .append(") Structure error!"))), ex);
/*  61 */       this.connection = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean isValid() {
/*  66 */     return this.connection != null;
/*     */   }
/*     */ 
/*     */   public Connection getConnection() {
/*  70 */     return this.connection;
/*     */   }
/*     */ 
/*     */   public int executePreparedStatement(PreparedStatementOperator pso) throws Exception {
/*  74 */     if (this.connection == null)
/*  75 */       return -1;
/*  76 */     PreparedStatement preparedStatement = null;
/*  77 */     Vector vReader = new Vector();
/*     */     try {
/*  79 */       preparedStatement = this.connection.prepareStatement(pso.getSql());
/*  80 */       for (int i = 0; i < pso.size(); i++) {
/*  81 */         switch (pso.parameterTypeAt(i)) {
/*     */         default:
/*  83 */           break;

/*     */         case 2:
/*  86 */           preparedStatement.setInt(i + 1, pso.intParameterAt(i));
/*  87 */           break;

/*     */         case 3:
/*  90 */           preparedStatement.setLong(i + 1, pso.longParameterAt(i));
/*  91 */           break;

/*     */         case 4:
/*  94 */           preparedStatement
/*  95 */             .setDouble(i + 1, pso.doubleParameterAt(i));
/*  96 */           break;

/*     */         case 5:
/*  99 */           preparedStatement.setBigDecimal(i + 1, (BigDecimal)
/* 100 */             pso.parameterAt(i));
/* 101 */           break;

/*     */         case 12:
/* 104 */           if (pso.stringParameterAt(i) == null) {
/* 105 */             preparedStatement.setString(i + 1, 
/* 106 */               pso.stringParameterAt(i));
/*     */           } else {
/* 108 */             StringReader sr = new StringReader(
/* 109 */               pso.stringParameterAt(i));
/* 110 */             preparedStatement.setCharacterStream(i + 1, sr, 
/* 111 */               pso.stringParameterAt(i).length());
/* 112 */             vReader.add(sr);
/*     */           }
/* 114 */           break;

/*     */         case 93:
/* 117 */           preparedStatement.setTimestamp(i + 1, 
/* 118 */             new Timestamp(pso.dateParameterAt(i).getTime()));
/* 119 */           break;

/*     */         case 2004:
/* 122 */           preparedStatement.setBinaryStream(i + 1, pso.inputStreamParameterAt(i), pso.parameterLengthAt(i));
/* 123 */           break;
/*     */         case 2005:
/* 125 */           preparedStatement.setAsciiStream(i + 1, pso.inputStreamParameterAt(i), pso.parameterLengthAt(i));
/*     */         }
/*     */       }
/*     */ 
/* 129 */       preparedStatement.execute();
/* 130 */       preparedStatement.close();
/* 131 */       preparedStatement = null;
/*     */       try {
/* 133 */         for (int i = 0; i < vReader.size(); i++)
/* 134 */           ((StringReader)vReader.elementAt(i)).close();
/*     */       } catch (Exception localException1) {
/*     */       }
/*     */     }
/*     */     catch (Exception ex) {
/* 139 */       ErrorProcessor.prompt(getClass().getName(), 
/* 140 */         "executePreparedStatement() error!", ex);
/*     */       try {
/* 142 */         preparedStatement.close();
/* 143 */         preparedStatement = null;
/*     */       } catch (Exception localException2) {
/*     */       }
/* 146 */       returnConnection();
/* 147 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 149 */     return 1;
/*     */   }
/*     */ 
/*     */   public int executePreparedStatement(PreparedStatementOperator pso, InputStream inputStream) throws Exception
/*     */   {
/* 154 */     ResultSet resultSet = null;
/* 155 */     int errorCode = 0;
/* 156 */     int writeAllLength = 0;
/* 157 */     if (this.connection == null)
/* 158 */       return -1;
/* 159 */     PreparedStatement preparedStatement = null;
/*     */     try {
/* 161 */       preparedStatement = this.connection.prepareStatement(pso.getSql());
/* 162 */       for (int i = 0; i < pso.size(); i++) {
/* 163 */         switch (pso.parameterTypeAt(i)) {
/*     */         case 2:
/* 165 */           preparedStatement.setInt(i + 1, pso.intParameterAt(i));
/* 166 */           break;

/*     */         case 3:
/* 169 */           preparedStatement.setLong(i + 1, pso.longParameterAt(i));
/* 170 */           break;

/*     */         case 4:
/* 173 */           preparedStatement
/* 174 */             .setDouble(i + 1, pso.doubleParameterAt(i));
/* 175 */           break;

/*     */         case 5:
/* 178 */           preparedStatement.setBigDecimal(i + 1, (BigDecimal)
/* 179 */             pso.parameterAt(i));
/* 180 */           break;

/*     */         case 12:
/* 183 */           preparedStatement
/* 184 */             .setString(i + 1, pso.stringParameterAt(i));
/* 185 */           break;

/*     */         case 93:
/* 188 */           preparedStatement.setTimestamp(i + 1, 
/* 189 */             new Timestamp(pso.dateParameterAt(i).getTime()));
/* 190 */           break;
/*     */         case 2004:
/* 192 */           preparedStatement.setBlob(i + 1, pso.blobParameterAt(i));
/* 193 */           break;
/*     */         case 2005:
/* 195 */           preparedStatement.setClob(i + 1, pso.clobParameterAt(i));
/*     */         }
/*     */       }
/*     */ 
/* 199 */       resultSet = preparedStatement.executeQuery();
/* 200 */       resultSet.next();
/* 201 */       BLOB blob = (BLOB)resultSet.getBlob(1);
/* 202 */       errorCode = 4;
/* 203 */       if (blob == null)
/* 204 */         Debug.debugMessage(1, this.sSystemName, this.sSubSystemName, this.sServiceName, "blob is none");
/* 205 */       writeAllLength = writeBlob(inputStream, blob);
/* 206 */       resultSet.close();
/* 207 */       resultSet = null;
/* 208 */       preparedStatement.close();
/* 209 */       preparedStatement = null;
/*     */     } catch (Exception ex) {
/* 211 */       ErrorProcessor.prompt(getClass().getName(), 
/* 212 */         "executePreparedStatement() error!", ex);
/*     */       try {
/* 214 */         if (resultSet != null) {
/* 215 */           resultSet.close();
/* 216 */           resultSet = null;
/*     */         }
/* 218 */         if (preparedStatement != null) {
/* 219 */           preparedStatement.close();
/* 220 */           preparedStatement = null;
/*     */         }
/*     */       } catch (Exception exception) {
/* 223 */         exception.printStackTrace();
/*     */       }
/* 225 */       returnConnection();
/* 226 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 228 */     return 1;
/*     */   }
/*     */ 
/*     */   public int executePreparedStatement(PreparedStatementOperator pso, OutputStream outputStream) throws Exception
/*     */   {
/* 233 */     ResultSet resultSet = null;
/* 234 */     int errorCode = 0;
/* 235 */     int writeAllLength = 0;
/* 236 */     if (this.connection == null)
/* 237 */       return -1;
/* 238 */     PreparedStatement preparedStatement = null;
/*     */     try {
/* 240 */       preparedStatement = this.connection.prepareStatement(pso.getSql());
/* 241 */       for (int i = 0; i < pso.size(); i++) {
/* 242 */         switch (pso.parameterTypeAt(i)) {
/*     */         case 2:
/* 244 */           preparedStatement.setInt(i + 1, pso.intParameterAt(i));
/* 245 */           break;

/*     */         case 3:
/* 248 */           preparedStatement.setLong(i + 1, pso.longParameterAt(i));
/* 249 */           break;

/*     */         case 4:
/* 252 */           preparedStatement
/* 253 */             .setDouble(i + 1, pso.doubleParameterAt(i));
/* 254 */           break;

/*     */         case 5:
/* 257 */           preparedStatement.setBigDecimal(i + 1, (BigDecimal)
/* 258 */             pso.parameterAt(i));
/* 259 */           break;

/*     */         case 12:
/* 262 */           preparedStatement
/* 263 */             .setString(i + 1, pso.stringParameterAt(i));
/* 264 */           break;

/*     */         case 93:
/* 267 */           preparedStatement.setDate(i + 1, 
/* 268 */             new java.sql.Date(pso.dateParameterAt(i).getTime()));
/* 269 */           break;
/*     */         case 2004:
/* 271 */           preparedStatement.setBlob(i + 1, pso.blobParameterAt(i));
/* 272 */           break;
/*     */         case 2005:
/* 274 */           preparedStatement.setClob(i + 1, pso.clobParameterAt(i));
/*     */         }
/*     */       }
/*     */ 
/* 278 */       resultSet = preparedStatement.executeQuery();
/* 279 */       resultSet.next();
/* 280 */       BLOB blob = (BLOB)resultSet.getBlob(1);
/* 281 */       errorCode = 4;
/* 282 */       if (blob == null)
/* 283 */         System.out.println("blob is none");
/* 284 */       writeAllLength = readBlob(outputStream, blob);
/* 285 */       resultSet.close();
/* 286 */       resultSet = null;
/* 287 */       preparedStatement.close();
/* 288 */       preparedStatement = null;
/*     */     } catch (Exception ex) {
/* 290 */       ErrorProcessor.prompt(getClass().getName(), 
/* 291 */         "executePreparedStatement() error!", ex);
/*     */       try {
/* 293 */         if (resultSet != null) {
/* 294 */           resultSet.close();
/* 295 */           resultSet = null;
/*     */         }
/* 297 */         if (preparedStatement != null) {
/* 298 */           preparedStatement.close();
/* 299 */           preparedStatement = null;
/*     */         }
/*     */       }
/*     */       catch (Exception exception) {
/* 303 */         exception.printStackTrace();
/*     */       }
/* 305 */       returnConnection();
/* 306 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 308 */     return 1;
/*     */   }
/*     */ 
/*     */   public SelectResultSet executeSelect(PreparedStatementOperator pso) throws Exception {
/* 312 */     SelectResultSet selectResultSet = null;
/* 313 */     ResultSet resultSet = null;
/* 314 */     PreparedStatement preparedStatement = null;
/* 315 */     if (this.connection == null)
/* 316 */       return null;
/*     */     try {
/* 318 */       preparedStatement = this.connection.prepareStatement(pso.getSql());
/* 319 */       for (int i = 0; i < pso.size(); i++) {
/* 320 */         switch (pso.parameterTypeAt(i)) {
/*     */         case 2:
/* 322 */           preparedStatement.setInt(i + 1, pso.intParameterAt(i));
/* 323 */           break;

/*     */         case 3:
/* 326 */           preparedStatement.setLong(i + 1, pso.longParameterAt(i));
/* 327 */           break;

/*     */         case 4:
/* 330 */           preparedStatement
/* 331 */             .setDouble(i + 1, pso.doubleParameterAt(i));
/* 332 */           break;

/*     */         case 5:
/* 335 */           preparedStatement.setBigDecimal(i + 1, (BigDecimal)
/* 336 */             pso.parameterAt(i));
/* 337 */           break;

/*     */         case 12:
/* 340 */           preparedStatement
/* 341 */             .setString(i + 1, pso.stringParameterAt(i));
/* 342 */           break;

/*     */         case 93:
/* 345 */           preparedStatement.setDate(i + 1, 
/* 346 */             new java.sql.Date(pso.dateParameterAt(i).getTime()));
/*     */         }
/*     */       }
/*     */ 
/* 350 */       resultSet = preparedStatement.executeQuery();
/*     */     } catch (Exception ex) {
/* 352 */       ErrorProcessor.prompt(getClass().getName(), 
/* 353 */         "executeSelect() error!", ex);
/*     */       try {
/* 355 */         preparedStatement.close();
/* 356 */         preparedStatement = null;
/*     */       } catch (Exception exception) {
/* 358 */         exception.printStackTrace();
/*     */       }
/* 360 */       returnConnection();
/* 361 */       SelectResultSet selectresultset = null;
/* 362 */       SelectResultSet selectresultset2 = selectresultset;
/* 363 */       return selectresultset2;
/*     */     }
/*     */     try {
/* 366 */       ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
/* 367 */       int columnCount = resultSetMetaData.getColumnCount();
/* 368 */       selectResultSet = new SelectResultSet(columnCount);
/* 369 */       for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
/* 370 */         selectResultSet.setColumnName(columnIndex, 
/* 371 */           resultSetMetaData.getColumnName(columnIndex + 1));
/* 372 */         selectResultSet.setColumnType(columnIndex, 
/* 373 */           resultSetMetaData.getColumnType(columnIndex + 1));
/* 374 */         selectResultSet.setColumnTypeName(columnIndex, 
/* 375 */           resultSetMetaData.getColumnTypeName(columnIndex + 1));
/*     */       }
/*     */ 
/* 378 */       for (int rowIndex = 0; resultSet.next(); rowIndex++) {
/* 379 */         Vector rowValues = new Vector();
/* 380 */         for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
/*     */         {




/* 386 */           if (resultSetMetaData.getColumnTypeName(columnIndex + 1).equals("DATE"))
/* 387 */             rowValues.addElement(
/* 388 */               resultSet.getTimestamp(columnIndex + 1));
/*     */           else {
/* 390 */             rowValues.addElement(
/* 391 */               resultSet.getObject(columnIndex + 1));
/*     */           }
/*     */         }
/* 394 */         selectResultSet.addRowValues(rowValues);
/*     */       }
/*     */ 
/* 397 */       resultSet.close();
/* 398 */       preparedStatement.close();
/* 399 */       resultSet = null;
/* 400 */       preparedStatement = null;
/*     */     } catch (Exception ex) {
/* 402 */       ErrorProcessor.prompt(getClass().getName(), 
/* 403 */         String.valueOf(String.valueOf(new StringBuffer(
/* 404 */         "executeSelect(").append(this.sSubSystemName).append(
/* 405 */         ") error!"))), ex);
/*     */       try {
/* 407 */         if (resultSet != null) {
/* 408 */           resultSet.close();
/* 409 */           resultSet = null;
/*     */         }
/*     */       } catch (Exception localException1) {
/*     */       }
/*     */       try {
/* 414 */         if (preparedStatement != null) {
/* 415 */           preparedStatement.close();
/* 416 */           preparedStatement = null;
/*     */         }
/*     */       } catch (Exception exception2) {
/* 419 */         exception2.printStackTrace();
/*     */       }
/* 421 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 423 */     return selectResultSet;
/*     */   }
/*     */ 
/*     */   public SelectResultSet executeSelect(String sqlString) throws Exception {
/* 427 */     if (sqlString == null)
/* 428 */       return null;
/* 429 */     SelectResultSet selectResultSet = null;
/* 430 */     Statement statement = null;
/* 431 */     ResultSet resultSet = null;
/*     */     try {
/* 433 */       statement = this.connection.createStatement();
/* 434 */       resultSet = statement.executeQuery(sqlString);
/* 435 */       ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
/* 436 */       int columnCount = resultSetMetaData.getColumnCount();
/* 437 */       selectResultSet = new SelectResultSet(columnCount);
/* 438 */       for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
/* 439 */         selectResultSet.setColumnName(columnIndex, 
/* 440 */           resultSetMetaData.getColumnName(columnIndex + 1));
/* 441 */         selectResultSet.setColumnType(columnIndex, 
/* 442 */           resultSetMetaData.getColumnType(columnIndex + 1));
/* 443 */         selectResultSet.setColumnTypeName(columnIndex, 
/* 444 */           resultSetMetaData.getColumnTypeName(columnIndex + 1));
/*     */       }
/*     */ 
/* 447 */       for (int rowIndex = 0; resultSet.next(); rowIndex++) {
/* 448 */         Vector rowValues = new Vector();




/* 449 */         for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
/*     */         {
/* 455 */           if (resultSetMetaData.getColumnTypeName(columnIndex + 1).equals("DATE")) 
/* 456 */             rowValues.addElement(
/* 457 */               resultSet.getTimestamp(columnIndex + 1));
/*     */           else {
/* 459 */             rowValues.addElement(
/* 460 */               resultSet.getObject(columnIndex + 1));
/*     */           }
/*     */         }
/* 463 */         selectResultSet.addRowValues(rowValues);
/*     */       }
/*     */ 
/* 466 */       resultSet.close();
/* 467 */       statement.close();
/*     */     } catch (Exception ex) {
/* 469 */       ErrorProcessor.prompt(getClass().getName(), 
/* 470 */         String.valueOf(String.valueOf(new StringBuffer(
/* 471 */         "executeSelect(").append(this.sSubSystemName).append(
/* 472 */         ", ").append(sqlString).append(") error!"))), ex);
/*     */       try {
/* 474 */         resultSet.close();
/*     */       } catch (Exception exception) {
/* 476 */         exception.printStackTrace();
/* 477 */         resultSet = null;
/*     */       }
/*     */       try {
/* 480 */         statement.close();
/*     */       } catch (Exception exception1) {
/* 482 */         exception1.printStackTrace();
/* 483 */         statement = null;
/*     */       }
/* 485 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 487 */     return selectResultSet;
/*     */   }
/*     */ 
/*     */   public SelectResultSet executeProcedure(String sqlString) throws Exception {
/* 491 */     if (sqlString == null)
/* 492 */       return null;
/* 493 */     SelectResultSet selectResultSet = null;
/* 494 */     CallableStatement callableStatement = null;
/* 495 */     ResultSet resultSet = null;
/* 496 */     String errorStr = null;
/*     */     try {
/* 498 */       callableStatement = this.connection.prepareCall(sqlString);
/* 499 */       callableStatement.registerOutParameter(1, -10);
/* 500 */       callableStatement.registerOutParameter(2, 12);
/* 501 */       callableStatement.execute();
/* 502 */       errorStr = callableStatement.getString(2);
/* 503 */       if (errorStr.compareTo("null") != 0)
/* 504 */         throw new Exception(errorStr);
/* 505 */       resultSet = (ResultSet)callableStatement.getObject(1);
/* 506 */       ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
/* 507 */       int columnCount = resultSetMetaData.getColumnCount();
/* 508 */       selectResultSet = new SelectResultSet(columnCount);
/* 509 */       for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
/* 510 */         selectResultSet.setColumnName(columnIndex, 
/* 511 */           resultSetMetaData.getColumnName(columnIndex + 1));
/* 512 */         selectResultSet.setColumnType(columnIndex, 
/* 513 */           resultSetMetaData.getColumnType(columnIndex + 1));
/* 514 */         selectResultSet.setColumnTypeName(columnIndex, 
/* 515 */           resultSetMetaData.getColumnTypeName(columnIndex + 1));
/*     */       }
/*     */ 
/* 518 */       for (int rowIndex = 0; resultSet.next(); rowIndex++) {
/* 519 */         Vector rowValues = new Vector();




/* 520 */         for (int columnIndex = 0; columnIndex < columnCount; columnIndex++)
/*     */         {
/* 526 */           if (resultSetMetaData.getColumnTypeName(columnIndex + 1).equals("DATE"))           
/* 527 */             rowValues.addElement(
/* 528 */               resultSet.getTimestamp(columnIndex + 1));
/*     */           else {
/* 530 */             rowValues.addElement(
/* 531 */               resultSet.getObject(columnIndex + 1));
/*     */           }
/*     */         }
/* 534 */         selectResultSet.addRowValues(rowValues);
/*     */       }
/*     */ 
/* 537 */       resultSet.close();
/* 538 */       callableStatement.close();
/*     */     } catch (Exception ex) {
/* 540 */       ErrorProcessor.prompt(getClass().getName(), 
/* 541 */         String.valueOf(String.valueOf(new StringBuffer(
/* 542 */         "executeProcedure(")
/* 543 */         .append(this.sSubSystemName).append(", ")
/* 544 */         .append(sqlString).append(") error!"))), ex);
/*     */       try {
/* 546 */         resultSet.close();
/* 547 */         resultSet = null;
/*     */       } catch (Exception exception) {
/* 549 */         resultSet = null;
/*     */       }
/*     */       try {
/* 552 */         callableStatement.close();
/* 553 */         callableStatement = null;
/*     */       } catch (Exception exception1) {
/* 555 */         callableStatement = null;
/*     */       }
/* 557 */       selectResultSet = null;
/* 558 */       throw new SystemException(ex.getMessage());
/*     */     } finally {
/* 560 */       if (resultSet != null)
/*     */         try {
/* 562 */           resultSet.close();
/* 563 */           resultSet = null;
/*     */         }
/*     */         catch (Exception localException1) {
/*     */         }
/* 567 */       if (callableStatement != null)
/*     */         try {
/* 569 */           callableStatement.close();
/* 570 */           callableStatement = null;
/*     */         }
/*     */         catch (Exception localException2) {
/*     */         }
/*     */     }
/* 575 */     return selectResultSet;
/*     */   }
/*     */ 
/*     */   public void executeProcedure1(String sqlString) throws Exception {
/* 579 */     if (sqlString == null)
/* 580 */       throw new Exception("输入sql为空");
/* 581 */     CallableStatement callableStatement = null;
/* 582 */     String errorStr = null;
/*     */     try {
/* 584 */       callableStatement = this.connection.prepareCall(sqlString);
/* 585 */       callableStatement.registerOutParameter(1, 12);
/* 586 */       callableStatement.execute();
/* 587 */       errorStr = callableStatement.getString(1);
/* 588 */       if (errorStr.compareTo("null") != 0)
/* 589 */         throw new Exception(errorStr);
/* 590 */       callableStatement.close();
/*     */     } catch (Exception ex) {
/* 592 */       ErrorProcessor.prompt(getClass().getName(), 
/* 593 */         String.valueOf(String.valueOf(new StringBuffer(
/* 594 */         "executeProcedure1(").append(
/* 595 */         this.sSubSystemName).append(", ").append(
/* 596 */         sqlString).append(") error!"))), ex);
/*     */       try {
/* 598 */         callableStatement.close();
/* 599 */         callableStatement = null;
/*     */       } catch (Exception localException1) {
/*     */       }
/* 602 */       throw new SystemException(ex.getMessage());
/*     */     }
/*     */   }
/*     */ 
/*     */   public int writeBLOB(String sqlString, InputStream inputStream) throws Exception {
/* 607 */     if ((inputStream == null) || (sqlString == null))
/* 608 */       return -1;
/* 609 */     int errorCode = 0;
/* 610 */     int writeAllLength = 0;
/* 611 */     Statement statement = null;
/* 612 */     ResultSet resultSet = null;
/*     */     try {
/* 614 */       statement = this.connection.createStatement();
/* 615 */       errorCode = 1;
/* 616 */       resultSet = statement.executeQuery(sqlString);
/* 617 */       errorCode = 2;
/* 618 */       resultSet.next();
/* 619 */       BLOB blob = (BLOB)resultSet.getBlob(1);
/* 620 */       errorCode = 4;
/* 621 */       if (blob == null)
/* 622 */         System.out.println("blob is none");
/* 623 */       writeAllLength = writeBlob(inputStream, blob);
/* 624 */       errorCode = 5;
/* 625 */       resultSet.close();
/* 626 */       errorCode = 6;
/* 627 */       statement.close();
/* 628 */       errorCode = 7;
/*     */     } catch (Exception ex) {
/* 630 */       ErrorProcessor.prompt(getClass().getName(), 
/* 631 */         String.valueOf(String.valueOf(new StringBuffer(
/* 632 */         "writeBLOB(").append(sqlString).append(
/* 633 */         ", inputStream) errorCode:").append(errorCode))), ex);
/*     */       try {
/* 635 */         resultSet.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/*     */       try {
/* 639 */         statement.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/* 642 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 644 */     return writeAllLength;
/*     */   }
/*     */ 
/*     */   public int readBLOB(String sqlString, OutputStream outputStream) throws Exception {
/* 648 */     if ((outputStream == null) || (sqlString == null))
/* 649 */       return -1;
/* 650 */     int errorCode = 0;
/* 651 */     int readAllLength = 0;
/* 652 */     Statement statement = null;
/* 653 */     ResultSet resultSet = null;
/*     */     try {
/* 655 */       statement = this.connection.createStatement();
/* 656 */       errorCode = 1;
/* 657 */       resultSet = statement.executeQuery(sqlString);
/* 658 */       errorCode = 2;
/* 659 */       resultSet.next();
/* 660 */       errorCode = 3;
/* 661 */       BLOB blob = (BLOB)resultSet.getBlob(1);
/* 662 */       errorCode = 4;
/* 663 */       readAllLength = readBlob(outputStream, blob);
/* 664 */       errorCode = 5;
/* 665 */       resultSet.close();
/* 666 */       errorCode = 6;
/* 667 */       statement.close();
/* 668 */       errorCode = 7;
/*     */     } catch (Exception ex) {
/* 670 */       ErrorProcessor.prompt(getClass().getName(), 
/* 671 */         String.valueOf(
/* 672 */         String.valueOf(new StringBuffer("readBLOB(").append(
/* 673 */         sqlString).append(
/* 674 */         ", inputStream) errorCode:").append(
/* 675 */         errorCode))), ex);
/*     */       try {
/* 677 */         resultSet.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/*     */       try {
/* 681 */         statement.close();
/*     */       } catch (Exception localException2) {
/*     */       }
/* 684 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 686 */     return readAllLength;
/*     */   }
/*     */ 
/*     */   public int executeSQL(String sql) throws Exception {
/* 690 */     if (this.connection == null)
/* 691 */       return -1;
/* 692 */     int rowCount = 0;
/* 693 */     Statement statement = null;
/*     */     try {
/* 695 */       statement = this.connection.createStatement();
/* 696 */       rowCount = statement.executeUpdate(sql);
/* 697 */       statement.close();
/*     */     } catch (Exception ex) {
/* 699 */       ex.printStackTrace();
/* 700 */       ErrorProcessor.prompt(getClass().getName(), 
/* 701 */         String.valueOf(String.valueOf(new StringBuffer("executeSQL(")
/* 702 */         .append(sql).append(") error!"))), ex);
/*     */       try {
/* 704 */         statement.close();
/* 705 */         statement = null;
/*     */       } catch (Exception exception) {
/* 707 */         exception.printStackTrace();
/*     */       }
/* 709 */       returnConnection();
/* 710 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 712 */     return 0;
/*     */   }
/*     */ 
/*     */   public int commit() throws Exception {
/* 716 */     if (this.connection == null)
/* 717 */       return -1;
/*     */     try {
/* 719 */       this.connection.commit();
/* 720 */       returnConnection();
/*     */     } catch (Exception ex) {
/* 722 */       ErrorProcessor.prompt(getClass().getName(), 
/* 723 */         "commit() error!", ex);
/* 724 */       returnConnection();
/* 725 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 727 */     return 1;
/*     */   }
/*     */ 
/*     */   public int rollback() throws Exception {
/* 731 */     if (this.connection == null)
/* 732 */       return -1;
/*     */     try {
/* 734 */       this.connection.rollback();
/* 735 */       returnConnection();
/*     */     } catch (Exception ex) {
/* 737 */       ErrorProcessor.prompt(getClass().getName(), 
/* 738 */         "rollback() error!", ex);
/* 739 */       returnConnection();
/* 740 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 742 */     return 1;
/*     */   }
/*     */ 
/*     */   public void returnConnection() {
/* 746 */     if (this.connection != null)
/* 747 */       this.dbConnectionManager.freeConnection(this.sSubSystemName, this.connection);
/*     */   }
/*     */ 
/*     */   private int writeBlob(InputStream is, BLOB blob) throws Exception
/*     */   {
/* 752 */     int writeAllLength = 0;		
/* 753 */     OutputStream os = null;
/*     */     try {
/* 755 */       os = blob.getBinaryOutputStream();
/* 756 */       int tempid = 1024;
/* 757 */       byte[] buffer = new byte[tempid];		int writeLength;
/* 759 */       while ((writeLength = is.read(buffer)) != -1){
/*     */         int writeLength;		
/* 760 */         os.write(buffer, 0, writeLength);
/* 761 */         writeAllLength += writeLength;
/*     */       }
/* 763 */       os.close();
/*     */     } catch (Exception ex) {
/* 765 */       ErrorProcessor.prompt(getClass().getName(), 
/* 766 */         "writeBlob(InputStream is, BLOB blob) error!", ex);
/*     */       try {
/* 768 */         os.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 771 */       writeAllLength = -1;
/* 772 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 774 */     return writeAllLength;
/*     */   }
/*     */ 
/*     */   private int readBlob(OutputStream os, BLOB blob) throws Exception {
/* 778 */     int readAllLength = 0;
/* 779 */     InputStream is = null;
/*     */     try {
/* 781 */       byte[] buffer = new byte[1024];
/* 782 */       is = blob.getBinaryStream();	int readLength;
/* 784 */       while ((readLength = is.read(buffer)) != -1){
/*     */         int readLength;
/* 785 */         os.write(buffer, 0, readLength);
/* 786 */         os.flush();
/* 787 */         readAllLength += readLength;
/*     */       }
/* 789 */       is.close();
/*     */     } catch (Exception ex) {
/*     */       try {
/* 792 */         is.close();
/*     */       } catch (Exception localException1) {
/*     */       }
/* 795 */       readAllLength = -1;
/* 796 */       throw new SystemException(ex.getMessage());
/*     */     }
/* 798 */     return readAllLength;
/*     */   }

/*     */   public void finalize() {
/* 802 */     returnConnection();
/*     */   }
/*     */ 
/*     */   public String byte2hex(byte[] b) {
/* 806 */     String hs = "";
/* 807 */     String stmp = "";
/* 808 */     for (int n = 0; n < b.length; n++) {
/* 809 */       stmp = Integer.toHexString(b[n] & 0xFF);
/* 810 */       if (stmp.length() == 1)
/* 811 */         hs = String.valueOf(
/* 812 */           String.valueOf(new StringBuffer(String.valueOf(
/* 813 */           String.valueOf(hs))).append("0").append(stmp)));
/*     */       else {
/* 815 */         hs = String.valueOf(String.valueOf(hs)) + 
/* 816 */           String.valueOf(String.valueOf(stmp));
/*     */       }
/*     */     }
/* 819 */     return hs.toUpperCase();
/*     */   }
/*     */ 
/*     */   public int WriteInSqlServer(String sql, InputStream is) {
/* 823 */     int flag = 1;
/*     */     try {
/* 825 */       int bytes = 0;
/* 826 */       PreparedStatement insert = this.connection.prepareStatement(sql);
/*     */       try {
/* 828 */         bytes = is.available();
/* 829 */         Debug.debugMessage(1, this.sSystemName, this.sSubSystemName, this.sServiceName, 
/* 830 */           "bytes=========================".concat(String.valueOf(String.valueOf(bytes))));
/* 831 */         insert.setBinaryStream(1, is, bytes);
/* 832 */         insert.executeUpdate();
/* 833 */         flag = 1;
/*     */       } catch (Exception e) {
/* 835 */         ErrorProcessor.prompt(
/* 836 */           getClass().getName(), 
/* 837 */           "WriteInSqlServer error!", e);
/* 838 */         flag = -1;
/*     */       }
/*     */       try {
/* 841 */         insert.close();
/* 842 */         is.close();
/*     */       } catch (Exception e) {
/* 844 */         ErrorProcessor.prompt(
/* 845 */           getClass().getName(), 
/* 846 */           "WriteInSqlServer error!", e);
/* 847 */         flag = -1;
/*     */       }
/*     */     } catch (Exception e) {
/* 850 */       ErrorProcessor.prompt(getClass().getName(), 
/* 851 */         "WriteInSqlServer error!", e);
/* 852 */       flag = -1;
/*     */     }
/* 854 */     return flag;
/*     */   }
/*     */ 
/*     */   public int ReadFromSqlServer(String sql, OutputStream outputStream) {
/* 858 */     int flag = 1;
/* 859 */     FileOutputStream fileOutStream = null;
/* 860 */     InputStream inStream = null;
/* 861 */     int bytes = 0;
/*     */     try {
/* 863 */       Statement statement = this.connection.createStatement(1004, 1008);
/* 864 */       Debug.debugMessage(1, this.sSystemName, this.sSubSystemName, this.sServiceName, "sql==".concat(String.valueOf(
/* 865 */         String.valueOf(sql))));
/* 866 */       ResultSet rs1 = statement.executeQuery(sql);
/* 867 */       if (rs1.next()) {
/* 868 */         byte[] bytes1 = rs1.getBytes(1);
/* 869 */         Debug.debugMessage(1, this.sSystemName, this.sSubSystemName, this.sServiceName, "bytes1====".concat(String.valueOf(
/* 870 */           String.valueOf(bytes1.length))));
/*     */         try {
/* 872 */           for (int i = 0; i < bytes1.length; i++)
/* 873 */             outputStream.write(bytes1[i]);
/*     */         }
/*     */         catch (Exception e) {
/* 876 */           ErrorProcessor.prompt(
/* 877 */             getClass().getName(), 
/* 878 */             "ReadInSqlServer error!", e);
/* 879 */           flag = -1;
/*     */         }
/*     */       }
/* 882 */       rs1.close();
/* 883 */       statement.close();
/*     */     } catch (Exception e) {
/* 885 */       ErrorProcessor.prompt(getClass().getName(), 
/* 886 */         "ReadInSqlServer error!", e);
/* 887 */       flag = -1;
/*     */     }
/* 889 */     return flag;
/*     */   }

/*     */   static
/*     */   {
/* 893 */     NUMBER = 2;
/* 894 */     LONGNUMBER = 3;
/* 895 */     DOUBLENUMBER = 4;
/* 896 */     BIGDECIMAL = 5;
/* 897 */     VARCHAR2 = 12;
/* 898 */     DATE = 93;
/* 899 */     BLOB = 2004;
/* 900 */     CLOB = 2005;
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.database.DBOperator
 * JD-Core Version:    0.6.0
 */