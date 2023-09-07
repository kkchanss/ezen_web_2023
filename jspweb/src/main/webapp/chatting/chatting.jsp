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
		<h2>채팅</h2>
		<div>
			<div class="contentbox"></div>
			<input class="inputcontent" type="text">
			<button class="sendbtn" onclick="msgsend()">전송</button>
		</div>
	</div>
	
	<%@include file="../footer.jsp" %>
	
	
	
	
	
	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="/jspweb/js/chatting/chatting.js" type="text/javascript"></script>
</body>
</html>