package co.edu.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO{ //DB에 접근해서 CRUD기능을 처리하는 클래스. 

	// 입력
	public EmployeeVO insertEmp(EmployeeVO vo) {
		getConnect();
		
		String seq = "select employees_seq.nextval from dual";
		
		String sql = "insert into empl (employee_id, first_name, last_name, email, hire_date, job_id) "
				+ "values(?,?,?,?,?,?)";
		try {
			//sequence 획득.
			int seqInt = 0;
			psmt = conn.prepareStatement(seq);
			rs = psmt.executeQuery();
			if(rs.next()) {
				seqInt = rs.getInt(1); //첫번째 칼럼을 가지고 온다는 뜻
			}
			
			//insert작업
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, seqInt);
			psmt.setString(2, vo.getFirstName());
			psmt.setString(3, vo.getLastName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getHireDate());
			psmt.setString(6, vo.getJobId());
			int r = psmt.executeUpdate(); //실제 쿼리를 실행. 처리된 건수를 반영
			System.out.println(r + "건 입력됨. ");
			
			//새로 입력하게 된 사원번호를 알고싶어서 
			vo.setEmployeeId(seqInt); //넣어줄게~
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	// 삭제
	public void deleteEmp(int employeeId) {
		getConnect();
		String sql = "delete from empl where employee_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, employeeId);
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 수정
	public void updateEmp(EmployeeVO vo) {
		getConnect();
		String sql = "update empl set first_name =?, last_name =?, email=? hire_date =?, job_id =? where employee_id?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getFirstName());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			psmt.setInt(6, vo.getEmployeeId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 수정됨.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}
	// 목록
	public List<EmployeeVO> empList(EmployeeVO vo){
		List<EmployeeVO> empList = new ArrayList<EmployeeVO>();
		getConnect();
		String sql = "select * from empl"//
				+ "   where employee_id = decode(?,0, employee_id, ?)" // 들어온 값이 0이면, 전체 값을 다 조회하고(employee_id), 그렇지 않으면 매개값으로 들어온 녀석과 비교
				+ "   and   first_name like '%'||?||'%' " //
				+ "   and   last_name like '%'||?||'%' "//
				+ "   and   email like '%'||?||'%'  "//
				+ "   and   to_char(hire_date, 'yyyy-mm-dd') like '%'||?||'%' "//
				+ "   and   job_id = nvl(?, job_id) "// 들어오는 값이 null이면 job_id값으로. 
				+ " order by employee_id";
		try {
			psmt = conn.prepareStatement(sql); //sql에서 갖고 온 결과를 list에 담아주기
			psmt.setInt(1, vo.getEmployeeId());
			psmt.setInt(2, vo.getEmployeeId());
			psmt.setString(3, vo.getFirstName());
			psmt.setString(4, vo.getLastName());
			psmt.setString(5, vo.getEmail());
			psmt.setString(6, vo.getHireDate());
			psmt.setString(7, vo.getJobId());
			
			
			rs = psmt.executeQuery(); //rs는 컬렉션. 여러가지 데이터를 담을 수 있는!
			
			while(rs.next()) {
				int empId = rs.getInt("employee_id");
				String fName = rs.getString("first_name");
				String lName = rs.getString("last_name");
				String email = rs.getString("email");
				String hDate = rs.getString("hire_date");
				String jobId = rs.getString("job_id");
						
				EmployeeVO emp = new EmployeeVO(empId, fName, lName, email, hDate, jobId);
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} 
		return empList;
	}

}
