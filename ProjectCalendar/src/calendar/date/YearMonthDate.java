package calendar.date;

public class YearMonthDate {
	
	private static int year=2018;
	private static int month=1;
	private static int date=1;
	
	
	public static int getYear() {
		return year;
	}
	
	public static int getMonth() {
		return month;
	}
	
	public static int getDate() {
		return date;
	}
	
	public static void setYear(int year) {
		YearMonthDate.year = year;
	}
	
	public static void setMonth(int month) {
		YearMonthDate.month = month;
	}
	
	public static void setDate(int date) {
		YearMonthDate.date = date;
	}

}
