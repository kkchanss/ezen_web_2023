<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!-- 뷰포트 : 반응형 동작 코드 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>list</title>
	<!-- 부트스트랩에서 만든 CSS 호출 -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
	<!-- 
		★ 부트스트랩을 사용하려면 설치/호출/적용을 해야한다.
		1. CSS <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
		2. JS <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
			
		------------------------------------------------------------------------------------------
			1. .container : 반응형 구역
				2. 그리드 : 해당 구역 12조각 
					.row						: 하위 요소 가로배치 
					.col						: 열 
					.col-조각수					: 열-그리드수
					.justify-content-md-center  : 가로배치 가로정렬
					.g-여백수						: 커터 : 열마다 자동여백[24px]	g-0[ 열 여백제거]
				2. 
					.table 						: 테이블 기본 CSS 
					.table-striped				: 홀/짝 행 구별 색상
					.table-hover				: 행에 마우스를 올렸을때 색상
					.table-bordered				: 테이블 테두리
				3. .text-center					: 하위 요소 가운데 정렬 
				4. .navigation 					: 페이지네이션 / 페이징처리 버튼
				5. .form-select					: 셀렉트 상자 꾸미기
				6. .form-control				: input 상자 꾸미기 
	 -->
	<!-- 다른 JSP 파일이 호출 가능함 -->
	<%@ include file="../header.jsp" %>
	
	<!-- CSS/JS 미리 만들어진 라이브러리 제공 -->
	<div class="container"> <!-- 현재 게시물 출력 페이지 전체 구역 -->
		<h3> 커뮤니티</h3>
		<a href="write.jsp"><button type="button" class="btn btn-outline-dark">글쓰기</button></a>
		<table class="table table-hover text-center">
			<thead>
				<tr class="table-dark"> <!-- 제목 행 -->
					<th width="5%"> 번호 </th> <th width="58%"> 제목 </th> <th width="10%"> 작성자 </th> <th width="13%"> 작성일 </th>
					<th width="7%"> 조회수 </th> <th width="7%"> 추천수 </th>
				</tr>
			</thead>
			<tbody class="tcontent">
				<!-- boardPrint() 가 innerHTML 넣는 구역 -->
			</tbody>
			<tfoot>
				<tr class="table-dark"> <td colspan="6"> total : 3 </td></tr>
			</tfoot>
		</table>  <!-- 테이블 end -->
		<nav aria-label="Page navigation example">
		
			<!-- 페이징처리 구역 -->
		  <ul class="pagination justify-content-center">
		    <li class="page-item disabled">
		      <a class="page-link">이전</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#">다음</a>
		    </li>
		  </ul>
		</nav>
			<!-- 검색창 구역 -->
			<div class="row justify-content-md-center gx-1">
				<div class="col-1">
					<select class="form-select">
						<option>키워드</option> <option>번호</option> <option>제목</option> <option>작성자</option>
					</select>
				</div>
				<div class="col-3">
					<input type="text" class="form-control"> 
				</div>
				<div class="col-1">
					<button class="form-control"> 검색 </button>
				</div>
			</div>
		
		
	</div> <!-- 현재 게시물 출력 페이지 전체 구역 end -->
	
	
	<!-- 다른 JSP 파일이 호출 가능함 -->
	<%@ include file="../footer.jsp" %>
	<!-- 부트스트랩에서 만든 JS 호출 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	<!-- JS 호출하기 -->
	<script src="../JS/list.js" type="text/javascript"></script>
	
</body>
</html>