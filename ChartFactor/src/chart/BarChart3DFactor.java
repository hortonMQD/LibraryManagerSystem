package chart;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.ApplicationFrame;

@SuppressWarnings("serial")
public class BarChart3DFactor extends ApplicationFrame{

	
	protected CategoryDataset dataset;	//���ݼ�
	protected String chartTitle;		//ͼ�����
	protected String xString;			//x���ǩ  ��ʽ���·�
	protected String yString;			//y���ǩ  ��ʽ��"����������λ������"
	
	
	public BarChart3DFactor(String title) {
		super(title);
	}

	public BarChart3DFactor(String title,CategoryDataset dateset,String xString,String yString) {
		super(title);
		this.chartTitle = title;
		this.dataset = dateset;
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
	 * ����ͼ��
	 * @return  ���س�ʼ�����ͼ��
	 */
	public JPanel createPlot() {
		JFreeChart chart = getJFreeChart();
		// �޸�����
		updateFont(chart);
		return new ChartPanel(chart);		
	}
	
	
	//setContentPane(new ChartPanel(chart));
	
}
