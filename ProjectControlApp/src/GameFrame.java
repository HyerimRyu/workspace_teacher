import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame extends JFrame {

	JButton player1;
	JButton player2;
	JButton player3;
	
	public GameFrame() {
		
		JPanel panel = new JPanel(new GridLayout(0, 3));
		
		Image img;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		img = toolkit.getImage("images/spong.png");
		img = img.getScaledInstance(200, 175, Image.SCALE_SMOOTH);
		JButton player1 = new JButton(new ImageIcon(img));
		
		Image img2;
		img2 = toolkit.getImage("images/BQ.png");
		img2= img2.getScaledInstance(200, 175, Image.SCALE_SMOOTH);
		JButton player2 = new JButton(new ImageIcon(img2));
		
		Image img3;
		img3 = toolkit.getImage("images/jingjing.png");
		img3 = img3.getScaledInstance(200, 175, Image.SCALE_SMOOTH);
		JButton player3 = new JButton(new ImageIcon(img3));
		
		//버튼 내용 역역 채우지 않기(투명)
		
		player1.setContentAreaFilled(false);
		player2.setContentAreaFilled(false);;
		player3.setContentAreaFilled(false);;
		//버튼 포커스 선택 되었을때 생기는 테두리 사용 안함(투명3)
		
		player1.setFocusPainted(false);
		player2.setFocusPainted(false);
		player3.setFocusPainted(false);
		
		player1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent g) {
				
				new ServerGame();
			}
		});//player1 액션리스너
		
		player2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent g) {
			
				new ClientGame();
			}
		});//player2 액션리스너
		player3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ClientGame2();
			}
		});
		
		panel.add(player1);
		panel.add(player2);
		panel.add(player3);
		setTitle("캐릭터 선택");
		add(panel);
		setBounds(330, 150, 620, 350);
		setResizable(false);
		setVisible(true);

	}
}