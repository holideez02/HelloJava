<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- jsp->자바파일로 바뀔때 만들어지는 내장객체 -->
	<% String paging = (String) request.getParameter("page");
	   session.getAttribute("id");
	   System.out.println(paging);
	   application.setAttribute("info", "hong"); //app이 실행되면 만들어짐.
	   session.setAttribute("mysession", "1234");
	   session.setAttribute("yoursession", "5678");
	 %>
	 
</body>
</html>