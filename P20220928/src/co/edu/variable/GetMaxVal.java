package co.edu.variable;

public class GetMaxVal {
	public static void main(String[] args) {
		int[] randomAry = new int[5]; // 정수 5개 담을 수 있는 배열을 만들고, 이 주소값을 randomAry에 담아둘게요.
		randomAry[0] = (int) (Math.random() * 100) + 1; // 0~1 사이의 임의 수를 생성. 에러나는 이유는 정수배열과 난수(실수)이기 때문. 0~100사이의 정수를
														// 만들기 위해 괄호로 묶어 *10 하고 +1(1~10사이) 정수로 형변환
		randomAry[1] = (int) (Math.random() * 100) + 1;
		randomAry[2] = (int) (Math.random() * 100) + 1;
		randomAry[3] = (int) (Math.random() * 100) + 1;
		randomAry[4] = (int) (Math.random() * 100) + 1;
		// randomAry[5] = (int)(Math.random()*100) + 1; //크기는 5인데 6번째를 넣으니 컴파일 오류

		//최대값 구하는 법
		int maxVal = 0; // 배열요소 중 최대값을 저장.
		for (int i = 0; i < 5; i++) { // i<5와 같음
			System.out.println(randomAry[i]);
			// maxVal 변수에 두 값을 비교해서 큰 값 담기.
			if (randomAry[i] > maxVal) {
				maxVal = randomAry[i];
			}

		}
		//최소값 구하는 법
		int minVal = 100;
		for (int j = 0; j < randomAry.length; j++) {
			System.out.println(randomAry[j]);
			if (randomAry[j] < minVal) {
				minVal = randomAry[j];
			}
		}

		System.out.println("생성된 배열의 임의의 값중 최대값 =>" + maxVal);
		System.out.println("생성된 배열의 임의의 값중 최소값 =>" + minVal);

	}
}
