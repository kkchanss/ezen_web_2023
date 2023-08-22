console.log('visitlog.js 열림');

// 1. Create ( 저장 )
function vwrite() {
   
   // 1. HTML input 태그 호출 
   let vwriterInput = document.querySelector('.vwriter');
   let vpwdInput = document.querySelector('.vpwd');
   let vcontentInput = document.querySelector('.vcontent');
   // 2. 객체화 
   let info = {
      vwriter : vwriterInput.value,
      vpwd : vpwdInput.value,
      vcontent : vcontentInput.value
   }; console.log(info);
   // 3. 유효성검사 
   
   // 4. AJAX 
   $.ajax({
      url : "../VisitLogController" ,
      method : 'post' ,
      data :   info  ,
      success: function(result){ console.log(result ); },
      
   });
      // 5. 결과에 따른 코드 
   
} // f e

// 1. Read ( 호출 )
function vread() {
   $.ajax({
      	url : "../VisitController" ,
      	method : 'get' ,
      	success: function(result){ 
			
			
			console.log(result ); 
	  	},
      
   });
} // f e


// 1. update ( 수정 )
function vupdate() {
   
} // f e 


// 1. delete ( 삭제 )
function vdelete() {
   
} // f e 