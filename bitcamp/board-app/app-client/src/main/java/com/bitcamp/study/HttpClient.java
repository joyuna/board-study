package com.bitcamp.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HttpClient {
  public static void main(String[] args) throws Exception {
    try( // 6) socket.close 지우고 try 생성 왜? close 안넣어줘도 되니깐!
        Socket socket =new Socket("stores.auction.co.kr", 80); // 1)
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream());) { // 8)
      // 9) ()안 in, adapter, out 리팩토링하기
      // 10) 리팩토링하면서 기존 in2,out2변수명을 in,out으로 변경

      // 11) HTTP 프로토콜에 따라서 메인 웹 페이지를 요청한다.
      out.println("GET /thisbike HTTP/1.1"); // 어떤 자원을 요청하는지 알려주는 라인
      out.println("Host: stores.auction.co.kr");// 연결하는 서버가 어떤 서버인지 알려주는 라인
      out.println(); // 12) 요청하는 정보가 끝났다는 걸 알려주는 라인

      // 13) 웹서버의 응답을 출력한다.
      String line;
      while ((line = in.readLine()) != null) {
        System.out.println(line);
      }
    }
  }
}
