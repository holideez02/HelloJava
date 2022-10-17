package co.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class ComponentExam extends JFrame {
	public ComponentExam() {
		setTitle("라벨 예제");
		setSize(new Dimension(300, 250));
		
		JPanel panel = new JPanel(); //아무것도 지정 안했기 때문에 flowlayout으로 정의됨.
		JLabel label1 = new JLabel("Color Label");
		label1.setFont(new Font("Arial", Font.ITALIC, 20));
		label1.setForeground(Color.YELLOW);
		label1.setText("Yellow Font"); //라벨에 값을 지정하고 싶을때. 변경하고 싶은것을 매개값으로 주기!
		
		JLabel label2 = new JLabel("Font Label");
		label2.setFont(new Font("Arial", Font.BOLD, 25)); //폰트유형, 스타일, 크기
		label2.setForeground(Color.GREEN);
		
		JLabel label3 = new JLabel();
		ImageIcon icon = new ImageIcon("c:/Temp/spring.jpg");
		//이미지 크기 지정???
		label3.setIcon(icon);
		label3.setPreferredSize(new Dimension(180,150)); // 아이콘 크기 지정할때 
		
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		
		add(panel); //panel에 label 붙이고, window에 panel을 다시 추가.
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public static void main(String[] args) {
		new ComponentExam();
	}
}
