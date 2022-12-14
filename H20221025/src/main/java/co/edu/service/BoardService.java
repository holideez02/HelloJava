package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.board.faqVO;

public interface BoardService {
	//기능만 정의.
	public BoardVO insertBoard(BoardVO vo); //입력기능
	public List<BoardVO> getList(BoardVO vo); //목록조회
	public BoardVO findBoard(int boardNo); //한건 조회
	public boolean updateBoard(BoardVO vo); //수정
	public boolean deleteBoard(int boardNo); //삭제
	public List<faqVO> boardList(faqVO vo); //faq 목록
	
	//페이지 기능.
	public List<BoardVO> pageList(int page);
	public List<faqVO> faqPageList(int page); // faq 페이징
	
	//회원가입 기능
	public MemberVO memberInsert(MemberVO vo); 
	
	//로그인 기능
	public MemberVO login(String id, String passwd);
	
	//회원목록.
	public List<MemberVO> memberList();
	
	//비밀번호찾기
	public MemberVO getPassWd(String id);
	
	//메일보내기
	public String sendMail(String from, String to, String subject, String content);
	
	//비밀번호 재설정
	public MemberVO update(MemberVO mvo);
}
