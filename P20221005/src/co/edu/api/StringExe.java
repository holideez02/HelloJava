package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {

//		String fileName = "src/co/edu/api/Data.txt";
		String fileName = "src/co/edu/api/Birth.txt";
		File file = new File(fileName);

		String searchKey = "자 바";
		searchKey = searchKey.replace(" ", ""); //공백을 없애서 자 바 라고 검색해도 나오게끔..

//		Scanner scn = null;
//		try {
//			scn = new Scanner(file);
//			while (true) {
//				String str = scn.nextLine();
//				if (str == null) 
//					break;
//
//				if (str.indexOf(searchKey) != -1) {
//					System.out.println(str);
//				} 
//				
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (NoSuchElementException e) {
//
//		}
		
		//주민등록번호로 여자,남자 구분 
		Scanner scn = null;
		try {
			scn = new Scanner(file);
			while (true) {
				String str = scn.nextLine();
				if (str == null) 
					break;
				System.out.println(str);
				
//				str = str.replace(" ", "");
//				str = str.replace("-","");
//				
//				if (str.charAt(6) == '1' || str.charAt(6) == '3') {
//					System.out.println("남자 입니다.");
//				} else if(str.charAt(6) == '2' || str.charAt(6) == '4') {
//					System.out.println("여자 입니다.");
//				} 
//					else if(){ //년도, 월, 일 정보가 잘못되면 잘못된번호라고 인식.
//					System.out.println("잘못된 번호입니다.");
//				}
				
				//교수님은..이렇게하셨다...
				if(str.replace("-", "").charAt(6) % 2 ==1) {
					System.out.println("남자입니다.");
				}else if(str.replace("-", "").charAt(6)%2 ==0) {
					System.out.println("여자입니다.");
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {

		}

		System.out.println("end of prog.");
	}
}
