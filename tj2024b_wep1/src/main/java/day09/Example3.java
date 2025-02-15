package day09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/day09/example3")
public class Example3 extends HttpServlet{
	private ArrayList<HashMap<String, String>>list = new ArrayList<>();
	private String filePath = "c:/java";
	//1.dopost : 파일쓰기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//*여러개 map( DTO대용) 를 저장할 list 선언
		
		//(1)HTTP 요청 Body 자료들을 hashMAP 타입으로 매핑하기
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String>map = mapper.readValue(req.getReader(),HashMap.class);
		
		//(2) 입력받은 map을 list로 저장
		list.add(map);
		//(3)만약에 지정한 경로가 존재하지 않으면 폴더 경로 생성
		File file = new File(filePath);
		if(!file.exists()) {file.mkdir();}
		//(4) 출력 스트림 객체
		FileOutputStream out = new FileOutputStream(filePath+"/tesx3.txt");
		//(5)출력할 내용물 , list 타입을( JSON 형식) 문자열 타입으로 변환
		String outStr = mapper.writeValueAsString(list); 
		//(6)출력할 내용물 byte로 변환
		byte[] bytes = outStr.getBytes();
		//(7)바이트 출력/내보내기
		out.write(bytes);
		
	}// f end
	
	//2.파일 내용 가져오기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1.지정한 파일경로의 파일 객체 가져오기
		File file = new File(filePath+"/tesx3.txt");
		if(!file.exists()) { // 만일 파일이 존재하지 않으면
			System.out.println("파일이 존재하지 않습니다.");
			resp.setContentType("text/plain");
			resp.getWriter().print("파일이 존재하지 않습니다.");
		}else {
			//3. 파일의 자료들을 arraylist 타입으로 변환 
			ObjectMapper mapper = new ObjectMapper();
			//mapper.readvalue(req.getReader() 혹은 file, 
		ArrayList<HashMap<String, String>> list =	mapper.readValue(file, ArrayList.class);
			//4. 내보내기 (응답)  읽어온 파일의 list 내용들을 다시 json 문자열로 변환
		String jsonResult =  mapper.writeValueAsString(list);
		//5.
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
		}
	}
	
}// c end
