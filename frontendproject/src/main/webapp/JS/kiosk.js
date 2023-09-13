console.log ('kiosk JS 열림')

// 샘플데이터 --------------------------------------------------------------------
//1. 광고 이미지를 저장하고 있는 = 배열
let bimgList = ['himg1.png','himg2.png','himg3.jpg','himg4.png','himg5.png']
//2. 카테고리 여러개 저장하는 배열
let categoryList = ['신제품(new)','프리미엄','와퍼&주니어','치킨&슈림프버거','올데이킹&킹모닝']
//3. 제품 여러개를 저장하는 배열
	// 서로 다른 유형들의 데이터를 여러개 저장할때는 = 객체 {}
	// 동일한 유형들의 데이터를 여러개 저장할때는 = 배열 []
let burgerList = [  { name : '헬로디아블로와퍼', 		price : 10500, img : '헬로디아블로와퍼.png', 		category : 0 },
					{ name : '헬로릴리트와퍼', 			price : 11500, img : '헬로릴리트와퍼.png',  		category : 0 },
					{ name : '헬로이나리우스와퍼',		price : 11000, img : '헬로이나리우스와퍼.png',	 	category : 0 },
					{ name : '더블비프불고기버거', 		price : 9500,  img : '더블비프불고기버거.png', 		category : 1 },
					{ name : '몬스터X', 				price : 9500,  img : '몬스터X.png', 				category : 1 },
					{ name : '몬스터와퍼', 			price : 9000,  img : '몬스터와퍼.png', 			category : 2 },
					{ name : '블랙바비큐와퍼', 			price : 8500,  img : '블랙바비큐와퍼.png', 			category : 2 },
					{ name : '블랙바비큐콰트로치즈와퍼',  price : 9000,  img : '블랙바비큐콰트로치즈와퍼.png', 	category : 2 },
					{ name : '통새우와퍼',  			price : 8000,  img : '통새우와퍼.png', 			category : 2 },
					{ name : '치킨킹', 				price : 7000,  img : '치킨킹.png', 				category : 3 },
					{ name : '치킨킹BLT', 			price : 7500,  img : '치킨킹BLT.png', 			category : 3 },
					{ name : '오믈렛킹모닝', 			price : 6000,  img : '오믈렛킹모닝.png', 			category : 4 },
					{ name : '오믈렛킹모닝BLT', 		price : 6500,  img : '오믈렛킹모닝BLT.png', 		category : 4 }
				 ]
//4. 장바구니 배열 / 선택된 버거들이 저장되는 배열
	// 버거객체를 담을 것인지 인덱스를 담을 것인지 선택하기 ! 
let cartList = [ ]
//5. 주문내역 배열
	/*															┌> 정해져있는 데이터들은 수치화 하는것을 권장 
		주문 = { 주문번호: , 주문날짜/시간: , 결제금액: , 주문제품: [], 상태: 0[주문요청], 1[주문완료], 2[주문취소] }
	*/
let orderList = [ 
	{ orderNo: 1, date: '2023-07-05 13:30:25', pay: 27000, products: [ 0, 0, 2 ], state: 1 }
 ]

//1. 광고 이미지 변경 --------------------------------------------------------------------

	//1. 광고 이미지를 저장하고 있는 = 배열 최상단에 있음
//let bimgList = ['himg1.png','himg2.png','himg3.jpg','himg4.png','himg5.png']
	//2. 특정 시간마다 이미지의 src 변경하기
		// -setInterval ( 함수, 밀리초 ) : 1/1000초
		//1. function 함수(){}   2. function (){}   3. ()=>{}
			//setInterval(()=>{ 실행코드 }, 2000); // 2초마다 실행코드 추기적으로 실행 ! 
			
