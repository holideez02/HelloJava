<%@page import="co.edu.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원상세정보</title>
</head>
<body>
	<%
		MemberVO result = (MemberVO) request.getAttribute("memberInfo"); //request는 선언하지 않아도 바로 사용.jsp페이지가 자바페이지로 바뀌는거기때문에 클래스파일에 있는것 
	%>
	
	<h3>회원 상세정보 보기</h3>
	<% if (result != null){ %>
		<p>회원 아이디: <%=result.getId() %> </p>
		<p>회원 이름: <%=result.getName() %></p>
		<p>회원 이메일:<%=result.getEmail() %></p>
	<% } else{ %>
		<p>조회된 정보가 없습니다 !!!</p>
	<% } %>
	
	<%@ include file="home.jsp" %> <!-- 페이지 내에 다른 페이지를 추가 -->
</body>
</html>