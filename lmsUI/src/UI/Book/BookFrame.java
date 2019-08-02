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
		setTitle("ͼ�����");
		initTableDate();
		initCombox();
		flashBT.addActionListener(this);
		addBT.addActionListener(this);
		updateBT.addActionListener(this);
		deleteBT.addActionListener(this);
		selectBT.addActionListener(this);
		infoTable.addMouseListener(new MouseAdapter() {	//	����������¼�����
			public void mouseClicked(MouseEvent e) {//�������ʱ
				if(e.getClickCount() == 2) {		//��������˫���¼�
					String ISBN = (String)infoTable.getValueAt(infoTable.getSelectedRow(), 1);//��ȡѡ���еĵڶ������ݣ���ֵΪUserID
					//BookInfo book = new BookBll().SelectBook(ISBN, "ISBN").get(0);
					new BookMessage(ISBN);
				}//if������
			}//mouseClicked()����
		});//addMouseListener()����
	}
	
	
	public BookFrame(String userID) {
		super();
		setTitle("ͼ�����");
		initTableDate();
		initCombox();
		flashBT.addActionListener(this);
		addBT.addActionListener(this);
		updateBT.addActionListener(this);
		deleteBT.addActionListener(this);
		selectBT.addActionListener(this);
		infoTable.addMouseListener(new MouseAdapter() {	//	����������¼�����
			public void mouseClicked(MouseEvent e) {//�������ʱ
				if(e.getClickCount() == 2) {		//��������˫���¼�
					String ISBN = (String)infoTable.getValueAt(infoTable.getSelectedRow(), 1);//��ȡѡ���еĵڶ������ݣ���ֵΪUserID
					//BookInfo book = new BookBll().SelectBook(ISBN, "ISBN").get(0);
					new BookMessage(ISBN);
				}//if������
			}//mouseClicked()����
		});//addMouseListener()����
		this.UserID = userID;
	}
	
	
	
	/**
	 * ��ʼ���鼮��Ϣ���
	 */
	private void initTableDate() {
		//DefaultTableModel date = initDataModel(initDataTest());
		DefaultTableModel date = initDataModel(initData());
		infoTable.setModel(date);
		
	}
	
	
	/**
	 * ��ʼ������ ����������
	 */
	private void initCombox() {
		String Data[] = new String[] { "ISBN","����","�ݲ�λ��"};	//����������
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// ��������������ģ��
		selectCB.setModel(surchComboBoxModel);		//������ģ�ͼ��ص���������
		
	}
	
	
	
	//��ʼ���������(������)
	private List<BookInfo> initDataTest(){
		List<BookInfo> date = new ArrayList<>();
		for(int i = 0;i<100;i++) {
			BookInfo bookInfo = new BookInfo();
			bookInfo.setName("����  ����֮��");
			bookInfo.setPublishing("�廪��ѧ������");
			bookInfo.setCreateDate("2019-07-06");
			bookInfo.setType("�����ѧ��");
			bookInfo.setLocation("ŵ�ٹݿ�˹̹����");
			bookInfo.setState("�ڹ�");
			date.add(bookInfo);
		}
		return date;
	}
	
	
	
	//��ʼ���������
	private List<BookInfo> initData(){
		List<BookInfo> date = new BookBll().SelectAllBook();
		return date;
	}
	
	
	/**
	 * �������ݼ����趨�ı������ģ��
	 * usableList �����ݼ���
	 * return �������ģ��
	 */
	private DefaultTableModel initDataModel(List<BookInfo> DateList) {
		int Count = DateList.size();			//��ȡ�����е�ѧ������
		String[] columnNames = {"���","ISBN","����","�鼮����","�ݲ�λ��","�ݲ�״̬"};//��������������
		String[][] tableValues = new String[Count][6];//���������������
		for(int i = 0;i < Count;i++) {//�������������
			BookInfo Date = DateList.get(i);//��ȡ���û�����
			int count = i+1;
			tableValues[i][0] = "" + count;//��һ��Ϊ���
			tableValues[i][1] = "" + Date.getISBN();//�ڶ���ΪISBN
			tableValues[i][2] = "" + Date.getName();//������Ϊ����
			tableValues[i][3] = "" + Date.getType();	 //������Ϊ�鼮����
			tableValues[i][4] = "" + Date.getLocation();//������Ϊ�ݲ�λ��
			tableValues[i][5] = "" + Date.getState();//������Ϊ�ݲ�״̬
		}
		DefaultTableModel tmp = new DefaultTableModel(tableValues,columnNames);//��������������������鴴���������ģ��
		return tmp;
	}

	
	/**
	 * ��ȡ�����ϸ��Ϣ
	 * @return  ���ر����Ϣ���ݼ���
	 */
	private List<BookInfo> getTableDate(){
		List<BookInfo> date = new ArrayList<>();
		
		
		return date;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand() == "�� ��") {
			new BookAdd(UserID);
		}else if(arg0.getActionCommand() == "�� ��") {
			new BookUpdate((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
		}else if(arg0.getActionCommand() == "ɾ ��") {
			boolean result = new BookBll().Delete((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
			if (result) {
				JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
				initTableDate();
			}else {
				JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}
		}else if(arg0.getActionCommand() == "ˢ ��") {
			initTableDate();
		}else if(arg0.getActionCommand() == "����") {
			String message = selectTF.getText();
			String selectType = selectCB.getSelectedItem().toString();
			List<BookInfo> books = new BookBll().SelectBook(message, selectType);
			infoTable.setModel(initDataModel(books));
		}
	}
	
}
