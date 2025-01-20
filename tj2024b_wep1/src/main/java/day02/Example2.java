package day02;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day02/example2") //http://localhost:8080/tj2024b_wep1/day02/example2
public class Example2 extends HttpServlet {

	//1.do get
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println("사용자가 서버로부터 get 메소드로 요청했습니다.");
	
		// 쿼리스트링의 매개변수 가져오기
			// .getParameter("URL 경로상의 매개변수명") ;  //매개변수명의 값 (String 타입)반환 함수 , 없으면  Null ,
		System.out.print("1]URL ? 뒤에 'name'이라는 매개변수명을 가진 변수의 값 가져오기 : ");
		System.out.println(req.getParameter("name"));
			
		System.out.println("1]URL? 뒤에 'age'라는 매개변수명을 가진 변수의 값 가져오기:");
		System.out.println(req.getParameter("age"));
	
	
	}
	
	//2. do post
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doPost(req, resp);
	System.out.println("|n3 2] 사용자가 서버로부터 post 메소드로 요청했습니다.");
	String name = req.getParameter("name");
	String age = req.getParameter("age");
	System.out.printf("name: %s , age : %s" , name , age);
	
	}
	//3.doput
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3] 사용자가 서버로부터 put 메소드로 요청했습니다.");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name: %s , age : %s" , name , age);
	
	}
	
	//4.doDelete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("4]사용자가 서버로부터 delete 메소드로 요청했습니다. ");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		System.out.printf("name: %s , age : %s" , name , age);
	}
	
	
}// class end
