package day02.task1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day02/waiting")
public class WaitingController  extends HttpServlet{
	
	
	//1. 예약신청메소드 CRUD중 C
	@Override  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		int phone = Integer.parseInt(req.getParameter("phone"));
		int pno = Integer.parseInt(req.getParameter("pno"));
		
		boolean result = WaitingDao.getInstance().waitingNum(phone, pno);
		System.out.println(result);
	}//f end
	
	//2.예약 조회 메소드
	
	
	//3.예약수정 메소드
	
	
	//4.예약삭제 메소드
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int wno = Integer.parseInt(req.getParameter("wno"));
		boolean result = WaitingDao.getInstance().delete(wno);
		System.out.println(result);
	}

}
