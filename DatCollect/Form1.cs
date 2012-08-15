using System;
using System.IO;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Xml;

namespace DatCollect
{
	public partial class Form1 : Form
	{
		public struct SDict
		{
			public int id;
			public string name;
			public string code;
			public string rcode;
		}

		public class CStockholderControl
		{
			public Form1 parent;
			public GroupBox groupBox;
			public Label label1;
			public Label label2;
			public Label label3;
			public Label label4;
			public TextBox textBoxStockholderName;
			public TextBox textBoxStockholderCapital;
			public TextBox textBoxStockholderRatio;
			public DateTimePicker dateTimePickerStockholderStockDate;
			public Button buttonAddStockholder;
			public Button buttonDelStockholder;

			public CStockholderControl(Form1 form, int idx)
			{
				this.parent = form;
				this.groupBox = new System.Windows.Forms.GroupBox();
				this.label1 = new System.Windows.Forms.Label();
				this.label2 = new System.Windows.Forms.Label();
				this.label3 = new System.Windows.Forms.Label();
				this.label4 = new System.Windows.Forms.Label();
				this.textBoxStockholderName = new System.Windows.Forms.TextBox();
				this.textBoxStockholderCapital = new System.Windows.Forms.TextBox();
				this.textBoxStockholderRatio = new System.Windows.Forms.TextBox();
				this.dateTimePickerStockholderStockDate = new System.Windows.Forms.DateTimePicker();
				this.buttonAddStockholder = new System.Windows.Forms.Button();
				this.buttonDelStockholder = new System.Windows.Forms.Button();

				this.groupBox.SuspendLayout();

				this.groupBox.Controls.Add(this.label1);
				this.groupBox.Controls.Add(this.label2);
				this.groupBox.Controls.Add(this.label3);
				this.groupBox.Controls.Add(this.label4);
				this.groupBox.Controls.Add(this.textBoxStockholderName);
				this.groupBox.Controls.Add(this.textBoxStockholderCapital);
				this.groupBox.Controls.Add(this.textBoxStockholderRatio);
				this.groupBox.Controls.Add(this.dateTimePickerStockholderStockDate);
				this.groupBox.Controls.Add(this.buttonAddStockholder);
				this.groupBox.Controls.Add(this.buttonDelStockholder);

				Point ptzero = this.parent.groupBox_stockholder.Location;
				// 
				// groupBox
				// 
				this.groupBox.Location = ptzero + new Size(0, 150 * idx);
				this.groupBox.Size = new System.Drawing.Size(719, 138);
				this.groupBox.TabIndex = idx;
				this.groupBox.TabStop = false;
				this.groupBox.Text = "股东信息";
				// 
				// label1
				// 
				this.label1.AutoSize = true;
				this.label1.Location = new System.Drawing.Point(30, 33);
				this.label1.Size = new System.Drawing.Size(65, 12);
				this.label1.Text = "股东姓名：";
				// 
				// label2
				// 
				this.label2.AutoSize = true;
				this.label2.Location = new System.Drawing.Point(404, 33);
				this.label2.Size = new System.Drawing.Size(65, 12);
				this.label2.Text = "出资金额：";
				// 
				// label3
				// 
				this.label3.AutoSize = true;
				this.label3.Location = new System.Drawing.Point(30, 74);
				this.label3.Size = new System.Drawing.Size(65, 12);
				this.label3.Text = "出资比例：";
				// 
				// label4
				// 
				this.label4.AutoSize = true;
				this.label4.Location = new System.Drawing.Point(404, 74);
				this.label4.Size = new System.Drawing.Size(53, 12);
				this.label4.Text = "出资时间：";

				// 
				// textBoxStockholderName
				// 
				this.textBoxStockholderName.Location = new System.Drawing.Point(142, 29);
				this.textBoxStockholderName.Size = new System.Drawing.Size(175, 21);
				this.textBoxStockholderName.TabIndex = 0;
				// 
				// textBoxStockholderCapital
				// 
				this.textBoxStockholderCapital.Location = new System.Drawing.Point(514, 29);
				this.textBoxStockholderCapital.Size = new System.Drawing.Size(175, 21);
				this.textBoxStockholderCapital.TabIndex = 1;
				// 
				// textBoxStockholderRatio
				// 
				this.textBoxStockholderRatio.Location = new System.Drawing.Point(142, 70);
				this.textBoxStockholderRatio.Size = new System.Drawing.Size(175, 21);
				this.textBoxStockholderRatio.TabIndex = 2;
				// 
				// dateTimePickerStockholderStockDate
				// 
				this.dateTimePickerStockholderStockDate.Location = new System.Drawing.Point(514, 70);
				this.dateTimePickerStockholderStockDate.Size = new System.Drawing.Size(175, 21);
				this.dateTimePickerStockholderStockDate.TabIndex = 3;
				// 
				// buttonDelStockholder
				// 
				this.buttonDelStockholder.Location = new System.Drawing.Point(511, 106);
				this.buttonDelStockholder.Size = new System.Drawing.Size(75, 23);
				this.buttonDelStockholder.TabIndex = 4;
				this.buttonDelStockholder.Name = Guid.NewGuid().ToString();
				this.buttonDelStockholder.Text = "删除股东";
				this.buttonDelStockholder.UseVisualStyleBackColor = true;
				this.buttonDelStockholder.Click += new System.EventHandler(this.parent.button_delStockholder_Click);
				// 
				// buttonAddStockholder
				// 
				this.buttonAddStockholder.Location = new System.Drawing.Point(611, 106);
				this.buttonAddStockholder.Size = new System.Drawing.Size(75, 23);
				this.buttonAddStockholder.TabIndex = 5;
				this.buttonAddStockholder.Name = Guid.NewGuid().ToString();
				this.buttonAddStockholder.Text = "增加股东";
				this.buttonAddStockholder.UseVisualStyleBackColor = true;
				this.buttonAddStockholder.Click += new System.EventHandler(this.parent.button_addStockholder_Click);


				this.groupBox.ResumeLayout(false);
				this.groupBox.PerformLayout();
			}
		}

		public class CProductControl
		{
			public Form1 parent;
			public GroupBox groupBox;
			public Label label0;
			public Label label1;
			public Label label2;
			public Label label3;
			public Label label4;
			public Label label5;
			public Label label6;
			public Label label7;
			public Label label8;
			public TextBox textBoxProductType;
			public TextBox textBoxProductName;
			public TextBox textBoxProductMode;
			public TextBox textBoxProductUnit;
			public TextBox textBoxProductYieldYearAvg;
			public TextBox textBoxProductYeildYearMax;
			public TextBox textBoxProductYeildMax;
			public TextBox textBoxProductDayofMaxYeild;
			public TextBox textBoxProductPhoto;
			public Button buttonSelectProduct;
			public Button buttonBrowsePhoto;
			public Button buttonAddProduct;
			public Button buttonDelProduct;

