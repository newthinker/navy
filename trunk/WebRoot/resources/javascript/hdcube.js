//用来打开一个修改或者详细信息页面，负责检查是否有选中的值
function edit_fun(source, checkBoxName) {
	var j = 0;
	//因此循环所有复选框，获取页面中所有复选框对象
	var CheckBox_other = getCheckBoxOther(checkBoxName);
	if (typeof (CheckBox_other) == "undefined") {
		alert("\u6ca1\u6709\u627e\u5230\u9009\u4e2d\u7684\u8bb0\u5f55");
		return null;
	}
	if (typeof (CheckBox_other.length) == "undefined") {
		alert("\u6ca1\u6709\u627e\u5230\u9009\u4e2d\u7684\u8bb0\u5f55");
		return CheckBox_other;
	}
    //判断被选中的记录条数
	for (var i = 0; i < CheckBox_other.length; i++) {
		if (CheckBox_other[i].checked == true) {
			j = j + 1;
		}
	}
	if (j == 0) {
		alert("\u8bf7\u9009\u4e2d\u4e00\u6761\u8bb0\u5f55");
		return false;
	} else {
		if (j > 1) {
			alert("\u672c\u64cd\u4f5c\u53ea\u80fd\u9009\u62e9\u4e00\u6761\u8bb0\u5f55\uff0c\u60a8\u9009\u62e9\u4e86\u591a\u6761\u8bb0\u5f55");
			return false;
		} else {
			if (j == 1) {
    	//document.forms["formMakePlan"].elements["formMakePlan:hiddenSaveFaid"].value = selvalue;
				var faid = document.forms["formMakePlan"].elements["formMakePlan:hiddenSaveFaid"].value;
    	//popup = window.open(source + "?flag=edit&id=" + faid, "popup2", "height=600,width=700,toolbar=no,menubar=no");
    	//var content = source + "?flag=detail&id=" + faid;
		//winParam = "window.showModelessDialog('" + content + "',window,'dialogWidth:600px;dialogHeight:600px;";
		//winParam += "dialogLeft:200px;dialogTop:200px;resizable:no;scroll:0;help:0;status:0')";
		//objWindow = eval(winParam);
				return true;
			} else {
			}
		}
	}
}
//检查复选是否有选中（复选框）
function fun_checkSelected(checkBoxName) {
	var j = 0;
		//因此循环所有复选框，获取页面中所有复选框对象
	var CheckBox_other = getCheckBoxOther(checkBoxName);
	if (typeof (CheckBox_other) == "undefined") {
		alert("\u6ca1\u6709\u627e\u5230\u9009\u4e2d\u7684\u8bb0\u5f55");
		return null;
	}
	if (typeof (CheckBox_other.length) == "undefined") {
		alert("\u6ca1\u6709\u627e\u5230\u9009\u4e2d\u7684\u8bb0\u5f55");
		return CheckBox_other;
	}
	    //判断被选中的记录条数
	for (var i = 0; i < CheckBox_other.length; i++) {
		if (CheckBox_other[i].checked == true) {
			j = j + 1;
		}
	}
	if (j == 0) {
		alert("您还没有选择记录！");
		return false;
	} else {
		return true;
	}
}
 //检查复选是否有选中（单选框）
