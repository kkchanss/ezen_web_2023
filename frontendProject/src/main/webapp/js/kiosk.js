console.log('js 실행')

// ------------------------ 샘플 데이터 ------------------------- //

 // 1. 광고이미지 변경
 	// 1. 광고이미지 여러개 = 배열
 let bimgList = [ 'himg1.png', 'himg2.png', 'himg3.jpg', 'himg4.png', 'himg5.png']
 	// 2. 카테고리 여러개 저장하는 배열
 let categoryList = [ '신제품(NEW)', '프리미엄', '와퍼&주니어', '치킨&슈림프버거', '올데이킹&킹모닝'];
 	// 1. 제품 여러개 저장하는 배열
 		// 서로 다른 유형들의 여러개 저장 = 객체 { }
 		// 동일한 유형들의 데이터 여러개 저장 = 배열/리스트 [ ]
 		// 버거이름, 버거가격, 버거이미지, 버거카테고리, 버거이름2, 버거가격2, 버거이미지2, 버거카테고리2
 		// [{ 버거이름, 버거가격, 버거이미지, 버거카테고리}, {버거이름2, 버거가격2, 버거이미지2, 버거카테고리2}]
 		// 다른 배열이나 객체의 연관관계
 		// 카테고리(상위) ---> 제품(하위) // 카테고리 식별값 ---> 제품에 저장 [ pk ---> fk ]
 let burgerList = [
	 				{ name : '헬로디아블로와퍼', price: 9500, img : '헬로디아블로와퍼.png', category : 0}, 
	 				{ name : '헬로릴리트와퍼', price: 12500, img : '헬로릴리트와퍼.png', category : 0}, 
	 				{ name : '치킨킹', price: 8000, img : '치킨킹.png', category : 3}
 					]
 	// 1. 카트(장바구니) 배열 / 선택 버거들이 저장되는 배열
 		// 1. 버거 객체 2. 버거의 식별 = 중복x -> 버거제품번호 ? 대신에 배열인덱스
 let cartList = []
 	// 1. 주문(주문내역) 배열
 		/*
 																[ 정해져 있는 데이터들은 숫자로 저장 -> 권장 ]
 			주문 { 주문번호 : , 주문날짜 : , 결제금액 : , 주문제품들 : [], 상태 : 0['주문요청'], 1['주문완료'], 2} 
 		*/
 let orderList = [
	 { ono : 1, date : '2023-07-05 13:30', pay : 30000, prodcts : [0, 0, 2]}
 ]
