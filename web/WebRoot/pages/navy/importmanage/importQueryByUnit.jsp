<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	DecimalFormat fmtNumber = new DecimalFormat("0.00");
	
	List result = resp.getDto().getList("RESULT");
	
	String downloadurl = "";
	if (resp.getDto().get("DOWNLOAD") != null) {
		String download = (String)resp.getDto().get("DOWNLOAD");
		String downloadFilename = (String)resp.getDto().get("DOWNLOAD_FILENAME");
		downloadurl = "download?download=" + download + "&filename=" + downloadFilename;
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
		
		<script type="text/javascript">
			function SYNC_Roll(){
				DataGroup2.style.posTop=-DataFrame3.scrollTop
			}
		</script>
	</head>
	
	<body  style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;"
		onload="init('Navy','NavyManage','ImportQueryByUnitService','/pages/navy/importmanage/importQueryByUnit.jsp');">
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
		
			<center>
				<table width="100%" height="100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top" height="1">
							<div id="site">&nbsp;当前位置：采购项目按单位统计</div>
						</td>
					</tr>
					<tr>
						<td valign="top" height="1">
							<jsp:include page="importQueryByUnitParam.jsp?mode=show"></jsp:include>
						</td>
					</tr>
					<tr>
						<td valign="top" height="25">
							<div id="btu_new">
								<img src="resources/images/common/btn_search.gif" alt=" " width="62" height="22"
									onclick="submit_form('Navy','NavyManage','ImportQueryByUnitService','/pages/navy/importmanage/importQueryByUnit.jsp');" />
								<img src="resources/images/common/btn_excle.gif" width="81" height="22"
									onclick="submit_form('Navy','NavyManage','ImportQueryByUnitExportService','/pages/navy/importmanage/importQueryByUnit.jsp');" /> 
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top">
							<table border="0" cellpadding="0" cellspacing="0"
								height="100%" width="100%">
								<tr>
									<td valign="top" height="35" width="100%">
										<table border="0" cellpadding="0" cellspacing="0"
											height="100%" width="100%">
											<tr>
												<td rowspan="3" width="30%" align="center" class="title3">
													<div style="width:100%">申请进口单位名称</div>
												</td>
												<td colspan="2" width="35%" align="center">
													<div class="title" style="width:100%">军事装备免税</div>
												</td>
												<td colspan="2" align="center">
													<div class="title" style="width:100%">军事装备免税审批</div>
												</td>
												<td rowspan="3" width="12" align="center" class="title3">
													<div style="width:100%">&nbsp;</div>
												</td>
											</tr>
											<tr>
												<td width="15%" align="center"><div class="title" style="width:100%">进口</div></td>
												<td width="20%" align="center"><div class="title" style="width:100%">进口金额</div></td>
												<td width="15%" align="center"><div class="title" style="width:100%">进口</div></td>
												<td align="center"><div class="title" style="width:100%">进口金额</div></td>
											</tr>
											<tr>
												<td width="15%" align="center"><div class="title" style="width:100%">项目数</div></td>
												<td width="20%" align="center"><div class="title" style="width:100%">(美元)</div></td>
												<td width="15%" align="center"><div class="title" style="width:100%">项目数</div></td>
												<td align="center"><div class="title" style="width:100%">(美元)</div></td>
											</tr>
										</table>
									</td>
								</tr>
								<tr>
									<td valign="top" height="100%">
										<div
											style="overflow: scroll; overflow-x: hidden; width: 100%; height: 100%">
											<table border="0" cellpadding="0" cellspacing="0"
												width="100%" class="tbl">
												<%
													List typeList = resp.getDto().getList("RESULT");
													if (typeList == null) {
														typeList = new ArrayList();
													}
													
													for (int i = 0; i < typeList.size(); i ++) {
														DTO data = (DTO)typeList.get(i);
												%>
												<tr>
													<td width="30%" align="left">
														<%= data.getString("DEPTNAME") == null ? "&nbsp;" : data.getString("DEPTNAME") %>
													</td>
													<td width="15%" align="right" style="text-align:right;">
														<%= data.getLong("COUNT_DEPT") == null ? "0" : data.getLong("COUNT_DEPT") %>
													</td>
													<td width="20%" align="right" style="text-align:right;">
														<%= fmtNumber.format(data.getLong("SUM_COMPACTMONEY") == null ? 0 : data.getLong("SUM_COMPACTMONEY")) %>
													</td>
													<td width="15%" align="right" style="text-align:right;">
														<%= data.getLong("COUNTEXA_DEPT") == null ? "0" : data.getLong("COUNTEXA_DEPT") %>
													</td>
													<td width="20%" align="right" style="text-align:right;padding-right:10px;">
														<%= fmtNumber.format(data.getLong("SUMEXA_COMPACTMONEY") == null ? 0 : data.getLong("SUMEXA_COMPACTMONEY")) %>
													</td>
												</tr>
												<%
													}
												%>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="30">
							<div class="linepage">
							</div>
						</td>
					</tr>
				</table>
			</center>
		</form>
		<iframe id="download" src="<%= downloadurl %>" width="0" height="0" frameborder="0"></iframe>
	</body>
</html>