package UI.Book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Bll.BookBll;
import pojo.BookInfo;

public class BookAdd extends BookAddUpdateFrame implements ActionListener{

	
	public BookAdd() {
		super();
		frame.setTitle("���ͼ����Ϣ");
		confirm.addActionListener(this);
	}
	
	
	
	public BookAdd(String userID) {
		super();
		frame.setTitle("���ͼ����Ϣ");
		confirm.addActionListener(this);
		this.principal = userID;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "ȷ   ��") {
			BookInfo book = getBookInfo();
			book.setState("�ڹ�");
			boolean result = new BookBll().Insert(book);
			if (result) {
				JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}else {
				JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}
		}
	}
	
	

}
