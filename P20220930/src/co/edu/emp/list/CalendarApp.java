package co.edu.emp.list;

public class CalendarApp {
	public static void main(String[] args) {
//		MethodCalendar cal = new MethodCalendar(); //불가
		MethodCalendar cal = MethodCalendar.getInstance();
		cal.makeCal(1998,5);
	}
}
