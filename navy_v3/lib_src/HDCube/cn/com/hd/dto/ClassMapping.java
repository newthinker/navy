/*    */ package cn.com.hd.dto;
/*    */ 
/*    */ import java.util.List; 
/*    */ public class ClassMapping
/*    */ {
/*    */   private String className;
/*    */   private String tableName;
/*    */   private String schema;
/*    */   private PropertyMapping[] id;
/*    */   private List<PropertyMapping> listProperty;
/*    */ 
/*    */   public String getClassName()
/*    */   {
/* 14 */     return this.className;
/*    */   }
/*    */   public void setClassName(String className) {
/* 17 */     this.className = className;
/*    */   }
/*    */   public String getTableName() {
/* 20 */     return this.tableName;
/*    */   }
/*    */   public void setTableName(String tableName) {
/* 23 */     this.tableName = tableName;
/*    */   }
/*    */   public String getSchema() {
/* 26 */     return this.schema;
/*    */   }
/*    */   public void setSchema(String schema) {
/* 29 */     this.schema = schema;
/*    */   }
/*    */   public PropertyMapping[] getId() {
/* 32 */     return this.id;
/*    */   }
/*    */   public void setId(PropertyMapping[] id) {
/* 35 */     this.id = id;
/*    */   }
/*    */   public List<PropertyMapping> getListProperty() {
/* 38 */     return this.listProperty;
/*    */   }
/*    */   public void setListProperty(List<PropertyMapping> listProperty) {
/* 41 */     this.listProperty = listProperty;
/*    */   }
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.dto.ClassMapping
 * JD-Core Version:    0.6.0
 */