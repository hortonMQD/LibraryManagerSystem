package UI.Book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Bidi;

import javax.swing.JOptionPane;

import Bll.BookBll;
import pojo.BookInfo;

public class BookUpdate extends BookAddUpdateFrame implements ActionListener{

	
	public BookUpdate() {
		super();
		ISBNTf.setEditable(false);
		frame.setTitle("�޸�ͼ����Ϣ");
		confirm.addActionListener(this);
	}
	
	
	public BookUpdate(String ISBN) {
		super();
		ISBNTf.setEditable(false);
		frame.setTitle("�޸�ͼ����Ϣ");
		confirm.addActionListener(this);
		BookInfo bookInfo = new BookBll().SelectBook(ISBN, "ISBN").get(0);
		bookState = bookInfo.getState();
		bookAddDate = bookInfo.getAddDate();
		principal = bookInfo.getPrincipal();
		initDate(bookInfo);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "ȷ   ��") {
			BookInfo bookInfo = getBookInfo();
			bookInfo.setAddDate(bookAddDate);
			bookInfo.setPrincipal(principal);
			bookInfo.setState(bookState);
			boolean result = new BookBll().Update(bookInfo);
			if (result) {
				JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}else {
				JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}
		}
	}
	
	
	
	

}
