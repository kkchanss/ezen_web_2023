aread();
// 쓰기
function awrite() {
	
	let money = document.querySelector('.amoney');
	let day = document.querySelector('.aday');
	let content = document.querySelector('.acontent');
	
	let info = {
		'amoney' : money.value,
		'aday' : day.value, 
		'acontent' : content.value
	}
	
	$.ajax({
      url : "../AccountbookController" ,
      method : 'post' ,
      data :   info  ,
      success: function(result){ 
		  if(result == 'true') console.log('등록 성공');
		  else console.log('등록 실패')
		  aread();
	}
      
   });
}
// 읽기
function aread() {
	
	$.ajax({
      url : "../AccountbookController" ,
      method : 'get' ,
      success: function(result){ 
		  let outputDiv = document.querySelector('.outputDiv');
		  outputDiv.innerHTML = '' 
		  for(let i = 0 ; i < result.length; i++) {
			outputDiv.innerHTML += `<div class="accountbox">
	               <div class="accountbox_top">
	               	  <div class="accountmoney">금액 : ${result[i].amoney}원 </div>
	                  <div class="accountdate">날짜 : ${result[i].aday} </div>
	               </div>
	               
	               <div class="accountbox_center">내용 : ${result[i].acontent} </div>
	              
	               <div class="accountbox_bottom">
	                  <button onclick="aupdate(${result[i].ano})" type="button">수정</button>
	                  <button onclick="adelete(${result[i].ano})" type="button">삭제</button>
	               </div>
	         </div>`
		  }
		
	}
      
   });
} 
 
// 수정 
function aupdate(ano) {
	let acontent = prompt('수정할 내용:')
   
   let info = {
	  'ano' : ano,
      'acontent' : acontent
   }; 
   
    $.ajax({
      url : "../AccountbookController",
      method : "put",
      data : info ,
      success : function f(r){ 
		  if(r == 'true') console.log('수정 완료')
		  else console.log('수정 실패')
		   aread();
	  },
      error : function f(r){ console.log('vupdate 오류')}
   })
}

// 삭제
function adelete(ano) {
   
    $.ajax({
      url : "../AccountbookController",
      method : "delete",
      data : {'ano' : ano} ,
      success : function f(r){
        if(r == 'true')
        console.log('삭제 완료')
        else 
        console.log('삭제 실패')
        aread()
        } ,
      error : function f(r){console.log('삭제 에러'+r)}
   })
}


