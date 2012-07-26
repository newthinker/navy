<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="../../common/init.jsp" %>
<%
	DTO queryParam = (DTO)resp.getDto().get("REQUEST_PARAM");
	
	if (queryParam == null) {
		queryParam = new DTO();
	}
	
	List impYear = (List)resp.getDto().getSelectItems();
	
	if (impYear == null) {
		impYear = new ArrayList();
	}
	
	String mode = request.getParameter("mode");
%>

<div 
	 style="display:<%= mode != null && mode.equals("show") ? "block" : "none" %>">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="searchTbl">
		<tr>
			<td align="right" width="15%">
				计划年度:&nbsp;
			</td>
			<td align="left">
				<select name="STR_QUERY_IMPORTYEAR" id="STR_QUERY_IMPORTYEAR" style="width:150px">
					<%
						for (int i = 0; i < impYear.size(); i ++) {
							DTO dto = (DTO)impYear.get(i);
					%>
					<option value="<%= dto.getString("IMPORTYEAR") %>"><%= dto.getString("IMPORTYEAR") %></option>
					<%
						}
					%>
				</select>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		setSelect("STR_QUERY_IMPORTYEAR", "<%= queryParam.getString("QUERY_IMPORTYEAR") == null ? "" : queryParam.getString("QUERY_IMPORTYEAR") %>");
	</script>
</div>
