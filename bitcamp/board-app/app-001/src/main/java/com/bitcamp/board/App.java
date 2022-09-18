/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220918-ver4
 */
package com.bitcamp.board;

public class App {
  public static void main(String[] args) {

    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();

    java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

    int no = 0;
    String title = "";
    String content = "";
    String writer = "";
    String password = "";
    int viewCount = 0;
    long createdDate = 0;


    while (true) {
      System.out.println("메뉴");
      System.out.println(" 1: 게시글 목록");
      System.out.println(" 2: 게시글 상세보기");
      System.out.println(" 3: 게시글 등록");
      System.out.println();
      System.out.println("메뉴를 선택하세요[1..3](0 :종료)");

      int menuNo = keyboardInput.nextInt();
      keyboardInput.nextLine();

      if (menuNo ==0) {
        break;
      } else if (menuNo == 1) {
        System.out.println("[게시글 목록]");
        System.out.println("번호 제목 조회수 작성자 등록일");

        System.out.print(1);
        System.out.print("\t");
        System.out.print("제목입니다1");
        System.out.print('\t');
        System.out.print(20 + "\t");
        System.out.print("홍길동\t");
        System.out.print("2022-09-18\r\n");

        System.out.print(2 + "\t" + "제목입니다2\t" +
            11 + "\t" + "홍길동\t" + "2022-09-18\n");

        System.out.println(3 + "\t제목입니다3\t" 
            + 31 + "\t" + "임꺽정\t2022-09-18");

        System.out.printf("%d\t%s\t%d\t%s\t%s\n",
            4, "제목입니다4", 45 , "유관순", "2022-09-18");
      } else if (menuNo == 2) {
        System.out.println("[게시판 상세보기]");

        System.out.printf("번호: %d\n", no);
        System.out.printf("제목: %s\n", title);
        System.out.printf("내용: %s\n", content);
        System.out.printf("조회수: %d\n", viewCount);
        System.out.printf("작성자: %s\n", writer);

        java.util.Date date = new java.util.Date(createdDate);

        System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);

      } else if (menuNo == 3) {
        System.out.println("[게시글 등록]");

        System.out.println("제목?");
        title = keyboardInput.nextLine();

        System.out.println("내용?");
        content = keyboardInput.nextLine();

        System.out.println("작성자?");
        writer = keyboardInput.nextLine();

        System.out.println("암호?");
        password = keyboardInput.nextLine();

        no = 1;
        viewCount = 0;
        createdDate = System.currentTimeMillis(); // 이 친구를 넣으니까 현재 시간이 출력 됨.

      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    } // while

    System.out.println("안녕히 가세요!");
    keyboardInput.close();
  }
}
