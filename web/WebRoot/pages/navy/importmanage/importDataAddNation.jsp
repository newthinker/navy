<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
	List dictlist = (List)resp.getDto().getSelectItems();
	
	if (dictlist == null) {
		dictlist = new ArrayList();
		
		DTO dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
	}
	
	DTO planType = (DTO)dictlist.get(0);
	DTO unit = (DTO)dictlist.get(1);
	DTO dept = (DTO)dictlist.get(2);
	DTO classtype = (DTO)dictlist.get(3);
	DTO currency = (DTO)dictlist.get(4);
	DTO impmode = (DTO)dictlist.get(5);
	DTO agent = (DTO)dictlist.get(6);
	DTO impclass = (DTO)dictlist.get(7);
	DTO directory = (DTO)dictlist.get(8);
	DTO use = (DTO)dictlist.get(9);
	DTO impYear = (DTO)dictlist.get(10);
	DTO sup = (DTO)dictlist.get(11);
	
	List typeList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (typeList != null && typeList.size() > 0) {
		dto = (DTO) typeList.get(0);
	}
	
	String iPlanCount = resp.getDto().showInt("PLAN_COUNT");
	String iCompactCount = resp.getDto().showInt("COMPACT_COUNT");
	String iAgreeCount = resp.getDto().showInt("AGREE_COUNT");
	String iExamineCount = resp.getDto().showInt("EXAMINE_COUNT");
	String iImageCount = resp.getDto().showInt("IMAGE_COUNT");
