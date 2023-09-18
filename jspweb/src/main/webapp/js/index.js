

findByTop(10);

//findByPno(3);

//findByAll();

// 1. N개 제품들을 최신순으로 출력 함수 
function findByTop( count ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" , 
		data : { type: "findByTop" , count : count } ,
		success : jsonArray => {
			console.log( jsonArray ) ;
			let productBox = document.querySelector('.productBox')
			let html = '';
			
			jsonArray.forEach((p) => {
				// * 대표 이미지 출력하기 : [ 첫번째 이미지 ] / Object.keys(객체명)
				let firstImg = Object.values(p.imgList)[0];
				
				html += `
				 <div class="col">
				    <div class="card">
				      <img src="/jspweb/product/img/${firstImg}" class="card-img-top" alt="...">
				      <div class="card-body">
				        <h5 class="card-title">${p.pname}</h5>
				        <p class="card-text">
				        	<div>${p.pcontent}</div>
				        	<div>${p.pdate}</div>
				        </p>
				      </div>
				    </div>
				  </div>
				`
			})
			
			productBox.innerHTML = html;
		}
		
	})
}

/*
	
	자바스크립트 객체
		형태 : let 변수명 = { 속성명 : 데이터 , 속성명 : 데이터, 속성명 : 데이터 }
			- 데이터 : 데이터(상수/변수), 함수, 배열/리스트 등등
			삽입 : 객체명.새로운필드명 = 데이터
			삭제 : delete 객체명.삭제할속성명		* 사용자정의 함수(우리가 만드는 함수) 중에 delete 라는 이름으로 선언
			
	자바스크립트 배열/리스트
		형태 : let 변수명 = []
			배열명.push(데이터)
			배열명.splic(인덱스,개수)
			배열명[인덱스]
*/ 


// 2. 현재카카오지도내 보고있는 동서남북 기준내 제품들을 출력 함수 
function findByLatLng( east , west  ,  south  , north  ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" , 
		data : { type: "findByLatLng" 	, 
				east :  east , west  : west ,  
				south  : south , north  :  north  
				} ,
		success : jsonArray => { console.log( jsonArray ) }
	})
}
// 3. 선택된 제품번호에 해당하는 제품 출력 함수 
function findByPno( pno ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" , 
		data : { type: "findByPno" 	, pno : pno  } ,
		success : jsonObject => { console.log( jsonObject ) }
	})
}
// 4. 모든 제품들을 출력하는 함수 
function findByAll(   ) {
	$.ajax({
		url : "/jspweb/ProductInfoController" , method : "get" , 
		data : { type: "findByAll" 	 } ,
		success : jsonArray => { console.log( jsonArray ) }
	})
}