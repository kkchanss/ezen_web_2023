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

// 문제1
	// 1. 2개 입력받아 각 변수에 저장 
	// 2. 입력받은 값을 변수에 저장 
	// 3. 두번째 값을 입력받기
	// 4. 입력받은 값을 변수에 저장
let p1_num1 = +prompt('정수1 입력');
let p1_num2 = +prompt('정수2 입력');
let p1_max = 0;
	// 2. if 이용한 논리제어
if( p1_num1 > p1_num2) { p1_max = p1_num1}
else { p1_max = p1_num2 }
console.log(p1_max)

// 문제2
let p2_num1 = prompt('정수1 입력');
let p2_num2 = prompt('정수2 입력');
let p2_num3 = prompt('정수3 입력');

if(p2_num1>=p2_num2){
	if(p2_num1>=p2_num3) console.log(p2_num1)
	else console.log(p2_num3)
}
else if(p2_num2 >= p2_num3) console.log(p2_num2)
else console.log(p2_num3)

// 문제3
let p3_num1 = prompt('정수1 입력');
let p3_num2 = prompt('정수2 입력');
let p3_num3 = prompt('정수3 입력');
let p3_num4 = prompt('정수4 입력');

let p3_max = p3_num1;
if(p3_max < p3_num2) p3_max = p3_num2
if(p3_max < p3_num3) p3_max = p3_num3
if(p3_max < p3_num4) p3_max = p3_num4
/*if(p3_num1>=p3_num2 && p3_num1>=p3_num3 && p3_num1>=p3_num4) console.log(p3_num1) 
else if(p3_num2>=p3_num1 && p3_num2>=p3_num3 && p3_num2>=p3_num4) console.log(p3_num2) 
else if(p3_num3>=p3_num1 && p3_num3>=p3_num2 && p3_num3>=p3_num4) console.log(p3_num3)
else console.log(p3_num4)*/

// 문제4
let p4_num1 = prompt('정수1 입력');
let p4_num2 = prompt('정수2 입력');
let p4_num3 = prompt('정수3 입력'); 
// 정렬 = 하나씩 비교 해서 자리 교체
	// 만약에 첫번째 값이 두번째 값보다 크면 
if( p4_num1 > p4_num2) { // 조건1 : > 오름차순 < 내림차순
	// * 스왑 / 교체
	let temp = p4_num1; // 1. 임시변수에 3 저장
	p4_num1 = p4_num2; // 2. 3 있던 곳에 5 저장
	p4_num2 = temp; // 3. 5 있던 곳에 3 저장
}
if( p4_num1 > p4_num3) {
	let temp = p4_num1;
	p4_num1 = p4_num3;
	p4_num3 = temp;
}
if( p4_num2 > p4_num3) {
	let temp = p4_num2;
	p4_num2 = p4_num3;
	p4_num3 = temp;
}

// 문제6 
let score = +prompt('점수 : ')
if(score >= 90) { console.log('합격')}
else{ console.log('탈락')}

// 문제7
if(score >= 90) { console.log('A등급');}
else if(score >= 80) { console.log('B등급');}
else if(score >= 70) { console.log('C등급');}
else { console.log('재시험'); }

// 문제8 : 아이디와 비밀번호 입력 받기
let id = prompt('아이디 : ')
let pw = prompt('비밀번호 : ')
if(id == "admin" && pw == "1234") { console.log('로그인 성공!')}
else { console.log('일치하지 않습니다')}