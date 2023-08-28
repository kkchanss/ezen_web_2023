/*
	onchange : 포커스 변경될때 값이 다르면 
	onkeyup : 키보드에서 키를 누르고 떼었을때 
	onkeydown : 키보드에서 키를 눌렀을때

	정규표현식 : 문자열에 특정 규칙/패턴 집합 표현할때 사용되는 언어 
		문법 
			/^	: 정규표현식 시작 알림
			$/	: 정규표현식 끝 알림 
			[a-z] : 소문자 a-z 패턴 검색 
			[A-Z] : 대문자 A-Z 패턴 검색 
			[0-9] : 숫자 0~9 패턴 검색 
			[가-힣] : 한글 패턴 
			{최소길이,최대길이} : 문자열 길이 패턴
			+ : 앞에 있는 패턴 1개이상 반복 
			? : 앞에 있는 패턴 0개 혹은 1개 이상 반복  
			* : 앞에 있는 패턴 0개 반복 
			
			1. [a-z]
			2. [a-zA-Z]
			3. [a-zA-Z0-9]
			4. [ac]
			5. (?=,*[패턴문자]) : 해당 패턴문자가 한개 이상 포함 패턴
 				[?=,*[a-z]] : 소문자 한개 이상 필수
 				[?=,*[a-z]] : 대문자 한개 이상 필수
 				[?=,*[0-9]] : 숫자 한개 이상 필수
 				[?=,*[\d]] : 숫자 한개 이상 필수
 				[?=,*[a-z]] : 소문자 한개 이상 필수
			/^[a-z0-9]{5,30}$/ -- a~z, 0~9로 5글자 이상 30글자 이하 
*/



// 아이디 유효성 검사 
function idcheck() {
	console.log('idcheck');
	
	let mid = document.querySelector('.mid').value; 
	
	//if(mid.length < 5 && mid.length >= 30) {}
	let midj = /^[a-z0-9]{5,30}$/
	
	console.log(midj.test(mid))
	
	if(midj.test(mid)) {
		document.querySelector('.idcheckbox').innerHTML = '사용 가능한 아이디'
		$.ajax({ 
			url : "/jspweb/MemberFindController" , 
			method:"get" , 
			data : { 'type' : "mid", 'data' : mid} , 
			success : r => { 
				if(r == true) document.querySelector('.idcheckbox').innerHTML = '아이디 중복'
				console.log('중복검사 : ' +r)
			} ,
			error : e => { console.log('통신실패'); }
		})
	
	}else{
		document.querySelector('.idcheckbox').innerHTML = '영문(소문자)+숫자 조합의 5~30글자 가능'
	}
}

// 비밀번호 유효성 검사 
function pwcheck() {
	console.log('pwcheck');
	
	let mpwd = document.querySelector('.mpwd').value; 
	let mpwdconfirm = document.querySelector('.mpwdconfirm').value;
	//if(mid.length < 5 && mid.length >= 30) {}
	let mpwdj =  /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/
	let pwcheckbox = document.querySelector('.pwcheckbox');
	console.log(mpwdj.test(mpwd))
	
	if(mpwdj.test(mpwd)){
		
		if(mpwdj.test(mpwdconfirm)){
			if(mpwd == mpwdconfirm) {
				pwcheckbox.innerHTML = '비밀번호 일치'
			}else{
				pwcheckbox.innerHTML = '비밀번호 불일치'
			}
		}else{
			pwcheckbox.innerHTML = '영어 대,소문자 1개 이상 + 숫자 1개이상 조합으로 5글자~20글자 까지 가능'
		}
	}else{
		pwcheckbox.innerHTML = '영어 대,소문자 1개 이상 + 숫자 1개이상 조합으로 5글자~20글자 까지 가능';
	}
}

