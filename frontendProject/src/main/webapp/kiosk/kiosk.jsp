<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/frontendProject/css/kiosk.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>
	<!-- 범위조정(tab처리) : ctrl+shift+f -->
	<div class="kioskwrap"> <!-- 키오스크 전체 -->
		<div> <!-- 헤더 : 광고이미지 / 카테고리 표시되는 구역 -->
				
			<!-- 광고 이미지 -->
			<img class="himg" src="../img/himg1.png">
			
			<!-- 카테고리 -->
			<ul class="categorymenu">
			</ul>
		</div> <!-- 헤더 end -->
		
		<div class="kioskcontent"> <!-- 본문 : 제품 / 카트 출력 -->
			
			<div class="productbox"> <!-- 제품 구역 -->
<!-- 			
				<div class="product"> 제품 1개 기준
					<img src="../img/헬로디아블로와퍼.png"/>
					<div class="pinfo">
						<div class="pname"> 헬로 디아블로 와퍼 </div>
						<div class="pprice"> 15,000원 </div>
					</div>
				</div> -->
				
			</div> <!-- 제품 구역 end -->
			
			<div class="cartbox"> <!-- 카트 구역 -->
				<div class="cartcontent"> <!-- 제품개수/총가격, 제품정보 출력 -->
				
					<div class="carttop"> <!-- 제품개수/총가격 출력 구역 --> 
						<div> 카트 <span class="ccount">0</span> </div>
						<div> 총 주문금액 <span class="ctotal">0원</span> </div>
					</div>
					
					<div class="cartbottom"> <!-- 제품정보 출력 --> 
					
				<!-- 		<div class="citem">
							<div class="iname"> 더블비프불고기버거 </div>제품명						
							<div class="iprice"> 12,000원 </div> 제품가격
							<span class="icencel"> X </span> 개별 취소
						</div> -->
						
						
					</div>
					
				</div>
				
				<div class="cartbtn"> <!-- 버튼 구역 -->
					<button onclick="cartCencel()" class="cancelbtn">취소하기</button>
					<button onclick="productOrder()" class="orderbtn">주문하기</button>
				</div>
				
			</div> <!-- 카트 구역 end -->
			
		</div> <!-- 본문 end -->
	</div> <!-- 키오스크 전체 end -->
	
	<%@include file = "../footer.jsp" %>
	
	<script src="/frontendProject/js/kiosk.js" type="text/javascript"> </script>
</body>
</html>