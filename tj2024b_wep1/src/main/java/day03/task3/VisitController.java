package day03.task3;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/visit2")
public class VisitController extends HttpServlet {

	//방문록 등록   :POST     , 매개변수 : BODY     매개변수 예 ] {"content " : "안녕 "  ,"age" : "30"   url :  http ://localhost:8080/tj2024b_web1/day03/visit2
	//반환타입 : application/json      , 매개변수  예 ] true 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1.HTTP로부터 요청 받은 HTTP  HEADER BODY(본문) 을 가져오기 
		ObjectMapper mapper = new ObjectMapper();
		VisitDto visitDto =  mapper.readValue(req.getReader(),VisitDto.class);
		
		//2.Dao 처리 
		boolean result = VisitDao.getInstance().write(visitDto);
		
		
		//Dao 결과를 HTTP HEADER BDOY (본문)으로 응답(response) 보내기
		resp.setContentType("application/json ");   //(1)  응답할 자료의 타입 명시
		resp.getWriter().print(result);					//(2)  응답 자료보내기.  
		
	}// f end
	
	//방문록 전체조회  : GET   url :  http ://localhost:8080/tj2024b_web1/day03/visit2
	//반환타입  : application/json , 매개변수 예 ] [{"num" : 1 , "content": "수정안녕 " , "age " : 40 }]
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//1.매개변수 없음
		//2. DAO 처리
		ArrayList<VisitDto> result = VisitDao.getInstance().findAll();
	
		//3. DAO 결과를 HTTP HEADER BODY(본문) 으로 응답(RESPONSE) 보내기
			// 자바객체(DTO) --> JSON 타입변환
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);  // 
		
				
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
				
		
		
	}//f end
	
	// 방문록 수정	: PUT   url :  http ://localhost:8080/tj2024b_web1/day03/visit2
	//매개변수 : BODY , 매개변수 예] {"num" : 3, " content" : "수정안녕"  , "age" :40 }
	//반환타입 : application/json , 매개변수 , 예 ] true
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	ObjectMapper mapper = new ObjectMapper();
		
		VisitDto visitDto = mapper.readValue(req.getReader(),VisitDto.class);
		//2. DAO 처리
		boolean result = VisitDao.getInstance().update(visitDto);
		
		//3.DAO 결과를 HTTP HEADER BODY(본문)으로 응답(response)보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	
	}
		
	

		

	
	//방문록 삭제   : DELETE  //url :  http ://localhost:8080/tj2024b_web1/day03/visit2?num=1
	//매개변수 : queryString , 매개변수 예] ?bnum = 1
	
	@Override  
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.HTTP 로 요청받은 HTTP의 queryStirng 의 매개변수 가져오기 
		int num = Integer.parseInt(req.getParameter("num") );
		//2.DAO 처리
		boolean result = VisitDao.getInstance().delete(num);
		//3. DAO 의 결과를 HTTP HEADER BODY(본문)으로 응답(RESPONSE) 보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}//fend
	
}// class end
