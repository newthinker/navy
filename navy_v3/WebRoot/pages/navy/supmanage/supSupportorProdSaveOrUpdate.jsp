<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	List resList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (resList != null && resList.size() > 0) {
		dto = (DTO) resList.get(0);
	}
	
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
	
	String supid = request.getParameter("supid");
	String prodid = request.getParameter("prodid");
	String loc = "修改";
	if (prodid == null) {
		prodid = "";
	}
	if (prodid.equals("")) {
		loc = "新增";
	}
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
		function set_souproducttype(code, item)
		{
			var requestTest = "<?xml version='1.0' encoding='UTF-8'?><Request>" +
			"<header>" +
				"<responseSystemName>Navy</responseSystemName>" +
				"<responseSubsystemName>DictManage</responseSubsystemName>" +
				"<responseService>ProductTypeQueryService</responseService>" +
				"<dispatcherUrl></dispatcherUrl>" +
			"</header>" +
			"<DTO><STR_FATHERCODE>" + code + "</STR_FATHERCODE></DTO></Request>";
		
			var request = getRequest();
			var url = '<%=request.getContextPath()%>/systemxhr?opt=&XML_DATA='+escape(requestTest);
			request.open('POST',url,true);
			request.onreadystatechange = function()
			{
				if (request.readyState==4 && request.status==200)
				{
					var xmldata1 = request.responseXML.selectSingleNode("Response/DTO/DICT_LIST/Row/LIS_RESULT/Row");
					while (xmldata1)
					{
						var xmlname1 = xmldata1.selectSingleNode("STR_DICTNAME");
						var xmlcode1 = xmldata1.selectSingleNode("STR_DICTCODE");
						if (xmlname1 && xmlcode1)
						{
							var item1 = new treeItem(xmlname1.text, 
									"javascript:setsouvalue('" + xmlname1.text + "', '" + xmlcode1.text + "');", 
									"_self",null,null,xmlcode1.text);
							item.add(item1);
						}
						xmldata1 = xmldata1.nextSibling;
					}
					item.expand();
				}
			};
			request.send(null);
		}

		function setsouvalue(value1, value2)
		{
			var selItem = Global.selectedItem;
			if (selItem) {
				if (selItem.level < 3) {
					if (selItem.childNodes.length > 0) {
						selItem.expand();
					}
					else {
						set_souproducttype(value2, selItem);
					}
				}
				else {
					document.getElementById("STR_GOODNAME").innerText = value1;
					document.getElementById("STR_PRODTYPE").value = value2;
				}
			}
		}
		
		</script>
		
		<script type="text/javascript">
			function checkinput() {
				var obj = document.getElementById("STR_PRODNAME");
				if (!check_input(obj, false, 0, null, null, "产品名称")) {
					return false;
				}

				//obj = document.getElementById("STR_GOODNAME");
				//if (!check_input(obj, false, 0, null, null, "物资品名")) {
				//	return false;
				//}
				
				obj = document.getElementById("STR_PRODNO");
				if (!check_input(obj, false, 0, null, null, "产品系列或型号")) {
					return false;
				}

				obj = document.getElementById("STR_MEASURUNIT");
				if (!check_input(obj, false, 0, null, null, "计量单位")) {
					return false;
				}
				
				obj = document.getElementById("STR_AVGOUTPUT");
				if (!check_input(obj, true, 2, null, null, "年平均年产量")) {
					return false;
				}

				obj = document.getElementById("STR_MAXOUTPUT");
				if (!check_input(obj, true, 2, null, null, "年最大年产量")) {
					return false;
				}

				obj = document.getElementById("STR_SINGLEMAXOUTPUT");
				if (!check_input(obj, true, 2, null, null, "单批最大产量")) {
					return false;
				}
				
				obj = document.getElementById("STR_SINGLEMAXDATE");
				if (!check_input(obj, true, 1, null, null, "所用天数")) {
					return false;
				}
				
				return true;
			}
		</script>
	</head>
	
	<body scroll="no"
		style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<jsp:include page="supSupportorQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= supid %>">
			<input id="str_prodid" name="str_prodid" type="hidden" value="<%= prodid %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<div id="site">&nbsp;当前位置：供应商信息管理&gt;&gt;<span>供应商信息新增</span>&gt;&gt;<span>产品信息<%= loc %></span>
			</div>
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td colspan="3" height="5px">
					</td>
				</tr>
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">产品信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free" style="width:95%">
							<tr>
								<th>
									产品编目分类
								</th>
								<td>
									<input id="STR_GOODNAME" name="STR_GOODNAME" class="searchTbl_input" type="text" readonly="readonly" align="center"
										value="<%= dto.getString("GOODNAME") == null ? "" : dto.getString("GOODNAME") %>" />
									<span style="color:red;">*</span>
									<input id="STR_PRODTYPE" name="STR_PRODTYPE" type="hidden"
										value="<%= dto.getString("PRODTYPE") == null ? "" : dto.getString("PRODTYPE") %>" />
									<a id="a_souProtypediv" class="link_blue_table" href="javascript:void(0)" onclick="showProtypeTree(this);">显示产品编目</a>
									<div id="souProtypediv" style="position:absolute; display:none; overflow:auto; background-color:#FFFFFF; border:solid 1px #000000; padding:5px; width:250px; height:300px;" >
										<div id="souProtypetree"></div>
									</div>
									<script type="text/javascript">
										var protypetreeInit = 0;
										function showProtypeTree(obj)
										{
											ScriptHelper.showDivCommon(obj,'souProtypediv',20,125);
											if (protypetreeInit == 0)
											{
												var item1 = new treeItem("产品编目", "javascript:setsouvalue('产品编目', -1);", "_self",null,null,-1);
												item1.setup(document.getElementById("souProtypetree"));
												//set_producttype();
												protypetreeInit = 1;
											}
											if (document.getElementById("a_souProtypediv").innerText == "显示产品编目")
												document.getElementById("a_souProtypediv").innerText = "隐藏产品编目";
											else
												document.getElementById("a_souProtypediv").innerText = "显示产品编目";
										}
									</script>
								</td>
							</tr>
							<tr>
								<th>
									产品名称
								</th>
								<td>
									<input type="text" name="STR_PRODNAME" id="STR_PRODNAME"
										class="searchTbl_input" value="<%= dto.showString("PRODNAME") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									产品系列或型号
								</th>
								<td>
									<input type="text" name="STR_PRODNO" id="STR_PRODNO"
										class="searchTbl_input" value="<%= dto.showString("PRODNO") %>" />
									<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									计量单位
								</th>
								<td>
									<input type="text" name="STR_MEASURUNIT" id="STR_MEASURUNIT"
										class="searchTbl_input" value="<%= dto.showString("MEASURUNIT") %>" />
		        					<span style="color:red;">*</span>
								</td>
							</tr>
							<tr>
								<th>
									2008-2010年平均年产量
								</th>
								<td>
									<input type="text" name="STR_AVGOUTPUT" id="STR_AVGOUTPUT"
										class="searchTbl_input" value="<%= dto.showNumber("AVGOUTPUT") %>" />
								</td>
							</tr>
							<tr>
								<th>
									2008-2010年最大年产量
								</th>
								<td>
									<input type="text" name="STR_MAXOUTPUT" id="STR_MAXOUTPUT"
										class="searchTbl_input" value="<%= dto.showNumber("MAXOUTPUT") %>" />
								</td>
							</tr>
							<tr>
								<th>
									单批最大产量
								</th>
								<td>
									<input type="text" name="STR_SINGLEMAXOUTPUT" id="STR_SINGLEMAXOUTPUT"
										class="searchTbl_input" value="<%= dto.showNumber("SINGLEMAXOUTPUT") %>" />
								</td>
							</tr>
							<tr>
								<th>
									完成单批最大产量所用时间(天)
								</th>
								<td>
									<input type="text" name="STR_SINGLEMAXDATE" id="STR_SINGLEMAXDATE"
										class="searchTbl_input" value="<%= dto.showString("SINGLEMAXDATE") %>" />
								</td>
							</tr>
							<tr>
								<th>
									备注
								</th>
								<td>
									<textarea name="STR_REMARK" id="STR_REMARK" rows="5" cols="6"><%= dto.showString("REMARK") %></textarea>
									<br />(可填写2000个英文字符或1000个中文字符)
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<div class="btu">
				<input type="button" name="save" value="保 存" class="btu_input"
					onclick="if (checkinput()) submit_form('Navy', 'NavyManage', 'SupSupportorProdSaveOrUpdateService', '/pages/navy/supmanage/supSupportorProdSaveOrUpdate.jsp?supid=<%= supid %>&prodid=<%= prodid %>');" />
				<input type="button" name="back" id="button" value="关 闭" class="btu_input"
					onclick="window.close();" />
			</div>
		</form>
		<script type="text/javascript">
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("保存成功！");
				window.dialogArguments.submit_form('Navy', 'NavyManage', 'SupSupportorProdQueryService', '/pages/navy/supmanage/supSupportorProdQuery.jsp?supid=<%= supid %>');
				window.close();
			<% 
				}
			%>

			if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
				document.getElementById("str_prodid").value = "<%= prodid %>";
				submit_form('Navy', 'NavyManage', 'SupSupportorProdQueryByIdService', '/pages/navy/supmanage/supSupportorProdSaveOrUpdate.jsp?supid=<%= supid %>&prodid=<%= prodid %>');
			}
		</script>
	</body>
</html>