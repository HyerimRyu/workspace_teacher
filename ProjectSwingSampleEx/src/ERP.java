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


//부서셋팅 클래스 
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
	// 프라이빗 해제 하였음.. 
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
	//전체화면의 North
	private JLabel jl = new JLabel(" < 인사 관리 > ",JLabel.CENTER);
	//전체화면의 Center
	private JSplitPane jsp = new JSplitPane();
		//센터의 West 지역 
	private JPanel jpjp = new JPanel(new BorderLayout());
	private JLabel jljl = new JLabel("등록 인원",JLabel.CENTER);
	//private JTree tree = new JTree();
	//private JScrollPane treejsp = new JScrollPane(tree);
	
		//센터의 중앙부
	private JTabbedPane jtb = new JTabbedPane();
	private JPanel jpjpjp = new JPanel(new BorderLayout());
	private JPanel jpjpjp1 = new JPanel(new BorderLayout());
	private JPanel jpjpjp2 = new JPanel(new BorderLayout());
	private JPanel jpjpjp3 = new JPanel(new BorderLayout());
	
	
	
	
	//전체화면의 South
	private JPanel jp = new JPanel(new GridLayout(2,1)); //2행 1열
	private JPanel jp1 = new JPanel(new BorderLayout()); 
	private JPanel jp2 = new JPanel(new GridLayout(1,2)); //1행 2열 
	private JPanel jp3 = new JPanel(new GridLayout(1,2));
	private JPanel jp4 = new JPanel(new GridLayout(1,2));
	private JLabel jlb = new JLabel("부서명",JLabel.RIGHT);
	private JTextField jtf = new JTextField();
	private JButton jbt1 = new JButton("부서 추가");
	private JButton jbt2 = new JButton("파일로 저장");
	private JButton jbt3 = new JButton("불러 오기 ");
	private JButton jbt4 = new JButton("종료");
	
	// 사용자 등록 탭
	private JLabel namelb = new JLabel("이름 : ", JLabel.RIGHT);
	private JLabel juminlb = new JLabel("주민번호 : ", JLabel.RIGHT);
	private JLabel idlb = new JLabel("아이디 : ", JLabel.RIGHT);
	private JLabel passlb = new JLabel("비밀번호 : ", JLabel.RIGHT);
	private JLabel pass1lb = new JLabel("비밀번호 확인 : ", JLabel.RIGHT);
	private JLabel tellb = new JLabel("전화번호 : ", JLabel.RIGHT);
	private JLabel tel1lb = new JLabel("휴대폰 : ", JLabel.RIGHT);
	private JLabel addrlb = new JLabel("주소 : ", JLabel.RIGHT);
	private JLabel bulb = new JLabel("부서 : ", JLabel.RIGHT);
	private JLabel jiklb = new JLabel("직책 : ", JLabel.RIGHT);
	private JLabel worklb = new JLabel("업무내용 작성 : ", JLabel.RIGHT);
	private JButton regbt = new JButton("등록");
	private JButton clearbt = new JButton("Clear");
	private JTextField nametf = new JTextField();
	private JTextField jumintf = new JTextField();
	private JTextField jumin1tf = new JTextField();
	private JButton juminbt = new JButton("중첩");
	private JTextField idtf = new JTextField();
	private JButton idbt = new JButton("중첩");
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
	
	
	// 정보 수정 탭
	private JLabel namelb1 = new JLabel("이름 : ", JLabel.RIGHT);
	private JLabel juminlb1 = new JLabel("주민번호 : ", JLabel.RIGHT);
	private JLabel idlb1 = new JLabel("아이디 : ", JLabel.RIGHT);
	private JLabel passlb1 = new JLabel("비밀번호 : ", JLabel.RIGHT);
	private JLabel pass1lb1 = new JLabel("비밀번호 확인 : ", JLabel.RIGHT);
	private JLabel tellb1 = new JLabel("전화번호 : ", JLabel.RIGHT);
	private JLabel tel1lb1 = new JLabel("휴대폰 : ", JLabel.RIGHT);
	private JLabel addrlb1 = new JLabel("주소 : ", JLabel.RIGHT);
	private JLabel bulb1 = new JLabel("부서 : ", JLabel.RIGHT);
	private JLabel jiklb1 = new JLabel("직책 : ", JLabel.RIGHT);
	private JLabel worklb1 = new JLabel("업무내용 작성 : ", JLabel.RIGHT);
	private JButton regbt1 = new JButton("수정");
	private JButton clearbt1 = new JButton("Clear");
	private JLabel nametf1 = new JLabel("Guest");
	private JLabel jumintf1 = new JLabel("******-*******");
	//private JLabel jumin1tf1 = new JLabel("******-*******");
	//private JButton juminbt1 = new JButton("중첩");
	private JLabel idtf1 = new JLabel("Guest");
	//private JButton idbt1 = new JButton("중첩");
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
	
	// 검색 탭 !
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton namerb = new JRadioButton("이름으로 검색",true);
	private JRadioButton juminrb = new JRadioButton("주민번호로 검색");
	private JRadioButton telrb = new JRadioButton("전화번호로 검색");
	private JRadioButton tel1rb = new JRadioButton("휴대폰으로 검색");
	private JRadioButton idrb = new JRadioButton("ID 으로 검색");
	
	private JLabel searchlb = new JLabel("검색 필드",JLabel.RIGHT);
	private JTextField searchtf = new JTextField();
	private JButton searchbt = new JButton("검색");
	private JLabel viewlb = new JLabel("결과 표시 : ", JLabel.RIGHT);
	private Vector viewvc = new Vector();
	private JList viewli = new JList(viewvc);
	private JScrollPane viewjsp = new JScrollPane(viewli);
	private JButton changebt = new JButton("해당 사용자 정보 변경 및 상세보기");
	// 삭제 탭 !
	private JLabel dellb = new JLabel("삭제할 대상을 선택하세요.");
	private JButton delbt = new JButton("체크된 사용자 삭제");
	private JButton delclearbt = new JButton("Clear Check");
	private String[] headername = { "번호","삭제","아이디","이름","주민번호","전화번호","휴대폰번호","주소","부서","직위","업무내용"};
	private DefaultTableModel dtm = new DefaultTableModel(headername,10);
	private DefaultTableColumnModel dtcm = new DefaultTableColumnModel();
	private DefaultListSelectionModel dlsm = new DefaultListSelectionModel();
	private JTable jt = new JTable(dtm,dtcm,dlsm);
	private JScrollPane tablejsp = new JScrollPane(jt);
	private TableColumn[] tc = new TableColumn[11];
	private DefaultTableCellRenderer[] dtcr = new DefaultTableCellRenderer[11];
	private DefaultCellEditor[] dce  = new DefaultCellEditor[11];
	private JTableHeader jth = new JTableHeader(dtcm);
	
	// 트리 구성
	private DefaultMutableTreeNode root = new DefaultMutableTreeNode("주식회사 (주)");
	private DefaultTreeModel treemodel = new DefaultTreeModel(root);
	private JTree tree = new JTree(treemodel);
	private JScrollPane treejsp = new JScrollPane(tree);
	
	//부서 세팅 관련 멤버 ..
	private static int busetnum = 0 ;
	private Vector busetvc = new Vector();
	
	// 사용자 저장 멤버 ..
	private Vector personvc = new Vector();
	
	// 파일 저장 멤버 ...
	private JFileChooser jfc = new JFileChooser();
	
	
	public Exam02_sub(){
		super("인사관리 (ERP) ");
		this.init();
		this.start();
		this.setSize(800,500);
		this.setVisible(true);
		//활성화 시 창 위치 지정 
		Dimension di = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension di1 = this.getSize();
		this.setLocation((int)(di.getWidth() / 2 - di1.getWidth() / 2), (int)(di.getHeight() / 2 - di1.getHeight() / 2));
		
	}
	
	public void init(){
		con = this.getContentPane();
		con.setLayout(new BorderLayout(5,5));
		
		
		// 전체화면 상단부
		jl.setFont(new Font("바당체",Font.BOLD,15));
		con.add("North",jl);
		
		
		// 전체화면 중앙부
			//스피릿 왼쪽 부분
		jpjp.add("North",jljl);
		jpjp.add("Center",treejsp);
		jpjp.setBorder(new BevelBorder(BevelBorder.RAISED));
		jsp.setLeftComponent(jpjp); // 스피릿의 레프트 컴포넌트 추가 
		
			// 	스피릿 오른쪽 부분
		
		this.initjpjpjp();
		this.initjpjpjp1();
		this.initjpjpjp2();
		this.initjpjpjp3();
		
		jtb.addTab("사용자 등록", jpjpjp);
		jtb.addTab("검색", jpjpjp1);
		jtb.addTab("삭제", jpjpjp2);
		jtb.addTab("정보 수정", jpjpjp3);
		
		jsp.setRightComponent(jtb); // 스피릿의 라이트 컴포넌트 추가 
		jsp.setOneTouchExpandable(true); // 스프릿 구분선에서 버튼으로 숨김 보임 버튼 
		jsp.setDividerSize(20); // 스프릿 구분선 사이즈 
		jsp.setDividerLocation(120); // 로딩되었을때, 스피릿 비율 설정
		con.add("Center",jsp);
		
		
		// 전체화면 하단부
		jp1.add("West",jlb);
		jp1.add("Center",jtf);
		jp1.add("East",jbt1);
		
		
		// 패널 3번에는, 그리도 1행 2열로, 버튼 두개 넣음
		jp3.add(jbt2);
		jp3.add(jbt3);
		//패널 4번에는, 그리드 1행 2열로, 1열은 일반 라벨로 빈공간, 2열은, 버튼 하나 넣음.
		jp4.add(new JLabel());
		jp4.add(jbt4);
		// jp2 는 그리드 레이아웃으로써, 1행 2열로 나누고, 패널 3,4번 추가 
		jp2.add(jp3);
		jp2.add(jp4);
		// jp패널은 2행 1열 그리드로써, 1행에 jp1 을, 2행에 jp2 를 추가함.
		jp.add(jp1);
		jp.add(jp2);
		con.add("South",jp);
		
		// 정보수정 버튼 false
		jtb.setEnabledAt(3, false);
		
	}
	//사용자 탭 화면 구성 
	private void initjpjpjp(){
		// West 구역 ( 라벨 ) 
				JPanel p = new JPanel(new GridLayout(10,1)); //10행 1열
				
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
				
				// 센터 구역 ( 필드들..)
				JPanel p1 = new JPanel(new GridLayout(10,1));
				p1.add(nametf);
				JPanel p2 = new JPanel(new BorderLayout(10,10));
				
				JPanel p2_1 = new JPanel(new GridLayout(1,2,5,0));
				p2_1.add(jumintf);
				p2_1.add(jumin1tf);
				p2.add("Center",p2_1);
				p2.add("East",juminbt); // 주민 버튼 완료 
				p1.add(p2); // 주민버튼 추가 
				
				JPanel p3 = new JPanel(new BorderLayout(10,0));
				p3.add("Center",idtf);
				p3.add("East",idbt);
				p1.add(p3);
				p1.add(passtf);
				p1.add(pass1tf);
				
				// 패널 p4  전화번호 구역 
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
				// 패널 p4  끝 
				
				//패널 5 휴대폰 번호 구역 
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
				// 패널 5 휴대폰 번호 구역 끝 
				
				p1.add(addrtf);
				p1.add(butf);
				p1.add(jiktf);
				jpjpjp.add("Center",p1);
				
				//  바텀 부분 
				JPanel p22 = new JPanel(new BorderLayout(0,5));
				p22.add("West",worklb);
				p22.add("Center",workjsp);
				JPanel p22_1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				p22_1.add(regbt);
				p22_1.add(clearbt);
				p22.add("South",p22_1);
				jpjpjp.add("South",p22);
		
	}
	//  ** 검색 탭 **
	private void initjpjpjp1(){
		// 검색 텝의 상단부 
		JPanel p1 = new JPanel(new GridLayout(5,1));
			// 라디오버튼 그룹 지정 
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
		// 검색탭 센터 
		JPanel p2 = new JPanel(new BorderLayout());
		JPanel p3 = new JPanel(new BorderLayout());
		p3.add("West",searchlb);
		p3.add("Center",searchtf);
		p3.add("East",searchbt);
		p2.add("North",p3);       // p2패널의 북 
		JPanel p4 = new JPanel(new BorderLayout());
		p4.add("West",viewlb);
		p4.add("Center",viewjsp);
		p2.add("Center",p4);     // p2 패널의 센터 
		JPanel p5 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p5.add("South",changebt);
		p2.add("South",p5);      // p2 패널의 하단 
		jpjpjp1.add("Center",p2);
	}
	
