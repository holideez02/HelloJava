package co.dev;

import java.util.ArrayList;

public class StudExample {
	public static void main(String[] args) {
		Student stud = new Student(101, "홍길동", 80);
		String name1 = stud.getStudName();
		int score1 = stud.getScore();

		// 배열에다가 넣으면 인덱스번호도 지정해줘야하고.. 귀찮으니 arrayList에다가!
		ArrayList<Student> studList = new ArrayList<Student>();
		studList.add(stud);
		studList.add(new Student(102, "김현수", 88)); // add는 제일 뒤에다가 하나씩 추가.
		studList.add(0, new Student(103, "박문수", 78));

		Student hong = new Student(201, "홍수환", 90); // 을 김현수 앞에 담고싶다면?

		for (int i = 0; i < studList.size(); i++) {
			if (studList.get(i).getStudName().equals("김현수")) {
				studList.add(i, hong);
				break;
			}
		}

		// 컬렉션 출력.
		for (int i = 0; i < studList.size(); i++) {
			System.out.println(studList.get(i).getStudName());
		}

		// 학번기준으로 정렬
		ArrayList<Student> sortAry = new ArrayList<>();

		for (int i = 0; i < studList.size(); i++) {
			for (int j = 0; j < i; j++) {

			}
		}
	}
}
