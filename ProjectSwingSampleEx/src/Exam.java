import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import javax.swing.table.*;

class Exam_Sub extends JFrame implements ActionListener{
	private JRootPane jrp;
	private Container con;
	private JLabel jlb = new JLabel("�ο��� : ", JLabel.RIGHT);
	private JLabel jlb1 = new JLabel("��", JLabel.LEFT);
	private JTextField tf = new JTextField();
	private JButton jbt = new JButton("�����");
	private JButton jbt1 = new JButton("����");
	private JButton jbt2 = new JButton("����");

	
	//���̺� ���� ��
	private DefaultTableModel dtm;
	private DefaultTableColumnModel dtcm;
	private DefaultListSelectionModel dlsm;
	// ���� ���� ��
	private JTable jt;
	private JScrollPane jsp;
	// �ο��� ������ ���� 
	private int num = 0;
	// ���̺� �÷� 
	private TableColumn tc, tc1, tc2, tc3, tc4, tc5, tc6, tc7;
	private DefaultTableCellRenderer dtcr, dtcr1, dtcr2, dtcr3, dtcr4, dtcr5, dtcr6, dtcr7;
	private JTextField jtf, jtf1, jtf2, jtf3, jtf4, jtf5, jtf6, jtf7;
	private DefaultCellEditor dce, dce1, dce2, dce3, dce4, dce5, dce6, dce7;
	private JTableHeader jth;

