<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> calender </title>
		<link href="/frontendproject/CSS/calender.css" rel="stylesheet">
	</head>
<body>
	
	<!-- 다른 JSP 파일이 호출 가능함 -->
	<%@ include file="../header.jsp" %>
	
	<div class="calwrap"> <!-- 캘린더 전체 구역 -->
		<div class="caltop"> <!-- 캘린더 상단 -->
			<button onclick="onNext(0)" type="button"> ◀ </button> <!-- 이전달 버튼 -->
			<h3 class="caldate">  </h3> <!-- 현재/월 표시 구역 -->
			<button onclick="onNext(1)" type="button"> ▶ </button> <!-- 다음달 버튼 -->
		</div>
		<div class="calender"> <!-- 날짜 및 일정 표시구역 -->
			<!-- calPrint() 함수로 출력 -->
		</div>
	</div> <!-- 캘린더 전체 구역 end -->
	
	<div class="modalwrap"> <!-- 모달 전체 구역 -->
		<div class="modal"> <!-- 모달 상자 -->
			<h3> 일정 추가 </h3>
			<input class="color" type="color"/>
			<div class="date"></div>
			<textarea class="contentInput" rows="5" cols="10"></textarea>
			
			<div class="modalbtns">
				<button onclick="onWrite()" type="button"> 일정등록 </button>
				<button onclick="closeModal()" type="button"> 닫기 </button>
			</div>
		</div>
	</div>
	










	
	<!-- 다른 JSP 파일이 호출 가능함 -->
	<%@ include file="../footer.jsp" %>
	<script src="../JS/calender.js" type="text/javascript"></script>
</body>
</html>