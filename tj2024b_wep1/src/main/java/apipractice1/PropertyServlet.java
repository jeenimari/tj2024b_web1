package apipractice1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PropertyServlet")
public class PropertyServlet extends HttpServlet {
    
    private PropertyDAO propertyDAO;
    
    public PropertyServlet() {
        super();
        propertyDAO = new PropertyDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        
        try {
            List<PropertyDTO> propertyList = propertyDAO.getAllProperties();
            
            // JSON 배열 형태의 문자열 생성
            StringBuilder jsonArrayBuilder = new StringBuilder();
            jsonArrayBuilder.append("[");
            
            for (int i = 0; i < propertyList.size(); i++) {
                PropertyDTO property = propertyList.get(i);
                
                jsonArrayBuilder.append("{");
                jsonArrayBuilder.append("\"id\":\"" + property.getId() + "\",");
                jsonArrayBuilder.append("\"title\":\"" + escapeString(property.getTitle()) + "\",");
                jsonArrayBuilder.append("\"lat\":\"" + property.getLatitude() + "\",");
                jsonArrayBuilder.append("\"lng\":\"" + property.getLongitude() + "\",");
                jsonArrayBuilder.append("\"address\":\"" + escapeString(property.getAddress()) + "\",");
                jsonArrayBuilder.append("\"price\":\"" + property.getPrice() + "\",");
                jsonArrayBuilder.append("\"propertyType\":\"" + escapeString(property.getPropertyType()) + "\",");
                jsonArrayBuilder.append("\"squareFeet\":\"" + property.getSquareFeet() + "\"");
                jsonArrayBuilder.append("}");
                
                // 마지막 항목이 아니면 쉼표 추가
                if (i < propertyList.size() - 1) {
                    jsonArrayBuilder.append(",");
                }
            }
            
            jsonArrayBuilder.append("]");
            
            PrintWriter out = resp.getWriter();
            out.print(jsonArrayBuilder.toString());
            out.flush();
            
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("데이터를 불러오는 중 오류가 발생했습니다.");
        }
    }
    
    // JSON 문자열 이스케이프 처리를 위한 메소드
    private String escapeString(String input) {
        if (input == null) {
            return "";
        }
        return input.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }
}