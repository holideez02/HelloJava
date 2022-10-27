package co.edu.board;

public class PageVO {
	int totalCnt; //전체건수
	int pageNum; //현재페이지
	int startPage, endPage, totalPage; //시작페이지, 끝페이지(한화면에), 전체페이지
	boolean prev, next; //이전페이지, 다음페이지
	
	public PageVO(int totalCnt, int pageNum) {
		this.totalCnt = totalCnt;
		this.pageNum = pageNum;
		
		totalPage = (int) Math.ceil(totalCnt / 10.0); //한페이지에 10개씩 나눔. 51.6 올림 => 52
		//startPage, endPage 계산.
		this.endPage = (int) Math.ceil(this.pageNum/10.0)*10; //3페이지면 3/10=0.3에 올림->1->1*10=10페이지 
		this.startPage= this.endPage -9; //1page
		if(this.endPage>totalPage) {
			this.endPage = totalPage;
		}
		
		prev = this.startPage > 10; //이전페이지
		next = this.endPage <totalPage; //다음페이지. 
		
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	@Override
	public String toString() {
		return "PageVO [totalCnt=" + totalCnt + ", pageNum=" + pageNum + ", startPage=" + startPage + ", endPage="
				+ endPage + ", totalPage=" + totalPage + ", prev=" + prev + ", next=" + next + "]";
	}
	
	
}
