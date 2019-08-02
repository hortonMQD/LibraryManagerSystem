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
		
		barChart = new BarChart3DFactor("馆藏图书情况", initDateSetTest(dataset), "类型", "馆藏量(单位：本)").createPlot();
	}
	
	
	/**
	 * 初始化馆藏图书柱状图数据
	 * @param dataset	数据集合
	 * @return	 返回初始化后馆藏图书柱状图面板
	 */
	private CategoryDataset initDateSetTest(CategoryDataset dataset) {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		
		//添加数据
		keyedValue.addValue("宇宙科学类", 300);
		keyedValue.addValue("自然物理类", 100);
		keyedValue.addValue("计算机科学类", 220);
		keyedValue.addValue("人文类", 130);
		keyedValue.addValue("哲学类", 500);
		keyedValue.addValue("自然地理类", 600);
		keyedValue.addValue("历史文献", 600);
		
		dataset = DatasetUtilities.createCategoryDataset("馆藏图书", keyedValue);
		return dataset;
	}
	
	
	
	/**
	 * 初始化馆藏图书柱状图数据
	 * @param dataset	数据集合
	 * @return	 返回初始化后馆藏图书柱状图面板
	 */
	private CategoryDataset initDateSet(CategoryDataset dataset) {
		DefaultKeyedValues keyedValue = new DefaultKeyedValues();
		int[] data = new BookBll().ChartData();
		//添加数据
		keyedValue.addValue("宇宙科学类", data[0]);
		keyedValue.addValue("自然物理类", data[1]);
		keyedValue.addValue("计算机科学类", data[2]);
		keyedValue.addValue("人文类", data[3]);
		keyedValue.addValue("哲学类", data[4]);
		keyedValue.addValue("自然地理类", data[5]);
		keyedValue.addValue("历史文献", data[6]);
		
		dataset = DatasetUtilities.createCategoryDataset("馆藏图书", keyedValue);
		return dataset;
	}
	
	
	public JPanel getPanel() {
		return barChart;
	}
	
	private static CategoryDataset getCategoryDataset() {

		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1月", 310);
		keyedValues.addValue("2月", 489);
		keyedValues.addValue("3月", 512);
		keyedValues.addValue("4月", 589);
		keyedValues.addValue("5月", 359);
		keyedValues.addValue("6月", 402);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"JAVA图书", keyedValues);
		return dataset;
	}

	
	
}
