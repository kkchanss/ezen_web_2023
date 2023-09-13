<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>admin</title>
	<link href="../css/admin.css" rel="stylesheet">
	</head>
<body>
	<!-- 헤더 JSP 파일 호출 -->
	<%@ include file="./header.jsp" %>

		<div class="admin_wed"> <!-- 관리자 페이지 전체 레이아웃 s -->
			<div class="admin_wed2">
				<div class="menu_L">  <!-- 관리자 페이지 왼쪽 메뉴 s ------------------------------> 
					<h3> Menu </h3>
						<ul>
							<li><button onclick="order_status_view()" class="order_status menu_btn"> 		   주문현황 </button></li>
							<li><button onclick="Sales_stats_view()" class="Sales_stats menu_btn">			   매출통계 </button></li>
							<li><button onclick="member_management_view()" class="member_management menu_btn"> 회원관리 </button></li>
							<li><button onclick="review_management_view()" class="review_management menu_btn"> 리뷰관리 </button></li>
							<li><button onclick="setting_view()" class="setting menu_btn"> 					   환경설정 </button></li>
						</ul>
						
				</div> <!-- 관리자 페이지 왼쪽 메뉴 e -->
					
		
			
				<div class="menu_R"> <!-- 관리자 페이지 오른쪽 출력 s ------------------------------>
				
					<!-- inner HTML 로 화면 전환 -->
					<h2>  주문현황 </h2>
					<table>
						<tr>
							<th> 주문번호 </th> 
							<th> 주문일 </th> 
							<th> 주문자 </th> 
							<th> 전화번호 </th>
							<th> 주문품목</th>
							<th> 결제금액</th>
						</tr>
					
					</table>
					
					
					
				
				</div> <!-- 관리자 페이지 오른쪽 출력 e -->
			</div>	
		</div> <!-- 관리자 페이지 전체 레이아웃 e -->




	<!-- 푸터 JSP 파일 호출 -->
	<%@ include file="./footer.jsp" %>
	<!-- 해당 페이지 JS 호출 -->
	<script src="../js/admin.js" type="text/javascript"></script>
	<!-- Java 서블릿이랑 통신하기위해 호출했음 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</body>
</html>