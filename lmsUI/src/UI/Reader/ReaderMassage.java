package UI.Reader;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import UITool.User_ReaderAbsoluteMassageFrame;
import pojo.ReaderInfo;

public class ReaderMassage extends User_ReaderAbsoluteMassageFrame{

	
	private JPanel readerPanel;
	private JLabel sexLb;
	private JLabel createDataLb;
	private JLabel moneyLb;
	private JLabel maxNumLb;
	private JLabel nowNumLb;
	
	
	public ReaderMassage() {
		initReaderPanel();
	}
	
	
	public ReaderMassage(ReaderInfo reader) {
		initReaderPanel();
		setReaderData(reader);
	}
	
	
	public void initReaderPanel() {
		sexLb = new JLabel("�Ա���");
		createDataLb = new JLabel("�쿨���ڣ�2019-06-15");
		moneyLb = new JLabel("Ѻ��200");
		maxNumLb = new JLabel("���ɽ��鼮��5");
		nowNumLb = new JLabel("�ѽ��鼮��2");
		
		readerPanel = new JPanel(new GridLayout(5, 1));
		readerPanel.add(sexLb);
		readerPanel.add(createDataLb);
		readerPanel.add(moneyLb);
		readerPanel.add(maxNumLb);
		readerPanel.add(nowNumLb);
		
		mainpanel.add(readerPanel);
	}
	
	
	private void setReaderData(ReaderInfo reader) {
		IDLb.setText(reader.getReaderID());
		nameLb.setText(reader.getName());
		birthdayLb.setText(reader.getBirthday());
		sexLb.setText(reader.getSex());
		createDataLb.setText(reader.getCreateDate());
		moneyLb.setText(reader.getMoney());
		maxNumLb.setText(reader.getMaxNum());
		nowNumLb.setText(reader.getNowNum());
		telephoneLb.setText(reader.getTelephone());
		addressLb.setText(reader.getAddress());
	}
	
}
