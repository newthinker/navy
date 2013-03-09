<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../common/init.jsp" %>
<%
%>

<html>
	<head>
		<base href="<%=base%>" target="_self">
		<title></title>

		<link href="resources/css/common.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		
		<script>
			function Label_onClick(changetd, changeclassName) {
				for (i = 0; i < document.all.Labeltable.length; i ++) {
				   	document.all.Labeltable[i].className = "";
				}
				
				changetd.className = changeclassName;
			}
			
			function complete() {
				submit_form('Navy','NavyManage','SupportorQueryService','/pages/navy/supportormanage/supportorQuery.jsp');
			}
		</script>
	</head>

	<body scroll="no">
		<form action="system">
			<jsp:include page="supportorQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt" />
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="" />
			<table border="0" cellpadding="0" cellspacing="0" width="100%" height="100%">
				<tr>
					<td height="1">
						<div id="site">
							当前位置：
							供应商信息管理&gt;&gt;
							<span>供应商信息新增</span>
						</div>
					</td>
				</tr>
				<tr>
					<td height="1">
						<div id="menu_div">
							<div class="blue_nav1">
								<ul>
								  <li id="Labeltable" onclick="Label_onClick(this,'blue_nav1_ontab')" class="blue_nav1_ontab"><a href="pages/navy/supportormanage/supportorAdd.jsp" target="importAdd"><span>国内供应商</span></a></li>
								  <li id="Labeltable" onclick="Label_onClick(this,'blue_nav1_ontab')"><a href="pages/navy/supportormanage/supportorAddImport.jsp" target="importAdd"><span>进口供应商</span></a></li>
								</ul>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<iframe src="pages/navy/supportormanage/supportorAdd.jsp" id="importAdd" name="importAdd" 
							frameborder="0" width="100%" height="100%" scrolling="no"></iframe>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
