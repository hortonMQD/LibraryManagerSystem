package UI.Borrow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Bll.BorrowBll;
import Bll.ReaderBll;
import UITool.Borrow_ReturnAbsolutePanel;
import pojo.BorrowInfo;
import pojo.ReaderInfo;

public class RetutnPanel extends Borrow_ReturnAbsolutePanel implements ActionListener{

	
	public RetutnPanel() {
		super();
		initTableDate(initDate());
	}
	
	public RetutnPanel(String userID) {
		super();
		UserID = userID;
		initTableDate(initDate());
		cancel.addActionListener(this);
		confirm.addActionListener(this);
	}
	
	//初始化表格数据(测试用)
    private List<BorrowInfo> initDate(){
		List<BorrowInfo> date = new ArrayList<>();
		for(int i = 0;i<3;i++) {
			BorrowInfo Info = new BorrowInfo();
			Info.setBookID("111333111333");
			Info.setBookName("龙族  黑月之潮");
			Info.setBorrowDate("2019-10-21");
			Info.setAntipateReturn("2019-11-21");
			date.add(Info);
		}
		return date;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand() == "确  定") {
			if (readerID == null) {
				readerID = tf.getText();
				tf.setText("");
				ReaderInfo reader = new ReaderBll().SelectReader(readerID, "用户编号").get(0);
				setReaderData(reader);
				readerID = reader.getID();
			}else {
				BorrowBll bll = new BorrowBll();
				ISBN = tf.getText();
				boolean result = bll.Return(readerID, ISBN, UserID);
				if (result) {
					initTableDate(bll.selectBorrow(readerID));
					JOptionPane.showMessageDialog(null,"操作成功","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
				}else {
					JOptionPane.showMessageDialog(null,"操作失败","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
				}
			}
		}else if(arg0.getActionCommand() == "取  消") {
			readerID = null;
			ISBN = null;
			tf.setText("");
		}
	}

}
