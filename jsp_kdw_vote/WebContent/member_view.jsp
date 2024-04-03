<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>투표</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script> 
</head>

<body class="d-flex flex-column justify-content-between vh-100">
  <header>
  	<div class="text-center bg-secondary m-0 py-3">
  		<h3>(과정평가형 정보처리산업기사) 지역구의원투표 프로그램 ver 2024-03</h3>
  	</div>
  	
    <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">투표</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/member/member_list.do">후보조회</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="${pageContext.request.contextPath}/vote/vote_regist.do">투표하기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="${pageContext.request.contextPath}/vote/vote_list.do">투표검수조회</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="${pageContext.request.contextPath}/vote/candi_rank.do">후보자등수</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="${pageContext.request.contextPath}/vote/home.do">홈으로</a>
            </li>
          </ul>
          <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
  </header>

  <main>
 	<div class="container mt-3">
      <div class="container">
        <h3 class="text-center mb-3">후보수정</h3>
        <div class="row">
          <div class="card col-md-6 offset-md-3 offset-md-3">
<!--        <h3 class="text-center mt-5">업데이트도 할수 있어요</h3> -->
            <div class="card-body">
<!-- 
              <div class="form-group mb-3">
                <label> Type </label>
                <select placeholder="type" class="form-control">
                  <option value="1">후보수정</option>
                </select>
              </div>
 -->
              <form action="${pageContext.request.contextPath}/member/member_modify.do" method="POST">
				  <div class="row mb-3 d-flex form-control">
				    <label for="inputName" class="col-sm-2 col-form-label">후보번호</label>
				    <div class="col-sm-6">
	                  <input type="text" placeholder="m_no" name="m_no" class="form-control" value="${view.m_no}" readonly />
				    </div>
				  </div>
				  <div class="row mb-3 d-flex form-control">
				    <label for="inputName" class="col-sm-2 col-form-label">성명</label>
				    <div class="col-sm-6">
	                  <input type="text" placeholder="m_name" name="m_name" class="form-control" value="${view.m_name}" />
				    </div>
				  </div>
				  <div class="row mb-3 d-flex form-control">
				    <label for="inputName" class="col-sm-2 col-form-label">소속정당</label>
				    <div class="col-sm-6">
				      <select class="form-select" name="p_code" aria-label="Default select example">
				        <c:forEach var="party" items="${party}">
							<c:set var="chk" value=""></c:set>
							<c:if test="${party.p_code == view.p_code}">
								<c:set var="chk" value="selected"></c:set>
							</c:if>
							<option ${chk} value="${party.p_code}">${party.p_code}. ${party.p_name}</option>			
				        </c:forEach>
				      </select>
				    </div>
				  </div>
                  <div class="row mb-3 d-flex form-control">
                     <label for="inputName" class="col-sm-2 col-form-label">최종학력</label>
				  	 <div class="col-sm-6">
				      <select class="form-select" name="p_school" aria-label="Default select example">
				        <c:forEach var="school" items="${school}">
							<c:set var="chk" value=""></c:set>
							<c:if test="${school.p_school == view.p_school}">
								<c:set var="chk" value="selected"></c:set>
							</c:if>
							<option ${chk} value="${school.p_school}">${school.p_school}. ${school.t_school}</option>			
				        </c:forEach>
				      </select>
                     </div>
                  </div>
				  <div class="row mb-3 d-flex form-control">
				    <label for="inputName" class="col-sm-2 col-form-label">주민번호</label>
				    <div class="col-sm-6">
	                  <input type="text" placeholder="m_jumin" name="m_jumin" class="form-control" value="${view.m_jumin}" maxlength="13" />
				    </div>
				  </div>
				  <div class="row mb-3 d-flex form-control">
				    <label for="inputName" class="col-sm-2 col-form-label">지역구</label>
				    <div class="col-sm-6">
	                  <input type="text" placeholder="m_city" name="m_city" class="form-control" value="${view.m_city}" />
				    </div>
				  </div>
	              <div class="mt-3 d-flex justify-content-center">
	                <button class="btn btn-success me-md-2" type="submit">Update</button>
	                <button class="btn btn-danger"><a class="nav-link active" href="${pageContext.request.contextPath}/member/member_list.do">Cancel</a></button>
	               </div>
               </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>

  <!-- <footer class="text-center"> -->
  <footer class="text-center d-flex justify-content-between border-top">
  	<div style="width:25%"></div>
    <hr>
    <p class="m-auto">HRDKOREA Copyright©2024 All rights reserved. Human Resources Development Service of Korea</p>
	<div id="clock" class="btn ms-auto" ></div>
	<script>
		function clock(){
			let today = new Date();
			let hh = today.getHours();
			let mm = today.getMinutes();
			let ss = today.getSeconds();
			let clockElement = document.getElementById('clock');

			var editTime = hh + " : " + mm + " : " + ss;
			var viewTime = editTime.split(' : ').map(str => str.padStart(2, '0')).join(' : ');
			
			clockElement.innerHTML = viewTime;
		}
		setInterval(clock, 1000);
	</script>
  </footer>

</body>
</html>
