<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../../common/init.jsp" %>
<%
	DTO queryParam = (DTO)resp.getDto().get("REQUEST_PARAM");
	
	if (queryParam == null) {
		queryParam = new DTO();
	}
	
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
	
	String mode = request.getParameter("mode");
%>

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
				DTO dto = (DTO)classlist.get(i);
		%>
		if (code == "<%= dto.getString("RELEVANCECODE") %>") {
			sub.options.add(new Option("<%= dto.getString("DICTNAME") %>", "<%= dto.getString("DICTCODE") %>"));
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
				DTO dto = (DTO)directorylist.get(i);
		%>
		if (code == "<%= dto.getString("RELEVANCECODE") %>") {
			sub.options.add(new Option("<%= dto.getString("DICTNAME") %>", "<%= dto.getString("DICTCODE") %>"));
		}
		<%
			}
		%>
	}
</script>

<input id="int_rownumber" name="int_rownumber" value="20" type="hidden">
<input id="int_pageindex" name="int_pageindex" type="hidden">
<div class="searchTbl"
	 style="display:<%= mode != null && mode.equals("show") ? "block" : "none" %>">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="searchTbl">
		<tr>
			<td align="right" width="10%">
				计划类别:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_TYPECODE" id="STR_QUERY_TYPECODE" style="width:150px">
					<option value="">-请选择-</option>
					<%
						for (int i = 0; i < planType.getList("RESULT").size(); i ++) {
							DTO dto = (DTO)planType.getList("RESULT").get(i);
					%>
					<option value="<%= dto.getString("DICTCODE") %>"><%= dto.getString("DICTNAME") %></option>
					<%
						}
					%>
				</select>
			</td>
			<td align="right" width="10%">
				计划年度:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_IMPORTYEAR" id="STR_QUERY_IMPORTYEAR" style="width:150px">
					<option value="">-请选择-</option>
					<%
						for (int i = 0; i < impYear.getList("RESULT").size(); i ++) {
							DTO dto = (DTO)impYear.getList("RESULT").get(i);
					%>
					<option value="<%= dto.getString("IMPORTYEAR") %>"><%= dto.getString("IMPORTYEAR") %></option>
					<%
						}
					%>
				</select>
			</td>
			<td align="right" width="10%">
				采购机构:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_UNITID" id="STR_QUERY_UNITID" style="width:150px">
					<option value="">-请选择-</option>
					<%
						for (int i = 0; i < unit.getList("RESULT").size(); i ++) {
							DTO dto = (DTO)unit.getList("RESULT").get(i);
					%>
					<option value="<%= dto.getString("DICTCODE") %>"><%= dto.getString("DICTNAME") %></option>
					<%
						}
					%>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">
				事业部门:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_DEPTID" id="STR_QUERY_DEPTID" style="width:150px"
					onchange="setClass(this, document.getElementById('STR_QUERY_CLASSID'));">
					<option value="">-请选择-</option>
					<%
						for (int i = 0; i < dept.getList("RESULT").size(); i ++) {
							DTO dto = (DTO)dept.getList("RESULT").get(i);
					%>
					<option value="<%= dto.getString("DICTCODE") %>"><%= dto.getString("DICTNAME") %></option>
					<%
						}
					%>
				</select>
			</td>
			<td align="right">
				专业类别:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_CLASSID" id="STR_QUERY_CLASSID" style="width:150px">
					<option value="">-请选择-</option>
				</select>
			</td>
			<td align="right">
				采购项目名称:&nbsp;
			</td>
			<td align="left">
				<input id="STR_QUERY_PROJECT" name="STR_QUERY_PROJECT" style="width:150px"
					value="<%= queryParam.getString("QUERY_PROJECT") == null ? "" : queryParam.getString("QUERY_PROJECT") %>" />
			</td>
		</tr>
		<tr>
			<td align="right">
				采购方式:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_MODEID" id="STR_QUERY_MODEID" style="width:150px">
					<option value="">-请选择-</option>
					<%
						for (int i = 0; i < impmode.getList("RESULT").size(); i ++) {
							DTO dto = (DTO)impmode.getList("RESULT").get(i);
					%>
					<option value="<%= dto.getString("DICTCODE") %>"><%= dto.getString("DICTNAME") %></option>
					<%
						}
					%>
				</select>
			</td>
			<td align="right">
				进口类别:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_IMPORTCLASSID" id="STR_QUERY_IMPORTCLASSID" style="width:150px"
					onchange="selDict(this, document.getElementById('STR_QUERY_DIRECTORYID'));">
					<option value="">-请选择-</option>
					<%
						for (int i = 0; i < impclass.getList("RESULT").size(); i ++) {
							DTO dto = (DTO)impclass.getList("RESULT").get(i);
					%>
					<option value="<%= dto.getString("DICTCODE") %>"><%= dto.getString("DICTNAME") %></option>
					<%
						}
					%>
				</select>
			</td>
			<td align="right">
				免税目录:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_DIRECTORYID" id="STR_QUERY_DIRECTORYID" style="width:150px">
					<option value="">-请选择-</option>
				</select>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		setSelect("STR_QUERY_TYPECODE", "<%= queryParam.getString("QUERY_TYPECODE") == null ? "" : queryParam.getString("QUERY_TYPECODE") %>");
		setSelect("STR_QUERY_IMPORTYEAR", "<%= queryParam.getString("QUERY_IMPORTYEAR") == null ? "" : queryParam.getString("QUERY_IMPORTYEAR") %>");
		setSelect("STR_QUERY_UNITID", "<%= queryParam.getString("QUERY_UNITID") == null ? "" : queryParam.getString("QUERY_UNITID") %>");
		setSelect("STR_QUERY_DEPTID", "<%= queryParam.getString("QUERY_DEPTID") == null ? "" : queryParam.getString("QUERY_DEPTID") %>");
		setSelect("STR_QUERY_CLASSID", "<%= queryParam.getString("QUERY_CLASSID") == null ? "" : queryParam.getString("QUERY_CLASSID") %>");
		setSelect("STR_QUERY_MODEID", "<%= queryParam.getString("QUERY_MODEID") == null ? "" : queryParam.getString("QUERY_MODEID") %>");
		setSelect("STR_QUERY_IMPORTCLASSID", "<%= queryParam.getString("QUERY_IMPORTCLASSID") == null ? "" : queryParam.getString("QUERY_IMPORTCLASSID") %>");
		setSelect("STR_QUERY_DIRECTORYID", "<%= queryParam.getString("QUERY_DIRECTORYID") == null ? "" : queryParam.getString("QUERY_DIRECTORYID") %>");
	</script>
</div>
