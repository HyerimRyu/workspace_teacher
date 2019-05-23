import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class TimeThread extends Thread {

	private JLabel timeLabel = new JLabel();

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while (true) {
			try {
				Date date = new Date();
				SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss a");
				timeLabel.setFont(new Font("NanumGothicBold", Font.BOLD, 20));
				timeLabel.setForeground(new Color(0, 104, 56));
				timeLabel.setOpaque(true);
				timeLabel.setBackground(Color.WHITE);
				timeLabel.setText(time.format(date).toString());
				timeLabel.setHorizontalAlignment(0);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
