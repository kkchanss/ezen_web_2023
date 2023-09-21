
// 1. 포인트 사용 함수
function setPoint(mpamount, mpcomment){
	if(loginState == false) { return;}
	$.ajax({
		url : "/jspweb/PointController",
		method : "post",
		data : { mpamount : mpamount, mpcomment : mpcomment},
		success : result => { console.log(result)},
		error : e => { console.log(e)}
	})
}
// 2. 내 포인트 확인 함수
function getPoint(){
	if(loginState == false) { return;}
	$.ajax({
		url : "/jspweb/PointController",
		method : "get",
		data : { type : 1},
		success : result => { console.log(result)},
		error : e => { console.log(e)}
	})
}

function getPointList() {
	if(loginState == false) { return;}
	$.ajax({
		url : "/jspweb/PointController",
		method : "get",
		data : { type : 2},
		success : result => { console.log(result)},
		error : e => { console.log(e)}
	})
}