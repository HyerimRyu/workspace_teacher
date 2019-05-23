package calendar.center.datepanel.scheduleframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.print.attribute.standard.JobName;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import calendar.center.datepanel.DatePanel;
import calendar.date.YearMonthDate;

public class ScheduleFrame extends JFrame {
	
	public static JButton datePanelBtn;
	
	JRadioButton rb;
	JRadioButton rb2;
	ButtonGroup rg;
	
	JRadioButton shoulderRb;
	JRadioButton chestRb;
	JRadioButton backRb;
	JRadioButton stomachRb;
	JRadioButton lowerRb;
	ButtonGroup rg2;
	
	public static JTextField tf1;
	public static JTextField tf2;
	public static JTextField tf3;
	public static JSpinner yearSpinner;
	JSpinner monthSpinner;
	JSpinner dateSpinner;
	
	//SpinnerListModel slmYear;
	//SpinnerListModel slmMonth;
	SpinnerListModel slmDate;

	public ScheduleFrame() {
		setLayout(new BorderLayout());
		setTitle("일정관리");
		setBounds(480, 0, 320, 512);
		setResizable(false);
		setAlwaysOnTop(true);
		
		JPanel radioBtnPanel=new JPanel();
		radioBtnPanel.setBorder(new LineBorder(Color.BLACK));
		rb=new JRadioButton("참석");
		rb.setName("north");
		rb.addActionListener(okCancelBtnListener);
		rb2=new JRadioButton("불참");
		rb2.setName("north");
		rb2.addActionListener(okCancelBtnListener);
		rg=new ButtonGroup();
		rg.add(rb);
		rg.add(rb2);
		radioBtnPanel.add(rb);
		radioBtnPanel.add(rb2);
		
		
		JPanel todayExercisePanel=new JPanel();
		todayExercisePanel.setLayout(new BorderLayout());
		
		JPanel labelPanel=new JPanel();
		todayExercisePanel.setBorder(new LineBorder(Color.BLACK));
		JLabel exerciseLabel=new JLabel("당일운동");
		exerciseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exerciseLabel.setFont(new Font(null, Font.BOLD, 30));
		labelPanel.add(exerciseLabel);
		
		JPanel exerciseRadioBtnPanel=new JPanel();
		shoulderRb=new JRadioButton("어깨");
		shoulderRb.setName("center");
		shoulderRb.addActionListener(okCancelBtnListener);
		chestRb=new JRadioButton("가슴");
		chestRb.setName("center");
		chestRb.addActionListener(okCancelBtnListener);
		backRb=new JRadioButton("등");
		backRb.setName("center");
		backRb.addActionListener(okCancelBtnListener);
		stomachRb=new JRadioButton("복부");
		stomachRb.setName("center");
		stomachRb.addActionListener(okCancelBtnListener);
		lowerRb=new JRadioButton("하체");
		lowerRb.setName("center");
		lowerRb.addActionListener(okCancelBtnListener);
		rg2=new ButtonGroup();
		rg2.add(shoulderRb);rg2.add(chestRb);rg2.add(backRb);rg2.add(stomachRb);rg2.add(lowerRb);
		exerciseRadioBtnPanel.add(shoulderRb);exerciseRadioBtnPanel.add(chestRb);exerciseRadioBtnPanel.add(backRb);
		exerciseRadioBtnPanel.add(stomachRb);exerciseRadioBtnPanel.add(lowerRb);
		
		JPanel textFieldPanel=new JPanel();
		tf1=new JTextField(9);
		tf2=new JTextField(3);
		tf3=new JTextField(3);
		tf1.setText(YearMonthDate.getYear()+"."+YearMonthDate.getMonth()+"."+YearMonthDate.getDate());
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		
		textFieldPanel.add(tf1);
		textFieldPanel.add(tf2);
		textFieldPanel.add(tf3);
		
		todayExercisePanel.add(labelPanel, BorderLayout.NORTH);
		todayExercisePanel.add(exerciseRadioBtnPanel, BorderLayout.CENTER);
		todayExercisePanel.add(textFieldPanel, BorderLayout.SOUTH);
		
		JPanel timeAndButton=new JPanel();
		timeAndButton.setLayout(new BorderLayout());
		
		JPanel timePanel=new JPanel();
		JLabel promiseLabel=new JLabel("약속시간");
		JLabel yearLabel=new JLabel("년");
		JLabel monthLabel=new JLabel("월");
		JLabel dateLabel=new JLabel("일");
		setYearSpinner();
		setMonthSpinner();
		setDateSpinner();
		
		timePanel.add(promiseLabel);
		timePanel.add(yearLabel);
		timePanel.add(yearSpinner);
		timePanel.add(monthLabel);
		timePanel.add(monthSpinner);
		timePanel.add(dateLabel);
		timePanel.add(dateSpinner);
		
		JPanel okCancelPanel=new JPanel();
		JButton okBtn=new JButton("확인");
		JButton cancelBtn=new JButton("취소");
		okBtn.addActionListener(okCancelBtnListener);
		cancelBtn.addActionListener(okCancelBtnListener);
		okCancelPanel.add(okBtn);
		okCancelPanel.add(cancelBtn);
		
		timeAndButton.add(timePanel, BorderLayout.NORTH);
		timeAndButton.add(okCancelPanel, BorderLayout.CENTER);

		
		add(radioBtnPanel, BorderLayout.NORTH);
		add(todayExercisePanel, BorderLayout.CENTER);
		add(timeAndButton, BorderLayout.SOUTH);
		

		
		
	}
	
