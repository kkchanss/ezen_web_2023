
// 1.로그인된 회원의정보 호출
getInfo();
function getInfo(){
	$.ajax({
		url : "/jspweb/MemberInfoController" , 
		method : "get" , 
		data : { type : "info" } ,
		success : r => { 
			if( r == null ){ // 비로그인 상태 -> 페이지 차단
				alert('회원전용 페이지입니다.[로그인]페이지로 이동');
				location.href="/jspweb/member/login.jsp";
			}else{ // 로그인 상태 -> 마이페이지 구역에 정보 넣어주기 
				console.log(r)
				console.log('r.mimg : ' + r.mimg);
				document.querySelector('.preimg').src=`img/${r.mimg}`;
				document.querySelector('.mid').innerHTML = r.mid;
				document.querySelector('.memail').innerHTML = r.memail;
			}
		}
	});
} // f end 
// 2. 수정 
function mupdate(){
	console.log('mupdate');
	let form = document.querySelectorAll('.signupForm')[0];
		console.log(form);
	let formdata = new FormData(form);
	
	$.ajax({
		url : "/jspweb/MemberInfoController" , 
		method : "put" , 
		data : formdata,
		contentType: false, 
		processData: false,
		success : r => { 
			alert('수정 완료')
			location.href="/jspweb/index.jsp"
		},
		error : e => {
			alert(e)
		}
	});	
	
}

// 3. 탈퇴
function mdelete(){
	// 1. 탈퇴여부 확인    confirm() 확인true/취소false 버튼 알림창 
	let dconfirm = confirm('정말 탈퇴하시겠습니까?');
	// 2. 확인 버튼을 눌렀을때.
	if( dconfirm == true ){
		let mpwd = prompt('비밀번호 확인');
		// 3. ajax  [ 입력받은 패스워드 전송해서 로그인된 회원의 패스워드 와 입력받은 패스워드가 일치하면 탈퇴]
		$.ajax({
			url : "/jspweb/MemberInfoController" , 
			method : "delete" , 
			data : { mpwd : mpwd } ,
			success : r => { 
				if( r == true ){ // 비로그인 상태 -> 페이지 차단
					alert('탈퇴되었습니다.')
					logout();
				}else{ // 로그인 상태 -> 마이페이지 구역에 정보 넣어주기 
					alert('비밀번호가 다릅니다.')
				}
		}
	});
	}
}



