package com.tolo.tabcs.manage.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.tolo.tabcs.common.client.Action;
import com.tolo.tabcs.common.entity.Role;
import com.tolo.tabcs.common.entity.User;
import com.tolo.tabcs.common.gui.SepPanel;
import com.tolo.tabcs.common.pro.Request;
import com.tolo.tabcs.common.pro.Response;


public class UserAndRolesManagementPanel extends JPanel{

	private static final long serialVersionUID = 598712463L;
	private JTextField userId;
	private JTextField userName;
	private JComboBox userRole,userRole1;
	private OuterPanel rolePanel;
	private OuterPanel userPanel;
	private JButton resetPasswd;
	private JFrame frame;
	public Object[][] obj1;
	public Object[][] obj2;
	public List<String> ll;

	
	//预先加载角色信息方法--------------------------
	List<Role> list = new ArrayList<Role>();
	Action action = new Action();
	@SuppressWarnings("unchecked")
	protected void searchRole(){
		Request req = new Request(Request.SEARCH_ROLE_REQUEST);
		Response res = action.doAction(req);
		List<Role> list = (List<Role>) res.getData("all");
		this.list = list;
	}

	
	public UserAndRolesManagementPanel(){
}
	
	
	public UserAndRolesManagementPanel(JFrame frame){
		this.frame=frame;
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		searchRole();
		//角色面板
		JLabel roleNameLabel=new JLabel("角色名称");
		//roleName=new JTextField(8);
		userRole1=new JComboBox();
		userRole1.addItem("-请选择-");
		for(Role l:list){
			userRole1.addItem(l.getName());
		}
		userRole1.addItem("全部角色");
		JComponent[] coms1={roleNameLabel,userRole1};
		String[] colsName1={"角色编号","角色名称","权限编号"};
		obj1=new Object[20][colsName1.length];
		rolePanel=new OuterPanel("角色管理",coms1,obj1,colsName1);
		this.add(rolePanel);
		
		//用户面板
		JLabel userIdLabel=new JLabel("用户ID");
		userId=new JTextField(8);
		JLabel userNameLabel=new JLabel("用户姓名");
		userName=new JTextField(8);
		JLabel userRoleLabel=new JLabel("用户角色");
		userRole=new JComboBox();
		userRole.addItem("-请选择-");
		for(Role l:list){
			userRole.addItem(l.getName());
		}
		JComponent[] coms2={userIdLabel,userId,userNameLabel,userName,userRoleLabel,userRole};
		String[] colsName2={"用户ID","姓名","角色","所属营业网点","联系方式","所属省份","所属城市"};
		obj2=new Object[20][colsName2.length];
		for(int m=0;m<20;m++){
			for(int k=0;k<7;k++){
				obj2[m][k]="";
			}
		}
		userPanel=new OuterPanel("用户管理",coms2,obj2,colsName2);
		//为userPanel添加密码重置按钮
		resetPasswd=new JButton("密码重置");
		userPanel.getInner().getSouthPanel().add(resetPasswd);
		this.add(userPanel);
		addEventListener();
	}
	
	
	//角色查询按钮监听
	private void addEventListener(){
		rolePanel.getInner().getSearch().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String name=((String) userRole1.getSelectedItem()).trim();
					if (name.equals("全部角色")){
						for (int m = 0; m < list.size(); m++){
							obj1[m][0] = list.get(m).getId();
							obj1[m][1] = list.get(m).getName();
							obj1[m][2] = list.get(m).getRole_privilege();
							}
					}else{
						for (int m = 0; m < list.size(); m++) {
						obj1[m][0]="";
						obj1[m][1]="";
						obj1[m][2]="";
						if(name.equals(list.get(m).getName())){
							obj1[0][0]=list.get(m).getId();
							obj1[0][1]=list.get(m).getName();
							obj1[0][2]=list.get(m).getRole_privilege();
							}
						}
					}
				rolePanel.updateUI();
			}
		});
		
		
		//角色高级查询按钮监听
		rolePanel.getInner().getSuperSearch().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				rolePanel.updateUI();
			}
			
		});
		
		//角色增加按钮监听
		rolePanel.getInner().getAdd().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new UserAndRolesManagementadd().showMe();
				System.out.println("9999999999999999999999999");
				rolePanel.updateUI();
			}
			
		});
		
		//角色删除按钮监听
		rolePanel.getInner().getDel().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				userPanel.updateUI();
				new RemoveRoleDialog(null).setVisible(true);
				rolePanel.updateUI();
			}
			
		});
		
		//角色修改按钮监听
		rolePanel.getInner().getUpdate().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				rolePanel.updateUI();
				if (rolePanel.getInner().getTable().getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "请选择一个角色，然后再点击修改按钮");
					return;
				}
				if (rolePanel.getInner().getTable().getSelectedRowCount() == 1) {
				
					System.out.println(rolePanel.getInner().getTable().getSelectedRow());
					System.out.println("============"+obj1[rolePanel.getInner().getTable().getSelectedRow()][1]);
					String s=((String) obj1[rolePanel.getInner().getTable().getSelectedRow()][1]).trim();
					if(s.equals("")){
						JOptionPane.showMessageDialog(null, "请选择一个角色，然后再点击修改按钮");
						return;
					}
					new UserAndRolesManagementdel(s).showMe();
				}
				if (rolePanel.getInner().getTable().getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "不能选中多个角色，请重新选择");
					return;
				}
				rolePanel.updateUI();
			}
			
		});
		
		
		//用户查询按钮监听
		userPanel.getInner().getSearch().addActionListener(new ActionListener(){

			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				String userid = userId.getText().trim();
				String username = userName.getText().trim();
				String userrole=((String) userRole.getSelectedItem()).trim();
				if(userId.getText().trim().equals("")&&userName.getText().trim().equals("")
						&&userRole.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "请填写用户查询条件");
				} else if(
						((!userId.getText().trim().equals(""))&&userName.getText().trim().equals("")&&userRole.getSelectedIndex()==0)){
					for (int i = 0; i < 20; i++) {
						for (int j = 0; j < 7; j++) {
							obj2[i][j] = "";
						}
					}
					int user_id = Integer.parseInt(userid);
					List<User> list1 = new ArrayList<User>();
					Request req = new Request(Request.SEARCH_USER_REQUEST1);
					User user = new User();
					user.setId(user_id);
					req.addData("userByID", user);
					Response res = action.doAction(req);
					list1 = (List<User>) res.getData("userByID");
						for (int i = 0; i < list1.size(); i++) {
							obj2[i][0]=list1.get(i).getId();
							obj2[i][1]=list1.get(i).getName();
							obj2[i][2]=list1.get(i).getRole_name();
							obj2[i][3]=list1.get(i).getBranch_name();
							obj2[i][4]=list1.get(i).getUser_telephone();
							obj2[i][5]=list1.get(i).getPrivince_name();
							obj2[i][6]=list1.get(i).getCity_name();
					}
				}else if( (userId.getText().trim().equals("")&&userName.getText().trim().equals("")&&!(userRole.getSelectedIndex()==0))){
					for (int i = 0; i < 20; i++) {
						for (int j = 0; j < 7; j++) {
							obj2[i][j] = "";
						}
					}
					List<User> list1 = new ArrayList<User>();
					Request req = new Request(Request.SEARCH_USER_REQUEST3);
					User user = new User();
					user.setRole_name(userrole);
					req.addData("userByRoleName", user);
					Response res = action.doAction(req);
					list1 = (List<User>) res.getData("userByRoleName");
						for (int i = 0; i < list1.size(); i++) {
							obj2[i][0]=list1.get(i).getId();
							obj2[i][1]=list1.get(i).getName();
							obj2[i][2]=list1.get(i).getRole_name();
							obj2[i][3]=list1.get(i).getBranch_name();
							obj2[i][4]=list1.get(i).getUser_telephone();
							obj2[i][5]=list1.get(i).getPrivince_name();
							obj2[i][6]=list1.get(i).getCity_name();
					}
				}else if((userId.getText().trim().equals("")&&!userName.getText().trim().equals("")&&userRole.getSelectedIndex()==0)){
					for (int i = 0; i < 20; i++) {
						for (int j = 0; j < 7; j++) {
							obj2[i][j] = "";
						}
					}
					List<User> list1 = new ArrayList<User>();
					Request req = new Request(Request.SEARCH_USER_REQUEST2);
					User user = new User();
					user.setName(username);
					req.addData("userByName", user);
				//	System.out.println("打印 ＝ "  + user.getName());
					Response res = action.doAction(req);
					list1 = (List<User>) res.getData("userByName");
						for (int i = 0; i < list1.size(); i++) {
							obj2[i][0]=list1.get(i).getId();
							obj2[i][1]=list1.get(i).getName();
							obj2[i][2]=list1.get(i).getRole_name();
							obj2[i][3]=list1.get(i).getBranch_name();
							obj2[i][4]=list1.get(i).getUser_telephone();
							obj2[i][5]=list1.get(i).getPrivince_name();
							obj2[i][6]=list1.get(i).getCity_name();
					}
				}	
				else{
					JOptionPane.showMessageDialog(null, "查询条件不符，请重新输入查询条件");
				}
				userPanel.updateUI();
			}
			
		});
		//用户高级查询按钮监听
		userPanel.getInner().getSuperSearch().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		//用户增加按钮监听
		userPanel.getInner().getAdd().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				new AddUserDialog(frame,ll).setVisible(true);
				userPanel.updateUI();
				
			}
			
		});
		//用户删除按钮监听
		userPanel.getInner().getDel().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if (userPanel.getInner().getTable().getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "请选择一个用户，然后再点击删除按钮");
					return;
				}
				if (userPanel.getInner().getTable().getSelectedRowCount() == 1) {
					System.out.println(userPanel.getInner().getTable().getSelectedRow());
					System.out.println("============"+obj2[userPanel.getInner().getTable().getSelectedRow()][0]);
					int id =  (Integer)obj2[userPanel.getInner().getTable().getSelectedRow()][0];
					System.out.println(id);
					if(id==0){
						JOptionPane.showMessageDialog(null, "请选择一个用户，然后再点击删除按钮");
						return;
					}  
					int j=JOptionPane.showConfirmDialog(null, "确定删除"+id+"用户?", "删除", JOptionPane.YES_NO_OPTION);
					if(j==JOptionPane.NO_OPTION){
						return;
					}
				
					Request req = new Request(Request.REMOVE_USER_REQUEST);
					User user = new User();
					user.setId(id);
//					System.out.println("======+++"+user.getId());
				  req.addData("userid",user);
				  	
					Response res = action.doAction(req);
					
					boolean flag=(Boolean) res.getData("删除状态");
					if(flag){
						JOptionPane.showMessageDialog(null, "删除成功");
					} else{
						JOptionPane.showMessageDialog(null, "删除失败");
					}
				}
				
				if (userPanel.getInner().getTable().getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "不能选中多个用户，请重新选择");
					return;
				}
				
				//--------
			}
			
		});
		//用户修改按钮监听
		userPanel.getInner().getUpdate().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if (userPanel.getInner().getTable().getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "请选择一个用户，然后再点击修改按钮");
					return;
				}
				if (userPanel.getInner().getTable().getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "不能选中多个用户，请重新选择");
					return;
				}
				String s=((String) obj2[userPanel.getInner().getTable().getSelectedRow()][0]).trim();
				if (s.equals("")) {
					JOptionPane.showMessageDialog(null, "请选择一个用户，然后再点击修改按钮");
					return;
				}
				new ModifyUserDailog(frame,ll,s).setVisible(true);
			}
			
		});
		
		resetPasswd.addActionListener(new ActionListener(){//密码重置
			@Override
			public void actionPerformed(ActionEvent e) {
				if (userPanel.getInner().getTable().getSelectedRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "请选择一个用户，然后再点击密码重置按钮");
					return;
				}
				if (userPanel.getInner().getTable().getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "不能选中多个用户，请重新选择");
					return;
				}
				
				String s=((String) obj2[userPanel.getInner().getTable().getSelectedRow()][0]).trim();
				System.out.println(s+"密码重置");
				if (s.equals("")) {
					JOptionPane.showMessageDialog(null, "请选择一个用户，然后再点击密码重置按钮");
					return;
				}
				
				int j=JOptionPane.showConfirmDialog(null, "确定重置"+s+"用户的密码？", "重置密码", JOptionPane.YES_NO_OPTION);
				if(j==JOptionPane.NO_OPTION){
					return;
				}
			}
			
		});
		
	}
	
	static class OuterPanel extends JPanel{
		private static final long serialVersionUID = 546219871L;
		private JLabel titleLabel;
		private SepPanel sepPanel;
		private InnerPanel inner;
		
		public InnerPanel getInner() {
			return inner;
		}
		
		public OuterPanel(String title,JComponent[] coms,Object[][] obj,String[] colsName){
			this.inner=new InnerPanel(coms, obj, colsName);
			titleLabel=new JLabel(title);
			sepPanel=new SepPanel();
			init();
		}
		private void init(){
			JPanel pan=new JPanel(new FlowLayout(FlowLayout.LEFT));
			pan.add(titleLabel);
			pan.add(sepPanel);
			this.setLayout(new BorderLayout());
			this.add(pan,BorderLayout.NORTH);
			this.add(inner,BorderLayout.CENTER);
		}
	}
	
	static class InnerPanel extends JPanel{
		private static final long serialVersionUID = 5723698L;
		private JButton search;
		private JButton superSearch;
		private JButton add;
		private JButton del;
		private JButton update;
		private JTable table;
		private JPanel northPanel;
		private JScrollPane centerPanel;
		private JPanel southPanel;
		public JPanel getSouthPanel(){
			return southPanel;
		}
		public JButton getSearch() {
			return search;
		}
		public JButton getSuperSearch() {
			return superSearch;
		}
		public JTable getTable() {
			return table;
		}
		public JButton getAdd() {
			return add;
		}
		public JButton getDel() {
			return del;
		}
		public JButton getUpdate() {
			return update;
		}
		public InnerPanel(JComponent[] coms,Object[][] obj,String[] colsName){
			northPanel=new JPanel();
			search=new JButton("查询");
			superSearch=new JButton("高级查询");
			for(JComponent com:coms){
				northPanel.add(com);
			}
			northPanel.add(search);
			northPanel.add(superSearch);
			
			centerPanel=new JScrollPane();
			table=new JTable(obj,colsName);
			centerPanel.getViewport().add(table);
			
			southPanel=new JPanel();
			add=new JButton("增加");
			del=new JButton("删除");
			update=new JButton("修改");
			southPanel.add(add);
			southPanel.add(del);
			southPanel.add(update);
			init();
		}
		private void init(){
			this.setLayout(new BorderLayout());
			this.add(northPanel,BorderLayout.NORTH);
			this.add(centerPanel,BorderLayout.CENTER);
			this.add(southPanel,BorderLayout.SOUTH);
		}
		
	}

}
