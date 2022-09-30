package co.edu.board;

import java.util.Scanner;

//기능만.
public class BoardDAO {
	//Singleton 방식의 인스턴스 생성. 목적은 인스턴스를 여러개 만들지 않기 위함
	private static BoardDAO instance = new BoardDAO(); //static이기 때문에 클래스에 소속됨. 여러개가 아닌 하나만 생성할 수 있게 됨
	private BoardDAO() {} // 외부에서 접근 못하도록 private
	public static BoardDAO getInstance() { //외부에서 인스턴스를 만들 수 있는 유일한 방법. 
		return instance; //인스턴스를 갖고옴
	}
		
	
	
	Scanner scn = new Scanner(System.in);
	Board[] myBoards = new Board[100]; // 변수 myBoards에 인스턴스 담기위한 배열 생성
	boolean isCheck =false;
	
	// 1.글등록
	public void addBoard() {
		System.out.println("글등록 기능.");
		System.out.print("글번호 입력>>> ");
		int bNo = scn.nextInt();scn.nextLine();
		System.out.print("글제목입력 >> ");
		String title = scn.nextLine();
		System.out.print("글내용입력 >> ");
		String content = scn.nextLine();
		
		Board brd = new Board(bNo, title, content); //이러면 set, get 따로 불러올 필요 없음.
		// 배열등록
		for (int i=0; i<myBoards.length; i++) {
			if(myBoards[i] == null) { //배열이 비어있다면
				myBoards[i] = brd; //거기에 담을게요
				break;
			}
		}
	}

	// 2.글목록 조회
	public void boardList() {
		System.out.println("글목록 기능");
		for(Board brd : myBoards) {
			if(brd != null) {
				System.out.println(brd.toString());
			} 
		}
		
	}
	
	// 3.글상세보기
	public void boardDetail() {
		System.out.println("상세보기 기능");
		System.out.println("몇번을 보실껀가요? >> ");
		int bNo = scn.nextInt();scn.nextLine();
		
		//글번호 없으면
		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] != null && myBoards[i].getBoardNo() == bNo){
				isCheck = true;
				break;
			} 
		}
		if(!isCheck) {
			System.out.println("글번호가 없습니다.");
		}
		
		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] != null && bNo == myBoards[i].getBoardNo()) {
				System.out.println(myBoards[i].getContent().toString());
				break;
			}
		}
	}
	
	// 4.글삭제
	public void delBoard() {
		System.out.println("글삭제 기능");
		System.out.println("몇번을 삭제할까요? >> ");
		int bNo = scn.nextInt();scn.nextLine();
		
		//글번호 없으면
		for(int i=0; i<myBoards.length; i++) {
			if(myBoards[i] != null && myBoards[i].getBoardNo() == bNo){
				isCheck = true;
				break;
			} 
		}
		if(!isCheck) {
			System.out.println("글번호가 없습니다.");
		}
		
		for(int i=0; i<myBoards.length; i++) {
			if(bNo == myBoards[i].getBoardNo()) {
				myBoards[i]=null;
				break;
			}
		}System.out.println("삭제되었습니다.");
	}
	
	// 5.전체 메뉴
	public void exe() {
		boolean run = true;
		while(run) { //종료하는 조건을 사용자가 정할 수 있게끔 
			System.out.println("1.글등록 2.글목록 3.글상세보기 4.글삭제 9.종료");
			System.out.print("선택>> ");
			
			int menu = scn.nextInt();
			switch(menu) {
			case 1: 
				addBoard(); 
				break;
			case 2: 
				boardList(); 
				break;
			case 3: 
				boardDetail(); 
				break;
			case 4: 
				delBoard(); 
				break;
			case 9:
				run = false;
				break;
				default: // 아무것도 아니면 실행되는것. break는 필요없음
					System.out.println("잘못된 메뉴입니다.");
			}
		} // end of while
		System.out.println("프로그램 종료.");
	} //end of exe();
}
