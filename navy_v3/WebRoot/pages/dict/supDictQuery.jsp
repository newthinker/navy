<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@page import="java.io.InputStream"%>
<%@ include file="../common/init.jsp" %>

<%
	DTO queryParam = (DTO)resp.getDto().get("REQUEST_PARAM");
	
	if (queryParam == null) {
		queryParam = new DTO();
	}
	
	String typeid = queryParam.getString("QUERY_TYPEID");
	if (typeid == null)
		typeid = request.getParameter("typeid");
	String fathercode = queryParam.getString("QUERY_FATHERCODE");
	if (fathercode == null)
		fathercode = request.getParameter("fathercode");
	String urlparam = "?typeid=" + typeid;
	if (!fathercode.isEmpty()) {
		urlparam += "&fathercode=" + fathercode;
	}
	
	String loc = "";
	if (typeid.equals("6")) {
		loc = "采购方式";
	} else if (typeid.equals("11")) {
		loc = "供应商类型";
	} else if (typeid.equals("12")) {
		loc = "开户银行";
	} else if (typeid.equals("13")) {
		loc = "信用等级";
	} else if (typeid.equals("14")) {
		loc = "经济性质";
	} else if (typeid.equals("15")) {
		loc = "产品编目";
	} else if (typeid.equals("17")) {
		loc = "服务机构类型";
	} else if (typeid.equals("18")) {
		loc = "货车类型";
	}
%>

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
		<script language="javascript" src="resources/javascript/iOffice_Popup.js"></script>
		<style type="text/css">
		</style>

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
			
			function SYNC_Roll(){
				DataGroup2.style.posTop=-DataFrame3.scrollTop
			}
			
			function click_url(value, type) {
				if (type == 1) {
					window.document.getElementById('STR_DICTCODE').value=value;
					submit_form('HDDict', 'DictManage', 'DictQueryByIDService', '/pages/dict/supDictDetail.jsp<%=urlparam%>');
				} else if (type == 2) {
					window.document.getElementById('STR_DICTCODE').value=value;
					submit_form('HDDict', 'DictManage', 'DictQueryByIDService', '/pages/dict/supDictUpdate.jsp<%=urlparam%>');
				} else if (type == 3) {
					if (confirm('确定要删除记录吗？')) {
						window.document.getElementById('STR_DICTCODE').value=value;
						submit_form('HDDict', 'DictManage', 'DictDeleteService', '/pages/dict/supDictQuery.jsp<%=urlparam%>&opt=refresh');
					}
				} else if (type == 4) {
					window.document.getElementById('STR_FATHERCODE').value=value;
					window.document.getElementById('STR_QUERY_FATHERCODE').value=value;
					submit_form('HDDict', 'DictManage', 'DictQueryService', '/pages/dict/supDictQuery.jsp');
				}
				
			}
		</script>
	</head>

	<body  style="background:url(../images/tbl_bg.gif) top left repeat-x; background-color:#ffffff;"
		onload="init('HDDict','DictManage','DictQueryService','/pages/dict/supDictQuery.jsp<%= urlparam %>');">
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="STR_QUERY_TYPEID" name="STR_QUERY_TYPEID" type="hidden" value="<%= typeid %>">
			<input id="STR_DICTCODE" name="STR_DICTCODE" type="hidden" value="">
			<input id="STR_TYPEID" name="STR_TYPEID" type="hidden" value="<%= typeid %>">
			<input id="STR_QUERY_FATHERCODE" name="STR_QUERY_FATHERCODE" type="hidden" value="<%= fathercode %>">
			<input id="STR_FATHERCODE" name="STR_FATHERCODE" type="hidden" value="<%= fathercode %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<center>
				<table width="100%" height="100%" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td valign="top" height="1">
							<div id="site">&nbsp;当前位置：<%= loc %>管理</div>
						</td>
					</tr>
					<tr>
						<td valign="top" height="1">
							<jsp:include page="dictQueryParam.jsp?mode=show"></jsp:include>
						</td>
					</tr>
					<tr>
						<td valign="top" height="25">
							<div id="btu_new">
								<img src="resources/images/common/btn_search.gif" alt=" " width="62" height="22"
									onclick="submit_form('HDDict', 'DictManage', 'DictQueryService', '/pages/dict/supDictQuery.jsp<%= urlparam %>');" />
								<img src="resources/images/common/btn_new.gif" width="62" height="22"
									onclick="window.document.getElementById('STR_DICTCODE').value='-1';
									submit_form('HDDict', 'DictManage', 'DictQueryByIDService', '/pages/dict/supDictAdd.jsp<%= urlparam %>');" /> 
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
												<td width="25%">
													<div class="title" style="width:100%">名称</div>
												</td>
												<td width="9%">
													<div class="title" style="width:100%">下级分类</div>
												</td>
												<td width="30%">
													<div class="title" style="width:100%">说明</div>
												</td>
												<td width="12%">
													<div class="title" style="width:100%">最后修改人</div>
												</td>
												<td width="12%">
													<div class="title" style="width:100%">最后修改日期</div>
												</td>
												<td width="12%">
													<div class="title" style="width:100%">操作</div>
												</td>
												<td>
													<div class="title" style="width:100%">&nbsp;</div>
												</td>
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
													<td width="25%" style="padding-left:5px;">
														<a class="link_blue" href="javascript:click_url('<%=data.getString("DICTCODE")%>', 1);">
															<%= data.showString("DICTNAME", "&nbsp;") %>
														</a>
													</td>
													<td width="10%" style="padding-left:5px;">
														<a class="link_blue" href="javascript:click_url('<%=data.getString("DICTCODE")%>', 4);">查看</a>
													</td>
													<td width="30%" style="padding-left:5px;">
														<%= data.showString("DICTEXPLAIN", "&nbsp;") %>
													</td>
													<td width="12%" style="padding-left:5px;">
														<%= data.showString("OPERATORNAME", "&nbsp;") %>
													</td>
													<td width="12%" style="padding-left:5px;">
														<%= data.showDate("OPERATDATE", "&nbsp;") %>
													</td>
													<td width="12%" style="padding-left:5px">
														<a class="link_blue" href="javascript:click_url('<%=data.getString("DICTCODE")%>', 2);">修改</a>
														<a class="link_blue" href="javascript:click_url('<%=data.getString("DICTCODE")%>', 3);">删除</a>
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
								第<%= pages.getPageIndex() %>页/共<%= pages.getPageCount() == null ? 0 : pages.getPageCount() %>页 共<%= pages.getRowsCount() == null ? 0 : pages.getRowsCount() %>条记录
								<a href="javascript:firstpage('HDDict', 'DictManage', 'DictQueryService', '/pages/dict/supDictQuery.jsp<%= urlparam %>')">首页</a>
								<a href="javascript:prevpage('HDDict', 'DictManage', 'DictQueryService', '/pages/dict/supDictQuery.jsp<%= urlparam %>')">上一页</a>
								<a href="javascript:nextpage('HDDict', 'DictManage', 'DictQueryService', '/pages/dict/supDictQuery.jsp<%= urlparam %>')">下一页</a>
								<a href="javascript:lastpage('HDDict', 'DictManage', 'DictQueryService', '/pages/dict/supDictQuery.jsp<%= urlparam %>')">末页</a>
								转到 
								<select id="page" name="page" 
									onchange="gopage(this.value, 'HDDict','DictManage','DictQueryService','/pages/dict/supDictQuery.jsp<%= urlparam %>')">
									<% 
										for (int i = 0; i < (pages.getPageCount() == null ? 0 : pages.getPageCount()); i ++) { 
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
		</script>
	</body>
</html>
