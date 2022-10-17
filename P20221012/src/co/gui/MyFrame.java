package co.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {

	public MyFrame() {
		setTitle("윈도우 UI"); // JFrame이 가진 메소드를 사용하는 것
		setSize(300, 250); // 윈도우 사이즈. 화면 창!

		// 버튼
		setLayout(new FlowLayout()); // 배치관리자.

		JButton btn = new JButton("확인"); // 버튼이라고 하는 component를 만든 것
		JButton btn2 = new JButton("취소");
		// 이벤트가 발생했을때 매개값으로 선언되어있는 인터페이스(동작)를 구현
		btn.addActionListener(e -> System.out.println("확인버튼 클릭.")); //람다식

		btn2.addActionListener(e -> { //람다식. 실행할 구문이 두개이상이면 {} 넣기
			System.out.println("취소버튼 클릭.");
			System.exit(0); // 종료
		});
		add(btn); // JFrame에 컨트롤을 등록
		add(btn2);

		setVisible(true); // 화면에 출력.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 눌렀을때 화면종료.

	}

	public static void main(String[] args) {
		new MyFrame(); // 호출하면서 실행
	}
}
