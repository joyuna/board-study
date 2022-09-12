package com.bitcamp.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
  public static void main(String[] args) throws Exception {

    // 1) 서버의 기본 소켓 번호는 80 이다.
    try (ServerSocket ss = new ServerSocket(80);
        Socket socket = ss.accept(); // 2) 클라이언트가 연결될 때까지 기다리다가 클라이언트가 연결되면 socket을 리턴할거다.
        //3)socket이 리턴한 Inputstream을 new InputStreamReader에 담아 그거를 다시 new BufferedReader에 담는다.
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());  //4)
        ) {

      String line; // 5)
      while ((line = in.readLine()) != null) { // 6)
        if (line.length() == 0) { // 8) 클라이언트가 빈 줄을 보내면, 읽기를 끝낸다.
          break;
        }
        System.out.println(line);// 7)
      }

      // 9) 클라이언트에게 응답한다. => 규칙이 있다.
      out.println("HTTP/1.1 200 ok");
      out.println("Content-Type: text/html;charset=UTF-8");
      out.println(); // 10) 이제부터 본격적으로 콘텐트를 보내겠다고 알린다.
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Hello!</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>안녕하세요!</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }
}
