create table T_IMPORT  (
   IMPORTID             VARCHAR2(36)      not null,
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
   DEPT_ID              VARCHAR2(36),      -- ����
   DEPT                 VARCHAR2(100),
   CLASS_ID             VARCHAR2(36),
   CLASS_NAME           VARCHAR2(100),
   PROJECT              VARCHAR2(200),
   BUDGET               DECIMAL(8, 2),
   COMPACT_MONEY        DECIMAL(8, 2),
   CURRENCY_ID          VARCHAR2(36),
   CURRENCY             VARCHAR2(100),
   RATE                 DECIMAL(5, 2),
   RMB_RATE        DECIMAL(5, 2),      -- ����
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
   PASS_DATE      DATE,          -- ����
   STORE_TYPE      VARCHAR2(36),      -- ����
   constraint PK_T_IMPORT primary key (IMPORTID)
);
comment on table T_IMPORT is
  '����ս���������ʱ�';
comment on column T_IMPORT.IMPORTID is
  'ID';
comment on column T_IMPORT.TYPE_CODE is
  '�ƻ�������';
comment on column T_IMPORT.TYPE_NAME is
  '�ƻ����';
comment on column T_IMPORT.IMPORT_YEAR is
  'ս�Դ����ƻ����';
comment on column T_IMPORT.PLAN_ID is
  '�ɹ��ƻ�ID';
comment on column T_IMPORT.PLAN is
  '�ɹ��ƻ�';
comment on column T_IMPORT.PLAN_DATE is
  '�ƻ��´�ʱ��';
comment on column T_IMPORT.COMPACT_ID is
  '�ɹ���ͬ';
comment on column T_IMPORT.COMPACT is
  '�ɹ���ͬ';
comment on column T_IMPORT.COMPACT_DATE is
  '��ͬǩ��ʱ��';
comment on column T_IMPORT.UNIT_ID is
  '�ɹ�����ID';
comment on column T_IMPORT.UNIT is
  '�ɹ�����';
comment on column T_IMPORT.DEPT_ID is
  '��ҵ����ID';
comment on column T_IMPORT.DEPT is
  '��ҵ����';
comment on column T_IMPORT.CLASS_ID is
  'רҵ���ID';
comment on column T_IMPORT.CLASS_NAME is
  'רҵ���';
comment on column T_IMPORT.PROJECT is
  '�ɹ���Ŀ';
comment on column T_IMPORT.BUDGET is
  'Ԥ����(��Ԫ)';
comment on column T_IMPORT.COMPACT_MONEY is
  '��ͬ���(��Ԫ)';
comment on column T_IMPORT.CURRENCY_ID is
  '����ID';
comment on column T_IMPORT.CURRENCY is
  '����';
comment on column T_IMPORT.RATE is
  '����';
comment on column T_IMPORT.DOLLAR is
  '�ۺ���Ԫ';
comment on column T_IMPORT.RMB is
  '�ۺ������';
comment on column T_IMPORT.ECONOMIZE is
  '��ʡ�ʽ�';
comment on column T_IMPORT.MODE_ID is
  '�ɹ���ʽID';
comment on column T_IMPORT.MODE_NAME is
  '�ɹ���ʽ';
comment on column T_IMPORT.DELIVERY_DATE is
  '��������';
comment on column T_IMPORT.AGENT_ID is
  'ί�д���˾ID';
comment on column T_IMPORT.AGENT is
  'ί�д���˾';
comment on column T_IMPORT.AGREE_ID is
  '����Э��ID';
comment on column T_IMPORT.AGREE is
  '����Э��';
comment on column T_IMPORT.PRODUCTOR is
  '�豸��������';
comment on column T_IMPORT.SUPPORTOR_ID is
  '��Ӧ��ID';
comment on column T_IMPORT.SUPPORTOR is
  '��Ӧ��';
comment on column T_IMPORT.SUPPORTOR_ADDR is
  '��Ӧ��ע��ص�';
comment on column T_IMPORT.EXAMINE_ID is
  '������������ļ�ID';
comment on column T_IMPORT.EXAMINE_NO is
  '��������������';
