package day8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/day08/waiting")
public class WatingController extends HttpServlet {

	  private ObjectMapper objectMapper = new ObjectMapper();
	    
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 대기명단 등록 처리
	     
	        HttpSession session = req.getSession();
	        
	        // waitingList: 대기자 목록
	        // waiting (대기하는), list (목록)
	        @SuppressWarnings("unchecked")
	        ArrayList<HashMap<String, Object>> waitingList = 
	            (ArrayList<HashMap<String, Object>>) session.getAttribute("waitingList");
	        
	        if (waitingList == null) {
	            waitingList = new ArrayList<>();
	            session.setAttribute("waitingList", waitingList);
	        }
	        
	        // waitingNumber: 대기 번호
	        // waiting (대기하는), number (번호)
	        int waitingNumber = waitingList.size() + 1;
	        
	        // waitingInfo: 대기 정보
	        // waiting (대기하는), info (정보)
	        HashMap<String, Object> waitingInfo = new HashMap<>();
	        
	        // phoneNumber: 전화번호
	        // phone (전화), number (번호)
	        
	        // personCount: 인원 수
	        // person (사람), count (수, 계수)
	        waitingInfo.put("waitingNumber", waitingNumber);
	        waitingInfo.put("phoneNumber", req.getParameter("phoneNumber"));
	        waitingInfo.put("personCount", Integer.parseInt(req.getParameter("personCount")));
	        
	        // add: 추가하다
	        waitingList.add(waitingInfo);
	        
	        resp.setContentType("application/json");
	        // writeValue: 값을 쓰다
	        // write (쓰다), value (값)
	        objectMapper.writeValue(resp.getWriter(), waitingInfo);
	}
	 
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
		 HttpSession session = req.getSession();
	        
		
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<HashMap<String, Object>> waitingList = 
	            (ArrayList<HashMap<String, Object>>) session.getAttribute("waitingList");
	            
	        if (waitingList == null) {
	            waitingList = new ArrayList<>();
	        }
	        
	        // Jackson을 사용하여 JSON 응답 생성
	        resp.setContentType("application/json");
	        objectMapper.writeValue(resp.getWriter(), waitingList);
	    }
	 
	 @Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 // 특정 대기명단 인원수 수정
	        HttpSession session = req.getSession();
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<HashMap<String, Object>> waitingList = 
	            (ArrayList<HashMap<String, Object>>) session.getAttribute("waitingList");
	            
	        if (waitingList == null) {
	            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	            return;
	        }
	        
	        int waitingNumber = Integer.parseInt(req.getParameter("waitingNumber"));
	        int newPersonCount = Integer.parseInt(req.getParameter("personCount"));
	        
	        boolean found = false;
	        for (HashMap<String, Object> waiting : waitingList) {
	            if ((int)waiting.get("waitingNumber") == waitingNumber) {
	                waiting.put("personCount", newPersonCount);
	                found = true;
	                // Jackson을 사용하여 JSON 응답 생성
	                resp.setContentType("application/json");
	                objectMapper.writeValue(resp.getWriter(), waiting);
	                break;
	            }
	}
	        if (!found) {
	            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);}
	 }
	 
	 @Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 특정 대기명단 삭제
	        HttpSession session = req.getSession();
	        
	        @SuppressWarnings("unchecked")
	        ArrayList<HashMap<String, Object>> waitingList = 
	            (ArrayList<HashMap<String, Object>>) session.getAttribute("waitingList");
	            
	        if (waitingList == null) {
	            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	            return;
	        }
	        
	        int waitingNumber = Integer.parseInt(req.getParameter("waitingNumber"));
	        
	        boolean removed = waitingList.removeIf(
	            waiting -> (int)waiting.get("waitingNumber") == waitingNumber
	        );
	        
	        if (removed) {
	            resp.setStatus(HttpServletResponse.SC_OK);
	        } else {
	            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
	        }
	    }

}
