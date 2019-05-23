package calendar.center;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import calendar.date.YearMonthDate;

public class CenterPanel extends JPanel {
	
	static Calendar cal=Calendar.getInstance();
	JLabel label;
	JButton btn;
	String[][] date=new String[6][7];
	static int startDay;
	static int lastDay;
	int inputDay=1;
	private int year=YearMonthDate.getYear();
	private int month=YearMonthDate.getMonth();
	JPanel northPanel;
	
	DatePanel datePanel;
	int width;
	int height;
	
	


	
	public CenterPanel() {
		datePanel=new DatePanel();
		setLayout(new BorderLayout());
		String[] header= {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		northPanel=new JPanel();
		northPanel.setLayout(new GridLayout(1, 7));
		
		
		
		
		
		int width=header.length;
		int row=0;
		for(int i=1; inputDay<=lastDay; i++) {
			
			if(i<startDay) date[row][i-1]="";
			else {
				date[row][(i-1)%width]=Integer.toString(inputDay);
				inputDay++;
				if(i%width==0) row++;
			}
		}
		inputDay=1;
		row=0;
		
		
		for(int i=1; i<header.length; i++) {
			JLabel dayLabel=new JLabel(header[i]);
			dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
			northPanel.add(dayLabel);
		}
		
		
		
//		for(int i=1; i<43; i++) {
//			JPanel panel=new JPanel();
//			panel.setLayout(new BorderLayout());
//			panel.setBorder(new LineBorder(Color.BLACK));
//			if(i<startDay) label=new JLabel("");
//			else label=new JLabel(date[row][(i-1)%width]);
//			if(i%width==0) row++;
//			
//			btn=new JButton();
//			if(i<startDay) {
//				//panel에 아무것도 안달고 붙임
//				panel.setBackground(Color.GRAY);
//			}else {
//				if(i-1>lastDay) {
//					//panel에 아무것도 안달고 붙임
//					panel.setBackground(Color.GRAY);
//				}
//				else {
//					panel.add(label, BorderLayout.NORTH);
//					panel.add(btn, BorderLayout.CENTER);
//				}
//					
//			}
//			
//			centerPanel.add(panel);
//		}
//		row=0;
//		add(
//		add(centerPanel, BorderLayout.CENTER);
		add(northPanel, BorderLayout.NORTH);
		add(datePanel, BorderLayout.CENTER);
		
	}
	
	
	
	public static void setCal() {
		cal.set(Calendar.YEAR, YearMonthDate.getYear());
		cal.set(Calendar.MONTH, YearMonthDate.getMonth()-1);
		cal.set(Calendar.DATE, YearMonthDate.getDate());
		
		startDay=cal.get(Calendar.DAY_OF_WEEK);
		lastDay=cal.getActualMaximum(Calendar.DATE);

	}
	

	

	class DatePanel extends JPanel{
		
		public DatePanel() {
			
			cal.set(Calendar.YEAR, YearMonthDate.getYear());
			cal.set(Calendar.MONTH, YearMonthDate.getMonth()-1);
			cal.set(Calendar.DATE, YearMonthDate.getDate());
			setLayout(new GridLayout(6, 7));
			startDay=cal.get(Calendar.DAY_OF_WEEK);
			lastDay=cal.getActualMaximum(Calendar.DATE);
			int row=0;
			int width=7;
			for(int i=1; inputDay<=lastDay; i++) {
				
				if(i<startDay) date[row][i-1]="";
				else {
					date[row][(i-1)%width]=Integer.toString(inputDay);
					inputDay++;
					if(i%width==0) row++;
				}
			}
			inputDay=1;
			row=0;
			
			for(int i=1; i<=42; i++) {
			JPanel panel=new JPanel();
			panel.setLayout(new BorderLayout());
			panel.setBorder(new LineBorder(Color.BLACK));
			if(i<startDay) label=new JLabel("");
			else label=new JLabel(date[row][(i-1)%width]);
			if(i%width==0) row++;
			
			btn=new JButton();
			if(i<startDay) {
				//panel에 아무것도 안달고 붙임
				panel.setBackground(Color.GRAY);
			}else {
				if(i-1>lastDay) {
					//panel에 아무것도 안달고 붙임
					panel.setBackground(Color.GRAY);
				}
				else {
					panel.add(label, BorderLayout.NORTH);
					panel.add(btn, BorderLayout.CENTER);
				}
				
			}
			add(panel);
			}
		row=0;

		}
		
	
	}

	
	
}
