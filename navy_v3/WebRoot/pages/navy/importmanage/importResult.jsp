<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.DecimalFormat"%>
<%@ include file="../../common/init.jsp" %>

<%
	Integer count = resp.getDto().getInt("COUNT");
	Double sum = resp.getDto().getDouble("SUM");
	
	DecimalFormat dformat = new DecimalFormat("0.00");
	
	String type = request.getParameter("type");
	
	DTO query_data = resp.getRequestParam();
	if (query_data == null) {
		query_data = new DTO();
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%= base %>" target="_self">

		<title></title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		
		<style type="text/css">
			.title1 {
				font-size: 14px;
				font-weight: bold !important;
				height: 29px;
				line-height: 29px;
				vertical-align: middle;
				color: #3a637a;
				PADDING-BOTTOM: 4px;
				OVERFLOW: hidden;
				CURSOR: hand;
				WHITE-SPACE: nowrap;
			}
		</style>
		<script type="text/javascript">
			function search(val) {
				if (document.getElementById("ORDER").value != val) {
					document.getElementById("ORDER_ASC").value = "";
				}
				
				var asc = document.getElementById("ORDER_ASC").value;
				document.getElementById("ORDER").value = val;
				if (asc == "") {
					document.getElementById("ORDER_ASC").value = "true";
					document.getElementById(val + "IMG").src = "resources/images/common/tbl1_thbg_up.gif";
				} else if (asc == "true") {
					document.getElementById("ORDER_ASC").value = "false";
					document.getElementById(val + "IMG").src = "resources/images/common/tbl1_thbg_down.gif";
				} else {
					document.getElementById("ORDER_ASC").value = "";
					document.getElementById(val + "IMG").src = "resources/images/common/tbl1_thbg_order.gif";
				}
				
				submit_form('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importResult.jsp');
			}
		</script>
	</head>

	<body style="OVERFLOW:SCROLL;OVERFLOW-Y:HIDDEN"
		onload="init('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importResult.jsp');">
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="str_importid" name="str_importid" type="hidden" value="">
			<input id="str_imagetypeid" name="str_imagetypeid" type="hidden" value="">
			<input id="str_imagetype" name="str_imagetype" type="hidden" value="">
			<input id="str_supid" name="str_supid" type="hidden" value="">
			
			<input id="ORDER" name="ORDER" type="hidden" value="<%= resp.getDto().showString("ORDER") %>">
			<input id="ORDER_ASC" name="ORDER_ASC" type="hidden" value="<%= resp.getDto().showString("ORDER_ASC") %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			<input id="int_rownumber" name="int_rownumber" value="20" type="hidden">
			<input id="int_pageindex" name="int_pageindex" type="hidden">
			
			<input id="STR_QUERY_TYPECODE" name="STR_QUERY_TYPECODE" type="hidden" value="<%= query_data.showString("QUERY_TYPECODE") %>">
			<input id="STR_QUERY_IMPORTYEAR" name="STR_QUERY_IMPORTYEAR" type="hidden" value="<%= query_data.showString("QUERY_IMPORTYEAR") %>">
			<input id="STR_QUERY_UNITID" name="STR_QUERY_UNITID" type="hidden" value="<%= query_data.showString("QUERY_UNITID") %>">
			<input id="STR_QUERY_MODEID" name="STR_QUERY_MODEID" type="hidden" value="<%= query_data.showString("QUERY_MODEID") %>">
			<input id="STR_QUERY_DEPTID" name="STR_QUERY_DEPTID" type="hidden" value="<%= query_data.showString("QUERY_DEPTID") %>">
			<input id="STR_QUERY_CLASSID" name="STR_QUERY_CLASSID" type="hidden" value="<%= query_data.showString("QUERY_CLASSID") %>">
			<input id="STR_QUERY_PROJECT" name="STR_QUERY_PROJECT" type="hidden" value="<%= query_data.showString("QUERY_PROJECT") %>">
			<input id="STR_QUERY_COMPACT" name="STR_QUERY_COMPACT" type="hidden" value="<%= query_data.showString("QUERY_COMPACT") %>">
			<input id="STR_QUERY_IMPORTCLASSID" name="STR_QUERY_IMPORTCLASSID" type="hidden" value="<%= query_data.showString("QUERY_IMPORTCLASSID") %>">
			<input id="STR_QUERY_DIRECTORYID" name="STR_QUERY_DIRECTORYID" type="hidden" value="<%= query_data.showString("QUERY_DIRECTORYID") %>">
			<input id="DAT_QUERY_COMPACTDATEBEFORE" name="DAT_QUERY_COMPACTDATEBEFORE" type="hidden" value="<%= query_data.showDate("QUERY_COMPACTDATEBEFORE") %>">
			<input id="DAT_QUERY_COMPACTDATEAFTER" name="DAT_QUERY_COMPACTDATEAFTER" type="hidden" value="<%= query_data.showDate("QUERY_COMPACTDATEAFTER") %>">
	
			<table width="100%" border="0" cellpadding="0" cellspacing="0" height="100%">
				<tr>
					<td valign="top" height="35" width="100%">
						<table border="0" cellpadding="0" cellspacing="0"
							height="100%" width="100%">
							<tr>
								<th align="left">
									<div class="title" style="width:50px">序号</div>
								</th>
								<th onclick="search('PROJECT')" align="left">
									<div class="title" style="width:200px">
										<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" class="title1">
											<tr>
												<td align="left" valign="middle" class="title1">采购项目名称</td>
												<td width="15" align="right" valign="middle"><img id="PROJECTIMG" 
													src="resources/images/common/tbl1_thbg_order.gif" border="0" width="100%" height="100%">
												</td>
											</tr>
										</table>
									</div>
								</th>
								<th align="left">
									<div class="title" style="width:100px">计划类别</div>
								</th>
								<th align="left" onclick="search('IMPORT_YEAR')">
									<div class="title" style="width:105px">
										<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" class="title1">
											<tr>
												<td align="left" valign="middle" class="title1">计划年度</td>
												<td width="15" align="right" valign="middle"><img id="IMPORT_YEARIMG" 
													src="resources/images/common/tbl1_thbg_order.gif" border="0" width="100%" height="100%">
												</td>
											</tr>
										</table>
									</div>
								</th>
								<th align="left">
									<div class="title" style="width:200px">采购计划</div>
								</th>
								<th align="left" onclick="search('PLAN_DATE')">
									<div class="title" style="width:120px">
										<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" class="title1">
											<tr>
												<td align="left" valign="middle" class="title1">计划下达时间</td>
												<td width="15" align="right" valign="middle"><img id="PLAN_DATEIMG" 
													src="resources/images/common/tbl1_thbg_order.gif" border="0" width="100%" height="100%">
												</td>
											</tr>
										</table>
									</div>
								</th>
								<th align="left">
									<div class="title" style="width:120px">采购方式</div>
								</th>
								<th align="left" onclick="search('DEPT')">
									<div class="title" style="width:150px">
										<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" class="title1">
											<tr>
												<td align="left" valign="middle" class="title1">事业部门</td>
												<td width="15" align="right" valign="middle"><img id="DEPTIMG" 
													src="resources/images/common/tbl1_thbg_order.gif" border="0" width="100%" height="100%">
												</td>
											</tr>
										</table>
									</div>
								</th>
								<th align="left" onclick="search('CLASS_NAME')">
									<div class="title" style="width:150px">
										<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" class="title1">
											<tr>
												<td align="left" valign="middle" class="title1">专业类别</td>
												<td width="15" align="right" valign="middle"><img id="CLASS_NAMEIMG" 
													src="resources/images/common/tbl1_thbg_order.gif" border="0" width="100%" height="100%">
												</td>
											</tr>
										</table>
									</div>
								</th>
								<th align="left" onclick="search('UNIT')">
									<div class="title" style="width:150px">
										<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" class="title1">
											<tr>
												<td align="left" valign="middle" class="title1">采购机构</td>
												<td width="15" align="right" valign="middle"><img id="UNITIMG" 
													src="resources/images/common/tbl1_thbg_order.gif" border="0" width="100%" height="100%">
												</td>
											</tr>
										</table>
									</div>
								</th>
								<th align="left">
									<div class="title" style="width:125px">预算金额(万元)</div>
								</th>
								<th align="left">
									<div class="title" style="width:200px">采购合同</div>
								</th>
								<th align="left" onclick="search('COMPACT_DATE')">
									<div class="title" style="width:120px">
										<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" class="title1">
											<tr>
												<td align="left" valign="middle" class="title1">合同签订时间</td>
												<td width="15" align="right" valign="middle"><img id="COMPACT_DATEIMG" 
													src="resources/images/common/tbl1_thbg_order.gif" border="0" width="100%" height="100%">
												</td>
											</tr>
										</table>
									</div>
								</th>
								<th align="left">
									<div class="title" style="width:120px">交货期限</div>
								</th>
								<th align="left">
									<div class="title" style="width:130px">合同金额(万元)</div>
								</th>
								<%
									if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
								%>
								<th align="left">
									<div class="title" style="width:120px;">币种</div>
								</th>
								<%
									}
								%>
								<%
									if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
								%>
								<th align="left">
									<div class="title" style="width:125px;">汇率</div>
								</th>
								<% 
									}
								%>
								<th align="left">
									<div class="title" style="width:120px">折合美元</div>
								</th>
								<th align="left">
									<div class="title" style="width:120px">折合人民币</div>
								</th>
								<th align="left">
									<div class="title" style="width:120px">节省金额</div>
								</th>
								<%
									if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
								%>
								<th align="left">
									<div class="title" style="width:250px;">委托代理公司</div>
								</th>
								<% 
									}
								%>
								<%
									if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
								%>
								<th align="left">
									<div class="title" style="width:200px;">代理协议</div>
								</th>
								<% 
									}
								%>
								<th align="left">
									<div class="title" style="width:250px">设备生产厂家</div>
								</th>
								<th align="left" onclick="search('SUPPORTOR')">
									<div class="title" style="width:250px">
										<table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" class="title1">
											<tr>
												<td align="left" valign="middle" class="title1">供应商</td>
												<td width="15" align="right" valign="middle"><img id="SUPPORTORIMG" 
													src="resources/images/common/tbl1_thbg_order.gif" border="0" width="100%" height="100%">
												</td>
											</tr>
										</table>
									</div>
								</th>
								<th align="left">
									<div class="title" style="width:250px">供应商注册地点</div>
								</th>
								<%
									if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
								%>
								<th align="left">
									<div class="title" style="width:200px;">二级归口审批文件</div>
								</th>
								<%
									}
								%>
								<%
									if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
								%>
								<th align="left" >
									<div class="title" style="width:150px;">进口类别</div>
								</th>
								<%
									}
								%>
								<%
									if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
								%>
								<th align="left">
									<div class="title" style="width:200px;">免税目录</div>
								</th>
								<%
									}
								%>
								<th align="left">
									<div class="title" style="width:180px">存放类型</div>
								</th>
								<th align="left">
									<div class="title" style="width:250px">储备(存放)地点</div>
								</th>
								<th align="left">
									<div class="title" style="width:100px">调用时间</div>
								</th>
								<th align="left">
									<div class="title" style="width:250px">调用单位</div>
								</th>
								<th align="left">
									<div class="title" style="width:105px">使用情况</div>
								</th>
								<%
									if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
								%>
								<th align="left">
									<div class="title" style="width:110px;">通关日期</div>
								</th>
								<%
									}
								%>
								<td>
									<div class="title" style="width:15px">&nbsp;</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td valign="top" id="list">
						<div style="overflow:scroll;overflow-x:hidden;width:100%;height:100%;">
							<table border="0" cellpadding="0" cellspacing="0" width="100%">
								<%
									List typeList = resp.getDto().getList("RESULT");
									if (typeList == null) {
										typeList = new ArrayList();
									}
									
									for (int i = 0; i < typeList.size(); i ++) {
										DTO data = (DTO)typeList.get(i);
								%>
								<tr>
									<td class="tbl_td_left" width="50px" height="30">
										<%= i + 1 + pages.getRowNumber() * (pages.getPageIndex() - 1) %>
									</td>
									<td class="tbl_td_left" width="200px">
										<a href="javascript:window.parent.document.getElementById('str_importid').value='<%= data.getString("IMPORTID")  %>';window.parent.submit_form('Navy', 'NavyManage', 'ImportQueryByIDService', '/pages/navy/importmanage/importDataDetailsIndex.jsp?src=query');" class="link_blue_table"><%= data.getString("PROJECT") == null ? "" : data.getString("PROJECT") %></a>&nbsp;
										<%
											Date passdate = data.getDate("PASSDATE");
											if (passdate != null) {
												Calendar c = Calendar.getInstance();
												c.setTime(passdate);
												c.add(Calendar.YEAR, 5);
												Date now = new Date();
												passdate = c.getTime();
												c.setTime(now);
												c.add(Calendar.MONTH, -1);
												
												if (passdate.after(now)) {
										%>
													&nbsp;&nbsp;&nbsp;<span style="color:red;">已过期</span>
										<%
												} else if (passdate.after(c.getTime())) {
										%>
													&nbsp;&nbsp;&nbsp;<span style="color:red;">即将过期</span>
										<%
												}
											}
										%>
									</td>
									<td class="tbl_td_left" width="100px">
										<%= data.getString("TYPENAME") == null ? "&nbsp;" : data.getString("TYPENAME") %>
									</td>
									<td class="tbl_td_left" width="100px">
										<%= data.getString("IMPORTYEAR") == null ? "&nbsp;" : data.getString("IMPORTYEAR") %>
									</td>
									<td class="tbl_td_left" width="200px">
										<a href="pages/navy/importmanage/images.jsp?importid=<%= data.getString("IMPORTID") %>&typeid=<%= data.getString("PLANID") %>&type=PLAN" class="link_blue_table" target="_blank"><%= data.getString("PLAN") == null ? "" : data.getString("PLAN") %></a>&nbsp;
									</td>
									<td class="tbl_td_left" width="120px">
										<%= data.showDate("PLANDATE", "&nbsp;") %>
									</td>
									<td class="tbl_td_left" width="120px">
										<%= data.getString("MODENAME") == null ? "&nbsp;" : data.getString("MODENAME") %>
									</td>
									<td class="tbl_td_left" width="150px">
										<%= data.getString("DEPT") == null ? "&nbsp;" : data.getString("DEPT") %>
									</td>
									<td class="tbl_td_left" width="150px">
										<%= data.getString("CLASSNAME") == null ? "&nbsp;" : data.getString("CLASSNAME") %>
									</td>
									<td class="tbl_td_left" width="150px">
										<%= data.getString("UNIT") == null ? "&nbsp;" : data.getString("UNIT") %>
									</td>
									<td class="tbl_td_right" width="120px">
										<%= data.getNumber("BUDGET") == null ? "&nbsp;" : dformat.format(data.getNumber("BUDGET").doubleValue()) %>
									</td>
									<td class="tbl_td_left" width="200px">
										<a href="pages/navy/importmanage/images.jsp?importid=<%= data.getString("IMPORTID") %>&typeid=<%= data.getString("COMPACTID") %>&type=COMPACT" class="link_blue_table" target="_blank"><%= data.getString("COMPACT") == null ? "" : data.getString("COMPACT") %></a>&nbsp;
									</td>
									<td class="tbl_td_left" width="120px">
										<%= data.showDate("COMPACTDATE", "&nbsp;") %>
									</td>
									<td class="tbl_td_left" width="120px">
										<%= data.showDate("DELIVERYDATE", "&nbsp;") %>
									</td>
									<td class="tbl_td_right" width="120px">
										<%= data.getNumber("COMPACTMONEY") == null ? "&nbsp;" : dformat.format(data.getNumber("COMPACTMONEY").doubleValue()) %>
									</td>
									<%
										if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
									%>
									<td class="tbl_td_left" width="120px">
										<%= data.getString("CURRENCY") == null ? "&nbsp;" : data.getString("CURRENCY") %>
									</td>
									<% 
										} 
									%>
									<%
										if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
									%>
									<td class="tbl_td_right" width="120px">
										<%= data.getNumber("RATE") == null ? "&nbsp;" : data.getNumber("RATE").doubleValue() %>
									</td>
									<% 
										} 
									%>
									<td class="tbl_td_right" width="120px">
										<%= data.getNumber("DOLLAR") == null ? "&nbsp;" : dformat.format(data.getNumber("DOLLAR").doubleValue()) %>
									</td>
									<td class="tbl_td_right" width="120px">
										<%= data.getNumber("RMB") == null ? "&nbsp;" : dformat.format(data.getNumber("RMB").doubleValue()) %>
									</td>
									<td class="tbl_td_right" width="120px">
										<%= data.getNumber("ECONOMIZE") == null ? "&nbsp;" : dformat.format(data.getNumber("ECONOMIZE").doubleValue()) %>
									</td>
									<%
										if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
									%>
									<td class="tbl_td_left" width="250px">
										<%= data.getString("AGENT") == null ? "&nbsp;" : data.getString("AGENT") %>
									</td>
									<% 
										} 
									%>
									<%
										if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
									%>
									<td class="tbl_td_left" width="200px">
										<a href="pages/navy/importmanage/images.jsp?importid=<%= data.getString("IMPORTID") %>&typeid=<%= data.getString("AGREEID") %>&type=AGREE" class="link_blue_table" target="_blank"><%= data.getString("AGREE") == null ? "" : data.getString("AGREE") %></a>&nbsp;
									</td>
									<% 
										} 
									%>
									<td class="tbl_td_left" width="250px">
										<%= data.getString("PRODUCTOR") == null ? "&nbsp;" : data.getString("PRODUCTOR") %>
									</td>
									<td class="tbl_td_left" width="250px">
										<a href="javascript:window.parent.showSupportor('<%= data.getString("SUPPORTORID") %>')" class="link_blue_table"><%= data.getString("SUPPORTOR") == null ? "&nbsp;" : data.getString("SUPPORTOR") %></a>
									</td>
									<td class="tbl_td_left" width="250px">
										<%= data.getString("SUPPORTORADDR") == null ? "&nbsp;" : data.getString("SUPPORTORADDR") %>
									</td>
									<%
										if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
									%>
									<td class="tbl_td_left" width="200px">
										<a href="pages/navy/importmanage/images.jsp?importid=<%= data.getString("IMPORTID") %>&typeid=<%= data.getString("EXAMINEID") %>&type=EXAMINE" class="link_blue_table" target="_blank"><%= data.getString("EXAMINENO") == null ? "" : data.getString("EXAMINENO") %></a>&nbsp;
									</td>
									<% 
										} 
									%>
									<%
										if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
									%>
									<td class="tbl_td_left" width="150px">
										<%= data.getString("IMPORTCLASS") == null ? "&nbsp;" : data.getString("IMPORTCLASS") %>
									</td>
									<% 
										} 
									%>
									<%
										if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
									%>
									<td class="tbl_td_left" width="200px">
										<%= data.getString("DIRECTORY") == null ? "&nbsp;" : data.getString("DIRECTORY") %>
									</td>
									<% 
										} 
									%>
									<td class="tbl_td_left" width="200px">
										<%= data.getString("STORETYPE") == null ? "&nbsp;" : data.getString("STORETYPE") %>
									</td>
									<td class="tbl_td_left" width="250px">
										<%= data.getString("STOREADDR") == null ? "&nbsp;" : data.getString("STOREADDR") %>
									</td>
									<td class="tbl_td_left" width="100px">
										<%= data.showDate("USEDATE", "&nbsp;") %>
									</td>
									<td class="tbl_td_left" width="250px">
										<%= data.getString("USEUNIT") == null ? "&nbsp;" : data.getString("USEUNIT") %>
									</td>
									<td class="tbl_td_left" width="100px">
										<%= data.getString("USESTATE") == null ? "&nbsp;" : data.getString("USESTATE") %>
									</td>
									<%
										if (!query_data.showString("QUERY_TYPECODE").equals("110000000")) {
									%>
									<td class="tbl_td_left" width="100px">
										<%= data.showDate("PASSDATE", "&nbsp;") %>
									</td>
									<% 
										} 
									%>
								</tr>
								<%
									}
								%>
							</table>
						</div>
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			var val = document.getElementById("ORDER").value;
			if (val != null && val != "") {
				var asc = document.getElementById("ORDER_ASC").value;
				if (asc == "true") {
					document.getElementById(val + "IMG").src = "resources/images/common/tbl1_thbg_up.gif";
				} else if (asc == "false") {
					document.getElementById(val + "IMG").src = "resources/images/common/tbl1_thbg_down.gif";
				} else {
					document.getElementById(val + "IMG").src = "resources/images/common/tbl1_thbg_order.gif";
				}
			}
			
			window.parent.document.getElementById("count").innerText = <%= count == null ? 0 : count %>;
			window.parent.document.getElementById("sum").innerText = <%= sum == null ? 0 : sum %>;
			
			if ("<%= type %>" != "null" && "<%= type %>" != "") {
				document.getElementById("STR_QUERY_TYPECODE").value = "<%= type %>";
			}
		</script>
	</body>
</html>
