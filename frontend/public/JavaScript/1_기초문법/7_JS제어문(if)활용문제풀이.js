/*
 조건 : 반복문X 입력:prompt 출력 : console 
       문제 1 : 2개의 정수 를 입력받아서 가장 큰수를 출력 
       문제 2 : 3개의 정수 를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
       문제 3 : 4개의 정수 를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
       
       문제 4 : 3개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       문제 5 : 4개의 정수 를 입력받아서 오름차순 / 내림차순 출력 
       
       문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
       문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
                            80점이상 B등급 출력 
                            70점이상 C등급 출력  
                            그외 재시험
       문제 8 : 아이디와 비밀번호 입력받기 
             회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
                                     아니면 로그인실패 출력
 */

 
// 문제 1 : 2개의 정수를 입력받아서 가장 큰수를 출력 
let 정수1 =Number(prompt('정수1 입력 :'));
let 정수2 =Number(prompt('정수2 입력 :'));
if(정수1>정수2) console.log('가장 큰수 : '+ 정수1);
if(정수2>정수1) console.log('가장 큰수 : '+ 정수2);

/* 선생님 정답
	- 정수 2개 입력 받기
	let value1 = Number(prompt('정수1 :'));
	let value2 = Number(prompt('정수2 :'));
	- if 이용한 논리제어
	if(value1 > value2) {console.log(value1)}
	else{console.log (value2)}
	
	1. 첫번째 값을 입력받기				- Number(prompt('정수1 :')				
	2. 입력받은 값을 변수에 저장 			- let value1 =
	3. 두번째 값을 입력받기 				- Number(prompt('정수2 :')
	4. 입력받은 값을 변수에 저장 			- let value2 =
	5. 가장큰수?? 를 구해야 한다 비교/연산/조건/ 판단 -> 연산자 	- value1 > value2
	6. 연산자를 선택하기 (> < >= <=)
	7. if를 이용한 출력
*/

// 문제 2 : 3개의 정수를 입력받아서 가장 큰수를 출력     [ max 함수 x ]
let 정수3 = Number(prompt('정수3 입력 :'));
let 정수4 = Number(prompt('정수4 입력 :'));
let 정수5 = Number(prompt('정수5 입력 :'));
if(정수3>정수4);
if(정수3>정수5) console.log('가장 큰수 : '+ 정수3);
	if(정수4>정수3);
	if(정수4>정수5) console.log('가장 큰수 : '+ 정수4);
		if(정수5>정수3);
		if(정수5>정수4) console.log('가장 큰수 : '+ 정수5);
		
/* 선생님 정답
	let value3 = Number(prompt('정수3 :'));
	let value4 = Number(prompt('정수4 :'));
	let value5 = Number(prompt('정수5 :'));
	let max1 = value3;
	if(max1 < value4) {max1 = value4}
	if(max1 < value5) {max1 = value5}
	console.log(max1)
*/
					
// 문제 3 : 4개의 정수를 입력받아서 가장 큰수를 출력    [ max 함수 x ]
let 정수6 = Number(prompt('정수6 입력 :'));
let 정수7 = Number(prompt('정수7 입력 :'));
let 정수8 = Number(prompt('정수8 입력 :'));
let 정수9 = Number(prompt('정수9 입력 :'));
if(정수6>정수7);
if(정수6>정수8);
if(정수6>정수9) console.log('가장 큰수 : '+ 정수6);
	if(정수7>정수6);
	if(정수7>정수8);
	if(정수7>정수9) console.log('가장 큰수 : '+ 정수7);
		if(정수8>정수6);
		if(정수8>정수8); 
		if(정수8>정수9) console.log('가장 큰수 : '+ 정수8);
			if(정수9>정수6);
			if(정수9>정수7); 
			if(정수9>정수8) console.log('가장 큰수 : '+ 정수9);

