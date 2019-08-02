package UI.Chart.ReaderUser;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import Bll.ReaderBll;
import Bll.UserBll;
import chart.PieChart3DFactor;

public class PieChart extends JPanel{
	
	protected JPanel ReaderAgePiePanel;
	protected JPanel ReaderNoBorrowPanel;
	protected JPanel UserAgePiePanel;
	protected JPanel UserSalaryPiePanel;
	protected JPanel piePanel;
	
	public PieChart() {
		ReaderAgePiePanel = new PieChart3DFactor("�����������", initReaderAgeDatasetTest()).createPiePlot();
		ReaderNoBorrowPanel = new PieChart3DFactor("�޽����¼�����������",initReaderNoBorrowAgeDatasetTest()).createPiePlot();
		UserSalaryPiePanel = new PieChart3DFactor("�û��������", initSalaryDatasetTest()).createPiePlot();
		UserAgePiePanel = new PieChart3DFactor("�û��������", initUserAgeDatasetTest()).createPiePlot();
	}
	
	
	public JScrollPane getPanel() {
		piePanel = new JPanel(new GridLayout(4, 1));
		piePanel.add(ReaderAgePiePanel);
		piePanel.add(ReaderNoBorrowPanel);
		piePanel.add(UserAgePiePanel);
		piePanel.add(UserSalaryPiePanel);
		JScrollPane panel = new JScrollPane(piePanel);
		return panel;
	}
	
	/**
	 * ��ʼ����������������ݼ���
	 * @return	���س�ʼ�����������������ݼ���
	 */
	private  PieDataset initReaderAgeDataset() { 
		DefaultPieDataset dataset = new DefaultPieDataset();
		int[] readerAge = new ReaderBll().setReaderAgeChartData();
		//�������
		dataset.setValue("10-20", readerAge[0]);
		dataset.setValue("20-30", readerAge[1]);
		dataset.setValue("30-40", readerAge[2]);
		dataset.setValue("40-50", readerAge[3]);
		dataset.setValue("50-60", readerAge[4]);
		dataset.setValue("60-70", readerAge[5]);
		dataset.setValue("70-80", readerAge[6]);
		dataset.setValue("80-90", readerAge[7]);
		dataset.setValue("90-100", readerAge[8]);
		return dataset;
	}
	
	/**
	 * ��ʼ���û�����������ݼ���
	 * @return	���س�ʼ�����û�����������ݼ���
	 */
	private  PieDataset initUserAgeDataset() { 
		DefaultPieDataset dataset = new DefaultPieDataset();
		int[] userAge = new UserBll().setAgeChartData();
		//�������
		dataset.setValue("20-30", userAge[0]);
		dataset.setValue("30-40", userAge[1]);
		dataset.setValue("40-50", userAge[2]);
		dataset.setValue("50-60", userAge[3]);
		dataset.setValue("60-70", userAge[4]);
		return dataset;
	}
	

	
	/**
	 * ��ʼ���û�����������ݼ���
	 * @return  ���س�ʼ�����û�����������ݼ���
	 */
	private PieDataset initSalaryDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		int[] userSalary = new UserBll().setSalaryChartData();

		//�������
		dataset.setValue("1000-2000", userSalary[0]);
		dataset.setValue("2000-3000", userSalary[1]);
		dataset.setValue("3000-4000", userSalary[2]);
		dataset.setValue("4000-5000", userSalary[3]);
		dataset.setValue("5000-6000", userSalary[4]);
		dataset.setValue("6000-7000", userSalary[5]);
		dataset.setValue("7000-10000", userSalary[6]);
		return dataset;
	}
	
	
	/**
	 * ��ʼ�������޽����¼������ݼ���
	 * @return	���س�ʼ��������޽����¼������ݼ���
	 */
	private  PieDataset initReaderNoBorrowAgeDataset() { 
		DefaultPieDataset dataset = new DefaultPieDataset();
		//�������
		dataset.setValue("10-20", 100);
		dataset.setValue("20-30", 10);
		dataset.setValue("30-40", 20);
		dataset.setValue("40-50", 30);
		dataset.setValue("50-60", 50);
		dataset.setValue("60-70", 60);
		dataset.setValue("70-80", 60);
		dataset.setValue("80-90", 60);
		dataset.setValue("90-100", 60);
		return dataset;
	}
	
	
	/**
	 * ��ʼ����������������ݼ���
	 * @return	���س�ʼ�����������������ݼ���
	 */
	private  PieDataset initReaderAgeDatasetTest() { 
		DefaultPieDataset dataset = new DefaultPieDataset();
		//�������
		dataset.setValue("10-20", 300);
		dataset.setValue("20-30", 100);
		dataset.setValue("30-40", 220);
		dataset.setValue("40-50", 130);
		dataset.setValue("50-60", 500);
		dataset.setValue("60-70", 600);
		dataset.setValue("70-80", 600);
		dataset.setValue("80-90", 600);
		dataset.setValue("90-100", 600);
		return dataset;
	}
	
	
	
	/**
	 * ��ʼ���û�����������ݼ���
	 * @return	���س�ʼ�����û�����������ݼ���
	 */
	private  PieDataset initUserAgeDatasetTest() { 
		DefaultPieDataset dataset = new DefaultPieDataset();
		//�������
		dataset.setValue("20-30", 10);
		dataset.setValue("30-40", 22);
		dataset.setValue("40-50", 13);
		dataset.setValue("50-60", 5);
		dataset.setValue("60-70", 6);
		return dataset;
	}
	
	
	
	
	/**
	 * ��ʼ���û�����������ݼ���
	 * @return  ���س�ʼ�����û�����������ݼ���
	 */
	private PieDataset initSalaryDatasetTest() {
		DefaultPieDataset dataset = new DefaultPieDataset();

		//�������
		dataset.setValue("1000-2000", 10);
		dataset.setValue("2000-3000", 22);
		dataset.setValue("3000-4000", 13);
		dataset.setValue("4000-5000", 5);
		dataset.setValue("5000-6000", 6);
		dataset.setValue("6000-7000", 6);
		dataset.setValue("7000-10000", 2);
		return dataset;
	}
	
	
	/**
	 * ��ʼ�������޽����¼������ݼ���
	 * @return	���س�ʼ��������޽����¼������ݼ���
	 */
	private  PieDataset initReaderNoBorrowAgeDatasetTest() { 
		DefaultPieDataset dataset = new DefaultPieDataset();
		//�������
		dataset.setValue("10-20", 100);
		dataset.setValue("20-30", 10);
		dataset.setValue("30-40", 20);
		dataset.setValue("40-50", 30);
		dataset.setValue("50-60", 50);
		dataset.setValue("60-70", 60);
		dataset.setValue("70-80", 60);
		dataset.setValue("80-90", 60);
		dataset.setValue("90-100", 60);
		return dataset;
	}
	
	
	
	
}
