package UI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

import Bll.UserBll;



@SuppressWarnings("serial")
public class Login extends JFrame implements ActionListener{
	
	
	private JFrame loginWin;	
	
	private JButton ok;			//ȷ����ť
	private JButton cancel;		//ȡ����ť
	private JLabel idLb;		//�û�����ǩ
	private JLabel pdLb;		//�����ǩ
	private JLabel identityLb;	//��½���ѡ���ǩ
	
	
	
	private JTextField id;		//�û��������
	private JTextField pd;		//���������
	private JComboBox<String> Identity;	//��½���������
	
	
	private JPanel accountPanel;	//�û�������������
	private JPanel buttonPanel;		//��ť����
	
	public Login() {
		accountPanel = initAccountPanel(accountPanel);			//��ʼ���ı�������
		buttonPanel = initButtonPanel(buttonPanel);				//��ʼ��ť����
		
		loginWin = new JFrame("ͼ��ݹ���ϵͳ");
		loginWin.setVisible(true);								//���ô�����ʾ
		loginWin.setSize(300, 150);								//���ô����С
		loginWin.setLocationRelativeTo(null);					//���ô��������ʾ
		loginWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����˳�ͬʱ�رս���
		loginWin.setResizable(false);   						//���ô����С����
		
		loginWin.getContentPane().add(accountPanel,BorderLayout.NORTH);		//�����ı�������
		loginWin.getContentPane().add(buttonPanel, BorderLayout.SOUTH);		//���ذ�ť����
	}
	
	
	/**
	 * ��ʼ���ı�������
	 * @param panel	�ı�������
	 * @return ���س�ʼ������ı�������
	 */
	private JPanel initAccountPanel(JPanel panel) {
		if(panel == null) { panel = new JPanel(); }
		
		
		idLb = new JLabel("�û�����");
		pdLb = new JLabel("��    �룺");
		identityLb = new JLabel("Ȩ  �ޣ�");
		
		id = new JTextField();
		pd = new JTextField();
		
		
		Vector<String> identityList = new Vector<>();
		identityList.add("�ݳ�");
		identityList.add("ְԱ");
		Identity = new JComboBox<>(identityList);
		
		panel.add(idLb);
		panel.add(id);
		panel.add(pdLb);
		panel.add(pd);
		panel.add(identityLb);
		panel.add(Identity);
		
		panel.setLayout(new GridLayout(3, 2));
		return panel;
	}
	
	/**
	 * ��ʼ����ť����
	 * @param panel ��ť����
	 * @return	���س�ʼ����İ�ť����
	 */
	private JPanel initButtonPanel(JPanel panel) {
		if(panel == null) { panel = new JPanel(); }
		
		ok = new JButton("ȷ  ��");
		cancel = new JButton("ȡ  ��");
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		panel.add(ok);
		panel.add(cancel);
		
		return panel;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "ȷ  ��") {
			if (id.getText().trim().length() != 0 && pd.getText().trim().length() != 0) {
				Object result = new UserBll().Login(id.getText(), pd.getText(), Identity.getSelectedItem().toString());
				if (result instanceof Boolean) {
					JOptionPane.showMessageDialog(null,"����ȷ��д�û���������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
					pd.setText("");
				} else {
					String userID = (String)result;
					loginWin.hide();
					new MainFrame(userID);
				}
			} else {
				JOptionPane.showMessageDialog(null,"����д�û���������","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE); //������ʾ��Ϣ
			}
			
		}else if(arg0.getActionCommand() == "ȡ  ��") {
			loginWin.dispose();
		}
	}
	

	public static void main(String[] args) {
		new Login();
	}
	
	
}
