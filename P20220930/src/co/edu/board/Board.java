package co.edu.board;

public class Board {
	private int boardNo; //글번호
	private String title; //글 제목
	private String content; //글 내용
	
	public Board() {} //매개변수가 없는 기본생성자.(초기화 위한)

	public Board(int boardNo, String title, String content) { // 오른쪽 - source -generate constructor using fields... 자동생성됨
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}

	// 오른쪽- source - generate getters and setters
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	//source- toString() :정의해주면 값들을 문자열로 보여줄수 있게 자동으로 만들어줌
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
