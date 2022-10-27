package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.board.faqVO;
import co.edu.dao.BoardDAO;
import co.edu.dao.MemberDAO;
import co.edu.dao.faqDAO;

public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao = new BoardDAO();
	MemberDAO mdao = new MemberDAO();
	faqDAO fdao = new faqDAO();
	

	@Override
	public BoardVO insertBoard(BoardVO vo) { //입력
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) { //목록조회
		return dao.boardList(vo);
	}

	@Override
	public BoardVO findBoard(int boardNo) { //상세조회
		return dao.searchBoard(boardNo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) { //수정
		return dao.updateBoard(vo);
	}

	@Override
	public boolean deleteBoard(int boardNo) { //삭제
		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<BoardVO> pageList(int page) { //글목록 페이징
		return dao.pageList(page);
	}

	@Override
	public MemberVO memberInsert(MemberVO vo) { //회원가입 입력
		return mdao.memberInsert(vo);
	}

	@Override
	public List<MemberVO> memberList() { //회원목록조회
		return dao.memberList();
	}

	@Override
	public MemberVO login(String id, String passwd) {
		return mdao.login(id, passwd);
	}

	@Override
	public List<faqVO> boardList(faqVO vo) {
		return fdao.boardList(vo);
	}

	@Override
	public List<faqVO> faqPageList(int page) { //faq페이징
		return fdao.faqPageList(page);
	}
}
