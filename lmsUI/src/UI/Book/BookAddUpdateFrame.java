package UI.Book;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pojo.BookInfo;

@SuppressWarnings("serial")
public class BookAddUpdateFrame extends JFrame{
	
	protected JFrame frame;
	protected JPanel mainpanel;		
	protected JPanel textPanel;			//书籍简介面板
	protected JPanel imagePanel;		//相片面板

	protected JPanel btPanel;			//按钮面板
	
	protected JButton confirm;			//确认按钮
	protected JButton cancel;			//取消按钮
	
	protected JLabel imageLb;			//相片标签
	protected JButton imageBt;			//添加相片按钮
	
	protected JTextField ISBNTf;		//ISBN文本框
	protected JTextField nameTf;		//书名文本框
	protected JTextField authorTf;		//作者文本框
	protected JTextField publishingTf;	//出版社文本框
	protected JTextField pageCountTf;	//书籍页数文本框
	protected JTextField priceTf;		//书籍价格文本框
	protected JComboBox<String> locationCb;	//馆藏位置下拉框
	protected JComboBox<String> typeCb;		//书籍类型下拉框
	protected JTextField createDateTf;	//出版日期文本框
	protected JTextArea textArea;		//地址文本框
	
	
	
	protected String bookState;
	protected String bookAddDate;
	protected String principal = null;
	
	
	public BookAddUpdateFrame() {
		//initImagePanel();
		mainpanel = new JPanel();
		mainpanel.add(initMainPanel());
		initTextPanel();
		initBtPanel();
		initTypeCombox();
		initLocationCombox();
		mainpanel.add(textPanel);
		
		frame = new JFrame();					//创建窗口
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		//frame.getContentPane().add(textPanel, BorderLayout.CENTER);
		frame.getContentPane().add(btPanel, BorderLayout.SOUTH);
		
		frame.setResizable(false);					//不允许自由调整大小
		frame.setLocationRelativeTo(null);			 //设置窗体居中显示
		frame.setSize(800, 400);    				 //设置窗体大小
		frame.setVisible(true);						 //设置窗体可见
	}
	
	
	
