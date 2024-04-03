<%@page import="com.seoung.ex.dto.MemberDto"%>
<%@page import="com.seoung.ex.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>leave_ok.jsp</title>
</head>
<body>
<h1>회원 탈퇴 페이지</h1>
<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	MemberDto member = new MemberDto(id, pw, email, address);
	MemberDao dao = new MemberDao();

	int result = dao.leaveMember(member);
	
	System.out.println("탈퇴 OK ...");
	
	if(result == 0){
		response.sendRedirect("modify.jsp");
	}else if(result >= 0) {
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
%>

</body>
</html>
