import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JToolBar.Separator;
import javax.swing.border.*;
import javax.swing.tree.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;


//�μ����� Ŭ���� 
class BuSet implements Serializable{
	private String buname;
	private int bunum;
	
	public BuSet(String str , int i ){
		buname = str;
		bunum = i;
	}
	public String getBuname(){
		return buname;
	}
	
	public int getBunum(){
		return bunum;
	}
	public void setBuname(String str){
		buname =str;
	}
	public void setBunum(int i){
		bunum = i;
	}
}

class Person implements Serializable{
	// �����̺� ���� �Ͽ���.. 
	 String name;
	 String jumin;
	 String id;
	 String pass;
	 String tel;
	 String tel1;
	 String addr;
	 String buname;
	 String jik;
	 String work;
	
	public Person(String a , String b ,  String  c ,  String  d ,  String e, 
			String f,  String g ,  String h ,  String  i ,  String j){
		name = a ; jumin = b ; id = c ; pass = d; tel = e; tel1 = f; addr = g ; 
		buname = h; jik = i ; work = j;
	}

}


class Exam02_sub extends JFrame implements ActionListener, FocusListener, ChangeListener{
	private Container con;
	//��üȭ���� North
	private JLabel jl = new JLabel(" < �λ� ���� > ",JLabel.CENTER);
	//��üȭ���� Center
	private JSplitPane jsp = new JSplitPane();
		//������ West ���� 
	private JPanel jpjp = new JPanel(new BorderLayout());
	private JLabel jljl = new JLabel("��� �ο�",JLabel.CENTER);
	//private JTree tree = new JTree();
	//private JScrollPane treejsp = new JScrollPane(tree);
	
		//������ �߾Ӻ�
	private JTabbedPane jtb = new JTabbedPane();
	private JPanel jpjpjp = new JPanel(new BorderLayout());
	private JPanel jpjpjp1 = new JPanel(new BorderLayout());
	private JPanel jpjpjp2 = new JPanel(new BorderLayout());
	private JPanel jpjpjp3 = new JPanel(new BorderLayout());
	
	
	
	
	//��üȭ���� South
	private JPanel jp = new JPanel(new GridLayout(2,1)); //2�� 1��
	private JPanel jp1 = new JPanel(new BorderLayout()); 
	private JPanel jp2 = new JPanel(new GridLayout(1,2)); //1�� 2�� 
	private JPanel jp3 = new JPanel(new GridLayout(1,2));
	private JPanel jp4 = new JPanel(new GridLayout(1,2));
	private JLabel jlb = new JLabel("�μ���",JLabel.RIGHT);
	private JTextField jtf = new JTextField();
	private JButton jbt1 = new JButton("�μ� �߰�");
	private JButton jbt2 = new JButton("���Ϸ� ����");
	private JButton jbt3 = new JButton("�ҷ� ���� ");
	private JButton jbt4 = new JButton("����");
	
