package day03.task2;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import day03.task1.VisitDao;
import day03.task1.VisitDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day03/waiting")
public class WaitingController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue(req.getReader(),WaitingDto.class);
		
		//디비 저장
		boolean result = WaitingDao.getInstance().write(waitingDto);
		
	
		//결과 응답
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println("대기번호 등록결과: "  + result);
	}
	
	@Override// 대기번호 삭제
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// URL  파라미터에서 삭제할 번호가져오기
		
		int num = Integer.parseInt(req.getParameter("num"));
		System.out.println("삭제할 대기번호 : " + num);
		
		//db 삭제처리
		boolean result = WaitingDao.getInstance().delete(num);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
		System.out.println("대기번호 삭제 결과 : " + result);
	}
	
	
} // class end
