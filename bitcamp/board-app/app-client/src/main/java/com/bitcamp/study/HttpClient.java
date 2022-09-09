package com.bitcamp.study;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpClient {
  public static void main(String[] args) throws Exception {
    Socket socket =new Socket("www.etnews.co.kr", 80); // 1)
    // 3) inputstream은 바이트 스트림이다.
    InputStream in = socket.getInputStream(); 
    // 5) 그래서 중간에 바이트 스트림을 캐릭터 스트림으로 바꿔줄 아답타를 준비하고 연결해준다.
    InputStreamReader adapter = new InputStreamReader(in);
    // 4) Http는 줄 단위로 읽을 수 있기 때문에 줄 단위로 읽을 수 있는 버퍼드 리더를 준비한다.
    // 그런데 BufferedReader는 캐릭터 스트림이다.
    BufferedReader in2 = new BufferedReader(adapter); 
    socket.close(); // 2)
  }
}
