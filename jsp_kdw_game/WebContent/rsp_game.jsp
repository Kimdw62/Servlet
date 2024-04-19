<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <style>
    #game{
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      height: 100vh;
    }
  </style>
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
    <div class="container">
      <div class="row">
      	     <div class="col-md-4 d-flex justify-content-center py-1">
	          <div class="card" style="width: 18rem;"> 
	            <img src="${you.image}" class="card-img-top" alt="...">
	            <div class="card-body text-center">
	              <h5 class="card-title">당신</h5>
	              <form action="${pageContext.request.contextPath}/rsp/result.do" method="POST">
		              <button class="btn btn-primary m-2"  type="submit" name="rsp" value="가위">가위</button>
		              <button  class="btn btn-primary m-2" type="submit"  name="rsp" value="바위">바위</button>
		              <button  class="btn btn-primary m-2"  type="submit" name="rsp" value="보">보</button>
	              </form>
	            </div>
	          </div>

        </div>
        <div class="col-md-4  d-flex justify-content-center py-1">
          <div class="card" style="width: 18rem;">
            <img src="https://taegon.kim/wp-content/uploads/2018/05/image-5.png" class="card-img-top" alt="...">
            <div class="card-body text-center">
              <h5 class="mt-3 card-title">심판</h5>
              <h6 class="mt-4 text-danger">${computer.getResult(you)}</h6>
            </div>
          </div>
        </div>
        <div class="col-md-4 d-flex justify-content-center py-1">
          <div class="card" style="width: 18rem;">
            <img src="${computer.image}">
            <div class="card-body text-center">
              <h5 class="card-title">컴퓨터</h5>
              <button class="btn btn-primary m-2">${computer.getRsp()}</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
  <footer class="text-center">
    <hr>
    <p>© Company 2022-2023</p>
  </footer>
</body>
</html>