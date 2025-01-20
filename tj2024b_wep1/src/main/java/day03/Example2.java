package day03;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/example2")
public class Example2 extends HttpServlet {
	
	//queryString 방식이 아닌 HTTP body( 본문 ) 활용 .
	//!!!! : HTTP body(본문)은 post , PUT METHOD 에서 사용지원. 관례적으로 권장 .
	
	@Override   //HTTP POST BODY // http://localhost:8080/day03/example2 
	// Content-Type : application/json , body : 본문내용입니다. 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("[HTTP *POST 방식으로 요청이 왔어요.]");
	System.out.println(req.getReader());					//요청할때 마다 객체가 바뀜 (HTTP 무상태)
	System.out.println(req.getReader().readLine());  // HTTP 본문의 내용들을 한줄 읽어서 반환하는 함수
	
	}// dopost end

	@Override   //HTTP PUT BODY // http://localhost:8080/day03/example2
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *POST 방식으로 요청이 왔어요.]");
		System.out.println(req.getReader());
		System.out.println(req.getReader().readLine());  // HTTP 본문의 내용들을 한줄 읽어서 반환하는 함수
	}//doput end
	
}// class end
