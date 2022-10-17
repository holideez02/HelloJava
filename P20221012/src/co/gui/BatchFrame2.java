package co.gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class BatchFrame2 extends JFrame{
	
	public BatchFrame2() {
		setTitle("BorderLayout 관리자");
		setSize(300,250);
		
		setLayout(new BorderLayout(10,10)); //위치를 지정하는 레이아웃. 매개값으로 숫자를 넣으면 좌우 / 아래위 여백가능
		
		JButton top = new JButton("top");
		JButton left = new JButton("left");
		JButton center = new JButton("center");
		JButton right = new JButton("right");
		JButton bottom = new JButton("bottom");
		
		add("North", top);
		add("West", left);
		add("Center", center);
		add("East", right);
		add("South", bottom);
		
		setVisible(true); //컴포넌트를 다 배치하고 실행됨. 이 문장 이후에 쓰여진 컴포넌트는 실행이 안됨 ㅠㅠ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); //화면의 중앙에 실행하고 싶을때
		
	}
	public static void main(String[] args) {
		new BatchFrame2();
	}
}
