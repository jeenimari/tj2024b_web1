package day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Example2 {
	public static void main(String[] args) {
		//[2]파일의 자료를 자바로 가져오기
		try {
		FileInputStream input = new FileInputStream("c:/Java/test1.txt");
		//(2)바이트 배열선언 , 임의의 크기 10(영문 한글자당 1바이트)
		byte[] bytes = new byte[10];  
		//(3)파일내 자료를 바이트열로 읽어오기
		input.read(bytes);
		//(4)바이트 배열을 문자열로 변환, new String(바이트 배열 변수명) 
		String str = new String(bytes);
		System.out.println(str);
		System.out.println("파일 불러오기 성공");
		}catch (FileNotFoundException e) {
			System.out.println(e);
			
		}
		catch (IOException e) {
			System.out.println(e);
			
		}
		//[3]파일 클래스
			//(1) 지정한 경로의 파일을 자바객체와 연결하기
		File file = new File("c:/java/test1.txt");
			//(2) 파일 존재 여부 확인 메소드
		System.out.println(file.isFile());
			//(3) 파일 이름 반환 메소드
		System.out.println(file.getName());
			//(4)파일 (바이트)용량
		System.out.println(file.length());
			//(5)파일 삭제함수.
		System.out.println(file.delete()); 
			//(6)파일 경로 확인
		System.out.println(file.getPath());
		File file2 = new File("c:/java2");
		if(!file2.exists()) { // 만일 자바2 폴더가 존재하지 않으면
			file2.mkdir(); // 지정한 경로의 폴더 생성 함수 
		}
		
	}//m end
}// c end
