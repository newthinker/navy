<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../common/init.jsp" %>

<%
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"/>
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
				submit_form('Navy','NavyManage','ImportQueryService','/pages/navy/importmanage/importDataQuery.jsp');
			}
		</script>
	</head>

	<body scroll="yes">
		<form action="system" method="post">
			<jsp:include page="importDataQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt" />
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="" />
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
				<tr>
					<td>
						<div id="site">
							&nbsp;当前位置：
							采购项目信息管理&gt;&gt;
							<span>采购项目信息新增</span>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div id="menu_div">
							<div class="blue_nav1">
								<ul>
								  <li id="Labeltable" onclick="Label_onClick(this,'blue_nav1_ontab')" class="blue_nav1_ontab"><a href="pages/navy/importmanage/importDataAdd.jsp" target="importAdd"><span>进口项目</span></a></li>
								  <li id="Labeltable" onclick="Label_onClick(this,'blue_nav1_ontab')"><a href="pages/navy/importmanage/importDataAddNation.jsp" target="importAdd"><span>国内项目</span></a></li>
								</ul>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<iframe src="pages/navy/importmanage/importDataAdd.jsp" id="importAdd" name="importAdd" 
							frameborder="0" width="100%" height="500" scrolling="auto"></iframe>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
