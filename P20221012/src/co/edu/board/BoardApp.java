package co.edu.board;

import java.util.List;
import java.util.Scanner;

//main메소드를 담고있는 클래스
public class BoardApp {
	public static void main(String[] args) { 
		BoardDAO brdDao = new BoardDAO();
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 0.종료");
			int menu = Integer.parseInt(scn.nextLine());
			if(menu == 1) { //글등록
				System.out.println("글 번호 입력>>");
				int boardNum = Integer.parseInt(scn.nextLine());
				System.out.println("글 제목 입력>>");
				String boardTitle = scn.nextLine();
				System.out.println("글 내용 입력>>");
				String boardContent = scn.nextLine();
				System.out.println("글 작성자 입력>>");
				String boardWriter = scn.nextLine();
				System.out.println("글 작성일자 입력>>");
				String date = scn.nextLine();
				int cnt = 0;
				
				Board brd = new Board(boardNum, boardTitle, boardContent, boardWriter, date, cnt);
				brdDao.insert(brd);
				
			}else if(menu == 2) { //수정
				
			}else if(menu == 3) { //삭제
				
			}else if(menu == 4) { //목록
				System.out.println("목록을 조회합니다>>");
				List<Board> brds = brdDao.listSearch();
				
				for(Board brd : brds) {
					System.out.println(brd);
				}
				
			}else if(menu == 5) { //상세 조회
				System.out.println("조회할 글 번호 입력>>");
				int boardNum = Integer.parseInt(scn.nextLine());
				
				System.out.println(brdDao.search(boardNum));
				
			}else if(menu == 0){
				System.out.println("종료합니다..");
				break;
				
			}else {
				System.out.println("잘못된 메뉴 입니다.");
			}
		}
		scn.close();
		System.out.println("프로그램 종료");
		
		
		
	}
}
