package boardpractice;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/boardpractice/board")
public class BoardController extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	System.out.println("POST OK");
	 // 1. HTTP BODY 로 요청된 데이터들을 JSON --> DTO로 변환 
    ObjectMapper mapper = new ObjectMapper();
    BoardDto boardDto =  mapper.readValue( req.getReader() , BoardDto.class );
    // 2. DAO 처리 
    boolean result = BoardDao.getInstance().boardWrite( boardDto );
    // 3. DAO 처리 응답
    resp.setContentType("application/json");
    resp.getWriter().print( result );
}
	

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	System.out.println("GET OK");
	
	// 1.  X
    // 2. DAO 처리 
    ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
    // 3. 결과 응답 
    ObjectMapper mapper = new ObjectMapper();
    String jsonResult  = mapper.writeValueAsString( result );
    resp.setContentType("application/json");
    resp.getWriter().print( jsonResult );
	}


@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PUT OK");
		//HTTP 요청의 BODY 본문을 DTO로 변환하기
		ObjectMapper mapper = new ObjectMapper();
		BoardDto boardDto = mapper.readValue(req.getReader(),BoardDto.class);
		
		
		//2. DAO 처리
		boolean result = BoardDao.getInstance().update( boardDto ); // dto로 변환된 본문 을 dao에게 전달하고 sql 처리 결과받기
		
		
		//3.결과를 HTTP 응답하기
	resp.setContentType("application/json");
		resp.getWriter().print(result);
	}


@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	System.out.println("DELETE OK");
	
	
	 // 1. HTTP 요청의 쿼리스트링 매개변수 가져오기 
    // req.getParameter("bno");          - 쿼리스트링의 bno 이라는 매개변수 값 반환 
    // Integer.parseInt( 문자열 );        - 문자열타입 --> 정수타입 
	int bno = Integer.parseInt( req.getParameter("bno") ) ; 
	// 2. DAO 처리 
    // DAO 로 부터 매개변수를 전달하고 SQL 처리 결과를 받기 
	boolean result = BoardDao.getInstance().delete(bno); 
	// 3. 결과를 HTTP 응답 하기.
    // HTTP 응답 할 content-type 설정 
    // HTTP 응답 자료를 보내기.
	resp.setContentType("application/json");
	resp.getWriter().print(result);
	
	}
}//class end

