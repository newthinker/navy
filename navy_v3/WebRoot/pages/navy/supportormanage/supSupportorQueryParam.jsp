﻿<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../../common/init.jsp" %>
<%
	DTO queryParam = (DTO)resp.getDto().get("REQUEST_PARAM");

	if (queryParam == null) {
		queryParam = new DTO();
	}

	List dictlist = (List)resp.getDto().getSelectItems();

	if (dictlist == null) {
		dictlist = new ArrayList();

		for (int i=0; i<7; ++i)
		{
			DTO dto = new DTO();
			dto.setList("RESULT", new ArrayList());
			dictlist.add(dto);
		}
	}

	DTO type = (DTO)dictlist.get(0);
	DTO bank = (DTO)dictlist.get(1);
	DTO credit = (DTO)dictlist.get(2);
	DTO economy = (DTO)dictlist.get(3);
	DTO l1Name = (DTO)dictlist.get(6);

	String mode = request.getParameter("mode");
%>

<script type="text/javascript">
	function getRequest(){
		if(window.XMLHttpRequest){
			request =  new XMLHttpRequest();
			//alert("xmlRequestHttp");
		}
		else{
			request = new ActiveXObject("Microsoft.XMLHTTP");
			//alert("xobject");
		}
		return request;
	}
	function change_province(provalue) {
		var value = provalue;
		value = value.replace(/&/g, "&amp;");
		value = value.replace(/</g, "&lt;");
		value = value.replace(/>/g, "&gt;");
		value = value.replace(/"/g, "&quot;");
		value = value.replace(/'/g, "&apos;");
		var requestTest = "<?xml version='1.0' encoding='UTF-8'?><Request>" +
		"<header>" +
			"<responseSystemName>Navy</responseSystemName>" +
			"<responseSubsystemName>DictManage</responseSubsystemName>" +
			"<responseService>AreaQueryByCodeService</responseService>" +
			"<dispatcherUrl></dispatcherUrl>" +
		"</header>" +
		"<DTO>" +
			"<STR_AREACODE>" + value + "</STR_AREACODE>" +
		"</DTO></Request>";

		var request = getRequest();
		var url = '<%=request.getContextPath()%>/systemxhr?opt=&XML_DATA='+escape(requestTest);
		request.open('POST',url,true);
		request.onreadystatechange = function()
		{
			if (request.readyState==4 && request.status==200)
			{
				var citydom = document.getElementById("STR_QUERY_L2LOC");
				while (citydom.options.length > 1)
				{
					citydom.options.length = 1;
				}
				//console.log(request);
				var xmldata = request.responseXML.getElementsByTagName("Response/DTO/DICT_LIST/Row/LIS_RESULT/Row");
				for (var i=0; i<xmldata.length; i++)
				{
					var xmlname = xmldata[i].getElementsByTagName("STR_AREANAME");
					var xmlcode = xmldata[i].getElementsByTagName("STR_AREACODE");
					if (xmlname.length > 0 && xmlcode.length > 0)
					{
	                    var item = new Option(xmlname[0].nodeTypedValue, xmlcode[0].nodeTypedValue);  
						citydom.options.add(item);
					}
				}
			}
		};
		request.send(null);
	}
	function show_city()
	{
		
		getRequest();
		//alert("test");
	}
</script>

<input id="int_rownumber" name="int_rownumber" value="20" type="hidden">
<input id="int_pageindex" name="int_pageindex" type="hidden">
<div class="searchTbl"
	 style="display:<%= mode != null && mode.equals("show") ? "block" : "none" %>">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" class="searchTbl">
		<tr>
			<td align="right" width="14%">
				供应商名称:&nbsp;
			</td>
			<td align="left" width="16%">
				<input id="STR_QUERY_SUPNAME" name="STR_QUERY_SUPNAME" style="width:150px"
					value="<%= queryParam.getString("QUERY_SUPNAME") == null ? "" : queryParam.getString("QUERY_SUPNAME") %>" />
			</td>
			<td align="right" width="14%">
				省市地区:&nbsp;
			</td>
			<td align="left" width="26%">
				<select name="STR_QUERY_L1LOC" id="STR_QUERY_L1LOC" style="width:100px" onchange="change_province(this.value)">
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
				<select name="STR_QUERY_L2LOC" id="STR_QUERY_L2LOC" style="width:100px">
					<option value="">-请选择-</option>
				</select>
			</td>
			<td align="right" width="14%">
				注册资金:&nbsp;
			</td>
			<td align="left" width="16%">
				<select name="STR_QUERY_LICCAPITAL" id="STR_QUERY_LICCAPITAL" style="width:150px">
					<option value="">-请选择-</option>
					<option value="1">1万~10万</option>
					<option value="2">10万~100万</option>
					<option value="3">100万~1000万</option>
					<option value="4">1000万~1亿</option>
					<option value="5">1亿以上</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">
				生产范围:&nbsp;
			</td>
			<td align="left">
				<input id="STR_QUERY_GOODNAME" name="STR_QUERY_GOODNAME" style="width:150px"
					value="<%= queryParam.getString("QUERY_GOODNAME") == null ? "" : queryParam.getString("QUERY_GOODNAME") %>" />
			</td>
			<td align="right">
				产品产能:&nbsp;
			</td>
			<td align="left">
				<input id="STR_QUERY_AVGOUTPUT" name="STR_QUERY_AVGOUTPUT" style="width:150px"
					value="<%= queryParam.getString("QUERY_AVGOUTPUT") == null ? "" : queryParam.getString("QUERY_AVGOUTPUT") %>" />
			</td>
			<td align="right">
				相应运力:&nbsp;
			</td>
			<td align="left">
				<input id="STR_QUERY_DEADWEIGHT" name="STR_QUERY_DEADWEIGHT" style="width:150px"
					value="<%= queryParam.getString("QUERY_DEADWEIGHT") == null ? "" : queryParam.getString("QUERY_DEADWEIGHT") %>" />
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		//setSelect("STR_QUERY_SUPTYPE", "<%= queryParam.getString("QUERY_SUPTYPE") == null ? "" : queryParam.getString("QUERY_SUPTYPE") %>");

	</script>
</div>