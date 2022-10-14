package co.edu.nested;

interface Run {
	void run();
}

class Runner implements Run {
	@Override
	public void run() {
		System.out.println("run.");
	}

}

public class AnonymousExample2 {
	public static void main(String[] args) {
		
		//익명구현객체: 상황에 따라 기능이 다를 경우 사용.
		Run runner = new Run() { //인터페이스기 때문에 new를 쓸 수 없는데 . run을 구현하는 익명 객체를만들겠다는 의미
			String kind;//필드도 선언가능.
			
			void runKind() {
				System.out.println("육상");
			}
			
			@Override
			public void run() {
				System.out.println("구현 run");
				runKind(); // 외부에서는 쓸 수 없기 때문에 미리 안에서 실행해주는것
			} 
			
		};
		runner.run();
		
		Run runner2 = new Run() {
			@Override
			public void run() {
				System.out.println("구기종목");
			}
		};
		runner2.run();
	}
}
