<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
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
  <header>
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
 	<div class="container mt-3">
      <div class="container">
        <div class="row">
          <div class="card col-md-6 offset-md-3 offset-md-3">
            <h3 class="text-center mt-5">${board.bid}번 댓글 쓰기</h3>
            <div class="card-body">
              <div class="form-group mb-3">
                <label> Type </label>
                <select placeholder="type" class="form-control">
                  <option value="1">자유게시판</option>
                </select>
              </div>
              <form action="${pageContext.request.contextPath}/board/reply.do" method="POST">
					<input type="hidden" name="bid" value="${board.bid}">
					<input type="hidden" name="bgroup" value="${board.bgroup}">
					<input type="hidden" name="bstep" value="${board.bstep}">
					<input type="hidden" name="bindent" value="${board.bindent}">
	              <div class="form-group mb-3">
	                <label> Board ID </label>
	                <input type="text" placeholder="bid" name="bid" class="form-control" value="${board.bid}" readonly />
	              </div>

	              <div class="form-group mb-3">
	                <label> 히트(조회수) </label>
	                <input type="text" placeholder="bid" name="bid" class="form-control" value="${board.bhit}" readonly />
	              </div>
	              <div class="form-group mb-3">
	                <label> 이름 </label>
	                <input type="text" placeholder="bname" name="bname" class="form-control" value="${board.bname}" />
	              </div>
	              <div class="form-group mb-3">
	                <label> 제목 </label>
	                <input placeholder="btitle" name="btitle" class="form-control" value="${board.btitle}" />
	              </div>
	              <div class="form-group">
	                <label> 내용 </label>
	                <textarea placeholder="bcontent" name="bcontent" class="form-control" rows="5">${board.bcontent}</textarea>
	              </div>
	              <div class="mt-3 d-flex justify-content-between">
	                <button class="btn btn-success" type="submit">저장</button>
	                <button class="btn btn-danger"><a class="nav-link active" href="${pageContext.request.contextPath}/board/list.do">Cancel</a></button>
	               </div>
               </form>
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