function emailcheck() {
	
	// 1. 입력된 값 호출 
	let memail = document.querySelector('.memail').value;
	let emailcheckbox = document.querySelector('.emailcheckbox');
	// 2. 이메일 정규표현식 [ 영대소문자+숫자+_- @ ]
		// itdanja@kakao.com
		// 1. itdanja ; 이메일 아이디부분은 영대소문자, 숫자, _- 패턴 
		// 2. @ : + @ @앞에 패턴이 1개 이상 필수
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+\.[a-zA-Z]+$/
	
	if(memailj.test(memail)){
		
		$.ajax({ 
			url : "/jspweb/MemberFindController" , 
			method:"get" , 
			data : {"type" : "memail", "data" : memail} , 
			success : r => { 
				if(r == true){emailcheckbox.innerHTML = '이메일 중복'
					document.querySelector('.authReqBtn').disabled = true;
				}
				else {
					emailcheckbox.innerHTML = '이메일 가능' 
					document.querySelector('.authReqBtn').disabled = false;
				}
			} ,
			error : e => { console.log('통신실패'); }
		})
		
		//emailcheckbox.innerHTML='o'
	}else{
		emailcheckbox.innerHTML='알맞는 형식의 이메일을 적어주세요'
		document.querySelector('.authReqBtn').disabled = true;
	}
	
}

function authReq() {
	console.log('인증요청');
	
	let authbox = document.querySelector('.authbox')
	
	let html = `
		<span class="timebox"> 02:00 </span>
		<input class="ecode" type="text"/>	
		<button onclick='auth()' class="" type="button">인증</button>  <br/>
	`
	authbox.innerHTML = html;
	authcode = '1234';
	timer = 10;
	
	settimer();
}

let timer = 0;
let timerIntar;
let authcode;

function settimer() {
	//setInterval( () => {console.log('ㅎㅇ')}, 1000);
	timerIntar = setInterval(() => {
		
		let m = parseInt(timer/60);
		let s = parseInt(timer%60);
		m = m < 10 ? "0" + m : m;
		s = s < 10 ? "0" + s : s;
		
		document.querySelector('.timebox').innerHTML = `${m}:${s}`; // 현재 인증 시간 html 대입
		timer--;
		
		if(timer < 0) {
			// 1. setInterval 종료 
			clearInterval(timerIntar)
			// 2. 인증실패 알림
			document.querySelector('.emailcheckbox').innerHTML = '인증 실패'
			// 3. authbox 다시 숨기기
			document.querySelector('.authbox').innerHTML = ''
		}
		
	}, 1000)
}

function auth() {
	console.log('인증')

	let ecode = document.querySelector('.ecode').value;
	
	if(authcode == ecode) {
		document.querySelector('.emailcheckbox').innerHTML = '인증코드 일치'
		clearInterval(timerIntar)
		document.querySelector('.authbox').innerHTML = ''
	}else{
		document.querySelector('.emailcheckbox').innerHTML = '인증코드 불일치'
	}
}


// 1. 회원가입 메소드
function signup(){
	
	// 1. HTML에 가져올 데이터의 tag객체 호출 [ DOM객체 : html 태그를 객체화 ]
	let midInput = document.querySelector('.mid'); 
	let mpwdInput = document.querySelector('.mpwd'); 
	let mpwdconfirmInput = document.querySelector('.mpwdconfirm'); 
	let memailInput = document.querySelector('.memail'); 
	let mimgInput = document.querySelector('.mimg'); 
	
	// 2. (객체화)
	let info = { // 인증코드(유효성검사 위한) , 패스워드확인(유효성검사 위한) : DB 넣을 필요가 없는 데이터 
		mid : midInput.value , 
		mpwd : mpwdInput.value , 
		memail : memailInput.value , 
		mimg : mimgInput.value 
	}
	// 3. 유효성검사
	
	// 4. AJAX메소드를 이용한 Servlet 와 통신 
	$.ajax({ 
		url : "/jspweb/MemberInfoController" , 
		method:"post" , 
		data : info , 
		success : r => { console.log('통신성공'); } ,
		error : e => { console.log('통신실패'); }
	})
		// 5. Servlet 의 응답에 따른 제어 
	
}

