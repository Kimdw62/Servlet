<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>join.jsp</title>
</head>
<body>
<h1>회원가입 페이지</h1>
	<form action="join_ok.jsp" method="post">
		아이디 : <input type="text" name="id" size="20"><br>
		패스워드 : <input type="password" name="pw" size="20"><br>		
		이메일 : <input type="text" name="email" size="20"><br>
		주소 : <input type="text" name="address" size="40"><br>
		<br>
		<input type="submit" value="저장">
		<input type="reset" value="초기화">
	</form>
</body>
</html>
