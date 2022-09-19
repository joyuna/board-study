/*
 * 게시판 관리 애플리케이션
 * 비트캠프-20220918-ver5
 */
package com.bitcamp.board;

public class App {
  public static void main(String[] args) {

    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();

    java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

    java.text.SimpleDateFormat formatter = 
        new java.text.SimpleDateFormat("yyyy-MM-dd");

    final int SIZE = 3;

    int[] no = new int[SIZE];
    String[] title = new String[SIZE];
    String[] content = new String[SIZE];
    String[] writer = new String[SIZE];
    String[] password = new String[SIZE];
    int[] viewCount = new int[SIZE];
    long[] createdDate = new long[SIZE];

    int boardCount = 0; // 저장된 게시글의 개수

    while (true) {
      System.out.println("메뉴");
      System.out.println(" 1: 게시글 목록");
      System.out.println(" 2: 게시글 상세보기");
      System.out.println(" 3: 게시글 등록");
      System.out.println();
      System.out.print("메뉴를 선택하세요[1..3](0 :종료)");

      int menuNo = keyboardInput.nextInt();
      keyboardInput.nextLine();

      System.out.println("------------------------------------");
      if (menuNo ==0) {
        break;

      } else if (menuNo == 1) {
        System.out.println("[게시글 목록]");
        System.out.println("번호 제목 조회수 작성자 등록일");

        for (int i = 0; i < boardCount; i++) {

          java.util.Date date = new java.util.Date(createdDate[i]);

          String dateStr = formatter.format(date);

          System.out.printf("%d\t%s\t%d\t%s\t%s\n",
              no[i], title[i], viewCount[i], writer[i], dateStr);
        }

      } else if (menuNo == 2) {
        System.out.println("[게시판 상세보기]");

        System.out.print("조회할 게시글 번호?");
        String input = keyboardInput.nextLine();
        int boardNo = Integer.parseInt(input);

        int boardIndex = -1;
        for (int i = 0; i < boardCount; i++) {
          if (no[i] == boardNo) {
            boardIndex = i;
            break;            
          }
        }


        if (boardIndex == -1) {
          System.out.println("해당 번호의 게시글이 없습니다!");
          continue;
        }

        System.out.printf("번호: %d\n", no[boardIndex]);
        System.out.printf("제목: %s\n", title[boardIndex]);
        System.out.printf("내용: %s\n", content[boardIndex]);
        System.out.printf("조회수: %d\n", viewCount[boardIndex]);
        System.out.printf("작성자: %s\n", writer[boardIndex]);
        java.util.Date date = new java.util.Date(createdDate[boardIndex]);
        System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);

      } else if (menuNo == 3) {
        System.out.println("[게시글 등록]");

        if (boardCount == SIZE) {
          System.out.println("게시글을 더이상 저장할 수 없습니다.");
          continue;
        }

        System.out.println("제목?");
        title[boardCount] = keyboardInput.nextLine();

        System.out.println("내용?");
        content[boardCount] = keyboardInput.nextLine();

        System.out.println("작성자?");
        writer[boardCount] = keyboardInput.nextLine();

        System.out.println("암호?");
        password[boardCount] = keyboardInput.nextLine();

        //        no = 1;
        //        viewCount = 0;
        no[boardCount] = boardCount == 0 ? 1 : no[boardCount - 1] + 1;

        viewCount[boardCount] = 0;
        createdDate[boardCount] = System.currentTimeMillis(); // 이 친구를 넣으니까 현재 시간이 출력 됨.

        boardCount++;

      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      System.out.println();
    } // while

    System.out.println("안녕히 가세요!");
    keyboardInput.close();
  }
}
