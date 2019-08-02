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
		frame.setTitle("����û���Ϣ");
		
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "ȷ   ��") {
			boolean result = new UserBll().Insert(getUserData());
			if (result) {
				JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}else {
				JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}
		}
	}

	
	
}
