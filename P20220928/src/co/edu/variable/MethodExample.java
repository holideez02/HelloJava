package co.edu.variable;

public class MethodExample {
	// 가로, 세로넣어주면 => 너비 구하기
	public static int getArea(int w, int h) {
		int result = w * h;
		return result;
//		return w * h;
	}
	
	// 배열요소의 각 값의 합.
	public static int sumAry(int[] ary) {
		int sum = 0;
		for(int i = 0; i<ary.length; i++) {
			sum = sum + ary[i];
		}
		return sum;
	}
	
	//두 수의 나눈 결과를 반환.
	public static double divide(double n1, double n2) {
		double result = n1 / n2;
		return result; //d3에 저장이 되겠지 
	}
	
	// 두 수를 나누는 작업. 매개변수를 int로 지정.
	public static double divide(int n1, int n2) {
		//1bit * 8 = 1byte. 
		//유형: byte(1), short(2), int(4), long(8)
		//	 : float(4), double(8)
		if(n2 == 0) { // 실수/정수와 0을 나누게 되면 infinity가 뜸. 그러니 값이 0이면 0으로 산출되도록.
			return 0;
		}
		double result = (double) n1 / n2; //둘다 int로 반환값을 받으면 .5가 사라지니까 double로 받아줌. 3/2 =>1.0 으로 산출. 
		// 작은값을 큰타입으로 형변환. int와 long으로 받아왔다면 둘다 long으로 바꿔서 계산후 double로 형변환 // 3.0 / 2.0 =>1.5
		// 둘다 int로 받아와도 하나를 double로 수동형변환(casting) 해주면 옆의것도 자동형변환 시켜서 값이 정확하게 1.5로 산출됨
		return result;
	}
	
	public static void main(String[] args) {
		int result = getArea(20, 15);
		System.out.println("전체 너비는 " + result);
		
		int[] intAry = {23, 45, 12};
		result = sumAry(intAry); //sumAry메소드가서 intAry넣어준 값 저장해올게요~
		System.out.println("전체 배열요소의 합계는 " + result);
		
		//이렇게 다른 값 넣어도 메소드에서 계산가능
//		int[] intAry2 = {22, 33, 44, 55};
//		result = sumAry(intAry2);
//		System.out.println("전체 배열요소의 합계는 " + result);
		
		//배열요소 합하는것 
//		int sum = 0;
//		for(int i=0; i<intAry.length; i++) {
//			sum = sum + intAry[i];
//		}
		
		//이번엔 실수! float, double. double이 값이 더 커서 자주 사용
		double d1 = 23.4567;
		double d2 = 12.34;
		double d3 = d1 + d2; // 받아오는값이 int면 에러. d1과 d2가 double이니까 맞춰줘야지. 아니면 형변환!
		
		d3 = divide(d1, d2);
		System.out.println("나눈결과는 " + d3);
		
		d3 = divide(3,0); // 정수와 0으로 나누게되면 infinity로 뜸. 
		System.out.println("나눈결과는 " + d3);
	}
	
}
