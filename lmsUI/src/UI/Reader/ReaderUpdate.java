package UI.Reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Bll.ReaderBll;
import pojo.ReaderInfo;

public class ReaderUpdate extends ReaderAddUpdateFrame implements ActionListener{

	public ReaderUpdate() {
		super();
		frame.setTitle("�޸Ķ�����Ϣ");
		IDTf.setEditable(false);
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}

	
	public ReaderUpdate(String readerID) {
		super();
		frame.setTitle("�޸Ķ�����Ϣ");
		IDTf.setEditable(false);
		ReaderInfo reader = new ReaderBll().SelectReader(readerID, "�û����").get(0);
		ID = reader.getID();
		createDate = reader.getCreateDate();
		setReaderData(reader);
		confirm.addActionListener(this);
		cancel.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "ȷ   ��") {
			ReaderInfo reader = getReaderData();
			reader.setID(ID);
			reader.setCreateDate(createDate);
			boolean result = new ReaderBll().Update(reader);
			if (result) {
				JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}else {
				JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}
		}
	}

	
	
	
}
