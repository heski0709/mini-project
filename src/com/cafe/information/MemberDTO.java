package com.cafe.information;

public class MemberDTO {
	private int num;
	private int point;
	private String grade;
	public MemberDTO() {
		super();
		
	}
	public MemberDTO(int num, int point, String grade) {
		super();
		this.num = num;
		this.point = point;
		this.grade = grade;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "MemberDTO [num=" + num + ", point=" + point + ", grade=" + grade + "]";
	}

	
}




