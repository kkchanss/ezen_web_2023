
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