/* 선생님 정답
	let value6 = Number(prompt('정수6 :'));
	let value7 = Number(prompt('정수7 :'));
	let value8 = Number(prompt('정수8 :'));
	let value9 = Number(prompt('정수9 :'));
	let max2 = value6;
	if(max2 < value7) {max2 = value7}
	if(max2 < value8) {max2 = value8}
	if(max2 < value9) {max2 = value9}
	console.log(max2)
*/

// 문제 4 : 3개의 정수를 입력받아서 오름차순 / 내림차순 출력 

/* 선생님 정답
	let int1 = Number(prompt('정수1 :'));
	let int2 = Number(prompt('정수2 :'));
	let int3 = Number(prompt('정수3 :'));
	- 정렬 : 하나씩 비요해서 자리를 교체
	if(int1 > int2){  //* 조건1  >오름차순  <내림차순
		let temp = int1; // 변수하나를 잠깐 가져온듯... 임시변수에 int1 저장
		int1 = int2;
		int2 = temp;
	}
	if(int1 > int3){  //* 조건2
		let temp = int1;
		int1 = int3;
		int3 = temp;
	}
	if(int2 > int3){  //* 조건3
		let temp = int2;
		int2 = int3;
		int3 = temp;
	}
	console.log(int1+''+int2+''+int3)
*/

// 문제 5 : 4개의 정수를 입력받아서 오름차순 / 내림차순 출력 

let int1 = Number(prompt('정수1 :'));
let int2 = Number(prompt('정수2 :'));
let int3 = Number(prompt('정수3 :'));
let int4 = Number(prompt('정수4 :'));
	if(int1 > int2){
		let temp = int1
		int1 = int2
		int2 = temp
	}
	if(int1 > int3){
		let temp = int1
		int1 = int3
		int3 = temp
	}
	if(int1 > int4){
		let temp = int1
		int1 = int4
		int4 = temp
	}
	if(int2 > int3){
		let temp = int2
		int2 = int3
		int3 = temp
	}
	if(int2 > int4){
		let temp = int2
		int2 = int4
		int4 = temp
	}
	if(int3 > int4){
		let temp = int3
		int3 = int4
		int4 = temp
	}
	console.log(int1+''+int2+''+int3+''+int4)


// 문제 6 : 점수를 입력받아 점수 90점이상 합격 출력 아니면 탈락 출력 
let 점수1 = Number(prompt('점수1 : '))
if(점수1 >= 90) console.log('합격')
	else console.log('탈락')
	
	
// 문제 7 : 점수를 입력받아 점수 90점이상 A등급 출력 
//                        	80점이상 B등급 출력 
//                       	70점이상 C등급 출력  
//                          그 외 재시험
let 점수2 = Number(prompt('점수2 : '))
if(점수2 >= 90) {console.log('A등급');}
else if(점수2 >= 80) {console.log('B등급');}
else if(점수2 >= 70) {console.log('C등급');}
else {console.log('재시험');}


// 문제 8 : 아이디와 비밀번호 입력받기 
//         회원아이디가 admin 이고 비밀번호가 1234 이면 로그인 성공 출력 
//                                      	아니면 로그인 실패 출력
let 아이디 = prompt('아이디 : ')
let 비밀번호 = Number(prompt('비밀번호 : '))
if (아이디 == 'admin'){
	if (비밀번호 == 1234) {console.log ('로그인 성공')}
} else {console.log ('로그인 실패')}


/* 선생님 정답
let id = prompt('아이디 : ')
let pw = prompt('비밀번호 : ')
if (id == 'admin'){
	if (pw == 1234) {
		console.log ('로그인 성공');
	}
	else{
		console.log ('로그인 실패 : 비밀번호가 일치하지 않습니다.');
	}
} else {
	console.log ('로그인 실패 : 아이디가 일치하지 않습니다.');
}
*/

//이클립스* 기준으로 컨트롤+쉬프트+f : 코드 탭간격 자동 맞춤 












