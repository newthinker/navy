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
  is '�й�ʡ������������������';
comment on column DICTSYS.T_DICT_AREA.AREA_CODE
  is '������������';
comment on column DICTSYS.T_DICT_AREA.AREA_NAME
  is '������������';
comment on column DICTSYS.T_DICT_AREA.PARENT_CODEID
  is '�ϼ�������������';
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
  is '�����ֵ���ϸ��';
comment on column DICTSYS.T_DICT_DETAIL.DICT_CODE
  is '�ֵ������';
comment on column DICTSYS.T_DICT_DETAIL.TYPE_ID
  is '����ID';
comment on column DICTSYS.T_DICT_DETAIL.DICT_NAME
  is '�ֵ�������';
comment on column DICTSYS.T_DICT_DETAIL.DICT_OWNER
  is '�ֵ������ԣ��û� or ϵͳ��';
comment on column DICTSYS.T_DICT_DETAIL.SPELLING
  is 'ƴ��';
comment on column DICTSYS.T_DICT_DETAIL.FATHER_CODE
  is '�ϼ��ֵ������';
comment on column DICTSYS.T_DICT_DETAIL.RELEVANCE_CODE
  is '�����ֵ������';
comment on column DICTSYS.T_DICT_DETAIL.DICT_ORDER
  is 'ͬ������';
comment on column DICTSYS.T_DICT_DETAIL.DICT_EXPLAIN
  is '�ֵ���˵��';
comment on column DICTSYS.T_DICT_DETAIL.VALIDATED
  is '��Ч��';
comment on column DICTSYS.T_DICT_DETAIL.DICT_REMARK
  is '��ע';
comment on column DICTSYS.T_DICT_DETAIL.HAVE_CHILD
  is '�Ƿ����ӽڵ㣨Y-�У�N-�ޣ�';
comment on column DICTSYS.T_DICT_DETAIL.CREATOR_ID
  is '������ID';
comment on column DICTSYS.T_DICT_DETAIL.CREATOR_NAME
  is '����������';
comment on column DICTSYS.T_DICT_DETAIL.CREATE_DATE
  is '��������';
comment on column DICTSYS.T_DICT_DETAIL.OPERATOR_ID
  is '����޸���ID';
comment on column DICTSYS.T_DICT_DETAIL.OPERATOR_NAME
  is '����޸�������';
comment on column DICTSYS.T_DICT_DETAIL.OPERAT_DATE
  is '����޸�����';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOA
  is '��չ��Ϣ1';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOB
  is '��չ��Ϣ2';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOC
  is '��չ��Ϣ3';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOD
  is '��չ��Ϣ4';
comment on column DICTSYS.T_DICT_DETAIL.EXPINFOE
  is '��չ��Ϣ5';
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
  is '�����ֵ����ͱ�';
comment on column DICTSYS.T_DICT_TYPE.TYPE_ID
  is '����ID';
comment on column DICTSYS.T_DICT_TYPE.TYPE_NAME
  is '��������';
comment on column DICTSYS.T_DICT_TYPE.TYPE_OWNER
  is '�������ԣ��û� or  ϵͳ��';
comment on column DICTSYS.T_DICT_TYPE.TYPE_EXPLAIN
  is '����˵��';
comment on column DICTSYS.T_DICT_TYPE.VALIDATED
  is '��Ч��';
comment on column DICTSYS.T_DICT_TYPE.TYPE_ORDER
  is 'ͬ������';
comment on column DICTSYS.T_DICT_TYPE.CREATOR_ID
  is '������ID';
comment on column DICTSYS.T_DICT_TYPE.CREATOR_NAME
  is '����������';
comment on column DICTSYS.T_DICT_TYPE.CREATE_DATE
  is '��������';
comment on column DICTSYS.T_DICT_TYPE.OPERATOR_ID
  is '����޸���ID';
comment on column DICTSYS.T_DICT_TYPE.OPERATOR_NAME
  is '����޸�������';
comment on column DICTSYS.T_DICT_TYPE.OPERAT_DATE
  is '����޸�����';
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
  v_curcode       varchar2(100);        -- ��ǰ�ֵ����
  v_typecode      varchar2(2) := '15';  -- ���ͱ��
  v_dictname      varchar2(200);        -- �ֵ�����
  v_dictcode      varchar2(100);        -- �ֵ���
  v_parentcode    varchar2(100);        -- ������
  v_havechild     varchar2(2);          -- �Ƿ����ӽڵ�
  
  v_num			  integer;				-- �ӽڵ����
