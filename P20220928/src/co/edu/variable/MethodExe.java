package co.edu.variable;

public class MethodExe {
	//클래스가 시작되면 제일 먼저 시작되는 main 메소드
	public static void main(String[] args) {
//		printStar();
//		printStar(3); // 같은 이름의 메소드이지만 매개변수가 들어감. 3번 한다는거지! 실행부분은 변수타입 쓰지 않고 값만 쓰기
//		printCircle("※"); // 매개변수로 받아오는 값을 출력.
//		printCircle("♥", 5); //하트 다섯번 출력하는것 
		int result = sum(sum(2, 3), sum(3,4)); // 2,3을 반환하고 (13), 3,4를 반환하고(18), 13,18을 반환하여 80
		System.out.println("최종값은 " +  result);
	}
	
	public static void printStar() { //반환값: 없음. 매개변수: 없음.
		System.out.println("★");
	}
	
	public static void printStar(int times) { //반환값: 없음. 매개변수: 있음
		for(int i=0; i<times; i++) {
			System.out.print("★");		
			}
	}
	
	public static void printCircle(String circle) { // 
		System.out.print(circle);	
	}
	
	//출력하는 모양, 몇번할건지!
	public static void printCircle(String circle, int times) { //매개변수 두개 받아와서 모양과 갯수 설정 가능!
		for(int i=0; i<times; i++) {
			System.out.println(circle);		
			}
	}
	
	//반환값을 가지는 메소드.
	public static int sum(int n1, int n2) {
		int result = n1 * 2 + n2 * 3;
		System.out.println("결과값은 " + result);
		return result; //반환값의 유형을 받아올때는 꼭 return 써주고, int면 int로 같이 반환되어야함
	}
	
}
