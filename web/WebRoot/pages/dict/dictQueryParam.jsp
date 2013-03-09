<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/init.jsp" %>
<%
	DTO queryParam = (DTO)resp.getDto().get("REQUEST_PARAM");
	
	if (queryParam == null) {
		queryParam = new DTO();
	}
	
	String mode = request.getParameter("mode");
%>
<input id="int_rownumber" name="int_rownumber" value="20" type="hidden">
<input id="int_pageindex" name="int_pageindex" type="hidden">
<div class="searchTbl"
	 style="display:<%= mode != null && mode.equals("show") ? "block" : "none" %>">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="searchTbl">
		<tr>
			<td align="right">
				名称:&nbsp;
			</td>
			<td align="left">
				<input id="STR_QUERY_DICTNAME" name="STR_QUERY_DICTNAME" style="width:150px"
					value="<%= queryParam.getString("QUERY_DICTNAME") == null ? "" : queryParam.getString("QUERY_DICTNAME") %>" />
			</td>
			<td align="right">
				有效性:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_VALIDATED" id="STR_QUERY_VALIDATED" style="width:150px" 
					value="<%=queryParam.getString("QUERY_VALIDATED")%>">
					<option value="">-请选择-</option>
					<option value="Y">是</option>
					<option value="N">否</option>
				</select>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		setSelect("STR_QUERY_VALIDATED", "<%= queryParam.getString("QUERY_VALIDATED") == null ? "" : queryParam.getString("QUERY_VALIDATED") %>");
	</script>
</div>
