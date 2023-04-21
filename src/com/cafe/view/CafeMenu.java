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
        System.out.println("[1] 회원주문");
        System.out.println("[2] 비회원주문");
        System.out.println("=======================");

        int num;

        while (true) {
            /* 
             * Scanner로 숫자가 아닌 문자가 들어왔을 시 
             * InputMistmatchException 에러로 프로그램이 
             * 강제종료되지 않고 루프를 돌게 함
             */
            try {
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                continue;   
            } finally {
                sc.nextLine();
            }

            /*
             * 입력 값이 1인 경우 :
             * CafeManager의 전화번호 입력 메서드를 실행
             * 초기값으로 등록되어 있는 회원들 중 전화번호가 같은 사람이 있다면
             * CafeManager의 Member타입 변수에 대입시킴
             * 
             * 입력값이 2인 경우 :
             * 아무 동작을 하지않고 메뉴창으로 넘어감
             */
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
            System.out.println("[1] 아메리카노");
            System.out.println("[2] 카페라떼");
            System.out.println("[3] 바닐라라떼");
            System.out.println("[4] 초코라떼");
            System.out.println("[5] 아이스티");
            System.out.println("[6] 결정\t\t[7] 취소");
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
            
            // FIXME : 다른 방식으로 짤 수 없는지 고민해보자
            switch (num) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5: selectMenu(num); break;
                case 6: cm.option(); break;
                case 7:
                // FIXME : 주문취소 시 CafeManager의 typelist의 값 clear하기
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

        cm.addType(addMenu(name));
    }

    public TypeDTO addMenu(String name) {

        return new Beverage(name, map.get(name), "regular");
    }
}
