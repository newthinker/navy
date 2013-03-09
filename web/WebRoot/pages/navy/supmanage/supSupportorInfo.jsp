<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ include file="../../common/init.jsp" %>
<%
	List dictlist = (List)resp.getDto().getSelectItems();
	
	if (dictlist == null) {
		dictlist = new ArrayList();
		
		DTO dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
		
		dto = new DTO();
		dto.setList("RESULT", new ArrayList());
		dictlist.add(dto);
	}
	
	DTO type = (DTO)dictlist.get(0);
	DTO bank = (DTO)dictlist.get(1);
	DTO credit = (DTO)dictlist.get(2);
	
	DTO supportor = null;
	DTO transport = null;
	DTO highway = null;
	List typeList = (List)resp.getDto().getList("RESULT");
	if (typeList != null) {
		if (typeList.size() > 0) {
			supportor = (DTO) typeList.get(0);
		}
		if (typeList.size() > 1) {
			transport = (DTO) typeList.get(1);
		}
		if (typeList.size() > 2) {
			highway = (DTO) typeList.get(2);
		}
	}
	
	if (supportor == null) {
		supportor = new DTO();
	}
	if (transport == null) {
		transport = new DTO();
	}
	if (highway == null) {
		highway = new DTO();
	}
	
	SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
	String src = request.getParameter("src");
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
		</style>
		<script language="javascript" src="resources/javascript/iOffice_Popup.js"></script>
		<script language="javascript" src="resources/javascript/hdcube.js"></script>

		<script type="text/javascript">
		</script>
	</head>
	
	<body style="background:url(resources/images/common/tbl_bg.gif) top left repeat-x; background-color:#ffffff;" scroll="yes">
		<form action="system" method="post">
			<jsp:include page="supSupportorQueryParam.jsp"></jsp:include>
			<input type="hidden" name="opt" id="opt">
			<input id="str_supid" name="str_supid" type="hidden" value="<%= supportor.getString("SUPID") %>">
			<input id="XML_DATA" name="XML_DATA" type="hidden" value="">
			
			<input id="STR_TYPE" name="STR_TYPE" type="hidden" />
			<input id="STR_CREDIT" name="STR_CREDIT" type="hidden" />
			
			<div id="site">
				当前位置：
				供应商信息管理&gt;&gt;
				<span>供应商信息查看</span>
			</div>
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td colspan="3" height="5px">
					</td>
				</tr>
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">基础信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="15%">
									供应商名称
								</th>
								<td width="35%">
									<%= supportor.getString("SUPNAME") == null ? "" : supportor.getString("SUPNAME") %>&nbsp;
								</td>
								<th width="15%">
									供应商英文名称
								</th>
								<td width="35%">
									<%= supportor.getString("SUPENNAME") == null ? "" : supportor.getString("SUPENNAME") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									成立时间
								</th>
								<td>
									<%= supportor.getDate("CREATEDATE") == null ? "" : fmtDate.format(supportor.getDate("CREATEDATE")) %>&nbsp;
								</td>
								<th>
									公司简称
								</th>
								<td>
									<%= supportor.getString("ABBREVIATION") == null ? "" : supportor.getString("ABBREVIATION") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									注册地址
								</th>
								<td>
									<%= supportor.getString("ADDRESS") == null ? "" : supportor.getString("ADDRESS") %>&nbsp;
								</td>
								<th>
									邮政编码
								</th>
								<td>
									<%= supportor.getString("POSTCODE") == null ? "" : supportor.getString("POSTCODE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									所在地址
								</th>
								<td>
									<%= supportor.getString("LOCATION") == null ? "" : supportor.getString("LOCATION") %>&nbsp;
								</td>
								<th>
									位置
								</th>
								<td>
									经度：
									<%= supportor.showString("LONGITUDE") %>
									&nbsp;
									纬度：
									<%= supportor.showString("LATITUDE") %>
								</td>
							</tr>
							<tr>
								<th>
									网址
								</th>
								<td>
									&nbsp;<a target="_blank" class="link_blue" href="<%= (supportor.showString("NETADDR").toLowerCase().indexOf("http://") > 0) ? supportor.showString("NETADDR") : "http://" + supportor.showString("NETADDR") %>"><%= supportor.getString("NETADDR") == null ? "" : supportor.getString("NETADDR") %></a>&nbsp;
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									经济性质
								</th>
								<td>
									<%= supportor.getString("ECONOMY") == null ? "" : supportor.getString("ECONOMY") %>&nbsp;
								</td>
								<th>
									供应商类型
								</th>
								<td>
									<%= supportor.showString("TYPE", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									开户银行
								</th>
								<td>
									<%= supportor.getString("BANK") == null ? "" : supportor.getString("BANK") %>&nbsp;
								</td>
								<th>
									银行账号
								</th>
								<td>
									<%= supportor.getString("ACCOUNT") == null ? "" : supportor.getString("ACCOUNT") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									信用等级
								</th>
								<td>
									<%= supportor.getString("CREDIT") == null ? "" : supportor.getString("CREDIT") %>&nbsp;
								</td>
								<th>
									信用等级评定机构
								</th>
								<td>
									<%= supportor.getString("CREDITORG") == null ? "" : supportor.getString("CREDITORG") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									评定时间
								</th>
								<td>
									<%= supportor.getDate("CREDITDATE") == null ? "" : fmtDate.format(supportor.getDate("CREDITDATE")) %>&nbsp;
								</td>
								<th>
									类型
								</th>
								<td>
									<%= supportor.getString("SUPTYPE") == null ? "" : supportor.getString("SUPTYPE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									是否依法缴纳社会保险
								</th>
								<td>
									<%= supportor.getString("INSURANCE") == null ? "" : supportor.getString("INSURANCE") %>&nbsp;
								</td>
								<th>
									近三年有无重大违法记录
								</th>
								<td>
									<%= supportor.getString("ILLEGAL") == null ? "" : supportor.getString("ILLEGAL") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									组织机构代码
								</th>
								<td>
									<%= supportor.getString("ORGANIZECODE") == null ? "" : supportor.getString("ORGANIZECODE") %>&nbsp;
								</td>
								<th>
									组织机构代码证
								</th>
								<td>
									<% if (supportor.getString("ORGSTRIMAGE") == null
										|| supportor.getString("ORGSTRIMAGE").equals("")) { %>
									&nbsp;
									<% } else { %>
									<a href="pages/navy/supmanage/supImages.jsp?imageid=<%= supportor.getString("ORGSTRIMAGE") %>" class="link_blue_table" target="_blank">查看扫描件</a>&nbsp;
									<% } %>
								</td>
							</tr>
							<tr>
								<th>
									银行资信证明
								</th>
								<td>
									<% if (supportor.getString("BANKPROVE") == null
										|| supportor.getString("BANKPROVE").equals("")) { %>
									&nbsp;
									<% } else { %>
									<a href="pages/navy/supmanage/supImages.jsp?imageid=<%= supportor.getString("BANKPROVE") %>" class="link_blue_table" target="_blank">查看扫描件</a>&nbsp;
									<% } %>
								</td>
								<th>
									质量管理认证
								</th>
								<td>
									<% if (supportor.getString("QUALITYPROVE") == null
										|| supportor.getString("QUALITYPROVE").equals("")) { %>
									&nbsp;
									<% } else { %>
									<a href="pages/navy/supmanage/supImages.jsp?imageid=<%= supportor.getString("QUALITYPROVE") %>" class="link_blue_table" target="_blank">查看扫描件</a>&nbsp;
									<% } %>
								</td>
							</tr>
							<tr>
								<th>
									特定资质证书
								</th>
								<td>
									<% if (supportor.getString("OTHERPROVE") == null
										|| supportor.getString("OTHERPROVE").equals("")) { %>
									&nbsp;
									<% } else { %>
									<a href="pages/navy/supmanage/supImages.jsp?imageid=<%= supportor.getString("OTHERPROVE") %>" class="link_blue_table" target="_blank">下载</a>&nbsp;
									<% } %>
								</td>
								<th>
									近三年审计报告扫描件打包
								</th>
								<td>
									<% if (supportor.getString("AUDITLAST3Y") == null
										|| supportor.getString("AUDITLAST3Y").equals("")) { %>
									&nbsp;
									<% } else { %>
									<a href="pages/navy/supmanage/supImages.jsp?imageid=<%= supportor.getString("AUDITLAST3Y") %>" class="link_blue_table" target="_blank">下载</a>&nbsp;
									<% } %>
								</td>
							</tr>
							<tr>
								<th>
									供应商简介
								</th>
								<td colspan="3">
									<textarea readonly="readonly" name="STR_SUMMARY" id="STR_SUMMARY" rows="5" cols="10"><%= supportor.getString("SUMMARY") == null ? "" : supportor.getString("SUMMARY") %></textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">法人信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="15%">
									法定代表人
								</th>
								<td width="35%">
									<%= supportor.getString("CORPORATION") == null ? "" : supportor.getString("CORPORATION") %>&nbsp;
								</td>
								<th width="15%">
									固定电话
								</th>
								<td width="35%">
									<%= supportor.getString("CORPPHONE") == null ? "" : supportor.getString("CORPPHONE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									手机
								</th>
								<td>
									<%= supportor.getString("CORPMOBILE") == null ? "" : supportor.getString("CORPMOBILE") %>&nbsp;
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">注册联系人信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="15%">
									注册登记联系人
								</th>
								<td width="35%">
									<%= supportor.getString("CONTACT") == null ? "" : supportor.getString("CONTACT") %>&nbsp;
								</td>
								<th width="15%">
									固定电话
								</th>
								<td width="35%">
									<%= supportor.getString("CONTACTPHONE") == null ? "" : supportor.getString("CONTACTPHONE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									手机
								</th>
								<td>
									<%= supportor.getString("CONTACTMOBILE") == null ? "" : supportor.getString("CONTACTMOBILE") %>&nbsp;
								</td>
								<th>
									传真
								</th>
								<td>
									<%= supportor.getString("CONTACTFAX") == null ? "" : supportor.getString("CONTACTFAX") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									电子邮箱
								</th>
								<td>
									<%= supportor.getString("CONTACTEMAIL") == null ? "" : supportor.getString("CONTACTEMAIL") %>&nbsp;
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">营业执照信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="15%">
									注册号
								</th>
								<td width="35%">
									<%= supportor.getString("LICNO") == null ? "" : supportor.getString("LICNO") %>&nbsp;
								</td>
								<th>
									营业执照或事业法人证
								</th>
								<td>
									<% if (supportor.getString("LICBUSIMAGE") == null
										|| supportor.getString("LICBUSIMAGE").equals("")) { %>
									&nbsp;
									<% } else { %>
									<a href="pages/navy/supmanage/supImages.jsp?imageid=<%= supportor.getString("LICBUSIMAGE") %>" class="link_blue_table" target="_blank">查看扫描片</a>&nbsp;
									<% } %>
								</td>
							</tr>
							<tr>
								<th width="15%">
									发证机关
								</th>
								<td width="35%">
									<%= supportor.getString("LICORG") == null ? "" : supportor.getString("LICORG") %>&nbsp;
								</td>
								<th>
									注册所在地
								</th>
								<td>
									<%= supportor.getString("LICADDR") == null ? "" : supportor.getString("LICADDR") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									有效期开始时间
								</th>
								<td>
									<%= supportor.getDate("LICVALSTART") == null ? "" : fmtDate.format(supportor.getDate("LICVALSTART")) %>&nbsp;
								</td>
								<th>
									有效期结束时间
								</th>
								<td>
									<%= supportor.getDate("LICVALEND") == null ? "" : fmtDate.format(supportor.getDate("LICVALEND")) %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									注册资本金
								</th>
								<td>
									<%= supportor.getNumber("LICCAPITAL") == null ? "" : supportor.getNumber("LICCAPITAL")%>&nbsp;&nbsp;万元
								</td>
								<th>
									最近年检时间
								</th>
								<td>
									<%= supportor.getDate("LICEXADATE") == null ? "" : fmtDate.format(supportor.getDate("LICEXADATE")) %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									主要经营范围
								</th>
								<td colspan="3">
									<textarea readonly="readonly" name="STR_LICMAINOPT" id="STR_LICMAINOPT" rows="5" cols="10"><%= supportor.getString("LICMAINOPT") == null ? "" : supportor.getString("LICMAINOPT") %></textarea>
								</td>
							</tr>
							<tr>
								<th>
									兼营经营范围
								</th>
								<td colspan="3">
									<textarea readonly="readonly" name="STR_LICOTHEROPT" id="STR_LICOTHEROPT" rows="5" cols="10"><%= supportor.getString("LICOTHEROPT") == null ? "" : supportor.getString("LICOTHEROPT") %></textarea>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">税务登记证(国税)</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="15%">
									登记证号
								</th>
								<td width="35%">
									<%= supportor.getString("STATETAXNO") == null ? "" : supportor.getString("STATETAXNO") %>&nbsp;
								</td>
								<th width="15%">
									发证机关
								</th>
								<td width="35%">
									<%= supportor.getString("STATETAXORG") == null ? "" : supportor.getString("STATETAXORG") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									有效期开始时间
								</th>
								<td>
									<%= supportor.getDate("STATETAXVALSTART") == null ? "" : fmtDate.format(supportor.getDate("STATETAXVALSTART")) %>&nbsp;
								</td>
								<th>
									有效期结束时间
								</th>
								<td>
									<%= supportor.getDate("STATETAXVALEND") == null ? "" : fmtDate.format(supportor.getDate("STATETAXVALEND")) %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									是否依法缴纳税收
								</th>
								<td>
									<%= supportor.getString("IFSTATETAX") == null ? "" : supportor.getString("IFSTATETAX") %>&nbsp;
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">税务登记证(地税)</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="15%">
									登记证号
								</th>
								<td width="35%">
									<%= supportor.getString("LOCALTAXNO") == null ? "" : supportor.getString("LOCALTAXNO") %>&nbsp;
								</td>
								<th width="15%">
									发证机关
								</th>
								<td width="35%">
									<%= supportor.getString("LOCALTAXORG") == null ? "" : supportor.getString("LOCALTAXORG") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									有效期开始时间
								</th>
								<td>
									<%= supportor.getDate("LOCALTAXVALSTART") == null ? "" : fmtDate.format(supportor.getDate("LOCALTAXVALSTART")) %>&nbsp;
								</td>
								<th>
									有效期结束时间
								</th>
								<td>
									<%= supportor.getDate("LOCALTAXVALEND") == null ? "" : fmtDate.format(supportor.getDate("LOCALTAXVALEND")) %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									是否依法缴纳税收
								</th>
								<td>
									<%= supportor.getString("IFLOCALTAX") == null ? "" : supportor.getString("IFLOCALTAX") %>&nbsp;
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">仓储信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="15%">
									仓库总面积
								</th>
								<td width="35%">
									<%= supportor.getNumber("STOREHOUSEAREA") == null ? "" : supportor.getNumber("STOREHOUSEAREA") %>&nbsp;
								</td>
								<th width="15%">
									货场总面积
								</th>
								<td width="35%">
									<%= supportor.getNumber("WAREHOUSEAREA") == null ? "" : supportor.getNumber("WAREHOUSEAREA") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									仓库照片
								</th>
								<td>
									<% if (supportor.getString("STOREHOUSEIMAGE") == null
										|| supportor.getString("STOREHOUSEIMAGE").equals("")) { %>
									&nbsp;
									<% } else { %>
									<a href="pages/navy/supmanage/supImages.jsp?imageid=<%= supportor.getString("STOREHOUSEIMAGE") %>" class="link_blue_table" target="_blank">查看图片</a>&nbsp;
									<% } %>
								</td>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">运输信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<table width="0%" border="0" cellpadding="0" cellspacing="0"
							class="tbl_search2_free">
							<tr>
								<th width="15%">
									提供运输的企业
								</th>
								<td width="35%">
									<%= transport.getString("COMNAME") == null ? "" : transport.getString("COMNAME") %>&nbsp;
								</td>
								<th width="15%">
									主要运输车类型
								</th>
								<td width="35%">
									<%= transport.getString("TRUCKTYPE") == null ? "" : transport.getString("TRUCKTYPE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									单车载重量
								</th>
								<td>
									<%= transport.getNumber("DEADWEIGHT") == null ? "" : transport.getNumber("DEADWEIGHT") %>&nbsp;
								</td>
								<th>
									数量（台）
								</th>
								<td>
									<%= transport.getNumber("COUNT") == null ? "" : transport.getNumber("COUNT") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									高速公路名称
								</th>
								<td>
									<%= highway.getString("HIWNAME") == null ? "" : highway.getString("HIWNAME") %>&nbsp;
								</td>
								<th>
									高速公路编号
								</th>
								<td>
									<%= highway.getString("HIWID") == null ? "" : highway.getString("HIWID") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									高速公路入口名称
								</th>
								<td>
									<%= highway.getString("HIWIN") == null ? "" : highway.getString("HIWIN") %>&nbsp;
								</td>
								<th>
									高速公路入口编号
								</th>
								<td>
									<%= highway.getString("HIWINID") == null ? "" : highway.getString("HIWINID") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									&nbsp;
								</th>
								<td>
									&nbsp;
								</td>
								<th>
									高速公路入口距离
								</th>
								<td>
									<%= highway.getNumber("HIWDIS") == null ? "" : highway.getNumber("HIWDIS") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									最近铁路货运站
								</th>
								<td>
									<%= transport.getString("NEARRAILWAY") == null ? "" : transport.getString("NEARRAILWAY") %>&nbsp;
								</td>
								<th>
									货运站距离
								</th>
								<td>
									<%= transport.getNumber("RWDIS") == null ? "" : transport.getNumber("RWDIS") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									最近港口
								</th>
								<td>
									<%= transport.getString("NEARPORT") == null ? "" : transport.getString("NEARPORT") %>&nbsp;
								</td>
								<th>
									港口距离
								</th>
								<td>
									<%= transport.getNumber("PORTDIS") == null ? "" : transport.getNumber("PORTDIS") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									最近机场
								</th>
								<td>
									<%= transport.getString("NEARAIRPORT") == null ? "" : transport.getString("NEARAIRPORT") %>&nbsp;
								</td>
								<th>
									机场距离
								</th>
								<td>
									<%= transport.getNumber("APDIS") == null ? "" : transport.getNumber("APDIS") %>&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">产品信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<iframe src="pages/navy/supmanage/supSupportorProdQueryDetail.jsp?supid=<%= supportor.showString("SUPID") %>"
							frameborder="0" scrolling="no" width="100%" height="310"></iframe>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">供应商出资(股东)信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<iframe src="pages/navy/supmanage/supSupportorStockQueryDetail.jsp?supid=<%= supportor.showString("SUPID") %>"
							frameborder="0" scrolling="no" width="100%" height="310"></iframe>
					</td>
				</tr>
			</table>
			<br />
			<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr style="background: url(resources/images/common/tab_cornerbg.gif); background-repeat: repeat-x;">
					<td width="17"><img src="resources/images/common/tab_cornerleft.gif" width="17" height="27" /></td>
					<td width="1195">
						<div class="fen_div_title">售后服务机构信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<iframe src="pages/navy/supmanage/supSupportorSaleOrgQueryDetail.jsp?supid=<%= supportor.showString("SUPID") %>"
							frameborder="0" scrolling="no" width="100%" height="310"></iframe>
					</td>
				</tr>
			</table>
			<div class="btu">
				<input type="button" name="back" id="button" value="返 回" class="btu_input"
					onclick="submit_form('Navy', 'NavyManage', 'SupSupportorQueryService', '/pages/navy/supmanage/supSupportorQuery.jsp');" />
			</div>
		</form>
		<script type="text/javascript">
			<% if (resp != null && resp.getErrorInfo() != null) { %>&nbsp;
				alert("<%= resp.getErrorInfo() %>&nbsp;");
			<% } else if (resp.getDto().get("RESULT") != null && (Integer)resp.getDto().get("RESULT") > 0) { %>
				alert("保存成功！");
			<% 
				}
			%>
		</script>
	</body>
</html>