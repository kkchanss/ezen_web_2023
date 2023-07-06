console.log('write js 실행');

// 1. 썸머노트 실행할때 사용되는 코드
$(document).ready(function() {
	$('#summernote').summernote({
		lang : 'ko-KR',
		height: 500, 
		placeholder: "여기에 내용작성"
		
	});
});

//---------------------------------------//