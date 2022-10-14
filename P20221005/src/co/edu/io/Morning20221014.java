package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Morning20221014 {
	public static void main(String[] args) throws Exception {

		ArrayList<Member> memberList = new ArrayList<>();

		while (true) {
			Scanner scn = new Scanner(System.in);

			System.out.println("1.등록 2.종료 3.보기");
			System.out.print("선택>> ");

			int menu = scn.nextInt();
			scn.nextLine();
			String[] memAry = null;

			if (menu == 1) { //등록
				System.out.println(">> 입력. 예시) 회원아이디 회원이름 회원포인트");
				String memVal = scn.nextLine();
				memAry = memVal.split(" ");
				Member mem = new Member(memAry[0], memAry[1], Integer.parseInt(memAry[2]));

				memberList.add(mem);

				if (memVal.equals("quit")) {
					break;
				}

				System.out.println("completed.");
			} else if (menu == 2) { // 저장
				try (FileWriter fos = new FileWriter("C:/Temp/memberList.txt");) {

					for (Member memb : memberList) {
						fos.write(memb.getUserId() + "\t" + memb.getName() + "\t" + memb.getPoint() + "\n");
					}
				}
				System.out.println("종료.");
				break;

			} else if (menu == 3) { // 보기
				try {
					FileReader reader = new FileReader("C:/Temp/memberList.txt"); //입력
					
					while(true) {
						int bytes = reader.read(); //int타입으로 지정되서 2byte씩 읽어들임
						if(bytes == -1) {
							break;
						}
						System.out.print((char) bytes); //정수타입을 그대로 출력하지 말고 char로 바꿔주자.
					}
					reader.close();
					System.out.println("completed.");
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void write() {
		ArrayList<Member> memberList = new ArrayList<>();

		try (FileOutputStream fos = new FileOutputStream("C:/Temp/memberList.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) { // try안에 넣어주면 close 각각 안해줘도 됨

			oos.writeObject(memberList); // 오브젝트 타입을 작성. write

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("completed.");

	}

	public static void read() {

		try (FileInputStream fis = new FileInputStream("C:/Temp/memberList.txt");
				ObjectInputStream oos = new ObjectInputStream(fis);) {
			ArrayList<Member> memberList = (ArrayList<Member>) oos.readObject(); // 리턴타입이 object기 때문에 어떤거든 다 읽을 수 있음

			for (Member mem : memberList) {
				System.out.println(mem.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
