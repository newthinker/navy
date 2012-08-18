<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	List dictlist = (List)resp.getDto().getSelectItems();
	
	if (dictlist == null) {
		dictlist = new ArrayList();
		for (int i=0; i<7; i++) {
			DTO dto = new DTO();
			dto.setList("RESULT", new ArrayList());
			dictlist.add(dto);
		}
	}

	for (int i=dictlist.size(); i<7; i++) {
		DTO dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
	}
	
	DTO type = (DTO)dictlist.get(0);
	DTO bank = (DTO)dictlist.get(1);
	DTO credit = (DTO)dictlist.get(2);
	DTO economy = (DTO)dictlist.get(3);
	DTO saleorgtype = (DTO)dictlist.get(4);
	DTO trucktype = (DTO)dictlist.get(5);
	DTO purchasetype = (DTO)dictlist.get(6);

	DTO supportor = null;
	DTO transport = null;
	DTO highway = null;
	List typeList = (List)resp.getDto().getList("RESULT");
	if (typeList != null) {
		if (typeList.size() > 0) {
			supportor = (DTO) typeList.get(0);
		}
		if (typeList.size() > 1) {
			transport = (DTO) typeList.get(1);
		}
		if (typeList.size() > 2) {
			highway = (DTO) typeList.get(2);
		}
	}
	
	if (supportor == null) {
		supportor = new DTO();
	}
	if (transport == null) {
		transport = new DTO();
	}
	if (highway == null) {
		highway = new DTO();
	}
	
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<script language="javascript" src="<%= base %>/resources/javascript/calendar/WdatePicker.js"></script>
		<base href="<%= base %>" target="_self">

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta content="MSHTML 6.00.3790.2666" name="GENERATOR">
		
		<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		</style>
		<script language="javascript" src="resources/javascript/iOffice_Popup.js"></script>
		<script language="javascript" src="resources/javascript/hdcube.js"></script>

		<script type="text/javascript">
			function checkinput() {
				var obj = document.getElementById("STR_SUPNAME");
				if (!check_input(obj, false, 0, null, null, "供应商名称")) {
					return false;
				}
				
				obj = document.getElementById("STR_TYPECODE");
				if (!check_input(obj, false, 0, null, null, "供应商类型")) {
					return false;
				}
				
				obj = document.getElementById("DAT_CREATEDATE");
				if (!check_input(obj, false, 0, null, null, "成立时间")) {
					return false;
				}
				
				obj = document.getElementById("STR_ADDRESS");
				if (!check_input(obj, false, 0, null, null, "注册地址")) {
					return false;
				}

				obj = document.getElementById("STR_POSTCODE");
				if (!check_input(obj, true, 1, 100000, 999999, "邮编")) {
					return false;
				}
				
				obj = document.getElementById("STR_LOCATION");
				if (!check_input(obj, false, 0, null, null, "所在地址")) {
					return false;
				}

				obj = document.getElementById("STR_LONGITUDE");
				if (!check_input(obj, true, 2, -180, 180, "经度")) {
					return false;
				}

				obj = document.getElementById("STR_LATITUDE");
				if (!check_input(obj, true, 2, -90, 90, "纬度")) {
					return false;
				}

				obj = document.getElementById("STR_ACCOUNT");
				if (!check_input(obj, true, 1, null, null, "银行帐号")) {
					return false;
				}
				
				obj = document.getElementById("DOU_LICCAPITAL");
				if (!check_input(obj, true, 2, 1, 1000000000, "注册资本金")) {
					return false;
				}
				
				obj = document.getElementById("STR_SUMMARY");
				if (!check_input(obj, true, 0, 1, 2000, "供应商简介")) {
					return false;
				}
				
				obj = document.getElementById("STR_LICMAINOPT");
				if (!check_input(obj, true, 0, 1, 2000, "主要经营范围")) {
					return false;
				}
				
				obj = document.getElementById("STR_LICOTHEROPT");
				if (!check_input(obj, true, 0, 1, 2000, "兼营经营范围")) {
					return false;
				}

				obj = document.getElementById("STR_STOREHOUSEAREA");
				if (!check_input(obj, true, 2, null, null, "仓库总面积")) {
					return false;
				}

				obj = document.getElementById("STR_WAREHOUSEAREA");
				if (!check_input(obj, true, 2, null, null, "货场总面积")) {
					return false;
				}

				obj = document.getElementById("STR_DEADWEIGHT");
				if (!check_input(obj, true, 2, null, null, "载重量")) {
					return false;
				}

				obj = document.getElementById("STR_COUNT");
				if (!check_input(obj, true, 1, null, null, "运输车数量")) {
					return false;
				}

				obj = document.getElementById("STR_HIWDIS");
				if (!check_input(obj, true, 2, null, null, "高速公路入口距离")) {
					return false;
				}

				obj = document.getElementById("STR_RWDIS");
				if (!check_input(obj, true, 2, null, null, "货运站距离")) {
					return false;
				}

				obj = document.getElementById("STR_PORTDIS");
				if (!check_input(obj, true, 2, null, null, "港口距离")) {
					return false;
				}

				obj = document.getElementById("STR_APDIS");
				if (!check_input(obj, true, 2, null, null, "机场距离")) {
					return false;
				}

				return true;
			}
		</script>
	</head>
	
	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;" scroll="yes">
		<form action="system" method="post">
			<jsp:include page="supSupportorQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= supportor.showString("SUPID") %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<input id="STR_ECONOMY" name="STR_ECONOMY" type="hidden" />
			<input id="STR_TYPE" name="STR_TYPE" type="hidden" />
			<input id="STR_PURCHASETYPE" name="STR_PURCHASETYPE" type="hidden" />
			<input id="STR_BANK" name="STR_BANK" type="hidden" />
			<input id="STR_CREDIT" name="STR_CREDIT" type="hidden" />
			
			<input id="STR_TRUCKTYPE" name="STR_TRUCKTYPE" type="hidden" />
			
			<div id="site">
				当前位置：
				供应商信息管理&gt;&gt;
				<span>供应商信息新增</span>
			</div>
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td colspan="3" height="5px">
					</td>
				</tr>
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">基础信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="20%">
									供应商名称
								</th>
								<td width="30%">
									<input type="text" name="STR_SUPNAME" id="STR_SUPNAME"
										class="searchTbl_input" value="<%= supportor.getString("SUPNAME") == null ? "" : supportor.getString("SUPNAME") %>" />
									<span style="color:red;">*</span>
								</td>
								<th width="20%">
									供应商英文名称
								</th>
								<td width="30%">
									<input type="text" name="STR_SUPENNAME" id="STR_SUPENNAME"
										class="searchTbl_input" value="<%= supportor.getString("SUPENNAME") == null ? "" : supportor.getString("SUPENNAME") %>" />
								</td>
							</tr>
							<tr>
								<th>
									成立时间
								</th>
								<td>
									<input name="DAT_CREATEDATE" id="DAT_CREATEDATE" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" style="width:200px;" readonly="readonly" class="Wdate"
										value="<%= supportor.getDate("CREATEDATE") == null ? "" : fmtDate.format(supportor.getDate("CREATEDATE")) %>" />
		        					<span style="color:red;">*</span>
								</td>
								<th>
									公司简称
								</th>
								<td>
									<input type="text" name="STR_ABBREVIATION" id="STR_ABBREVIATION"
										class="searchTbl_input" value="<%= supportor.getString("ABBREVIATION") == null ? "" : supportor.getString("ABBREVIATION") %>" />
								</td>
							</tr>
							<tr>
								<th>
									注册地址
								</th>
								<td>
									<input type="text" name="STR_ADDRESS" id="STR_ADDRESS"
										class="searchTbl_input" value="<%= supportor.getString("ADDRESS") == null ? "" : supportor.getString("ADDRESS") %>" />
									<span style="color:red;">*</span>
								</td>
								<th>
									邮政编码
								</th>
								<td>
									<input type="text" name="STR_POSTCODE" id="STR_POSTCODE"
										class="searchTbl_input" value="<%= supportor.getString("POSTCODE") == null ? "" : supportor.getString("POSTCODE") %>" />
								</td>
							</tr>
							<tr>
								<th>
									所在地址
								</th>
								<td>
									<input type="text" name="STR_LOCATION" id="STR_LOCATION"
										class="searchTbl_input" value="<%= supportor.getString("LOCATION") == null ? "" : supportor.getString("LOCATION") %>" />
									<span style="color:red;">*</span>
								</td>
								<th>
									位置
								</th>
								<td>
									经度：
									<input type="text" name="STR_LONGITUDE" id="STR_LONGITUDE" style="width:55px"
										class="searchTbl_input" value="<%= supportor.showString("LONGITUDE") %>" />
									&nbsp;
									纬度：
									<input type="text" name="STR_LATITUDE" id="STR_LATITUDE" style="width:55px"
										class="searchTbl_input" value="<%= supportor.showString("LATITUDE") %>" />
								</td>
							</tr>
							<tr>
								<th>
									网址
								</th>
								<td>
									<input type="text" name="STR_NETADDR" id="STR_NETADDR"
										class="searchTbl_input" value="<%= supportor.getString("NETADDR") == null ? "" : supportor.getString("NETADDR") %>" />
								</td>
								<th>
									组织机构代码
								</th>
								<td>
									<input type="text" name="STR_ORGANIZECODE" id="STR_ORGANIZECODE"
										class="searchTbl_input" value="<%= supportor.getString("ORGANIZECODE") == null ? "" : supportor.getString("ORGANIZECODE") %>" />
								</td>
							</tr>
							<tr>
								<th>
									经济性质
								</th>
								<td>
									<select name="STR_ECONOMYID" id="STR_ECONOMYID" style="width:200px;"
										onchange="setSelectLabel('STR_ECONOMY', this)">
										<option value="">-请选择-</option>
										<%
											for (int i = 0; i < economy.getList("RESULT").size(); i ++) {
												DTO typedto = (DTO)economy.getList("RESULT").get(i);
										%>
										<option value="<%= typedto.getString("DICTCODE") %>"><%= typedto.getString("DICTNAME") %></option>
										<%
											}
										%>
									</select>
								</td>
								<th>
									供应商类型
								</th>
								<td>
									<select name="STR_TYPECODE" id="STR_TYPECODE" style="width:200px;"
										onchange="setSelectLabel('STR_TYPE', this)">
										<option value="">-请选择-</option>
										<%
											for (int i = 0; i < type.getList("RESULT").size(); i ++) {
												DTO typedto = (DTO)type.getList("RESULT").get(i);
												if (typedto.getString("RELEVANCECODE")==null || typedto.getString("RELEVANCECODE").equals("000000000")) {
										%>
										<option value="<%= typedto.getString("DICTCODE") %>"><%= typedto.getString("DICTNAME") %></option>
										<%
												}
											}
										%>
									</select>
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									采购方式
								</th>
								<td>
									<select name="STR_PURCHASETYPEID" id="STR_PURCHASETYPEID" style="width:200px;"
										onchange="setSelectLabel('STR_PURCHASETYPE', this)">
										<option value="">-请选择-</option>
										<%
											for (int i = 0; i < purchasetype.getList("RESULT").size(); i ++) {
												DTO purchasetypedto = (DTO)purchasetype.getList("RESULT").get(i);
										%>
										<option value="<%= purchasetypedto.getString("DICTCODE") %>"><%= purchasetypedto.getString("DICTNAME") %></option>
										<%
											}
										%>
									</select>
								</td>
								<th>
									是否成交
								</th>
								<td>
									<select name="STR_IFTURNOVER" id="STR_IFTURNOVER" style="width:200px;">
										<option value="是" selected>是</option>
										<option value="否">否</option>
									</select>
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									开户银行
								</th>
								<td>
									<select name="STR_BANKID" id="STR_BANKID" style="width:200px;"
										onchange="setSelectLabel('STR_BANK', this)">
										<option value="">-请选择-</option>
										<%
											for (int i = 0; i < bank.getList("RESULT").size(); i ++) {
												DTO typedto = (DTO)bank.getList("RESULT").get(i);
										%>
										<option value="<%= typedto.getString("DICTCODE") %>"><%= typedto.getString("DICTNAME") %></option>
										<%
											}
										%>
									</select>										
								</td>
								<th>
									银行账号
								</th>
								<td>
									<input type="text" name="STR_ACCOUNT" id="STR_ACCOUNT"
										class="searchTbl_input" value="<%= supportor.getString("ACCOUNT") == null ? "" : supportor.getString("ACCOUNT") %>" />
								</td>
							</tr>
							<tr>
								<th>
									信用等级
								</th>
								<td>
									<select name="STR_CREDITID" id="STR_CREDITID" style="width:200px;"
										onchange="setSelectLabel('STR_CREDIT', this)">
										<option value="">-请选择-</option>
										<%
											for (int i = 0; i < credit.getList("RESULT").size(); i ++) {
												DTO creditdto = (DTO)credit.getList("RESULT").get(i);
										%>
										<option value="<%= creditdto.getString("DICTCODE") %>"><%= creditdto.getString("DICTNAME") %></option>
										<%
											}
										%>
									</select>
								</td>
								<th>
									信用等级评定机构
								</th>
								<td>
									<input type="text" name="STR_CREDITORG" id="STR_CREDITORG"
										class="searchTbl_input" value="<%= supportor.getString("CREDITORG") == null ? "" : supportor.getString("CREDITORG") %>" />
								</td>
							</tr>
							<tr>
								<th>
									评定时间
								</th>
								<td>
									<input name="DAT_CREDITDATE" id="DAT_CREDITDATE" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" style="width:200px;" readonly="readonly" class="Wdate"
										value="<%= supportor.getDate("CREDITDATE") == null ? "" : fmtDate.format(supportor.getDate("CREDITDATE")) %>" />
								</td>
								<th>
									是否协议供应商
								</th>
								<td>
									<select name="STR_SUPTYPE" id="STR_SUPTYPE" style="width:200px;">
										<option value="是">是</option>
										<option value="否" selected>否</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>
									是否依法缴纳社会保险
								</th>
								<td>
									<select name="STR_INSURANCE" id="STR_INSURANCE" style="width:200px;">
										<option value="">-请选择-</option>
										<option value="是">是</option>
										<option value="否">否</option>
									</select>
								</td>
								<th>
									近三年有无重大违法记录
								</th>
								<td>
									<select name="STR_ILLEGAL" id="STR_ILLEGAL" style="width:200px;">
										<option value="">-请选择-</option>
										<option value="有">有</option>
										<option value="无">无</option>
									</select>
								</td>
							</tr>
							<tr>
								<th>
									供应商简介
								</th>
								<td colspan="3">
									<textarea name="STR_SUMMARY" id="STR_SUMMARY" rows="5" cols="10"><%= supportor.getString("SUMMARY") == null ? "" : supportor.getString("SUMMARY") %></textarea>
									<br />(可填写2000个英文字符或1000个中文字符)
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">法人信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="20%">
									法定代表人
								</th>
								<td width="30%">
									<input type="text" name="STR_CORPORATION" id="STR_CORPORATION"
										class="searchTbl_input" value="<%= supportor.getString("CORPORATION") == null ? "" : supportor.getString("CORPORATION") %>" />
								</td>
								<th width="20%">
									固定电话
								</th>
								<td width="30%">
									<input type="text" name="STR_CORPPHONE" id="STR_CORPPHONE"
										class="searchTbl_input" value="<%= supportor.getString("CORPPHONE") == null ? "" : supportor.getString("CORPPHONE") %>" />
								</td>
							</tr>
							<tr>
								<th>
									手机
								</th>
								<td>
									<input type="text" name="STR_CORPMOBILE" id="STR_CORPMOBILE"
										class="searchTbl_input" value="<%= supportor.getString("CORPMOBILE") == null ? "" : supportor.getString("CORPMOBILE") %>" />
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">注册联系人信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="20%">
									注册登记联系人
								</th>
								<td width="30%">
									<input type="text" name="STR_CONTACT" id="STR_CONTACT"
										class="searchTbl_input" value="<%= supportor.getString("CONTACT") == null ? "" : supportor.getString("CONTACT") %>" />
								</td>
								<th width="20%">
									固定电话
								</th>
								<td width="30%">
									<input type="text" name="STR_CONTACTPHONE" id="STR_CONTACTPHONE"
										class="searchTbl_input" value="<%= supportor.getString("CONTACTPHONE") == null ? "" : supportor.getString("CONTACTPHONE") %>" />
								</td>
							</tr>
							<tr>
								<th>
									手机
								</th>
								<td>
									<input type="text" name="STR_CONTACTMOBILE" id="STR_CONTACTMOBILE"
										class="searchTbl_input" value="<%= supportor.getString("CONTACTMOBILE") == null ? "" : supportor.getString("CONTACTMOBILE") %>" />
								</td>
								<th>
									传真
								</th>
								<td>
									<input type="text" name="STR_CONTACTFAX" id="STR_CONTACTFAX"
										class="searchTbl_input" value="<%= supportor.getString("CONTACTFAX") == null ? "" : supportor.getString("CONTACTFAX") %>" />
								</td>
							</tr>
							<tr>
								<th>
									电子邮箱
								</th>
								<td>
									<input type="text" name="STR_CONTACTEMAIL" id="STR_CONTACTEMAIL"
										class="searchTbl_input" value="<%= supportor.getString("CONTACTEMAIL") == null ? "" : supportor.getString("CONTACTEMAIL") %>" />
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">营业执照信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="20%">
									注册号
								</th>
								<td width="30%">
									<input type="text" name="STR_LICNO" id="STR_LICNO"
										class="searchTbl_input" value="<%= supportor.getString("LICNO") == null ? "" : supportor.getString("LICNO") %>" />
								</td>
								<th width="20%">
									发证机关
								</th>
								<td width="30%">
									<input type="text" name="STR_LICORG" id="STR_LICORG"
										class="searchTbl_input" value="<%= supportor.getString("LICORG") == null ? "" : supportor.getString("LICORG") %>" />
								</td>
							</tr>
							<tr>
								<th>
									注册资本金
								</th>
								<td>
									<input type="text" name="DOU_LICCAPITAL" id="DOU_LICCAPITAL"
										class="searchTbl_input" value="<%= supportor.getNumber("LICCAPITAL") == null ? supportor.showDouble("LICCAPITAL") : supportor.getNumber("LICCAPITAL").doubleValue() %>" />&nbsp;万元
								</td>
								<th>
									注册所在地
								</th>
								<td>
									<input type="text" name="STR_LICADDR" id="STR_LICADDR"
										class="searchTbl_input" value="<%= supportor.getString("LICADDR") == null ? "" : supportor.getString("LICADDR") %>" />
								</td>
							</tr>
							<tr>
								<th>
									有效期开始时间
								</th>
								<td>
									<input name="DAT_LICVALSTART" id="DAT_LICVALSTART" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" style="width:200px;" readonly="readonly" class="Wdate"
										value="<%= supportor.getDate("LICVALSTART") == null ? "" : fmtDate.format(supportor.getDate("LICVALSTART")) %>" />
								</td>
								<th>
									有效期结束时间
								</th>
								<td>
									<input name="DAT_LICVALEND" id="DAT_LICVALEND" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" style="width:200px;" readonly="readonly" class="Wdate"
										value="<%= supportor.getDate("LICVALEND") == null ? "" : fmtDate.format(supportor.getDate("LICVALEND")) %>" />
								</td>
							</tr>
							<tr>
								<th>
									最近年检时间
								</th>
								<td>
									<input name="DAT_LICEXADATE" id="DAT_LICEXADATE" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" style="width:200px;" readonly="readonly" class="Wdate"
										value="<%= supportor.getDate("LICEXADATE") == null ? "" : fmtDate.format(supportor.getDate("LICEXADATE")) %>" />
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									主要经营范围
								</th>
								<td colspan="3">
									<textarea name="STR_LICMAINOPT" id="STR_LICMAINOPT" rows="5" cols="10"><%= supportor.getString("LICMAINOPT") == null ? "" : supportor.getString("LICMAINOPT") %></textarea>
									<br />(可填写2000个英文字符或1000个中文字符)
								</td>
							</tr>
							<tr>
								<th>
									兼营经营范围
								</th>
								<td colspan="3">
									<textarea name="STR_LICOTHEROPT" id="STR_LICOTHEROPT" rows="5" cols="10"><%= supportor.getString("LICOTHEROPT") == null ? "" : supportor.getString("LICOTHEROPT") %></textarea>
									<br />(可填写2000个英文字符或1000个中文字符)
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">税务登记证(国税)</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="20%">
									登记证号
								</th>
								<td width="30%">
									<input type="text" name="STR_STATETAXNO" id="STR_STATETAXNO"
										class="searchTbl_input" value="<%= supportor.getString("STATETAXNO") == null ? "" : supportor.getString("STATETAXNO") %>" />
								</td>
								<th width="20%">
									发证机关
								</th>
								<td width="30%">
									<input type="text" name="STR_STATETAXORG" id="STR_STATETAXORG"
										class="searchTbl_input" value="<%= supportor.getString("STATETAXORG") == null ? "" : supportor.getString("STATETAXORG") %>" />
								</td>
							</tr>
							<tr>
								<th>
									有效期开始时间
								</th>
								<td>
									<input name="DAT_STATETAXVALSTART" id="DAT_STATETAXVALSTART" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" style="width:200px;" readonly="readonly" class="Wdate"
										value="<%= supportor.getDate("STATETAXVALSTART") == null ? "" : fmtDate.format(supportor.getDate("STATETAXVALSTART")) %>" />
								</td>
								<th>
									有效期结束时间
								</th>
								<td>
									<input name="DAT_STATETAXVALEND" id="DAT_STATETAXVALEND" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" style="width:200px;" readonly="readonly" class="Wdate"
										value="<%= supportor.getDate("STATETAXVALEND") == null ? "" : fmtDate.format(supportor.getDate("STATETAXVALEND")) %>" />
								</td>
							</tr>
							<tr>
								<th>
									是否依法缴纳税收
								</th>
								<td>
									<select name="STR_IFSTATETAX" id="STR_IFSTATETAX" style="width:200px;">
										<option value="">-请选择-</option>
										<option value="是">是</option>
										<option value="否">否</option>
									</select>
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">税务登记证(地税)</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="20%">
									登记证号
								</th>
								<td width="30%">
									<input type="text" name="STR_LOCALTAXNO" id="STR_LOCALTAXNO"
										class="searchTbl_input" value="<%= supportor.getString("LOCALTAXNO") == null ? "" : supportor.getString("LOCALTAXNO") %>" />
								</td>
								<th width="20%">
									发证机关
								</th>
								<td width="30%">
									<input type="text" name="STR_LOCALTAXORG" id="STR_LOCALTAXORG"
										class="searchTbl_input" value="<%= supportor.getString("LOCALTAXORG") == null ? "" : supportor.getString("LOCALTAXORG") %>" />
								</td>
							</tr>
							<tr>
								<th>
									有效期开始时间
								</th>
								<td>
									<input name="DAT_LOCALTAXVALSTART" id="DAT_LOCALTAXVALSTART" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" style="width:200px;" readonly="readonly" class="Wdate"
										value="<%= supportor.getDate("LOCALTAXVALSTART") == null ? "" : fmtDate.format(supportor.getDate("LOCALTAXVALSTART")) %>" />
								</td>
								<th>
									有效期结束时间
								</th>
								<td>
									<input name="DAT_LOCALTAXVALEND" id="DAT_LOCALTAXVALEND" style="cursor:hand;"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
										type="text" style="width:200px;" readonly="readonly" class="Wdate"
										value="<%= supportor.getDate("LOCALTAXVALEND") == null ? "" : fmtDate.format(supportor.getDate("LOCALTAXVALEND")) %>" />
								</td>
							</tr>
							<tr>
								<th>
									是否依法缴纳税收
								</th>
								<td>
									<select name="STR_IFLOCALTAX" id="STR_IFLOCALTAX" style="width:200px;">
										<option value="">-请选择-</option>
										<option value="是">是</option>
										<option value="否">否</option>
									</select>
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">仓储信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="20%">
									仓库总面积
								</th>
								<td width="30%">
									<input type="text" name="STR_STOREHOUSEAREA" id="STR_STOREHOUSEAREA"
										class="searchTbl_input" value="<%= supportor.getNumber("STOREHOUSEAREA") == null ? "" : supportor.getNumber("STOREHOUSEAREA") %>" />
								</td>
								<th width="20%">
									货场总面积
								</th>
								<td width="30%">
									<input type="text" name="STR_WAREHOUSEAREA" id="STR_WAREHOUSEAREA"
										class="searchTbl_input" value="<%= supportor.getNumber("WAREHOUSEAREA") == null ? "" : supportor.getNumber("WAREHOUSEAREA") %>" />
								</td>
							</tr>
						<!-- <tr>
								<th>
									仓库照片
								</th>
								<td>
									<input type="text" name="STR_STOREHOUSEIMAGE" id="STR_STOREHOUSEIMAGE"
										class="searchTbl_input" value="<%= supportor.getString("CORPMOBILE") == null ? "" : supportor.getString("CORPMOBILE") %>" />
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr> -->
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">运输信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="20%">
									提供运输的企业
								</th>
								<td width="30%">
									<input type="text" name="STR_COMNAME" id="STR_COMNAME"
										class="searchTbl_input" value="<%= transport.getString("COMNAME") == null ? "" : transport.getString("COMNAME") %>" />
								</td>
								<th width="20%">
									运输车类型
								</th>
								<td width="30%">
									<select name="STR_TRUCKTYPEID" id="STR_TRUCKTYPEID" style="width:200px"
										onchange="setSelectLabel('STR_TRUCKTYPE', this)">
										<option value="">-请选择-</option>
										<%
											for (int i = 0; i < trucktype.getList("RESULT").size(); i ++) {
												DTO trucktypedto = (DTO)trucktype.getList("RESULT").get(i);
										%>
										<option value="<%= trucktypedto.getString("DICTCODE") %>"><%= trucktypedto.getString("DICTNAME") %></option>
										<%
											}
										%>
									</select>
								</td>
							</tr>
							<tr>
								<th>
									载重量
								</th>
								<td>
									<input type="text" name="STR_DEADWEIGHT" id="STR_DEADWEIGHT"
										class="searchTbl_input" value="<%= transport.getDouble("DEADWEIGHT") == null ? "" : transport.getDouble("DEADWEIGHT") %>" />
								</td>
								<th>
									数量（台）
								</th>
								<td>
									<input type="text" name="STR_COUNT" id="STR_COUNT"
										class="searchTbl_input" value="<%= transport.getInt("COUNT") == null ? "" : transport.getInt("COUNT") %>" />
								</td>
							</tr>
							<tr>
								<th>
									高速公路名称
								</th>
								<td>
									<input type="text" name="STR_HIWNAME" id="STR_HIWNAME"
										class="searchTbl_input" value="<%= highway.getString("HIWNAME") == null ? "" : highway.getString("HIWNAME") %>" />
								</td>
								<th>
									高速公路编号
								</th>
								<td>
									<input type="text" name="STR_HIWID" id="STR_HIWID"
										class="searchTbl_input" value="<%= highway.getString("HIWID") == null ? "" : highway.getString("HIWID") %>" />
								</td>
							</tr>
							<tr>
								<th>
									高速公路入口名称
								</th>
								<td>
									<input type="text" name="STR_HIWIN" id="STR_HIWIN"
										class="searchTbl_input" value="<%= highway.getString("HIWIN") == null ? "" : highway.getString("HIWIN") %>" />
								</td>
								<th>
									高速公路入口编号
								</th>
								<td>
									<input type="text" name="STR_HIWINID" id="STR_HIWINID"
										class="searchTbl_input" value="<%= highway.getString("HIWINID") == null ? "" : highway.getString("HIWINID") %>" />
								</td>
							</tr>
							<tr>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
								<th>
									高速公路入口距离
								</th>
								<td>
									<input type="text" name="STR_HIWDIS" id="STR_HIWDIS"
										class="searchTbl_input" value="<%= highway.getDouble("HIWDIS") == null ? "" : highway.getDouble("HIWDIS") %>" />
								</td>
							</tr>
							<tr>
								<th>
									最近铁路货运站
								</th>
								<td>
									<input type="text" name="STR_NEARRAILWAY" id="STR_NEARRAILWAY"
										class="searchTbl_input" value="<%= transport.getString("NEARRAILWAY") == null ? "" : transport.getString("NEARRAILWAY") %>" />
								</td>
								<th>
									货运站距离
								</th>
								<td>
									<input type="text" name="STR_RWDIS" id="STR_RWDIS"
										class="searchTbl_input" value="<%= transport.getDouble("RWDIS") == null ? "" : transport.getDouble("RWDIS") %>" />
								</td>
							</tr>
							<tr>
								<th>
									最近港口
								</th>
								<td>
									<input type="text" name="STR_NEARPORT" id="STR_NEARPORT"
										class="searchTbl_input" value="<%= transport.getString("NEARPORT") == null ? "" : transport.getString("NEARPORT") %>" />
								</td>
								<th>
									港口距离
								</th>
								<td>
									<input type="text" name="STR_PORTDIS" id="STR_PORTDIS"
										class="searchTbl_input" value="<%= transport.getDouble("PORTDIS") == null ? "" : transport.getDouble("PORTDIS") %>" />
								</td>
							</tr>
							<tr>
								<th>
									最近机场
								</th>
								<td>
									<input type="text" name="STR_NEARAIRPORT" id="STR_NEARAIRPORT"
										class="searchTbl_input" value="<%= transport.getString("NEARAIRPORT") == null ? "" : transport.getString("NEARAIRPORT") %>" />
								</td>
								<th>
									机场距离
								</th>
								<td>
									<input type="text" name="STR_APDIS" id="STR_APDIS"
										class="searchTbl_input" value="<%= transport.getDouble("APDIS") == null ? "" : transport.getDouble("APDIS") %>" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">产品信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<iframe src="pages/navy/supmanage/supSupportorProdQuery.jsp?supid=<%= supportor.showString("SUPID") %>"
							frameborder="0" scrolling="no" width="100%" height="310"></iframe>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">供应商出资(股东)信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<iframe src="pages/navy/supmanage/supSupportorStockQuery.jsp?supid=<%= supportor.showString("SUPID") %>"
							frameborder="0" scrolling="no" width="100%" height="310"></iframe>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">售后服务机构信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<iframe src="pages/navy/supmanage/supSupportorSaleOrgQuery.jsp?supid=<%= supportor.showString("SUPID") %>"
							frameborder="0" scrolling="no" width="100%" height="310"></iframe>
					</td>
				</tr>
			</table>
			<div class="btu">
				<input type="button" name="save" value="保 存" class="btu_input"
					onclick="if (checkinput()) submit_form('Navy', 'NavyManage', 'SupSupportorAddService', '/pages/navy/supmanage/supSupportorAdd.jsp');" />
				<input type="button" name="back" id="button" value="返 回" class="btu_input"
					onclick="submit_form('Navy', 'NavyManage', 'SupSupportorQueryService', '/pages/navy/supmanage/supSupportorQuery.jsp');" />
			</div>
		</form>
		<script type="text/javascript">
			setSelect("STR_ECONOMYID", "<%= supportor.getString("ECONOMYID") == null ? "" : supportor.getString("ECONOMYID") %>");
			setSelect("STR_TYPECODE", "<%= supportor.getString("TYPECODE") == null ? "" : supportor.getString("TYPECODE") %>");
			setSelect("STR_PURCHASETYPEID", "<%= supportor.getString("PURCHASETYPEID") == null ? "" : supportor.getString("PURCHASETYPEID") %>");
			setSelect("STR_IFTURNOVER", "<%= supportor.getString("IFTURNOVER") == null ? "" : supportor.getString("IFTURNOVER") %>");
			setSelect("STR_BANKID", "<%= supportor.getString("BANKID") == null ? "" : supportor.getString("BANKID") %>");
			setSelect("STR_CREDITID", "<%= supportor.getString("CREDITID") == null ? "" : supportor.getString("CREDITID") %>");
			setSelect("STR_SUPTYPE", "<%= supportor.getString("SUPTYPE") == null ? "" : supportor.getString("SUPTYPE") %>");
			setSelect("STR_INSURANCE", "<%= supportor.getString("INSURANCE") == null ? "" : supportor.getString("INSURANCE") %>");
			setSelect("STR_ILLEGAL", "<%= supportor.getString("ILLEGAL") == null ? "" : supportor.getString("ILLEGAL") %>");
			setSelect("STR_IFSTATETAX", "<%= supportor.getString("IFSTATETAX") == null ? "" : supportor.getString("IFSTATETAX") %>");
			setSelect("STR_IFLOCALTAX", "<%= supportor.getString("IFLOCALTAX") == null ? "" : supportor.getString("IFLOCALTAX") %>");
			setSelect("STR_TRUCKTYPEID", "<%= transport.getString("TRUCKTYPEID") == null ? "" : transport.getString("TRUCKTYPEID") %>");
			
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("保存成功！");
				submit_form('Navy','NavyManage','SupSupportorQueryService','/pages/navy/supmanage/supSupportorQuery.jsp');
			<% 
				}
			%>
			
			if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
				document.getElementById("str_supid").value = "-1";
				submit_form('Navy', 'NavyManage', 'SupSupportorQueryByIDService', '/pages/navy/supmanage/supSupportorAdd.jsp');
			}
		</script>
	</body>
</html>