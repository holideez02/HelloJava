package co.edu.emp.list;

import java.util.Calendar;

public class MethodCalendar {
		private static MethodCalendar instance = new MethodCalendar(); //정적타입으로 필드선언
		private MethodCalendar() {};
		public static MethodCalendar getInstance() { //정적 타입으로 메소드 선언 
			return instance;
		}
		
	public void makeCal(int year, int month) { //정적메소드이기 때문에 클래스명.메소드 하면 호출가능
		System.out.println("     >>>> "+ year + "년 " + month + "월 <<<<");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		// 요일 출력.
		for (String day : days) { // days라는 배열의 갯수만큼 for 반복을 할게요. day에 하나씩 받아옴!
			System.out.printf("%4s", day); // printf는 매개값을 두개 받는 메소드(문자열 하나, 다른거 하나)
		}
		System.out.println(); //요일 산출 후 줄바꿈 이루어짐
		
		//1일의 위치 지정.
		for(int i=0; i<getFirstDay(year,month); i++) { //i<getFirstDay(9)라면 9월달에 해당하는 공간값을 가지고 오겠지!
			System.out.printf("%4s", " "); //목요일이 1일이라면 앞에 네 공간이 비워져야 하니까.
		}
		
		// 날짜 출력.
		for (int i=1; i<=getLastDate(year,month); i++) {
			System.out.printf("%4d", i); //뒤에 가지고오는 값이 숫자면 d 4자리 너비만큼 띄워줄게요.
			if((i + getFirstDay(year,month))%7==0) { //7로 나눴을때 0이면(7의 배수만큼 나오면) 줄바꿈. 첫번째날짜가 무슨요일인지 알려주는
				System.out.println();
			}
		}
	} //end of makeCal()
	
	public int getFirstDay(int year, int month) { //월 정보를 넣어주면 1일의 요일정보를 알려줌
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		return cal.get(Calendar.DAY_OF_WEEK) -1; //일요일이 1부터 시작.이니까 -1을 해줘야 저번처럼 가능
		
	} // end of getFirstDay()
	
	public int getLastDate(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, 1);
		return cal.getActualMaximum(Calendar.DATE);
	}
}// end of class.