			public CProductControl(Form1 form, int idx)
			{
				this.parent = form;
				this.groupBox = new System.Windows.Forms.GroupBox();
				this.label0 = new System.Windows.Forms.Label();
				this.label1 = new System.Windows.Forms.Label();
				this.label2 = new System.Windows.Forms.Label();
				this.label3 = new System.Windows.Forms.Label();
				this.label4 = new System.Windows.Forms.Label();
				this.label5 = new System.Windows.Forms.Label();
				this.label6 = new System.Windows.Forms.Label();
				this.label7 = new System.Windows.Forms.Label();
				this.label8 = new System.Windows.Forms.Label();
				this.textBoxProductType = new System.Windows.Forms.TextBox();
				this.textBoxProductName = new System.Windows.Forms.TextBox();
				this.textBoxProductMode = new System.Windows.Forms.TextBox();
				this.textBoxProductUnit = new System.Windows.Forms.TextBox();
				this.textBoxProductYieldYearAvg = new System.Windows.Forms.TextBox();
				this.textBoxProductYeildYearMax = new System.Windows.Forms.TextBox();
				this.textBoxProductYeildMax = new System.Windows.Forms.TextBox();
				this.textBoxProductDayofMaxYeild = new System.Windows.Forms.TextBox();
				this.textBoxProductPhoto = new System.Windows.Forms.TextBox();
				this.buttonSelectProduct = new System.Windows.Forms.Button();
				this.buttonBrowsePhoto = new System.Windows.Forms.Button();
				this.buttonAddProduct = new System.Windows.Forms.Button();
				this.buttonDelProduct = new System.Windows.Forms.Button();

				this.groupBox.SuspendLayout();

				this.groupBox.Controls.Add(this.label0);
				this.groupBox.Controls.Add(this.label1);
				this.groupBox.Controls.Add(this.label2);
				this.groupBox.Controls.Add(this.label3);
				this.groupBox.Controls.Add(this.label4);
				this.groupBox.Controls.Add(this.label5);
				this.groupBox.Controls.Add(this.label6);
				this.groupBox.Controls.Add(this.label7);
				this.groupBox.Controls.Add(this.label8);
				this.groupBox.Controls.Add(this.textBoxProductType);
				this.groupBox.Controls.Add(this.textBoxProductName);
				this.groupBox.Controls.Add(this.textBoxProductMode);
				this.groupBox.Controls.Add(this.textBoxProductUnit);
				this.groupBox.Controls.Add(this.textBoxProductYieldYearAvg);
				this.groupBox.Controls.Add(this.textBoxProductYeildYearMax);
				this.groupBox.Controls.Add(this.textBoxProductYeildMax);
				this.groupBox.Controls.Add(this.textBoxProductDayofMaxYeild);
				this.groupBox.Controls.Add(this.textBoxProductPhoto);
				this.groupBox.Controls.Add(this.buttonSelectProduct);
				this.groupBox.Controls.Add(this.buttonBrowsePhoto);
				this.groupBox.Controls.Add(this.buttonAddProduct);
				this.groupBox.Controls.Add(this.buttonDelProduct);

				Point ptzero = this.parent.groupBox3.Location;
				// 
				// groupBox
				// 
				this.groupBox.Location = ptzero + new Size(0, 230 * idx);
				this.groupBox.Size = new System.Drawing.Size(710, 217);
				this.groupBox.TabIndex = idx;
				this.groupBox.TabStop = false;
				this.groupBox.Text = "产品相关信息";
				// 
				// label0
				// 
				this.label0.AutoSize = true;
				this.label0.Location = new System.Drawing.Point(25, 31);
				this.label0.Size = new System.Drawing.Size(65, 12);
				this.label0.Text = "产品类型：";
				// 
				// label1
				// 
				this.label1.AutoSize = true;
				this.label1.Location = new System.Drawing.Point(399, 31);
				this.label1.Size = new System.Drawing.Size(65, 12);
				this.label1.Text = "产品名称：";
				// 
				// label2
				// 
				this.label2.AutoSize = true;
				this.label2.Location = new System.Drawing.Point(25, 68);
				this.label2.Size = new System.Drawing.Size(101, 12);
				this.label2.Text = "产品系统或型号：";
				// 
				// label3
				// 
				this.label3.AutoSize = true;
				this.label3.Location = new System.Drawing.Point(399, 68);
				this.label3.Size = new System.Drawing.Size(65, 12);
				this.label3.Text = "计量单位：";
				// 
				// label4
				// 
				this.label4.AutoSize = true;
				this.label4.Location = new System.Drawing.Point(25, 100);
				this.label4.Size = new System.Drawing.Size(71, 24);
				this.label4.Text = "2009-2011年\r\n年均产量：";
				// 
				// label5
				// 
				this.label5.AutoSize = true;
				this.label5.Location = new System.Drawing.Point(399, 100);
				this.label5.Size = new System.Drawing.Size(77, 24);
				this.label5.Text = "2009-2011年\r\n最大年产量：";
				// 
				// label6
				// 
				this.label6.AutoSize = true;
				this.label6.Location = new System.Drawing.Point(25, 143);
				this.label6.Size = new System.Drawing.Size(89, 12);
				this.label6.Text = "单批最大产量：";
				// 
				// label7
				// 
				this.label7.AutoSize = true;
				this.label7.Location = new System.Drawing.Point(399, 138);
				this.label7.Size = new System.Drawing.Size(101, 24);
				this.label7.Text = "完成单批最大产品\r\n所用时间（天）：";
				// 
				// label8
				// 
				this.label8.AutoSize = true;
				this.label8.Location = new System.Drawing.Point(25, 180);
				this.label8.Size = new System.Drawing.Size(65, 12);
				this.label8.Text = "产品照片：";

				// 
				// buttonSelectProduct
				// 
				this.buttonSelectProduct.Location = new System.Drawing.Point(318, 26);
				this.buttonSelectProduct.Size = new System.Drawing.Size(65, 23);
				this.buttonSelectProduct.TabIndex = 0;
				this.buttonSelectProduct.Text = "选择分类";
				this.buttonSelectProduct.UseVisualStyleBackColor = true;
				this.buttonSelectProduct.Click += new System.EventHandler(this.parent.button_selectProduct_Click);
				// 
				// textBoxProductType
				// 
				this.textBoxProductType.Location = new System.Drawing.Point(137, 28);
				this.textBoxProductType.Size = new System.Drawing.Size(175, 21);
				this.textBoxProductType.TabStop = false;
				this.textBoxProductType.ReadOnly = true;
				this.textBoxProductType.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
				this.textBoxProductType.Text = "未分类";
				this.textBoxProductType.Tag = "0";
				// 
				// textBoxProductName
				// 
				this.textBoxProductName.Location = new System.Drawing.Point(511, 28);
				this.textBoxProductName.Size = new System.Drawing.Size(175, 21);
				this.textBoxProductName.TabIndex = 1;
				// 
				// textBoxProductMode
				// 
				this.textBoxProductMode.Location = new System.Drawing.Point(137, 65);
				this.textBoxProductMode.Size = new System.Drawing.Size(175, 21);
				this.textBoxProductMode.TabIndex = 2;
				// 
				// textBoxProductUnit
				// 
				this.textBoxProductUnit.Location = new System.Drawing.Point(511, 65);
				this.textBoxProductUnit.Size = new System.Drawing.Size(175, 21);
				this.textBoxProductUnit.TabIndex = 3;
				// 
				// textBoxProductYieldYearAvg
				// 
				this.textBoxProductYieldYearAvg.Location = new System.Drawing.Point(137, 102);
				this.textBoxProductYieldYearAvg.Size = new System.Drawing.Size(175, 21);
				this.textBoxProductYieldYearAvg.TabIndex = 4;
				// 
				// textBoxProductYeildYearMax
				// 
				this.textBoxProductYeildYearMax.Location = new System.Drawing.Point(511, 102);
				this.textBoxProductYeildYearMax.Size = new System.Drawing.Size(175, 21);
				this.textBoxProductYeildYearMax.TabIndex = 5;
				// 
				// textBoxProductYeildMax
				// 
				this.textBoxProductYeildMax.Location = new System.Drawing.Point(137, 140);
				this.textBoxProductYeildMax.Size = new System.Drawing.Size(175, 21);
				this.textBoxProductYeildMax.TabIndex = 6;
				// 
				// textBoxProductDayofMaxYeild
				// 
				this.textBoxProductDayofMaxYeild.Location = new System.Drawing.Point(511, 140);
				this.textBoxProductDayofMaxYeild.Size = new System.Drawing.Size(175, 21);
				this.textBoxProductDayofMaxYeild.TabIndex = 7;
				// 
				// textBoxProductPhoto
				// 
				this.textBoxProductPhoto.Location = new System.Drawing.Point(137, 177);
				this.textBoxProductPhoto.Size = new System.Drawing.Size(175, 21);
				this.textBoxProductPhoto.TabIndex = 8;
				// 
				// buttonBrowsePhoto
				// 
				this.buttonBrowsePhoto.Location = new System.Drawing.Point(318, 176);
				this.buttonBrowsePhoto.Size = new System.Drawing.Size(35, 23);
				this.buttonBrowsePhoto.TabIndex = 9;
				this.buttonBrowsePhoto.Text = "...";
				this.buttonBrowsePhoto.UseVisualStyleBackColor = true;
				this.buttonBrowsePhoto.Click += new System.EventHandler(this.parent.button_browsePhoto_Click);
				// 
				// buttonDelProduct
				// 
				this.buttonDelProduct.Location = new System.Drawing.Point(511, 175);
				this.buttonDelProduct.Size = new System.Drawing.Size(75, 23);
				this.buttonDelProduct.TabIndex = 10;
				this.buttonDelProduct.Name = Guid.NewGuid().ToString();
				this.buttonDelProduct.Text = "删除产品";
				this.buttonDelProduct.UseVisualStyleBackColor = true;
				this.buttonDelProduct.Click += new System.EventHandler(this.parent.button_delProduct_Click);
				// 
				// button_addProduct
				// 
				this.buttonAddProduct.Location = new System.Drawing.Point(611, 175);
				this.buttonAddProduct.Size = new System.Drawing.Size(75, 23);
				this.buttonAddProduct.TabIndex = 11;
				this.buttonAddProduct.Name = Guid.NewGuid().ToString();
				this.buttonAddProduct.Text = "增加产品";
				this.buttonAddProduct.UseVisualStyleBackColor = true;
				this.buttonAddProduct.Click += new System.EventHandler(this.parent.button_addProduct_Click);


				this.groupBox.ResumeLayout(false);
				this.groupBox.PerformLayout();

			}
		}

		public class CAftersalesControl
		{
			public Form1 parent;
			public GroupBox groupBox;
			public Label label1;
			public Label label2;
			public Label label3;
			public Label label4;
			public Label label5;
			public TextBox textBoxAftersalesName;
			public ComboBox comboBoxAftersalesType;
			public ComboBox comboBoxAftersalesProvice;
			public ComboBox comboBoxAftersalesCity;
			public TextBox textBoxAftersalesContext;
			public TextBox textBoxAftersalesTel;
			public Button buttonAddAftersales;
			public Button buttonDelAftersales;

