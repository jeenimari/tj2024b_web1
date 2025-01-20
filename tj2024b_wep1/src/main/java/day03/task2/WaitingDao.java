package day03.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import day03.task1.VisitDto;

public class WaitingDao {
	//필드생성
	private static WaitingDao instance = new WaitingDao();
	private Connection conn;  
	
	
	//생성자
	private WaitingDao() {
		try {
			conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/mydb016",
	                "root",
	                "1234"
	            );
		}catch(Exception e) {
			System.out.println(e);
		}
	}// 생성자 end
	
	public static WaitingDao getInstance() {
		return instance;
	}
	//대기번호 등록 SQL
	 public boolean write(WaitingDto waitingDto) {
	        try {
	            String sql = "insert into waiting(phone,pno) values(?,?)";
	            // 오류 2: 메소드명 오타 수정 "preparedStatement" -> "prepareStatement"
	            PreparedStatement ps = conn.prepareStatement(sql);
	           
	            ps.setString(1,waitingDto.getPhone());
	            ps.setInt(2, waitingDto.getPno());
	            int count = ps.executeUpdate();
	            if(count == 1) return true;
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return false;
	    }
	 
	 //대기번호 삭제 
	 public boolean delete(int num) {
	        try {
	            String sql = "delete from visit where num=?";
	            // 오류 3: 메소드명 오타 수정 "preparedStatement" -> "prepareStatement"
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, num);
	            int count = ps.executeUpdate();
	            if(count == 1) return true;
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        return false;
	    }
}//class end
