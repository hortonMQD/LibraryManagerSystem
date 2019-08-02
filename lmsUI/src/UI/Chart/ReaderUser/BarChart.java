package UI.Chart.ReaderUser;

import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartPanel;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import Bll.ReaderBll;
import Bll.UserBll;
import chart.BarChart3DFactor;
import chart.MoreBarChart3DFactor;

@SuppressWarnings("serial")
public class BarChart extends Panel{

	
	
	protected JPanel barChart;				//��Ա������
	protected JPanel SalaryBarChart;		//Ա���������
	
	
	public BarChart() {
		barChart = new MoreBarChart3DFactor("��Ա���", initBarChartDataSetTest(), "����ֶ�", "����").createPlot();
		SalaryBarChart = new BarChart3DFactor("Ա���������", initSalaryDateSetTest(), "���ʷֶ�", "���(��λ��Ԫ)").createPlot();
		
	}
	
	
	
	
	/**
	 * ��ʼ���û�����������ݼ���
	 * @return  ���س�ʼ�����û�����������ݼ���
	 */
	private CategoryDataset initSalaryDateSetTest() {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		//�������
		keyedValue.setValue("1000-2000", 12);
		keyedValue.setValue("2000-3000", 22);
		keyedValue.setValue("3000-4000", 13);
		keyedValue.setValue("4000-5000", 5);
		keyedValue.setValue("5000-6000", 6);
		keyedValue.setValue("6000-7000", 6);
		keyedValue.setValue("7000-10000", 2);
		
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("����", keyedValue);
		return dataset;
	}
	
	
	/**
	 * ��ʼ����ϵ����״ͼ���ݼ���
	 * Ա����������
	 * ������������
	 * �쿨���޽����¼���
	 * @return ���س�ʼ����Ķ�ϵ����״ͼ���ݼ���
	 */
	private CategoryDataset initBarChartDataSetTest() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String [] rowKeyes = {"������������","�쿨���������޽����¼���","Ա����������"};
		String[] columnKeyes = {"10-20","20-30","30-40","40-50","50-60","60-70","70-80","80-90","90-100"};
		dataset.addValue(100, rowKeyes[0],columnKeyes[0]);
		dataset.addValue(130, rowKeyes[0],columnKeyes[1]);
		dataset.addValue(140, rowKeyes[0],columnKeyes[2]);
		dataset.addValue(160, rowKeyes[0],columnKeyes[3]);
		dataset.addValue(110, rowKeyes[0],columnKeyes[4]);
		dataset.addValue(80, rowKeyes[0],columnKeyes[5]);
		dataset.addValue(70, rowKeyes[0],columnKeyes[6]);
		dataset.addValue(10, rowKeyes[0],columnKeyes[7]);
		dataset.addValue(20, rowKeyes[0],columnKeyes[8]);
		
		dataset.addValue(30, rowKeyes[1],columnKeyes[0]);
		dataset.addValue(40, rowKeyes[1],columnKeyes[1]);
		dataset.addValue(3, rowKeyes[1],columnKeyes[2]);
		dataset.addValue(10, rowKeyes[1],columnKeyes[3]);
		dataset.addValue(2, rowKeyes[1],columnKeyes[4]);
		dataset.addValue(1, rowKeyes[1],columnKeyes[5]);
		dataset.addValue(8, rowKeyes[1],columnKeyes[6]);
		dataset.addValue(2, rowKeyes[1],columnKeyes[7]);
		dataset.addValue(17, rowKeyes[1],columnKeyes[8]);
		
		dataset.addValue(0, rowKeyes[2],columnKeyes[0]);
		dataset.addValue(21, rowKeyes[2],columnKeyes[1]);
		dataset.addValue(32, rowKeyes[2],columnKeyes[2]);
		dataset.addValue(123, rowKeyes[2],columnKeyes[3]);
		dataset.addValue(12, rowKeyes[2],columnKeyes[4]);
		dataset.addValue(1, rowKeyes[2],columnKeyes[5]);
		dataset.addValue(0, rowKeyes[2],columnKeyes[6]);
		dataset.addValue(0, rowKeyes[2],columnKeyes[7]);
		dataset.addValue(0, rowKeyes[2],columnKeyes[8]);
		
