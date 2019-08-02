package chart;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;

@SuppressWarnings("serial")
public class LineChartFactor extends ApplicationFrame {


	protected CategoryDataset dataset;
	protected String chartTitle;		//图表标题
	protected String xString;			//x轴标签  格式：月份
	protected String yString;			//y轴标签  格式："销售量（单位：本）"
	
	public LineChartFactor(String title) {
		super(title);
	}


	public LineChartFactor(String title,CategoryDataset dataset,String xString,String yString) {
		super(title);
		this.chartTitle = title;
		this.dataset = dataset;
		this.xString = xString;
		this.yString = yString;
	}
	
	
	/**
	 * 生成JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		JFreeChart chart = ChartFactory.createLineChart(chartTitle, // 图表标题
				xString, // x轴标签
				yString, // y轴标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		return chart;
	}

	/**
	 * 修改字体
	 * 
	 * @param chart
	 */
	private void updateFont(JFreeChart chart) {

		// 标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));
		// 图表
		CategoryPlot categoryPlot = chart.getCategoryPlot();

		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		// X轴字体
		categoryAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// X轴标签字体
		categoryAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));

		ValueAxis valueAxis = categoryPlot.getRangeAxis();
		// y轴字体
		valueAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// y轴标签字体
		valueAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
	}

	/**
	 * 设置图表
	 * 
	 * @param chart
	 */
	public JPanel createPlot() {
		JFreeChart chart = getJFreeChart();
		// 修改字体
		updateFont(chart);
		return new ChartPanel(chart);
	}

}