	// ����� ��� ��
	private JLabel namelb = new JLabel("�̸� : ", JLabel.RIGHT);
	private JLabel juminlb = new JLabel("�ֹι�ȣ : ", JLabel.RIGHT);
	private JLabel idlb = new JLabel("���̵� : ", JLabel.RIGHT);
	private JLabel passlb = new JLabel("��й�ȣ : ", JLabel.RIGHT);
	private JLabel pass1lb = new JLabel("��й�ȣ Ȯ�� : ", JLabel.RIGHT);
	private JLabel tellb = new JLabel("��ȭ��ȣ : ", JLabel.RIGHT);
	private JLabel tel1lb = new JLabel("�޴��� : ", JLabel.RIGHT);
	private JLabel addrlb = new JLabel("�ּ� : ", JLabel.RIGHT);
	private JLabel bulb = new JLabel("�μ� : ", JLabel.RIGHT);
	private JLabel jiklb = new JLabel("��å : ", JLabel.RIGHT);
	private JLabel worklb = new JLabel("�������� �ۼ� : ", JLabel.RIGHT);
	private JButton regbt = new JButton("���");
	private JButton clearbt = new JButton("Clear");
	private JTextField nametf = new JTextField();
	private JTextField jumintf = new JTextField();
	private JTextField jumin1tf = new JTextField();
	private JButton juminbt = new JButton("��ø");
	private JTextField idtf = new JTextField();
	private JButton idbt = new JButton("��ø");
	private JPasswordField passtf = new JPasswordField();
	private JPasswordField pass1tf = new JPasswordField();
	private Vector telvc = new Vector();
	private JComboBox teltf = new JComboBox(telvc);
	private JTextField tel1tf = new JTextField();
	private JTextField tel2tf = new JTextField();
	private Vector tellvc = new Vector();
	private JComboBox tell1tf = new JComboBox(tellvc);
	private JTextField tell2tf = new JTextField();
	private JTextField tell3tf = new JTextField();
	private Vector buvc = new Vector();
	private JComboBox butf = new JComboBox(buvc);
	private Vector jikvc = new Vector();
	private JComboBox jiktf = new JComboBox(jikvc);
	private JTextArea worktf = new JTextArea(5,20);
	private JTextField addrtf = new JTextField();
	private JScrollPane workjsp = new JScrollPane(worktf);
	
	
	// ���� ���� ��
	private JLabel namelb1 = new JLabel("�̸� : ", JLabel.RIGHT);
	private JLabel juminlb1 = new JLabel("�ֹι�ȣ : ", JLabel.RIGHT);
	private JLabel idlb1 = new JLabel("���̵� : ", JLabel.RIGHT);
	private JLabel passlb1 = new JLabel("��й�ȣ : ", JLabel.RIGHT);
	private JLabel pass1lb1 = new JLabel("��й�ȣ Ȯ�� : ", JLabel.RIGHT);
	private JLabel tellb1 = new JLabel("��ȭ��ȣ : ", JLabel.RIGHT);
	private JLabel tel1lb1 = new JLabel("�޴��� : ", JLabel.RIGHT);
	private JLabel addrlb1 = new JLabel("�ּ� : ", JLabel.RIGHT);
	private JLabel bulb1 = new JLabel("�μ� : ", JLabel.RIGHT);
	private JLabel jiklb1 = new JLabel("��å : ", JLabel.RIGHT);
	private JLabel worklb1 = new JLabel("�������� �ۼ� : ", JLabel.RIGHT);
	private JButton regbt1 = new JButton("����");
	private JButton clearbt1 = new JButton("Clear");
	private JLabel nametf1 = new JLabel("Guest");
	private JLabel jumintf1 = new JLabel("******-*******");
	//private JLabel jumin1tf1 = new JLabel("******-*******");
	//private JButton juminbt1 = new JButton("��ø");
	private JLabel idtf1 = new JLabel("Guest");
	//private JButton idbt1 = new JButton("��ø");
	private JPasswordField passtf1 = new JPasswordField("*************");
	private JPasswordField pass1tf1 = new JPasswordField("*************");
	private Vector telvc1 = new Vector();
	private JComboBox teltf1 = new JComboBox(telvc1);
	private JTextField tel1tf1 = new JTextField();
	private JTextField tel2tf1 = new JTextField();
	private Vector tellvc1 = new Vector();
	private JComboBox tell1tf1 = new JComboBox(tellvc1);
	private JTextField tell2tf1 = new JTextField();
	private JTextField tell3tf1 = new JTextField();
	private Vector buvc1 = new Vector();
	private JComboBox butf1 = new JComboBox(buvc1);
	private Vector jikvc1 = new Vector();
	private JComboBox jiktf1 = new JComboBox(jikvc1);
	private JTextArea worktf1 = new JTextArea(5,20);
	private JTextField addrtf1 = new JTextField();
	private JScrollPane workjsp1 = new JScrollPane(worktf1);
	
	// �˻� �� !
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton namerb = new JRadioButton("�̸����� �˻�",true);
	private JRadioButton juminrb = new JRadioButton("�ֹι�ȣ�� �˻�");
	private JRadioButton telrb = new JRadioButton("��ȭ��ȣ�� �˻�");
	private JRadioButton tel1rb = new JRadioButton("�޴������� �˻�");
	private JRadioButton idrb = new JRadioButton("ID ���� �˻�");
	
	private JLabel searchlb = new JLabel("�˻� �ʵ�",JLabel.RIGHT);
	private JTextField searchtf = new JTextField();
	private JButton searchbt = new JButton("�˻�");
	private JLabel viewlb = new JLabel("��� ǥ�� : ", JLabel.RIGHT);
	private Vector viewvc = new Vector();
	private JList viewli = new JList(viewvc);
	private JScrollPane viewjsp = new JScrollPane(viewli);
	private JButton changebt = new JButton("�ش� ����� ���� ���� �� �󼼺���");
	// ���� �� !
	private JLabel dellb = new JLabel("������ ����� �����ϼ���.");
	private JButton delbt = new JButton("üũ�� ����� ����");
	private JButton delclearbt = new JButton("Clear Check");
	private String[] headername = { "��ȣ","����","���̵�","�̸�","�ֹι�ȣ","��ȭ��ȣ","�޴�����ȣ","�ּ�","�μ�","����","��������"};
	private DefaultTableModel dtm = new DefaultTableModel(headername,10);
	private DefaultTableColumnModel dtcm = new DefaultTableColumnModel();
	private DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
	private JTable jt = new JTable(dtm,dtcm,dlsm);
	private JScrollPane tablejsp = new JScrollPane(jt);
	private TableColumn[] tc = new TableColumn[11];
	private DefaultTableCellRenderer[] dtcr = new DefaultTableCellRenderer[11];
	private DefaultCellEditor[] dce  = new DefaultCellEditor[11];
	private JTableHeader jth = new JTableHeader(dtcm);
	
	// Ʈ�� ����
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("�ֽ�ȸ�� (��)");
	private DefaultTreeModel treemodel = new DefaultTreeModel(root);
	private JTree tree = new JTree(treemodel);
	private JScrollPane treejsp = new JScrollPane(tree);
	
	//�μ� ���� ���� ��� ..
	private static int busetnum = 0 ;
	private Vector busetvc = new Vector();
	
	// ����� ���� ��� ..
	private Vector personvc = new Vector();
	
