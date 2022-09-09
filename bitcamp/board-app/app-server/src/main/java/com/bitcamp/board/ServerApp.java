package com.bitcamp.board;

import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
  public static void main(String[] args) {
    System.out.println("[게시글 데이터 관리 서버]");

    // 2. 예외가 생기면 try catch해라. 그리고 에러난 이유를 출력하라.
    try {
      // 1. 네트워크 준비
      // 4. => 클라이언트 연결을 관리할 객체를 준비한다.
      ServerSocket serverSocket = new ServerSocket(8888);
      System.out.println("서버 소켓 준비 완료!");

      // 6. 네트워크 준비하자마자 종료되는 걸 막기 위해
      // 클라이언트의 연결을 기다림
      // => 클라이언트와 연결되면 그 클라이언트와 통신할 준비를 한다.
      //    즉 Socket 객체 리턴
      // => 클라이언트와 연결될 때까지 리턴하지 않는다.
      Socket socket = serverSocket.accept();
      // 7. 클라이언트와 연결되면 출력!
      System.out.println("클라이언트와 연결 되었음!");

      // 8. 클라이언트와 연결된 것을 끊는다.
      socket.close();
      // 9. 클라이언트와 연결이 끊어지면 출력!
      System.out.println("클라이언트와 연결을 끊었음!");

      // 5. 네트워크 종료
      // => 더 이상 클라이언트와 연결하고 싶지 않다면 네트워크를 종료한다.
      serverSocket.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    // 3. 만약 정상으로 실행 됐으면 서버를 종료하라.
    System.out.println("서버 종료!"); 
  }
}
