console.log('hrm.js')

hrmread();

function hrmwrite(){
	
	/*let hname = document.querySelector('.hname').value;
	let hphone = document.querySelector('.hphone').value;
	let himg = document.querySelector('.himg').value;*/
	
	let hrmForm = document.querySelectorAll('.hrm_top')[0];
	console.log('hrmForm : ' + hrmForm);
	let hrmData = new FormData(hrmForm);
	console.log('hrmData : ' + hrmData);
	$.ajax({
		url : "/jspweb/HrmController" , 
		method: "post" ,			// form 객체 [ 대용량 ] 전송은 무조건 post 방식 
		data : hrmData ,			// FormData 객체를 전송 
		contentType : false ,		// form 객체 [ 대용량 ]  전송타입 		
		processData : false ,
		success : r => { 
			if(r) {
				console.log('저장 성공!');
				
			}
			hrmread();	
		} ,
		error : e => { console.log(e) } 
		
	});
	
}

function hrmread() {
		console.log('hrmread')
		$.ajax({
		url : "/jspweb/HrmController" , 
		method: "get" ,			
		success : r => { 
			let hrm_bottom = document.querySelector('.hrm_bottom');
			if(r) {
				hrm_bottom.innerHTML = '';
				for(let i = 0; i < r.length; i++) {
					hrm_bottom.innerHTML += `
						<div class="hrmbox">
							<div class="hrmbox_top">
								<div class="box_hname">${r[i].hname}</div>
								<div class="box_hposition">${r[i].hposition}</div>
								<div class="box_hphone">${r[i].hphone}</div>
							</div>
							<div class="hrmbox_bottom">
								<img class="box_himg" src="/jspweb/hrm/img/${r[i].himg}">
							</div>
						</div>
					`;
				}
			}
		} ,
		error : e => { console.log('오류 : ' + e) } ,
	})
}
