package chart;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

@SuppressWarnings("serial")
public class PieChart3DFactor  extends ApplicationFrame{
	
	
	protected PieDataset dataset;
	protected String titleChart;
	
	public PieChart3DFactor(String title) {
		super(title);
	}
	
	public PieChart3DFactor(String title,PieDataset dataset) {
		super(title);
		
		this.dataset = dataset;
		this.titleChart = title;
	}

	

	/**
	 * 获取数据集，生成JFreeChart，
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		JFreeChart chart = ChartFactory.createPieChart3D(titleChart, dataset,
				true, true, false);
		// 设置饼图使用的字体
		setPiePoltFont(chart);
		return chart;
	}

	/**
	 * 设置饼图使用的字体
	 * 
	 * @param chart
	 */
	protected void setPiePoltFont(JFreeChart chart) {

		// 分类标签字体和显示
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont(new Font("宋体", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}"));

		// 标题字体
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.BOLD, 20));

		// 图例字体
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));

	}

	/**
	 * 设置Pie
	 * 
	 * @param chart
	 */
	public JPanel createPiePlot() {
		JFreeChart chart = getJFreeChart();

		// 把JFreeChart对象保存到面板中
		return new ChartPanel(chart);

	}
}
