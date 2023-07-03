/*
 	
 	함수 : 미리 정의된 코드의 집합
 		1. 내장함수 : JS언어 기본적으로 사용할 수 있는 함수
 		2. 내장객체 : JS언어 기본적으로 사용할 수 있는 객체
 			console
 			document
 			Math
 			mew Date();
 		3. 정의함수 : 개발자 정의해서 사용하는 함수 
 			function 함수명(){} ===> 함수명();
 	
 	DOM 객체 : Document Object Model : 문서 객체 모델
 		- HTML 정적언어 (메모리x이벤트x) - JS 동적언어(메모리o이벤트o)
 		1. 정의 : HTML문서를 각 항목을 계층으로 표현된 JS객체
 		2.
 		
 */

 // 1. document 객체 이용한 태그를 객체로 호출
 	// 1. querySelector() vs getElementById / getElementsByClassName
 
 console.log(document); // 현재 js가 포함된 HTML 문서의 전체
 console.log(document.body); // <body> 호출
 console.log(document.head); // <head> 호출
 console.log(document.div); // <div> 중복 가능한 태그 이므로 제공x
 let div변수 = document.querySelector('div');
 console.log(document.querySelector('div')); // <div> 태그 호출
 console.log(document.querySelector('.box1')); // <div> 태그 호출
 console.log(document.querySelector('#box2')); // <div> 태그 호출
 console.log(document.querySelectorAll('div')); // <div> 태그 호출
 let div배열 = document.querySelectorAll('div');
 console.log(div배열[2]);
 	// 2. innerHTML 속성
 div배열[2].innerHTML = '안녕하세요3 수정HTML';
 document.body.innerHTML = '';
 document.body.innerHTML += '<h3> 추가HTML </h3>'
 let html = '<p> 변수로 작성한 HTML형식의 문자열 데이터</p>'; // 모양/형식은 HTML이고 자료형/타입 '문자열'
 // 자료형/타입 : 숫자형, 문자형, 논리형, 배열, 객체, 함수
 document.body.innerHTML = html;
 
	// 3. style 속성 : <태그 style="CSS작성"> </태그>
 document.body.style = `background-color:black; color:white;`
 
 	// 4. addEventListener('이벤트명', 함수);
 	/*
 		1.
 			function 함수명() {}
 			addEventListener{'이벤트명', 함수명};
 		2.  
 			익명함수[ 함수명이 없는 함수 (인수)=>{실행코드}]를 이용한 이벤트 추가
 			addEventListener('이벤트명', () => {});
 	*/
 document.addEventListener('DOMContentLoaded', () => {
	 console.log('JS에서 이벤트 실행');
 });
 // 2. 해당 객체가 호출 되었을때
 window.onload = () => { console.log('JS에서 이벤트 실행2');}
  
 // 3. JS 열렸을때 이벤트 1번 실행
 console.log('JS에서 이벤트 실행3');
 
 // 4. 
 let p = document.querySelector('p'); console.log(p);
 
 // 5.
 p.addEventListener('click', () => {
	 console.log('p 태그 클릭했다.');
 });