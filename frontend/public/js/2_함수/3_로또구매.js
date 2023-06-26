/*
	1. 로또구매 버튼 클릭해서 실행
	2. 1~45개 버튼 화면에 표시
	3. 6개 버튼 선택 ( 중복 불가능 ) / 구매취소 
   	4. 6개 숫자 모두 선택시 추첨결과 버튼 활성화 / 유효성검사 
   	5. 당첨번호 = 자동 난수(랜덤) 6개
   	6. 선택한 6개 숫자와 당첨번호6개와 비교해서 결과
 */

console.log('js 실행')

let lotto_list = []
let 추첨_list = []
 // 1. 로또 구매 함수 정의 [실행 조건 : 로또 버튼 클릭 시]
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
	 
	 if(lotto_list.length == 6) {
		 alert('이미 6개를 선택하셨습니다.')
		 return;
	 }
	 
	 if(lotto_list.includes(선택된번호)) {
		 console.log('이미 선택하신 번호입니다. 해당 번호를 삭제합니다.');
		 lotto_list.splice(lotto_list.indexOf(선택된번호), 1);  // 삭제
		 선택번호출력()
	 }
	 else{
		 console.log(선택된번호 + '숫자버튼을 클릭했군요.')
		 lotto_list.push(선택된번호)
		 선택번호출력()
	 }
 }
 
 // 3. 선택된 번호들을 출력하는 함수 [ 실행조건 : 배열에 변화가 있으면 (1. 추가 / 2. 삭제 / 3. 수정)]
function 선택번호출력() {
	document.querySelector('.선택번호출력구역').innerHTML = lotto_list;
	
	// 만약 모두 선택했으면
	if(lotto_list.length == 6) {
		document.querySelector('.추첨결과버튼구역').innerHTML =
		`<button onclick="추첨결과()" >추첨결과보기</button>`
	}
	
	// 모두 선택 안했으면
	else{
		document.querySelector('.추첨결과버튼구역').innerHTML = ''
	}
}

// 4. 추첨결과
function 추첨결과() {
	alert('로또 추첨합니다. [잠시 대기]')
	
	// 1. 난수 생성
	for(let i = 0; i < 6; i++) {
		let num = parseInt(Math.random()*45+1);
		if(추첨_list.includes(num)) i--;
		else {
			추첨_list.push(num);
		}
	}
 
 	console.log(추첨_list)
 	
 	// 4. 두 배열 비교 하기 [ 선택번호목록과 추첨번호목록]	
	let sum = 0;
		// 1. 배열과 for 활용
/*	for(let i = 0; i < 6; i++) {
		if(추첨_list.includes(lotto_list[i])) sum++;
	}*/
		// 2. 향상된 for문 [ for(let 반복변수명 in 배열명)]
/*	for(let 인덱스 in lotto_list) { // 자동으로 0번 인덱스부터 마지막 인덱스까지의 인덱스를 반복 변수에 대입
		console.log(인덱스)
	}*/	
		// 3. 향상된 for문 [ for(let 반복변수명 of 배열명)]
/*	for(let 데이터 of lotto_list) { // 자동으로 0번 인덱스부터 마지막 인덱스까지의 데이터를 반복 변수에 대입
		if(추첨_list.includes(데이터)) sum++;
	}*/
		// 4. for 라이브러리 [ 배열명.forEach() vs 배열명.map() vs filter() ]
						// 배열명.forEach((반복변수명)=>{실행문})
						// 배열명.forEach((데이터, 인덱스)=>{실행문})
	lotto_list.forEach((데이터, 인덱스)=> {  
		if(추첨_list.indexOf(데이터)!= -1) {sum++;}
	})
	
	if(sum == 6) {
		alert("맞은 갯수 : " + sum + "개, 등수 : " + 1 + "등")
	}
	else if(sum == 5) {
		alert("맞은 갯수 : " + sum + "개, 등수 : " + 2 + "등")
	}
	else if(sum == 4) {
		alert("맞은 갯수 : " + sum + "개, 등수 : " + 3 + "등")
	}
	else{
		alert("맞은 갯수 : " + sum + "개, 등수 : 순위 외")
	}
	// 2. 실수(소수점 있는) --> 정수(소수점 없는) : parseInt() : 실수->정수(소수점 버림)
/*	console.log(parseInt(Math.random()*45+1)) // 1~46 사이의 난수(실수-->정수) 생성
	console.log(추첨_list)*/
}