package UI.Book;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bll.BookBll;
import pojo.BookInfo;

public class BookMessage extends JFrame{

	protected JFrame frame;
	protected JPanel mainpanel;		
	protected JPanel imagePanel;		//相片面板

	protected JPanel btPanel;			//按钮面板
	
	protected JButton close;			//关闭按钮
	
	protected JLabel imageLb;			//相片标签
	protected JLabel ISBNLb;			//ISBN标签
	protected JLabel nameLb;			//书籍名称标签
	protected JLabel authorLb;			//书籍作者标签
	protected JLabel publishingLb;		//出版社标签
	protected JLabel typeLb;			//书籍类型标签
	protected JLabel createDateLb;		//出版时间标签
	protected JLabel pageCountLb;		//书籍页数标签
	protected JLabel priceLb;			//书籍价格标签
	protected JLabel locationLb;		//馆藏位置标签
	protected JLabel stateLb;			//书籍在馆标签
	protected JLabel textLb;			//书籍简介标签
	
	
	
	public BookMessage() {
		initMainPanel();
		initBtPanel();
		frame = new JFrame("图书详细信息");
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		frame.getContentPane().add(btPanel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		frame.setSize(400, 300);
	}
	
	
	
	public BookMessage(String ISBN) {
		initMainPanel();
		initBtPanel();
		frame = new JFrame("图书详细信息");
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		frame.getContentPane().add(btPanel, BorderLayout.SOUTH);
		initBookData(new BookBll().SelectBook(ISBN, "ISBN").get(0));
		frame.setVisible(true);
		frame.setSize(400, 300);
	}
	
	
	
	private void initBookData(BookInfo book) {
		ISBNLb.setText("ISBN："+book.getISBN());
		nameLb.setText("书名："+book.getName());
		authorLb.setText("作者："+book.getAuthor());
		publishingLb.setText("出版社："+book.getPublishing());
		createDateLb.setText("出版时间："+book.getCreateDate());
		pageCountLb.setText("书籍页数："+book.getPageCount());
		priceLb.setText("书籍价格："+book.getPrice());
		locationLb.setText("馆藏位置："+book.getLocation());
		stateLb.setText("是否在馆："+book.getState());
		textLb.setText(book.getText().toString());
		typeLb.setText("书籍类型："+book.getType());
	}
	
	
	
	/**
	 * 初始化信息主面板
	 */
	private void initMainPanel() {
		ISBNLb = new JLabel("ISBN：3333111122222");
		nameLb = new JLabel("书名：龙族   黑月之潮");
		authorLb = new JLabel("作者：江南");
		publishingLb = new JLabel("出版社：清华大学出版社");
		createDateLb = new JLabel("出版时间：2019-01-01");
		pageCountLb = new JLabel("书籍页数：400");
		priceLb = new JLabel("书籍价格：50");
		locationLb = new JLabel("馆藏位置：诺顿馆");
		stateLb = new JLabel("是否在馆：在馆");
		JLabel text = new JLabel("简介");
		typeLb = new JLabel("书籍类型：宇宙科学类");
		textLb = new JLabel();
		
		JPanel leftPanel = new JPanel(new GridLayout(10, 1));
		leftPanel.add(ISBNLb);
		leftPanel.add(nameLb);
		leftPanel.add(authorLb);
		leftPanel.add(typeLb);
		leftPanel.add(publishingLb);
		leftPanel.add(createDateLb);
		leftPanel.add(pageCountLb);
		leftPanel.add(locationLb);
		leftPanel.add(stateLb);
		
		JPanel rightPanel = new JPanel(new GridLayout(2, 1));
		rightPanel.add(text);
		rightPanel.add(textLb);
		
		mainpanel = new JPanel(new GridLayout(1, 2));
		mainpanel.add(leftPanel);
		mainpanel.add(rightPanel);
		
	}
	
	
	
	
	/**
	 * 初始化相片面板
	 */
	private void initImagePanel() {
		imageLb = new JLabel();
		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setSize(200, 220);
		panel.add(imageLb);
		imagePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout)imagePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		imagePanel.add(panel);
	}
	
	/**
	 * 初始化按钮面板
	 */
	private void initBtPanel() {
		close = new JButton("关   闭");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout)btPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		btPanel.add(close);
	}
	
}
