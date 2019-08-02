package UI.Borrow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Bll.BorrowBll;
import Bll.ReaderBll;
import UI.Book.BookAdd;
import UITool.Borrow_ReturnAbsolutePanel;
import UITool.FixedTable;
import pojo.BorrowInfo;
import pojo.ReaderInfo;



@SuppressWarnings("serial")
public class BorrowPanel extends Borrow_ReturnAbsolutePanel implements ActionListener{

		
	
	public BorrowPanel() {
		super();
		initTableDate(initDate());
		
	}
	
	
	public BorrowPanel(String userID) {
		super();
		UserID = userID;
		initTableDate(new ArrayList<BorrowInfo>());
		cancel.addActionListener(this);
		confirm.addActionListener(this);
	}
	
	
	//��ʼ���������(������)
    private List<BorrowInfo> initDate(){
		List<BorrowInfo> date = new ArrayList<>();
		for(int i = 0;i<3;i++) {
			BorrowInfo Info = new BorrowInfo();
			Info.setBookID("111333111333");
			Info.setBookName("����  ������֮ͫ");
			Info.setBorrowDate("2019-10-01");
			Info.setAntipateReturn("2019-11-01");
			date.add(Info);
		}
		return date;
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
			if (Date.getReturnDate() == null) {
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
    
    
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "ȷ  ��") {
			if (readerID == null) {
				readerID = tf.getText();
				tf.setText("");
				ReaderInfo reader = new ReaderBll().SelectReader(readerID, "�û����").get(0);
				setReaderData(reader);
				readerID = reader.getID();
			}else {
				BorrowBll bll = new BorrowBll();
				ISBN = tf.getText();
				boolean result = bll.Borrow(readerID, ISBN, UserID);
				if (result) {
					initTableDate(bll.selectBorrow(readerID));
					JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
				}else {
					JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
				}
			}
		}else if(arg0.getActionCommand() == "ȡ  ��") {
			readerID = null;
			ISBN = null;
			tf.setText("");
		}
	}
	
	
}
