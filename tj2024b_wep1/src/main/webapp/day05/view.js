const boardView=()=>{
	let bno = new URL(location.href).searchParams.get('bno');
	
	const option = {method : 'GET'}
	fetch(`/tj2024b_wep1/day05/board/view?bno=${bno}`,option)
	.then(response =>response.json() )
	.then(data=>{
		
		document.querySelector('bdataebox').innerHTML =`${data.bdate}`
		document.querySelector('bwriterbox').innerHTML =`${data.bwriter}`
		document.querySelector('bviewbox').innerHTML =`${data.bview}`
		document.querySelector('btitlebox').innerHTML =`${data.btitle}`
		document.querySelector('bcontentbox').innerHTML =`${data.bcontentbox}`
		
	})
	.catch(error=>{console.log(error)})
	
} //c end
boardView();  //js 가 열릴때 최초 실행
