<%@page import="co.edu.board.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression Language(EL) JSP Standard Tag Library(JSTL)</title>
</head>
<body>
	<%
		String info = (String) application.getAttribute("info");
		System.out.println(info); //info에 담긴 attribute를 갖고와서
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = (List<BoardVO>) dao.pageList(1);
		
		request.setAttribute("bList", list);
	%>
	<p>${info }</p> <!-- jsp는 간단한 표현식을 제공. Attribute를 읽어옴. 반복문이나 복잡한거는 불가능-->
	<p>${"Hongkildong" eq "Hong" }</p> <!-- eq는 equals를 의미. 같으면 true -->
	<p>${55+22 }</p>
	<p>${info }</p>
	<p>${param.page }</p> <!--http://localhost/H20221025/test2.jsp?page=555를 입력하면 555출력  -->
	<p>app: ${sessionScope.hissession eq null}</p> <!-- 내장객체가 출력됨.his어쩌고는 없으니까 null-true! -->

	<c:set var="myName" value="홍길동"></c:set> <!-- 변수선언할때. myName라는 속성값에 홍길동을 담음.-->
	<p>${myName }</p> <!-- 변수의 값 가져옴 -->
	<c:out value="${myName }"></c:out> <!-- 변수의 값 가져옴 -->
	
	<c:if test="${info eq 'hong' }"> <!-- 조건문 사용 -->
		<p>같습니다</p>
	</c:if> 
	
	<c:if test="${!info2 }"> <!-- info가 null인지? -->
		<p>값이 없습니다</p>
	</c:if>
	
	<c:set var="score" value="75"></c:set>
	
	<c:choose> 
		<c:when test="${score > 90 }"><p>A학점</p></c:when> 
		<c:when test="${score > 80 }"><p>B학점</p></c:when> 
		<c:when test="${score > 70 }"><p>C학점</p></c:when> 
		<c:otherwise><p>불합격</p></c:otherwise> 
	</c:choose>
	
	<c:forEach var="i" begin="1" end="10" step="1">
		<p>${i }</p>
	</c:forEach>
	
	<c:forEach var="board" items="${bList }">
		<p>글번호: ${board.boardNo }, 제목: ${board.title }, 작성자: ${board.writer }</p>
	</c:forEach>
</body>
</html>