function fun_checkSelect_radio(formName,selectName) {
	var formObj = document.forms[formName].elements[selectName];
	var u = 0;
	if (formObj == null || typeof (formObj) == "undefined") {
		alert("您还没有选择记录！");
		return false;
	} else {
		if (typeof (formObj.length) == "undefined") {
			if (formObj.checked == true) {
				selvalue = formObj.value;
				return true;
			} else {
				alert("您还没有选择记录！");
				return false;
			}
		} else {
			for (var i = 0; i < formObj.length; i++) {
				if (formObj[i].checked == true) {
					selvalue = formObj[i].value;
					u++;
					return true;
					break;
				}
			}
			if (u <= 0) {
				alert("您还没有选择记录！");
				return false;
			}
		}
	}
}
function setIdInHidden(checkboxObj, faidHidden) {
	if (checkboxObj.checked == true) {
		//alert(faidHidden);
		document.forms["formMakePlan"].elements["formMakePlan:hiddenSaveFaid"].value = faidHidden;
	} else {
	}
}
//单选
function fun_edit(source) {
	var formObj = document.forms["formMakePlan"].elements["recordId"];
	var selvalue = "";
	var u = 0;
	if (typeof (formObj) == "undefined") {
		alert("\u60a8\u8fd8\u6ca1\u6709\u9009\u62e9\u8bb0\u5f55");
		return;
	} else {
		if (typeof (formObj.length) == "undefined") {
			if (formObj.checked == true) {
				selvalue = formObj.value;
				popup = window.open(source + "?flag=edit&faid=" + selvalue, "popup2", "height=600,width=700,toolbar=no,menubar=no");
			} else {
				alert("\u60a8\u8fd8\u6ca1\u6709\u9009\u62e9\u8bb0\u5f55");
				return;
			}
		} else {
			for (var i = 0; i < formObj.length; i++) {
				if (formObj[i].checked == true) {
					selvalue = formObj[i].value;
					popup = window.open(source + "?flag=edit&faid=" + selvalue, "popup2", "height=600,width=700,toolbar=no,menubar=no");
					u++;
					break;
				}
			}
			if (u <= 0) {
				alert("\u8bf7\u9009\u62e9\u8981\u4fee\u6539\u7684\u8bb0\u5f55");
				return;
			}
		}
	}
}
//用来打开一个详细信息查询页面
function detail_fun(source, id) {
	//popup = window.showModelessDialog(source + "?flag=detail&id=" + id, "popup1", "dialogHeight:300px;dialogWidth:700,toolbar=no,menubar=no");
	var winParam = "";
	var content = source + "?flag=detail&id=" + id;
	winParam = "window.showModelessDialog('" + content + "',window,'dialogWidth:800px;dialogHeight:480px;";
	winParam += "dialogLeft:200px;dialogTop:200px;resizable:no;scroll:0;help:0;status:0')";
	objWindow = eval(winParam);
}
//控制录入框不能输入数字
function bxqtzf() {
	var iekey = event.keyCode;
	if (iekey < 45 || iekey > 57) {
		event.returnValue = false;
	}
	if (iekey == 8 || iekey == 9) {
		event.returnValue = true;
	}
   			//if(iekey==190 )
      		//event.returnValue = true;
	if (iekey > 95 && iekey < 106) {
		event.returnValue = true;
	}
	if (event.shiftKey) {
		event.returnValue = false;
	}
}

//通过选择自己，来控制别的复选框，达到全选，全不选的目的.
//返回被操作的复选框对象，如果没有则返回null 
function selectAll(CheckBox_self, checkBoxName) {
	try {
		var CheckBox_other = getCheckBoxOther(checkBoxName);
		if (typeof (CheckBox_other) == "undefined") {
			return null;
		}
		if (typeof (CheckBox_other.length) == "undefined") {
			CheckBox_other.checked = CheckBox_self.checked;
			return CheckBox_other;
		}
		if (CheckBox_self.checked == true) {
			for (var i = 0; i < CheckBox_other.length; i++) {
				if (!CheckBox_other[i].disabled) {
					CheckBox_other[i].checked = true;
				}
			}
		} else {
			for (var i = 0; i < CheckBox_other.length; i++) {
				if (!CheckBox_other[i].disabled) {
					CheckBox_other[i].checked = false;
				}
			}
		}
		return CheckBox_other;
	}
	catch (E) {
		alert("e::::::::" + E.description);
		return null;
	}
}
function getCheckBoxOther(checkBoxName) {
	var checkBoxArray = new Array();
	var j = 0;
	for (var i = 0; i < document.forms[0].elements.length; i++) {
		if (document.forms[0].elements[i].type == "checkbox" && document.forms[0].elements[i].name.indexOf(checkBoxName) > 0) {
			checkBoxArray[j++] = document.forms[0].elements[i];
		}
	}
	return checkBoxArray;
}
//打开模式对话框
function fun_openModelessDialog(url , id , width , height , left , top) {
	var winParam = "";
	var content = url + ".faces";
	if (id != null){
		content += "?id=" + id;
	}
	winParam = "window.showModalDialog('" + content + "',window,'dialogWidth:"+width+"px;dialogHeight:"+height+"px;";
	winParam += "dialogLeft:"+left+"px;dialogTop:"+top+"px;resizable:no;scroll:0;help:0;status:0')";
	objWindow = eval(winParam);
}
function fun_loading() {
	var winParam = "";
	var content = "../../loading.htm";
	winParam = "window.showModelessDialog('" + content + "',window,'dialogWidth:500px;dialogHeight:160px;";
	winParam += "dialogLeft:400px;dialogTop:400px;resizable:no;scroll:0;help:0;status:0')";
	objWindow = eval(winParam);
}
 //打开选择窗口对话框
