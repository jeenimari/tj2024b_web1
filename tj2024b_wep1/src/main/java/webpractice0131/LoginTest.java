package webpractice0131;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loginTest")
public class LoginTest extends HttpServlet{

	public void inint() {
		
		System.out.println("init 메서드 호출");

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		System.out.println("아이디 : " + id);
		System.out.println("패스워드:" + pw);
		
		if(id!=null &&(id.length()!=0)) {
			out.print("<html>");
			out.print("<body>");
			out.print(id+"님!! 로그인 하셨습니다.");
			out.print("</body>");
			out.print("</html>");
		}else { //ID 와 비밀번호가 없으면 다시 로그인창으로 이동합니다.
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요!!");
			out.print("<br>");
			out.print("<a href='http://localhost:8080/webpractice0131/login.html'>로그인 창으로 이동</a>");
			out.print("</body>");
			out.print("</html>");
		}// if end
	}// f end
	
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}//class end
