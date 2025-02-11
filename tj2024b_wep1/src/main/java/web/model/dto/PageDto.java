package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString
@AllArgsConstructor @NoArgsConstructor //롬복준비
public class PageDto {
	private int totalCount; //전체 자료 개수
	private int page; //현재 페이지
	private int totalpage; //전체 페이지수
	private int startbtn;  //페이징 버튼 시작번호
	private int endbtn; //페이징 버튼 끝번호
	//* Object 타입으로 사용한이유
	//Object 타입은 자바의 최상위 클래스 이므로 모든 타입들의 자료들을 저장 할 수 있다.
	//-data에는 List<boardDto>,List<replyDto>등등 여러 타입들을 하나의 타입에서 저장함.
	private Object data; //페이징된 자료
	

}
