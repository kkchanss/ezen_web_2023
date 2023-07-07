
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