package UI.Borrow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Bll.BorrowBll;
import Bll.ReaderBll;
import UI.Book.BookAdd;
import UITool.Borrow_ReturnAbsolutePanel;
import UITool.FixedTable;
import pojo.BorrowInfo;
import pojo.ReaderInfo;



@SuppressWarnings("serial")
public class BorrowPanel extends Borrow_ReturnAbsolutePanel implements ActionListener{

		
	
	public BorrowPanel() {
		super();
		initTableDate(initDate());
		
	}
	
	
	public BorrowPanel(String userID) {
		super();
		UserID = userID;
		initTableDate(new ArrayList<BorrowInfo>());
		cancel.addActionListener(this);
		confirm.addActionListener(this);
	}
	
	
	//初始化表格数据(测试用)
    private List<BorrowInfo> initDate(){
		List<BorrowInfo> date = new ArrayList<>();
		for(int i = 0;i<3;i++) {
			BorrowInfo Info = new BorrowInfo();
			Info.setBookID("111333111333");
			Info.setBookName("龙族  悼亡者之瞳");
			Info.setBorrowDate("2019-10-01");
			Info.setAntipateReturn("2019-11-01");
			date.add(Info);
		}
		return date;
	}
	
	
    
    
    /**
     * 初始化借书信息表格
     */
    protected void initTableDate(List<BorrowInfo> DateList) {
    	DefaultTableModel date = initDataModel(DateList);
		infoTable.setModel(date);
		FixedTable.ColumnWidthMatchesTheContent(infoTable);	//设置表格列宽与内容相适应
	}
    
	
	
	/**
	 * 根据数据集合设定的表格数据模型
	 * DateList ：数据集合
	 * return 表格数据模型
	 */
	protected DefaultTableModel initDataModel(List<BorrowInfo> DateList) {
		int Count = DateList.size();			//获取集合中的学生数量
		String[] columnNames = {"序号","ISBN","书籍名称","借书日期","预计还书日期"};//定义表格列名数组
		String[][] tableValues = new String[Count][5];//创建表格数据数组
		for(int i = 0;i < Count;i++) {//遍历表格所有行
			BorrowInfo Date = DateList.get(i);//获取行用户对象
			if (Date.getReturnDate() == null) {
				int count = i+1;
				tableValues[i][0] = "" + count;//第一列为序号
				tableValues[i][1] = "" + Date.getBookID();//第二列为ISBN编号
				tableValues[i][2] = "" + Date.getBookName();//第三列为书籍名称
				tableValues[i][3] = "" + Date.getBorrowDate();//第四列为借书日期
				tableValues[i][4] = "" + Date.getAntipateReturn();//第五列为预计归还日期
			}
		}
		DefaultTableModel tmp = new DefaultTableModel(tableValues,columnNames);//根据列名数组和数据数组创建表格数据模型
		return tmp;
	}
    
    
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
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
				boolean result = bll.Borrow(readerID, ISBN, UserID);
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
