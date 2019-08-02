package UI.User;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import UITool.User_ReaderAbsoluteMassageFrame;
import pojo.UserInfo;

public class UserMassage extends User_ReaderAbsoluteMassageFrame{

	private JPanel userPanel;
	private JLabel identityLb;
	private JLabel leaderLb;
	private JLabel salaryLb;
	
	
	public UserMassage() {
		super();
		initUserPanel();
	}
	
	public UserMassage(UserInfo user) {
		super();
		//frame.setVisible(true);
		frame.setTitle("用户详细信息");
		initUserPanel();
		setUserData(user);
	}
	
	
	private void initUserPanel() {
		identityLb = new JLabel("职        位：普通职员");
		leaderLb = new JLabel("上        级：昂热");
		salaryLb = new JLabel("工        资：5000");
		userPanel = new JPanel(new GridLayout(3, 1));
		userPanel.add(identityLb);
		userPanel.add(leaderLb);
		userPanel.add(salaryLb);
		
		mainpanel.add(userPanel);
	}
	
	
	private void setUserData(UserInfo user) {
		IDLb.setText("编        号："+user.getUserID());
		nameLb.setText("姓        名："+user.getName());
		birthdayLb.setText("出生日期："+user.getBirthday());
		telephoneLb.setText("联系电话："+user.getTelephone());
		addressLb.setText("通讯地址："+user.getAddress());
		identityLb.setText("职        位："+user.getIdentity());
		leaderLb.setText("上        级："+user.getLeader());
		salaryLb.setText("工        资："+user.getSalary());
	}
	
}