comment on column T_IMPORT.IMPORT_CLASS_ID is
  '�������ID';
comment on column T_IMPORT.IMPORT_CLASS is
  '�������';
comment on column T_IMPORT.DIRECTORY_ID is
  '��˰Ŀ¼ID';
comment on column T_IMPORT.DIRECTORY is
  '��˰Ŀ¼';
comment on column T_IMPORT.STORE_ADDR is
  '�����ص�';
comment on column T_IMPORT.USE_DATE is
  '����ʱ��';
comment on column T_IMPORT.USE_UNIT is
  '���õ�λ';
comment on column T_IMPORT.USE_STATE is
  'ʹ�����ID';
comment on column T_IMPORT.IMAGE is
  'װ��ͼƬID';

create table T_SUPPORTOR  (
   SUP_ID               VARCHAR(36)        not null,
   SUP_NAME             VARCHAR(200),
   SUP_EN_NAME          VARCHAR(200),
   CREATE_DATE          DATE,
   ABBREVIATION         VARCHAR2(20),
   ADDRESS              VARCHAR2(200),
   POSTCODE             VARCHAR2(20),
   NET_ADDR             VARCHAR2(255),
   ORGANIZE_CODE        VARCHAR2(100),
   ECOMOMY_ID			VARCHAR2(36),		-- �������ͱ��
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
   LIC_MAIN_OPT         VARCHAR2(2000),
   LIC_OTHER_OPT        VARCHAR2(2000),
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
   ----------------------------------------------------------------------
   SUP_TYPE_CODE    	VARCHAR2(10),
   SUP_TYPE        		VARCHAR2(200),
   SUMMARY        		VARCHAR2(2000),
   IMAGE        		VARCHAR2(36),
   LOCATION        		VARCHAR2(1000),
   LONGITUDE      		VARCHAR2(50),
   LATITUDE        		VARCHAR2(50),
   PRODUCTS_CLASS    	VARCHAR2(1000),
   MANUFACTURER_CONTACT VARCHAR2(100),
   MANUFACTURER_FAX    	VARCHAR2(100),
   MANUFACTURER_EMAIL  	VARCHAR2(200),
   MANUFACTURER_ADDRESS VARCHAR2(1000),
   MANUFACTURER_PERFORMANCE  VARCHAR2(2000),
   MANUFACTURER_SUMMARY VARCHAR2(2000),
   MANUFACTURER      	VARCHAR2(200),
   ----------------------------------------------------------------------
   L1_LOC        		VARCHAR2(30),    -- ��Ӧ������ʡ/����
   L2_LOC        		VARCHAR2(30),    -- ��Ӧ��������
   STOREHOUSE_AREA    	DECIMAL(8, 2), 	 -- �ֿ������
   WAREHOUSE_AREA    	DECIMAL(8, 2),   -- ���������
   STOREHOUSE_IMAGE    	VARCHAR2(50),    -- �ֿ���Ƭ
   AUDIT_LAST3Y      	VARCHAR2(200),   -- ��������Ʊ���ѹ���ļ�(RAR��ZIP��ʽ)
   LIC_BUS_IMAGE    	VARCHAR2(50),    -- Ӫҵִ��ɨ���
   ORG_STR_IMAGE    	VARCHAR2(50),    -- ��֯�ṹ����֤ɨ���
   BANK_PROVE      		VARCHAR2(200),   -- ��������֤���ļ�ɨ���
   OTHER_PROVE      	VARCHAR2(200),   -- ��������֤���ļ�(RAR��ZIP��ʽ)
   PURCHASE_TYPE_ID		VARCHAR2(36),	 -- �ɹ����ͱ��
   PURCHASE_TYPE    	VARCHAR2(100),   -- �ɹ���ʽ
   IF_TURNOVER      	VARCHAR2(20),    -- �Ƿ�ɽ�
   QUALITY_PROVE    	VARCHAR2(200),   -- ����������֤֤��ɨ���
   constraint PK_T_SUPPORTOR primary key (SUP_ID)
);
comment on table T_SUPPORTOR is
  '��Ӧ����Ϣ��';
