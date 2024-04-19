<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>게임</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script> 
</head>

<body class="d-flex flex-column justify-content-between vh-100">
  <header >
    <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">게임사이트</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/lotto/list.do">로또</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="${pageContext.request.contextPath}/rsp/result.do">가위바위보</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="${pageContext.request.contextPath}/board/list.do">게시판</a>
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="${pageContext.request.contextPath}/gugudan/list.do">구구단</a>
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
  
 <!-- Begin Page Content -->
     <div class="container">

         <!-- Page Heading -->
         <h1 class="h3 mb-2 text-gray-800">Tables</h1>
         <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
             For more information about DataTables, please visit the <a target="_blank"
                 href="https://datatables.net">official DataTables documentation</a>.</p>

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
                                 <th>번호</th>
                                 <th>이름</th>
                                 <th>제목</th>
                                 <th>날짜</th>
                                 <th>히트</th>
                                 <th>삭제</th>
                             </tr>
                        </thead>

						<tbody>
		                     <c:forEach var="board" items="${boards}">
		                         <tr>
		                            <td>${board.bid}</td>
		                            <td>${board.bname}</td>
		                            <td>
	                                  <c:forEach begin="1" end="${board.bindent}">[Re]</c:forEach>
	                                  <a href="${pageContext.request.contextPath}/board/content_view.do?bid=${board.bid}" method="POST">${board.btitle}</a>
		                            </td>            
		                            <td>${board.bdate}</td>
		                            <td>${board.bhit}</td>
		                            <td>
		                            	<button class="btn btn-success"><a class="nav-link active" href="${pageContext.request.contextPath}/board/delete.do?bid=${board.bid}" method="POST">삭제</a></button>
		                            </td>

		                         </tr>
		                      </c:forEach>
						</tbody>

                     </table>
                 </div>
             </div>

			  <!-- <div class="card-footer"> -->
<%-- 				<button class="btn btn-primary"><a class="nav-link active" href="${pageContext.request.contextPath}/board/write_view.do">글쓰기</a></button> --%>
			  <div class="d-flex justify-content-center">

<!--popup  -->
            <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">글쓰기</button>
            <!-- 모달 스타트 -->
            <div class="modal fade" ref="writeModal" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog modal-sl modal-dialog-centered">
                <div class="modal-content">

                <form action="${pageContext.request.contextPath}/board/write.do" method="POST">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">글쓰기</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button><br />
                  </div>
                  <div class="modal-body">
                    <div class="mb-3">
                      <label for="recipient-name" class="col-form-label">작성자:</label>
                       <input type="text" class="form-control" name="bname" />
                    </div>
                    <div class="mb-3">
                      <label for="recipient-name" class="col-form-label">제목:</label>
                      <input type="text" class="form-control" name="btitle" />
                    </div>
                    <div class="mb-3">
                      <label for="message-text" class="col-form-label">내용:</label>
                      <textarea class="form-control" rows="8" name="bcontent"></textarea>
                    </div>
                  </div>
                  <div class="modal-footer">
<!--                <button type="button" class="btn btn-primary" data-bs-dismiss="modal" @click="writeBoard">전송</button> -->
<!--                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">취소</button> -->
	                <button class="btn btn-success" type="submit">Add</button>
	                <button class="btn btn-danger"><a class="nav-link active" href="${pageContext.request.contextPath}/board/list.do">Cancel</a></button>
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
    <p class="m-auto">© Company 2022-2023</p>
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