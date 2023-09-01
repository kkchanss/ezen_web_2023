<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="webcontainer">
		<h3>글 쓰기 페이지</h3>
		<a href="list.jsp">목록보기</a>
		
		<form>
			제목 : <input type="text">
		</form>
		
		<button onclick="onWrite()" type="button">글쓰기</button>
	</div>
	
	<%@include file="../footer.jsp" %>	
</body>
</html>