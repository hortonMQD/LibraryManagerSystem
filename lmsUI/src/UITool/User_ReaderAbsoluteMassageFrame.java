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
	protected JPanel imagePanel;		//相片面板

	protected JPanel btPanel;			//按钮面板
	
	protected JButton close;			//关闭按钮
	
	protected JLabel imageLb;			//相片标签
	protected JLabel IDLb;				//编号标签
	protected JLabel nameLb;			//姓名标签
	protected JLabel birthdayLb;		//出生日期标签
	protected JLabel telephoneLb;		//联系电话标签
	protected JLabel addressLb;			//地址标签
	
	
	
	public User_ReaderAbsoluteMassageFrame() {
		initMainPanel();
		frame = new JFrame();
		frame.setLocationRelativeTo(null);			 //设置窗体居中显示
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		frame.setSize(400, 300);
		frame.setVisible(true);
		
		
	}
	
	/**
	 * 初始化主面板
	 */
	private void initMainPanel() {
		IDLb = new JLabel("编        号：17010001");			//编号标签
		nameLb = new JLabel("姓        名：路明非");			//姓名标签
		birthdayLb = new JLabel("出生日期：1998-10-20");		//出生日期标签
		telephoneLb = new JLabel("联系电话：17328264138");		//联系电话标签
		addressLb = new JLabel("通讯地址：卡塞尔学院");		//地址标签
		
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
	 * 初始化相片面板
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
		close = new JButton("关   闭");
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
