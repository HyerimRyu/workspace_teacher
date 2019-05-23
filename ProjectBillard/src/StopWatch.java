import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StopWatch extends Thread {

	private JPanel stopWatchPanel = new JPanel();
	
	private JLabel stopWatchLabel = new JLabel();
	private JLabel chargeLabel = new JLabel();

	private FileReader billiardFileReader;
	private BufferedReader billiardBufReader;
	
	private int charge;
	private int chargePerMin;
	
	private boolean isRun = true;

	private long endTime, totalTime;
	private int hour, min, sec;
	
	public int getCharge() {
		return charge;
	}
	
	public JPanel getStopWatchPanel() {
		return stopWatchPanel;
	}
	
	public JLabel getStopWatchLabel() {
		return stopWatchLabel;
	}
	
	public JLabel getChargeLabel() {
		return chargeLabel;
	}

	public void setIsRun(boolean isRun) {
		this.isRun = isRun;
	}

	public StopWatch(FileReader billiardFileReader) {
		// TODO Auto-generated constructor stub
		try {
			this.billiardFileReader = billiardFileReader;
			billiardBufReader = new BufferedReader(this.billiardFileReader);
			
			chargePerMin= Integer.parseInt(billiardBufReader.readLine());
			charge= Integer.parseInt(billiardBufReader.readLine());
			
			billiardFileReader.close();
			this.billiardFileReader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chargeLabel.setHorizontalAlignment(0);
		chargeLabel.setFont(new Font("NanumGothicBold", Font.BOLD, 30));
		
		stopWatchLabel.setFont(new Font("NanumGothicBold", Font.BOLD, 50));
		
		stopWatchPanel.setLayout(new BorderLayout());
		stopWatchPanel.add(chargeLabel, BorderLayout.SOUTH);
		stopWatchPanel.add(stopWatchLabel, BorderLayout.CENTER);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		while (isRun) {
			try {
				
				endTime = System.currentTimeMillis();

				totalTime = (endTime - startTime) / 1000;

				hour = (int) totalTime / 3600;
				min = (int) totalTime / 60 % 60;
				sec = (int) totalTime % 60;
				
				stopWatchLabel.setText(String.format("%02d:%02d:%02d", hour, min, sec));
				stopWatchLabel.setHorizontalAlignment(0);
				if(totalTime>1800) 
					if(min%10==0 && sec==0)
						charge += chargePerMin;
				chargeLabel.setText(charge+"¿ø");
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
