
// 카테고리 리스트
let categoryList = [ '샌드위치', '랩', '샐러드'];

categoryPrint(0);
//productPrint(0);

 function categoryPrint(selectNo) {
	 console.log('categoryPrint')
	 // 1. 어디에
	 let midUl = document.querySelector('.midUl');
	 // 2. 무엇을
	 let html = '';
	 	// HTML 구성 : 배열 내 데이터(for)를 li 형식으로 출력
	 for(let i = 0; i < categoryList.length; i++) {
		 if(i == selectNo) {  html+=`<li onclick="categorySelect( ${ i })" class="categoryselect"> ${categoryList[i]}  </li>`
		}
		 else{ 
			 
			 html+=`<li onclick="categorySelect( ${ i })"> ${categoryList[i]}  </li>` 
		}
	 }
	 
	 midUl.innerHTML = html;
 }

 // 3. 카테고리 클릭 함수 [ 실행조건 : . li에서 클릭했을때 ]
 function categorySelect(selectNo) {
	 console.log('categorySelect')
	 // <li> 여러개 존재 하는데 무엇 선택했는지 식별
	 console.log(selectNo);
	 // 0. 카테고리의 모든 li 호출
	 let categoryli = document.querySelectorAll('.midUl li'); // 해당 클래스 ul안에 있는 모든 li 호출
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
	 let products = document.querySelector('.products')
	 // 2. 무엇을 [ 선택된 카테고리에 맞는 제품들만 출력 ]
	 let html = ``;
	 	// html 구성 : 
	 	for(let i = 0; i < mainMenuList.length; i++) { // 모든 버거배열/리스트[서랍장] 열어서[하나씩] 확인
	 		// i번째 버거의 카테고리와 선택한 카테고리와 같으면
			if(mainMenuList[i].category == categoryNo) {
				html+=`<div class="product"> 
					<img src="../img/${mainMenuList[i].img}"/>
					<div class="pinfo">
						<div class="pname"> ${mainMenuList[i].name} </div>
						<div class="pcontent"> ${mainMenuList[i].content} </div>
					</div>
				</div>`;
			}
		}
	 // 3. 출력[대입]
 	 products.innerHTML = html;
 }