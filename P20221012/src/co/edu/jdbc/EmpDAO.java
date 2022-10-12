package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {

	public static void main(String[] args) {
		update();
	}
	
	public static void update() { //수정.
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // oracleDriver 클래스 불러옴
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
			stmt = conn.createStatement();
			int r = stmt.executeUpdate("update empl set first_name = 'messi' where employee_id = 500"); //insert, delete, update구문을 쓰고 싶으면 executeUpdate구문 작성
			System.out.println(r + "건 변경됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생하거나 정상 처리 되더라도 반드시 실행될 문장
			try {
//				rs.close();
				stmt.close();
				conn.close(); // 연결 후 닫아주는 작업은 반드시!
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void delete() { //삭제.
		Connection conn = null;
		Statement stmt = null;
//		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // oracleDriver 클래스 불러옴
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		
			stmt = conn.createStatement();
			int r = stmt.executeUpdate("delete from empl where employee_id = 700"); //insert, delete, update구문을 쓰고 싶으면 executeUpdate구문 작성
			System.out.println(r + "건이 삭제됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생하거나 정상 처리 되더라도 반드시 실행될 문장
			try {
//				rs.close();
				stmt.close();
				conn.close(); // 연결 후 닫아주는 작업은 반드시!
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void search() { //조회. select경우!
		// jdbc driver 로드
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // oracleDriver 클래스 불러옴
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); // url, 사용자계정, pw

			stmt = conn.createStatement(); // 실행쿼리문을 전송, 결과받아오도록 하는 객체
			rs = stmt.executeQuery("select * from empl order by employee_id"); // 실행된 결과를 set컬렉션에 담아줌. 조회할때! select경우!
			// Set 컬렉션
			while (rs.next()) {
				System.out.println("사원번호: " + rs.getInt("employee_id"));
				System.out.println("이름: " + rs.getString("first_name"));
				System.out.println("급여: " + rs.getInt("salary"));
				System.out.println("=====================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 예외가 발생하거나 정상 처리 되더라도 반드시 실행될 문장
			try {
				rs.close();
				stmt.close();
				conn.close(); // 연결 후 닫아주는 작업은 반드시!
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("프로그램 종료.");
	}
}
