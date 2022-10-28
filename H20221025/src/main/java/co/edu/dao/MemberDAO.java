package co.edu.dao;

import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.sound.midi.VoiceStatus;

import co.edu.board.MemberVO;
import co.edu.common.DAO;

public class MemberDAO extends DAO{
	public MemberVO memberInsert(MemberVO vo) { //생성
		conn = getConnect();
		
		String sql ="insert into members (id, passwd, name, email, responsibility) "
				+ "values(?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPasswd());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			psmt.setString(5, vo.getResponsibility());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력.");
			
			if (r > 0) {
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public MemberVO login(String id, String passwd) { //로그인
		getConnect();
		String sql = "select * from members where id=? and passwd=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, passwd);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setResponsibility(rs.getString("responsibility"));
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public MemberVO getPassWd(String id) {
		conn = getConnect();
		String sql = "select * from members where id =?";

		MemberVO vo = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO(rs.getString("id"), rs.getString("passwd"), rs.getString("name"),
						rs.getString("email"),"user1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
	
	public String sendMail(String from, String to, String subject, String content) {
		String _email = "holideez02@gmail.com"; //내 이메일
		String _password = "bzditzoatmieapdn"; //내 비밀번호

		System.out.println(" 전송중입니다..");

//		String subject = "Hello JavaMail API Test";
		String fromMail = from;// "cholee@yedam.ac";
		String fromName = "관리자";
		String toMail = to;// "leadon@naver.com"; // 콤마(,) 나열 가능

		// mail contents
		StringBuffer contents = new StringBuffer();
		contents.append("<h1>Hello</h1>\n");
		contents.append("<p>Nice to meet you ~! :)</p><br>");

		// mail properties
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // use Gmail
		props.put("mail.smtp.port", "587"); // set port

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); // use TLS
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() { // set authenticator
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(_email, _password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(mailSession);

			message.setFrom(new InternetAddress(fromMail, MimeUtility.encodeText(fromName, "UTF-8", "B"))); // 한글의 경우
																											// encoding
																											// 필요
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toMail));
			message.setSubject(subject);
			message.setContent(content, "text/html;charset=UTF-8"); // 내용 설정 (HTML 형식)
			message.setSentDate(new java.util.Date());

			Transport t = mailSession.getTransport("smtp");
			t.connect(_email, _password);
			t.sendMessage(message, message.getAllRecipients());
			t.close();

			System.out.printf("전송완료.");
			return "Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "Fail";
		}
		
	}
	
	public MemberVO update(MemberVO mvo) { //비밀번호 수정
		String sql = "update members "
				+ "set passwd=? "
				+ "where id=? ";
		conn = getConnect();
		MemberVO vo = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mvo.getPasswd());
			psmt.setString(2, mvo.getId());
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경되었습니다.");
			vo = new MemberVO(rs.getString("id"), rs.getString("passwd"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return vo;
	}
}
