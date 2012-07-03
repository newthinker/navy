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
			<td align="right">
				注册地址:&nbsp;
			</td>
			<td align="left">
				<input id="STR_QUERY_ADDRESS" name="STR_QUERY_ADDRESS" style="width:150px"
					value="<%= queryParam.getString("QUERY_ADDRESS") == null ? "" : queryParam.getString("QUERY_ADDRESS") %>" />
			</td>
			<td align="right">
				是否协议供应商:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_SUPTYPE" id="STR_QUERY_SUPTYPE" style="width:150px">
					<option value="">-请选择-</option>
					<option value="是">是</option>
					<option value="否">否</option>
				</select>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		setSelect("STR_QUERY_SUPTYPE", "<%= queryParam.getString("QUERY_SUPTYPE") == null ? "" : queryParam.getString("QUERY_SUPTYPE") %>");
	</script>
</div>
