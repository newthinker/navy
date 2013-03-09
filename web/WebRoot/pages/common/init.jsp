<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="cn.com.hd.transfer.Response"%>
<%@page import="cn.com.hd.transfer.DTO"%>
<%@page import="cn.com.hd.transfer.PageInfo"%>
<%
	String path = request.getContextPath();
	String base = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	String sServer = request.getServerName();
	
	String sOpt = request.getParameter("opt");
	
	Response resp = null;
	PageInfo pages = null;
	if (request.getAttribute("XML_DATA") != null) {
		resp = (Response)request.getAttribute("XML_DATA");
	}
	
	if (resp == null) {
		resp = new Response();
		resp.setDto(new DTO());
	}
	
	if (resp.getDto().get("PAGEINFO") != null) {
		pages = (PageInfo)resp.getDto().get("PAGEINFO");
	}
	
	if (pages == null) {
		pages = new PageInfo();
	}
%>
<script type="text/javascript">
	function createXml(responseSystemName, responseSubsystemName, responseService, dispatcherUrl) {
		dispatcherUrl = dispatcherUrl.replace(/&/g, "&amp;");
		var requestTest = "<?xml version='1.0' encoding='UTF-8'?><Request>" + 
		"<header>" + 
			"<responseSystemName>"+responseSystemName+"</responseSystemName>" +
			"<responseSubsystemName>"+responseSubsystemName+"</responseSubsystemName>" +
			"<responseService>"+responseService+"</responseService>" +
			"<dispatcherUrl>"+dispatcherUrl+"</dispatcherUrl>" +
		"</header><DTO>";
		var elems = document.forms[0].elements;
		for (var i = 0; i < elems.length; i ++) {
			if (elems[i].name != 'XML_DATA' && elems[i].type != 'button' && elems[i].type != 'file') {
				if (elems[i].value != "") {
					var value = elems[i].value;
					value = value.replace(/&/g, "&amp;");
					value = value.replace(/</g, "&lt;");
					value = value.replace(/>/g, "&gt;");
					value = value.replace(/"/g, "&quot;");
					value = value.replace(/'/g, "&apos;");
					requestTest = requestTest + "<" + elems[i].name.toUpperCase() + ">" + value + "</" + elems[i].name.toUpperCase() + ">"
				}
			}	
		}
		
		requestTest = requestTest + "</DTO></Request>";
		document.getElementById("XML_DATA").value = requestTest;
	}
	function submit_form(responseSystemName, responseSubsystemName, responseService, dispatcherUrl) {
		createXml(responseSystemName, responseSubsystemName, responseService, dispatcherUrl);
		document.forms[0].submit();
	}
	
	function firstpage(responseSystemName, responseSubsystemName, responseService, dispatcherUrl) {
		var int_pageindex = <%= pages.getPageIndex() %>;
		if (int_pageindex == 1) {
			return;
		} else {
			document.getElementById("int_pageindex").value = 1;
		}
		
		submit_form(responseSystemName, responseSubsystemName, responseService, dispatcherUrl);
	}
	
	function nextpage(responseSystemName, responseSubsystemName, responseService, dispatcherUrl) {
		var int_pageindex = <%= pages.getPageIndex() %>;
		if (int_pageindex == <%= pages.getPageCount() %>) {
			return;
		} else {
			document.getElementById("int_pageindex").value = int_pageindex + 1;
		}
				
		submit_form(responseSystemName, responseSubsystemName, responseService, dispatcherUrl);
	}
	
	function prevpage(responseSystemName, responseSubsystemName, responseService, dispatcherUrl) {
		var int_pageindex = <%= pages.getPageIndex() %>;
		if (int_pageindex == 1) {
			return;
		} else {
			document.getElementById("int_pageindex").value = int_pageindex - 1;
		}
		
		submit_form(responseSystemName, responseSubsystemName, responseService, dispatcherUrl);
	}
	
	function lastpage(responseSystemName, responseSubsystemName, responseService, dispatcherUrl) {
		var int_pageindex = <%= pages.getPageIndex() %>;
		if (int_pageindex == <%= pages.getPageCount() %>) {
			return;
		} else {
			document.getElementById("int_pageindex").value = <%= pages.getPageCount() %>;
		}
		
		submit_form(responseSystemName, responseSubsystemName, responseService, dispatcherUrl);
	}
	
	function gopage(pages, responseSystemName, responseSubsystemName, responseService, dispatcherUrl) {
		if (document.getElementById("int_pageindex")) {
			document.getElementById("int_pageindex").value = parseInt(pages);
		}
		
		submit_form(responseSystemName, responseSubsystemName, responseService, dispatcherUrl);
	}
	
	function init(responseSystemName, responseSubsystemName, responseService, dispatcherUrl) {
		if ("<%= sOpt %>" == "null" || "<%= sOpt %>" == "refresh") {
			submit_form(responseSystemName, responseSubsystemName, responseService, dispatcherUrl);
		}
	}
	
	function setSelect(selid, value) {
		var sel = document.getElementById(selid);
		if (!sel) {
			alert("下拉框不存在！");
			return;
		}
			
		var ops = sel.options;
		for (var i = 0; i < ops.length; i ++) {
			if (ops[i].value == value) {
				ops[i].selected = "selected";
				break;
			}
		}
	}
</script>