function selectPinPai() {
	var winParam = "";
	var content = "../putplan/pinPaiSelectTable.faces";
	winParam = "window.showModelessDialog('" + content + "',window,'dialogWidth:260px;dialogHeight:480px;";
	winParam += "dialogLeft:400px;dialogTop:400px;resizable:no;scroll:0;help:0;status:0')";
	objWindow = eval(winParam);
}
  //打开选择窗口对话框
function selectPinPai2() {
	var winParam = "";
	var content = "../../brandtrain/putplan/pinPaiSelectTable.faces";
	winParam = "window.showModelessDialog('" + content + "',window,'dialogWidth:260px;dialogHeight:480px;";
	winParam += "dialogLeft:400px;dialogTop:400px;resizable:no;scroll:0;help:0;status:0')";
	objWindow = eval(winParam);
}
function selectBrand(tffs, cjrq) {
	var winParam = "";
	var content = "../selectbrand/selectBrand.faces?tffs=" + tffs + "&cjrq=" + cjrq;
	winParam = "window.showModelessDialog('" + content + "',window,'dialogWidth:600px;dialogHeight:480px;";
	winParam += "dialogLeft:400px;dialogTop:400px;resizable:no;scroll:0;help:0;status:0')";
	objWindow = eval(winParam);
}
function selectKhxx(source) {
	var winParam = "";
	var content = source + "khxxSelectTable.faces";
	winParam = "window.showModelessDialog('" + content + "',window,'dialogWidth:700px;dialogHeight:500px;";
	winParam += "dialogLeft:400px;dialogTop:400px;resizable:no;scroll:0;help:0;status:0')";
	objWindow = eval(winParam);
}
 
function fun_checkSelect_radio(formName,selectName) {
	var formObj = document.forms[formName].elements[selectName];
	var u = 0;
	if (formObj == null || typeof (formObj) == "undefined") {
		alert("您还没有选择记录！");
		return false;
	} else {
		if (typeof (formObj.length) == "undefined") {
			if (formObj.checked == true) {
				selvalue = formObj.value;
				return true;
			} else {
				alert("您还没有选择记录！");
				return false;
			}
		} else {
			for (var i = 0; i < formObj.length; i++) {
				if (formObj[i].checked == true) {
					selvalue = formObj[i].value;
					u++;
					return true;
					break;
				}
			}
			if (u <= 0) {
				alert("您还没有选择记录！");
				return false;
			}
		}
	}
}
 