			public CAftersalesControl(Form1 form, int idx)
			{
				this.parent = form;
				this.groupBox = new System.Windows.Forms.GroupBox();
				this.label1 = new System.Windows.Forms.Label();
				this.label2 = new System.Windows.Forms.Label();
				this.label3 = new System.Windows.Forms.Label();
				this.label4 = new System.Windows.Forms.Label();
				this.label5 = new System.Windows.Forms.Label();
				this.textBoxAftersalesName = new System.Windows.Forms.TextBox();
				this.comboBoxAftersalesType = new System.Windows.Forms.ComboBox();
				this.comboBoxAftersalesProvice = new System.Windows.Forms.ComboBox();
				this.comboBoxAftersalesCity = new System.Windows.Forms.ComboBox();
				this.textBoxAftersalesContext = new System.Windows.Forms.TextBox();
				this.textBoxAftersalesTel = new System.Windows.Forms.TextBox();
				this.buttonAddAftersales = new System.Windows.Forms.Button();
				this.buttonDelAftersales = new System.Windows.Forms.Button();

				this.groupBox.SuspendLayout();

				this.groupBox.Controls.Add(this.label1);
				this.groupBox.Controls.Add(this.label2);
				this.groupBox.Controls.Add(this.label3);
				this.groupBox.Controls.Add(this.label4);
				this.groupBox.Controls.Add(this.label5);
				this.groupBox.Controls.Add(this.textBoxAftersalesName);
				this.groupBox.Controls.Add(this.comboBoxAftersalesType);
				this.groupBox.Controls.Add(this.comboBoxAftersalesProvice);
				this.groupBox.Controls.Add(this.comboBoxAftersalesCity);
				this.groupBox.Controls.Add(this.textBoxAftersalesContext);
				this.groupBox.Controls.Add(this.textBoxAftersalesTel);
				this.groupBox.Controls.Add(this.buttonAddAftersales);
				this.groupBox.Controls.Add(this.buttonDelAftersales);

				Point ptzero = this.parent.groupBox4.Location;
				// 
				// groupBox
				// 
				this.groupBox.Location = ptzero + new Size(0, 190 * idx);
				this.groupBox.Size = new System.Drawing.Size(710, 178);
				this.groupBox.TabIndex = idx;
				this.groupBox.TabStop = false;
				this.groupBox.Text = "售后服务机构信息";
				// 
				// label1
				// 
				this.label1.AutoSize = true;
				this.label1.Location = new System.Drawing.Point(25, 26);
				this.label1.Size = new System.Drawing.Size(101, 24);
				this.label1.Text = "分支或服务机构\r\n          名称：";
				// 
				// label2
				// 
				this.label2.AutoSize = true;
				this.label2.Location = new System.Drawing.Point(399, 32);
				this.label2.Size = new System.Drawing.Size(41, 12);
				this.label2.Text = "类别：";
				// 
				// label3
				// 
				this.label3.AutoSize = true;
				this.label3.Location = new System.Drawing.Point(25, 70);
				this.label3.Size = new System.Drawing.Size(65, 12);
				this.label3.Text = "注册所在地：";
				// 
				// label4
				// 
				this.label4.AutoSize = true;
				this.label4.Location = new System.Drawing.Point(25, 107);
				this.label4.Size = new System.Drawing.Size(53, 12);
				this.label4.Text = "负责人：";
				// 
				// label5
				// 
				this.label5.AutoSize = true;
				this.label5.Location = new System.Drawing.Point(399, 107);
				this.label5.Size = new System.Drawing.Size(65, 12);
				this.label5.Text = "联系电话：";

				// 
				// textBoxAftersalesName
				// 
				this.textBoxAftersalesName.Location = new System.Drawing.Point(137, 28);
				this.textBoxAftersalesName.Size = new System.Drawing.Size(175, 21);
				this.textBoxAftersalesName.TabIndex = 0;
				// 
				// comboBoxAftersalesType
				// 
				this.comboBoxAftersalesType.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
				this.comboBoxAftersalesType.FormattingEnabled = true;
				this.comboBoxAftersalesType.Location = new System.Drawing.Point(511, 28);
				this.comboBoxAftersalesType.Size = new System.Drawing.Size(175, 20);
				this.comboBoxAftersalesType.TabIndex = 1;
				Dictionary<string, SDict> tdi = null;
				if (this.parent._dict.TryGetValue(16, out tdi))
				{
					foreach (KeyValuePair<string, SDict> item in tdi)
					{
						this.comboBoxAftersalesType.Items.Add(item.Value.name);
					}
					this.comboBoxAftersalesType.SelectedIndex = 0;
				}
				tdi = null;
				// 
				// comboBoxAftersalesProvice
				// 
				this.comboBoxAftersalesProvice.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
				this.comboBoxAftersalesProvice.FormattingEnabled = true;
				this.comboBoxAftersalesProvice.Location = new System.Drawing.Point(137, 66);
				this.comboBoxAftersalesProvice.Size = new System.Drawing.Size(93, 20);
				this.comboBoxAftersalesProvice.TabIndex = 2;
				this.comboBoxAftersalesProvice.SelectedIndexChanged += new System.EventHandler(this.parent.comboBox_aftersalesProvice_SelectedIndexChanged);
				foreach (KeyValuePair<string, ArrayList> item in this.parent._citys)
				{
					this.comboBoxAftersalesProvice.Items.Add(item.Key);
				}
				this.comboBoxAftersalesProvice.SelectedIndex = 0;
				// 
				// comboBoxAftersalesCity
				// 
				this.comboBoxAftersalesCity.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
				this.comboBoxAftersalesCity.FormattingEnabled = true;
				this.comboBoxAftersalesCity.Location = new System.Drawing.Point(236, 66);
				this.comboBoxAftersalesCity.Size = new System.Drawing.Size(76, 20);
				this.comboBoxAftersalesCity.TabIndex = 3;
				this.comboBoxAftersalesCity.Items.Clear();
				foreach (string city in this.parent._citys[this.comboBoxAftersalesProvice.Text])
				{
					this.comboBoxAftersalesCity.Items.Add(city);
				}
				this.comboBoxAftersalesCity.SelectedIndex = 0;
				// 
				// textBoxAftersalesContext
				// 
				this.textBoxAftersalesContext.Location = new System.Drawing.Point(137, 103);
				this.textBoxAftersalesContext.Size = new System.Drawing.Size(175, 21);
				this.textBoxAftersalesContext.TabIndex = 4;
				// 
				// textBoxAftersalesTel
				// 
				this.textBoxAftersalesTel.Location = new System.Drawing.Point(509, 103);
				this.textBoxAftersalesTel.Size = new System.Drawing.Size(175, 21);
				this.textBoxAftersalesTel.TabIndex = 5;
				// 
				// buttonDelAftersales
				// 
				this.buttonDelAftersales.Location = new System.Drawing.Point(511, 141);
				this.buttonDelAftersales.Size = new System.Drawing.Size(75, 23);
				this.buttonDelAftersales.TabIndex = 6;
				this.buttonDelAftersales.Name = Guid.NewGuid().ToString();
				this.buttonDelAftersales.Text = "删除售后";
				this.buttonDelAftersales.UseVisualStyleBackColor = true;
				this.buttonDelAftersales.Click += new System.EventHandler(this.parent.button_delAftersales_Click);
				// 
				// buttonAddAftersales
				// 
				this.buttonAddAftersales.Location = new System.Drawing.Point(611, 141);
				this.buttonAddAftersales.Size = new System.Drawing.Size(75, 23);
				this.buttonAddAftersales.TabIndex = 7;
				this.buttonAddAftersales.Name = Guid.NewGuid().ToString();
				this.buttonAddAftersales.Text = "增加售后";
				this.buttonAddAftersales.UseVisualStyleBackColor = true;
				this.buttonAddAftersales.Click += new System.EventHandler(this.parent.button_addAftersales_Click);


				this.groupBox.ResumeLayout(false);
				this.groupBox.PerformLayout();
			}
		}

		//
		public Dictionary<int, Dictionary<string, SDict>> _dict;
		public Dictionary<string, ArrayList> _citys;

		// 动态控件
		List<CStockholderControl> _shcs;
		List<CProductControl> _pcs;
		List<CAftersalesControl> _ascs;

        // Form2
        Form2 _psForm;

		public Form1()
		{
			InitializeComponent();

			_dict = new Dictionary<int, Dictionary<string, SDict>>();
			_citys = new Dictionary<string, ArrayList>();
			_shcs = new List<CStockholderControl>();
			_pcs = new List<CProductControl>();
			_ascs = new List<CAftersalesControl>();

			this.AcceptButton = button_next1;
			this.CancelButton = button_cancel1;

			Init();

		}



		private void Init()
		{
			XmlDocument doc = null;

			doc = new XmlDocument();
			doc.Load("city.xml");
			XmlNodeList provinceNodeList = doc.SelectNodes("/address/province");
			if (provinceNodeList != null)
			{
				foreach (XmlNode provinceNode in provinceNodeList)
				{
					string province = provinceNode.Attributes["name"].Value;
					if (!_citys.ContainsKey(province))
						_citys.Add(province, new ArrayList());

					comboBox_provice.Items.Add(province);
					comboBox_regProvice.Items.Add(province);
					comboBox_aftersalesProvice.Items.Add(province);

					XmlNodeList cityNodeList = provinceNode.SelectNodes("city");
					if (cityNodeList != null)
					{
						foreach (XmlNode cityNode in cityNodeList)
						{
							string city = cityNode.Attributes["name"].Value;

							_citys[province].Add(city);
						}
					}
				}
				comboBox_provice.SelectedIndex = 0;
				comboBox_regProvice.SelectedIndex = 0;
				comboBox_aftersalesProvice.SelectedIndex = 0;
			}
			doc = null;

			doc = new XmlDocument();
			doc.Load("dict.xml");
			XmlNodeList rowNodeList = doc.SelectNodes("/dictlist/dict/row");
			if (rowNodeList != null)
			{
				foreach (XmlNode rowNode in rowNodeList)
				{
					SDict di = new SDict();
					di.id = int.Parse(rowNode.Attributes["TYPE_ID"].Value);
					di.name = rowNode.Attributes["DICT_NAME"].Value;
					di.code = rowNode.Attributes["DICT_CODE"].Value;
					di.rcode = rowNode.Attributes["RELEVANCE_CODE"].Value;

					if (!_dict.ContainsKey(di.id))
						_dict.Add(di.id, new Dictionary<string, SDict>());
					if (!_dict[di.id].ContainsKey(di.code))
						_dict[di.id].Add(di.code, di);
				}
			}
			doc = null;

			Dictionary<string, SDict> tdi = null;
			// 经济性质
			if (_dict.TryGetValue(14, out tdi))
			{
				foreach (KeyValuePair<string, SDict> item in tdi)
				{
					comboBox_economyNature.Items.Add(item.Value.name);
				}
				comboBox_economyNature.SelectedIndex = 0;
			}
			tdi = null;
			// 供应商类型
			if (_dict.TryGetValue(11, out tdi))
			{
				foreach (KeyValuePair<string, SDict> item in tdi)
				{
					comboBox_supplierType.Items.Add(item.Value.name);
				}
				comboBox_supplierType.SelectedIndex = 0;
			}
			tdi = null;
			// 采购方式
			if (_dict.TryGetValue(6, out tdi))
			{
				foreach (KeyValuePair<string, SDict> item in tdi)
				{
					comboBox_purchaseType.Items.Add(item.Value.name);
				}
				comboBox_purchaseType.SelectedIndex = 0;
			}
			tdi = null;

			// 信用等级
			if (_dict.TryGetValue(13, out tdi))
			{
				foreach (KeyValuePair<string, SDict> item in tdi)
				{
					comboBox_creditLevel.Items.Add(item.Value.name);
				}
				comboBox_creditLevel.SelectedIndex = 0;
			}
			tdi = null;
			// 开户银行
			if (_dict.TryGetValue(12, out tdi))
			{
				foreach (KeyValuePair<string, SDict> item in tdi)
				{
					comboBox_bank.Items.Add(item.Value.name);
				}
				comboBox_bank.SelectedIndex = 0;
			}
			tdi = null;
			// 售后类型
			if (_dict.TryGetValue(17, out tdi))
			{
				foreach (KeyValuePair<string, SDict> item in tdi)
				{
					comboBox_aftersalesType.Items.Add(item.Value.name);
				}
				comboBox_aftersalesType.SelectedIndex = 0;
			}
			tdi = null;
			// 运输车类型
			if (_dict.TryGetValue(18, out tdi))
			{
				foreach (KeyValuePair<string, SDict> item in tdi)
				{
					comboBox_transportType.Items.Add(item.Value.name);
				}
				comboBox_transportType.SelectedIndex = 0;
			}
			tdi = null;

			this.comboBox_natualTaxPay.SelectedIndex = 0;
			this.comboBox_landTaxPay.SelectedIndex = 0;
			this.comboBox_bankHasIllegal.SelectedIndex = 0;
			this.comboBox_bankHasPay.SelectedIndex = 0;
			this.comboBox_purchaseSuccese.SelectedIndex = 0;
		}

