package com.tolo.tabcs.manage.gui;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;


@SuppressWarnings("serial")
public class RemoveBranchDialog extends JDialog{
	
	private Action action;

	public RemoveBranchDialog(Frame owner) {
		super(owner,true);
		action = new Action();
		

		this.setTitle("删除营业网点");
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
		dotIdLabel.setText("请输入要删除的网点编号：");
		dotIdLabel.setBounds(10, 22, 200, 18);
		getContentPane().add(dotIdLabel);

		final JTextField dotIdJtf = new JTextField();
		dotIdJtf.setBounds(190, 100, 129, 30);
		getContentPane().add(dotIdJtf);
		dotIdJtf.setText("");

		final JButton on_button = new JButton("确定");
		on_button.setBounds(80, 193, 129, 22);
		on_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(dotIdJtf.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null, "请输入要删除的网点编号！");
					return;
				}
				Request req = new  Request(Request.REMOVE_BRANCH_REQUEST);
				req.addData("删除网点",dotIdJtf.getText().trim());
				Response res = action.doAction(req);
				boolean flag = (Boolean) res.getData("删除网点状态");
				if(flag){
					JOptionPane.showMessageDialog(null,"删除营业网点成功");
					exit();
				}else{
					JOptionPane.showMessageDialog(null,"删除营业网点失败");
				}
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
	
	
	private void exit(){
		this.dispose();
	}
	
	
}
