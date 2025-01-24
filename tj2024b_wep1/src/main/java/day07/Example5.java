package day07;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day07/example5")
public class Example5 extends HttpServlet {

	private ArrayList<HashMap<String, String>> list = new ArrayList<>();
	//DTO를 사용하지 않는 상황 : 일회성 이동객체 , DTO 의 멤버변수 정의가 명확하지 않을때 한번쓰고버릴때 등
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/day07/example5 POST OK");
		//1.HTTP 요청에 따른 JSON 타입을 DTO 변환 DTO 대신 MAP으로 자동타입변환
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String>map = mapper.readValue(req.getReader(), HashMap.class);
		System.out.println(map);
		//2.DB 처리
		list.add(map);
		
		//3.HTTP 응답처리
		resp.setContentType("applicaition/json");
		resp.getWriter().print(true);
		
//		String reqData = req.getParameter("data");
//		list.add(reqData);
//		resp.getWriter().print("데이터추가 :" + reqData);
    }
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		System.out.println("/day07/example5 GET OK");
		//1.요청매개변수 없음
		//2.DB처리
		//3.HTTP 응답처리
		ObjectMapper mapper = new ObjectMapper(); 
		String jsonResult = mapper.writeValueAsString(list);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);

//		resp.setContentType("application/json");
//		PrintWriter out = resp.getWriter();
//		out.print("<h3>name:유재석 age : 30</h3>");
//		for(String item : list) {
//		   out.print(item + "<br>");
//	}
	}
}

