package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientApp {
  public static void main(String[] args) {
    System.out.println("[게시글 관리 클라이언트]");

    // 2. 예외가 발생하면 던져
    try ( // 6) try문 하나 더 추가 -> close를 안하기 위해서 
        // 1. 네트워크 준비
        // 4. => 정상적으로 연결되었으면 Socket 객체를 리턴한다.
        Socket socket = new Socket("127.0.0.1",8888);
        // 7)
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());) {

      System.out.println("연결되었음!");

      // 8) 통신 프로토콜에 따라 요청한다.
      out.writeUTF("board");
      out.writeUTF("insert");

      // 9) 통신 프로토콜에 따라 응답을 처리한다.
      String status = in.readUTF();
      System.out.println(status);


      // 5. 네트워크 끊기
      // => 서버와 연결된 것을 끊는다.
      socket.close();
      System.out.println("연결을 끊었음!");

    } catch (Exception e) {
      e.printStackTrace(); // 3. 에러가 발생한 이유를 출력 하라.
    }

    System.out.println("종료!");
  }
}
