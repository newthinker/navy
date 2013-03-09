create or replace procedure getAllProducts
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

create or replace procedure getSons(thecode varchar2)
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
