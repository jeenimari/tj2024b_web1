package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		MemberDao dao = new MemberDao();
		List<MemberVO> list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		for (int i = 0; i<list.size(); i++) {
			MemberVO memberVO = list.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String emailString = memberVO.getEmail();
			
			int joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>"+pwd+"</td><td>"
					+name+"</td><td>"+ emailString + "</td><td>"
					+joinDate + "</td></tr>"
					);
		}// for end
		out.print("</table></body></html>");
		
	}// get end
}// class end
