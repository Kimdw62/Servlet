<%@page import="com.seoung.ex.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
<h1>메인 페이지</h1>
<%
	MemberDto member = (MemberDto)session.getAttribute("member");
%>

<h1><%=member.getId() %>님 안녕하세요.</h1>

<a href="login.jsp" >로그인 페이지로 이동</a>

<form action="logout.jsp" method="post">
	<input type="button" value="회원수정" onclick="javascript:window.location='modify.jsp'">
	<input type="button" value="회원탈퇴" onclick="javascript:window.location='leave.jsp'">
	<input type="submit" value="로그아웃">
</form>


</body>
</html>
