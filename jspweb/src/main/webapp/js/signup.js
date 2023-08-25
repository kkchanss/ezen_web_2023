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
			
			[a-z]
			[a-zA-Z]
			[a-zA-Z0-9]
			[ac]
			
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
		document.querySelector('.idcheckbox').innerHTML = '패턴 맞네'
		$.ajax({ 
			url : "/jspweb/MemberFindController" , 
			method:"get" , 
			data : { 'mid' : mid} , 
			success : r => { 
				if(r == true) document.querySelector('.idcheckbox').innerHTML = '아이디 중복'
				console.log('중복검사 : ' +r)
			} ,
			error : e => { console.log('통신실패'); }
		})
	
	}else{
		document.querySelector('.idcheckbox').innerHTML = '패턴 아니네'
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

