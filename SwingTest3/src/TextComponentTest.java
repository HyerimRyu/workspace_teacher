import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextComponentTest extends JFrame {
	
	public TextComponentTest() {
		// TODO Auto-generated constructor stub
		setTitle("Components Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel= new JPanel();
		
		//글씨 관련 컴포넌트 3개..
		
		//1. JLabel
		JLabel label= new JLabel("Label Component");
		//setSize는 컴포넌트의 크기를 지정하는 것이며 글씨크기는 변하지 않음.		
		//폰트 설정( 글꼴, 스타일, 크기 )
		Font font= new Font("serif", Font.BOLD, 30);
		font= new Font("sans serif", Font.ITALIC, 30);
		font= new Font(null, Font.BOLD|Font.ITALIC, 30);
		label.setForeground(Color.RED);
		label.setFont(font);		
		panel.add(label);
		
		//2. JTextField : 한줄 입력
		JTextField tf= new JTextField(25);//25글자정도 들어갈 크기
		panel.add(tf);	
		
		//2-1. JPasswordField : 한줄입력
		JPasswordField pf= new JPasswordField(25);
		panel.add(pf);
		
		//3. JTextArear : 여러줄 입력
		JTextArea ta= new JTextArea(10, 25); //rows, cols
		ta.setBorder( BorderFactory.createLineBorder(Color.BLUE) );
		panel.add(ta);
		
		
		
		add(panel);
		setBounds(600, 100, 350, 500);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TextComponentTest();
	}

}
