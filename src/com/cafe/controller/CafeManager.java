package com.cafe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cafe.dto.Beverage;
import com.cafe.dto.TypeDTO;

public class CafeManager {
	 private List<TypeDTO> typelist;
	 private Scanner sc = new Scanner(System.in);
     private Map<String, Integer> prices = new HashMap<>(); 
     
     /* 초기화 블럭을 이용해 초기값 설정 */
    {
        prices.put("아메리카노", 2000);
        prices.put("카페라떼", 3000);
        prices.put("바닐라라떼", 3500);
        prices.put("초코라떼", 3500);
        prices.put("아이스티", 2000);
    }

     public CafeManager() {
        typelist  = new ArrayList<>();
     }

     public void addMenu(String name) {
        int price = prices.get(name);
        TypeDTO menu = new Beverage(name, price, "regular");

        typelist.add(menu);
     }

     public void printMenu() {
        if (typelist.size() == 0) {
            return;
        }

        int i = 1;
        System.out.println("====== 선택하신 음료 ======");
        for (TypeDTO typeDTO : typelist) {
            System.out.println(i + " : " + typeDTO.getName());
            i++;
        }
        System.out.println("===========================");
     }

     public void deleteMenu() {
        for (int i = 0; i < typelist.size(); i++) {
            typelist.remove(i);
        }
     }
     
     public void option() {

         while (true) {

             System.out.println(" [1] ice와 hot 둘중 하나를 골라주시길 바랍니다. ");
             System.out.println(" [2] 샷을 추가합니다 + 500원 ");
             System.out.println(" [3] 휘핑을 추가합니다. ");
             System.out.println(" [4] 시럽을 추가합니다. ");
             System.out.println(" [5] 얼음을 추가합니다. ");
             System.out.println(" [6] 사이즈를 업 합니다 + 500원 ");
             System.out.println(" [0] 결제로 넘어가기 ");
             System.out.println();
             System.out.println(" 숫자를 입력해주시길 바랍니다. ");
             int in = sc.nextInt();

             switch (in) {

                 case 1: {
                     System.out.println("ice [1] 와 hot [2] 원하는 옵션을 입력해주세요 : ");
                     int icehot = sc.nextInt();
                     sc.nextLine();

                     if (icehot == 1) {
                         System.out.println(" ice의 옵션을 선택합니다. ");
                     } else if (icehot == 2) {
                         System.out.println(" hot의 옵션을 선택합니다.");
                     } else {
                         System.out.println(" 숫자를 잘못 입력하셨습니다 초기메뉴로 돌아갑니다.");
                     }
                     break;
                 }

                 case 2: {
                     System.out.println(" 정상적으로 샷이 추가 되었습니다 ");
                     // 음료 샷 멤버변수의 값을 1증가시키는 메소드를 실행 시킨다.
                     // price의 값을 500을 증가 시킨다.
                     showOptionInformation();
                     break;
                 }
                 case 3: {
                     System.out.println(" 정상적으로 휘핑이 추가 되었습니다. ");
                     // 음료 휘핑의 멤버변수의 값을 true로 바꿉니다.
                     showOptionInformation();
                     break;
                 }
                 case 4: {
                     System.out.println(" 정상적으로 시럽이 추가 되었습니다.");
                     // 음료 시럽의 멤버변수의 값을 true로 바꿉니다.
                     showOptionInformation();
                     break;
                 }
                 case 5: {
                     System.out.println(" 정상적으로 얼음이 추가 되었습니다.");
                     // 음료의 얼음추가 변수의 값을 true로 바꿉니다.
                     showOptionInformation();
                     break;
                 }
                 case 6: {
                     System.out.println(" 정상적으로 사이즈 업이 되었습니다.");
                     // 음료의 사이즈의 변수 의 값을 true로 변경을 합니다.
                     // price의 값을 500을 증가 시킨다.
                     showOptionInformation();
                     break;
                 }
                 case 0: {
                     showOptionInformation();
                     System.out.println(" 결제 페이지로 넘어가겠습니다. ");

                     payment();
                     break;
                 }
                 default:
                     System.out.println("숫자를 잘못 입력 하셨습니다.");
             }
         }
     }

     public void payment() {

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
                     System.out.println(" .getprice" + "원이 정상적으로 결제 되었습니다.");
                     System.out.println(" 포인트" + /* pointsEarned() */ "이 적립이 되었습니다.");
                     // setpoint(getpoint + pointsEarned);
                     System.out.println(" 현재 고객이 가지고 있는 포인트는" + /* get.point ) */ "입니다. ");
                 }
                     return;
                 case 2: {
                     System.out.println("포인트 " + /* getpoint */ "를 사용하여 할인을 받아"
                             + /* (.getprice - getpoint( */ "원이 정상적으로 결제가 되었습니다. 감사합니다.");
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
         System.out.println("현재 선택하신 메뉴의 옵션은 " /*
                                                * 매개변수로 받은 모든 멤버변수
                                                * a는 A b는 B c는 c 입니다.
                                                */);
         System.out.println("=============================================");
     }

}
