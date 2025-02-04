console.log("info.js open")


//1.현재 로그인된 회원정보 요청 함수
const getMyInfo =()=>{
	
	//fetch 옵션
	const option = {method : 'GET'}
	//fetch 실행
	fetch('/tj2024b_wep1/member/info',option)
	.then(r =>r.json())
	.then(data =>{
		if(data!=null){ // 데이터가 널이아니면 
			//특정한 dom 정보 대입하기.
			document.querySelector('.mid').value = data.mid
			document.querySelector('.mname').value = data.mname
			document.querySelector('.mphone').value = data.mphone
			//*img 마크업에 이미지 경로 대입하는 방법 . src 속성 이용
			document.querySelector('.mimg').src = `/tj2024b_wep1/upload/${data.mimg}`
		}
		
	})
	.catch(e=> {console.log(e)})	

}// fend

getMyInfo(); //js 가 열렸을때 최초 1번 실행


//[2]회원탈퇴
const onDelete = ()=>{
	//*alert : 알림창 , confirm : 확인/ 취소 알림창  prompt : 입력상자 알림창
	confirm('정말 탈퇴 하실 생각?') 
	if(result == false)return; //만약에 취소 버튼을 클릭 했다면 탈퇴 요청 취소
	//fetch
	const option = {method :'delete'}
	fetch("tj2024b_wep1/member/info",option)
	.then(r=>r.sjson())
	.then(data =>{
		if(data==true){
			alert('탈퇴 성공');
			location.href="/tj2024b_wep1/index.jsp";
		}else{
			alert('탈퇴실패 : 관리자에게 문의');
		}
	})
	.catch(e=>{console.log(e);})
}// fend

//3.회원수정 페이지로 이동
const onUpdate= ()=>{
	location.href = "/tj2024b_wep1/member/update.jsp"; //업데이트jsp로 페이지 이동
	//게시판에는 게시물번호가 세션이 없으므로 ?bno=3 해야한다. 그렇지만 수정할 회원번호가 (로그인된 회원번호)가 세션에 있으므로 굳이 할 필요가 없다.
	//현재 페이지와 이동할 페이지가 같은 폴더이면 지정 파일명 작성 ,만일 다른 폴더이면 프로젝트명 부터 작성
	
}// f end


//4. 포인트 리스트 출력 
 // 1. 로그인된 회원번호는 서버에서 세션으로 관리되므로 별도로 보낼 필요 없음
   fetch('/tj2024b_wep1/member/info')
       .then(r => r.json())
       .then(r => {
           console.log(r);
           let html = '';
           // 2. pointlist 객체가 있고 데이터가 있을 때만 반복
           if(r.pointList != null && r.pointList.length > 0) {
               r.pointList.forEach(p => {
                   html += `
                       <tr>
                           <td>${p.pcomment}</td>
                           <td>${p.ppoint}</td>
                           <td>${p.pdate}</td>
                       </tr>
                   `;
               });
           }
           document.querySelector('.pointTable tbody').innerHTML = html;
       });


// 3. 페이지 로드시 실행
getPointList();