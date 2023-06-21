/*

	-------------------------------------------------------------------
요구사항1 : 아이디와 비밀번호를 입력받아 회원가입을 진행하고 싶어요.
   [조건1] 
      입력 <input> 사용 해서 아이디 입력받기 
      입력 <input> 사용 해서 비밀번호 입력받기 
   [조건2]
      * 1차원배열만 사용 [ 배열 변수 여러개 사용 가능 ]
   [조건3]
      <input type="button"> 사용해서 회원가입 이벤트 실행 [ 회원가입함수 구현하기 ]

-------------------------------------------------------------------
요구사항2 : 아이디와 비밀번호를 입력받아 로그인 을 진행하고 싶어요.
   [조건1]
      입력 <input> 사용 해서 아이디 입력받기 
      입력 <input> 사용 해서 비밀번호 입력받기 
   [조건2] 
      만약에 배열에 존재하는 아이디,비밀번호가 일치한 데이터가 있을경우
      [ 로그인 성공 ] 아니면  [ 로그인 실패 ] alert 로 출력해주세요.
   [조건3]
      <input type="button"> 사용해서 로그인 이벤트 실행    [ 로그인함수 구현하기 ]
------------------------------------------------------------------------
요구사항3 : 유효성검사 진행해주세요.  
   1. 만약에 입력상자[input] 에 공백 이면 학번을 입력해주세요~       [ if( sno2Value == '' ) ]
   2. 회원가입 이나 로그인시 성공시에 입력상자[input] 의 value 다시 공백으로 초기화 해주세요.   [ sno2.value = '' ]
   3. 입력상자[input]에 입력한 아이디 와 비밀번호 가 8자리가 이상일경우에만 회원가입하도록 해주세요.   [ sno2Value.length !=8  ]

요구사항4 : 기본적인 css 작업해주세요
   1. (필수) div 2개를 만들어서 [ 왼쪽은 회원가입 구역 ] [ 오른쪽은 로그인 구역 ]
   2. 그외 이쁘게 꾸며주세요. 

 */

let idArr = [];
let pwArr = [];

function fjoin() {
	// 가져오기
	
	let idIn = document.querySelector('.idIn');
	let pwIn = document.querySelector('.pwIn');
	
	
	if(idIn.value == '') {
		alert('아이디를 입력해주세요')
	}
	else if(pwIn.value == '') {
		alert('패스워드를 입력해주세요')
	}
	else {
		if(idArr.indexOf(idIn.value) != -1 ) {
			alert('이미 있는 아이디입니다')
		}
		else if(pwArr.indexOf(pwIn.value) != -1 ) {
			alert('이미 있는 비밀번호입니다')
		}
		else {
			if(idIn.value.length < 8) {
				alert('아이디를 8자 이상으로 입력해주세요')
			}
			else if(pwIn.value.length < 8) {
				alert('비밀번호를 8자 이상으로 입력해주세요')
			}
			else{
				alert('회원가입 완료!')
				idArr.push(idIn.value);
				pwArr.push(pwIn.value);
			}
		}
	}
	
	idIn.value = ''
	pwIn.value = ''
}
 
function flogin() {
	// 가져오기
	
	let idOut = document.querySelector('.idOut');
	let idOut2 = idOut.value;
	let pwOut = document.querySelector('.pwOut');
	let pwOut2 = pwOut.value;
	if(idOut2 == '') {
		alert('아이디를 입력해주세요')
	}
	else if(pwOut2 == '') {
		alert('패스워드를 입력해주세요')
	}
	else{
		if(idArr.indexOf(idOut2) != -1) {
			if(pwArr.indexOf(pwOut2) != -1) {
				if(idArr.indexOf(idOut2) == pwArr.indexOf(pwOut2)) {
					alert('로그인 성공');
				}
				else{
					alert('아이디 혹은 비밀번호가 일치하지 않습니다.')
				}
			}	
			else{
				alert('비밀번호가 일치하지 않습니다.')
			}
		}
		else {
			alert('아이디가 일치하지 않습니다.' + idOut2 + ' test' + idArr)
		}
	}
	
	idOut.value = ''
	pwOut.value = ''
}
 