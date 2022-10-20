package myProject;

public class Login {
	private String id;
	private String pw;
	private String userName;
	private String email;
	
	public Login() {};
	public Login(String id, String pw, String userName, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.userName = userName;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
