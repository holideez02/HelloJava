package co.edu;

public class ThirdImpl implements Command{
	
	@Override
	public void exec() {
		System.out.println("SecondImpl() 실행됨.");
	}

}
