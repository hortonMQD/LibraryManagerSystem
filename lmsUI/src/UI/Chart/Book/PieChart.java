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
		PiePanel = new PieChart3DFactor("�ݲ�ͼ�����", initDatasetTest(dataset)).createPiePlot();
	}
	
	
	public JPanel getPanel() {
		return PiePanel;
	}
	
	/**
	 * ��ʼ���ݲ�ͼ�������ͼ�����ԣ�
	 * @param dataset	���ݼ���
	 * @return	���س�ʼ����ݲ�ͼ�������ͼ���
	 */
	private  PieDataset initDatasetTest(DefaultPieDataset dataset) { 
		dataset = new DefaultPieDataset();
		//�������
		dataset.setValue("�����ѧ��", 300);
		dataset.setValue("��Ȼ������", 100);
		dataset.setValue("�������ѧ��", 220);
		dataset.setValue("������", 130);
		dataset.setValue("��ѧ��", 500);
		dataset.setValue("��Ȼ������", 600);
		dataset.setValue("��ʷ����", 600);
		return dataset;
	}
	
	
	/**
	 * ��ʼ���ݲ�ͼ�������ͼ
	 * @param dataset	���ݼ���
	 * @return	���س�ʼ����ݲ�ͼ�������ͼ���
	 */
	private  PieDataset initDataset(DefaultPieDataset dataset) { 
		dataset = new DefaultPieDataset();
		int[] data = new BookBll().ChartData();
		//�������
		dataset.setValue("�����ѧ��", data[0]);
		dataset.setValue("��Ȼ������", data[1]);
		dataset.setValue("�������ѧ��", data[2]);
		dataset.setValue("������", data[3]);
		dataset.setValue("��ѧ��", data[4]);
		dataset.setValue("��Ȼ������", data[5]);
		dataset.setValue("��ʷ����", data[6]);
		return dataset;
	}
}
