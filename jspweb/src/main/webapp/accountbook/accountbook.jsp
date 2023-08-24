<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <!-- css import -->
   <link href="accountbook.css" rel="stylesheet" />
</head>
<body>
	<div class="wrap"> <!-- 전체 구역 -->
		<div class="inputDiv"> <!-- 입력 구역 -->
			<input class="acontent"    type="text" placeholder="내용">
	        <br>
	        <input class="amoney"    type="number" placeholder="금액">
	        <br>
	        <input class="aday" type="date">
	    	<br>
	        <button onclick="awrite()" type="button">등록</button>
		</div>
		
		<div class="outputDiv"> <!-- 출력 구역 -->
			 <div class="accountbox">
	               <div class="accountbox_top">
	               	  <div class="accountmoney"> 20,000원 </div>
	                  <div class="accountdate"> 2023-11-11 </div>
	               </div>
	               
	               <div class="accountbox_center"> 음식음식음식음식음식음식 </div>
	              
	               <div class="accountbox_bottom">
	                  <button onclick="aupdate()" type="button">수정</button>
	                  <button onclick="adelete()" type="button">삭제</button>
	               </div>
	         </div>
		</div>
	</div>
	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   	<script src="accountbook.js" type="text/javascript"></script>
	
</body>
</html>