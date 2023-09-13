
 //1. select 목록 상자에서 변경될때 선택된 value 가지고 오기
 let selectbox = document.querySelector('.selectbox');
 
 	// * 이벤트 등록 [ addEventListener vs <select onchange=""> ]
 selectbox.addEventListener('change', ()=>{
	console.log (' 목록 상자가 변경 되었네요.')
 	console.log ( selectbox.value )
 
 })
 
 
 //2. input 의 checkbox에서 체크 여부 가지고 오기 
 let checkbox = document.querySelector('.checkbox');
 
 	// * 이벤트 등록
 checkbox.addEventListener('change', ()=>{
	 console.log (' 체크 상자가 변경 되었네요.')
	 console.log ( checkbox.checked ) // 체크 여부를 ture인지 false 인지 값을 받아옴 ! 
	 
 })
 	
 //3. 타이머 예제
 	//1. 제어할 해당 태그 호출하기
 let timer = document.querySelector('.timer');
 let timerbox = document.querySelector('.timerbox')
 
 	//2. 시간함수
 let time = 0; // 타이머 시간을 저장하는 변수
 let timerId = 0; //타이머 함수가 저장되는 변수
 	
 	// * 이벤트 등록
 timer.addEventListener('change', ()=>{
	 
	 if( timer.checked ){ // 체크가 있으면
		timerId = setInterval(()=>{
					time++;
					timerbox.innerHTML = `${time}초`;
					}, 1000)
	 }else{ // 체크가 없으면
		 clearInterval( timerId )
	 }
	 
	 
 })
 
 /*
 	setInterval(): 특정시간마다 특정함수를 재호출 해준다.
 		1. setInterval ( 함수 , 시간 )
	 		함수
	 			1. 기존함수명
	 			2. ()=>{}
	 			3. function (){}
	 		시간 : 밀리초 [ 1초/ 1000초 ]
	 			1000 -> 1초
	 			100 -> 0.1초
	 			10 -> 0.01초
	 			1 -> 0.001초
 		2. clearInterval() : 해당 타이머 정지
 			let timerId = setInterval( ()=>{} , 밀리초 );
			clearInterval( timerId )
 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 