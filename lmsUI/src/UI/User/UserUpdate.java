package UI.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Bll.UserBll;
import pojo.UserInfo;

@SuppressWarnings("serial")
public class UserUpdate extends UserAddUpdateFrame implements ActionListener{

	
	
	public UserUpdate() {
		super();
		frame.setTitle("修改用户信息");
		IDTf.setEditable(false);
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	public UserUpdate(String userID) {
		super();
		frame.setTitle("修改用户信息");
		UserInfo userInfo = new UserBll().SelectUser(userID, "编号").get(0);
		UserID = userInfo.getID();
		setUserData(userInfo);
		IDTf.setEditable(false);
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "确   定") {
			UserInfo user = getUserData();
			user.setID(UserID);
			boolean result = new UserBll().Update(user);
			if (result) {
				JOptionPane.showMessageDialog(null,"操作成功","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}else {
				JOptionPane.showMessageDialog(null,"操作失败","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}
		}
	}

}
