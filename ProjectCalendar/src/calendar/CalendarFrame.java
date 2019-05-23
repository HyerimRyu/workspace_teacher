package calendar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import calendar.center.CenterPanel;
import calendar.date.YearMonthDate;
import calendar.north.NorthPanel;


public class CalendarFrame extends JFrame{
	
	static byte[] bytes=null;
	static String s;
	 
	public CalendarFrame() {
		
		
		
		
		setTitle("CalendarFrame");
		setBounds(320, 256, 640, 512);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new NorthPanel(), BorderLayout.CENTER);
		
		setVisible(true);
		
	}

	

	public static void main(String[] args) {
		
		CalendarFrame calendarFrame=new CalendarFrame();
		
		Map<String, File> test=new HashMap<String, File>();
		
//		while(calendarFrame.isVisible()) {
//			for(int i=0; i<=83; i++) {
//				for(int j=1; j<=12; j++) {
//					for(int k=1; k<=31; k++) {
//
//						try {
//							File file=new File("schedule\\"+(2018+i)+"\\"+j+"\\"+k+".text");
//							FileInputStream fis=new FileInputStream(file);
//							BufferedInputStream bfr=new BufferedInputStream(fis);
////							FileReader fr=new FileReader(file);
////							BufferedReader reader=new BufferedReader(fr);
//							
//						} catch (Exception e) {
//								// TODO Auto-generated catch block
//								e.printStackTrace();
//						}
//						
//					
//					}
//				}
//			}
//			
//			
//		
//		}
		


	}
	
	
	
	
	

}

