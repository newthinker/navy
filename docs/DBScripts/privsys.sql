create table T_DEPT  (
   DEPT_ID              VARCHAR(50)                     not null,
   DEPT_NAME            VARCHAR(100),
   SPELLING             VARCHAR(100),
   SUPER_DEPT_ID        VARCHAR(50),
   DEPT_ORDER           NUMBER,
   REMARK               VARCHAR(500),
   VALIDATED            VARCHAR(10),
   CREATOR_ID           VARCHAR(50),
   CREATOR_NAME         VARCHAR(100),
   CREATE_DATE          DATE,
   OPERATOR_ID          VARCHAR(50),
   OPERATOR_NAME        VARCHAR(100),
   OPERAT_DATE          DATE,
   EXPINFOA             VARCHAR(1000),
   EXPINFOB             VARCHAR(1000),
   EXPINFOC             VARCHAR(1000),
   EXPINFOD             VARCHAR(1000),
   EXPINFOE             VARCHAR(1000),
   constraint PK_T_NG_DEPT primary key (DEPT_ID)
);

comment on table T_DEPT is
'������ҵ������Ϣ��';

comment on column T_DEPT.DEPT_ID is
'����ID';

comment on column T_DEPT.DEPT_NAME is
'��������';

comment on column T_DEPT.SPELLING is
'ƴ��';

comment on column T_DEPT.SUPER_DEPT_ID is
'�ϼ�����ID';

comment on column T_DEPT.DEPT_ORDER is
'��������';

comment on column T_DEPT.REMARK is
'��ע';

comment on column T_DEPT.VALIDATED is
'��Ч��';

comment on column T_DEPT.CREATOR_ID is
'�����˱���';

comment on column T_DEPT.CREATOR_NAME is
'����������';

comment on column T_DEPT.CREATE_DATE is
'��������';

comment on column T_DEPT.OPERATOR_ID is
'�޸��˱���';

comment on column T_DEPT.OPERATOR_NAME is
'�޸�������';

comment on column T_DEPT.OPERAT_DATE is
'�޸�����';

comment on column T_DEPT.EXPINFOA is
'��չ��ϢA';

comment on column T_DEPT.EXPINFOB is
'��չ��ϢB';

comment on column T_DEPT.EXPINFOC is
'��չ��ϢC';

comment on column T_DEPT.EXPINFOD is
'��չ��ϢD';

comment on column T_DEPT.EXPINFOE is
'��չ��ϢE';

create table T_USER  (
   USER_ID              VARCHAR2(36)                    not null,
   DEPT_ID              VARCHAR2(36),
   USER_NAME            VARCHAR2(100),
   USER_ALIAS           VARCHAR2(100),
   LOGIN_NAME           VARCHAR2(100),
   LOGIN_PASS           VARCHAR2(100),
   REMARK               VARCHAR2(1000),
   VALIDATED            VARCHAR2(10),
   CREATOR_ID           VARCHAR2(36),
   CREATOR              VARCHAR2(100),
   CREATOR_DATE         DATE,
   OPERATOR_ID          VARCHAR2(36),
   OPERATOR             VARCHAR2(100),
   OPDATE               DATE,
   EXPINFOA             VARCHAR2(1000),
   EXPINFOB             VARCHAR2(1000),
   EXPINFOC             VARCHAR2(1000),
   EXPINFOD             VARCHAR2(1000),
   EXPINFOE             VARCHAR2(1000),
   constraint PK_T_USER primary key (USER_ID)
);

comment on table T_USER is
'�û���Ϣ��';

comment on column T_USER.USER_ID is
'�û�ID';

comment on column T_USER.DEPT_ID is
'����ID';

comment on column T_USER.USER_NAME is
'�û���';

comment on column T_USER.USER_ALIAS is
'����';

comment on column T_USER.LOGIN_NAME is
'��¼��';

comment on column T_USER.LOGIN_PASS is
'����';

comment on column T_USER.REMARK is
'��ע';

comment on column T_USER.VALIDATED is
'��Ч��';

comment on column T_USER.CREATOR_ID is
'������ID';

comment on column T_USER.CREATOR is
'������';

comment on column T_USER.CREATOR_DATE is
'��������';

comment on column T_USER.OPERATOR_ID is
'����޸���ID';

comment on column T_USER.OPERATOR is
'����޸���';

comment on column T_USER.OPDATE is
'����޸�����';

comment on column T_USER.EXPINFOA is
'��չ��ϢA';

comment on column T_USER.EXPINFOB is
'��չ��ϢB';

comment on column T_USER.EXPINFOC is
'��չ��ϢC';

comment on column T_USER.EXPINFOD is
'��չ��ϢD';

comment on column T_USER.EXPINFOE is
'��չ��ϢE';

create table T_ROLE  (
   ROLE_ID              VARCHAR2(36)                    not null,
   DEPT_ID              VARCHAR2(36),
   ROLE_NAME            VARCHAR2(100),
   ROLE_ALIAS           VARCHAR2(100),
   REMARK               VARCHAR2(1000),
   VALIDATED            VARCHAR2(10),
   CREATOR_ID           VARCHAR2(36),
   CREATOR              VARCHAR2(100),
   CREATE_DATE          DATE,
   OPERATOR_ID          VARCHAR2(36),
   OPERATOR             VARCHAR2(100),
   OPDATE               DATE,
   EXPINFOA             VARCHAR2(1000),
   EXPINFOB             VARCHAR2(1000),
   EXPINFOC             VARCHAR2(1000),
   EXPINFOD             VARCHAR2(1000),
   EXPINFOE             VARCHAR2(1000),
   constraint PK_T_ROLE primary key (ROLE_ID)
);

