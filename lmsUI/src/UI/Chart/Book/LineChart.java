package UI.Chart.Book;

import javax.swing.JPanel;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import Bll.BookBll;
import chart.LineChartFactor;

public class LineChart extends JPanel{
	
	protected JPanel lineChart;
	protected CategoryDataset dataset;
	
	public LineChart() {
		lineChart = new LineChartFactor("�ݲ�ͼ�����", initDatesetTest(dataset), "����", "�ݲ���������λ������").createPlot();
	}
	
	
	
	
	public JPanel getPanel() {
		return lineChart;
	}
	
	
	/**
	 * ��ʼ���ݲ�ͼ������ͼ���ݣ����ԣ�
	 * @param dataset	���ݼ���
	 * @return	 ���س�ʼ����ݲ�ͼ������ͼ���
	 */
	private CategoryDataset initDatesetTest(CategoryDataset dataset) {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		
		keyedValue.addValue("�����ѧ��", 300);
		keyedValue.addValue("��Ȼ������", 100);
		keyedValue.addValue("�������ѧ��", 220);
		keyedValue.addValue("������", 130);
		keyedValue.addValue("��ѧ��", 500);
		keyedValue.addValue("��Ȼ������", 600);
		keyedValue.addValue("��ʷ����", 600);
		dataset = DatasetUtilities.createCategoryDataset("�ݲ�ͼ�����", keyedValue);
		return dataset;
	}
	
	
	/**
	 * ��ʼ���ݲ�ͼ������ͼ����
	 * @param dataset	���ݼ���
	 * @return	 ���س�ʼ����ݲ�ͼ������ͼ���
	 */
	private CategoryDataset initDateset(CategoryDataset dataset) {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		int[] data = new BookBll().ChartData();
		keyedValue.addValue("�����ѧ��", data[0]);
		keyedValue.addValue("��Ȼ������", data[1]);
		keyedValue.addValue("�������ѧ��", data[2]);
		keyedValue.addValue("������", data[3]);
		keyedValue.addValue("��ѧ��", data[4]);
		keyedValue.addValue("��Ȼ������", data[5]);
		keyedValue.addValue("��ʷ����", data[6]);
		dataset = DatasetUtilities.createCategoryDataset("�ݲ�ͼ�����", keyedValue);
		return dataset;
	}
}
