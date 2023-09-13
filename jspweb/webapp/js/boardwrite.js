 
 let categoryNumber = sessionStorage.getItem('categoryNumber'); 
 
 
 console.log(categoryNumber)
 
 let title = document.querySelector('.write_title');
 
 if(categoryNumber == 0) {
	 console.log("1")
	 title.innerHTML = `공지사항 작성`;
 	
 }
 else if(categoryNumber == 1) {
	 console.log("2")
	 title.innerHTML = `리뷰 작성`	;
	 let starSelect = document.querySelector('.starSelect');
	 starSelect.innerHTML = `
	 		별점 : <select class="stars">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						
					</select>
	 `;
	 let menuSelect = document.querySelector('.menuSelect');
	 menuSelect.innerHTML = `
	 	메뉴 선택 : <select class="menus">
							<option> 에그마요 샌드위치 </option>
							<option> 참치 샌드위치 </option>
							<option> 햄 샌드위치 </option>
							<option> 쉬림프 샌드위치 </option>
							<option> 바비큐 샌드위치 </option>
							<option> 치킨데리야끼 샌드위치 </option>
							<option> 스테이크&치즈아보카도 랩 </option>
							<option> 쉬림프 에그마요 랩 </option>
							<option> 치킨 베이컨 미니 랩 </option>
							<option> 이탈리안 비엠티 샐러드 </option>
							<option> 비엘티 샐러드 </option>
							<option> 햄 샐러드 </option>
							<option> 풀드포크바비큐 샐러드 </option>
							<option> 스파이시 이탈리안 샐러드 </option>
							<option> 쉬림프 샐러드 </option>
						</select>
	 `;
 }else{
	 console.log("3")
	 title.innerHTML = `QnA 작성`;
 } 
 
 
 
 /* --------------------- 게시물 작성 ---------------------------- */
 function boardPost(){
	 
	
	let btitlewrite = document.querySelector('.btitlewrite').value;
	let bcontentwrite = document.querySelector('.bcontentwrite').value;
	
	 
	if(categoryNumber == 1) {
		let stars = document.querySelector('.stars').value;
		let menus = document.querySelector('.menus').value;
		
		console.log('menus : ' + menus);
		$.ajax({
		url : "/subway/BoardController" ,
		method : 'post' ,
		data : { 'btitlewrite' : btitlewrite , 'bcontentwrite' : bcontentwrite, 'categoryNumber' : categoryNumber, 'stars' : stars, 'menus' : menus } ,
		success: function(result){ alert('게시물 작성완료되었습니다.'); 
			location.href="/subway/jsp/board.jsp";
		},
		error: function(result){console.log('실패 ' + result)}
	});
	}
	else {
		$.ajax({
		url : "/subway/BoardController" ,
		method : 'post' ,
		data : { 'btitlewrite' : btitlewrite , 'bcontentwrite' : bcontentwrite, 'categoryNumber' : categoryNumber, 'stars' : -1, 'menus' : null} ,
		success: function(result){ alert('게시물 작성완료되었습니다.');
		location.href="/subway/jsp/board.jsp"; },
		error: function(result){console.log('실패 ' + result)}
		})
		
	}
	
	
}
 