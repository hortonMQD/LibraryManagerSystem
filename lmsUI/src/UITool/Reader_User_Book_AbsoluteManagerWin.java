package UITool;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class Reader_User_Book_AbsoluteManagerWin extends JInternalFrame{
	
	protected JPanel btPanel;				//按钮面板
	protected JPanel selectPanel;			//搜索面板
	protected JPanel tablePanel;			//表格面板
	
	
	
	protected JComboBox<String> selectCB;	//搜索下拉框
	protected JTextField selectTF;			//搜索文本框
	protected JButton selectBT;				//搜索按钮
	
	
	protected JButton addBT;				//添加按钮
	protected JButton deleteBT;				//删除按钮
	protected JButton updateBT;				//修改按钮
	protected JButton flashBT;				//刷新按钮
	
	
	protected String UserID;
	
	protected FixedTable infoTable;				//表格
	
	protected JInternalFrame frame;				//内部窗口
	
	
	
	public Reader_User_Book_AbsoluteManagerWin() {
		
		btPanel = initBtPanel(btPanel);						//初始化按钮面板
		tablePanel = initTablePanel(tablePanel);			//初始化表格面板
		selectPanel = initSelectPanel(selectPanel);			//初始化搜索面板
		
		
		
		frame = new JInternalFrame();					//创建窗口
		setResizable(true);		//允许自由调整大小
		setClosable(true);		//提供关闭按钮
		setIconifiable(true);	//提供图表化按钮
		setMaximizable(true);	//提供最大化按钮
		
		getContentPane().add(selectPanel, BorderLayout.NORTH);//加载搜索面板到窗口顶部
		getContentPane().add(tablePanel, BorderLayout.CENTER);//加载表格面板到窗口中央
		getContentPane().add(btPanel, BorderLayout.SOUTH);	//加载按钮面板到窗口底部
		
		

		frame.setSize(600, 500);    				 //设置窗体大小
		frame.setVisible(true);						 //设置窗体可见
	}
	
	
	/**
	 * 初始化表格面板
	 * @param panel  表格容器
	 * @return  返回初始化后的表格面板
	 */
	private JPanel initTablePanel(JPanel panel) {
		if (panel == null) {	panel = new JPanel();  }
		
		panel.setLayout(new BorderLayout(0, 0));
		infoTable = new FixedTable();
		infoTable.setToolTipText("双击鼠标查看详细信息");		//设置表格悬停提示
		JScrollPane scrollPane = new JScrollPane(infoTable);// 给表格添加下拉框
		infoTable.setCellEditable(false);					//让表格不可编辑
		FixedTable.ColumnWidthMatchesTheContent(infoTable);	//设置表格列宽与内容相适应


		JLabel lblNewLabel = new JLabel("提示：双击鼠标查看提示信息。");// 提示标签
		panel.add(scrollPane, BorderLayout.CENTER); //将添加下拉框的表格放到表格面板中间位置
		panel.add(lblNewLabel, BorderLayout.SOUTH); //提示标签放到表格面板最南位置
		
		
		return panel;
	}
	
	
	/**
	 * 初始化按钮面板
	 * @param panel  按钮容器
	 * @return 返回初始化后的按钮面板
	 */
	private JPanel initBtPanel(JPanel panel) {
		if (panel == null) {	panel = new JPanel();  }
		FlowLayout flowLayout = (FlowLayout)panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		
		addBT = new JButton("添 加");
		deleteBT = new JButton("删 除");
		updateBT = new JButton("修 改");
		flashBT = new JButton("刷 新");
		
		panel.add(flashBT);
		panel.add(addBT);
		panel.add(updateBT);
		panel.add(deleteBT);
		
		return panel;
	}
	
	/**
	 * 初始化搜索面板
	 * @param panel  搜索容器
	 * @return	返回初始化后的搜索面板
	 */
	private JPanel initSelectPanel(JPanel panel) {
		if (panel == null) {	panel = new JPanel();  }
		FlowLayout flowLayout = (FlowLayout)panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		selectCB = new JComboBox<>();
		selectTF = new JTextField();
		selectTF.setColumns(15);
		selectBT = new JButton("搜索");
		
		panel.add(selectCB);
		panel.add(selectTF);
		panel.add(selectBT);
		
		return panel;
	}
}
