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

	// 회원생성
	public void insert(Swim swim) {
		conn = getConnect();
		String sql = "insert into swim (user_seq, user_name, user_sex, "
				+ "user_birth, user_phone, user_email, user_address, " 
				+ "user_course, user_money, creation_date, user_teacher)\r\n"
				+ " values(user_seq.nextval, '" + swim.getName() 
				+ "', '" + swim.getSex() + "', '" + swim.getBirth()
				+ "', '" + swim.getPhoneNum() + "', '" + swim.getEmail() 
				+ "', '" + swim.getAddress() + "', '"+ swim.getCourse() 
				+ "', " + swim.getMoney() + ", sysdate, '" + swim.gettName() +"' )";
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
						rs.getString("user_birth"), rs.getString("user_phone"), rs.getString("user_course")));
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
						rs.getString("user_birth"), rs.getString("user_phone"), rs.getString("user_email"),
						rs.getString("user_address"), rs.getString("user_course"), rs.getInt("user_money"),
						rs.getString("creation_date"), rs.getString("user_teacher"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return swim;

	}
	// 강좌별 상세조회
	public List<Swim> courseSearch(String course) {
		conn = getConnect();
		String sql = "select * from swim where user_course = ?";
		List<Swim> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, course);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				list.add(new Swim(rs.getInt("user_seq"), rs.getString("user_name"), rs.getString("user_sex"),
						rs.getString("user_birth"), rs.getString("user_phone"), rs.getString("user_email"),
						rs.getString("user_address"), rs.getString("user_course"), rs.getInt("user_money"),
						rs.getString("creation_date"), rs.getString("user_teacher")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	// 수정
	public void update(Swim swim) {
		String sql = " update swim " + " set user_name = ?, " + " user_sex = ?, " + " user_birth = ?, "
				+ " user_phone = ?, " + " user_email = ?, " + " user_address =?, " + " user_course = ?, "
				+ " user_money =?, " + " creation_date = ?" + " where user_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, swim.getName());
			psmt.setString(2, swim.getSex());
			psmt.setString(3, swim.getBirth());
			psmt.setString(4, swim.getPhoneNum());
			psmt.setString(5, swim.getEmail());
			psmt.setString(6, swim.getAddress());
			psmt.setString(7, swim.getCourse());
			psmt.setInt(8, swim.getMoney());
			psmt.setString(9, swim.getDate());
			psmt.setInt(10, swim.getUserNo());

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
			if (r > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}
	
	//강사 등록
	public void tInsert(Teacher t) {
		conn = getConnect();
		String sql = "insert into teacher (teacher_seq, t_name, t_id, t_class, "
				+ "hire_date, t_phone, licence)\r\n"
				+ " values(teacher_seq.nextval, '" + t.getName() 
				+ "', '" + t.getId() + "', '" + t.getCourse()
				+ "', '" + t.getHireDate() + "', '" + t.getPhone() 
				+ "', '" + t.getLicence() +"')";
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println("강사정보 " + r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//강사 조회
	public List<Teacher> tSearchList() {
		conn = getConnect();
		List<Teacher> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from teacher order by teacher_seq");
			while (rs.next()) {
				list.add(new Teacher(rs.getInt("teacher_seq"), rs.getString("t_name"), rs.getString("t_id"),
						rs.getString("t_class")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	//강사 상세조회
	public Teacher tsearch(int tNo) {
		conn = getConnect();
		String sql = "select * from teacher where teacher_seq = ?";
		Teacher t = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, tNo);

			rs = psmt.executeQuery();
			if (rs.next()) {
				t = new Teacher(rs.getInt("teacher_seq"), rs.getString("t_name"), rs.getString("t_id"),
						rs.getString("t_class"), rs.getString("hire_date"), rs.getString("t_phone"),
						rs.getString("licence"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return t;
	}
	//강사 수정
	public void tUpdate(Teacher t) {
		String sql = " update teacher " + " set t_name = ?, " + " t_id = ?, " 
				+ " t_class = ?, "+ " hire_date = ?, " 
				+ " t_phone = ?, " + " licence =? " + " where teacher_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, t.getName());
			psmt.setString(2, t.getId());
			psmt.setString(3, t.getCourse());
			psmt.setString(4, t.getHireDate());
			psmt.setString(5, t.getPhone());
			psmt.setString(6, t.getLicence());
			psmt.setInt(7, t.gettNo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	//강사 삭제
	public boolean tDelete(int tNo) {
		String sql = "delete from teacher where teacher_seq = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, tNo);

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
	
//	public static String escEntered(String prompt) {
//		System.out.println(prompt);
//	}

}
