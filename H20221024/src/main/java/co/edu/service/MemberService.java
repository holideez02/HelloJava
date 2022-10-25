package co.edu.service;

import java.util.List;

import co.edu.vo.MemberVO;

//CRUD 기능 담아놓음. 인터페이스니까 기능만 정의해놓음.
public interface MemberService {
	public void addMember(MemberVO vo); //추가
	public void modifyMember(MemberVO vo); //수정
	public void removeMember(String id); // 삭제
	public MemberVO findMember(String id); //한건조회
	public List<MemberVO> memberList(); //전체목록
	
	public MemberVO login(String id, String passwd); //로그인 처리
}