//***************************************************************************
//[功能]
//			此函数主要用来进行表单验证
//
//[建立]
//          2006-11-11, 张宏斌
//[更新]
//
//[参数]
//			input			需校验的控件
//			allowNull		校验是否允许null, 允许：true, 不允许：false
//			checkType		进行什么方式校验0：字符、1：数、2：小数、3：日期、4：email 、5：年月
//			min					最小值
//			max					最大值
//			info				错误信息
//[返回]
//			输入无误				- true
//			输入有误				- false
//[备注]
//
//***************************************************************************
function check_input(input, allowNull, checkType, min, max, info) {
	if (input == "undefined") {
		alert("\u65e0\u6b64\u5bf9\u8c61\uff01");
		return false;
	}
	var inputValue = input.value;
	if (!allowNull && inputValue == "") {
		if (info != null) {
			alert("\u5fc5\u987b\u586b\u5199\u201c" + info + "\u201d\uff01");
			input.focus();
		}
		return false;
	}
	if (inputValue != "") {
		if (checkType == "0") {
			if (min != null && max != null && min >= 0 && min <= max) {
				var len = getLength(inputValue);
				if (len < min || len > max) {
					if (info != null) {
						alert("\u60a8\u8f93\u5165\u7684\u201c" + info + "\u201d\u8d85\u957f!");
						input.focus();
						input.select();
					}
					return false;
				}
			}
		} else {
			if (checkType == "1") {
				if (inputValue != "0" && !parseInt(inputValue)) {
					if (info != null) {
						alert("\u201c" + info + "\u201d\u5fc5\u987b\u4e3a\u4e00\u4e2a\u6570!");
						input.focus();
						input.select();
					}
					return false;
				}
				if (inputValue != parseInt(inputValue).toString()) {
					if (info != null) {
						alert("\u201c" + info + "\u201d\u5fc5\u987b\u4e3a\u4e00\u4e2a\u6574\u6570!");
						input.focus();
						input.select();
					}
					return false;
				}
				if (min != null && max != null && min <= max) {
					if (parseInt(inputValue) < min || parseInt(inputValue) > max) {
						if (info != null) {
							alert("\u201c" + info + "\u201d\u5fc5\u987b\u5728" + min + "\u548c" + max + "\u4e4b\u95f4!");
							input.focus();
							input.select();
						}
						return false;
					}
				}
			} else {
				if (checkType == "2") {
					if (inputValue != "0" && isNaN(inputValue)) {
						if (info != null) {
							alert("\u201c" + info + "\u201d\u5fc5\u987b\u4e3a\u4e00\u4e2a数字!");
							input.focus();
							input.select();
						}
						return false;
					}
					if (min != null && max != null && min <= max) {
						if (parseFloat(inputValue) < min || parseFloat(inputValue) > max) {
							if (info != null) {
								alert("\u201c" + info + "\u201d\u5fc5\u987b\u5728" + min + "\u548c" + max + "\u4e4b\u95f4!");
								input.focus();
								input.select();
							}
							return false;
						}
					}
				} else {
					if (checkType == "3") {
						d = getDate(inputValue);
						if (d == null) {
							if (info != null) {
								alert("\u201c" + info + "\u201d\u65e5\u671f\u683c\u5f0f\u4e0d\u6b63\u786e!");
								input.focus();
								input.select();
							}
							return false;
						}
						var arr = inputValue.split("-");
						if (!(d.getFullYear() == parseInt(arr[0]) && d.getMonth() + 1 == parseInt(arr[1]) && d.getDate() == arr[2])) {
							if (info != null) {
								alert("\u201c" + info + "\u201d\u65e5\u671f\u683c\u5f0f\u4e0d\u6b63\u786e!");
								input.focus();
								input.select();
							}
							return false;
						}
						var m = getDate(min);
						var n = getDate(max);
						if (m != null && n != null) {
							if (m.toString() != "NaN" && n.toString() != "NaN" && Date.parse(m) <= Date.parse(n)) {
								if (Date.parse(d) < Date.parse(m) || Date.parse(d) > Date.parse(n)) {
									if (info != null) {
										alert("\u201c" + info + "\u201d\u5fc5\u987b\u5728" + min + "\u548c" + max + "\u4e4b\u95f4!");
										input.focus();
										input.select();
									}
									return false;
								}
							}
						}
					} else {
						if (checkType == "4") {
							if (inputValue.charAt(0) == "@" || inputValue.charAt(0) == ".") {
								if (info != null) {
									alert("\u201c" + info + "\u201dEmail\u683c\u5f0f\u4e0d\u6b63\u786e!");
									input.focus();
									input.select();
								}
								return false;
							}
							if (inputValue.charAt(inputValue.length - 1) == "@" || inputValue.charAt(inputValue.length - 1) == ".") {
								if (info != null) {
									alert("\u201c" + info + "\u201dEmail\u683c\u5f0f\u4e0d\u6b63\u786e!");
									input.focus();
									input.select();
								}
								return false;
							}
							if (inputValue.split("@").length == 1 || inputValue.split(".").length == 1) {
								if (info != null) {
									alert("\u201c" + info + "\u201dEmail\u683c\u5f0f\u4e0d\u6b63\u786e!");
									input.focus();
									input.select();
								}
								return false;
							}
						} else {
							if (checkType == "5") {
								var len = getLength(inputValue);
								if (len != 6) {
									if (info != null) {
										alert("“" + info + "”的格式不正确!");
										input.focus();
										input.select();
									}
									return false;
								}
								if (isNaN(inputValue)){
									if (info != null) {
										alert("“" + info + "”的格式不正确!");
										input.focus();
										input.select();
									}
									return false;
								}
								if (parseDouble(inputValue) % 100 < 1 || parseDouble(inputValue) % 100 > 12){
									if (info != null) {
										alert("“" + info + "”的格式不正确!");
										input.focus();
										input.select();
									}
									return false;
								}
							}
						}
					}
				}
			}
		}
	}
	return true;
}
function getDate(datestr) {
	if (datestr == null) {
		return null;
	}
	var arr = datestr.split("-");
	if (arr.length != 3) {
		return null;
	}
	return new Date(arr[0] + "/" + arr[1] + "/" + arr[2]);
}

