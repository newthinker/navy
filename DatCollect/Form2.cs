using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace DatCollect
{
	public partial class Form2 : Form
	{
		public Form2()
		{
			InitializeComponent();
		}

		private void Form2_FormClosing(object sender, FormClosingEventArgs e)
		{
			this.Hide();
			e.Cancel = true;
		}

		private void button_close_Click(object sender, EventArgs e)
		{
			this.Hide();
		}

		Form1 _form1;
		Button _trigger;

		public void init(Form1 form)
		{
			_form1 = form;
			Dictionary<string, Form1.SDict> tdi = null;
			// 产品分类
			if (_form1._dict.TryGetValue(15, out tdi))
			{
				// 1级
				foreach (KeyValuePair<string, Form1.SDict> item1 in tdi)
				{
					if (item1.Value.rcode == "0")
					{
						TreeNode nd1 = treeView1.Nodes.Add(item1.Value.name);
						nd1.Tag = item1.Key;

						// 2级
						foreach (KeyValuePair<string, Form1.SDict> item2 in tdi)
						{
							if (item2.Value.rcode == item1.Value.code)
							{
								TreeNode nd2 = nd1.Nodes.Add(item2.Value.name);
								nd2.Tag = item2.Key;

								// 3级
								foreach (KeyValuePair<string, Form1.SDict> item3 in tdi)
								{
									if (item3.Value.rcode == item2.Value.code)
									{
										TreeNode nd3 = nd2.Nodes.Add(item3.Value.name);
										nd3.Tag = item3.Key;
									}
									else
									{
									}
								}
							}
							else
							{
							}
						}
					}
					else
					{
					}
				}
			}
			tdi = null;
		}

		public Button Trigger
		{
			get { return _trigger; }
			set { _trigger = value; }
		}

		private Point pi;

		private void treeView1_MouseDown(object sender, MouseEventArgs e)
		{
			pi = new Point(e.X, e.Y);
		}

		private void treeView1_DoubleClick(object sender, EventArgs e)
		{
			TreeNode node = this.treeView1.GetNodeAt(pi);
			if (pi.X < node.Bounds.Left || pi.X > node.Bounds.Right)
			{
				//不触发事件
				return;
			}
			//else
			//{
			//    MessageBox.Show(node.Text);
			//}

			if (node == null)
				return;
			if (node.Nodes.Count > 0)
				return;

			if (node.Parent == null) //1
			{
				_form1.selectProductType("其它", "0");
				this.Hide();
				return;
			}

			node = node.Parent;
			if (node.Parent == null) //2
			{
				_form1.selectProductType("其它", "0");
				this.Hide();
				return;
			}

			node = node.Parent;
			if (node.Parent == null) //3
			{
				_form1.selectProductType(this.treeView1.SelectedNode.Text, (string)this.treeView1.SelectedNode.Tag);
				this.Hide();
				return;
			}
		}

		private void button_ok_Click(object sender, EventArgs e)
		{
			TreeNode node = this.treeView1.SelectedNode;
			if (node == null)
				return;
			if (node.Nodes.Count > 0)
				return;

			if (node.Parent == null) //1
			{
				_form1.selectProductType("未分类", "0");
				this.Hide();
				return;
			}

			node = node.Parent;
			if (node.Parent == null) //2
			{
				_form1.selectProductType("未分类", "0");
				this.Hide();
				return;
			}

			node = node.Parent;
			if (node.Parent == null) //3
			{
				_form1.selectProductType(this.treeView1.SelectedNode.Text, (string)this.treeView1.SelectedNode.Tag);
				this.Hide();
				return;
			}
		}

		private void button1_Click(object sender, EventArgs e)
		{
			string keywords = textBox1.Text;
			if (keywords == "")
			{
				return;
			}

			listView1.Items.Clear();

			foreach (TreeNode nd1 in treeView1.Nodes)
			{
				if (nd1.Text.IndexOf(keywords) != -1)
				{
					ListViewItem lvi = listView1.Items.Add(nd1.Text);
					//lvi.SubItems.Add("1");
					lvi.Tag = nd1;
				}

				foreach (TreeNode nd2 in nd1.Nodes)
				{
					if (nd2.Text.IndexOf(keywords) != -1)
					{
						ListViewItem lvi = listView1.Items.Add(nd1.Text + " - " + nd2.Text);
						//lvi.SubItems.Add("2");
						lvi.Tag = nd2;
					}

					foreach (TreeNode nd3 in nd2.Nodes)
					{
						if (nd3.Text.IndexOf(keywords) != -1)
						{
							ListViewItem lvi = listView1.Items.Add(nd1.Text + " - " + nd2.Text + " - " + nd3.Text);
							//lvi.SubItems.Add("3");
							lvi.Tag = nd3;
						}
					}
				}
			}
		}

		private void listView1_SelectedIndexChanged(object sender, EventArgs e)
		{
			if (listView1.SelectedItems.Count > 0)
			{
				ListViewItem lvi = listView1.SelectedItems[0];
				treeView1.SelectedNode = (TreeNode)lvi.Tag;
			}
		}
	}
}
