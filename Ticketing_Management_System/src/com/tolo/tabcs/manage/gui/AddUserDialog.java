package com.tolo.tabcs.manage.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Branch;
import com.tolo.tabcs.common.entity.City;
import com.tolo.tabcs.common.entity.Province;
import com.tolo.tabcs.common.entity.Role;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

public class AddUserDialog extends JDialog{
	
	private JComboBox comboBox_4;
	private JComboBox comboBox_3;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private static final long serialVersionUID = -5462649674694014372L;
	private JTextField textField_name;
	//private JTextField textField_saler;
	private JTextField textField_telephone;
//	private JTextArea textArea;
	Action action = new Action();
//	private String[] pro_array={"-请选择-" ,"浙江","北京","上海"};
//	private String[][] city_array={
//			{"-请选择-" ,"杭州","宁波","温州","舟山"},
//			{"-请选择-" ,"北京"},
//			{"-请选择-" ,"上海"},
//	};
	
List<Province> list1 = new ArrayList<Province>();
List<City> list2 = new ArrayList<City>();
List<Branch> list3 = new ArrayList<Branch>();
List<Role> list = new ArrayList<Role>();
//加载角色信息--------------------------
@SuppressWarnings("unchecked")
protected void searchRole(){
	Request req = new Request(Request.SEARCH_ROLE_REQUEST);
	Response res = action.doAction(req);
	List<Role> list = (List<Role>) res.getData("all");
	this.list = list;
}
//加载省份信息
	private void searchProvince(){
		Request req = new Request(Request.SEARCH_PROVINCE_NAME_REQUEST);
		Response res = action.doAction(req);
		List<Province> list1 = (List<Province>) res.getData("province");
		this.list1 = list1;
	}
//加载城市信息	
	private void searchCity(){
		Request req = new Request(Request.SEARCH_CITY_NAME_REQUEST);
		Response res = action.doAction(req);
		List<City> list2 = (List<City>) res.getData("city");
		this.list2 = list2;
	}
//加载营业网点信息
	private void searchBranch(){
		Request req = new Request(Request.SEARCH_BRANCH_REQUEST);
		Response res = action.doAction(req);
		List<Branch> list3 = (List<Branch>) res.getData("branch");
		this.list3 = list3;
	}
	
	
	
	public AddUserDialog(JFrame frame,List<String> l) {
		super(frame,true);
		action=new Action();
		
			searchRole();
//		searchBranch();
//		searchCity();
//		searchProvince();
		
		getContentPane().setLayout(null);
		this.setTitle("增加用户");
		setBounds(100, 100, 500, 375);

		final JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 492, 341);
		getContentPane().add(panel);
		
		Font font=new Font("", Font.BOLD, 16);
//		
		final JSeparator separator_1 = new JSeparator();//水平分隔符
		separator_1.setBounds(0, 45, 492, 12);
		getContentPane().add(separator_1);
		
		final JLabel label = new JLabel("姓名");
		label.setFont(font);
		label.setBounds(32, 38, 63, 24);
		panel.add(label);

		textField_name = new JTextField();
		textField_name.setBounds(101, 39, 90, 22);
		panel.add(textField_name);

		final JLabel label_1 = new JLabel("角色");
		label_1.setFont(font);
		label_1.setBounds(240, 90, 63, 24);
		panel.add(label_1);

		
		final JLabel label_2 = new JLabel("联系电话");
		label_2.setFont(font);
		label_2.setBounds(240, 38, 69, 24);
		//label_2.setBounds(240, 90, 90, 24);
		panel.add(label_2);
		
		textField_telephone = new JTextField();
		textField_telephone.setBounds(330, 39, 110, 22);
		panel.add(textField_telephone);	
		
		final JLabel label_3 = new JLabel("营业网点");
		label_3.setFont(font);
		label_3.setBounds(240, 156, 90, 24);
		panel.add(label_3);
		
		final JLabel label_4 = new JLabel("所属城市");
		label_4.setFont(font);
		label_4.setBounds(32, 156, 75, 24);
		panel.add(label_4);

		final JLabel label_5 =new JLabel("所属省份");
		label_5.setFont(font);
		label_5.setBounds(32, 90, 75, 24);
		panel.add(label_5);

		final JButton button_yes = new JButton();
		button_yes.setText("确定");
		button_yes.setBounds(122, 289, 106, 28);
		panel.add(button_yes);
		
		
		final JButton button_no = new JButton();
		button_no.setText("取消");
		button_no.setBounds(267, 289, 106, 28);
		panel.add(button_no);
		button_no.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				exit();
			}
		});
