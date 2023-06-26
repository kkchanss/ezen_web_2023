/*
	1. 로또구매 버튼 클릭해서 실행
	2. 1~45개 버튼 화면에 표시
	3. 6개 버튼 선택 ( 중복 불가능 ) / 구매취소 
   	4. 6개 숫자 모두 선택시 추첨결과 버튼 활성화 / 유효성검사 
   	5. 당첨번호 = 자동 난수(랜덤) 6개
   	6. 선택한 6개 숫자와 당첨번호6개와 비교해서 결과
 */

console.log('js 실행')


 // 1. 로또 구매 함수 정의
 function 로또구매() {
	 console.log('로또구매() 실행 ');
	 // 1. 1~45개의 button 생성
	 let buttonHTML = ''
	 for(let i = 1; i <= 45; i++) { // f start
		 // i는 1부터 45까지 1씩 증가 반복
		 // 버튼 하나씩 변수에 추가
		 buttonHTML += `<button onclick="숫자버튼(${i})"> ${i} </button>` // i번째 버튼생성
		 // 인수 = i번째 출력된 숫자(1~45 사이 1개) 중 클릭된 숫자를 
		 // 만약에 i가 5의 배수이면
		 if(i % 5 == 0) buttonHTML += '<br/>' 
	 } // f end
	 
	 // 2. 
	 document.querySelector('.버튼목록구역').innerHTML = buttonHTML;
 } // f end
 
 // 2. 숫자(선택) 버튼 함수 정의
 function 숫자버튼(선택된번호) {
	 console.log(선택된번호 + '숫자버튼을 클릭했군요.')
 }
 