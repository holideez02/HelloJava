package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//ObjectOutputStream 은 Serializable 이라는 인터페이스를 구현하는 클래스여야만 한다.

public class ObjectExample {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
				ObjectInputStream oos = new ObjectInputStream(fis);) {
			ArrayList<Emp> list = (ArrayList<Emp>) oos.readObject(); // 리턴타입이 object기 때문에 어떤거든 다 읽을 수 있음

			for (Emp emp : list) {
				System.out.println(emp.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void writeObj() {
		// 입출력 스트림 -> Class 인스턴스를 생성하고 생성한 값들을 파일입출력으로 저장.
		// ObjectInputStream, ObjectOutputStream : Object 기반.
		ArrayList<Emp> empList = new ArrayList<>();
		empList.add(new Emp(100, "홍길동", "인사"));
		empList.add(new Emp(200, "김민식", "개발"));
		empList.add(new Emp(300, "이유진", "총무"));

		try (FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) { // try안에 넣어주면 close 각각 안해줘도 됨

			oos.writeObject(empList); // 오브젝트 타입을 작성. write

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("completed.");
	}
}
