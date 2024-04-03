<%@page import="com.seoung.ex.dto.MemberDto"%>
<%@page import="com.seoung.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modify.jsp</title>
</head>
<body>
<h1>회원 정보 수정 페이지</h1>
	<form action="modify_ok.jsp" method="post">
		아이디 : <input type="text" name="id" size="20" value="${sessionScope.member.id}" readonly><br>
		패스워드 : <input type="password" name="pw" size="20" value="${sessionScope.member.pw}"><br>		
		이메일 : <input type="text" name="email" size="20" value="${sessionScope.member.email}"><br>
		주소 : <input type="text" name="address" size="40" value="${sessionScope.member.address}"><br>
		<br>
		<input type="submit" value="저장">
		<input type="reset" value="초기화">
	</form>
</body>
</html>
