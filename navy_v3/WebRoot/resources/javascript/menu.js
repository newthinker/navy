	var root = new treeItem("�������ʹ���ϵͳ","index_main.htm","ifrm","",icon.root.src);

		var item0 = new treeItem("�������ʹ���ϵͳ","","");
		var item1 = new treeItem("ϵͳά��","","");


		var item00 = new treeItem("���ݵ���","content/wzdr.htm","ifrm");
		var item01 = new treeItem("���ʽ�����Ϣ����","content/wzjk.htm","ifrm");
		var item02 = new treeItem("���ʽ��ڻ���ͳ��","content/wzhz.htm","ifrm");
		var item03 = new treeItem("���ʽ��ڷֵ�λ����ͳ��","content/wzfhz.htm","ifrm");

		var item10 = new treeItem("��ҵ����ά��","content/tbl1.htm","ifrm");
		var item11 = new treeItem("����ά��","content/hlwh.htm","ifrm");
		var item12 = new treeItem("��˰Ŀ¼ά��","content/mlwh.htm","ifrm");

		

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
		
		
		