	public Exam_Sub(){
		super("Test");
		this.init();
		this.start();
		this.setSize(300, 200);
		
		// ȭ�� �߾� ó��
		Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int)(di.getWidth() / 2 - di1.getWidth() / 2), 
			(int)(di.getHeight() / 2 - di1.getHeight() / 2));
		this.setVisible(true);
	}
	public void init(){
		jrp = this.getRootPane();
		con = jrp.getContentPane();
		con.setLayout(new BorderLayout());
		// ��ܺ� ���̾ƿ� 
		JPanel jp = new JPanel(new BorderLayout());
		jp.add("West", jlb);
		jp.add("Center", tf);
		//jp�� ���� ���� 
		JPanel jp1 = new JPanel(new BorderLayout());
		jp1.add("West", jlb1);
		jp1.add("Center", jbt);
		jp.add("East", jp1);

		// �ϴܺ� ���̾ƿ� 
		JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp2.add(jbt1);//����...
		jp2.add(jbt2);

		// �����̳� ���̾ƿ� ���Ϻ�
		con.add("North", jp);
		con.add("South", jp2);

	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����� �̺�Ʈ �߻��� ... 
		tf.addActionListener(this);
		jbt.addActionListener(this);
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == tf || e.getSource() == jbt){
			//���̺� ����
			try{
				num = Integer.parseInt(tf.getText().trim());
			}catch(NumberFormatException ee){
				tf.setText("");
				tf.requestFocus();
				return;
			}
			tf.setEnabled(false);
			jbt.setEnabled(false);
			dtm = new DefaultTableModel(num, 8);
			dtcm = new DefaultTableColumnModel();
			dlsm = new DefaultListSelectionModel();
			jt = new JTable(dtm, dtcm, dlsm);
			jsp = new JScrollPane(jt);
			
			dtcr = new DefaultTableCellRenderer();
			jtf = new JTextField();
			jtf.setEditable(true);
			dce = new DefaultCellEditor(jtf);
			tc = new TableColumn(0, 120, dtcr, dce);
			tc.setHeaderValue("�̸�");
			dtcm.addColumn(tc);			
			dtcr1 = new DefaultTableCellRenderer();
			jtf1 = new JTextField();
			jtf1.setEditable(true);
			dce1 = new DefaultCellEditor(jtf1);
			tc1 = new TableColumn(1, 75, dtcr1, dce1);
			tc1.setHeaderValue("����");
			dtcm.addColumn(tc1);
			dtcr2 = new DefaultTableCellRenderer();
			jtf2 = new JTextField();
			jtf2.setEditable(true);
			dce2 = new DefaultCellEditor(jtf2);
			tc2 = new TableColumn(2, 75, dtcr2, dce2);
			tc2.setHeaderValue("����");
			dtcm.addColumn(tc2);
			dtcr3 = new DefaultTableCellRenderer();
			jtf3 = new JTextField();
			jtf3.setEditable(true);
			dce3 = new DefaultCellEditor(jtf3);
			tc3 = new TableColumn(3, 75, dtcr3, dce3);
			tc3.setHeaderValue("����");
			dtcm.addColumn(tc3);
			dtcr4 = new DefaultTableCellRenderer();
			jtf4 = new JTextField();
			jtf4.setEditable(false);
			dce4 = new DefaultCellEditor(jtf4);
			tc4 = new TableColumn(4, 75, dtcr4, dce4);
			tc4.setHeaderValue("����");
			dtcm.addColumn(tc4);
			dtcr5 = new DefaultTableCellRenderer();
			jtf5 = new JTextField();
			jtf5.setEditable(false);
			dce5 = new DefaultCellEditor(jtf5);
			tc5 = new TableColumn(5, 100, dtcr5, dce5);
			tc5.setHeaderValue("���");
			dtcm.addColumn(tc5);
			dtcr6 = new DefaultTableCellRenderer();
			jtf6 = new JTextField();
			jtf6.setEditable(false);
			dce6 = new DefaultCellEditor(jtf6);
			tc6 = new TableColumn(6, 50, dtcr6, dce6);
			tc6.setHeaderValue("����");
			dtcm.addColumn(tc6);
			dtcr7 = new DefaultTableCellRenderer();
			jtf7 = new JTextField();
			jtf7.setEditable(false);
			dce7 = new DefaultCellEditor(jtf7);
			tc7 = new TableColumn(7, 50, dtcr7, dce7);
			tc7.setHeaderValue("����");
			dtcm.addColumn(tc7);
			jth = new JTableHeader(dtcm);
			jth.setReorderingAllowed(false);
			jt.setTableHeader(jth);
			
			// �����̳� ȭ�� �籸�� (�̹� true�����̴� validate �ؾ���.......
			con.add("Center", jsp);
			con.validate();
			// ���̺� ������ ���� �� ������¡ 
			this.pack();
			Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension di1 = this.getSize();
			this.setLocation((int)(di.getWidth() / 2 - di1.getWidth() / 2), 
				(int)(di.getHeight() / 2 - di1.getHeight() / 2));
		}
		else if(e.getSource() == jbt1){
			// ���� ��ư ó���� 
			jt.clearSelection();
			int[][] imsi = new int[num][2];
			for(int i = 0; i < num; i++){
				int tot = Integer.parseInt((String)dtm.getValueAt(i, 1)) +
					Integer.parseInt((String)dtm.getValueAt(i, 2)) +
					Integer.parseInt((String)dtm.getValueAt(i, 3)); 
				float avg = tot / 3.0f;
				char ch = 0;
				switch((int)(avg / 10)){
				case 10:
				case 9: ch = 'A'; break;
				case 8: ch = 'B'; break;
				case 7: ch = 'C'; break;
				case 6: ch = 'D'; break;
				default: ch = 'F';
				}
				dtm.setValueAt(String.valueOf(tot), i, 4);
				dtm.setValueAt(String.valueOf(avg), i, 5);
				dtm.setValueAt(ch + "", i, 6);
				imsi[i][0] = tot;
				imsi[i][1] = 1;
			}
			// Sort ��... 
			for(int i = 0; i < num; i++){
				for(int j = 0; j < num; j++){
					if(imsi[i][0] < imsi[j][0]){
						imsi[i][1]++;
					}
				}
			}			
			for(int i = 0; i < num; i++){
				dtm.setValueAt(String.valueOf(imsi[i][1]), i, 7);
			}
		}
		else if(e.getSource() == jbt2){
			System.exit(0);
		}
	}
}
public class Exam{
	public static void main(String[] ar){
		Exam_Sub es = new Exam_Sub();
	}
}