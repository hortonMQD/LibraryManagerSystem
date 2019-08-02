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
		lineChart = new LineChartFactor("馆藏图书情况", initDatesetTest(dataset), "类型", "馆藏数量（单位：本）").createPlot();
	}
	
	
	
	
	public JPanel getPanel() {
		return lineChart;
	}
	
	
	/**
	 * 初始化馆藏图书折线图数据（测试）
	 * @param dataset	数据集合
	 * @return	 返回初始化后馆藏图书折现图面板
	 */
	private CategoryDataset initDatesetTest(CategoryDataset dataset) {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		
		keyedValue.addValue("宇宙科学类", 300);
		keyedValue.addValue("自然物理类", 100);
		keyedValue.addValue("计算机科学类", 220);
		keyedValue.addValue("人文类", 130);
		keyedValue.addValue("哲学类", 500);
		keyedValue.addValue("自然地理类", 600);
		keyedValue.addValue("历史文献", 600);
		dataset = DatasetUtilities.createCategoryDataset("馆藏图书情况", keyedValue);
		return dataset;
	}
	
	
	/**
	 * 初始化馆藏图书折线图数据
	 * @param dataset	数据集合
	 * @return	 返回初始化后馆藏图书折现图面板
	 */
	private CategoryDataset initDateset(CategoryDataset dataset) {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		int[] data = new BookBll().ChartData();
		keyedValue.addValue("宇宙科学类", data[0]);
		keyedValue.addValue("自然物理类", data[1]);
		keyedValue.addValue("计算机科学类", data[2]);
		keyedValue.addValue("人文类", data[3]);
		keyedValue.addValue("哲学类", data[4]);
		keyedValue.addValue("自然地理类", data[5]);
		keyedValue.addValue("历史文献", data[6]);
		dataset = DatasetUtilities.createCategoryDataset("馆藏图书情况", keyedValue);
		return dataset;
	}
}
