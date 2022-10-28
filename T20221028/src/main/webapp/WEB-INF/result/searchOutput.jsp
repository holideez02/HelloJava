<%@page import="co.test.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BookVO result = (BookVO) request.getAttribute("bookInfo");
	%>
	<h3>조회결과페이지</h3>

		<p>도서코드: <%=result.getBookCode() %> </p>
		<p>제목: <%=result.getBookTitle() %></p>
		<p>저자: <%=result.getBookAuthor() %></p>
		<p>출판사: <%=result.getBookPress() %></p>
		<p>가격:<%=result.getBookPrice() %></p>

    <a href="main.do">첫페이지</a>

</body>
</html>