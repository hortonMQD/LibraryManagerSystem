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
		frame = new JInternalFrame();					//创建窗口
		setTitle("借还管理");
		setResizable(true);		//允许自由调整大小
		setClosable(true);		//提供关闭按钮
		setIconifiable(true);	//提供图表化按钮
		setMaximizable(true);	//提供最大化按钮
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("借出管理", new BorrowPanel("asdasd").getPanel());
		tabbedPane.addTab("归还管理", new RetutnPanel("1231321").getPanel());
		tabbedPane.addTab("借书记录查询", new SelectBorrowInfoPanel().getPanel());
		
		frame.setVisible(true);

		frame.pack();
	
	}
	
	
	
	public mainBorrow(String UserID) {
		frame = new JInternalFrame();					//创建窗口
		setTitle("借还管理");
		setResizable(true);		//允许自由调整大小
		setClosable(true);		//提供关闭按钮
		setIconifiable(true);	//提供图表化按钮
		setMaximizable(true);	//提供最大化按钮
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane);
		
		tabbedPane.addTab("借出管理", new BorrowPanel(UserID).getPanel());
		tabbedPane.addTab("归还管理", new RetutnPanel(UserID).getPanel());
		tabbedPane.addTab("借书记录查询", new SelectBorrowInfoPanel().getPanel());
		
		frame.setVisible(true);

		frame.pack();
	
	}
	
	
	
	
}
