import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame {

	private StartFrame startFrame;
	private UserFrame userFrame;
	private OptionFrame optionFrame;

	public MainFrame() {
		// TODO Auto-generated constructor stub

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(0, 1));

		JButton btnStart = new JButton("START");
		JButton btnClient = new JButton("CLIENT");
		JButton btnOption = new JButton("OPTION");

		TimeThread timeThread = new TimeThread();
		timeThread.setDaemon(true);
		timeThread.start();

		add(timeThread.getTimeLabel(), BorderLayout.NORTH);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		setIconImage(toolkit.getImage("images/FrameIcon.png")); // 프레임 아이콘 설정

		Image startImg = toolkit.getImage("images/StartIcon.png"); // Start 아이콘 설정
		startImg = startImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon startIcon = new ImageIcon(startImg);

		Image clientImg= toolkit.getImage("images/FrameIcon.png");
		clientImg = clientImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon clientIcon = new ImageIcon(clientImg);
		
		Image optionImg = toolkit.getImage("images/OptionIcon.png");
		optionImg = optionImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon optionIcon = new ImageIcon(optionImg);

		btnStart.setFont(new Font("mexcellent 3d", Font.PLAIN, 100)); // Start Font 설정
		btnStart.setBackground(Color.WHITE); // Start Color 설정
		btnStart.setIcon(startIcon);
		btnStart.setForeground(new Color(0, 104, 56));
		btnStart.setFocusPainted(false);
		
		btnClient.setFont(new Font("mexcellent 3d", Font.PLAIN, 100)); // Start Font 설정
		btnClient.setBackground(new Color(0, 104, 56)); // Start Color 설정
		btnClient.setIcon(clientIcon);
		btnClient.setForeground(Color.WHITE);

		btnOption.setFont(new Font("mexcellent 3d", Font.PLAIN, 100));
		btnOption.setIcon(optionIcon);
		btnOption.setBackground(Color.white);
		btnOption.setForeground(new Color(0, 104, 56));

		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				startFrame = new StartFrame();
			}
		});

		btnClient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				userFrame = new UserFrame();
			}
		});
		
		btnOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				optionFrame = new OptionFrame();

			}
		});

		menuPanel.add(btnStart);
		menuPanel.add(btnClient);
		menuPanel.add(btnOption);

		mainPanel.add(menuPanel, BorderLayout.CENTER);

		add(mainPanel, BorderLayout.CENTER);
		setTitle("Future Billiard");
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
