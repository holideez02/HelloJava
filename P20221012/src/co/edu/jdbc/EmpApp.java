package co.edu.jdbc;

import java.util.List;

public class EmpApp {
	public static void main(String[] args) {
		EmployeeDAO empDao = new EmployeeDAO();
		
		//입력.
		int empId = 500;
		String lastName = "Hong";
		String email = "hongkil@email.com";
		String jobId = "ST_MAN";
		String hireDate = "2021-05-11";
		Employee emp1 = new Employee(empId, lastName, email, hireDate, jobId);
		
//		empDao.insert(emp1);
		empDao.update(emp1); //업데이트할려면 위에 값도 바꿔줘야지
//		empDao.delete(empId);
//		System.out.println(empDao.getEmp(empId));
		
		//조회.
		List<Employee> employees = empDao.search();
		
		for(Employee emp : employees) {
			System.out.println(emp);
		}
	}
}
