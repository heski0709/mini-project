package com.cafe.information;

public class GoldMember extends MemberDTO{

	private final double pointAcc = 3.5;

	public GoldMember(String i, int j, String string) {
		super(i,j,string);
	}

	public double getPointAcc() {
		return pointAcc;
	}
	
	
}
	
	

