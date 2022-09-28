package co.edu.variable;

import java.util.Arrays;

//import co.edu.variable.String;

public class practice {
		public static void main(String[] args) {
			int[] numAry = { 34, 21, 12 };
			
			// 반복적인 처리.
//			numAry = {12, 21, 34} //작은 값 순으로 위치 바꾸기
			// 케이스 : n1> n2> n3 => ?
			// 케이스 : n1 < n2 > n3 => ?
			// 배열 위치 바꾸는 연습

			//두개 비교하고 위치 바꾸면 되겠지!!
//			if(numAry[0] > numAry[1]) { //34 > 21
//				int temp = numAry[0];
//				numAry[0] = numAry[1]; //21
//				numAry[1] = temp; //
//			}
//			
//			for(int n : numAry) {
//				System.out.println(n);
//			}
			
			Arrays.sort(numAry);
			System.out.println(Arrays.toString(numAry));
		}
}
