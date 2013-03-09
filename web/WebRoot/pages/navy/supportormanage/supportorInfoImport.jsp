<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ include file="../../common/init.jsp" %>
<%
	List typeList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (typeList != null && typeList.size() > 0) {
		dto = (DTO) typeList.get(0);
	}
	
	String prodclass = dto.showString("PRODUCTSCLASS", "0000000000000");
	if (prodclass.length() < 13) {
		prodclass += "0000000000000";
		prodclass = prodclass.substring(0, 12);
	}
	
	String src = request.getParameter("src");
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
		</script>
	</head>
	
	<body scroll="yes"
		style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<jsp:include page="supportorQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= dto.showString("SUPID") %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<input id="STR_TYPE" name="STR_TYPE" type="hidden" />
			<input id="STR_CREDIT" name="STR_CREDIT" type="hidden" />
			
			<div id="site">
				当前位置：
				供应商信息管理&gt;&gt;
				<span>供应商信息详细信息</span>
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
								<th width="15%">
									企业名称
								</th>
								<td width="35%">
									<%= dto.showString("SUPENNAME", "&nbsp;") %>
								</td>
								<th>
									供应商类别
								</th>
								<td>
									<%= dto.showString("TYPE", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th width="15%">
									中文译名
								</th>
								<td width="35%">
									<%= dto.showString("SUPNAME", "&nbsp;") %>
								</td>
								<th width="15%">
									法定代表人
								</th>
								<td width="35%">
									<%= dto.showString("CORPORATION", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									企业注册地址
								</th>
								<td>
									<%= dto.showString("ADDRESS", "&nbsp;") %>
								</td>
								<th>
									邮政编码
								</th>
								<td>
									<%= dto.showString("POSTCODE", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									所在地址
								</th>
								<td>
									<%= dto.showString("LOCATION", "&nbsp;") %>
								</td>
								<th>
									位置
								</th>
								<td>
									经度：
									<%= dto.showString("LONGITUDE", "&nbsp;") %>
									&nbsp;
									纬度：
									<%= dto.showString("LATITUDE", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th width="15%">
									注册号
								</th>
								<td width="35%">
									<%= dto.showString("LICNO", "&nbsp;") %>
								</td>
								<th width="15%">
									发证机关
								</th>
								<td width="35%">
									<%= dto.showString("LICORG", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th width="15%">
									经营产品大类
								</th>
								<td colspan="3">
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(0) == '1') ? "checked" : ""%>>&nbsp;机械设备&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(1) == '1') ? "checked" : ""%>>&nbsp;电子设备&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(2) == '1') ? "checked" : ""%>>&nbsp;电子元器件&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(3) == '1') ? "checked" : ""%>>&nbsp;仪器仪表&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(4) == '1') ? "checked" : ""%>>&nbsp;航空器材&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(5) == '1') ? "checked" : ""%>>&nbsp;船舶器材&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(6) == '1') ? "checked" : ""%>>&nbsp;运输工具&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(7) == '1') ? "checked" : ""%>>&nbsp;医疗器材&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(8) == '1') ? "checked" : ""%>>&nbsp;通信设备&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(9) == '1') ? "checked" : ""%>>&nbsp;计算机及外设&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(10) == '1') ? "checked" : ""%>>&nbsp;音像设备&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(11) == '1') ? "checked" : ""%>>&nbsp;技术资料及软件&nbsp;&nbsp;&nbsp;
									<input name="prod_class" style="border:0px;width:16px" 
										type="checkbox" onclick="this.checked=!this.checked"
										<%= (prodclass.charAt(12) == '1') ? "checked" : ""%>>&nbsp;原材料&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									经营范围
								</th>
								<td colspan="3">
									<textarea name="STR_LICMAINOPT" id="STR_LICMAINOPT" rows="5" cols="10" readonly><%= dto.showString("LICMAINOPT", "&nbsp;") %></textarea>
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
									<%= dto.showString("MANUFACTURER", "&nbsp;") %>
								</td>
								<th width="15%">
									联系人
								</th>
								<td width="35%">
									<%= dto.showString("MANUFACTURERCONTACT", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									联系电话
								</th>
								<td>
									<%= dto.showString("MANUFACTURERPHONE", "&nbsp;") %>
								</td>
								<th>
									传真电话
								</th>
								<td>
									<%= dto.showString("MANUFACTURERFAX", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									电子邮箱
								</th>
								<td>
									<%= dto.showString("MANUFACTUREREMAIL", "&nbsp;") %>
								</td>
								<th>
									企业网址
								</th>
								<td>
									<%= dto.showString("NETADDR", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									国内供货业绩
								</th>
								<td colspan="3">
									<textarea name="STR_MANUFACTURERPERFORMANCE" id="STR_MANUFACTURERPERFORMANCE" rows="5" cols="10" readonly><%= dto.showString("MANUFACTURERPERFORMANCE") %></textarea>
								</td>
							</tr>
							<tr>
								<th>
									企业简介
								</th>
								<td colspan="3">
									<textarea name="STR_MANUFACTURERSUMMARY" id="STR_MANUFACTURERSUMMARY" rows="5" cols="10" readonly><%= dto.showString("MANUFACTURERSUMMARY") %></textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="btu">
				<input type="button" name="back" id="button" value="返 回" class="btu_input"
					onclick="submit_form('Navy', 'NavyManage', 'SupportorDetailService', '/pages/navy/supportormanage/supportorDetails.jsp?src=<%= src %>');" />
			</div>
		</form>
	</body>
</html>