create or replace procedure getAllProducts
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

/*-------------------------------------------------------------------------------------
  �������ƣ�getSons
  ���������thecode,��ǰ�ڵ���ֵ����            
  ��������������ǰ�ڵ��������ӽڵ����
---------------------------------------------------------------------------------------*/
create or replace procedure getSons(thecode varchar2)
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
	  if( v_num=0 ) then	-- ���û���ӽڵ���˳�
		continue;
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