		private void comboBox_provice_SelectedIndexChanged(object sender, EventArgs e)
		{
			string provice = comboBox_provice.Text;
			comboBox_city.Items.Clear();
			foreach (string city in _citys[provice])
			{
				comboBox_city.Items.Add(city);
			}
			comboBox_city.SelectedIndex = 0;
		}

		private void comboBox_regProvice_SelectedIndexChanged(object sender, EventArgs e)
		{
			string provice = comboBox_regProvice.Text;
			comboBox_regCity.Items.Clear();
			foreach (string city in _citys[provice])
			{
				comboBox_regCity.Items.Add(city);
			}
			comboBox_regCity.SelectedIndex = 0;
		}

		private void button_storehouseImage_Click(object sender, EventArgs e)
		{
			OpenFileDialog fileDialog1 = new OpenFileDialog();
			fileDialog1.Filter = "image files|*.jpg;*.png;*.gif";
			if (fileDialog1.ShowDialog() == DialogResult.OK)
			{
				FileInfo fi = new FileInfo(fileDialog1.FileName);
				if (fi.Exists && fi.Length <= 500 * 1024)
				{
					textBox_storehouseImage.Text = fileDialog1.FileName;
				}
				else
				{
					MessageBox.Show("文件超过限制");
				}
			}

		}

		private void button_addStockholder_Click(object sender, EventArgs e)
		{
			CStockholderControl shc = new CStockholderControl(this, _shcs.Count + 1);
			_shcs.Add(shc);


			this.tabPage1.SuspendLayout();
			this.SuspendLayout();

			this.tabPage1.Controls.Add(shc.groupBox);

			// 俩按钮
			{
				Point pt = this.panel1.Location;
				pt.Y += 150;
				this.panel1.Location = pt;
			}

			this.tabPage1.ResumeLayout(true);
			this.ResumeLayout(false);
		}

		private void button_delStockholder_Click(object sender, EventArgs e)
		{
			Button btn = (Button)sender;

			int idx = 0;
			for (; idx < _shcs.Count; ++idx)
			{
				CStockholderControl item = _shcs[idx];
				if (item.buttonDelStockholder == btn)
				{
					this.tabPage1.SuspendLayout();
					this.SuspendLayout();

					this.tabPage1.Controls.Remove(item.groupBox);

					this.tabPage1.ResumeLayout(true);
					this.ResumeLayout(false);

					_shcs.Remove(item);

					break;
				}
			}

			for (; idx < _shcs.Count; ++idx)
			{
				CStockholderControl item = _shcs[idx];

				this.tabPage1.SuspendLayout();
				this.SuspendLayout();

				Point pt = item.groupBox.Location;
				pt.Y -= 150;
				item.groupBox.Location = pt;
				item.groupBox.TabIndex = idx;

				this.tabPage1.ResumeLayout(true);
				this.ResumeLayout(false);
			}

			{
				Point pt = this.panel1.Location;
				pt.Y -= 150;
				this.panel1.Location = pt;
			}
		}

		private void button_businessLicId_Click(object sender, EventArgs e)
		{
			OpenFileDialog fileDialog1 = new OpenFileDialog();
			fileDialog1.Filter = "image files|*.jpg;*.png;*.gif";
			if (fileDialog1.ShowDialog() == DialogResult.OK)
			{
				FileInfo fi = new FileInfo(fileDialog1.FileName);
				if (fi.Exists && fi.Length <= 500 * 1024)
				{
					textBox_businessLicId.Text = fileDialog1.FileName;
				}
				else
				{
					MessageBox.Show("文件超过限制");
				}
			}

		}

		private void button_organizationImage_Click(object sender, EventArgs e)
		{
			OpenFileDialog fileDialog1 = new OpenFileDialog();
			fileDialog1.Filter = "image files|*.jpg;*.png;*.gif";
			if (fileDialog1.ShowDialog() == DialogResult.OK)
			{
				FileInfo fi = new FileInfo(fileDialog1.FileName);
				if (fi.Exists && fi.Length <= 500 * 1024)
				{
					textBox_organizationImage.Text = fileDialog1.FileName;
				}
				else
				{
					MessageBox.Show("文件超过限制");
				}
			}

		}

		private void button_bankProve_Click(object sender, EventArgs e)
		{
			OpenFileDialog fileDialog1 = new OpenFileDialog();
			fileDialog1.Filter = "image files|*.jpg;*.png;*.gif";
			if (fileDialog1.ShowDialog() == DialogResult.OK)
			{
				FileInfo fi = new FileInfo(fileDialog1.FileName);
				if (fi.Exists && fi.Length <= 500 * 1024)
				{
					textBox_bankProve.Text = fileDialog1.FileName;
				}
				else
				{
					MessageBox.Show("文件超过限制");
				}
			}

		}

		private void button_qualityProve_Click(object sender, EventArgs e)
		{
			OpenFileDialog fileDialog1 = new OpenFileDialog();
			fileDialog1.Filter = "image files|*.jpg;*.png;*.gif";
			if (fileDialog1.ShowDialog() == DialogResult.OK)
			{
				FileInfo fi = new FileInfo(fileDialog1.FileName);
				if (fi.Exists && fi.Length <= 500 * 1024)
				{
					textBox_qualityProve.Text = fileDialog1.FileName;
				}
				else
				{
					MessageBox.Show("文件超过限制");
				}
			}

		}

		private void button_otherProve_Click(object sender, EventArgs e)
		{
			OpenFileDialog fileDialog1 = new OpenFileDialog();
			fileDialog1.Filter = "zip files|*.zip";
			if (fileDialog1.ShowDialog() == DialogResult.OK)
			{
				FileInfo fi = new FileInfo(fileDialog1.FileName);
				if (fi.Exists && fi.Length <= 5 * 1024 * 1024)
				{
					textBox_otherProve.Text = fileDialog1.FileName;
				}
				else
				{
					MessageBox.Show("文件超过限制");
				}
			}

		}

		private void button_br2009_Click(object sender, EventArgs e)
		{
			OpenFileDialog fileDialog1 = new OpenFileDialog();
			fileDialog1.Filter = "zip files|*.zip";
			if (fileDialog1.ShowDialog() == DialogResult.OK)
			{
				FileInfo fi = new FileInfo(fileDialog1.FileName);
				if (fi.Exists && fi.Length <= 5 * 1024 * 1024)
				{
					textBox_designRep2009.Text = fileDialog1.FileName;
				}
				else
				{
					MessageBox.Show("文件超过限制");
				}
			}
		}

		private void button_selectProduct_Click(object sender, EventArgs e)
		{
            if (_psForm == null)
            {
                _psForm = new Form2();
				_psForm.init(this);
				_psForm.Trigger = (Button)sender;
                _psForm.Show();
            }
            else
			{
				_psForm.Trigger = (Button)sender;
                if (_psForm.Visible)
                    _psForm.Activate();
                else
                   _psForm.Show();
            }
		}

		public void selectProductType(string type, string tag)
		{
			if (_psForm.Trigger.Name == "button_selectProduct")
			{
				textBox_productType.Text = type;
				textBox_productType.Tag = tag;
			}
			else
			{
				foreach (CProductControl item in _pcs)
				{
					if (item.buttonSelectProduct == _psForm.Trigger)
					{
						item.textBoxProductType.Text = type;
						item.textBoxProductType.Tag = tag;
					}
				}
			}
		}

		private void button_browsePhoto_Click(object sender, EventArgs e)
		{
			Button btn = (Button)sender;

			if (btn.Name == "button_browsePhoto")
			{
				OpenFileDialog fileDialog1 = new OpenFileDialog();
				fileDialog1.Filter = "image files|*.jpg;*.png;*.gif";
				if (fileDialog1.ShowDialog() == DialogResult.OK)
				{
					FileInfo fi = new FileInfo(fileDialog1.FileName);
					if (fi.Exists && fi.Length <= 500 * 1024)
					{
						textBox_productPhoto.Text = fileDialog1.FileName;
					}
					else
					{
						MessageBox.Show("文件超过限制");
					}
				}
			}
			else
			{
				foreach (CProductControl item in _pcs)
				{
					if (item.buttonBrowsePhoto == btn)
					{
						OpenFileDialog fileDialog1 = new OpenFileDialog();
						fileDialog1.Filter = "image files|*.jpg;*.png;*.gif";
						if (fileDialog1.ShowDialog() == DialogResult.OK)
						{
							FileInfo fi = new FileInfo(fileDialog1.FileName);
							if (fi.Exists && fi.Length <= 500 * 1024)
							{
								item.textBoxProductPhoto.Text = fileDialog1.FileName;
							}
							else
							{
								MessageBox.Show("文件超过限制");
							}
						}
						break;
					}
				}
			}
		}

		private void button_addProduct_Click(object sender, EventArgs e)
		{
			CProductControl pc = new CProductControl(this, _pcs.Count + 1);
			_pcs.Add(pc);


			this.tabPage3.SuspendLayout();
			this.SuspendLayout();

			this.tabPage3.Controls.Add(pc.groupBox);

			// 俩按钮
			if (_pcs.Count > 1)
			{
				Point pt = this.panel3.Location;
				pt.Y += 230;
				this.panel3.Location = pt;
			}

			this.tabPage3.ResumeLayout(true);
			this.ResumeLayout(false);
		}

		private void button_delProduct_Click(object sender, EventArgs e)
		{
			Button btn = (Button)sender;

			int idx = 0;
			for (; idx < _pcs.Count; ++idx)
			{
				CProductControl item = _pcs[idx];
				if (item.buttonDelProduct == btn)
				{
					this.tabPage3.SuspendLayout();
					this.SuspendLayout();

					this.tabPage3.Controls.Remove(item.groupBox);

					this.tabPage3.ResumeLayout(true);
					this.ResumeLayout(false);

					_pcs.Remove(item);

					break;
				}
			}

			for (; idx < _pcs.Count; ++idx)
			{
				CProductControl item = _pcs[idx];

				this.tabPage3.SuspendLayout();
				this.SuspendLayout();

				Point pt = item.groupBox.Location;
				pt.Y -= 230;
				item.groupBox.Location = pt;
				item.groupBox.TabIndex = idx;

				this.tabPage3.ResumeLayout(true);
				this.ResumeLayout(false);
			}

			if (_pcs.Count > 0)
			{
				Point pt = this.panel3.Location;
				pt.Y -= 230;
				this.panel3.Location = pt;
			}
		}

