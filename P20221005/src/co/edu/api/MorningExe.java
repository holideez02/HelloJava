package co.edu.api;

public class MorningExe {
	public static void main(String[] args) {
		int cnt = 1;
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("%3d", cnt++);
			}
			System.out.println();
		}

		int cnt2 = 1;
		for (int j = 4; j >= 1; j--) {
			for (int i = 1; i < 5; i++) {
				if (j <= i) {
					System.out.printf("%3d", cnt2++);
				} else {
					System.out.printf("%3s", " ");
				}
			}
			System.out.println();
		}
	}
}
