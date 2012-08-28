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
	'�����ֵ����ͱ�';
comment on column T_DICT_TYPE.TYPE_ID is
	'����ID';
comment on column T_DICT_TYPE.TYPE_NAME is
	'��������';
comment on column T_DICT_TYPE.TYPE_OWNER is
	'�������ԣ��û� or  ϵͳ��';
comment on column T_DICT_TYPE.TYPE_EXPLAIN is
	'����˵��';
comment on column T_DICT_TYPE.VALIDATED is
	'��Ч��';
comment on column T_DICT_TYPE.TYPE_ORDER is
	'ͬ������';
comment on column T_DICT_TYPE.CREATOR_ID is
	'������ID';
comment on column T_DICT_TYPE.CREATOR_NAME is
	'����������';
comment on column T_DICT_TYPE.CREATE_DATE is
	'��������';
comment on column T_DICT_TYPE.OPERATOR_ID is
	'����޸���ID';
comment on column T_DICT_TYPE.OPERATOR_NAME is
	'����޸�������';
comment on column T_DICT_TYPE.OPERAT_DATE is
	'����޸�����';

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
	'�����ֵ���ϸ��';
comment on column T_DICT_DETAIL.DICT_CODE is
	'�ֵ������';
comment on column T_DICT_DETAIL.TYPE_ID is
	'����ID';
comment on column T_DICT_DETAIL.DICT_NAME is
	'�ֵ�������';
comment on column T_DICT_DETAIL.DICT_OWNER is
	'�ֵ������ԣ��û� or ϵͳ��';
comment on column T_DICT_DETAIL.SPELLING is
	'ƴ��';
comment on column T_DICT_DETAIL.FATHER_CODE is
	'�ϼ��ֵ������';
comment on column T_DICT_DETAIL.RELEVANCE_CODE is
	'�����ֵ������';
comment on column T_DICT_DETAIL.DICT_ORDER is
	'ͬ������';
comment on column T_DICT_DETAIL.DICT_EXPLAIN is
	'�ֵ���˵��';
comment on column T_DICT_DETAIL.VALIDATED is
	'��Ч��';
comment on column T_DICT_DETAIL.DICT_REMARK is
	'��ע';
comment on column T_DICT_DETAIL.HAVE_CHILD is
	'�Ƿ����ӽڵ㣨Y-�У�N-�ޣ�';
comment on column T_DICT_DETAIL.CREATOR_ID is
	'������ID';
comment on column T_DICT_DETAIL.CREATOR_NAME is
	'����������';
comment on column T_DICT_DETAIL.CREATE_DATE is
	'��������';
comment on column T_DICT_DETAIL.OPERATOR_ID is
	'����޸���ID';
comment on column T_DICT_DETAIL.OPERATOR_NAME is
	'����޸�������';
comment on column T_DICT_DETAIL.OPERAT_DATE is
	'����޸�����';
comment on column T_DICT_DETAIL.EXPINFOA is
	'��չ��Ϣ1';
comment on column T_DICT_DETAIL.EXPINFOB is
	'��չ��Ϣ2';
comment on column T_DICT_DETAIL.EXPINFOC is
	'��չ��Ϣ3';
comment on column T_DICT_DETAIL.EXPINFOD is
	'��չ��Ϣ4';
comment on column T_DICT_DETAIL.EXPINFOE is
	'��չ��Ϣ5';
	
create table T_DICT_AREA (
	AREA_CODE		VARCHAR2(6)			NOT NULL,
	AREA_NAME		VARCHAR2(32),
	PARENT_CODEID		VARCHAR2(6),
	constraint PK_T_DICT_AREA primary key (AREA_CODE)
);	
comment on table T_DICT_AREA is 
	'�й�ʡ������������������';
comment on column T_DICT_AREA.AREA_CODE is 
	'������������';
comment on column T_DICT_AREA.AREA_NAME is 
	'������������';
comment on column T_DICT_AREA.PARENT_CODEID is 
	'�ϼ�������������';
	
-- �������������ļ��Ĵ洢����
CREATE OR REPLACE PROCEDURE PARSE_AREA_FILE (p_file varchar2)
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

    insert into T_DICT_AREA(AREA_CODE, AREA_NAME, PARENT_CODE) values(v_code, v_name, v_parent);

  end loop;

  utl_file.fclose(v_filehandle);
END PARSE_AREA_FILE;