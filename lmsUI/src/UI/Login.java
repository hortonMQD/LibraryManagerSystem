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
	
	private JButton ok;			//确定按钮
	private JButton cancel;		//取消按钮
	private JLabel idLb;		//用户名标签
	private JLabel pdLb;		//密码标签
	private JLabel identityLb;	//登陆身份选择标签
	
	
	
	private JTextField id;		//用户名输入框
	private JTextField pd;		//密码输入框
	private JComboBox<String> Identity;	//登陆身份下拉框
	
	
	private JPanel accountPanel;	//用户名、密码容器
	private JPanel buttonPanel;		//按钮容器
	
	public Login() {
		accountPanel = initAccountPanel(accountPanel);			//初始化文本框容器
		buttonPanel = initButtonPanel(buttonPanel);				//初始按钮容器
		
		loginWin = new JFrame("图书馆管理系统");
		loginWin.setVisible(true);								//设置窗体显示
		loginWin.setSize(300, 150);								//设置窗体大小
		loginWin.setLocationRelativeTo(null);					//设置窗体居中显示
		loginWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//点击退出同时关闭进程
		loginWin.setResizable(false);   						//设置窗体大小锁定
		
		loginWin.getContentPane().add(accountPanel,BorderLayout.NORTH);		//加载文本框容器
		loginWin.getContentPane().add(buttonPanel, BorderLayout.SOUTH);		//加载按钮容器
	}
	
	
	/**
	 * 初始化文本框容器
	 * @param panel	文本框容器
	 * @return 返回初始化后的文本框容器
	 */
	private JPanel initAccountPanel(JPanel panel) {
		if(panel == null) { panel = new JPanel(); }
		
		
		idLb = new JLabel("用户名：");
		pdLb = new JLabel("密    码：");
		identityLb = new JLabel("权  限：");
		
		id = new JTextField();
		pd = new JTextField();
		
		
		Vector<String> identityList = new Vector<>();
		identityList.add("馆长");
		identityList.add("职员");
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
	 * 初始化按钮容器
	 * @param panel 按钮容器
	 * @return	返回初始化后的按钮容器
	 */
	private JPanel initButtonPanel(JPanel panel) {
		if(panel == null) { panel = new JPanel(); }
		
		ok = new JButton("确  定");
		cancel = new JButton("取  消");
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
		panel.add(ok);
		panel.add(cancel);
		
		return panel;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand() == "确  定") {
			if (id.getText().trim().length() != 0 && pd.getText().trim().length() != 0) {
				Object result = new UserBll().Login(id.getText(), pd.getText(), Identity.getSelectedItem().toString());
				if (result instanceof Boolean) {
					JOptionPane.showMessageDialog(null,"请正确填写用户名、密码","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
					pd.setText("");
				} else {
					String userID = (String)result;
					loginWin.hide();
					new MainFrame(userID);
				}
			} else {
				JOptionPane.showMessageDialog(null,"请填写用户名、密码","提示消息",JOptionPane.WARNING_MESSAGE); //弹出提示信息
			}
			
		}else if(arg0.getActionCommand() == "取  消") {
			loginWin.dispose();
		}
	}
	

	public static void main(String[] args) {
		new Login();
	}
	
	
}
