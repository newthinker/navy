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
'海军事业部门信息表';

comment on column T_DEPT.DEPT_ID is
'部门ID';

comment on column T_DEPT.DEPT_NAME is
'部门名称';

comment on column T_DEPT.SPELLING is
'拼音';

comment on column T_DEPT.SUPER_DEPT_ID is
'上级部门ID';

comment on column T_DEPT.DEPT_ORDER is
'部门排序';

comment on column T_DEPT.REMARK is
'备注';

comment on column T_DEPT.VALIDATED is
'有效性';

comment on column T_DEPT.CREATOR_ID is
'创建人编码';

comment on column T_DEPT.CREATOR_NAME is
'创建人姓名';

comment on column T_DEPT.CREATE_DATE is
'创建日期';

comment on column T_DEPT.OPERATOR_ID is
'修改人编码';

comment on column T_DEPT.OPERATOR_NAME is
'修改人姓名';

comment on column T_DEPT.OPERAT_DATE is
'修改日期';

comment on column T_DEPT.EXPINFOA is
'扩展信息A';

comment on column T_DEPT.EXPINFOB is
'扩展信息B';

comment on column T_DEPT.EXPINFOC is
'扩展信息C';

comment on column T_DEPT.EXPINFOD is
'扩展信息D';

comment on column T_DEPT.EXPINFOE is
'扩展信息E';

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
'用户信息表';

comment on column T_USER.USER_ID is
'用户ID';

comment on column T_USER.DEPT_ID is
'部门ID';

comment on column T_USER.USER_NAME is
'用户名';

comment on column T_USER.USER_ALIAS is
'别名';

comment on column T_USER.LOGIN_NAME is
'登录名';

comment on column T_USER.LOGIN_PASS is
'密码';

comment on column T_USER.REMARK is
'备注';

comment on column T_USER.VALIDATED is
'有效性';

comment on column T_USER.CREATOR_ID is
'创建人ID';

comment on column T_USER.CREATOR is
'创建人';

comment on column T_USER.CREATOR_DATE is
'创建日期';

comment on column T_USER.OPERATOR_ID is
'最后修改人ID';

comment on column T_USER.OPERATOR is
'最后修改人';

comment on column T_USER.OPDATE is
'最后修改日期';

comment on column T_USER.EXPINFOA is
'扩展信息A';

comment on column T_USER.EXPINFOB is
'扩展信息B';

comment on column T_USER.EXPINFOC is
'扩展信息C';

comment on column T_USER.EXPINFOD is
'扩展信息D';

comment on column T_USER.EXPINFOE is
'扩展信息E';

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
'用户角色信息表';

comment on column T_ROLE.ROLE_ID is
'角色ID';

comment on column T_ROLE.DEPT_ID is
'部门ID';

comment on column T_ROLE.ROLE_NAME is
'角色名称';

comment on column T_ROLE.ROLE_ALIAS is
'角色别名';

comment on column T_ROLE.REMARK is
'备注';

comment on column T_ROLE.VALIDATED is
'有效性';

comment on column T_ROLE.CREATOR_ID is
'创建人ID';

comment on column T_ROLE.CREATOR is
'创建人';

comment on column T_ROLE.CREATE_DATE is
'创建日期';

comment on column T_ROLE.OPERATOR_ID is
'最后修改人ID';

comment on column T_ROLE.OPERATOR is
'最后修改人';

comment on column T_ROLE.OPDATE is
'最后修改日期';

comment on column T_ROLE.EXPINFOA is
'扩展信息A';

comment on column T_ROLE.EXPINFOB is
'扩展信息B';

comment on column T_ROLE.EXPINFOC is
'扩展信息C';

comment on column T_ROLE.EXPINFOD is
'扩展信息D';

comment on column T_ROLE.EXPINFOE is
'扩展信息E';

create table T_USER_ROLE  (
   USER_ID              VARCHAR2(36)                    not null,
   ROLE_ID              VARCHAR2(36)                    not null,
   constraint PK_T_USER_ROLE primary key (USER_ID, ROLE_ID)
);

comment on table T_USER_ROLE is
'用户角色信息表';

comment on column T_USER_ROLE.USER_ID is
'用户ID';

comment on column T_USER_ROLE.ROLE_ID is
'角色ID';

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
'系统功能信息表';

comment on column T_FUNCTION.FUNCTION_ID is
'功能ID';

comment on column T_FUNCTION.FUNCTION_NAME is
'功能名称';

comment on column T_FUNCTION.SUPER_FUNCTION_ID is
'上级功能ID';

comment on column T_FUNCTION.VALIDATED is
'有效性';

comment on column T_FUNCTION.FUNCTION_URL is
'功能链接';

comment on column T_FUNCTION.FUNCTION_TYPE is
'功能类型';

comment on column T_FUNCTION.FUNCTION_ORDER is
'排序';

comment on column T_FUNCTION.REMARK is
'备注';

comment on column T_FUNCTION.CREATOR_ID is
'创建人ID';

comment on column T_FUNCTION.CREATOR is
'创建人';

comment on column T_FUNCTION.CREATE_DATE is
'创建日期';

comment on column T_FUNCTION.OPERATOR_ID is
'最后修改人ID';

comment on column T_FUNCTION.OPERATOR is
'最后修改人';

comment on column T_FUNCTION.OPDATE is
'最后修改日期';

comment on column T_FUNCTION.EXPINFOA is
'扩展信息A';

comment on column T_FUNCTION.EXPINFOB is
'扩展信息B';

comment on column T_FUNCTION.EXPINFOC is
'扩展信息C';

comment on column T_FUNCTION.EXPINFOD is
'扩展信息D';

comment on column T_FUNCTION.EXPINFOE is
'扩展信息E';
create table T_ROLE_FUNC  (
   ROLE_ID              VARCHAR2(36)                    not null,
   FUNCTION_ID          VARCHAR2(36)                    not null,
   constraint PK_T_ROLE_FUNC primary key (ROLE_ID, FUNCTION_ID)
);

comment on table T_ROLE_FUNC is
'功能角色对应表';

comment on column T_ROLE_FUNC.ROLE_ID is
'角色ID';

comment on column T_ROLE_FUNC.FUNCTION_ID is
'功能ID';
