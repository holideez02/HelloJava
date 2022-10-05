package co.edu.variable;

public class MethodCalendar {

	public static void main(String[] args) {
		makeCal(9); // 호출.
	}

	public static void makeCal(int month) {
		System.out.println("         >>>> " + month + "월 <<<<");
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };
		// 요일 출력.
		for (String day : days) { // days라는 배열의 갯수만큼 for 반복을 할게요. day에 하나씩 받아옴!
			System.out.printf("%4s", day); // printf는 매개값을 두개 받는 메소드(문자열 하나, 다른거 하나)
		}
		System.out.println(); //요일 산출 후 줄바꿈 이루어짐
		
		//1일의 위치 지정.
		for(int i=0; i<getFirstDay(month); i++) { //i<getFirstDay(9)라면 9월달에 해당하는 공간값을 가지고 오겠지!
			System.out.printf("%4s", " "); //목요일이 1일이라면 앞에 네 공간이 비워져야 하니까.
		}
		
		// 날짜 출력.
		for (int i=1; i<=getLastDate(month); i++) {
			System.out.printf("%4d", i); //뒤에 가지고오는 값이 숫자면 d 4자리 너비만큼 띄워줄게요.
			if((i + getFirstDay(month))%7==0) { //7로 나눴을때 0이면(7의 배수만큼 나오면) 줄바꿈. 첫번째날짜가 무슨요일인지 알려주는
				System.out.println();
			}
		}
	} //end of makeCal()
	
	public static int getFirstDay(int month) {
		if(month==9) {
			return 4;
		} else if(month ==8) {
			return 1;
		} else if(month ==7) {
			return 5;
		} else if(month ==6) {
			return 3;
		} else {
			return 0;
		}
	} // end of getFirstDay()
	
	public static int getLastDate(int month) {
		switch(month) {
		case 9 : 
			return 30;
		case 8 : 
			return 31;
		case 7 : 
			return 31;
		case 6 : 
			return 30;
		default: 
			return 30; 
		}
	}
}// end of class.
