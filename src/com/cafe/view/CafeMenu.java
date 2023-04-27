package com.cafe.view;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import com.cafe.controller.CafeManager;

/**
 * 카페 메뉴를 보여주기 위한 클래스
 */
public class CafeMenu {
    private final Map<Integer, String> menu = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private CafeManager cm;

    {
        menu.put(1, "아메리카노");
        menu.put(2, "카페라떼");
        menu.put(3, "바닐라라떼");
        menu.put(4, "초코라떼");
        menu.put(5, "아이스티");
    }

    /* 생성자에서 CafeManager 초기화 */
    public CafeMenu() {
        cm = new CafeManager();
    }

    /* 메뉴 출력 메서드 */
    public void menu() {
        System.out.println("=======================");
        System.out.println(" [1] 회원주문");
        System.out.println(" [2] 비회원주문");
        System.out.println("=======================");

        int num;

        while (true) {
            /* 
             * Scanner로 숫자가 아닌 문자가 들어왔을 시 
             * InputMistmatchException 에러로 프로그램이 
             * 강제종료되지 않고 루프를 돌게 함
             */
            try {
                System.out.print("실행하실 번호를 입력해주세요 : ");
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
             * 비회원으로 Member타입을 설정하고 메뉴로 넘어감
             */
            switch (num) {
                case 1: cm.findMember(); break;
                case 2: cm.nonMember(); break;
                default: System.out.println("잘못된 숫자를 입력하셨습니다."); continue;
            }
            break;
        }

        while (true) {
            System.out.println("=========== 메뉴 ==========");
            System.out.println(" [1] 아메리카노");
            System.out.println(" [2] 카페라떼");
            System.out.println(" [3] 바닐라라떼");
            System.out.println(" [4] 초코라떼");
            System.out.println(" [5] 아이스티");
            System.out.println(" [6] 결정\t   [7] 취소");
            System.out.println("===========================");
            cm.printMenu();

            try {
                System.out.print("번호를 입력해주세요 : ");
                num = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                continue;
            } finally {
                sc.nextLine(); // Scanner 버퍼 제거
            }

            selectMenu(num);

            if (num == 6) {
                cm.numOption();
                System.out.println("프로그램을 종료합니다. 감사합니다.");
                return;
            } else if (num == 7) {
                System.out.println("주문을 취소했습니다.");
                cm.clearMenu();
                return;
            } else if (num < 1 || num > 7) {
                System.out.println("잘못된 숫자를 입력하셨습니다.");
            }
        }
    }

    public void selectMenu(int num) {
        String name = menu.get(num);
        if (name == null) {
            return;
        }

        cm.addMenu(name);
    }
    
}
