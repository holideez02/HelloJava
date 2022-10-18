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

public class SmsScreen extends JFrame{

	Dimension lbl1 = new Dimension(65, 15);
	Dimension lbl2 = new Dimension(40, 15);
	
	JPanel center, bottom;
	JLabel fromLbl, toLbl, contentLbl;
	JTextField fromTxt, toTxt;
	JTextArea contentTxt;
	JButton send, cancel;
	
	SmsApp app = new SmsApp();
	
	public SmsScreen() {
		setTitle("문자 보내기 UI");
		setSize(340, 300);
		setLayout(new BorderLayout());
		
		center = new JPanel();
		bottom = new JPanel();
		
		toLbl = new JLabel("수신번호");
		fromLbl = new JLabel("발신번호");
		contentLbl = new JLabel("내용: ");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);
		
		toTxt = new JTextField(22);
		fromTxt = new JTextField(22);
		contentTxt = new JTextArea(10, 25);
		
		send = new JButton("전송");
		send.addActionListener(new MyActionListener());
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());
		
		center.add(toLbl);
		center.add(toTxt);
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		bottom.add(send);
		bottom.add(cancel);
		
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			if(src == send) {
				System.out.println("보내기 버튼 실행");
				String to = toTxt.getText();
				String from = fromTxt.getText();
				String content = contentTxt.getText();
				
				if(app.sendSms(to, from, content).equals("Success")) {
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.DEFAULT_OPTION);
					toTxt.setText("");
					fromTxt.setText("");
					contentTxt.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "발송성공!!", "전송결과", JOptionPane.WARNING_MESSAGE);
				}
			} else if(src == cancel) {
				System.out.println("취소 버튼 실행");
			}
		}
		
	}
	public static void main(String[] args) {
		new SmsScreen();
	}
	
}
