--------------------------------------------
-- Export file for user NAVYSYS           --
-- Created by zuow on 2013/3/18, 13:48:17 --
--------------------------------------------

spool navy_navy_all.log

prompt
prompt Creating table T_AFTERSALE_ORG
prompt ==============================
prompt
create table NAVYSYS.T_AFTERSALE_ORG
(
  ORG_ID      VARCHAR2(36) not null,
  SUP_ID      VARCHAR2(36),
  ORG_NAME    VARCHAR2(200),
  ORG_TYPE    VARCHAR2(100),
  LOCATION    VARCHAR2(500),
  DIRECTOR    VARCHAR2(100),
  PHONE       VARCHAR2(100),
  ORG_TYPE_ID VARCHAR2(36)
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_AFTERSALE_ORG
  is '供应商售后服务机构信息表';
comment on column NAVYSYS.T_AFTERSALE_ORG.ORG_ID
  is '售后机构ID';
comment on column NAVYSYS.T_AFTERSALE_ORG.SUP_ID
  is '供应商ID';
comment on column NAVYSYS.T_AFTERSALE_ORG.ORG_NAME
  is '售后机构名称';
comment on column NAVYSYS.T_AFTERSALE_ORG.ORG_TYPE
  is '售后机构类别';
comment on column NAVYSYS.T_AFTERSALE_ORG.LOCATION
  is '售后机构所在市县';
comment on column NAVYSYS.T_AFTERSALE_ORG.DIRECTOR
  is '负责人';
comment on column NAVYSYS.T_AFTERSALE_ORG.PHONE
  is '联系电话';
comment on column NAVYSYS.T_AFTERSALE_ORG.ORG_TYPE_ID
  is '售后机构类别编号';
alter table NAVYSYS.T_AFTERSALE_ORG
  add constraint PK_T_AFTERSALE_ORG primary key (ORG_ID)
  using index 
  tablespace NAVY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_HIGHWAY
prompt ========================
prompt
create table NAVYSYS.T_HIGHWAY
(
  COM_ID    VARCHAR2(36) not null,
  HIW_ID    VARCHAR2(32),
  HIW_NAME  VARCHAR2(64),
  HIW_IN    VARCHAR2(64),
  HIW_IN_ID VARCHAR2(32),
  HIW_DIS   NUMBER(10,2)
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_HIGHWAY
  is '高速公路信息表';
comment on column NAVYSYS.T_HIGHWAY.COM_ID
  is '运输服务企业ID';
comment on column NAVYSYS.T_HIGHWAY.HIW_ID
  is '高速公路编号';
comment on column NAVYSYS.T_HIGHWAY.HIW_NAME
  is '高速公路名称';
comment on column NAVYSYS.T_HIGHWAY.HIW_IN
  is '高速公路入口名称';
comment on column NAVYSYS.T_HIGHWAY.HIW_IN_ID
  is '高速公路入口编号';
comment on column NAVYSYS.T_HIGHWAY.HIW_DIS
  is '距离';
alter table NAVYSYS.T_HIGHWAY
  add constraint PK_T_HIGHWAY primary key (COM_ID)
  using index 
  tablespace NAVY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_IMAGE
prompt ======================
prompt
create table NAVYSYS.T_IMAGE
(
  IMAGE_ID      VARCHAR2(50) not null,
  IMPORT_ID     VARCHAR2(50),
  IMAGE_TYPE_ID VARCHAR2(50),
  IMAGE_TYPE    VARCHAR2(50) not null,
  IMAGE_NAME    VARCHAR2(100),
  IMAGE_DESC    VARCHAR2(50),
  IMAGE_PATH    VARCHAR2(255),
  IMAGE_ORDER   NUMBER,
  IMAGE         BLOB,
  EXPINFOA      VARCHAR2(1000),
  EXPINFOB      VARCHAR2(1000),
  EXPINFOC      VARCHAR2(1000),
  EXPINFOD      VARCHAR2(1000),
  EXPINFOE      VARCHAR2(1000)
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_IMAGE
  is '海军物资图片信息表';
comment on column NAVYSYS.T_IMAGE.IMAGE_ID
  is '图片ID';
comment on column NAVYSYS.T_IMAGE.IMPORT_ID
  is '物资ID';
comment on column NAVYSYS.T_IMAGE.IMAGE_TYPE_ID
  is '图片类型ID';
comment on column NAVYSYS.T_IMAGE.IMAGE_TYPE
  is '图片类型';
comment on column NAVYSYS.T_IMAGE.IMAGE_NAME
  is '图片名称';
comment on column NAVYSYS.T_IMAGE.IMAGE_DESC
  is '图片描述';
comment on column NAVYSYS.T_IMAGE.IMAGE_PATH
  is '图片路径';
comment on column NAVYSYS.T_IMAGE.IMAGE
  is '图片内容';
comment on column NAVYSYS.T_IMAGE.EXPINFOA
  is '扩展信息A';
comment on column NAVYSYS.T_IMAGE.EXPINFOB
  is '扩展信息B';
comment on column NAVYSYS.T_IMAGE.EXPINFOC
  is '扩展信息C';
comment on column NAVYSYS.T_IMAGE.EXPINFOD
  is '扩展信息D';
comment on column NAVYSYS.T_IMAGE.EXPINFOE
  is '扩展信息E';
alter table NAVYSYS.T_IMAGE
  add constraint PK_T_IMAGE primary key (IMAGE_ID)
  using index 
  tablespace NAVY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_IMPORT
prompt =======================
prompt
create table NAVYSYS.T_IMPORT
(
  IMPORTID        VARCHAR2(36) not null,
  TYPE_CODE       VARCHAR2(36),
  TYPE_NAME       VARCHAR2(100),
  IMPORT_YEAR     VARCHAR2(4),
  PLAN_ID         VARCHAR2(36),
  PLAN            VARCHAR2(100),
  PLAN_DATE       DATE,
  COMPACT_ID      VARCHAR2(36),
  COMPACT         VARCHAR2(100),
  COMPACT_DATE    DATE,
  UNIT_ID         VARCHAR2(36),
  UNIT            VARCHAR2(100),
  DEPT_ID         VARCHAR2(36),
  DEPT            VARCHAR2(100),
  CLASS_ID        VARCHAR2(36),
  CLASS_NAME      VARCHAR2(100),
  PROJECT         VARCHAR2(200),
  BUDGET          NUMBER(8,2),
  COMPACT_MONEY   NUMBER(8,2),
  CURRENCY_ID     VARCHAR2(36),
  CURRENCY        VARCHAR2(100),
  RATE            NUMBER(5,2),
  RMB_RATE        NUMBER(5,2),
  DOLLAR          NUMBER(8,2),
  RMB             NUMBER(8,2),
  ECONOMIZE       NUMBER(8,2),
  MODE_ID         VARCHAR2(36),
  MODE_NAME       VARCHAR2(100),
  DELIVERY_DATE   DATE,
  AGENT_ID        VARCHAR2(36),
  AGENT           VARCHAR2(200),
  AGREE_ID        VARCHAR2(36),
  AGREE           VARCHAR2(100),
  PRODUCTOR       VARCHAR2(200),
  SUPPORTOR_ID    VARCHAR2(36),
  SUPPORTOR       VARCHAR2(100),
  SUPPORTOR_ADDR  VARCHAR2(200),
  EXAMINE_ID      VARCHAR2(36),
  EXAMINE_NO      VARCHAR2(100),
  IMPORT_CLASS_ID VARCHAR2(36),
  IMPORT_CLASS    VARCHAR2(100),
  DIRECTORY_ID    VARCHAR2(36),
  DIRECTORY       VARCHAR2(100),
  STORE_ADDR      VARCHAR2(1000),
  USE_DATE        DATE,
  USE_UNIT        VARCHAR2(200),
  USE_STATE       VARCHAR2(36),
  IMAGE           VARCHAR2(36),
  PASS_DATE       DATE,
  STORE_TYPE      VARCHAR2(36)
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_IMPORT
  is '海军战备储备物资表';
comment on column NAVYSYS.T_IMPORT.IMPORTID
  is 'ID';
comment on column NAVYSYS.T_IMPORT.TYPE_CODE
  is '计划类别代码';
comment on column NAVYSYS.T_IMPORT.TYPE_NAME
  is '计划类别';
comment on column NAVYSYS.T_IMPORT.IMPORT_YEAR
  is '战略储备计划年度';
comment on column NAVYSYS.T_IMPORT.PLAN_ID
  is '采购计划ID';
comment on column NAVYSYS.T_IMPORT.PLAN
  is '采购计划';
comment on column NAVYSYS.T_IMPORT.PLAN_DATE
  is '计划下达时间';
comment on column NAVYSYS.T_IMPORT.COMPACT_ID
  is '采购合同';
comment on column NAVYSYS.T_IMPORT.COMPACT
  is '采购合同';
comment on column NAVYSYS.T_IMPORT.COMPACT_DATE
  is '合同签订时间';
comment on column NAVYSYS.T_IMPORT.UNIT_ID
  is '采购机构ID';
comment on column NAVYSYS.T_IMPORT.UNIT
  is '采购机构';
comment on column NAVYSYS.T_IMPORT.DEPT_ID
  is '事业部门ID';
comment on column NAVYSYS.T_IMPORT.DEPT
  is '事业部门';
comment on column NAVYSYS.T_IMPORT.CLASS_ID
  is '专业类别ID';
comment on column NAVYSYS.T_IMPORT.CLASS_NAME
  is '专业类别';
comment on column NAVYSYS.T_IMPORT.PROJECT
  is '采购项目';
comment on column NAVYSYS.T_IMPORT.BUDGET
  is '预算金额(万元)';
comment on column NAVYSYS.T_IMPORT.COMPACT_MONEY
  is '合同金额(万元)';
comment on column NAVYSYS.T_IMPORT.CURRENCY_ID
  is '币种ID';
comment on column NAVYSYS.T_IMPORT.CURRENCY
  is '币种';
comment on column NAVYSYS.T_IMPORT.RATE
  is '汇率';
comment on column NAVYSYS.T_IMPORT.DOLLAR
  is '折合美元';
comment on column NAVYSYS.T_IMPORT.RMB
  is '折合人民币';
comment on column NAVYSYS.T_IMPORT.ECONOMIZE
  is '节省资金';
comment on column NAVYSYS.T_IMPORT.MODE_ID
  is '采购方式ID';
comment on column NAVYSYS.T_IMPORT.MODE_NAME
  is '采购方式';
comment on column NAVYSYS.T_IMPORT.DELIVERY_DATE
  is '交货日期';
comment on column NAVYSYS.T_IMPORT.AGENT_ID
  is '委托代理公司ID';
comment on column NAVYSYS.T_IMPORT.AGENT
  is '委托代理公司';
comment on column NAVYSYS.T_IMPORT.AGREE_ID
  is '代理协议ID';
comment on column NAVYSYS.T_IMPORT.AGREE
  is '代理协议';
comment on column NAVYSYS.T_IMPORT.PRODUCTOR
  is '设备生产厂家';
comment on column NAVYSYS.T_IMPORT.SUPPORTOR_ID
  is '供应商ID';
comment on column NAVYSYS.T_IMPORT.SUPPORTOR
  is '供应商';
comment on column NAVYSYS.T_IMPORT.SUPPORTOR_ADDR
  is '供应商注册地点';
comment on column NAVYSYS.T_IMPORT.EXAMINE_ID
  is '二级归口审批文件ID';
comment on column NAVYSYS.T_IMPORT.EXAMINE_NO
  is '二级归口审批编号';
comment on column NAVYSYS.T_IMPORT.IMPORT_CLASS_ID
  is '进口类别ID';
comment on column NAVYSYS.T_IMPORT.IMPORT_CLASS
  is '进口类别';
comment on column NAVYSYS.T_IMPORT.DIRECTORY_ID
  is '免税目录ID';
comment on column NAVYSYS.T_IMPORT.DIRECTORY
  is '免税目录';
comment on column NAVYSYS.T_IMPORT.STORE_ADDR
  is '储备地点';
comment on column NAVYSYS.T_IMPORT.USE_DATE
  is '调用时间';
comment on column NAVYSYS.T_IMPORT.USE_UNIT
  is '调用单位';
comment on column NAVYSYS.T_IMPORT.USE_STATE
  is '使用情况ID';
comment on column NAVYSYS.T_IMPORT.IMAGE
  is '装备图片ID';
alter table NAVYSYS.T_IMPORT
  add constraint PK_T_IMPORT primary key (IMPORTID)
  using index 
  tablespace NAVY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_PROVE_INFO
prompt ===========================
prompt
create table NAVYSYS.T_PROVE_INFO
(
  SUP_ID     VARCHAR2(36) not null,
  PROVE_NAME VARCHAR2(200),
  IMAGE_ID   VARCHAR2(50)
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_PROVE_INFO
  is '资质证书信息表';
comment on column NAVYSYS.T_PROVE_INFO.SUP_ID
  is '供应商ID';
comment on column NAVYSYS.T_PROVE_INFO.PROVE_NAME
  is '资质证书名称';
comment on column NAVYSYS.T_PROVE_INFO.IMAGE_ID
  is '资质证书扫描件ID';

prompt
prompt Creating table T_STOCKHOLDER
prompt ============================
prompt
create table NAVYSYS.T_STOCKHOLDER
(
  STOCKHOLDER_ID   VARCHAR2(36) not null,
  SUP_ID           VARCHAR2(36),
  STOCKHOLDER_NAME VARCHAR2(100),
  CAPITAL          NUMBER(8),
  RATIO            VARCHAR2(50),
  STOCK_DATE       DATE
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_STOCKHOLDER
  is '供应商股东信息表';
comment on column NAVYSYS.T_STOCKHOLDER.STOCKHOLDER_ID
  is '股东ID';
comment on column NAVYSYS.T_STOCKHOLDER.SUP_ID
  is '供应商ID';
comment on column NAVYSYS.T_STOCKHOLDER.STOCKHOLDER_NAME
  is '供应商名称';
comment on column NAVYSYS.T_STOCKHOLDER.CAPITAL
  is '出资金额';
comment on column NAVYSYS.T_STOCKHOLDER.RATIO
  is '出资比例';
comment on column NAVYSYS.T_STOCKHOLDER.STOCK_DATE
  is '出资时间';
alter table NAVYSYS.T_STOCKHOLDER
  add constraint PK_T_STOCKHOLDER primary key (STOCKHOLDER_ID)
  using index 
  tablespace NAVY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SUPPORTOR
prompt ==========================
prompt
create table NAVYSYS.T_SUPPORTOR
(
  SUP_ID                   VARCHAR2(36) not null,
  SUP_NAME                 VARCHAR2(200),
  SUP_EN_NAME              VARCHAR2(200),
  CREATE_DATE              DATE,
  ABBREVIATION             VARCHAR2(20),
  ADDRESS                  VARCHAR2(200),
  POSTCODE                 VARCHAR2(20),
  NET_ADDR                 VARCHAR2(255),
  ORGANIZE_CODE            VARCHAR2(100),
  ECONOMY                  VARCHAR2(200),
  TYPE_CODE                VARCHAR2(36),
  TYPE                     VARCHAR2(100),
  BANK_ID                  VARCHAR2(36),
  BANK                     VARCHAR2(100),
  ACCOUNT                  VARCHAR2(100),
  CREDIT_ID                VARCHAR2(36),
  CREDIT                   VARCHAR2(100),
  CREDIT_ORG               VARCHAR2(100),
  CREDIT_DATE              DATE,
  INSURANCE                VARCHAR2(20),
  ILLEGAL                  VARCHAR2(20),
  CORPORATION              VARCHAR2(100),
  CORP_PHONE               VARCHAR2(100),
  CORP_MOBILE              VARCHAR2(100),
  CONTACT                  VARCHAR2(100),
  CONTACT_PHONE            VARCHAR2(100),
  CONTACT_MOBILE           VARCHAR2(100),
  CONTACT_FAX              VARCHAR2(100),
  CONTACT_EMAIL            VARCHAR2(100),
  LIC_NO                   VARCHAR2(100),
  LIC_ORG                  VARCHAR2(100),
  LIC_CAPITAL              NUMBER(8,3),
  LIC_ADDR                 VARCHAR2(100),
  LIC_VAL_START            DATE,
  LIC_VAL_END              DATE,
  LIC_EXA_DATE             DATE,
  LIC_MAIN_OPT             VARCHAR2(2000),
  LIC_OTHER_OPT            VARCHAR2(2000),
  STATE_TAX_NO             VARCHAR2(100),
  LOCAL_TAX_NO             VARCHAR2(100),
  STATE_TAX_ORG            VARCHAR2(200),
  LOCAL_TAX_ORG            VARCHAR2(200),
  STATE_TAX_VAL_START      DATE,
  STATE_TAX_VAL_END        DATE,
  LOCAL_TAX_VAL_START      DATE,
  LOCAL_TAX_VAL_END        DATE,
  IF_STATE_TAX             VARCHAR2(20),
  IF_LOCAL_TAX             VARCHAR2(20),
  SUP_TYPE_CODE            VARCHAR2(10),
  SUP_TYPE                 VARCHAR2(200),
  SUMMARY                  VARCHAR2(2000),
  IMAGE                    VARCHAR2(36),
  LOCATION                 VARCHAR2(1000),
  LONGITUDE                VARCHAR2(50),
  LATITUDE                 VARCHAR2(50),
  PRODUCTS_CLASS           VARCHAR2(1000),
  MANUFACTURER_CONTACT     VARCHAR2(100),
  MANUFACTURER_FAX         VARCHAR2(100),
  MANUFACTURER_EMAIL       VARCHAR2(200),
  MANUFACTURER_ADDRESS     VARCHAR2(1000),
  MANUFACTURER_PERFORMANCE VARCHAR2(2000),
  MANUFACTURER_SUMMARY     VARCHAR2(2000),
  MANUFACTURER             VARCHAR2(200),
  STOREHOUSE_AREA          NUMBER(8,2),
  WAREHOUSE_AREA           NUMBER(8,2),
  STOREHOUSE_IMAGE         VARCHAR2(50),
  AUDIT_LAST3Y             VARCHAR2(200),
  LIC_BUS_IMAGE            VARCHAR2(50),
  ORG_STR_IMAGE            VARCHAR2(50),
  PURCHASE_TYPE            VARCHAR2(100),
  IF_TURNOVER              VARCHAR2(20),
  L1_LOC                   VARCHAR2(30),
  L2_LOC                   VARCHAR2(30),
  BANK_PROVE               VARCHAR2(200),
  OTHER_PROVE              VARCHAR2(200),
  QUALITY_PROVE            VARCHAR2(200),
  ECONOMY_ID               VARCHAR2(36),
  PURCHASE_TYPE_ID         VARCHAR2(36)
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_SUPPORTOR
  is '供应商信息表';
comment on column NAVYSYS.T_SUPPORTOR.SUP_ID
  is '供应商ID';
comment on column NAVYSYS.T_SUPPORTOR.SUP_NAME
  is '供应商名称';
comment on column NAVYSYS.T_SUPPORTOR.SUP_EN_NAME
  is '供应商英文名称';
comment on column NAVYSYS.T_SUPPORTOR.CREATE_DATE
  is '成立时间';
comment on column NAVYSYS.T_SUPPORTOR.ABBREVIATION
  is '简称';
comment on column NAVYSYS.T_SUPPORTOR.ADDRESS
  is '注册地址';
comment on column NAVYSYS.T_SUPPORTOR.POSTCODE
  is '邮政编码';
comment on column NAVYSYS.T_SUPPORTOR.NET_ADDR
  is '网址';
comment on column NAVYSYS.T_SUPPORTOR.ORGANIZE_CODE
  is '组织机构代码';
comment on column NAVYSYS.T_SUPPORTOR.ECONOMY
  is '经济性质';
comment on column NAVYSYS.T_SUPPORTOR.TYPE_CODE
  is '供应商类型代码';
comment on column NAVYSYS.T_SUPPORTOR.TYPE
  is '供应商类型';
comment on column NAVYSYS.T_SUPPORTOR.BANK_ID
  is '开户银行ID';
comment on column NAVYSYS.T_SUPPORTOR.BANK
  is '开户银行';
comment on column NAVYSYS.T_SUPPORTOR.ACCOUNT
  is '银行帐号';
comment on column NAVYSYS.T_SUPPORTOR.CREDIT
  is 'AAA，AA，A，BBB，BB，B，CCC，CC，C，D';
comment on column NAVYSYS.T_SUPPORTOR.CREDIT_ORG
  is '信用等级评定机构';
comment on column NAVYSYS.T_SUPPORTOR.CREDIT_DATE
  is '评定时间';
comment on column NAVYSYS.T_SUPPORTOR.INSURANCE
  is '是否依法缴纳社会保险费';
comment on column NAVYSYS.T_SUPPORTOR.ILLEGAL
  is '近三年内有无重大违法记录';
comment on column NAVYSYS.T_SUPPORTOR.CORPORATION
  is '法定代表人';
comment on column NAVYSYS.T_SUPPORTOR.CORP_PHONE
  is '法人固话';
comment on column NAVYSYS.T_SUPPORTOR.CORP_MOBILE
  is '法人手机';
comment on column NAVYSYS.T_SUPPORTOR.CONTACT
  is '供应商注册登记联系人';
comment on column NAVYSYS.T_SUPPORTOR.CONTACT_PHONE
  is '联系人固话';
comment on column NAVYSYS.T_SUPPORTOR.CONTACT_MOBILE
  is '联系人手机';
comment on column NAVYSYS.T_SUPPORTOR.CONTACT_FAX
  is '联系人传真';
comment on column NAVYSYS.T_SUPPORTOR.CONTACT_EMAIL
  is '联系人电子邮件';
comment on column NAVYSYS.T_SUPPORTOR.LIC_NO
  is '执照注册号';
comment on column NAVYSYS.T_SUPPORTOR.LIC_ORG
  is '执照发证机关';
comment on column NAVYSYS.T_SUPPORTOR.LIC_CAPITAL
  is '执照注册资本金(万元)';
comment on column NAVYSYS.T_SUPPORTOR.LIC_ADDR
  is '执照注册所在地';
comment on column NAVYSYS.T_SUPPORTOR.LIC_VAL_START
  is '执照有效期开始';
comment on column NAVYSYS.T_SUPPORTOR.LIC_VAL_END
  is '执照有效期结束';
comment on column NAVYSYS.T_SUPPORTOR.LIC_EXA_DATE
  is '最近年检时间';
comment on column NAVYSYS.T_SUPPORTOR.LIC_MAIN_OPT
  is '主要经营范围';
comment on column NAVYSYS.T_SUPPORTOR.LIC_OTHER_OPT
  is '兼营范围';
comment on column NAVYSYS.T_SUPPORTOR.STATE_TAX_NO
  is '税务登记证号';
comment on column NAVYSYS.T_SUPPORTOR.LOCAL_TAX_NO
  is '地税登记证号';
comment on column NAVYSYS.T_SUPPORTOR.STATE_TAX_ORG
  is '国税发证机关';
comment on column NAVYSYS.T_SUPPORTOR.LOCAL_TAX_ORG
  is '地税发证机关';
comment on column NAVYSYS.T_SUPPORTOR.STATE_TAX_VAL_START
  is '国税有效期开始时间';
comment on column NAVYSYS.T_SUPPORTOR.STATE_TAX_VAL_END
  is '国税有效期结束时间';
comment on column NAVYSYS.T_SUPPORTOR.LOCAL_TAX_VAL_START
  is '地税有效期开始时间';
comment on column NAVYSYS.T_SUPPORTOR.LOCAL_TAX_VAL_END
  is '地税有效其结束时间';
comment on column NAVYSYS.T_SUPPORTOR.IF_STATE_TAX
  is '是否依法缴纳国税税收';
comment on column NAVYSYS.T_SUPPORTOR.IF_LOCAL_TAX
  is '是否依法缴纳地税税收';
comment on column NAVYSYS.T_SUPPORTOR.STOREHOUSE_AREA
  is '仓库总面积';
comment on column NAVYSYS.T_SUPPORTOR.WAREHOUSE_AREA
  is '货场总面积';
comment on column NAVYSYS.T_SUPPORTOR.STOREHOUSE_IMAGE
  is '仓库照片';
comment on column NAVYSYS.T_SUPPORTOR.AUDIT_LAST3Y
  is '近三年审计报告压缩文件(RAR或ZIP格式)';
comment on column NAVYSYS.T_SUPPORTOR.LIC_BUS_IMAGE
  is '营业执照扫描件';
comment on column NAVYSYS.T_SUPPORTOR.ORG_STR_IMAGE
  is '组织结构代码证扫描件';
comment on column NAVYSYS.T_SUPPORTOR.PURCHASE_TYPE
  is '采购方式';
comment on column NAVYSYS.T_SUPPORTOR.IF_TURNOVER
  is '是否成交';
comment on column NAVYSYS.T_SUPPORTOR.L1_LOC
  is '供应商所在省/地区';
comment on column NAVYSYS.T_SUPPORTOR.L2_LOC
  is '供应商所在市';
comment on column NAVYSYS.T_SUPPORTOR.BANK_PROVE
  is '银行资信证明扫描件';
comment on column NAVYSYS.T_SUPPORTOR.OTHER_PROVE
  is '其它资质证明压缩包文件';
comment on column NAVYSYS.T_SUPPORTOR.QUALITY_PROVE
  is '质量管理认证证书扫描件';
comment on column NAVYSYS.T_SUPPORTOR.ECONOMY_ID
  is '经济类型编号';
comment on column NAVYSYS.T_SUPPORTOR.PURCHASE_TYPE_ID
  is '采购方式编号';
alter table NAVYSYS.T_SUPPORTOR
  add constraint PK_T_SUPPORTOR primary key (SUP_ID)
  using index 
  tablespace NAVY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SUP_PRODUCT
prompt ============================
prompt
create table NAVYSYS.T_SUP_PRODUCT
(
  PROD_ID           VARCHAR2(36) not null,
  SUP_ID            VARCHAR2(36),
  GOOD_NAME         VARCHAR2(200),
  PROD_NAME         VARCHAR2(200),
  MEASUR_UNIT       VARCHAR2(100),
  PROD_NO           VARCHAR2(200),
  AVG_OUTPUT        NUMBER(10,2),
  MAX_OUTPUT        NUMBER(10,2),
  SINGLE_MAX_OUTPUT NUMBER(10,2),
  SINGLE_MAX_DATE   VARCHAR2(200),
  REMARK            VARCHAR2(1000),
  PROD_IMAGE        VARCHAR2(50),
  PROD_TYPE         VARCHAR2(100)
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_SUP_PRODUCT
  is '供应商物资信息表';
comment on column NAVYSYS.T_SUP_PRODUCT.PROD_ID
  is '供应物资编号';
comment on column NAVYSYS.T_SUP_PRODUCT.SUP_ID
  is '供应物资所属供应商ID';
comment on column NAVYSYS.T_SUP_PRODUCT.GOOD_NAME
  is '物资品名';
comment on column NAVYSYS.T_SUP_PRODUCT.PROD_NAME
  is '产品名称';
comment on column NAVYSYS.T_SUP_PRODUCT.MEASUR_UNIT
  is '物资计量单位';
comment on column NAVYSYS.T_SUP_PRODUCT.PROD_NO
  is '产品系列或型号';
comment on column NAVYSYS.T_SUP_PRODUCT.AVG_OUTPUT
  is '过去三年(2009～2011)平均年产量)';
comment on column NAVYSYS.T_SUP_PRODUCT.MAX_OUTPUT
  is '过去三年(2009～2011)最大年产量';
comment on column NAVYSYS.T_SUP_PRODUCT.SINGLE_MAX_OUTPUT
  is '单批最大产量';
comment on column NAVYSYS.T_SUP_PRODUCT.SINGLE_MAX_DATE
  is '完成单批最大产量所需时间(天)';
comment on column NAVYSYS.T_SUP_PRODUCT.REMARK
  is '备注';
comment on column NAVYSYS.T_SUP_PRODUCT.PROD_IMAGE
  is '产品照片编号';
comment on column NAVYSYS.T_SUP_PRODUCT.PROD_TYPE
  is '产品分类编号代码';
alter table NAVYSYS.T_SUP_PRODUCT
  add constraint PK_T_SUP_PRODUCT primary key (PROD_ID)
  using index 
  tablespace NAVY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_SUP_TRANS
prompt ==========================
prompt
create table NAVYSYS.T_SUP_TRANS
(
  SUP_ID VARCHAR2(36) not null,
  COM_ID VARCHAR2(36) not null
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_SUP_TRANS
  is '供应商运输信息表';
comment on column NAVYSYS.T_SUP_TRANS.SUP_ID
  is '供应商ID';
comment on column NAVYSYS.T_SUP_TRANS.COM_ID
  is '运输服务企业ID';
alter table NAVYSYS.T_SUP_TRANS
  add constraint PK_T_SUP_TRANS primary key (SUP_ID, COM_ID)
  using index 
  tablespace NAVY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table T_TRANSPORT
prompt ==========================
prompt
create table NAVYSYS.T_TRANSPORT
(
  COM_ID        VARCHAR2(36) not null,
  COM_NAME      VARCHAR2(64),
  TRUCK_TYPE    VARCHAR2(10),
  DEADWEIGHT    NUMBER(10,2),
  COUNT         NUMBER(38),
  NEAR_RAILWAY  VARCHAR2(32),
  RW_DIS        NUMBER(10,2),
  NEAR_PORT     VARCHAR2(32),
  PORT_DIS      NUMBER(10,2),
  NEAR_AIRPORT  VARCHAR2(32),
  AP_DIS        NUMBER(10,2),
  TRUCK_TYPE_ID VARCHAR2(36)
)
tablespace NAVY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on table NAVYSYS.T_TRANSPORT
  is '运输服务企业信息表';
comment on column NAVYSYS.T_TRANSPORT.COM_ID
  is '运输服务企业ID';
comment on column NAVYSYS.T_TRANSPORT.COM_NAME
  is '运输服务企业名称';
comment on column NAVYSYS.T_TRANSPORT.TRUCK_TYPE
  is '运输车种类';
comment on column NAVYSYS.T_TRANSPORT.DEADWEIGHT
  is '载重量';
comment on column NAVYSYS.T_TRANSPORT.COUNT
  is '运输车数量';
comment on column NAVYSYS.T_TRANSPORT.NEAR_RAILWAY
  is '最近铁路货运站名称';
comment on column NAVYSYS.T_TRANSPORT.RW_DIS
  is '铁路距离';
comment on column NAVYSYS.T_TRANSPORT.NEAR_PORT
  is '最近港口名称';
comment on column NAVYSYS.T_TRANSPORT.PORT_DIS
  is '水路距离';
comment on column NAVYSYS.T_TRANSPORT.NEAR_AIRPORT
  is '最近机场名称';
comment on column NAVYSYS.T_TRANSPORT.AP_DIS
  is '飞行距离';
comment on column NAVYSYS.T_TRANSPORT.TRUCK_TYPE_ID
  is '运输车类型编号';
alter table NAVYSYS.T_TRANSPORT
  add constraint PK_T_TRANSPORT primary key (COM_ID)
  using index 
  tablespace NAVY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating procedure INT_RANDOM
prompt =============================
prompt
CREATE OR REPLACE PROCEDURE NAVYSYS.INT_RANDOM (random in out integer) IS
  v_Exestr  VARCHAR2(32767);
begin
  v_Exestr := 'select trunc(dbms_random.value(1,' || random || ')) from dual';
  EXECUTE IMMEDIATE v_Exestr INTO random;
end INT_RANDOM;
/

prompt
prompt Creating procedure IMPORT_TEST_DATA
prompt ===================================
prompt
CREATE OR REPLACE PROCEDURE NAVYSYS.IMPORT_TEST_DATA  IS
  v_num      INTEGER := 2000;    -- 测试数据个数
  i        INTEGER;      -- 计数
  j        INTEGER;

  v_count      INTEGER;

  v_supid      varchar2(30);    -- 供应商编号
  v_supname    varchar2(30);    -- 供应商名称
  v_sup_type    varchar2(100);    -- 供应商类型
  v_type_code    varchar2(100);    -- 供应商类型编码
  v_sup_economy  varchar2(200);    -- 供应商经济性质
  v_sup_purchase  varchar2(100);    -- 供应商采购类型
  v_detail_record  dictsys.t_dict_detail%rowtype;    -- 数据字典中详情记录
  v_area_record  dictsys.t_dict_area%rowtype;        -- 数据字典中地区记录
  v_l1loc      varchar2(30);    -- 供应商所在省
  v_l2loc      varchar2(30);    -- 供应商所在市

  v_output       number;        -- 产品产量
  v_temp1    varchar2(200);    -- 产品名称
  v_temp2    varchar2(100);    -- 产品编号
  v_impid    varchar2(36);     -- 进口物资编号
BEGIN
  i:=1999;
  while i<v_num loop
    i:=i+1;
    v_supid := i;
    v_supname := 'sup_' || i;

    -- 供应商类型
    select * into v_detail_record from (select * from dictsys.t_dict_detail where type_id='11' order by dbms_random.value)
      where rownum = 1;
    v_type_code := v_detail_record.dict_code;
    v_sup_type := v_detail_record.dict_name;
    -- 经济性质
    select * into v_detail_record from (select * from dictsys.t_dict_detail where type_id='14' order by dbms_random.value)
      where rownum = 1;
    v_sup_economy := v_detail_record.dict_name;
    -- 采购类型
    select * into v_detail_record from (select * from dictsys.t_dict_detail where type_id='6' order by dbms_random.value)
      where rownum = 1;
    v_sup_purchase := v_detail_record.dict_name;

    -- 随机获取供应商所在地区
    select * into v_area_record from (select * from dictsys.t_dict_area where parent_codeid='0' order by dbms_random.value)
      where rownum = 1;
    v_l1loc := v_area_record.area_name;
    v_l2loc := v_area_record.area_code;
    select * into v_area_record from (select * from dictsys.t_dict_area where parent_codeid=v_l2loc order by dbms_random.value) where rownum = 1;
    v_l2loc := v_area_record.area_name;
    
    -- 注册资金
    j := 600;
    int_random(j);
    v_count := j;

    -- 插入供应商记录
    insert into t_supportor(SUP_ID, SUP_NAME, ECONOMY, TYPE_CODE, TYPE, PURCHASE_TYPE, L1_LOC, L2_LOC, LIC_CAPITAL)
      values(v_supid, v_supname, v_sup_economy, v_type_code, v_sup_type, v_sup_purchase, v_l1loc, v_l2loc, v_count);
    commit;

    -- 产品表
    -- 首先随机获取几个产品数据
    v_count := 5;
    j := 0;
    for Rec in (select * from (select * from dictsys.t_dict_detail where type_id='15'
          and have_child='N' order by dbms_random.value) where rownum<=v_count) loop
      j := j+1;

      v_temp1 := Rec.dict_name;
      v_temp2 := Rec.dict_code;
      v_output := 10000;
      INT_RANDOM(v_output);

      insert into t_sup_product(prod_id, sup_id, good_name, avg_output, prod_type)
        values('prod_' || i || '_' || j, v_supid, v_temp1, v_output, v_temp2);
      commit;
    end loop;

    -- 售后表
    v_count := 3;
    j := 0;
    for Rec in (select * from (select * from dictsys.t_dict_detail where type_id='17'
           order by dbms_random.value) where rownum<=3) loop
      j := j+1;
      v_temp1 := Rec.Dict_Name;
      v_temp2 := Rec.Dict_Code;
      insert into t_aftersale_org(org_id, sup_id, org_type, org_type_id)
             values('org_' || i || '_' || j, v_supid, v_temp1, v_temp2);
    end loop;

    -- 股东信息表
    j := 0;
    while j<=2 loop
      j := j+1;
      insert into t_stockholder(stockholder_id, sup_id, ratio)
             values('stock_' || i || '_' || j, v_supid, '50');
    end loop;

    -- 进口物资表
     v_impid := 'imp_' || i;
     insert into t_image(image_id, import_id, image_type_id, image_type, image_path, image_name)
            values('img_plan_' || i || '_' || j, v_impid, 'plan_' || i, 'plan', 'navy/import/plan_' || i || '.jpg', 'plan_' || i || '.jpg');
     insert into t_image(image_id, import_id, image_type_id, image_type, image_path, image_name)
            values('img_compact_' || i || '_' || j, v_impid, 'compact_' || i, 'compact', 'navy/import/compact_' || i  || '.jpg', 'compact_' || i  || '.jpg');
     insert into t_image(image_id, import_id, image_type_id, image_type, image_path, image_name)
            values('img_agree_' || i || '_' || j, v_impid, 'agree_' || i, 'agree', 'navy/import/agree_' || i ||  '.jpg', 'agree_' || i ||  '.jpg');
     insert into t_image(image_id, import_id, image_type_id, image_type, image_path, image_name)
            values('img_examine_' || i || '_' || j, v_impid, 'examine_' || i, 'examine', 'navy/import/examine_' || i  || '.jpg', 'examine_' || i  || '.jpg');
     insert into t_image(image_id, import_id, image_type_id, image_type, image_path, image_name)
            values('image_' || i || '_' || j, v_impid, 'image_' || i, 'image', 'navy/import/image_' || i || '.jpg', 'image_' || i || '.jpg');

     insert into t_import(importid, plan_id, compact_id, agent_id, examine_id, image, supportor_id, supportor)
            values(v_impid, 'plan_' || i, 'compact_' || i, 'agree_' || i, 'examine_' || i, 'image_' || i, v_supid, v_supname);

  END LOOP;
END IMPORT_TEST_DATA;
/

prompt
prompt Creating procedure TEST_DATA
prompt ============================
prompt
CREATE OR REPLACE PROCEDURE NAVYSYS.TEST_DATA  IS
  v_num      INTEGER := 100;    -- 测试数据个数
  i        INTEGER;      -- 计数
  j        INTEGER;

  v_count      INTEGER;

  v_supid      varchar2(30);    -- 供应商编号
  v_supname    varchar2(30);    -- 供应商名称
  v_sup_type    varchar2(100);    -- 供应商类型
  v_type_code    varchar2(100);    -- 供应商类型编码
  v_sup_economy  varchar2(200);    -- 供应商经济性质
  v_sup_purchase  varchar2(100);    -- 供应商采购类型
  v_detail_record  dictsys.t_dict_detail%rowtype;    -- 数据字典中详情记录
  v_area_record  dictsys.t_dict_area%rowtype;        -- 数据字典中地区记录
  v_l1loc      varchar2(30);    -- 供应商所在省
  v_l2loc      varchar2(30);    -- 供应商所在市

  v_output       number;        -- 产品产量
  v_prod_name    varchar2(200);    -- 产品名称
  v_prod_type    varchar2(100);    -- 产品编号

BEGIN
  i:=0;
  while i<v_num loop
    i:=i+1;
    v_supid := i;
    v_supname := 'sup_' || i;

    -- 供应商类型
    select * into v_detail_record from (select * from dictsys.t_dict_detail where type_id='11' order by dbms_random.value)
      where rownum = 1;
    v_type_code := v_detail_record.dict_code;
    v_sup_type := v_detail_record.dict_name;
    -- 经济性质
    select * into v_detail_record from (select * from dictsys.t_dict_detail where type_id='14' order by dbms_random.value)
      where rownum = 1;
    v_sup_economy := v_detail_record.dict_name;
    -- 采购类型
    select * into v_detail_record from (select * from dictsys.t_dict_detail where type_id='6' order by dbms_random.value)
      where rownum = 1;
    v_sup_purchase := v_detail_record.dict_name;

    -- 随机获取供应商所在地区
    select * into v_area_record from (select * from dictsys.t_dict_area where parent_codeid='0' order by dbms_random.value)
      where rownum = 1;
    v_l1loc := v_area_record.area_name;
    v_l2loc := v_area_record.area_code;
    select * into v_area_record from (select * from dictsys.t_dict_area where parent_codeid=v_l2loc order by dbms_random.value) where rownum = 1;
    v_l2loc := v_area_record.area_name;
    
    -- 注册资金
    j := 600;
    int_random(j);
    v_count := j;

    -- 插入供应商记录
    insert into t_supportor(SUP_ID, SUP_NAME, ECONOMY, TYPE_CODE, TYPE, PURCHASE_TYPE, L1_LOC, L2_LOC, LIC_CAPITAL)
      values(v_supid, v_supname, v_sup_economy, v_type_code, v_sup_type, v_sup_purchase, v_l1loc, v_l2loc, v_count);
    commit;

    -- 产品表
    -- 首先随机获取几个产品数据
    v_count := 5;
    j := 0;
    for Rec in (select * from (select * from dictsys.t_dict_detail where type_id='15'
          and have_child='N' order by dbms_random.value) where rownum<=v_count) loop
      j := j+1;

      v_prod_name := Rec.dict_name;
      v_prod_type := Rec.dict_code;
      v_output := 10000;
      INT_RANDOM(v_output);

      insert into t_sup_product(prod_id, sup_id, good_name, avg_output, prod_type)
        values('prod_' || i || '_' || j, v_supid, v_prod_name, v_output, v_prod_type);
      commit;
    end loop;
    
    -- 运输表
    v_count := 100;
    int_random(v_count);
    v_output := 50;
    int_random(v_output);
    insert into t_sup_trans(sup_id, com_id) 
           values(v_supid, 'com_' || i);
    insert into t_transport(com_id, deadweight, count) 
           values('com_' || i, v_count, v_output);
    
  END LOOP;
END TEST_DATA;
/

prompt
prompt Creating procedure clean_data
prompt =============================
prompt
CREATE OR REPLACE PROCEDURE NAVYSYS."clean_data" is
BEGIN
	DELETE FROM T_AFTERSALE_ORG;
	DELETE FROM T_HIGHWAY;
	DELETE FROM T_IMAGE;
	DELETE FROM T_IMPORT;
	DELETE FROM T_PROVE_INFO;
	DELETE FROM T_STOCKHOLDER;
	DELETE FROM T_SUPPORTOR;
	DELETE FROM T_SUP_PRODUCT;
	DELETE FROM T_SUP_TRANS;
	DELETE FROM T_TRANSPORT;
END clean_data;
/


spool off
