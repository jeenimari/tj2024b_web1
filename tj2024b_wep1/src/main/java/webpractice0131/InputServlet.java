package webpractice0131;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/webpractice0131/input")
public class InputServlet extends HttpServlet {

	private void inint() {
		
		System.out.println("inint 메소드 호출 ok");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pw);
		String[] subject = req.getParameterValues("subject"); //한개의 전소된 값은 getparameter이용 이건 여러개 배열 형태로 반환됨
		for(String str : subject) {
			System.out.println("선택한 과목:" + str);
		}
		
		
	}// fend
	public void destory() {
		System.out.println("destory 메서드 호출");
	}
	
}// c end
