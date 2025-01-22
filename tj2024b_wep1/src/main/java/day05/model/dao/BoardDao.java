package day05.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day05.model.dto.*;

public class BoardDao {
   
   // 1. 싱글톤 객체 생성
   private static BoardDao instance = new BoardDao();
   
   // 2. DB 연결 필드
   private Connection conn;
   
   // 3. 생성자 (private로 DB 연결)
   private BoardDao() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/mydb1546",
               "root", 
               "1234"
           );
       } catch (Exception e) {
           System.out.println("DB 연결 실패: " + e);
       }
   }
   
   // 4. 싱글톤 객체 반환 메소드
   public static BoardDao getInstance() {
       return instance;
   }
   
   // 5. 게시물 등록
   public boolean write(BoardDto boardDto) {
       try {
           String sql = "insert into board(btitle, bcontent, bwriter, bpwd) values(?, ?, ?, ?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, boardDto.getBtitle());
           ps.setString(2, boardDto.getBcontent());
           ps.setString(3, boardDto.getBwriter());
           ps.setString(4, boardDto.getBpwd());
           int count = ps.executeUpdate();
           if(count == 1) return true;
       } catch (SQLException e) {
           System.out.println("게시물 등록 실패: " + e);
       }
       return false;
   }
   
   // 6. 전체 게시물 조회 
   public ArrayList<BoardDto> findAll() {
       ArrayList<BoardDto> list = new ArrayList<>();
       try {
           String sql = "select * from board order by bno desc";
           PreparedStatement ps = conn.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           while(rs.next()) {
               BoardDto boardDto = new BoardDto();
               boardDto.setBno(rs.getInt("bno"));
               boardDto.setBtitle(rs.getString("btitle"));
               boardDto.setBcontent(rs.getString("bcontent"));
               boardDto.setBwriter(rs.getString("bwriter"));
               boardDto.setBpwd(rs.getString("bpwd"));
               boardDto.setBdate(null);
               boardDto.setBview(rs.getInt("bview"));
               list.add(boardDto);
           }
       } catch (SQLException e) {
           System.out.println("전체 게시물 조회 실패: " + e);
       }
       return list;
   }
   
   // 7. 개별 게시물 조회
   public day05.model.dto.BoardDto findByBno(int bno) {
       try {
           String sql = "select * from board where bno = ?";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, bno);
           ResultSet rs = ps.executeQuery();
           if(rs.next()) {
               BoardDto boardDto = new BoardDto();
               boardDto.setBno(rs.getInt("bno"));
               boardDto.setBtitle(rs.getString("btitle"));
               boardDto.setBcontent(rs.getString("bcontent"));
               boardDto.setBwriter(rs.getString("bwriter"));
               boardDto.setBpwd(rs.getString("bpwd"));
               boardDto.setBdate(null);
               boardDto.setBview(rs.getInt("bview"));
               return boardDto;
           }
       } catch (SQLException e) {
           System.out.println("개별 게시물 조회 실패: " + e);
       }
       return null;
   }
   
   // 8. 조회수 증가
   public boolean updateView(int bno) {
       try {
           String sql = "update board set bview = bview + 1 where bno = ?";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, bno);
           int count = ps.executeUpdate();
           if(count == 1) return true;
       } catch (SQLException e) {
           System.out.println("조회수 증가 실패: " + e);
       }
       return false;
   }
   
   // 9. 게시물 수정
   public boolean update(BoardDto boardDto) {
       try {
           String sql = "update board set btitle=?, bcontent=? where bno=? and bpwd=?";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1, boardDto.getBtitle());
           ps.setString(2, boardDto.getBcontent());
           ps.setInt(3, boardDto.getBno());
           ps.setString(4, boardDto.getBpwd());
           int count = ps.executeUpdate();
           if(count == 1) return true;
       } catch (SQLException e) {
           System.out.println("게시물 수정 실패: " + e);
       }
       return false;
   }
   
   // 10. 게시물 삭제
   public boolean delete(int bno, String bpwd) {
       try {
           String sql = "delete from board where bno=? and bpwd=?";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, bno);
           ps.setString(2, bpwd);
           int count = ps.executeUpdate();
           if(count == 1) return true;
       } catch (SQLException e) {
           System.out.println("게시물 삭제 실패: " + e);
       }
       return false;
   }
}