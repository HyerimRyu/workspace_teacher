import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. 최상위 컨테이너 생성
		JFrame frame= new JFrame("Swing GUI");
		frame.setSize(500, 400);
		
		//2. 컴포넌트들 추가하기
		
		JButton b1= new JButton("btn1");
		JButton b2= new JButton("button2");
		
		//기본적으로 JFrame은 BorderLayout이라는 배치관리자로 되어 있음.
		//가장 쉬운 레이아웃매니저이 FlowLayout으로 변경
		frame.setLayout(  new FlowLayout() );		
		
		//컨테이너에 컴포넌트 추가
		frame.add(b1);
		frame.add(b2);
		
		
		//JLabel - 클씨보여주는 컴포넌트
		JLabel label= new JLabel("This is Label");
		//label.setSize(50, 10); //FlowLayout안에서는 사이즈지정 안됨!
		frame.add(label);
		
		//JTextField - 사용자로부터 글씨 입력받는 컴포넌트
		JTextField tf= new JTextField(20);//최소 20글자 사이즈..이상도 써짐.
		frame.add(tf);
		
		
		//이미지 - 이미지용 컴포넌트 없음..
		//JLabel에 이미지(아이콘)를 보여줄 수 있는 능력이 있음. 이를 활용!!
		
		//이미지 아이콘객체 생성
		ImageIcon icon= new ImageIcon("images/ms16.png");
		//이미지를 실제로 가지고 있는 Image객체를 뽑아오기!!
		Image im= icon.getImage();
		//뽑아온 이미지객체의 사이즈를 새롭게 만들기!
		Image im2= im.getScaledInstance(280, 280, Image.SCALE_DEFAULT);
		//새로 조절된 사이즈의 이미지(im2)를 가지는 ImageIcon객체를 다시 생성
		ImageIcon icon2= new ImageIcon(im2);		
		
//		JLabel img= new JLabel();
//		img.setIcon(icon);
		JLabel img= new JLabel(icon2);
		frame.add(img);	
		
		
		
		//swing은 frame창은 x버튼 누르면 자동으로 사라지지만 프로그램은 종료되지 않음.
		//x버튼 누르면 프로그램도 같이 종료되도록 설정!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(300, 200);//프레임의 좌상단 위치.
		//화면에 보이기
		//frame.pack();
		frame.setVisible(true);
	}

}









