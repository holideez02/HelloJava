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
	
</body>
</html>