--------------------------------------------
-- Export file for user DICTSYS           --
-- Created by zuow on 2013/3/18, 13:44:23 --
--------------------------------------------

spool navy_dict.log

prompt
prompt Creating table T_DICT_AREA
prompt ==========================
prompt
create table DICTSYS.T_DICT_AREA
(
  AREA_CODE     VARCHAR2(6) not null,
  AREA_NAME     VARCHAR2(32),
  PARENT_CODEID VARCHAR2(6)
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
comment on table DICTSYS.T_DICT_AREA
  is '中国省市县三级行政区划表';
comment on column DICTSYS.T_DICT_AREA.AREA_CODE
  is '行政区划编码';
comment on column DICTSYS.T_DICT_AREA.AREA_NAME
  is '行政区划名称';
comment on column DICTSYS.T_DICT_AREA.PARENT_CODEID
  is '上级行政区划编码';
alter table DICTSYS.T_DICT_AREA
  add constraint PK_T_DICT_AREA primary key (AREA_CODE)
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
prompt Creating table T_DICT_DETAIL
prompt ============================
prompt
create table DICTSYS.T_DICT_DETAIL
(
  DICT_CODE      VARCHAR2(100) not null,
  TYPE_ID        VARCHAR2(50) not null,
  DICT_NAME      VARCHAR2(200),
  DICT_OWNER     VARCHAR2(100),
  SPELLING       VARCHAR2(100),
  FATHER_CODE    VARCHAR2(100),
  RELEVANCE_CODE VARCHAR2(100),
  DICT_ORDER     NUMBER(38),
  DICT_EXPLAIN   VARCHAR2(1000),
  VALIDATED      VARCHAR2(2),
  DICT_REMARK    VARCHAR2(1000),
  HAVE_CHILD     VARCHAR2(2),
  CREATOR_ID     VARCHAR2(50),
  CREATOR_NAME   VARCHAR2(100),
  CREATE_DATE    DATE,
  OPERATOR_ID    VARCHAR2(50),
  OPERATOR_NAME  VARCHAR2(100),
  OPERAT_DATE    DATE,
  EXPINFOA       VARCHAR2(1000),
  EXPINFOB       VARCHAR2(1000),
  EXPINFOC       VARCHAR2(1000),
  EXPINFOD       VARCHAR2(1000),
  EXPINFOE       VARCHAR2(1000)
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
comment on table DICTSYS.T_DICT_DETAIL
  is '公用字典明细表';
comment on column DICTSYS.T_DICT_DETAIL.DICT_CODE
  is '字典项代码';
comment on column DICTSYS.T_DICT_DETAIL.TYPE_ID
  is '类型ID';
comment on column DICTSYS.T_DICT_DETAIL.DICT_NAME
  is '字典项名称';
comment on column DICTSYS.T_DICT_DETAIL.DICT_OWNER
  is '字典项属性（用户 or 系统）';
comment on column DICTSYS.T_DICT_DETAIL.SPELLING
  is '拼音';
comment on column DICTSYS.T_DICT_DETAIL.FATHER_CODE
  is '上级字典项代码';
comment on column DICTSYS.T_DICT_DETAIL.RELEVANCE_CODE
  is '关联字典项代码';
comment on column DICTSYS.T_DICT_DETAIL.DICT_ORDER
  is '同级排序';
comment on column DICTSYS.T_DICT_DETAIL.DICT_EXPLAIN
  is '字典项说明';
comment on column DICTSYS.T_DICT_DETAIL.VALIDATED
  is '有效性';
comment on column DICTSYS.T_DICT_DETAIL.DICT_REMARK
  is '备注';
comment on column DICTSYS.T_DICT_DETAIL.HAVE_CHILD
  is '是否有子节点（Y-有，N-无）';
comment on column DICTSYS.T_DICT_DETAIL.CREATOR_ID
  is '创建人ID';
comment on column DICTSYS.T_DICT_DETAIL.CREATOR_NAME
  is '创建人姓名';
comment on column DICTSYS.T_DICT_DETAIL.CREATE_DATE
  is '创建日期';
comment on column DICTSYS.T_DICT_DETAIL.OPERATOR_ID
  is '最后修改人ID';
comment on column DICTSYS.T_DICT_DETAIL.OPERATOR_NAME
  is '最后修改人姓名';
comment on column DICTSYS.T_DICT_DETAIL.OPERAT_DATE
  is '最后修改日期';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOA
  is '扩展信息1';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOB
  is '扩展信息2';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOC
  is '扩展信息3';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOD
  is '扩展信息4';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOE
  is '扩展信息5';
alter table DICTSYS.T_DICT_DETAIL
  add constraint PK_T_DICT_DETAIL primary key (DICT_CODE, TYPE_ID)
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
prompt Creating table T_DICT_TYPE
prompt ==========================
prompt
create table DICTSYS.T_DICT_TYPE
(
  TYPE_ID       VARCHAR2(50) not null,
  TYPE_NAME     VARCHAR2(100),
  TYPE_OWNER    VARCHAR2(100),
  TYPE_EXPLAIN  VARCHAR2(1000),
  VALIDATED     VARCHAR2(2),
  TYPE_ORDER    NUMBER(38),
  CREATOR_ID    VARCHAR2(50),
  CREATOR_NAME  VARCHAR2(100),
  CREATE_DATE   DATE,
  OPERATOR_ID   VARCHAR2(50),
  OPERATOR_NAME VARCHAR2(100),
  OPERAT_DATE   DATE
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
comment on table DICTSYS.T_DICT_TYPE
  is '公用字典类型表';
comment on column DICTSYS.T_DICT_TYPE.TYPE_ID
  is '类型ID';
comment on column DICTSYS.T_DICT_TYPE.TYPE_NAME
  is '类型名称';
comment on column DICTSYS.T_DICT_TYPE.TYPE_OWNER
  is '类型属性（用户 or  系统）';
comment on column DICTSYS.T_DICT_TYPE.TYPE_EXPLAIN
  is '类型说明';
comment on column DICTSYS.T_DICT_TYPE.VALIDATED
  is '有效性';
comment on column DICTSYS.T_DICT_TYPE.TYPE_ORDER
  is '同级排序';
comment on column DICTSYS.T_DICT_TYPE.CREATOR_ID
  is '创建人ID';
comment on column DICTSYS.T_DICT_TYPE.CREATOR_NAME
  is '创建人姓名';
comment on column DICTSYS.T_DICT_TYPE.CREATE_DATE
  is '创建日期';
comment on column DICTSYS.T_DICT_TYPE.OPERATOR_ID
  is '最后修改人ID';
comment on column DICTSYS.T_DICT_TYPE.OPERATOR_NAME
  is '最后修改人姓名';
comment on column DICTSYS.T_DICT_TYPE.OPERAT_DATE
  is '最后修改日期';
alter table DICTSYS.T_DICT_TYPE
  add constraint PK_T_DICT_TYPE primary key (TYPE_ID)
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


spool off
