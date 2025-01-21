
console.log(`example1.js 실행`);

//1.Js 자료
console.log(3);  //숫자 	정수
console.log(3.14);  // Number	실수
console.log(true);   // boolean	논리
console.log(null); 	// null	객체없다
console.log(undefined)  // undefinde 정의없다
console.log("안녕1"); // String
console.log('안녕'); 	//String
console.log(`안녕3`);   //String
console.log([3,3.14,true,`안녕4` ]) // Array type  배열 [  ]
console.log(function 함수명( ){ } )   // funtion 	함수
console.log({"속성명": 3 , "속성명2":`안녕4`}); //object     객체

//*let 변수선언 키워드 , const 상수 선언 키워드

//2. JS 함수
// (1) 선언적 함수 : function 함수명 ( 매개변수명 , 매개변수명){실행문; }
//( 정의/만들기)
function func1(a,b){
	let c = a+b;
	return c;
}//f end
let result = func1(3,4);    //( 함수호출/사용)
console.log(result)


//(2)익명 함수 : funtion(매개변수명 , 매개면수명 ){ 실행문;}
const func2 = function(a, b){    //함수선언
	let c = a+b ; return c;
}
let result1 = func2(5,1); // 함수호출
console.log(result1)


//(3) 람다식 함수  (화살표) : (   매개변수명 , 매개변수명 )=>{실행문;}
const func3 = (a,b )=> {c= a+b; return c;}
let result2 = func3(10,2); //함수선언 
console.log(result2)

//3. 람다식 함수의 활용처  : 다양한 라이브러리 (미리만들어진 함수)들에서 널리 사용됨
const words  = ["사과","수박", "딸기", "오렌지"]
//예 ] 배열내 모든 요소값들을 하나씩 출력하시오
for(let index =0; index<=words.length-1; index++){
	console.log(words[index]);
}//일반포문 

//for-Each ( (반복변수명 )=> { 실행문 } ) 함수,  배열내 요소를 하나씩 반복변수명에 대입
words.forEach((word)=>{console.log(word)} );

//(3)배열변수명.map(  )        배열내 요소를 하나씩 반복면수명에 대입 반복실행
words.map( (word)=> {console.log(word)} );   

//(*) forEach 와 map 함수의 차이점
let newWords1 = words.forEach( ( i )=>{return i;} )
console.log(newWords1); //undefinde   // 왜이럴까?  return 지원 하지않기떄문

let newWords2 =  words.map((j)=>{return j;})  // map 함수는 return 지원함
console.log(newWords2); 