//  ** 삭제 탭 **
	private void initjpjpjp2(){
		
		jpjpjp2.add("North",dellb); // 상단부 라벨 하나 
		JPanel ppp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		ppp.add(delbt);
		ppp.add(delclearbt);
		jpjpjp2.add("South",ppp); //하단부 버튼 두개 
		
		//테이블 셋팅 
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
			jt.setValueAt(String.valueOf(i+1), i, 0); // i 행 , 0열 
		}
		jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // 리사이징 끔 
		jth.setReorderingAllowed(false); // 리오더링 끔 
		jpjpjp2.add("Center",tablejsp); // 중앙부 테이블 
	
	}
	
	//  ** 수정 탭 **
	private void initjpjpjp3(){
		// West 구역 ( 라벨 ) 
				JPanel p = new JPanel(new GridLayout(10,1)); //10행 1열
				
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
				
				// 센터 구역 ( 필드들..)
				JPanel p1 = new JPanel(new GridLayout(10,1));
				p1.add(nametf1);
				JPanel p2 = new JPanel(new BorderLayout(10,10));
				
				//JPanel p2_1 = new JPanel(new GridLayout(1,2,5,0));
				//p2_1.add(jumintf1);
				//p2_1.add(jumin1tf1);
				//p2.add("Center",p2_1);
				//p2.add("East",juminbt1); // 주민 버튼 완료 
				p1.add(jumintf1); // 주민버튼 추가 
				
				//JPanel p3 = new JPanel(new BorderLayout(10,0));
				//p3.add("Center",idtf1);
				//p3.add("East",idbt1);
				p1.add(idtf1);
				p1.add(passtf1);
				p1.add(pass1tf1);
				
				// 패널 p4  전화번호 구역 
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
				// 패널 p4  끝 
				
				//패널 5 휴대폰 번호 구역 
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
				// 패널 5 휴대폰 번호 구역 끝 
				
				p1.add(addrtf1);
				p1.add(butf1);
				p1.add(jiktf1);
				jpjpjp3.add("Center",p1);
				
				//  바텀 부분 
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
		
		if(e.getSource() == jbt4){  //클리어 버튼 
			System.exit(0);
		}
		else if(e.getSource() == jtf || e.getSource() == jbt1){ // 부서추가 필드와 버튼 
			String imsi = jtf.getText().trim();
			if(imsi == null || imsi.length() == 0){ // 입력안했으면 리턴 
				return;
			}
			BuSet bs = new BuSet(imsi,busetnum); // 부서셋 클래스를 핸들러로 사용 
			busetnum++;  
			busetvc.add(bs);
			jtf.setText("");
			this.treerefresh();  //트리프래시 메소드 하단부 정의 함....
			
		}
		else if(e.getSource() == regbt){ // 등록 버튼 
			Person ps = new Person(nametf.getText().trim(), jumintf.getText().trim() + "-" + jumin1tf.getText().trim(),
					idtf.getText().trim(), new String(passtf.getPassword()), 
					(String)teltf.getSelectedItem() + "-" + tel1tf.getText().trim() + "-" + tel2tf.getText().trim(),
					(String)tell1tf.getSelectedItem() + "-" + tell2tf.getText().trim() + "-" + tell3tf.getText().trim(),
					addrtf.getText().trim(), (String)butf.getSelectedItem(), (String)jiktf.getSelectedItem(), 
					worktf.getText().trim());
			personvc.add(ps); // 펄슨 클랙스 벡터에 담ㅇ므 
		
			nametf.setText(""); // 담고나서 초기화 
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
		else if(e.getSource() == clearbt){ // 클리어 bt 
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
		else if(e.getSource() == juminbt){ //주민등록번호 중복확인 
			String str = jumintf.getText().trim() +"-"+ jumin1tf.getText().trim();
			if(personvc.size() == 0){
				String imsi = jumintf.getText().trim();
				if(imsi == null || imsi.length() == 0){
					JOptionPane.showMessageDialog(this, " 주민 등록 번호를 입력 하세요 ");
					
				}else{
				JOptionPane.showMessageDialog(this, " 사용 가능한 주민 번호 입니다.");
				idtf.requestFocus();
				}
			}
			for(int i = 0 ; i <personvc.size(); i ++){ 
				Person ps = (Person)personvc.elementAt(i);
				if(str.equals(ps.jumin)){
					JOptionPane.showMessageDialog(this, "사용 중인 주민 번호 입니다.");
					jumintf.setText("");
					jumin1tf.setText("");
					jumintf.requestFocus();
					return;
				}
				else{
					JOptionPane.showMessageDialog(this, " 사용 가능한 주민 번호 입니다.");
					idtf.requestFocus();
				}
			}
		}
		else if(e.getSource() == idbt){ // 아이디 중복 확인 
			String str = idtf.getText().trim();
		
			if(personvc.size() == 0){
				String imsi = idtf.getText().trim();
				if(imsi == null || imsi.length() == 0){
					JOptionPane.showMessageDialog(this, " 아이디를 입력 하세요 ");
					
				}else{
				JOptionPane.showMessageDialog(this, " 사용 가능한 아이디 입니다.");
				passtf.requestFocus();
				}
			}
			for(int i = 0 ; i <personvc.size(); i ++){
				Person ps = (Person)personvc.elementAt(i);
				if(str.equals(ps.id)){
					JOptionPane.showMessageDialog(this, "사용 중인 아이디 입니다.");
					idtf.setText("");
					
					idtf.requestFocus();
					return;
				}
				else{
					JOptionPane.showMessageDialog(this, " 사용 가능한 아이디 입니다.");
					passtf.requestFocus();
				}
			}
		}
		
		// 서치 필드와 버튼 
		else if(e.getSource() == searchtf || e.getSource() == searchbt){
			// 검색할 내용 가져오고..
			String str = searchtf.getText().trim();
			// 데이터가 있는지 여부 검사하고..
			if(personvc.size() == 0){
				JOptionPane.showMessageDialog(this, " 데이터가 존재하지 않습니다.");
			}
			// 검색 결과 담을 벡터 초기화 해두고.. 
			viewvc.clear();
			// 루프 돌면서 검색한다..
			for(int i = 0 ; i < personvc.size() ; i ++){
				Person ps = (Person)personvc.elementAt(i);
				int k = -1; // 검색내용과 맞는 모든 데이터 검색을 위해서.. k 변수 선언 하고..
				if(namerb.isSelected()){ // 이름이 같으면, k 벨류를 바꿔서, 벡터에 저장하도록 한다.
					if(ps.name.equals(str)){
						k = i;
					}
				}
				else if(juminrb.isSelected()){ // 나머지도 마찬가지...
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
				//검색되었다면..즉.. 벨류가 바뀐게 있다면.. 데이터를 벡터에 저장...
				if(k != -1){ 
					viewvc.add(ps.name + ":" + ps.jumin + ":" + ps.id);			
				}
			}
			viewli.setListData(viewvc); // 루프가 끝나면, 해당 벡터를, 리스트에 추가 
			viewli.updateUI(); // 리스트 업데이트 
		}
		else if(e.getSource() == changebt){
			String str = (String)viewli.getSelectedValue(); //선택한 밸류 뽑아옴..
			str = str.substring(str.indexOf(":") + 1, str.lastIndexOf(":")); // ":" 를 기반으로 파싱 
			jtb.setSelectedIndex(3); // 정보 수정 탭으로 이동 시킴
			
			butf.updateUI(); // 부서 텍스트필드 업데이트 
			// 직책 콤보박스 
			jikvc1.clear();
			jikvc1.add("부장");
			jikvc1.add("과장");
			jikvc1.add("차장");
			jikvc1.add("대리");
			jikvc1.add("사원");
			
			// 부서 콤보박스 
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
			if(kkk == -1){ // 결과 없을시.. 이건 있을 수 없는 일..
				JOptionPane.showMessageDialog(this, "심각한 오류 발생!!!");
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
					
					ps.pass = new String(passtf1.getPassword()); // 반드시 바꿔야함.
					ps.tel = (String)teltf1.getSelectedItem() + "-" + tel1tf1.getText().trim() + "-" + tel2tf1.getText().trim();
					ps.tel1 = (String)tell1tf1.getSelectedItem() + "-" + tell2tf1.getText().trim() + "-" + tell3tf1.getText().trim();
					ps.addr = addrtf1.getText().trim();
					ps.buname = (String)butf1.getSelectedItem();
					ps.jik = (String)jiktf1.getSelectedItem();
					ps.work = worktf1.getText().trim();
					JOptionPane.showMessageDialog(this, "정상 수정 되었습니다.");
					break;
				}
			}
			jtb.setSelectedIndex(1); // 수정 완료 후, 검색 탭으로 전환 
		}
		else if(e.getSource() == delbt){ // 삭제버튼 눌렀을 시.. 
			int imsi = personvc.size();
			for(int i = 0 , j = 0; i < imsi ; i++, j ++){ // i 는 테이블의 위치를.. j 는 person객체의 내용을 지우고, 위치번째를 뒤로 한칸씩 이동시킴..
				if(( (Boolean)jt.getValueAt(i, 1) ).equals(new Boolean(true))){
					personvc.removeElementAt(j);
					j--;
				}
			}
			dtm.setRowCount(personvc.size()); // 열 재정리..
			for(int i = 0 ; i <personvc.size() ; i ++){
				Person ps = (Person)personvc.elementAt(i);
				jt.setValueAt(String.valueOf(i+1), i, 0); // i행 0열에는, 번호 1~쭉 
				//삭제열은, 체크박스라 빼고...
				jt.setValueAt((ps.id).trim(), i, 2); // 2번째부터, i행 2열에 쭉 아이디..
				jt.setValueAt((ps.name).trim(), i, 3); // i행 3열에 쭉 이름 .. 
				jt.setValueAt((ps.jumin).trim(),i,4); // i행 4열에 주민 쭉......
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
				jt.setValueAt(new Boolean(false), i, 1); // i 행  , 1번째 열
			}
		}
		else if(e.getSource() == jbt2){
			jfc.showSaveDialog(this);
			try{
				String strstr = jfc.getSelectedFile().toString(); // 전체 경로를 얻어옴..
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
			String strstr = jfc.getSelectedFile().toString(); // 전체 경로를 얻어옴..
			strstr = strstr.substring(0,strstr.indexOf(".")); //확장자 오려내기.. 
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
		//트리노드에, 부서를 노드에 추가시킴.
		DefaultMutableTreeNode[] node = new DefaultMutableTreeNode[busetvc.size()];
		root.removeAllChildren();
		for(int i = 0 ; i < node.length ; i ++	){
			BuSet imsi = (BuSet)busetvc.elementAt(i);
			node[i] = new DefaultMutableTreeNode(imsi.getBuname());
			root.add(node[i]);
		}
		tree.updateUI();
		// 만약 person 객체가 넘어왔을시... 아래 실행댐 .
		if(personvc.size() !=0){
			DefaultMutableTreeNode[] childnode = new DefaultMutableTreeNode[personvc.size()]; // 노드 만들 고..
			for(int i = 0 ; i < node.length ; i ++){ 
				node[i].removeAllChildren();     // 기존에 있던 노드 모두 삭제..
			}
			for(int i = 0 ; i < personvc.size() ; i ++){
				Person ps = (Person) personvc.elementAt(i); // 하나씩 뽑아와서...
				// 차일드 노드 생성 
				childnode[i] = new DefaultMutableTreeNode(ps.name);
				// 부서명이 같은 것에, 차일드 노드 추가 .. 노드배열은 위에있음 
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
			// 직책 콤보박스 
			jikvc.clear();
			jikvc.add("부장");
			jikvc.add("과장");
			jikvc.add("차장");
			jikvc.add("대리");
			jikvc.add("사원");
			
			// 부서 콤보박스 
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
		//삭제 탭 내용부 
		if(e.getSource() == jtb){
			if(jtb.getSelectedIndex() == 2){ // 삭제 탭 이라면..
				dtm.setRowCount(personvc.size());  // 펄슨 벡터 크기만큼 행 생성
				for(int i = 0 ; i <personvc.size() ; i ++){
					Person ps = (Person)personvc.elementAt(i);
					jt.setValueAt(String.valueOf(i+1), i, 0); // i행 0열에는, 번호 1~쭉 
					//삭제열은, 체크박스라 빼고...
					jt.setValueAt((ps.id).trim(), i, 2); // 2번째부터, i행 2열에 쭉 아이디..
					jt.setValueAt((ps.name).trim(), i, 3); // i행 3열에 쭉 이름 .. 
					jt.setValueAt((ps.jumin).trim(),i,4); // i행 4열에 주민 쭉......
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