//		
//		final JComboBox comboBox = new JComboBox(pro_array);
//		comboBox.setBounds(101, 91, 90, 27);
//		panel.add(comboBox);

		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"-请选择-"}));
		comboBox_2.setBounds(101, 157, 90, 27);
		panel.add(comboBox_2);
		
		comboBox_3 = new JComboBox();//营业网点
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"-请选择-" }));
		for (Branch branch : list3) {
			comboBox_3.addItem(branch.getBranch_name());
		}
		comboBox_3.setBounds(330, 157, 90, 27);
		panel.add(comboBox_3);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(101, 91, 90, 27);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"-请选择-"}));
		panel.add(comboBox_4);		
		
		comboBox_1 = new JComboBox();//角色
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-请选择-" }));
		for (Role role : list) {
			comboBox_1.addItem(role.getName());
		}
		comboBox_1.setBounds(330, 91, 90, 27);
		panel.add(comboBox_1);

//---------------------------------------------------------监听		
		
		comboBox_4.addItemListener(new ItemListener(){//省份监听
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_4.getSelectedItem()==null){
					System.out.println(comboBox_4.getSelectedItem());
					return;
				}
				if(comboBox_4.getSelectedItem().equals("-请选择-")){
					for(Province l:list1){
						comboBox_4.addItem(l.getName());
					}
					return;
				}
			}
		});
		
		
		comboBox_1.addItemListener(new ItemListener(){//网点监听
	
							@SuppressWarnings("unchecked")
							@Override
							public void itemStateChanged(ItemEvent e) {
								if(comboBox_1.getSelectedItem()==null){
									System.out.println(comboBox_3.getSelectedItem());
									return;
								}
								if(comboBox_1.getSelectedItem().equals("-请选择-")){
									for(Branch l:list3){
										comboBox_1.addItem(l.getBranch_name());
									}
									return;
								}
							}
					});
		
		comboBox_3.addItemListener(new ItemListener(){//角色监听
			
			@SuppressWarnings("unchecked")
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_3.getSelectedItem()==null){
					System.out.println(comboBox_3.getSelectedItem());
					return;
				}
				if(comboBox_3.getSelectedItem().equals("-请选择-")){
					
					return;
				}
			}
	});
		
		comboBox_3.addItemListener(new ItemListener(){//城市监听

			@SuppressWarnings("unchecked")
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(comboBox_3.getSelectedItem()==null){
					System.out.println(comboBox_3.getSelectedItem());
					return;
				}
				if(comboBox_3.getSelectedItem().equals("-请选择-")){
					System.out.println(comboBox_3.getSelectedItem());
					return;
				}

				Request req=new Request(Request.SEARCH_BRANCH_REQUEST);
				req.addData("state","查询");
				req.addData("网点编号", "-1");
//				req.addData("省份",( (String)comboBox.getSelectedItem()).trim());
				req.addData("城市", ( (String)comboBox_3.getSelectedItem()).trim());
				req.addData("网点名称", "-请选择-" );
				Response res=action.doAction(req);
				comboBox_2.removeAllItems();
				comboBox_2.addItem("-请选择-");

			}	
		});
		
		
		
		
		button_yes.addActionListener(new ActionListener() {//确定按钮监听
			public void actionPerformed(final ActionEvent e) {
				if(textField_name.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入用户名！！！");
					return;
				}
				if(comboBox_4.getSelectedItem().equals("-请选择-")){
					JOptionPane.showMessageDialog(null, "请选择省份！！！");
					return;
				}
				if(comboBox_2.getSelectedItem().equals("-请选择-")){
					JOptionPane.showMessageDialog(null, "请选择城市！！！");
					return;
				}
				if(comboBox_1.getSelectedItem().equals("-请选择-")){
					JOptionPane.showMessageDialog(null, "请选择营业网点！！！");
					return;
				}		
				if(comboBox_4.getSelectedItem().equals("-请选择-")){
					JOptionPane.showMessageDialog(null, "请选择角色！！！");
					return;
				}

				
				Request req = new Request(Request.ADD_USER_REQUEST);
			//	req.addData("增加用户", user);
				Response res = action.doAction(req);
				boolean flag = (Boolean) res.getData("增加用户状态");
				if(flag){
					JOptionPane.showMessageDialog(null, "增加用户成功");
					exit();
				}else{
					JOptionPane.showMessageDialog(null, "增加用户失败");
				}
		
			}
		});
	}
	public void exit(){
		this.dispose();
	}

}
