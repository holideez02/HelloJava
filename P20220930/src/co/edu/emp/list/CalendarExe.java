package co.edu.emp.list;

import java.util.Calendar;

public class CalendarExe {
	public static void main(String[] args) {
///		Calendar today = new Calendar(); //불가. 새롭게 생성자 호출 불가.
		Calendar today = Calendar.getInstance(); //싱글턴 방식으로 생성해야함.
		today.set(2020, 1, 1); //10월달은 9월달로. 2022년 10월 1일
		System.out.println("요일정보:" + today.get(Calendar.DAY_OF_WEEK)); //day of week는 요일정보를 나타냄. 일요일부터 1. 오늘은 수요일. 일월화수 4 산출!
		System.out.println("날짜정보:" + today.get(Calendar.DATE));
		System.out.println("월정보:" + (today.get(Calendar.MONTH)+1));
		System.out.println("월말정보:" + today.getActualMaximum(Calendar.DATE));
	}
}
