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
	
	JFrame frame = new JFrame("ͼ��ݹ���ϵͳ");
	
	//����һ����������
	private MyJDesktopPane desktop = new MyJDesktopPane();
	
	
	//������һ���ڲ����ڵ������
	private int nextFrameX;
	private int nextFrameY;
	
	//�����ڲ�����Ϊ��������� 1/2  ��С
	private int width = DESKTOP_WIDTH / 2; 
	private int height = DESKTOP_HEIGHT / 2;
	
	
	
	//�����ڲ����ڰ�ť
	private JButton borrow;
	private JButton chart;
	private JButton book;
	private JButton user;
	private JButton reader;
	private JButton ticket;
	private String UserID;
	
	private JPanel panel;	//��ť���
	
	
	public void initDesktop() {
		desktop.setDragMode(JDesktopPane.LIVE_DRAG_MODE);//�����ڲ�������϶�ģʽΪ�϶�ʱ�����ػ�
	}
	
	public void initPanel(){
		borrow = new JButton("�軹����");
		chart = new JButton("ͼ��鿴");
		book = new JButton("ͼ�����");
		user = new JButton("�û�����");
		reader = new JButton("���߹���");
		ticket = new JButton("��������");
		
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
		
		initDesktop();			//��ʼ����������
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "ͼ�����") {
			initInternalFrame(new BookFrame(UserID));
		}else if(arg0.getActionCommand() == "�û�����") {
			initInternalFrame(new UserFrame());
		}else if(arg0.getActionCommand() == "�軹����") {
			initInternalFrame(new mainBorrow());
		}else if(arg0.getActionCommand() == "ͼ��鿴") {
			initInternalFrame(new mainChart());
		}else if(arg0.getActionCommand() == "���߹���") {
			initInternalFrame(new ReaderFrame());
		}else if(arg0.getActionCommand() == "��������") {
			
		}
	}
	
	
	//��������������ڲ�����
	private void initInternalFrame(JInternalFrame frame) {
		desktop.add(frame);
		frame.reshape(nextFrameX, nextFrameY, width, height);
		frame.show();
		initFrameLocation();
	}
	
	//������һ�����ڵ�λ��
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
		frame.setLocationRelativeTo(null);					//���ô��������ʾ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����˳�ͬʱ�رս���
		frame.setVisible(true);
		frame.getContentPane().add(panel,BorderLayout.NORTH);
		frame.getContentPane().add(desktop,BorderLayout.CENTER);
	}
	
	
	public MainFrame(String userID) {
		initPanel();
		frame.add(desktop);
		frame.setSize(DESKTOP_WIDTH, DESKTOP_HEIGHT);
		frame.setLocationRelativeTo(null);					//���ô��������ʾ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����˳�ͬʱ�رս���
		frame.setVisible(true);
		frame.getContentPane().add(panel,BorderLayout.NORTH);
		frame.getContentPane().add(desktop,BorderLayout.CENTER);
		this.UserID = userID;
	}
}
