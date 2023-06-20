
// 1. 산술연산자
console.log('더하기 : ' + 10+3)
console.log('더하기 : ' + (10+3))
console.log('빼기 : ' + (10-3))
console.log('곱하기 : ' + (10*3))
console.log('나누기 : ' + (10/3))
console.log('나머지 : ' + (10%3))

/* 문제
	-문제1 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점 출력 , 평균 출력
   	-문제2 : prompt 함수 로 반지름 입력받아서 원넓이[ 반지름*반지름*3.14 ] 출력
   	-문제3 : prompt 함수 로 두 실수를 입력받아서 앞실수의 값이 뒤실수의 값의 몇%인지 출력
*/
	/* 문제1 */
	let language = +prompt('국어 점수를 입력해주세요');
	let english = +prompt('영어 점수를 입력해주세요');
	let math = Number(prompt('수학 점수를 입력해주세요'));
	let sum = (language+english+math);
	alert('총점 : ' + sum + ', 평균 : ' + sum/3);
	
	/* 문제2 */
	let r = prompt('반지름을 입력해주세요');
	alert('원넓이 : ' + r*r*3.14);
	
	/* 문제3 */
	let num1 = +prompt('실수1 입력');
	let num2 = +prompt('실수2 입력');
	let sum2 = num1+num2;
	alert('num1은 num2의 ' + ((num1/num2)*100) + '%퍼입니다');
	
// 2. 비교연산자
console.log('초과 : ' + (10>3)) // true
console.log('미만 : ' + (10<3)) // false
console.log('이상 : ' + (10>=3)) // true
console.log('이하 : ' + (10<=3)) // false
console.log('같다 : ' + (10==3)) // false
console.log('같지않다 : ' + (10!=3)) // true

// 3. 관계연산자
console.log('이면서 : ' + (10>3 && 20>15)) // 10은 3보다 크면서 20은 15보다 크다 // true and true
console.log('이면서 : ' + (10>3 && 20>30)) // true and false => false
console.log('이거나 : ' + (10>3 || 20>15)) // true or true => true
console.log('이면서 : ' + (10>3 && 20>30)) // true or false => true
console.log('부정 : ' + !(10>3)) // !true  => false

/*
	-문제4 : prompt 함수 로 정수를 입력받아 홀수[true] / 짝수[false] 여부 출력
    -문제5 : prompt 함수 로 정수를 입력받아 7배수이면 true / 아니면 false 출력
    -문제6 : prompt 함수 로 십만원 단위의 금액을 입력받아 지폐 개수 세기 
         356789      결과 : 십만원3장 만원5장 천원6장 
    -문제7 : prompt 함수 로 아이디와 비밀번호를 입력받아 아이디가 admin 이고 비밀번호가 1234 와 일치하면 
         결과 : true 출력 아니면 false 출력 
    -문제8 : prompt 함수로 정수를 입력받아 홀수 이면서 7배수이면 true 아니면 false 출력
*/

// 문제4
let problem4 = prompt('문제4 : 정수 입력');
if(problem4 % 2 == 0) alert(problem4 + '은 짝수입니다.');
else alert(problem4 + '은 홀수입니다.');

// 문제5
let problem5 = prompt('문제5 : 정수 입력');
alert('7배수 여부 : ' + (problem5 % 7 == 0));

// 문제6
let problem6 = prompt('문제6 : 돈 입력');
let mon1 = parseInt((problem6/100000));

// let mon2 = parseInt((problem6-(mon1*100000)/10000));
let mon2 = parseInt((problem6/10000%10));
// let mon3 = parseInt((problem6-(mon1*100000)-(mon2*10000)/1000));
let mon3 = parseInt((problem6/1000%10));
alert('십만원 ' + mon1 + '장 만원' + mon2 + '장 천원' + mon3 + '장');

// 문제7
let id = prompt('문제7 : 아이디 입력');
let pass = prompt('비번 입력');
alert('일치 여부 : ' + (id == 'admin' && pass == '1234'));

// 문제8
let problem8 = prompt('문제8 : 정수 입력');
alert('일치 여부 : ' + (problem8 % 2 == 0 && problem8 % 7 == 0));

// 4. 대입연산자
let 데이터1 = 10 // let키워드(변수)로 '데이터1' 이라는 변수명에 10을 저장했다.
console.log(데이터1) // 10
데이터1 += 10 // 10 + 10 => 20
console.log(데이터1) // 20
데이터1 -= 5 
console.log(데이터1)
데이터1 *= 2 
console.log(데이터1)

// 예제1
let html = '<h3> JS에서 작성된 HTML입니다. </h3>' // html언어를 문자열 안에서 작성한다.
html += '<p> 문단 추가했습니다 </p>'
document.write(html); // document.write()  // document:html문서, write:쓰다

// 5. 증감연산자 [ data+1, data+=1, data++]
let 데이터2 = 10
console.log('data : ' + 데이터2) // 10
console.log('data : ' + 데이터2++) // 10에서 1 증가 => 11? 10 [ 출력 후에 증가 ]
console.log('data : ' + 데이터2) // 11
console.log('data : ' + ++데이터2) // 12 [ 출력 전에 증가 ]
console.log('data : ' + 데이터2--) // 12 [ 출력 후에 감소 ]
console.log('data : ' + 데이터2) // 11
console.log('data : ' + --데이터2) // 10 [ 출력 전에 감소 ]

// 6. 삼항연산자 [ 조건 ? 참 : 거짓 (만약 조건이 true이면 참코드 실행 false 이면 거짓코드 실행) ]
	// 예제1
let 나이 = 38
let 연령구간 = 나이<=19 ? '청소년' : '성인'
console.log('38의 연령구간 : ' + 연령구간)

	// 예제2 [조건1 ? 참1 : 조건2? 참2 : 조건3? 참3 : 거짓]
let 점수 = 78
let 등급 = 점수 >= 90 ? 'A등급' : 점수 >= 80 ? 'B등급' : 점수 >= 70 ? 'C등급' : '탈락';
console.log('점수의 등급 : ' + 등급)

/*
	문제9 : 정수 2개를 입력받아 더 큰수 를 출력
   	문제10 : 정수 3개를 입력받아 가장 큰수 를 출력 
   	문제11 : 정수 3개를 입력받아 오름차순 으로 출력    [ 7 5 9 -> 5 7 9]
*/

let pro9_num1 = prompt('문제9 : 정수1 입력');
let pro9_num2 = prompt('문제9 : 정수2 입력');
console.log(pro9_num1 > pro9_num2 ? pro9_num1 : pro9_num2)

let pro10_num1 = prompt('문제10 : 정수1 입력');
let pro10_num2 = prompt('문제10 : 정수2 입력');
let pro10_num3 = prompt('문제10 : 정수3 입력');

let pro10_max = pro10_num1 // 1. max 변수에 첫번째 입력값 저장한다.
pro10_max = pro10_max < pro10_num2 ? pro10_num2 : pro10_max
pro10_max = pro10_max < pro10_num3 ? pro10_num3 : pro10_max 
console.log('세 정수 중 가장 큰수 : ' + max)
			
let pro11_num1 = prompt('문제10 : 정수1 입력');
let pro11_num2 = prompt('문제10 : 정수2 입력');
let pro11_num3 = prompt('문제10 : 정수3 입력');			
