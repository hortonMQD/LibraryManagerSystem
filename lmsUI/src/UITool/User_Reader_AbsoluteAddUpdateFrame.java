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
	protected JPanel imagePanel;		//相片面板

	protected JPanel btPanel;			//按钮面板
	
	protected JButton confirm;			//确认按钮
	protected JButton cancel;			//取消按钮
	
	protected JLabel imageLb;			//相片标签
	protected JButton imageBt;			//添加相片按钮
	protected JTextField IDTf;			//编号文本框
	protected JTextField nameTf;		//姓名文本框
	protected JTextField birthdayTf;	//出生日期文本框
	protected JTextField telephoneTf;	//联系电话文本框
	protected JTextField addressTf;		//地址文本框
	
	
	public User_Reader_AbsoluteAddUpdateFrame() {
		//initImagePanel();
		initMainPanel();
		initBtPanel();
		
		frame = new JFrame();					//创建窗口
		//frame.getContentPane().add(imagePanel, BorderLayout.NORTH);
		frame.getContentPane().add(mainpanel, BorderLayout.CENTER);
		frame.getContentPane().add(btPanel, BorderLayout.SOUTH);
		
		frame.setResizable(false);					//不允许自由调整大小
		frame.setLocationRelativeTo(null);			 //设置窗体居中显示
		frame.setSize(400, 300);    				 //设置窗体大小
		frame.setVisible(true);						 //设置窗体可见
	}
	
	
	
	/**
	 * 初始化相片面板
	 */
	private void initImagePanel() {
		imageLb = new JLabel();
		imageBt = new JButton("点击选择图片");
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
		confirm = new JButton("确   定");
		cancel = new JButton("取   消");
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
	 * 初始化主面板
	 */
	private void initMainPanel() {
		JLabel IDLb = new JLabel("编        号：");			//编号标签
		JLabel nameLb = new JLabel("姓        名：");			//姓名标签
		JLabel birthdayLb = new JLabel("出生日期：");		//出生日期标签
		JLabel telephoneLb = new JLabel("联系电话：");		//联系电话标签
		JLabel addressLb = new JLabel("通讯地址：");		//地址标签
		
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
