package co.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//간단한 계산기
public class ComponentExam3 extends JFrame {

	String[] keys = { "1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/" };
	JButton[] keyBtn = new JButton[16];
	String displayText = ""; // 그냥 선언만 하면 null로 뜨니 ""로 주도록
	String left, right;

	public ComponentExam3() {
		setTitle("계산기 UI");
		setBounds(100, 100, 300, 220); // 위치와 크기를 지정하는 메소드

		setLayout(new FlowLayout()); // 순차적으로 놓는 flowLayout형태로 지정

		// display 정보를 출력하기 위한 panel
		JPanel displayPanel = new JPanel();
		JTextField display = new JTextField("0", 20); // 초기값, 크기
		display.setHorizontalAlignment(JTextField.RIGHT); // 오른쪽 수평정렬
		displayPanel.add(display);

		// 사용자가 값을 입력하도록 하는 버튼을 생성하기 위한 panel
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(4, 4, 5, 5)); // 4열 4행
		for (int i = 0; i < keyBtn.length; i++) { // 16번 반복문 돌며
			keyBtn[i] = new JButton(keys[i]); // keys의 인덱스 값으로 라벨 붙임
			// 버튼 이벤트.
			keyBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					String keyOper = ((JButton) e.getSource()).getText();
					// 계산처리.
					if (keyOper.equals("=")) {
						left = displayText.substring(0, displayText.indexOf("+")); // 345+12.
						right = displayText.substring(displayText.indexOf("+") + 1);
						displayText = String.valueOf(Integer.parseInt(left) + Integer.parseInt(right)); //left와 right는 문자열이니까 integer로 바꿔서 정수로 계산 후 다시 string으로 형변환 
						display.setText(displayText);
						return; //actionPerformed 메소드 종료.
					}
					
					if (keyOper.equals("C")) {
						displayText = "0";
						display.setText(displayText);
						return; //actionPerformed 메소드 종료.
					}
					
					displayText += keyOper;
					display.setText(displayText);
				}
			});
			keyPanel.add(keyBtn[i]);
		}

		add(displayPanel);
		add(keyPanel); // window에다가 둘다 추가해줌

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new ComponentExam3();
	}

}
