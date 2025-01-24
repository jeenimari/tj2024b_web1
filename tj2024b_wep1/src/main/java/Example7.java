import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/day07/example7")
public class Example7 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//[1]톰캣 안에 있는 객체 호출 및 첫 HTTP 요청 생성
		HttpSession httpSession = req.getSession();
		System.out.println(httpSession);
		
		//[2] 세션 객체의 주요 메소드
		System.out.println(httpSession.getAttributeNames()); //세션 객체내 모든 속성 반환 함수
		System.out.println(httpSession.getCreationTime());    // 세션 객체가 만들어진 시간
		System.out.println(httpSession.getId( ) );					// 세션 객체의 아이디/식별자
		System.out.println(httpSession.getLastAccessedTime()); //마지막 세션 객체 사용시간
		System.out.println(httpSession.isNew()); 					//새로 만들어진 세션 인지 여부 반환
	
	//[3] 세션 객체의 속성명 과 속성값
	httpSession.setAttribute("세션 속성1" , "유재석");
	
	//[4] 세션 객체의 지정한 속성명의 값 호출
	Object object = httpSession.getAttribute("세션속성1");
	System.out.println((String)object );
	
	//[5] 세션 객체의 지정한 속성 제거
	httpSession.removeAttribute("세션속성1");
	
	// httpSession.getAttributeNames( ) : 세션 객체내 모든 속성들을 collections 객체로 반환함수.
	//httpSession.getCreationTime( )  : 세션객체가 만들어진 시간 , 시 분 조 환산필요
	//httpSession.getId() 	: 세션 객체가 마지막으로 사용된 시간 , 시 분 초 환산 필요
	//.httpSession.isNew( ) : 세션객체가 방금 만들어졌는지 여부 반환 , true/false
	
	
	}
	
	
}

