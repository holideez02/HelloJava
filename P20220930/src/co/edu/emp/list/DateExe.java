package co.edu.emp.list;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateExe {
	//날짜, 시간
	public static void main(String[] args) {
		Date today = new Date(); //1970.1.1부터 ms/s로 계산해서 지정됨. 2022.10.5 => 52*12*30*24*60*60*1000.. 에반데
//		today.setYear(2022); 
//		today.setMonth(11);
		String ymd = "2022-10-05 13:14:15";
		//특별한 날짜 지정
		//2022-10-05 형식으로 보게끔 지정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(today));
		try {//이거 실행되다가
			today = sdf.parse(ymd); // sdf의 형식으로 출력.
			System.out.println(today); //문자열을 date타입으로 바꾼것. Wed Oct 05 13:14:15 KST 2022
		} catch (ParseException e) { //에러가 발생하면 밑의 문장 실행
			e.printStackTrace();
		}
		
		//날짜(LocalDate) + 시간(LocalTime) = LocalDateTime
		LocalDateTime day = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh시mm분ss초");
//		day.format(dtf);
		day = LocalDateTime.of(2022, 10, 5, 10, 20, 30); //시간 지정해주기
		System.out.println(day.format(dtf));
	}
}
