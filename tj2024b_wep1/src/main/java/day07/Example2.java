package day07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Example2 {
	public static void main(String[] args) {
	
		//1.ArrayList 인스턴스 생성
		 //1.인스턴스 : new ArrayList<String>(); 		//클래스타입
		//2. 변수명 : list										// 암거나
		//3. 변수의 타입 : List<String> list				//인터페이스타입
		List<String> list = new ArrayList<String>();    //ArrayList타입은 List 인터페이스를 구현했으므로
		
		//2. List 인터페이스
			//(1) .add(자료)  : 리스트 내 지정한 자료를 마지막 요소 추가.
		list.add("유재석"); System.out.println(list);   //유재석
		list.add("강호동"); System.out.println(list);    // 유재석 ,가호동
		list.add("신동엽"); System.out.println(list);   //유재석 ,강호동 ,신동엽
		list.add("하하"); System.out.println(list);   //유재석 강호동 신동엽 하하
		
		list.add(2,"김희철"); System.out.println(list); // 3번째 위치에 김희철 자료를 변경
		
				//(2) .set(인덱스,자료) :리스트 내 지정한 인덱스에 지정한 자료의 요소 추가
		list.set(2, "서장훈");  // 3번재 위치에 '서장훈'자료를 추가
		System.out.println(list);
		
			//(3).get(인덱스)  : 리스트내 지정한 인덱스의 요소값 반환
		System.out.println(list.get(2)) ;   // 3번째 위치한 요소값 반환 //서장훈
		String str1 = list.get(0);  //1번째 위치한 요소값반환 // 유재석
		System.out.println(str1);
		
		//(4).size()   :리스트내 요소전체 개수 반환
		System.out.println(list.size()); //5
		
		//(5) .contains(자료) : 리스트내 지정한 자료존재 여부 반환 true/false
		System.out.println(list.contains("서장훈"));
		boolean result1 = list.contains("지미");
		System.out.println(result1);
		
		//(6) .indexOf(자료)  : 리스트내 지정한 자료의 인덱스반환 , 없으면 0 있으면 인덱스 수반환
		System.out.println(list.indexOf("서장훈")); // 2번 인덱스 반환     // 서장훈이 3번째에 위치했다는걸 알려줌
		int result2 = list.indexOf("박명수");
		System.out.println(result2);  //박명수 존재하지 않으므로 -1 출력
		
		//(7)  .remove(인덱스/자료)  : 리스트내 지정한 인덱스/자료 의 요소 삭제
		list.remove(0); //0번 인덱스 삭제 
		System.out.println(list); // 유재석 사라짐
		
		//(8) .clear() : 리스트내 모든 요소 삭제
		//(9) .isEmpty() : 리스트 내 요소가 비어있으면 true 1개라도 존재하면 false 
		System.out.println(list.isEmpty());
		
		
		//(10)  리스트내 요소들을 순회 (하나씩 거내기 ) 하는 방법
		//1. 일반 for문
		for(int index =0 ; index<=list.size()-1; index ++) {
			System.out.println(list.get(index));
			
		}
		//향상된 for문
		for(String str : list) {
			System.out.print(str);
		}
		//3.forEach() , JS : () =>{} , JAVA : ( ) -> { }
		list.forEach(  ( str ) ->{System.out.print(str); } );
		
		
		//3.클래스 들
		ArrayList<String>list1 = new ArrayList<String>();
		Vector<String>list2 = new Vector<String>(); 	//+ 멀티스레드에서 주로 사용됨
		LinkedList<String>list3 = new LinkedList<String>(); // + 요소가 중간 삽입/삭제 용이
			//여러 클래스들의 인스턴스를 다루기 위해서는 주로 인터페이스 타입 사용
		List<String>list4 = new ArrayList<String>();
		List<String>list5 = new Vector<String>();
		List<String>list6 = new LinkedList<String>();
		
	}// mend
}
