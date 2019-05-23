package calendar.north;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;
import java.time.Year;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import calendar.center.datepanel.DatePanel;
import calendar.date.YearMonthDate;


public class NorthPanel extends JPanel {
	
	private static int year;
	private static int month; 
	private JLabel yearLabel;
	private JLabel monthLabel;
	private DatePanel datePanel;
	

	public NorthPanel() {
		
		setYear();
		setMonth();
		
		setLayout(new BorderLayout());
		JPanel northPanel=new JPanel();
		northPanel.setLayout(new GridLayout(2, 0));
		JPanel yearPanel=new JPanel();
		JPanel monthPanel=new JPanel();
		
		JButton yearPreBtn=new JButton("preyear");
		yearLabel=new JLabel(YearMonthDate.getYear()+"");
		JButton yearNextBtn=new JButton("nextyear");
		yearPreBtn.addActionListener(year_pre_nextBtnListener);
		yearNextBtn.addActionListener(year_pre_nextBtnListener);
		yearPanel.add(yearPreBtn);
		yearPanel.add(yearLabel);
		yearPanel.add(yearNextBtn);
		
		JButton monthPreBtn=new JButton("premonth");
		monthLabel=new JLabel(YearMonthDate.getMonth()+"");
		JButton monthNextBtn=new JButton("nextmonth");
		monthPreBtn.addActionListener(month_pre_nextBtnListener);
		monthNextBtn.addActionListener(month_pre_nextBtnListener);
		monthPanel.add(monthPreBtn);
		monthPanel.add(monthLabel);
		monthPanel.add(monthNextBtn);
		
		northPanel.add(yearPanel);
		northPanel.add(monthPanel);
		add(northPanel, BorderLayout.NORTH);
		datePanel=new DatePanel(2018, 1);
		add(datePanel, BorderLayout.CENTER);
	}
	
	private void setYear() {
		year=YearMonthDate.getYear();
	}
	
	private void setMonth() {
		month=YearMonthDate.getMonth();
	}
	

	
	ActionListener year_pre_nextBtnListener=new ActionListener() {
		
		//수정사항 datePanel pre next버튼 누를시 새 객체 만들지 말고 getter setter로 다시 값만 재설정 하는 부분이 필요하다.
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj instanceof JButton) {
				JButton btn=(JButton)obj;
				if(btn.getText().equals("preyear")) {
					if(yearLabel.getText().equals("2018")) return;
					else {
						remove(datePanel);
						year--;
						YearMonthDate.setYear(year);
						yearLabel.setText(year+"");
						datePanel=new DatePanel(year, month);
						add(datePanel, BorderLayout.CENTER);
					}
				}else if(btn.getText().equals("nextyear")) {
					if(year>=2099) return;
					else {
						remove(datePanel);
						year++;
						YearMonthDate.setYear(year);
						yearLabel.setText(year+"");
						datePanel=new DatePanel(year, month);
						add(datePanel, BorderLayout.CENTER);
					}
				}
			}
			
		}
	};
	
	ActionListener month_pre_nextBtnListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj instanceof JButton) {
				JButton btn=(JButton)obj;
				if(btn.getText().equals("premonth")) {
					if(monthLabel.getText().equals("1")) {
						if(yearLabel.getText().equals("2018")) return;
						remove(datePanel);
						year--;
						month=12;
						YearMonthDate.setYear(year);
						YearMonthDate.setMonth(month);
						yearLabel.setText(year+"");
						monthLabel.setText(month+"");
						datePanel=new DatePanel(year, month);
						add(datePanel, BorderLayout.CENTER);
						
					}else {
						remove(datePanel);
						month--;
						YearMonthDate.setMonth(month);
						monthLabel.setText(month+"");
						datePanel=new DatePanel(year, month);
						add(datePanel, BorderLayout.CENTER);
					}
				}else if(btn.getText().equals("nextmonth")) {
					if(monthLabel.getText().equals("12")) {
						if(yearLabel.getText().equals("2099")) return;
						remove(datePanel);
						year++;
						month=1;
						YearMonthDate.setYear(year);
						YearMonthDate.setMonth(month);
						yearLabel.setText(year+"");
						monthLabel.setText(month+"");
						datePanel=new DatePanel(year, month);
						add(datePanel, BorderLayout.CENTER);
						
					}else {
						remove(datePanel);
						month++;
						YearMonthDate.setMonth(month);
						monthLabel.setText(month+"");
						datePanel=new DatePanel(year, month);
						add(datePanel, BorderLayout.CENTER);
						
						
					}
				}
			}

		}
	};
}
