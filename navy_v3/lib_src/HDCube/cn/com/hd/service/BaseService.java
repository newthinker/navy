/*      */ package cn.com.hd.service;
/*      */ 
/*      */ import cn.com.hd.database.DBOperator;
/*      */ import cn.com.hd.database.PreparedStatementOperator;
/*      */ import cn.com.hd.database.SelectResultSet;
/*      */ import cn.com.hd.dto.ClassMapping;
/*      */ import cn.com.hd.dto.PropertyMapping;
/*      */ import cn.com.hd.error.Debug;
/*      */ import cn.com.hd.error.ErrorProcessor;
/*      */ import cn.com.hd.error.SystemException;
/*      */ import cn.com.hd.manager.SystemServiceManager;
/*      */ import cn.com.hd.transfer.Condition;
/*      */ import cn.com.hd.transfer.Conditions;
/*      */ import cn.com.hd.transfer.DTO;
/*      */ import cn.com.hd.transfer.LoginInfo;
/*      */ import cn.com.hd.transfer.PageInfo;
/*      */ import cn.com.hd.transfer.RegisterObject;
/*      */ import cn.com.hd.transfer.Request;
/*      */ import cn.com.hd.transfer.Response;
/*      */ import cn.com.hd.transfer.SystemParam;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.File;
/*      */ import java.io.InputStream;
/*      */ import java.lang.reflect.AccessibleObject;
/*      */ import java.lang.reflect.Field;
/*      */ import java.math.BigDecimal;
/*      */ import java.sql.Blob;
/*      */ import java.sql.Clob;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.UUID;
/*      */ import javax.servlet.http.HttpSession;
/*      */ import org.jdom.Document;
/*      */ import org.jdom.Element;
/*      */ import org.jdom.input.SAXBuilder;
/*      */ 





