package day03.task4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import day03.task3.VisitDto;

public class WaitingDao {

	//필드
	
	private static WaitingDao instance = new WaitingDao();
	private Connection conn;
	
	
	//생성자
	
	private WaitingDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/mydb0115",
	                "root",
	                "1234"
	            );
			
		}catch (Exception e) {System.out.println(e);}
		
		
	}// fend
	
	public static WaitingDao getInstance() {
		return instance;
	}
	
	//대기번호 등록 SQL
    public boolean write(WaitingDto waitingDto) {
        try {
            String sql = "insert into waiting(phone,pno) values(?,?)";
            // 오류 2: 메소드명 오타 수정 "preparedStatement" -> "prepareStatement"
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitingDto.getPhone());
            ps.setInt(2, waitingDto.getPno());
            int count = ps.executeUpdate();
            if(count == 1) return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    
  //  대기번호 전체조회 SQL
    public ArrayList<WaitingDto>findAll(){
    	ArrayList<WaitingDto> list = new ArrayList<WaitingDto>();
    	try {
    		
    		String sql = "select * from waiting";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ResultSet  rs =  ps.executeQuery();
    		while(rs.next()) {
    			WaitingDto waitingDto = new WaitingDto();
    			waitingDto.setPhone(rs.getString("phone"));
    			waitingDto.setPno(rs.getInt("pno"));
    			waitingDto.setWno(rs.getInt("wno"));
    			list.add(waitingDto);
    		}
  
    		
    	}catch (SQLException e) {
    		System.out.println(e);
			
		}
    	return list;
    } // f end
    
// 대기개별수정  SQL
    
    public boolean findByWno(WaitingDto waitingDto) {
    	try {
    		String sql = "update waiting"
    				+" set phone = ? , pno =?"
    				+" where wno = ?";
    		PreparedStatement ps = conn.prepareStatement(sql);
    		ps.setString(1, waitingDto.getPhone());
    		ps.setInt(2, waitingDto.getPno());
    		ps.setInt(3,waitingDto.getWno() );
    		int count =  ps.executeUpdate();
    		if( count == 1 ) return true;
    	}catch (SQLException e) {System.out.println(e);	}
			return false;
	
			
			
    }// fend; 
  
    //대기개별삭제 
    public boolean delete(int wno) {
        try {
            String sql = "delete from waiting where wno=?";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, wno);
            int count = ps.executeUpdate();
            if(count == 1) return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

  
}//class end
