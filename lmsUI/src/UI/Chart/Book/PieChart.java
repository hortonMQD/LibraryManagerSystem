package UI.Chart.Book;

import javax.swing.JPanel;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import Bll.BookBll;
import chart.PieChart3DFactor;

public class PieChart extends JPanel{
	
	protected JPanel PiePanel;
	protected DefaultPieDataset dataset;
	
	
	
	public PieChart() {
		PiePanel = new PieChart3DFactor("馆藏图书情况", initDatasetTest(dataset)).createPiePlot();
	}
	
	
	public JPanel getPanel() {
		return PiePanel;
	}
	
	/**
	 * 初始化馆藏图书情况饼图（测试）
	 * @param dataset	数据集合
	 * @return	返回初始化后馆藏图书情况饼图面板
	 */
	private  PieDataset initDatasetTest(DefaultPieDataset dataset) { 
		dataset = new DefaultPieDataset();
		//添加数据
		dataset.setValue("宇宙科学类", 300);
		dataset.setValue("自然物理类", 100);
		dataset.setValue("计算机科学类", 220);
		dataset.setValue("人文类", 130);
		dataset.setValue("哲学类", 500);
		dataset.setValue("自然地理类", 600);
		dataset.setValue("历史文献", 600);
		return dataset;
	}
	
	
	/**
	 * 初始化馆藏图书情况饼图
	 * @param dataset	数据集合
	 * @return	返回初始化后馆藏图书情况饼图面板
	 */
	private  PieDataset initDataset(DefaultPieDataset dataset) { 
		dataset = new DefaultPieDataset();
		int[] data = new BookBll().ChartData();
		//添加数据
		dataset.setValue("宇宙科学类", data[0]);
		dataset.setValue("自然物理类", data[1]);
		dataset.setValue("计算机科学类", data[2]);
		dataset.setValue("人文类", data[3]);
		dataset.setValue("哲学类", data[4]);
		dataset.setValue("自然地理类", data[5]);
		dataset.setValue("历史文献", data[6]);
		return dataset;
	}
}
