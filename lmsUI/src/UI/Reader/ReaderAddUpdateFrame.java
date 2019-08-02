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
	protected JComboBox<String> sexCb;		//性别下拉框
	protected JTextField moneyTf;			//押金文本框
	protected String ID;
	protected String createDate;
	
	public ReaderAddUpdateFrame() {
		super();
		initReaderPanel();
		mainpanel.add(ReaderPanel);
	}
	
	
	
	public void initReaderPanel() {
		JLabel sexLb = new JLabel("性        别");
		JLabel moneyLb = new JLabel("押        金");
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
	 * 初始化搜索 下拉框数据
	 */
	protected void initSexCombox() {
		String Data[] = new String[] { "男","女"};	//下拉框数据
		DefaultComboBoxModel surchComboBoxModel = new DefaultComboBoxModel(Data);// 创建下拉框数据模型
		sexCb.setModel(surchComboBoxModel);		//将数据模型加载到下拉框中
	}
	
	
}