// ----------------------- 샘플 데이터 end -------------------- //
 let viewhimg = 0; // 현재 출력중인 광고이미지 인덱스 저장하고 있는 변수
 	// 2. 특정시간마다 이미지의 src 변경 하기	
 		// - setInterval ( 함수, 밀리초 ) : 1/1000
 		// 1. function 함수(){} 2. function () {} 3. () => {}
			/* setInterval( (실행코드) => {} , 2000); // 2초마다 실행코드가 주기적으로 실행*/
 setInterval(()=> {
	 
	 // 1. 해당 이미지 태그 객체 호출
	 let himg = document.querySelector('.himg');
	 // 2. 호출된 객체에서 src 속성 대입/바꿔치기
	 	// 배열 내 이미지 하나씩 바꿔가져서 대입
	 
	 	viewhimg++; // 인덱스 증가시킴 [ 다음 이미지로 변경]
	 	if(viewhimg >= bimgList.length) {viewhimg = 0;} 
	 	
	 himg.src = `../img/${bimgList[viewhimg]}`;
 },2000);
 // 2. 카테고리 출력 [ 어디에 무엇을 출력할껀지 ] 함수  
 	// 1. 카테고리 여러개 저장하는 배열
 
 	// 2. 카텍리 출력 함수 정의 [ 실행조건 : 1. 페이지 열렸을때 ]
 categoryPrint(0); // 최초 1번 실행 [ 가장 앞에 있는 카테고리 선택 가정]
 productPrint(0);
 function categoryPrint(selectNo) {
	 console.log('categoryPrint')
	 // 1. 어디에
	 let categorymenu = document.querySelector('.categorymenu');
	 // 2. 무엇을
	 let html = '';
	 	// HTML 구성 : 배열 내 데이터(for)를 li 형식으로 출력
	 for(let i = 0; i < categoryList.length; i++) {
		 if(i == selectNo) {  html+=`<li onclick="categorySelect( ${ i })" class="categoryselect"> ${categoryList[i]} </li>` }
		 else{  html+=`<li onclick="categorySelect( ${ i })"> ${categoryList[i]} </li>` }
		
	 }
	 
	 categorymenu.innerHTML = html;
 }
 
 
 // 3. 카테고리 클릭 함수 [ 실행조건 : . li에서 클릭했을때 ]
 function categorySelect(selectNo) {
	 console.log('categorySelect')
	 // <li> 여러개 존재 하는데 무엇 선택했는지 식별
	 console.log(selectNo);
	 // 0. 카테고리의 모든 li 호출
	 let categoryli = document.querySelectorAll('.categorymenu li'); // 해당 클래스 ul안에 있는 모든 li 호출
	 	console.log(categoryli);
	 // 1. 해당 선택된 인덱스의 class 추가 // !!! JS에서 class 추가 / 삭제 가능
	 for(let i = 0 ; i < categoryList.length; i++) {
		 // 2. 선택된 인덱스[selectNo]의 i번째 카테고리 찾기
		 if( selectNo == i ) {
			 // 해당 li에 class 추가	DOM객체명.classList.add('새로운클래스명')
			 categoryli[i].classList.add('categoryselect');
		 }else{
			 // 해당 li에 class 삭제 DOM객체명.classList.remove('새로운클래스명')
			 categoryli[i].classList.remove('categoryselect');
		 }
	 }
	 //categoryPrint(selectNo);
	 console.log("----" + selectNo);
	 // 3.
	 productPrint(selectNo);
 }
 // ---------------------------------- //
 
 // 4. 제품 출력 함수 [ 실행 조건 : 1. 카테고리 클릭(변경)하면 ]
 function productPrint(categoryNo) { // 어떤 카테고리의 제품 출력할껀지 인수 판단
	 // 1. 어디에
	 let productbox = document.querySelector('.productbox')
	 // 2. 무엇을 [ 선택된 카테고리에 맞는 제품들만 출력 ]
	 let html = ``;
	 	// html 구성 : 
	 	for(let i = 0; i < burgerList.length; i++) { // 모든 버거배열/리스트[서랍장] 열어서[하나씩] 확인
	 		// i번째 버거의 카테고리와 선택한 카테고리와 같으면
			if(burgerList[i].category == categoryNo) {
				html+=`<div onclick="productSelect(${i})" class="product"> 
					<img src="../img/${burgerList[i].img}"/>
					<div class="pinfo">
						<div class="pname"> ${burgerList[i].name} </div>
						<div class="pprice"> ${burgerList[i].price.toLocaleString()} </div>
					</div>
				</div>`;
			}
		}
	 // 3. 출력[대입]
 	 productbox.innerHTML = html;
 }
 
 	
 // 5. 제품 선택 함수 [ 실행 조건 : 1. 제품 구역 클릭 하면 ]
 function productSelect(productNo) { // 어떤 제품을 카트에 담을껀지 인수 판단
	 console.log(productNo)
	 cartList.push(productNo); console.log(cartList);
	 cartPrint();
 }
 
 // 6. 카트 출력 함수
 function cartPrint() {
	 console.log('cartPrint()');
	 // 1. 어디에
	 let cartbottom = document.querySelector('.cartbottom');
	 let ctotal = document.querySelector('.ctotal');
	 let total = 0;
	 
	 // 2. 무엇을
	 let html = ``;
	 for(let i = 0; i < cartList.length; i++) {
		 let burgerIndex = cartList[i];
		 html += `<div class="citem">
						<div class="iname"> ${burgerList[burgerIndex].name} </div>					
						<div class="iprice"> ${burgerList[burgerIndex].price.toLocaleString()}원 </div> 
						<span onclick="productCancel(${i})" class="icencel"> X </span> 
				</div>`;
		// 3. i번째 가격을 누적합계
		total += burgerList[burgerIndex].price;
	 }
	 // 3. 출력
	 cartbottom.innerHTML = html;
	 // * 카트 내 제품 수 출력
	 document.querySelector('.ccount').innerHTML = `${cartList.length}`; 
	 // * 카트 내 총 가격 출력
	 ctotal.innerHTML = `${total.toLocaleString()}원`;
	 // * 만약에 카트 내 제품이 많아서 가로 스크롤이 생성 되었을때 자동으로 가장 오른쪽으로 이동
	 cartbottom.scrollLeft = 10000;
 }
 
 // 7. 카트 내 버거 부분 취소 함수 [ 실행 조건 : x버튼을 클릭했을때]
  function productCancel(burgerIndex) { // 전체취소: 인수x 부분취소: 인수o
  		alert('제품 취소') 
	 	cartList.splice(burgerIndex, 1);
	  	cartPrint();
  }
  
 // 8. 카트 내 버거 전체 취소 함수 [ 실행 조건 : 취소하기 버튼을 눌렀을때]
 function cartCencel() {
	 cartList = []; // 배열의 모든 요소 삭제
	 // == cartList.splice(0); 
	 cartPrint();
 }
 // 9. 카트내 저장된 버거 주문(등록) 함수 [ ]
 function productOrder() {
	 alert('주문 했습니다')
	 
	 // * 주문번호 만들기
	 let ono = orderList[orderList.length-1].ono; // 주문배열내 마지막주문의 번호
	 let totalprice = 0;
	 let products = []; // 주문이 들어가는 버거들 인덱스
	 for(let i = 0; i < cartList.length; i++) {
		 products.push(cartList[i]); // i번째 버거를 새로운 배열에 저장
		 totalprice += burgerList[cartList[i]].price // i번째 
	 }
	 // 1. 주문객체 생성해서
	 let order = {
		 ono : ono+1, 			// 주문번호 생성해서 저장 [ 마지막 주문번호 + 1 ]
		 date : new Date(), 	// 현재날짜/시간 구해주는 함수 이용해서 자동으로 대입
		 pay : totalprice, 				// 주문객체 생성시 '주문요청' 으로 상태 초기로 사용
		 prodcts : products,	// 카트에 있던 모든 제품들 // 전역변수[cartList] 대입 시 문제발생
		 state : 0				// 주문객체 생성시 '주문요청' 으로 상태 초기로 사용
	 }		
	 
	 orderList.push(order); // 주문배열에 저장하기
	 
	 cartCencel() // cart 비우기
	 
	 console.log(orderList)
 }
 