comment on column T_SUPPORTOR.SUP_ID is
  '��Ӧ��ID';
comment on column T_SUPPORTOR.SUP_NAME is
  '��Ӧ������';
comment on column T_SUPPORTOR.SUP_EN_NAME is
  '��Ӧ��Ӣ������';
comment on column T_SUPPORTOR.CREATE_DATE is
  '����ʱ��';
comment on column T_SUPPORTOR.ABBREVIATION is
  '���';
comment on column T_SUPPORTOR.ADDRESS is
  'ע���ַ';
comment on column T_SUPPORTOR.POSTCODE is
  '��������';
comment on column T_SUPPORTOR.NET_ADDR is
  '��ַ';
comment on column T_SUPPORTOR.ORGANIZE_CODE is
  '��֯��������';
comment on column T_SUPPORTOR.ECONOMY is
  '��������';
comment on column T_SUPPORTOR.TYPE_CODE is
  '��Ӧ�����ʹ���';
comment on column T_SUPPORTOR.TYPE is
  '��Ӧ������';
comment on column T_SUPPORTOR.BANK_ID is
  '��������ID';
comment on column T_SUPPORTOR.BANK is
  '��������';
comment on column T_SUPPORTOR.ACCOUNT is
  '�����ʺ�';
comment on column T_SUPPORTOR.CREDIT is
  'AAA��AA��A��BBB��BB��B��CCC��CC��C��D';
comment on column T_SUPPORTOR.CREDIT_ORG is
  '���õȼ���������';
comment on column T_SUPPORTOR.CREDIT_DATE is
  '����ʱ��';
comment on column T_SUPPORTOR.INSURANCE is
  '�Ƿ�����������ᱣ�շ�';
comment on column T_SUPPORTOR.ILLEGAL is
  '�������������ش�Υ����¼';
comment on column T_SUPPORTOR.CORPORATION is
  '����������';
comment on column T_SUPPORTOR.CORP_PHONE is
  '���˹̻�';
comment on column T_SUPPORTOR.CORP_MOBILE is
  '�����ֻ�';
comment on column T_SUPPORTOR.CONTACT is
  '��Ӧ��ע��Ǽ���ϵ��';
comment on column T_SUPPORTOR.CONTACT_PHONE is
  '��ϵ�˹̻�';
comment on column T_SUPPORTOR.CONTACT_MOBILE is
  '��ϵ���ֻ�';
comment on column T_SUPPORTOR.CONTACT_FAX is
  '��ϵ�˴���';
comment on column T_SUPPORTOR.CONTACT_EMAIL is
  '��ϵ�˵����ʼ�';
comment on column T_SUPPORTOR.LIC_NO is
  'ִ��ע���';
comment on column T_SUPPORTOR.LIC_ORG is
  'ִ�շ�֤����';
comment on column T_SUPPORTOR.LIC_CAPITAL is
  'ִ��ע���ʱ���(��Ԫ)';
comment on column T_SUPPORTOR.LIC_ADDR is
  'ִ��ע�����ڵ�';
comment on column T_SUPPORTOR.LIC_VAL_START is
  'ִ����Ч�ڿ�ʼ';
comment on column T_SUPPORTOR.LIC_VAL_END is
  'ִ����Ч�ڽ���';
comment on column T_SUPPORTOR.LIC_EXA_DATE is
  '������ʱ��';
comment on column T_SUPPORTOR.LIC_MAIN_OPT is
  '��Ҫ��Ӫ��Χ';
comment on column T_SUPPORTOR.LIC_OTHER_OPT is
  '��Ӫ��Χ';
comment on column T_SUPPORTOR.STATE_TAX_NO is
  '˰��Ǽ�֤��';
comment on column T_SUPPORTOR.LOCAL_TAX_NO is
  '��˰�Ǽ�֤��';
comment on column T_SUPPORTOR.STATE_TAX_ORG is
  '��˰��֤����';
comment on column T_SUPPORTOR.LOCAL_TAX_ORG is
  '��˰��֤����';
