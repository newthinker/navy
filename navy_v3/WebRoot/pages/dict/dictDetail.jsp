<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../common/init.jsp" %>
<%
	List dictList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (dictList != null && dictList.size() > 0) {
		dto = (DTO) dictList.get(0);
	}
	
	String typeid = dto.getString("TYPEID");
	String dictcode = dto.getString("DICTCODE");
	
	String loc = "";
	if (typeid.equals("1")) {
		loc = "计划类别";
	} else if (typeid.equals("2")) {
		loc = "采购机构";
	} else if (typeid.equals("3")) {
		loc = "需求单位";
	} else if (typeid.equals("4")) {
		loc = "专业类别";
	} else if (typeid.equals("5")) {
		loc = "币种";
	} else if (typeid.equals("6")) {
		loc = "采购方式";
	} else if (typeid.equals("7")) {
		loc = "委托代理公司";
	} else if (typeid.equals("8")) {
		loc = "进口类别";
	} else if (typeid.equals("9")) {
		loc = "免税目录";
	} else if (typeid.equals("10")) {
		loc = "使用情况";
	} else if (typeid.equals("11")) {
		loc = "供应商类型";
	} else if (typeid.equals("12")) {
		loc = "开户银行";
	} else if (typeid.equals("13")) {
		loc = "信用等级";
	}
	
	List selectItem = resp.getDto().getSelectItems();
	if (selectItem == null) {
		selectItem = new ArrayList();
		DTO tmpdto = new DTO();
		tmpdto.setList("RESULT", new ArrayList());
		selectItem.add(tmpdto);
		
		tmpdto = new DTO();
		tmpdto.setList("RESULT", new ArrayList());
		selectItem.add(tmpdto);
	}
	
	DTO dept = (DTO)selectItem.get(0);
	DTO importClass = (DTO)selectItem.get(1);
	
	String name = "";
	if (typeid.equals("4")) {
		name = "需求单位";
	} else if (typeid.equals("9")) {
		name = "免税目录";
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
		<title>无标题文档</title>
		<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
		<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
		
		<script language="javascript" src="resources/javascript/iOffice_Popup.js"></script>
		<script language="javascript" src="resources/javascript/hdcube.js"></script>
		<script type="text/javascript">
			function checkinput() {
				var obj = document.getElementById("STR_DICTNAME");
				if (!check_input(obj, false, "0", 1, 100, "名称")) {
					return false;
				}
				
				obj = document.getElementById("STR_EXPINFOA");
				if (obj != null && obj != "undefine") {
					if (!check_input(obj, false, "0", 1, 200, "汇率")) {
						return false;
					}
				}
				
				obj = document.getElementById("STR_RELEVANCECODE");
				if (obj != null && obj != "undefine") {
					if (!check_input(obj, false, "0", 1, 200, "<%= name %>")) {
						return false;
					}
				}
				
				obj = document.getElementById("INT_DICTORDER");
				if (!check_input(obj, false, "1", 1, 1000000, "排序")) {
					return false;
				}
				
				obj = document.getElementById("STR_VALIDATED");
				if (!check_input(obj, false, "0", null, null, "有效性")) {
					return false;
				}
				
				obj = document.getElementById("STR_DICTEXPLAIN");
				if (!check_input(obj, true, "0", 1, 200, "字典项说明")) {
					return false;
				}
				
				return true;
			}
		</script>
	</head>

	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#fff;"
		onload="init('HDDict', 'DictManage', 'DictQueryByIDService', '/pages/dictmanage/dictUpdate.jsp');">
		<form action="system" method="post">
			<jsp:include page="dictQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input type="hidden" name="str_typeid" id="str_typeid" value="<%= typeid %>">
			<input type="hidden" name="str_dictcode" id="str_dictcode" value="<%= dictcode %>">
			<input type="hidden" name="STR_DICTOWNER" id="STR_DICTOWNER" value="<%= dto.showString("DICTOWNER") %>">
			<input type="hidden" name="STR_EXPINFO1" id="STR_EXPINFOA" value="<%= dto.showString("DICTNAME") %>" />
			<input id="STR_QUERY_TYPEID" name="STR_QUERY_TYPEID" type="hidden" value="<%= typeid %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">

			<div id="site">&nbsp;当前位置： <%= loc %>维护 &gt;&gt; <span>修改<%= loc %>信息</span>
			</div>
			<div class="fen_div">
				<div class="fen_div_title"
					style="position: absolute; z-index: 2; left: 26px; top: 37px;">
					<%= loc %>信息
				</div>
				<table width="0%" border="0" cellpadding="0" cellspacing="0"
					class="tbl_search2_free">
					<tr>
						<th width="20%">
							名称
						</th>
						<td>
							<%= dto.getString("DICTNAME") == null ? "" : dto.getString("DICTNAME") %>
						</td>
					</tr>
					<%
						if (typeid.equals("4")) {
					%>
					<tr>
						<th width="20%">
							选择需求单位
						</th>
						<td>
							<%= dto.getString("DICTNAME") %>
						</td>
					</tr>
					<% 
						}
					%>
					<%
						if (typeid.equals("9")) {
					%>
					<tr>
						<th width="20%">
							选择进口类别
						</th>
						<td>
							<%= dto.getString("DICTNAME") %>
						</td>
					</tr>
					<% 
						}
					%>
					<tr>
						<th>
							排序
						</th>
						<td>
							<%= dto.getNumber("DICTORDER") == null ? "" : dto.getNumber("DICTORDER").intValue() %>
						</td>
					</tr>
					<tr>
						<th>
							有效性
						</th>
						<td>
							<%= dto.getString("VALIDATED") == null ? "" : dto.getString("VALIDATED") %>
						</td>
					</tr>
					<tr>
						<th>
							说明
						</th>
						<td>
							<textarea name="STR_DICTEXPLAIN" id="STR_DICTEXPLAIN" rows="5" cols="10" readonly><%= dto.getString("DICTEXPLAIN") == null ? "" : dto.getString("DICTEXPLAIN") %></textarea>
						</td>
					</tr>
				</table>
			</div>
			<div class="btu">
				<input type="button" name="save" value="返 回" class="btu_input"
					onclick="submit_form('HDDict', 'DictManage', 'DictQueryService', '/pages/dict/dictQuery.jsp?typeid=<%= typeid %>');" />
			</div>
		</form>
		<script type="text/javascript">
			<% if (resp != null && resp.getErrorInfo() != null) { %>
				alert("<%= resp.getErrorInfo() %>");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0){ %>
				alert("保存成功！");
				submit_form('HDDict', 'DictManage', 'DictQueryService', '/pages/dict/dictQuery.jsp?opt=refresh&typeid=<%= typeid %>');
			<% 
				}
			%>
		</script>
	</body>
</html>
