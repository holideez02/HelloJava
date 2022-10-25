<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<% 
		String id = (String) session.getAttribute("id"); //로그인이 되어있으면 세션에다가 id라는 이름의 id값을 가져오기로 했었음. login java에서!
		String auth = (String) session.getAttribute("auth"); //auth를 읽어와서
	%>	
	<% if(id != null) {%>
		<p> 아이디: <%=id %></p>
	<%} else {%>
		<p> 손님</p>
	<%} %>
	
	<h2>Member 첫페이지.</h2> <!-- 이 화면이 뜨는것.. -->
	<% if(auth.equals("admin")) {%>
	<a href="./memberAddForm.do">회원정보 생성페이지.</a><br> <!-- .do로 끝나니까 frontcontroller로 -->
	<%} %>
	<a href="./memberModifyForm.do">회원정보 수정페이지.</a><br> <!-- form 은 사용자에게 이런 화면을 보여준다는 의미로 쓰는것. 처리가 아니고 화면띄우기 !! -->
	<a href="./memberRemoveForm.do">회원정보 삭제페이지.</a><br>
	<a href="./memberSearchForm.do">회원정보 상세페이지.</a><br>
	<a href="./memberList.do">회원목록보기페이지.</a><br>
	
	<% if(id== null){ %> <!-- session에 id값이 없다면 로그인 화면 -->
		<a href="./loginForm.do">로그인화면</a><br>
	<% } else { %> <!-- session에 id값이 있다면 로그아웃 화면, 다시 로그인할 수 있도록. -->
		<a href="./loginOut.do">로그아웃</a><br>
	<%} %>
	
</body>
</html>