comment on column T_SUPPORTOR.STATE_TAX_VAL_START is
  '��˰��Ч�ڿ�ʼʱ��';
comment on column T_SUPPORTOR.STATE_TAX_VAL_END is
  '��˰��Ч�ڽ���ʱ��';
comment on column T_SUPPORTOR.LOCAL_TAX_VAL_START is
  '��˰��Ч�ڿ�ʼʱ��';
comment on column T_SUPPORTOR.LOCAL_TAX_VAL_END is
  '��˰��Ч�����ʱ��';
comment on column T_SUPPORTOR.IF_STATE_TAX is
  '�Ƿ��������ɹ�˰˰��';
comment on column T_SUPPORTOR.IF_LOCAL_TAX is
  '�Ƿ��������ɵ�˰˰��';
comment on column T_SUPPORTOR.L1_LOC is
  '��Ӧ������ʡ/����';
comment on column T_SUPPORTOR.L2_LOC is
  '��Ӧ��������';
comment on column T_SUPPORTOR.STOREHOUSE_AREA is 
  '�ֿ������';
comment on column T_SUPPORTOR.WAREHOUSE_AREA is 
  '���������';
comment on column T_SUPPORTOR.STOREHOUSE_IMAGE is 
  '�ֿ���Ƭ';
comment on column T_SUPPORTOR.AUDIT_LAST3Y is
  '��������Ʊ���ѹ���ļ�(RAR��ZIP��ʽ)';
comment on column T_SUPPORTOR.LIC_BUS_IMAGE is
  'Ӫҵִ��ɨ���';
comment on column T_SUPPORTOR.ORG_STR_IMAGE is 
  '��֯�ṹ����֤ɨ���';
comment on column T_SUPPORTOR.BANK_PROVE is
  '��������֤���ļ�ɨ���';
comment on column T_SUPPORTOR.OTHER_PROVE is
  '��������֤���ļ�(RAR��ZIP��ʽ)';
comment on column T_SUPPORTOR.PURCHASE_TYPE is 
  '�ɹ���ʽ';
comment on column T_SUPPORTOR.IF_TURNOVER is 
  '�Ƿ�ɽ�';
comment on column T_SUPPORTOR.QUALITY_PROVE is
  '����������֤֤��ɨ���';
        
create table T_SUP_PRODUCT (
  PROD_ID        VARCHAR2(36)    not null,
  SUP_ID        VARCHAR(36),  
  GOOD_NAME      VARCHAR2(200),  
  DICT_CODE      VARCHAR2(100),
  PROD_NAME      VARCHAR2(200),
  MEASUR_UNIT      VARCHAR2(100),
  PROD_NO        VARCHAR2(200),
  AVG_OUTPUT      DECIMAL(10,2),
  MAX_OUTPUT      DECIMAL(10,2),
  SINGLE_MAX_OUTPUT  DECIMAL(10,2),
  SINGLE_MAX_DATE    VARCHAR2(200),
  REMARK        VARCHAR2(1000),
  PROD_IMAGE      VARCHAR2(50),    -- ������Ʒ��Ƭ�ֶ�
  constraint PK_T_SUP_PRODUCT primary key (PROD_ID)  
);
comment on table T_SUP_PRODUCT is
  '��Ӧ��������Ϣ��';
comment on column T_SUP_PRODUCT.PROD_ID is
  '��Ӧ���ʱ��';
comment on column T_SUP_PRODUCT.SUP_ID is
  '��Ӧ����������Ӧ��ID';    
comment on column T_SUP_PRODUCT.GOOD_NAME is  
  '����Ʒ��';
comment on column T_SUP_PRODUCT.DICT_CODE is
  '���ʷ�����';
comment on column T_SUP_PRODUCT.PROD_NAME is
  '��Ʒ����';
comment on column T_SUP_PRODUCT.MEASUR_UNIT is
  '���ʼ�����λ';
comment on column T_SUP_PRODUCT.PROD_NO is 
  '��Ʒϵ�л��ͺ�';
comment on column T_SUP_PRODUCT.AVG_OUTPUT is
  '��ȥ����(2009��2011)ƽ�������)';
