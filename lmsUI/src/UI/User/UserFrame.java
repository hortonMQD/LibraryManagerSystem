package UI.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Bll.UserBll;
import UITool.Reader_User_Book_AbsoluteManagerWin;
import pojo.UserInfo;

@SuppressWarnings("serial")
public class UserFrame  extends Reader_User_Book_AbsoluteManagerWin implements ActionListener{

	
	public UserFrame() {
		super();
		setTitle("�û�����");
		initCombox();
		//initTableDateTest();
		initTableDate();
		addBT.addActionListener(this);
		updateBT.addActionListener(this);
		deleteBT.addActionListener(this);
		selectBT.addActionListener(this);
		flashBT.addActionListener(this);
		infoTable.addMouseListener(new MouseAdapter() {	//	����������¼�����
			public void mouseClicked(MouseEvent e) {//�������ʱ
				if(e.getClickCount() == 2) {		//��������˫���¼�
					String userID = (String)infoTable.getValueAt(infoTable.getSelectedRow(), 1);//��ȡѡ���еĵڶ������ݣ���ֵΪUserID
					UserInfo user = new UserBll().SelectUser(userID, "���").get(0);
					new UserMassage(user);
				}//if������
			}//mouseClicked()����
		});//addMouseListener()����
	}
	
	
	
	/**
	 * ��ʼ���û���Ϣ�������
	 */
	private void initTableDateTest() {
		DefaultTableModel date = initDataModel(initDate());
		infoTable.setModel(date);
	}
	
	
	/**
	 * ��ʼ���û���Ϣ����
	 */
	private void initTableDate() {
		List<UserInfo> users = new UserBll().SelectAllUser();
		DefaultTableModel date = initDataModel(users);
		infoTable.setModel(date);
	}
	
	
	/**
	 * ��ʼ������ ����������
	 */
	private void initCombox() {
		String Data[] = new String[] { "����","���"};	//����������
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// ��������������ģ��
		selectCB.setModel(surchComboBoxModel);		//������ģ�ͼ��ص���������
	}
	
	
	
	//��ʼ���������(������)
	private List<UserInfo> initDate(){
		List<UserInfo> date = new ArrayList<>();
		for(int i = 0;i<100;i++) {
			UserInfo Info = new UserInfo();
			Info.setName("����");
			Info.setSex("��");
			Info.setIdentity("�ݳ�");
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
	private DefaultTableModel initDataModel(List<UserInfo> DateList) {
		int Count = DateList.size();			//��ȡ�����е�ѧ������
		String[] columnNames = {"���","�û����","����","����","Ȩ��","��ϵ�绰"};//��������������
		String[][] tableValues = new String[Count][6];//���������������
		for(int i = 0;i < Count;i++) {//�������������
			UserInfo Date = DateList.get(i);//��ȡ���û�����
			int count = i+1;
			tableValues[i][0] = "" + count;//��һ��Ϊ���
			tableValues[i][1] = "" + Date.getUserID();//�ڶ���Ϊ�û����
			tableValues[i][2] = "" + Date.getName();//������Ϊ����
			tableValues[i][3] = "" + Date.getSalary();//������Ϊ����
			tableValues[i][4] = "" + Date.getIdentity();//������Ϊ��½Ȩ��
			tableValues[i][5] = "" + Date.getTelephone();//������Ϊ��ϵ�绰
		}
		DefaultTableModel tmp = new DefaultTableModel(tableValues,columnNames);//��������������������鴴���������ģ��
		return tmp;
	}

	
	/**
	 * ��ȡ�����ϸ��Ϣ
	 * @return  ���ر����Ϣ���ݼ���
	 */
	private List<UserInfo> getTableDate(){
		List<UserInfo> date = new ArrayList<>();
		
		
		return date;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand() == "�� ��") {
			new UserAdd();
		}else if(arg0.getActionCommand() == "�� ��") {
			new UserUpdate((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
		}else if(arg0.getActionCommand() == "ɾ ��") {
			boolean result = new UserBll().Delete((String)infoTable.getValueAt(infoTable.getSelectedRow(), 1));
			if (result) {
				JOptionPane.showMessageDialog(null,"�����ɹ�","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
				initTableDate();
			}else {
				JOptionPane.showMessageDialog(null,"����ʧ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}
		}else if(arg0.getActionCommand() == "ˢ ��") {
			initTableDate();
		}else if (arg0.getActionCommand() == "����") {
			String message = selectTF.getText();
			String selectType = selectCB.getSelectedItem().toString();
			List<UserInfo> users = new UserBll().SelectUser(message, selectType);
			infoTable.setModel(initDataModel(users));
		}
	}
	
}
