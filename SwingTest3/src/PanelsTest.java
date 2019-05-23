import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelsTest extends JFrame{
	
	public PanelsTest() {
		//패널안에 패널넣기
		this.setTitle("Panels Test");
		setSize(500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//가장 큰 첫번째 panel
		JPanel rootPanel= new JPanel();
		GridLayout gridLayout= new GridLayout(0, 2);
		gridLayout.setHgap(10);
		rootPanel.setLayout(gridLayout);
		
		//왼쪽 패널
		JPanel panelA= new JPanel();
		panelA.setBackground(Color.YELLOW);
		panelA.setLayout( new FlowLayout() );
		panelA.add(new JButton("aaa"));
		panelA.add(new JButton("bbb"));
		panelA.add(new JButton("ccc"));
		panelA.add(new JButton("ddd"));
		panelA.add(new JButton("eee"));
		panelA.add(new JButton("fff"));
		panelA.add(new JButton("ggg"));
		
		//오른쪽 패널	
		JPanel panelB= new JPanel();
		panelB.setBackground(Color.BLUE);
		panelB.setLayout(new BorderLayout());
		panelB.add(new JButton("buttton1"), BorderLayout.NORTH);
		panelB.add(new JButton("buttton2"), BorderLayout.CENTER);
		panelB.add(new JButton("buttton3"), BorderLayout.SOUTH);
		
		//작은패널들을 큰패널에 붙이기
		rootPanel.add(panelA);
		rootPanel.add(panelB);
		
		rootPanel.setBackground(Color.RED);
		
		//Frame에 rootPanel을 붙이기.
		add(rootPanel);		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PanelsTest();	
	}

}