	/**
	 * 初始化相片面板
	 */
	private void initImagePanel() {
		imageLb = new JLabel();
		imageBt = new JButton("点击选择图片");
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.setSize(200, 220);
		panel.add(imageLb);
		panel.add(imageBt);
		imagePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout)imagePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		imagePanel.add(panel);
	}
	
	
	
	private void initBtPanel() {
		confirm = new JButton("确   定");
		cancel = new JButton("取   消");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btPanel = new JPanel(new GridLayout(1, 2));
		btPanel.add(confirm);
		btPanel.add(cancel);
	}
	
	
	
	/**
	 * 初始化文本框面板
	 */
	private JPanel initMainPanel() {
		JLabel ISBNLb = new JLabel("  ISBN  ：");			//ISBN标签
		JLabel nameLb = new JLabel("书籍名称：");				//书籍名称标签
		JLabel authorLb = new JLabel("作        者：");			//作者标签
		JLabel typeLb = new JLabel("书籍类型");
		JLabel publishingLb = new JLabel("出  版  社：");		//出版社标签
		JLabel createDateLb = new JLabel("出版日期");		//出版日期标签
		JLabel pageCountLb = new JLabel("页        数");			//书籍页数标签
		JLabel priceLb = new JLabel("价        格");				//书籍价格标签
		JLabel locationLb = new JLabel("馆藏位置");			//馆藏位置标签
		
		
		ISBNTf = new JTextField();
		ISBNTf.setColumns(20);
		nameTf = new JTextField();
		nameTf.setColumns(20);
		authorTf = new JTextField();
		authorTf.setColumns(20);
		publishingTf = new JTextField();
		publishingTf.setColumns(20);
		createDateTf = new JTextField();
		createDateTf.setColumns(20);
		pageCountTf = new JTextField();
		pageCountTf.setColumns(20);
		priceTf = new JTextField();
		priceTf.setColumns(20);
		locationCb = new JComboBox<>();
		typeCb = new JComboBox<>();
		
		
		JPanel mainpanel = new JPanel(new GridLayout(9, 1));
		mainpanel.add(addPanel(ISBNTf,ISBNLb));
		mainpanel.add(addPanel(nameTf,nameLb));
		mainpanel.add(addPanel(authorTf,authorLb));
		mainpanel.add(addPanel(typeCb, typeLb));
		mainpanel.add(addPanel(publishingTf,publishingLb));
		mainpanel.add(addPanel(createDateTf,createDateLb));
		mainpanel.add(addPanel(pageCountTf,pageCountLb));
		mainpanel.add(addPanel(priceTf,priceLb));
		mainpanel.add(addPanel(locationCb,locationLb));		
		return mainpanel;
	}
	
	private void initTextPanel() {
		textArea = new JTextArea(10,30);
		textArea.setLineWrap(true);
		JScrollPane pane = new JScrollPane(textArea);
		JLabel textLb = new JLabel("简        介");			//简介标签
		textPanel = new JPanel();
		textPanel.add(textLb, BorderLayout.NORTH);
		textPanel.add(pane, BorderLayout.CENTER);
	}
	
	
	/**
	 * 初始化书籍类型下拉框数据
	 */
	private void initTypeCombox() {
		String Data[] = new String[] {"宇宙科学类","自然物理类","计算机科学类","人文类","哲学类","自然地理类","历史文献"};	//下拉框数据
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// 创建下拉框数据模型
		typeCb.setModel(surchComboBoxModel);		//将数据模型加载到下拉框中
	}
	
	
	/**
	 * 初始化馆藏位置下拉框数据
	 */
	private void initLocationCombox() {
		String Data[] = new String[] { "诺顿馆"};	//下拉框数据
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// 创建下拉框数据模型
		locationCb.setModel(surchComboBoxModel);		//将数据模型加载到下拉框中
	}
	
	
	/**
	 * 获得文本框内书籍数据
	 * @return	返回书籍信息对象
	 */
	protected BookInfo getBookInfo() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setISBN(ISBNTf.getText());
		bookInfo.setName(nameTf.getText());
		bookInfo.setAuthor(authorTf.getText());
		bookInfo.setText(new StringBuilder().append(textArea.getText()));
		bookInfo.setPublishing(publishingTf.getText());
		bookInfo.setCreateDate(createDateTf.getText());
		bookInfo.setPageCount(pageCountTf.getText());
		bookInfo.setPrice(priceTf.getText());
		bookInfo.setLocation(locationCb.getSelectedItem().toString());
		bookInfo.setType(typeCb.getSelectedItem().toString());
		if (principal != null) {
			bookInfo.setPrincipal(principal);
		}
		return bookInfo;
	}
	
	
	/**
	 * 将数据填充到文本框中
	 * @param book	传入的书籍数据
	 */
	protected void initDate(BookInfo book) {
		ISBNTf.setText(book.getISBN());
		nameTf.setText(book.getName());
		authorTf.setText(book.getAuthor());
		textArea.setText(book.getText().toString());
		publishingTf.setText(book.getPublishing());
		createDateTf.setText(book.getCreateDate());
		pageCountTf.setText(book.getPageCount());
		priceTf.setText(book.getPrice());
		locationCb.setSelectedItem(book.getLocation());
		typeCb.setSelectedItem(book.getType());
	}
	
	
	protected JPanel addPanel(JComboBox<String> comboBox,JLabel label) {
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(comboBox);
		return panel;
	}
	
	
	protected JPanel addPanel(JTextField textField,JLabel label) {
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(textField);
		return panel;
	}
	
	
	protected JPanel addPanel(JScrollPane pane,JLabel label) {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(label);
		panel.add(pane);
		return panel;
	}
	
	
	protected JPanel addPanel(JTextArea pane,JLabel label) {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(label);
		panel.add(pane);
		return panel;
	}
	

}
