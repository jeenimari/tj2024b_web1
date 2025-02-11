package apipractice1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PropertyDAO {
	
	    private Connection conn;
	    private PreparedStatement pstmt;
	    private ResultSet rs;
	    
	    // DB 연결
	    private void getConnection() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            String url = "jdbc:mysql://localhost:3306/your_database";
	            String user = "your_username";
	            String password = "your_password";
	            conn = DriverManager.getConnection(url, user, password);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // DB 연결 해제
	    private void closeConnection() {
	        try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    // 전체 매물 조회
	    public List<PropertyDTO> getAllProperties() {
	        List<PropertyDTO> properties = new ArrayList<>();
	        try {
	            getConnection();
	            String sql = "SELECT * FROM properties";
	            pstmt = conn.prepareStatement(sql);
	            rs = pstmt.executeQuery();
	            
	            while(rs.next()) {
	                PropertyDTO property = new PropertyDTO();
	                property.setId(rs.getInt("id"));
	                property.setTitle(rs.getString("title"));
	                property.setLatitude(rs.getDouble("latitude"));
	                property.setLongitude(rs.getDouble("longitude"));
	                property.setAddress(rs.getString("address"));
	                property.setPrice(rs.getInt("price"));
	                property.setSquareFeet(rs.getInt("square_feet"));
	                property.setPropertyType(rs.getString("property_type"));
	                
	                properties.add(property);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return properties;
	    }
	    
	    // ID로 특정 매물 조회
	    public PropertyDTO getPropertyById(int id) {
	        PropertyDTO property = null;
	        try {
	            getConnection();
	            String sql = "SELECT * FROM properties WHERE id = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
	            rs = pstmt.executeQuery();
	            
	            if(rs.next()) {
	                property = new PropertyDTO();
	                property.setId(rs.getInt("id"));
	                property.setTitle(rs.getString("title"));
	                property.setLatitude(rs.getDouble("latitude"));
	                property.setLongitude(rs.getDouble("longitude"));
	                property.setAddress(rs.getString("address"));
	                property.setPrice(rs.getInt("price"));
	                property.setSquareFeet(rs.getInt("square_feet"));
	                property.setPropertyType(rs.getString("property_type"));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return property;
	    }
	    
	    // 지역 기반 매물 검색
	    public List<PropertyDTO> getPropertiesByLocation(double minLat, double maxLat, 
	                                                double minLng, double maxLng) {
	        List<PropertyDTO> properties = new ArrayList<>();
	        try {
	            getConnection();
	            String sql = "SELECT * FROM properties WHERE latitude BETWEEN ? AND ? " +
	                        "AND longitude BETWEEN ? AND ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setDouble(1, minLat);
	            pstmt.setDouble(2, maxLat);
	            pstmt.setDouble(3, minLng);
	            pstmt.setDouble(4, maxLng);
	            rs = pstmt.executeQuery();
	            
	            while(rs.next()) {
	                PropertyDTO property = new PropertyDTO();
	                // ... 속성 설정 ...
	                properties.add(property);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return properties;
	    }
	}

