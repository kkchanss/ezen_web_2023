
console.log('write.js 실행')

// 썸머노트를 사용할때 사용되는 코드
	$(document).ready(function() {
	  // $('#summernote').summernote( {설정객체} );
	  $('#summernote').summernote( { 
		lang : 'ko-KR', // 한글 적용 [ 한글.JS CDN 필요]  
		height : 500 , 
		placeholder : '여기에 내용작성'
	  });
	});

/*
	JS는 HTML에 포함된 문서, 그래서 HTML가 우선이다.
	1. 해당 HTML이 새로고침되거나 페이지 전환이 되면 JS도 재 호출이 된다. -> 메모리가 휘발된다는 의미
	2. 영구적인 저장은 서버에서 한다 ! [ 서버 = DB ]
	3. 임시로 브라우저에 저장할 수 있다. 1. 세선 / 2. 쿠키 (단점은 오픈이라 보안의 문제가 있음, 보안 필요없는 데이터만 사용!) -> JS 새로고침해도 유지된다.
		세션(서버PC) : 모든 브라우저가 꺼지면 초기화 된다.
		쿠키(사용자PC) : 모든 브라우저나 윈도우같은 운영체제가 꺼져도 유지가 된다.
		-> 사용 방법 = JS에서 객체 제공 = 키와 값으로 이루어진 객체 
			- 문자 타입으로 저장이 된다., 숫자x, 배열x, 객체x
			sessionStorage : 세션
				sessionStorage.setItem('키',값)	: 해당 값을 '키'라는 이름으로 저장하는 것
				sessionStorage.getItem('키')		: 해당 키를 호출하면 저장된 값 호출 
				sessionStorage.clear()			: 삭제
			localStorage : 쿠키
				localStorage.setItem('키',값)
				localStorage.getItem('키')
				localStorage.clear()
			- JSON : JS 객체 문법으로 구조화된 데이터를 표현하기 위한 문자 기반의 포멧[형식]
				- 구조(모양)는 객체/배열 인데 포멧[형식/자료형/타입]
					└> 생긴건 객체 처럼 생겼는데 타입이 문자라는거임!!!!!!!!!!!!!!
					JS = { id: 'qwe', pw: '1234' }
					JSON = '{ id: 'qwe', pw: '1234' }'
				- 사용방법
					1. JSON.parse()			: 문자타입을 객체/배열 타입으로 변환 //* 나올때
					2. JSON.stringify()		: 객체/배열 타입을 문자타입으로 변환 //* 들어갈때
*/
let loginId = 'blue1234';

//1. 수정할 게시물 = 클릭된 게시물 = 현재 보고있는 게시물 [세션]
let no = sessionStorage.getItem('no');
let boardList = JSON.parse(localStorage.getItem('boardList'));



onView()
//2. 수정할 게시물을 출력해야한다.
function onView(){// f s 
	console.log ('onView 함수 실행')
	//1. 어디에 [ input, textarea]
	let title = document.querySelector('.title')
	let content = document.querySelector('#summernote')
	
	//2. 무엇을
	for( let i = 0 ; i<boardList.length ; i++){
		let b = boardList[i]
		if( b.no == no ){
			//3. 출력/대입
			title.value = b.title
			content.value = b.content
			break;
		}
	}	
}// f e 

//3. 수정함수 [실행조건 : 수정버튼을 클릭했을때]
function onUpdate(){ // f s 
	//누구를 == 현재 보고 있는 게시물
	for( let i = 0 ; i<boardList.length ; i++){
		let b = boardList[i]
		if( b.no == no ){
			//어떻게/새로운값 == 새로 입력받은 값
			let title = document.querySelector('.title').value;
			let content = document.querySelector('#summernote').value;
			//수정/대입
			b.title = title;
			b.content = content;
			// 쿠키나 세션 사용중이라면 삭제해야함.
			localStorage.setItem('boardList', JSON.stringify(boardList))
			// 클릭되었던 게시물이 삭제되면 클릭된 게시물 번호가 저장된 세션도 삭제
			sessionStorage.removeItem('no');
			// 페이지 전환하기 
			location.href="list.jsp";
			alert('수정하기 성공');
			break;
		}
	}
}// f e 
	






























