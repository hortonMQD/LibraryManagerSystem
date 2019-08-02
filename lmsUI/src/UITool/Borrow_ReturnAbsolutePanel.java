package UITool;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import pojo.BorrowInfo;
import pojo.ReaderInfo;

@SuppressWarnings("serial")
public class Borrow_ReturnAbsolutePanel extends JPanel{
	
	
	protected JPanel panel;			//多面板容器
	protected JPanel btPanel;			//搜索面板
	protected JPanel lbPanel;			//读者信息面板
	protected JPanel tbPanel;			//已借书籍信息面板
	
	protected JTextField tf;			//编号输入框
	protected JButton cancel;			//取消按钮
	protected JButton confirm;		//确定按钮
	
	protected JLabel id;				//读者编号标签
	protected JLabel name;			//姓名标签
	protected JLabel sex;				//性别标签
	protected JLabel createDate;		//办卡日期标签
	protected JLabel telephone;		//联系电话标签
	protected JLabel image;			//头像标签

	protected FixedTable infoTable;	//表格
	
	
	
	protected String ISBN = null;
	protected String readerID = null;
	protected String UserID = null;
	
	
	public Borrow_ReturnAbsolutePanel() {

		btPanel = initBtPanel();			//初始化搜索面板
		lbPanel = initLbPanel();			//初始化读者信息面板
		tbPanel = initTbPanel();			//初始化已借书籍信息面板
		panel = new JPanel();				//多面板容器
		//panel.setLayout(new BorderLayout());
		panel.add(btPanel, BorderLayout.NORTH);
		panel.add(lbPanel,BorderLayout.CENTER);
		panel.add(tbPanel, BorderLayout.SOUTH);
	}
	
	
	/**
	 * 初始化搜索面板
	 */
	private JPanel initBtPanel() {
		//JLabel label = new JLabel();				//编号标签
		tf = new JTextField();						//编号输入框
		tf.setColumns(20);
		
		cancel = new JButton("取  消");				//取消按钮
		confirm = new JButton("确  定");				//确定按钮
		
		JPanel Panel = new JPanel();		//搜索面板
		FlowLayout flowLayout = (FlowLayout)Panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		//将控件加载到搜索面板中
		//btPanel.add(label);
		Panel.add(tf);
		Panel.add(confirm);
		Panel.add(cancel);
		btPanel = new JPanel();
		btPanel.add(Panel);
		return btPanel;
	}
	
	
	

	public JPanel getPanel() {
		return panel;
	}
	
	
	
	/**
	 * 初始化读者信息面板
	 */
	private JPanel initLbPanel() {
		name = new JLabel("姓名：路明非");
		id = new JLabel("编号：17010001");
		sex = new JLabel("性别： 男");
		createDate = new JLabel("办卡日期：2019-10-10");
		telephone = new JLabel("联系电话：17328264138");
		//image = new JLabel();
		
		JPanel left = new JPanel(new GridLayout(5, 1));								//标签面板
		//JPanel right = new JPanel(new GridLayout(1, 1));							//头像面板
//		lbPanel = new JPanel(new GridLayout(5, 1));										//读者信息面板
//		lbPanel.add(id);
//		lbPanel.add(name);
//		lbPanel.add(sex);
//		lbPanel.add(telephone);
//		lbPanel.add(createDate);
		left.add(id);
		left.add(name);
		left.add(sex);
		left.add(telephone);
		left.add(createDate);
		//right.add(image);
		
		lbPanel = new JPanel(new GridLayout(1, 2));				//读者信息面板
		
		lbPanel.add(left);											//将标签面板加载读者信息面板
		//lbPanel.add(right);										//将头像面板加载到读者信息面板
		
		return lbPanel;
	}
	
	/**
	 * 初始化书籍信息面板
	 */
	private JPanel initTbPanel() {
		tbPanel = new JPanel(new BorderLayout(0, 0));
		infoTable = new FixedTable();
		JScrollPane scrollPane = new JScrollPane(infoTable);// 给表格添加下拉框
		infoTable.setCellEditable(false);					//让表格不可编辑
		initTableDate();									//初始化表格信息
		//FixedTable.ColumnWidthMatchesTheContent(infoTable);	//设置表格列宽与内容相适应
		tbPanel.add(scrollPane,BorderLayout.CENTER); 							//将添加下拉框的表格放到表格面板中间位置
		return tbPanel;
	}
	
	
	//初始化表格数据(测试用)
    private List<BorrowInfo> initDate(){
		List<BorrowInfo> date = new ArrayList<>();
		for(int i = 0;i<3;i++) {
			BorrowInfo Info = new BorrowInfo();
			Info.setBookID("111333111333");
			Info.setBookName("龙族  黑月之潮");
			Info.setBorrowDate("2019-10-10");
			Info.setAntipateReturn("2019-11-10");
			date.add(Info);
		}
		return date;
	}
	
	
    
    /**
     * 初始化借书信息表格
     */
    private void initTableDate() {
    	DefaultTableModel date = initDataModel(new ArrayList<BorrowInfo>());
		infoTable.setModel(date);
		FixedTable.ColumnWidthMatchesTheContent(infoTable);	//设置表格列宽与内容相适应
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
			if (Date.getReturnDate() != null) {
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
	
	
	
	
	
	
	
	protected void setReaderData(ReaderInfo info) {
		id.setText("编号："+info.getReaderID());
		name.setText("姓名："+info.getName());
		sex.setText("性别："+info.getSex());
		createDate.setText("办卡日期："+info.getCreateDate());
		telephone.setText("联系电话："+info.getTelephone());
	}
	
	
}
