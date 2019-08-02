package UI.Chart.ReaderUser;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Bll.ReaderBll;
import Bll.UserBll;
import chart.LineChartFactor;
import chart.XYLineChartFactor;

@SuppressWarnings("serial")
public class LineChart extends JPanel{
	
	protected JPanel lineChart;
	protected JPanel readerlineChart;
	protected JPanel userLineChart;
	protected XYSeriesCollection dataset;
	
	
	public LineChart() {
		readerlineChart = new XYLineChartFactor("��Ա���", initReaderDatesetTest(dataset), "�����", "��������λ������").createPlot();
		userLineChart = new LineChartFactor("Ա���������", initUserDatesetTest(), "���ʽ׶�", "Ԫ").createPlot();
	}
	
	public JScrollPane getPanel() {
		lineChart = new JPanel(new GridLayout(2, 1));
		lineChart.add(readerlineChart);
		lineChart.add(userLineChart);
		JScrollPane scrollPane = new JScrollPane(lineChart);
		return scrollPane;
	}
	

	/**
	 * ��ʼ�������������ͼ����
	 * @param dataset	���ݼ���
	 * @return	 ���س�ʼ�������������ݼ���
	 */
	private IntervalXYDataset initReaderDatesetTest(XYSeriesCollection dataset) {
		if (dataset == null) {  dataset = new XYSeriesCollection();  }
		
		final XYSeries series1 = new XYSeries("������������");
		final XYSeries series2 = new XYSeries("�쿨���������޽����¼���");
		final XYSeries series3 = new XYSeries("Ա����������");

		
		series1.add(10, 100);
		series1.add(20, 130);
		series1.add(30, 140);
		series1.add(40, 160);
		series1.add(50, 110);
		series1.add(60, 80);
		series1.add(70, 70);
		series1.add(80, 10);
		series1.add(90, 20);

		series2.add(10, 30);
		series2.add(20, 40);
		series2.add(30, 3);
		series2.add(40, 10);
		series2.add(50, 2);
		series2.add(60, 1);
		series2.add(70, 8);
		series2.add(80, 2);
		series2.add(90, 17);
		
		
		series3.add(10, 0);			//10-20
		series3.add(20, 13);		//20-30
		series3.add(30, 14);		//30-40
		series3.add(40, 16);		//40-50
		series3.add(50, 11);		//50-60
		series3.add(60, 3);			//60-70
		series3.add(70, 0);			//70-80
		series3.add(80, 0);			//80-90
		series3.add(90, 0);			//90-100


		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		
		return dataset;
	}
	
	
	/**
	 * ��ʼ���û��������ͼ����
	 * @param dataset	���ݼ���
	 * @return	 ���س�ʼ�����û�������ݼ���
	 */
	private CategoryDataset initUserDatesetTest() {
		
		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1000-2000", 3);
		keyedValues.addValue("2000-3000", 20);
		keyedValues.addValue("3000-4000", 10);
		keyedValues.addValue("4000-5000", 6);
		keyedValues.addValue("5000-6000", 8);
		keyedValues.addValue("6000-7000", 4);
		keyedValues.addValue("7000-10000", 3);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("Ա���������", keyedValues);
		
		return dataset;
	}
	
	
	
	/**
	 * ��ʼ�������������ͼ����
	 * @param dataset	���ݼ���
	 * @return	 ���س�ʼ�������������ݼ���
	 */
	private IntervalXYDataset initReaderDateset(XYSeriesCollection dataset) {
		if (dataset == null) {  dataset = new XYSeriesCollection();  }
		
		final XYSeries series1 = new XYSeries("������������");
		final XYSeries series2 = new XYSeries("�쿨���������޽����¼���");
		final XYSeries series3 = new XYSeries("Ա����������");

		int[] userAge = new UserBll().setAgeChartData();
		int[] readerAge = new ReaderBll().setReaderAgeChartData();
		series1.add(10, readerAge[0]);
		series1.add(20, readerAge[1]);
		series1.add(30, readerAge[2]);
		series1.add(40, readerAge[3]);
		series1.add(50, readerAge[4]);
		series1.add(60, readerAge[5]);
		series1.add(70, readerAge[6]);
		series1.add(80, readerAge[7]);
		series1.add(90, readerAge[8]);

		series2.add(10, 30);
		series2.add(20, 40);
		series2.add(30, 3);
		series2.add(40, 10);
		series2.add(50, 2);
		series2.add(60, 1);
		series2.add(70, 8);
		series2.add(80, 2);
		series2.add(90, 17);
		
		
		series3.add(10, 0);			//10-20
		series3.add(20, userAge[0]);		//20-30
		series3.add(30, userAge[1]);		//30-40
		series3.add(40, userAge[2]);		//40-50
		series3.add(50, userAge[3]);		//50-60
		series3.add(60, userAge[4]);			//60-70
		series3.add(70, 0);			//70-80
		series3.add(80, 0);			//80-90
		series3.add(90, 0);			//90-100


		dataset.addSeries(series1);
		dataset.addSeries(series2);
		dataset.addSeries(series3);
		
		return dataset;
	}
	
	

	/**
	 * ��ʼ���û��������ͼ����
	 * @param dataset	���ݼ���
	 * @return	 ���س�ʼ�����û�������ݼ���
	 */
	private CategoryDataset initUserDateset() {
		
		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		int[] userSalary = new UserBll().setSalaryChartData();
		keyedValues.addValue("1000-2000", userSalary[0]);
		keyedValues.addValue("2000-3000", userSalary[1]);
		keyedValues.addValue("3000-4000", userSalary[2]);
		keyedValues.addValue("4000-5000", userSalary[3]);
		keyedValues.addValue("5000-6000", userSalary[4]);
		keyedValues.addValue("6000-7000", userSalary[5]);
		keyedValues.addValue("7000-10000", userSalary[6]);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("Ա���������", keyedValues);
		
		return dataset;
	}
	
}
