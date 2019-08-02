package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import UI.Book.BookFrame;
import UI.Borrow.mainBorrow;
import UI.Chart.mainChart;
import UI.Reader.ReaderFrame;
import UI.User.UserFrame;
import UITool.MyJDesktopPane;

public class MainFrame implements ActionListener {
	
	final int DESKTOP_WIDTH = 800;
	final int DESKTOP_HEIGHT = 600;
	final int FRAME_DISTANCE = 30;
	
	JFrame frame = new JFrame("图书馆管理系统");
	
	//定义一个虚拟桌面
	private MyJDesktopPane desktop = new MyJDesktopPane();
	
	
	//保存下一个内部窗口的坐标点
	private int nextFrameX;
	private int nextFrameY;
	
	//定义内部窗口为虚拟桌面的 1/2  大小
	private int width = DESKTOP_WIDTH / 2; 
	private int height = DESKTOP_HEIGHT / 2;
	
	
	
	//定义内部窗口按钮
	private JButton borrow;
	private JButton chart;
	private JButton book;
	private JButton user;
	private JButton reader;
	private JButton ticket;
	private String UserID;
	
	private JPanel panel;	//按钮面板
	
	
	public void initDesktop() {
		desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);//设置内部窗体的拖动模式为拖动时连续重绘
	}
	
	public void initPanel(){
		borrow = new JButton("借还管理");
		chart = new JButton("图表查看");
		book = new JButton("图书管理");
		user = new JButton("用户管理");
		reader = new JButton("读者管理");
		ticket = new JButton("罚单管理");
		
		book.addActionListener(this);
		borrow.addActionListener(this);
		chart.addActionListener(this);
		user.addActionListener(this);
		reader.addActionListener(this);
		
		panel = new JPanel(new GridLayout(1, 6));
		panel.add(reader);
		panel.add(borrow);
		panel.add(book);
		panel.add(ticket);
		panel.add(user);
		panel.add(chart);
		
		initDesktop();			//初始化虚拟桌面
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "图书管理") {
			initInternalFrame(new BookFrame(UserID));
		}else if(arg0.getActionCommand() == "用户管理") {
			initInternalFrame(new UserFrame());
		}else if(arg0.getActionCommand() == "借还管理") {
			initInternalFrame(new mainBorrow());
		}else if(arg0.getActionCommand() == "图表查看") {
			initInternalFrame(new mainChart());
		}else if(arg0.getActionCommand() == "读者管理") {
			initInternalFrame(new ReaderFrame());
		}else if(arg0.getActionCommand() == "罚单管理") {
			
		}
	}
	
	
	//在虚拟桌面加载内部窗体
	private void initInternalFrame(JInternalFrame frame) {
		desktop.add(frame);
		frame.reshape(nextFrameX, nextFrameY, width, height);
		frame.show();
		initFrameLocation();
	}
	
	//定义下一个窗口的位置
	private void initFrameLocation() {
		nextFrameX += FRAME_DISTANCE;
		nextFrameY += FRAME_DISTANCE;
		if(nextFrameX + width > desktop.getWidth()) { nextFrameX = 0; };
		if(nextFrameY + height > desktop.getHeight()) { nextFrameY = 0; };
	}
	
	
	
	
	public MainFrame() {
		initPanel();
		frame.add(desktop);
		frame.setSize(DESKTOP_WIDTH, DESKTOP_HEIGHT);
		frame.setLocationRelativeTo(null);					//设置窗体居中显示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击退出同时关闭进程
		frame.setVisible(true);
		frame.getContentPane().add(panel,BorderLayout.NORTH);
		frame.getContentPane().add(desktop,BorderLayout.CENTER);
	}
	
	
	public MainFrame(String userID) {
		initPanel();
		frame.add(desktop);
		frame.setSize(DESKTOP_WIDTH, DESKTOP_HEIGHT);
		frame.setLocationRelativeTo(null);					//设置窗体居中显示
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击退出同时关闭进程
		frame.setVisible(true);
		frame.getContentPane().add(panel,BorderLayout.NORTH);
		frame.getContentPane().add(desktop,BorderLayout.CENTER);
		this.UserID = userID;
	}
}
