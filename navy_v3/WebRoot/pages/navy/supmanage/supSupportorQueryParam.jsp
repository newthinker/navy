<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="../../common/init.jsp" %>
<%
	DTO queryParam = (DTO)resp.getDto().get("REQUEST_PARAM");

	if (queryParam == null) {
		queryParam = new DTO();
	}

//	List dictlist = (List)resp.getDto().getSelectItems();
//
//	if (dictlist == null) {
//		dictlist = new ArrayList();
//
//		for (int i=0; i<7; ++i)
//		{
//			DTO dto = new DTO();
//			dto.setList("RESULT", new ArrayList());
//			dictlist.add(dto);
//		}
//	}
//
//	DTO type = (DTO)dictlist.get(0);
//	DTO bank = (DTO)dictlist.get(1);
//	DTO credit = (DTO)dictlist.get(2);
//	DTO economy = (DTO)dictlist.get(3);

	String mode = request.getParameter("mode");
%>

<script type="text/javascript" src='resources/javascript/xtree.js'></script>
<script type="text/javascript" src="resources/javascript/floatdiv.js"></script>
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
	function set_province(bQuery)
	{
		var requestTest = "<?xml version='1.0' encoding='UTF-8'?><Request>" +
		"<header>" +
			"<responseSystemName>Navy</responseSystemName>" +
			"<responseSubsystemName>DictManage</responseSubsystemName>" +
			"<responseService>AreaQueryByCodeService</responseService>" +
			"<dispatcherUrl></dispatcherUrl>" +
		"</header>" +
		"<DTO>" +
			"<STR_AREACODE>0</STR_AREACODE>" +
		"</DTO></Request>";

		var request = getRequest();
		var url = '<%=request.getContextPath()%>/systemxhr?opt=&XML_DATA='+escape(requestTest);
		request.open('POST',url,true);
		request.onreadystatechange = function()
		{
			if (request.readyState==4 && request.status==200)
			{
				var provdom = document.getElementById(bQuery ? "STR_QUERY_L1LOC" : "STR_L1LOC");
				while (provdom.options.length > 1)
				{
					provdom.options.length = 1;
				}
				var xmldata = request.responseXML.getElementsByTagName("Response/DTO/DICT_LIST/Row/LIS_RESULT/Row");
				for (var i=0; i<xmldata.length; i++)
				{
					var xmlname = xmldata[i].getElementsByTagName("STR_AREANAME");
					var xmlcode = xmldata[i].getElementsByTagName("STR_AREACODE");
					if (xmlname.length > 0 && xmlcode.length > 0)
					{
						var item = new Option(xmlname[0].nodeTypedValue, xmlcode[0].nodeTypedValue);  
						provdom.options.add(item);
					}
				}
			}
		};
		request.send(null);
	}
	function change_province(provalue, bQuery) {
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
				var citydom = document.getElementById(bQuery ? "STR_QUERY_L2LOC" : "STR_L2LOC");
				while (citydom.options.length > 1)
				{
					citydom.options.length = 1;
				}
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

	function set_producttype(code, item)
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
								"javascript:setvalue('" + xmlname1.text + "', '" + xmlcode1.text + "');", 
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

	function setvalue(value1, value2)
	{
		var selItem = Global.selectedItem;
		if (selItem) {
			if (selItem.level < 3) {
				if (selItem.childNodes.length > 0) {
					selItem.expand();
				}
				else {
					set_producttype(value2, selItem);
				}
			}
			else {
				document.getElementById("STR_QUERY_GOODNAME").innerText = value1;
				document.getElementById("STR_QUERY_PRODTYPE").value = value2;
			}
		}
	}
	
	set_province(true);
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
			<td align="left" width="25%">
				<input id="STR_QUERY_SUPNAME" name="STR_QUERY_SUPNAME" style="width:150px"
					value="<%= queryParam.getString("QUERY_SUPNAME") == null ? "" : queryParam.getString("QUERY_SUPNAME") %>" />
			</td>
			<td align="right" width="10%">
				省市地区:&nbsp;
			</td>
			<td align="left" width="21%">
				<select name="STR_QUERY_L1LOC" id="STR_QUERY_L1LOC" style="width:100px" onchange="change_province(this.value, true)">
					<option value="">-请选择-</option>
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
					<option value="1">50万以下</option>
					<option value="2">50万~200万</option>
					<option value="3">200万~500万</option>
					<option value="5">500万以上</option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">
				组织机构代码:&nbsp;
			</td>
			<td align="left">
				<input id="STR_QUERY_ORGANIZECODE" name="STR_QUERY_ORGANIZECODE" style="width:150px"
					value="<%= queryParam.getString("QUERY_ORGANIZECODE") == null ? "" : queryParam.getString("QUERY_ORGANIZECODE") %>" />
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
		<tr>
			<td align="right">
				生产范围:&nbsp;
			</td>
			<td align="left">
			<!--<span id="protypename" style="border:solid 1px #b3c9d2; width:150px" > -请选择产品分类- </span> -->
				<input id="STR_QUERY_GOODNAME" name="STR_QUERY_GOODNAME" style="width:150px;text-align:center;" align="center" readonly="readonly"
					value="<%= queryParam.getString("QUERY_GOODNAME") == null ? "-请选择产品分类-" : queryParam.getString("QUERY_GOODNAME") %>" />
				<input id="STR_QUERY_PRODTYPE" name="STR_QUERY_PRODTYPE" style="width:150px" type="hidden"
					value="<%= queryParam.getString("QUERY_PRODTYPE") == null ? "" : queryParam.getString("QUERY_PRODTYPE") %>" />
				<a id="a_protypediv" class="link_blue_table" href="javascript:void(0)" onclick="showProtypeTree(this);">显示产品编目</a>
				<div id="protypediv" style="position:absolute; display:none; overflow:auto; background-color:#FFFFFF; border:solid 1px #000000; padding:5px; width:250px; height:300px;" >
					<div id="protypetree"></div>
				</div>
				<script type="text/javascript">
					var protypetreeInit = 0;
					function showProtypeTree(obj)
					{
						ScriptHelper.showDivCommon(obj,'protypediv');
						if (protypetreeInit == 0)
						{
							var item1 = new treeItem("产品编目", "javascript:setvalue('产品编目', -1);", "_self",null,null,-1);
							item1.setup(document.getElementById("protypetree"));
							//set_producttype();
							protypetreeInit = 1;
						}
						if (document.getElementById("a_protypediv").innerText == "显示产品编目")
							document.getElementById("a_protypediv").innerText = "隐藏产品编目";
						else
							document.getElementById("a_protypediv").innerText = "显示产品编目";
					}
				</script>
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
		setSelect("STR_QUERY_SUPTYPE", "<%= queryParam.getString("QUERY_SUPTYPE") == null ? "" : queryParam.getString("QUERY_SUPTYPE") %>");
		setSelect("STR_QUERY_LICCAPITAL", "<%= queryParam.getString("QUERY_LICCAPITAL") == null ? "" : queryParam.getString("QUERY_LICCAPITAL") %>");

	</script>
</div>