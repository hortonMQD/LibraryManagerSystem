package UI.Borrow;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class mainBorrow extends JInternalFrame{

	
	protected JTabbedPane tabbedPane;
	protected JInternalFrame frame;
	
	public mainBorrow() {
		frame = new JInternalFrame();					//��������
		setTitle("�軹����");
		setResizable(true);		//�������ɵ�����С
		setClosable(true);		//�ṩ�رհ�ť
		setIconifiable(true);	//�ṩͼ����ť
		setMaximizable(true);	//�ṩ��󻯰�ť
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("�������", new BorrowPanel("asdasd").getPanel());
		tabbedPane.addTab("�黹����", new RetutnPanel("1231321").getPanel());
		tabbedPane.addTab("�����¼��ѯ", new SelectBorrowInfoPanel().getPanel());
		
		frame.setVisible(true);

		frame.pack();
	
	}
	
	
	
	public mainBorrow(String UserID) {
		frame = new JInternalFrame();					//��������
		setTitle("�軹����");
		setResizable(true);		//�������ɵ�����С
		setClosable(true);		//�ṩ�رհ�ť
		setIconifiable(true);	//�ṩͼ����ť
		setMaximizable(true);	//�ṩ��󻯰�ť
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("�������", new BorrowPanel(UserID).getPanel());
		tabbedPane.addTab("�黹����", new RetutnPanel(UserID).getPanel());
		tabbedPane.addTab("�����¼��ѯ", new SelectBorrowInfoPanel().getPanel());
		
		frame.setVisible(true);

		frame.pack();
	
	}
	
	
	
	
}