//***************************************************************************
//[功能]
//			此函数主要用来进行时间区间验证
//
//[建立]
//          2007-1-6, 郭楠
//[更新]
//
//[参数]
//			start			需校验的时间控件开始时间
//			end  			需校验的时间控件结束时间
//         	info            错误信息
//
//[返回]
//			输入无误				- true
//			输入有误				- false
//[备注]
//***************************************************************************
function input_check_time(start, end, info) {
	if (start == null || end == null || start == "undefined" || end == "undefinded") {
		alert("\u65e0\u6b64\u5bf9\u8c61\uff01");
		return false;
	}
	if (!check_input(start, true, 3, null, null, info)) {
		return false;
	}
	if (!check_input(end, true, 3, null, null, info)) {
		return false;
	}
	var startValue = getDate(start.value);
	var endValue = getDate(end.value);
	if (start.value == "" && end.value != "") {
		if (info != null) {
			alert(info + "\u5f00\u59cb\u65f6\u95f4\u4e0d\u80fd\u4e3a\u7a7a\uff01");
			start.focus();
		}
		return false;
	}
	if (start.value != "" && end.value == "") {
		if (info != null) {
			alert(info + "\u7ed3\u675f\u65f6\u95f4\u4e0d\u80fd\u4e3a\u7a7a\uff01");
			end.focus();
		}
		return false;
	}
	if (Date.parse(startValue) > Date.parse(endValue)) {
		if (info != null) {
			alert(info + "\u5f00\u59cb\u65f6\u95f4\u4e0d\u80fd\u5927\u4e8e" + info + "\u7ed3\u675f\u65f6\u95f4\uff01");
			start.focus();
			start.select();
		}
		return false;
	}
	return true;
}
//set title
function fun_setTitle(id, value) {
	var hidTitle = document.getElementById(id);
	if (hidTitle == null || hidTitle == "undefine") {
		alert("\u65e0\u6b64\u5bf9\u8c61\uff01");
		return false;
	}
	hidTitle.value = value;
	return true;
}
function clickButton(id) {
	var hidTitle = document.getElementById(id);
	if (hidTitle == null || hidTitle == "undefine") {
		alert("\u65e0\u6b64\u5bf9\u8c61\uff01");
		return false;
	}
	hidTitle.click();
	return true;
}
function getLength(value) {
	var len = 0;
	for (i = 0; i < value.length; i++) {
		if (/[u00-uFF]/.test(value.charAt(i))) {
			len++;
		} else {
			len += 2;
		}
	}
	return len;
}

function download() {
	window.iframesubmit_operator.location = "/FAIPSysManage/pages/filemanage/download.jsp";
	//window.open("/FAIPMIS/pages/common/download.jsp", "download", "height=1,width=1,left=100%,top=100%,toolbar=no,menubar=no");
	return false;
}

function downLoadFile() {
	window.iframesubmit_operator.location = "/FAIPSysManage/pages/filemanage/downLoadFile.jsp";
	//window.open("/FAIPMIS/pages/common/downLoadFile.jsp", "download", "height=1,width=1,left=100%,top=100%,toolbar=no,menubar=no");
	return false;
}

function downLoadFileAbs() {
	window.iframesubmit_operator.location = "/FAIPSysManage/pages/filemanage/downLoadFileAbs.jsp";
	//window.open("/FAIPMIS/pages/common/downLoadFile.jsp", "download", "height=1,width=1,left=100%,top=100%,toolbar=no,menubar=no");
	return false;
}

