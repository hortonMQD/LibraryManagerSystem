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
	protected JComboBox<String> identityCb;		//身份下拉框
	protected JComboBox<String> leaderCb;			//上级下拉框
	protected JTextField salaryTf;
	
	protected String UserID;
	
	public UserAddUpdateFrame() {
		super();
		initUserPanel();
		initLeaderCombox();
		mainpanel.add(UserPanel);
	}
	
	public void initUserPanel() {
		JLabel salaryLb = new JLabel("工        资：");
		JLabel identityLb = new JLabel("职        位：");
		JLabel leaderLb = new JLabel("上        级：");
		
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
	 * 初始化搜索 下拉框数据
	 */
	protected void initLeaderCombox() {
		List<String> list = new UserBll().getNameData();
		String Data[] = list.toArray(new String[list.size()]);	//下拉框数据
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// 创建下拉框数据模型
		leaderCb.setModel(surchComboBoxModel);		//将数据模型加载到下拉框中
	}
	
	
	/**
	 * 初始化搜索 下拉框数据
	 */
	protected void initIdentityCombox() {
		String Data[] = new String[] { "馆长","职员"};	//下拉框数据
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// 创建下拉框数据模型
		identityCb.setModel(surchComboBoxModel);		//将数据模型加载到下拉框中
	}
	
}
