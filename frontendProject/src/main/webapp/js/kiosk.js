console.log('js 실행')

 // 1. 광고이미지 변경
 	// 1. 광고이미지 여러개 = 배열
 
 let bimgList = [ 'himg1.png', 'himg2.png', 'himg3.jpg', 'himg4.png', 'himg5.png']
 	// 2. 특정시간마다 이미지의 src 변경 하기	
 		// - setInterval ( 함수, 밀리초 ) : 1/1000
 		// 1. function 함수(){} 2. function () {} 3. () => {}
			/* setInterval( (실행코드) => {} , 2000); // 2초마다 실행코드가 주기적으로 실행*/
 let viewhimg = 0; // 현재 출력중인 광고이미지 인덱스 저장하고 있는 변수
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
 let categoryList = [ '신제품(NEW)', '프리미엄', '와퍼&주니어', '치킨&슈림프버거', '올데이킹&킹모닝'];
 	// 2. 카텍리 출력 함수 정의 [ 실행조건 : 1. 페이지 열렸을때 ]
 categoryPrint(0); // 최초 1번 실행 [ 가장 앞에 있는 카테고리 선택 가정]
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
	 categoryPrint(selectNo);
 }