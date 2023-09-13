/*
	변수
		지역변수 : 지역{}에서 태어났으면 지역 박으로 못 나감
			{안산}에서 태어났으면 안산 밖으로 못 나감
			-> {}안에서 선언된 변수는 {} 밖으로 못나감 ! 안으로는 가능 
		전역변수 : 지역{}밖에서 태어났으면 자유롭게 이동가능
			대한민국에서 태어났으면 {안산}도 갈수 있고 {수원}에도 갈수 있음
			-> {}밖에서 선언된 변수는 {} 안으로 이동가능 !
	문자열내 변수/배열/객체 를 포함하는 방법 [ JS 안에서 HTML 작성시 문자처리 ]
		1. 작은 따옴표 (연결연산자를 이용) => '<td>'+변수명/배열명+'</td>'
		2. 백틱(`${}`) => `<td>${변수명/배열명}</td>`
						 `<td>${함수명}</td>`
*/


// 스크립트가 잘 작동하는지 확인.
console.log('8_JS배열의활용2.js 실행');

//4. 배열 선언
let 방문록배열 = []; // .내용배열 ★여럿 함수에서 사용하기 때문에 함수 밖에 선언★
		// 인덱스 = 배열내 저장된 순서 번호
let 방문록배열2 = []; // .작성자배열

// 1. 이벤트 함수 만들기
function 등록(){ // 함수 시작
	//1. 함수가 잘 작동하는지 체크!!
		console.log('등록함수 실행');
		
	//2. <input> 태그 호출
		let contentInput = document.querySelector('.content')
		console.log (contentInput); //호출이 잘 되었는지 체크!!
		
	//3. 입력받은 값 호출
		let value = contentInput.value;
		console.log ( value); //입력값이 잘 들어왔는지 체크!!
		
	//4. 배열을 등록을 하고 싶어 ! 함수밖에 먼저 빈 배열 선언함 ! 빈 배열이 함수의 위나 아래나 어디든 상관없는데 함수 안에 있는건 x
		방문록배열.push( value );
		console.log ( 방문록배열 ); // 배열에 잘 들어왔는지 체크!!
		방문록배열2.push( document.querySelector('.writer').value );
		console.log ( 방문록배열2 );
		
	//5. HTML에 배열 출력
		//1. 전체
		let contentTable = document.querySelector('.contentTable')
		console.log ( contentTable );
		
		//2. 이너
		let tableHTML =	contentTable.innerHTML
		console.log ( tableHTML );
		
		//3. innerHTML 내용 ★추가 +=★
		//tableHTML += '<tr><td>' +방문록배열[0] +'</td><td></td></tr>' 이렇게 하면 0번 위치에 있는것만 출력이 된다.
			// 그렇다고 숫자를 막 늘려서 적어놓으면 빈칸에 이상한게 출력됨. 그래서 배열내 존재하는 인덱스 까지만 출력하고 싶음.
			// 반복문 for을 이용한 0번 인덱스부터 마지막 인덱스까지 1개씩 출력
			// 0번 부터(초기값) ; 마지막 인덱스까지 (조건) ; 1개씩 (증감식)
			
		//방법 1)  
				for ( let i = 0; i < 방문록배열.length ;  i++ ){
				tableHTML += `<tr><td>${방문록배열[i]}</td><td></td></tr>`
				}
		//방법 2)  tableHTML += `<tr><td>${방문록배열[ 방문록배열.length-1]}</td><td></td></tr>`*/
			  	
				
		console.log ( tableHTML );
		//4. 추가된 HTML 내용 (=) 대입
		contentTable.innerHTML = tableHTML
	
} // 함수 끝













