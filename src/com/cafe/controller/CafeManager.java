package com.cafe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cafe.dto.Beverage;
import com.cafe.dto.CafeMenuDTO;
import com.cafe.information.GoldMember;
import com.cafe.information.GreenMember;
import com.cafe.information.MemberDTO;
import com.cafe.information.MemberManager;

public class CafeManager {
	private Map<String, Integer> prices = new HashMap<>();
	private List<CafeMenuDTO> menulist;
	private MemberManager memberManager = new MemberManager();
	private MemberDTO member;
	private Scanner sc = new Scanner(System.in);

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
			System.out.println(" " + i + " : " + typeDTO.getName());
			i++;
		}
		System.out.println("=============================");
	}

	public void selectedMenuDelete(int choice) {
		menulist.remove(choice);
	}

	public void clearMenu() {
		menulist.clear();
	}

	public void numOption() {
		while (true) {
			printMenu();
			System.out.println(" [0] 결제로 넘어가기 ");
			System.out.print("선택하신 메뉴 중 옵션을 넣을 번호를 입력해주세요 ");
			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 0) {
				System.out.println(" 결제 페이지로 넘어갑니다. ");
				payment();

				return;
			}

			option(choice);
		}
	}

	public void option(int choice) {

		while (true) {
			System.out.println("============================================");
			System.out.println(" [1] ice와 hot 둘중 하나를 골라주시길 바랍니다.");
			System.out.println(" [2] 샷을 추가합니다 + 500원 ");
			System.out.println(" [3] 휘핑을 추가합니다. ");
			System.out.println(" [4] 시럽을 추가합니다. ");
			System.out.println(" [5] 얼음을 추가합니다. ");
			System.out.println(" [6] 사이즈를 업 합니다 + 500원 ");
			System.out.println(" [7] 선택하신 메뉴로 돌아갑니다.");
			System.out.println(" [0] 취소하기");
			showOptionInformation(choice - 1);
			System.out.print(" 원하시는 숫자를 입력해주시길 바랍니다 :  ");

			int in = sc.nextInt();

			switch (in) {

				case 1: {
					System.out.print("ice [1] 와 hot [2] 원하는 옵션을 입력해주세요 : ");
					int icehot = sc.nextInt();
					sc.nextLine();

					if (icehot == 1) {
						System.out.println(" ice의 옵션이 선택되었습니다. ");
						((Beverage) menulist.get(choice - 1)).setCold(true);

					} else if (icehot == 2) {
						System.out.println(" hot의 옵션이 선택되었습니다.");
						((Beverage) menulist.get(choice - 1)).setCold(false);
					} else {
						System.out.println(" 숫자를 잘못 입력하셨습니다 초기메뉴로 돌아갑니다.");
					}
				}
					break;

				case 2: {
					System.out.println(" 정상적으로 샷이 추가 되었습니다 ");
					((Beverage) menulist.get(choice - 1))
							.setAddShot(((Beverage) menulist.get(choice - 1)).getAddShot() + 1);
					menulist.get(choice - 1).setPrice(menulist.get(choice - 1).getPrice() + 500);
				}
					break;
				case 3: {
					System.out.println(" 정상적으로 휘핑이 추가 되었습니다. ");
					((Beverage) menulist.get(choice - 1)).setWhipping(true);
				}
					break;
				case 4: {
					System.out.println(" 정상적으로 시럽이 추가 되었습니다.");
					((Beverage) menulist.get(choice - 1)).setSyrup(true);
				}
					break;
				case 5: {
					System.out.println(" 정상적으로 얼음이 추가 되었습니다.");
					((Beverage) menulist.get(choice - 1)).setIce(true);
				}
					break;
				case 6: {
					System.out.println(" 정상적으로 사이즈 업이 되었습니다.");
					((Beverage) menulist.get(choice - 1)).setSizeUp(true);
					menulist.get(choice - 1).setPrice(menulist.get(choice - 1).getPrice() + 500);
				}
					break;
				case 7: {
					System.out.println("이전 화면으로 돌아갑니다.");
					return;
				}
				case 0: {
					System.out.println("취소하셨습니다.");
					selectedMenuDelete(choice - 1);
					return;
				}
				default: {
					System.out.println("숫자를 잘못 입력 하셨습니다.");
				}
			}

		}
	}

	public void payment() {

		while (true) {

			System.out.println("========== 결제 화면 ==========");
			System.out.println();
			System.out.println(" 결제 방법  ");
			System.out.println();
			System.out.println(" [1] 일반결제 (카드)  [2] 포인트를 사용하여 결제");
			System.out.println(" 숫자를 입력해주시길 바랍니다 : ");

			int payment = sc.nextInt();
			sc.nextLine();

			switch (payment) {
				case 1: {
					System.out.println(pay() + "원이 정상적으로 결제 되었습니다.");

					if (!member.getGrade().equals("비회원")) {
						System.out.println("포인트 " + pointsEarned(pay()) + "이 적립이 되었습니다.");
						member.setPoint(member.getPoint() + pointsEarned(pay()));
						System.out.println("현재 고객이 가지고 있는 포인트는 " + member.getPoint() + "입니다. ");
					}
					return;
				}

				case 2: {
					if (member.getGrade().equals("비회원")) {
						System.out.println(" 비회원일 경우 포인트 사용이 불가능합니다.");
						break;
					} else {
						System.out.println("포인트 " + member.getPoint() + "를 사용하여 할인을 받아"
								+ (pay() - member.getPoint()) + "원이 정상적으로 결제가 되었습니다. 감사합니다.");
					}
					return;
				}
				
				default:
					System.out.println(" 숫자를 잘못 입력하셨습니다 다시 입력해주시길 바랍니다 ");
					System.out.println();
			}
		}

	}

	public int pointsEarned(int price) {

		if (member instanceof GoldMember) {
			return (int) (price * (((GoldMember) member).getPointAcc() / 100));
		} else if (member instanceof GreenMember) {
			return (int) (price * (((GreenMember) member).getPointAcc() / 100));
		} else {
			return 0;
		}
	}

	public void showOptionInformation(int choice) {
		System.out.println("=============================================");
		System.out.println("현재 선택하신 메뉴의 옵션은 \n" + ((Beverage) menulist.get(choice)).toString());
		System.out.println("=============================================");
	}

	public void findMember() {
		System.out.print("전화번호를 입력해주세요. : ");
		String num = sc.next();

		for (MemberDTO member : memberManager.getMemberlist()) {
			if (member.getNum().equals(num)) {
				this.member = member;
				return;
			}
		}

		System.out.println("회원 정보를 찾을 수 없습니다. 비회원으로 로그인합니다.");
		this.member = new MemberDTO(null, 0, "비회원");
	}

	public int pay() {
		int result = 0;
		for (int i = 0; i < menulist.size(); i++) {
			result += menulist.get(i).getPrice();
		}
		return result;
	}

	public void nonMember() {
		System.out.println("비회원으로 로그인합니다.");
		this.member = new MemberDTO(null, 0, "비회원");
	}
}