let viewimg = 0; // 현재 보고 있는 광고 이미지 인덱스 저장하고 있는 변수
setInterval(()=>{ 
	//1. 어디에
	let himg = document.querySelector('.himg');
	//2. 호출된 객체에서 src 라는 속성 대입/ 바꿔치기
		// 배열내 이미지 하나씩 바꿔 가면서 대입하기 
		viewimg++; // 인덱스 증가 시켜서 다음 이미지로 변경 
	// 마지막 인덱스 다음이면 처음으로 돌아가기 
	if( viewimg >= bimgList.length) { viewimg = 0; }
	himg.src = `../img/${bimgList[viewimg]}`;
 }, 2000);


//2. 카테고리 출력 함수 --------------------------------------------------------------------

	//1. 카테고리 여러개 저장하는 배열 최상단에 있음
// let categoryList = ['신제품(new)','프리미엄','와퍼&주니어','치킨&슈림프버거','올데이킹&킹모닝']

	//2. 카테고리 출력하는 함수 정의 [실행 조건 : 페이지 열렸을 때]
categoryPrint(0); // 0 넣어줘야만 첫 실행 가능 !!!!!!!!!!!!
function categoryPrint( selectNo ){
	
	//1. 어디에
	let categorymenu = document.querySelector('.categorymenu')
	//2. 무엇을
	let html = ``;
		//HTML 구성 : 배열내 모든 데이터(for문 사용)를 li형식으로 출력
	for ( let i = 0; i<categoryList.length; i++){
		if( i == selectNo ){ 
			html += `<li onclick="categoryselect(${i})" class="categoryselect"> ${categoryList[i]} </li>`;
			 // += 누적으로 출력 
		} else { 
			html += `<li onclick="categoryselect(${i})"> ${categoryList[i]} </li>`;
		  }
	}
	
	//3. 구성된 HTML 출력
	categorymenu.innerHTML = html;
	productPrint(selectNo)
}


//3. 카테고리 선택 클릭 함수 --------------------------------------------------------------------
	// 실행 조건 li에서 클릭 했을때
function categoryselect( selectNo ){
	// li가 여러개 존재 하는데 무엇 선택했는지 식별
	console.log (selectNo);
	
	//0. 카테고리에 모든 li 호출 [querySelectorAll 은 여러개를 배열로 가지고 온다.]
	let categoryli = document.querySelectorAll('.categorymenu li'); // 해당 클래스의 모든 li 호출
	console.log (categoryli);
	
	//1. 해당 선택된 인덱스의 class 추가 // !!!!! JS 에서 class 추가,삭제 가능 ! 
	for( let i = 0 ; i< categoryList.length; i++){
		//2. 선택된 카테고리[selectNo] 의 i번째 카테고리 찾기
		if( selectNo == i){
			// 해당 li 에 class 추가 DOM객체명.classList.add('새로운클래스명')
			categoryli[i].classList.add('categoryselect')
		}else {
			// 해당 li 에 class 삭제 DOM객체명.classList.remove('새로운클래스명')
			categoryli[i].classList.remove('categoryselect')
		}
	}
	productPrint(selectNo)
}


//4. 제품 출력 함수 --------------------------------------------------------------------
// 실행조건 : 카테고리 클릭(변경) 하면
function productPrint ( categoryNo ){ // 어떤 카테고리에 제품 출력 할건지?? 인수 판단
	//1. 어디에
	let productbox = document.querySelector('.productbox')
	
	//2. 무엇을 (선택된 카테고리에 맞는 제품들만 출력)
	let html = ``;
		//html 구성하기 
		for( let i = 0; i<burgerList.length; i++){ // 모든 버거 배열 열어서 확인
			if( burgerList[i].category == categoryNo ){
				html += `<div onclick="productSelect(${i})" class="product"> 
							<img src="../img/${burgerList[i].img}"/> 
							<div class="pinfo">
								<div class="pname"> ${burgerList[i].name} </div>
								<div class="pprice"> ${burgerList[i].price.toLocaleString()}원 </div>
							</div>
						  </div>`
			} 
		}
	//3. 대입
	productbox.innerHTML = html;
}


