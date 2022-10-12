package co.edu.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO extends DAO {

	// 삭제
	public boolean delete(int empId) {
		String sql = "delete from employees where employee_id = ?";
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);

			int r = psmt.executeUpdate();
			if (r > 0)
				return true;
//			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false; // 아무것도 처리 안됐을때
	}

	// 업데이트
	public void update(Employee emp) {
		String sql = "update employees "//
				+ "set Last_name = ?,  "//
				+ "	   email = ?,  "//
				+ "    hire_date = ?, "//
				+ "    job_id = ? "//
				+ "where employee_id = ?"; // 쿼리를 만드는데 지금 값을 정하지 않고 나중에 할당하겠다 라는 물음표
		conn = getConnect();
		try {
			psmt = conn.prepareStatement(sql);// 만들때 sql을 넣었기 때문에
			psmt.setString(1, emp.getLastName());
			psmt.setString(2, emp.getEmail());
			psmt.setString(3, emp.getHireDate());
			psmt.setString(4, emp.getJobId());
			psmt.setInt(5, emp.getEmployeeId());

			int r = psmt.executeUpdate(); // 매개값이 필요 없삼 ^_^ 만들때 sql을넣어주니까!
			System.out.println(r + "건 변경됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 입력
	public void insert(Employee emp) {
		String sql = "insert into employees (employee_id, last_name, email, hire_date, job_id)\r\n" + "values("
				+ emp.getEmployeeId() + ", '" + emp.getLastName() + "', '" + emp.getEmail() + "', '" + emp.getHireDate()
				+ "', '" + emp.getJobId() + "')";
		System.out.println(sql);
		conn = getConnect();
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql);
			System.out.println(r + "건 입력됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	// 조회.
	public List<Employee> search() {
		conn = getConnect(); // DAO에서 conn의 필드를 갖고 있어서 선언따로 안해줘도 괜찮다
		List<Employee> list = new ArrayList<>(); // 반환하기 위한 값.
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from employees order by employee_id"); // 조회
			while (rs.next()) {
				list.add(new Employee(rs.getInt("employee_id") // 칼럼값을 생성자의 매개값으로.
						, rs.getString("last_name"), rs.getString("email"), rs.getString("hire_date"),
						rs.getString("job_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); // 연결 해제 메소드
		}
		return list;
	}

	public Employee getEmp(int empId) {
		// 딱 한건만 반환.(리턴)
		conn = getConnect();
		String sql = "select * from employees where employee_id = ? order by employee_id";
		Employee emp = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);

			rs = psmt.executeQuery(); // 쿼리결과를 rs에 담아요
			if (rs.next()) { // rs에 값이 있다면(true) 실행. 값이 없으면 null이 리턴. 한건이니까 while아니고 if로 써준거
				emp = new Employee(rs.getInt("employee_id") // employee 인스턴스로 만들어줘요
						, rs.getString("last_name"), rs.getString("email"), rs.getString("hire_date"),
						rs.getString("job_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return emp;
	}
}
