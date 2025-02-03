console.log('login.js open')

//[1]로그인 요청 함수
const onLogin = ( ) =>{
	
	//1.HTML  input Dom 가져오기
	
	const midinput = document.querySelector('.midinput');
	console.log(midinput);
	const mpwdinput = document.querySelector('.mpwdinput');
	//2.INPUT 입력값 가져오기 
	const mid = midinput.value;
	const mpwd = mpwdinput.value;
	
	
	//3.유효성 검사 (일단생략)
	
	
	//4.fetch
	//보낼 데이터를 객체화(json)화
	const obj = {	mid : mid , mpwd : mpwd	}
	const option = {
		method : 'POST',
		header : {'Content-Tyep' : 'application/json'},
		body : JSON.stringify(obj)
	 }
	 fetch('/tj2024b_wep1/member/login',option)
	 .then(response =>response.json())
	 .then(data =>{
		if(data>0){alert('로그인성공'); location.href="../index.jsp";} // ../ 상위폴더로 이동 뜻
		else{alert('로그인 실패'); }
		
	 })
	 .catch(error =>{console.log(error)})
}// f end