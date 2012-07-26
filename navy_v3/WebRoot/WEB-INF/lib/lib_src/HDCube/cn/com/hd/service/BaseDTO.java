/*     */ package cn.com.hd.service;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ import java.text.SimpleDateFormat;
/*     */ import org.jdom.Element;
/*     */ 




/*     */ public class BaseDTO
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */ 
/*     */   public BaseDTO clone()
/*     */   {
/*     */     try
/*     */     {
/*  22 */       return (BaseDTO)super.clone();
/*     */     } catch (CloneNotSupportedException e) {
/*  24 */       e.printStackTrace();
/*  25 */     }return new BaseDTO();
/*     */   }
/*     */ 






/*     */   public Object getPropertyValue(String name)
/*     */   {
/*     */     try
/*     */     {
/*  38 */       if (!name.equals("serialVersionUID")) {
/*  39 */         Field field = getClass().getDeclaredField(name);
/*  40 */         AccessibleObject.setAccessible(new Field[] { field }, true);
/*  41 */         Object obj = field.get(this);
/*  42 */         AccessibleObject.setAccessible(new Field[] { field }, false);
/*  43 */         return obj;
/*     */       }
/*     */ 
/*  46 */       return null; } catch (Exception ex) {
/*     */     }
/*  48 */     return null;
/*     */   }
/*     */ 






/*     */   public void setPropertyValue(String name, Object value)
/*     */   {
/*     */     try
/*     */     {
/*  61 */       Field field = getClass().getDeclaredField(name);
/*  62 */       AccessibleObject.setAccessible(new Field[] { field }, true);
/*  63 */       field.set(this, value);
/*  64 */       AccessibleObject.setAccessible(new Field[] { field }, false);
/*     */     }
/*     */     catch (Exception localException)
/*     */     {
/*     */     }
/*     */   }
/*     */ 


/*     */   public String toString()
/*     */   {
/*  75 */     StringBuffer buffer = new StringBuffer();
/*  76 */     Class c = getClass();
/*  77 */     buffer.append(c.getName());
/*  78 */     buffer.append("[");
/*  79 */     Field[] fields = c.getDeclaredFields();
/*     */     try {
/*  81 */       AccessibleObject.setAccessible(fields, true);
/*  82 */       for (int i = 0; i < fields.length; i++) {
/*  83 */         if (i != 0) {
/*  84 */           buffer.append(",");
/*     */         }
/*     */ 
/*  87 */         String name = fields[i].getName();
/*  88 */         Object value = fields[i].get(this);
/*     */ 
/*  90 */         buffer.append(name + "=" + value);
/*     */       }
/*     */ 
/*  93 */       AccessibleObject.setAccessible(fields, false);
/*     */     }
/*     */     catch (Exception localException) {
/*     */     }
/*  97 */     buffer.append("]");
/*  98 */     return buffer.toString();
/*     */   }
/*     */ 
/*     */   public String toXMLString() {
/* 102 */     StringBuffer xml = new StringBuffer();
/* 103 */     Field[] fields = getClass().getDeclaredFields();
/* 104 */     for (Field field : fields) {
/* 105 */       String name = field.getName();
/* 106 */       String type = field.getType().getSimpleName();
/* 107 */       Object value = getPropertyValue(name);
/* 108 */       if (name.equals("serialVersionUID"))
/*     */       {
/*     */         continue;
/*     */       }
/* 112 */       if (value == null)
/*     */       {
/*     */         continue;
/*     */       }
/* 116 */       String sValue = null;
/* 117 */       if ((type.equals("Integer")) || (type.equals("Long")) || 
/* 118 */         (type.equals("Double")) || (type.equals("String")) || (type.equals("Float"))) {
/* 119 */         sValue = value.toString(); } else {
/* 120 */         if (!type.equals("Date")) continue;
/* 121 */         sValue = new SimpleDateFormat("yyyy-MM-dd").format(value);
/*     */       }
/*     */ 


/* 126 */       xml.append("<").append(name.toUpperCase()).append(">");
/* 127 */       xml.append(sValue);
/* 128 */       xml.append("</").append(name.toUpperCase()).append(">\n");
/*     */     }
/*     */ 
/* 131 */     return xml.toString();
/*     */   }
/*     */ 
/*     */   public void fromXMLString(Element element) {
/* 135 */     Field[] fields = getClass().getDeclaredFields();
/* 136 */     for (Field field : fields) {
/* 137 */       String name = field.getName();
/* 138 */       String type = field.getType().getSimpleName();
/*     */ 
/* 140 */       Element elem = element.getChild(name.toUpperCase());
/* 141 */       if (elem != null) {
/* 142 */         Object value = null;
/* 143 */         String sValue = elem.getTextTrim();
/*     */ 
/* 145 */         if (type.equals("String")) {
/* 146 */           value = sValue;
/* 147 */         } else if (type.equals("Double")) {
/*     */           try {
/* 149 */             value = Double.valueOf(sValue);
/*     */           } catch (Exception ex) {
/* 151 */             continue;
/*     */           }
/* 153 */         } else if (type.equals("Integer")) {
/*     */           try {
/* 155 */             value = Integer.valueOf(sValue);
/*     */           } catch (Exception ex) {
/* 157 */             continue;
/*     */           }
/* 159 */         } else if (type.equals("Long")) {
/*     */           try {
/* 161 */             value = Long.valueOf(sValue);
/*     */           } catch (Exception ex) {
/* 163 */             continue;
/*     */           }
/* 165 */         } else if (type.equals("Float")) {
/*     */           try {
/* 167 */             value = Float.valueOf(sValue);
/*     */           } catch (Exception ex) {
/* 169 */             continue;
/*     */           }
/*     */         } else {
/* 171 */           if (!type.equals("Date")) continue;
/*     */           try {
/* 173 */             value = new SimpleDateFormat("yyyy-MM-dd").parse(sValue);
/*     */           } catch (Exception ex) {
/* 175 */             continue;
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/* 181 */         setPropertyValue(name, value);
/*     */       }
/*     */     }
/*     */   }
/*     */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.service.BaseDTO
 * JD-Core Version:    0.6.0
 */