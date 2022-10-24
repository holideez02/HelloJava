<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.getRequestDispatcher("main.do").forward(request, response);
	//main.do를 요청... .do로 끝나는건 frontcontroller에서 처리하기.
%>