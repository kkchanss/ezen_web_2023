/*

	이벤트함수
	HTML 이벤트 적용하는 방법
	1.
		<태그 이벤트속성명="함수명()"> </태그명>
	2. 
		document.addEventListener('click', 함수명)
	3. 이벤트
		이벤트명
		1. DOMContentLoaded : HTML이 완전히 열렸을때 [모두 로드되었을때] 실행되는 이벤트
		2. window.onload : 해당 객체가 호출 되었을때
		3. click : 해당 객체를 클릭했을땨
		4. keyup : 해당 객체에서 키보드를 누르고 떼어있을때
		5. keydown : 해당 객체에서 키보드를 눌렀을때
			- key 상태 확인
 */
// 1.
let text = document.querySelector('.textbox');
text.addEventListener('keyup', ( e ) => {
	console.log('키보드 입력하고 떼어있을때');
	
	let h3 = document.querySelector('.h3box');
	
	console.log(text.value.length)
	
	h3.innerHTML = `입력된 문자 길이 : ${text.value.length}`;
	// 1. 키 상태 확인
	console.log(e);
	console.log(e.altKey);
	console.log(e.ctrlKey);
	console.log(e.shiftKey);
	console.log(e.code);	// 입력한 키보드의 코드네임
	console.log(e.key); 	// 키의 value
	console.log(e.keyCode)
	
	if(event.keyCode == 13) { alert('엔터 입력했습니다')}
})

// 2.
let moving = document.querySelector('.moving'); // 1. 버튼의 태그 호출
moving.style.position = `absolute`; // 2. style 속성 이용한 css 추가
	// 1. DOM객체명.style = `속성명 : 값, 속성명 : 값`
	// 2. DOM객체명.style.css속성명 = `값`;		주의할 점 : css속성명 작성시 카멜표기법  사용
		// DOM객체명.style = `background-color = 'blue'`;
		// DOM객체명.style.backgroundColor =  `blue` // JS는 속셩명에 - 사용금지..
		
	// * 버튼 위치의 초기값 x = 가로축 y = 세로축 block = 이동단위[30px씩 이동]
	let x = 7; let y = 0; let block = 30;
	// 1. 버튼 위치 출력 함수
movingPrint(); // 최초 1번 실행
function movingPrint() {
	moving.style.left = `${x * block}px`
	moving.style.top = `${y * block}px`
}
	// 2. 이동 이벤트 함수 [만약에 본문에서 키다운을 누르면]
document.body.addEventListener('keydown', (e)=>{
	// e: keydown 이벤트 결과 정보 담고있는 객체
	// 1. 만약에 key를 눌렀을때
	if(control == true){
		let key = e.keyCode;
		console.log(key);
		// 왼쪽방향키 = 37 위방향키 = 38 오른쪽방향키 = 39 아래방향키 = 40
		if(key == 37) { x--; } // 왼쪽방향키를 눌렀을때 왼쪽으로 이동
		else if(key == 38) { y--; }
		else if(key == 39){ x++; }
		else if(key == 40) { y++; }
		movingPrint();
	}

})

let control = true; // 버튼 이동상태 저장 변수 [ true = 이동, false = 이동불가 ]
	// 3. 버튼 클릭시 control 변수 상태 변경해주는 함수
moving.addEventListener('click', ( e )=>{
	control = !control // 현재 상태를 반대로 변경
	if(control) moving.innerHTML = "배치하기";
	else moving.innerHTML = "이동하기";
})