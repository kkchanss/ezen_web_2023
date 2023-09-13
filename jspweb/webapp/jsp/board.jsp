<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="subway.Board" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/header.css" rel="stylesheet">
<link href="../css/footer.css" rel="stylesheet">
<link href="../css/board.css" rel="stylesheet">
</head>
<body>

	<%@include file = "header.jsp" %>
	
	<div class="wrap">
		<ul class="board_category">
			<li onclick="categorySelect( ${ i })" class="categoryselect"> 공지사항  </li>
			<li onclick="categorySelect( ${ i })" class="categoryselect"> 한줄 리뷰  </li>
			<li onclick="categorySelect( ${ i })" class="categoryselect"> 문의사항  </li> 
		</ul>
		
		<div class="board_content">
			<img src="\subway\img\subways_qna.png" class="board_title">
		</div>
		<div class="board_list_box">
		
			<!-- <table class="board_list"> review 리스트
               <tr> 
                  <th class="no"> 번호 </th>
                  <th class="name"> 작성자 </th>
                  <th class="menu"> 상품명 </th>
                  <th class="content"> 내용 </th>
                  <th class="star"> 별점 </th>
                  <th class="time"> 날짜 </th>
               </tr>
               
     			<tr>
                  <td class="no"> 1 </td>
                  <td class="name"> 찬희 </td>
                  <th class="menu"> 상품명 </th>
                  <td class="content"><a href="#"> 사장님이 친절해요 </a> </td>
                  <td class="star"> ★☆ </td> 
                  <td class="time"> 2023-07-09 </td>                
               </tr>
               
               <tr>
                  <td class="no"> 2 </td>
                  <td class="name"> 찬희 </td>
                  <th class="menu"> 상품명 </th>
                  <td class="content"><a href="#"> 에그마요 추천합니다 </a> </td>
                  <td class="star"> ★★★☆☆ </td>   
                  <td class="time"> 2023-07-09 </td>              
               </tr> 
            </table> review 리스트 end -->
            
            <table class="board_list"> 
              <!--  <tr> 
                  <th class="no"> 번호 </th>
                  <th class="name"> 작성자 </th>
                  <th class="title"> 제목 </th>
                  <th class="content"> 내용 </th>
                  <th class="hits"> 조회수 </th>
                  <th class="time"> 날짜 </th>
               </tr>
               
     			<tr>
                  <td class="no"> 1 </td>
                  <td class="name"> 찬희 </td>
                  <th class="title"> 이것은 </th>
                  <td class="content"><a href="#"> 공지사항 </a> </td>
                  <td class="star"> 0 </td> 
                  <td class="time"> 2023-07-09 </td>                
               </tr>
               
               <tr>
                  <td class="no"> 2 </td>
                  <td class="name"> 찬희 </td>
                  <th class="title"> 이것도 </th>
                  <td class="content"><a href="#"> 공지사항 </a> </td>
                  <td class="star"> 115 </td>   
                  <td class="time"> 2023-07-09 </td>              
               </tr>  -->
            </table>
           
       </div>
       <!--  
       <button class="writeBtn" onclick="location.href='boardwrite.jsp'">게시물 작성</button>
       -->
       <div class="wirteBtnDiv">
        <button class="writeBtn" onclick="loginCheck()">게시물 작성</button>
        </div>
	</div>
	
	
	<%@include file = "footer.jsp" %>
	<script src="https://code.jquery.com/jquery-latest.min.js"></script>
	<script src="../js/board.js" type="text/javascript"></script>
</body>
</html>