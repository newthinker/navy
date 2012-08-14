<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	
	List typeList = (List)resp.getDto().getList("RESULT");
	DTO dto = new DTO();
	if (typeList != null && typeList.size() > 0) {
		dto = (DTO) typeList.get(0);
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
			<input id="str_supid" name="str_supid" type="hidden" value="<%= dto.getString("SUPID") %>">
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
									<%= dto.getString("SUPNAME") == null ? "" : dto.getString("SUPNAME") %>&nbsp;
								</td>
								<th width="15%">
									供应商英文名称
								</th>
								<td width="35%">
									<%= dto.getString("SUPENNAME") == null ? "" : dto.getString("SUPENNAME") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									成立时间
								</th>
								<td>
									<%= dto.getDate("CREATEDATE") == null ? "" : fmtDate.format(dto.getDate("CREATEDATE")) %>&nbsp;
								</td>
								<th>
									公司简称
								</th>
								<td>
									<%= dto.getString("ABBREVIATION") == null ? "" : dto.getString("ABBREVIATION") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									注册地址
								</th>
								<td>
									<%= dto.getString("ADDRESS") == null ? "" : dto.getString("ADDRESS") %>&nbsp;
								</td>
								<th>
									邮政编码
								</th>
								<td>
									<%= dto.getString("POSTCODE") == null ? "" : dto.getString("POSTCODE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									所在地址
								</th>
								<td>
									<%= dto.getString("LOCATION") == null ? "" : dto.getString("LOCATION") %>
								</td>
								<th>
									位置
								</th>
								<td>
									经度：
									<%= dto.showString("LONGITUDE") %>
									&nbsp;
									纬度：
									<%= dto.showString("LATITUDE") %>
								</td>
							</tr>
							<tr>
								<th>
									网址
								</th>
								<td>
									<%= dto.getString("NETADDR") == null ? "" : dto.getString("NETADDR") %>&nbsp;
								</td>
								<th>
									组织机构代码
								</th>
								<td>
									<%= dto.getString("ORGANIZECODE") == null ? "" : dto.getString("ORGANIZECODE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									经济性质
								</th>
								<td>
									<%= dto.getString("ECONOMY") == null ? "" : dto.getString("ECONOMY") %>&nbsp;
								</td>
								<th>
									供应商类型
								</th>
								<td>
									<%= dto.showString("TYPE", "&nbsp;") %>
								</td>
							</tr>
							<tr>
								<th>
									开户银行
								</th>
								<td>
									<%= dto.getString("BANK") == null ? "" : dto.getString("BANK") %>&nbsp;
								</td>
								<th>
									银行账号
								</th>
								<td>
									<%= dto.getString("ACCOUNT") == null ? "" : dto.getString("ACCOUNT") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									信用等级
								</th>
								<td>
									<%= dto.getString("CREDIT") == null ? "" : dto.getString("CREDIT") %>&nbsp;
								</td>
								<th>
									信用等级评定机构
								</th>
								<td>
									<%= dto.getString("CREDITORG") == null ? "" : dto.getString("CREDITORG") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									评定时间
								</th>
								<td>
									<%= dto.getDate("CREDITDATE") == null ? "" : fmtDate.format(dto.getDate("CREDITDATE")) %>&nbsp;
								</td>
								<th>
									类型
								</th>
								<td>
									<%= dto.getString("SUPTYPE") == null ? "" : dto.getString("SUPTYPE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									是否依法缴纳社会保险
								</th>
								<td>
									<%= dto.getString("INSURANCE") == null ? "" : dto.getString("INSURANCE") %>&nbsp;
								</td>
								<th>
									近三年有无重大违法记录
								</th>
								<td>
									<%= dto.getString("ILLEGAL") == null ? "" : dto.getString("ILLEGAL") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									供应商简介
								</th>
								<td colspan="3">
									<textarea readonly="readonly" name="STR_SUMMARY" id="STR_SUMMARY" rows="5" cols="10"><%= dto.getString("SUMMARY") == null ? "" : dto.getString("SUMMARY") %></textarea>
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
									<%= dto.getString("CORPORATION") == null ? "" : dto.getString("CORPORATION") %>&nbsp;
								</td>
								<th width="15%">
									固定电话
								</th>
								<td width="35%">
									<%= dto.getString("CORPPHONE") == null ? "" : dto.getString("CORPPHONE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									手机
								</th>
								<td>
									<%= dto.getString("CORPMOBILE") == null ? "" : dto.getString("CORPMOBILE") %>&nbsp;
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
									<%= dto.getString("CONTACT") == null ? "" : dto.getString("CONTACT") %>&nbsp;
								</td>
								<th width="15%">
									固定电话
								</th>
								<td width="35%">
									<%= dto.getString("CONTACTPHONE") == null ? "" : dto.getString("CONTACTPHONE") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									手机
								</th>
								<td>
									<%= dto.getString("CONTACTMOBILE") == null ? "" : dto.getString("CONTACTMOBILE") %>&nbsp;
								</td>
								<th>
									传真
								</th>
								<td>
									<%= dto.getString("CONTACTFAX") == null ? "" : dto.getString("CONTACTFAX") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									电子邮箱
								</th>
								<td>
									<%= dto.getString("CONTACTEMAIL") == null ? "" : dto.getString("CONTACTEMAIL") %>&nbsp;
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
									<%= dto.getString("LICNO") == null ? "" : dto.getString("LICNO") %>&nbsp;
								</td>
								<th width="15%">
									发证机关
								</th>
								<td width="35%">
									<%= dto.getString("LICORG") == null ? "" : dto.getString("LICORG") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									注册资本金
								</th>
								<td>
									<%= dto.getNumber("LICCAPITAL") == null ? "" : dto.getNumber("LICCAPITAL").doubleValue() %>&nbsp;&nbsp;万元
								</td>
								<th>
									注册所在地
								</th>
								<td>
									<%= dto.getString("LICADDR") == null ? "" : dto.getString("LICADDR") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									有效期开始时间
								</th>
								<td>
									<%= dto.getDate("LICVALSTART") == null ? "" : fmtDate.format(dto.getDate("LICVALSTART")) %>&nbsp;
								</td>
								<th>
									有效期结束时间
								</th>
								<td>
									<%= dto.getDate("LICVALEND") == null ? "" : fmtDate.format(dto.getDate("LICVALEND")) %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									最近年检时间
								</th>
								<td>
									<%= dto.getDate("EXADATE") == null ? "" : fmtDate.format(dto.getDate("EXADATE")) %>&nbsp;
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
									主要经营范围
								</th>
								<td colspan="3">
									<textarea readonly="readonly" name="STR_LICMAINOPT" id="STR_LICMAINOPT" rows="5" cols="10"><%= dto.getString("LICMAINOPT") == null ? "" : dto.getString("LICMAINOPT") %></textarea>
								</td>
							</tr>
							<tr>
								<th>
									兼营经营范围
								</th>
								<td colspan="3">
									<textarea readonly="readonly" name="STR_LICOTHEROPT" id="STR_LICOTHEROPT" rows="5" cols="10"><%= dto.getString("LICOTHEROPT") == null ? "" : dto.getString("LICOTHEROPT") %></textarea>
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
									<%= dto.getString("STATETAXNO") == null ? "" : dto.getString("STATETAXNO") %>&nbsp;
								</td>
								<th width="15%">
									发证机关
								</th>
								<td width="35%">
									<%= dto.getString("STATETAXORG") == null ? "" : dto.getString("STATETAXORG") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									有效期开始时间
								</th>
								<td>
									<%= dto.getDate("STATETAXVALSTART") == null ? "" : fmtDate.format(dto.getDate("STATETAXVALSTART")) %>&nbsp;
								</td>
								<th>
									有效期结束时间
								</th>
								<td>
									<%= dto.getDate("STATETAXVALEND") == null ? "" : fmtDate.format(dto.getDate("STATETAXVALEND")) %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									是否依法缴纳税收
								</th>
								<td>
									<%= dto.getString("IFSTATETAX") == null ? "" : dto.getString("IFSTATETAX") %>&nbsp;
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
									<%= dto.getString("LOCALTAXNO") == null ? "" : dto.getString("LOCALTAXNO") %>&nbsp;
								</td>
								<th width="15%">
									发证机关
								</th>
								<td width="35%">
									<%= dto.getString("LOCALTAXORG") == null ? "" : dto.getString("LOCALTAXORG") %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									有效期开始时间
								</th>
								<td>
									<%= dto.getDate("LOCALTAXVALSTART") == null ? "" : fmtDate.format(dto.getDate("LOCALTAXVALSTART")) %>&nbsp;
								</td>
								<th>
									有效期结束时间
								</th>
								<td>
									<%= dto.getDate("LOCALTAXVALEND") == null ? "" : fmtDate.format(dto.getDate("LOCALTAXVALEND")) %>&nbsp;
								</td>
							</tr>
							<tr>
								<th>
									是否依法缴纳税收
								</th>
								<td>
									<%= dto.getString("IFLOCALTAX") == null ? "" : dto.getString("IFLOCALTAX") %>&nbsp;
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
						<div class="fen_div_title">产品信息</div>
					</td>
					<td width="17" align="right"><img src="resources/images/common/tab_cornerright.gif" width="17" height="27" /></td>
				</tr>
				<tr>
					<td colspan="3" style="border:1px solid #b9c5c9; border-top:none; background-color:#ffffff;">
						<iframe src="pages/navy/supmanage/supSupportorProdQueryDetail.jsp?supid=<%= dto.showString("SUPID") %>"
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
						<iframe src="pages/navy/supmanage/supSupportorStockQueryDetail.jsp?supid=<%= dto.showString("SUPID") %>"
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
						<iframe src="pages/navy/supmanage/supSupportorSaleOrgQueryDetail.jsp?supid=<%= dto.showString("SUPID") %>"
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