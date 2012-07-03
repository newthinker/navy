create table T_IMPORT  (
   IMPORTID             VARCHAR2(36)                    not null,
   TYPE_CODE            VARCHAR2(36),
   TYPE_NAME            VARCHAR2(100),
   IMPORT_YEAR          VARCHAR2(4),
   PLAN_ID              VARCHAR2(36),
   PLAN                 VARCHAR2(100),
   PLAN_DATE            DATE,
   COMPACT_ID           VARCHAR2(36),
   COMPACT              VARCHAR2(100),
   COMPACT_DATE         DATE,
   UNIT_ID              VARCHAR2(36),
   UNIT                 VARCHAR2(100),
   DEPT_ID              VARCHAR2(36),
   DEPT                 VARCHAR2(100),
   CLASS_ID             VARCHAR2(36),
   CLASS_NAME           VARCHAR2(100),
   PROJECT              VARCHAR2(200),
   BUDGET               DECIMAL(8, 2),
   COMPACT_MONEY        DECIMAL(8, 2),
   CURRENCY_ID          VARCHAR2(36),
   CURRENCY             VARCHAR2(100),
   RATE                 DECIMAL(5, 2),
   DOLLAR               DECIMAL(8, 2),
   RMB                  DECIMAL(8, 2),
   ECONOMIZE            DECIMAL(8, 2),
   MODE_ID              VARCHAR2(36),
   MODE_NAME            VARCHAR2(100),
   DELIVERY_DATE        DATE,
   AGENT_ID             VARCHAR2(36),
   AGENT                VARCHAR2(200),
   AGREE_ID             VARCHAR2(36),
   AGREE                VARCHAR2(100),
   PRODUCTOR            VARCHAR2(200),
   SUPPORTOR_ID         VARCHAR2(36),
   SUPPORTOR            VARCHAR2(100),
   SUPPORTOR_ADDR       VARCHAR2(200),
   EXAMINE_ID           VARCHAR2(36),
   EXAMINE_NO           VARCHAR2(100),
   IMPORT_CLASS_ID      VARCHAR2(36),
   IMPORT_CLASS         VARCHAR2(100),
   DIRECTORY_ID         VARCHAR2(36),
   DIRECTORY            VARCHAR2(100),
   STORE_ADDR           VARCHAR2(1000),
   USE_DATE             DATE,
   USE_UNIT             VARCHAR2(200),
   USE_STATE            VARCHAR2(36),
   IMAGE                VARCHAR2(36),
   constraint PK_T_IMPORT primary key (IMPORTID)
);

comment on table T_IMPORT is
'海军战备储备物资表';

comment on column T_IMPORT.IMPORTID is
'ID';

comment on column T_IMPORT.TYPE_CODE is
'计划类别代码';

comment on column T_IMPORT.TYPE_NAME is
'计划类别';

comment on column T_IMPORT.IMPORT_YEAR is
'战略储备计划年度';

comment on column T_IMPORT.PLAN_ID is
'采购计划ID';

comment on column T_IMPORT.PLAN is
'采购计划';

comment on column T_IMPORT.PLAN_DATE is
'计划下达时间';

comment on column T_IMPORT.COMPACT_ID is
'采购合同';

comment on column T_IMPORT.COMPACT is
'采购合同';

comment on column T_IMPORT.COMPACT_DATE is
'合同签订时间';

comment on column T_IMPORT.UNIT_ID is
'采购机构ID';

comment on column T_IMPORT.UNIT is
'采购机构';

comment on column T_IMPORT.DEPT is
'事业部门';

comment on column T_IMPORT.CLASS_ID is
'专业类别ID';

comment on column T_IMPORT.CLASS_NAME is
'专业类别';

comment on column T_IMPORT.PROJECT is
'采购项目';

comment on column T_IMPORT.BUDGET is
'预算金额(万元)';

comment on column T_IMPORT.COMPACT_MONEY is
'合同金额(万元)';

comment on column T_IMPORT.CURRENCY_ID is
'币种ID';

comment on column T_IMPORT.CURRENCY is
'币种';

comment on column T_IMPORT.RATE is
'汇率';

comment on column T_IMPORT.DOLLAR is
'折合美元';

comment on column T_IMPORT.RMB is
'折合人民币';

comment on column T_IMPORT.ECONOMIZE is
'节省资金';

comment on column T_IMPORT.MODE_ID is
'采购方式ID';

comment on column T_IMPORT.MODE_NAME is
'采购方式';

comment on column T_IMPORT.DELIVERY_DATE is
'交货日期';

comment on column T_IMPORT.AGENT_ID is
'委托代理公司ID';

comment on column T_IMPORT.AGENT is
'委托代理公司';

comment on column T_IMPORT.AGREE_ID is
'代理协议ID';

comment on column T_IMPORT.AGREE is
'代理协议';

comment on column T_IMPORT.PRODUCTOR is
'设备生产厂家';

comment on column T_IMPORT.SUPPORTOR_ID is
'供应商ID';