comment on column T_SUP_PRODUCT.MAX_OUTPUT is
  '��ȥ����(2009��2011)��������';
comment on column T_SUP_PRODUCT.SINGLE_MAX_OUTPUT is
  '����������';
comment on column T_SUP_PRODUCT.SINGLE_MAX_DATE is
  '��ɵ�������������ʱ��(��)';
comment on column T_SUP_PRODUCT.REMARK is
  '��ע';
comment on column T_SUP_PRODUCT.PROD_IMAGE is
  '��Ʒ��Ƭ���';    

create table T_TRANSPORT (
  COM_ID        	VARCHAR2(36)  not null,
  COM_NAME      	VARCHAR2(64),
  TRUCK_TYPE_ID		VARCHAR2(36),		-- �������ͱ��
  TRUCK_TYPE      	VARCHAR2(3),
  DEADWEIGHT      	DECIMAL(10,2),
  COUNT        		INTEGER,  
  NEAR_RAILWAY    	VARCHAR2(32),
  RW_DIS        	DECIMAL(10,2),
  NEAR_PORT      	VARCHAR2(32),
  PORT_DIS      	DECIMAL(10,2),
  NEAR_AIRPORT    	VARCHAR2(32),
  AP_DIS        	DECIMAL(10,2),
  constraint PK_T_TRANSPORT primary key (COM_ID)
);
comment on table T_TRANSPORT is
  '���������ҵ��Ϣ��';
comment on column T_TRANSPORT.COM_ID is 
  '���������ҵID';
comment on column T_TRANSPORT.COM_NAME is
  '���������ҵ����';
comment on column T_TRANSPORT.TRUCK_TYPE is
  '���䳵����';
comment on column T_TRANSPORT.DEADWEIGHT is 
  '������';
comment on column T_TRANSPORT.COUNT is
  '���䳵����';
comment on column T_TRANSPORT.NEAR_RAILWAY is 
  '�����·����վ����';
comment on column T_TRANSPORT.RW_DIS is
  '��·����';
comment on column T_TRANSPORT.NEAR_PORT is 
  '����ۿ�����';
comment on column T_TRANSPORT.PORT_DIS is 
  'ˮ·����';
comment on column T_TRANSPORT.NEAR_AIRPORT is
  '�����������';
comment on column T_TRANSPORT.AP_DIS is
  '���о���';

create table T_SUP_TRANS (
  SUP_ID        VARCHAR(36),
  COM_ID        VARCHAR2(36),
  constraint PK_T_SUP_TRANS primary key (SUP_ID, COM_ID)
);
comment on table T_SUP_TRANS is 
  '��Ӧ��������Ϣ��';
comment on column T_SUP_TRANS.SUP_ID is
  '��Ӧ��ID';
comment on column T_SUP_TRANS.COM_ID is
  '���������ҵID';
  
create table T_HIGHWAY (
  COM_ID        VARCHAR2(36)    not null,
  HIW_ID        VARCHAR2(32),
  HIW_NAME      VARCHAR2(64),
  HIW_IN        VARCHAR2(64),
  HIW_IN_ID      VARCHAR2(32),
  HIW_DIS        DECIMAL(10,2),
  constraint PK_T_HIGHWAY primary key (COM_ID)
);
comment on table T_HIGHWAY is
  '���ٹ�·��Ϣ��';
comment on column T_HIGHWAY.COM_ID is
  '���������ҵID';
comment on column T_HIGHWAY.HIW_ID is
  '���ٹ�·���';
comment on column T_HIGHWAY.HIW_NAME is
  '���ٹ�·����';
comment on column T_HIGHWAY.HIW_IN is
  '���ٹ�·�������';
comment on column T_HIGHWAY.HIW_IN_ID is
  '���ٹ�·��ڱ��';
comment on column T_HIGHWAY.HIW_DIS is
  '����';

