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
		frame = new JInternalFrame();					//创建窗口
		setTitle("图表查看");
		setResizable(true);		//允许自由调整大小
		setClosable(true);		//提供关闭按钮
		setIconifiable(true);	//提供图表化按钮
		setMaximizable(true);	//提供最大化按钮
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();
		panel.add(new JButton());
		panel.add(new JButton());
		panel.add(new JButton());
		panel.add(new JButton());
		panel.add(new JButton());
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("人员图表", new ReaderUserChartMainPanel().getPanel());
		tabbedPane.addTab("书籍图表",  new BookChartMainPanel().getPanel());
		
		
		frame.setVisible(true);

	
	}

}
