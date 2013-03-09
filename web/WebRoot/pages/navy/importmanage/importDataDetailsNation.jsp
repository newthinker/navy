<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
	
	List typeList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (typeList != null && typeList.size() > 0) {
		dto = (DTO) typeList.get(0);
	}
	
	String src = request.getParameter("src");
	String supid = request.getParameter("supid");
	String url = "";
	String service = "ImportQueryService";
	if (src.equals("manage")) {
		url = "/pages/navy/importmanage/importDataQuery.jsp";
	} else if (src.equals("query")) {
		url = "/pages/navy/importmanage/importQuery.jsp";
	} else if (src.equals("supportor")) {
		url = "/pages/navy/supportormanage/supportorDetails.jsp";
		service = "SupportorDetailService";
	} else {
		url = "/pages/navy/importmanage/importQuery.jsp";
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
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
	
	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;" scroll="yes">
		<form action="upload" method="post" enctype="multipart/form-data">
			<jsp:include page="importDataQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= supid %>">
			
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="tbl_search2_free">
				<tr>
					<td colspan="4">
						<div id="site">
							当前位置：
							采购项目信息管理&gt;&gt;
							<span>采购项目信息查看</span>
						</div>
					</td>
				</tr>
				<tr>
					<th width="15%">
						计划类别
					</th>
					<td width="30%">
						<%= dto.getString("TYPENAME") == null ? "&nbsp;" : dto.getString("TYPENAME") %>
					</td>
					<th width="15%">
						计划年度
					</th>
					<td width="35%">
						<%= dto.getString("IMPORTYEAR") == null ? "&nbsp;" : dto.getString("IMPORTYEAR") %>
					</td>
				</tr>
				<tr>
					<th>
						采购计划
					</th>
					<td>
						<a href="pages/navy/importmanage/images.jsp?importid=<%= dto.getString("IMPORTID") %>&typeid=<%= dto.getString("PLANID") %>&type=PLAN" class="link_blue_table" target="_blank"><%= dto.getString("PLAN") == null ? "" : dto.getString("PLAN") %></a>&nbsp;
					</td>
					<th>
						计划下达时间
					</th>
					<td>
						<%= dto.getDate("PLANDATE") == null ? "&nbsp;" : fmtDate.format(dto.getDate("PLANDATE")) %>
					</td>
				</tr>
				<tr>
					<th>
						采购方式
					</th>
					<td>
						<%= dto.getString("MODENAME") == null ? "&nbsp;" : dto.getString("MODENAME") %>
					</td>
					<th>
						事业部门
					</th>
					<td>
						<%= dto.getString("DEPT") == null ? "&nbsp;" : dto.getString("DEPT") %>
					</td>
				</tr>
				<tr>
					<th>
						专业类别
					</th>
					<td>
						<%= dto.getString("CLASSNAME") == null ? "&nbsp;" : dto.getString("CLASSNAME") %>
					</td>
					<th>
						采购机构
					</th>
					<td>
						<%= dto.getString("UNIT") == null ? "&nbsp;" : dto.getString("UNIT") %>
					</td>
				</tr>
				<tr>
					<th>
						采购项目名称
					</th>
					<td>
						<%= dto.getString("PROJECT") == null ? "&nbsp;" : dto.getString("PROJECT") %>
					</td>
					<th>
						预算金额(万元)
					</th>
					<td>
						<%= dto.getNumber("BUDGET") == null ? "&nbsp;" : dto.getNumber("BUDGET").doubleValue() %>
					</td>
				</tr>
				<tr>
					<th>
						采购合同
					</th>
					<td>
						<a href="pages/navy/importmanage/images.jsp?importid=<%= dto.getString("IMPORTID") %>&typeid=<%= dto.getString("COMPACTID") %>&type=COMPACT" class="link_blue_table" target="_blank"><%= dto.getString("COMPACT") == null ? "" : dto.getString("COMPACT") %></a>&nbsp;
					</td>
					<th>
						合同签订时间
					</th>
					<td>
						<%= dto.getDate("COMPACTDATE") == null ? "&nbsp;" : fmtDate.format(dto.getDate("COMPACTDATE")) %>
					</td>
				</tr>
				<tr>
					<th>
						交货期限
					</th>
					<td>
						<%= dto.getDate("DELIVERYDATE") == null ? "&nbsp;" : fmtDate.format(dto.getDate("DELIVERYDATE")) %>
					</td>
					<th>
						合同金额
					</th>
					<td>
						<%= dto.getNumber("COMPACTMONEY") == null ? "&nbsp;" : dto.getNumber("COMPACTMONEY").doubleValue() %>
					</td>
				</tr>
				<tr>
					<th>
						折合美元(万美元)
					</th>
					<td>
						<%= dto.getNumber("DOLLAR") == null ? "&nbsp;" : dto.getNumber("DOLLAR").doubleValue() %>
					</td>
					<th>
						折合人民币(万元)
					</th>
					<td>
						<%= dto.getNumber("RMB") == null ? "&nbsp;" : dto.getNumber("RMB").doubleValue() %>
					</td>
				</tr>
				<tr>
					<th>
						设备生产厂家
					</th>
					<td>
						<%= dto.getString("PRODUCTOR") == null ? "&nbsp;" : dto.getString("PRODUCTOR") %>
					</td>
					<th>
						供应商
					</th>
					<td>
						<%= dto.getString("SUPPORTOR") == null ? "&nbsp;" : dto.getString("SUPPORTOR") %>
					</td>
				</tr>
				<tr>
					<th>
						供应商注册地点
					</th>
					<td>
						<%= dto.getString("SUPPORTORADDR") == null ? "&nbsp;" : dto.getString("SUPPORTORADDR") %>
					</td>
					<th>
						存放类型
					</th>
					<td>
						<%= dto.getString("STORETYPE") == null ? "&nbsp;" : dto.getString("STORETYPE") %>
					</td>
				</tr>
				<tr>
					<th>
						存放地点
					</th>
					<td>
						<%= dto.getString("STOREADDR") == null ? "&nbsp;" : dto.getString("STOREADDR") %>
					</td>
				
					<th>
						调用时间
					</th>
					<td>
						<%= dto.getDate("USEDATE") == null ? "&nbsp;" : fmtDate.format(dto.getDate("USEDATE")) %>
					</td>
				</tr>
				<tr>
					<th>
						调用单位
					</th>
					<td>
						<%= dto.getString("USEUNIT") == null ? "&nbsp;" : dto.getString("USEUNIT") %>
					</td>
					<th>
						使用情况
					</th>
					<td>
						<%= dto.getString("USESTATE") == null ? "&nbsp;" : dto.getString("USESTATE") %>
					</td>
				</tr>
				<tr>
					<th>
						装备图片
					</th>
					<td>
						<a href="pages/navy/importmanage/images.jsp?importid=<%= dto.getString("IMPORTID") %>&typeid=<%= dto.getString("IMAGE") %>&type=IMAGE" class="link_blue_table" target="_blank"><%= dto.getString("PROJECT") == null ? "" : dto.getString("PROJECT") %></a>&nbsp;
					</td>
					<th>
						&nbsp;
					</th>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<div class="btu">
							<input type="button" name="back" id="button" value="返 回" class="btu_input" style="width:80px"
								onclick="submit_form('Navy', 'NavyManage', '<%= service %>', '<%= url %>');" />
						</div>
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
		</script>
	</body>
</html>