package co.edu.board;

public class Board {
	int boardNum;
	String boardTitle;
	String boardContent;
	String boardWriter;
	String date;
	int cnt;
	
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
	public Board(int boardNum, String boardContent, int cnt) {
		this.boardNum = boardNum;
		this.boardContent = boardContent;
		this.cnt = cnt;
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
	public String toString() {
		return "게시판 [글번호: " + boardNum + ", 제목: " + boardTitle + ", 내용: " + boardContent
				+ ", 작성자: " + boardWriter + ", 작성일: " + date + ", 조회목록=" + cnt + "]";
	}
	
}

