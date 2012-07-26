/*    */ package cn.com.hd.transfer;
/*    */ 
/*    */ import cn.com.hd.dto.ClassMapping;
/*    */ import cn.com.hd.xmlparser.dto.SubsystemDTO;
/*    */ import cn.com.hd.xmlparser.dto.SystemDTO;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class RegisterObject
/*    */ {
/* 11 */   public static HashMap<String, SystemDTO> systemInfo = new HashMap();
/*    */ 
/* 13 */   public static HashMap<String, SubsystemDTO> subsystemInfo = new HashMap();
/*    */ 
/* 15 */   public static HashMap<String, ClassMapping> DTOInfo = new HashMap();
/*    */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.transfer.RegisterObject
 * JD-Core Version:    0.6.0
 */