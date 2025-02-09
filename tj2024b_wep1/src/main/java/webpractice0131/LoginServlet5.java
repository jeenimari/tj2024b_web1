package webpractice0131;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/webpractice0131/login5")
public class LoginServlet5 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init메서드 호출");
		//서블릿 객체 생성 → init() 호출 → service()/doGet()/doPost() 호출 → destroy() 호출
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user-pw");
		//히든 태그로 전송된 값을 받음
		String address = req.getParameter("user_address"); 
		
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		
		String data ="<html>";
		data +="<body>";
		data +="아이디 :" + id;
		data +="<br>" ;
		data +="비밀번호" + pw;
		data +="<br>" ;
		data +="주소:" + address ;
		data +="<body>" ;
		data +="</html>";
		out.print(data);
				
	} // fend
	
	@Override
	// 전송된 값을 웹 브라우저로 출력 
	public void destroy() {
		System.out.println("destory 메서드호출");
	}
} //class end
