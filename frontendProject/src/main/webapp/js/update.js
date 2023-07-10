console.log('write js 실행');

// 1. 썸머노트 실행할때 사용되는 코드
$(document).ready(function() {
	$('#summernote').summernote({
		lang : 'ko-KR',
		height: 500, 
		placeholder: "여기에 내용작성"
		
	});
});

// 2. 수정한 게시물 = 클릭한 게시물 = 현재 보고있는 게시물 [ 게시물 번호는 = 세션 ]
let no = sessionStorage.getItem('no');
let boardList = JSON.parse(localStorage.getItem('boardList'));

onView();
function onView() {
	// 1. 어디에
	let title = document.querySelector('.title');
	//let writerdate = document.querySelector('.writerdate');
	let content = document.querySelector('#summernote');
	
	// 2. 무엇을 [ 클릭된 게시물의 정보 1개 ]
	for(let i = 0; i < boardList.length; i++) {
		let b = boardList[i];
		if(b.no == no) {
			// 3. 출력/대입
			title.value = b.title;
			content.value = b.content;
			break; // 반복문 끝
		}
	}
	
}

// 3. 수정 함수 [ 실행조건 : 등록 버튼을 클릭했을 때 ]
function onUpdate() {

	let title = document.querySelector('.title');
	let content = document.querySelector('#summernote');
	
		// 2. 무엇을 [ 클릭된 게시물의 정보 1개 ]
	for(let i = 0; i < boardList.length; i++) {
		let b = boardList[i];
		if(b.no == no) {
			// 3. 출력/대입
			boardList[i].title = title.value;
			boardList[i].content = content.value;
			localStorage.setItem('boardList', JSON.stringify(boardList));
			location.href="view.jsp"
			break; // 반복문 끝
		}
	}
	
}
