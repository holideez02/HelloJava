package co.edu.variable;

import java.util.Arrays;

public class SortExe {
	public static void main(String[] args) {
		int[] numAry = { 34, 21, 12 ,9, 15, 22 }; //{12,21,34}로 바꾸기
		
		// 반복적인 처리.
//		numAry = {12, 21, 34} //작은 값 순으로 배열 위치 바꾸기(오름차순)
		// 케이스 : n1 > n2 > n3 => ?
		// 케이스 : n1 < n2 > n3 => ?
		// 배열의 값들이 4개이면 3번비교 -> 2번비교 -> 1번비교.
		for(int j=0; j<numAry.length-1; j++) {
			for(int i=0; i<numAry.length-1; i++) {
				if(numAry[i] > numAry[i+1]) { //i:0, i:1, i:2, i:3일때 하나씩 반복
					int temp = 0;
					temp = numAry[i]; //순서가 먼저 있는 값을 temp에 저장
					numAry[i] = numAry[i+1];
					numAry[i+1] = temp;
				}
			}
		}
//		//1) 0번과 1번 비교
//		if(numAry[0] > numAry[1]) { //34 > 21
//			int temp = numAry[0];
//			numAry[0] = numAry[1]; //21
//			numAry[1] = temp; //
//		}
//		// 1번과 2번 비교
//		if(numAry[1] > numAry[2]) { //34 > 21
//			int temp = numAry[1];
//			numAry[1] = numAry[2]; //21
//			numAry[2] = temp; //
//		}
//		// 2번과 3번 비교
//		if(numAry[2] > numAry[3]) { //34 > 21
//			int temp = numAry[2];
//			numAry[2] = numAry[3]; //21
//			numAry[3] = temp; //
//		}
//		
//		//2) 다시 0번과 1번 비교 , 1번과 2번 비교
//		if(numAry[0] > numAry[1]) { //34 > 21
//			int temp = numAry[0];
//			numAry[0] = numAry[1]; //21
//			numAry[1] = temp; //
//		}
//		if(numAry[1] > numAry[2]) { //34 > 21
//			int temp = numAry[1];
//			numAry[1] = numAry[2]; //21
//			numAry[2] = temp; //
//		}
//		//3) 마지막으로 0번과 1번 비교
//		if(numAry[0] > numAry[1]) { //34 > 21
//			int temp = numAry[0];
//			numAry[0] = numAry[1]; //21
//			numAry[1] = temp; //
//		}
		//값을 알고있다면 이렇게 
//		int temp = numAry[0];
//		numAry[0] = numAry[2];
//		numAry[2] = temp;
		
	    //4) 순서출력.
		for(int n : numAry) {
			System.out.print(n + " ");	
		}
		
		//만약.. 1억개면? ... 배열 정렬해주는 메소드
		Arrays.sort(numAry);
		System.out.println("오름차순으로 정렬한다면 " + Arrays.toString(numAry));
	}
}
