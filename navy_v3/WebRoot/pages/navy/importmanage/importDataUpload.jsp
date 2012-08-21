<%@ page language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../../common/init.jsp" %>
<%
	int cnt = 5;
	
	String importid = request.getParameter("importid");
	String typeid = request.getParameter("typeid");
	String type = request.getParameter("type");
	
	List list = resp.getDto().getList("RESULT");
	if (list == null) {
		list = new ArrayList();
	}
	
	String url = "/pages/navy/importmanage/importDataUpload.jsp?opt=1&importid=" + importid + "&typeid=" + typeid + "&type=" + type;
%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<base href="<%= base %>" target="_self">

		<title>上传扫描件</title>

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
			function checkInput() {
				for (var i = 0; i < 5; i ++) {
					var upload = document.getElementById("upload" + i);
					if (upload.value != "") {
						var ext = upload.value.substring(upload.value.indexOf(".") + 1, upload.value.length);
						if (ext.toLowerCase() != "jpg" && ext.toLowerCase() != "png" && ext.toLowerCase() != "gif") {
							alert("扫描件格式为jpg、png、gif");
							return false;
						}
					}
				
					return true;
				}
			}
			
			function finish() {
				window.opener.document.getElementById("<%= type %>").innerText = "<%= list.size() %>";
			}
		</script>
	</head>
	
	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;" scroll="no" 
		onload="init('Navy', 'NavyManage', 'ImportImageQueryService', '/pages/navy/importmanage/importDataUpload.jsp?opt=1&importid=<%= importid %>&typeid=<%= typeid %>&type=<%= type %>');">
		<form action="upload?size=2&url=<%= url %>" method="post" enctype="multipart/form-data">
			<input type="hidden" name="opt" id="opt">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			<input id="int_rownumber" name="int_rownumber" value="50" type="hidden">
			<input id="int_pageindex" name="int_pageindex" type="hidden">
			<input id="str_imageid" name="str_imageid" type="hidden" value="">
			<input id="str_importid" name="str_importid" type="hidden" value="<%= importid %>">
			<input id="STR_IMAGETYPE" name="STR_IMAGETYPE" type="hidden" value="<%= type %>">
			<input id="STR_IMAGETYPEID" name="STR_IMAGETYPEID" type="hidden" value="<%= typeid %>">
			
			<table width="100%" height="100%" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td width="600" height="100%" valign="top">
						<table width="100%" height="100%" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td valign="top" height="1">
									<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
										<tr>
											<td colspan="3" height="5px">
											</td>
										</tr>
										<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
											<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
											<td width="1195">
												<div class="fen_div_title">上传附件</div>
											</td>
											<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
										</tr>
										<tr>
											<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
												<table border="0" cellpadding="0" cellspacing="0"
													class="tbl_search2_free" style="width:96%">
													<tr>
														<td colspan="2">
															注意：文件格式：图片（gif、jpg、png） 文件大小<1M
														</td>
													</tr>
													<tr>
														<th width="20%" align="right">
															选择文件
														</th>
														<td>
															<table width="100%" border="0" cellpadding="0" cellspacing="0">
																<%
																	for (int i = 0; i < cnt; i ++) {
																%>
																<tr>
																	<td height="35px">
																		<input id="upload<%= i %>" name="upload<%= i %>" type="file" />
																	</td>
																</tr>
																<%
																	}
																%>
															</table>
														</td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td valign="top" height="1">
									<div class="btu">
										<input type="button" name="save" value="上 传" class="btu_input"
											onclick="if (checkInput()) submit_form('Navy', 'NavyManage', 'ImportUploadService', '/pages/navy/importmanage/importDataUpload.jsp?importid=<%= importid %>&typeid=<%= typeid %>&type=<%= type %>');" />
										<input type="button" name="back" id="button" value="关 闭" class="btu_input"
											onclick="window.close();" />
									</div>
								</td>
							</tr>
							<tr>
								<td valign="top">
									<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center" height="100%" width="100%">
										<tr height="1">
											<td colspan="3" height="5px">
											</td>
										</tr>
										<tr height="1" style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
											<td width="17" valign="top"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
											<td width="1195" valign="top">
												<div class="fen_div_title">已上传附件</div>
											</td>
											<td width="17" align="right" valign="top"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
										</tr>
										<tr>
											<td colspan="3" valign="top" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
												<table border="0" cellpadding="0" cellspacing="0"
													height="100%" width="100%">
													<tr>
														<td valign="top" height="35" width="100%">
															<table border="0" cellpadding="0" cellspacing="0"
																height="100%" width="100%">
																<tr>
																	<td width="19%" align="center">
																		<div class="title" style="width:100%">序号</div>
																	</td>
																	<td align="center">
																		<div class="title" style="width:100%">文件名</div>
																	</td>
																	<td width="20%" align="center">
																		<div class="title" style="width:100%">操作</div>
																	</td>
																</tr>
															</table>
														</td>
													</tr>
													<tr>
														<td valign="top" height="100%">
															<div style="overflow:scroll;overflow-x:hidden;width:100%;height:100%">
																<table border="0" cellpadding="0" cellspacing="0"
																	width="100%" class="tbl">
																	<%
																		for (int i = 0; i < list.size(); i ++) {
																			DTO data = (DTO)list.get(i);
																	%>
																	<tr valign="top" height="30">
																		<td width="20%">
																			<%= i + 1 + pages.getRowNumber() * (pages.getPageIndex() - 1) %>
																		</td>
																		<td>
																			<a href="<%= data.getString("IMAGEPATH") %>" target="_blank" class="link_blue"><%= data.getString("IMAGENAME") == null ? "" : data.getString("IMAGENAME") %></a>
																		</td>
																		<td width="15%">
																			<a class="link_blue" href="javascript:if (confirm('确定要删除记录吗？')) {window.document.getElementById('str_imageid').value='<%= data.getString("IMAGEID")  %>';submit_form('Navy', 'NavyManage', 'ImportImageDeleteService', '/pages/navy/importmanage/importDataUpload.jsp?opt=refresh&importid=<%= importid%>&typeid=<%= typeid %>&type=<%= type %>');}">删除</a>
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
											<td height="30" colspan="3">
												<div class="linepage1">
													第<%= pages.getPageIndex() %>页/共<%= pages.getPageCount() == null ? 0 : pages.getPageCount() %>页 共<%= pages.getRowsCount() == null ? 0 : pages.getRowsCount() %>条记录
													<a href="javascript:firstpage('Navy','NavyManage','ImportImageQueryService','/pages/navy/importmanage/importDataUpload.jsp?opt=1&importid=<%= importid %>&typeid=<%= typeid %>&type=<%= type %>')">首页</a>
													<a href="javascript:prevpage('Navy','NavyManage','ImportImageQueryService','/pages/navy/importmanage/importDataUpload.jsp?opt=1&importid=<%= importid %>&typeid=<%= typeid %>&type=<%= type %>')">上一页</a>
													<a href="javascript:nextpage('Navy','NavyManage','ImportImageQueryService','/pages/navy/importmanage/importDataUpload.jsp?opt=1&importid=<%= importid %>&typeid=<%= typeid %>&type=<%= type %>')">下一页</a>
													<a href="javascript:lastpage('Navy','NavyManage','ImportImageQueryService','/pages/navy/importmanage/importDataUpload.jsp?opt=1&importid=<%= importid %>&typeid=<%= typeid %>&type=<%= type %>')">末页</a>
												</div>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
					<td>
						<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
							<tr>
								<td style="border:1px solid">
									<iframe src="pages/navy/importmanage/imagesDetail.jsp?importid=<%= importid %>&typeid=<%= typeid %>&type=<%= type %>" 
										id="images" name="images" frameborder="0" width="100%" height="100%" scrolling="auto"></iframe>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") == 1) { %>
				alert("上传成功！");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") == 2) { %>
				alert("删除成功！");
			<% 
				}
			%>
			
			finish();
		</script>
	</body>
</html>
