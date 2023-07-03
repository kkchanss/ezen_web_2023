
// 누구를
//  1. 조작/제어할 HTML 태그 dom객체 호출
let userbox = document.querySelector('.userbox');

// 유저 위치 = x 좌표
let u_left = 500;

// 어떻게 : 웹에서 키보드를 누를때
	// DOM객체명.addEventListener('이벤트명', () => {})
document.body.addEventListener('keydown', (e) => {
	console.log('키 눌림');
	console.log(e);
	if(e.keyCode == 37) {
		console.log('왼쪽으로 이동'); // css left --
		u_left -= 10;
		
		if(u_left < 500) u_left = 500;
		userbox.style.backgroundImage = `url("img/흰둥이.png")`; // 이동 이미지 출력
	}
	else if(e.keyCode == 39) {
		console.log('오른쪽으로 이동'); // css left ++
		u_left += 10;
		if(u_left > 1300) u_left = 1300;
		userbox.style.backgroundImage = `url("img/흰둥이.png")`; // 이동 이미지 출력
	}
	else if(e.keyCode == 65) { // a키 눌렀을때
		console.log('공격')
		userbox.style.backgroundImage = `url("img/위공격.png")`; // 공격 이미지 출력
	}
	// 3. 
	userbox.style.left = `${u_left}px`;
	// 확인
	console.log(userbox.style.left)
}) // f end

// 2. 키 누르고 떼었을때. = keyup
document.body.addEventListener('keyup', (e) => {
	// 원래 기본 이미지 변경 
	userbox.style.backgroundImage = `url("img/아래공격.png")`;
})
