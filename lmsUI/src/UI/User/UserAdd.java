package UI.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Bll.UserBll;
import pojo.UserInfo;



@SuppressWarnings("serial")
public class UserAdd extends UserAddUpdateFrame implements ActionListener{
	
	
	
	
	public UserAdd() {
		super();
		frame.setTitle("添加用户信息");
		
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "确   定") {
			boolean result = new UserBll().Insert(getUserData());
			if (result) {
				JOptionPane.showMessageDialog(null,"操作成功","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}else {
				JOptionPane.showMessageDialog(null,"操作失败","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}
		}
	}

	
	
}
