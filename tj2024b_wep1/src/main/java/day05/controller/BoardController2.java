package day05.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import day05.model.dao.BoardDao;

import day05.model.dto.BoardDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Map;

/**
* 개별 게시물 관련 요청을 처리하는 컨트롤러
* - URL 패턴: /board/* (예: /board/1, /board/2)
* - 처리기능: 개별조회(GET), 수정(PUT), 삭제(DELETE)
*/
@WebServlet("/day05/board/view") 
public class BoardController2 extends HttpServlet {
   
   // 데이터베이스 작업용 DAO 객체
   private BoardDao boardDao;
   // JSON 변환용 ObjectMapper 객체
   private ObjectMapper objectMapper;
   
   // 서블릿 초기화 시 필요한 객체들 생성
   @Override
   public void init() throws ServletException {
       boardDao = BoardDao.getInstance();
       objectMapper = new ObjectMapper();
   }
   
   /**
    * 개별 게시물 조회 처리 (GET 요청)
    * 요청 예시: GET /board/1
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
       
       // 1. 경로에서 게시물 번호 추출
       String pathInfo = request.getPathInfo(); // "/1" 형태로 반환됨
       int boardNo = Integer.parseInt(pathInfo.substring(1)); // 1번 위치부터 끝까지 자르기
       
       try {
           // 2. 조회수 증가
           boardDao.updateView(boardNo);
           
           // 3. 게시물 정보 조회
           BoardDto board = boardDao.findByBno(boardNo);
           
           // 4. 조회 결과가 있는지 확인
           if(board != null) {
               // 5. 게시물이 있는 경우: JSON 형태로 응답
               sendSuccessResponse(response, board);
           } else {
               // 6. 게시물이 없는 경우: 오류 메시지 응답
               sendErrorResponse(response, "게시물을 찾을 수 없습니다.");
           }
           
       } catch(Exception e) {
           // 7. 처리 중 오류 발생 시
           sendErrorResponse(response, "게시물 조회 중 오류 발생: " + e.getMessage());
       }
   }
   
   /**
    * 게시물 수정 처리 (PUT 요청)
    * 요청 예시: PUT /board/1
    * 요청 본문: {"btitle":"수정된 제목", "bcontent":"수정된 내용", "bpwd":"1234"}
    */
   @Override
   protected void doPut(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
       
       // 1. 경로에서 게시물 번호 추출
       String pathInfo = request.getPathInfo();
       int boardNo = Integer.parseInt(pathInfo.substring(1));
       
       try {
           // 2. JSON 요청 데이터를 자바 객체로 변환
           BoardDto board = objectMapper.readValue(request.getReader(), BoardDto.class);
           board.setBno(boardNo);  // 게시물 번호 설정
           
           // 3. 게시물 수정 실행
           boolean isUpdated = boardDao.update(board);
           
           // 4. 수정 성공/실패 여부에 따른 응답
           if(isUpdated) {
               sendSuccessResponse(response, Map.of("message", "게시물이 성공적으로 수정되었습니다."));
           } else {
               sendErrorResponse(response, "게시물 수정에 실패했습니다. 비밀번호를 확인해주세요.");
           }
           
       } catch(Exception e) {
           sendErrorResponse(response, "게시물 수정 중 오류 발생: " + e.getMessage());
       }
   }
   
   /**
    * 게시물 삭제 처리 (DELETE 요청)
    * 요청 예시: DELETE /board/1
    * 요청 본문: {"bpwd":"1234"}
    */
   @Override
   protected void doDelete(HttpServletRequest request, HttpServletResponse response) 
           throws ServletException, IOException {
       
       // 1. 경로에서 게시물 번호 추출
       String pathInfo = request.getPathInfo();
       int boardNo = Integer.parseInt(pathInfo.substring(1));
       
       try {
           // 2. JSON 요청에서 비밀번호 추출
           Map<String, String> requestData = objectMapper.readValue(
               request.getReader(), 
               objectMapper.getTypeFactory().constructMapType(Map.class, String.class, String.class)
           );
           String password = requestData.get("bpwd");
           
           // 3. 게시물 삭제 실행
           boolean isDeleted = boardDao.delete(boardNo, password);
           
           // 4. 삭제 성공/실패 여부에 따른 응답
           if(isDeleted) {
               sendSuccessResponse(response, Map.of("message", "게시물이 성공적으로 삭제되었습니다."));
           } else {
               sendErrorResponse(response, "게시물 삭제에 실패했습니다. 비밀번호를 확인해주세요.");
           }
           
       } catch(Exception e) {
           sendErrorResponse(response, "게시물 삭제 중 오류 발생: " + e.getMessage());
       }
   }
   
   /**
    * 성공 응답을 보내는 헬퍼 메소드
    */
   private void sendSuccessResponse(HttpServletResponse response, Object data) throws IOException {
       response.setContentType("application/json;charset=UTF-8");
       response.setStatus(HttpServletResponse.SC_OK);  // 200 상태 코드
       response.getWriter().print(objectMapper.writeValueAsString(data));
   }
   
   /**
    * 오류 응답을 보내는 헬퍼 메소드
    */
   private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
       response.setContentType("application/json;charset=UTF-8");
       response.setStatus(HttpServletResponse.SC_BAD_REQUEST);  // 400 상태 코드
       response.getWriter().print(objectMapper.writeValueAsString(Map.of("error", message)));
   }
}