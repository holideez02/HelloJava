package co.edu.memo.except;

public class MenuException extends Exception { //try - catch를 꼭 넣어주기. 
	int choice;
	
	public MenuException (int choice) {
		this.choice = choice;
	}
	
	public void showErrorMessage() {
		System.out.println(choice + "는 없는 메뉴입니다.");
	}
}
