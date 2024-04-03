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

<!-- create user vote identified by tiger -->
  
 <!-- Begin Page Content -->
     <div class="container">

         <!-- Page Heading -->
         <h1 class="h3 mb-2 text-gray-800">투표검수조회</h1>

         <!-- DataTales Example -->
         <div class="card shadow mb-4 text-center">
             <div class="card-header py-3">
                 <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
             </div>
             <div class="card-body">
                 <div class="table-responsive">
                     <table class="table table-bordered " id="dataTable" width="100%" cellspacing="0">
                        <thead>
                             <tr>
                                 <th hidden>주민번호</th>
                                 <th>성명</th>
                                 <th>생년월일</th>
                                 <th>나이</th>
                                 <th>성별</th>
                                 <th>후보</th>
                                 <th>투표시간</th>
                                 <th>유권자확인</th>
                             </tr>
                        </thead>

						<tbody>
		                     <c:forEach var="vote" items="${vote}">
		                         <tr>
 		                            <td hidden>${vote.u_jumin}</td>
		                            <td>${vote.v_name}</td>
<%--  		                        <td>${vote.v_jumin}</td> --%>
 		                            <td>
	                                  <a href="${pageContext.request.contextPath}/vote/vote_view.do?v_jumin=${vote.u_jumin}" method="POST">${vote.v_jumin}</a>
		                            </td>
  		                            <td>${vote.v_age}</td>
		                            <td>${vote.v_sex}</td>
		                            <td>${vote.m_no}</td>
		                            <td>${vote.v_time}</td>
		                            <td>${vote.v_confirm}</td>
		                         </tr>
		                      </c:forEach>
						</tbody>

                     </table>
                 </div>
             </div>

			<div class="d-flex justify-content-center">
			</div>

       </div>
     </div>
     <!-- /.container-fluid -->  
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


<!-- http://49.247.158.208:9999/hjs -->

<!--
 <script type="text/javascript">
  function now(){
  var today=new Date();
  var time=today.getHours();
  var minutes = today.getMinutes();
  var seconds = today.getSeconds();

  var item = document.getElementById('time');
  item.innerText = time+":"+ minutes+":"+ seconds;
}
setInterval(now,1000);
</script>
<style>
  #time{
    font-family:'DS-Digital',sarif;
    height:2.3em;
    float: right;
    font-weight: bold;
    font-size:1.5em;
    margin-left:1.5em;      
  }
  #foot{
     margin-left:45%;
  }

</style>



<footer>
  <hr>
  <div id="foot">
    <span>© Company 2022-2024</span>
    <span id="time"></span>
  </div>
</footer>
-->