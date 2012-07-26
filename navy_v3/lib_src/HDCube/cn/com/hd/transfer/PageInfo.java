/*     */ package cn.com.hd.transfer;
/*     */ 
/*     */ import cn.com.hd.service.BaseDTO;
/*     */ 
/*     */ public class PageInfo extends BaseDTO
/*     */ {
/*     */   private static final long serialVersionUID = 6483483031323376305L;
/*     */   private Integer firstIndex;
/*     */   private Integer lastIndex;
/*     */   private Integer pageCount;
/*     */   private Integer pageIndex;
/*     */   private Integer rowNumber;
/*     */   private Integer rowsCount;
/*     */   private Boolean userPagination;
/*     */ 
/*     */   public PageInfo()
/*     */   {
/*  51 */     this.pageIndex = Integer.valueOf(1);
/*  52 */     this.rowNumber = Integer.valueOf(5);
/*  53 */     this.userPagination = Boolean.valueOf(true);
/*     */   }
/*     */ 
/*     */   public void firstPage()
/*     */   {
/*  60 */     setPageIndex(1);
/*     */   }
/*     */ 
/*     */   public Integer getFirstIndex()
/*     */   {
/*  69 */     return this.firstIndex;
/*     */   }
/*     */ 
/*     */   public Integer getLastIndex()
/*     */   {
/*  78 */     return this.lastIndex;
/*     */   }
/*     */ 
/*     */   public Integer getPageCount()
/*     */   {
/*  87 */     return this.pageCount;
/*     */   }
/*     */ 
/*     */   public Integer getPageIndex()
/*     */   {
/*  96 */     return this.pageIndex;
/*     */   }
/*     */ 
/*     */   public Integer getRowNumber()
/*     */   {
/* 105 */     return this.rowNumber;
/*     */   }
/*     */ 
/*     */   public Integer getRowsCount()
/*     */   {
/* 114 */     return this.rowsCount;
/*     */   }
/*     */ 
/*     */   public Boolean isUserPagination()
/*     */   {
/* 123 */     return this.userPagination;
/*     */   }
/*     */ 
/*     */   public void lastPage()
/*     */   {
/* 130 */     setPageIndex(this.pageCount.intValue());
/*     */   }
/*     */ 
/*     */   public void nextPage()
/*     */   {
/* 137 */     int page = this.pageIndex.intValue() + 1 > this.pageCount.intValue() ? this.pageCount.intValue() : this.pageIndex.intValue() + 1;
/* 138 */     setPageIndex(page);
/*     */   }
/*     */ 
/*     */   public void nextPage(int pageInterval)
/*     */   {
/* 146 */     int page = this.pageIndex.intValue() + pageInterval > this.pageCount.intValue() ? this.pageCount.intValue() : this.pageIndex.intValue() + pageInterval;
/* 147 */     setPageIndex(page);
/*     */   }
/*     */ 
/*     */   public void prevPage()
/*     */   {
/* 154 */     int page = this.pageIndex.intValue() - 1 < 1 ? 1 : this.pageIndex.intValue() - 1;
/* 155 */     setPageIndex(page);
/*     */   }
/*     */ 
/*     */   public void prevPage(int pageInterval)
/*     */   {
/* 163 */     int page = this.pageIndex.intValue() - pageInterval < 1 ? 1 : this.pageIndex.intValue() - pageInterval;
/* 164 */     setPageIndex(page);
/*     */   }
/*     */ 
/*     */   public void setPageIndex(int pageIndex)
/*     */   {
/* 173 */     this.pageIndex = Integer.valueOf(pageIndex);
/* 174 */     init();
/*     */   }
/*     */ 
/*     */   public void setRowNumber(int rowNumber)
/*     */   {
/* 183 */     this.rowNumber = Integer.valueOf(rowNumber);
/* 184 */     init();
/*     */   }
/*     */ 
/*     */   public void setRowsCount(int rowsCount)
/*     */   {
/* 193 */     this.rowsCount = Integer.valueOf(rowsCount);
/* 194 */     init();
/*     */   }
/*     */ 
/*     */   public void setUserPagination(boolean userPagination)
/*     */   {
/* 203 */     this.userPagination = Boolean.valueOf(userPagination);
/*     */   }
/*     */ 
/*     */   public void init()
/*     */   {
/* 210 */     this.firstIndex = Integer.valueOf((this.pageIndex.intValue() - 1) * this.rowNumber.intValue());
/* 211 */     this.lastIndex = Integer.valueOf(this.firstIndex.intValue() + this.rowNumber.intValue());
/*     */ 
/* 213 */     if (this.rowsCount != null)
/* 214 */       this.pageCount = Integer.valueOf((int)Math.ceil(this.rowsCount.intValue() / this.rowNumber.intValue()));
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.PageInfo
 * JD-Core Version:    0.6.0
 */