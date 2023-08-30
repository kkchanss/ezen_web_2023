<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="hrm.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>
	
	<div class="hrmwrap">
		<form class="hrm_top">
			직원명 : <input name="hname" class="hname" type="text"> <br>
			직원전화번호 : <input name="hphone" class="hphone" type="text"> <br>
			직원사진 : <input name="himg" class="himg" type="file"> <br>
			직급 : 
			<select name="hposition" class="position_select">
				<option>사장</option>
				<option>부장</option>
				<option>팀장</option>
				<option>대리</option>
				<option>주임</option>
				<option>사원</option>
			</select>
			
			<button type="button" onclick="hrmwrite()">제출</button>
		</form>
		
		<div class="hrm_bottom">
			<div class="hrmbox">
				<div class="hrmbox_top">
					<div class="box_hname">네임</div>
					<div class="box_hposition">직급</div>
					<div class="box_hphone">폰번호</div>
				</div>
				<div class="hrmbox_bottom">
					<img class="box_himg" src="/jspweb/img/ezenlogo.png">
				</div>
			</div>
		</div>
	</div>
	
	<%@include file = "../footer.jsp" %>
	
	<!-- 최신 JQUERY import ( ajax() 사용할 js파일부터 위에서 호출)  -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="hrm.js"  type="text/javascript"></script>
</body>
</html>