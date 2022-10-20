package myProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManage {

	File file = new File("c:/Temp/userList.txt");
	ArrayList<Swim> userList = new ArrayList<>();
	Scanner scn = new Scanner(System.in);

	// 싱글톤 인스턴스 생성.
	private static UserManage instance = new UserManage();

	private UserManage() {
	}

	public static UserManage getInstance() {
		return instance;
	}


	// 입력된 내용을 파일에 저장하기.
	public void storeToFile() {
		SwimDAO dao = new SwimDAO();
		userList=(ArrayList<Swim>) dao.listSearch(null);
		try {
			FileWriter fw = new FileWriter(file);
			
			for (Swim user : userList) {
				fw.write("["+ user.getUserNo() + "] "+ user.getName() + " " + user.getSex() + " " + user.getBirth() + " "
						+ user.getPhoneNum() + "\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 출력스트림
}
