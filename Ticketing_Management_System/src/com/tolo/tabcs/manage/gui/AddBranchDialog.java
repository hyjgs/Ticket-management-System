package com.tolo.tabcs.manage.gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

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
/**
 * @author TangLiang
 */
@SuppressWarnings("serial")
public class AddBranchDialog extends JDialog {

	//测试-------------------
	private String[] pro_array={"浙江","北京","上海","黑龙江","吉林","辽宁","内蒙古","新疆","西藏","甘肃"};//"山西","河北","天津","山东","江苏","河南","湖北","湖南","广西","云南","广东","福建","江西","台湾","安徽"};
	private String[][] city_array={
			{"杭州","宁波","温州","舟山"},
			{"北京"},
			{"上海"},
			{"哈尔滨","佳木斯","牡丹江"},
			{"吉林","长春"},
			{"沈阳","大连","锦州","丹东"},{"呼和浩特","包头"},{"乌鲁木齐","和田"},{"拉萨",},{"兰州","敦煌"},//,{""},{},{},{},{},{},{},{},
	};
	private String[] arra={"-请选择-"};
	
	private Action action;
	private Frame owner;
	//------------------------------
	/**
	 * Create the dialog
	 */
	@SuppressWarnings("unchecked")
	public AddBranchDialog(Frame owner) {
		super(owner,true);
		action = new Action();
		this.owner = owner;
		
		Request req=new Request(Request.SEARCH_USER_REQUEST);
		req.addData("state","查询经理ID");
		Response res=action.doAction(req);
		List<Integer> lu=(List<Integer>) res.getData("查询经理ID");
		System.out.println("nihao");
		lu = new ArrayList<Integer>();
		lu.add(10001);
		lu.add(10002);
		lu.add(10003);
		lu.add(10004);
		lu.add(10005);
		lu.add(10006);
		lu.add(10007);
		lu.add(10008);
		lu.add(10009);
		lu.add(10010);
		lu.add(10011);
		lu.add(10012);
		lu.add(10013);
		lu.add(10014);
		lu.add(10015);
		this.setTitle("添加营业网点");
		getContentPane().setLayout(null);
		setBounds(100, 100, 500, 246);
		
		

		final JLabel addLabel = new JLabel();
		addLabel.setText("网点信息");
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
		dotIdJtf.setText("自动分配");
		dotIdJtf.setEnabled(false);

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

		final JComboBox managerCombo = new JComboBox(arra);
		for(int i=0;i<lu.size();i++){
			managerCombo.addItem(lu.get(i));
		}
		managerCombo.setBounds(80, 156, 129, 22);
		getContentPane().add(managerCombo);
		
//		final JTextField textField_1 = new JTextField();//?????????????????????????????
//		textField_1.setBounds(80, 156, 129, 22);
//		getContentPane().add(textField_1);
		
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
//				if("".equals(((JTextField)(getContentPane().getComponents()[3])).getText().trim())){
//					JOptionPane.showMessageDialog(null, "网点编号不能为空！");
//					return;
//				}
				
				
				if(dotNameJtf.getText().trim().equals("")||textField.getText().trim().equals("")||
						addressField.getText().trim().equals("")||managerCombo.getSelectedItem().equals("-请选择-")){
								JOptionPane.showMessageDialog(null, "请填写完整营业网点信息");
								return;
				}
				addBranch((String)provinceCombo.getSelectedItem(),(String)cityCombo.getSelectedItem(),dotNameJtf.getText().trim(),
						textField.getText().trim(),(String) (managerCombo.getSelectedItem()+""),addressField.getText().trim());
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
	private void addBranch(String bra_pro,String bra_city,String bra_name,String bra_tel,String bra_manager_id,String bra_addr){
		System.out.println(bra_pro+bra_city+bra_name+bra_tel+bra_manager_id+ bra_addr);
//		Branch br = new Branch();
//		br.setBra_pro(bra_pro);
//		br.setBra_city(bra_city);
//		br.setBra_name(bra_name);
//		br.setBra_tel(bra_tel);
//		br.setBra_manager_id(Integer.parseInt(bra_manager_id));
//		br.setBra_addr(bra_addr);
		Branch br = new Branch();
		br.setProvince_name(bra_pro);
//		System.out.println(br.get);
		br.setCity_name(bra_city);
		br.setBranch_name(bra_name);
		br.setBranch_telephone1(bra_tel);
		br.setUser_id(Integer.parseInt(bra_manager_id));
		br.setBranch_address(bra_addr);
		Request req = new  Request(Request.ADD_BRANCH_REQUEST);
		req.addData("添加网点",br);
//		System.out.println("name is "+ (Branch)req.getData("添加网点"));
		Response res = action.doAction(req);
		boolean flag = (Boolean) res.getData("添加网点状态");
		System.out.println("添加网点状态="+flag);
		if(flag){
			JOptionPane.showMessageDialog(owner,"添加营业网点成功");
			exit();
		}else {
			JOptionPane.showMessageDialog(owner,"添加营业网点失败");
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
