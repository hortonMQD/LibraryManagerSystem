package UITool;

import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

@SuppressWarnings("serial")
public class MyJDesktopPane extends JDesktopPane{
	
	
	/**
	 * 	�����д����Լ�����ʽ��ʾ
	 * @param offset  ��������֮���λ�ƾ���
	 * @param scale	    �ڲ�������JDesktopPane�Ĵ�С����
	 */
	public void cascadeWindows(int offset,double scale) {
		
		//���ڶ��弶����ʾ����ʱ���ڲ����ڵĴ�С
		int width = (int)(getWidth() * scale);
		int height = (int)(getHeight() * scale);
		
		//���ڱ��漶������ʱ��ÿ�����ڵ�λ��
		int x = 0;
		int y = 0;
		for(JInternalFrame frame : getAllFrames()) {
			try {
				//ȡ���ڲ����ڵ���󻯣���С��
				frame.setMaximum(false);
				frame.setIcon(false);
				
				//�Ѵ������·�����ָ��λ��
				frame.reshape(x, y, width, height);
				x += offset;
				y += offset;
				
				//����ڲ����ڵ������������Ե
				if(x + width > getWidth()) { x = 0; }
				if(y + height > getHeight()) { y = 0; }
			} catch (PropertyVetoException e) {    }
		}
	}
	
	
	/**
	 * �����д�����ƽ�̷�ʽ��ʾ
	 */
	@SuppressWarnings("unused")
	public void titeWindows() {
		
		int frameCount = 0;			//�ڲ����ڸ���
		
		//ͳ�����д���
		for(JInternalFrame frame : getAllFrames()) {
			frameCount++;
		}
		
		//������Ҫ�����У������в���ƽ�����д���
		int row = (int)Math.sqrt(frameCount);
		int cols = frameCount / row;
		
		//��Ҫ�������ӵ������еĴ���
		int extra = frameCount % row;
		//����ƽ��ʱ�ڲ����ڵĴ�С
		int width = getWidth() / cols;
		int height = getHeight() / row;
		//���ڱ���ƽ�̴���ʱÿ�������ں��������ϵ�����
		int x = 0;
		int y = 0;
		
		for (JInternalFrame frame : getAllFrames()) {
			try {
				//ȡ���ڲ����ڵ���󻯡���С��
				frame.setMaximum(false);
				frame.setIcon(false);
				//�����ڷ���ָ��λ��
				frame.reshape(x*width, y*height, width, height);
				y++;
				
				//ÿ����һ�д���
				if(y == row) {
					//��ʼ������һ�д���
					y = 0;
					x++;
					/*
					 * ����������Ĵ�����ʣ�µ��������
					 * ����������ж���Ҫ������һ������
					 */
					if (extra == cols - x) {
						row++;
						height = getHeight() / row;
					}
				}
			} catch (PropertyVetoException e) {			}
			
		}
	}
	
	/**
	 * ѡ����һ����ͼ�괰��
	 */
	public void selectNextWindow() {
		JInternalFrame[] frames = getAllFrames();
		for(int i = 0;i < frames.length;i++) {
			if (frames[i].isSelected()) {
				//�ҳ���һ���Ǵ��ڻ��Ĵ��ڣ�����ѡ����
				//���ѡ��ʧ�ܣ����������ѡ����һ������
				int next = (i + 1) % frames.length;
				while(next != i) {
					//����ô��ڲ�����С��״̬
					if (!frames[next].isIcon()) {
						try {
							frames[next].setSelected(true);
							frames[next].toFront();
							frames[i].toBack();
							return;
						} catch (PropertyVetoException e) {		}
						next = (next + 1) % frames.length;
					}
				}
			}
		}
	}

}
