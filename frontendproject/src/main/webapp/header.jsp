<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<!-- css 호출 -->
 	<head>
		<link href="/frontendproject/CSS/index.css" rel="stylesheet">
	</head>
	
	
	<h3>헤더입니다.</h3>
	<ul class="head_menu"> <!-- 헤더에 경로를 넣을때는 절대 경로에 넣어야한다. 이유는 모든 페이지의 경로가 같지 않기 때문에 상대 경로를 넣으면 오류뜸 -->
		<li> <a href="/frontendproject/index.jsp"> home </a></li>
		<li> <a href="/frontendproject/kiosk/kiosk.jsp"> 키오스크 </a></li>
		<li> <a href="/frontendproject/board/list.jsp"> 게시판 </a></li>
		<li> <a href="/frontendproject/calender/calender.jsp"> 캘린더 </a></li>
	</ul>
	
	<!-- 오류 : HTTP상태 404 - 찾을수 없음
			 ㄴ> 페이지를 못찾았다.
				1. 경로문제
				2. 오타
				3. 존재하지 않는 파일 등
	 -->
	 
	 
	 
	 
	 
	 
	 <script src="/frontendproject/JS/index.js" type="text/javascript"></script>