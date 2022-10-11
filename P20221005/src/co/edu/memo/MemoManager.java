package co.edu.memo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 실제로 조회, 삭제, 등록하는 기능들 모아놓은
public class MemoManager {

	List<Memo> memoStorage = new ArrayList<>(); // 정보를 담아놓기 위한 컬렉션.
	File file = new File("c:/Temp/memobook.dat"); // 읽을때도 쓸때도 여기.
	Scanner scn = new Scanner(System.in);

	// 싱글톤
	private static MemoManager instance = new MemoManager();

	private MemoManager() {
		readFromFile(); //제일먼저 호출 되게끔
	}

	public static MemoManager getInstance() {
		return instance;
	}

	// 추가.
	public void inputData() {
		System.out.print("번호> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("날짜> ");
		String date = scn.nextLine();
		System.out.print("내용> ");
		String content = scn.nextLine();

		memoStorage.add(new Memo(no, date, content));
	}

	// 조회.날짜를 입력받으면 해당되는 날짜의 메모를 전부 출력
	public void searchData() {
		System.out.print("날짜>");
		String sDate = scn.nextLine();
		boolean exists = false;
		for (int i = 0; i < memoStorage.size(); i++) {
			if (sDate.equals(memoStorage.get(i).getDate())) { // 메모 인스턴스만 비교할려면 memoStorage.get(i)
				System.out.println(memoStorage.get(i).toString());
				exists = true;
			}
		}
		if (!exists) {
			System.out.println("해당날짜의 메모가 없습니다.");
		}
	}

	// 삭제. 번호를 입력하면 한 건 삭제.
	public void deleteData() {
		System.out.println("번호 입력>");
		int dNo = Integer.parseInt(scn.nextLine());
		boolean exists = false;
		for(int i=0; i< memoStorage.size(); i++) {
			if(memoStorage.get(i) != null && dNo == memoStorage.get(i).getNo()) {
				memoStorage.remove(i);
				System.out.println("삭제완료.");
				exists = true;
			}
		}
		if (!exists) {
			System.out.println("삭제할 메모가 없습니다.");
		}

		
	}
	
	// 프로그램이 실행되면 파일을 읽어서 데이터를 컬렉션에(memoStorage) 저장해주는 기능.
	public void readFromFile() {
		// try with resource. 따로 close를 해주지 않아도 되니까 편한..
		try( FileInputStream fis = new FileInputStream(file);
			 ObjectInputStream ois = new ObjectInputStream(fis);
			){
			
			memoStorage = (List<Memo>) ois.readObject();
			
		} catch(Exception e) {
//			e.printStackTrace();
			return; //예외가 뜨면 따로 출력하지않고 리턴~ 없으면 아무것도 안담아도 됩니다
		}
	}
	
	// 종료하면 파일 저장.
	public void storeToFile() {
		try( FileOutputStream fos = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(fos);
			){
			oos.writeObject(memoStorage); //지금까지의 내용을 저장함.
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
