package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor  //기본 생성자 와 전체매개변수 생성자를 자동생성
@AllArgsConstructor 
@Getter
@Setter
@ToString

public class BoardDto {

	private int bno;              
    private String btitle;                 
    private String bcontent;
    private int bview;
    private String bdate;
    private int mno; 
    private int cno;
    
    //+HTML에 출력할때 작성자의 회원번호가 아닌 작성자 ID 출력
    private String mid;
	
	
	
	
}
