package webpractice0131;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/webpractice0131/login3")
public class LoginServlet3 extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		System.out.println("아이디:" + user_id);
		System.out.println("비밀번호:" + user_pw);
		
		PrintWriter out = resp.getWriter();
	    out.println("<html><body>");
	    out.println("아이디: " + user_id + "<br>");
	    out.println("비밀번호: " + user_pw);
	    out.println("</body></html>");
	}
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}// class end
