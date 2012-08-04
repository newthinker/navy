<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ include file="../../common/init.jsp" %>
<%
	DTO queryParam = (DTO)resp.getDto().get("REQUEST_PARAM");
	
	if (queryParam == null) {
		queryParam = new DTO();
	}
	
	List dictlist = (List)resp.getDto().getSelectItems();
	
	String mode = request.getParameter("mode");
%>

<script type="text/javascript">
</script>

<input id="int_rownumber" name="int_rownumber" value="20" type="hidden">
<input id="int_pageindex" name="int_pageindex" type="hidden">
<div class="searchTbl"
	 style="display:<%= mode != null && mode.equals("show") ? "block" : "none" %>">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="searchTbl">
		<tr>
			<td align="right">
				供应商名称:&nbsp;
			</td>
			<td align="left">
				<input id="STR_QUERY_SUPNAME" name="STR_QUERY_SUPNAME" style="width:150px"
					value="<%= queryParam.getString("QUERY_SUPNAME") == null ? "" : queryParam.getString("QUERY_SUPNAME") %>" />
			</td>
			<td align="right" width="10%">
				省/地区:&nbsp;
			</td>
			<td align="left" width="15%">
				<select name="STR_QUERY_L1NAME" id="STR_QUERY_L1NAME" style="width:150px">
					<option value="">-请选择-</option>
					<%
						for (int i = 0; i < l1Name.getList("RESULT").size(); i ++) {
							DTO dto = (DTO)l1Name.getList("RESULT").get(i);
					%>
					<option value="<%= dto.getString("AREACODE") %>"><%= dto.getString("AREANAME") %></option>
					<%
						}
					%>
				</select>
			</td>
			<td align="right" width="10%">
				市:&nbsp;
			</td>
			<td align="left" width="15%">
				<select name="STR_QUERY_L2NAME" id="STR_QUERY_L2NAME" style="width:150px">
					<option value="">-请选择-</option>
					<%
						for (int i = 0; i < l2Name.getList("RESULT").size(); i ++) {
							DTO dto = (DTO)l2Name.getList("RESULT").get(i);
					%>
					<option value="<%= dto.getString("AREACODE") %>"><%= dto.getString("AREANAME") %></option>
					<%
						}
					%>
				</select>
			</td>	
			<td align="right" width="10%">
				注册资金:&nbsp;
			</td>
			<td align="left" width="15%">
				<select name="STR_QUERY_CAPITAL" id="STR_QUERY_CAPITAL" style="width:150px">
					<option value="">-请选择-</option>
					<%
						for (int i = 0; i < capital.getList("RESULT").size(); i ++) {
							DTO dto = (DTO)capital.getList("RESULT").get(i);
					%>
					<option value="<%= dto.getString("DICTCODE") %>"><%= dto.getString("DICTNAME") %></option>
					<%
						}
					%>
				</select>
			</td>			
		</tr>
		<tr>
		
		</tr>
	</table>
	<script type="text/javascript">
		setSelect("STR_QUERY_SUPTYPE", "<%= queryParam.getString("QUERY_SUPTYPE") == null ? "" : queryParam.getString("QUERY_SUPTYPE") %>");
	</script>
</div>