%>
<html>
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
			function setClass(pnt, sub) {
				var code = pnt.options[pnt.selectedIndex].value;
				var len = sub.options.length;
				for (var i = 0; i < len; i ++) {
					sub.options.remove(0);
				}
				sub.options.add(new Option("-请选择-", ""));
				<%
					List classlist = classtype.getList("RESULT");
					for (int i = 0; i < classlist.size(); i ++) {
						DTO dtoDict = (DTO)classlist.get(i);
				%>
				if (code == "<%= dto.getString("RELEVANCECODE") %>") {
					sub.options.add(new Option("<%= dtoDict.getString("DICTNAME") %>", "<%= dtoDict.getString("DICTCODE") %>"));
				}
				<%
					}
				%>
			}
			
			function selDict(pnt, sub) {
				var code = pnt.options[pnt.selectedIndex].value;
				var len = sub.options.length;
				for (var i = 0; i < len; i ++) {
					sub.options.remove(0);
				}
				sub.options.add(new Option("-请选择-", ""));
				<%
					List directorylist = directory.getList("RESULT");
					for (int i = 0; i < directorylist.size(); i ++) {
						DTO dtoDict = (DTO)directorylist.get(i);
				%>
				if (code == "<%= dto.getString("RELEVANCECODE") %>") {
					sub.options.add(new Option("<%= dtoDict.getString("DICTNAME") %>", "<%= dtoDict.getString("DICTCODE") %>"));
				}
				<%
					}
				%>
			}
			
			function setAddr() {
				var value = document.getElementById("SUPPORTOR").value;
				var values = value.split("#");
				document.getElementById("STR_SUPPORTORID").value = values[0];
				document.getElementById("STR_SUPPORTORADDR").value = values[1];
			}
			
			function checkinput() {
				var obj = document.getElementById("STR_PLAN");
				if (obj.value == "[请输入采购计划编号]") {
					obj.value = "";
				}
				
				obj = document.getElementById("STR_COMPACT");
				if (obj.value == "[请输入采购合同编号]") {
					obj.value = "";
				}
				
				obj = document.getElementById("STR_TYPECODE");
				if (!check_input(obj, false, 0, null, null, "计划类别")) {
					return false;
				}
				
				obj = document.getElementById("STR_IMPORTYEAR");
				if (!check_input(obj, false, 0, null, null, "计划年度")) {
					return false;
				}
				
				obj = document.getElementById("STR_COMPACT");
				if (!check_input(obj, false, 0, null, null, "采购合同")) {
					return false;
				}
			
				obj = document.getElementById("STR_PROJECT");
				if (!check_input(obj, false, 0, null, null, "采购项目名称")) {
					return false;
				}
			
				obj = document.getElementById("STR_BUDGET");
				if (!check_input(obj, true, 2, 0, 10000000000, "预算金额")) {
					return false;
				}
				
				obj = document.getElementById("STR_COMPACTMONEY");
				if (!check_input(obj, false, 2, 0, 10000000000, "合同金额")) {
					return false;
				}
				
				obj = document.getElementById("STR_SUPPORTOR");
				if (!check_input(obj, false, 0, null, null, "供应商")) {
					return false;
				}
				
				obj = document.getElementById("STR_PLAN");
				var cnt = document.getElementById("PLAN");
				if (obj.value == "" && cnt.innerText > 0) {
					alert("必须填写采购计划");
					obj.focus();
					obj.select();
					return false;
				}
			
				return true;
			}
			
			function fileUpload(typeid, type) {
				var left = 0;
				var top = 0;
				window.open('pages/navy/importmanage/importDataUpload.jsp?importid=<%= dto.getString("IMPORTID") == null ? "" : dto.getString("IMPORTID") %>' + '&type=' + type + '&typeid=' + typeid, 'upload', 'top=' + top + ',left=' + left + ',height=' + screen.height + ',width=' + screen.width + ',toolbar=no,menubar=no');
			}
			
			function selectSupportor() {
				var left = (screen.width - 800) /2;
				var top = (screen.height - 500) /2;
				window.open('pages/navy/supportormanage/selectSupportor.jsp', 'select', 'top=' + top + ',left=' + left + ',height=500,width=800,toolbar=no,menubar=no,resize=no');
			}
		</script>
	</head>
	
	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;">
		<form action="system" method="post">
			<jsp:include page="importDataQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_importid" name="str_importid" type="hidden" value="<%= dto.getString("IMPORTID") == null ? "" : dto.getString("IMPORTID") %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<input id="STR_TYPENAME" name="STR_TYPENAME" type="hidden" value="<%= dto.getString("TYPENAME") == null ? "" : dto.getString("TYPENAME") %>">
			<input id="STR_UNIT" name="STR_UNIT" type="hidden" value="<%= dto.getString("UNIT") == null ? "" : dto.getString("UNIT") %>">
			<input id="STR_DEPT" name="STR_DEPT" type="hidden" value="<%= dto.getString("DEPT") == null ? "" : dto.getString("DEPT") %>">
			<input id="STR_CURRENCY" name="STR_CURRENCY" type="hidden" value="<%= dto.getString("CURRENCY") == null ? "" : dto.getString("CURRENCY") %>">
			<input id="STR_CURRENCYID" name="STR_CURRENCYID" type="hidden" value="<%= dto.getString("CURRENCYID") == null ? "" : dto.getString("CURRENCYID") %>">
			<input id="STR_MODENAME" name="STR_MODENAME" type="hidden" value="<%= dto.getString("MODENAME") == null ? "" : dto.getString("MODENAME") %>">
			<input id="STR_AGENT" name="STR_AGENT" type="hidden" value="<%= dto.getString("AGENT") == null ? "" : dto.getString("AGENT") %>">
			<input id="STR_SUPPORTORID" name="STR_SUPPORTORID" type="hidden" value="<%= dto.getString("SUPPORTORID") == null ? "" : dto.getString("SUPPORTORID") %>">
			<input id="STR_IMPORTCLASS" name="STR_IMPORTCLASS" type="hidden" value="<%= dto.getString("IMPORTCLASS") == null ? "" : dto.getString("IMPORTCLASS") %>">
			<input id="STR_CLASSNAME" name="STR_CLASSNAME" type="hidden" value="<%= dto.getString("CLASSNAME") == null ? "" : dto.getString("CLASSNAME") %>">
			<input id="STR_DIRECTORY" name="STR_DIRECTORY" type="hidden" value="<%= dto.getString("DIRECTORY") == null ? "" : dto.getString("DIRECTORY") %>">
			
			<input id="STR_PLANID" name="STR_PLANID" type="hidden" value="<%= dto.getString("PLANID") == null ? "" : dto.getString("PLANID") %>">
			<input id="STR_COMPACTID" name="STR_COMPACTID" type="hidden" value="<%= dto.getString("COMPACTID") == null ? "" : dto.getString("COMPACTID") %>">
			<input id="STR_AGREEID" name="STR_AGREEID" type="hidden" value="<%= dto.getString("AGREEID") == null ? "" : dto.getString("AGREEID") %>">
			<input id="STR_EXAMINEID" name="STR_EXAMINEID" type="hidden" value="<%= dto.getString("EXAMINEID") == null ? "" : dto.getString("EXAMINEID") %>">
			<input id="STR_IMAGE" name="STR_IMAGE" type="hidden" value="<%= dto.getString("IMAGE") == null ? "" : dto.getString("IMAGE") %>">
			
			<table width="100%" border="0" cellpadding="0" cellspacing="0"
				class="tbl_search2_free">
				<tr>
					<th width="15%">
						计划类别
					</th>
					<td width="30%">
						<select name="STR_TYPECODE" id="STR_TYPECODE" style="width:200px"
							class="searchTbl_select" onchange="setSelectLabel('STR_TYPENAME', this);">
							<option value="">-请选择-</option>
							<%
								for (int i = 0; i < planType.getList("RESULT").size(); i ++) {
									DTO dtoDict = (DTO)planType.getList("RESULT").get(i);
									if (dtoDict.getString("DICTCODE").equals("140000000")) {
										continue;
									}
									
									if (dtoDict.getString("DICTCODE").equals("150000000")) {
										continue;
									}
							%>
							<option value="<%= dtoDict.getString("DICTCODE") %>"><%= dtoDict.getString("DICTNAME") %></option>
							<%
								}
							%>
						</select>
						<span style="color:red;">*</span>
					</td>
					<th width="15%">
						计划年度
					</th>
					<td width="35%">
						<select name="STR_IMPORTYEAR" id="STR_IMPORTYEAR" style="width:200px">
							<option value="">-请选择-</option>
							<%
								for (int i = 0; i < impYear.getList("RESULT").size(); i ++) {
									DTO dtoDict = (DTO)impYear.getList("RESULT").get(i);
							%>
							<option value="<%= dtoDict.getString("IMPORTYEAR") %>"><%= dtoDict.getString("IMPORTYEAR") %></option>
							<%
								}
							%>
						</select>
						<span style="color:red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						采购计划
					</th>
					<td>
						<input type="text" name="STR_PLAN" id="STR_PLAN" class="searchTbl_input" style="width:130px" 
							onfocus="if (this.value == '[请输入采购计划编号]') this.value = '';" 
							onblur="if (this.value == '') this.value = '[请输入采购计划编号]';"
							value="<%= dto.getString("PLAN") == null ? "" : dto.getString("PLAN") %>" />
						<input type="button" class="btu_input" style="width:60px" value="上传文件"
							onclick="fileUpload('<%= dto.getString("PLANID") == null ? "" : dto.getString("PLANID") %>', 'PLAN');">
						已上传<span id="PLAN"><%= iPlanCount %></span>个附件
					</td>
					<th>
						计划下达时间
					</th>
					<td>
						<input name="DAT_PLANDATE" id="DAT_PLANDATE" style="cursor:hand;"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
							type="text" style="width:200px;" readonly="readonly" class="Wdate"
							value="<%= dto.showDate("PLANDATE") %>" />
					</td>
				</tr>
				<tr>
					<th>
						采购方式
					</th>
					<td>
						<select name="STR_MODEID" id="STR_MODEID" style="width:200px"
							class="searchTbl_select" onchange="setSelectLabel('STR_MODENAME', this);">
							<option>-请选择-</option>
							<%
								for (int i = 0; i < impmode.getList("RESULT").size(); i ++) {
									DTO dtoDict = (DTO)impmode.getList("RESULT").get(i);
							%>
							<option value="<%= dtoDict.getString("DICTCODE") %>"><%= dtoDict.getString("DICTNAME") %></option>
							<%
								}
							%>
						</select>
					</td>
					<th>
						事业部门
					</th>
					<td>
						<select name="STR_DEPTID" id="STR_DEPTID" style="width:200px" class="searchTbl_select" 
							onchange="setSelectLabel('STR_DEPT', this);setClass(this, document.getElementById('STR_CLASSID'));">
							<option>-请选择-</option>
							<%
								for (int i = 0; i < dept.getList("RESULT").size(); i ++) {
									DTO dtoDict = (DTO)dept.getList("RESULT").get(i);
							%>
							<option value="<%= dtoDict.getString("DICTCODE") %>"><%= dtoDict.getString("DICTNAME") %></option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						专业类别
					</th>
					<td>
						<select name="STR_CLASSID" id="STR_CLASSID" style="width:200px"
							onchange="setSelectLabel('STR_CLASSNAME', this);">
							<option value="">-请选择-</option>
						</select>
					</td>
					<th>
						采购机构
					</th>
					<td>
						<select name="STR_UNITID" id="STR_UNITID" style="width:200px"
							class="searchTbl_select" onchange="setSelectLabel('STR_UNIT', this);">
							<option value="">-请选择-</option>
							<%
								for (int i = 0; i < unit.getList("RESULT").size(); i ++) {
									DTO dtoDict = (DTO)unit.getList("RESULT").get(i);
							%>
							<option value="<%= dtoDict.getString("DICTCODE") %>"><%= dtoDict.getString("DICTNAME") %></option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						采购项目名称
					</th>
					<td>
						<input type="text" name="STR_PROJECT" id="STR_PROJECT" class="searchTbl_input" 
							value="<%= dto.getString("PROJECT") == null ? "" : dto.getString("PROJECT") %>" />
						<span style="color:red;">*</span>
					</td>
					<th>
						预算金额(万元)
					</th>
					<td>
						<input type="text" name="STR_BUDGET" id="STR_BUDGET" class="searchTbl_input" 
							value="<%= dto.showNumber("BUDGET").equals("") ? dto.showDouble("BUDGET") : dto.showNumber("BUDGET") %>" />
					</td>
				</tr>
				<tr>
					<th>
						采购合同
					</th>
					<td>
						<input type="text" name="STR_COMPACT" id="STR_COMPACT" class="searchTbl_input" style="width:130px"
							onfocus="if (this.value == '[请输入采购合同编号]') this.value = '';" 
							onblur="if (this.value == '') this.value = '[请输入采购合同编号]';"
							value="<%= dto.getString("COMPACT") == null ? "" : dto.getString("COMPACT") %>" />
						<input type="button" class="btu_input" style="width:60px" value="上传文件"
							onclick="fileUpload('<%= dto.getString("COMPACTID") == null ? "" : dto.getString("COMPACTID") %>', 'COMPACT');">
						<span style="color:red;">*</span>
						已上传<span id="COMPACT"><%= iCompactCount %></span>个附件
					</td>
					<th>
						合同签订时间
					</th>
					<td>
						<input name="DAT_COMPACTDATE" id="DAT_COMPACTDATE" style="cursor:hand;"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
							type="text" style="width:200px;" readonly="readonly" class="Wdate"
							value="<%= dto.getDate("COMPACTDATE") == null ? "" : fmtDate.format(dto.getDate("COMPACTDATE")) %>" />
					</td>
				</tr>
				<tr>
					<th>
						交货期限
					</th>
					<td>
						<input name="DAT_DELIVERYDATE" id="DAT_DELIVERYDATE" style="cursor:hand;"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
							type="text" style="width:200px;" readonly="readonly" class="Wdate"
							value="<%= dto.showDate("DELIVERYDATE") %>" />
					</td>
					<th>
						合同金额(万元)
					</th>
					<td>
						<input type="text" name="STR_COMPACTMONEY" id="STR_COMPACTMONEY" class="searchTbl_input" 
							value="<%= dto.showNumber("COMPACTMONEY").equals("") ? dto.showDouble("COMPACTMONEY") : dto.showNumber("COMPACTMONEY") %>" />
						<span style="color:red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						设备生产厂家
					</th>
					<td>
						<input type="text" name="STR_PRODUCTOR" id="STR_PRODUCTOR" class="searchTbl_input" 
							value="<%= dto.getString("PRODUCTOR") == null ? "" : dto.getString("PRODUCTOR") %>" />
					</td>
					<th>
						供应商
					</th>
					<td>
						<input id="STR_SUPPORTOR" name="STR_SUPPORTOR" type="text" class="searchTbl_input" readonly="readonly"
							value="<%= dto.getString("SUPPORTOR") == null ? "" : dto.getString("SUPPORTOR") %>">
						<input type="button" class="btu_input" style="width:80px" value="选择供应商"
							onclick="selectSupportor();">
						<span style="color:red;">*</span>
					</td>
				</tr>
				<tr>
					<th>
						供应商注册地点
					</th>
					<td>
						<input type="text" name="STR_SUPPORTORADDR" id="STR_SUPPORTORADDR" class="searchTbl_input" readonly="readonly"
							value="<%= dto.getString("SUPPORTORADDR") == null ? "" : dto.getString("SUPPORTORADDR") %>" />
					</td>
					<th>
						存放类型
					</th>
					<td>
						<select name="STR_STORETYPE" id="STR_STORETYPE" style="width:200px">
							<option value="">-请选择-</option>
							<option value="正常">正常</option>
							<option value="以厂代储">以厂代储</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						存放地点
					</th>
					<td>
						<input type="text" name="STR_STOREADDR" id="STR_STOREADDR" class="searchTbl_input" 
							value="<%= dto.getString("STOREADDR") == null ? "" : dto.getString("STOREADDR") %>" />
					</td>
					<th>
						调用时间
					</th>
					<td>
						<input name="DAT_USEDATE" id="DAT_USEDATE" style="cursor:hand;"
							onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',qsEnabled:true,quickSel:['2000-1-10','2000-2-20']})"
							type="text" style="width:200px;" readonly="readonly" class="Wdate"
							value="<%= dto.showDate("USEDATE") %>" />
					</td>
				</tr>
				<tr>
					<th>
						调用单位
					</th>
					<td>
						<input type="text" name="STR_USEUNIT" id="STR_USEUNIT" class="searchTbl_input" 
							value="<%= dto.getString("USEUNIT") == null ? "" : dto.getString("USEUNIT") %>" />
					</td>
					<th>
						使用情况
					</th>
					<td>
						<select name="STR_USESTATE" id="STR_USESTATE" 
							style="width:200px" class="searchTbl_select">
							<option>-请选择-</option>
							<%
								for (int i = 0; i < use.getList("RESULT").size(); i ++) {
									DTO dtoDict = (DTO)use.getList("RESULT").get(i);
							%>
							<option value="<%= dtoDict.getString("DICTNAME") %>"><%= dtoDict.getString("DICTNAME") %></option>
							<%
								}
							%>
						</select>
					</td>
				</tr>
				<tr>
					<th>
						装备图片
					</th>
					<td>
						<input type="button" class="btu_input" style="width:60px" value="上传文件"
							onclick="fileUpload('<%= dto.getString("IMAGE") == null ? "" : dto.getString("IMAGE") %>', 'IMAGE');">
						已上传<span id="IMAGE"><%= iImageCount %></span>个附件
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
							<input type="button" name="save" value="保 存" class="btu_input" style="width:80px"
								onclick="if (checkinput()) submit_form('Navy', 'NavyManage', 'ImportAddService', '/pages/navy/importmanage/importDataAddNation.jsp');" />
							<input type="button" name="back" id="button" value="返 回" class="btu_input" style="width:80px"
								onclick="window.parent.complete();" />
						</div>
					</td>
				</tr>
			</table>
		</form>
		<script type="text/javascript">
			setSelect("STR_TYPECODE", "<%= dto.getString("TYPECODE") == null ? "" : dto.getString("TYPECODE") %>");
			setSelect("STR_IMPORTYEAR", "<%= dto.getString("IMPORTYEAR") == null ? "" : dto.getString("IMPORTYEAR") %>");
			setSelect("STR_UNITID", "<%= dto.getString("UNITID") == null ? "" : dto.getString("UNITID") %>");
			setSelect("STR_DEPTID", "<%= dto.getString("DEPTID") == null ? "" : dto.getString("DEPTID") %>");
			setSelect("STR_CLASSID", "<%= dto.getString("CLASSID") == null ? "" : dto.getString("CLASSID") %>");
			setSelect("STR_MODEID", "<%= dto.getString("MODEID") == null ? "" : dto.getString("MODEID") %>");
			setSelect("STR_USESTATE", "<%= dto.getString("USESTATE") == null ? "" : dto.getString("USESTATE") %>");
			setSelect("STR_STORETYPE", "<%= dto.getString("STORETYPE") == null ? "" : dto.getString("STORETYPE") %>");
			
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("保存成功！");
				window.parent.complete();
			<% 
				}
			%>
			
			if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
				document.getElementById("str_importid").value = "-1";
				submit_form('Navy', 'NavyManage', 'ImportQueryByIDService', '/pages/navy/importmanage/importDataAddNation.jsp');
			}
			
			var obj = document.getElementById("STR_PLAN");
			if (obj.value == "") {
				obj.value = "[请输入采购计划编号]";
			}
			
			obj = document.getElementById("STR_COMPACT");
			if (obj.value == "") {
				obj.value = "[请输入采购合同编号]";
			}
		</script>
	</body>
</html>