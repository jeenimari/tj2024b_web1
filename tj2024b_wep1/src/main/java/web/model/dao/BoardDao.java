package web.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import web.model.dto.BoardDto;
import web.model.dto.MemberDto;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class BoardDao extends Dao {

	//+싱글톤
	@Getter
	private static BoardDao instance = new BoardDao();
	
	//싱글톤 e
	
	//1.글쓰기 SQL 처리 메소드
	public boolean write(BoardDto boardDto) {
		try {
			String sql ="insert into member(btitle,bcontent,mno,cno)values(?,?,?,?)";
					PreparedStatement ps = conn.prepareStatement(sql);
			
            ps.setString( 1 , boardDto.getBtitle() );
            ps.setString( 2 , boardDto.getBcontent() );
            ps.setInt( 3 , boardDto.getMno() );
            ps.setInt( 4 , boardDto.getCno() );
           
            int count =ps.executeUpdate();
            if(count ==1 ) {return true;}
            
		}catch (SQLException e) { System.out.println(e);
			// TODO: handle exception
		}
		return false;
		
	}//f end 
	
	//2.게시물 전체 조회 findAll SQL 메소드
	
	public ArrayList<BoardDto> findAll(){
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = "select*from board b inner join member m on b.mno=m.mno order by b.bno desc";
			PreparedStatement ps=conn.prepareStatement(sql); 
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setMno(rs.getInt("mno"));
				boardDto.setCno(rs.getInt("cno"));
				boardDto.setMid(rs.getString("mid"));
				list.add(boardDto);
				
			}
		}catch (Exception e) {
			System.out.println(e);
			return list;
		}
		
	} // f end
	
	//3. 개별 게시물 조회
	public boolean update(BoardDto boardDto) {
		try {
			String sql ="update from board set btitle=?,bcontent=?,cno=? where bno=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, boardDto.getBtitle());
			ps.setString(2, boardDto.getBcontent());
			ps.setInt(3, boardDto.getCno());
			ps.setInt(4, boardDto.getBno());
			
			int count = ps.executeUpdate();
			if(count ==1) {return true;}
		}catch (SQLException e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return false;
	}// f end
	
	
		//4. 게시물 삭제
	public boolean delete(int bno) {
		try {
			String Sql = "delete from board where bno=?";
			PreparedStatement ps = conn.prepareStatement(Sql);
			ps.setInt(1, bno);
			int count = ps.executeUpdate();
			if(count ==1)return true;
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}// fend
	
	//5 게시물 개별 조회 findByBno SQL 메소드
	
	public BoardDto findByBno(int bno) {
		try {
			//1.특정 게시물 테이블 게시물 1개조회
			//String sql = "select*from board where bno=?";
			//2. 게시물 테이블과 회원 테이블 교집합 구해서 회원아이디 조회가능
			//String sql ="select*from board b inner join member b on b.mno  = m.mno";
			//3.게시물 테이블과 회원테이블과 카테고리 테이블 교집합 구해서 회원아이디와 카테고리명 조회가능
			String sql="select*from"
					+ "board b inner join member b on b.mno=m.mno"
					+ "inner join category c on b.cno = c.cno"
					+ "where bno=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				BoardDto boardDto = new BoardDto();
				
				boardDto.setBno(rs.getInt("bno"));
				boardDto.setBtitle(rs.getString("btitle"));
				boardDto.setBcontent(rs.getString("bcontent"));
				boardDto.setBdate(rs.getString("bdate"));
				boardDto.setBview(rs.getInt("bview"));
				boardDto.setMno(rs.getInt("mno"));
				boardDto.setCno(rs.getInt("cno"));
				boardDto.setMid(rs.getString("mid"));
				boardDto.setCname(rs.getString("cname")); //카테고리 테이블과 조인한 결과 가능
				return boardDto;
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	
	
	

}// class end
