package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Student{
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
//	@Override
//	public int hashCode() {
//		return name.hashCode();
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Student) {
//			Student std = (Student) obj;
//			return this.name.equals(std.name);
//		}else {			
//			return false;
//		}
//	}
}
public class MapExample3 {
	public static void main(String[] args) {
		// 1.저장 2.조회 3.종료
		Map<String, Integer> students = new HashMap<>(); //학생이름, 점수
		
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.저장 2.조회 3.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();scn.nextLine();
			if(menu==1) {
				System.out.print("학생이름 입력>> ");
				String name = scn.nextLine();
				System.out.print("학생점수 입력>> ");
				int score = scn.nextInt();
				
				students.put(name, score);
				
			}else if(menu==2) {
				System.out.print("조회할 학생이름 입력>> ");
				String searchName = scn.nextLine();

				System.out.println(searchName + "학생의 점수는: " + students.get(searchName));
			}else if(menu==3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		} //end of while
		System.out.println("프로그램 종료.");
	}
}
