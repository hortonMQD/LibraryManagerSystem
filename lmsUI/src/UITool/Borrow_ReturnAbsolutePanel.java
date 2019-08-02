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
	
	
	protected JPanel panel;			//���������
	protected JPanel btPanel;			//�������
	protected JPanel lbPanel;			//������Ϣ���
	protected JPanel tbPanel;			//�ѽ��鼮��Ϣ���
	
	protected JTextField tf;			//��������
	protected JButton cancel;			//ȡ����ť
	protected JButton confirm;		//ȷ����ť
	
	protected JLabel id;				//���߱�ű�ǩ
	protected JLabel name;			//������ǩ
	protected JLabel sex;				//�Ա��ǩ
	protected JLabel createDate;		//�쿨���ڱ�ǩ
	protected JLabel telephone;		//��ϵ�绰��ǩ
	protected JLabel image;			//ͷ���ǩ

	protected FixedTable infoTable;	//���
	
	
	
	protected String ISBN = null;
	protected String readerID = null;
	protected String UserID = null;
	
	
	public Borrow_ReturnAbsolutePanel() {

		btPanel = initBtPanel();			//��ʼ���������
		lbPanel = initLbPanel();			//��ʼ��������Ϣ���
		tbPanel = initTbPanel();			//��ʼ���ѽ��鼮��Ϣ���
		panel = new JPanel();				//���������
		//panel.setLayout(new BorderLayout());
		panel.add(btPanel, BorderLayout.NORTH);
		panel.add(lbPanel,BorderLayout.CENTER);
		panel.add(tbPanel, BorderLayout.SOUTH);
	}
	
	
	/**
	 * ��ʼ���������
	 */
	private JPanel initBtPanel() {
		//JLabel label = new JLabel();				//��ű�ǩ
		tf = new JTextField();						//��������
		tf.setColumns(20);
		
		cancel = new JButton("ȡ  ��");				//ȡ����ť
		confirm = new JButton("ȷ  ��");				//ȷ����ť
		
		JPanel Panel = new JPanel();		//�������
		FlowLayout flowLayout = (FlowLayout)Panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		//���ؼ����ص����������
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
	 * ��ʼ��������Ϣ���
	 */
	private JPanel initLbPanel() {
		name = new JLabel("������·����");
		id = new JLabel("��ţ�17010001");
		sex = new JLabel("�Ա� ��");
		createDate = new JLabel("�쿨���ڣ�2019-10-10");
		telephone = new JLabel("��ϵ�绰��17328264138");
		//image = new JLabel();
		
		JPanel left = new JPanel(new GridLayout(5, 1));								//��ǩ���
		//JPanel right = new JPanel(new GridLayout(1, 1));							//ͷ�����
//		lbPanel = new JPanel(new GridLayout(5, 1));										//������Ϣ���
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
		
		lbPanel = new JPanel(new GridLayout(1, 2));				//������Ϣ���
		
		lbPanel.add(left);											//����ǩ�����ض�����Ϣ���
		//lbPanel.add(right);										//��ͷ�������ص�������Ϣ���
		
		return lbPanel;
	}
	
	/**
	 * ��ʼ���鼮��Ϣ���
	 */
	private JPanel initTbPanel() {
		tbPanel = new JPanel(new BorderLayout(0, 0));
		infoTable = new FixedTable();
		JScrollPane scrollPane = new JScrollPane(infoTable);// ��������������
		infoTable.setCellEditable(false);					//�ñ�񲻿ɱ༭
		initTableDate();									//��ʼ�������Ϣ
		//FixedTable.ColumnWidthMatchesTheContent(infoTable);	//���ñ���п�����������Ӧ
		tbPanel.add(scrollPane,BorderLayout.CENTER); 							//�����������ı��ŵ��������м�λ��
		return tbPanel;
	}
	
	
	//��ʼ���������(������)
    private List<BorrowInfo> initDate(){
		List<BorrowInfo> date = new ArrayList<>();
		for(int i = 0;i<3;i++) {
			BorrowInfo Info = new BorrowInfo();
			Info.setBookID("111333111333");
			Info.setBookName("����  ����֮��");
			Info.setBorrowDate("2019-10-10");
			Info.setAntipateReturn("2019-11-10");
			date.add(Info);
		}
		return date;
	}
	
	
    
    /**
     * ��ʼ��������Ϣ���
     */
    private void initTableDate() {
    	DefaultTableModel date = initDataModel(new ArrayList<BorrowInfo>());
		infoTable.setModel(date);
		FixedTable.ColumnWidthMatchesTheContent(infoTable);	//���ñ���п�����������Ӧ
	}
	
    
    /**
     * ��ʼ��������Ϣ���
     */
    protected void initTableDate(List<BorrowInfo> DateList) {
    	DefaultTableModel date = initDataModel(DateList);
		infoTable.setModel(date);
		FixedTable.ColumnWidthMatchesTheContent(infoTable);	//���ñ���п�����������Ӧ
	}
    
	
	
	/**
	 * �������ݼ����趨�ı������ģ��
	 * DateList �����ݼ���
	 * return �������ģ��
	 */
	protected DefaultTableModel initDataModel(List<BorrowInfo> DateList) {
		int Count = DateList.size();			//��ȡ�����е�ѧ������
		String[] columnNames = {"���","ISBN","�鼮����","��������","Ԥ�ƻ�������"};//��������������
		String[][] tableValues = new String[Count][5];//���������������
		for(int i = 0;i < Count;i++) {//�������������
			BorrowInfo Date = DateList.get(i);//��ȡ���û�����
			if (Date.getReturnDate() != null) {
				int count = i+1;
				tableValues[i][0] = "" + count;//��һ��Ϊ���
				tableValues[i][1] = "" + Date.getBookID();//�ڶ���ΪISBN���
				tableValues[i][2] = "" + Date.getBookName();//������Ϊ�鼮����
				tableValues[i][3] = "" + Date.getBorrowDate();//������Ϊ��������
				tableValues[i][4] = "" + Date.getAntipateReturn();//������ΪԤ�ƹ黹����
			}
		}
		DefaultTableModel tmp = new DefaultTableModel(tableValues,columnNames);//��������������������鴴���������ģ��
		return tmp;
	}
	
	
	
	
	
	
	
	protected void setReaderData(ReaderInfo info) {
		id.setText("��ţ�"+info.getReaderID());
		name.setText("������"+info.getName());
		sex.setText("�Ա�"+info.getSex());
		createDate.setText("�쿨���ڣ�"+info.getCreateDate());
		telephone.setText("��ϵ�绰��"+info.getTelephone());
	}
	
	
}
