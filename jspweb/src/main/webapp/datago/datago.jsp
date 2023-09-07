<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   <%@include file = "../header.jsp" %>
   
   
   
   <div class="webcontainer">
      <h3> 공공데이터 </h3>
     
     	<div id="map" style="width:500px;height:400px;"></div>
      <div>
      	 <h6> 안산시 착한가격업소 현황 </h6>
	      <table class="apiTable1">
	      		<tr>
	      			<th>번호</th>
	      			<th>상호명</th>
	      			<th>주소</th>
	      			<th>연락처</th>
	      			<th>대표메뉴1</th>
	      			<th>대표메뉴2</th>
	      			<th>대표메뉴3</th>
	      		</tr>
	      </table>
      </div>
   </div>
   
   
   <!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1d55986e78fa9e3909689ada90eb437d"></script>
	   <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1ac4a57d8a5927d34020a891fcdbbcbd&libraries=clusterer"></script>
   	<script src="/jspweb/js/datago/datago.js" type="text/javascript"></script>

</body>
</html>