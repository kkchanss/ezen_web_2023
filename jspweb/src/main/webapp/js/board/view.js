/**
 * 
 */

 getBoard()
 
 function getBoard()
 {
   let up = new URL(location.href).searchParams
    let bno = up.get('bno')
    console.log(bno)
    $.ajax({
       url: "/jspweb/BoardInfoController",
       method : 'get',
       data : {type:"2",bno:bno},
       success:r => {
          document.querySelector('.boardBox').innerHTML =`
          부가정보: <div> ${r.bcname},${r.bview} ${r.bdate} </div>
         부가정보2: <div> ${r.mid} <img src="/jspweb/member/img/${r.mimg}"></div>
         제목 :  <div> ${r.btitle}</div>
         내용 :  <div> ${r.bcontent} </div>
         파일 :  <div> ${r.bfile} </div>
         
         <a href="list.jsp"> <button type="button">목록보기 </button> </a>`
         console.log(r.ishost)
         if(r.ishost)
         {
            document.querySelector('.boardBox').innerHTML +=`
         <button onclick ="onDelete(${r.bno})" type="button"> 삭제 </button>
         <button onclick ="onUpdate(${r.bno})" type="button"> 수정 </button>`}
       },
       error:e =>{}
       
       
    })
 }
 
 function onDelete(bno)
 {
    $.ajax({
       url:"/jspweb/BoardInfoController",
       method:"delete",
       data:{bno:bno},
       success :r=>{
         if(r)
         {
            alert('삭제 성공')
            location.href = '/jspweb/board/list.jsp'
            }
         else{alert('삭제 실패')}
      },
       error : e=> {console.log('b')}
       
    })
 }
 function onUpdate(bno)
 {
    location.href = `/jspweb/board/update.jsp?bno=${bno}`
 }