package webpractice0131;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guguTest")
public class GuguTest extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init  메서드 호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		int dan = Integer.parseInt(req.getParameter("dan"));
		
		out.print("<table border=1 width=800 align=center>");
		out.print("<tr align=center bgcolor='#FFFF66'>");
		out.print("</tr>");
		
		for(int i = 1; i<10; i++) {
			
			out.print("<tr align=center>");
			out.print("<td width=400>");
			out.print(dan+"*" + i);
			out.print("</td>");
			out.print("<td width=400>");
			out.print(i*dan);
			out.print("</td>");
			out.print("</tr>");
			
		}// for end
		out.print("</table>");
	
	}
	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}
}// class end
