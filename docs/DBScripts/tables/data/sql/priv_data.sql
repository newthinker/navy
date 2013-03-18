prompt PL/SQL Developer import file
prompt Created on 2013年3月17日 by zuow
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
values ('310000000', '海司机要局', null, '-1', 1, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('320000000', '海司情报部', null, '-1', 2, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('330000000', '海司四部', null, '-1', 3, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('340000000', '海司通信部', null, '-1', 4, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('350000000', '海司军训部', null, '-1', 5, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('360000000', '海司航保部', null, '-1', 6, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('370000000', '海司航空兵部', null, '-1', 7, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('380000000', '海后司令部', null, '-1', 8, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('390000000', '海后军需物油部', null, '-1', 9, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3A0000000', '海后卫生部', null, '-1', 10, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3B0000000', '海后港营部', null, '-1', 11, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3C0000000', '海后军交部', null, '-1', 12, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3D0000000', '海后舰技部', null, '-1', 13, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3E0000000', '海后航技部', null, '-1', 14, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
insert into T_DEPT (DEPT_ID, DEPT_NAME, SPELLING, SUPER_DEPT_ID, DEPT_ORDER, REMARK, VALIDATED, CREATOR_ID, CREATOR_NAME, CREATE_DATE, OPERATOR_ID, OPERATOR_NAME, OPERAT_DATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3F0000000', '海后军械部', null, '-1', 15, null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
prompt 15 records loaded
prompt Loading T_FUNCTION...
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3300000000', '供应商信息统计', '3000000000', 'Y', 'pages/navy/supmanage/supSupportorStat.jsp', null, 3, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1400000000', '采购项目查询', '1000000000', 'Y', 'pages/navy/importmanage/importQuery.jsp', null, 4, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2300000000', '需求单位维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=3', null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2400000000', '专业类别维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=4', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2500000000', '币种维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=5', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2600000000', '采购方式维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=6', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2700000000', '委托代理公司维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=7', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2800000000', '进口类别维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=8', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2900000000', '免税目录维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=9', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2A00000000', '使用情况维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=10', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2B00000000', '供应商类别维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=11', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2C00000000', '开户银行维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=12', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2D00000000', '信用等级维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=13', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1500000000', '供应商信息管理', '1000000000', 'N', 'pages/navy/supportormanage/supportorQuery.jsp', null, 3, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1000000000', '采购项目管理', '-1', 'Y', null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1100000000', '采购项目导入', '1000000000', 'Y', 'pages/navy/importmanage/import.jsp', null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1200000000', '采购项目信息管理', '1000000000', 'Y', 'pages/navy/importmanage/importDataQuery.jsp', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('1300000000', '采购项目汇总分析', '1000000000', 'Y', 'pages/navy/importmanage/importQueryByUnit.jsp', null, 5, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2000000000', '系统维护', '-1', 'Y', null, null, 3, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2100000000', '计划类别维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=1', null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('2200000000', '采购机构维护', '2000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=2', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3000000000', '供应商管理', '-1', 'Y', null, null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3500000000', '经济性质维护', '3000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=14', null, 5, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3600000000', '服务机构类型维护', '3000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=17', null, 6, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3700000000', '运输车类型维护', '3000000000', 'Y', 'pages/dict/dictQuery.jsp?typeid=18', null, 7, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3100000000', '供应商导入', '3000000000', 'Y', 'pages/navy/supmanage/supImport.jsp', null, 1, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3200000000', '供应商查询', '3000000000', 'Y', 'pages/navy/supmanage/supSupportorQuery.jsp', null, 2, null, null, null, null, null, null, null, null, null, null, null, null);
insert into T_FUNCTION (FUNCTION_ID, FUNCTION_NAME, SUPER_FUNCTION_ID, VALIDATED, FUNCTION_URL, FUNCTION_TYPE, FUNCTION_ORDER, REMARK, CREATOR_ID, CREATOR, CREATE_DATE, OPERATOR_ID, OPERATOR, OPDATE, EXPINFOA, EXPINFOB, EXPINFOC, EXPINFOD, EXPINFOE)
values ('3400000000', '产品编目维护', '3000000000', 'Y', 'pages/dict/supDictQuery.jsp?typeid=15&fathercode=-1', null, 4, null, null, null, null, null, null, null, null, null, null, null, null);
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
values ('10000000', '390000000', '熊助理', 'xiong', 'xiong', 'e10adc3949ba59abbe56e057f20f883e', null, 'Y', null, null, null, null, null, null, null, null, null, null, null);
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
