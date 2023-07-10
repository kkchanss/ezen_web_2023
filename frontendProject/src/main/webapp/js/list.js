console.log('list')


// 게시판 리스트
let boardList = JSON.parse(localStorage.getItem('boardList'));
if(boardList == null) boardList = []; // 만약에 쿠키가 비어 있으면 비어 있는 배열 대입
boardPrint();
function boardPrint() {
	
	
	// 출력할 공간
	let tcontent = document.querySelector('.tcontent');
	
	// 출력할 변수
	let html = '';
	
	for(let i = 0; i < boardList.length; i++) {
		let board = boardList[i]; // i번째 게시물 호출
		html += `<tr> 
					<td> ${ board.no} </td> <td onclick="onViewLoad(${board.no})"> ${board.title} </td> <th> ${board.writer} </th>
					<td>${board.date} </td> <td> ${board.view} </td> <th> ${board.like} </th>
				</tr>`
	}
	// 대입	
	tcontent.innerHTML = html;
}

// 2. 상세 페이지로 이동 [ 실행조건 : 클릭한 게시물 제목 ]
function onViewLoad(no) { // 인수 : 클릭한 번호(게시물)의 번호
	console.log(' 현재 클릭된 제목(게시물)의 번호 : ' + no);
	// 클릭된 결과를 다른페이지로 옮기는 방법
		// JS는 페이지가 전환/새로고침 초기화 --> 세션/쿠키
	// 1. 클릭된 게시물번호 세션에 저장
	sessionStorage.setItem('no', no); // 클릭된 게시물번호 세션에 저장

	increaseView(no);
	
	// 2. 페이지 이동
	location.href = "view.jsp"
}

// 3. 조회수 증가 함수 [ 실행조건 : 클릭후 페이지 전환 전에]
function increaseView(no) {
	// 1. 클릭된 게시물번호의 게시물찾기
	for(let i = 0; i < boardList.length; i++) {
		if(boardList[i].no == no) { // 찾았다
			// 조회수 1 증가
			boardList[i].view++;
			// 만약에 세션/쿠키를 사용중 이라면 ..... 
			localStorage.setItem('boardList', JSON.stringify(boardList));
			break;
		}
	}
	alert('페이지이동')
}


