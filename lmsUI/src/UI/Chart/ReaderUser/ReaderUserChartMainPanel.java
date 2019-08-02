package UI.Chart.ReaderUser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;


@SuppressWarnings("serial")
public class ReaderUserChartMainPanel extends JPanel{
	
	protected JPanel mainPanel;
	protected JPanel chartPanel;
	protected JPanel radioPanel;
	private String[] chartType = {"��״ͼ","��״ͼ","����ͼ"};
	
	
	
	
	
	
	public ReaderUserChartMainPanel() {
		mainPanel = new JPanel(new BorderLayout());
		
		chartPanel = new JPanel();
		chartPanel.add(new BarChart().getPanel(),BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(chartPanel);
		mainPanel.add(initRadioPanel(radioPanel), BorderLayout.NORTH);
		mainPanel.add(scrollPane,BorderLayout.CENTER);
	}
	
	public JPanel getPanel() {
		return mainPanel;
	}

	
	public JPanel initRadioPanel(JPanel radioPanel) {
		if (radioPanel == null) {	radioPanel = new JPanel();	}
		ChangeAction action = new ChangeAction();
		radioPanel.add(new ButtonPanel(action, "��ʾͼ������", chartType));
		return radioPanel;
	}
	
	
	
	
	class ChangeAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JRadioButton source = (JRadioButton)e.getSource();
			String selection = source.getActionCommand();
			if (selection.equals(chartType[0])) {
				chartPanel.removeAll();
				chartPanel.add(new BarChart().getPanel());
				chartPanel.updateUI();
			}else if(selection.equals(chartType[1])) {
				chartPanel.removeAll();
				chartPanel.add(new PieChart().getPanel());
				chartPanel.updateUI();
			}else if (selection.equals(chartType[2])) {
				chartPanel.removeAll();
				chartPanel.add(new LineChart().getPanel());
				chartPanel.updateUI();
			}
		}
	}
	
	
	/**
	 * JPanel��չ�࣬����������JRadioButton�ؼ�
	 * �ҿ���ָ��һ���ַ�����ΪtitleBorder
	 * @author Horton
	 *
	 */
	class ButtonPanel extends JPanel{
		@SuppressWarnings("unused")
		private ButtonGroup group;
		public ButtonPanel(ReaderUserChartMainPanel.ChangeAction action,String title,String[] labels) {
			setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),title));
			setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			group = new ButtonGroup();
			for(int i = 0;labels != null && i < labels.length;i++) {
				JRadioButton button = new JRadioButton(labels[i]);
				button.setActionCommand(labels[i]);
				add(button);
				button.addActionListener(action);
				group.add(button);
				button.setSelected(i == 0);
			}
			
		}
	}

}