		private void comboBox_aftersalesProvice_SelectedIndexChanged(object sender, EventArgs e)
		{
			ComboBox cbb = (ComboBox)sender;

			if (cbb.Name == "comboBox_aftersalesProvice")
			{
				string provice = cbb.Text;
				comboBox_aftersalesCity.Items.Clear();
				foreach (string city in _citys[provice])
				{
					comboBox_aftersalesCity.Items.Add(city);
				}
				comboBox_aftersalesCity.SelectedIndex = 0;
			}
			else
			{
				foreach (CAftersalesControl item in _ascs)
				{
					if (item.comboBoxAftersalesProvice == cbb)
					{
						string provice = cbb.Text;
						item.comboBoxAftersalesCity.Items.Clear();
						foreach (string city in _citys[provice])
						{
							item.comboBoxAftersalesCity.Items.Add(city);
						}
						item.comboBoxAftersalesCity.SelectedIndex = 0;
						break;
					}
				}
			}

		}

		private void button_addAftersales_Click(object sender, EventArgs e)
		{
			CAftersalesControl asc = new CAftersalesControl(this, _ascs.Count + 1);
			_ascs.Add(asc);


			this.tabPage4.SuspendLayout();
			this.SuspendLayout();

			this.tabPage4.Controls.Add(asc.groupBox);

			// 俩按钮
			if (_ascs.Count == 2)
			{
				Point pt = this.panel4.Location;
				pt.Y += 120;
				this.panel4.Location = pt;
			}
			else if (_ascs.Count > 2)
			{
				Point pt = this.panel4.Location;
				pt.Y += 190;
				this.panel4.Location = pt;
			}

			this.tabPage4.ResumeLayout(true);
			this.ResumeLayout(false);

		}

		private void button_delAftersales_Click(object sender, EventArgs e)
		{
			Button btn = (Button)sender;

			int idx = 0;
			for (; idx < _ascs.Count; ++idx)
			{
				CAftersalesControl item = _ascs[idx];
				if (item.buttonDelAftersales == btn)
				{
					this.tabPage3.SuspendLayout();
					this.SuspendLayout();

					this.tabPage4.Controls.Remove(item.groupBox);

					this.tabPage4.ResumeLayout(true);
					this.ResumeLayout(false);

					_ascs.Remove(item);

					break;
				}
			}

			for (; idx < _ascs.Count; ++idx)
			{
				CAftersalesControl item = _ascs[idx];

				this.tabPage4.SuspendLayout();
				this.SuspendLayout();

				Point pt = item.groupBox.Location;
				pt.Y -= 190;
				item.groupBox.Location = pt;
				item.groupBox.TabIndex = idx;

				this.tabPage4.ResumeLayout(true);
				this.ResumeLayout(false);
			}

			if (_ascs.Count == 1)
			{
				Point pt = this.panel4.Location;
				pt.Y -= 120;
				this.panel4.Location = pt;
			}
			else if (_ascs.Count > 1)
			{
				Point pt = this.panel4.Location;
				pt.Y -= 190;
				this.panel4.Location = pt;
			}
		}

		private void tabControl_data_Selected(object sender, TabControlEventArgs e)
		{
			switch (tabControl_data.SelectedIndex)
			{
				case 0:
					this.AcceptButton = button_next1;
					this.CancelButton = button_cancel1;
					break;
				case 1:
					this.AcceptButton = button_next2;
					this.CancelButton = button_cancel2;
					break;
				case 2:
					this.AcceptButton = button_next3;
					this.CancelButton = button_cancel3;
					break;
				case 3:
					this.AcceptButton = button_next4;
					this.CancelButton = button_cancel4;
					break;
				case 4:
					this.AcceptButton = button_finish;
					this.CancelButton = button_cancel5;
					break;
			}
		}

		private void button_next1_Click(object sender, EventArgs e)
		{
			this.tabControl_data.SelectedIndex = 1;
			this.AcceptButton = button_next2;
			this.CancelButton = button_cancel2;
		}

		private void button_next2_Click(object sender, EventArgs e)
		{
			this.tabControl_data.SelectedIndex = 2;
			this.AcceptButton = button_next3;
			this.CancelButton = button_cancel3;
		}

		private void button_next3_Click(object sender, EventArgs e)
		{
			this.tabControl_data.SelectedIndex = 3;
			this.AcceptButton = button_next4;
			this.CancelButton = button_cancel4;
		}

		private void button_next4_Click(object sender, EventArgs e)
		{
			this.tabControl_data.SelectedIndex = 4;
			this.AcceptButton = button_finish;
			this.CancelButton = button_cancel5;
		}

		private void button_cancel_Click(object sender, EventArgs e)
		{
			this.Close();
        }

		private void setXmlElem(XmlTextWriter writer, string key, string value)
		{
			writer.WriteStartElement(key);
			writer.WriteString(value);
			writer.WriteEndElement();
		}

		private void setXmlElemFile(XmlTextWriter writer, string key, string value, string folder)
		{
			if (File.Exists(value))
			{
				string name = Path.GetFileName(value);
				while (File.Exists(folder + Path.DirectorySeparatorChar + name))
				{
					name = Path.GetFileNameWithoutExtension(name) + "1" + Path.GetExtension(name);
				}
				File.Copy(value, folder + Path.DirectorySeparatorChar + name);
				setXmlElem(writer, key, name);
			}
			else
			{
				setXmlElem(writer, key, "");
			}
		}

