package co.edu.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStreamExample {
	
	public static void main(String[] args) {
		read();
	}
	
	public static void read() { //입력 스트림!
		
		try {
			FileReader reader = new FileReader("src/co/edu/io/ByteStreamExample.java"); //입력
			
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
	public static void write() { //출력 스트림!
		Scanner scn = new Scanner(System.in);
		
		// 문자기반 스트림 생성. Reader/ Writer(출력)
		try {
			FileWriter fw = new FileWriter("C:/Temp/addr.txt"); // 출력
			
			while(true) {
				System.out.print(">> ");
				String temp = scn.nextLine(); // 한 라인씩 읽어들임
				if(temp.equals("quit")) //quit이라고 쓰면 종료
					break;
				
				fw.write(temp + "\n"); //줄바꿈 위해 \n
			}
			
			fw.close();
			scn.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("completed.");
	}
}
