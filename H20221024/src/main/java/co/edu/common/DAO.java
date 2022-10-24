package co.edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	public Connection conn;
	public Statement stmt;
	public ResultSet rs;
	public PreparedStatement psmt;

	// Connection 객체를 반환해주는 getConnect 메소드
	public Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // oracleDriver 클래스 불러옴
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jsy", "jsy");
//			System.out.println("연결 성공");

		} catch (Exception e) {
			System.out.println("연결 실패");
		}
		return conn;
	}

	// Resource 해제하는 disconnect 메소드
	public void disconnect() {
		try {
			if(rs != null) rs.close(); //값이 할당되었을때만 닫아주는. nullpoint 방지
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
