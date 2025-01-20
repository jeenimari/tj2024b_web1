package day03.task4;

public class WaitingDto {

	private String phone;  //핸폰번호
	private int pno;   //인원수
	private int wno;    // 대기번호
	
	WaitingDto() {}

	public WaitingDto(String phone, int pno, int wno) {
		super();
		this.phone = phone;
		this.pno = pno;
		this.wno = wno;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getWno() {
		return wno;
	}

	public void setWno(int wno) {
		this.wno = wno;
	}

	@Override
	public String toString() {
		return "WaitingDto [phone=" + phone + ", pno=" + pno + ", wno=" + wno + "]";
	}
	
	
	
}//class end