	public static void setDatePanelBtn(JButton btn) {
		datePanelBtn=btn;
	}
	
	public void setYearSpinner() {
		int year=YearMonthDate.getYear();
		String[] yearIndex=new String[82];
		for(int i=0; i<yearIndex.length; i++) {
			yearIndex[i]=(2018+i)+"";
		}
		SpinnerListModel slmYear=new SpinnerListModel(yearIndex);
		slmYear.setValue(year+"");
		yearSpinner=new JSpinner(slmYear);
		yearSpinner.setEnabled(false);
	}
	
	public void setMonthSpinner() {
		int month=YearMonthDate.getMonth();
		String[] monthIndex=new String[12];
		for(int i=0; i<monthIndex.length; i++) {
			if(i<9) monthIndex[i]="0"+(1+i);
			else monthIndex[i]=(1+i)+"";
			
		}
		SpinnerListModel slmMonth=new SpinnerListModel(monthIndex);
		if(month>=10) slmMonth.setValue(month+"");
		else slmMonth.setValue("0"+month);
		monthSpinner=new JSpinner(slmMonth);
		monthSpinner.setEnabled(false);
		
	}
	
	public void setDateSpinner() {
		int date=YearMonthDate.getDate();
		String[] dateIndex=new String[DatePanel.cal.getActualMaximum(Calendar.DATE)];
		for(int i=0; i<dateIndex.length; i++) {
			if(i<9) dateIndex[i]="0"+(1+i);
			else dateIndex[i]=(1+i)+"";
		}
		SpinnerListModel slmDate=new SpinnerListModel(dateIndex);
		if(date>=10) slmDate.setValue(date+"");
		else slmDate.setValue("0"+date);
		dateSpinner=new JSpinner(slmDate);
		dateSpinner.setEnabled(false);
		
	}
	
	

	
	
	
	ActionListener okCancelBtnListener=new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			
			if(obj instanceof JRadioButton) {
				JRadioButton btn=(JRadioButton)obj;
				if(btn.getName().equals("north")) {
					tf2.setText(btn.getText());
					
				}else if(btn.getName().equals("center")) {
					tf3.setText(btn.getText());
				}
				
			}
			if(obj instanceof JButton) {
				JButton btn=(JButton)obj;
				if(btn.getText().equals("확인")) {
					if(rb.isSelected()==false && rb2.isSelected()==false) return;
					if(rb.isSelected()) {
						datePanelBtn.setBackground(Color.GREEN);
						datePanelBtn.setText("출석");
						File schedulePath=new File("schedule");
						if(!schedulePath.isDirectory()) schedulePath.mkdir();
						File yearPath=new File(schedulePath+"\\"+YearMonthDate.getYear());
						if(!yearPath.isDirectory())yearPath.mkdir();
						File monthPath=new File(schedulePath+"\\"+YearMonthDate.getYear()+"\\"+YearMonthDate.getMonth());
						if(!monthPath.isDirectory())monthPath.mkdir();
						File dateSchedule=new File(monthPath, datePanelBtn.getName()+".txt");
						try {
							FileWriter fw=new FileWriter(dateSchedule, true);
							PrintWriter writer=new PrintWriter(fw);
							writer.println(tf1.getText());
							writer.println(tf2.getText());
							writer.println(tf3.getText());
							
							writer.flush();
							writer.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						setVisible(false);
						
					}else if(rb2.isSelected()){
						datePanelBtn.setBackground(Color.RED);
						datePanelBtn.setText("불참");
						File schedulePath=new File("schedule");
						if(!schedulePath.isDirectory()) schedulePath.mkdir();
						File yearPath=new File(schedulePath+"\\"+YearMonthDate.getYear());
						if(!yearPath.isDirectory())yearPath.mkdir();
						File monthPath=new File(schedulePath+"\\"+YearMonthDate.getYear()+"\\"+YearMonthDate.getMonth());
						if(!monthPath.isDirectory())monthPath.mkdir();
						File dateSchedule=new File(monthPath, datePanelBtn.getName()+".txt");
						try {
							FileWriter fw=new FileWriter(dateSchedule, true);
							PrintWriter writer=new PrintWriter(fw);
							writer.println(tf1.getText());
							writer.println(tf2.getText());
							writer.println(tf3.getText());
							
							writer.flush();
							writer.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}


						setVisible(false);
					}
				}else if(btn.getText().equals("취소")) {
					setVisible(false);
				}
			}else return;
			
		}
	};
	
}

//String[] timeArr=new String[25];
//for(int i=0; i<timeArr.length; i++) {
//	
//	if(i<10) timeArr[i]="0"+i;
//	else timeArr[i]=i+"";
//}
//String[] minuteArr=new String[60];
//for(int i=0; i<minuteArr.length; i++) {
//	if(i<10) minuteArr[i]="0"+i;
//	else minuteArr[i]=i+"";
//}

//setBounds(480, 384, 320, 256);	