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
         <h1 class="h3 mb-2 text-gray-800">후보조회</h1>

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
                                 <th>후보번호</th>
                                 <th>성명</th>
                                 <th>소속정당</th>
                                 <th>학력</th>
                                 <th>주민번호</th>
                                 <th>지역구</th>
                                 <th>대표전화</th>
                                 <th>삭제</th>
                             </tr>
                        </thead>

						<tbody>
		                     <c:forEach var="member" items="${member}">
		                         <tr>
		                            <td>${member.m_no}</td>
<%-- 		                            <td>${member.m_name}</td> --%>
		                            <td>
	                                  <a href="${pageContext.request.contextPath}/member/member_view.do?m_no=${member.m_no}" method="POST">${member.m_name}</a>
		                            </td>
 		                            <td>${member.p_name}</td>
		                            <td>${member.t_school}</td>
		                            <td>${member.m_jumin}</td>
		                            <td>${member.m_city}</td>
		                            <td>${member.p_tel}</td>
		                            <td>
		                            	<button class="btn btn-success"><a class="nav-link active" href="${pageContext.request.contextPath}/member/member_delete.do?m_no=${member.m_no}" method="POST">삭제</a></button>
		                            </td>
		                         </tr>
		                      </c:forEach>
						</tbody>

                     </table>
                 </div>
             </div>

<!--
      <select name="protocol">
         <option value="http">http</option>
         <option value="ftp" selected="selected">ftp</option>
         <option value="smtp">smtp</option>
         <option value="pop">pop</option>
      </select><br/>
 -->
			  <!-- <div class="card-footer"> -->
               	<%-- <button class="btn btn-primary"><a class="nav-link active" href="${pageContext.request.contextPath}/board/write_view.do">글쓰기</a></button> --%>
			  <div class="d-flex justify-content-center">

<!--popup  -->
            <button type="button" class="btn btn-primary mb-3" data-bs-toggle="modal" data-bs-target="#exampleModal">후보등록</button>
            <!-- 모달 스타트 -->
            <div class="modal fade" ref="writeModal" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog modal-sl modal-dialog-centered">
                <div class="modal-content">

                <form action="${pageContext.request.contextPath}/member/member_write.do" method="POST">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">후보등록</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button><br />
                  </div>
                  <div class="modal-body">
                    <div class="row mb-3 d-flex form-control">
                      <label for="recipient-name" class="col-sm-3 col-form-label">후보번호</label>
					  <div class="col-sm-6">
						<input type="text" class="form-control" id="m_no" name="m_no" />
                      </div>
                    </div>

                    <div class="row mb-3 d-flex form-control">
                      <label for="recipient-name" class="col-sm-3 col-form-label">성명</label>
					  <div class="col-sm-6">
						<input type="text" class="form-control" id="m_name" name="m_name" />
                      </div>
                    </div>
                    <div class="row mb-3 d-flex form-control">
                      <label for="recipient-name" class="col-sm-3 col-form-label">소속정당</label>
					  <div class="col-sm-6">
					    <select class="form-select" name="p_code" aria-label="Default select example">
					      <option selected>소속정당</option>
	                      <c:forEach var="party" items="${party}">
						   	<option value="${party.p_code}">${party.p_code}. ${party.p_name}</option>
		                  </c:forEach>
					    </select>
                      </div>
                    </div>
                    <div class="row mb-3 d-flex form-control">
                      <label for="recipient-name" class="col-sm-3 col-form-label">최종학력</label>
					  <div class="col-sm-6">
					      <select class="form-select" name="p_school" aria-label="Default select example">
					        <option selected>학력선택</option>
	                        <c:forEach var="school" items="${school}">
						      	<option value="${school.p_school}">${school.p_school}. ${school.t_school}</option>
		                    </c:forEach>
					      </select>
                      </div>
                    </div>
                    <div class="row mb-3 d-flex form-control">
                      <label for="recipient-name" class="col-sm-3 col-form-label">주민번호</label>
					  <div class="col-sm-6">
                        <input type="text" class="form-control" id="m_jumin" name="m_jumin" maxlength="13" />
                      </div>
                    </div>
                    <div class="row mb-3 d-flex form-control">
                      <label for="recipient-name" class="col-sm-3 col-form-label">지역구</label>
					  <div class="col-sm-6">
                        <input type="text" class="form-control" id="m_city" name="m_city" />
                      </div>
                    </div>
                  </div>

<!--              <div class="modal-footer"> -->
	              <div class="modal-footer mt-3 d-flex justify-content-center">
	                <button class="btn btn-success" type="submit">Add</button>
	                <button class="btn btn-danger"><a class="nav-link active" href="${pageContext.request.contextPath}/member/member_list.do">Cancel</a></button>
                  </div>
                </form>

                </div>
              </div>
            </div>
            <!-- 모달 엔드 -->

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