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
		frame.setTitle("修改图书信息");
		confirm.addActionListener(this);
	}
	
	
	public BookUpdate(String ISBN) {
		super();
		ISBNTf.setEditable(false);
		frame.setTitle("修改图书信息");
		confirm.addActionListener(this);
		BookInfo bookInfo = new BookBll().SelectBook(ISBN, "ISBN").get(0);
		bookState = bookInfo.getState();
		bookAddDate = bookInfo.getAddDate();
		principal = bookInfo.getPrincipal();
		initDate(bookInfo);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "确   定") {
			BookInfo bookInfo = getBookInfo();
			bookInfo.setAddDate(bookAddDate);
			bookInfo.setPrincipal(principal);
			bookInfo.setState(bookState);
			boolean result = new BookBll().Update(bookInfo);
			if (result) {
				JOptionPane.showMessageDialog(null,"操作成功","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}else {
				JOptionPane.showMessageDialog(null,"操作失败","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}
		}
	}
	
	
	
	

}
