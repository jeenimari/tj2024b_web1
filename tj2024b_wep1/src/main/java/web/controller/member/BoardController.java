package web.controller.member;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import web.model.dao.BoardDao;
import web.model.dao.MemberDao;
import web.model.dto.BoardDto;
import web.model.dto.MemberDto;

@WebServlet("/member/board")
public class BoardController extends HttpServlet {

	//[1]게시물 쓰기 컨트롤러
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("write POST OK");
		// JSON 문자열 --> 특정한 자바 객체 타입으로 변환 기능을 제공하는 라이브러리 객체 생성 
        ObjectMapper mapper = new ObjectMapper(); 
        // HTTP 의 request Body 로 부터 JSON 문자열을 읽어와서 BoardDto 타입으로 변환하는 readValue 함수 실행 
        BoardDto boardDto = mapper.readValue( req.getReader() , BoardDto.class );
        
       
        	//현재 로그인된 회원번호를 세션에서 찾아 boardDto 담아주기.
        	HttpSession session =req.getSession();
        	Object object= session.getAttribute("loginMno"); 
        			if(object!=null) {
        				//Object 타입--> int /Integer 타입으로 변환하기
        				int logingMno = (Integer)object;
        				boardDto.setMno(logingMno);;   
        					}// if end
		
		
       
        
        
        // 읽어온 자료를 dao 에게 전달하고 결과를 받는다. 
        boolean result = BoardDao.getInstance().write( boardDto );
        // HTTP 로 부터 response 
        resp.setContentType( "application/json" );
        resp.getWriter().print( result );
		
		
	}// f end
	
	//[2] 게시물 전체조회 컨트롤러
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<BoardDto>result = BoardDao.getInstance().finAll();
		
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonResult = mapper.writeValueAsString(result);
		
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
				
		
	}// f end
	
	//[3]게시물 개별 삭제 컨트롤러
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DELETE GOGO");
		//1.HTTP queryString 매개변수 가져오기
		int bno = Integer.parseInt(req.getParameter("bno"));
		
		boolean result = BoardDao.getInstance().delete(bno);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}// f end
	
	//4.게시물 개별 수정 update SQL 메소드
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("PUT GOGO");
		ObjectMapper mapper = new ObjectMapper();
		
		BoardDto boardDto = mapper.readValue(req.getReader(),BoardDto.class);
		
		boolean result = BoardDao.getInstance().update();
	
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}// f end
	
	
	
}
