<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h6> AJAX [ JS ---- 자바[서블릿] 통신 ]</h6>
	<h1> 1. [문자타입] JS예시 servlet[자바웹클래스]에게 통신</h1>
	<button onclick="예제1()" type="button">예제1</button>

	<h6> 2. [HTML 입력받은 ] JS에서 servlet[자바웹클래스]에게 통신 </h6>
	성명 : <input class="name" type="text"> <br>
	나이 : <input class="age" type="number"> <br>
	<button onclick="예제2()" type="button">예제2</button>


	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<script src="1_AJAX통신.js" type="text/javascript"></script>

</body>
</html>