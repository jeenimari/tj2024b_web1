package day04;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day04/example1")
public class Example1 extends HttpServlet{
	
	//queryString 예시
	
	@Override          
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value1 = req.getParameter("value1");
		int value2 = Integer.parseInt(req.getParameter("value2"));
		System.out.println("value1: " + value1);
		System.out.println("value2: " + value2);
		
		//2.응답 HTTP header body
		boolean result = true;
		resp.getWriter().print(result);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}// f end
	
	
	//2.HTTP header body(본문 ) 예 ] http://localhost:8080/tj2024b_web1/day04/example1
	@Override    
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.요청 바디 제이슨타입 -> DTO 변환
		ObjectMapper mapper = new ObjectMapper();
		ValueDto valueDto = mapper.readValue(req.getReader( ),ValueDto.class);
		System.out.println(valueDto);
		
		//2. 응답 HTTP header body
		ValueDto result = new ValueDto("강호동",23);
			String jsonResult= mapper.writeValueAsString(result);  //DTO 는 JSON 으로 자동변환할 수 없음
		resp.setContentType("application/json"); //DTO 는 JSON 으로 자동변환할 수 없음
		resp.getWriter().print(result); 
		
	}

}// class end
