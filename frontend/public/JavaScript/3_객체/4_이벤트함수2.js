/*

	이벤트함수
	HTML 에 이벤트 적용하는 방법
	1. 
		<태그 이벤트속성명 = "함수명()"> </태그명>
	2. 
		1. DOM객체.addEventListener(' 이벤트명 ', 함수명 ) 		 -> 기존 함수명 적용
		2. DOM객체.addEventListener(' 이벤트명 ', ()=>{} )		 -> 이견 화살표 함수 정의해서 적용
		3. DOM객체.addEventListener(' 이벤트명 ', function(){} ) -> 익명 함수 정의해서 작용
		
			DOM객체.addEventListener('이벤트명' , ( 이벤트결과인수=e )=>{ } )
		
	3. 이벤트
		이벤트명
		1. DONContentLoaded : HTML이 완전히 열렸을때 [모두 로드되었을때] 실행되는 이벤트
		2. window.onload	: 해당 객체가 호출되었을때 
		3. click			: 해당 객체를 클릭 했을때
		4. keyup			: 해당 객체에서 키보드를 누르고 떼어있을때
		5. keydown			: 해당 객체에서 키보드를 눌렀을때 
			- e.keyCode 입력된 키 코드번호 
 */

 //1. 
 let textbox = document.querySelector('.textbox')
 textbox.addEventListener('keyup', (event)=>{ console.log('키보드 입력하고 떼어있을때')
	let h3 = document.querySelector('.h3box')
	console.log ( textbox.value.length )
	h3.innerHTML = ` 입력된 문자 길이 : ${textbox.value.length}`;
	//1. 키상태 확인 => 키보드 제어도 가능 
	 console.log ( event );
	 console.log ( event.altKey );   // alt 눌렀는지
	 console.log ( event.ctrlKey );  // ctrl 눌렀는지
	 console.log ( event.shiftKey ); // shift 눌렀는지
	 console.log ( event.code );	 // 입력된 키보드의 코드 
	 console.log ( event.Key );		 // 
	 console.log ( event.KeyCode );  // 입력된 키보드의 코드 번호
	 
	 // 만약에 키보드에서 엔터를 눌렀을때
	 if( event.KeyCode == 13 ){alert ('엔터를 입력 했습니다.');}
 })
 
 //2. 
 let moving =document.querySelector('.moving'); // 버튼 태그 호출
 moving.style.position = `absolute`; 			// style 속성 사용하여 css 추가
 	//DOM 객체명.style = `속성명 : 값, 속성명 : 값` 
 	//DOM 객체명.style.css속성명 = `값`;   -> 주의할점 : css 속성명 작성시 마켈표기법 사용해야함.
 		//DOM 객체명.style = `background-color : blue` 
 		//DOM 객체명.style.backgroundColor = `값`;
 	
 	// * 버튼위치의 초기값 x=가로축, y=세로축, block=이동단위[30px씩]
 	let x = 7; let y = 0; let block = 30;
 	//1. 버튼 위치 출력함수
 movingPrint() //JS 열렸을때 최초 한번 실행 
 function movingPrint(){
	 moving.style.left = `${x * block}px`
	 moving.style.top = `${y * block}px`
 }
 	//2. 버튼 이동이벤트 함수
 document.body.addEventListener('keydown', (e)=>{
	 // e : keydown 이벤트 결과 정보 담고 있는 객체
	 // 만약에 이동 상태가 ture 인 경우에만 가능하도록 
	 if( control == true){
	 // 1. 만약에 key 를 눌렀을때
	 let key = e.keyCode; // 눌린 키보드 키의 넘버를 가져온다.
	 	console.log (key);
	 	// 왼쪽방향키 = 37, 위방향키 = 38, 오른방향키 = 39, 아래방향키 = 40
	 if(key == 37 ){ x--;}
	 else if( key == 38){ y--; }
	 else if( key == 39){ x++; }
	 else if( key == 40){ y++; }
	 movingPrint() // 해당 버튼의 위치를 새로고침 
	 }
 })
 		
 	//3.
 let control = true ; // 버튼 이동 상태 저장 변수 [ true = 이동, false = 이동불가]
 moving.addEventListener('click', ()=>{ 
	 control = !control // 클릭하면 현재 상태를 반대로 입력한다.
	 if( control ) moving.innerHTML = '배치하기';	
	 else moving.innerHTML = '이동하기';	 
})
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		
 		