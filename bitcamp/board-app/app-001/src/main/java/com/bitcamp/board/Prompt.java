/*
 * 키보드 입력을 받는 도구 구비
 * 비트캠프-20220930-ver8
 * ver7의 문제점 : 앱이 실행되는동안은 게시글이 저장됐다가 앱을 껐다 키면 초기화 됨 ..
 */
package com.bitcamp.board;

public class Prompt {

  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

  static int inputInt() {
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  static int inputInt(String title) {
    System.out.println(title);
    String str = keyboardInput.nextLine();
    return Integer.parseInt(str);
  }

  static String inputString() {
    return keyboardInput.nextLine();
  }

  static String inputString(String title) {
    System.out.println(title);
    return keyboardInput.nextLine();
  }

  static void close() {
    keyboardInput.close();
  }
}