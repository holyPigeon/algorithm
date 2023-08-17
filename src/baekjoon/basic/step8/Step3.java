package baekjoon.basic.step8;

import java.io.*;
import java.util.ArrayList;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int n = Integer.parseInt(str);
    int x = 2;
    ArrayList<Integer> list = new ArrayList<>();

    while(n > 0) {
      if (n / x == 0) {
        break;
      }
      if (n % x == 0) { // 만약 n이 x로 나머지 없이 잘 나누어졌을 때
        n = n / x; // n에서 x를 나눔
        list.add(x); // x를 소인수분해 리스트에 추가
      } else { // 만약 n이 x로 나누어 떨어지지 않는다면
        x++; // x의 값 1 증가
      }
    }

    for (int i: list) {
      bw.write(i + "\n");
    }

    bw.flush();
  }
}