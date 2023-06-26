/*
	- 과제3 : 가계부 만들기 ( 과제3.HTML , 과제3.JS , 과제3.CSS )
요구사항
	- 1.배열 3개 사용 ( 날짜배열 , 항목배열 , 금액배열 )
	- 2.함수 3개 이상 정의해서 구현 
	- 3.총합계는 계산해서 테이블 가장 하단에 출력하시오.
	- 4.해당 삭제 버튼 클릭시 해당 항목 제거 
	- 5. 출력시 숫자를 천단위 쉼표로 출력하시오. [ toLocaleString() 함수( 천단위쉼표가 있는 문자열로 변환)  ]
		- let 금액 = 1200000
		- 금액.toLocaleString( ) => '1,200,000'
	- 6. css 적절하게 적당히 꾸며서 제출해주세요.

ex) 입력 예시 [ input 3개 사용 ]
	날짜 : <input type="date" />
	항목 : <input type="text" />
	금액 : <input type="text" />

ex) 출력 예시 [ table 사용 ]
	날짜		항목		금액		비고
	2023-06-06	콜라		300		<button>삭제</button>
	2023-06-05	노트북		1,200,000		<button>삭제</button>
	2023-06-03	교통비		1,750		<button>삭제</button>
		-총합계-			1,202,050	
  
 */


let days = [];
let items = [];
let moneys = [];
// 입력 받는 함수 
function input_func() {
	let day_in = document.querySelector('.day')
	let item_in = document.querySelector('.item')
	let money_in = document.querySelector('.money')
	
	// 비어있는 항목 체크
	if(day_in.value == '' || item_in.value == '' || money_in.value == ''){
		alert('비어있는 항목이 있습니다. 다시 입력해주시길 바랍니다.')
		day_in.value = ''
		item_in.value = '' 
		money_in.value = ''
		return;
	}
	
	// 값 저장 
	days.push(day_in.value);
	items.push(item_in.value);
	moneys.push(money_in.value);
	
	list_make();
	
	day_in.value = ''
	item_in.value = '' 
	money_in.value = ''
}

// 출력 함수
function list_make() {
	let lists = `<tr><th>날짜</th><th>항목</th><th>금액</th><th>비고</th></tr>`
	let list = document.querySelector('.list');
	let money_sum = 0;
	for(let i = 0; i < days.length; i++) {
		
		money_sum += parseInt(moneys[i]);
		lists += `<tr><td>${days[i]}</td><td>${items[i]}</td><td>${parseInt(moneys[i]).toLocaleString()}</td><td><button class="delete_btn" onclick="list_delete(${i})"> 삭제버튼 </button></td></tr>`
	}
	
	lists += `<tr><td colspan="3">총 합계</td><td>${money_sum.toLocaleString()}</td> </tr>`
	list.innerHTML = lists;
	
}

// 삭제 함수
function list_delete(d_num) {
	
	alert('삭제되었습니다')
	days.splice(d_num, 1);
	items.splice(d_num, 1);
	moneys.splice(d_num, 1);
	list_make();
}




 