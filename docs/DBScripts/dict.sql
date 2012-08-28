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
   DICT_CODE            VARCHAR2(100)		not null,
   TYPE_ID              VARCHAR2(50)        not null,
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
	
create table T_DICT_AREA (
	AREA_CODE		VARCHAR2(6)			NOT NULL,
	AREA_NAME		VARCHAR2(32),
	PARENT_CODEID		VARCHAR2(6),
	constraint PK_T_DICT_AREA primary key (AREA_CODE)
);	
comment on table T_DICT_AREA is 
	'中国省市县三级行政区划表';
comment on column T_DICT_AREA.AREA_CODE is 
	'行政区划编码';
comment on column T_DICT_AREA.AREA_NAME is 
	'行政区划名称';
comment on column T_DICT_AREA.PARENT_CODEID is 
	'上级行政区划编码';
	
-- 解析行政区划文件的存储过程
CREATE OR REPLACE PROCEDURE PARSE_AREA_FILE (p_file varchar2)
IS
  v_filehandle  utl_file.file_type;    -- 文件句柄
  v_text        varchar2(50);      -- 存放文本
  v_code        varchar2(50);      -- 行政编码
  v_name        varchar2(50);      -- 名称
  v_parent      varchar2(50);      -- 父级行政区划编码
  v_loc          integer := 0;
--  p_file        varchar2(100) := 'area.txt';

  v_first_level      varchar2(4);
  v_second_level    varchar2(2);

  v_first_parent    varchar2(50);
  v_second_parent   varchar2(50);
BEGIN
  if ( p_file is null ) then
    return;
  end if;

  v_filehandle := utl_file.fopen('INPUT_FILE', p_file, 'r');
  loop
  begin
    utl_file.get_line(v_filehandle, v_text);  -- 读取一行数据
    exception
      when no_data_found then
      exit;
    end;

    -- 解析数据
    if ( v_text is null ) then
      continue;
    end if;

    v_text := trim(v_text);      -- 去掉两边的空格

    v_loc := instr(v_text, ' ');
    if ( v_loc = 0 ) then
      continue;
    end if;

    v_code := substr(v_text, 1, v_loc-1);
    v_name := substr(v_text, v_loc+1);

    v_code := trim(v_code);
    v_name := trim(v_name);

    v_first_level := substr(v_code, length(v_code)-3);
    v_second_level := substr(v_code, length(v_code)-1);

    if( v_first_level = '0000' ) then
      if ( v_second_level = '00' ) then
         v_parent := 0;
         v_first_parent := v_code;
      end if;
    else
      if ( v_second_level = '00' ) then
        v_parent := v_first_parent;
        v_second_parent := v_code;
      else
        v_parent := v_second_parent;
      end if;
    end if;

    insert into T_DICT_AREA(AREA_CODE, AREA_NAME, PARENT_CODE) values(v_code, v_name, v_parent);

  end loop;

  utl_file.fclose(v_filehandle);
END PARSE_AREA_FILE;