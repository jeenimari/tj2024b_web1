package day05.model.dto;

import java.security.Timestamp;

public class BoardDto {
	 private int bno;
	    private String btitle;
	    private String bcontent;
	    private String bwriter;
	    private String bpwd;
	    private Timestamp bdate;
	    private int bview;
	    
	   public BoardDto() {}

	public BoardDto(int bno, String btitle, String bcontent, String bwriter, String bpwd, Timestamp bdate, int bview) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bpwd = bpwd;
		this.bdate = bdate;
		this.bview = bview;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBpwd() {
		return bpwd;
	}

	public void setBpwd(String bpwd) {
		this.bpwd = bpwd;
	}

	public Timestamp getBdate() {
		return bdate;
	}

	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bpwd=" + bpwd + ", bdate=" + bdate + ", bview=" + bview + "]";
	}
	   
		

}//class end
