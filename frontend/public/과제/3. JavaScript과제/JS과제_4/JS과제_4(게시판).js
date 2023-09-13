console.log ('JS 실행')

let 글 = []

function 등록(){ // 등록함수 시작 -------------------------------------------------

	// 입력값 받아오기
	let user = document.querySelector('.write_user').value
	let pw = document.querySelector('.write_pw').value
	let title = document.querySelector('.write_title').value
	let body = document.querySelector('.write_body').value
	
		//유효성 검사 1
 		if( user == '' || pw == ''){
			alert('[등록실패] 작성자명과 비밀번호를 모두 입력해주세요.')
			return;
		 }
		//유효성 검사 2
		if( pw.length < 4 ){
			alert('[등록실패] 비밀번호를 4글자 이상 입력해주세요.')
			return;
		 }
		 
	/* 날짜 가져오기 */
	let today = new Date();
	let year = today.getFullYear();
	let month = ('0' + (today.getMonth() + 1)).slice(-2);
	let day = ('0' + today.getDate()).slice(-2);
	let dateString = year + '-' + month  + '-' + day;
	
	
	// 객체에 저장하기
	let content = { 
		작성자 : user, 
		비밀번호 : pw, 
		제목 : title, 
		내용 : body, 
		날짜 : dateString, 
		조회수 : 0 }	
	
	// 글 배열에 저장하기
	글.push(content); 
	
	// 입력칸에 값 초기화하기 
	document.querySelector('.write_user').value = ''
	document.querySelector('.write_pw').value = ''
	document.querySelector('.write_title').value = ''
	document.querySelector('.write_body').value = ''
	
	alert ( ' 등록되었습니다. ')
	
	출력();
	
} // 등록함수 끝


// 저장된 글 정보를 목록 페이지(HTML)에 출력
function 출력(){ // 출력함수 시작 -------------------------------------------------
	
	// 어디에 출력 할것인지
	let list_table = document.querySelector('.list_table')
	
	let HTML = `<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>`;
				
		// 글 배열안에 있는 객체에서 데이터 찾아오기
		for ( let i = 0; i < 글.length ;  i++ ){
		HTML += `<tr>
					<td> <button onclick="보기(${i})"> ${i+1} </button></td>
					<td> <button onclick="보기(${i})"> ${글[i].제목} </button></td>
					<td> <button onclick="보기(${i})"> ${글[i].작성자} </button></td>
					<td> ${글[i].날짜} </td>
					<td> ${글[i].조회수} </td>
				</tr>`;
		}
		
		
	// table 에 HTML 넣어주기 <table> </table>의 안에 !!
	list_table.innerHTML = HTML;
	
 } // 출력함수 끝
 

 function 보기(i){ // 보기함수 시작 -------------------------------------------------
	 console.log (' 보기함수 실행 ')
	 
	// HTML 넣어주기
	let view_div = document.querySelector('.view_div')
	let HTML = `제목 : ${글[i].제목} <br/>
	 			작성자 : ${글[i].작성자} <br/>
	 			내용 : ${글[i].내용} <br/>
	 			<button class="delete" onclick="삭제(${i})"> 삭제 </button>
	 			`;
	view_div.innerHTML = HTML;	 
	
	//조회수 증가 (구글링 겁나 했는데 길고 어려운 코드만 나오다가 이렇게 간단하게 할수 있는지 몰랐다...)
	글[i].조회수++
	
	출력();
	 
 } // 보기함수 끝 
 
 
 function 삭제(i){ // 삭제함수 시작 -------------------------------------------------
 	console.log ( ' 삭제함수 실행 ')
 	console.log (i)
 	console.log (글[i].작성자)
 	console.log (글[i].비밀번호)

 	let delete_pw = Number(prompt( '비밀번호를 입력하세요. '))
 	if ( delete_pw == 글[i].비밀번호 ){
		글.splice( i , 1)
		
		document.querySelector(`.view_div`).innerHTML = ''
 		alert ( ' 삭제되었습니다. ')
	
		출력();
		
	 }else { alert ( ' 비밀번호가 틀렸습니다. ') }
 	
 	return;
 	
	 
 } // 삭제함수 끝
 
 
 
 
 
 
  
 
 
 
 
 
 
 
 
 
 
 
 