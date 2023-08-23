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
vread();
// 1. Read ( 호출 )
function vread() {
   $.ajax({
      	url : "../VisitLogController" ,
      	method : 'get' ,
      	success: function(result){ 
			let visit_Bootom = document.querySelector('.visit_Bottom')
	        for(i=0;i<result.length;i++)
	        {
				console.log('test')
	          visit_Bootom.innerHTML += `
	           <div class="visitbox">
	               <div class="visitbox_top">
	                  <div> ${result[i].vwriter} </div>
	                  <div class="visitdate"> ${result[i].vday} </div>
	               </div>
	               <div class="visitbox_center"> ${result[i].vcontent} </div>
	               <div class="visitbox_bottom">
	                  <button type="button">수정</button>
	                  <button type="button">삭제</button>
	               </div>
	            </div>
	          `
	        }
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