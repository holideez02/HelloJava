<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>로그인 화면</title>
</head>
<body>
<h3>로그인 화면</h3>
	<form action="./signIn.do" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="passwd"><br>
		<input type="submit" value="로그인">
	</form>
	
	<a href="passwdReConfirmForm.do"> 비밀번호 재전송</a>
	<!-- passwdReConfirm.jsp 생성 : 아이디 입력, 재전송 버튼 누르면 메일 주소로 변경된 비번이 전송되도록..
		 passwdReConfirm.do : 아이디를 받아서 이메일정보로 메일을 발송.
	-->
	
</body>
</html>