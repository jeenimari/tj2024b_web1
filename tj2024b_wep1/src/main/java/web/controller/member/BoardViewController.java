package web.controller.member;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.model.dao.BoardDao;
import web.model.dto.BoardDto;
@WebServlet("/member/view")
public class BoardViewController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET GOGO");
	
	//개별 조회할 게시물 번호를 HTTP 쿼리스트링의 매개변수 값 가져오기
	 int bno = Integer.parseInt(req.getParameter("bno"));
	//다오에게 조회할 게시물 번호 전달 결과 응답받기
	BoardDto boardDto = BoardDao.getInstance().findByBno();
	//3. DTO를 JSON으로 변환
	ObjectMapper mapper = new ObjectMapper();
	String jsonResult = mapper.writeValueAsString(boardDto);
	 //4.다오타입 변환된 JSON 형식의 문자열 타입 자료를  Http response 응답하기
	 resp.setContentType("application/json");
	 resp.getWriter().print(boardDto);
	}// fend
}
