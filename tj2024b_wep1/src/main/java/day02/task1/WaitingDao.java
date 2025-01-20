package day02.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitingDao {
	
	
	//필드
	
	private static WaitingDao instance = new WaitingDao();
	private Connection conn;
	
	//생성자
	private WaitingDao(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mydb1234",
	                "root",
	                "1234"
	                );
		}catch (Exception e) {System.out.println(e);}
		
		
	}//생성자 end
	
	//싱글톤 게터
	public static WaitingDao getInstance() {
		return instance;
	}

	//대기번호 등록 SQL
	public boolean waitingNum(int phone, int pno ) {
		try {
			String sql = "insert into waiting(phone,pno) values(?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, phone);
			ps.setInt(2, pno);
			int count = ps.executeUpdate();
			if(count ==1)return true;
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	//대기번호 삭제 SQL
	
	public boolean delete(int wno) {
		try {
			String sql ="delete from waiting where wnum=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, wno);
			int count = ps.executeUpdate();
			if(count ==1)return true;
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}


}//class end
