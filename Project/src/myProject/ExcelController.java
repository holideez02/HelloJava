package myProject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelController {
	 
//    @Autowired
//    BoardRepository repository;
    public void downloadExcel() throws IOException { //https://shanepark.tistory.com/260, https://gaemi606.tistory.com/entry/Java-Excel-%ED%8C%8C%EC%9D%BC-%EC%83%9D%EC%84%B1%ED%95%98%EA%B8%B0
    	SwimDAO dao = new SwimDAO();
//    	userList=(ArrayList<Swim>) dao.listSearch();
 
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("회원 목록");
        int rowNo = 0;
 
        Row headerRow = sheet.createRow(rowNo++);
        headerRow.createCell(0).setCellValue("회원번호");
        headerRow.createCell(1).setCellValue("이름");
        headerRow.createCell(2).setCellValue("성별");
        headerRow.createCell(3).setCellValue("생년월일");
        headerRow.createCell(4).setCellValue("연락처");
 
//        List<Swim> list = repository.findAll();
        List<Swim> list = new ArrayList<>();
        for (Swim sm : list) {
            Row row = sheet.createRow(rowNo++);
            row.createCell(0).setCellValue(sm.getUserNo());
            row.createCell(1).setCellValue(sm.getName());
            row.createCell(2).setCellValue(sm.getSex());
            row.createCell(3).setCellValue(sm.getBirth());
            row.createCell(4).setCellValue(sm.getPhoneNum());
        }
 
        File currDir = new File(".");                // 현재 프로젝트 경로를 가져옴
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "userList.xlsx";    // 파일명 설정

//        Workbook workbook = createWorkBook(tables);        // workbook을 반환하는 메서드

        FileOutputStream fileOutputStream = new FileOutputStream(fileLocation);        // 파일 생성
        workbook.write(fileOutputStream);                                            // 엑셀파일로 작성
        workbook.close();
    }
}