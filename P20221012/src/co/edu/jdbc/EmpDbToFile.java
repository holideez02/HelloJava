package co.edu.jdbc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmpDbToFile { // db에서 파일을 읽어와요
	public static void main(String[] args) {

		try {
			FileWriter fw = new FileWriter("c:/Temp/empFile.txt");
			EmployeeDAO dao = new EmployeeDAO();
			List<Employee> list = dao.search();

			for (Employee emp : list) {
				fw.write(emp.getEmployeeId() + " " + emp.getLastName()+ " " +emp.getEmail() + " " +emp.getHireDate() + " " +emp.getJobId()+ " \n" );
				
			}
			
			System.out.println("완료");
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
