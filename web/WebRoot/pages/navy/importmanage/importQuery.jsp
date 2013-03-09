<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="../../common/init.jsp" %>
<%
	String downloadurl = "";
	if (resp.getDto().get("DOWNLOAD") != null) {
		String download = (String)resp.getDto().get("DOWNLOAD");
		String downloadFilename = (String)resp.getDto().get("DOWNLOAD_FILENAME");
		downloadurl = "download?download=" + download + "&filename=" + downloadFilename;
	}
	
	String type = request.getParameter("type");
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
			function showSupportor(suppid) {
				document.getElementById("str_importid").value = "";
				document.getElementById("str_imagetypeid").value = "";
				document.getElementById("str_imagetype").value = "";
				document.getElementById("str_supid").value = suppid;
				
				submit_form("Navy", "NavyManage", "SupportorDetailService", "/pages/navy/supportormanage/supportorDetails.jsp?src=import");
			}
			
			function SYNC_Roll(){
				DataGroup2.style.posTop=-DataFrame3.scrollTop
			}
			
			function createExcel() {
				var frm = document.getElementById("download");
				createXml('Navy','NavyManage','ImportQueryExportService','/pages/navy/importmanage/importQuery.jsp');
				frm.document.getElementById("XML_DATA").value = document.getElementById("XML_DATA").value;
				frm.document.forms[0].submit();
			}
			
			function showSearchDiv() {
				document.getElementById("search_tr").style.display = "block";
			}
			
			function hiddenSearchDiv() {
				document.getElementById("search_tr").style.display = "none";
			}
			
			function query() {
				result.document.getElementById("STR_QUERY_TYPECODE").value = document.getElementById("STR_QUERY_TYPECODE").value;
				result.document.getElementById("STR_QUERY_IMPORTYEAR").value = document.getElementById("STR_QUERY_IMPORTYEAR").value;
				result.document.getElementById("STR_QUERY_UNITID").value = document.getElementById("STR_QUERY_UNITID").value;
				result.document.getElementById("STR_QUERY_MODEID").value = document.getElementById("STR_QUERY_MODEID").value;
				result.document.getElementById("STR_QUERY_DEPTID").value = document.getElementById("STR_QUERY_DEPTID").value;
				result.document.getElementById("STR_QUERY_CLASSID").value = document.getElementById("STR_QUERY_CLASSID").value;
				result.document.getElementById("STR_QUERY_PROJECT").value = document.getElementById("STR_QUERY_PROJECT").value;
				result.document.getElementById("STR_QUERY_COMPACT").value = document.getElementById("STR_QUERY_COMPACT").value;
				result.document.getElementById("STR_QUERY_IMPORTCLASSID").value = document.getElementById("STR_QUERY_IMPORTCLASSID").value;
				result.document.getElementById("STR_QUERY_DIRECTORYID").value = document.getElementById("STR_QUERY_DIRECTORYID").value;
				result.document.getElementById("DAT_QUERY_COMPACTDATEBEFORE").value = document.getElementById("DAT_QUERY_COMPACTDATEBEFORE").value;
				result.document.getElementById("DAT_QUERY_COMPACTDATEBEFORE").value = document.getElementById("DAT_QUERY_COMPACTDATEBEFORE").value;
				result.document.getElementById("int_rownumber").value = document.getElementById("int_rownumber").value;
				result.document.getElementById("int_pageindex").value = document.getElementById("int_pageindex").value;
				result.submit_form('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importResult.jsp');
			}
		</script>
	</head>
	
	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="str_importid" name="str_importid" type="hidden" value="">
			<input id="str_imagetypeid" name="str_imagetypeid" type="hidden" value="">
			<input id="str_imagetype" name="str_imagetype" type="hidden" value="">
			<input id="str_supid" name="str_supid" type="hidden" value="">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
		
			<center>
				<table width="100%" height="100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top" height="1">
							<div id="site">&nbsp;当前位置：采购项目查询分析</div>
						</td>
					</tr>
					<tr id="search_tr">
						<td valign="top" height="1">
							<jsp:include page="importQueryParam.jsp?mode=show"></jsp:include>
						</td>
					</tr>
					<tr>
						<td valign="top" height="25">
							<div id="btu_new">
								<table cellpadding="0" cellspacing="0" width="100%" border="0">
									<tr>
										<td align="left">
											&nbsp;&nbsp;&nbsp;合同总数<span id="count"></span>，合同金额总计人民币<span id="sum"></span>万元
										</td>
										<td align="right" width="400px">
											<img src="resources/images/common/btn_search.gif" alt=" " width="62" height="22"
												onclick="query();" /> 
											<img src="resources/images/common/btn_excle.gif" width="81" height="22"
												onclick="createExcel();" /> 
											<img src="resources/images/common/btn_hidden.gif" width="81" height="22"
												onclick="hiddenSearchDiv();" id="hiddenImg" /> 
											<img src="resources/images/common/btn_visible.gif" width="81" height="22"
												onclick="showSearchDiv();" id="showImg" /> 
										</td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top">
							<iframe id="result" src="pages/navy/importmanage/importResult.jsp?type=<%= type %>" 
								width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>
						</td>
					</tr>
					<tr>
						<td height="30">
							<div class="linepage1">
								第<%= pages.getPageIndex() %>页/共<%= pages.getPageCount() == null ? 0 : pages.getPageCount() %>页 共<%= pages.getRowsCount() == null ? 0 : pages.getRowsCount() %>条记录
								<a href="javascript:result.firstpage('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importResult.jsp')">首页</a>
								<a href="javascript:result.prevpage('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importResult.jsp')">上一页</a>
								<a href="javascript:result.nextpage('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importResult.jsp')">下一页</a>
								<a href="javascript:result.lastpage('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importResult.jsp')">末页</a>
								转到 
								<select id="page" name="page" 
									onchange="result.gopage(this.value, 'Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importResult.jsp')">
									<% 
										for (int i = 0; i < ((pages.getPageCount() == null) ? 0 : pages.getPageCount()); i ++) { 
									%>
									<option value="<%= i + 1 %>"><%= i + 1 %></</option>
									<% 
										} 
									%>
								</select>
								&nbsp;&nbsp;&nbsp;
							</div>
						</td>
					</tr>
				</table>
			</center>
		</form>
		<script type="text/javascript">
			setSelect("page", "<%= pages.getPageIndex() %>");
			
			if ("<%= type %>" != "null" && "<%= type %>" != "") {
				document.getElementById("STR_QUERY_TYPECODE").value = "<%= type %>";
			}
			
			init('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importQuery.jsp?type=<%= type %>');
		</script>
	</body>
</html>
<iframe id="download" src="<%= downloadurl %>" width="0" height="0" frameborder="0"></iframe>