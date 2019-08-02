package UI.Chart;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import UI.Chart.Book.BookChartMainPanel;
import UI.Chart.ReaderUser.ReaderUserChartMainPanel;

public class mainChart extends JInternalFrame{
	
	protected JTabbedPane tabbedPane;
	protected JInternalFrame frame;
	
	public mainChart() {
		frame = new JInternalFrame();					//��������
		setTitle("ͼ��鿴");
		setResizable(true);		//�������ɵ�����С
		setClosable(true);		//�ṩ�رհ�ť
		setIconifiable(true);	//�ṩͼ����ť
		setMaximizable(true);	//�ṩ��󻯰�ť
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();
		panel.add(new JButton());
		panel.add(new JButton());
		panel.add(new JButton());
		panel.add(new JButton());
		panel.add(new JButton());
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("��Աͼ��", new ReaderUserChartMainPanel().getPanel());
		tabbedPane.addTab("�鼮ͼ��",  new BookChartMainPanel().getPanel());
		
		
		frame.setVisible(true);

	
	}

}
