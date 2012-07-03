create table T_DICT_TYPE  (
   TYPE_ID              VARCHAR2(50)                    not null,
   TYPE_NAME            VARCHAR2(100),
   TYPE_OWNER           VARCHAR2(100),
   TYPE_EXPLAIN         VARCHAR2(1000),
   VALIDATED            VARCHAR2(2),
   TYPE_ORDER           INTEGER,
   CREATOR_ID           VARCHAR2(50),
   CREATOR_NAME         VARCHAR2(100),
   CREATE_DATE          DATE,
   OPERATOR_ID          VARCHAR2(50),
   OPERATOR_NAME        VARCHAR2(100),
   OPERAT_DATE          DATE,
   constraint PK_T_DICT_TYPE primary key (TYPE_ID)
);

comment on table T_DICT_TYPE is
'公用字典类型表';

comment on column T_DICT_TYPE.TYPE_ID is
'类型ID';

comment on column T_DICT_TYPE.TYPE_NAME is
'类型名称';

comment on column T_DICT_TYPE.TYPE_OWNER is
'类型属性（用户 or  系统）';

comment on column T_DICT_TYPE.TYPE_EXPLAIN is
'类型说明';

comment on column T_DICT_TYPE.VALIDATED is
'有效性';

comment on column T_DICT_TYPE.TYPE_ORDER is
'同级排序';

comment on column T_DICT_TYPE.CREATOR_ID is
'创建人ID';

comment on column T_DICT_TYPE.CREATOR_NAME is
'创建人姓名';

comment on column T_DICT_TYPE.CREATE_DATE is
'创建日期';

comment on column T_DICT_TYPE.OPERATOR_ID is
'最后修改人ID';

comment on column T_DICT_TYPE.OPERATOR_NAME is
'最后修改人姓名';

comment on column T_DICT_TYPE.OPERAT_DATE is
'最后修改日期';

create table T_DICT_DETAIL  (
   DICT_CODE            VARCHAR2(100)                   not null,
   TYPE_ID              VARCHAR2(50)                    not null,
   DICT_NAME            VARCHAR2(200),
   DICT_OWNER           VARCHAR2(100),
   SPELLING             VARCHAR2(100),
   FATHER_CODE          VARCHAR2(100),
   RELEVANCE_CODE       VARCHAR2(100),
   DICT_ORDER           INTEGER,
   DICT_EXPLAIN         VARCHAR2(1000),
   VALIDATED            VARCHAR2(2),
   DICT_REMARK          VARCHAR2(1000),
   HAVE_CHILD           VARCHAR2(2),
   CREATOR_ID           VARCHAR2(50),
   CREATOR_NAME         VARCHAR2(100),
   CREATE_DATE          DATE,
   OPERATOR_ID          VARCHAR2(50),
   OPERATOR_NAME        VARCHAR2(100),
   OPERAT_DATE          DATE,
   EXPINFOA             VARCHAR2(1000),
   EXPINFOB             VARCHAR2(1000),
   EXPINFOC             VARCHAR2(1000),
   EXPINFOD             VARCHAR2(1000),
   EXPINFOE             VARCHAR2(1000),
   constraint PK_T_DICT_DETAIL primary key (DICT_CODE, TYPE_ID)
);

comment on table T_DICT_DETAIL is
'公用字典明细表';

comment on column T_DICT_DETAIL.DICT_CODE is
'字典项代码';

comment on column T_DICT_DETAIL.TYPE_ID is
'类型ID';

comment on column T_DICT_DETAIL.DICT_NAME is
'字典项名称';

comment on column T_DICT_DETAIL.DICT_OWNER is
'字典项属性（用户 or 系统）';

comment on column T_DICT_DETAIL.SPELLING is
'拼音';

comment on column T_DICT_DETAIL.FATHER_CODE is
'上级字典项代码';

comment on column T_DICT_DETAIL.RELEVANCE_CODE is
'关联字典项代码';

comment on column T_DICT_DETAIL.DICT_ORDER is
'同级排序';

comment on column T_DICT_DETAIL.DICT_EXPLAIN is
'字典项说明';

comment on column T_DICT_DETAIL.VALIDATED is
'有效性';

comment on column T_DICT_DETAIL.DICT_REMARK is
'备注';

comment on column T_DICT_DETAIL.HAVE_CHILD is
'是否有子节点（Y-有，N-无）';

comment on column T_DICT_DETAIL.CREATOR_ID is
'创建人ID';

comment on column T_DICT_DETAIL.CREATOR_NAME is
'创建人姓名';

comment on column T_DICT_DETAIL.CREATE_DATE is
'创建日期';

comment on column T_DICT_DETAIL.OPERATOR_ID is
'最后修改人ID';

comment on column T_DICT_DETAIL.OPERATOR_NAME is
'最后修改人姓名';

comment on column T_DICT_DETAIL.OPERAT_DATE is
'最后修改日期';

comment on column T_DICT_DETAIL.EXPINFOA is
'扩展信息1';

comment on column T_DICT_DETAIL.EXPINFOB is
'扩展信息2';

comment on column T_DICT_DETAIL.EXPINFOC is
'扩展信息3';

comment on column T_DICT_DETAIL.EXPINFOD is
'扩展信息4';

comment on column T_DICT_DETAIL.EXPINFOE is
'扩展信息5';