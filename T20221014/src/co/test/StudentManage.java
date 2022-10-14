package co.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class StudentManage {

	File file = new File("c:/Temp/studentList.txt");
	ArrayList<Student> studentList = new ArrayList<>();
	Scanner scn = new Scanner(System.in);

	// 싱글톤 인스턴스 생성.
	private static StudentManage instance = new StudentManage();

	private StudentManage() {
		readFromFile();
	}

	public static StudentManage getInstance() {
		return instance;
	}

	// 등록.
	public void add(Student student) {

		studentList.add(student);
		System.out.println("<<입력되었습니다!>>");

	}

	// 삭제.
	public void del(int studNo) {
		boolean exists = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i) != null && studNo == studentList.get(i).getStudNo()) {
				studentList.remove(i);
				System.out.println("삭제되었습니다.");
				exists = true;
			}
		}
		if (!exists) {
			System.out.println("해당정보가 없습니다.");
		}
	}

	// 목록(입력순서).
	public void list() {
		System.out.println("-------------------");
		System.out.println("학번 이름 나이 영어 국어 총점");
		System.out.println("-------------------");

		for (Student std : studentList) {
			System.out.println(std.toString());
		}
	}

	// 순위(총점순서).
	public void ord() {
		for (int j = 0; j < studentList.size() - 1; j++) {
			for (int i = 0; i < studentList.size()- 1; i++) {
				if (studentList.get(i).getSumScore() > studentList.get(i + 1).getSumScore()) {
					int temp = 0;
					int score1 = studentList.get(i).getSumScore();
					int score2 = studentList.get(i + 1).getSumScore();
					temp = score1;
					score1 = score2;
					score2 = temp;
				}
			}
		}
	}

	// 저장된 파일을 읽어오기.
	public void readFromFile() {

		try {
			FileReader fr = new FileReader(file); //
			BufferedReader br = new BufferedReader(fr);//

			String studentInfo = null;
			String[] itemAry = null;

			while (true) {
				studentInfo = br.readLine();
				if (studentInfo == null) { // 파일의 끝부분이면 종료.
					break;
				}
				itemAry = studentInfo.split(" ");
				
				int no = Integer.parseInt(itemAry[0]);
				String name = itemAry[1];
				int age = Integer.parseInt(itemAry[2]);
				int eng = Integer.parseInt(itemAry[3]);
				int math = Integer.parseInt(itemAry[4]);
				int sum = Integer.parseInt(itemAry[5]);
				Student student = new Student(no, name, age, eng, math, sum);
				studentList.add(student);

			}
			br.close();
			fr.close();

		} catch (Exception e) {
			System.out.println("읽을 파일이 없습니다.");
		}
	} // 입력스트림

	// 입력된 내용을 파일에 저장하기.
	public void storeToFile() {
		try {
			FileWriter fw = new FileWriter(file);

			for (Student student : studentList) {
				fw.write(student.getStudNo() + "\t" + student.getStudName() + "\t" + student.getStudAge() + "\t"
						+ student.getEngScore() + "\t" + student.getMathScore() + "\t" + student.getSumScore() + "\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 출력스트림

}
