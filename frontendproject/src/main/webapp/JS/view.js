

 //1. list.js에서 클릭된 게시물 번호 호출 [세션]
 let no = sessionStorage.getItem('no'); // 내가 지금 보고있는 것 
 let boardList = JSON.parse(localStorage.getItem('boardList'));
 console.log (boardList)
 //2. 클릭된 게시물번호의 게시물을 찾아서 출력해 줄것 
 onView()
 function onView(){
	 // 식별자 : 인덱스, 게시물 = 인덱스숫자 찾기 
	 
	 //1. 어디에 [ h, p, div ]
	 let title = document.querySelector('.title')
	 let writerdate = document.querySelector('.writerdate')
	 let content = document.querySelector('.content')
	 
	 //2. 무엇을??
	 //1. 해당하는 게시물번호의 게시물 찾기
	 for( let i = 0 ; i<boardList.length; i++){
		 let b = boardList[i] // i번째 게시물을 꺼내기 
		 if(b.no == no){
			 //만약에 i번째 게시물 번호와 클릭된 게시물 번호가 같으면
			 console.log (b);
			 //3. 대입
			 title.innerHTML = b.title;
			 writerdate.innerHTML = `작성자 : ${b.writer} 작성일 : ${b.date}`;
			 content.innerHTML = b.content;
			 break;
		 }
	 }
 }
 
 
 
 //삭제하기 함수 [ 실행조건 : 삭제하기 버튼을 눌렀을때 ]
 function onDelete ( ){// 인수를 받아올 필요는 없다, 원래는 삭제할 번호(식별자)가 필요한데 전역변수가 있어서 필요없음, 현재 보고 있는 게시물이라서!
	 //1. 현재 삭제할 게시물 찾기
	 for ( let i = 0 ; i <boardList.length ; i++){
		 //2. 클릭된 게시물(현재 보고 있는 게시물)이 i번째 게시물과 같은지
		 if( no == boardList[i].no ){
			 //3. 삭제하기
			 boardList.splice( i , 1 );
			 	// 배열에 변화된 결과를 쿠키에 반영 시켜야함. 쿠키는 스크립트의 메모리가 아니기 때문에 자동으로 되지 않음.
			 	localStorage.setItem('boardList', JSON.stringify(boardList))
			 	// 클릭되었던 게시물이 삭제되면 클릭된 게시물 번호가 저장된 세션도 삭제
			 	sessionStorage.removeItem('no')
			 	// 페이지 전환하기 
			 	location.href="list.jsp"
			 //4. 삭제후 다음 인덱스는 확인할 필요가 없다.
			 break;
		 }
	 } 
 }
 

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 