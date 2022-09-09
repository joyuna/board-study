package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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

      // 10. 클라이언트와 데이터를 주고 받는다.
      // => 클라이언트가 보낸 데이터를 읽을 때 사용할 도구를 준비한다.
      InputStream in = socket.getInputStream();

      // 12. => 데이터를 읽을 때 primitive type 또는 String 타입의 값을
      //        보다 손쉽게 읽을 수 있도록 기존의 입력 도구에 보조 도구(decorator)를 붙여 사용한다.
      DataInputStream in2 = new DataInputStream(in);


      // 11. => 클라이언트로 데이터를 보낼 때 사용할 도구를 준비한다.
      OutputStream out = socket.getOutputStream();

      // 13. => 데이터를 출력할 때 primitive type 또는 String 타입의 값을
      //        보다 손쉽게 출력할 수 있도록 기존의 출력 도구에 보조 도구(decorator)를 붙여 사용한다.
      DataOutputStream out2 = new DataOutputStream(out);

      // 14. 클라이언트와 서버 사이에 정해진 규칙(protocol)에 따라 데이터를 주고 받는다.
      // 




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
