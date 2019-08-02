package UI.Chart.Book;

import java.awt.Panel;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import Bll.BookBll;
import chart.BarChart3DFactor;

public class BarChart extends Panel{

	
	
	protected JPanel barChart;
	protected CategoryDataset dataset;
	
	public BarChart() {
		
		barChart = new BarChart3DFactor("�ݲ�ͼ�����", initDateSetTest(dataset), "����", "�ݲ���(��λ����)").createPlot();
	}
	
	
	/**
	 * ��ʼ���ݲ�ͼ����״ͼ����
	 * @param dataset	���ݼ���
	 * @return	 ���س�ʼ����ݲ�ͼ����״ͼ���
	 */
	private CategoryDataset initDateSetTest(CategoryDataset dataset) {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		
		//�������
		keyedValue.addValue("�����ѧ��", 300);
		keyedValue.addValue("��Ȼ������", 100);
		keyedValue.addValue("�������ѧ��", 220);
		keyedValue.addValue("������", 130);
		keyedValue.addValue("��ѧ��", 500);
		keyedValue.addValue("��Ȼ������", 600);
		keyedValue.addValue("��ʷ����", 600);
		
		dataset = DatasetUtilities.createCategoryDataset("�ݲ�ͼ��", keyedValue);
		return dataset;
	}
	
	
	
	/**
	 * ��ʼ���ݲ�ͼ����״ͼ����
	 * @param dataset	���ݼ���
	 * @return	 ���س�ʼ����ݲ�ͼ����״ͼ���
	 */
	private CategoryDataset initDateSet(CategoryDataset dataset) {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		int[] data = new BookBll().ChartData();
		//�������
		keyedValue.addValue("�����ѧ��", data[0]);
		keyedValue.addValue("��Ȼ������", data[1]);
		keyedValue.addValue("�������ѧ��", data[2]);
		keyedValue.addValue("������", data[3]);
		keyedValue.addValue("��ѧ��", data[4]);
		keyedValue.addValue("��Ȼ������", data[5]);
		keyedValue.addValue("��ʷ����", data[6]);
		
		dataset = DatasetUtilities.createCategoryDataset("�ݲ�ͼ��", keyedValue);
		return dataset;
	}
	
	
	public JPanel getPanel() {
		return barChart;
	}
	
	private static CategoryDataset getCategoryDataset() {

		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1��", 310);
		keyedValues.addValue("2��", 489);
		keyedValues.addValue("3��", 512);
		keyedValues.addValue("4��", 589);
		keyedValues.addValue("5��", 359);
		keyedValues.addValue("6��", 402);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"JAVAͼ��", keyedValues);
		return dataset;
	}

	
	
}
