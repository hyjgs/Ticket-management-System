package com.tolo.tabcs.manage.gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Branch;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;
import com.tolo.tabcs.util.CollectionUtils;

@SuppressWarnings("serial")
public class EditBranchDialog extends JDialog {

	//测试-------------------
	private String[] pro_array={"浙江","北京","上海"," 江苏 ", " 四川 "};
	private String[][] city_array={
			{"杭州","宁波","温州","舟山","绍兴 "," 金华 "," 嘉兴"},
			{"北京"},
			{"上海"},
			{"南京","苏州","无锡","常州","郑州","海宁",},
			{"成都","绵阳","内江","自贡","泸州","广元",},
	};
	private Action action;
	//------------------------------
	/**
	 * Create the dialog
	 */
	public EditBranchDialog(Frame owner) {
		super(owner,true);
		action=new Action();
		this.setTitle("修改营业网点页面");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 246);
		
		

		final JLabel addLabel = new JLabel();
		addLabel.setText("修改营业网点信息");
		addLabel.setBounds(10, 0, 66, 18);
		getContentPane().add(addLabel);

		final JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 45, 492, 12);
		getContentPane().add(separator_1);
		
		final JLabel dotIdLabel = new JLabel();
		dotIdLabel.setText("网点编号");
		dotIdLabel.setBounds(10, 22, 66, 18);
		getContentPane().add(dotIdLabel);

		final JTextField dotIdJtf = new JTextField();
		dotIdJtf.setBounds(80, 20, 129, 22);
		getContentPane().add(dotIdJtf);

		final JSeparator separator = new JSeparator();
		separator.setBounds(0, 15, 492, 12);
		getContentPane().add(separator);


		final JLabel provinceLabel = new JLabel();
		provinceLabel.setText("省份");
		provinceLabel.setBounds(10, 55, 45, 18);
		getContentPane().add(provinceLabel);

		final JComboBox provinceCombo = new JComboBox(pro_array);
		provinceCombo.setBounds(80, 53, 129, 22);
		provinceCombo.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				doItemStateChanged(provinceCombo,(JComboBox)getContentPane().getComponents()[8]);
			}
			
		});
		getContentPane().add(provinceCombo);

		final JLabel cityLabel = new JLabel();
		cityLabel.setText("城市");
		cityLabel.setBounds(253, 55, 45, 18);
		getContentPane().add(cityLabel);

		final JComboBox cityCombo = new JComboBox(city_array[0]);
		cityCombo.setBounds(304, 53, 148, 22);
		getContentPane().add(cityCombo);

		final JLabel dotNameLabel = new JLabel();
		dotNameLabel.setText("网点名字");
		dotNameLabel.setBounds(10, 88, 66, 18);
		getContentPane().add(dotNameLabel);

		final JTextField dotNameJtf = new JTextField();
		dotNameJtf.setBounds(80, 86, 129, 22);
		getContentPane().add(dotNameJtf);

		final JLabel phoneJlabel = new JLabel();
		phoneJlabel.setText("网点电话");
		phoneJlabel.setBounds(10, 124, 66, 18);
		getContentPane().add(phoneJlabel);

		final JTextField textField = new JTextField();
		textField.setBounds(80, 122, 129, 22);
		getContentPane().add(textField);

		final JLabel managerNoJlabel = new JLabel();
		managerNoJlabel.setText("网点经理");
		managerNoJlabel.setBounds(10, 158, 66, 18);
		getContentPane().add(managerNoJlabel);

		final JTextField textField_1 = new JTextField();
		textField_1.setBounds(80, 156, 129, 22);
		getContentPane().add(textField_1);
		
		final JLabel addressJlabel = new JLabel();
		addressJlabel.setText("网点地址");
		addressJlabel.setBounds(253, 158, 66, 18);
		getContentPane().add(addressJlabel);

		final JTextField addressField = new JTextField();
		addressField.setBounds(304, 156, 139, 22);
		getContentPane().add(addressField);
		
		final JButton on_button = new JButton("确定");
		on_button.setBounds(80, 193, 129, 22);
		on_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if("".equals(((JTextField)(getContentPane().getComponents()[3])).getText().trim())){
					JOptionPane.showMessageDialog(null, "网点编号不能为空！");
					return;
				} 
				if(dotNameJtf.getText().trim().equals("")||textField.getText().trim().equals("")||
						textField_1.getText().trim().equals("")||addressField.getText().trim().equals("")){
								JOptionPane.showMessageDialog(null, "请填写完整营业网点信息");
								return;
				}
				int bra_id=Integer.parseInt(dotIdJtf.getText().trim());
				editBranch(bra_id,(String)provinceCombo.getSelectedItem(),(String)cityCombo.getSelectedItem(),dotNameJtf.getText().trim(),
						textField.getText().trim(),textField_1.getText().trim(),addressField.getText().trim());
			}
		});
		getContentPane().add(on_button);
		
		final JButton off_button = new JButton("取消");
		off_button.setBounds(304, 193, 148, 22);
		off_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				exit();
			}
		});
		getContentPane().add(off_button);
	}
	
	/**
	 * 添加营业网点的方法
	 */
	private void editBranch(int bra_id,String bra_pro,String bra_city,String bra_name,String bra_tel,String bra_manager_id,String bra_addr){
//		Branch br = new Branch();
//		br.setBra_id(bra_id);
//		br.setBra_pro(bra_pro);
//		br.setBra_city(bra_city);
//		br.setBra_name(bra_name);
//		br.setBra_tel(bra_tel);
//		br.setBra_manager_id(Integer.parseInt(bra_manager_id));
//		br.setBra_addr(bra_addr);
		Branch br = new Branch();
		br.setBranch_id(bra_id);
		br.setProvince_name(bra_pro);
		br.setCity_name(bra_city);
		br.setBranch_name(bra_name);
		br.setBranch_telephone1(bra_tel);
		br.setUser_id(Integer.parseInt(bra_manager_id));
		br.setBranch_address(bra_addr);
		Request req = new  Request(Request.UPDATE_BRANCH_REQUEST);
		req.addData("修改网点",br);
		Response res = action.doAction(req);
		boolean flag = (Boolean) res.getData("修改网点状态");
		System.out.println("修改网点状态="+flag);
		if(flag){
			JOptionPane.showMessageDialog(null,"修改营业网点成功");
			exit();
		}else {
			JOptionPane.showMessageDialog(null,"修改营业网点失败");
		}
	}
	
	private void exit(){
		this.dispose();
	}
	
	private void doItemStateChanged(JComboBox provinceCombo,JComboBox cityCombo){
		int index=provinceCombo.getSelectedIndex();
		cityCombo.removeAllItems();
		for(int i=0;i<city_array[index].length;i++){
			cityCombo.addItem(city_array[index][i]);
		}
	}

}
