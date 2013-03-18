--------------------------------------------
-- Export file for user PRIVSYS           --
-- Created by zuow on 2013/3/18, 13:46:05 --
--------------------------------------------

spool navy_priv.log

prompt
prompt Creating table T_DEPT
prompt =====================
prompt
create table PRIVSYS.T_DEPT
(
  DEPT_ID       VARCHAR2(50) not null,
  DEPT_NAME     VARCHAR2(100),
  SPELLING      VARCHAR2(100),
  SUPER_DEPT_ID VARCHAR2(50),
  DEPT_ORDER    NUMBER,
  REMARK        VARCHAR2(500),
  VALIDATED     VARCHAR2(10),
  CREATOR_ID    VARCHAR2(50),
  CREATOR_NAME  VARCHAR2(100),
  CREATE_DATE   DATE,
  OPERATOR_ID   VARCHAR2(50),
  OPERATOR_NAME VARCHAR2(100),
  OPERAT_DATE   DATE,
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
comment on table PRIVSYS.T_DEPT
  is '������ҵ������Ϣ��';
comment on column PRIVSYS.T_DEPT.DEPT_ID
  is '����ID';
comment on column PRIVSYS.T_DEPT.DEPT_NAME
  is '��������';
comment on column PRIVSYS.T_DEPT.SPELLING
  is 'ƴ��';
comment on column PRIVSYS.T_DEPT.SUPER_DEPT_ID
  is '�ϼ�����ID';
comment on column PRIVSYS.T_DEPT.DEPT_ORDER
  is '��������';
comment on column PRIVSYS.T_DEPT.REMARK
  is '��ע';
comment on column PRIVSYS.T_DEPT.VALIDATED
  is '��Ч��';
comment on column PRIVSYS.T_DEPT.CREATOR_ID
  is '�����˱���';
comment on column PRIVSYS.T_DEPT.CREATOR_NAME
  is '����������';
comment on column PRIVSYS.T_DEPT.CREATE_DATE
  is '��������';
comment on column PRIVSYS.T_DEPT.OPERATOR_ID
  is '�޸��˱���';
comment on column PRIVSYS.T_DEPT.OPERATOR_NAME
  is '�޸�������';
comment on column PRIVSYS.T_DEPT.OPERAT_DATE
  is '�޸�����';
comment on column PRIVSYS.T_DEPT.EXPINFOA
  is '��չ��ϢA';
comment on column PRIVSYS.T_DEPT.EXPINFOB
  is '��չ��ϢB';
comment on column PRIVSYS.T_DEPT.EXPINFOC
  is '��չ��ϢC';
comment on column PRIVSYS.T_DEPT.EXPINFOD
  is '��չ��ϢD';
comment on column PRIVSYS.T_DEPT.EXPINFOE
  is '��չ��ϢE';
alter table PRIVSYS.T_DEPT
  add constraint PK_T_NG_DEPT primary key (DEPT_ID)
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
prompt Creating table T_FUNCTION
prompt =========================
prompt
create table PRIVSYS.T_FUNCTION
(
  FUNCTION_ID       VARCHAR2(36) not null,
  FUNCTION_NAME     VARCHAR2(100),
  SUPER_FUNCTION_ID VARCHAR2(36),
  VALIDATED         VARCHAR2(50),
  FUNCTION_URL      VARCHAR2(255),
  FUNCTION_TYPE     VARCHAR2(50),
  FUNCTION_ORDER    NUMBER,
  REMARK            VARCHAR2(1000),
  CREATOR_ID        VARCHAR2(36),
  CREATOR           VARCHAR2(100),
  CREATE_DATE       DATE,
  OPERATOR_ID       VARCHAR2(36),
  OPERATOR          VARCHAR2(100),
  OPDATE            DATE,
  EXPINFOA          VARCHAR2(1000),
  EXPINFOB          VARCHAR2(1000),
  EXPINFOC          VARCHAR2(1000),
  EXPINFOD          VARCHAR2(1000),
  EXPINFOE          VARCHAR2(1000)
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
comment on table PRIVSYS.T_FUNCTION
  is 'ϵͳ������Ϣ��';
comment on column PRIVSYS.T_FUNCTION.FUNCTION_ID
  is '����ID';
comment on column PRIVSYS.T_FUNCTION.FUNCTION_NAME
  is '��������';
comment on column PRIVSYS.T_FUNCTION.SUPER_FUNCTION_ID
  is '�ϼ�����ID';
comment on column PRIVSYS.T_FUNCTION.VALIDATED
  is '��Ч��';
comment on column PRIVSYS.T_FUNCTION.FUNCTION_URL
  is '��������';
comment on column PRIVSYS.T_FUNCTION.FUNCTION_TYPE
  is '��������';
comment on column PRIVSYS.T_FUNCTION.FUNCTION_ORDER
  is '����';
comment on column PRIVSYS.T_FUNCTION.REMARK
  is '��ע';
comment on column PRIVSYS.T_FUNCTION.CREATOR_ID
  is '������ID';
comment on column PRIVSYS.T_FUNCTION.CREATOR
  is '������';
comment on column PRIVSYS.T_FUNCTION.CREATE_DATE
  is '��������';
comment on column PRIVSYS.T_FUNCTION.OPERATOR_ID
  is '����޸���ID';
comment on column PRIVSYS.T_FUNCTION.OPERATOR
  is '����޸���';
comment on column PRIVSYS.T_FUNCTION.OPDATE
  is '����޸�����';
comment on column PRIVSYS.T_FUNCTION.EXPINFOA
  is '��չ��ϢA';
comment on column PRIVSYS.T_FUNCTION.EXPINFOB
  is '��չ��ϢB';
comment on column PRIVSYS.T_FUNCTION.EXPINFOC
  is '��չ��ϢC';
comment on column PRIVSYS.T_FUNCTION.EXPINFOD
  is '��չ��ϢD';
comment on column PRIVSYS.T_FUNCTION.EXPINFOE
  is '��չ��ϢE';
alter table PRIVSYS.T_FUNCTION
  add constraint PK_T_FUNCTION primary key (FUNCTION_ID)
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
prompt Creating table T_ROLE
prompt =====================
prompt
create table PRIVSYS.T_ROLE
(
  ROLE_ID     VARCHAR2(36) not null,
  DEPT_ID     VARCHAR2(36),
  ROLE_NAME   VARCHAR2(100),
  ROLE_ALIAS  VARCHAR2(100),
  REMARK      VARCHAR2(1000),
  VALIDATED   VARCHAR2(10),
  CREATOR_ID  VARCHAR2(36),
  CREATOR     VARCHAR2(100),
  CREATE_DATE DATE,
  OPERATOR_ID VARCHAR2(36),
  OPERATOR    VARCHAR2(100),
  OPDATE      DATE,
  EXPINFOA    VARCHAR2(1000),
  EXPINFOB    VARCHAR2(1000),
  EXPINFOC    VARCHAR2(1000),
  EXPINFOD    VARCHAR2(1000),
  EXPINFOE    VARCHAR2(1000)
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
comment on table PRIVSYS.T_ROLE
  is '�û���ɫ��Ϣ��';
comment on column PRIVSYS.T_ROLE.ROLE_ID
  is '��ɫID';
comment on column PRIVSYS.T_ROLE.DEPT_ID
  is '����ID';
comment on column PRIVSYS.T_ROLE.ROLE_NAME
  is '��ɫ����';
comment on column PRIVSYS.T_ROLE.ROLE_ALIAS
  is '��ɫ����';
comment on column PRIVSYS.T_ROLE.REMARK
  is '��ע';
comment on column PRIVSYS.T_ROLE.VALIDATED
  is '��Ч��';
comment on column PRIVSYS.T_ROLE.CREATOR_ID
  is '������ID';
comment on column PRIVSYS.T_ROLE.CREATOR
  is '������';
comment on column PRIVSYS.T_ROLE.CREATE_DATE
  is '��������';
comment on column PRIVSYS.T_ROLE.OPERATOR_ID
  is '����޸���ID';
comment on column PRIVSYS.T_ROLE.OPERATOR
  is '����޸���';
comment on column PRIVSYS.T_ROLE.OPDATE
  is '����޸�����';
comment on column PRIVSYS.T_ROLE.EXPINFOA
  is '��չ��ϢA';
comment on column PRIVSYS.T_ROLE.EXPINFOB
  is '��չ��ϢB';
comment on column PRIVSYS.T_ROLE.EXPINFOC
  is '��չ��ϢC';
comment on column PRIVSYS.T_ROLE.EXPINFOD
  is '��չ��ϢD';
comment on column PRIVSYS.T_ROLE.EXPINFOE
  is '��չ��ϢE';
alter table PRIVSYS.T_ROLE
  add constraint PK_T_ROLE primary key (ROLE_ID)
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
prompt Creating table T_ROLE_FUNC
prompt ==========================
prompt
create table PRIVSYS.T_ROLE_FUNC
(
  ROLE_ID     VARCHAR2(36) not null,
  FUNCTION_ID VARCHAR2(36) not null
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
comment on table PRIVSYS.T_ROLE_FUNC
  is '���ܽ�ɫ��Ӧ��';
comment on column PRIVSYS.T_ROLE_FUNC.ROLE_ID
  is '��ɫID';
comment on column PRIVSYS.T_ROLE_FUNC.FUNCTION_ID
  is '����ID';
alter table PRIVSYS.T_ROLE_FUNC
  add constraint PK_T_ROLE_FUNC primary key (ROLE_ID, FUNCTION_ID)
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
prompt Creating table T_USER
prompt =====================
prompt
create table PRIVSYS.T_USER
(
  USER_ID      VARCHAR2(36) not null,
  DEPT_ID      VARCHAR2(36),
  USER_NAME    VARCHAR2(100),
  USER_ALIAS   VARCHAR2(100),
  LOGIN_NAME   VARCHAR2(100),
  LOGIN_PASS   VARCHAR2(100),
  REMARK       VARCHAR2(1000),
  VALIDATED    VARCHAR2(10),
  CREATOR_ID   VARCHAR2(36),
  CREATOR      VARCHAR2(100),
  CREATOR_DATE DATE,
  OPERATOR_ID  VARCHAR2(36),
  OPERATOR     VARCHAR2(100),
  OPDATE       DATE,
  EXPINFOA     VARCHAR2(1000),
  EXPINFOB     VARCHAR2(1000),
  EXPINFOC     VARCHAR2(1000),
  EXPINFOD     VARCHAR2(1000),
  EXPINFOE     VARCHAR2(1000)
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
comment on table PRIVSYS.T_USER
  is '�û���Ϣ��';
comment on column PRIVSYS.T_USER.USER_ID
  is '�û�ID';
comment on column PRIVSYS.T_USER.DEPT_ID
  is '����ID';
comment on column PRIVSYS.T_USER.USER_NAME
  is '�û���';
comment on column PRIVSYS.T_USER.USER_ALIAS
  is '����';
comment on column PRIVSYS.T_USER.LOGIN_NAME
  is '��¼��';
comment on column PRIVSYS.T_USER.LOGIN_PASS
  is '����';
comment on column PRIVSYS.T_USER.REMARK
  is '��ע';
comment on column PRIVSYS.T_USER.VALIDATED
  is '��Ч��';
comment on column PRIVSYS.T_USER.CREATOR_ID
  is '������ID';
comment on column PRIVSYS.T_USER.CREATOR
  is '������';
comment on column PRIVSYS.T_USER.CREATOR_DATE
  is '��������';
comment on column PRIVSYS.T_USER.OPERATOR_ID
  is '����޸���ID';
comment on column PRIVSYS.T_USER.OPERATOR
  is '����޸���';
comment on column PRIVSYS.T_USER.OPDATE
  is '����޸�����';
comment on column PRIVSYS.T_USER.EXPINFOA
  is '��չ��ϢA';
comment on column PRIVSYS.T_USER.EXPINFOB
  is '��չ��ϢB';
comment on column PRIVSYS.T_USER.EXPINFOC
  is '��չ��ϢC';
comment on column PRIVSYS.T_USER.EXPINFOD
  is '��չ��ϢD';
comment on column PRIVSYS.T_USER.EXPINFOE
  is '��չ��ϢE';
alter table PRIVSYS.T_USER
  add constraint PK_T_USER primary key (USER_ID)
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
prompt Creating table T_USER_ROLE
prompt ==========================
prompt
create table PRIVSYS.T_USER_ROLE
(
  USER_ID VARCHAR2(36) not null,
  ROLE_ID VARCHAR2(36) not null
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
comment on table PRIVSYS.T_USER_ROLE
  is '�û���ɫ��Ϣ��';
comment on column PRIVSYS.T_USER_ROLE.USER_ID
  is '�û�ID';
comment on column PRIVSYS.T_USER_ROLE.ROLE_ID
  is '��ɫID';
alter table PRIVSYS.T_USER_ROLE
  add constraint PK_T_USER_ROLE primary key (USER_ID, ROLE_ID)
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
