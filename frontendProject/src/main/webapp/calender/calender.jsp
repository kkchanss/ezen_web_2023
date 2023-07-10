<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/calender.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>
	
	<div class="calwrap"> <!-- 캘린더 전체구역 -->
		
		<div class="caltop"> <!-- 상간 메뉴 -->
			<button onclick="onNext(0)" type="button"> < </button> <!-- 이전 달 버튼 -->
			<h3 class="caldate"> 2023년 07월 </h3><!-- 현재/월 표시 구역 -->
			<button onclick="onNext(1)" type="button"> > </button> <!-- 다음 달 버튼 -->
		</div>
		
		<div class="calender"> <!-- 날짜 표시 구역 -->
			<!-- 상단 요일 표기 일~토 -->
			<div class="week sunday"> 일 </div>			<div class="week"> 월 </div>
			<div class="week"> 화 </div>			<div class="week"> 수 </div>
			<div class="week"> 목 </div>			<div class="week"> 금 </div>
			<div class="week"> 토 </div>
			<!-- 일 표기 1 ~ 31/30/29 -->
			<div> 1 </div> <div> 2 </div> <div> 3 </div>
			<div> 4 </div> <div> 5 </div> <div> 6 </div>
			<div> 7 </div> <div> 8 </div> <div> 9 </div>
		</div>
	</div>
	<%@include file = "../footer.jsp" %>
	<script src="../js/calender.js" type="text/javascript"></script>
</body>
</html>