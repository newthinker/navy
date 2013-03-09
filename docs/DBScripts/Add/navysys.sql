--供应商信息表
alter table T_SUPPORTOR add ECOMOMY_ID			VARCHAR2(36);		-- 经济性质编号
alter table T_SUPPORTOR add L1_LOC 				VARCHAR2(30);    	-- 供应商所在省/地区
alter table T_SUPPORTOR add L2_LOC 				VARCHAR2(30);		-- 供应商所在市
alter table T_SUPPORTOR add STOREHOUSE_AREA 	DECIMAL(8, 2);  	-- 仓库总面积
alter table T_SUPPORTOR add WAREHOUSE_AREA 		DECIMAL(8, 2);   	-- 货场总面积
alter table T_SUPPORTOR add STOREHOUSE_IMAGE 	VARCHAR2(50);  		-- 仓库照片
alter table T_SUPPORTOR add AUDIT_LAST3Y 		VARCHAR2(200);     	-- 近三年审计报告压缩文件(RAR或ZIP格式)
alter table T_SUPPORTOR add LIC_BUS_IMAGE 		VARCHAR2(50);    	-- 营业执照扫描件
alter table T_SUPPORTOR add ORG_STR_IMAGE    	VARCHAR2(50);    	-- 组织结构代码证扫描件
alter table T_SUPPORTOR add BANK_PROVE      	VARCHAR2(200);		-- 银行资信证明文件扫描件
alter table T_SUPPORTOR add OTHER_PROVE      	VARCHAR2(200);   	-- 其它资质证明文件(RAR或ZIP格式)
alter table T_SUPPORTOR add PURCHASE_TYPE_ID	VARCHAR2(36);		-- 采购类型编号
alter table T_SUPPORTOR add PURCHASE_TYPE    	VARCHAR2(100);   	-- 采购方式
alter table T_SUPPORTOR add IF_TURNOVER      	VARCHAR2(20);    	-- 是否成交
alter table T_SUPPORTOR add QUALITY_PROVE    	VARCHAR2(200);   	-- 质量管理认证证书扫描件

alter table T_SUP_PRODUCT add PROD_IMAGE      	VARCHAR2(50);    	-- 新增产品照片字段

create table T_TRANSPORT (
  COM_ID        	VARCHAR2(36)  not null,
  COM_NAME      	VARCHAR2(64),
  TRUCK_TYPE_ID		VARCHAR2(36),		-- 货车类型编号
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
  '运输服务企业信息表';
comment on column T_TRANSPORT.COM_ID is 
  '运输服务企业ID';
comment on column T_TRANSPORT.COM_NAME is
  '运输服务企业名称';
comment on column T_TRANSPORT.TRUCK_TYPE is
  '运输车种类';
comment on column T_TRANSPORT.DEADWEIGHT is 
  '载重量';
comment on column T_TRANSPORT.COUNT is
  '运输车数量';
comment on column T_TRANSPORT.NEAR_RAILWAY is 
  '最近铁路货运站名称';
comment on column T_TRANSPORT.RW_DIS is
  '铁路距离';
comment on column T_TRANSPORT.NEAR_PORT is 
  '最近港口名称';
comment on column T_TRANSPORT.PORT_DIS is 
  '水路距离';
comment on column T_TRANSPORT.NEAR_AIRPORT is
  '最近机场名称';
comment on column T_TRANSPORT.AP_DIS is
  '飞行距离';

create table T_SUP_TRANS (
  SUP_ID        VARCHAR(36),
  COM_ID        VARCHAR2(36),
  constraint PK_T_SUP_TRANS primary key (SUP_ID, COM_ID)
);
comment on table T_SUP_TRANS is 
  '供应商运输信息表';
comment on column T_SUP_TRANS.SUP_ID is
  '供应商ID';
comment on column T_SUP_TRANS.COM_ID is
  '运输服务企业ID';
  
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
  '高速公路信息表';
comment on column T_HIGHWAY.COM_ID is
  '运输服务企业ID';
comment on column T_HIGHWAY.HIW_ID is
  '高速公路编号';
comment on column T_HIGHWAY.HIW_NAME is
  '高速公路名称';
comment on column T_HIGHWAY.HIW_IN is
  '高速公路入口名称';
comment on column T_HIGHWAY.HIW_IN_ID is
  '高速公路入口编号';
comment on column T_HIGHWAY.HIW_DIS is
  '距离';

alter table T_AFTERSALE_ORG add ORG_TYPE_ID VARCHAR2(36);		-- 服务机构类型编号  
  