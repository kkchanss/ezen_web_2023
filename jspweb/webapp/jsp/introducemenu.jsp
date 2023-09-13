<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IntroduceMenu</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/footer.css" rel="stylesheet">
<link href="../css/introducemenu.css" rel="stylesheet">
</head>
<body>

	<%@include file = "header.jsp" %>
	<div class="intro_wrap">
		<div class="intro_top">
			<div class="midUl_div">
				<ul class="midUl">
					<li class="">샌드위치</li>
					<li class="">랩</li>
					<li class="">샐러드</li>
				</ul>
			</div>
			
			<div class="intro_top_content">
				<h1>Sandwich</h1>
				<p>전세계 넘버원 브랜드 Subway! <br>
				50년 전통의 세계 최고의 샌드위치를 맛보세요!</p>
			</div>
			
			<div class="menuUl_div">
				<ul class="menuUl">
					<li class="s_all">All</li>
					<li class="s_classic">클래식</li>
					<li class="s_premium">프리미엄</li>
				</ul>
			</div>
		</div>
		
		<div class="intro_bottom">
			<div class="product">
				<img src="/subway/img/BBQ.png">
				<h3>쉬림프 샌드위치</h3>
				<p>test</p>
				<p>★☆ 1.5/5</p>
			</div>
			<div class="product">
				<img src="/subway/img/BBQ.png">
				<h3>쉬림프 샌드위치</h3>
				<p>test</p>
				<p>★★★ 3/5</p>
			</div>
			<div class="product">
				<img src="/subway/img/BBQ.png">
				<h3>쉬림프</h3>
				<p>Shrimp</p>
				<p>★★★★ 4/5</p>
			</div>
		</div>
	</div>
	
		
	<%@include file = "footer.jsp" %>

	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../js/introducemenu.js" type="text/javascript"></script>
</body>
</html>