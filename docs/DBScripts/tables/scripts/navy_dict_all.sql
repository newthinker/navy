--------------------------------------------
-- Export file for user DICTSYS           --
-- Created by zuow on 2013/3/18, 13:45:10 --
--------------------------------------------

spool navy_dict_all.log

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

prompt
prompt Creating procedure GETSONS
prompt ==========================
prompt
create or replace procedure dictsys.getSons(thecode varchar2)
is
  v_curcode       varchar2(100);        -- 当前字典编码
  v_typecode      varchar2(2) := '15';  -- 类型编号
  v_dictname      varchar2(200);        -- 字典名称
  v_dictcode      varchar2(100);        -- 字典编号
  v_parentcode    varchar2(100);        -- 父类编号
  v_havechild     varchar2(2);          -- 是否有子节点
  
  v_num			  integer;				-- 子节点个数
begin
  v_curcode := thecode;

  -- 判断当前节点是否为空
  if ( v_curcode is null ) then
    null;
  end if;

  -- 首先查询其下是否还有直属子节点
  select have_child into v_havechild from t_dict_detail where type_id=v_typecode and dict_code=v_curcode;

  if ( v_havechild='N' or v_havechild='n' ) then
    -- 打印当前节点
    select type_id, dict_name, dict_code, father_code into v_typecode, v_dictname, v_dictcode, v_parentcode 
           from t_dict_detail where type_id=v_typecode and dict_code=v_curcode;
    if ( v_typecode is not null and v_dictcode is not null
      and v_dictname is not null and v_parentcode is not null ) then
      dbms_output.put_line('<row TYPE_ID="' || v_typecode || '" DICT_NAME="' || v_dictname || '" DICT_CODE="' || 
                                 v_dictcode || '" RELEVANCE_CODE="' || v_parentcode || '" />');
    end if;
  else
    -- 查询其下所有直属子节点
    if ( v_havechild='Y' or v_havechild='y' ) then
      -- 查询并输出父节点
--      dbms_output.put_line('father="' || v_curcode || '"');
    select type_id, dict_name, dict_code, father_code into v_typecode, v_dictname, v_dictcode, v_parentcode 
      from t_dict_detail where type_id=v_typecode and dict_code=v_curcode;
    if ( v_typecode is not null and v_dictcode is not null
    and v_dictname is not null and v_parentcode is not null ) then
    dbms_output.put_line('<row TYPE_ID="' || v_typecode || '" DICT_NAME="' || v_dictname || '" DICT_CODE="' || 
             v_dictcode || '" RELEVANCE_CODE="' || v_parentcode || '" />');
    end if;
    
    -- 查询其下子节点个数
    select count(*) into v_num from t_dict_detail where type_id=v_typecode and FATHER_CODE=v_curcode;
    if( v_num=0 ) then  -- 如果没有子节点就退出
        return;
    end if;
    
      -- 定义游标
      declare
        cursor cur_code
        is
        select dict_code from t_dict_detail where type_id=v_typecode and FATHER_CODE=v_curcode;
      begin
        -- for循环遍历游标
        for c_tmp in cur_code
        loop
          v_curcode := c_tmp.dict_code;
--          dbms_output.put_line('son="' || v_curcode || '"');
      -- 查询并输出子节点信息
      select type_id, dict_name, dict_code, father_code into v_typecode, v_dictname, v_dictcode, v_parentcode 
        from t_dict_detail where type_id=v_typecode and dict_code=v_curcode;
             
          -- 递归调用
          getSons(v_dictcode);
        end loop;
      end;
    end if;
  end if;
end getSons;
/

prompt
prompt Creating procedure GETALLPRODUCTS
prompt =================================
prompt
create or replace procedure dictsys.getAllProducts
is
  v_curcode    varchar2(100);
begin
  -- 首先查询所有L1节点的编码
  declare
    cursor mycur
    is
    select dict_code from t_dict_detail where type_id='15' and father_code='-1';
  begin
    for thecode in mycur
  loop
    v_curcode := thecode.dict_code;
    getSons(v_curcode);
  end loop;
  end;

end getAllProducts;
/

prompt
prompt Creating procedure PARSE_AREA_FILE
prompt ==================================
prompt
CREATE OR REPLACE PROCEDURE DICTSYS.PARSE_AREA_FILE (p_file varchar2)
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
  
  v_pre_name        varchar2(50);  -- 上级行政区名称
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
    
    -- 判断是否为直辖市
    if ( v_second_level = '00' and v_name = '市辖区' ) then
      v_name := v_pre_name;
    elsif ( v_second_level = '00' and v_name = '县') then 
      continue;
    elsif ( v_second_level != '00') then       -- 暂时不需要第三级数据
      continue;  
    end if;
    
    insert into T_DICT_AREA(AREA_CODE, AREA_NAME, PARENT_CODEID) values(v_code, v_name, v_parent);
    
    v_pre_name := v_name;

  end loop;

  utl_file.fclose(v_filehandle);
END PARSE_AREA_FILE;
/


spool off
