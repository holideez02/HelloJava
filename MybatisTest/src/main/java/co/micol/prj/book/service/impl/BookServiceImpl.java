package co.micol.prj.book.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.book.mapper.BookMapper;
import co.micol.prj.book.service.BookService;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.DataSource;

public class BookServiceImpl implements BookService {
	// session 연결
	private SqlSession sqlSession = DataSource.getInstance().openSession(true); //true가 빠지면 auto커밋이 안됨. 커넥션에 연결한 것
	private BookMapper map = sqlSession.getMapper(BookMapper.class); //sqlSession을 열때 BookMapper.class를 가져옴
	
	@Override
	public List<BookVO> bookSelectList() {
		// 북 전체리스트
		return map.bookSelectList(); //bookService 인터페이스랑 bookMapper 인터페이스랑 이름 같게 만들었으니까 메서드로..
	}

	@Override
	public BookVO bookSelect(BookVO vo) {
		// 한권의 책 정보 가져오기
		return map.bookSelect(vo);
	}

	@Override
	public int bookInsert(BookVO vo) {
		// 책 입력
		return map.bookInsert(vo);
	}

	@Override
	public int bookDelete(BookVO vo) {
		// 책 삭제
		return map.bookDelete(vo);
	}

	@Override
	public int bookUpdate(BookVO vo) {
		// 책 수정
		return map.bookUpdate(vo);
	}

}
