package day07;

public class Example1 {
	public static void main(String[] args) {
		Box1 box1 = new  Box1();
		box1.content = "안녕하세요"; // 인스턴스 내 멤버변수의 값 대입
		String content1 = box1.content;
			
		//[2]Box 인스턴스 생성 
		Box2 box2 = new Box2();
		box2.content = 100;
		int content2 = box2.content;
		
		
		//[3] 특정 인스턴스의 하나의 멤버변수가 여러 타입 가질 수 있는지?
		//방법1] 다형성 : 다양한 타입으로 변환 가능한 성질
		Box3 box3 = new Box3();
		box3.content ="안녕하세요";
		String content3 = (String)box3.content; //강제타입변환 ,부모(object)---> 자식(String),다운캐스팅
		box3.content = 100;
		int content4 =(Integer)box3.content;
		//방법 2 ]제네릭 타입 : 클래스 내 멤버변수 타입을 인스턴스 생성할때 정하기
		Box4<String>box4 = new Box4<String>();
		box4.content ="안녕하세요";
		String content5 = box4.content;
		box4<Integer>box5 = new Box4()<>();
		
	}//m end

}//c end

class Box1{
	String content;
}

class Box2{int content;}
class Box3{Object content;}
class Box4<T>{
	//클래스명<제네릭타입>
	T content;
}
class Dto{}
class point<T,V>{
	T value1;
	V value2;
}