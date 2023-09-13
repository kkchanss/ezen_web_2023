// 카테고리 리스트 
let hcategoryList = ['메뉴소개', '이용방법', '새소식', '관리자'];
/*let hcategoryListBottom = [
	{name : '샌드위치', category : 0}, {name : '랩', category : 0}, {name : '샐러드', category : 0},
	{name : '써브웨이 이용방법', category : 1}, {name : '단체메뉴 이용방법', category : 1}, {name : '신선한 재료 소개', category : 1},
	{name : '이벤트&프로모션', category : 2}, {name : '뉴스&공지사항', category : 2}, {name : '광고영상', category : 2},
	{name : '주문확인', category : 3}, {name : '리뷰관리', category : 3}
];*/

member();
function member(){
	$.ajax({
		url : "/subway/header",
		method : "get",
		success : function f(r){
			console.log('헤더 컨트롤러 통신 성공')
		} ,
		error : function f(r){}
	})
}