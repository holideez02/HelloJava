<%@page import="co.test.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>

	<h3>${error }</h3>

    <h3>도서삭제조회</h3>
    <form action="./searchBook.do" method="get">
        <input type="text" name="bookCode"><br>
        <input type="hidden" name="job" value="remove">
        <input type="submit" value="조회">
    </form>

    <!-- 도서삭제를 위한 화면 작성코드를 입력하세요. -->
    <h3>도서삭제</h3>
    <%
		BookVO result = (BookVO) request.getAttribute("bookInfo");
		String bookCode = (String) session.getAttribute("bookCode");
	%>
	<% if(result != null){ %>
    <form action="./removeBook.do" method="post">
    삭제할 도서코드: <input type="text" name="bookCode" value="<%=result.getBookCode() %>" ><br> 
    <input type="submit" value="삭제">
    </form>
    <%} else{ %>
  	<p>조회 결과가 없습니다.</p>
  	<%} %>

    <a href="main.do">첫페이지</a>

</body>

</html>