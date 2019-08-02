package UITool;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;


@SuppressWarnings("serial")
public class FixedTable extends JTable{
	
	Color bankgrandColor = new Color(228, 254, 254);
	boolean isCellEditable = true;

	public boolean isCellEditable() {
		return isCellEditable;
	}

	public void setCellEditable(boolean isCellEditable) {
		this.isCellEditable = isCellEditable;
	}

	/**
	 * �вι��췽��
	 * 
	 * @param dm
	 *            - �������ģ��
	 */
	public FixedTable(TableModel dm) {
		super(dm);
		init();
	}

	/**
	 * �޲������췽��
	 */
	public FixedTable() {
		super();
		init();
	}

	private void init() {
		setSelectionForeground(Color.BLUE);
		// setShowGrid(true) ;

		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ���ֻ�ܵ�ѡ
		setDefaultRenderer(Object.class, new MyRender());// ��ͷ�߶�
		setRowHeight(30);// �и�
		overridCopyAction();
	}

	/**
	 * ��д����ƶ���
	 */
	private void overridCopyAction() {
		// �������̲������󣬴˶����ʾctrl+c��ϼ�������һ�������ͷ�ʱ����
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK, true);
		InputMap inputMap = getInputMap();// �����¼���ֵ��
		inputMap.put(keyStroke, "copy");// ���ղŵ�ctrl+c��ϼ��롰copy�����
		ActionMap actionMap = getActionMap();// �����¼���ֵ��
		actionMap.put("copy", new AbstractAction() {// ���ղŵġ�copy�������������
			@Override
			public void actionPerformed(ActionEvent e) {// �������¼�ʱ
				int row = getSelectedRow();// ��ȡѡ��������
				int column = getSelectedColumn();// ��ȡѡ��������
				String value = (String) getValueAt(row, column);// ������е����ݸ��Ƴ����ַ�������
				Toolkit tool = Toolkit.getDefaultToolkit();// ����ϵͳ��Ĭ��������߰�
				Clipboard clipboard = tool.getSystemClipboard();// ���ϵͳ���а����
				Transferable trans = new StringSelection(value);// �������Ա����ַ����Ĵ������
				clipboard.setContents(trans, null);// ����ǰ������������а�
			}
		});
	}

	/**
	 * ������ͷ
	 */
	public JTableHeader getTableHeader() {
		JTableHeader tableHeader = super.getTableHeader();// ��ñ��ͷ����
		tableHeader.setReorderingAllowed(false); // ���ñ���в�������
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) tableHeader.getDefaultRenderer(); // ��ñ��ͷ�ĵ�Ԫ�����
		// ��������������ʾ
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		hr.setFont(new Font("����", Font.BOLD, 20));
		hr.setPreferredSize(new Dimension(hr.getWidth(), 30));
		return tableHeader;
	}

	/**
	 * �ñ�񲻿ɱ༭
	 */
	public boolean isCellEditable(int row, int column) {
		return isCellEditable;
	}

	/**
	 * ���ر���һ��
	 */
	public void hiddenFirstColumn() {
		TableColumnModel firstColumnModel = getColumnModel();
		int count = firstColumnModel.getColumnCount();
		if (count > 0) {
			TableColumn firstColumn = firstColumnModel.getColumn(0);
			firstColumn.setMaxWidth(0);
			firstColumn.setMinWidth(0);
			firstColumn.setPreferredWidth(0);
			firstColumn.setResizable(false);// �п��ɸı�
		}
	}

	
	
	/**
	 * ���ñ���п�����������Ӧ
	 * @param myTable  �������
	 */
	public static void  ColumnWidthMatchesTheContent(JTable table) {
		JTableHeader header = table.getTableHeader();  //��ͷ
		int rowCount = table.getRowCount();  //��������
		TableColumnModel cm = table.getColumnModel();  //������ģ��

		for (int i = 0; i < cm.getColumnCount(); i++) {  //ѭ������ÿһ��
		TableColumn column = cm.getColumn(i);          //��i���ж���
		int width = (int)header.getDefaultRenderer().getTableCellRendererComponent(table, column.getIdentifier(), false, false, -1, i).getPreferredSize().getWidth();  //�ñ�ͷ�Ļ����������i�б�ͷ�Ŀ��
		for(int row = 0; row<rowCount; row++){  //ѭ�������i�е�ÿһ�У��õ�Ԫ������������i�е�row�еĵ�Ԫ����
		int preferedWidth = (int)table.getCellRenderer(row, i).getTableCellRendererComponent(table, table.getValueAt(row, i), false, false, row, i).getPreferredSize().getWidth();
		width = Math.max(width, preferedWidth);  //ȡ���Ŀ��
		}
		column.setPreferredWidth(width+table.getIntercellSpacing().width);  //���õ�i�е���ѡ���
		}

		table.doLayout();   //���ող����õĿ�����²��ָ�����
	}
	
	
	
	
	
	/**
	 * �Զ�������Ⱦ��
	 * 
	 * @author horton
	 *
	 */
	class MyRender implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			DefaultTableCellRenderer cr = new DefaultTableCellRenderer();// ������Ԫ�����
			cr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);// ��Ԫ�������ݾ���
			// ������Ԫ����Ⱦ��
			JLabel renderer = (JLabel) cr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			if (row % 2 != 0) {// �����ż����
				renderer.setBackground(bankgrandColor);// ż����������ɫ����
			} else {
				renderer.setBackground(Color.WHITE);// �����а�ɫ����
			}
			renderer.setFont(new Font("΢���ź�", Font.PLAIN, 14));
			return renderer;
		}
	}

}
