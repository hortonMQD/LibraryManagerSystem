package UI.Reader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Bll.ReaderBll;
import Bll.UserBll;
import UI.User.UserMassage;
import UITool.Reader_User_Book_AbsoluteManagerWin;
import pojo.ReaderInfo;
import pojo.UserInfo;

@SuppressWarnings("serial")
public class ReaderFrame   extends Reader_User_Book_AbsoluteManagerWin implements ActionListener{

	
	public ReaderFrame() {
		super();
		setTitle("���߹���");
		initCombox();
		initTableDate();
		addBT.addActionListener(this);
		updateBT.addActionListener(this);
		deleteBT.addActionListener(this);
		selectBT.addActionListener(this);
		flashBT.addActionListener(this);
		infoTable.addMouseListener(new MouseAdapter() {	//	����������¼�����
			public void mouseClicked(MouseEvent e) {//�������ʱ
				if(e.getClickCount() == 2) {		//��������˫���¼�
					String readerID = (String)infoTable.getValueAt(infoTable.getSelectedRow(), 1);//��ȡѡ���еĵڶ������ݣ���ֵΪreaderID
					ReaderInfo reader = new ReaderBll().SelectReader(readerID, "�û����").get(0);
					new ReaderMassage(reader);
				}//if������
			}//mouseClicked()����
		});//addMouseListener()����
	}
	
	
	/**
	 * ��ʼ���鼮��Ϣ����
	 */
	private void initTableDate() {
		DefaultTableModel date = initDataModel(new ReaderBll().SelectAllReader());
		infoTable.setModel(date);
	}
	
	
	/**
	 * ��ʼ���鼮��Ϣ����(����)
	 */
	private void initTableDateTest() {
		DefaultTableModel date = initDataModel(initDate());
		infoTable.setModel(date);
	}
	
	
	
	/**
	 * ��ʼ������ ����������
	 */
	private void initCombox() {
		String Data[] = new String[] { "����","�Ա�"};	//����������
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// ��������������ģ��
		selectCB.setModel(surchComboBoxModel);		//������ģ�ͼ��ص���������
	}
	
	
	
	//��ʼ���������(������)
	private List<ReaderInfo> initDate(){
		List<ReaderInfo> date = new ArrayList<>();
		for(int i = 0;i<100;i++) {
			ReaderInfo Info = new ReaderInfo();
			Info.setName("·����");
			Info.setSex("��");
			Info.setMaxNum("5");
			Info.setNowNum("2");
			Info.setTelephone("13828921933");
			date.add(Info);
		}
		return date;
	}
	
	
	/**
	 * �������ݼ����趨�ı������ģ��
	 * usableList �����ݼ���
	 * return �������ģ��
	 */
	private DefaultTableModel initDataModel(List<ReaderInfo> DateList) {
		int Count = DateList.size();			//��ȡ�����е�ѧ������
		String[] columnNames = {"���","���߱��","����","�Ա�","��ϵ�绰","�ɽ��鼮��Ŀ","��ǰ�ѽ���Ŀ"};//��������������
		String[][] tableValues = new String[Count][7];//���������������
		for(int i = 0;i < Count;i++) {//�������������
			ReaderInfo Date = DateList.get(i);//��ȡ���û�����
			int count = i+1;
			tableValues[i][0] = "" + count;					//��һ��Ϊ���
			tableValues[i][1] = "" + Date.getReaderID();	//�ڶ���Ϊ���߱��
			tableValues[i][2] = "" + Date.getName();		//������Ϊ����
			tableValues[i][3] = "" + Date.getSex();			//������Ϊ�Ա�
			tableValues[i][4] = "" + Date.getTelephone();	//������Ϊ��ϵ�绰
			tableValues[i][5] = "" + Date.getMaxNum();		//������Ϊ�ɽ��鼮��Ŀ
			tableValues[i][6] = "" + Date.getNowNum();		//������Ϊ��ǰ�ѽ���Ŀ
		}
		DefaultTableModel tmp = new DefaultTableModel(tableValues,columnNames);//��������������������鴴���������ģ��
		return tmp;
	}

	
	/**
	 * ��ȡ�����ϸ��Ϣ
	 * @return  ���ر����Ϣ���ݼ���
	 */
	private List<ReaderInfo> getTableDate(){
		List<ReaderInfo> date = new ArrayList<>();
		
		
		return date;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand() == "�� ��") {
			new ReaderAdd();
		}else if(arg0.getActionCommand() == "�� ��") {
			new ReaderUpdate((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
		}else if(arg0.getActionCommand() == "ɾ ��") {
			boolean result = new ReaderBll().Delete((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
			if (result) {
				JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
				initTableDate();
			}else {
				JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}
		}else if(arg0.getActionCommand() == "ˢ ��") {
			initTableDate();
		}else if (arg0.getActionCommand() == "����") {
			List<ReaderInfo> readers = new ReaderBll().SelectReader(selectTF.getText(), selectCB.getSelectedItem().toString());
			infoTable.setModel(initDataModel(readers));
		}
	}
	

}
