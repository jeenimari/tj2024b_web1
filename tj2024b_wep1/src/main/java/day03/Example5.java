package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day03/example5")
public class Example5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP GET 방식으로 요청이 왔습니다]");
		boolean result =true;   //응답할(보낼자료 준비)
		resp.setContentType("application/json");// HTTP를 이용한 응답 헤더정보 추가 , .set  ContentType()
		resp.getWriter().print(result);  //HTTP를 이용한 요청에 따른 응답 자료 보내기
		

	} //f end
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = "java";
		resp.setContentType("text/plain");
		resp.getWriter().print(result);
	}// f end
	
	@Override    //내장객체 = 이미 준비된 객체 
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 30;
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataDto result = new DataDto("유재석", 40);
		//DTO에서 JSON으로 타입변환 
		//1.ObjectMapper 인스턴스 생성
		ObjectMapper mapper = new ObjectMapper(); // 오브젝트 매버 인스턴스생성
		String jsonResult =  mapper.writeValueAsString(result); //.writeValueAsString(변환할객체):지정한 객체를 JSON형식으로 변환 함수.		
		resp.setContentType("application/json");  // 오류 : DTO를 JSON으로  타입변환 불가능
		resp.getWriter().print(jsonResult);
		
	}// f end
	
}// class end
