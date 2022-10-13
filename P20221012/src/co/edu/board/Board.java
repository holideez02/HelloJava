package co.edu.board;

public class Board {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String date;
	private int cnt;
	private String id;
	private String pswd;
	private String reply;
	
	public Board() {};
	public Board(int boardNum, String boardTitle, String boardContent, String boardWriter, String date, int cnt) {
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.date = date;
		this.cnt = cnt;
	}
	
	public Board(int boardNum, String boardTitle, String boardWriter, String date) {
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.date = date;
	}
	public Board(int boardNum, String boardTitle, String boardContent, String boardWriter, int cnt) {
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.cnt = cnt;
	}
	public Board(int boardNum, String boardContent) {
		this.boardNum = boardNum;
		this.boardContent = boardContent;
	}
	
	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() { //글 상세
		return "[글번호: " + boardNum + ", 제목: " + boardTitle + ", 내용: " + boardContent
				+ ", 작성자: " + boardWriter + ", 작성일: " + date + ", 조회목록=" + cnt + "]";
	}
	
	public String showInfo() { //글 목록 보기
		return "글번호: " + boardNum + " 제목: " + boardTitle + " 작성자: " + boardWriter + " 작성일: " + date ;
	}
	
}