		return dataset;
	}
	
	
	
	/**
	 * ��ʼ���û�����������ݼ���
	 * @return  ���س�ʼ�����û�����������ݼ���
	 */
	private CategoryDataset initSalaryDateSet() {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		int[] Data = new UserBll().setSalaryChartData();
		//�������
		keyedValue.setValue("1000-2000", Data[0]);
		keyedValue.setValue("2000-3000", Data[1]);
		keyedValue.setValue("3000-4000", Data[2]);
		keyedValue.setValue("4000-5000", Data[3]);
		keyedValue.setValue("5000-6000", Data[4]);
		keyedValue.setValue("6000-7000", Data[5]);
		keyedValue.setValue("7000-10000", Data[6]);
		
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("����", keyedValue);
		return dataset;
	}

	
	
	
	/**
	 * ��ʼ����ϵ����״ͼ���ݼ���
	 * Ա����������
	 * ������������
	 * �쿨���޽����¼���
	 * @return ���س�ʼ����Ķ�ϵ����״ͼ���ݼ���
	 */
	private CategoryDataset initBarChartDataSet() {
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String [] rowKeyes = {"������������","�쿨���������޽����¼���","Ա����������"};
		String[] columnKeyes = {"10-20","20-30","30-40","40-50","50-60","60-70","70-80","80-90","90-100"};
		int[] userAge = new UserBll().setAgeChartData();
		int[] readerAge = new ReaderBll().setReaderAgeChartData();
		dataset.addValue(readerAge[0], rowKeyes[0],columnKeyes[0]);
		dataset.addValue(readerAge[1], rowKeyes[0],columnKeyes[1]);
		dataset.addValue(readerAge[2], rowKeyes[0],columnKeyes[2]);
		dataset.addValue(readerAge[3], rowKeyes[0],columnKeyes[3]);
		dataset.addValue(readerAge[4], rowKeyes[0],columnKeyes[4]);
		dataset.addValue(readerAge[5], rowKeyes[0],columnKeyes[5]);
		dataset.addValue(readerAge[6], rowKeyes[0],columnKeyes[6]);
		dataset.addValue(readerAge[7], rowKeyes[0],columnKeyes[7]);
		dataset.addValue(readerAge[8], rowKeyes[0],columnKeyes[8]);
		
		dataset.addValue(30, rowKeyes[1],columnKeyes[0]);
		dataset.addValue(40, rowKeyes[1],columnKeyes[1]);
		dataset.addValue(3, rowKeyes[1],columnKeyes[2]);
		dataset.addValue(10, rowKeyes[1],columnKeyes[3]);
		dataset.addValue(2, rowKeyes[1],columnKeyes[4]);
		dataset.addValue(1, rowKeyes[1],columnKeyes[5]);
		dataset.addValue(8, rowKeyes[1],columnKeyes[6]);
		dataset.addValue(2, rowKeyes[1],columnKeyes[7]);
		dataset.addValue(17, rowKeyes[1],columnKeyes[8]);
		
		dataset.addValue(0, rowKeyes[2],columnKeyes[0]);
		dataset.addValue(userAge[0], rowKeyes[2],columnKeyes[1]);
		dataset.addValue(userAge[1], rowKeyes[2],columnKeyes[2]);
		dataset.addValue(userAge[2], rowKeyes[2],columnKeyes[3]);
		dataset.addValue(userAge[3], rowKeyes[2],columnKeyes[4]);
		dataset.addValue(userAge[4], rowKeyes[2],columnKeyes[5]);
		dataset.addValue(0, rowKeyes[2],columnKeyes[6]);
		dataset.addValue(0, rowKeyes[2],columnKeyes[7]);
		dataset.addValue(0, rowKeyes[2],columnKeyes[8]);
		
		return dataset;
	}
	
	
	public JScrollPane getPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 1));
		panel.add(barChart);
		panel.add(SalaryBarChart);
		JScrollPane scrollPane = new JScrollPane(panel);
		return scrollPane;
	}
	
}
