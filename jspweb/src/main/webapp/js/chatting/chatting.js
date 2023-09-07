console.log('chatting.js')

// 1. 클라이언트 소켓 만들기
	
	// 1. JS웹소켓 객체 [WebSocket클래스]
		// new WebSocket('서버소켓 URL')
	let 클라이언트소켓 = new WebSocket('ws://localhost:80/jspweb/ChattingSocket'); console.log(클라이언트소켓);
	
	클라이언트소켓.onmessage = (e) => onmsg(e);
	클라이언트소켓.onerror = (e) => {console.log(e)
	console.log(' dfsdf')};


function msgsend() {
	// 1. input 입력된 값 가져오기
	let msg = document.querySelector('.inputcontent').value;
	// 2. 클라이언트소켓 .send();
	클라이언트소켓.send(msg); // input에서 입력받은 데이터를 보내기 [ 클라이언트.send() ===> 서버소켓 @OnMessage]
}

function onmsg(event) {
	console.log(event);
	console.log(event.data);
	console.log('받음');
	
	document.querySelector('.contentbox')
		.innerHTML += `<div>${event.data}</div>`
}