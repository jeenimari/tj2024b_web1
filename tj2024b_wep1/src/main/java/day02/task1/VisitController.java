package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//컨트롤러 : view 와 dao 사이의 중간다리 역할 ,(서블릿) 매핑/연결 역할

@WebServlet("/day02/visit")// [2]매핑 주소 정의
public class VisitController extends HttpServlet{ //서블릿상속
	
	//[3] HTTP METHOD 들을 재정의한다.
	
	//1.방문록 등록 (쿼리스트링) : CREATE  [C]
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.URL 상의 쿼리스트링 매개변수를 가져온다 . 내용,나이
		String content = req.getParameter("content");
		int age = Integer.parseInt(req.getParameter("age"));
			// Integer.parseInt로 강제 타입변환시켜서 오류가나지않게함
		
		//2.매개변수를 DAO 에게 전달하고 결과를 받는다 .
		boolean result = VisitDao.getInstance().write(content,age);
		System.out.println(result);
	}// fe end
	
	//2.방문록 조회 X                : READ [R]   doGet
	
	
	//3.방문록 수정					: UPDATE[U]  doPut
	
	
	//4. 방문록 삭제  (쿼리스트링)  : DELETE [D]
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. URL 상의 쿼리스트링 매개변수를 가져옴 . 삭제할번호 PK
		int num = Integer.parseInt(req.getParameter("num"));//문자타입을 정수타입변환
		//2.매개변수를 DAO에게 전달하고 결과 받음
		boolean result = VisitDao.getInstance().delete(num);
		System.out.println(result);
	}//f end
}
