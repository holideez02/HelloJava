package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.dao.BoardDAO;

public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao = new BoardDAO();
	

	@Override
	public BoardVO insertBoard(BoardVO vo) { //입력
		return null;
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) { //목록조회
		return null;
	}

	@Override
	public BoardVO findBoard(int boardNo) { //상세조회
		return null;
	}

	@Override
	public boolean updateBoard(BoardVO vo) { //수정
		return false;
	}

	@Override
	public boolean deleteBoard(int boardNo) { //삭제
		return false;
	}

}
