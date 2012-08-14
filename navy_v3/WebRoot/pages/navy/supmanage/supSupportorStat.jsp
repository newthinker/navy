<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cn.com.hd.dto.navy.TSupportorStat"%>
<%@ include file="../../common/init.jsp"%>
<%
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
	DTO queryParam = (DTO)resp.getDto().get("REQUEST_PARAM");
	if (queryParam == null) {
		queryParam = new DTO();
	}
	TSupportorStat supStat = (TSupportorStat)resp.getDto().getObject("RESULT");
	int statType = 0;
	if (supStat != null) {
		statType = supStat.getStattype();
	}
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%= base %>" target="_self">

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta content="MSHTML 6.00.3790.2666" name="GENERATOR">

<link href="resources/css/table.css" rel="stylesheet" type="text/css" />
<link href="resources/css/index.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.stat_choose {
	width: 500px;
	height: 30px;
	margin: 0 auto;
	padding: 30px 10px 10px;
}

.stat_choose ul {
	position: relative;
	margin: 0 auto;
}

.stat_choose ul li {
	position: relative;
	float: left;
	margin: 0 2px;
	height: 29px;
	font-size: 14px;
	cursor: pointer;
}

.stat_choose ul li span {
	z-index: 0;
	color: #307D74;
	padding: 7px 11px;
	font-family: 黑体;
}

.stat_choose ul li.current {
	z-index: 2;
	font-size: 16px; /*font-weight:700;*/
	cursor: default;
}

.stat_choose ul li.current span {
	border-bottom: 2px solid #00F;
	color: #77A
}

.suptype_choose {
	width: 400px;
	height: 30px;
	margin: 0 auto;
}

.suptype_choose ul {
	position: relative;
	margin: 0 auto;
}

.suptype_choose ul li {
	position: relative;
	float: left;
	margin: 0 2px;
	height: 29px;
	font-size: 12px;
	cursor: pointer;
}

.suptype_choose ul li span {
	z-index: 0;
	color: #307D74;
	padding: 7px 11px;
	font-family: 黑体;
}

.suptype_choose ul li.current {
	z-index: 2;
	font-size: 14px;
	cursor: default;
}

.suptype_choose ul li.current span {
	border-bottom: 2px solid #00F;
	color: #77A
}
</style>

<script type="text/javascript" src="resources/javascript/jquery-1.7.1.min.js"></script>
<script src="resources/javascript/highcharts.js"></script>
<!-- <script src="resources/javascript/modules/exporting.js"></script> -->

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
	function set_producttype()
	{
		var requestTest = "<?xml version='1.0' encoding='UTF-8'?><Request>" +
		"<header>" +
			"<responseSystemName>Navy</responseSystemName>" +
			"<responseSubsystemName>DictManage</responseSubsystemName>" +
			"<responseService>ProductTypeQueryService</responseService>" +
			"<dispatcherUrl></dispatcherUrl>" +
		"</header>" +
		"<DTO></DTO></Request>";
	
		var request = getRequest();
		var url = '<%=request.getContextPath()%>/systemxhr?opt=&XML_DATA='+escape(requestTest);
		request.open('POST',url,true);
		request.onreadystatechange = function()
		{
			if (request.readyState==4 && request.status==200)
			{
				//console.log(request.responseText);
				//alert("waiting for creating tree...");
				var xmldata1 = request.responseXML.selectSingleNode("Response/DTO/DICT_LIST/Row/LIS_RESULT/Row");
				while (xmldata1)
				{
					var xmlname1 = xmldata1.selectSingleNode("STR_DICTNAME");
					var xmlcode1 = xmldata1.selectSingleNode("STR_DICTCODE");
					if (xmlname1 && xmlcode1)
					{
						var item1 = new treeItem(xmlname1.text, "javascript:setvalue('" + xmlname1.text + "', '" + xmlcode1.text + "');", "_self");
						item1.setup(document.getElementById("protypetree"));
						
						var xmldata2 = xmldata1.selectSingleNode("CHILDREN/Row");
						while (xmldata2)
						{
							var xmlname2 = xmldata2.selectSingleNode("STR_DICTNAME");
							var xmlcode2 = xmldata2.selectSingleNode("STR_DICTCODE");
							if (xmlname2 && xmlcode2)
							{
								var item2 = new treeItem(xmlname2.text, "javascript:setvalue('" + xmlname2.text + "', '" + xmlcode2.text + "');", "_self");
								item1.add(item2);

								var xmldata3 = xmldata2.selectSingleNode("CHILDREN/Row");
								while (xmldata3)
								{
									var xmlname3 = xmldata3.selectSingleNode("STR_DICTNAME");
									var xmlcode3 = xmldata3.selectSingleNode("STR_DICTCODE");
									if (xmlname3 && xmlcode3)
									{
										var item3 = new treeItem(xmlname3.text, "javascript:setvalue('" + xmlname3.text + "', '" + xmlcode3.text + "');", "_self");
										item2.add(item3);
									}
									xmldata3 = xmldata3.nextSibling;
								}
							}
							xmldata2 = xmldata2.nextSibling;
						}
					}
					xmldata1 = xmldata1.nextSibling;
				}

				document.getElementById("protypenotify").style.display = "none";
			}
		};
		request.send(null);
	}
