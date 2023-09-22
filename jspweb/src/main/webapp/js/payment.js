
// 1. 포인트 사용 함수
function setPoint(mpamount, mpcomment){
	if(loginState == false) { return;}
	
	let returnData = false;
	$.ajax({
		url : "/jspweb/PointController",
		method : "post",
		async : false,
		data : { mpamount : mpamount, mpcomment : mpcomment},
		success : result => { console.log(result)
		returnData = result},
		error : e => { console.log(e)}
	})
	
	return returnData;
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

// 1. 아임포트 관리자 식별키
IMP.init('imp74472512') // 아임포트 콘솔에서 확인

// 2. 결제 함수 [ 속성은 PG사 별로 상이 ]
function requestPay() {
   
   // 2-1 : 만약에 결제방식을 선택하지 않았으면
   if( pay_method == '' ){
      alert('결제방식을 선택해주세요');
      return;
   }
   if(amount == 0) {
	   alert('결제 금액을 선택해주세요');
	   return;
   }
	// 2-2 : 주문번호 만들기
		// * 고유성/중복x/PK/식별키
		// 1. 날짜+상품코드+회원번호 조합해서 설계
		// 2. 회사전화번호+사업자번호 조합해서 설계
	let now = new Date(); // 현재 날짜
	let time = now.getTime(); // 현재 시간
	let merchant_uid = "p" + time + "-" + loginMid;
   
   IMP.request_pay({
      pg: "html5_inicis.INIBillTst",      // 아임포트 콘솔에서 확인
      pay_method: pay_method,
      merchant_uid: merchant_uid,   // 주문번호
      name: "포인트 결제",
      amount: amount,                         // 숫자 타입
      buyer_email: "gildong@gmail.com",
      buyer_name: "홍길동",
      buyer_tel: "010-4242-4242",
      buyer_addr: "서울특별시 강남구 신사동",
      buyer_postcode: "01181"
   }, function(rsp) { // callback
	   if (rsp.success) {
		   // axios로 HTTP 요청
		   axios({
			   url: "{서버의 결제 정보를 받는 endpoint}",
			   method: "post",
			   headers: { "Content-Type": "application/json" },
			   data: {
				   imp_uid: rsp.imp_uid,
				   merchant_uid: rsp.merchant_uid
			   }
		   }).then((data) => {
			   // 서버 결제 API 성공시 로직
		   })
	   } else {
		  
		   alert(`결제 성공`); 
		   
		   // 1. 포인트 적립 기능처리
		   setPoint(amount, '포인트결제');
	   	
	   		// 2. 결제내역 테이블 기능처리 [구현x]
	   }
   });
}

// 3. 결제 방식 선택 함수
let pay_method = ''      // 결제방식
function onPayMethod( method ){
   pay_method = method;
   
}
let amount = 0; // 결제 금액
function onAmount(value) {
	amount = value;
}