begin
  v_curcode := thecode;

  -- �жϵ�ǰ�ڵ��Ƿ�Ϊ��
  if ( v_curcode is null ) then
    null;
  end if;

  -- ���Ȳ�ѯ�����Ƿ���ֱ���ӽڵ�
  select have_child into v_havechild from t_dict_detail where type_id=v_typecode and dict_code=v_curcode;

  if ( v_havechild='N' or v_havechild='n' ) then
    -- ��ӡ��ǰ�ڵ�
    select type_id, dict_name, dict_code, father_code into v_typecode, v_dictname, v_dictcode, v_parentcode 
           from t_dict_detail where type_id=v_typecode and dict_code=v_curcode;
    if ( v_typecode is not null and v_dictcode is not null
      and v_dictname is not null and v_parentcode is not null ) then
      dbms_output.put_line('<row TYPE_ID="' || v_typecode || '" DICT_NAME="' || v_dictname || '" DICT_CODE="' || 
                                 v_dictcode || '" RELEVANCE_CODE="' || v_parentcode || '" />');
    end if;
  else
    -- ��ѯ��������ֱ���ӽڵ�
    if ( v_havechild='Y' or v_havechild='y' ) then
      -- ��ѯ��������ڵ�
--      dbms_output.put_line('father="' || v_curcode || '"');
    select type_id, dict_name, dict_code, father_code into v_typecode, v_dictname, v_dictcode, v_parentcode 
      from t_dict_detail where type_id=v_typecode and dict_code=v_curcode;
    if ( v_typecode is not null and v_dictcode is not null
    and v_dictname is not null and v_parentcode is not null ) then
    dbms_output.put_line('<row TYPE_ID="' || v_typecode || '" DICT_NAME="' || v_dictname || '" DICT_CODE="' || 
             v_dictcode || '" RELEVANCE_CODE="' || v_parentcode || '" />');
    end if;
    
    -- ��ѯ�����ӽڵ����
    select count(*) into v_num from t_dict_detail where type_id=v_typecode and FATHER_CODE=v_curcode;
    if( v_num=0 ) then  -- ���û���ӽڵ���˳�
        return;
    end if;
    
      -- �����α�
      declare
        cursor cur_code
        is
        select dict_code from t_dict_detail where type_id=v_typecode and FATHER_CODE=v_curcode;
      begin
        -- forѭ�������α�
        for c_tmp in cur_code
        loop
          v_curcode := c_tmp.dict_code;
--          dbms_output.put_line('son="' || v_curcode || '"');
      -- ��ѯ������ӽڵ���Ϣ
      select type_id, dict_name, dict_code, father_code into v_typecode, v_dictname, v_dictcode, v_parentcode 
        from t_dict_detail where type_id=v_typecode and dict_code=v_curcode;
             
          -- �ݹ����
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
  -- ���Ȳ�ѯ����L1�ڵ�ı���
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
  v_filehandle  utl_file.file_type;    -- �ļ����
  v_text        varchar2(50);      -- ����ı�
  v_code        varchar2(50);      -- ��������
  v_name        varchar2(50);      -- ����
  v_parent      varchar2(50);      -- ����������������
  v_loc          integer := 0;
--  p_file        varchar2(100) := 'area.txt';

  v_first_level      varchar2(4);
  v_second_level    varchar2(2);

  v_first_parent    varchar2(50);
  v_second_parent   varchar2(50);
  
  v_pre_name        varchar2(50);  -- �ϼ�����������
BEGIN
  if ( p_file is null ) then
    return;
  end if;

  v_filehandle := utl_file.fopen('INPUT_FILE', p_file, 'r');
  loop
  begin
    utl_file.get_line(v_filehandle, v_text);  -- ��ȡһ������
    exception
      when no_data_found then
      exit;
    end;

    -- ��������
    if ( v_text is null ) then
      continue;
    end if;

    v_text := trim(v_text);      -- ȥ�����ߵĿո�

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
    
    -- �ж��Ƿ�ΪֱϽ��
    if ( v_second_level = '00' and v_name = '��Ͻ��' ) then
      v_name := v_pre_name;
    elsif ( v_second_level = '00' and v_name = '��') then 
      continue;
    elsif ( v_second_level != '00') then       -- ��ʱ����Ҫ����������
      continue;  
    end if;
    
    insert into T_DICT_AREA(AREA_CODE, AREA_NAME, PARENT_CODEID) values(v_code, v_name, v_parent);
    
    v_pre_name := v_name;

  end loop;

  utl_file.fclose(v_filehandle);
END PARSE_AREA_FILE;
/


spool off
