console.log('js 시작')

let memberList = []


function 등록(){
	let name = document.querySelector('.name').value;
	let pwd = document.querySelector('.pwd').value;
	let title = document.querySelector('.title').value;
	let content = document.querySelector('.content').value;
	
	let today = new Date();
	let year = today.getFullYear();
	let month = today.getMonth() + 1;
	let date = today.getDate();
	let hours = today.getHours();
	let minutes = today.getMinutes();
	let seconds = today.getSeconds();
	
	let time = year + '년 ' + month + '월 ' + date + '일 ' + hours + ':' + minutes + ':' + seconds;
	
	console.log(time); 
	
	
	if(name == '' || pwd == '' || title == '' || content == '') {
		alert('모두 입력해주시길 바랍니다.')
		document.querySelector('.name').value = '';
		document.querySelector('.pwd').value = '';
		document.querySelector('.title').value = '';
		document.querySelector('.content').value = '';
		return;
	}
	
	let member = { name : name, pwd : pwd, title : title, content : content, time : time, hits : 0 };
	memberList.push(member);
	
	alert('글 등록이 완료되었습니다.')
	document.querySelector('.name').value = '';
	document.querySelector('.pwd').value = '';
	document.querySelector('.title').value = '';
	document.querySelector('.content').value = '';
	목록();
	
}

function 목록(){
	let lists = `<tr><th> 번호 </th><th> 제목 </th><th> 작성자 </th><th> 작성일 </th><th> 조회수 </th></tr>`;
	let list = document.querySelector('.list');
	
	for(let i = 0; i < memberList.length; i++) {
		lists+=`<tr class="list${i}" onclick="조회수(${i})"> <td>${i+1}</td> <td>${memberList[i].title}</td> <td>${memberList[i].name}</td> 
				<td>${memberList[i].time}</td> <td>${memberList[i].hits}</td> </tr>`;
	}
	list.innerHTML = lists;
}

function 조회수(index) {
	memberList[index].hits++;
	목록();
	보기(index);
}

function 보기(index) {
	let title = memberList[index].title;
	let content = memberList[index].content;
	let name = memberList[index].name;
	
	let lists = '';
	lists += `<li>제목 : ${title}</li><li>내용 : ${content}</li><li>작성자 : ${name}</li> <li><button onclick="삭제(${index})">삭제</button></li>`
	
	let read_ul = document.querySelector('.read_ul');
	read_ul.innerHTML = lists;
}

function 삭제(index){
	let pwd = memberList[index].pwd;
	let pwd1 = prompt('비밀번호를 입력해주세요 : ');
	if(pwd1 == pwd) {
		alert('삭제되었습니다.')
		memberList.splice(index, 1);
		console.log(memberList);
		let read_ul = document.querySelector('.read_ul');
		read_ul.innerHTML = '';
		목록();
	}
	else{
		alert('틀렸습니다 다시 입력해주시길 바랍니다.')
		return;
	}
}

