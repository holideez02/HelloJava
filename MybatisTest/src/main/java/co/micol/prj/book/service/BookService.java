package co.micol.prj.book.service;

import java.util.List;

import co.micol.prj.book.vo.BookVO;

public interface BookService {
	List<BookVO> bookSelectList();  //book 전체리스트 가져오기. getBookList(R)
	BookVO bookSelect(BookVO vo);   //한권의 책 상세내역 가져오기.(R) getBook 매개변수로 bookVO를 전달. 
	int bookInsert(BookVO vo);      //도서입력(C) setBook
	int bookDelete(BookVO vo);      //도서삭제(D) deleteBook
	int bookUpdate(BookVO vo);      //도서변경(U) updateBook. 의미있는 메소드 이름으로..
	
}
