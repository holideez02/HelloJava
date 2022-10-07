package co.edu.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employees {
	int empId;
	String empName;
	int salary;

	public Employees(int empId, String empName, int salary) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "사번: " + this.empId + ", 이름: " + this.empName + ", 급여: " + this.salary;
	}
}

public class MorningCode {
	public static void main(String[] args) {
//		String tok = "Hello World Good";
//		Scanner scn = new Scanner(tok);
		Scanner scanner = new Scanner(System.in);

//		while(scn.hasNext())
//			System.out.println(scn.next()); //공백을 기준으로 문장을 하나씩 잘라옴

//		String[] toks = tok.split(" "); //공백을 기준으로 문장을 나누겠습니다. 배열을 문자로 만드는 유용한 메소드!
//		for(String str: toks) {
//			System.out.println(str);
//		}

		// 사용자가 입력한 첫번째 값은 empId, 두번째 값은 empName, 세번째 값은 salary에 담기
		// Employee클래스의 인스턴스를 생성.
		// ArrayList에 저장.
		// 종료를 하고싶으면 quit 종료.
		ArrayList<Employees> list = new ArrayList<Employees>(); // ArrayList 만들어놓고 
		while (true) {
			System.out.println("입력>> ex) 100 홍길동 2500"); // ex) 100 홍길동 2500
			System.out.print(">> ");
			String inputVal = scanner.nextLine(); //한줄을 쭉 받아와서 inputVal에 담아요
			String[] inputs = inputVal.split(" "); //공백
			
			//quit == 종료.
			if (inputs[0].equals("quit")) {
				break;
			}
			
			if(inputs.length != 3) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			Employees e = new Employees(Integer.parseInt(inputs[0]), inputs[1], Integer.parseInt(inputs[2])); //인스턴스 생성
			list.add(e); //ArrayList에 저장
		}
		// for(반복문)으로 출력.
		for (Employees e : list) {
			System.out.println(e); //보여주기
		}
		System.out.println("end of prog");
	}
}
