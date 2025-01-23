//[수정 할 정보 조회]

const boardView = ( ) => {
        
        let bno = new URL( location.href ).searchParams.get('bno');
        
        
        const option = { method : 'GET' }
       
        fetch( `/tj2024b_wep1/boardpractice/board/view?bno=${ bno }` , option )
                .then( response => response.json() )
                .then( data => {
                        // 4. fetch 응답에 따른 화면 출력 
                       		//마크업 주요 속성
								//1. innerHTML : 시작 마크업과 끝마크업 사이  <마크업>여기</마크업>
								//2.value : 마크업의 입력 속성값임 <마크업 value="여기여기"/>
                        document.querySelector('.titleInput').value = `${ data.btitle }`
                        document.querySelector('.contentInput').value = `${ data.bcontent }`
                        
                })
                .catch( error => { console.log(error) })
} // f end 
boardView() ; // JS가 열릴때 최초 실행





//[수정처리] 기존게시물을 보여주고 그다음에 수정처리 하는거임
const boardUpdate= ()=>{
	//1. 수정할 게시물 번호
	let bno = new URL(location.href).searchParams.get('bno')
	//2.input DOM객체 가져오기
	let titleInput = document.querySelector('.titleInput')
	let contentInput = document.querySelector('.contentInput')
	//3.가져온 DOM 객체로 부터 value(입력값속성)값 가져오기
	let btitle = titleInput.value;
	let bcontent = contentInput.value;
	//4. 객체화
	let dataObj = {bno : bno , btitle : btitle ,bcontent:bcontent}
	//5.fetch
	const option = {
		method : 'PUT',
		headers : {'Content-Type' :  'application/json'},
		body : JSON.stringify(dataObj)
	}//o end
	fetch('/tj2024b_wep1/boardpractice/board', option)
	.then(response =>response.json() )
	.then(data =>{
		if(data == true){
			alert('수정성공');
			location.href=`view.jsp?bno=${bno}`;
			}else{
				alert('수정실패');
			}
		}) 	
		
		.catch(e =>{console.log(e);})
	}


