package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.common.DAO;
import co.edu.vo.MemberVO;

public class MemberDAO extends DAO{
	
	//생성, 수정, 삭제, 한건조회, 목록조회
	public void memberInsert(MemberVO vo) { //생성
		conn = getConnect();
		
		String sql ="insert into members (id, passwd, name, email)\r\n"
				+ "values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	
	public MemberVO memberSearch(String id) { //한 건 조회
		conn = getConnect();
		String sql = "select id, passwd, name, email"
				+ "from members "
				+ "where id = ?";
		MemberVO vo = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(rs.getString("id"), rs.getString("passwd")
						, rs.getString("name"), rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	public void memberUpdate(MemberVO vo) { //수정
		conn = getConnect();
		String sql = "update members set id=?, "
				+ "passwd =?, name =?, email=? "
				+ "where id=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getId());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
	}
	
	public boolean memberDelete(String id) {
		conn = getConnect();
		String sql = "delete from members where id =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int r = psmt.executeUpdate();
			if(r>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	public List<MemberVO> memberList(){ //전체조회
		conn = getConnect();
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from members";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberVO(rs.getString("id"), rs.getString("passwd")
						, rs.getString("name"), rs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

}