//5. 제품 선택 --------------------------------------------------------------------
// 실행조건 : 제품이미지 클릭하면
function productSelect ( productNo ){ // 어떤 제품을 장바구니에 담을건지?? 인수 판단
	console.log (burgerList[productNo].name);
	//1. 선택된 버거의 인덱스를 배열에 저장 [버거의 모든 정보를 저장할 필요가 없음]
	cartList.push(productNo); console.log ( cartList );
		
	cartPrint();
}


//6. 장바구니 내 버거들의 출력 함수 --------------------------------------------------------------------
// 실행조건 : 장바구니 내 제품이 등록되면 , 취소 되면
function cartPrint(){ // 인수 판단 : 모든 카트 내 제품 출력
	let cartbottom = document.querySelector('.cartbottom')
	let html = ``;
	let totalPrice = 0;
		for( let i = 0; i < cartList.length ; i++){
			let burgerIndex = cartList[i]
			html += `<div class="citem">
						<div class="iname"> ${burgerList[burgerIndex].name} </div> 
						<div class="iprice"> ${burgerList[burgerIndex].price.toLocaleString()}원 </div> 
						<span onclick="productCancel(${i})" class="icencel"> x </span>
					 </div>`;
			// i 번째의 가격을 누적합계
			totalPrice += burgerList[burgerIndex].price
		}
		
	//출력 대입 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	cartbottom.innerHTML = html;
	// + 카트내 제품 수 출력 [ 제품수 : 배열길이]
	document.querySelector('.ccount').innerHTML = `${cartList.length}`
	// + 카트내 제품 총가격 출력 [총가격 : 배열내 버거요소의 가격을 모두 더한 값]
	document.querySelector('.ctotal').innerHTML = `${totalPrice.toLocaleString()}원`
	
	// ***** 만약에 카트내 제품이 많아서 스크롤이 생성 되었을때 자동으로 가장 오른쪽으로 이동하기
	cartbottom.scrollLeft = 10000; // 임의값 높은거 썻음 !
}


//7. 장바구니 내 버거들의 부분 취소 함수 --------------------------------------------------------------------
// 실행조건 : 장바구니 내 버거 박스의 X를 클릭 했을때 
function productCancel(cartIndex){
	cartList.splice (cartIndex , 1);
	alert ('장바구니에서 삭제되었습니다.')
	cartPrint();
}


//8. 장바구니 내 전체 취소 함수 --------------------------------------------------------------------
// 실행조건 : 취소하기 버튼을 클릭 했을때
function cartCancel(){
	cartList.splice ( 0 ); // 배열내 모든 요소 삭제하기
	alert ('장바구니를 모두 비웠습니다.')
	cartPrint();
}

//주문 데이터 구조화 설계


//9. 주문하기 버튼 함수 --------------------------------------------------------------------
// 실행조건 : 주문하기 버튼을 클릭 했을때
function productOrder(){
	//0. 주문번호 만들기 // 마지막 인덱스 : 배열명.length -1
	let ono = orderList[orderList.length-1].orderNo;
	// 전역변수cartList에 있던 데이터를 새로운 곳에 넣어줘야한다.
	let products = []; // 주문이 들어가는 버거 인덱스
	let totalPrice = 0;
	for( let i = 0 ; i<cartList.length ; i++){
		products.push(cartList[i]);
		totalPrice += burgerList[cartList[i]].price
	}
	//1. 주문객체 생성해서 
	let order = {
		orderNo: ono+1, 	// 주문번호 생성해서 저장 [ 마지막 주문번호에 +1 ] 
		date: new Date(),	// 현재 날짜/ 시간 구해주는 함수 이용해서 자동으로 대입 
		pay: totalPrice, 	// 장바구니 내의 제품들의 총 가격
		products: products, // 장바구니에 있던 모든 제품들 ** 전역변수 대입시에는 문제가 발생! 그래서 함수안에서 새로 선언한 배열 넣기
		state: 0			// 주문객체 생성시 '주문요청'상태로 초기값 사용
	}
	//2. 주문 배열에 저장하기
	orderList.push(order)
	alert('주문이 완료되었습니다.')
	
	// 장바구니 초기화
	cartList.splice ( 0 );
	cartPrint()
	console.log (order)
	console.log (orderList)
}




