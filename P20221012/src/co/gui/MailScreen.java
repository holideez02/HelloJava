package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//메일 발송화면
public class MailScreen extends JFrame {

	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(40, 15);

	JPanel center, bottom; // 컴포넌트를 모아두기 위한 컨테이너
	JLabel fromLbl, toLbl, subjectLbl, contentLbl; // 레이블.
	JTextField fromTxt, toTxt, subjectTxt; // 입력을 위한 텍스트 필드
	JTextArea contentTxt;
	JButton send, cancel;

	MailApp app = new MailApp();

	public MailScreen() {
		setTitle("메일 보내기 UI");
		setSize(340, 300);
		setLayout(new BorderLayout()); // 배치관리자 선언
		// panel
		center = new JPanel();
		bottom = new JPanel();

		// label 세팅
		toLbl = new JLabel("받는 사람"); // 받는사람 주소
		fromLbl = new JLabel("보내는 사람");
		subjectLbl = new JLabel("제목: ");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		subjectLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);

		// textField
		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		subjectTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);

		// button
		send = new JButton("보내기");
		send.addActionListener(new MyActionListener()); // 매개값으로 들어가는 ActionLister 인터페이스. 구현하는 객체도 만들어야!
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());

		// 컨테이너에 컴포넌트를 부착!!
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(subjectLbl);
		center.add(subjectTxt);
		center.add(contentLbl);
		center.add(contentTxt);

		// 윈도우에 컨테이너를 배치한 것
		bottom.add(send);
		bottom.add(cancel);

		add("Center", center);
		add("South", bottom);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x버튼 누르면 프로그램 종료
		setLocationRelativeTo(null); // 윈도우 중앙에 화면 띄울게요
	}

	// 기능을 실행하는 구현객체.
	class MyActionListener implements ActionListener {// addActionListener를 구현하는 ..

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource(); // 어떤 객체에 이벤트가 발생했는지 알려준다.
			if (src == send) {
				System.out.println("보내기 버튼 actionPerformed.");
				String from = fromTxt.getText(); // 텍스트 필드의 값을 읽어들임
				String to = toTxt.getText();
				String subject = subjectTxt.getText();
				String content = contentTxt.getText();

				if (app.sendMail(from, to, subject, content).equals("Success")) {
					// 콘솔에 성공 - > 값을 지워주도록.
//					System.out.println("성공!");
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
					fromTxt.setText("");
					toTxt.setText("");
					subjectTxt.setText("");
					contentTxt.setText("");
				} else {
					// 콘솔에 실패 ->
//					System.out.println("실패");
					JOptionPane.showMessageDialog(null, "발송실패!!", "전송결과", JOptionPane.WARNING_MESSAGE);
				}
			} else if (src == cancel) {
				System.out.println("취소 버튼 actionPerformed.");
			}
		}
	}

	// 화면시작
	public static void main(String[] args) {
		new MailScreen();
	}
}
