package UITool;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class User_ReaderAbsoluteMassageFrame extends JFrame{

	protected JFrame frame;
	protected JPanel mainpanel;		
	protected JPanel imagePanel;		//��Ƭ���

	protected JPanel btPanel;			//��ť���
	
	protected JButton close;			//�رհ�ť
	
	protected JLabel imageLb;			//��Ƭ��ǩ
	protected JLabel IDLb;				//��ű�ǩ
	protected JLabel nameLb;			//������ǩ
	protected JLabel birthdayLb;		//�������ڱ�ǩ
	protected JLabel telephoneLb;		//��ϵ�绰��ǩ
	protected JLabel addressLb;			//��ַ��ǩ
	
	
	
	public User_ReaderAbsoluteMassageFrame() {
		initMainPanel();
		frame = new JFrame();
		frame.setLocationRelativeTo(null);			 //���ô��������ʾ
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		frame.setSize(400, 300);
		frame.setVisible(true);
		
		
	}
	
	/**
	 * ��ʼ�������
	 */
	private void initMainPanel() {
		IDLb = new JLabel("��        �ţ�17010001");			//��ű�ǩ
		nameLb = new JLabel("��        ����·����");			//������ǩ
		birthdayLb = new JLabel("�������ڣ�1998-10-20");		//�������ڱ�ǩ
		telephoneLb = new JLabel("��ϵ�绰��17328264138");		//��ϵ�绰��ǩ
		addressLb = new JLabel("ͨѶ��ַ��������ѧԺ");		//��ַ��ǩ
		
		JPanel northPanel = new JPanel(new GridLayout(5, 1));
		northPanel.add(IDLb);
		northPanel.add(nameLb);
		northPanel.add(telephoneLb);
		northPanel.add(birthdayLb);
		northPanel.add(addressLb);
		
		mainpanel = new JPanel(new GridLayout(2, 1));
		mainpanel.add(northPanel);
	}
	
	
	/**
	 * ��ʼ����Ƭ���
	 */
	private void initImagePanel() {
		imageLb = new JLabel();
		JPanel panel = new JPanel(new GridLayout(1, 1));
		panel.setSize(200, 220);
		panel.add(imageLb);
		imagePanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout)imagePanel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		imagePanel.add(panel);
	}
	
	
	private void initBtPanel() {
		close = new JButton("��   ��");
		close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout)btPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.CENTER);
		btPanel.add(close);
	}
}
