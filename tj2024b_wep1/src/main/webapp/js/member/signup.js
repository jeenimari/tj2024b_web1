/**
 * 
 */
console.log('signup.js open');

//[1] 회원가입 요청 함수
const onSignup = ( )=>{
	
	//1.form 을 한번에 가져오기. application/json 타입이 아님 --->multipart/form-data(첨부파일)
	//why? form-data로 전송할 경우에는 속성명을 'name'속성으로 식별.
	const signupform = document.querySelector('#signupform'); //form 전체 가져오기 
		console.log(signupform);
	//* .Fetch 이용한 multipart/form-data 타입으로 전송하는 방법
		//(1) 전송 할 폼을 바이트(바이너리) 데이터로 변환 , FrormData 클래스
		
		const signupformData = new FormData(signupform);
			
		//(2) fetch 옵션, content-type 생략하면 자동으로 'multipart/form-data'적용된다.
		const option = {
			method : 'POST',
			body : signupformData //JSON.stringify(): 폼전송은 json 형식이 아니므로 생략.
		}
		
		//(3) fetch 요청 과 응답 
		fetch('/tj2024b_wep1/member/signup',option)
		.then(response => response.json() )
		.then( data => {
			if(data ==true){alert('회원가입 성공'); location.href="login.jsp";} //회원가입 성공시 메세지후 로그인 페이지 이동
			else{alert('회원가입 실패'); }		
		}) 	//응답 자료
		.catch( error =>{console.log(error);}) // fetch 통신 간 오류 발생시
	
}