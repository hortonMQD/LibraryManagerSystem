package UI.Reader;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import UITool.User_Reader_AbsoluteAddUpdateFrame;
import pojo.ReaderInfo;

public class ReaderAddUpdateFrame extends User_Reader_AbsoluteAddUpdateFrame{

	
	protected JPanel ReaderPanel;
	protected JComboBox<String> sexCb;		//�Ա�������
	protected JTextField moneyTf;			//Ѻ���ı���
	protected String ID;
	protected String createDate;
	
	public ReaderAddUpdateFrame() {
		super();
		initReaderPanel();
		mainpanel.add(ReaderPanel);
	}
	
	
	
	public void initReaderPanel() {
		JLabel sexLb = new JLabel("��        ��");
		JLabel moneyLb = new JLabel("Ѻ        ��");
		sexCb = new JComboBox<>();
		initSexCombox();
		moneyTf = new JTextField();
		moneyTf.setColumns(20);
		ReaderPanel = new JPanel(new GridLayout(2, 1));
		ReaderPanel.add(addPanel(moneyTf, moneyLb));
		ReaderPanel.add(addPanel(sexCb, sexLb));
	}
	
	
	
	
	protected ReaderInfo getReaderData() {
		ReaderInfo reader = new ReaderInfo();
		reader.setReaderID(IDTf.getText());
		reader.setName(nameTf.getText());
		reader.setBirthday(birthdayTf.getText());
		reader.setTelephone(telephoneTf.getText());
		reader.setAddress(addressTf.getText());
		reader.setSex(sexCb.getSelectedItem().toString());
		reader.setMoney(moneyTf.getText());
		return reader;
	}
	
	
	
	protected void setReaderData(ReaderInfo reader) {
		IDTf.setText(reader.getReaderID());
		nameTf.setText(reader.getName());
		birthdayTf.setText(reader.getBirthday());
		telephoneTf.setText(reader.getTelephone());
		addressTf.setText(reader.getAddress());
		sexCb.setSelectedItem(reader.getSex());
		moneyTf.setText(reader.getMoney());
	}
	
	
	/**
	 * ��ʼ������ ����������
	 */
	protected void initSexCombox() {
		String Data[] = new String[] { "��","Ů"};	//����������
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// ��������������ģ��
		sexCb.setModel(surchComboBoxModel);		//������ģ�ͼ��ص���������
	}
	
	
}
