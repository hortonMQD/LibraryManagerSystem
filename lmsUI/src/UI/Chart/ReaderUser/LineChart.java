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
		readerlineChart = new XYLineChartFactor("人员情况", initReaderDatesetTest(dataset), "年龄段", "人数（单位：个）").createPlot();
		userLineChart = new LineChartFactor("员工工资情况", initUserDatesetTest(), "工资阶段", "元").createPlot();
	}
	
	public JScrollPane getPanel() {
		lineChart = new JPanel(new GridLayout(2, 1));
		lineChart.add(readerlineChart);
		lineChart.add(userLineChart);
		JScrollPane scrollPane = new JScrollPane(lineChart);
		return scrollPane;
	}
	

	/**
	 * 初始化读者情况折线图数据
	 * @param dataset	数据集合
	 * @return	 返回初始化后读者情况数据集合
	 */
	private IntervalXYDataset initReaderDatesetTest(XYSeriesCollection dataset) {
		if (dataset == null) {  dataset = new XYSeriesCollection();  }
		
		final XYSeries series1 = new XYSeries("读者年龄段情况");
		final XYSeries series2 = new XYSeries("办卡后各年龄段无借书记录情况");
		final XYSeries series3 = new XYSeries("员工年龄段情况");

		
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
	 * 初始化用户情况折线图数据
	 * @param dataset	数据集合
	 * @return	 返回初始化后用户情况数据集合
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
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("员工工资情况", keyedValues);
		
		return dataset;
	}
	
	
	
	/**
	 * 初始化读者情况折线图数据
	 * @param dataset	数据集合
	 * @return	 返回初始化后读者情况数据集合
	 */
	private IntervalXYDataset initReaderDateset(XYSeriesCollection dataset) {
		if (dataset == null) {  dataset = new XYSeriesCollection();  }
		
		final XYSeries series1 = new XYSeries("读者年龄段情况");
		final XYSeries series2 = new XYSeries("办卡后各年龄段无借书记录情况");
		final XYSeries series3 = new XYSeries("员工年龄段情况");

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
	 * 初始化用户情况折线图数据
	 * @param dataset	数据集合
	 * @return	 返回初始化后用户情况数据集合
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
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset("员工工资情况", keyedValues);
		
		return dataset;
	}
	
}
