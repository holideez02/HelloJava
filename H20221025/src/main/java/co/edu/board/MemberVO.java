package co.edu.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //생성자 만들어주는
@NoArgsConstructor //매개값이 없는 생성자 만들어주는
public class MemberVO {
	public MemberVO(String id, String passwd) {
		this.id=id;
		this.passwd = passwd;
	}
	private String id;
	private String passwd;
	private String name;
	private String email;
	private String responsibility;
}
