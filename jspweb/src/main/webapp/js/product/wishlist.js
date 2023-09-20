getWishProductList();
let cl =document.querySelectorAll('.checkbox');
cl[0].addEventListener('click',(e)=>{
   let _c = cl[0].checked
   cl.forEach( c=>{c.checked = _c})
})

// 0. 로그인제 페이지
if(loginState == false) {
	location.href="/jspweb/member/login.jsp";
}

function getWishProductList() {
	
	$.ajax({
		url : "/jspweb/PwishListController",
		async : false, 
		method : "get",
		data : { type : "findByAll" },
		success : jsonArray => { console.log(jsonArray); 
			
			let table = document.querySelector('.table');
			let html = `
				<tr>
	 				<th width="5%"> <input class="checkbox" type="checkbox"> </th>
	 				<th width="5%"> 이미지 </th>
	 				<th width="40%"> 제품 정보 </th>
	 				<th width="10%"> 가격 </th>
	 				<th width="10%"> 비고 </th>
 				</tr>
			`;
			
			jsonArray.forEach((p) =>{
				html += `
					<tr>
						<td><input class="checkbox" type="checkbox"></td>
						<td> <img src="/jspweb/product/img/${ Object.values(p.imgList)[0]}" width="100%" /> </td>
						<td  style="text-align: left; padding-left: 20px;" > ${p.pname} </td>
						<td> ${p.pprice.toLocaleString()}원</td>
						<td> <button type="button"> X </button> </td>
					</tr>
				`;
			})
			
			table.innerHTML = html;
		}
	});
	
};