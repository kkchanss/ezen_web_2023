<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 뷰 포트 : 반응형 동작 코드 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- include bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" 
crossorigin="anonymous">
<!-- include summernote css/js -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-bs5.min.css" integrity="sha512-ngQ4IGzHQ3s/Hh8kMyG4FC74wzitukRMIcTOoKT3EyzFZCILOPF0twiXOQn75eDINUfKBYmzYn2AA8DkAk8veQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />

	<!-- 
		썸머노트[부트스트랩/JQUERY 라이브러리 기반으로 생성된 에디터]
			1. 설치
				1. <link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">
				2. <script src="http://code.jquery.com/jquery-latest.min.js"></script>
				3. <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
				4. <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>
			2. div 또는 textarea
				1. <div id = "summernote"> </div>
				2. <textarea id="summernote" class="form-control m-3" rows="10"> </textarea>
			3. JS에서 실행
				 $(document).ready(function() {
       				 $('#summernote').summernote();
      			});
	 -->
<title>Insert title here</title>
</head>
<body>

	<%@include file="../header.jsp" %>
	<div class="container">
		<input  class="form-control m-3 title" type="text" placeholder="제목">
		<textarea id="summernote" class="form-control m-3" rows="10" cols="5" placeholder="내용"></textarea>
		<input  class="form-control m-3" type="file"/>
		
		<div class="row justify-content-md-center">
			<div class="col-2">
				<input onclick="onUpdate()" class="form-control btn btn-dark" type="button" value="등록">
			</div>
			<div class="col-2">
				<input class="form-control" type="button" value="다시쓰기">
			</div>
			<div class="col-2">
				<a href="list.jsp"><input class="form-control" type="button" value="목록보기"></a>
			</div>
		</div>
	</div>
	
	<%@include file="../footer.jsp" %>
	
	
	<!-- 부스트트랩에서 만든 js 적용 -->
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>   
   
   <!-- jquery : js 최신 라이브러리  -->
   <script src="https://code.jquery.com/jquery-latest.min.js">   </script>
   
   <!-- 썸머노트 js 적용 -->
   <script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-bs5.min.js"></script>   
   
   <!-- 썸머노트 한글 적용 -->
   <script src=" https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.18/lang/summernote-ko-KR.min.js"></script>
   
   
   
   <script src="../js/update.js" type="text/javascript"></script>
</body>
</html>