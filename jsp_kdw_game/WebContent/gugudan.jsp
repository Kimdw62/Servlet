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
         <h1 class="h3 mb-2 text-gray-800">구구단</h1>

         <!-- DataTales Example -->
         <div class="card shadow mb-4 text-center">
             <div class="card-header py-3">
                 <h4 class="m-0 font-weight-bold text-primary">Multiplication Table</h4>
             </div>
             <div class="card-body">
                 <div class="table-responsive">
                     <table class="table table-bordered " id="dataTable" width="100%" cellspacing="0">
                        <thead>
                          <tr>
                        	<c:forEach var="j" begin="1" end="9">
                               <th>${j}단</th>
                        	</c:forEach>
                          </tr>
                        </thead>

						<tbody>
							<c:forEach var="i" begin="1" end="9">
								<tr>
								<c:forEach var="j" begin="1" end="9">
									<td>${j} * ${i} = ${i*j}</td> 
								</c:forEach>
								</tr>
							</c:forEach>
						</tbody>

                     </table>
                 </div>
             </div>
			  <div class="card-footer">
               	<button class="btn btn-primary"><a class="nav-link active" href="${pageContext.request.contextPath}/board/list.do">게시판</a></button>
			  </div>
         </div>

     </div>
     <!-- /.container-fluid -->  
  
  </main>

  <footer class="text-center">
    <hr>
    <p>© Company 2022-2023</p>
  </footer>

</body>
</html>


<!-- http://49.247.158.208:9999/hjs -->
