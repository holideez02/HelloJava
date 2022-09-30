package co.edu.board;

public class BoardExe {
	public static void main(String[] args) {
//		BoardDAO dao = new BoardDAO(); // 인스턴스 생성해서 호출하는 메서드로 생성해야함.
		BoardDAO dao = BoardDAO.getInstance(); //이렇게 호출해주어야 함
		dao.exe(); //인스턴스 안의 메소드를 호출하며 프로그램 실행
	}
}