	// ���� ���� ��� ...
	private JFileChooser jfc = new JFileChooser();
	
	
	public Exam02_sub(){
		super("�λ���� (ERP) ");
		this.init();
		this.start();
		this.setSize(800,500);
		this.setVisible(true);
		//Ȱ��ȭ �� â ��ġ ���� 
		Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int)(di.getWidth() / 2 - di1.getWidth() / 2), (int)(di.getHeight() / 2 - di1.getHeight() / 2));
		
	}
	
	public void init(){
		con = this.getContentPane();
		con.setLayout(new BorderLayout(5,5));
		
		
		// ��üȭ�� ��ܺ�
		jl.setFont(new Font("�ٴ�ü",Font.BOLD,15));
		con.add("North",jl);
		
		
		// ��üȭ�� �߾Ӻ�
			//���Ǹ� ���� �κ�
		jpjp.add("North",jljl);
		jpjp.add("Center",treejsp);
		jpjp.setBorder(new BevelBorder(BevelBorder.RAISED));
		jsp.setLeftComponent(jpjp); // ���Ǹ��� ����Ʈ ������Ʈ �߰� 
		
			// 	���Ǹ� ������ �κ�
		
		this.initjpjpjp();
		this.initjpjpjp1();
		this.initjpjpjp2();
		this.initjpjpjp3();
		
		jtb.addTab("����� ���", jpjpjp);
		jtb.addTab("�˻�", jpjpjp1);
		jtb.addTab("����", jpjpjp2);
		jtb.addTab("���� ����", jpjpjp3);
		
		jsp.setRightComponent(jtb); // ���Ǹ��� ����Ʈ ������Ʈ �߰� 
		jsp.setOneTouchExpandable(true); // ������ ���м����� ��ư���� ���� ���� ��ư 
		jsp.setDividerSize(20); // ������ ���м� ������ 
		jsp.setDividerLocation(120); // �ε��Ǿ�����, ���Ǹ� ���� ����
		con.add("Center",jsp);
		
		
		// ��üȭ�� �ϴܺ�
		jp1.add("West",jlb);
		jp1.add("Center",jtf);
		jp1.add("East",jbt1);
		
		
		// �г� 3������, �׸��� 1�� 2����, ��ư �ΰ� ����
		jp3.add(jbt2);
		jp3.add(jbt3);
		//�г� 4������, �׸��� 1�� 2����, 1���� �Ϲ� �󺧷� �����, 2����, ��ư �ϳ� ����.
		jp4.add(new JLabel());
		jp4.add(jbt4);
		// jp2 �� �׸��� ���̾ƿ����ν�, 1�� 2���� ������, �г� 3,4�� �߰� 
		jp2.add(jp3);
		jp2.add(jp4);
		// jp�г��� 2�� 1�� �׸���ν�, 1�࿡ jp1 ��, 2�࿡ jp2 �� �߰���.
		jp.add(jp1);
		jp.add(jp2);
		con.add("South",jp);
		
		// �������� ��ư false
		jtb.setEnabledAt(3, false);
		
	}
	//����� �� ȭ�� ���� 
	private void initjpjpjp(){
		// West ���� ( �� ) 
				JPanel p = new JPanel(new GridLayout(10,1)); //10�� 1��
				
				p.add(namelb);
				p.add(juminlb);
				p.add(idlb);
				p.add(passlb);
				p.add(pass1lb);
				p.add(tellb);
				p.add(tel1lb);
				p.add(addrlb);
				p.add(bulb);
				p.add(jiklb);
				jpjpjp.add("West",p);
				
				// ���� ���� ( �ʵ��..)
				JPanel p1 = new JPanel(new GridLayout(10,1));
				p1.add(nametf);
				JPanel p2 = new JPanel(new BorderLayout(10,10));
				
				JPanel p2_1 = new JPanel(new GridLayout(1,2,5,0));
				p2_1.add(jumintf);
				p2_1.add(jumin1tf);
				p2.add("Center",p2_1);
				p2.add("East",juminbt); // �ֹ� ��ư �Ϸ� 
				p1.add(p2); // �ֹι�ư �߰� 
				
				JPanel p3 = new JPanel(new BorderLayout(10,0));
				p3.add("Center",idtf);
				p3.add("East",idbt);
				p1.add(p3);
				p1.add(passtf);
				p1.add(pass1tf);
				
				// �г� p4  ��ȭ��ȣ ���� 
				JPanel p4 = new JPanel(new BorderLayout(5,0));
				telvc.addElement(" 02       ");
				telvc.addElement(" 063       ");
				telvc.addElement(" 062       ");
				telvc.addElement(" 061       ");
				telvc.addElement(" 053       ");
				telvc.addElement(" 054       ");
				p4.add("West",teltf);
				JPanel p4_1 = new JPanel(new GridLayout(1,2,5,0));
				p4_1.add(tel1tf);
				p4_1.add(tel2tf);
				p4.add("Center",p4_1);
				p1.add(p4);
				// �г� p4  �� 
				
				//�г� 5 �޴��� ��ȣ ���� 
				JPanel p5 = new JPanel(new BorderLayout(5,0));
				tellvc.addElement(" 010       ");
				tellvc.addElement(" 011       ");
				tellvc.addElement(" 012       ");
				tellvc.addElement(" 013       ");
				tellvc.addElement(" 014       ");
				tellvc.addElement(" 015       ");
				
				p5.add("West",tell1tf);
				JPanel p5_1 = new JPanel(new GridLayout(1,2,5,0));
				p5_1.add(tell2tf);
				p5_1.add(tell3tf);
				p5.add("Center",p5_1);
				p1.add(p5);
				// �г� 5 �޴��� ��ȣ ���� �� 
				
				p1.add(addrtf);
				p1.add(butf);
				p1.add(jiktf);
				jpjpjp.add("Center",p1);
				
				//  ���� �κ� 
				JPanel p22 = new JPanel(new BorderLayout(0,5));
				p22.add("West",worklb);
				p22.add("Center",workjsp);
				JPanel p22_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				p22_1.add(regbt);
				p22_1.add(clearbt);
				p22.add("South",p22_1);
				jpjpjp.add("South",p22);
		
	}
	//  ** �˻� �� **
	private void initjpjpjp1(){
		// �˻� ���� ��ܺ� 
		JPanel p1 = new JPanel(new GridLayout(5,1));
			// ������ư �׷� ���� 
			bg.add(namerb);
			bg.add(juminrb);
			bg.add(telrb);
			bg.add(tel1rb);
			bg.add(idrb);
		p1.add(namerb);
		p1.add(juminrb);
		p1.add(telrb);
		p1.add(tel1rb);
		p1.add(idrb);
		jpjpjp1.add("North",p1);
		// �˻��� ���� 
		JPanel p2 = new JPanel(new BorderLayout());
		JPanel p3 = new JPanel(new BorderLayout());
		p3.add("West",searchlb);
		p3.add("Center",searchtf);
		p3.add("East",searchbt);
		p2.add("North",p3);       // p2�г��� �� 
		JPanel p4 = new JPanel(new BorderLayout());
		p4.add("West",viewlb);
		p4.add("Center",viewjsp);
		p2.add("Center",p4);     // p2 �г��� ���� 
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p5.add("South",changebt);
		p2.add("South",p5);      // p2 �г��� �ϴ� 
		jpjpjp1.add("Center",p2);
	}
	
