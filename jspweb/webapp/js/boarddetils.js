boardDetilsPrint();
commentPrint();

// 읽기 
function boardDetilsPrint() {
	
	let bno = 0;
	bno = localStorage.getItem('bno');
	let categoryNumber = 0;
	categoryNumber = sessionStorage.getItem('categoryNumber'); 
	
	
 	$.ajax({
		url : "/subway/BoardController" ,
		method : 'get' ,
		data : {'bno' : bno, 'selectNo' : categoryNumber+1, 'resultType' : 'boardDetilsPrint' } ,
		success: function(result){ 
			
			let btitle = document.querySelector('.btitle');
			let bno = document.querySelector('.bno');
			let id = document.querySelector('.id');
			let bdate = document.querySelector('.bdate');
			let bcontent = document.querySelector('.bcontent');
			let hits = document.querySelector('.hits');
			let pname = document.querySelector('.pname');
			let stars = document.querySelector('.stars');
			
			if(categoryNumber == 0 || categoryNumber == 2) {
				 
				 btitle.innerHTML = `제목 : ${result.btitle}`;
				 bno.innerHTML = `게시물 번호 : ${result.bno}`;
				 id.innerHTML = `아이디 : ${result.id}`;
				 bdate.innerHTML = `작성일 : ${result.bdate}`;
				 bcontent.innerHTML = `내용 : ${result.bcontent}`;
				 hits.innerHTML = `조회수 : ${result.hits}`;
				
				
			}
			else if(categoryNumber == 1) {
				
				let num = result.stars;
					let sum = '';
					for(let i = 0; i < Math.floor(num); i++) {
						sum+='★';
					}
					let num2 = (num-Math.floor(num))*10;
					if(num2 > 4) {
						sum+='☆';
					}
				
				btitle.innerHTML = `${result.btitle}`;
				bno.innerHTML = `${result.bno}`;
				id.innerHTML = `${result.id}`;
				bdate.innerHTML = `${result.bdate}`;
				bcontent.innerHTML = `${result.bcontent}`;
				hits.innerHTML = `${result.hits}`;
				pname.innerHTML = `${result.pname}`;
		        stars.innerHTML = `${sum} ( ${num} / 5)`;         
		      
			}
			
			if(result.ishost) {
				let btn_group = document.querySelector('.btn-group');
				btn_group.innerHTML = `
					 <button class="btn btn-update" onclick="boardUpdate()">게시물 수정</button>
		       		 <button class="btn btn-delete" onclick="boardDelete()">게시물 삭제</button>
				`;
			}
		} // success end
	})
}

// 수정 
function boardUpdate() {
	
	location.href="/subway/jsp/boardupdate.jsp"
}

// 삭제
function boardDelete() {
   
    let bno = 0;
	bno = localStorage.getItem('bno');
   
    $.ajax({
      url : "/subway/BoardController",
      method : "delete",
      data : {'bno' : bno} ,
      success : function f(r){
        if(r == 'true') {
			alert('삭제 완료')
		}
        
        else 
        console.log('삭제 실패')
        } ,
      error : function f(r){console.log('boardDelete 에러'+r)}
   })
}

// 댓글 작성
function commentWrite() {
	
	let bno = 0;
	bno = localStorage.getItem('bno');
	let content = document.querySelector('.commentinput');
    $.ajax({
      url : "/subway/CommentsController",
      method : "post",
      data : {bno : bno, content : content.value} ,
      success : function f(r){
        if(r) {
			alert('댓글 작성 완료')
			content.innerHTML = '';
		}
        
        else console.log('댓글 작성 실패');
      
        commentPrint();
        } ,
      error : function f(r){console.log('commentWrite 에러'+r)}
   })	
	
}

// 댓글 보기 
function commentPrint() {
	
	let bno = 0;
	bno = localStorage.getItem('bno');
    $.ajax({
	  url : "/subway/CommentsController",
	  method : "get",
	  data : {bno : bno} ,
	  success : function f(r){
		  	
		  	console.log('comment Print : ' + r)
		  
			let comment_view = document.querySelector('.comment_view');
			let html = '';
			
			for(let i = 0;  i < r.length; i++) {
				html += `
					<div class="comment_box">
			    		<div class="comment_top">
			    			<span class="mno">${r[i].mid}</span>
			    		</div> 
			    		<div class="content">
			    			${r[i].content}
			    		</div>
			    		<div class="cdate">
			    			${r[i].cdate}
			    		</div>
	    			</div>
				`;
			}
			comment_view.innerHTML = html;
	  } ,
      error : function f(r){console.log('commentPrint 에러'+r)}
   })	
}