		private bool check1()
		{
			try
			{
				if (this.textBox_fullName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写供应商全称！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_fullName.Focus();
					return false;
				}
				if (this.textBox_shortName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写供应商简称！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_shortName.Focus();
					return false;
				}
				if (this.textBox_referee.Text.Length == 0)
				{
					MessageBox.Show("请正确填写法定代表人！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_referee.Focus();
					return false;
				}
				if (this.textBox_telephone.Text.Length == 0)
				{
					MessageBox.Show("请正确填写法定代表人固定电话！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_telephone.Focus();
					return false;
				}
				if (this.textBox_adress.Text.Length == 0)
				{
					MessageBox.Show("请正确填写供应商注册地址！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_adress.Focus();
					return false;
				}
				if (this.textBox_mobile.Text.Length == 0)
				{
					MessageBox.Show("请正确填写法定代表人手机号码！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_mobile.Focus();
					return false;
				}
				if (this.textBox_longitude.Text.Length == 0)
				{
					MessageBox.Show("请正确填写经度！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_longitude.Focus();
					return false;
				}
				if (this.textBox_latitude.Text.Length == 0)
				{
					MessageBox.Show("请正确填写纬度！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_latitude.Focus();
					return false;
				}
				if (this.textBox_postid.Text.Length == 0)
				{
					MessageBox.Show("请正确填写邮编！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_postid.Focus();
					return false;
				}
				if (this.textBox_website.Text.Length == 0)
				{
					MessageBox.Show("请正确填写网址！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_website.Focus();
					return false;
				}
				if (this.textBox_supplierContact.Text.Length == 0)
				{
					MessageBox.Show("请正确填写联系人！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_supplierContact.Focus();
					return false;
				}
				if (this.textBox_supplierMobile.Text.Length == 0)
				{
					MessageBox.Show("请正确填写联系人手机！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_supplierMobile.Focus();
					return false;
				}
				if (this.textBox_supplierTelephone.Text.Length == 0)
				{
					MessageBox.Show("请正确填写联系人电话！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_supplierTelephone.Focus();
					return false;
				}
				if (this.textBox_supplierFax.Text.Length == 0)
				{
					MessageBox.Show("请正确填写联系人传真！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_supplierFax.Focus();
					return false;
				}
				if (this.textBox_storehouseArea.Text.Length == 0)
				{
					MessageBox.Show("请正确填写仓库面积！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_storehouseArea.Focus();
					return false;
				}
				if (this.textBox_warehouseArea.Text.Length == 0)
				{
					MessageBox.Show("请正确填写货场面积！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_warehouseArea.Focus();
					return false;
				}
				if (!File.Exists(this.textBox_storehouseImage.Text))
				{
					MessageBox.Show("请正确填写仓库照片！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_storehouseImage.Focus();
					return false;
				}
				if (this.textBox_stockholderName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写股东姓名！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_stockholderName.Focus();
					return false;
				}
				if (this.textBox_stockholderCapital.Text.Length == 0)
				{
					MessageBox.Show("请正确填写股东出资金额！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_stockholderCapital.Focus();
					return false;
				}
				if (this.textBox_stockholderRatio.Text.Length == 0)
				{
					MessageBox.Show("请正确填写股东出资比例！");
					this.tabControl_data.SelectedIndex = 0;
					this.textBox_stockholderRatio.Focus();
					return false;
				}
				foreach (CStockholderControl sh in _shcs)
				{
					if (sh.textBoxStockholderName.Text.Length == 0)
					{
						MessageBox.Show("请正确填写股东姓名！");
						this.tabControl_data.SelectedIndex = 0;
						sh.textBoxStockholderName.Focus();
						return false;
					}
					if (sh.textBoxStockholderCapital.Text.Length == 0)
					{
						MessageBox.Show("请正确填写股东出资金额！");
						this.tabControl_data.SelectedIndex = 0;
						sh.textBoxStockholderCapital.Focus();
						return false;
					}
					if (sh.textBoxStockholderRatio.Text.Length == 0)
					{
						MessageBox.Show("请正确填写股东出资比例！");
						this.tabControl_data.SelectedIndex = 0;
						sh.textBoxStockholderRatio.Focus();
						return false;
					}
				}
			}
			catch (System.Exception ex)
			{
				MessageBox.Show(ex.ToString());
				return false;
			}

			return true;
		}

		private bool check2()
		{
			try
			{
				if (!File.Exists(this.textBox_businessLicId.Text))
				{
					MessageBox.Show("请正确填写营业执照！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_businessLicId.Focus();
					return false;
				}
				if (this.textBox_businessLicOrg.Text.Length == 0)
				{
					MessageBox.Show("请正确填写营业执照发证机关！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_businessLicOrg.Focus();
					return false;
				}
				if (this.textBox_regId.Text.Length == 0)
				{
					MessageBox.Show("请正确填写营业执照注册号！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_regId.Focus();
					return false;
				}
				if (this.textBox_regCapital.Text.Length == 0)
				{
					MessageBox.Show("请正确填写注册资本！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_regCapital.Focus();
					return false;
				}
				if (this.textBox_creditOrg.Text.Length == 0)
				{
					MessageBox.Show("请正确填写信用评定机构！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_creditOrg.Focus();
					return false;
				}
				if (this.textBox_natualTaxId.Text.Length == 0)
				{
					MessageBox.Show("请正确填写国税税务登记号码！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_natualTaxId.Focus();
					return false;
				}
				if (this.textBox_natualTaxOrg.Text.Length == 0)
				{
					MessageBox.Show("请正确填写国税税务发证机关！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_natualTaxOrg.Focus();
					return false;
				}
				if (this.textBox_landTaxId.Text.Length == 0)
				{
					MessageBox.Show("请正确填写地税税务登记号码！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_landTaxId.Focus();
					return false;
				}
				if (this.textBox_landTaxOrg.Text.Length == 0)
				{
					MessageBox.Show("请正确填写地税税务发证机关！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_landTaxOrg.Focus();
					return false;
				}
				if (!File.Exists(this.textBox_organizationImage.Text))
				{
					MessageBox.Show("请正确填写组织机构代码扫描件！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_organizationImage.Focus();
					return false;
				}
				if (this.textBox_organizationId.Text.Length == 0)
				{
					MessageBox.Show("请正确填写组织机构代码！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_organizationId.Focus();
					return false;
				}
				if (this.dateTimePicker_businessLicDateStart.Value.CompareTo(this.dateTimePicker_businessLicDateEnd.Value) >= 0)
				{
					MessageBox.Show("请正确填写国税税务有效期！");
					this.tabControl_data.SelectedIndex = 1;
					this.dateTimePicker_businessLicDateStart.Focus();
					return false;
				}
				if (this.textBox_mainScope.Text.Length == 0)
				{
					MessageBox.Show("请正确填写主营范围！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_mainScope.Focus();
					return false;
				}
				if (this.textBox_secodeScope.Text.Length == 0)
				{
					MessageBox.Show("请正确填写兼营范围！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_secodeScope.Focus();
					return false;
				}
				if (this.textBox_bankId.Text.Length == 0)
				{
					MessageBox.Show("请正确填写开户银行帐号！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_bankId.Focus();
					return false;
				}
				if (this.textBox_bankContact.Text.Length == 0)
				{
					MessageBox.Show("请正确填写开户银行联系人！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_bankContact.Focus();
					return false;
				}
				if (this.textBox_bankAdress.Text.Length == 0)
				{
					MessageBox.Show("请正确填写开户银行地址！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_bankAdress.Focus();
					return false;
				}
				if (this.textBox_bankTel.Text.Length == 0)
				{
					MessageBox.Show("请正确填写开户银行电话！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_bankTel.Focus();
					return false;
				}
				if (this.textBox_bankMobile.Text.Length == 0)
				{
					MessageBox.Show("请正确填写开户银行手机！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_bankMobile.Focus();
					return false;
				}
				if (this.textBox_bankFax.Text.Length == 0)
				{
					MessageBox.Show("请正确填写开户银行传真！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_bankFax.Focus();
					return false;
				}
				if (this.textBox_bankMail.Text.Length == 0)
				{
					MessageBox.Show("请正确填写开户银行邮箱！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_bankMail.Focus();
					return false;
				}
				if (!File.Exists(this.textBox_bankProve.Text))
				{
					MessageBox.Show("请正确填写银行资信证明文件！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_bankProve.Focus();
					return false;
				}
				if (!File.Exists(this.textBox_qualityProve.Text))
				{
					MessageBox.Show("请正确填写质量管理证明文件！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_qualityProve.Focus();
					return false;
				}
				if (!File.Exists(this.textBox_otherProve.Text))
				{
					MessageBox.Show("请正确填写其它证明文件！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_otherProve.Focus();
					return false;
				}
				if (!File.Exists(this.textBox_designRep2009.Text))
				{
					MessageBox.Show("请正确填写审计报告扫描件！");
					this.tabControl_data.SelectedIndex = 1;
					this.textBox_designRep2009.Focus();
					return false;
				}
			}
			catch (System.Exception ex)
			{
				MessageBox.Show(ex.ToString());
				return false;
			}

			return true;
		}

		private bool check3()
		{
			try
			{
				if (this.textBox_productName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写产品名称！");
					this.tabControl_data.SelectedIndex = 2;
					this.textBox_productName.Focus();
					return false;
				}
				if (this.textBox_productUnit.Text.Length == 0)
				{
					MessageBox.Show("请正确填写产品计量单位！");
					this.tabControl_data.SelectedIndex = 2;
					this.textBox_productUnit.Focus();
					return false;
				}
				if (this.textBox_productMode.Text.Length == 0)
				{
					MessageBox.Show("请正确填写产品型号！");
					this.tabControl_data.SelectedIndex = 2;
					this.textBox_productMode.Focus();
					return false;
				}
				if (this.textBox_productYieldYearAvg.Text.Length == 0)
				{
					MessageBox.Show("请正确填写产品年均产量！");
					this.tabControl_data.SelectedIndex = 2;
					this.textBox_productYieldYearAvg.Focus();
					return false;
				}
				if (this.textBox_productYeildYearMax.Text.Length == 0)
				{
					MessageBox.Show("请正确填写产品最大年产量！");
					this.tabControl_data.SelectedIndex = 2;
					this.textBox_productYeildYearMax.Focus();
					return false;
				}
				if (this.textBox_productYeildMax.Text.Length == 0)
				{
					MessageBox.Show("请正确填写产品单批最大产量！");
					this.tabControl_data.SelectedIndex = 2;
					this.textBox_productYeildMax.Focus();
					return false;
				}
				if (this.textBox_productDayofMaxYeild.Text.Length == 0)
				{
					MessageBox.Show("请正确填写产品完成单批最大产量所用天数！");
					this.tabControl_data.SelectedIndex = 2;
					this.textBox_productDayofMaxYeild.Focus();
					return false;
				}
				if (!File.Exists(this.textBox_productPhoto.Text))
				{
					MessageBox.Show("请正确填写产品照片！");
					this.tabControl_data.SelectedIndex = 2;
					this.textBox_productPhoto.Focus();
					return false;
				}
				foreach (CProductControl pc in _pcs)
				{
					if (pc.textBoxProductName.Text.Length == 0)
					{
						MessageBox.Show("请正确填写产品名称！");
						this.tabControl_data.SelectedIndex = 2;
						pc.textBoxProductName.Focus();
						return false;
					}
					if (pc.textBoxProductUnit.Text.Length == 0)
					{
						MessageBox.Show("请正确填写产品计量单位！");
						this.tabControl_data.SelectedIndex = 2;
						pc.textBoxProductUnit.Focus();
						return false;
					}
					if (pc.textBoxProductMode.Text.Length == 0)
					{
						MessageBox.Show("请正确填写产品型号！");
						this.tabControl_data.SelectedIndex = 2;
						pc.textBoxProductMode.Focus();
						return false;
					}
					if (pc.textBoxProductYieldYearAvg.Text.Length == 0)
					{
						MessageBox.Show("请正确填写产品年均产量！");
						this.tabControl_data.SelectedIndex = 2;
						pc.textBoxProductYieldYearAvg.Focus();
						return false;
					}
					if (pc.textBoxProductYeildYearMax.Text.Length == 0)
					{
						MessageBox.Show("请正确填写产品最大年产量！");
						this.tabControl_data.SelectedIndex = 2;
						pc.textBoxProductYeildYearMax.Focus();
						return false;
					}
					if (pc.textBoxProductYeildMax.Text.Length == 0)
					{
						MessageBox.Show("请正确填写产品单批最大产量！");
						this.tabControl_data.SelectedIndex = 2;
						pc.textBoxProductYeildMax.Focus();
						return false;
					}
					if (pc.textBoxProductDayofMaxYeild.Text.Length == 0)
					{
						MessageBox.Show("请正确填写产品完成单批最大产量所用天数！");
						this.tabControl_data.SelectedIndex = 2;
						pc.textBoxProductDayofMaxYeild.Focus();
						return false;
					}
					if (!File.Exists(pc.textBoxProductPhoto.Text))
					{
						MessageBox.Show("请正确填写产品照片！");
						this.tabControl_data.SelectedIndex = 2;
						pc.textBoxProductPhoto.Focus();
						return false;
					}
				}
			}
			catch (System.Exception ex)
			{
				MessageBox.Show(ex.ToString());
				return false;
			}

			return true;
		}

		private bool check4()
		{
			try
			{
				if (this.textBox_aftersalesName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写服务机构名称！");
					this.tabControl_data.SelectedIndex = 3;
					this.textBox_aftersalesName.Focus();
					return false;
				}
				if (this.textBox_aftersalesContext.Text.Length == 0)
				{
					MessageBox.Show("请正确填写服务机构负责人！");
					this.tabControl_data.SelectedIndex = 3;
					this.textBox_aftersalesContext.Focus();
					return false;
				}
				if (this.textBox_aftersalesTel.Text.Length == 0)
				{
					MessageBox.Show("请正确填写服务机构联系电话！");
					this.tabControl_data.SelectedIndex = 3;
					this.textBox_aftersalesTel.Focus();
					return false;
				}
				foreach (CAftersalesControl asc in _ascs)
				{
					if (asc.textBoxAftersalesName.Text.Length == 0)
					{
						MessageBox.Show("请正确填写服务机构名称！");
						this.tabControl_data.SelectedIndex = 3;
						asc.textBoxAftersalesName.Focus();
						return false;
					}
					if (asc.textBoxAftersalesContext.Text.Length == 0)
					{
						MessageBox.Show("请正确填写服务机构负责人！");
						this.tabControl_data.SelectedIndex = 3;
						asc.textBoxAftersalesContext.Focus();
						return false;
					}
					if (asc.textBoxAftersalesTel.Text.Length == 0)
					{
						MessageBox.Show("请正确填写服务机构联系电话！");
						this.tabControl_data.SelectedIndex = 3;
						asc.textBoxAftersalesTel.Focus();
						return false;
					}
				}
			}
			catch (System.Exception ex)
			{
				MessageBox.Show(ex.ToString());
				return false;
			}

			return true;
		}

		private bool check5()
		{
			try
			{
				if (this.textBox_transportName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写运输企业名称！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportName.Focus();
					return false;
				}
				if (this.textBox_transportDeadweight.Text.Length == 0)
				{
					MessageBox.Show("请正确填写运输车载重量！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportDeadweight.Focus();
					return false;
				}
				if (this.textBox_transportNum.Text.Length == 0)
				{
					MessageBox.Show("请正确填写运输车数量！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportNum.Focus();
					return false;
				}
				if (this.textBox_transportHighwayName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写高速公路名称！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportHighwayName.Focus();
					return false;
				}
				if (this.textBox_transportHighwayID.Text.Length == 0)
				{
					MessageBox.Show("请正确填写高速公路编号！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportHighwayID.Focus();
					return false;
				}
				if (this.textBox_transportHighwayEnterName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写最近高速公路入口名称！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportHighwayEnterName.Focus();
					return false;
				}
				if (this.textBox_transportHighwayEnterID.Text.Length == 0)
				{
					MessageBox.Show("请正确填写最近高速公路入口编号！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportHighwayEnterID.Focus();
					return false;
				}
				if (this.textBox_transportHighwayDistance.Text.Length == 0)
				{
					MessageBox.Show("请正确填写最近高速公路入口距离！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportHighwayDistance.Focus();
					return false;
				}
				if (this.textBox_transportRailwayName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写最近铁路货运站名称！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportRailwayName.Focus();
					return false;
				}
				if (this.textBox_transportRailwayDistance.Text.Length == 0)
				{
					MessageBox.Show("请正确填写最近铁路货运站距离！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportRailwayDistance.Focus();
					return false;
				}
				if (this.textBox_transportPortName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写最近港口名称！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportPortName.Focus();
					return false;
				}
				if (this.textBox_transportPortDistance.Text.Length == 0)
				{
					MessageBox.Show("请正确填写最近港口距离！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportPortDistance.Focus();
					return false;
				}
				if (this.textBox_transportAirportName.Text.Length == 0)
				{
					MessageBox.Show("请正确填写最近机场名称！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportAirportName.Focus();
					return false;
				}
				if (this.textBox_transportAirportDistance.Text.Length == 0)
				{
					MessageBox.Show("请正确填写最近机场距离！");
					this.tabControl_data.SelectedIndex = 4;
					this.textBox_transportAirportDistance.Focus();
					return false;
				}
			}
			catch (System.Exception ex)
			{
				MessageBox.Show(ex.ToString());
				return false;
			}

			return true;
		}

		private void button_finish_Click(object sender, EventArgs e)
		{
			if (!check1())
			{
				//MessageBox.Show("数据填写不完整！");
				return;
			}
			if (!check2())
			{
				return;
			}
			if (!check3())
			{
				return;
			}
			if (!check4())
			{
				return;
			}
			if (!check5())
			{
				return;
			}

			FolderBrowserDialog saveFileDialog1 = new System.Windows.Forms.FolderBrowserDialog();
			saveFileDialog1.Description = "请选择文件保存路径";
			saveFileDialog1.ShowNewFolderButton = true;
			if (saveFileDialog1.ShowDialog() != DialogResult.OK)
				return;

			string filepath = saveFileDialog1.SelectedPath;

			// 创建一个临时文件夹
			string tmppath = Path.GetTempPath() + "\\" + Path.GetRandomFileName();
			Directory.CreateDirectory(tmppath);

			// 供应商信息
			XmlTextWriter writer = new XmlTextWriter(tmppath + "\\supportor.xml", Encoding.UTF8);
			writer.Formatting = Formatting.Indented;  //缩进格式
			writer.Indentation = 4;
			writer.WriteStartDocument();
			writer.WriteStartElement("DTO");
			writer.WriteStartElement("ROW");
			setXmlElem(writer, "SUPNAME", this.textBox_fullName.Text);
			//setXmlElem(writer, "SUPENNAME", "");
			setXmlElem(writer, "CREATEDATE", this.dateTimePicker_creat.Text);
			setXmlElem(writer, "ABBREVIATION", this.textBox_shortName.Text);
			setXmlElem(writer, "ADDRESS", this.textBox_adress.Text);
			setXmlElem(writer, "POSTCODE", this.textBox_postid.Text);
			setXmlElem(writer, "NETADDR", this.textBox_website.Text);
			setXmlElem(writer, "ORGANIZECODE", this.textBox_organizationId.Text);
			setXmlElem(writer, "ECONOMY", this.comboBox_economyNature.Text);
			try
			{
				foreach (KeyValuePair<string, SDict> item in _dict[11])
				{
					if (this.comboBox_supplierType.Text == item.Value.name)
					{
						setXmlElem(writer, "TYPECODE", item.Value.code);
					}
				}
			}
			catch
			{
				setXmlElem(writer, "TYPECODE", "");
			}
			setXmlElem(writer, "TYPE", this.comboBox_supplierType.Text);
			setXmlElem(writer, "PURCHASETYPE", this.comboBox_purchaseType.Text);
			setXmlElem(writer, "IFTURNOVER", this.comboBox_purchaseSuccese.Text);
			try
			{
				foreach (KeyValuePair<string, SDict> item in _dict[12])
				{
					if (this.comboBox_bank.Text == item.Value.name)
					{
						setXmlElem(writer, "BANKID", item.Value.code);
					}
				}
			}
			catch
			{
				setXmlElem(writer, "BANKID", "");
			}
			setXmlElem(writer, "BANK", this.comboBox_bank.Text);
			setXmlElem(writer, "ACCOUNT", this.textBox_bankId.Text);
			//setXmlElem(writer, "CREDITID", this.textBox_fullName.Text);
			setXmlElem(writer, "CREDIT", this.comboBox_creditLevel.Text);
			setXmlElem(writer, "CREDITORG", this.textBox_creditOrg.Text);
			setXmlElem(writer, "CREDITDATE", this.dateTimePicker_creditDate.Text);
			setXmlElem(writer, "INSURANCE", this.comboBox_bankHasPay.Text);
			setXmlElem(writer, "ILLEGAL", this.comboBox_bankHasIllegal.Text);
			setXmlElem(writer, "CORPORATION", this.textBox_referee.Text);
			setXmlElem(writer, "CORPPHONE", this.textBox_telephone.Text);
			setXmlElem(writer, "CORPMOBILE", this.textBox_mobile.Text);
			setXmlElem(writer, "CONTACT", this.textBox_supplierContact.Text);
			setXmlElem(writer, "CONTACTPHONE", this.textBox_supplierTelephone.Text);
			setXmlElem(writer, "CONTACTMOBILE", this.textBox_supplierMobile.Text);
			setXmlElem(writer, "CONTACTFAX", this.textBox_supplierFax.Text);
			//setXmlElem(writer, "CONTACTEMAIL", this.textBox_fullName.Text);
			setXmlElem(writer, "LICNO", this.textBox_regId.Text);
			setXmlElem(writer, "LICORG", this.textBox_businessLicOrg.Text);
			setXmlElem(writer, "LICCAPITAL", this.textBox_regCapital.Text);
			setXmlElem(writer, "LICADDR", this.comboBox_regProvice.Text + "," + this.comboBox_regCity.Text);
			setXmlElem(writer, "L1LOC", this.comboBox_regProvice.Text);
			setXmlElem(writer, "L2LOC", this.comboBox_regCity.Text);
			setXmlElem(writer, "LICVALSTART", this.dateTimePicker_businessLicDateStart.Text);
			setXmlElem(writer, "LICVALEND", this.dateTimePicker_businessLicDateEnd.Text);
			setXmlElem(writer, "LICEXADATE", this.dateTimePicker_businessLicCheckDate.Text);
			setXmlElem(writer, "LICMAINOPT", this.textBox_mainScope.Text);
			setXmlElem(writer, "LICOTHEROPT", this.textBox_secodeScope.Text);
			setXmlElem(writer, "STATETAXNO", this.textBox_natualTaxId.Text);
			setXmlElem(writer, "LOCALTAXNO", this.textBox_landTaxId.Text);
			setXmlElem(writer, "STATETAXORG", this.textBox_natualTaxOrg.Text);
			setXmlElem(writer, "LOCALTAXORG", this.textBox_landTaxOrg.Text);
			setXmlElem(writer, "STATETAXVALSTART", this.dateTimePicker_natualTaxDateStart.Text);
			setXmlElem(writer, "STATETAXVALEND", this.dateTimePicker_natualTaxDateEnd.Text);
			setXmlElem(writer, "LOCALTAXVALSTART", this.dateTimePicker_landTaxDateStart.Text);
			setXmlElem(writer, "LOCALTAXVALEND", this.dateTimePicker_landTaxDateEnd.Text);
			setXmlElem(writer, "IFSTATETAX", this.comboBox_natualTaxPay.Text);
			setXmlElem(writer, "IFLOCALTAX", this.comboBox_landTaxPay.Text);
			//setXmlElem(writer, "SUPTYPECODE", this.textBox_fullName.Text);
			//setXmlElem(writer, "SUPTYPE", this.textBox_fullName.Text);
			//setXmlElem(writer, "SUMMARY", this.textBox_fullName.Text);
			//setXmlElem(writer, "IMAGE", this.textBox_fullName.Text);
			//setXmlElem(writer, "LOCATION", this.textBox_fullName.Text);
			//setXmlElem(writer, "LONGITUDE", this.textBox_fullName.Text);
			//setXmlElem(writer, "LATITUDE", this.textBox_fullName.Text);
			//setXmlElem(writer, "PRODUCTSCLASS", this.textBox_fullName.Text);
			//setXmlElem(writer, "MANUFACTURERCONTACT", this.textBox_fullName.Text);
			//setXmlElem(writer, "MANUFACTURERPHONE", this.textBox_fullName.Text);
			//setXmlElem(writer, "MANUFACTURERFAX", this.textBox_fullName.Text);
			//setXmlElem(writer, "MANUFACTUREREMAIL", this.textBox_fullName.Text);
			//setXmlElem(writer, "MANUFACTURERADDRESS", this.textBox_fullName.Text);
			//setXmlElem(writer, "MANUFACTURERPERFORMANCE", this.textBox_fullName.Text);
			//setXmlElem(writer, "MANUFACTURERSUMMARY", this.textBox_fullName.Text);
			//setXmlElem(writer, "MANUFACTURER", this.textBox_fullName.Text);
			setXmlElem(writer, "STOREHOUSEAREA", this.textBox_storehouseArea.Text);
			setXmlElem(writer, "WAREHOUSEAREA", this.textBox_warehouseArea.Text);
			setXmlElemFile(writer, "STOREHOUSEIMAGE", this.textBox_storehouseImage.Text, tmppath);
			setXmlElemFile(writer, "LICBUSIMAGE", this.textBox_businessLicId.Text, tmppath);
			setXmlElemFile(writer, "ORGSTRIMAGE", this.textBox_organizationImage.Text, tmppath);
			setXmlElemFile(writer, "BANKPROVE", this.textBox_bankProve.Text, tmppath);
			setXmlElemFile(writer, "QUALITYPROVE", this.textBox_qualityProve.Text, tmppath);
			setXmlElemFile(writer, "OTHERPROVE", this.textBox_otherProve.Text, tmppath);
			setXmlElemFile(writer, "AUDITLAST3Y", this.textBox_designRep2009.Text, tmppath);
			//setXmlElem(writer, "PURCHASETYPE", this.textBox_fullName.Text);
			//setXmlElem(writer, "IFTURNOVER", this.textBox_fullName.Text);
			writer.WriteEndElement();
			writer.WriteEndElement();
			writer.Flush();
			writer.Close();

			// 股东信息
			writer = new XmlTextWriter(tmppath + "\\supportor_stock.xml", Encoding.UTF8);
			writer.Formatting = Formatting.Indented;  //缩进格式
			writer.Indentation = 4;
			writer.WriteStartDocument();
			writer.WriteStartElement("DTO");
			{
				writer.WriteStartElement("ROW");
				setXmlElem(writer, "STOCKHOLDERNAME", this.textBox_stockholderName.Text);
				setXmlElem(writer, "CAPITAL", this.textBox_stockholderCapital.Text);
				setXmlElem(writer, "RATIO", this.textBox_stockholderRatio.Text);
				setXmlElem(writer, "STOCKDATE", this.dateTimePicker_stockholderStockDate.Text);
				writer.WriteEndElement();
			}
			foreach (CStockholderControl sh in _shcs)
			{
				writer.WriteStartElement("ROW");
				setXmlElem(writer, "STOCKHOLDERNAME", sh.textBoxStockholderName.Text);
				setXmlElem(writer, "CAPITAL", sh.textBoxStockholderCapital.Text);
				setXmlElem(writer, "RATIO", sh.textBoxStockholderRatio.Text);
				setXmlElem(writer, "STOCKDATE", sh.dateTimePickerStockholderStockDate.Text);
				writer.WriteEndElement();
			}
			writer.WriteEndElement();
			writer.Flush();
			writer.Close();

			// 产品
			writer = new XmlTextWriter(tmppath + "\\supportor_product.xml", Encoding.UTF8);
			writer.Formatting = Formatting.Indented;  //缩进格式
			writer.Indentation = 4;
			writer.WriteStartDocument();
			writer.WriteStartElement("DTO");
			{
				writer.WriteStartElement("ROW");
				setXmlElem(writer, "GOODNAME", this.textBox_productType.Text);
				setXmlElem(writer, "PRODTYPE", (string)this.textBox_productType.Tag);
				setXmlElem(writer, "PRODNAME", this.textBox_productName.Text);
				setXmlElem(writer, "MEASURUNIT", this.textBox_productUnit.Text);
				setXmlElem(writer, "PRODNO", this.textBox_productMode.Text);
				setXmlElem(writer, "AVGOUTPUT", this.textBox_productYieldYearAvg.Text);
				setXmlElem(writer, "MAXOUTPUT", this.textBox_productYeildYearMax.Text);
				setXmlElem(writer, "SINGLEMAXOUTPUT", this.textBox_productYeildMax.Text);
				setXmlElem(writer, "SINGLEMAXDATE", this.textBox_productDayofMaxYeild.Text);
				setXmlElemFile(writer, "PRODIMAGE", this.textBox_productPhoto.Text, tmppath);
				//setXmlElem(writer, "remark", this.textBox_productType.Text);
				writer.WriteEndElement();
			}
			foreach (CProductControl pc in _pcs)
			{
				writer.WriteStartElement("ROW");
				setXmlElem(writer, "GOODNAME", pc.textBoxProductType.Text);
				setXmlElem(writer, "PRODNAME", pc.textBoxProductName.Text);
				setXmlElem(writer, "MEASURUNIT", pc.textBoxProductUnit.Text);
				setXmlElem(writer, "PRODNO", pc.textBoxProductMode.Text);
				setXmlElem(writer, "AVGOUTPUT", pc.textBoxProductYieldYearAvg.Text);
				setXmlElem(writer, "MAXOUTPUT", pc.textBoxProductYeildYearMax.Text);
				setXmlElem(writer, "SINGLEMAXOUTPUT", pc.textBoxProductYeildMax.Text);
				setXmlElem(writer, "SINGLEMAXDATE", pc.textBoxProductDayofMaxYeild.Text);
				setXmlElem(writer, "PRODIMAGE", pc.textBoxProductPhoto.Text);
				//setXmlElem(writer, "remark", pc.textBoxProductType.Text);
				writer.WriteEndElement();
			}
			writer.WriteEndElement();
			writer.Flush();
			writer.Close();

			// 售后信息
			writer = new XmlTextWriter(tmppath + "\\supportor_org.xml", Encoding.UTF8);
			writer.Formatting = Formatting.Indented;  //缩进格式
			writer.Indentation = 4;
			writer.WriteStartDocument();
			writer.WriteStartElement("DTO");
			{
				writer.WriteStartElement("ROW");
				setXmlElem(writer, "ORGNAME", this.textBox_aftersalesName.Text);
				setXmlElem(writer, "ORGTYPE", this.comboBox_aftersalesType.Text);
				setXmlElem(writer, "LOCATION", this.comboBox_aftersalesProvice.Text + "," + this.comboBox_aftersalesCity.Text);
				setXmlElem(writer, "DIRECTOR", this.textBox_aftersalesContext.Text);
				setXmlElem(writer, "PHONE", this.textBox_aftersalesTel.Text);
				writer.WriteEndElement();
			}
			foreach (CAftersalesControl asc in _ascs)
			{
				writer.WriteStartElement("ROW");
				setXmlElem(writer, "ORGNAME", asc.textBoxAftersalesName.Text);
				setXmlElem(writer, "ORGTYPE", asc.comboBoxAftersalesType.Text);
				setXmlElem(writer, "LOCATION", asc.comboBoxAftersalesProvice.Text + "," + asc.comboBoxAftersalesCity.Text);
				setXmlElem(writer, "DIRECTOR", asc.textBoxAftersalesContext.Text);
				setXmlElem(writer, "PHONE", asc.textBoxAftersalesTel.Text);
				writer.WriteEndElement();
			}
			writer.WriteEndElement();
			writer.Flush();
			writer.Close();

			// 高速公路信息
			writer = new XmlTextWriter(tmppath + "\\supportor_highway.xml", Encoding.UTF8);
			writer.Formatting = Formatting.Indented;  //缩进格式
			writer.Indentation = 4;
			writer.WriteStartDocument();
			writer.WriteStartElement("DTO");
			{
				writer.WriteStartElement("ROW");
				setXmlElem(writer, "HIWID", this.textBox_transportHighwayID.Text);
				setXmlElem(writer, "HIWNAME", this.textBox_transportHighwayName.Text);
				setXmlElem(writer, "HIWIN", this.textBox_transportHighwayEnterName.Text);
				setXmlElem(writer, "HIWINID", this.textBox_transportHighwayEnterID.Text);
				setXmlElem(writer, "HIWDIS", this.textBox_transportHighwayDistance.Text);
				writer.WriteEndElement();
			}
			//foreach (CAftersalesControl asc in _ascs)
			//{
			//    writer.WriteStartElement("ROW");
			//    setXmlElem(writer, "ORGNAME", asc.textBoxAftersalesName.Text);
			//    setXmlElem(writer, "ORGTYPE", asc.comboBoxAftersalesType.Text);
			//    setXmlElem(writer, "LOCATION", asc.comboBoxAftersalesProvice.Text + "," + asc.comboBoxAftersalesCity.Text);
			//    setXmlElem(writer, "DIRECTOR", asc.textBoxAftersalesContext.Text);
			//    setXmlElem(writer, "PHONE", asc.textBoxAftersalesTel.Text);
			//    writer.WriteEndElement();
			//}
			writer.WriteEndElement();
			writer.Flush();
			writer.Close();

			// 运输信息
			writer = new XmlTextWriter(tmppath + "\\supportor_tran.xml", Encoding.UTF8);
			writer.Formatting = Formatting.Indented;  //缩进格式
			writer.Indentation = 4;
			writer.WriteStartDocument();
			writer.WriteStartElement("DTO");
			writer.WriteStartElement("ROW");
			setXmlElem(writer, "COMNAME", this.textBox_transportName.Text);
			setXmlElem(writer, "TRUCKTYPE", this.comboBox_transportType.Text);
			setXmlElem(writer, "DEADWEIGHT", this.textBox_transportDeadweight.Text);
			setXmlElem(writer, "COUNT", this.textBox_transportNum.Text);
			setXmlElem(writer, "NEARRAILWAY", this.textBox_transportRailwayName.Text);
			setXmlElem(writer, "RWDIS", this.textBox_transportRailwayDistance.Text);
			setXmlElem(writer, "NEARPORT", this.textBox_transportPortName.Text);
			setXmlElem(writer, "PORTDIS", this.textBox_transportPortDistance.Text);
			setXmlElem(writer, "NEARAIRPORT", this.textBox_transportAirportName.Text);
			setXmlElem(writer, "APDIS", this.textBox_transportAirportDistance.Text);
			writer.WriteEndElement();
			writer.WriteEndElement();
			writer.Flush();
			writer.Close();

			// 路径
			string datfile = filepath + "\\" + this.textBox_fullName.Text + "-" + DateTime.Now.ToString("yyyyMMdd") + ".dat";
			// 压缩
			ZipFloClass Zc = new ZipFloClass();
			Zc.ZipFile(tmppath + "\\", datfile);

			DirectoryInfo di = new DirectoryInfo(tmppath);
			di.Delete(true);

			MessageBox.Show("数据导出成功！");
		}

	}
}
