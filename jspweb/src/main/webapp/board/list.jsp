<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="../css/list.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="wrap">
		<ul class="board_category">
			<li onclick="categorySelect( ${ i })" class="categoryselect"> 공지사항  </li>
			<li onclick="categorySelect( ${ i })" class="categoryselect"> 자유게시판  </li>
			<li onclick="categorySelect( ${ i })" class="categoryselect"> 노하우  </li> 
		</ul>
		
		<h1>게시판</h1>
		
		<div class="board_list_box">
			<table class="board_list">
				<tr> 
	                  <th class="bno"> 번호 </th>
	                  <th class="mno"> 작성자 </th>
	                  <th class="btitle"> 제목 </th>
	                  <th class="bhits"> 조회수 </th>
	                  <th class="bdate"> 날짜 </th>
               </tr>
               <tr> 
	                  <td class="bno"> 123 </td>
	                  <td class="mno"> test </td>
	                  <td class="btitle"> test제목 </td>
	                  <td class="bhits"> 1 </td>
	                  <td class="bdate"> 2023-11-11 </td>
               </tr>
			</table>
		</div>
	</div>
	
	<%@include file="../footer.jsp" %>
</body>
</html>