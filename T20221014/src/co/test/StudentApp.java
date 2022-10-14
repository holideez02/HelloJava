package co.test;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentApp {
	public static void main(String[] args) {

		StudentManage app = StudentManage.getInstance();
		Scanner scn = new Scanner(System.in);
//		ArrayList<Student> studentList = new ArrayList<>();

		while (true) {
			
			System.out.println("------------------------------");
			System.out.println("1.등록 2.삭제 3.목록 4.순위 5.종료");
			System.out.println("------------------------------");
			System.out.println("선택 > ");
			int menu = scn.nextInt();
			
			if (menu == 1) { // 등록.
				Student std = null;
				System.out.print("학생번호>> ");
				int studNo = scn.nextInt(); scn.nextLine();
				System.out.print("학생이름>> ");
				String studName = scn.nextLine();
				System.out.print("학생나이>> ");
				int studAge = scn.nextInt(); scn.nextLine();
				System.out.print("영어점수>> ");
				int engScore = scn.nextInt(); scn.nextLine();
				System.out.print("국어점수>> ");
				int mathScore = scn.nextInt(); scn.nextLine();
				int sumScore = engScore + mathScore;
				
				std = new Student(studNo, studName, studAge, engScore, mathScore, sumScore);
				app.add(std);
				
			} else if (menu == 2) { // 삭제.
				System.out.println("삭제할 학생번호>>");
				int studNo = scn.nextInt(); scn.nextLine();
				app.del(studNo);
				
			} else if (menu == 3) { // 목록.
				app.list();
			} else if (menu == 4) { // 순위.
				app.ord();
			} else if (menu == 5) { // 종료.
				app.storeToFile();
				System.out.println("<<저장되었습니다!!>>");
				break;
			}

		}

		scn.close();
		System.out.println("프로그램 종료.");
	}
}