comment on column T_IMPORT.SUPPORTOR is
'供应商';

comment on column T_IMPORT.SUPPORTOR_ADDR is
'供应商注册地点';

comment on column T_IMPORT.EXAMINE_ID is
'二级归口审批文件ID';

comment on column T_IMPORT.EXAMINE_NO is
'二级归口审批编号';

comment on column T_IMPORT.IMPORT_CLASS_ID is
'进口类别ID';

comment on column T_IMPORT.IMPORT_CLASS is
'进口类别';

comment on column T_IMPORT.DIRECTORY_ID is
'免税目录ID';

comment on column T_IMPORT.DIRECTORY is
'免税目录';

comment on column T_IMPORT.STORE_ADDR is
'储备地点';

comment on column T_IMPORT.USE_DATE is
'调用时间';

comment on column T_IMPORT.USE_UNIT is
'调用单位';

comment on column T_IMPORT.USE_STATE is
'使用情况ID';

comment on column T_IMPORT.IMAGE is
'装备图片ID';

create table T_SUPPORTOR  (
   SUP_ID               VARCHAR(36)                     not null,
   SUP_NAME             VARCHAR(200),
   SUP_EN_NAME          VARCHAR(200),
   CREATE_DATE          DATE,
   ABBREVIATION         VARCHAR2(20),
   ADDRESS              VARCHAR2(200),
   POSTCODE             VARCHAR2(20),
   NET_ADDR             VARCHAR2(255),
   ORGANIZE_CODE        VARCHAR2(100),
   ECONOMY              VARCHAR2(200),
   TYPE_CODE            VARCHAR2(36),
   TYPE                 VARCHAR2(100),
   BANK_ID              VARCHAR2(36),
   BANK                 VARCHAR2(100),
   ACCOUNT              VARCHAR2(100),
   CREDIT_ID            VARCHAR2(36),
   CREDIT               VARCHAR2(100),
   CREDIT_ORG           VARCHAR2(100),
   CREDIT_DATE          DATE,
   INSURANCE            VARCHAR2(20),
   ILLEGAL              VARCHAR2(20),
   CORPORATION          VARCHAR2(100),
   CORP_PHONE           VARCHAR2(100),
   CORP_MOBILE          VARCHAR2(100),
   CONTACT              VARCHAR2(100),
   CONTACT_PHONE        VARCHAR2(100),
   CONTACT_MOBILE       VARCHAR2(100),
   CONTACT_FAX          VARCHAR2(100),
   CONTACT_EMAIL        VARCHAR2(100),
   LIC_NO               VARCHAR2(100),
   LIC_ORG              VARCHAR2(100),
   LIC_CAPITAL          DECIMAL(8, 3),
   LIC_ADDR             VARCHAR2(100),
   LIC_VAL_START        DATE,
   LIC_VAL_END          DATE,
   LIC_EXA_DATE         DATE,
   LIC_MAIN_OPT         VARCHAR2(200),
   LIC_OTHER_OPT        VARCHAR2(200),
   STATE_TAX_NO         VARCHAR2(100),
   LOCAL_TAX_NO         VARCHAR2(100),
   STATE_TAX_ORG        VARCHAR2(200),
   LOCAL_TAX_ORG        VARCHAR2(200),
   STATE_TAX_VAL_START  DATE,
   STATE_TAX_VAL_END    DATE,
   LOCAL_TAX_VAL_START  DATE,
   LOCAL_TAX_VAL_END    DATE,
   IF_STATE_TAX         VARCHAR2(20),
   IF_LOCAL_TAX         VARCHAR2(20),
   constraint PK_T_SUPPORTOR primary key (SUP_ID)
);

comment on table T_SUPPORTOR is
'供应商信息表';

comment on column T_SUPPORTOR.SUP_ID is
'供应商ID';

comment on column T_SUPPORTOR.SUP_NAME is
'供应商名称';

comment on column T_SUPPORTOR.SUP_EN_NAME is
'供应商英文名称';

comment on column T_SUPPORTOR.CREATE_DATE is
'成立时间';

comment on column T_SUPPORTOR.ABBREVIATION is
'简称';

comment on column T_SUPPORTOR.ADDRESS is
'注册地址';

comment on column T_SUPPORTOR.POSTCODE is
'邮政编码';

comment on column T_SUPPORTOR.NET_ADDR is
'网址';

comment on column T_SUPPORTOR.ORGANIZE_CODE is
'组织机构代码';

comment on column T_SUPPORTOR.ECONOMY is
'经济性质';

comment on column T_SUPPORTOR.TYPE_CODE is
'供应商类型代码';

comment on column T_SUPPORTOR.TYPE is
'供应商类型';

comment on column T_SUPPORTOR.BANK_ID is
'开户银行ID';

comment on column T_SUPPORTOR.BANK is
'开户银行';

comment on column T_SUPPORTOR.ACCOUNT is
'银行帐号';

