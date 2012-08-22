create table T_DICT_AREA (
	AREA_CODE		VARCHAR2(6)			NOT NULL,
	AREA_NAME		VARCHAR2(32),
	PARENT_CODE		VARCHAR2(6),
	constraint PK_T_DICT_AREA primary key (AREA_CODE)
);	
comment on table T_DICT_AREA is 
	'中国省市县三级行政区划表';
comment on column T_DICT_AREA.AREA_CODE is 
	'行政区划编码';
comment on column T_DICT_AREA.AREA_NAME is 
	'行政区划名称';
comment on column T_DICT_AREA.PARENT_CODE is 
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