package UI.User;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Bll.UserBll;
import UITool.User_Reader_AbsoluteAddUpdateFrame;
import pojo.UserInfo;

@SuppressWarnings("serial")
public class UserAddUpdateFrame  extends User_Reader_AbsoluteAddUpdateFrame {

	
	protected JPanel UserPanel;
	protected JComboBox<String> identityCb;		//���������
	protected JComboBox<String> leaderCb;			//�ϼ�������
	protected JTextField salaryTf;
	
	protected String UserID;
	
	public UserAddUpdateFrame() {
		super();
		initUserPanel();
		initLeaderCombox();
		mainpanel.add(UserPanel);
	}
	
	public void initUserPanel() {
		JLabel salaryLb = new JLabel("��        �ʣ�");
		JLabel identityLb = new JLabel("ְ        λ��");
		JLabel leaderLb = new JLabel("��        ����");
		
		identityCb = new JComboBox<>();
		leaderCb = new JComboBox<>();
		salaryTf = new JTextField();
		salaryTf.setColumns(20);
		initIdentityCombox();
		UserPanel = new JPanel(new GridLayout(3, 1));
		UserPanel.add(addPanel(salaryTf, salaryLb));
		UserPanel.add(addPanel(identityCb, identityLb));
		UserPanel.add(addPanel(leaderCb, leaderLb));
	}
	
	
	protected void setUserData(UserInfo user) {
		IDTf.setText(user.getUserID());
		nameTf.setText(user.getName());
		telephoneTf.setText(user.getTelephone());
		salaryTf.setText(user.getSalary());
		identityCb.setSelectedItem(user.getIdentity());
		leaderCb.setSelectedItem(user.getLeader());
		birthdayTf.setText(user.getBirthday());
		addressTf.setText(user.getAddress());
	}
	
	
	protected UserInfo getUserData() {
		UserInfo info = new UserInfo();
		info.setUserID(IDTf.getText());
		info.setName(nameTf.getText());
		info.setTelephone(telephoneTf.getText());
		info.setSalary(salaryTf.getText());
		info.setIdentity(identityCb.getSelectedItem().toString());
		info.setLeader(leaderCb.getSelectedItem().toString());
		info.setBirthday(birthdayTf.getText());
		info.setAddress(addressTf.getText());
		return info;
	}
	
	
	/**
	 * ��ʼ������ ����������
	 */
	protected void initLeaderCombox() {
		List<String> list = new UserBll().getNameData();
		String Data[] = list.toArray(new String[list.size()]);	//����������
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// ��������������ģ��
		leaderCb.setModel(surchComboBoxModel);		//������ģ�ͼ��ص���������
	}
	
	
	/**
	 * ��ʼ������ ����������
	 */
	protected void initIdentityCombox() {
		String Data[] = new String[] { "�ݳ�","ְԱ"};	//����������
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// ��������������ģ��
		identityCb.setModel(surchComboBoxModel);		//������ģ�ͼ��ص���������
	}
	
}
