<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
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
		
		<title></title>
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
                    '北京市',
                    '河北省',
                    '山东省',
                    'Seoul',
                    'Manila',
                    'Mumbai',
                    'Sao Paulo',
                    'Mexico City',
                    'Dehli',
                    'Osaka',
                    'Cairo',
                    'Kolkata',
                    'Los Angeles',
                    'Shanghai',
                    'Moscow',
                    'Beijing',
                    'Buenos Aires',
                    'Guangzhou',
                    'Shenzhen',
                    'Istanbul'
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
                data: [34.4, 21.8, 20.1, 20, 19.6, 19.5, 19.1, 18.4, 18,
                    17.3, 16.8, 15, 14.7, 14.5, 13.3, 12.8, 12.4, 11.8,
                    11.7, 11.2],
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
		
	</head>
	
	<body  style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;"
		onload="init('Navy','NavyManage','SupportorProductStatService','/pages/navy/supportormanage/supSupportorStat.jsp');">
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
											
										}
										else if (type == 2) {
											
										}
										else if (type == 3) {
											
										}
										else {
										}
									}
									function setLiCurrent(node) {
										if (node == 'li_supcount') {
											$('li#li_supcount').addClass('current');
											$('li#li_prodcap').removeClass('current');
											$('li#li_suptype').removeClass('current');
										}
										else if (node == 'li_prodcap') {
											$('li#li_supcount').removeClass('current');
											$('li#li_prodcap').addClass('current');
											$('li#li_suptype').removeClass('current');
										}
										else if (node == 'li_suptype') {
											$('li#li_supcount').removeClass('current');
											$('li#li_prodcap').removeClass('current');
											$('li#li_suptype').addClass('current');
										}
									}
								</script>
								<ul>
									<li id="li_supcount" class="current" onclick="changeStat(1);setLiCurrent(this.id);"><span>供应商区域数量统计</span></li>
									<li>|</li>
									<li id="li_prodcap" onclick="changeStat(2);setLiCurrent(this.id);"><span>产品产能统计</span></li>
									<li>|</li>
									<li id="li_suptype" onclick="changeStat(3);setLiCurrent(this.id);"><span>供应商类型统计</span></li>
								</ul>
							</div>
						</td>
					</tr>
				<!-- 	<tr>
						<td valign="top" height="1">
						<jsp:include page="supSupportorQueryParam.jsp?mode=show"></jsp:include>
						</td>
					</tr>
					<tr>
						<td valign="top" height="25">
							<div id="btu_new">
								<img src="resources/images/common/btn_search.gif" alt=" " width="62" height="22"
									onclick="submit_form('Navy','NavyManage','SupportorProductStatService','/pages/navy/supportormanage/supSupportorStat.jsp');" /> 
							</div>
						</td>
					</tr> -->
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