

// 1.
function findByTop(count) {
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "get",
		data : { type : "findByTop", count : count},
		success : jsonArray => { console.log(jsonArray) }
	})
}

// 2. 현재 카카오지도 내 보고있는 동서남북 기준 내 제품들을 출력 함수 
function findByLatLng(east, west, south, north){
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "get",
		data : { type : "findByLatLng", east : east, west : west, south : south, north : north},
		success : jsonArray => { console.log(jsonArray) }
	})	
}

// 3. 
function findByPno(pno) {
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "get",
		data : { type : "findByPno", pno : pno},
		success : jsonArray => { console.log(jsonArray) }
	})	
}

// 4.
function findByAll() {
	$.ajax({
		url : "/jspweb/ProductInfoController",
		method : "get",
		data : { type : "findByAll"},
		success : jsonArray => { console.log(jsonArray) }
	})	
}