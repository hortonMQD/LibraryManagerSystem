package UITool;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class User_Reader_AbsoluteAddUpdateFrame extends JFrame{
	
	protected JFrame frame;
	protected JPanel mainpanel;		
	protected JPanel imagePanel;		//��Ƭ���

	protected JPanel btPanel;			//��ť���
	
	protected JButton confirm;			//ȷ�ϰ�ť
	protected JButton cancel;			//ȡ����ť
	
	protected JLabel imageLb;			//��Ƭ��ǩ
	protected JButton imageBt;			//�����Ƭ��ť
	protected JTextField IDTf;			//����ı���
	protected JTextField nameTf;		//�����ı���
	protected JTextField birthdayTf;	//���������ı���
	protected JTextField telephoneTf;	//��ϵ�绰�ı���
	protected JTextField addressTf;		//��ַ�ı���
	
	
	public User_Reader_AbsoluteAddUpdateFrame() {
		//initImagePanel();
		initMainPanel();
		initBtPanel();
		
		frame = new JFrame();					//��������
		//frame.getContentPane().add(imagePanel, BorderLayout.NORTH);
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		frame.getContentPane().add(btPanel, BorderLayout.SOUTH);
		
		frame.setResizable(false);					//���������ɵ�����С
		frame.setLocationRelativeTo(null);			 //���ô��������ʾ
		frame.setSize(400, 300);    				 //���ô����С
		frame.setVisible(true);						 //���ô���ɼ�
	}
	
	
	
	/**
	 * ��ʼ����Ƭ���
	 */
	private void initImagePanel() {
		imageLb = new JLabel();
		imageBt = new JButton("���ѡ��ͼƬ");
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.setSize(200, 220);
		panel.add(imageLb);
		panel.add(imageBt);
		imagePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout)imagePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		imagePanel.add(panel);
	}
	
	
	
	private void initBtPanel() {
		confirm = new JButton("ȷ   ��");
		cancel = new JButton("ȡ   ��");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btPanel = new JPanel(new GridLayout(1, 2));
		btPanel.add(confirm);
		btPanel.add(cancel);
	}
	
	
	
	/**
	 * ��ʼ�������
	 */
	private void initMainPanel() {
		JLabel IDLb = new JLabel("��        �ţ�");			//��ű�ǩ
		JLabel nameLb = new JLabel("��        ����");			//������ǩ
		JLabel birthdayLb = new JLabel("�������ڣ�");		//�������ڱ�ǩ
		JLabel telephoneLb = new JLabel("��ϵ�绰��");		//��ϵ�绰��ǩ
		JLabel addressLb = new JLabel("ͨѶ��ַ��");		//��ַ��ǩ
		
		IDTf = new JTextField();
		IDTf.setColumns(20);
		nameTf = new JTextField();
		nameTf.setColumns(20);
		birthdayTf = new JTextField();
		birthdayTf.setColumns(20);
		telephoneTf = new JTextField();
		telephoneTf.setColumns(20);
		addressTf = new JTextField();
		addressTf.setColumns(20);
		
		JPanel northPanel = new JPanel(new GridLayout(5, 1));
		northPanel.add(addPanel(IDTf, IDLb));
		northPanel.add(addPanel(nameTf, nameLb));
		northPanel.add(addPanel(telephoneTf, telephoneLb));
		northPanel.add(addPanel(birthdayTf, birthdayLb));
		northPanel.add(addPanel(addressTf, addressLb));
		
		mainpanel = new JPanel(new GridLayout(2, 1));
		mainpanel.add(northPanel);
	}
	
	
	
	protected JPanel addPanel(JComboBox<String> comboBox,JLabel label) {
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(comboBox);
		return panel;
	}
	
	
	protected JPanel addPanel(JTextField textField,JLabel label) {
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(textField);
		return panel;
	}
	
}
