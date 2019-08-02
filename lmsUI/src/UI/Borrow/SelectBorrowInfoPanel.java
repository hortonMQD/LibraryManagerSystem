package UI.Borrow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Bll.BorrowBll;
import Bll.ReaderBll;
import UITool.Borrow_ReturnAbsolutePanel;
import UITool.FixedTable;
import pojo.BorrowInfo;
import pojo.ReaderInfo;

public class SelectBorrowInfoPanel extends Borrow_ReturnAbsolutePanel implements ActionListener{

	
	public SelectBorrowInfoPanel() {
		// TODO Auto-generated constructor stub
		super();
		panel.remove(lbPanel);
		panel.remove(tbPanel);
		panel.add(tbPanel,BorderLayout.CENTER);
		cancel.addActionListener(this);
		confirm.addActionListener(this);
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
		// TODO Auto-generated method stub
		if(arg0.getActionCommand() == "ȷ  ��") {
			if (readerID == null) {
				readerID = tf.getText();
				readerID = new ReaderBll().SelectReader(readerID, "�û����").get(0).getID();
				initTableDate(new BorrowBll().selectBorrow(readerID));
			}
		}else if(arg0.getActionCommand() == "ȡ  ��") {
			readerID = null;
			tf.setText("");
		}
	}

}
