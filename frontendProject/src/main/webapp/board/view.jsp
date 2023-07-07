<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 뷰 포트 : 반응형 동작 코드 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- include bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" 
crossorigin="anonymous">

</head>
<body>
	<%@include file="../header.jsp" %>






	
	<div class="container"> <!-- 부트스트랩 구역 -->
		<h4 class="title text-center mt-5 mb-2"> 게시물 제목 출력 구역</h4>
		<p class="writerdate text-center"> 작성자와 작성일 출력되는 구역 </p>
		<div class="row justify-content-md-center"> 
			<div class="content col-8" style="min-height: 500px;">게시물 내용이 출력되는 구역</div>
		</div>
	</div>
	
	<div class="row justify-content-md-center">
		<div class="col-1">
			<input onclick="onWrite()" class="form-control btn btn-dark" type="button" value="삭제하기">
		</div>
		<div class="col-1">
			<input class="form-control" type="button" value="수정하기">
		</div>
		<div class="col-1">
			<input class="form-control" type="button" value="목록보기">
		</div>
	</div>	










	
	<%@include file="../footer.jsp" %>
	
	<!-- 부스트트랩에서 만든 js 적용 -->
 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>   
   
  	<!-- jquery : js 최신 라이브러리  -->
   	<script src="https://code.jquery.com/jquery-latest.min.js">   </script>
   	<script src="../js/view.js" type="text/javascript"></script>
</body>
</html>