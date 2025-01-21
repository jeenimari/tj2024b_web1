// [1] 람다식 함수 정의
const  func1 = ( )=>{ 
	console.log('func1 execute')
 }
 
 //[2]람다식 함수 정의 안에서 fetch 함수 활용
 const func2 = ( )=>{
	
	// ** fetch : HTTP 비동기 통신 제공하는 함수
	fetch ( `http://localhost:8080/tj2024b_wep1/day02/example1` )

}//fend

const func3 = ( ) => { 
	fetch(`/tj2024b_wep1/day02/example1`,{method : `POST`})
}

const func4 = ( ) => { 
	fetch(`/tj2024b_wep1/day02/example1`,{method : `PUT`})
}

const func5 = ( ) => { 
	fetch(`/tj2024b_wep1/day02/example1`,{method : `DELETE`})
}

const func6 = ()=>{
	
	let name = '유재석';
	let age = 40;
	fetch(`/tj2024b_wep1/day02/example2?name=${ name }&age=${ age }`)
	
}

const func7 = ()=>{
	let name ='신동엽'; let age = 30;
	const option = {method : 'post'}
	fetch(`/tj2024b_wep1/day02/example2?name=${ name }&age=${ age }`)
	
}

const func8 = ()=>{
	let name = '서진석';  let age =32;
	const option = {method : "PUT"}
	fetch(`/tj2024b_wep1/day02/example2?name=${ name }&age=${ age }`)
}
const func9 = ()=>{
	let name = '김잔디';  let age =34;
		const option = {method : "DELETE"}
		fetch(`/tj2024b_wep1/day02/example2?name=${ name }&age=${ age }`)
}

const func10 = ( )=>{
	let object = {data1 : '유재석', 'data2' : 50}
	const option = { 
		method : 'POST',
		header : {'content-Type' : 'application/json'},
		body : JSON.stringify(object)   //HTTP 통신은 문자열타입만가능해서 바꾸는거임
	}// option end
	fetch(`/tj2024b_wep1/day03/example3` ,option);
}//f end


const func11 = ( )=>{
	let object = {data1 : '강호동','data2' : 40}
	const option = {
		method : 'put',
		header : {'Content-Type' : 'application/json'},
		body : JSON.stringify(object) 	 //HTTP 통신은 문자열타입만가능해서 바꾸는거임
	}// option end
	fetch(`/tj2024b_wep1/day03/example3` , option );
	
}// f end

const func12 = ( )=> {
	
	const option = { method : 'GET'}
	fetch(`/tj2024b_wep1/day03/example5` , option )
	.then(response => response.json( ) )
	.then(data => {console.log(data) ; } )
	
	
}// f end

const func13 = ()=>{
	const option = { method : 'POST'}
	fetch(`/tj2024b_wep1/day03/example5/` , option)
	.then(response => response.text())
	.then(data=>{console.log(data);})
}//f end

const func14 = () =>{
	const option = {method : 'PUT'}
	fetch(`/tj2024b_wep1/day03/example5/` , option)
	.then(response =>response.json)			//통신 성공시
	.then(data=>{console.log(data);})
	.catch(error=> {console.log(error);}) //통신실패시
}

const func15 = ( )=>{
	const option = {method : 'DELETE'}
	fetch(`/tj2024b_wep1/day03/example5/` , option)
	.then(r =>r.json())
	.then(data =>{console.log(data);})
	.catch(e=> {console.log(e);})

/*
	1. fetch(`HTTP URL` ,{ 옵션 } ) .then ( response 객체 => )<-- 다음으로 이어가기
	
	fetch(`HTTP URL`,{옵션} ).then(response 객체 )
	
	
	then( ) 
	1.응답객체 : 통신한 응답의 정보가 담긴 HTTP 응답 객체반환
		then(응답객체명 => 응답객체명 )
		-GET : fetch (`HTTP URL ` , { method : `get`} )
		-POST : fetch ( `HTTP URL` .{ method : `post`})
		-PUT  : fetch ( `HTTP URL` .{ method : `put`})
		-DELETE : fetch ( `HTTP URL` .{ method : `DELETE`})
		
		2. HEADER
			 {'content-Type' : 'application/json'}
		
		3.BODY : 
			-전송할 데이터자료
		[참고1 : 백틱]	
		` ` : 백틱 템플릿 : 문자열 사이에 변수/호출 과 연산식을 넣을 수 있는 템플릿 
		`문자열${변수명 }문자열 ${함수명( ) } 문자열 ${연산 }`
		
		[참고2 : JSON 문자열 타입변환]
			1.JSON.parse()   : 문자열 타입 ---> JSON 변환 함수
			2. JSON.stringify() : JSON타입 ----> 문자열 타입 변환 함수
		
 */