package day03.task4;

import java.io.IOException;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting2")
public class WaitingController extends HttpServlet {

	//- 요청데이터는 post 와 put 매핑은 body 로 , get 와 delete 매핑은 queryString 사용합니다. 
    // 응답은 모두 applicartion/json 타입으로 응답 합니다.

	//1.대기번호등록  doPost()   // 매핑 body  
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		WaitingDto waitingDto = mapper.readValue(req.getReader(),WaitingDto.class);
		
		//다오처리
		boolean result = WaitingDao.getInstance().write(waitingDto);
		
		//다오 결과를 헤더바디로 응답보내기
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}//f end
	
	//2.대기전체 조회 doGet()   //매핑은 queryString 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ArrayList<WaitingDto>result = WaitingDao.getInstance().findAll();
		ObjectMapper mapper = new ObjectMapper(); 
		String jsonResult = mapper.writeValueAsString(result);
		
		//응답
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		
	}// fend
	
	//3.대기개별수정 doUpdate()   //매핑은 queryString 
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		ObjectMapper mapper = new ObjectMapper();
	       WaitingDto waitingDto = mapper.readValue(req.getReader(), WaitingDto.class);
	       System.out.println("수정할 정보: " + waitingDto);  // 로그 확인용
	       
	       // DB에서 수정 처리
	       boolean result = WaitingDao.getInstance().findByWno(waitingDto);
	       
	       // 결과 응답
	       resp.setContentType("application/json");
	       resp.getWriter().print(result);
	       System.out.println("수정 결과: " + result);
	   }
	
	//4.대기개별 삭제  doDelete()
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 int wno = Integer.parseInt(req.getParameter("wno"));
		 boolean result = WaitingDao.getInstance().delete(wno);
		 resp.setContentType("application/json");
	       resp.getWriter().print(result);
	       System.out.println("대기번호 삭제결과: " + result);
	}// f end
	
}//class end
