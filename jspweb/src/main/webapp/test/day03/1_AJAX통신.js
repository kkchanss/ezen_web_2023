// 예제1 
function 예제1() {

	$.ajax( { 
    	url : "/jspweb/Test06"  ,    // 1. 통신할 경로
      	method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      	data : {'value1' : 'jsdata'},
      	success : function 결과( result ){ console.log('서블릿 응답한 내용 : ' + result); },   // 3. 통신을 성공했을때 반환된 데이터
      	error : function 함수명(result) { console.log(result);}
   });
}

// 예제2
function 예제2() {
	// 1. 입력받은 데이터 가져온다.
	let nameData = document.querySelector('.name').value;
	let ageData = document.querySelector('.age').value;
	// 2. 객체화
	let info = {
		name : nameData,
		age : ageData 
	}
	$.ajax( { 
    	url : "/jspweb/Test07"  ,    // 1. 통신할 경로
      	method : "get",                               // 2. 통신할 HTTP 메소드 방식 
      	data : info,
      	success : function 결과( result ){ console.log(result); },   // 3. 통신을 성공했을때 반환된 데이터
      	error : function 함수명(result) { console.log(result);}
   });
}