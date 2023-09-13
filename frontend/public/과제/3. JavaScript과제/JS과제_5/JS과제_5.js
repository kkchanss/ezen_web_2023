/*
 */

 
 //1. 조작, 제어할 HTML 태그[DOM객체]를 호출
 let userbox = document.querySelector('.userbox');
 
 // 유저[userbox]위치 x좌표
 let u_left = 50;
 
 
 // 어떻게 : 현재 페이지(전체)에서 키보드를 누를때  = keydown
 	// DOM객체명.addEventListener('이벤트명', ()=>{})
 document.body.addEventListener('keydown', (e)=>{
	 console.log('키눌림')
	 //1. 눌린 키 상태 확인 .keyCode
	 console.log(e)
	 //2. 만약에 왼쪽/오른쪽 키를 눌렀을때 
	 if( e.keyCode == 37 ){
		 console.log("왼쪽으로 이동"); // css left 차감
		 u_left -= 10;
		 //유효성 검사 - 만약에 위치가 0보다 작아지면 0으로 고정함 ! 
		 if( u_left < 0){u_left = 0;}
		 userbox.style.backgroundImage = 'url(img/히어로.webp)';
		 userbox.style.width = `100px`;
	 }else if ( e.keyCode == 39 ){
		 console.log ("오른쪽으로 이동"); //css left 증가
		 u_left += 10;
		 //유효성 검사 - 만약에 위치가 0보다 작아지면 0으로 고정함 ! 
		 if( u_left > 500){u_left = 500;}
		 userbox.style.backgroundImage = 'url(img/히어로.webp)';
		 userbox.style.width = `100px`;
	 }else if ( e.keyCode == 65 ){ // a키를 눌렀을때
		 console.log('공격');
		 userbox.style.backgroundImage = 'url(img/히어로2.webp)';
		 userbox.style.width = `145px`;
	 }
	 // 현재 위치 값을 대입
	 userbox.style.left = `${u_left}px`
	 console.log (userbox.style.left);
 })
 
 //2. 키보드에서 키를 떼었을때 = keyup
 document.body.addEventListener (' keyup', (e)=>{
	 // 원래 기본 이미지로 변경
	 userbox.style.backgroundImage = 'url(img/히어로.webp)';
 })
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 