package com.cafe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cafe.dto.Beverage;
import com.cafe.dto.CafeMenuDTO;
import com.cafe.information.MemberDTO;
import com.cafe.information.MemberManager;

public class CafeManager {
	private List<CafeMenuDTO> menulist;
	private Scanner sc = new Scanner(System.in);
	private Map<String, Integer> prices = new HashMap<>();
	private MemberManager memberManager = new MemberManager();
	private MemberDTO member;

	/* 초기화 블럭을 이용해 초기값 설정 */
	{
		prices.put("아메리카노", 2000);
		prices.put("카페라떼", 3000);
		prices.put("바닐라라떼", 3500);
		prices.put("초코라떼", 3500);
		prices.put("아이스티", 2000);
	}

	public CafeManager() {
		menulist = new ArrayList<>();
		memberManager.init();
	}

	public void addMenu(String name) {
		int price = prices.get(name);
		CafeMenuDTO menu = new Beverage(name, price, "regular");

		menulist.add(menu);
	}

	public void printMenu() {
		if (menulist.size() == 0) {
			return;
		}

		int i = 1;
		System.out.println("======= 선택하신 음료 ========");
		for (CafeMenuDTO typeDTO : menulist) {
			System.out.println(i + " : " + typeDTO.getName());
			i++;
		}
		System.out.println("===========================");
	}

	public void deleteMenu() {
		menulist.clear();
	}

	public void option() {
		int paymentPrice = menulist.get(0).getPrice();
		while (true) {

			System.out.println(" [1] ice와 hot 둘중 하나를 골라주시길 바랍니다.");
			System.out.println(" [2] 샷을 추가합니다 + 500원 ");
			System.out.println(" [3] 휘핑을 추가합니다. ");
			System.out.println(" [4] 시럽을 추가합니다. ");
			System.out.println(" [5] 얼음을 추가합니다. ");
			System.out.println(" [6] 사이즈를 업 합니다 + 500원 ");
			System.out.println(" [0] 결제로 넘어가기 ");
			System.out.println();
			System.out.print(" 원하시는 숫자를 입력해주시길 바랍니다 :  ");
			int in = sc.nextInt();

			switch (in) {

			case 1: {
				System.out.print("ice [1] 와 hot [2] 원하는 옵션을 입력해주세요 : ");
				int icehot = sc.nextInt();
				sc.nextLine();


				payment(paymentPrice);

				if (icehot == 1) {
					System.out.println(" ice의 옵션이 선택되었습니다. ");
					((Beverage) menulist.get(0)).setCold(true);
					showOptionInformation();


				} else if (icehot == 2) {
					System.out.println(" hot의 옵션이 선택되었습니다.");
					((Beverage) menulist.get(0)).setCold(false);
					showOptionInformation();
				} else {
					System.out.println(" 숫자를 잘못 입력하셨습니다 초기메뉴로 돌아갑니다.");
				}
				break;
			}

			case 2: {
				System.out.println(" 정상적으로 샷이 추가 되었습니다 ");
				((Beverage) menulist.get(0)).setAddShot(((Beverage) menulist.get(0)).getAddShot() + 1);
				paymentPrice += 500;
				showOptionInformation();
				break;
			}
			case 3: {
				System.out.println(" 정상적으로 휘핑이 추가 되었습니다. ");
				((Beverage) menulist.get(0)).setWhipping(true);
				showOptionInformation();
				break;
			}
			case 4: {
				System.out.println(" 정상적으로 시럽이 추가 되었습니다.");
				((Beverage) menulist.get(0)).setSyrup(true);
				showOptionInformation();
				break;
			}
			case 5: {
				System.out.println(" 정상적으로 얼음이 추가 되었습니다.");
				((Beverage) menulist.get(0)).setIce(true);
				showOptionInformation();
				break;
			}
			case 6: {
				System.out.println(" 정상적으로 사이즈 업이 되었습니다.");
				((Beverage) menulist.get(0)).setSizeUp(true);
				paymentPrice += 500;
				showOptionInformation();
				break;
			}
			case 0: {
				showOptionInformation();
				System.out.println(" 결제 페이지로 넘어가겠습니다. ");

				payment(paymentPrice);
				break;
			}
			default:
				System.out.println("숫자를 잘못 입력 하셨습니다.");

			}
		}
	}

	public void payment(int paymentPrice) {

		while (true) {

			System.out.println("========== 결제 화면 ==========");
			System.out.println();
			System.out.println();
			System.out.println(" 결제 방법  ");
			System.out.println();
			System.out.println(" [1] 일반결제 (카드)  [2] 포인트를 사용하여 결제");
			System.out.println(" 숫자를 입력해주시길 바랍니다 : ");

			int payment = sc.nextInt();
			sc.nextLine();


			switch (payment) {
			case 1: {
				System.out.println(paymentPrice + "원이 정상적으로 결제 되었습니다.");
				System.out.println(" 포인트" + pointsEarned(((Beverage) menulist.get(0)).getPrice()) + "이 적립이 되었습니다.");
				// setpoint(getpoint + pointsEarned); 멤버의 setpoint
				System.out.println(" 현재 고객이 가지고 있는 포인트는" + /* get.point ) */ "입니다. ");
			}
			return;
			case 2: {
				System.out.println("포인트 " + /* getpoint */ "를 사용하여 할인을 받아"
						+ /* (paymentPrice - getpoint() */ "원이 정상적으로 결제가 되었습니다. 감사합니다.");
			}
			return;
			default:
				System.out.println(" 숫자를 잘못 입력하셨습니다 다시 입력해주시길 바랍니다 ");
				System.out.println();
			}
		}

	}

	public int pointsEarned(int price) {

		return price /* ( get.price * 회원의 적립률을 리턴 ) */;
	}

	public void showOptionInformation() {
		System.out.println("=============================================");
		System.out.println("현재 선택하신 메뉴의 옵션은 \n" + ((Beverage) menulist.get(0)).toString());
		System.out.println("=============================================");
	}

	public void findMember() {
		System.out.print("전화번호를 입력해주세요. : ");
		String num = sc.next();

		for (MemberDTO member : memberManager.getMemberlist()) {
			if (member.getNum().equals(num)) {
				this.member = member;
				break;
			}
		}
	}


}
