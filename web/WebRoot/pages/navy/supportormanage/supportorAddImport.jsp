<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	List dictlist = (List)resp.getDto().getSelectItems();
	
	if (dictlist == null) {
		dictlist = new ArrayList();
		
		DTO dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
	}
	
	DTO type = (DTO)dictlist.get(0);
	DTO bank = (DTO)dictlist.get(1);
	DTO credit = (DTO)dictlist.get(2);
	DTO economy = (DTO)dictlist.get(3);

	List typeList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (typeList != null && typeList.size() > 0) {
		dto = (DTO) typeList.get(0);
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
		
		<title></title>
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
				
				obj = document.getElementById("STR_ADDRESS");
				if (!check_input(obj, false, 0, null, null, "注册地址")) {
					return false;
				}
				
				obj = document.getElementById("STR_LICMAINOPT");
				if (!check_input(obj, true, 0, 1, 2000, "经营范围")) {
					return false;
				}
				
				obj = document.getElementById("STR_MANUFACTURERPERFORMANCE");
				if (!check_input(obj, true, 0, 1, 2000, "国内供货业绩")) {
					return false;
				}
				
				obj = document.getElementById("STR_MANUFACTURERSUMMARY");
				if (!check_input(obj, true, 0, 1, 2000, "企业简介")) {
					return false;
				}
				
				obj = document.getElementsByName("prod_class");
				var prod_class = "";
				for (var i = 0; i < obj.length; i ++) {
					if (obj[i].checked) {
						prod_class = prod_class + "1";
					} else {
						prod_class = prod_class + "0";
					}
				}
				
				document.getElementById("STR_PRODUCTSCLASS").value = prod_class;
				
				return true;
			}
		</script>
	</head>
	
	<body scroll="yes"
		style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<jsp:include page="supportorQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<input id="STR_TYPE" name="STR_TYPE" type="hidden" />
			<input id="STR_PRODUCTSCLASS" name="STR_PRODUCTSCLASS" type="hidden" value="">
			
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
								<th width="15%">
									企业名称
								</th>
								<td width="35%">
									<input type="text" name="STR_SUPENNAME" id="STR_SUPENNAME"
										class="searchTbl_input" value="<%= dto.getString("SUPENNAME") == null ? "" : dto.getString("SUPENNAME") %>" />
									<span style="color:red;">*</span>
								</td>
								<th>
									供应商类别
								</th>
								<td>
									<select name="STR_TYPECODE" id="STR_TYPECODE" style="width:200px;"
										onchange="setSelectLabel('STR_TYPE', this)">
										<option value="">-请选择-</option>
										<%
											for (int i = 0; i < type.getList("RESULT").size(); i ++) {
												DTO typedto = (DTO)type.getList("RESULT").get(i);
												if (typedto.getString("RELEVANCECODE")!=null) {
													if (!typedto.getString("RELEVANCECODE").equals("000000000")) {
										%>
										<option value="<%= typedto.getString("DICTCODE") %>"><%= typedto.getString("DICTNAME") %></option>
										<%
													}
												}
											}
										%>
									</select>
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th width="15%">
									中文译名
								</th>
								<td width="35%">
									<input type="text" name="STR_SUPNAME" id="STR_SUPNAME"
										class="searchTbl_input" value="<%= dto.getString("SUPNAME") == null ? "" : dto.getString("SUPNAME") %>" />
									<span style="color:red;">*</span>
								</td>
								<th width="15%">
									法定代表人
								</th>
								<td width="35%">
									<input type="text" name="STR_CORPORATION" id="STR_CORPORATION"
										class="searchTbl_input" value="<%= dto.getString("CORPORATION") == null ? "" : dto.getString("CORPORATION") %>" />
								</td>
							</tr>
							<tr>
								<th>
									企业注册地址
								</th>
								<td>
									<input type="text" name="STR_ADDRESS" id="STR_ADDRESS"
										class="searchTbl_input" value="<%= dto.getString("ADDRESS") == null ? "" : dto.getString("ADDRESS") %>" />
									<span style="color:red;">*</span>
								</td>
								<th>
									邮政编码
								</th>
								<td>
									<input type="text" name="STR_POSTCODE" id="STR_POSTCODE"
										class="searchTbl_input" value="<%= dto.getString("POSTCODE") == null ? "" : dto.getString("POSTCODE") %>" />
								</td>
							</tr>
							<tr>
								<th>
									所在地址
								</th>
								<td>
									<input type="text" name="STR_LOCATION" id="STR_LOCATION"
										class="searchTbl_input" value="<%= dto.getString("LOCATION") == null ? "" : dto.getString("LOCATION") %>" />
									<span style="color:red;">*</span>
								</td>
								<th>
									位置
								</th>
								<td>
									经度：
									<input type="text" name="STR_LONGITUDE" id="STR_LONGITUDE" style="width:55px"
										class="searchTbl_input" value="<%= dto.showString("LONGITUDE") %>" />
									&nbsp;
									纬度：
									<input type="text" name="STR_LATITUDE" id="STR_LATITUDE" style="width:55px"
										class="searchTbl_input" value="<%= dto.showString("LATITUDE") %>" />
								</td>
							</tr>
							<tr>
								<th width="15%">
									注册号
								</th>
								<td width="35%">
									<input type="text" name="STR_LICNO" id="STR_LICNO"
										class="searchTbl_input" value="<%= dto.getString("LICNO") == null ? "" : dto.getString("LICNO") %>" />
								</td>
								<th width="15%">
									发证机关
								</th>
								<td width="35%">
									<input type="text" name="STR_LICORG" id="STR_LICORG"
										class="searchTbl_input" value="<%= dto.getString("LICORG") == null ? "" : dto.getString("LICORG") %>" />
								</td>
							</tr>
							<tr>
								<th width="15%">
									经营产品大类
								</th>
								<td colspan="3">
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;机械设备&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;电子设备&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;电子元器件&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;仪器仪表&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;航空器材&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;船舶器材&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;运输工具&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;医疗器材&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;通信设备&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;计算机及外设&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;音像设备&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;技术资料及软件&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" type="checkbox">&nbsp;原材料&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									经营范围
								</th>
								<td colspan="3">
									<textarea name="STR_LICMAINOPT" id="STR_LICMAINOPT" rows="5" cols="10"><%= dto.getString("LICMAINOPT") == null ? "" : dto.getString("LICMAINOPT") %></textarea>
									<br />(可填写2000个英文字符或1000个中文字符)
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td colspan="3" height="5px">
					</td>
				</tr>
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">生产厂商</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="15%">
									生产厂商名称
								</th>
								<td width="35%">
									<input type="text" name="STR_MANUFACTURER" id="STR_MANUFACTURER"
										class="searchTbl_input" value="<%= dto.showString("MANUFACTURER") %>" />
								</td>
								<th width="15%">
									联系人
								</th>
								<td width="35%">
									<input type="text" name="STR_MANUFACTURERCONTACT" id="STR_MANUFACTURERCONTACT"
										class="searchTbl_input" value="<%= dto.showString("MANUFACTURERCONTACT") %>" />
								</td>
							</tr>
							<tr>
								<th>
									联系电话
								</th>
								<td>
									<input type="text" name="STR_MANUFACTURERPHONE" id="STR_MANUFACTURERPHONE"
										class="searchTbl_input" value="<%= dto.showString("MANUFACTURERPHONE") %>" />
								</td>
								<th>
									传真电话
								</th>
								<td>
									<input type="text" name="STR_MANUFACTURERFAX" id="STR_MANUFACTURERFAX"
										class="searchTbl_input" value="<%= dto.showString("MANUFACTURERFAX") %>" />
								</td>
							</tr>
							<tr>
								<th>
									电子邮箱
								</th>
								<td>
									<input type="text" name="STR_MANUFACTUREREMAIL" id="STR_MANUFACTUREREMAIL"
										class="searchTbl_input" value="<%= dto.showString("MANUFACTUREREMAIL") %>" />
								</td>
								<th>
									企业网址
								</th>
								<td>
									<input type="text" name="STR_NETADDR" id="STR_NETADDR"
										class="searchTbl_input" value="<%= dto.showString("NETADDR") %>" />
								</td>
							</tr>
							<tr>
								<th>
									国内供货业绩
								</th>
								<td colspan="3">
									<textarea name="STR_MANUFACTURERPERFORMANCE" id="STR_MANUFACTURERPERFORMANCE" rows="5" cols="10"><%= dto.showString("MANUFACTURERPERFORMANCE") %></textarea>
									<br />(可填写2000个英文字符或1000个中文字符)
								</td>
							</tr>
							<tr>
								<th>
									企业简介
								</th>
								<td colspan="3">
									<textarea name="STR_MANUFACTURERSUMMARY" id="STR_MANUFACTURERSUMMARY" rows="5" cols="10"><%= dto.showString("MANUFACTURERSUMMARY") %></textarea>
									<br />(可填写2000个英文字符或1000个中文字符)
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="btu">
				<input type="button" name="save" value="保 存" class="btu_input"
					onclick="if (checkinput()) submit_form('Navy', 'NavyManage', 'SupportorAddService', '/pages/navy/supportormanage/supportorAddImport.jsp');" />
				<input type="button" name="back" id="button" value="返 回" class="btu_input"
					onclick="window.parent.complete();" />
			</div>
		</form>
		<script type="text/javascript">
			setSelect("STR_TYPECODE", "<%= dto.getString("TYPECODE") == null ? "" : dto.getString("TYPECODE") %>");
			
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("保存成功！");
				window.parent.complete();
			<% 
				}
			%>
			
			if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
				document.getElementById("str_supid").value = "-1";
				submit_form('Navy', 'NavyManage', 'SupportorQueryByIDService', '/pages/navy/supportormanage/supportorAddImport.jsp');
			}
		</script>
	</body>
</html>