package day03;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day03/example3")
public class Example3 extends HttpServlet {

	@Override
	//HTTP POST BODY : http://localhost 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// * JSON 자료의 문자열 타입을 DTO 로 변환해보기 .(json은 JS언어에서 사용 하는 타입 JAVA는 DTO를 사용하기때문)
		
		System.out.println("[HTTP *POST 방식으로 요청이 왔어요.]");
		//System.out.println(req.getReader().readLine()); //단순한 문자열을 읽어옴.
		//JSON 모양의 문자열 타입 자료를 DTO로 변환 라이브러리 : json 라이브러리
		ObjectMapper mapper = new ObjectMapper();
		//req.getReader() 객체의 자료(JSON)들을 DTO 객체로 변환 함수.
		//.readValue(JSON 데이터 자료 ,변환할 객체타입.class) 
		DataDto dataDto = mapper.readValue(req.getReader(), DataDto.class);
		System.out.println(dataDto);
		
	}// f end
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[HTTP *put 방식으로 요청이 왔어요.]");
		//System.out.println(req.getReader().readLine());
		
		ObjectMapper mapper = new ObjectMapper();
		DataDto dataDto = mapper.readValue(req.getReader(),DataDto.class);
		System.out.println(dataDto);
	}
	
}// class end
