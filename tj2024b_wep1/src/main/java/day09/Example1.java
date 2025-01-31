package day09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Example1 {
	public static void main(String[] args) {
		
		//[1] 실행중인 자바 자료를 윈도우파일에 출력하기
		//C 드라이브에 Java 폴더 하나 생성
		//예외처리 거의 무조건으로 예외처리해야함
		try {
			//(1) 파일출력스트림 객체 생성 . -1 . 파일경로 2.예외처리
		FileOutputStream out = new FileOutputStream("c:/Java/test1.txt");
		String str = "Hello JAVA";
		 byte[] outStr= str.getBytes(); // 겟바이트 : 스트링을 바이트[] 반환 함수
		out.write(outStr);
		System.out.println("파일저장 성공ㅋ");
		}catch(FileNotFoundException e) {System.out.println(e);}
		catch(IOException e) {System.out.println(e);}
		
		
		//[2]키보드로부터 입력받은 자료를 파일에 출력하기. 
		try {
		FileOutputStream out = new FileOutputStream("c:/java/test2.txt");
		Scanner scan = new Scanner(System.in);
		System.out.println("[2]메모장에 작성할 내용입력:");
		String str = scan.nextLine();
		byte[] outStr= str.getBytes();
		out.write(outStr);
		System.out.println("메모장내용 저장 성공");
		}catch ( IOException e) {
			System.out.println(e);
			// TODO: handle exception
		}
	}// m end

}//c  end
