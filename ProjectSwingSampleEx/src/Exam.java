import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import javax.swing.table.*;

class Exam_Sub extends JFrame implements ActionListener{
	private JRootPane jrp;
	private Container con;
	private JLabel jlb = new JLabel("인원수 : ", JLabel.RIGHT);
	private JLabel jlb1 = new JLabel("명", JLabel.LEFT);
	private JTextField tf = new JTextField();
	private JButton jbt = new JButton("만들기");
	private JButton jbt1 = new JButton("연산");
	private JButton jbt2 = new JButton("종료");

	
	//테이블 구성 부
	private DefaultTableModel dtm;
	private DefaultTableColumnModel dtcm;
	private DefaultListSelectionModel dlsm;
	// 센터 영역 부
	private JTable jt;
	private JScrollPane jsp;
	// 인원수 가져올 변수 
	private int num = 0;
	// 테이블 컬럼 
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
		
		// 화면 중앙 처리
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
		// 상단부 레이아웃 
		JPanel jp = new JPanel(new BorderLayout());
		jp.add("West", jlb);
		jp.add("Center", tf);
		//jp의 왼쪽 구역 
		JPanel jp1 = new JPanel(new BorderLayout());
		jp1.add("West", jlb1);
		jp1.add("Center", jbt);
		jp.add("East", jp1);

		// 하단부 레이아웃 
		JPanel jp2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp2.add(jbt1);//연산...
		jp2.add(jbt2);

		// 콘테이너 레이아웃 상하부
		con.add("North", jp);
		con.add("South", jp2);

	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 만들기 이벤트 발생시 ... 
		tf.addActionListener(this);
		jbt.addActionListener(this);
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == tf || e.getSource() == jbt){
			//테이블 구성
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
			tc.setHeaderValue("이름");
			dtcm.addColumn(tc);			
			dtcr1 = new DefaultTableCellRenderer();
			jtf1 = new JTextField();
			jtf1.setEditable(true);
			dce1 = new DefaultCellEditor(jtf1);
			tc1 = new TableColumn(1, 75, dtcr1, dce1);
			tc1.setHeaderValue("국어");
			dtcm.addColumn(tc1);
			dtcr2 = new DefaultTableCellRenderer();
			jtf2 = new JTextField();
			jtf2.setEditable(true);
			dce2 = new DefaultCellEditor(jtf2);
			tc2 = new TableColumn(2, 75, dtcr2, dce2);
			tc2.setHeaderValue("영어");
			dtcm.addColumn(tc2);
			dtcr3 = new DefaultTableCellRenderer();
			jtf3 = new JTextField();
			jtf3.setEditable(true);
			dce3 = new DefaultCellEditor(jtf3);
			tc3 = new TableColumn(3, 75, dtcr3, dce3);
			tc3.setHeaderValue("수학");
			dtcm.addColumn(tc3);
			dtcr4 = new DefaultTableCellRenderer();
			jtf4 = new JTextField();
			jtf4.setEditable(false);
			dce4 = new DefaultCellEditor(jtf4);
			tc4 = new TableColumn(4, 75, dtcr4, dce4);
			tc4.setHeaderValue("총점");
			dtcm.addColumn(tc4);
			dtcr5 = new DefaultTableCellRenderer();
			jtf5 = new JTextField();
			jtf5.setEditable(false);
			dce5 = new DefaultCellEditor(jtf5);
			tc5 = new TableColumn(5, 100, dtcr5, dce5);
			tc5.setHeaderValue("평균");
			dtcm.addColumn(tc5);
			dtcr6 = new DefaultTableCellRenderer();
			jtf6 = new JTextField();
			jtf6.setEditable(false);
			dce6 = new DefaultCellEditor(jtf6);
			tc6 = new TableColumn(6, 50, dtcr6, dce6);
			tc6.setHeaderValue("학점");
			dtcm.addColumn(tc6);
			dtcr7 = new DefaultTableCellRenderer();
			jtf7 = new JTextField();
			jtf7.setEditable(false);
			dce7 = new DefaultCellEditor(jtf7);
			tc7 = new TableColumn(7, 50, dtcr7, dce7);
			tc7.setHeaderValue("석차");
			dtcm.addColumn(tc7);
			jth = new JTableHeader(dtcm);
			jth.setReorderingAllowed(false);
			jt.setTableHeader(jth);
			
			// 컨테이너 화면 재구성 (이미 true상태이니 validate 해야함.......
			con.add("Center", jsp);
			con.validate();
			// 테이블 구성에 따른 폼 리사이징 
			this.pack();
			Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension di1 = this.getSize();
			this.setLocation((int)(di.getWidth() / 2 - di1.getWidth() / 2), 
				(int)(di.getHeight() / 2 - di1.getHeight() / 2));
		}
		else if(e.getSource() == jbt1){
			// 연산 버튼 처리부 
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
			// Sort 부... 
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