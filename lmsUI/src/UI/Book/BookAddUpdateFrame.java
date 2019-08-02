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
	protected JPanel textPanel;			//�鼮������
	protected JPanel imagePanel;		//��Ƭ���

	protected JPanel btPanel;			//��ť���
	
	protected JButton confirm;			//ȷ�ϰ�ť
	protected JButton cancel;			//ȡ����ť
	
	protected JLabel imageLb;			//��Ƭ��ǩ
	protected JButton imageBt;			//�����Ƭ��ť
	
	protected JTextField ISBNTf;		//ISBN�ı���
	protected JTextField nameTf;		//�����ı���
	protected JTextField authorTf;		//�����ı���
	protected JTextField publishingTf;	//�������ı���
	protected JTextField pageCountTf;	//�鼮ҳ���ı���
	protected JTextField priceTf;		//�鼮�۸��ı���
	protected JComboBox<String> locationCb;	//�ݲ�λ��������
	protected JComboBox<String> typeCb;		//�鼮����������
	protected JTextField createDateTf;	//���������ı���
	protected JTextArea textArea;		//��ַ�ı���
	
	
	
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
		
		frame = new JFrame();					//��������
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		//frame.getContentPane().add(textPanel, BorderLayout.CENTER);
		frame.getContentPane().add(btPanel, BorderLayout.SOUTH);
		
		frame.setResizable(false);					//���������ɵ�����С
		frame.setLocationRelativeTo(null);			 //���ô��������ʾ
		frame.setSize(800, 400);    				 //���ô����С
		frame.setVisible(true);						 //���ô���ɼ�
	}
	
	
	
	/**
	 * ��ʼ����Ƭ���
	 */
	private void initImagePanel() {
		imageLb = new JLabel();
		imageBt = new JButton("���ѡ��ͼƬ");
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
		confirm = new JButton("ȷ   ��");
		cancel = new JButton("ȡ   ��");
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
	 * ��ʼ���ı������
	 */
	private JPanel initMainPanel() {
		JLabel ISBNLb = new JLabel("  ISBN  ��");			//ISBN��ǩ
		JLabel nameLb = new JLabel("�鼮���ƣ�");				//�鼮���Ʊ�ǩ
		JLabel authorLb = new JLabel("��        �ߣ�");			//���߱�ǩ
		JLabel typeLb = new JLabel("�鼮����");
		JLabel publishingLb = new JLabel("��  ��  �磺");		//�������ǩ
		JLabel createDateLb = new JLabel("��������");		//�������ڱ�ǩ
		JLabel pageCountLb = new JLabel("ҳ        ��");			//�鼮ҳ����ǩ
		JLabel priceLb = new JLabel("��        ��");				//�鼮�۸��ǩ
		JLabel locationLb = new JLabel("�ݲ�λ��");			//�ݲ�λ�ñ�ǩ
		
		
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
		JLabel textLb = new JLabel("��        ��");			//����ǩ
		textPanel = new JPanel();
		textPanel.add(textLb, BorderLayout.NORTH);
		textPanel.add(pane, BorderLayout.CENTER);
	}
	
	
	/**
	 * ��ʼ���鼮��������������
	 */
	private void initTypeCombox() {
		String Data[] = new String[] {"�����ѧ��","��Ȼ������","�������ѧ��","������","��ѧ��","��Ȼ������","��ʷ����"};	//����������
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// ��������������ģ��
		typeCb.setModel(surchComboBoxModel);		//������ģ�ͼ��ص���������
	}
	
	
	/**
	 * ��ʼ���ݲ�λ������������
	 */
	private void initLocationCombox() {
		String Data[] = new String[] { "ŵ�ٹ�"};	//����������
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// ��������������ģ��
		locationCb.setModel(surchComboBoxModel);		//������ģ�ͼ��ص���������
	}
	
	
	/**
	 * ����ı������鼮����
	 * @return	�����鼮��Ϣ����
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
	 * ��������䵽�ı�����
	 * @param book	������鼮����
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
