package UI.Reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Bll.ReaderBll;
import pojo.ReaderInfo;

public class ReaderAdd extends ReaderAddUpdateFrame implements ActionListener{

	
	
	
	public ReaderAdd() {
		super();
		frame.setTitle("添加读者信息");
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "确   定") {
			ReaderInfo reader = getReaderData();
			boolean result = new ReaderBll().Insert(reader);
			if (result) {
				JOptionPane.showMessageDialog(null,"操作成功","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}else {
				JOptionPane.showMessageDialog(null,"操作失败","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}
		}
	}
	
	
	private ReaderInfo getData() {
		ReaderInfo info = new ReaderInfo();
		info.setID(IDTf.getText());
		info.setName(nameTf.getText());
		info.setSex(sexCb.getSelectedItem().toString());
		info.setTelephone(telephoneTf.getText());
		info.setBirthday(birthdayTf.getText());
		info.setAddress(addressTf.getText());
		info.setMoney(moneyTf.getText());
		return info;
	}
}
