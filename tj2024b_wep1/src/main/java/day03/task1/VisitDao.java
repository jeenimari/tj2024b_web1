package day03.task1;

import java.sql.Connection;  // Connection import 누락
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VisitDao {
    // 필드 
    private static VisitDao instance = new VisitDao();
    private Connection conn;  // Connection 필드 선언 누락

    // 생성자
    private VisitDao() {
        try {
            // 오류 1: 오타 수정 "jbdc" -> "jdbc"
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb016",
                "root",
                "1234"
            );
        } catch (Exception e) {
            System.out.println(e); }
       
    }   // 중괄호 누락

    // 싱글톤 게터
    public static VisitDao getInstance() {
        return instance;
    }

    // 방문록 등록 SQL
    public boolean write(VisitDto visitDto) {
        try {
            String sql = "insert into visit(content,age) values(?,?)";
            // 오류 2: 메소드명 오타 수정 "preparedStatement" -> "prepareStatement"
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, visitDto.getContent());
            ps.setInt(2, visitDto.getAge());
            int count = ps.executeUpdate();
            if(count == 1) return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    // 방문록 삭제 SQL
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
}

// 발견된 주요 오류들:
// 1. Connection import 및 필드 선언 누락
// 2. JDBC 드라이버 이름 오타 ("jbdc" -> "jdbc")
// 3. prepareStatement 메소드명 오타
// 4. 생성자의 닫는 중괄호 누락
// 5. catch 블록에서 불필요한 TODO 주석 제거
// 6. 불필요한 Catch import 제거