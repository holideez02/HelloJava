package co.edu.inherit.friend;

public class FriendMain {
	public static void main(String[] args) {
		
		final String constVar ="Hello";
//		constVar = "World"; // final을 붙여 상수로 선언했기 때문에 값을 변경할 수 없음(Const Variable);
		FriendExe app = new FriendExe();
		app.exe();
	}
}
