var flag0 = 1;
function showHideMenu(obj) {
	if (flag0 == 0){
		obj.src="resources/images/common/nav_5.gif";
		document.getElementById("menu").style.display = "";
		//document.getElementById("top").style.display = "";
		document.getElementById("ifrm").style.width = "";
		
		flag0=1;
	} else {
		document.getElementById("menu").style.display = "none";
		//document.getElementById("top").style.display = "none";
		document.getElementById("ifrm").style.width = "100%";
		obj.src = "resources/images/common/nav_4.gif";
		
		flag0 = 0;
	}
}
