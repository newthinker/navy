<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="cn.com.hd.dto.navy.TSupportorStat"%>
<%@ include file="../../common/init.jsp" %>
<%
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
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
			.stat_choose {width:500px;height:30px;margin:0 auto;padding:30px 10px 20px;}
			.stat_choose ul {position:relative;margin:0 auto;}
			.stat_choose ul li {position:relative;float:left;margin:0 2px;height:29px;font-size:14px;cursor:pointer;}
			.stat_choose ul li span {z-index:0;color:#307D74;padding:7px 11px;font-family:黑体;}
			.stat_choose ul li.current {z-index:2;font-size:16px;/*font-weight:700;*/cursor:default;}
			.stat_choose ul li.current span {border-bottom:2px solid #00F;color:#77A}
		</style>
		
		<script type="text/javascript" src="resources/javascript/jquery-1.7.1.min.js"></script>
		<script src="resources/javascript/highcharts.js"></script>
	<!-- <script src="resources/javascript/modules/exporting.js"></script> -->
		
<%  if (statType == 1)
	{%>
		<script type="text/javascript">
$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
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
                categories: [
                    <% 
                    for (Entry<String, Integer> item : supStat.getMapnum().entrySet())
                    {%>
                    '<%=item.getKey()%>',
                    <%}%>
                ],
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
                data: [
                       <% 
                       for (Entry<String, Integer> item : supStat.getMapnum().entrySet())
                       {%>
                       '<%=item.getValue()%>',
                       <%}%>
				],
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
        });
    });
});
		</script>
<%	}%>
		
	</head>
	
	<body  style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;"
		onload="init('Navy','NavyManage','SupSupportorCountStatService','/pages/navy/supportormanage/supSupportorStat.jsp');">
		<form action="system" method="post">
			<input type="hidden" name="opt" id="opt">
			<input id="STR_PRODCODE" name="STR_PRODCODE" type="hidden" value="">
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
								<script type="text/javascript">
									function changeStat(type) {
										if (type == 1) {
											submit_form('Navy','NavyManage','SupSupportorCountStatService','/pages/navy/supportormanage/supSupportorStat.jsp');
										}
										else if (type == 2) {
											//submit_form('Navy','NavyManage','SupSupportorProdCapStatService','/pages/navy/supportormanage/supSupportorStat.jsp');
										}
										else if (type == 3) {
											submit_form('Navy','NavyManage','SupSupportorTypeCountStatService','/pages/navy/supportormanage/supSupportorStat.jsp');
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
								</script>
								<ul>
									<li id="li_supcount" onclick="changeStat(1);setLiCurrent(1);"><span>供应商区域数量统计</span></li>
									<li>|</li>
									<li id="li_prodcap" onclick="changeStat(2);setLiCurrent(2);"><span>产品产能统计</span></li>
									<li>|</li>
									<li id="li_suptype" onclick="changeStat(3);setLiCurrent(3);"><span>供应商类型统计</span></li>
								</ul>
								<script type="text/javascript">
									setLiCurrent(<%=statType%>);
								</script>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" align="center">
							<div id="container" style="min-width:400px; width:800px; height:400px; margin:0 auto; padding:20px auto 0;">
							</div>
						</td>
					</tr>
				</table>
			</center>
		</form>
		<iframe id="download" src="" width="0" height="0" frameborder="0"></iframe>
	</body>
</html>