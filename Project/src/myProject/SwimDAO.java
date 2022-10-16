package myProject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SwimDAO extends DAO {

	// 로그인
	public int login(String id, String pswd) {
		String sql = "select * from login where id = ? and passwd = ?";
		conn = getConnect();
		int login = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pswd);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return 1;
			} else {
				return login = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return login;
	}

	// 생성
	public void insert(Swim swim) {
		String sql = "insert into swim (user_seq, user_name, user_sex, user_phone, user_email, user_address, user_course, creation_date)\r\n"
				+ " values(user_seq.nextval, '" + swim.getName() + "', '" + swim.getSex() + "', '" + swim.getPhoneNum()
				+ "', '" + swim.getEmail() + "', '" + swim.getAddress() + "', '" + swim.getCourse() + "', sysdate)";
		System.out.println(sql);
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 회원목록 조회
	public List<Swim> listSearch() {
		conn = getConnect();
		List<Swim> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from swim order by user_seq");
			while (rs.next()) {
				list.add(new Swim(rs.getInt("user_seq"), rs.getString("user_name"), rs.getString("user_sex"),
						rs.getString("user_phone"), rs.getString("course")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 회원 상세조회
	public Swim search(int userNo) {
		conn = getConnect();
		String sql = "select * from swim where user_seq = ?";
		Swim swim = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userNo);

			rs = psmt.executeQuery();
			if (rs.next()) {
				swim = new Swim(rs.getInt("user_seq"), rs.getString("user_name"), rs.getString("user_sex"),
						rs.getString("user_phone"), rs.getString("user_email"), rs.getString("user_address"),
						rs.getString("user_course"), rs.getInt("user_money"), rs.getString("creation_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return swim;

	}

	// 수정
	public void update(Swim swim) {
		String sql = " update swim " + " set user_name = ?, " + " user_sex = ?, " + " user_phone = ?, "
				+ " user_email = ?, " + " user_address =?, " + " user_course = ?, " + " user_money =?, "
				+ " creation_date = ?" + " where user_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, swim.getName());
			psmt.setString(2, swim.getSex());
			psmt.setString(3, swim.getPhoneNum());
			psmt.setString(4, swim.getEmail());
			psmt.setString(5, swim.getAddress());
			psmt.setString(6, swim.getCourse());
			psmt.setInt(7, swim.getMoney());
			psmt.setString(8, swim.getDate());
			psmt.setInt(9, swim.getUserNo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 삭제
	public boolean delete(int UserNo) {
		String sql = "delete from swim where user_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, UserNo);
			
			int r = psmt.executeUpdate();
			if(r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}

}
