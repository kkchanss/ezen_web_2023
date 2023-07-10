// 저장할땐 JSON.stringify
// 가져올땐 JSON.parse

let no = sessionStorage.getItem('no');
let boardList = JSON.parse(localStorage.getItem('boardList'));

console.log('list.js에서 저장된 세션정보 : ' + no);

// 2. 클릭된 게시물번호의 게시물 찾아서 출력
onView();
function onView() {
	
	let title = document.querySelector('.title');
	let writerdate = document.querySelector('.writerdate');
	let content = document.querySelector('.content');
	
	// 식별자 : 인덱스, 게시물번호=인덱스찾기
	// 1. 해당하는 게시물번호의 게시물 찾기
	for(let i = 0; i < boardList.length; i++) {
		let b = boardList[i];
		if(b.no == no) {
			// 만약에 i번째 게시물번호와 클릭된 게시물 번호와 같으면
			console.log(b);
			title.innerHTML = b.title;
			writerdate.innerHTML = ` 작성자 : ${b.writer}, 날짜 : ${b.date}`;
			content.innerHTML = b .content;
			break; // 반복문 끝
		}
	}
	
}

// 3. 현재 보고 있는 게시물 삭제하기 삭제하기 [ 실행조건 : 삭제하기 버튼을 클릭했을 때 ]
function onDelete() { // 인수? 삭제할 식별자x 전역변수에 있기 때문에

	// 1. 삭제할 게시물 찾기
	for(let i = 0; i < boardList.length; i++) {
		// 2. 클릭된 게시물(현재 보고 있는 게시물) 번호와 i번째 게시물과 번호가 같으면
		if(no = boardList[i].no) {
			// 3. 삭제하기
			boardList.splice(i, 1);
				// 배열에 변화된 결과를 쿠키[JS메모리 x]에 반영
			localStorage.setItem('boardList', JSON.stringify(boardList)); 
			sessionStorage.removeItem('no');
			// 페이지 전환
			location.href="list.jsp"
			// 4. 삭제 후 다음 인덱스는 확인할 필요가 없다.
			break; // 반복문 끝
		}
			
			
	}
	
	console.log('삭제되었습니다.');
}

function onUpdate(){
	location.href="update.jsp"
}