</script>

<script type="text/javascript">

var chart;

function changeStat(type) {
	setLiCurrent(type);
	if (type == 1) {
		$('#div_suptypediv').hide();
		$('#div_protypediv').hide();
		chart.destroy();
		submit_form('Navy','NavyManage','SupSupportorCountStatService','/pages/navy/supmanage/supSupportorStat.jsp');
	}
	else if (type == 2) {
		$('#div_suptypediv').hide();
		$('#div_protypediv').show();
	}
	else if (type == 3) {
		$('#div_suptypediv').show();
		$('#div_protypediv').hide();
		chart.destroy();
		submit_form('Navy','NavyManage','SupSupportorTypeCountStatService','/pages/navy/supmanage/supSupportorStat.jsp');
	}
	else {
	}
}
function setLiCurrent(type) {
	if (type == 1) {
		$('li#li_supcount').addClass('current');
		$('li#li_prodcap').removeClass('current');
		$('li#li_suptype').removeClass('current');
	}
	else if (type == 2) {
		$('li#li_supcount').removeClass('current');
		$('li#li_prodcap').addClass('current');
		$('li#li_suptype').removeClass('current');
	}
	else if (type == 3) {
		$('li#li_supcount').removeClass('current');
		$('li#li_prodcap').removeClass('current');
		$('li#li_suptype').addClass('current');
	}
}

function createChart(titleText, xCategories, yTitle, isAllowDecimals, tooltipText, sdata) {
	var chart = new Highcharts.Chart({
		chart: {
			renderTo: 'container',
			type: 'column'
		},
		title: {
			text: titleText
		},
		credits: {
			enabled: false
		},
		xAxis: {
			categories: xCategories,
			labels: {
				rotation: -45,
				align: 'right',
				style: {
					fontSize: '13px',
					fontFamily: '宋体'
				}
			}
		},
		yAxis: {
			min: 0,
			allowDecimals: isAllowDecimals,
			title: {
				text: yTitle
			}
		},
		legend: {
			layout: 'vertical',
			backgroundColor: '#FFFFFF',
			align: 'left',
			verticalAlign: 'top',
			x: 100,
			y: 70,
			floating: true,
			shadow: true
		},
		tooltip: {
			formatter: function() {
				return '<b>'+this.x+'</b><br/>'+tooltipText+'： '+this.y;
			}
		},
		plotOptions: {
			column: {
				pointPadding: 0.2,
				borderWidth: 0
			}
		},
		series: [{
			name: '数目',
			data: sdata
		}]
	});
	return chart;
}

<%  if (statType == 3)
	{%>
		var keys1 = [];
		var values1 = [];
		var keys2 = [];
		var values2 = [];
		var keys3 = [];
		var values3 = [];
		var mapdata1 = [];
		var mapdata2 = [];
		var mapdata3 = [];
<%	}%>

