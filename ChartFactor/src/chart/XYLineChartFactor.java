package chart;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;

@SuppressWarnings("serial")
public class XYLineChartFactor extends ApplicationFrame {

	private IntervalXYDataset dataset;
	private String xString;			//x���ǩ����ʽ�����ҳ����
	private String yString;			//y���ǩ(��ʽ����Ա����)
	private String chartTitle;		//ͼ�����
	
	public XYLineChartFactor(String title) {
		super(title);
	}
	
	public XYLineChartFactor(String title,IntervalXYDataset dataset,String xString,String yString) {
		super(title);
		this.chartTitle = title;
		this.dataset = dataset;
		this.xString = xString;
		this.yString = yString;
	}

	/**
	 * ����JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		
		JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, // ͼ�����
				xString, // x���ǩ
				yString, // y���ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��
				false, // �Ƿ����ɹ���
				false // �Ƿ�����URL����
				);
		return chart;
	}

	/**
	 * �޸�����
	 * 
	 * @param chart
	 */
	private void updateFont(JFreeChart chart) {

		// ����
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("����", Font.PLAIN, 20));
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("����", Font.PLAIN, 14));
		// ͼ��
		XYPlot plot = chart.getXYPlot();
		NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
		// X������
		domainAxis.setTickLabelFont(new Font("����", Font.PLAIN, 14));
		// X���ǩ����
		domainAxis.setLabelFont(new Font("����", Font.PLAIN, 14));

		ValueAxis valueAxis = plot.getRangeAxis();
		// y������
		valueAxis.setTickLabelFont(new Font("����", Font.PLAIN, 14));
		// y���ǩ����
		valueAxis.setLabelFont(new Font("����", Font.PLAIN, 14));
	}

	/**
	 * ����ͼ��
	 * 
	 * @param chart
	 */
	public JPanel createPlot() {
		JFreeChart chart = getJFreeChart();
		// �޸�����
		updateFont(chart);
		return new ChartPanel(chart);
	}
}
