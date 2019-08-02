package UI.Book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Bll.BookBll;
import pojo.BookInfo;

public class BookAdd extends BookAddUpdateFrame implements ActionListener{

	
	public BookAdd() {
		super();
		frame.setTitle("添加图书信息");
		confirm.addActionListener(this);
	}
	
	
	
	public BookAdd(String userID) {
		super();
		frame.setTitle("添加图书信息");
		confirm.addActionListener(this);
		this.principal = userID;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "确   定") {
			BookInfo book = getBookInfo();
			book.setState("在馆");
			boolean result = new BookBll().Insert(book);
			if (result) {
				JOptionPane.showMessageDialog(null,"操作成功","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}else {
				JOptionPane.showMessageDialog(null,"操作失败","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}
		}
	}
	
	

}
