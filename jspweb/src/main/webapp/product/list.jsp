<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/product/list.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>

	<div class="mapcontent">
		<!-- 지도를 표시할 div 입니다 -->
		<div id="map"></div>
	</div>
   
   
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d55986e78fa9e3909689ada90eb437d&libraries=clusterer"></script>
   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d55986e78fa9e3909689ada90eb437d"></script>
   <script src="../js/product/list.js" type="text/javascript"></script>
</body>
</html>

<!-- 1d55986e78fa9e3909689ada90eb437d -->