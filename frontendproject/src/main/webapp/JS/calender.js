console.log ( 'calender JS 실행' )

// 전역배열
let contents = [] // 여러개의 일정 객체를 저장하는 배열

//0. 현재 연도/월 [초기값]
	// new Date()			: 현재 날짜/시간 반환해주는 클래스
	// new Date(연도, 월, 일) : 사용자 정의 날짜 반환해주는 클래스 
		// .getFullYear()	: 연도
		// .getMonth()		: 월 [ 0 ~ 11 ]
		// .getDay()		: 요일 [ 일 0 ~ 토 6]
		// .getDate()		: 일
		// new Date( year, month, 0 ); -> 다음달 1일에서 -1 하면 현재월의 마지막 일수 구하기
let year = new Date().getFullYear(); // 현재 연도
let month = new Date().getMonth()+1; // 현재 월 [0~11] 그래서 +1하는것 ! 

console.log ( year )
console.log ( month )

//1. 현재 연도/월 기준으로 달력 출력 하는 함수 ---------------------------------------------------------------------
calPrint()
closeModal()
function calPrint(){
	console.log ( 'calPrint 함수 출력' )
	//1. 현재 연도와 월을 해당 구역에 출력하기
	document.querySelector('.caldate').innerHTML = `${year}년 ${month}월`
	//2. 요일과 일 출력하기
	/*
		1. 시작요일이 필요하다.
		2. 현재 월의 마지막 일이 필요하다. 
	*/
	// 현재 보고 있는 캘린더의 날짜
	let now = new Date( year, month-1, 1 );
	let sweek = now.getDay(); console.log (sweek)
	// 현재 월에 마지막 일 구하기
	let now2 = new Date( year, month, 0 );
	let eDay = now2.getDate(); console.log (eDay)
	
	let calender = document.querySelector('.calender')
	let html = ``;
		// 요일
		html += `<div class="week sunday"> 일 </div> <div class="week"> 월 </div>
			<div class="week"> 화 </div> <div class="week"> 수 </div>
			<div class="week"> 목 </div> <div class="week"> 금 </div> <div class="week"> 토 </div>`
		
		// ***** 현재 달력 1일의 요일까지 공백 출력 
		for( let b = 1; b<= sweek ; b++){
			html += `<div></div>`
		}
		
		// ***** 현재 달력 마지막일까지 일수 출력 
		for( let day = 1 ; day <= eDay ; day++){
			html += `<div onclick="openModal(${day})"> 
					${day} 
					${ contentPrint(`${year}-${month}-${day}`) }
					</div>`
					//만약에 현재 날짜와 일정 목록에 등록된 일정에 날짜와 같으면 출력
		}
	//3. 대입
	calender.innerHTML = html;
}

//6. 일정 출력함수 [ 실행조건 : 현재 날짜와 동일한 일정 날짜 찾아서 출력 ]---------------------------------------------------------------------
	// 인수란 함수안으로 들어오는 값이나 코드를 말하는 것인데 
	// 반환은 함수가 끝나고 호출했던곳으로 돌아가는 것을 말한다.
function contentPrint(date){
	console.log (date)
	console.log ('일정출력함수')
	let html = ``;
	for( let i = 0; i<contents.length; i++){
		if( date == contents[i].date ){
			html += `<span class="content" style="background-color:${contents[i].color}">
						${contents[i].content}
						</span>`
		}
	}
	return html;
}

//2. 버튼을 클릭했을때 현재 월 변화해주는 함수 ---------------------------------------------------------------------
function onNext(n){ // 함수 하나 만들어서 인수로 구분 !! (0)은 이전달, (1)은 다음달
	console.log(n)
	//1. 버튼 식별 후 월 증감
	if( n == 0 ){
		month--; // 현재 보고 있는 월에서 -1
		// 만약에 월이 차감 했는데 1보다 작아지면 12월로 변경하고 연도가 작아지기
		if( month < 1 ){month=12; year--;}
	}else if( n == 1){
		month++; // 현재 보고 있는 월에서 +1
		if( month > 12 ){month=1; year++;}
	}
	//2. 달력을 꼭 새로고침하기위해 프린트 호출  
	calPrint();
}


//3. 모달[팝업] 열기 [ 실행조건 : 날짜를 클릭 했을때 ]---------------------------------------------------------------------
function openModal(day){
	console.log ('openModal 함수 실행')
	document.querySelector('.modalwrap').style.display = 'flex';
	document.querySelector('.date').innerHTML = `${year}-${month}-${day}`;
}

//4. 모달[팝업] 닫기 [ 실행조건 : 닫기를 클릭 했을때 ]---------------------------------------------------------------------
function closeModal(){document.querySelector('.modalwrap').style.display = 'none';}


// 5. 일정 등록 버튼 클릭했을떄 [ 실행조건 : 등록버튼을 클릭했을때 ]---------------------------------------------------------------------

function onWrite(){
	// 1. 입력받은 값 호출 
	let color = document.querySelector('.color');
	let contentInput = document.querySelector('.contentInput');
	let date = document.querySelector('.date');
	// 2. 가공 [ 1.유효성검사 , 2.객체화 ] 
	let object = {
		color : color.value,
		content : contentInput.value ,
		date : date.innerHTML
	}
	// 3. 저장 
	contents.push( object );	
	// 4. 비워주기
	color.value= ''; contentInput.value=''; 
	// 5. 모달닫기
	closeModal()
	calPrint()
}
















