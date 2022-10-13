package co.edu.board;

public class Reply {
	private int repSeq; //댓글번호(시퀀스)
	private int boardNum; //원본 글번호
	private String repContent; //댓글내용
	private String repWriter; //댓글작성자
	private String date; //날짜
	
	public Reply() {};
	public Reply(int repSeq, int boardNum, String repContent, String repWriter, String date) {
		super();
		this.repSeq = repSeq;
		this.boardNum = boardNum;
		this.repContent = repContent;
		this.repWriter = repWriter;
		this.date = date;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getRepContent() {
		return repContent;
	}

	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}

	public String getRepWriter() {
		return repWriter;
	}

	public void setRepWriter(String repWriter) {
		this.repWriter = repWriter;
	}

	public int getRepSeq() {
		return repSeq;
	}

	public void setRepSeq(int repSeq) {
		this.repSeq = repSeq;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "[글번호=" + boardNum
				+ ", 댓글번호=" + repSeq
				+ ", 댓글내용=" + repContent 
				+ ", 댓글 작성자="+ repWriter 
				+ ", 작성일=" + date + "]";
	}
	

	
}
