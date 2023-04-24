package com.cafe.information;

import java.util.ArrayList;
import java.util.List;

public class MemberManager {

	private List<MemberDTO> memberlist = new ArrayList<>();
	
	public void init() {
		memberlist.add(new WelcomeMember("01011111111", 600, "Welcome")); 
		memberlist.add(new GreenMember("01022222222", 1200, "Green")); 
		memberlist.add(new GoldMember("01033333333", 1800, "Gold")); 
	}

	public List<MemberDTO> getMemberlist() {
		return memberlist;
	}
	
}
