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
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;


/**
 * ������3D��״ͼ
 * @author Horton
 *
 */
@SuppressWarnings("serial")
public class MoreBarChart3DFactor extends ApplicationFrame{

	protected CategoryDataset dataset;
	protected String chartTitle;		//ͼ�����
	protected String xString;			//x���ǩ  ��ʽ���·�
	protected String yString;			//y���ǩ  ��ʽ��"����������λ������"
	
	public MoreBarChart3DFactor(String title) {
		super(title);
	}
	
	
	
	public MoreBarChart3DFactor(String title,CategoryDataset dataset,String xString,String yString) {
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
		JFreeChart chart = ChartFactory.createBarChart3D(chartTitle, // ͼ�����
				xString, // x���ǩ
				yString, // y���ǩ
				dataset, // ���ݼ�
				PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
				true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)
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
		CategoryPlot categoryPlot = chart.getCategoryPlot();

		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		// X������
		categoryAxis.setTickLabelFont(new Font("����", Font.PLAIN, 14));
		// X���ǩ����
		categoryAxis.setLabelFont(new Font("����", Font.PLAIN, 14));

		ValueAxis valueAxis = categoryPlot.getRangeAxis();
		// y������
		valueAxis.setTickLabelFont(new Font("����", Font.PLAIN, 14));
		// y���ǩ����
		valueAxis.setLabelFont(new Font("����", Font.PLAIN, 14));
	}
	
	/**
	 * ����ͼ����ʾ
	 * 
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart) {
		//����ͼ��
		CategoryPlot categoryPlot = chart.getCategoryPlot();
		BarRenderer3D renderer = (BarRenderer3D) categoryPlot.getRenderer();
		//��ʾ����
		renderer.setDrawBarOutline(true);
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
		// �޸�ͼ��
		updatePlot(chart);
		return new ChartPanel(chart);
	}

}
