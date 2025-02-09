package webpractice0131;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalServlet extends HttpServlet {
	 private static final float USD_RATE = 1332.50F;  // 달러 환율
	    private static final float JPY_RATE = 8.97F;     // 엔화 환율
	    private static final float CN_RATE = 185.58F;    // 위안화 환율
	    private static final float GBP_RATE = 1691.31F;  // 파운드 환율
	    private static final float EUR_RATE = 1447.76F;  // 유로 환율
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		String command = req.getParameter("command");//1 수행할 요청 받아오기
		String won = req.getParameter("won");//2 변환할 원화 받아오기
		String operator = req.getParameter("operator");//3변환활 외화 종류 받아오기
		
		// 4 최초 요청시 command가 null이면 계산기 화면을 출력하고 command 값이 calculate이면 계산 결과 출력
		if(command!=null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won),operator);
			System.out.println("계산된 결과값: " + result); // 디버깅용 출력문
			pw.print("<html>");
		    pw.print("<head><title>환율 계산 결과</title></head>");
		    pw.print("<body>");
		    pw.print("<h1>변환 결과</h1>");
		    pw.print("<p style='font-size:24px'>" + result + "</p>");
		    pw.print("<a href='calc'>환율 계산기로 돌아가기</a>");
		    pw.print("</body>");
		    pw.print("</html>");
			return;
		}// if end
		
		pw.print("<html>");
        pw.print("<head><title>환율 계산기</title></head>");
        pw.print("<body>");
        pw.print("<h2>환율 계산기</h2>");
        pw.print("<form name='frmCalc' method='get' action='calc'>");
        pw.print("원화: <input type='text' name='won' size=10 />");
        pw.print("<select name='operator'>");
        pw.print("<option value='dollar'>달러</option>");
        pw.print("<option value='en'>엔화</option>");
        pw.print("<option value='wian'>위안</option>");
        pw.print("<option value='pound'>파운드</option>");
        pw.print("<option value='euro'>유로</option>");
        pw.print("</select>");
        pw.print("<input type='hidden' name='command' value='calculate' />");
        pw.print("<input type='submit' value='변환' />");
        pw.print("</form>");
        pw.print("</body>");
        pw.print("</html>");
        pw.close();
		
		
	}// f end
	
	private static String calculate(float won,String operator) {
		String result = null;
		if(operator.equals("dollar")) {
			result = String.format("%.6f",won/USD_RATE);
		}else if(operator.equals("en")) {
			result = String.format("%.6f", won/JPY_RATE);
		}else if(operator.equals("wian")) {
			result = String.format("%.6f", won/CN_RATE);
		}else if(operator.equals("pound")) {
			result = String.format("%.6f", won/GBP_RATE);
		}else if(operator.equals("euro")) {
			result = String.format("%.6f", won/EUR_RATE);
		}
		return result;
	}
}//c end
