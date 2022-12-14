package co.edu.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //생성자 만들어주는
@NoArgsConstructor //매개값이 없는 생성자 만들어주는
public class faqVO {
	private int faqNo;
	private String title;
	private String content;
	private String writer;
	private String writeDate; 
	private int clickCnt;
	private String image;
}
