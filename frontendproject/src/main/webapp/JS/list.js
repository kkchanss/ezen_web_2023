
console.log (' list JS 실행')




//1. 쿠키에 있는 배열 호출 [ 실행조건 : 게시판 페이지가 열리면 ]
let boardList = JSON.parse(localStorage.getItem('boardList'));
	// 쿠키/세션이 저장된 객체, 배열 호출시 JSON.parse()
	// 쿠키/세션이 저장된 객체, 배열 저장시 JSON.stringify()
	
 if( boardList == null ){ boardList = [] }// 만약에 boardList가 없으면 빈 배열 선언하기 



boardPrint()
//1. 게시물 출력함수
function boardPrint(){
	//1. 어디에
	let tcontent = document.querySelector('.tcontent')
	//2. 무엇을
	let html = ``;
		//html 구성
		for( let i = 0 ; i < boardList.length ; i++ ){
			let board = boardList[i]; // i번째 게시물 호출
			html += `<tr>
						<td> ${ board.no } </td> <td onclick="onviewLoad(${board.no})"> ${ board.title } </td> <td> ${ board.writer } </td> <td> ${ board.date } </td>
						<td> ${ board.view } </td> <td> ${ board.like } </td> 
					</tr>`
		}
	//3.
	tcontent.innerHTML = html;
}
	
//2. 게시물 이동함수 
// 실행조건 : 클릭한 게시물 제목
//누구의? 상세페이지?
function onviewLoad( no ){ // 인수는 클릭한 제목의 번호가 들어온다.
	console.log ( '현재 클릭된 게시물의 번호 :' + no )
	// 클릭된 결과를 다른 페이지로 옮기는 방법
		// JS는 페이지과 전환 되거나 새로고침 되면 초기화 된다. 
		// 백엔드가 없는 지금은 세션이나 쿠키를 사용해서 데이터를 브라우저에 저장 해야함.
	//1. 클릭된 게시물 번호 세션에 저장 
	sessionStorage.setItem( 'no',no )
	
	increaseView(no)
	
	//2. 페이지 이동
	location.href="view.jsp"
}

//3. 조회수 증가 함수 [ 실행조건 : 제목 클릭 후 페이지 전환 전에 ]
function increaseView( no ){
	for( let i = 0 ; i < boardList.length ; i++ ){
		if ( boardList[i].no == no ){
		boardList[i].view++;
		// 만약에 세션과 쿠키를 사용중이라면 .... 업데이트 
		// 배열에 변화된 결과를 쿠키에 반영 시켜야함. 쿠키는 스크립트의 메모리가 아니기 때문에 자동으로 되지 않음.
		localStorage.setItem('boardList', JSON.stringify(boardList))
		break;
		}
	}
}







