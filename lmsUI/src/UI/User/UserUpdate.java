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
		frame.setTitle("�޸��û���Ϣ");
		IDTf.setEditable(false);
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	public UserUpdate(String userID) {
		super();
		frame.setTitle("�޸��û���Ϣ");
		UserInfo userInfo = new UserBll().SelectUser(userID, "���").get(0);
		UserID = userInfo.getID();
		setUserData(userInfo);
		IDTf.setEditable(false);
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "ȷ   ��") {
			UserInfo user = getUserData();
			user.setID(UserID);
			boolean result = new UserBll().Update(user);
			if (result) {
				JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}else {
				JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}
		}
	}

}
