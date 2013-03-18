prompt PL/SQL Developer import file
prompt Created on 2013��3��17�� by zuow
set feedback off
set define off
prompt Disabling triggers for T_DEPT...
alter table T_DEPT disable all triggers;
prompt Disabling triggers for T_FUNCTION...
alter table T_FUNCTION disable all triggers;
prompt Disabling triggers for T_ROLE...
alter table T_ROLE disable all triggers;
prompt Disabling triggers for T_ROLE_FUNC...
alter table T_ROLE_FUNC disable all triggers;
prompt Disabling triggers for T_USER...
alter table T_USER disable all triggers;
prompt Disabling triggers for T_USER_ROLE...
alter table T_USER_ROLE disable all triggers;
prompt Loading T_DEPT...
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('310000000', '��˾��Ҫ��', null, '-1', 1, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('320000000', '��˾�鱨��', null, '-1', 2, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('330000000', '��˾�Ĳ�', null, '-1', 3, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('340000000', '��˾ͨ�Ų�', null, '-1', 4, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('350000000', '��˾��ѵ��', null, '-1', 5, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('360000000', '��˾������', null, '-1', 6, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('370000000', '��˾���ձ���', null, '-1', 7, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('380000000', '����˾�', null, '-1', 8, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('390000000', '����������Ͳ�', null, '-1', 9, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3A0000000', '����������', null, '-1', 10, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3B0000000', '�����Ӫ��', null, '-1', 11, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3C0000000', '���������', null, '-1', 12, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3D0000000', '���󽢼���', null, '-1', 13, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3E0000000', '���󺽼���', null, '-1', 14, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3F0000000', '�����е��', null, '-1', 15, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
prompt 15 records loaded
prompt Loading T_FUNCTION...
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3300000000', '��Ӧ����Ϣͳ��', '3000000000', 'Y', 'pages/navy/supmanage/supSupportorStat.jsp', null, 3, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1400000000', '�ɹ���Ŀ��ѯ', '1000000000', 'Y', 'pages/navy/importmanage/importQuery.jsp', null, 4, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2300000000', '����λά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=3', null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2400000000', 'רҵ���ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=4', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2500000000', '����ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=5', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2600000000', '�ɹ���ʽά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=6', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2700000000', 'ί�д���˾ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=7', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2800000000', '�������ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=8', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2900000000', '��˰Ŀ¼ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=9', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2A00000000', 'ʹ�����ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=10', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2B00000000', '��Ӧ�����ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=11', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2C00000000', '��������ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=12', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2D00000000', '���õȼ�ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=13', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1500000000', '��Ӧ����Ϣ����', '1000000000', 'N', 'pages/navy/supportormanage/supportorQuery.jsp', null, 3, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1000000000', '�ɹ���Ŀ����', '-1', 'Y', null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1100000000', '�ɹ���Ŀ����', '1000000000', 'Y', 'pages/navy/importmanage/import.jsp', null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1200000000', '�ɹ���Ŀ��Ϣ����', '1000000000', 'Y', 'pages/navy/importmanage/importDataQuery.jsp', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1300000000', '�ɹ���Ŀ���ܷ���', '1000000000', 'Y', 'pages/navy/importmanage/importQueryByUnit.jsp', null, 5, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2000000000', 'ϵͳά��', '-1', 'Y', null, null, 3, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2100000000', '�ƻ����ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=1', null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2200000000', '�ɹ�����ά��', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=2', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3000000000', '��Ӧ�̹���', '-1', 'Y', null, null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3500000000', '��������ά��', '3000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=14', null, 5, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3600000000', '�����������ά��', '3000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=17', null, 6, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3700000000', '���䳵����ά��', '3000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=18', null, 7, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3100000000', '��Ӧ�̵���', '3000000000', 'Y', 'pages/navy/supmanage/supImport.jsp', null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3200000000', '��Ӧ�̲�ѯ', '3000000000', 'Y', 'pages/navy/supmanage/supSupportorQuery.jsp', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3400000000', '��Ʒ��Ŀά��', '3000000000', 'Y', 'pages/dict/supDictQuery.jsp?typeid=15&fathercode=-1', null, 4, null, null, null, null, null, null, null, null, null, null, null, null);
prompt 28 records loaded
prompt Loading T_ROLE...
insert into T_ROLE (ROLE_ID, DEPT_ID, ROLE_NAME, ROLE_ALIAS, REMARK, VALIDATED, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('admin', '0', 'admin', null, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
prompt 1 records loaded
prompt Loading T_ROLE_FUNC...
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '1000000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '1100000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '1200000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '1300000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '1400000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '1500000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2000000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2100000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2200000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2300000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2400000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2500000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2600000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2700000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2800000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2900000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2A00000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2B00000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2C00000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '2D00000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '3000000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '3100000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '3200000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '3300000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '3400000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '3500000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '3600000000');
insert into T_ROLE_FUNC (ROLE_ID, FUNCTION_ID)
values ('admin', '3700000000');
prompt 28 records loaded
prompt Loading T_USER...
insert into T_USER (USER_ID, DEPT_ID, USER_NAME, USER_ALIAS, LOGIN_NAME, LOGIN_PASS, REMARK, VALIDATED, CREATOR_ID, CREATOR, CREATOR_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1', '0', 'admin', 'admin', 'admin', 'e10adc3949ba59abbe56e057f20f883e', null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_USER (USER_ID, DEPT_ID, USER_NAME, USER_ALIAS, LOGIN_NAME, LOGIN_PASS, REMARK, VALIDATED, CREATOR_ID, CREATOR, CREATOR_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('10000000', '390000000', '������', 'xiong', 'xiong', 'e10adc3949ba59abbe56e057f20f883e', null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
prompt 2 records loaded
prompt Loading T_USER_ROLE...
insert into T_USER_ROLE (USER_ID, ROLE_ID)
values ('1', 'admin');
insert into T_USER_ROLE (USER_ID, ROLE_ID)
values ('10000000', 'admin');
insert into T_USER_ROLE (USER_ID, ROLE_ID)
values ('admin', 'admin');
prompt 3 records loaded
prompt Enabling triggers for T_DEPT...
alter table T_DEPT enable all triggers;
prompt Enabling triggers for T_FUNCTION...
alter table T_FUNCTION enable all triggers;
prompt Enabling triggers for T_ROLE...
alter table T_ROLE enable all triggers;
prompt Enabling triggers for T_ROLE_FUNC...
alter table T_ROLE_FUNC enable all triggers;
prompt Enabling triggers for T_USER...
alter table T_USER enable all triggers;
prompt Enabling triggers for T_USER_ROLE...
alter table T_USER_ROLE enable all triggers;
set feedback on
set define on
prompt Done.
