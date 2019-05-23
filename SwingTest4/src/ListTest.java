import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListTest extends JFrame{
	
	//����Ʈ�� ������ �׸��
	String[] datas= new String[] {"Char1","Char2","Char3","Char4","Char5","Char6"};	
	JList<String> list= new JList<String>();
	
	public ListTest() {
		// TODO Auto-generated constructor stub
		//����Ʈ��ü�� ������ �׸�� ����
		list.setListData(datas);
		list.setSelectionBackground(Color.YELLOW);
		list.setSelectionForeground(Color.RED);
		add(list, BorderLayout.WEST);
		
		//��� �̹��� ��ġ ����
		JPanel panel= new JPanel();
		panel.setLayout(new GridLayout(3, 2, 5, 5));//rows, cols, hgap, vgap
		
		JLabel[] imgLables= new JLabel[6];//�迭��ü 1�� ����
		
		for(int i=0; i<imgLables.length; i++) {
			//�̹��������ܰ�ü ����
			ImageIcon icon= new ImageIcon("images/ms_0"+(i+1)+".png");
			//ReSizing.....
			icon= new ImageIcon( icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH) );
			/////////////////			
			imgLables[i]= new JLabel(icon);
			panel.add(imgLables[i]);
		}
		
		add(panel, BorderLayout.CENTER);
		
		//����Ʈ�� �׸��� �����ϴ� ���� ��� �����ʰ�ü ���� �� �߰�
		list.addListSelectionListener( new ListSelectionListener() {
			
			//����Ʈ�� �׸��� �����ϸ� �ڵ����� ����Ǵ� �޼ҵ� : �ݹ�޼ҵ�
			@Override
			public void valueChanged(ListSelectionEvent e) {				
				// TODO Auto-generated method stub
				
				//�켱 ������ �Ⱥ��̰�..
				for(JLabel t: imgLables) t.setVisible(false);
				
				//����Ʈ���� ���õ� �׸��� �ε�����ȣ ������
				int index= list.getSelectedIndex();				
				imgLables[index].setVisible(true);
				
			}
		});
		
		JButton btn= new JButton("START");
		add(btn, BorderLayout.NORTH);
		
		btn.addActionListener(  new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(JLabel t : imgLables) t.setVisible(false);
			}
		});
		
		
		setTitle("List Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		setLocation(600, 100);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ListTest();
	}

}
