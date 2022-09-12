package com.bitcamp.study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HttpClient {
  public static void main(String[] args) throws Exception {
    try( // 6) socket.close 지우고 try 생성 왜? close 안넣어줘도 되니깐!
        Socket socket =new Socket("www.etnews.co.kr", 80); // 1)
        BufferedReader in2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out2 = new PrintStream(socket.getOutputStream());) { // 8)
      // 9) ()안 in, adapter, out 리팩토링하기
    }
  }
}
