package com.cafe.information;

public class GreenMember extends MemberDTO {

	private final double pointAcc = 2.5;
	

	public GreenMember(int i, int j, String string) {
		super(i, j, string);
	}


	public double getPointAcc() {
		return pointAcc;
	}

	
}
