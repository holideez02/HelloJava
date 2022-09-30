package co.edu.friend;

import java.util.Scanner;

//기능만.
public class FriendsDAO {

	private static FriendsDAO instance = new FriendsDAO();
	private FriendsDAO() {}
	public static FriendsDAO getInstance() {
		return instance;
	}
	
	
	Scanner scn = new Scanner(System.in);
	
	
}

