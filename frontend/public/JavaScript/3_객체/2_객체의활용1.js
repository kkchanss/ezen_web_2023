console.log ('JS 실행')
 
// 모든 함수에 접근할 수 있는 배열을 선언함 ! ( member 객체 여러개를 저장하는 선언 )
let 회원리스트 = []

// 요구사항 1. 등록함수 만들기 [ 실행 조건 : 회원가입 버튼을 클릭 했을때 ]
 function 등록(){ //회원가입 함수 시작
 	//1. 입력값 가져오기
 		//1. document.querySelector('.class')
 		//2. document.querySelector('#id')
 	let mid = document.querySelector('#mid').value
 	let mpwd = document.querySelector('#mpwd').value
 	
 		//유효성 검사 1
 		if( mid == '' || mpwd == ''){
			alert('[회원가입실패] 회원 정보를 모두 입력해주세요.')
			return;
		 }
		//유효성 검사 2
		if( mid.length < 8 || mpwd.length < 8){
			alert('[회원가입실패] 8글자 이상 입력해주세요.')
			return;
		 }
 	
 	//2. 객체에 담기 // 입력된 데이터(mid,mpwd) 를 {} 안에서 속성명을 부여해서 객체로 저장한다.
 	let member = { 아이디 : mid, 비밀번호 : mpwd }
	
	//3. 등록할(함수가 실행) 때마다 객체가 생성되고 '}' 가 끝나면 다 사라짐 = 지역변수의 특징을 가짐 
	// 함수 밖에 전역변수를 만들어서 저장하자 !! 객체 여러개 ( 배열 ) = 전역변수
	// * { } 안에서 선언된 객체를 전역 배열에 저장한다.
	회원리스트.push(member) ; 
	
	/* 입력칸 안에 내용 초기화 */
	document.querySelector('#mid').value = ''
	document.querySelector('#mpwd').value = ''
	
	
	/* ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
	 --> 위에 코드를 만약 줄여서 작성을 한다면
		회원리스트.push(
			{ 아이디 : document.querySelector('#mid').value,
		 	 비밀번호 : document.querySelector('#mpwd').value }
		);
	★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ */
	
 } //회원가입 함수 끝 mid, mpwd 는 초기화되어 사라짐 / 그러나 회원리스트는 전역변수로 살아있음 ! 
 
 
 
 // 요구사항 2. 로그인함수 만들기 [ 실행 조건 : 로그인 버튼을 클릭 했을때 ]
 function 로그인(){ // 로그인 함수 시작
	//1. 입력된 값을 가지고 온다.
	let mid2 = document.querySelector('#mid2').value
 	let mpwd2 = document.querySelector('#mpwd2').value
 	
 	//2. 입력된 값이 존재하는지 검사
 		// 회원리스트(전체)에서 회원 1명씩(1개씩) 꺼내서 검사하는데 아이디와 비밀번호가 일치 하는지 찾아야 한다.
 		
 	let login = false; // 로그인 상태 저장 함수 
 		
 	for ( let i = 0 ; i <회원리스트.length ; i++){
 		//i 는 0부터 회원리스트 마지막 인덱스 까지 1씩 증가 반복 
 		let member = 회원리스트[i]; // i번재 인덱스의 객체 1개 꺼내기
 		if( member.아이디 == mid2 ){ // i번째 객체의 아이디가 입력한 아이디와 같으면
			if( member.비밀번호 == mpwd2 ) {// i번째 객체의 비밀번호가 입력한 비밀번호와 같으면
				login = true; //i번째 객체는 로그인이 성공 했다는 증거를 변수에 저장.
				i =회원리스트.length; // 로그인 성공은 일회성 이기 때문에 로그인 성공지 다음 객체는 볼 필요가 없음. 반복분 종료 ! 
			 	break; // 반복문 강제 종료의 다른 방법으로는 해당 키워드 작서 ! ( 가장 가까운 for 에게 적용 ! )
			}
		}
	} // if 조건 2개 모두 충족 했을때 login 변수는 true 값으로 변경 
	
	// 판단 
	if( login == true ) alert ('로그인 성공');
	else alert ('로그인 실패')	
	
	
	/* 입력칸 안에 내용 초기화 */
	document.querySelector('#mid2').value = ''
	document.querySelector('#mpwd2').value = ''
	
 }// 로그인 함수 끝
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 