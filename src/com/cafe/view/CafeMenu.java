package com.cafe.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.cafe.controller.CafeManager;
import com.cafe.dto.Beverage;
import com.cafe.dto.TypeDTO;

/**
 * 카페 메뉴를 보여주기 위한 클래스
 */
public class CafeMenu {
    Scanner sc = new Scanner(System.in);
    Map<String, Integer> map = new HashMap<>(); 
    CafeManager cm;

    /* 음료들의 초기값을 초기화 블럭을 이용하여 설정 */
    {
        map.put("아메리카노", 2000);
        map.put("카페라떼", 3000);
        map.put("바닐라라떼", 3500);
        map.put("초코라떼", 3500);
        map.put("아이스티", 2000);
    }

    /* 생성자에서 CafeManager 초기화 */
    public CafeMenu() {
        cm = new CafeManager();
    }

    /* 메뉴 출력 메서드 */
    public void menu() {
        System.out.println("=======================");
        System.out.println("1. 회원주문");
        System.out.println("2. 비회원주문");
        System.out.println("=======================");

        int num;

        /* 숫자가 아닌 문자를 입력했을 경우 다시 loop */
        num1:
        while (true) {
            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                continue num1;   
            } finally {
                sc.nextLine();
            }

            switch (num) {
                case 1: break;
                case 2: break;
                default: System.out.println("잘못된 숫자를 입력하셨습니다."); continue;
            }
            
            break;
        }

        

        loop: 
        while (true) {
            System.out.println("========= 메뉴 =========");
            System.out.println("1. 아메리카노");
            System.out.println("2. 카페라떼");
            System.out.println("3. 바닐라라떼");
            System.out.println("4. 초코라떼");
            System.out.println("5. 아이스티");
            System.out.println("6. 결정\t\t7.취소");
            System.out.println("=======================");
            cm.printType();

            while (true) {
                try {
                    System.out.print("번호를 입력해주세요 : ");
                    num = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("숫자만 입력해주세요.");
                    continue loop;
                } finally {
                    sc.nextLine();
                }

                break;
            }
            
            switch (num) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5: selectMenu(num); break;
                case 6: cm.option(); break;
                case 7:
                    System.out.println("주문을 취소했습니다.");
                    return;

                default:
                    System.out.println("잘못된 숫자를 입력하셨습니다.");
                    return;
            }
        }
    }

    public void selectMenu(int num) {
        String name;
        switch (num) {
            case 1: name = "아메리카노"; break;
            case 2: name = "카페라떼"; break;
            case 3: name = "바닐라라떼"; break;
            case 4: name = "초코라떼"; break;
            case 5: name = "아이스티"; break;
            default: return;
        }

        cm.addType(addType(name));
    }

    public TypeDTO addType(String name) {

        return new Beverage(name, map.get(name), "regular", 0, false, false, false, false);
    }

    /* 선택한 메뉴를 출력하는 부분 */

    /* 결정 */
}