/*create table T_PROVE_INFO (
  SUP_ID        VARCHAR2(36)    not null,
  PROVE_NAME      VARCHAR2(200),
  IMAGE_ID      VARCHAR2(50)
);
comment on table T_PROVE_INFO is
  '����֤����Ϣ��';
comment on column T_PROVE_INFO.SUP_ID is
  '��Ӧ��ID';
comment on column T_PROVE_INFO.PROVE_NAME is
  '����֤������';
comment on column T_PROVE_INFO.IMAGE_ID is
  '����֤��ɨ���ID';
*/
  
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
    '��������ͼƬ��Ϣ��';
comment on column T_IMAGE.IMAGE_ID is
    'ͼƬID';
comment on column T_IMAGE.IMPORT_ID is
    '����ID';
comment on column T_IMAGE.IMAGE_TYPE_ID is
    'ͼƬ����ID';
comment on column T_IMAGE.IMAGE_TYPE is
    'ͼƬ����';
comment on column T_IMAGE.IMAGE_NAME is
    'ͼƬ����';
comment on column T_IMAGE.IMAGE_DESC is
    'ͼƬ����';
comment on column T_IMAGE.IMAGE_PATH is
    'ͼƬ·��';
comment on column T_IMAGE.IMAGE is
    'ͼƬ����';
comment on column T_IMAGE.EXPINFOA is
    '��չ��ϢA';
comment on column T_IMAGE.EXPINFOB is
    '��չ��ϢB';
comment on column T_IMAGE.EXPINFOC is
    '��չ��ϢC';
comment on column T_IMAGE.EXPINFOD is
    '��չ��ϢD';
comment on column T_IMAGE.EXPINFOE is
    '��չ��ϢE';
    
create table T_AFTERSALE_ORG (
  ORG_ID      VARCHAR2(36)  not null,
  SUP_ID      VARCHAR2(36),
  ORG_NAME    VARCHAR2(200),
  ORG_TYPE_ID VARCHAR2(36),		-- ����������ͱ��
  ORG_TYPE    VARCHAR2(100),
  LOCATION    VARCHAR2(500),
  DIRECTOR    VARCHAR2(100),
  PHONE      VARCHAR2(100),
  constraint PK_T_AFTERSALE_ORG primary key (ORG_ID)
);  
comment on table T_AFTERSALE_ORG is
  '��Ӧ���ۺ���������Ϣ��';
comment on column T_AFTERSALE_ORG.ORG_ID is
  '�ۺ����ID';
comment on column T_AFTERSALE_ORG.SUP_ID is 
  '��Ӧ��ID';
comment on column T_AFTERSALE_ORG.ORG_NAME is
  '�ۺ��������';
comment on column T_AFTERSALE_ORG.ORG_TYPE_ID is
  '�ۺ���������';
comment on column T_AFTERSALE_ORG.ORG_TYPE is
  '�ۺ�������';
comment on column T_AFTERSALE_ORG.LOCATION is
  '�ۺ������������';
comment on column T_AFTERSALE_ORG.DIRECTOR is
  '������';
comment on column T_AFTERSALE_ORG.PHONE is
  '��ϵ�绰';
  
create table T_STOCKHOLDER (
  STOCKHOLDER_ID        VARCHAR2(36)  not null,
  SUP_ID            VARCHAR2(36),
  STOCKHOLDER_NAME      VARCHAR2(100),
  CAPITAL            NUMBER(8),
  RATIO            VARCHAR2(50),
  STOCK_DATE          DATE,
  constraint PK_T_STOCKHOLDER primary key (STOCKHOLDER_ID)
);
comment on table T_STOCKHOLDER is
  '��Ӧ�̹ɶ���Ϣ��';
comment on column T_STOCKHOLDER.STOCKHOLDER_ID is
  '�ɶ�ID';
comment on column T_STOCKHOLDER.SUP_ID is
  '��Ӧ��ID';
comment on column T_STOCKHOLDER.STOCKHOLDER_NAME is
  '��Ӧ������';
comment on column T_STOCKHOLDER.CAPITAL is
  '���ʽ��';
comment on column T_STOCKHOLDER.RATIO is
  '���ʱ���';
comment on column T_STOCKHOLDER.STOCK_DATE is
  '����ʱ��';
  