function selectTree(flid, dmid, mcid, sjdmid, bzid) {
	var str = "/FAIPMIS/pages/common/selectDictTree.faces?";
	if (flid != null && flid != '') {
		str += "flid=" + flid + "&";
	}
	
	if (dmid != null && dmid != '') {
		str += "dmid=" + dmid + "&";
	}
	
	if (mcid != null && mcid != '') {
		str += "mcid=" + mcid + "&";
	}
	
	if (sjdmid != null && sjdmid != '') {
		str += "sjdmid=" + sjdmid;
	}
	
	if (bzid != null && bzid != '') {
		str += "bzid=" + bzid;
	}
	
	window.showModalDialog(str, window, "dialogWidth:492px;resizable:no;help:0;status:0;dialogLeft:200px;dialogTop:200px;");
	return false;
}

function selectTreeWithCode(flid, dmid, mcid, sjdmid, bzid) {
	var str = "/FAIPMIS/pages/common/dictTreeWithCode.faces?";
	if (flid != null && flid != '') {
		str += "flid=" + flid + "&";
	}
	
	if (dmid != null && dmid != '') {
		str += "dmid=" + dmid + "&";
	}
	
	if (mcid != null && mcid != '') {
		str += "mcid=" + mcid + "&";
	}
	
	if (sjdmid != null && sjdmid != '') {
		str += "sjdmid=" + sjdmid;
	}
	
	if (bzid != null && bzid != '') {
		str += "bzid=" + bzid;
	}
	
	window.showModalDialog(str, window, "dialogWidth:492px;resizable:no;help:0;status:0;dialogLeft:200px;dialogTop:200px;");
	return false;
}

function setSelectLabel(id, selectObj) {
	if (selectObj.options[selectObj.selectedIndex].value != "") {
		fun_setTitle(id, selectObj.options[selectObj.selectedIndex].text);
	} else {
		fun_setTitle(id, "");
	}
}

function windowOpen(url, width, height) {
	var screenHeight = screen.height;
	var screenWidth = screen.width;
	var left = (screenWidth - width) / 2;
	var top = (screenHeight - height) / 2;
	var style = "height="+height+",width="+width+",left="+left+",top="+top+",toolbar=no,menubar=no";
	alert(style);
	
	window.open(url, "newWindow", style);
	
}

function selectTcfmTree() {
	var str = "/FAIPMIS/pages/invest/investdb/selectTcfmTree.faces";
	
	window.showModalDialog(str, window, "dialogWidth:492px;resizable:no;help:0;status:0;dialogLeft:200px;dialogTop:200px;");
	return false;
}

function checkTwoMonth(start, end, startInfo, endInfo) {
	if (!checkMonth(start, startInfo)) {
		return false;
	}
	
	if (!checkMonth(end, endInfo)) {
		return false;
	}
	
	if (start.value != "" && end.value != "") {
		if (convertMonth(start.value) > convertMonth(end.value)) {
			alert("“" + startInfo + "”不能大于“" + endInfo + "”");
			start.focus();
			return false;
		}
	}
	
	return true;
}

function convertMonth(month) {
	var date = month.split("-");
	
	if (date[1].length == 1) {
		return date[0] + "-0" + date[1];
	} else {
		return month;
	}
}

function checkMonth(month, info) {
	if (month == null) {
		alert("无此对象");
	}
	
	if (month.value == "") {
		return true;
	}
	
	if (month.value.indexOf(".") != -1) {
		alert(info + "格式错误，格式为“2008-01”");
		return false;
	}
	
	var date = month.value.split("-");
	if (date.length != 2) {
		alert(info + "格式错误，格式为“2008-01”");
		month.focus();
		return false;
	}
	
	if (date[0].length != 4) {
		alert(info + "格式错误，格式为“2008-01”");
		month.focus();
		return false;
	}
	
	if (date[1].length > 2) {
		alert(info + "格式错误，格式为“2008-01”");
		month.focus();
		return false;
	}
	
	if (date[1].search("0") == 0) {
		date[1] = date[1].substring(1);
	}
	
	if (!parseInt(date[0]) || !parseInt(date[1])) {
		alert(info + "格式错误，格式为“2008-01”");
		month.focus();
		return false;
	}
	
	if (parseInt(date[1]) <= 0 || parseInt(date[1]) > 12) {
		alert(info + "格式错误，格式为“2008-01”");
		month.focus();
		return false;
	}
	
	return true;
}