//  ** ���� �� **
	private void initjpjpjp2(){
		
		jpjpjp2.add("North",dellb); // ��ܺ� �� �ϳ� 
		JPanel ppp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ppp.add(delbt);
		ppp.add(delclearbt);
		jpjpjp2.add("South",ppp); //�ϴܺ� ��ư �ΰ� 
		
		//���̺� ���� 
		for(int i =0 ; i < 11 ; i ++){
			dtcr[i] = new DefaultTableCellRenderer();
			if(i == 1){
				dce[i] = new DefaultCellEditor(new JCheckBox("",false));
			}
			else{
				dce[i] = new DefaultCellEditor(new JTextField());
			}
			
			tc[i] = new TableColumn(i,75,dtcr[i],dce[i]	);
			tc[i].setHeaderValue(headername[i]);
			dtcm.addColumn(tc[i]);
		}
		dtcr[0].setBackground(Color.LIGHT_GRAY);
		dtcr[0].setHorizontalAlignment(JLabel.CENTER);
		dtcr[1].setHorizontalAlignment(JLabel.CENTER);
		
		for(int i = 0 ; i < 10 ; i ++){
			jt.setValueAt(String.valueOf(i+1), i, 0); // i �� , 0�� 
		}
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // ������¡ �� 
		jth.setReorderingAllowed(false); // �������� �� 
		jpjpjp2.add("Center",tablejsp); // �߾Ӻ� ���̺� 
	
	}
	
	//  ** ���� �� **
	private void initjpjpjp3(){
		// West ���� ( �� ) 
				JPanel p = new JPanel(new GridLayout(10,1)); //10�� 1��
				
				p.add(namelb1);
				p.add(juminlb1);
				p.add(idlb1);
				p.add(passlb1);
				p.add(pass1lb1);
				p.add(tellb1);
				p.add(tel1lb1);
				p.add(addrlb1);
				p.add(bulb1);
				p.add(jiklb1);
				jpjpjp3.add("West",p);
				
				// ���� ���� ( �ʵ��..)
				JPanel p1 = new JPanel(new GridLayout(10,1));
				p1.add(nametf1);
				JPanel p2 = new JPanel(new BorderLayout(10,10));
				
				//JPanel p2_1 = new JPanel(new GridLayout(1,2,5,0));
				//p2_1.add(jumintf1);
				//p2_1.add(jumin1tf1);
				//p2.add("Center",p2_1);
				//p2.add("East",juminbt1); // �ֹ� ��ư �Ϸ� 
				p1.add(jumintf1); // �ֹι�ư �߰� 
				
				//JPanel p3 = new JPanel(new BorderLayout(10,0));
				//p3.add("Center",idtf1);
				//p3.add("East",idbt1);
				p1.add(idtf1);
				p1.add(passtf1);
				p1.add(pass1tf1);
				
				// �г� p4  ��ȭ��ȣ ���� 
				JPanel p4 = new JPanel(new BorderLayout(5,0));

				telvc1.addElement(" 02       ");
				telvc1.addElement(" 063       ");
				telvc1.addElement(" 062       ");
				telvc1.addElement(" 061       ");
				telvc1.addElement(" 053       ");
				telvc1.addElement(" 054       ");
				p4.add("West",teltf1);
				JPanel p4_1 = new JPanel(new GridLayout(1,2,5,0));
				p4_1.add(tel1tf1);
				p4_1.add(tel2tf1);
				p4.add("Center",p4_1);
				p1.add(p4);
				// �г� p4  �� 
				
				//�г� 5 �޴��� ��ȣ ���� 
				JPanel p5 = new JPanel(new BorderLayout(5,0));

				tellvc1.addElement(" 010       ");
				tellvc1.addElement(" 011       ");
				tellvc1.addElement(" 012       ");
				tellvc1.addElement(" 013       ");
				tellvc1.addElement(" 014       ");
				tellvc1.addElement(" 015       ");
				
				p5.add("West",tell1tf1);
				JPanel p5_1 = new JPanel(new GridLayout(1,2,5,0));
				p5_1.add(tell2tf1);
				p5_1.add(tell3tf1);
				p5.add("Center",p5_1);
				p1.add(p5);
				// �г� 5 �޴��� ��ȣ ���� �� 
				
				p1.add(addrtf1);
				p1.add(butf1);
				p1.add(jiktf1);
				jpjpjp3.add("Center",p1);
				
				//  ���� �κ� 
				JPanel p22 = new JPanel(new BorderLayout(0,5));
				p22.add("West",worklb1);
				p22.add("Center",workjsp1);
				JPanel p22_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				p22_1.add(regbt1);
				p22_1.add(clearbt1);
				p22.add("South",p22_1);
				jpjpjp3.add("South",p22);
				
				
				
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbt4.addActionListener(this);
		jtf.addActionListener(this);
		jbt1.addActionListener(this);
		nametf.addFocusListener(this);
		regbt.addActionListener(this);
		clearbt.addActionListener(this);
		juminbt.addActionListener(this);
		idbt.addActionListener(this);
		searchtf.addActionListener(this);
		searchbt.addActionListener(this);
		changebt.addActionListener(this);
		regbt1.addActionListener(this);
		jtb.addChangeListener(this);
		delbt.addActionListener(this);
		delclearbt.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == jbt4){  //Ŭ���� ��ư 
			System.exit(0);
		}
		else if(e.getSource() == jtf || e.getSource() == jbt1){ // �μ��߰� �ʵ�� ��ư 
			String imsi = jtf.getText().trim();
			if(imsi == null || imsi.length() == 0){ // �Է¾������� ���� 
				return;
			}
			BuSet bs = new BuSet(imsi,busetnum); // �μ��� Ŭ������ �ڵ鷯�� ��� 
			busetnum++;  
			busetvc.add(bs);
			jtf.setText("");
			this.treerefresh();  //Ʈ�������� �޼ҵ� �ϴܺ� ���� ��....
			
		}
		else if(e.getSource() == regbt){ // ��� ��ư 
			Person ps = new Person(nametf.getText().trim(), jumintf.getText().trim() + "-" + jumin1tf.getText().trim(),
					idtf.getText().trim(), new String(passtf.getPassword()), 
					(String)teltf.getSelectedItem() + "-" + tel1tf.getText().trim() + "-" + tel2tf.getText().trim(),
					(String)tell1tf.getSelectedItem() + "-" + tell2tf.getText().trim() + "-" + tell3tf.getText().trim(),
					addrtf.getText().trim(), (String)butf.getSelectedItem(), (String)jiktf.getSelectedItem(), 
					worktf.getText().trim());
			personvc.add(ps); // �޽� Ŭ���� ���Ϳ� �㤷�� 
		
			nametf.setText(""); // ����� �ʱ�ȭ 
			jumintf.setText("");
			jumin1tf.setText("");
			idtf.setText("");
			passtf.setText("");
			pass1tf.setText("");
			teltf.setSelectedIndex(0);
			tel1tf.setText("");
			tel2tf.setText("");
			tell1tf.setSelectedIndex(0);
			tell2tf.setText("");
			tell3tf.setText("");
			addrtf.setText("");
			butf.setSelectedIndex(0);
			jiktf.setSelectedIndex(0);
			worktf.setText("");
			this.treerefresh();
		}
		else if(e.getSource() == clearbt){ // Ŭ���� bt 
			nametf.setText("");
			jumintf.setText("");
			jumin1tf.setText("");
			idtf.setText("");
			passtf.setText("");
			pass1tf.setText("");
			teltf.setSelectedIndex(0);
			tel1tf.setText("");
			tel2tf.setText("");
			tell1tf.setSelectedIndex(0);
			tell2tf.setText("");
			tell3tf.setText("");
			addrtf.setText("");
			butf.setSelectedIndex(0);
			jiktf.setSelectedIndex(0);
			worktf.setText("");
		}
		else if(e.getSource() == juminbt){ //�ֹε�Ϲ�ȣ �ߺ�Ȯ�� 
			String str = jumintf.getText().trim() +"-"+ jumin1tf.getText().trim();
			if(personvc.size() == 0){
				String imsi = jumintf.getText().trim();
				if(imsi == null || imsi.length() == 0){
					JOptionPane.showMessageDialog(this, " �ֹ� ��� ��ȣ�� �Է� �ϼ��� ");
					
				}else{
				JOptionPane.showMessageDialog(this, " ��� ������ �ֹ� ��ȣ �Դϴ�.");
				idtf.requestFocus();
				}
			}
			for(int i = 0 ; i <personvc.size(); i ++){ 
				Person ps = (Person)personvc.elementAt(i);
				if(str.equals(ps.jumin)){
					JOptionPane.showMessageDialog(this, "��� ���� �ֹ� ��ȣ �Դϴ�.");
					jumintf.setText("");
					jumin1tf.setText("");
					jumintf.requestFocus();
					return;
				}
				else{
					JOptionPane.showMessageDialog(this, " ��� ������ �ֹ� ��ȣ �Դϴ�.");
					idtf.requestFocus();
				}
			}
		}
		else if(e.getSource() == idbt){ // ���̵� �ߺ� Ȯ�� 
			String str = idtf.getText().trim();
		
			if(personvc.size() == 0){
				String imsi = idtf.getText().trim();
				if(imsi == null || imsi.length() == 0){
					JOptionPane.showMessageDialog(this, " ���̵� �Է� �ϼ��� ");
					
				}else{
				JOptionPane.showMessageDialog(this, " ��� ������ ���̵� �Դϴ�.");
				passtf.requestFocus();
				}
			}
			for(int i = 0 ; i <personvc.size(); i ++){
				Person ps = (Person)personvc.elementAt(i);
				if(str.equals(ps.id)){
					JOptionPane.showMessageDialog(this, "��� ���� ���̵� �Դϴ�.");
					idtf.setText("");
					
					idtf.requestFocus();
					return;
				}
				else{
					JOptionPane.showMessageDialog(this, " ��� ������ ���̵� �Դϴ�.");
					passtf.requestFocus();
				}
			}
		}
		
		// ��ġ �ʵ�� ��ư 
		else if(e.getSource() == searchtf || e.getSource() == searchbt){
			// �˻��� ���� ��������..
			String str = searchtf.getText().trim();
			// �����Ͱ� �ִ��� ���� �˻��ϰ�..
			if(personvc.size() == 0){
				JOptionPane.showMessageDialog(this, " �����Ͱ� �������� �ʽ��ϴ�.");
			}
			// �˻� ��� ���� ���� �ʱ�ȭ �صΰ�.. 
			viewvc.clear();
			// ���� ���鼭 �˻��Ѵ�..
			for(int i = 0 ; i < personvc.size() ; i ++){
				Person ps = (Person)personvc.elementAt(i);
				int k = -1; // �˻������ �´� ��� ������ �˻��� ���ؼ�.. k ���� ���� �ϰ�..
				if(namerb.isSelected()){ // �̸��� ������, k ������ �ٲ㼭, ���Ϳ� �����ϵ��� �Ѵ�.
					if(ps.name.equals(str)){
						k = i;
					}
				}
				else if(juminrb.isSelected()){ // �������� ��������...
					if(ps.jumin.equals(str)){
						k = i;
					}
				}
				else if(telrb.isSelected()){
					if(ps.tel.equals(str)){
						k = i;
					}
				}
				else if(tel1rb.isSelected()){
					if(ps.tel1.equals(str)){
						k = i;
					}
				}
				else if(idrb.isSelected()){
					if(ps.id.equals(str)){
						k = i;
					}
				}
				//�˻��Ǿ��ٸ�..��.. ������ �ٲ�� �ִٸ�.. �����͸� ���Ϳ� ����...
				if(k != -1){ 
					viewvc.add(ps.name + ":" + ps.jumin + ":" + ps.id);			
				}
			}
			viewli.setListData(viewvc); // ������ ������, �ش� ���͸�, ����Ʈ�� �߰� 
			viewli.updateUI(); // ����Ʈ ������Ʈ 
		}
		else if(e.getSource() == changebt){
			String str = (String)viewli.getSelectedValue(); //������ ��� �̾ƿ�..
			str = str.substring(str.indexOf(":") + 1, str.lastIndexOf(":")); // ":" �� ������� �Ľ� 
			jtb.setSelectedIndex(3); // ���� ���� ������ �̵� ��Ŵ
			
			butf.updateUI(); // �μ� �ؽ�Ʈ�ʵ� ������Ʈ 
			// ��å �޺��ڽ� 
			jikvc1.clear();
			jikvc1.add("����");
			jikvc1.add("����");
			jikvc1.add("����");
			jikvc1.add("�븮");
			jikvc1.add("���");
			
			// �μ� �޺��ڽ� 
			buvc1.clear();
			for(int i = 0 ; i < busetvc.size() ; i ++){
				BuSet imsi = (BuSet)busetvc.elementAt(i);
				buvc1.add(imsi.getBuname());
			}
	
			int kkk = -1;
			for(int i = 0 ; i < personvc.size() ; i ++){
				Person ps = (Person)personvc.elementAt(i);
				if(ps.jumin.equals(str)){
					kkk = i;
					break;
				}
			}
			if(kkk == -1){ // ��� ������.. �̰� ���� �� ���� ��..
				JOptionPane.showMessageDialog(this, "�ɰ��� ���� �߻�!!!");
				return;
			}
			Person pps = (Person)personvc.elementAt(kkk);
			nametf1.setText(pps.name);
			jumintf1.setText(pps.jumin);
			idtf1.setText(pps.id);
			String imsi = pps.tel.substring(0, pps.tel.indexOf("-"));
			for(int i = 0; i < teltf1.getItemCount(); i++){
				if(imsi.equals(teltf1.getItemAt(i))){
					teltf1.setSelectedIndex(i);
					break;
				}
			}
			tel1tf1.setText(pps.tel.substring(pps.tel.indexOf("-") + 1, pps.tel.lastIndexOf("-")));
			tel2tf1.setText(pps.tel.substring(pps.tel.lastIndexOf("-") + 1));
			

			
			imsi = pps.tel1.substring(0, pps.tel1.indexOf("-"));
			for(int i = 0; i < tell1tf1.getItemCount(); i++){
				if(imsi.equals(tell1tf1.getItemAt(i))){
					tell1tf1.setSelectedIndex(i);
					break;
				}
			}
			
			tell2tf1.setText(pps.tel1.substring(pps.tel1.indexOf("-") + 1, pps.tel1.lastIndexOf("-")));
			tell3tf1.setText(pps.tel1.substring(pps.tel1.lastIndexOf("-") + 1));
			
			addrtf1.setText(pps.addr);
			imsi = pps.buname;
			for(int i = 0; i < butf1.getItemCount(); i++){
				if(imsi.equals(butf1.getItemAt(i))){
					butf1.setSelectedIndex(i);
					break;
				}
			}
			
			imsi = pps.jik;
			for(int i = 0; i < jiktf1.getItemCount(); i++){
				if(imsi.equals(jiktf1.getItemAt(i))){
					jiktf1.setSelectedIndex(i);
					break;
				}
			}
			
			worktf1.setText(pps.work);
		}
		else if(e.getSource() == regbt1){
			String str = jumintf1.getText().trim();
			
			for(int i = 0 ; i < personvc.size(); i ++){
				Person ps = (Person)personvc.elementAt(i);
				
				if(ps.jumin.equals(str)){
					
					ps.pass = new String(passtf1.getPassword()); // �ݵ�� �ٲ����.
					ps.tel = (String)teltf1.getSelectedItem() + "-" + tel1tf1.getText().trim() + "-" + tel2tf1.getText().trim();
					ps.tel1 = (String)tell1tf1.getSelectedItem() + "-" + tell2tf1.getText().trim() + "-" + tell3tf1.getText().trim();
					ps.addr = addrtf1.getText().trim();
					ps.buname = (String)butf1.getSelectedItem();
					ps.jik = (String)jiktf1.getSelectedItem();
					ps.work = worktf1.getText().trim();
					JOptionPane.showMessageDialog(this, "���� ���� �Ǿ����ϴ�.");
					break;
				}
			}
			jtb.setSelectedIndex(1); // ���� �Ϸ� ��, �˻� ������ ��ȯ 
		}
		else if(e.getSource() == delbt){ // ������ư ������ ��.. 
			int imsi = personvc.size();
			for(int i = 0 , j = 0; i < imsi ; i++, j ++){ // i �� ���̺��� ��ġ��.. j �� person��ü�� ������ �����, ��ġ��°�� �ڷ� ��ĭ�� �̵���Ŵ..
				if(( (Boolean)jt.getValueAt(i, 1) ).equals(new Boolean(true))){
					personvc.removeElementAt(j);
					j--;
				}
			}
			dtm.setRowCount(personvc.size()); // �� ������..
			for(int i = 0 ; i <personvc.size() ; i ++){
				Person ps = (Person)personvc.elementAt(i);
				jt.setValueAt(String.valueOf(i+1), i, 0); // i�� 0������, ��ȣ 1~�� 
				//��������, üũ�ڽ��� ����...
				jt.setValueAt((ps.id).trim(), i, 2); // 2��°����, i�� 2���� �� ���̵�..
				jt.setValueAt((ps.name).trim(), i, 3); // i�� 3���� �� �̸� .. 
				jt.setValueAt((ps.jumin).trim(),i,4); // i�� 4���� �ֹ� ��......
				jt.setValueAt((ps.tel).trim(), i, 5);
				jt.setValueAt((ps.tel1).trim(), i, 6);
				jt.setValueAt((ps.addr).trim(), i, 7);
				jt.setValueAt((ps.buname).trim(), i,8);
				jt.setValueAt((ps.jik).trim(), i, 9);
				jt.setValueAt((ps.work).trim(), i, 10);
				
				this.treerefresh();
			}
		}
		else if(e.getSource() == delclearbt){
			for(int i = 0 ; i < personvc.size(); i++){
				jt.setValueAt(new Boolean(false), i, 1); // i ��  , 1��° ��
			}
		}
		else if(e.getSource() == jbt2){
			jfc.showSaveDialog(this);
			try{
				String strstr = jfc.getSelectedFile().toString(); // ��ü ��θ� ����..
				String strstr1 = strstr+".buset"; 
				String strstr2 = strstr+".person";
			File fff = new File(strstr1);
			FileOutputStream fos = new FileOutputStream(fff);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(busetvc);
			oos.close();
			
			bos.close();
			fos.close();
			File fff1 = new File(strstr2);
			FileOutputStream fos1 = new FileOutputStream(fff1);
			BufferedOutputStream bos1 = new BufferedOutputStream(fos1);
			ObjectOutputStream oos1 = new ObjectOutputStream(bos1);
			oos1.writeObject(personvc);
			oos1.close();
			bos1.close();
			fos1.close();
			}catch(IOException ee){}
		}
		else if(e.getSource() == jbt3){
			jfc.showOpenDialog(this);
			String strstr = jfc.getSelectedFile().toString(); // ��ü ��θ� ����..
			strstr = strstr.substring(0,strstr.indexOf(".")); //Ȯ���� ��������.. 
			String strstr1 = strstr+".buset"; 
			String strstr2 = strstr+".person";
		try{	
		File fff = new File(strstr1);
		FileInputStream fos = new FileInputStream(fff);
		BufferedInputStream bos = new BufferedInputStream(fos);
		ObjectInputStream oos = new ObjectInputStream(bos);
		busetvc.clear();
		busetvc = (Vector)oos.readObject();
		oos.close();
		bos.close();
		fos.close();
		File fff1 = new File(strstr2);
		FileInputStream fos1 = new FileInputStream(fff1);
		BufferedInputStream bos1 = new BufferedInputStream(fos1);
		ObjectInputStream oos1 = new ObjectInputStream(bos1);
		personvc.clear();
		personvc = (Vector)oos1.readObject();
		oos1.close();
		bos1.close();
		fos1.close();
		}catch(Exception ee){}
		this.treerefresh();
		}
	}
	public void treerefresh(){ 
		//Ʈ����忡, �μ��� ��忡 �߰���Ŵ.
		DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[busetvc.size()];
		root.removeAllChildren();
		for(int i = 0 ; i < node.length ; i ++	){
			BuSet imsi = (BuSet)busetvc.elementAt(i);
			node[i] = new DefaultMutableTreeNode(imsi.getBuname());
			root.add(node[i]);
		}
		tree.updateUI();
		// ���� person ��ü�� �Ѿ������... �Ʒ� ����� .
		if(personvc.size() !=0){
			DefaultMutableTreeNode[] childnode = new DefaultMutableTreeNode[personvc.size()]; // ��� ���� ��..
			for(int i = 0 ; i < node.length ; i ++){ 
				node[i].removeAllChildren();     // ������ �ִ� ��� ��� ����..
			}
			for(int i = 0 ; i < personvc.size() ; i ++){
				Person ps = (Person) personvc.elementAt(i); // �ϳ��� �̾ƿͼ�...
				// ���ϵ� ��� ���� 
				childnode[i] = new DefaultMutableTreeNode(ps.name);
				// �μ����� ���� �Ϳ�, ���ϵ� ��� �߰� .. ���迭�� �������� 
				for(int j = 0 ; j < node.length ; j ++){
					if(ps.buname.equals((String)node[j].toString())){
						node[j].add(childnode[i]);
						break;
					}
				}
			}
		}
		tree.updateUI();
	}
	
	public void focusGained(FocusEvent e){
		if(e.getSource() == nametf){
			butf.updateUI();
			// ��å �޺��ڽ� 
			jikvc.clear();
			jikvc.add("����");
			jikvc.add("����");
			jikvc.add("����");
			jikvc.add("�븮");
			jikvc.add("���");
			
			// �μ� �޺��ڽ� 
			buvc.clear();
			for(int i = 0 ; i < busetvc.size() ; i ++){
				BuSet imsi = (BuSet)busetvc.elementAt(i);
				buvc.add(imsi.getBuname());
			}
	
			
			
		}
		
	}
	public void focusLost(FocusEvent e){
		
	}
	public void stateChanged(ChangeEvent e){
		//���� �� ����� 
		if(e.getSource() == jtb){
			if(jtb.getSelectedIndex() == 2){ // ���� �� �̶��..
				dtm.setRowCount(personvc.size());  // �޽� ���� ũ�⸸ŭ �� ����
				for(int i = 0 ; i <personvc.size() ; i ++){
					Person ps = (Person)personvc.elementAt(i);
					jt.setValueAt(String.valueOf(i+1), i, 0); // i�� 0������, ��ȣ 1~�� 
					//��������, üũ�ڽ��� ����...
					jt.setValueAt((ps.id).trim(), i, 2); // 2��°����, i�� 2���� �� ���̵�..
					jt.setValueAt((ps.name).trim(), i, 3); // i�� 3���� �� �̸� .. 
					jt.setValueAt((ps.jumin).trim(),i,4); // i�� 4���� �ֹ� ��......
					jt.setValueAt((ps.tel).trim(), i, 5);
					jt.setValueAt((ps.tel1).trim(), i, 6);
					jt.setValueAt((ps.addr).trim(), i, 7);
					jt.setValueAt((ps.buname).trim(), i,8);
					jt.setValueAt((ps.jik).trim(), i, 9);
					jt.setValueAt((ps.work).trim(), i, 10);
					
				}
			}
		}
	}
}

public class ERP {
	
	public static void main(String[] ar){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception ee){}
		Exam02_sub es = new Exam02_sub();
	}
}