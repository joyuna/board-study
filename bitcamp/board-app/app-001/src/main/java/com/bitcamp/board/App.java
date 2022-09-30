/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220930-ver8
 * ver7의 문제점 : 앱이 실행되는동안은 게시글이 저장됐다가 앱을 껐다 키면 초기화 됨 ..
 */
package com.bitcamp.board;

public class App {

  public static void main(String[] args) {
    welcome();
    loop: while (true) {
      displayMenu();
      int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 종료)");
      displayLine();

      switch (menuNo) {
        case 0: break loop;
        case 1: BoardHandler.processList(); break;
        case 2: BoardHandler.processDetail(); break;
        case 3: BoardHandler.processInput(); break;
        case 4: BoardHandler.processDelete(); break;
        case 5: BoardHandler.processUpdate(); break;
        default: System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      displayBlankLine();
    } // while

    System.out.println("안녕히 가세요!");
    Prompt.close();
  }

  static void welcome() {
    System.out.println("[게시판 애플리케이션]");

    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }



  static void displayMenu() {
    System.out.println("메뉴");
    System.out.println(" 1: 게시글 목록");
    System.out.println(" 2: 게시글 상세보기");
    System.out.println(" 3: 게시글 등록");
    System.out.println(" 4: 게시글 삭제");
    System.out.println(" 5: 게시글 변경");
    System.out.println();
  }

  static void displayLine() {
    System.out.println("==========================");
  }

  static void displayBlankLine() {
    System.out.println();
  }
}
