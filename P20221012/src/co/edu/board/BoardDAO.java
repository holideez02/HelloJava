package co.edu.board;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD ( Create, Read, Update, Delete) 
public class BoardDAO extends DAO {

	// 생성
	public void insert(Board brd) {
		String sql = "insert into board (board_num, board_title, board_content, board_writer, creation_date, cnt)\r\n" + "values("
				+ brd.getBoardNum() + ", '" 
				+ brd.getBoardTitle() + "', '" 
				+ brd.getBoardContent() + "', '"
				+ brd.getBoardWriter() + "', '"
				+ brd.getDate() + "', "
				+ brd.getCnt() + ")";
		System.out.println(sql);
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 글 목록 조회
	public List<Board> listSearch() {
		conn = getConnect();
		List<Board> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from board order by board_num");
			while (rs.next()) {
				list.add(new Board(rs.getInt("board_num")
						, rs.getString("board_title")
						, rs.getString("board_writer")
						, rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 글 상세 조회
	public Board search(int boardNum) {
		conn = getConnect();
		String sql = "select * from board where board_num = ?";
		Board brd = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				brd = new Board(rs.getInt("board_num")
						, rs.getString("board_title")
						, rs.getString("board_content")
						, rs.getString("board_writer")
						, rs.getString("creation_date")
						, rs.getInt("cnt"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return brd;
	}

	// 수정
	public void update(Board brd) {
		String sql = "update board "
				+ "set board_content = ?, "
				+ "    creation_date = ?, "
				+ "where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getBoardContent());
			psmt.setString(2, brd.getDate());
			psmt.setInt(3, brd.getBoardNum());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public boolean delete(int boardNum) {
		String sql = "delete from board where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			
			int r = psmt.executeUpdate();
			if (r>0)
				return true;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
}
