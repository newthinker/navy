<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../../common/init.jsp" %>
<%
	String supid = request.getParameter("supid");
	
	List resList = (List)resp.getDto().getList("RESULT");
	if (resList == null) {
		resList = new ArrayList();
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
			<% 
				if (resp != null && resp.getErrorInfo() != null) { %>
					alert("<%= resp.getErrorInfo() %>");
			<% 
				} else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0){ %>
					alert("删除成功！");
			<% 
				}
			%>
		</script>
		
		<script type="text/javascript">
			function showUpdate(orgid) {
				var url = "pages/navy/supmanage/supSupportorSaleOrgSaveOrUpdate.jsp?supid=<%= supid %>";
				
				if (orgid != "") {
					url = url + "&orgid=" + orgid;
				}
				
				var left = (screen.width - 650) /2;
				var top = (screen.height - 450) /2;
				var param = "dialogLeft=" + top + "px;dialogLeft=" + left + "px;dialogWidth:600px;dialogHeight:450px;resizable:no;scroll:0;help:0;status:0";
				window.showModalDialog(url, window, param);
			}
			
			function deleteOrg(orgid) {
				if (confirm('确定要删除记录吗？')) {
					var url = '/pages/navy/supmanage/supSupportorSaleOrgQuery.jsp?opt=refresh&supid=<%= supid %>';
					window.document.getElementById('str_orgid').value = orgid;
					submit_form('Navy', 'NavyManage', 'SupSupportorSaleOrgDeleteService', url);
				}
			}
			
			function showDetail(orgid) {
				var url = "pages/navy/supmanage/supSupportorSaleOrgDetail.jsp?supid=<%= supid %>&orgid=" + orgid;
				
				var left = (screen.width - 650) /2;
				var top = (screen.height - 300) /2;
				var param = "dialogLeft=" + top + "px;dialogLeft=" + left + "px;dialogWidth:600px;dialogHeight:300px;resizable:no;scroll:0;help:0;status:0";
				window.showModalDialog(url, window, param);
			}
		</script>
	</head>
	
	<body>
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= supid %>">
			<input id="str_orgid" name="str_orgid" type="hidden" value="">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
		
			<table width="100%" height="100%" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td valign="top" height="25">
						<div id="btu_new">
							<img src="resources/images/common/btn_new.gif" width="62" height="22"
								onclick="showUpdate('');" />
						</div>
					</td>
				</tr>
				<tr>
					<td valign="top" height="250" width="95%" align="center">
						<table border="0" cellpadding="0" cellspacing="0"
							height="100%" width="100%">
							<tr>
								<td valign="top" height="35" width="100%">
									<table border="0" cellpadding="0" cellspacing="0"
										height="100%" width="100%">
										<tr>
											<td width="5%">
												<div class="title" style="width:100%">序号</div>
											</td>
											<td width="19%">
												<div class="title" style="width:100%">机构名称</div>
											</td>
											<td width="15%">
												<div class="title" style="width:100%">类别</div>
											</td>
											<td width="20%">
												<div class="title" style="width:100%">所在市县</div>
											</td>
											<td width="15%">
												<div class="title" style="width:100%">负责人</div>
											</td>
											<td width="15%">
												<div class="title" style="width:100%">联系电话</div>
											</td>
											<td>
												<div class="title" style="width:100%">操作</div>
											</td>
											<td width="16">
												<div class="title" style="width:100%">&nbsp;</div>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td valign="top" height="100%">
									<div style="overflow: scroll; overflow-x: hidden; width: 100%; height: 100%">
										<table border="0" cellpadding="0" cellspacing="0"
											width="100%" class="tbl">
											<%
												for (int i = 0; i < resList.size(); i ++) {
													DTO data = (DTO)resList.get(i);
											%>
											<tr>
												<td width="5%">
													<%= i + 1 + pages.getRowNumber() * (pages.getPageIndex() - 1) %>
												</td>
												<td width="20%">
													<a href="javascript:showDetail('<%= data.getString("ORGID") %>');" class="link_blue_table"><%= data.showString("ORGNAME") %></a>
												</td>
												<td width="15%">
													<%= data.showString("ORGTYPE", "&nbsp;") %>
												</td>
												<td width="20%">
													<%= data.showString("LOCATION", "&nbsp;") %>
												</td>
												<td width="15%">
													<%= data.showString("DIRECTOR", "&nbsp;") %>
												</td>
												<td width="15%">
													<%= data.showString("PHONE", "&nbsp;") %>
												</td>
												<td>
													<a class="link_blue" href="javascript:showUpdate('<%= data.showString("ORGID") %>')">修改</a>
													<a class="link_blue" href="javascript:deleteOrg('<%= data.showString("ORGID") %>');">删除</a>
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
						<div class="linepage1">
						</div>
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
				document.getElementById("str_supid").value = "<%= supid %>";
				submit_form('Navy', 'NavyManage', 'SupSupportorSaleOrgQueryService', '/pages/navy/supmanage/supSupportorSaleOrgQuery.jsp?supid=<%= supid %>');
			}
		</script>
	</body>
</html>