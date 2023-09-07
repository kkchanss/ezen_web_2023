apil();
function apil() {
	
	$.ajax({
		url : "https://api.odcloud.kr/api/15036759/v1/uddi:577ba1b9-b79f-4865-b31e-a9dc71ce67bc_201909231019?page=1&perPage=10&serviceKey=Q6TBMdh4JXt%2B3GymGOHLK%2BDruf5411cs3VPSqgR5oRxhOFAQ8n9OPmMsSTodlyC9qUQpuugBe96lnpGcMGC3pA%3D%3D",
		method : "get",
		data : {
			
		},
		success : response => {
			console.log(response);
			
			let data = response.data; console.log(data)
			console.log(data[0])
			console.log(data[0].업소명)
			
			let apiTable1 = document.querySelector('.apiTable1');
			
			let html = `
				<tr>
	      			<th>번호</th>
	      			<th>상호명</th>
	      			<th>주소</th>
	      			<th>연락처</th>
	      			<th>대표메뉴1</th>
	      			<th>대표메뉴2</th>
	      			<th>대표메뉴3</th>
	      		</tr>
			`;
			
			data.forEach((d, i) => {
				html+= `
					<tr>
		      			<td>${i+1}</td>
		      			<td>${d.업소명}</td>
		      			<td>${d.소재지도로명주소}</td>
		      			<td>${d.연락처}</td>
		      			<td>${d.품목1}/${d.가격1}</td>
		      			<td>${d.품목2}/${d.가격2}</td>
		      			<td>${d.품목3}/${d.가격3}</td>
		      		</tr>
				`
			})
			
			apiTable1.innerHTML = html;
		} ,
		error : e => {
			
		}
	})
}

navigator.geolocation.getCurrentPosition(pos => {
	console.log(pos);
	let lat = pos.coords.latitude;
	let lng = pos.coords.longitude;


	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(lat, lng), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

	var markerPosition = new kakao.maps.LatLng(lat, lng);
	
	var marker = new kakao.maps.Marker({
		position: markerPosition
	});
		
	marker.setMap(map);
})
