
// [1] URL(경로상의 cno ) 매개변수 값 구하기.
// /tj2024b_web1/board/board.jsp?cno=1
// /tj2024b_web1/board/board.jsp?cno=2
// /tj2024b_web1/board/board.jsp?cno=3
// - URL 상의 쿼리스트링 매개변수 :  new URL( location.href ).searchParams 
// - URL 상의 쿼리스트링 매개변수의 값 추출 : new URL( location.href ).searchParams.get('매개변수명')
console.log( new URL( location.href).searchParams )
console.log( new URL( location.href).searchParams.get( 'cno' ) )

// [2] 지정한 카테고리별 게시물 조회 요청 
// [2] 지정한 카테고리별 게시물 조회 요청 + 페이징 처리 
const findall = ( ) => {
        const cno = new URL( location.href ).searchParams.get( 'cno' )
        // * 현재 경소상의 page 페이지 변수 찾기
        let page = new URL( location.href ).searchParams.get( 'page' )
        if( page == null ) page = 1; // 만약에 page가 없으면 1페이지 설정 
        
        const option = { method : 'GET' }
        fetch( `/tj2024b_web1/board?cno=${ cno }&page=${ page }` , option )
                .then( r => r.json() )
                .then( response => { console.log( response );
                        const boardlist = document.querySelector('.boardlist > tbody')
                        let html = ``;
                        
                        let boardList = response.data;
                        boardList.forEach( (board)=>{
                                html += `<tr>
                                                        <td> ${ board.bno } </td>
                                                        <td> <a href="view.jsp?bno=${ board.bno }"> ${ board.btitle } </a> </td>
                                                        <td> ${ board.mid } </td>
                                                        <td> ${ board.bdate } </td>
                                                        <td> ${ board.bview } </td>
                                                </tr>`
                        }) 
                        boardlist.innerHTML = html;
                        getPageBtn( response , cno ); // 페이징 버튼 생성 함수 실행 , 현재 페이지번호 전달 
                 })
                 .catch( e => { console.log(e); } )
} // f end 
findall(); 


//[3] 페이지버튼 생성 함수
const getPageBtn = ( )=>{
	page = parseInt(response.page); // parseInt() 정수로 타입변환함수.

	//1.어디에
	const pagebtnbox = document.querySelector('.pagebtnbox');
	//2.무엇을
	
	let html =``;// 무엇을
	html +=`<li class=page-item>
	<a class="page-link" href="board.jsp?>`
	
	for(let index = 1; index<=10; index++){
		html +=`<li class="page-item">
		<a class="page-link" href="board.jsp?cno=1&page=${index}">
		${index}
		</a>
		</li>`
	}
	
		//(3)다음버튼
	html +=`<li class="page-item">
			<a class="page-link" href="board.jsp?cno=1&page=${1}">
			${index}
			</a>
			</li>`
			
	//3. 출력
	pagebtnbox.innerHTML = html;
}