$(function () {
    $(document).ready(function() {
    	setLiCurrent(<%=statType%>);
<%  if (statType == 1)
	{%>
		var keys = [];
		var values = [];
		<% 
		for (Entry<String, Integer> item : supStat.getMapnum().entrySet())
		{%>
			keys.push('<%=item.getKey()%>');
			values.push(<%=item.getValue()%>);
		<%}%>
		chart = createChart('供应商个数统计', keys, '供应商个数 (个)', false, '供应商个数', values);
/*		chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'column'
            },
            title: {
                text: '供应商个数统计'
            },
        	credits: {
        		enabled: false
        	},
            xAxis: {
                categories: keys,
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: '宋体'
                    }
                }
            },
            yAxis: {
                min: 0,
                allowDecimals: false,
                title: {
                    text: '供应商个数 (个)'
                }
            },
            legend: {
                layout: 'vertical',
                backgroundColor: '#FFFFFF',
                align: 'left',
                verticalAlign: 'top',
                x: 100,
                y: 70,
                floating: true,
                shadow: true
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.x +'</b><br/>'+
                    '供应商个数： '+ this.y;
                }
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                name: '个数',
                data: values,
                dataLabels: {
                    enabled: true,
                    rotation: -90,
                    color: '#FFFFFF',
                    align: 'right',
                    x: -3,
                    y: 10,
                    formatter: function() {
                        return this.y;
                    },
                    style: {
                        fontSize: '13px',
                        fontFamily: 'Verdana, sans-serif'
                    }
                }
            }]
        }); */
<%	}
	else if (statType == 2)
	{%>
		$('#div_protypediv').show();
		var keys = [];
		var values = [];
		<% 
		for (Entry<String, Double> item : supStat.getMapcapacity().entrySet())
		{%>
			keys.push('<%=item.getKey()%>');
			values.push(<%=item.getValue()%>);
		<%}%>
		chart = createChart('产品产能统计', keys, '产品产能数目', true, '产品产能合计', values);
/*    	chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                type: 'column'
            },
            title: {
                text: '产品产能统计'
            },
        	credits: {
        		enabled: false
        	},
            xAxis: {
                categories: keys,
                labels: {
                    rotation: -45,
                    align: 'right',
                    style: {
                        fontSize: '13px',
                        fontFamily: '宋体'
                    }
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '产品产能'
                }
            },
            legend: {
                layout: 'vertical',
                backgroundColor: '#FFFFFF',
                align: 'left',
                verticalAlign: 'top',
                x: 100,
                y: 70,
                floating: true,
                shadow: true
            },
            tooltip: {
                formatter: function() {
                    return '<b>'+ this.x +'</b><br/>'+
                    '产品产能合计： '+ this.y;
                }
            },
            plotOptions: {
                column: {
                    pointPadding: 0.2,
                    borderWidth: 0
                }
            },
            series: [{
                name: '数目',
                data: values
            }]
        }); */
<%	}
	else if (statType == 3)
	{%>
		$('#div_suptypediv').show();
		<% 
		for (Entry<String, Integer> item : supStat.getMaptype().entrySet())
		{%>
			keys1.push('<%=item.getKey()%>');
			values1.push(<%=item.getValue()%>);
		<%}%>
		<% 
		for (Entry<String, Integer> item : supStat.getMapeconomy().entrySet())
		{%>
			keys2.push('<%=item.getKey()%>');
			values2.push(<%=item.getValue()%>);
		<%}%>
		<% 
		for (Entry<String, Integer> item : supStat.getMappruchase().entrySet())
		{%>
			keys3.push('<%=item.getKey()%>');
			values3.push(<%=item.getValue()%>);
		<%}%>
		
		chart = createChart('供应商类型统计', keys1, '供应商个数 (个)', false, '供应商个数', values1);
<%	}%>
    });
});

<%	if (statType == 3) {%>
function changeSupType(type) {
	if (type == 1) {
		$('li#supli_suptype').addClass('current');
		$('li#supli_supecon').removeClass('current');
		$('li#supli_suppur').removeClass('current');
		chart.destroy();
		chart = createChart('供应商类型统计', keys1, '供应商个数 (个)', false, '供应商个数', values1);
	}
	else if (type == 2) {
		$('li#supli_suptype').removeClass('current');
		$('li#supli_supecon').addClass('current');
		$('li#supli_suppur').removeClass('current');
		chart.destroy();
		chart = createChart('供应商经济类型统计', keys2, '供应商个数 (个)', false, '供应商个数', values2);
	}
	else if (type == 3) {
		$('li#supli_suptype').removeClass('current');
		$('li#supli_supecon').removeClass('current');
		$('li#supli_suppur').addClass('current');
		chart.destroy();
		chart = createChart('供应商采购类型统计', keys3, '供应商个数 (个)', false, '供应商个数', values3);
	}
	else {
	}
}
<%	}%>
		</script>

