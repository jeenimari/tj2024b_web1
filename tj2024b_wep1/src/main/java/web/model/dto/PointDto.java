package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PointDto {

	private int pno;            // 포인트 번호
    private int mno;            // 회원 번호
    private String pcomment;    // 포인트 내용
    private int ppoint;         // 포인트 수량
    private String pdate;       // 등록일
    private int mpoint; //
}
