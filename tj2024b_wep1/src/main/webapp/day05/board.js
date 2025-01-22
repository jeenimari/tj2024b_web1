//[2] 전체조회
const boardFindAll= ( )=>{
	
	//1.어디에
	let tbody = document.querySelector('tbody')
	//2.무엇을
	let html = '';
	
	//-fetch 옵션
	const option = {method : 'GET'}
	
	fetch('/tj2024b_wep1/day05/board',option)
	.then(response => response.json())
	.then(data =>{
		let html = '';
		data.forEach(board =>{
			
			html += 		`<tr>
									<th>${board.bno}</th><th><a href="view.jsp?bno=${board.bno}">
											${board.btitle}</a>
									</th>	
									<th>${board.bdate}</th>
									<th>${board.bwriter}</th>
									<th>${board.bview}</th>
								</tr>`;
		});
		tbody.innerHTML = html;
	});
	document.addEventListener('DOMContentLoaded' , boardFindAll);
}