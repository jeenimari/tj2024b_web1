package day05.controller;

import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import day05.model.dao.BoardDao;
import day05.model.dto.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

@WebServlet("/day05/board") //http://localhost:8080/tj2024b_wep1/day05/board
public class BoardController extends HttpServlet {
   
	// 1. 전체목록과 등록을 처리하는 서블릿

	    
	    private BoardDao boardDao = BoardDao.getInstance();
	    private ObjectMapper objectMapper = new ObjectMapper();
	    
	    // 전체 게시물 목록 조회
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        // 전체 목록 조회
	        response.setContentType("application/json;charset=UTF-8");
	        response.getWriter().print(
	            objectMapper.writeValueAsString(boardDao.findAll())
	        );
	    }
	    
	    // 게시물 등록
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        // JSON 요청 데이터를 DTO로 변환
	        BoardDto boardDto = objectMapper.readValue(request.getReader(), BoardDto.class);
	        
	        // DAO 호출하여 DB 처리
	        boolean result = boardDao.write(boardDto);
	        
	        // 응답 설정
	        response.setContentType("application/json");
	        response.getWriter().print(objectMapper.writeValueAsString(Map.of("success", result)));
	    }
	    
}//class end
  
