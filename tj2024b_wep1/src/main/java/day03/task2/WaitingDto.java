package day03.task2;

public class WaitingDto {
	private String phone;
	private int pno;
	private int num;
	
	private WaitingDto() {}
	
	
	public WaitingDto(String phone, int pno, int num) {
		super();
		this.phone = phone;
		this.pno = pno;
		this.num = num;
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


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public String toString() {
		return "WaitingDto [phone=" + phone + ", pno=" + pno + ", num=" + num + "]";
	}

	
	
}// class end