comment on table T_ROLE is
'�û���ɫ��Ϣ��';

comment on column T_ROLE.ROLE_ID is
'��ɫID';

comment on column T_ROLE.DEPT_ID is
'����ID';

comment on column T_ROLE.ROLE_NAME is
'��ɫ����';

comment on column T_ROLE.ROLE_ALIAS is
'��ɫ����';

comment on column T_ROLE.REMARK is
'��ע';

comment on column T_ROLE.VALIDATED is
'��Ч��';

comment on column T_ROLE.CREATOR_ID is
'������ID';

comment on column T_ROLE.CREATOR is
'������';

comment on column T_ROLE.CREATE_DATE is
'��������';

comment on column T_ROLE.OPERATOR_ID is
'����޸���ID';

comment on column T_ROLE.OPERATOR is
'����޸���';

comment on column T_ROLE.OPDATE is
'����޸�����';

comment on column T_ROLE.EXPINFOA is
'��չ��ϢA';

comment on column T_ROLE.EXPINFOB is
'��չ��ϢB';

comment on column T_ROLE.EXPINFOC is
'��չ��ϢC';

comment on column T_ROLE.EXPINFOD is
'��չ��ϢD';

comment on column T_ROLE.EXPINFOE is
'��չ��ϢE';

create table T_USER_ROLE  (
   USER_ID              VARCHAR2(36)                    not null,
   ROLE_ID              VARCHAR2(36)                    not null,
   constraint PK_T_USER_ROLE primary key (USER_ID, ROLE_ID)
);

comment on table T_USER_ROLE is
'�û���ɫ��Ϣ��';

comment on column T_USER_ROLE.USER_ID is
'�û�ID';

comment on column T_USER_ROLE.ROLE_ID is
'��ɫID';

create table T_FUNCTION  (
   FUNCTION_ID          VARCHAR2(36)                    not null,
   FUNCTION_NAME        VARCHAR2(100),
   SUPER_FUNCTION_ID    VARCHAR2(36),
   VALIDATED            VARCHAR2(50),
   FUNCTION_URL         VARCHAR2(255),
   FUNCTION_TYPE        VARCHAR2(50),
   FUNCTION_ORDER       NUMBER,
   REMARK               VARCHAR2(1000),
   CREATOR_ID           VARCHAR2(36),
   CREATOR              VARCHAR2(100),
   CREATE_DATE          DATE,
   OPERATOR_ID          VARCHAR2(36),
   OPERATOR             VARCHAR2(100),
   OPDATE               DATE,
   EXPINFOA             VARCHAR2(1000),
   EXPINFOB             VARCHAR2(1000),
   EXPINFOC             VARCHAR2(1000),
   EXPINFOD             VARCHAR2(1000),
   EXPINFOE             VARCHAR2(1000),
   constraint PK_T_FUNCTION primary key (FUNCTION_ID)
);

comment on table T_FUNCTION is
'ϵͳ������Ϣ��';

comment on column T_FUNCTION.FUNCTION_ID is
'����ID';

comment on column T_FUNCTION.FUNCTION_NAME is
'��������';

comment on column T_FUNCTION.SUPER_FUNCTION_ID is
'�ϼ�����ID';

comment on column T_FUNCTION.VALIDATED is
'��Ч��';

comment on column T_FUNCTION.FUNCTION_URL is
'��������';

comment on column T_FUNCTION.FUNCTION_TYPE is
'��������';

comment on column T_FUNCTION.FUNCTION_ORDER is
'����';

comment on column T_FUNCTION.REMARK is
'��ע';

comment on column T_FUNCTION.CREATOR_ID is
'������ID';

comment on column T_FUNCTION.CREATOR is
'������';

comment on column T_FUNCTION.CREATE_DATE is
'��������';

comment on column T_FUNCTION.OPERATOR_ID is
'����޸���ID';

comment on column T_FUNCTION.OPERATOR is
'����޸���';

comment on column T_FUNCTION.OPDATE is
'����޸�����';

comment on column T_FUNCTION.EXPINFOA is
'��չ��ϢA';

comment on column T_FUNCTION.EXPINFOB is
'��չ��ϢB';

comment on column T_FUNCTION.EXPINFOC is
'��չ��ϢC';

comment on column T_FUNCTION.EXPINFOD is
'��չ��ϢD';

comment on column T_FUNCTION.EXPINFOE is
'��չ��ϢE';
create table T_ROLE_FUNC  (
   ROLE_ID              VARCHAR2(36)                    not null,
   FUNCTION_ID          VARCHAR2(36)                    not null,
   constraint PK_T_ROLE_FUNC primary key (ROLE_ID, FUNCTION_ID)
);

comment on table T_ROLE_FUNC is
'���ܽ�ɫ��Ӧ��';

comment on column T_ROLE_FUNC.ROLE_ID is
'��ɫID';

comment on column T_ROLE_FUNC.FUNCTION_ID is
'����ID';