</head>

<body
	style="background: url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color: #ffffff;"
	onload="init('Navy','NavyManage','SupSupportorCountStatService','/pages/navy/supmanage/supSupportorStat.jsp');">
	<form action="system" method="post">
		<input type="hidden" name="opt" id="opt">
		<input id="XML_DATA" name="XML_DATA" type="hidden" value="">

		<center>
			<table width="100%" height="100%" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td valign="top" height="1">
						<div id="site">&nbsp;当前位置：供应商信息统计</div>
					</td>
				</tr>
				<tr>
					<td valign="top" align="center" height="1">
						<div class="stat_choose">
							<ul>
								<li id="li_supcount" onclick="changeStat(1);"><span>供应商区域数量统计</span></li>
								<li>|</li>
								<li id="li_prodcap" onclick="changeStat(2);"><span>产品产能统计</span></li>
								<li>|</li>
								<li id="li_suptype" onclick="changeStat(3);"><span>供应商类型统计</span></li>
							</ul>
						</div>
						<div id="div_protypediv" style="display:none; margin:0 auto; font-size:14px;">
							<input id="STR_QUERY_GOODNAME" name="STR_QUERY_GOODNAME" style="width:150px; text-align:center; color:red" readonly="readonly"
								value="<%= queryParam.getString("QUERY_GOODNAME") == null ? "-请选择产品分类-" : queryParam.getString("QUERY_GOODNAME") %>" />
							<input id="STR_QUERY_PRODCODE" name="STR_QUERY_PRODCODE" style="width:150px" type="hidden"
								value="<%= queryParam.getString("QUERY_PRODCODE") == null ? "" : queryParam.getString("QUERY_PRODCODE") %>" />
							<a id="a_protypediv" class="link_blue_table" href="javascript:void(0)" onclick="showProtypeTree(this);">显示产品编目</a>
							<div id="protypediv" align="left" style="position:absolute; display:none; overflow:auto; z-index:999; background-color:#FFFFFF; border:solid 1px #000000; padding:5px; width:250px; height:300px;" >
								<div id="protypenotify">请稍等...</div>
								<div id="protypetree"></div>
							</div>
							<script type="text/javascript">
								var protypetreeInit = 0;
								function showProtypeTree(obj)
								{
									ScriptHelper.showDivCommon(obj,'protypediv');
									if (protypetreeInit == 0)
									{
										set_producttype();
										protypetreeInit = 1;
									}
									if (document.getElementById("a_protypediv").innerText == "显示产品编目")
										document.getElementById("a_protypediv").innerText = "隐藏产品编目";
									else
										document.getElementById("a_protypediv").innerText = "显示产品编目";
								}
			
								function setvalue(value1, value2)
								{
									document.getElementById("STR_QUERY_GOODNAME").innerText = value1;
									document.getElementById("STR_QUERY_PRODCODE").value = value2;
									submit_form('Navy','NavyManage','SupSupportorProdCapStatService','/pages/navy/supmanage/supSupportorStat.jsp');
								}
							</script>
						</div>
						<div id="div_suptypediv" style="display:none; margin:0 auto; font-size:14px;">
							<div class="suptype_choose">
								<ul>
									<li id="supli_suptype" class="current" onclick="changeSupType(1);"><span>供应商类型</span></li>
									<li>|</li>
									<li id="supli_supecon" onclick="changeSupType(2);"><span>供应商经济类型</span></li>
									<li>|</li>
									<li id="supli_suppur" onclick="changeSupType(3);"><span>供应商采购类型</span></li>
								</ul>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<td valign="top" align="center">
						<div style="overflow:auto; height:500px; padding 10px auto 0">
						<div id="container"
							style="min-width: 400px; width: 800px; height: 400px; margin: 0 auto; padding: 20px auto 0;">
						</div>
						</div>
					</td>
				</tr>
			</table>
		</center>
	</form>
	<iframe id="download" src="" width="0" height="0" frameborder="0"></iframe>
</body>
</html>