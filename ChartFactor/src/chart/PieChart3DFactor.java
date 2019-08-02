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
	 * ��ȡ���ݼ�������JFreeChart��
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		JFreeChart chart = ChartFactory.createPieChart3D(titleChart, dataset,
				true, true, false);
		// ���ñ�ͼʹ�õ�����
		setPiePoltFont(chart);
		return chart;
	}

	/**
	 * ���ñ�ͼʹ�õ�����
	 * 
	 * @param chart
	 */
	protected void setPiePoltFont(JFreeChart chart) {

		// �����ǩ�������ʾ
		PiePlot piePlot = (PiePlot) chart.getPlot();
		piePlot.setLabelFont(new Font("����", Font.PLAIN, 14));
		piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}"));

		// ��������
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("����", Font.BOLD, 20));

		// ͼ������
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("����", Font.PLAIN, 14));

	}

	/**
	 * ����Pie
	 * 
	 * @param chart
	 */
	public JPanel createPiePlot() {
		JFreeChart chart = getJFreeChart();

		// ��JFreeChart���󱣴浽�����
		return new ChartPanel(chart);

	}
}
