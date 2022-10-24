package co.edu.service;

import java.util.List;

import co.edu.dao.MemberDAO;
import co.edu.vo.MemberVO;

//서비스 로직: 실제 데이터베이스 등록/수정/삭제/조회
//조회 후 추가와 같은 이런 복합적인 기능이라면 서비스로직인 여기에서 더 추가해서 쓸 수 있도록. 메소드가 더 길어지면 복잡하니까

public class MemberServiceImpl implements MemberService{

	MemberDAO dao = new MemberDAO();
	@Override
	public void addMember(MemberVO vo) {
		dao.memberInsert(vo);
	}

	@Override
	public void modifyMember(MemberVO vo) {
		dao.memberUpdate(vo);
	}

	@Override
	public void removeMember(String id) {
		dao.memberDelete(id);
	}

	@Override
	public MemberVO findMemmber(String id) {
		return dao.memberSearch(id);
	}

	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

}
