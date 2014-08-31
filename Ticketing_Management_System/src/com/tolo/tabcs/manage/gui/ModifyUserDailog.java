package com.tolo.tabcs.manage.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Role;
import com.tolo.tabcs.common.entity.User;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;

public class ModifyUserDailog extends JDialog{
	
	private JComboBox comboBox_4;
	private JComboBox comboBox_3;
	private JComboBox comboBox_2;
	//private JComboBox comboBox;
	private static final long serialVersionUID = -5462649674694014372L;
	private JTextField textField_name;
	private JTextField textField_saler;
	private JTextArea textArea;
	private Action action;
	private String[] pro_array={"-请选择-" ,"浙江","北京","上海"};
	private String[][] city_array={
			{"-请选择-" ,"杭州","宁波","温州","舟山"},
			{"-请选择-" ,"北京"},
			{"-请选择-" ,"上海"},
	};
	public String user_id;
	
	public ModifyUserDailog(JFrame frame,List<String> l,final String user_id) {
//		super(frame,true);
//		action=new Action();
//		this.user_id=user_id;
//		
//		getContentPane().setLayout(null);
//		setTitle("修改"+user_id+"号用户");
//		setBounds(100, 100, 500, 375);
//
//		final JPanel panel = new JPanel();
//		panel.setLayout(null);
//		panel.setBounds(0, 0, 492, 341);
//		getContentPane().add(panel);
//		
//		Font font=new Font("", Font.BOLD, 16);
//		
//		final JComponent separator = DefaultComponentFactory.getInstance().createSeparator("");
//		separator.setFont(font);
//		separator.setBounds(0, 0, 492, 341);
//		panel.add(separator);
//
//		final JLabel label = DefaultComponentFactory.getInstance().createLabel("姓名");
//		label.setFont(font);
//		label.setBounds(32, 38, 63, 24);
//		panel.add(label);
//
//		textField_name = new JTextField();
//		textField_name.setBounds(101, 39, 90, 22);
//		panel.add(textField_name);
//
//		final JLabel label_1 = DefaultComponentFactory.getInstance().createLabel("角色");
//		label_1.setFont(font);
//		label_1.setBounds(240, 38, 69, 24);
//		panel.add(label_1);
//
//		final JLabel label_2 = DefaultComponentFactory.getInstance().createLabel("所属营业网点");
//		label_2.setFont(font);
//		label_2.setBounds(32, 156, 75, 24);
//		panel.add(label_2);
//
//		final JLabel label_3 = DefaultComponentFactory.getInstance().createLabel("所属城市");
//		label_3.setFont(font);
//		label_3.setBounds(240, 90, 90, 24);
//		panel.add(label_3);
//
//		final JLabel label_5 = DefaultComponentFactory.getInstance().createLabel("所属省份");
//		label_5.setFont(font);
//		label_5.setBounds(32, 90, 63, 24);
//		panel.add(label_5);
//
//		final JLabel label_6 = DefaultComponentFactory.getInstance().createLabel("附加权限编号");
//		label_6.setFont(font);
//		label_6.setBounds(240, 156, 69, 24);
//		panel.add(label_6);
//
//		final JLabel label_4 = new JLabel();
//		label_4.setFont(font);
//		label_4.setForeground(Color.BLACK);
//		label_4.setText("");
//		label_4.setBounds(194, 195, 85, 18);
//		panel.add(label_4);
//
//		textArea = new JTextArea();
//		textArea.setBounds(37, 219, 425, 52);
//		panel.add(textArea);
//
//		textField_saler = new JTextField();
//		textField_saler.setBounds(315, 159, 90, 22);
//		panel.add(textField_saler);
//
//		final JButton button_yes = new JButton();
//		button_yes.setText("确定");
//		button_yes.setBounds(122, 289, 106, 28);
//		panel.add(button_yes);
//		
//	
//		final JButton button_no = new JButton();
//		button_no.addActionListener(new ActionListener() {
//			public void actionPerformed(final ActionEvent e) {
//				exit();
//			}
//		});
//		button_no.setText("取消");
//		button_no.setBounds(267, 289, 106, 28);
//		panel.add(button_no);
//
//		
//		final JComboBox comboBox = new JComboBox(pro_array);
//		comboBox.setBounds(101, 91, 90, 27);//????????????????????????????????????????????
//		panel.add(comboBox);
//
//		comboBox_2 = new JComboBox();
//		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"-请选择-"}));
//		comboBox_2.setBounds(101, 157, 90, 27);
//		panel.add(comboBox_2);
//		
//		comboBox_3 = new JComboBox();
//		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"-请选择-" }));
//		comboBox_3.setBounds(315, 91, 90, 27);
//		panel.add(comboBox_3);
//		
//		comboBox_4 = new JComboBox();
//		comboBox_4.setBounds(315, 39, 90, 27);
//		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"-请选择-"}));
//		for(int i=0;i<l.size();i++){
//			comboBox_4.addItem(l.get(i));
//		}
//		panel.add(comboBox_4);
//		
//		comboBox.addItemListener(new ItemListener(){//省份监听
//			public void itemStateChanged(ItemEvent e) {
//				int i=comboBox.getSelectedIndex();
//				System.out.println("11111111");
//				if(!(i==0)){
//					System.out.println("22222");
//					comboBox_3.removeAllItems();
//					for(int j=0;j<city_array[i-1].length;j++){
//						comboBox_3.addItem(city_array[i-1][j]);
//					}
//				}	else {
//					comboBox_3.removeAllItems();
//					comboBox_3.addItem("-请选择-");
//				}
//			}
//		});
//		
//		comboBox_3.addItemListener(new ItemListener(){//城市监听
//
//			@SuppressWarnings("unchecked")
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				if(comboBox_3.getSelectedItem()==null){
//					System.out.println(comboBox_3.getSelectedItem());
//					return;
//				}
//				if(comboBox_3.getSelectedItem().equals("-请选择-")){
//					System.out.println(comboBox_3.getSelectedItem());
//					return;
//				}
//				Request req=new Request(Request.SEARCH_BRANCH_REQUEST);
//				req.addData("state","查询");
//				req.addData("网点编号", "-1");
//				req.addData("省份",( (String)comboBox.getSelectedItem()).trim());
//				req.addData("城市", ( (String)comboBox_3.getSelectedItem()).trim());
//				req.addData("网点名称", "-请选择-" );
//				Response res=action.doAction(req);
//				List<Branch> lb=(List<Branch>) res.getData("查询");
//				for(int k=0;k<lb.size();k++){
//					System.out.println(lb.get(k).getBra_id());
//				}
//				comboBox_2.removeAllItems();
//				comboBox_2.addItem("-请选择-");
//				for(int k=0;k<lb.size();k++){
//					comboBox_2.addItem(lb.get(k).getBra_id()+"");
//				}
//			}	
//		});
////		
//		
//		button_yes.addActionListener(new ActionListener() {//确定按钮监听
//			public void actionPerformed(final ActionEvent e) {
//				if(textField_name.getText().trim().equals("")){
//					JOptionPane.showMessageDialog(null, "请输入用户名！！！");
//					return;
//				}
//				if(comboBox.getSelectedItem().equals("-请选择-")){
//					JOptionPane.showMessageDialog(null, "请选择省份！！！");
//					return;
//				}
//				if(comboBox_3.getSelectedItem().equals("-请选择-")){
//					JOptionPane.showMessageDialog(null, "请选择城市！！！");
//					return;
//				}
//				if(comboBox_2.getSelectedItem().equals("-请选择-")){
//					JOptionPane.showMessageDialog(null, "请选择营业网点！！！");
//					return;
//				}		
//				if(comboBox_4.getSelectedItem().equals("-请选择-")){
//					JOptionPane.showMessageDialog(null, "请选择角色！！！");
//					return;
//				}
//				User user = new User();
//				user.setName(textField_name.getText().trim());//姓名
//				user.setId(Integer.parseInt(user_id));
//				user.setUser_province(comboBox.getSelectedItem()+"");//省份
//				user.setUser_city(comboBox_3.getSelectedItem()+"");//城市
//				user.setBranch_id(Integer.parseInt((String) comboBox_2.getSelectedItem()));//网点ID
//				Role ro = new Role();
//				ro.setRol_name(comboBox_4.getSelectedItem()+"");
//				user.setUser_role(ro);//角色
//				if(textField_saler.getText().trim().equals("")){//附加权限
//					user.setUser_addaut(0);
//				}else {
//					user.setUser_addaut(Integer.parseInt(textField_saler.getText().trim()));
//				}
//				
//				Request req = new Request(Request.UPDATE_USER_REQUEST);
//				req.addData("修改用户", user);
//				Response res = action.doAction(req);
//				boolean flag = (Boolean) res.getData("修改用户状态");
//				if(flag){
//					JOptionPane.showMessageDialog(null, "修改用户成功");
//					exit();
//				}else{
//					JOptionPane.showMessageDialog(null, "修改用户失败");
//				}
//		
//			}
//		});
	}
	public void exit(){
		this.dispose();
	}
}
