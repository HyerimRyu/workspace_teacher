import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame{
	
	public Main() {
		// TODO Auto-generated constructor stub
		setTitle("aaa Test");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		
		JLabel label= new JLabel(new ImageIcon("original.gif"));
		add(label, BorderLayout.CENTER);	
		
		
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}


}
