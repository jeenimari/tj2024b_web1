package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    private static final String URL = "jdbc:mysql://localhost:3306/tmember";
    private static final String USER = "사용자명";
    private static final String PASSWORD = "비밀번호";

    public List<MemberVO> listMembers() {
        List<MemberVO> list = new ArrayList<>();
        String query = "select * from t_member";
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                MemberVO vo = new MemberVO();
                vo.setId(rs.getString("id"));
                vo.setPwd(rs.getString("pwd"));
                vo.setName(rs.getString("name"));
                vo.setEmail(rs.getString("email"));
                vo.setJoinDate(rs.getInt("joingDate"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}