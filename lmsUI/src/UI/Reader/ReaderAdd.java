package UI.Reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Bll.ReaderBll;
import pojo.ReaderInfo;

public class ReaderAdd extends ReaderAddUpdateFrame implements ActionListener{

	
	
	
	public ReaderAdd() {
		super();
		frame.setTitle("��Ӷ�����Ϣ");
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "ȷ   ��") {
			ReaderInfo reader = getReaderData();
			boolean result = new ReaderBll().Insert(reader);
			if (result) {
				JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}else {
				JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
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
