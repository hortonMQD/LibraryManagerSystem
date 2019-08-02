package UI.Borrow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Bll.BorrowBll;
import Bll.ReaderBll;
import UITool.Borrow_ReturnAbsolutePanel;
import UITool.FixedTable;
import pojo.BorrowInfo;
import pojo.ReaderInfo;

public class SelectBorrowInfoPanel extends Borrow_ReturnAbsolutePanel implements ActionListener{

	
	public SelectBorrowInfoPanel() {
		// TODO Auto-generated constructor stub
		super();
		panel.remove(lbPanel);
		panel.remove(tbPanel);
		panel.add(tbPanel,BorderLayout.CENTER);
		cancel.addActionListener(this);
		confirm.addActionListener(this);
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
		// TODO Auto-generated method stub
		if(arg0.getActionCommand() == "确  定") {
			if (readerID == null) {
				readerID = tf.getText();
				readerID = new ReaderBll().SelectReader(readerID, "用户编号").get(0).getID();
				initTableDate(new BorrowBll().selectBorrow(readerID));
			}
		}else if(arg0.getActionCommand() == "取  消") {
			readerID = null;
			tf.setText("");
		}
	}

}
