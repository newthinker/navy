	var root = new treeItem("海军物资管理系统","index_main.htm","ifrm","",icon.root.src);

		var item0 = new treeItem("海军物资管理系统","","");
		var item1 = new treeItem("系统维护","","");


		var item00 = new treeItem("数据导入","content/wzdr.htm","ifrm");
		var item01 = new treeItem("物资进口信息管理","content/wzjk.htm","ifrm");
		var item02 = new treeItem("物资进口汇总统计","content/wzhz.htm","ifrm");
		var item03 = new treeItem("物资进口分单位汇总统计","content/wzfhz.htm","ifrm");

		var item10 = new treeItem("事业部门维护","content/tbl1.htm","ifrm");
		var item11 = new treeItem("汇率维护","content/hlwh.htm","ifrm");
		var item12 = new treeItem("免税目录维护","content/mlwh.htm","ifrm");

		

		root.add(item0);
		root.add(item1);



		item0.add(item00);
		item0.add(item01);
		item0.add(item02);
		item0.add(item03);
		
		item1.add(item10);
		item1.add(item11);
		item1.add(item12);

		

		root.setup(document.getElementById("functionmap"));
		
		
		