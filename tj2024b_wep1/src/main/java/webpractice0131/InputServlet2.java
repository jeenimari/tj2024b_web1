package webpractice0131;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/webpractice0131/input2")
public class InputServlet2 extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("init 메서드 호출");
	}// f end
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		try {
		//전송되어 온 name 속성들만 Enumeration 타입으로 받아옴 열거라는뜻
		Enumeration enu = req.getParameterNames();
		//각 name 을 하나씩 가져와 대응해서 전송되어 온 값을 출력
		while(enu.hasMoreElements()) {
			String name =(String) enu.nextElement();
			String[] values = req.getParameterValues(name);
			for(String value : values) {
				System.out.println("name="+ name + ",value=" + value);
			}
		}// while end
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void destroy() {
		System.out.println("destory 메서드 호출");
	}
} // class end
