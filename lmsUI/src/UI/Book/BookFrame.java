package UI.Book;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Bll.BookBll;
import Bll.UserBll;
import UI.User.UserMassage;
import UITool.Reader_User_Book_AbsoluteManagerWin;
import pojo.BookInfo;
import pojo.UserInfo;

@SuppressWarnings("serial")
public class BookFrame extends Reader_User_Book_AbsoluteManagerWin implements ActionListener{

	public BookFrame() {
		super();
		setTitle("图书管理");
		initTableDate();
		initCombox();
		flashBT.addActionListener(this);
		addBT.addActionListener(this);
		updateBT.addActionListener(this);
		deleteBT.addActionListener(this);
		selectBT.addActionListener(this);
		infoTable.addMouseListener(new MouseAdapter() {	//	表格添加鼠标事件监听
			public void mouseClicked(MouseEvent e) {//当鼠标点击时
				if(e.getClickCount() == 2) {		//如果鼠标是双击事件
					String ISBN = (String)infoTable.getValueAt(infoTable.getSelectedRow(), 1);//获取选中行的第二列数据，赋值为UserID
					//BookInfo book = new BookBll().SelectBook(ISBN, "ISBN").get(0);
					new BookMessage(ISBN);
				}//if语句结束
			}//mouseClicked()结束
		});//addMouseListener()结束
	}
	
	
	public BookFrame(String userID) {
		super();
		setTitle("图书管理");
		initTableDate();
		initCombox();
		flashBT.addActionListener(this);
		addBT.addActionListener(this);
		updateBT.addActionListener(this);
		deleteBT.addActionListener(this);
		selectBT.addActionListener(this);
		infoTable.addMouseListener(new MouseAdapter() {	//	表格添加鼠标事件监听
			public void mouseClicked(MouseEvent e) {//当鼠标点击时
				if(e.getClickCount() == 2) {		//如果鼠标是双击事件
					String ISBN = (String)infoTable.getValueAt(infoTable.getSelectedRow(), 1);//获取选中行的第二列数据，赋值为UserID
					//BookInfo book = new BookBll().SelectBook(ISBN, "ISBN").get(0);
					new BookMessage(ISBN);
				}//if语句结束
			}//mouseClicked()结束
		});//addMouseListener()结束
		this.UserID = userID;
	}
	
	
	
	/**
	 * 初始化书籍信息表格
	 */
	private void initTableDate() {
		//DefaultTableModel date = initDataModel(initDataTest());
		DefaultTableModel date = initDataModel(initData());
		infoTable.setModel(date);
		
	}
	
	
	/**
	 * 初始化搜索 下拉框数据
	 */
	private void initCombox() {
		String Data[] = new String[] { "ISBN","书名","馆藏位置"};	//下拉框数据
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// 创建下拉框数据模型
		selectCB.setModel(surchComboBoxModel);		//将数据模型加载到下拉框中
		
	}
	
	
	
	//初始化表格数据(测试用)
	private List<BookInfo> initDataTest(){
		List<BookInfo> date = new ArrayList<>();
		for(int i = 0;i<100;i++) {
			BookInfo bookInfo = new BookInfo();
			bookInfo.setName("龙族  黑月之潮");
			bookInfo.setPublishing("清华大学出版社");
			bookInfo.setCreateDate("2019-07-06");
			bookInfo.setType("宇宙科学类");
			bookInfo.setLocation("诺顿馆康斯坦丁区");
			bookInfo.setState("在馆");
			date.add(bookInfo);
		}
		return date;
	}
	
	
	
	//初始化表格数据
	private List<BookInfo> initData(){
		List<BookInfo> date = new BookBll().SelectAllBook();
		return date;
	}
	
	
	/**
	 * 根据数据集合设定的表格数据模型
	 * usableList ：数据集合
	 * return 表格数据模型
	 */
	private DefaultTableModel initDataModel(List<BookInfo> DateList) {
		int Count = DateList.size();			//获取集合中的学生数量
		String[] columnNames = {"序号","ISBN","书名","书籍类型","馆藏位置","馆藏状态"};//定义表格列名数组
		String[][] tableValues = new String[Count][6];//创建表格数据数组
		for(int i = 0;i < Count;i++) {//遍历表格所有行
			BookInfo Date = DateList.get(i);//获取行用户对象
			int count = i+1;
			tableValues[i][0] = "" + count;//第一列为序号
			tableValues[i][1] = "" + Date.getISBN();//第二列为ISBN
			tableValues[i][2] = "" + Date.getName();//第三列为书名
			tableValues[i][3] = "" + Date.getType();	 //第四列为书籍类型
			tableValues[i][4] = "" + Date.getLocation();//第五列为馆藏位置
			tableValues[i][5] = "" + Date.getState();//第六列为馆藏状态
		}
		DefaultTableModel tmp = new DefaultTableModel(tableValues,columnNames);//根据列名数组和数据数组创建表格数据模型
		return tmp;
	}

	
	/**
	 * 获取表格详细信息
	 * @return  返回表格信息数据集合
	 */
	private List<BookInfo> getTableDate(){
		List<BookInfo> date = new ArrayList<>();
		
		
		return date;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand() == "添 加") {
			new BookAdd(UserID);
		}else if(arg0.getActionCommand() == "修 改") {
			new BookUpdate((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
		}else if(arg0.getActionCommand() == "删 除") {
			boolean result = new BookBll().Delete((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
			if (result) {
				JOptionPane.showMessageDialog(null,"操作成功","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
				initTableDate();
			}else {
				JOptionPane.showMessageDialog(null,"操作失败","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}
		}else if(arg0.getActionCommand() == "刷 新") {
			initTableDate();
		}else if(arg0.getActionCommand() == "搜索") {
			String message = selectTF.getText();
			String selectType = selectCB.getSelectedItem().toString();
			List<BookInfo> books = new BookBll().SelectBook(message, selectType);
			infoTable.setModel(initDataModel(books));
		}
	}
	
}
