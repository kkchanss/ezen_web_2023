<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<head>
		<link href="/frontendProject/css/index.css" rel="stylesheet">
	</head> <!-- 링크 확인 : ctrl + 클릭 -->
	
	<h3>헤더입니다.</h3>
	<ul class="head_menu"> <!-- 메뉴 -->
		<li> <a href="/frontendProject/index.jsp"> home </a> </li> <!-- a 태그 이용한 링크 (다른페이지 이동) -->
		<li> <a href="/frontendProject/kiosk/kiosk.jsp"> 키오스크 </a> </li> <!-- a 태그 이용한 링크 (다른페이지 이동) -->
		<li> <a href="/frontendProject/board/list.jsp"> 게시판 </a> </li> <!-- a 태그 이용한 링크 (다른페이지 이동) -->
		<li> <a href="/frontendProject/calender/calender.jsp"> 캘린더 </a> </li> <!-- a 태그 이용한 링크 (다른페이지 이동) -->
	</ul>
	
	<script src="/frontendProject/js/index.js" type="text/javascript"></script>
	<!-- 
		HTTP 상태 404 - 찾을 수 없음
			- 페이지 못 찾았다 [ 1. 경로문제 2. 오타 3. 존재하지 않는 경로 ]
			
		절대경로
			로컬 기준 [ C:\Users\504\eclipse-workspace\frontendProject\src\main\webapp\header.jsp ]
			서버 기준 [ http://localhost:8080/frontendProject/index.jsp]
			서버 기준 [ http://192.168.17.80:8080/frontendProject/index.jsp]
				http://ip주소:port번호
					- ip주소 : 컴퓨터 네트워크 식별번호 [ 집주소 ]
					- port번호 : 컴퓨터 내 프로그램 식별번호 [ 8080 : HTTP 식별 ] [ 방번호 ]
				- /프로젝트명/(src->main->webapp생략) 폴더명 / 파일명
		상대경로 ( 헤더는 모든페이지 ( 경로 일정x ) 동일하게 작동 )
			
			./ : 현재 폴더 ( 생략 가능 )
			../ : 상위 폴더 이동 
			현재 파일 기준 [ ]
	 -->