comment on column T_SUPPORTOR.CREDIT is
'AAA，AA，A，BBB，BB，B，CCC，CC，C，D';

comment on column T_SUPPORTOR.CREDIT_ORG is
'信用等级评定机构';

comment on column T_SUPPORTOR.CREDIT_DATE is
'评定时间';

comment on column T_SUPPORTOR.INSURANCE is
'是否依法缴纳社会保险费';

comment on column T_SUPPORTOR.ILLEGAL is
'近三年内有无重大违法记录';

comment on column T_SUPPORTOR.CORPORATION is
'法定代表人';

comment on column T_SUPPORTOR.CORP_PHONE is
'法人固话';

comment on column T_SUPPORTOR.CORP_MOBILE is
'法人手机';

comment on column T_SUPPORTOR.CONTACT is
'供应商注册登记联系人';

comment on column T_SUPPORTOR.CONTACT_PHONE is
'联系人固话';

comment on column T_SUPPORTOR.CONTACT_MOBILE is
'联系人手机';

comment on column T_SUPPORTOR.CONTACT_FAX is
'联系人传真';

comment on column T_SUPPORTOR.CONTACT_EMAIL is
'联系人电子邮件';

comment on column T_SUPPORTOR.LIC_NO is
'执照注册号';

comment on column T_SUPPORTOR.LIC_ORG is
'执照发证机关';

comment on column T_SUPPORTOR.LIC_CAPITAL is
'执照注册资本金(万元)';

comment on column T_SUPPORTOR.LIC_ADDR is
'执照注册所在地';

comment on column T_SUPPORTOR.LIC_VAL_START is
'执照有效期开始';

comment on column T_SUPPORTOR.LIC_VAL_END is
'执照有效期结束';

comment on column T_SUPPORTOR.LIC_EXA_DATE is
'最近年检时间';

comment on column T_SUPPORTOR.LIC_MAIN_OPT is
'主要经营范围';

comment on column T_SUPPORTOR.LIC_OTHER_OPT is
'兼营范围';

comment on column T_SUPPORTOR.STATE_TAX_NO is
'税务登记证号';

comment on column T_SUPPORTOR.LOCAL_TAX_NO is
'地税登记证号';

comment on column T_SUPPORTOR.STATE_TAX_ORG is
'国税发证机关';

comment on column T_SUPPORTOR.LOCAL_TAX_ORG is
'地税发证机关';

comment on column T_SUPPORTOR.STATE_TAX_VAL_START is
'国税有效期开始时间';

comment on column T_SUPPORTOR.STATE_TAX_VAL_END is
'国税有效期结束时间';

comment on column T_SUPPORTOR.LOCAL_TAX_VAL_START is
'地税有效期开始时间';

comment on column T_SUPPORTOR.LOCAL_TAX_VAL_END is
'地税有效其结束时间';

comment on column T_SUPPORTOR.IF_STATE_TAX is
'是否依法缴纳国税税收';

comment on column T_SUPPORTOR.IF_LOCAL_TAX is
'是否依法缴纳地税税收';

create table T_IMAGE  (
   IMAGE_ID             VARCHAR2(50)                    not null,
   IMPORT_ID            VARCHAR2(50),
   IMAGE_TYPE_ID        VARCHAR2(50),
   IMAGE_TYPE           VARCHAR2(50)                    not null,
   IMAGE_NAME           VARCHAR2(100),
   IMAGE_DESC           VARCHAR2(50),
   IMAGE_PATH           VARCHAR2(255),
   IMAGE_ORDER          NUMBER,
   IMAGE                BLOB,
   EXPINFOA             VARCHAR2(1000),
   EXPINFOB             VARCHAR2(1000),
   EXPINFOC             VARCHAR2(1000),
   EXPINFOD             VARCHAR2(1000),
   EXPINFOE             VARCHAR2(1000),
   constraint PK_T_IMAGE primary key (IMAGE_ID)
);

comment on table T_IMAGE is
'海军物资图片信息表';

comment on column T_IMAGE.IMAGE_ID is
'图片ID';

comment on column T_IMAGE.IMPORT_ID is
'物资ID';

comment on column T_IMAGE.IMAGE_TYPE_ID is
'图片类型ID';

comment on column T_IMAGE.IMAGE_TYPE is
'图片类型';

comment on column T_IMAGE.IMAGE_NAME is
'图片名称';

comment on column T_IMAGE.IMAGE_DESC is
'图片描述';

comment on column T_IMAGE.IMAGE_PATH is
'图片路径';

comment on column T_IMAGE.IMAGE is
'图片内容';

comment on column T_IMAGE.EXPINFOA is
'扩展信息A';

comment on column T_IMAGE.EXPINFOB is
'扩展信息B';

comment on column T_IMAGE.EXPINFOC is
'扩展信息C';

comment on column T_IMAGE.EXPINFOD is
'扩展信息D';

comment on column T_IMAGE.EXPINFOE is
'扩展信息E';
