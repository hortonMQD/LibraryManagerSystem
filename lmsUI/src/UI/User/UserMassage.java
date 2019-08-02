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
		frame.setTitle("�û���ϸ��Ϣ");
		initUserPanel();
		setUserData(user);
	}
	
	
	private void initUserPanel() {
		identityLb = new JLabel("ְ        λ����ְͨԱ");
		leaderLb = new JLabel("��        ��������");
		salaryLb = new JLabel("��        �ʣ�5000");
		userPanel = new JPanel(new GridLayout(3, 1));
		userPanel.add(identityLb);
		userPanel.add(leaderLb);
		userPanel.add(salaryLb);
		
		mainpanel.add(userPanel);
	}
	
	
	private void setUserData(UserInfo user) {
		IDLb.setText("��        �ţ�"+user.getUserID());
		nameLb.setText("��        ����"+user.getName());
		birthdayLb.setText("�������ڣ�"+user.getBirthday());
		telephoneLb.setText("��ϵ�绰��"+user.getTelephone());
		addressLb.setText("ͨѶ��ַ��"+user.getAddress());
		identityLb.setText("ְ        λ��"+user.getIdentity());
		leaderLb.setText("��        ����"+user.getLeader());
		salaryLb.setText("��        �ʣ�"+user.getSalary());
	}
	
}
