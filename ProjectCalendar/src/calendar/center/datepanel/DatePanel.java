package calendar.center.datepanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import calendar.center.datepanel.scheduleframe.ScheduleFrame;
import calendar.date.YearMonthDate;

public class DatePanel extends JPanel{
	
	private static JButton btn;
	

	public static Calendar cal=Calendar.getInstance();
	private JLabel dateLabel;
	private JButton dateButton;
	ButtonGroup bg;
	
	private boolean dateBtnHaveYetClick=true;
	private ScheduleFrame scheduleFrame;
	private ScheduleFrameThread sft;
	
	public DatePanel(int year, int month) {
		
		setLayout(new BorderLayout());
		//요일Panel 변수
		String[] header= {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		JPanel headerPanel= new JPanel();
		headerPanel.setLayout(new GridLayout(0, 7));
		JPanel datePanel=new JPanel();
		datePanel.setLayout(new GridLayout(6, 7));
		for(int i=0; i<header.length; i++) {
			JLabel headerLabel=new JLabel(header[i]);
			headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
			headerPanel.add(headerLabel);
		}
		
		//일자Panel변수
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		String[][] dates=new String[6][7];
		int startDay=cal.get(Calendar.DAY_OF_WEEK);
		int lastDay=cal.getActualMaximum(Calendar.DATE);
		int width=header.length;
		int row=0;
		int inputDay=1;
		final int index=42;
		
		for(int i=1; inputDay<=lastDay; i++) {
			if(i<startDay) dates[row][i-1]="";
			else {
				dates[row][(i-1)%width]=Integer.toString(inputDay);
				inputDay++;
				if(i%width==0) row++;
				}
			}
		row=0;
		int a=1;
		for(int i=1; i<=index; i++) {
			
			JPanel panel=new JPanel();
			panel.setLayout(new BorderLayout());
			panel.setBorder(new LineBorder(Color.BLACK));
			if(i<startDay) dateLabel=new JLabel("");
			else dateLabel=new JLabel(dates[row][(i-1)%width]);
			if(i%width==0) row++;
			dateButton=new JButton();
			bg=new ButtonGroup();
			bg.add(dateButton);
			dateButton.addActionListener(dateBtnListener);
			if(i<startDay) {
				//panel에 아무것도 안달고 붙임 색만 입힘
				panel.setBackground(Color.GRAY);
				}else {
					if(i-1>lastDay+startDay-2) {
						//panel에 아무것도 안달고 붙임
						panel.setBackground(Color.GRAY);
						}else {
							panel.add(dateLabel, BorderLayout.NORTH);
							panel.add(dateButton, BorderLayout.CENTER);
							dateButton.setName(dateLabel.getText());
							a++;
							}
					}
			datePanel.add(panel);	
		}
		add(datePanel, BorderLayout.CENTER);
		add(headerPanel, BorderLayout.NORTH);
		
	}
	

	
	ActionListener dateBtnListener=new ActionListener() {
		
		@Override
		synchronized public void actionPerformed (ActionEvent e) {
			
			Object obj=e.getSource();
			JButton btn=(JButton)obj;
			YearMonthDate.setDate(Integer.parseInt(btn.getName()));
			ScheduleFrame.setDatePanelBtn(btn);
			if(dateBtnHaveYetClick) {
				if(!(scheduleFrame==null)) scheduleFrame.dispose();
				scheduleFrame=new ScheduleFrame();
				sft=new ScheduleFrameThread();
				sft.start();
				dateBtnHaveYetClick=false;
				sft.pauseThread();
				
			}
			
			if(scheduleFrame.isShowing()==false) {
				scheduleFrame.dispose();
				scheduleFrame=new ScheduleFrame();
				sft.resumeThread();
				sft.pauseThread();
			}
			
			
			
			//popUpFrame.isShowing(); 현재 프레임이 보여지고 있는지 true false로 알려주는 메소드
			
		}
	};
	//정지,재개기능을 수정해야함 좋지 않음
	class ScheduleFrameThread extends Thread{
		
		private boolean isWait=false;
		@Override
		public void run() {
			while(true){

				if(isWait) {
					try {
						if(!(scheduleFrame==null)) scheduleFrame.dispose();
						scheduleFrame.setVisible(true);	
						scheduleFrame.setLocation(480, 136);
						synchronized(this) {
							wait();
						}
						
					}catch(Exception e) {}
					
				}
			}
			
		}
		
		public void pauseThread() {
			isWait=true;
		}
		
		public void resumeThread() {
			isWait=false;
			synchronized(this) {
				this.notify();
			}
		}
		
	}
}













//if(year%4==0 && year%100!=0 || year%400==0) {
//System.out.println("startDay:"+startDay);
//System.out.println("lastDay"+lastDay);
//System.out.println("year:"+year);
//System.out.println("month:"+month);
//if(month==2) {
//	for(int i=1; inputDay<=lastDay; i++) {
//		if(i<startDay) dates[row][i-1]="";
//		else {
//			dates[row][(i-1)%width]=Integer.toString(inputDay);
//			inputDay++;
//			if(i%width==0) row++;
//		}
//	}
//	row=0;
//	for(int i=1; i<=index; i++) {
//		JPanel panel=new JPanel();
//		panel.setLayout(new BorderLayout());
//		panel.setBorder(new LineBorder(Color.BLACK));
//		if(i<startDay) dateLabel=new JLabel("");
//		else dateLabel=new JLabel(dates[row][(i-1)%width]);
//		if(i%width==0) row++;
//		
//		dateButton=new JButton();
//		if(i<startDay) {
//			//panel에 아무것도 안달고 붙임 색만 입힘
//			panel.setBackground(Color.GRAY);
//		}else {
//			if(i-1>lastDay+startDay-2) {
//				//panel에 아무것도 안달고 붙임
//				panel.setBackground(Color.GRAY);
//			}else {
//				panel.add(dateLabel, BorderLayout.NORTH);
//				panel.add(dateButton, BorderLayout.CENTER);
//			}
//		}
//		datePanel.add(panel);
//	}
//}
//add(datePanel, BorderLayout.CENTER);
//add(headerPanel, BorderLayout.NORTH);
//}
