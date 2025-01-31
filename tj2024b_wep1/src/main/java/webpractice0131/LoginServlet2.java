package webpractice0131;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/webpractice0131/login2")
public class LoginServlet2 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		
		System.out.println("init 메서드 호출");
	}
	
	@Override   								//1.응답은 HttpservletReonse 객체이용 rsp로함
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//2.웹 브라우저에 전송된 데이터의 인코딩을 설정
		req.setCharacterEncoding("utf-8");
		//3.setContentType()을 이용해 응답할 데이터 종류가 HTML임을 설정
		resp.setContentType("text/html;charset=utf-8");
		//4.HTTPServletResponse 객체의 getWriter()를 이용해 출력 스트림 printWriter 객체를 받아옴
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		//브라우저로 출력할 데이터를 문자열로 연결해서 HTML 태그 로 만듬
		String data = "<html>";
			data +="<body>";
			data += "아이디"+ id;
			data += "<br>";
			data += "패스워드 : " + pw; 
			data += "</body>";
			data += "</html>";
			//printWriter의 print()를 이용해 HTML 태그 문자열을 웹 부라우저로 출력
			out.print(data);
					
	}// f end
}
