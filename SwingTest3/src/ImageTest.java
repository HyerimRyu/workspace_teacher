import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageTest extends JFrame{
	
	int num=12;
	
	public ImageTest() {
		setTitle("Image Test");
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel= new JPanel();
		
		//이미지를 표시하려면.. 우선 이미지를 보여줄수는 컴포넌트가 있어야함.
		//swing에는 없어서 JLabel을 대신 이용.
		JLabel label= new JLabel();		
		ImageIcon icon= new ImageIcon("images/ms21.png"); //이미지파일의 주소..
		icon= new ImageIcon( icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH) );
		label.setIcon(icon);
		panel.add(label);
		
		JButton btn= new JButton("이미지 버튼");
		//버튼에 아이콘 추가하기
		ImageIcon btnIcon= new ImageIcon("images/access.png");
		btn.setIcon(btnIcon);
		panel.add(btn);
		
		btn.addActionListener( new ActionListener() {
			//btn버튼이 클릭되면 자동으로 실행되는 메소드 : 콜백 메소드
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//이미지 변경하기
				num++;
				if(num>21) num=12;
				ImageIcon icon= new ImageIcon("images/ms"+num+".png");
				icon= new ImageIcon( icon.getImage().getScaledInstance(256, 256, Image.SCALE_SMOOTH) );
				label.setIcon(icon);
			}
		});
		
		
		
		
		add(panel);
		setLocation(600, 100);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageTest();
	}
}





