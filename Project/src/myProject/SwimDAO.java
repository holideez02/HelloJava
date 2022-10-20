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

	// 관리자 계정 분실시에 로그인과 비밀번호 찾기
	public Login getLogin(String userName) {
		conn = getConnect();
		String sql = "select * from login where user_name =?";

		Login lg = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userName);

			rs = psmt.executeQuery();
			if (rs.next()) {
				lg = new Login(rs.getString("id"), rs.getString("passwd"), rs.getString("user_name"),
						rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return lg;
	}

	// Create. 회원생성
	public Swim insert(Swim swim) {
		conn = getConnect();

		String seq = "select user_seq.nextval from dual";
		String mon = "select user_money from swim";

		String sql = "insert into swim (user_seq, user_name, user_sex, "
				+ "user_birth, user_phone, user_email, user_address, "
				+ "user_course, user_money, creation_date, user_teacher)"
				+ " values(user_seq.nextval,?,?,?,?,?,?,?,?,sysdate,?)";
		try { // user_seq 얻어옴
			int seqInt = 0;
			psmt = conn.prepareStatement(seq);
			rs = psmt.executeQuery();
			if (rs.next()) {
				seqInt = rs.getInt(1);
			}

			int money = 0; //money 얻어옴
			psmt = conn.prepareStatement(mon);
			rs = psmt.executeQuery();
			if (rs.next()) {
				money = rs.getInt(1);
			}

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, swim.getName());
			psmt.setString(2, swim.getSex());
			psmt.setString(3, swim.getBirth());
			psmt.setString(4, swim.getPhoneNum());
			psmt.setString(5, swim.getEmail());
			psmt.setString(6, swim.getAddress());
			psmt.setString(7, swim.getCourse());
			psmt.setInt(8, swim.getMoney());
			psmt.setString(9, swim.gettName());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 입력되었습니다.");

			swim.setUserNo(seqInt);
			swim.setMoney(money);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return swim;
	}

	// Read. 회원목록 조회
	public List<Swim> listSearch(Swim sm) {
		conn = getConnect();
		List<Swim> list = new ArrayList<Swim>();

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

	// Read. 회원 상세조회
	public Swim search(int userNo) {
		conn = getConnect();
		String sql = "select s.user_seq, s.user_name, s.user_sex, s.user_birth, s.user_phone, s.user_email"
				+ ", s.user_address, s.user_course, s.user_money, s.creation_date, c.teacher "
				+ "from swim s JOIN course c " + "ON s.user_course = c.course " + "where s.user_seq = ?";
		Swim swim = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userNo);

			rs = psmt.executeQuery();
			if (rs.next()) {
				swim = new Swim(rs.getInt("user_seq"), rs.getString("user_name"), rs.getString("user_sex"),
						rs.getString("user_birth"), rs.getString("user_phone"), rs.getString("user_email"),
						rs.getString("user_address"), rs.getString("user_course"), rs.getInt("user_money"),
						rs.getString("creation_date"), rs.getString("teacher"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return swim;
	}

	// Read. 강좌별 상세조회
	public List<Swim> courseSearch(String course) {
		conn = getConnect();
		String sql = "select * from swim where user_course = ? order by user_seq";
		List<Swim> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, course);

			rs = psmt.executeQuery();
			while (rs.next()) {
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

	// Update. 회원수정
	public void update(Swim swim) {
		String sql = " update swim " + " set user_name = ?, " + " user_sex = ?, " + " user_birth = ?, "
				+ " user_phone = ?, " + " user_email = ?, " + " user_address =?, " + " user_course = ?, "
				+ " user_money =?, " + " creation_date = ?," + " user_teacher =?" + " where user_seq = ?";
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
			psmt.setString(10, swim.gettName());
			psmt.setInt(11, swim.getUserNo());

			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// Delete. 삭제
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

	// Create. 강사 등록
	public void tInsert(Teacher t) {
		conn = getConnect();
		String sql = "insert into teacher (teacher_seq, t_name, t_id, t_class, " + "hire_date, t_phone, licence)"
				+ " values(teacher_seq.nextval, ?,?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, t.getName());
			psmt.setString(2, t.getId());
			psmt.setString(3, t.getCourse());
			psmt.setString(4, t.getHireDate());
			psmt.setString(5, t.getPhone());
			psmt.setString(6, t.getLicence());

			int r = psmt.executeUpdate();
			System.out.println("강사정보 " + r + "건 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// Read. 강사 조회
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

	// Read. 강사 상세조회
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

	// Update. 강사 수정
	public void tUpdate(Teacher t) {
		String sql = " update teacher " + " set t_name = ?, " + " t_id = ?, " + " t_class = ?, " + " hire_date = ?, "
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

	// Delete. 강사 삭제
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

	// 강사 찾기
	public String setTea(String course) {
		conn = getConnect();
		String sql = "select t_name from teacher where t_class =?";
		String t = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, course);

			rs = psmt.executeQuery();
			if (rs.next()) {
				t = rs.getString("t_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return t;
	}

	// 수강료 지정
	public int setMoney(String course) {
		conn = getConnect();
		String sql = " select money from course where course= ?";
		int money = 0;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, course);

			rs = psmt.executeQuery();
			if (rs.next()) {
				money = rs.getInt("money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return money;
	}

	public List<Swim> swimList(Swim sm) {
		List<Swim> userList = new ArrayList<Swim>();
		conn = getConnect();
		String sql = "select * from swim"//
				+ "   where user_seq = decode(?,0, user_seq, ?)" // 들어온 값이 0이면, 전체 값을 다 조회하고(employee_id), 그렇지 않으면 매개값으로
																	// 들어온 녀석과 비교
				+ "   and   user_name like '%'||?||'%' " //
				+ "   and   user_sex like '%'||?||'%' "//
				+ "   and   to_char(user_birth, 'yyyy-mm-dd') like '%'||?||'%' "//
				+ "   and   user_phone like '%'||?||'%'  "//
				+ "   and   user_email like '%'||?||'%'  "//
				+ "   and   user_address like '%'||?||'%'  "//
				+ "   and   user_course like '%'||?||'%'  "//
				+ "   and   user_money = decode(?,0, user_money, ?)"//
				+ "   and   to_char(creation_date, 'yyyy-mm-dd') like '%'||?||'%'  "//
				+ "   and   user_teacher = nvl(?, user_teacher) "// 들어오는 값이 null이면 job_id값으로.
				+ " order by user_seq";
		try {
			psmt = conn.prepareStatement(sql); // sql에서 갖고 온 결과를 list에 담아주기
			psmt.setInt(1, sm.getUserNo());
			psmt.setInt(2, sm.getUserNo());
			psmt.setString(3, sm.getName());
			psmt.setString(4, sm.getSex());
			psmt.setString(5, sm.getBirth());
			psmt.setString(6, sm.getPhoneNum());
			psmt.setString(7, sm.getEmail());
			psmt.setString(8, sm.getAddress());
			psmt.setString(9, sm.getCourse());
			psmt.setInt(10, sm.getMoney());
			psmt.setInt(11, sm.getMoney());
			psmt.setString(12, sm.getDate());
			psmt.setString(13, sm.gettName());

			rs = psmt.executeQuery();

			while (rs.next()) {
				int uNo = rs.getInt("user_seq");
				String name = rs.getString("user_name");
				String sex = rs.getString("user_sex");
				String birth = rs.getString("user_birth");
				String phone = rs.getString("user_phone");
				String email = rs.getString("user_email");
				String address = rs.getString("user_address");
				String course = rs.getString("user_course");
				String money = rs.getString("user_money");
				String date = rs.getString("creation_date");
				String tName = rs.getString("user_teacher");

				Swim s = new Swim(uNo, name, sex, birth, phone, email, address, course, uNo, date, tName);
				userList.add(s);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return userList;
	}
}
