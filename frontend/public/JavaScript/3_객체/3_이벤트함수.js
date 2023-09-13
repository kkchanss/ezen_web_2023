/*

	함수 : 미리 정의된 코드의 집합
		1. 내장함수 : JS언어에서 기본적으로 사용할수 있는 함수 = 라이브러리 
			1. console.log('하고싶은말')		
			2. alert('하고싶은말')				
			3. confirm('하고싶은말')		
			4. prompt('하고싶은말')			
			5. document.write('html형식문자열')
			6. parseInt()
			7. Number()
			8. 배열명.push( 새로운값 )	
			9. 배열명.splice( 위치인덱스 , 0 , 새로운값 )
			10. 배열명.pop()
			11. 배열명.indexOf('찾을데이터')
			12. document.querySelector()
			13. Math.random()
			14. new Date();
			15. toLocaleString()

		2. 내장객체 : JS언어에서 기본적으로 사용할수 있는 객체
			console
			document
			Math
			new Date();
			
		3. 정의함수 : 개발자가 정의 해서 사용하는 함수
			function 함수명(){} ====> 함수명();
		
		
	DOM 객체 : Document Object Model : 문서 객체 모델
		- HTML 정적언어 (메모리x,이벤트x)
		- JS 동적 언어  (메모리o,이벤트o)
		1. 정의 : HTML 문서를 각 항목을 계층으로 표현된 JS객체 
		2. 
			document

 
 */

 //1. document 객체를 이용한 태그를 객체로 호출 ! 
 	// 1. querySelector vs getElementById / getElementByClassName
 console.log( document )   		//현재 JS가 포함된 HTML의 전체 구역이 출력된다.
 console.log( document.body ) 	// <body> 호출
 console.log( document.head ) 	// <head> 호출
 console.log( document.div )	// 이거는 호출 안됨!! 2개 이상 존재(중복) 할 수 있어서 ! 
 console.log( document.querySelector('div')) // 이거는 호출 됨 [가장 위에꺼 한개]
 let  div변수 = document.querySelectorAll('div');
 
 console.log( document.querySelector('.box1'))
 console.log( document.querySelector('#box2'))
 console.log( document.querySelectorAll('div')) // 모든 <div> 전부 리스트로 호출
 let  div배열 =  document.querySelectorAll('div'); // 그래서 배열에 담아야함.
 console.log ( div배열[2] )
 
 	//2. innerHTML 속성 : <태그> innerHTML </태그>
 div배열[2].innerHTML = '안녕하세요3  수정 HTML'; 	// = 대입(기존데이터사라짐), += 추가(기존데이터 뒤에 이어서)
 document.body.innerHTML = ''; // body 내 모든 HTML 지우기 
 document.body.innerHTML += '<h3> 추가 HTML </h3>'
 let HTML = '<p> 변수로 작성한 HTML 형식의 문자열 데이터 </p>'; // 모양/형식은 HTML 이지만 자료형타입은 '문자열'
 document.body.innerHTML = HTML;
 
 	//3. style 속성 : <태그 style="CSS작성"></태그>
 document.body.style = 'background-color: skyblue; color: white; font-szie: 20px;';
 
 	//4. addEventListener('이벤트명', 함수);
/*
		 1.
			 function 함수명(){}
			 addEventListener('이벤트명', 함수);
		 2. 익명함수[ 함수명이 없는 함수 (인수) => {실행코드} ]를 이용한 이벤트 추가
			 addEventListener('이벤트명', ()=>{});	 
*/
/*
		이벤트명
			1. DONContentLoaded : HTML이 완전히 열렸을때 [모두 로드되었을때] 실해되는 이벤트
			2. window.onload	: 해당 객체가 호출되었을때 

*/
	//1. HTML 이 완전히 열렸을때
 document.addEventListener( 'DOMContentLoaded', ()=>{
	 console.log('JS에서 이벤트 실행');
 });
 	//2. 해당 객체가 호출 되었을때
 window.onload = () => { console.log ('JS에서 이벤트 실행2')}
 	//3. JS가 열렸을때 이벤트 1번 실행
 console.log ('JS에서 이벤트 실행3')
 	//4. 
 let p = document.querySelector('p'); console.log(p);
 	//5. 
 p.addEventListener(' click', ()=> {
	 console.log ('p 태그 클릭했다.');
 })
 
 
 
 
 
 
 
 
 
 
 
 