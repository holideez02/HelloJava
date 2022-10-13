package co.edu.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//main메소드를 담고있는 클래스
public class BoardApp {
	public static void main(String[] args) {
		BoardDAO brdDao = new BoardDAO();
		Reply rp = new Reply();
		Scanner scn = new Scanner(System.in);

		boolean checked = false;
		String userId1 = null;
		Board brd2 = null;

		while (!checked) {
			System.out.println("아이디를 입력하세요");
			String userId = scn.nextLine();
			System.out.println("비밀번호를 입력하세요");
			String userPw = scn.nextLine();
			if (brdDao.login(userId, userPw) == 1) {
				userId1 = userId;
				System.out.println(userId + "님 로그인 성공!");
				break;
			} else {
				System.out.println("로그인 실패");
				continue;
			}
		}

		while (true) {
			System.out.println("1.글등록 2.글수정 3.글삭제 4.글목록 5.상세조회 0.종료");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) { // 글등록
				System.out.println("글 번호 입력>>");
				int boardNum = Integer.parseInt(scn.nextLine());
				System.out.println("글 제목 입력>>");
				String boardTitle = scn.nextLine();
				System.out.println("글 내용 입력>>");
				String boardContent = scn.nextLine();
				String date = null;
				String boardWriter = userId1;
				int cnt = 0;

				Board brd = new Board(boardNum, boardTitle, boardContent, boardWriter, cnt);
				brdDao.insert(brd);

			} else if (menu == 2) { // 수정
				System.out.println("수정할 글 번호 입력>>");
				int boardNum = Integer.parseInt(scn.nextLine());

				Board brd3 = brdDao.search(boardNum);

				if (brd3 != null) {
					if (userId1.equals(brd3.getBoardWriter())) {
						System.out.println("수정할 내용 입력>>");
						String boardContent = scn.nextLine();

						Board brd = new Board(boardNum, boardContent);
						brdDao.update(brd);
					} else {
						System.out.println("권한 없습니다.");
					}
				}

			} else if (menu == 3) { // 삭제
				System.out.println("삭제할 글번호 입력>>");
				int boardNum = Integer.parseInt(scn.nextLine());
				Board brd1 = brdDao.search(boardNum);

				if (brd1 != null) {
					if (userId1.equals(brd1.getBoardWriter())) {
						if (brdDao.delete(boardNum)) {
							System.out.println("삭제되었습니다.");
						}
					} else {
						System.out.println("글을 삭제할 수 없습니다.");
					}
				} else {
					System.out.println("글 번호가 없습니다.");
				}

			} else if (menu == 4) { // 목록 조회
//				System.out.println("목록을 조회합니다>>");
//				List<Board> brds = brdDao.listSearch();
//
//				for (Board brd : brds) { //전체 글 보여주기
//					System.out.println(brd.showInfo());
//				}
//				for (int i = 0; i < brds.size(); i++) {
//					if (i < 3) {
//						System.out.println(brds.get(i).showInfo());
//					}
//				}
				
				System.out.println("목록을 조회합니다>>");
				List<Board> brds = brdDao.listSearch();
				
				while()
				for (int i = 0; i < brds.size(); i++) {
					if (i < 3) {
						System.out.println(brds.get(i).showInfo());
					}
				}

			} else if (menu == 5) { // 상세 조회
				System.out.println("조회할 글 번호 입력>>");
				int boardNum = Integer.parseInt(scn.nextLine());

				System.out.println(brdDao.search(boardNum));

				System.out.println("<<<< 댓글 >>>>");
				List<Reply> rep = brdDao.readReply(boardNum);
				for (Reply repl : rep) {
					System.out.println(repl.toString());
				}

				System.out.println("댓글을 달까요? 작성할려면 1, 삭제하려면 2, 나가려면 0을 누르세요.");
				int reply = Integer.parseInt(scn.nextLine());
				if (reply == 1) {
					System.out.println("댓글 내용을 입력하세요.");
					String replyContent = scn.nextLine();

					Reply re = new Reply(0, boardNum, replyContent, userId1, null);
					brdDao.writeReply(re);
					System.out.println("완료되었습니다.");

				} else if (reply == 2) {
					System.out.println("삭제할 글 번호를 입력하세요.");
					int delRe = Integer.parseInt(scn.nextLine());

					brdDao.repDelete(delRe);
					System.out.println("완료되었습니다.");

				} else if (reply == 0) {
					System.out.println("나갑니다.");
					continue;
				}

			} else if (menu == 0) {
				System.out.println("종료합니다..");
				break;

			} else {
				System.out.println("잘못된 메뉴 입니다.");
			}
		}

		scn.close();
		System.out.println("프로그램 종료");

	}
}
