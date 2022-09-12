package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
  public static void main(String[] args) {
    System.out.println("[게시글 데이터 관리 서버]");

    // 2. 예외가 생기면 try catch해라. 그리고 에러난 이유를 출력하라.
    try ( 
        // 1. 네트워크 준비
        // 4. => 클라이언트 연결을 관리할 객체를 준비한다.
        ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버 소켓 준비 완료!");

      try ( // 16) close 없애기 위해 try 삽입 
          // 6. 네트워크 준비하자마자 종료되는 걸 막기 위해
          // 클라이언트의 연결을 기다림
          // => 클라이언트와 연결되면 그 클라이언트와 통신할 준비를 한다.
          //    즉 Socket 객체 리턴
          // => 클라이언트와 연결될 때까지 리턴하지 않는다.
          Socket socket = serverSocket.accept();



          // 12. => 데이터를 읽을 때 primitive type 또는 String 타입의 값을
          //        보다 손쉽게 읽을 수 있도록 기존의 입력 도구에 보조 도구(decorator)를 붙여 사용한다.
          DataInputStream in = new DataInputStream(socket.getInputStream());

          // 13. => 데이터를 출력할 때 primitive type 또는 String 타입의 값을
          //        보다 손쉽게 출력할 수 있도록 기존의 출력 도구에 보조 도구(decorator)를 붙여 사용한다.
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {
        // 7. 클라이언트와 연결되면 출력!
        System.out.println("클라이언트와 연결 되었음!");

        // 14. 클라이언트와 서버 사이에 정해진 규칙(protocol)에 따라 데이터를 주고 받는다.
        // 15) String data 입력후 ()안 in,out 리팩토링 & 8,9 아래로 이동
        // 17) String dataName = ~~ , comand 삽입
        String dataName = in.readUTF();
        String command = in.readUTF();

        switch (dataName) { // 18)
          case "board": // 19)
            out.writeUTF("success"); // 24)
            break; // 20)
          case "member": // 21)
            out.writeUTF("success"); // 25)
            break; // 22)
          default: // 23)
            out.writeUTF("fail"); // 26)
        }

        // 9. 클라이언트와 연결이 끊어지면 출력!
        System.out.println("클라이언트와 연결을 끊었음!");
      } // 안쪽 try

    } catch (Exception e) {
      e.printStackTrace();
    } // 바깥쪽 try

    // 3. 만약 정상으로 실행 됐으면 서버를 종료하라.
    System.out.println("서버 종료!"); 
  }
}
