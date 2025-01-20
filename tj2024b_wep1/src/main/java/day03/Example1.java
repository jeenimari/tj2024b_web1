package day03;

import java.io.IOException;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/day03/example1")
//1단계 : 임의의 클래스의 extends httpservlet  
//2단계  : (web.xml 자동처리) 선언된 클래스위에 @webServelt("/주소정의")
//3단계 : http method 매핑 메소드들을 재정의( 오버라이딩 )  
public class Example1 extends HttpServlet {
	
	//do post
	@Override // http: //localhost:8080/day03/example?data1=유재석&data2=40;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dopost 방식으로 요청이 옴");
		String data1 = req.getParameter("data1") ; System.out.println("data1: " + data1);
	
		int data2 = Integer.parseInt(req.getParameter("data2")); System.out.println("data2:"+data2);
	}// post end
	
	//doget
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doget 방식으로 요청이 옴");
		String data1 = req.getParameter("data1") ; System.out.println("data1: " + data1);
		
		int data2 = Integer.parseInt(req.getParameter("data2")); System.out.println("data2:"+data2);

	}
	
	//doput
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doput 방식으로 요청이 옴");
		String data1 = req.getParameter("data1") ; System.out.println("data1: " + data1);
		int data2 = Integer.parseInt(req.getParameter("data2")); System.out.println("data2:"+data2);
	}
	
	//do delete
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("dodelete 방식으로 요청이 옴");
		String data1 = req.getParameter("data1") ; System.out.println("data1: " + data1);
		int data2 = Integer.parseInt(req.getParameter("data2")); System.out.println("data2:"+data2);
	}



}// class end
