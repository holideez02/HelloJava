package co.edu.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD ( Create, Read, Update, Delete) 
public class BoardDAO extends DAO {

	// 생성
	public void insert(Board brd) {
		String sql = "insert into board (board_num, board_title, board_content, board_writer)\r\n"
				+ "values(" + brd.getBoardNum() + ", '" + brd.getBoardTitle() + "', '" + brd.getBoardContent() + "', '"
				+ brd.getBoardWriter() +  "')";
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
				list.add(new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_writer"),
						rs.getString("creation_date")));
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
				brd = new Board(rs.getInt("board_num"), rs.getString("board_title"), rs.getString("board_content"),
						rs.getString("board_writer"), rs.getString("creation_date"), rs.getInt("cnt"));

				count(boardNum);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return brd;
	}

	// 카운트
	public void count(int boardNum) {
		String sql = "update board set cnt = cnt+1 where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);
			psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	// 수정
	public void update(Board brd) {
		String sql = "update board " + "set board_content = ?, " 
				+ "    creation_date = sysdate "
				+ "where board_num = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, brd.getBoardContent());
			psmt.setInt(2, brd.getBoardNum());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경됨.");

		} catch (SQLException e) {
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
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

	// 로그인 기능
	public int login (String id, String pswd) {
		String sql = "select * from users where id = ? and passwd = ?";
		conn = getConnect();
		int login = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pswd);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
			else {
				return login = 0;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}return login;
	}
	
	//댓글 달기
	public void writeReply(Reply rp) {
		conn = getConnect();
		String sql = "insert into reply (rep_seq, board_num, rep_content, rep_writer, creation_date) \r\n"
				+ "values(reply_seq.nextval, " 
				+ rp.getBoardNum() + ", '" 
				+ rp.getRepContent() + "', '" 
				+ rp.getRepWriter() + "', sysdate)";
		System.out.println(sql);
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
	
	//댓글 조회
	public List<Reply> readReply(int boardNum) {
		conn = getConnect();
		List<Reply> reply = new ArrayList<>();
		String sql = "select * from reply where board_num = ? order by rep_seq";
		Board brd = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNum);

			rs = psmt.executeQuery();
			while (rs.next()) {
				reply.add(new Reply(rs.getInt("rep_seq"), 
						rs.getInt("board_num"),
						rs.getString("rep_content"), 
						rs.getString("rep_writer"),
						rs.getString("creation_date")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return reply;
	}
		
	//댓글 삭제
		public boolean repDelete(int repSeq) {
			
			String sql = "delete from reply where rep_seq = ?";
			conn = getConnect();
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, repSeq);

				int r = psmt.executeUpdate();
				if (r > 0)
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return false;
		}
	}

