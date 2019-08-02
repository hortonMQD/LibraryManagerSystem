package UI.Reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Bll.ReaderBll;
import Bll.UserBll;
import UI.User.UserMassage;
import UITool.Reader_User_Book_AbsoluteManagerWin;
import pojo.ReaderInfo;
import pojo.UserInfo;

@SuppressWarnings("serial")
public class ReaderFrame   extends Reader_User_Book_AbsoluteManagerWin implements ActionListener{

	
	public ReaderFrame() {
		super();
		setTitle("读者管理");
		initCombox();
		initTableDate();
		addBT.addActionListener(this);
		updateBT.addActionListener(this);
		deleteBT.addActionListener(this);
		selectBT.addActionListener(this);
		flashBT.addActionListener(this);
		infoTable.addMouseListener(new MouseAdapter() {	//	表格添加鼠标事件监听
			public void mouseClicked(MouseEvent e) {//当鼠标点击时
				if(e.getClickCount() == 2) {		//如果鼠标是双击事件
					String readerID = (String)infoTable.getValueAt(infoTable.getSelectedRow(), 1);//获取选中行的第二列数据，赋值为readerID
					ReaderInfo reader = new ReaderBll().SelectReader(readerID, "用户编号").get(0);
					new ReaderMassage(reader);
				}//if语句结束
			}//mouseClicked()结束
		});//addMouseListener()结束
	}
	
	
	/**
	 * 初始化书籍信息窗体
	 */
	private void initTableDate() {
		DefaultTableModel date = initDataModel(new ReaderBll().SelectAllReader());
		infoTable.setModel(date);
	}
	
	
	/**
	 * 初始化书籍信息窗体(测试)
	 */
	private void initTableDateTest() {
		DefaultTableModel date = initDataModel(initDate());
		infoTable.setModel(date);
	}
	
	
	
	/**
	 * 初始化搜索 下拉框数据
	 */
	private void initCombox() {
		String Data[] = new String[] { "姓名","性别"};	//下拉框数据
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// 创建下拉框数据模型
		selectCB.setModel(surchComboBoxModel);		//将数据模型加载到下拉框中
	}
	
	
	
	//初始化表格数据(测试用)
	private List<ReaderInfo> initDate(){
		List<ReaderInfo> date = new ArrayList<>();
		for(int i = 0;i<100;i++) {
			ReaderInfo Info = new ReaderInfo();
			Info.setName("路明非");
			Info.setSex("男");
			Info.setMaxNum("5");
			Info.setNowNum("2");
			Info.setTelephone("13828921933");
			date.add(Info);
		}
		return date;
	}
	
	
	/**
	 * 根据数据集合设定的表格数据模型
	 * usableList ：数据集合
	 * return 表格数据模型
	 */
	private DefaultTableModel initDataModel(List<ReaderInfo> DateList) {
		int Count = DateList.size();			//获取集合中的学生数量
		String[] columnNames = {"序号","读者编号","姓名","性别","联系电话","可借书籍数目","当前已借数目"};//定义表格列名数组
		String[][] tableValues = new String[Count][7];//创建表格数据数组
		for(int i = 0;i < Count;i++) {//遍历表格所有行
			ReaderInfo Date = DateList.get(i);//获取行用户对象
			int count = i+1;
			tableValues[i][0] = "" + count;					//第一列为序号
			tableValues[i][1] = "" + Date.getReaderID();	//第二列为读者编号
			tableValues[i][2] = "" + Date.getName();		//第三列为姓名
			tableValues[i][3] = "" + Date.getSex();			//第四列为性别
			tableValues[i][4] = "" + Date.getTelephone();	//第五列为联系电话
			tableValues[i][5] = "" + Date.getMaxNum();		//第六列为可借书籍数目
			tableValues[i][6] = "" + Date.getNowNum();		//第七列为当前已借数目
		}
		DefaultTableModel tmp = new DefaultTableModel(tableValues,columnNames);//根据列名数组和数据数组创建表格数据模型
		return tmp;
	}

	
	/**
	 * 获取表格详细信息
	 * @return  返回表格信息数据集合
	 */
	private List<ReaderInfo> getTableDate(){
		List<ReaderInfo> date = new ArrayList<>();
		
		
		return date;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand() == "添 加") {
			new ReaderAdd();
		}else if(arg0.getActionCommand() == "修 改") {
			new ReaderUpdate((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
		}else if(arg0.getActionCommand() == "删 除") {
			boolean result = new ReaderBll().Delete((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
			if (result) {
				JOptionPane.showMessageDialog(null,"操作成功","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
				initTableDate();
			}else {
				JOptionPane.showMessageDialog(null,"操作失败","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}
		}else if(arg0.getActionCommand() == "刷 新") {
			initTableDate();
		}else if (arg0.getActionCommand() == "搜索") {
			List<ReaderInfo> readers = new ReaderBll().SelectReader(selectTF.getText(), selectCB.getSelectedItem().toString());
			infoTable.setModel(initDataModel(readers));
		}
	}
	

}
