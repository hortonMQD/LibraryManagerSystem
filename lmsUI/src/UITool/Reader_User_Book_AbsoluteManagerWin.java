package UITool;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class Reader_User_Book_AbsoluteManagerWin extends JInternalFrame{
	
	protected JPanel btPanel;				//��ť���
	protected JPanel selectPanel;			//�������
	protected JPanel tablePanel;			//������
	
	
	
	protected JComboBox<String> selectCB;	//����������
	protected JTextField selectTF;			//�����ı���
	protected JButton selectBT;				//������ť
	
	
	protected JButton addBT;				//��Ӱ�ť
	protected JButton deleteBT;				//ɾ����ť
	protected JButton updateBT;				//�޸İ�ť
	protected JButton flashBT;				//ˢ�°�ť
	
	
	protected String UserID;
	
	protected FixedTable infoTable;				//���
	
	protected JInternalFrame frame;				//�ڲ�����
	
	
	
	public Reader_User_Book_AbsoluteManagerWin() {
		
		btPanel = initBtPanel(btPanel);						//��ʼ����ť���
		tablePanel = initTablePanel(tablePanel);			//��ʼ��������
		selectPanel = initSelectPanel(selectPanel);			//��ʼ���������
		
		
		
		frame = new JInternalFrame();					//��������
		setResizable(true);		//�������ɵ�����С
		setClosable(true);		//�ṩ�رհ�ť
		setIconifiable(true);	//�ṩͼ����ť
		setMaximizable(true);	//�ṩ��󻯰�ť
		
		getContentPane().add(selectPanel, BorderLayout.NORTH);//����������嵽���ڶ���
		getContentPane().add(tablePanel, BorderLayout.CENTER);//���ر����嵽��������
		getContentPane().add(btPanel, BorderLayout.SOUTH);	//���ذ�ť��嵽���ڵײ�
		
		

		frame.setSize(600, 500);    				 //���ô����С
		frame.setVisible(true);						 //���ô���ɼ�
	}
	
	
	/**
	 * ��ʼ��������
	 * @param panel  �������
	 * @return  ���س�ʼ����ı�����
	 */
	private JPanel initTablePanel(JPanel panel) {
		if (panel == null) {	panel = new JPanel();  }
		
		panel.setLayout(new BorderLayout(0, 0));
		infoTable = new FixedTable();
		infoTable.setToolTipText("˫�����鿴��ϸ��Ϣ");		//���ñ����ͣ��ʾ
		JScrollPane scrollPane = new JScrollPane(infoTable);// ��������������
		infoTable.setCellEditable(false);					//�ñ�񲻿ɱ༭
		FixedTable.ColumnWidthMatchesTheContent(infoTable);	//���ñ���п�����������Ӧ


		JLabel lblNewLabel = new JLabel("��ʾ��˫�����鿴��ʾ��Ϣ��");// ��ʾ��ǩ
		panel.add(scrollPane, BorderLayout.CENTER); //�����������ı��ŵ��������м�λ��
		panel.add(lblNewLabel, BorderLayout.SOUTH); //��ʾ��ǩ�ŵ�����������λ��
		
		
		return panel;
	}
	
	
	/**
	 * ��ʼ����ť���
	 * @param panel  ��ť����
	 * @return ���س�ʼ����İ�ť���
	 */
	private JPanel initBtPanel(JPanel panel) {
		if (panel == null) {	panel = new JPanel();  }
		FlowLayout flowLayout = (FlowLayout)panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		
		addBT = new JButton("�� ��");
		deleteBT = new JButton("ɾ ��");
		updateBT = new JButton("�� ��");
		flashBT = new JButton("ˢ ��");
		
		panel.add(flashBT);
		panel.add(addBT);
		panel.add(updateBT);
		panel.add(deleteBT);
		
		return panel;
	}
	
	/**
	 * ��ʼ���������
	 * @param panel  ��������
	 * @return	���س�ʼ������������
	 */
	private JPanel initSelectPanel(JPanel panel) {
		if (panel == null) {	panel = new JPanel();  }
		FlowLayout flowLayout = (FlowLayout)panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		selectCB = new JComboBox<>();
		selectTF = new JTextField();
		selectTF.setColumns(15);
		selectBT = new JButton("����");
		
		panel.add(selectCB);
		panel.add(selectTF);
		panel.add(selectBT);
		
		return panel;
	}
}
