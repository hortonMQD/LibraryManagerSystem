package UI.Reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Bll.ReaderBll;
import pojo.ReaderInfo;

public class ReaderUpdate extends ReaderAddUpdateFrame implements ActionListener{

	public ReaderUpdate() {
		super();
		frame.setTitle("修改读者信息");
		IDTf.setEditable(false);
		confirm.addActionListener(this);
		cancel.addActionListener(this);
	}

	
	public ReaderUpdate(String readerID) {
		super();
		frame.setTitle("修改读者信息");
		IDTf.setEditable(false);
		ReaderInfo reader = new ReaderBll().SelectReader(readerID, "用户编号").get(0);
		ID = reader.getID();
		createDate = reader.getCreateDate();
		setReaderData(reader);
		confirm.addActionListener(this);
		cancel.addActionListener(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "确   定") {
			ReaderInfo reader = getReaderData();
			reader.setID(ID);
			reader.setCreateDate(createDate);
			boolean result = new ReaderBll().Update(reader);
			if (result) {
				JOptionPane.showMessageDialog(null,"操作成功","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}else {
				JOptionPane.showMessageDialog(null,"操作失败","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}
		}
	}

	
	
	
}