/*      */ public class BaseService
/*      */ {
/*      */   protected Request request;
/*      */   protected Response response;
/*   50 */   protected int result = 0;

/*      */   protected DBOperator dbOperator;

/*      */   protected HttpSession session;

/*      */   protected LoginInfo loginInfo;
/*      */   protected List<DBOperator> dbOperatorList;
/*      */ 
/*      */   protected BaseService()
/*      */   {
/*   61 */     this.response = new Response();
/*      */   }
/*      */ 
/*      */   protected PageInfo getPageInfo() throws Exception {
/*   65 */     PageInfo page = new PageInfo();
/*   66 */     getData(this.request.getDto(), page);
/*   67 */     page.init();
/*   68 */     return page;
/*      */   }
/*      */ 
/*      */   protected Response requestService(String subSystemName, String serviceName, DTO dto) throws Exception {
/*   72 */     return requestService(this.request.getResponseSystemName(), subSystemName, serviceName, dto);
/*      */   }
/*      */ 
/*      */   protected Response requestService(String serviceName, DTO dto) throws Exception {
/*   76 */     return requestService(this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), serviceName, dto);
/*      */   }
/*      */ 
/*      */   protected Response requestService(Request request) throws Exception {
/*   80 */     Response response = null;
/*      */     try {
/*   82 */       request.getDto().put("SESSION", this.session);
/*   83 */       request.getDto().put("LOGININFO", this.loginInfo);
/*   84 */       response = SystemServiceManager.service(request, this.dbOperatorList);
/*      */     } catch (Exception ex) {
/*   86 */       ErrorProcessor.prompt(getClass().getName(), "not found service : " + request.getResponseServiceName(), ex);
/*      */ 
/*   88 */       throw new SystemException(ex.getMessage());
/*      */     }
/*   90 */     return response;
/*      */   }
/*      */ 
/*      */   protected Response requestService(String systemName, String subSystemName, String serviceName, DTO dto) throws Exception {
/*   94 */     Request req = new Request();
/*   95 */     req.setResponseSystemName(systemName);
/*   96 */     req.setResponseSubsystemName(subSystemName);
/*   97 */     req.setResponseServiceName(serviceName);
/*   98 */     req.setDto(dto);
/*   99 */     Response response = requestService(req);
/*  100 */     return response;
/*      */   }
/*      */ 
/*      */   protected int log(String content) {
/*  104 */     String sAutoLog = SystemParam.getParam("AutoRecordLog");
/*  105 */     if ((sAutoLog != null) && (sAutoLog.equalsIgnoreCase("true"))) {
/*  106 */       HashMap mapDBOperator = new HashMap();
/*  107 */       mapDBOperator.put(this.request.getResponseSubsystemName(), this.dbOperator);
/*      */       try {
/*  109 */         Request req = new Request();
/*  110 */         req.setResponseSystemName("HDLog");
/*  111 */         req.setResponseSubsystemName("LogManage");
/*  112 */         req.setResponseServiceName("LogAddService");
/*  113 */         req.getDto().setString("SYSTEMNAME", this.request.getResponseSystemName());
/*  114 */         req.getDto().setString("SUBSYSTEMNAME", this.request.getResponseSubsystemName());
/*  115 */         req.getDto().setString("SERVICENAME", this.request.getResponseServiceName());
/*  116 */         req.getDto().setString("CLASS", getClass().getName());
/*  117 */         req.getDto().setString("OPERATORID", this.loginInfo.getUserid());
/*  118 */         req.getDto().setString("OPERATORNAME", this.loginInfo.getUsername());
/*  119 */         req.getDto().setString("OPERATORDEPT", this.loginInfo.getDeptname());
/*  120 */         req.getDto().setString("LOGTYPE", "操作日志");
/*  121 */         req.getDto().setString("LOGCONTENT", content);
/*      */ 
/*  123 */         Response resp = requestService(req);
/*      */ 
/*  125 */         return resp.getResult().intValue();
/*      */       } catch (Exception ex) {
/*  127 */         ErrorProcessor.prompt(getClass().getName(), "保存日志失败", ex);
/*  128 */         return 0;
/*      */       }
/*      */     }
/*      */ 
/*  132 */     return 0;
/*      */   }
/*      */ 
/*      */   protected DTO getDTO(BaseDTO basedto) {
/*  136 */     DTO dto = new DTO();
/*      */ 
/*  138 */     Field[] fields = basedto.getClass().getDeclaredFields();
/*  139 */     for (Field field : fields) {
/*  140 */       String name = field.getName();
/*  141 */       String type = field.getType().getSimpleName();
/*  142 */       Object value = basedto.getPropertyValue(name);
/*      */ 
/*  144 */       if ((value != null) && (!name.equals("serialVersionUID"))) {
/*  145 */         if (type.equals("Integer"))
/*  146 */           dto.setInt(name.toUpperCase(), (Integer)value);
/*  147 */         else if (type.equals("Long"))
/*  148 */           dto.setLong(name.toUpperCase(), (Long)value);
/*  149 */         else if (type.equals("Double"))
/*  150 */           dto.setDouble(name.toUpperCase(), (Double)value);
/*  151 */         else if (type.equals("Date"))
/*  152 */           dto.setDate(name.toUpperCase(), (Date)value);
/*  153 */         else if (type.equals("String"))
/*  154 */           dto.setString(name.toUpperCase(), (String)value);
/*  155 */         else if (type.equals("BLOB"))
/*  156 */           dto.setBlob(name.toUpperCase(), (Blob)value);
/*  157 */         else if (type.equals("CLOB"))
/*  158 */           dto.setClob(name.toUpperCase(), (Clob)value);
/*      */         else {
/*  160 */           dto.put(name.toUpperCase(), value);
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*  165 */     return dto;
/*      */   }
/*      */ 
/*      */   public List getDTO(List listBasedto) {
/*  169 */     List listDTO = new ArrayList();
/*  170 */     for (Iterator localIterator = listBasedto.iterator(); localIterator.hasNext(); ) { Object object = localIterator.next();
/*  171 */       BaseDTO basedto = (BaseDTO)object;
/*      */ 
/*  173 */       listDTO.add(getDTO(basedto));
/*      */     }
/*  175 */     return listDTO;
/*      */   }
/*      */ 
/*      */   protected BaseDTO getData(DTO dto, BaseDTO baseDTO) throws Exception {
/*  179 */     if (baseDTO == null) {
/*  180 */       baseDTO = (BaseDTO)baseDTO.getClass().newInstance();
/*      */     }
/*      */ 
/*  183 */     Field[] fields = baseDTO.getClass().getDeclaredFields();
/*  184 */     for (int i = 0; i < fields.length; i++) {
/*  185 */       Field field = fields[i];
/*  186 */       String fieldType = field.getType().getSimpleName();
/*      */       try {
/*  188 */         if (fieldType.equalsIgnoreCase("Integer")) {
/*  189 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  190 */           if (dto.getInt(field.getName().toUpperCase()) != null)
/*  191 */             field.set(baseDTO, dto
/*  192 */               .getInt(field.getName().toUpperCase()));
/*  193 */           else if (dto.getString(field.getName().toUpperCase()) != null)
/*  194 */             field.set(baseDTO, Integer.valueOf(dto
/*  195 */               .getString(field.getName().toUpperCase())));
/*  196 */           else if (dto.getNumber(field.getName().toUpperCase()) != null) {
/*  197 */             field.set(baseDTO, Integer.valueOf(dto.getNumber(field.getName().toUpperCase()).intValue()));
/*      */           }
/*  199 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  200 */         } else if (fieldType.equalsIgnoreCase("Long")) {
/*  201 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  202 */           if (dto.getLong(field.getName().toUpperCase()) != null)
/*  203 */             field.set(baseDTO, dto
/*  204 */               .getLong(field.getName().toUpperCase()));
/*  205 */           else if (dto.getString(field.getName().toUpperCase()) != null)
/*  206 */             field.set(baseDTO, 
/*  207 */               Long.valueOf(dto.getString(field.getName().toUpperCase())));
/*  208 */           else if (dto.getNumber(field.getName().toUpperCase()) != null) {
/*  209 */             field.set(baseDTO, Long.valueOf(dto.getNumber(field.getName().toUpperCase()).longValue()));
/*      */           }
/*  211 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  212 */         } else if (fieldType.equalsIgnoreCase("Double")) {
/*  213 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  214 */           if (dto.getDouble(field.getName().toUpperCase()) != null)
/*  215 */             field.set(baseDTO, dto
/*  216 */               .getDouble(field.getName().toUpperCase()));
/*  217 */           else if (dto.getString(field.getName().toUpperCase()) != null)
/*  218 */             field.set(baseDTO, 
/*  219 */               Double.valueOf(dto.getString(field.getName().toUpperCase())));
/*  220 */           else if (dto.getNumber(field.getName().toUpperCase()) != null) {
/*  221 */             field.set(baseDTO, Double.valueOf(dto.getNumber(field.getName().toUpperCase()).doubleValue()));
/*      */           }
/*  223 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  224 */         } else if (fieldType.equalsIgnoreCase("Boolean")) {
/*  225 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  226 */           if (dto.getBoolean(field.getName().toUpperCase()) != null)
/*  227 */             field.set(baseDTO, dto
/*  228 */               .getBoolean(field.getName().toUpperCase()));
/*  229 */           else if (dto.getString(field.getName().toUpperCase()) != null) {
/*  230 */             field.set(baseDTO, 
/*  231 */               Boolean.valueOf(dto.getString(field.getName().toUpperCase())));
/*      */           }
/*  233 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  234 */         } else if (fieldType.equalsIgnoreCase("Date")) {
/*  235 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  236 */           if (dto.getDate(field.getName().toUpperCase()) != null) {
/*  237 */             field.set(baseDTO, dto
/*  238 */               .getDate(field.getName().toUpperCase()));
/*  239 */           } else if (dto.getString(field.getName().toUpperCase()) != null) {
/*  240 */             Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dto
/*  241 */               .getString(field.getName().toUpperCase()));
/*  242 */             field.set(baseDTO, date);
/*      */           }
/*  244 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  245 */         } else if (fieldType.equalsIgnoreCase("String")) {
/*  246 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  247 */           if (dto.getString(field.getName().toUpperCase()) != null) {
/*  248 */             field.set(baseDTO, dto
/*  249 */               .getString(field.getName().toUpperCase()));
/*      */           }
/*  251 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  252 */         } else if (fieldType.equalsIgnoreCase("InputStream")) {
/*  253 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  254 */           Object value = dto.getInputStream(field.getName().toUpperCase());
/*  255 */           if (value != null) {
/*  256 */             if ((value instanceof String))
/*  257 */               field.set(baseDTO, new ByteArrayInputStream(((String)value).getBytes()));
/*  258 */             else if ((value instanceof InputStream))
/*  259 */               field.set(baseDTO, value);
/*  260 */             else if ((value instanceof Blob)) {
/*  261 */               field.set(baseDTO, ((Blob)value).getBinaryStream());
/*      */             }
/*      */           }
/*  264 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  265 */         } else if (fieldType.equalsIgnoreCase("List")) {
/*  266 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  267 */           if (dto.getList(field.getName().toUpperCase()) != null) {
/*  268 */             field.set(baseDTO, dto
/*  269 */               .getList(field.getName().toUpperCase()));
/*      */           }
/*  271 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  272 */         } else if (fieldType.equalsIgnoreCase("HashMap")) {
/*  273 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  274 */           if (dto.getHashMap(field.getName().toUpperCase()) != null) {
/*  275 */             field.set(baseDTO, dto
/*  276 */               .getHashMap(field.getName().toUpperCase()));
/*      */           }
/*  278 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*      */         }
/*      */       } catch (Exception ex) {
/*  281 */         ErrorProcessor.prompt(getClass().getName(), "getData() error!", ex);
/*  282 */         throw new SystemException(ex.getMessage());
/*      */       }
/*      */     }
/*  285 */     return baseDTO;
/*      */   }
/*      */ 
/*      */   protected BaseDTO getQueryData(DTO dto, BaseDTO baseDTO) throws Exception {
/*  289 */     if (baseDTO == null) {
/*  290 */       baseDTO = (BaseDTO)baseDTO.getClass().newInstance();
/*      */     }
/*      */ 
/*  293 */     Field[] fields = baseDTO.getClass().getDeclaredFields();
/*  294 */     for (int i = 0; i < fields.length; i++) {
/*  295 */       Field field = fields[i];
/*  296 */       String fieldType = field.getType().getSimpleName();
/*      */       try {
/*  298 */         if (fieldType.equalsIgnoreCase("Integer")) {
/*  299 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  300 */           if (dto.getInt("QUERY_" + field.getName().toUpperCase()) != null)
/*  301 */             field.set(baseDTO, dto.getInt("QUERY_" + 
/*  302 */               field.getName().toUpperCase()));
/*  303 */           else if (dto.getString("QUERY_" + field.getName().toUpperCase()) != null)
/*  304 */             field.set(baseDTO, Integer.valueOf(dto.getString("QUERY_" + 
/*  305 */               field.getName().toUpperCase())));
/*  306 */           else if (dto.getNumber(field.getName().toUpperCase()) != null) {
/*  307 */             field.set(baseDTO, Integer.valueOf(dto.getNumber(field.getName().toUpperCase()).intValue()));
/*      */           }
/*  309 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  310 */         } else if (fieldType.equalsIgnoreCase("Long")) {
/*  311 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  312 */           if (dto.getLong("QUERY_" + field.getName().toUpperCase()) != null)
/*  313 */             field.set(baseDTO, dto.getLong("QUERY_" + 
/*  314 */               field.getName().toUpperCase()));
/*  315 */           else if (dto.getString("QUERY_" + field.getName().toUpperCase()) != null)
/*  316 */             field.set(baseDTO, Long.valueOf(dto.getString("QUERY_" + 
/*  317 */               field.getName().toUpperCase())));
/*  318 */           else if (dto.getNumber(field.getName().toUpperCase()) != null) {
/*  319 */             field.set(baseDTO, Long.valueOf(dto.getNumber(field.getName().toUpperCase()).longValue()));
/*      */           }
/*  321 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  322 */         } else if (fieldType.equalsIgnoreCase("Double")) {
/*  323 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  324 */           if (dto.getDouble("QUERY_" + field.getName().toUpperCase()) != null)
/*  325 */             field.set(baseDTO, dto.getDouble("QUERY_" + 
/*  326 */               field.getName().toUpperCase()));
/*  327 */           else if (dto.getString("QUERY_" + field.getName().toUpperCase()) != null)
/*  328 */             field.set(baseDTO, Double.valueOf(dto.getString("QUERY_" + 
/*  329 */               field.getName().toUpperCase())));
/*  330 */           else if (dto.getNumber(field.getName().toUpperCase()) != null) {
/*  331 */             field.set(baseDTO, Double.valueOf(dto.getNumber(field.getName().toUpperCase()).doubleValue()));
/*      */           }
/*  333 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  334 */         } else if (fieldType.equalsIgnoreCase("Boolean")) {
/*  335 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  336 */           if (dto.getBoolean("QUERY_" + field.getName().toUpperCase()) != null)
/*  337 */             field.set(baseDTO, dto.getBoolean("QUERY_" + 
/*  338 */               field.getName().toUpperCase()));
/*  339 */           else if (dto.getString("QUERY_" + field.getName().toUpperCase()) != null) {
/*  340 */             field.set(baseDTO, Boolean.valueOf(dto.getString("QUERY_" + 
/*  341 */               field.getName().toUpperCase())));
/*      */           }
/*  343 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  344 */         } else if (fieldType.equalsIgnoreCase("Date")) {
/*  345 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  346 */           if (dto.getDate("QUERY_" + field.getName().toUpperCase()) != null) {
/*  347 */             field.set(baseDTO, dto.getDate("QUERY_" + 
/*  348 */               field.getName().toUpperCase()));
/*  349 */           } else if (dto.getString("QUERY_" + field.getName().toUpperCase()) != null) {
/*  350 */             Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dto.getString("QUERY_" + 
/*  351 */               field.getName().toUpperCase()));
/*  352 */             field.set(baseDTO, date);
/*      */           }
/*  354 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  355 */         } else if (fieldType.equalsIgnoreCase("String")) {
/*  356 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  357 */           if (dto.getString("QUERY_" + field.getName().toUpperCase()) != null) {
/*  358 */             field.set(baseDTO, dto.getString("QUERY_" + 
/*  359 */               field.getName().toUpperCase()));
/*      */           }
/*  361 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  362 */         } else if (fieldType.equalsIgnoreCase("InputStream")) {
/*  363 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  364 */           Object value = dto.getInputStream(field.getName().toUpperCase());
/*  365 */           if (value != null) {
/*  366 */             if ((value instanceof String))
/*  367 */               field.set(baseDTO, new ByteArrayInputStream(((String)value).getBytes()));
/*  368 */             else if ((value instanceof InputStream))
/*  369 */               field.set(baseDTO, value);
/*  370 */             else if ((value instanceof Blob)) {
/*  371 */               field.set(baseDTO, ((Blob)value).getBinaryStream());
/*      */             }
/*      */           }
/*  374 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  375 */         } else if (fieldType.equalsIgnoreCase("List")) {
/*  376 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  377 */           if (dto.getList(field.getName().toUpperCase()) != null) {
/*  378 */             field.set(baseDTO, dto
/*  379 */               .getList(field.getName().toUpperCase()));
/*      */           }
/*  381 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*  382 */         } else if (fieldType.equalsIgnoreCase("HashMap")) {
/*  383 */           AccessibleObject.setAccessible(new Field[] { field }, true);
/*  384 */           if (dto.getHashMap(field.getName().toUpperCase()) != null) {
/*  385 */             field.set(baseDTO, dto
/*  386 */               .getHashMap(field.getName().toUpperCase()));
/*      */           }
/*  388 */           AccessibleObject.setAccessible(new Field[] { field }, false);
/*      */         }
/*      */       } catch (Exception ex) {
/*  391 */         ErrorProcessor.prompt(getClass().getName(), "getData() error!", ex);
/*  392 */         throw new SystemException(ex.getMessage());
/*      */       }
/*      */     }
/*  395 */     return baseDTO;
/*      */   }
/*      */ 
/*      */   protected int saveOrUpdate(BaseDTO dto) throws Exception {
/*  399 */     ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/*  400 */     if (cmMap == null) {
/*  401 */       throw new Exception("no registed class name as " + dto.getClass().getName());
/*      */     }
/*      */ 
/*  404 */     boolean isNew = false;
/*      */ 
/*  406 */     PropertyMapping[] ids = cmMap.getId();
/*  407 */     for (int i = 0; i < ids.length; i++) {
/*  408 */       if (dto.getPropertyValue(ids[i].getName()) == null) {
/*  409 */         isNew = true;
/*  410 */         break;
/*      */       }
/*  412 */       isNew = false;
/*      */     }
/*      */ 

/*  416 */     if (isNew) {
/*  417 */       return save(dto);
/*      */     }
/*  419 */     return update(dto);
/*      */   }
/*      */ 
/*      */   protected int save(BaseDTO dto) throws Exception
/*      */   {
/*  424 */     PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*  425 */     StringBuffer sStrBuf = new StringBuffer();
/*  426 */     StringBuffer sStrBufColumn = new StringBuffer();
/*  427 */     StringBuffer sStrBufValue = new StringBuffer();
/*  428 */     StringBuffer sStrParameter = new StringBuffer();
/*      */     try
/*      */     {
/*  431 */       ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/*  432 */       if (cmMap == null) {
/*  433 */         throw new Exception("no registed class name as " + dto.getClass().getName());
/*      */       }
/*      */ 
/*  436 */       sStrBuf.append("INSERT INTO ").append(cmMap.getTableName()).append(" ");
/*  437 */       PropertyMapping[] ids = cmMap.getId();
/*  438 */       List props = cmMap.getListProperty();
/*  439 */       for (int i = 0; i < ids.length; i++) {
/*  440 */         PropertyMapping id = ids[i];
/*  441 */         Object value = dto.getPropertyValue(id.getName());
/*  442 */         if ((value == null) && (id.getGenerate() != null)) {
/*  443 */           if (id.getGenerate().equals("UUID")) {
/*  444 */             value = UUID.randomUUID().toString();
/*  445 */           } else if (id.getGenerate().equals("SEQUENCE")) {
/*  446 */             String seqSql = "SELECT " + id.getGeneratevalue() + ".NEXTVAL FROM DUAL";
/*  447 */             Debug.debugMessage("id sequence gengerate sql: " + seqSql);
/*  448 */             SelectResultSet idResultSet = this.dbOperator.executeSelect(seqSql);
/*  449 */             value = Long.valueOf(idResultSet.getLongValue(0, 0));
/*  450 */             dto.setPropertyValue(id.getName(), value);
/*  451 */             Debug.debugMessage("id sequence gengerate value: " + value);
/*      */           }
/*      */ 
/*  454 */           dto.setPropertyValue(id.getName(), value);
/*      */         }
/*      */ 
/*  457 */         if (sStrBufColumn.length() == 0) {
/*  458 */           sStrBufColumn.append(id.getColumnName());
/*  459 */           sStrBufValue.append("?");
/*      */ 
/*  461 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(id.getType()).getInt(null)).intValue(), value);
/*  462 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*  463 */           sStrParameter.append(id.getName()).append(":").append(value);
/*      */         } else {
/*  465 */           sStrBufColumn.append(", ").append(id.getColumnName());
/*  466 */           sStrBufValue.append(", ?");
/*  467 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(id.getType()).getInt(null)).intValue(), value);
/*  468 */           sStrParameter.append(", ").append(id.getName()).append(":").append(value);
/*  469 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*      */         }
/*      */       }
/*      */ 
/*  473 */       for (int i = 0; i < props.size(); i++) {
/*  474 */         PropertyMapping prop = (PropertyMapping)props.get(i);
/*  475 */         Object value = dto.getPropertyValue(prop.getName());
/*  476 */         if (value != null) {
/*  477 */           if (sStrBufColumn.length() == 0) {
/*  478 */             sStrBufColumn.append(prop.getColumnName());
/*  479 */             sStrBufValue.append("?");
/*      */ 
/*  481 */             if ((prop.getType().equalsIgnoreCase("BLOB")) || (prop.getType().equalsIgnoreCase("CLOB")))
/*  482 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), (InputStream)value, getInputStreamLength((InputStream)value));
/*      */             else {
/*  484 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*      */             }
/*      */ 
/*  487 */             sStrParameter.append(prop.getName()).append(":").append(value);
/*  488 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*      */           } else {
/*  490 */             sStrBufColumn.append(", ").append(prop.getColumnName());
/*  491 */             sStrBufValue.append(", ?");
/*      */ 
/*  493 */             if ((prop.getType().equalsIgnoreCase("BLOB")) || (prop.getType().equalsIgnoreCase("CLOB")))
/*  494 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), (InputStream)value, getInputStreamLength((InputStream)value));
/*      */             else {
/*  496 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*      */             }
/*      */ 
/*  499 */             sStrParameter.append(", ").append(prop.getName()).append(":").append(value);
/*  500 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*  505 */       sStrBuf.append(" ( ").append(sStrBufColumn).append(" ) VALUES (").append(sStrBufValue).append(" ) ");
/*      */ 
/*  507 */       Debug.debugMessage("sql ====== " + sStrBuf.toString());
/*      */ 
/*  509 */       psOperator.setSql(sStrBuf.toString());
/*      */ 
/*  511 */       int result = this.dbOperator.executePreparedStatement(psOperator);
/*      */ 
/*  513 */       log("save " + dto.getClass().getName() + ";sql:" + sStrBuf.toString() + ";parameter:{" + sStrParameter.toString() + "}");
/*      */ 
/*  515 */       return result;
/*      */     } catch (Exception ex) {
/*  517 */       ErrorProcessor.prompt(getClass().getName(), "save() error", ex);
/*  518 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected int update(BaseDTO dto) throws Exception
/*      */   {
/*      */     try {
/*  524 */       PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*  525 */       StringBuffer sStrBuf = new StringBuffer();
/*  526 */       StringBuffer sStrBufCol = new StringBuffer();
/*  527 */       StringBuffer sStrParameter = new StringBuffer();
/*      */ 
/*  529 */       ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/*  530 */       if (cmMap == null) {
/*  531 */         throw new Exception("no registed class name as " + dto.getClass().getName());
/*      */       }
/*      */ 
/*  534 */       sStrBuf.append("UPDATE ").append(cmMap.getTableName()).append(" SET ");
/*      */ 
/*  536 */       List props = cmMap.getListProperty();
/*  537 */       for (int i = 0; i < props.size(); i++) {
/*  538 */         PropertyMapping prop = (PropertyMapping)props.get(i);
/*  539 */         Object value = dto.getPropertyValue(prop.getName());
/*  540 */         if (value != null) {
/*  541 */           if (sStrBufCol.length() == 0) {
/*  542 */             sStrBufCol.append(prop.getColumnName()).append(" = ? ");
/*      */ 
/*  544 */             if ((prop.getType().equalsIgnoreCase("BLOB")) || (prop.getType().equalsIgnoreCase("CLOB")))
/*  545 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), (InputStream)value, getInputStreamLength((InputStream)value));
/*      */             else {
/*  547 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*      */             }
/*      */ 
/*  550 */             sStrParameter.append(prop.getName()).append(":").append(value);
/*  551 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*      */           } else {
/*  553 */             sStrBufCol.append(", ").append(prop.getColumnName()).append(" = ? ");
/*      */ 
/*  555 */             if ((prop.getType().equalsIgnoreCase("BLOB")) || (prop.getType().equalsIgnoreCase("CLOB")))
/*  556 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), (InputStream)value, getInputStreamLength((InputStream)value));
/*      */             else {
/*  558 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*      */             }
/*      */ 
/*  561 */             sStrParameter.append(", ").append(prop.getName()).append(":").append(value);
/*  562 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*  567 */       sStrBuf.append(sStrBufCol).append(" WHERE 1 = 1");
/*      */ 
/*  569 */       PropertyMapping[] ids = cmMap.getId();
/*  570 */       for (int i = 0; i < ids.length; i++) {
/*  571 */         PropertyMapping id = ids[i];
/*  572 */         Object value = dto.getPropertyValue(id.getName());
/*  573 */         if (value != null) {
/*  574 */           sStrBuf.append(" AND ").append(id.getColumnName()).append(" = ? ");
/*  575 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(id.getType()).getInt(null)).intValue(), value);
/*  576 */           sStrParameter.append(", ").append(id.getName()).append(":").append(value);
/*  577 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*      */         }
/*      */       }
/*      */ 
/*  581 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + sStrBuf.toString());
/*      */ 
/*  583 */       psOperator.setSql(sStrBuf.toString());
/*      */ 
/*  585 */       int result = this.dbOperator.executePreparedStatement(psOperator);
/*      */ 
/*  587 */       String sAutoLog = SystemParam.getParam("AutoRecordLog");
/*  588 */       if ((sAutoLog != null) && (sAutoLog.equalsIgnoreCase("true"))) {
/*  589 */         log("update " + dto.getClass().getName() + ";sql:" + sStrBuf.toString() + ";parameter:{" + sStrParameter.toString() + "}");
/*      */       }
/*      */ 
/*  592 */       return result;
/*      */     } catch (Exception ex) {
/*  594 */       ErrorProcessor.prompt(getClass().getName(), "update() error", ex);
/*  595 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected int delete(BaseDTO dto) throws Exception
/*      */   {
/*      */     try {
/*  601 */       PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*  602 */       StringBuffer sStrBuf = new StringBuffer();
/*  603 */       StringBuffer sStrParameter = new StringBuffer();
/*      */ 
/*  605 */       ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/*  606 */       if (cmMap == null) {
/*  607 */         throw new Exception("no registed class name as " + dto.getClass().getName());
/*      */       }
/*      */ 
/*  610 */       sStrBuf.append("DELETE FROM ").append(cmMap.getTableName()).append(" WHERE 1 = 1");
/*      */ 
/*  612 */       PropertyMapping[] ids = cmMap.getId();
/*  613 */       for (int i = 0; i < ids.length; i++) {
/*  614 */         PropertyMapping id = ids[i];
/*  615 */         Object value = dto.getPropertyValue(id.getName());
/*  616 */         if (value != null) {
/*  617 */           sStrBuf.append(" AND ").append(id.getColumnName()).append(" = ? ");
/*  618 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(id.getType()).getInt(null)).intValue(), value);
/*  619 */           sStrParameter.append(", ").append(id.getName()).append(":").append(value);
/*  620 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*      */         }
/*      */       }
/*      */ 
/*  624 */       List props = cmMap.getListProperty();
/*  625 */       for (int i = 0; i < props.size(); i++) {
/*  626 */         PropertyMapping prop = (PropertyMapping)props.get(i);
/*  627 */         Object value = dto.getPropertyValue(prop.getName());
/*  628 */         if (value != null) {
/*  629 */           sStrBuf.append(" AND ").append(prop.getColumnName()).append(" = ? ");
/*  630 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  631 */           sStrParameter.append(", ").append(prop.getName()).append(":").append(value);
/*  632 */           Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*      */         }
/*      */       }
/*      */ 
/*  636 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + sStrBuf.toString());
/*  637 */       psOperator.setSql(sStrBuf.toString());
/*      */ 
/*  639 */       int result = this.dbOperator.executePreparedStatement(psOperator);
/*      */ 
/*  641 */       String sAutoLog = SystemParam.getParam("AutoRecordLog");
/*  642 */       if ((sAutoLog != null) && (sAutoLog.equalsIgnoreCase("true"))) {
/*  643 */         log("delete " + dto.getClass().getName() + ";sql:" + sStrBuf.toString() + ";parameter:{" + sStrParameter.toString().replaceFirst(",", "") + "}");
/*      */       }
/*      */ 
/*  646 */       return result;
/*      */     } catch (Exception ex) {
/*  648 */       ErrorProcessor.prompt(getClass().getName(), "delete() error", ex);
/*  649 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected List queryList(BaseDTO dto) throws Exception
/*      */   {
/*  654 */     return getDTOList(queryResultSet(dto), dto.getClass());
/*      */   }
/*      */ 
/*      */   protected List queryList(PageInfo page, BaseDTO dto) throws Exception {
/*  658 */     return getDTOList(queryResultSet(page, dto), dto.getClass());
/*      */   }
/*      */ 
/*      */   protected List queryListByName(String sConfigName, String sSqlName, DTO dto) throws Exception {
/*  662 */     return getArrayList(queryResultSetByName(sConfigName, sSqlName, dto));
/*      */   }
/*      */ 
/*      */   protected SelectResultSet queryResultSet(BaseDTO dto) throws Exception {
/*  666 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/*  667 */     if (this.dbOperator.getConnection() == null) {
/*  668 */       throw new Exception("connection is null");
/*      */     }
/*  670 */     PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*  671 */     StringBuffer sStrBuf = new StringBuffer();
/*  672 */     StringBuffer sStrBufSelect = new StringBuffer();
/*  673 */     StringBuffer sStrBufWhere = new StringBuffer();
/*      */     try
/*      */     {
/*  676 */       ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/*  677 */       if (cmMap == null) {
/*  678 */         throw new Exception("no registed class name as " + dto.getClass().getName());
/*      */       }
/*      */ 
/*  681 */       PropertyMapping[] ids = cmMap.getId();
/*  682 */       List props = cmMap.getListProperty();
/*  683 */       for (int i = 0; i < ids.length; i++) {
/*  684 */         PropertyMapping id = ids[i];
/*  685 */         if (sStrBufSelect.length() != 0) {
/*  686 */           sStrBufSelect.append(", ");
/*      */         }
/*      */ 
/*  689 */         sStrBufSelect.append(id.getColumnName());
/*  690 */         Object value = dto.getPropertyValue(id.getName());
/*  691 */         if ((value != null) && (!value.equals(""))) {
/*  692 */           sStrBufWhere.append(" AND ").append(id.getColumnName()).append(" = ?");
/*  693 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(id.getType()).getInt(null)).intValue(), value);
/*  694 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*      */         }
/*      */       }
/*      */ 
/*  698 */       for (int i = 0; i < props.size(); i++) {
/*  699 */         PropertyMapping prop = (PropertyMapping)props.get(i);
/*  700 */         if (sStrBufSelect.length() != 0) {
/*  701 */           sStrBufSelect.append(", ");
/*      */         }
/*      */ 
/*  704 */         if ((!prop.getName().endsWith("Before")) && (!prop.getName().endsWith("After"))) {
/*  705 */           sStrBufSelect.append(prop.getColumnName());
/*      */         }
/*      */ 
/*  708 */         Object value = dto.getPropertyValue(prop.getName());
/*  709 */         if ((value != null) && (!value.equals(""))) {
/*  710 */           if (prop.getType().equals("VARCHAR2")) {
/*  711 */             if (prop.getColumnName().toUpperCase().endsWith("ID")) {
/*  712 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" = ?");
/*  713 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  714 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             } else {
/*  716 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" like ?");
/*  717 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), "%" + value + "%");
/*  718 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " %" + value + "%");
/*      */             }
/*  720 */           } else if (prop.getType().equals("DATE")) {
/*  721 */             if (prop.getName().endsWith("Before")) {
/*  722 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" >= ?");
/*  723 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  724 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             }
/*      */ 
/*  727 */             if (prop.getName().endsWith("After")) {
/*  728 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" <= ?");
/*  729 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  730 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             }
/*      */ 
/*  733 */             if ((!prop.getName().endsWith("Before")) && (!prop.getName().endsWith("After"))) {
/*  734 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" == ?");
/*  735 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  736 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             }
/*      */           } else {
/*  739 */             sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" = ?");
/*  740 */             psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  741 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*  746 */       sStrBuf.append("SELECT * FROM ").append(cmMap.getTableName()).append(" WHERE 1 = 1 ").append(sStrBufWhere);
/*      */ 
/*  748 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + sStrBuf.toString());
/*  749 */       psOperator.setSql(sStrBuf.toString());
/*      */ 
/*  751 */       return this.dbOperator.executeSelect(psOperator);
/*      */     } catch (Exception ex) {
/*  753 */       ErrorProcessor.prompt(getClass().getName(), "parameter error", ex);
/*  754 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected SelectResultSet queryStatResultSet(BaseDTO dto, String select, String groupby) throws Exception
/*      */   {
/*  759 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/*  760 */     if (this.dbOperator.getConnection() == null) {
/*  761 */       throw new Exception("connection is null");
/*      */     }
/*      */ 
/*  764 */     PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*  765 */     StringBuffer sStrBuf = new StringBuffer();
/*  766 */     StringBuffer sStrBufSelect = new StringBuffer();
/*  767 */     StringBuffer sStrBufWhere = new StringBuffer();
/*      */     try
/*      */     {
/*  770 */       ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/*  771 */       if (cmMap == null) {
/*  772 */         throw new Exception("no registed class name as " + dto.getClass().getName());
/*      */       }
/*      */ 
/*  775 */       PropertyMapping[] ids = cmMap.getId();
/*  776 */       List props = cmMap.getListProperty();
/*  777 */       for (int i = 0; i < ids.length; i++) {
/*  778 */         PropertyMapping id = ids[i];
/*  779 */         if (sStrBufSelect.length() != 0) {
/*  780 */           sStrBufSelect.append(", ");
/*      */         }
/*      */ 
/*  783 */         sStrBufSelect.append(id.getColumnName());
/*  784 */         Object value = dto.getPropertyValue(id.getName());
/*  785 */         if ((value != null) && (!value.equals(""))) {
/*  786 */           sStrBufWhere.append(" AND ").append(id.getColumnName()).append(" = ?");
/*  787 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(id.getType()).getInt(null)).intValue(), value);
/*  788 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*      */         }
/*      */       }
/*      */ 
/*  792 */       for (int i = 0; i < props.size(); i++) {
/*  793 */         PropertyMapping prop = (PropertyMapping)props.get(i);
/*  794 */         if (sStrBufSelect.length() != 0) {
/*  795 */           sStrBufSelect.append(", ");
/*      */         }
/*      */ 
/*  798 */         if ((!prop.getName().endsWith("Before")) && (!prop.getName().endsWith("After"))) {
/*  799 */           sStrBufSelect.append(prop.getColumnName());
/*      */         }
/*      */ 
/*  802 */         Object value = dto.getPropertyValue(prop.getName());
/*  803 */         if ((value != null) && (!value.equals(""))) {
/*  804 */           if (prop.getType().equals("VARCHAR2")) {
/*  805 */             sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" like ?");
/*  806 */             psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), "%" + value + "%");
/*  807 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " %" + value + "%");
/*  808 */           } else if (prop.getType().equals("DATE")) {
/*  809 */             if (prop.getName().endsWith("Before")) {
/*  810 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" >= ?");
/*  811 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  812 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             }
/*      */ 
/*  815 */             if (prop.getName().endsWith("After")) {
/*  816 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" <= ?");
/*  817 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  818 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             }
/*      */ 
/*  821 */             if ((!prop.getName().endsWith("Before")) && (!prop.getName().endsWith("After"))) {
/*  822 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" == ?");
/*  823 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  824 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             }
/*      */           } else {
/*  827 */             sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" = ?");
/*  828 */             psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  829 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*  834 */       sStrBuf.append("SELECT * FROM ").append(cmMap.getTableName()).append(" WHERE 1 = 1 ").append(sStrBufWhere);
/*      */ 
/*  836 */       StringBuffer sStrstat = new StringBuffer();
/*  837 */       sStrstat.append("SELECT ").append(select).append(" FROM (").append(sStrBuf).append(")");
/*  838 */       if (groupby != null) {
/*  839 */         sStrstat.append(" GROUP BY ").append(groupby);
/*      */       }
/*      */ 
/*  842 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + sStrstat.toString());
/*  843 */       psOperator.setSql(sStrstat.toString());
/*      */ 
/*  845 */       return this.dbOperator.executeSelect(psOperator);
/*      */     } catch (Exception ex) {
/*  847 */       ErrorProcessor.prompt(getClass().getName(), "parameter error", ex);
/*  848 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected SelectResultSet queryResultSet(PageInfo pages, BaseDTO dto) throws Exception
/*      */   {
/*  853 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/*  854 */     if (this.dbOperator.getConnection() == null) {
/*  855 */       throw new Exception("connection is null");
/*      */     }
/*      */ 
/*  858 */     PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*  859 */     StringBuffer sStrBufCnt = new StringBuffer();
/*  860 */     StringBuffer sStrBuf = new StringBuffer();
/*  861 */     StringBuffer sStrBufSelect = new StringBuffer();
/*  862 */     StringBuffer sStrBufWhere = new StringBuffer();
/*      */     try
/*      */     {
/*  865 */       ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dto.getClass().getName());
/*  866 */       if (cmMap == null) {
/*  867 */         throw new Exception("no registed class name as " + dto.getClass().getName());
/*      */       }
/*      */ 
/*  870 */       PropertyMapping[] ids = cmMap.getId();
/*  871 */       List props = cmMap.getListProperty();
/*  872 */       for (int i = 0; i < ids.length; i++) {
/*  873 */         PropertyMapping id = ids[i];
/*  874 */         Object value = dto.getPropertyValue(id.getName());
/*  875 */         if (sStrBufSelect.length() != 0) {
/*  876 */           sStrBufSelect.append(", ").append(id.getColumnName());
/*      */         }
/*      */ 
/*  879 */         sStrBufSelect.append(id.getColumnName());
/*  880 */         if ((value != null) && (!value.equals(""))) {
/*  881 */           sStrBufWhere.append(" AND ").append(id.getColumnName()).append(" = ?");
/*  882 */           psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(id.getType()).getInt(null)).intValue(), value);
/*  883 */           Debug.debugMessage("add param === " + id.getName() + " " + id.getType() + " " + value);
/*      */         }
/*      */       }
/*      */ 
/*  887 */       for (int i = 0; i < props.size(); i++) {
/*  888 */         PropertyMapping prop = (PropertyMapping)props.get(i);
/*  889 */         if (sStrBufSelect.length() != 0) {
/*  890 */           sStrBufSelect.append(", ");
/*      */         }
/*      */ 
/*  893 */         if ((!prop.getName().endsWith("Before")) && (!prop.getName().endsWith("After"))) {
/*  894 */           sStrBufSelect.append(prop.getColumnName());
/*      */         }
/*      */ 
/*  897 */         Object value = dto.getPropertyValue(prop.getName());
/*      */ 
/*  899 */         if ((value != null) && (!value.equals(""))) {
/*  900 */           if (prop.getType().equals("VARCHAR2")) {
/*  901 */             if (prop.getColumnName().toUpperCase().endsWith("ID")) {
/*  902 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" = ?");
/*  903 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  904 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             } else {
/*  906 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" like ?");
/*  907 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), "%" + value + "%");
/*  908 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " %" + value + "%");
/*      */             }
/*  910 */           } else if (prop.getType().equals("DATE")) {
/*  911 */             if (prop.getName().endsWith("Before")) {
/*  912 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" >= ?");
/*  913 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  914 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             }
/*      */ 
/*  917 */             if (prop.getName().endsWith("After")) {
/*  918 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" <= ?");
/*  919 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  920 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             }
/*      */ 
/*  923 */             if ((!prop.getName().endsWith("Before")) && (!prop.getName().endsWith("After"))) {
/*  924 */               sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" == ?");
/*  925 */               psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  926 */               Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + value);
/*      */             }
/*      */           } else {
/*  929 */             sStrBufWhere.append(" AND ").append(prop.getColumnName()).append(" = ?");
/*  930 */             psOperator.addParameter(Integer.valueOf(DBOperator.class.getDeclaredField(prop.getType()).getInt(null)).intValue(), value);
/*  931 */             Debug.debugMessage("add param === " + prop.getName() + " " + prop.getType() + " " + value);
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/*  936 */       sStrBufCnt.append("SELECT COUNT(1) FROM ").append(cmMap.getTableName()).append(" WHERE 1 = 1 ").append(sStrBufWhere);
/*  937 */       psOperator.setSql(sStrBufCnt.toString());
/*  938 */       SelectResultSet rs = this.dbOperator.executeSelect(psOperator);
/*  939 */       int count = rs.getIntValue(0, 0);
/*  940 */       pages.setRowsCount(count);
/*      */ 
/*  942 */       sStrBuf.append("SELECT * FROM ").append(cmMap.getTableName()).append(" WHERE 1 = 1 ").append(sStrBufWhere);
/*      */ 
/*  944 */       StringBuffer sSelect = new StringBuffer();
/*  945 */       sSelect.append("SELECT * FROM (SELECT T.*, ROWNUM RN FROM (").append(sStrBuf).append(") T) WHERE RN >= ").append((pages.getPageIndex().intValue() - 1) * pages.getRowNumber().intValue() + 1).append(" AND RN <= ").append(pages.getPageIndex().intValue() * pages.getRowNumber().intValue());
/*      */ 
/*  947 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + sSelect.toString());
/*  948 */       psOperator.setSql(sSelect.toString());
/*      */ 
/*  950 */       return this.dbOperator.executeSelect(psOperator);
/*      */     } catch (Exception ex) {
/*  952 */       ErrorProcessor.prompt(getClass().getName(), "parameter error", ex);
/*  953 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected SelectResultSet queryResultSetByName(String sConfigName, String sSqlName, DTO dto) throws Exception
/*      */   {
/*  958 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/*  959 */     if (this.dbOperator.getConnection() == null) {
/*  960 */       throw new Exception("connection is null");
/*      */     }
/*      */ 
/*  963 */     String sql = "";
/*  964 */     List parameterTypes = new ArrayList();
/*  965 */     List parameters = new ArrayList();
/*      */ 
/*  967 */     PreparedStatementOperator preparedStatementOperator = new PreparedStatementOperator(sql);
/*      */ 
/*  970 */     File file = new File(SystemParam.getParam("AbsolutePath") + "Config/SqlConfig/" + sConfigName);
/*  971 */     Document doc = null;
/*  972 */     Element root = null;
/*      */ 
/*  974 */     if (file.isDirectory()) {
/*  975 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), 
						this.request.getResponseServiceName(), sConfigName + " is a directory but no a config file.");
/*  976 */       return null;
/*      */     }
/*      */ 
/*  979 */     if (!file.exists()) {
/*  980 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), sConfigName + " is not found.");
/*  981 */       return null;
/*      */     }
/*  983 */     SAXBuilder sax = new SAXBuilder();
/*      */     try {
/*  985 */       doc = sax.build(file.getAbsoluteFile());
/*      */     } catch (Exception ex) {
/*  987 */       Debug.errorMessage(sConfigName + " is not a xml file.");
/*  988 */       return null;
/*      */     }
/*      */ 
/*  991 */     if (doc == null) {
/*  992 */       return null;
/*      */     }

/*  994 */     root = doc.getRootElement();
/*      */ 
/*  998 */     Element sql_config = null;

/*  999 */     List list = root.getChildren("sql-config");
/* 1000 */     for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object obj = localIterator.next();
/* 1001 */       Element elem = (Element)obj;
/* 1002 */       String sql_config_name = elem.getAttributeValue("name");
/* 1003 */       if (sql_config_name.equals(sSqlName)) {
/* 1004 */         sql_config = elem;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1010 */     if (sql_config == null) 
			   {
/* 1011 */       Debug.errorMessage("no sql name found in " + sConfigName);
/* 1012 */       return null;
/*      */     }
/*      */ 
/* 1015 */     sql = sql_config.getChild("sql").getTextTrim();
/*      */ 
/* 1017 */     list = sql_config.getChildren("param");
/* 1018 */     for (localIterator = list.iterator(); localIterator.hasNext(); ) { Object obj = localIterator.next();
/* 1019 */       Element pelem = (Element)obj;
/* 1020 */       String name = pelem.getAttributeValue("name");
/* 1021 */       String banding = pelem.getAttributeValue("valueBanding");
/* 1022 */       String type = pelem.getAttributeValue("parameterType");
/* 1023 */       parameterTypes.add(type);
/* 1024 */       Object value = null;
/* 1025 */       if (type.equals("VARCHAR2"))
/* 1026 */         value = dto.getString(banding);
/* 1027 */       else if (type.equals("LONGNUMBER")) {
/* 1028 */         if (dto.getLong(banding) != null)
/* 1029 */           value = dto.getLong(banding);
/* 1030 */         else if (dto.getString(banding) != null)
/* 1031 */           value = Long.valueOf(dto.getString(banding));
/*      */       }
/* 1033 */       else if (type.equals("DOUBLENUMBER")) {
/* 1034 */         if (dto.getDouble(banding) != null)
/* 1035 */           value = dto.getDouble(banding);
/* 1036 */         else if (dto.getString(banding) != null)
/* 1037 */           value = Double.valueOf(dto.getString(banding));
/*      */       }
/* 1039 */       else if (type.equals("DATE")) {
/* 1040 */         if (dto.getDate(banding) != null) {
/* 1041 */           value = dto.getDate(banding);
/* 1042 */         } else if (dto.getString(banding) != null) {
/* 1043 */           Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dto.getString(banding));
/* 1044 */           value = date;
/*      */         }
/* 1046 */       } else if (type.equals("NUMBER")) {
/* 1047 */         if (dto.getInt(banding) != null)
/* 1048 */           value = dto.getInt(banding);
/* 1049 */         else if (dto.getString(banding) != null)
/* 1050 */           value = Integer.valueOf(dto.getString(banding));
/*      */       }
/*      */       else {
/* 1053 */         value = dto.get(banding);
/*      */       }
/*      */ 
/* 1056 */       parameters.add(value);
/*      */     }
/*      */ 
/* 1059 */     preparedStatementOperator.setSql(sql);
/*      */ 
/* 1061 */     Debug.debugMessage(0, this.request, "sql ====== " + sql);
/*      */     try
/*      */     {
/* 1064 */       for (int i = 0; i < parameters.size(); i++) {
/* 1065 */         int parameterType = DBOperator.class.getDeclaredField((String)parameterTypes.get(i)).getInt(null);
/* 1066 */         Object obj = parameters.get(i);
/* 1067 */         preparedStatementOperator.addParameter(i, parameterType, obj);
/*      */ 
/* 1069 */         Debug.debugMessage("add param === " + parameters.get(i) + " --- " + obj);
/*      */       }
/*      */     } catch (Exception e) {
/* 1072 */       ErrorProcessor.prompt(getClass().getName(), "queryInfoList() error!", e);
/* 1073 */       throw new SystemException(e.getMessage());
/*      */     }
/*      */ 
/* 1076 */     SelectResultSet result = this.dbOperator.executeSelect(preparedStatementOperator);
/* 1077 */     return result;
/*      */   }
/*      */ 
/*      */   protected int executeSql(String sql) throws Exception {
/* 1081 */     return executeSql(sql, null, null);
/*      */   }
/*      */ 
/*      */   protected int executeSql(String sql, int[] paramTypes, Object[] params) throws Exception {
/* 1085 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/* 1086 */     if (this.dbOperator.getConnection() == null) {
/* 1087 */       throw new Exception("connection is null");
/*      */     }
/*      */ 
/* 1090 */     Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + sql);
/*      */ 
/* 1092 */     PreparedStatementOperator preparedStatementOperator = new PreparedStatementOperator(sql);
/*      */ 
/* 1094 */     if (params != null) {
/* 1095 */       for (int i = 0; i < params.length; i++) {
/* 1096 */         preparedStatementOperator.addParameter(paramTypes[i], params[i]);
/*      */ 
/* 1098 */         Debug.debugMessage("add paramter: param = " + params[i] + " type = " + paramTypes[i]);
/*      */       }
/*      */     }
/*      */ 
/* 1102 */     return this.dbOperator.executePreparedStatement(preparedStatementOperator);
/*      */   }
/*      */ 
/*      */   protected int executeSql(String sql, int[] paramTypes, Object[] params, int[] length) throws Exception {
/* 1106 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/* 1107 */     if (this.dbOperator.getConnection() == null) {
/* 1108 */       throw new Exception("connection is null");
/*      */     }
/*      */ 
/* 1111 */     Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + sql);
/*      */ 
/* 1113 */     PreparedStatementOperator preparedStatementOperator = new PreparedStatementOperator(sql);
/*      */ 
/* 1115 */     if (params != null) {
/* 1116 */       for (int i = 0; i < params.length; i++) {
/* 1117 */         if ((paramTypes[i] == DBOperator.BLOB) || (paramTypes[i] == DBOperator.CLOB))
/* 1118 */           preparedStatementOperator.addParameter(paramTypes[i], (InputStream)params[i], length[i]);
/*      */         else {
/* 1120 */           preparedStatementOperator.addParameter(paramTypes[i], params[i]);
/*      */         }
/*      */ 
/* 1123 */         Debug.debugMessage("add paramter: param = " + params[i] + " type = " + paramTypes[i]);
/*      */       }
/*      */     }
/*      */ 
/* 1127 */     return this.dbOperator.executePreparedStatement(preparedStatementOperator);
/*      */   }
/*      */ 
/*      */   protected int executeSqlByName(String sConfigName, String sSqlName, DTO dto) throws Exception {
/* 1131 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/* 1132 */     if (this.dbOperator.getConnection() == null) {
/* 1133 */       throw new Exception("connection is null");
/*      */     }
/*      */ 
/* 1136 */     String sql = "";
/* 1137 */     List parameterTypes = new ArrayList();
/* 1138 */     List parameters = new ArrayList();
/*      */ 
/* 1140 */     PreparedStatementOperator preparedStatementOperator = new PreparedStatementOperator(sql);
/*      */ 
/* 1143 */     File file = new File(SystemParam.getParam("AbsolutePath") + "Config/SqlConfig/" + sConfigName);

/* 1144 */     Document doc = null;
/* 1145 */     Element root = null;
/*      */ 
/* 1147 */     if (file.isDirectory()) {
/* 1148 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), sConfigName + " is a directory but no a config file.");
/* 1149 */       return -1;
/*      */     }
/*      */ 
/* 1152 */     if (!file.exists()) {
/* 1153 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), sConfigName + " is not found.");
/* 1154 */       return -1;
/*      */     }
/* 1156 */     SAXBuilder sax = new SAXBuilder();
/*      */     try {
/* 1158 */       doc = sax.build(file.getAbsoluteFile());
/*      */     } catch (Exception ex) {
/* 1160 */       Debug.errorMessage(sConfigName + " is not a xml file.");
/* 1161 */       return -1;
/*      */     }
/*      */ 
/* 1164 */     if (doc == null) {
/* 1165 */       return -1;
/*      */     }
/* 1167 */     root = doc.getRootElement();
/*      */ 


/* 1171 */     Element sql_config = null;
/* 1172 */     List list = root.getChildren("sql-config");
/* 1173 */     for (Iterator localIterator = list.iterator(); localIterator.hasNext(); ) { Object obj = localIterator.next();
/* 1174 */       Element elem = (Element)obj;
/* 1175 */       String sql_config_name = elem.getAttributeValue("name");
/* 1176 */       if (sql_config_name.equals(sSqlName)) {
/* 1177 */         sql_config = elem;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/* 1183 */     if (sql_config == null) {
/* 1184 */       Debug.errorMessage("no sql name found in " + sConfigName);
/* 1185 */       return -1;
/*      */     }
/*      */ 

/* 1188 */     sql = sql_config.getChild("sql").getTextTrim();
/*      */ 
/* 1190 */     list = sql_config.getChildren("param");
/* 1191 */     for (localIterator = list.iterator(); localIterator.hasNext(); ) { Object obj = localIterator.next();
/* 1192 */       Element pelem = (Element)obj;
/* 1193 */       String name = pelem.getAttributeValue("name");
/* 1194 */       String banding = pelem.getAttributeValue("valueBanding");
/* 1195 */       String type = pelem.getAttributeValue("parameterType");
/* 1196 */       parameterTypes.add(type);
/* 1197 */       Object value = null;
/* 1198 */       if (type.equals("VARCHAR2"))
/* 1199 */         value = dto.getString(banding);
/* 1200 */       else if (type.equals("LONGNUMBER")) {
/* 1201 */         if (dto.getLong(banding) != null)
/* 1202 */           value = dto.getLong(banding);
/* 1203 */         else if (dto.getString(banding) != null)
/* 1204 */           value = Long.valueOf(dto.getString(banding));
/*      */       }
/* 1206 */       else if (type.equals("DOUBLENUMBER")) {
/* 1207 */         if (dto.getDouble(banding) != null)
/* 1208 */           value = dto.getDouble(banding);
/* 1209 */         else if (dto.getString(banding) != null)
/* 1210 */           value = Double.valueOf(dto.getString(banding));
/*      */       }
/* 1212 */       else if (type.equals("DATE")) {
/* 1213 */         if (dto.getDate(banding) != null) {
/* 1214 */           value = dto.getDate(banding);
/* 1215 */         } else if (dto.getString(banding) != null) {
/* 1216 */           Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dto.getString(banding));
/* 1217 */           value = date;
/*      */         }
/* 1219 */       } else if (type.equals("NUMBER")) {
/* 1220 */         if (dto.getInt(banding) != null)
/* 1221 */           value = dto.getInt(banding);
/* 1222 */         else if (dto.getString(banding) != null)
/* 1223 */           value = Integer.valueOf(dto.getString(banding));
/*      */       }
/*      */       else {
/* 1226 */         value = dto.get(banding);
/*      */       }
/*      */ 
/* 1229 */       parameters.add(value);
/*      */     }
/*      */ 
/* 1232 */     preparedStatementOperator.setSql(sql);
/*      */ 
/* 1234 */     Debug.debugMessage(0, this.request, "sql ====== " + sql);
/*      */ 
/* 1236 */     for (int i = 0; i < parameters.size(); i++) {
/* 1237 */       int parameterType = DBOperator.class.getDeclaredField((String)parameterTypes.get(i)).getInt(null);
/* 1238 */       Object obj = parameters.get(i);
/* 1239 */       preparedStatementOperator.addParameter(i, parameterType, obj);
/*      */ 
/* 1241 */       Debug.debugMessage("add param === " + parameters.get(i) + " --- " + obj);
/*      */     }
/*      */ 
/* 1244 */     return this.dbOperator.executePreparedStatement(preparedStatementOperator);
/*      */   }
/*      */ 
/*      */   protected SelectResultSet queryResultSet(PageInfo pages, Conditions conditions) throws Exception {
/* 1248 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/* 1249 */     if (this.dbOperator.getConnection() == null) {
/* 1250 */       throw new Exception("connection is null");
/*      */     }
/*      */     try
/*      */     {
/* 1254 */       PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*      */ 
/* 1256 */       List conditionList = conditions.getConditions();
/* 1257 */       if (conditions == null) {
/* 1258 */         return null;
/*      */       }
/*      */ 
/* 1261 */       StringBuffer selectHql = new StringBuffer();
/* 1262 */       StringBuffer fromHql = new StringBuffer();
/* 1263 */       StringBuffer whereHql = new StringBuffer();
/* 1264 */       StringBuffer orderHql = new StringBuffer();
/*      */ 
/* 1266 */       List params = new ArrayList();
/*      */       String alias;
/* 1268 */       for (int i = 0; i < conditionList.size(); i++) {
/* 1269 */         Condition condition = (Condition)conditionList.get(i);
/*      */ 
/* 1271 */         alias = "dto" + (i + 1);
/* 1272 */         select = condition.getSelectHql(alias);
/* 1273 */         String where = condition.getWhereHql(alias, params);
/* 1274 */         String order = condition.getOrderHql(alias);
/*      */ 
/* 1276 */         if ((select != null) && (!select.equals(""))) {
/* 1277 */           if (selectHql.length() != 0) {
/* 1278 */             selectHql.append(", ");
/*      */           }
/*      */ 
/* 1281 */           selectHql.append(select);
/*      */         }
/*      */ 
/* 1284 */         if (fromHql.length() != 0) {
/* 1285 */           fromHql.append(", ");
/*      */         }
/*      */ 
/* 1288 */         fromHql.append(condition.getDTOName()).append(" dto").append(i + 1);
/*      */ 
/* 1290 */         whereHql.append(where);
/*      */ 
/* 1292 */         if ((order != null) && (!order.equals(""))) {
/* 1293 */           if (orderHql.length() != 0) {
/* 1294 */             orderHql.append(", ");
/*      */           }
/*      */ 
/* 1297 */           orderHql.append(order);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1302 */       selectHql.insert(0, "select ");
/* 1303 */       fromHql.insert(0, " from ");
/* 1304 */       whereHql.insert(0, " where 1 = 1");
/*      */ 
/* 1306 */       List expression = conditions.getExpression();
/* 1307 */       for (String exp : expression) {
/* 1308 */         whereHql.append(" and ").append(exp);
/*      */       }
/*      */ 
/* 1311 */       if (orderHql.length() != 0) {
/* 1312 */         orderHql.insert(0, " order by ");
/*      */       }
/*      */ 
/* 1315 */       String hql = selectHql.toString() + fromHql.toString() + 
/* 1316 */         whereHql.toString() + orderHql.toString();
/*      */ 
/* 1318 */       params.addAll(conditions.getExpParam());
/* 1319 */       psOperator.setSql(hql);
/*      */ 
/* 1321 */       for (String select = params.iterator(); select.hasNext(); ) { Object param = select.next();
/* 1322 */         if ((param instanceof Integer))
/* 1323 */           psOperator.addParameter(DBOperator.NUMBER, param);
/* 1324 */         else if ((param instanceof Long))
/* 1325 */           psOperator.addParameter(DBOperator.LONGNUMBER, param);
/* 1326 */         else if ((param instanceof Double))
/* 1327 */           psOperator.addParameter(DBOperator.DOUBLENUMBER, param);
/* 1328 */         else if ((param instanceof Date))
/* 1329 */           psOperator.addParameter(DBOperator.DATE, param);
/* 1330 */         else if ((param instanceof String)) {
/* 1331 */           psOperator.addParameter(DBOperator.VARCHAR2, param);
/*      */         }
/*      */ 
/* 1334 */         Debug.debugMessage("add param === " + param);
/*      */       }
/*      */ 
/* 1337 */       StringBuffer sStrBufCnt = new StringBuffer();
/* 1338 */       sStrBufCnt.append("SELECT COUNT(1) FROM (").append(hql).append(")");
/* 1339 */       psOperator.setSql(sStrBufCnt.toString());
/* 1340 */       SelectResultSet rs = this.dbOperator.executeSelect(psOperator);
/* 1341 */       int count = rs.getIntValue(0, 0);
/* 1342 */       pages.setRowsCount(count);
/*      */ 
/* 1344 */       StringBuffer sSelect = new StringBuffer();
/* 1345 */       sSelect.append("SELECT * FROM (SELECT T.*, ROWNUM RN FROM (").append(hql).append(") T) WHERE RN >= ").append((pages.getPageIndex().intValue() - 1) * pages.getRowNumber().intValue() + 1).append(" AND RN <= ").append(pages.getPageIndex().intValue() * pages.getRowNumber().intValue());
/* 1346 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + sSelect.toString());
/*      */ 
/* 1348 */       psOperator.setSql(sSelect.toString());
/* 1349 */       return this.dbOperator.executeSelect(psOperator);
/*      */     } catch (Exception ex) {
/* 1351 */       ErrorProcessor.prompt(getClass().getName(), "queryInfoList() error!", ex);
/* 1352 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected SelectResultSet queryResultSet(Conditions conditions) throws Exception
/*      */   {
/* 1357 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/* 1358 */     if (this.dbOperator.getConnection() == null) {
/* 1359 */       throw new Exception("connection is null");
/*      */     }
/*      */     try
/*      */     {
/* 1363 */       PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*      */ 
/* 1365 */       List conditionList = conditions.getConditions();
/* 1366 */       if (conditions == null) {
/* 1367 */         return null;
/*      */       }
/*      */ 
/* 1370 */       StringBuffer selectHql = new StringBuffer();
/* 1371 */       StringBuffer fromHql = new StringBuffer();
/* 1372 */       StringBuffer whereHql = new StringBuffer();
/* 1373 */       StringBuffer orderHql = new StringBuffer();
/*      */ 
/* 1375 */       List params = new ArrayList();
/*      */       String alias;
/* 1377 */       for (int i = 0; i < conditionList.size(); i++) {
/* 1378 */         Condition condition = (Condition)conditionList.get(i);
/*      */ 
/* 1380 */         alias = "dto" + (i + 1);
/* 1381 */         select = condition.getSelectHql(alias);
/* 1382 */         String where = condition.getWhereHql(alias, params);
/* 1383 */         String order = condition.getOrderHql(alias);
/*      */ 
/* 1385 */         if ((select != null) && (!select.equals(""))) {
/* 1386 */           if (selectHql.length() != 0) {
/* 1387 */             selectHql.append(", ");
/*      */           }
/*      */ 
/* 1390 */           selectHql.append(select);
/*      */         }
/*      */ 
/* 1393 */         if (fromHql.length() != 0) {
/* 1394 */           fromHql.append(", ");
/*      */         }
/*      */ 
/* 1397 */         fromHql.append(condition.getDTOName()).append(" dto").append(i + 1);
/*      */ 
/* 1399 */         whereHql.append(where);
/*      */ 
/* 1401 */         if ((order != null) && (!order.equals(""))) {
/* 1402 */           if (orderHql.length() != 0) {
/* 1403 */             orderHql.append(", ");
/*      */           }
/*      */ 
/* 1406 */           orderHql.append(order);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1411 */       selectHql.insert(0, "select ");
/* 1412 */       fromHql.insert(0, " from ");
/* 1413 */       whereHql.insert(0, " where 1 = 1");
/*      */ 
/* 1415 */       List expression = conditions.getExpression();
/* 1416 */       for (String exp : expression) {
/* 1417 */         whereHql.append(" and ").append(exp);
/*      */       }
/*      */ 
/* 1420 */       if (orderHql.length() != 0) {
/* 1421 */         orderHql.insert(0, " order by ");
/*      */       }
/*      */ 
/* 1424 */       String hql = selectHql.toString() + fromHql.toString() + 
/* 1425 */         whereHql.toString() + orderHql.toString();
/*      */ 
/* 1427 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + hql);
/*      */ 
/* 1429 */       params.addAll(conditions.getExpParam());
/* 1430 */       psOperator.setSql(hql);
/*      */ 
/* 1432 */       for (String select = params.iterator(); select.hasNext(); ) { Object param = select.next();
/* 1433 */         if ((param instanceof Integer))
/* 1434 */           psOperator.addParameter(DBOperator.NUMBER, param);
/* 1435 */         else if ((param instanceof Long))
/* 1436 */           psOperator.addParameter(DBOperator.LONGNUMBER, param);
/* 1437 */         else if ((param instanceof Double))
/* 1438 */           psOperator.addParameter(DBOperator.DOUBLENUMBER, param);
/* 1439 */         else if ((param instanceof Date))
/* 1440 */           psOperator.addParameter(DBOperator.DATE, param);
/* 1441 */         else if ((param instanceof String)) {
/* 1442 */           psOperator.addParameter(DBOperator.VARCHAR2, param);
/*      */         }
/*      */ 
/* 1445 */         Debug.debugMessage("add param === " + param);
/*      */       }
/*      */ 

/* 1449 */       return this.dbOperator.executeSelect(psOperator);
/*      */     } catch (Exception ex) {
/* 1451 */       ErrorProcessor.prompt(getClass().getName(), "queryInfoList() error!", ex);
/* 1452 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected SelectResultSet queryStatResultSet(Conditions conditions, String statselect, String groupby) throws Exception
/*      */   {
/* 1457 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/* 1458 */     if (this.dbOperator.getConnection() == null) {
/* 1459 */       throw new Exception("connection is null");
/*      */     }
/*      */     try
/*      */     {
/* 1463 */       PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*      */ 
/* 1465 */       List conditionList = conditions.getConditions();
/* 1466 */       if (conditions == null) {
/* 1467 */         return null;
/*      */       }
/*      */ 
/* 1470 */       StringBuffer selectHql = new StringBuffer();
/* 1471 */       StringBuffer fromHql = new StringBuffer();
/* 1472 */       StringBuffer whereHql = new StringBuffer();
/* 1473 */       StringBuffer orderHql = new StringBuffer();
/*      */ 
/* 1475 */       List params = new ArrayList();
/*      */       String alias;
/* 1477 */       for (int i = 0; i < conditionList.size(); i++) {
/* 1478 */         Condition condition = (Condition)conditionList.get(i);
/*      */ 
/* 1480 */         alias = "dto" + (i + 1);
/* 1481 */         String select = condition.getSelectHql(alias);
/* 1482 */         where = condition.getWhereHql(alias, params);
/* 1483 */         String order = condition.getOrderHql(alias);
/*      */ 
/* 1485 */         if ((select != null) && (!select.equals(""))) {
/* 1486 */           if (selectHql.length() != 0) {
/* 1487 */             selectHql.append(", ");
/*      */           }
/*      */ 
/* 1490 */           selectHql.append(select);
/*      */         }
/*      */ 
/* 1493 */         if (fromHql.length() != 0) {
/* 1494 */           fromHql.append(", ");
/*      */         }
/*      */ 
/* 1497 */         fromHql.append(condition.getDTOName()).append(" dto").append(i + 1);
/*      */ 
/* 1499 */         whereHql.append(where);
/*      */ 
/* 1501 */         if ((order != null) && (!order.equals(""))) {
/* 1502 */           if (orderHql.length() != 0) {
/* 1503 */             orderHql.append(", ");
/*      */           }
/*      */ 
/* 1506 */           orderHql.append(order);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1511 */       selectHql.insert(0, "select ");
/* 1512 */       fromHql.insert(0, " from ");
/* 1513 */       whereHql.insert(0, " where 1 = 1");
/*      */ 
/* 1515 */       List expression = conditions.getExpression();
/* 1516 */       for (String exp : expression) {
/* 1517 */         whereHql.append(" and ").append(exp);
/*      */       }
/*      */ 
/* 1520 */       if (orderHql.length() != 0) {
/* 1521 */         orderHql.insert(0, " order by ");
/*      */       }
/*      */ 
/* 1524 */       String hql = selectHql.toString() + fromHql.toString() + 
/* 1525 */         whereHql.toString() + orderHql.toString();
/*      */ 
/* 1527 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + hql);
/*      */ 
/* 1529 */       params.addAll(conditions.getExpParam());
/*      */ 
/* 1531 */       String sql = "SELECT " + statselect + " FROM (" + hql + ")";
/* 1532 */       if (groupby != null) {
/* 1533 */         sql = sql + " GROUP BY " + groupby;
/*      */       }
/* 1535 */       psOperator.setSql(sql);
/*      */ 
/* 1537 */       for (String where = params.iterator(); where.hasNext(); ) { Object param = where.next();
/* 1538 */         if ((param instanceof Integer))
/* 1539 */           psOperator.addParameter(DBOperator.NUMBER, param);
/* 1540 */         else if ((param instanceof Long))
/* 1541 */           psOperator.addParameter(DBOperator.LONGNUMBER, param);
/* 1542 */         else if ((param instanceof Double))
/* 1543 */           psOperator.addParameter(DBOperator.DOUBLENUMBER, param);
/* 1544 */         else if ((param instanceof Date))
/* 1545 */           psOperator.addParameter(DBOperator.DATE, param);
/* 1546 */         else if ((param instanceof String)) {
/* 1547 */           psOperator.addParameter(DBOperator.VARCHAR2, param);
/*      */         }
/*      */ 
/* 1550 */         Debug.debugMessage("add param === " + param);
/*      */       }
/*      */ 

/* 1554 */       return this.dbOperator.executeSelect(psOperator);
/*      */     } catch (Exception ex) {
/* 1556 */       ErrorProcessor.prompt(getClass().getName(), "queryInfoList() error!", ex);
/* 1557 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected SelectResultSet querySelectResultSet(PageInfo pages, Conditions conditions) throws Exception
/*      */   {
/* 1562 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/* 1563 */     if (this.dbOperator.getConnection() == null) {
/* 1564 */       throw new Exception("connection is null");
/*      */     }
/*      */     try
/*      */     {
/* 1568 */       PreparedStatementOperator psOperator = new PreparedStatementOperator();
/*      */ 
/* 1570 */       List conditionList = conditions.getConditions();
/* 1571 */       if (conditions == null) {
/* 1572 */         return null;
/*      */       }
/*      */ 
/* 1575 */       StringBuffer selectHql = new StringBuffer();
/* 1576 */       StringBuffer fromHql = new StringBuffer();
/* 1577 */       StringBuffer whereHql = new StringBuffer();
/* 1578 */       StringBuffer orderHql = new StringBuffer();
/*      */ 
/* 1580 */       List params = new ArrayList();
/*      */       String alias;
/* 1582 */       for (int i = 0; i < conditionList.size(); i++) {
/* 1583 */         Condition condition = (Condition)conditionList.get(i);
/*      */ 
/* 1585 */         alias = "dto" + (i + 1);
/* 1586 */         String select = condition.getSelectHql(alias);
/* 1587 */         where = condition.getWhereHql(alias, params);
/* 1588 */         String order = condition.getOrderHql(alias);
/*      */ 
/* 1590 */         if ((select != null) && (!select.equals(""))) {
/* 1591 */           if (selectHql.length() != 0) {
/* 1592 */             selectHql.append(", ");
/*      */           }
/*      */ 
/* 1595 */           selectHql.append(select);
/*      */         }
/*      */ 
/* 1598 */         if (fromHql.length() != 0) {
/* 1599 */           fromHql.append(", ");
/*      */         }
/*      */ 
/* 1602 */         fromHql.append(condition.getDTOName()).append(" dto").append(i + 1);
/*      */ 
/* 1604 */         whereHql.append(where);
/*      */ 
/* 1606 */         if ((order != null) && (!order.equals(""))) {
/* 1607 */           if (orderHql.length() != 0) {
/* 1608 */             orderHql.append(", ");
/*      */           }
/*      */ 
/* 1611 */           orderHql.append(order);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1616 */       selectHql.insert(0, "select ");
/* 1617 */       fromHql.insert(0, " from ");
/* 1618 */       whereHql.insert(0, " where 1 = 1");
/*      */ 
/* 1620 */       List expression = conditions.getExpression();
/* 1621 */       for (String exp : expression) {
/* 1622 */         whereHql.append(" and ").append(exp);
/*      */       }
/*      */ 
/* 1625 */       if (orderHql.length() != 0) {
/* 1626 */         orderHql.insert(0, " order by ");
/*      */       }
/*      */ 
/* 1629 */       String hql = selectHql.toString() + fromHql.toString() + 
/* 1630 */         whereHql.toString() + orderHql.toString();
/*      */ 
/* 1632 */       Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + hql);
/*      */ 
/* 1634 */       StringBuffer sSelect = new StringBuffer();
/* 1635 */       sSelect.append("SELECT * FROM (SELECT T.*, ROWNUM RN FROM (").append(hql).append(") T WHERE RN >= ").append(pages.getFirstIndex()).append(" AND RN <= ").append(pages.getLastIndex());
/* 1636 */       params.addAll(conditions.getExpParam());
/* 1637 */       psOperator.setSql(hql);
/*      */ 
/* 1639 */       for (String where = params.iterator(); where.hasNext(); ) { Object param = where.next();
/* 1640 */         if ((param instanceof Integer))
/* 1641 */           psOperator.addParameter(DBOperator.NUMBER, param);
/* 1642 */         else if ((param instanceof Long))
/* 1643 */           psOperator.addParameter(DBOperator.LONGNUMBER, param);
/* 1644 */         else if ((param instanceof Double))
/* 1645 */           psOperator.addParameter(DBOperator.DOUBLENUMBER, param);
/* 1646 */         else if ((param instanceof Date))
/* 1647 */           psOperator.addParameter(DBOperator.DATE, param);
/* 1648 */         else if ((param instanceof String)) {
/* 1649 */           psOperator.addParameter(DBOperator.VARCHAR2, param);
/*      */         }
/*      */ 
/* 1652 */         Debug.debugMessage("add param === " + param);
/*      */       }
/*      */ 

/* 1656 */       return this.dbOperator.executeSelect(psOperator);
/*      */     } catch (Exception ex) {
/* 1658 */       ErrorProcessor.prompt(getClass().getName(), "queryInfoList() error!", ex);
/* 1659 */     }throw new SystemException(ex.getMessage());
/*      */   }
/*      */ 
/*      */   protected List getArrayList(SelectResultSet result)
/*      */   {
/* 1664 */     List lResult = new ArrayList();
/* 1665 */     for (int i = 0; i < result.getRowCount(); i++) {
/* 1666 */       Object[] object = new Object[result.getColumnCount()];
/*      */ 
/* 1668 */       for (int j = 0; j < result.getColumnCount(); j++) {
/* 1669 */         Object value = result.getObjectValue(j, i);
/*      */ 
/* 1671 */         if (value != null) {
/* 1672 */           object[j] = value;
/*      */         }
/*      */       }
/*      */ 
/* 1676 */       lResult.add(object);
/*      */     }
/*      */ 
/* 1679 */     return lResult;
/*      */   }
/*      */ 
/*      */   protected List getDTO(SelectResultSet result) {
/* 1683 */     List lResult = new ArrayList();
/*      */ 
/* 1685 */     for (int i = 0; i < result.getRowCount(); i++) {
/* 1686 */       DTO dto = new DTO();
/*      */ 
/* 1688 */       for (int j = 0; j < result.getColumnCount(); j++) {
/* 1689 */         String type = result.getColumnTypeName(j);
/* 1690 */         String name = result.getColumnName(j).replaceAll("\\_", "");
/* 1691 */         if (result.getObjectValue(j, i) != null) {
/* 1692 */           if (type.equals("VARCHAR2"))
/* 1693 */             dto.setString(name, result.getStringValue(j, i));
/* 1694 */           else if (type.equals("NUMBER"))
/* 1695 */             dto.setNumber(name, (BigDecimal)result.getObjectValue(j, i));
/* 1696 */           else if (type.equals("INTEGER"))
/* 1697 */             dto.setDouble(name, Double.valueOf(result.getDoubleValue(j, i)));
/* 1698 */           else if (type.equals("LONG"))
/* 1699 */             dto.setDouble(name, Double.valueOf(result.getDoubleValue(j, i)));
/* 1700 */           else if (type.equals("DOUBLE"))
/* 1701 */             dto.setDouble(name, Double.valueOf(result.getDoubleValue(j, i)));
/* 1702 */           else if (type.equals("DATE"))
/* 1703 */             dto.setDate(name, result.getUtilDateValue(j, i));
/* 1704 */           else if (type.equals("BLOB"))
/* 1705 */             dto.put(name, result.getBlobValue(j, i));
/* 1706 */           else if (type.equals("CLOB"))
/* 1707 */             dto.put(name, result.getClobValue(j, i));
/*      */           else {
/* 1709 */             dto.put(name, result.getObjectValue(j, i));
/*      */           }
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/* 1715 */       lResult.add(dto);
/*      */     }
/*      */ 
/* 1718 */     return lResult;
/*      */   }
/*      */ 
/*      */   protected List getDTOList(SelectResultSet result, Class dtoclass) throws Exception {
/* 1722 */     List lResult = new ArrayList();
/* 1723 */     ClassMapping cmMap = (ClassMapping)RegisterObject.DTOInfo.get(dtoclass.getName());
/* 1724 */     for (int i = 0; i < result.getRowCount(); i++) {
/* 1725 */       BaseDTO dto = (BaseDTO)dtoclass.newInstance();
/*      */ 
/* 1727 */       for (int j = 0; j < result.getColumnCount(); j++) {
/* 1728 */         String columnname = result.getColumnName(j).replaceAll("\\_", "");
/* 1729 */         Object value = result.getObjectValue(j, i);
/*      */ 
/* 1731 */         if (value != null) {
/* 1732 */           for (PropertyMapping id : cmMap.getId()) {
/* 1733 */             if (id.getColumnName().equalsIgnoreCase(columnname)) {
/* 1734 */               dto.setPropertyValue(id.getName(), value);
/*      */             }
/*      */           }
/*      */ 
/* 1738 */           for (PropertyMapping prop : cmMap.getListProperty()) {
/* 1739 */             if (prop.getColumnName().equalsIgnoreCase(columnname)) {
/* 1740 */               dto.setPropertyValue(prop.getName(), value);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/* 1746 */       lResult.add(dto);
/*      */     }
/* 1748 */     return lResult;
/*      */   }
/*      */ 
/*      */   protected SelectResultSet queryResultSetBySql(String sql) throws Exception {
/* 1752 */     return queryResultSetBySql(sql, null, null);
/*      */   }
/*      */ 
/*      */   protected SelectResultSet queryResultSetBySql(String sql, List<Object> params, List<Integer> types) throws Exception {
/* 1756 */     Debug.debugMessage("connecttion : " + this.dbOperator.getConnection());
/* 1757 */     if (this.dbOperator.getConnection() == null) {
/* 1758 */       throw new Exception("connection is null");
/*      */     }
/*      */ 
/* 1761 */     Debug.debugMessage(0, this.request.getResponseSystemName(), this.request.getResponseSubsystemName(), this.request.getResponseServiceName(), "sql ====== " + sql);
/*      */ 
/* 1763 */     PreparedStatementOperator pso = new PreparedStatementOperator(sql);
/*      */ 
/* 1765 */     if ((params != null) && (types != null)) {
/* 1766 */       for (int i = 0; i < params.size(); i++) {
/* 1767 */         Object param = params.get(i);
/* 1768 */         Integer type = (Integer)types.get(i);
/* 1769 */         pso.addParameter(i, type.intValue(), param);
/*      */ 
/* 1771 */         Debug.debugMessage("add parameter : param = " + param + " type = " + type);
/*      */       }
/*      */     }
/*      */ 
/* 1775 */     return this.dbOperator.executeSelect(pso);
/*      */   }
/*      */ 
/*      */   private int getInputStreamLength(InputStream is) throws Exception {
/* 1779 */     byte[] buf = new byte[1024];
/* 1780 */     int length = 0;
/* 1781 */     int len = 0;
/* 1782 */     while ((len = is.read(buf)) > 0) {
/* 1783 */       if (len > 0) {
/* 1784 */         length += len;
/*      */       }
/*      */     }
/*      */ 
/* 1788 */     return length;
/*      */   }
/*      */ 
/*      */   public DBOperator getDbOperator() {
/* 1792 */     return this.dbOperator;
/*      */   }
/*      */ 
/*      */   public void setDbOperator(DBOperator dbOperator) {
/* 1796 */     this.dbOperator = dbOperator;
/*      */   }
/*      */ 
/*      */   public HttpSession getSession() {
/* 1800 */     return this.session;
/*      */   }
/*      */ 
/*      */   public void setSession(HttpSession session) {
/* 1804 */     this.session = session;
/*      */   }
/*      */ 
/*      */   public Request getRequest() {
/* 1808 */     return this.request;
/*      */   }
/*      */ 
/*      */   public void setRequest(Request request) {
/* 1812 */     this.request = request;
/*      */   }
/*      */ 
/*      */   public LoginInfo getLoginInfo() {
/* 1816 */     return this.loginInfo;
/*      */   }
/*      */ 
/*      */   public void setLoginInfo(LoginInfo loginInfo) {
/* 1820 */     this.loginInfo = loginInfo;
/*      */   }
/*      */ 
/*      */   public List<DBOperator> getDbOperatorList() {
/* 1824 */     return this.dbOperatorList;
/*      */   }
/*      */ 
/*      */   public void setDbOperatorList(List<DBOperator> dbOperatorList) {
/* 1828 */     this.dbOperatorList = dbOperatorList;
/*      */   }
/*      */ }

/* Location:           E:\workspace\navy\src\海军\WebRoot\WEB-INF\lib\HDCube.jar
 * Qualified Name:     cn.com.hd.service.BaseService
 * JD-Core Version:    0.6.0
 */