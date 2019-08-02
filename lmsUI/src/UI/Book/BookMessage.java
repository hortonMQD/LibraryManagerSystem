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
	protected JPanel imagePanel;		//��Ƭ���

	protected JPanel btPanel;			//��ť���
	
	protected JButton close;			//�رհ�ť
	
	protected JLabel imageLb;			//��Ƭ��ǩ
	protected JLabel ISBNLb;			//ISBN��ǩ
	protected JLabel nameLb;			//�鼮���Ʊ�ǩ
	protected JLabel authorLb;			//�鼮���߱�ǩ
	protected JLabel publishingLb;		//�������ǩ
	protected JLabel typeLb;			//�鼮���ͱ�ǩ
	protected JLabel createDateLb;		//����ʱ���ǩ
	protected JLabel pageCountLb;		//�鼮ҳ����ǩ
	protected JLabel priceLb;			//�鼮�۸��ǩ
	protected JLabel locationLb;		//�ݲ�λ�ñ�ǩ
	protected JLabel stateLb;			//�鼮�ڹݱ�ǩ
	protected JLabel textLb;			//�鼮����ǩ
	
	
	
	public BookMessage() {
		initMainPanel();
		initBtPanel();
		frame = new JFrame("ͼ����ϸ��Ϣ");
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		frame.getContentPane().add(btPanel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		frame.setSize(400, 300);
	}
	
	
	
	public BookMessage(String ISBN) {
		initMainPanel();
		initBtPanel();
		frame = new JFrame("ͼ����ϸ��Ϣ");
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		frame.getContentPane().add(btPanel, BorderLayout.SOUTH);
		initBookData(new BookBll().SelectBook(ISBN, "ISBN").get(0));
		frame.setVisible(true);
		frame.setSize(400, 300);
	}
	
	
	
	private void initBookData(BookInfo book) {
		ISBNLb.setText("ISBN��"+book.getISBN());
		nameLb.setText("������"+book.getName());
		authorLb.setText("���ߣ�"+book.getAuthor());
		publishingLb.setText("�����磺"+book.getPublishing());
		createDateLb.setText("����ʱ�䣺"+book.getCreateDate());
		pageCountLb.setText("�鼮ҳ����"+book.getPageCount());
		priceLb.setText("�鼮�۸�"+book.getPrice());
		locationLb.setText("�ݲ�λ�ã�"+book.getLocation());
		stateLb.setText("�Ƿ��ڹݣ�"+book.getState());
		textLb.setText(book.getText().toString());
		typeLb.setText("�鼮���ͣ�"+book.getType());
	}
	
	
	
	/**
	 * ��ʼ����Ϣ�����
	 */
	private void initMainPanel() {
		ISBNLb = new JLabel("ISBN��3333111122222");
		nameLb = new JLabel("����������   ����֮��");
		authorLb = new JLabel("���ߣ�����");
		publishingLb = new JLabel("�����磺�廪��ѧ������");
		createDateLb = new JLabel("����ʱ�䣺2019-01-01");
		pageCountLb = new JLabel("�鼮ҳ����400");
		priceLb = new JLabel("�鼮�۸�50");
		locationLb = new JLabel("�ݲ�λ�ã�ŵ�ٹ�");
		stateLb = new JLabel("�Ƿ��ڹݣ��ڹ�");
		JLabel text = new JLabel("���");
		typeLb = new JLabel("�鼮���ͣ������ѧ��");
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
	 * ��ʼ����Ƭ���
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
	 * ��ʼ����ť���
	 */
	private void initBtPanel() {
		close = new JButton("��   ��");
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
