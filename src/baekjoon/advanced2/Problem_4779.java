package baekjoon.advanced2;

import java.io.*;
import java.util.Stack;

/*
  - n이 0일 경우 "-"을 반환한다.
  - n이 1일 경우 len = 3이므로 len(3) / 3 인덱스를 공백으로 교체, 남은 선이 길이가 1이라면 멈춘다. 아니라면 남은 선 길이의 3분의 1을 구해서 공백으로 교체
  - n이 2일 경우 len = 9이므로
 */

public class Problem_4779 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    int n = Integer.parseInt(br.readLine());
    String s = "";

    for (int i = 0; i < (int)Math.pow(3, n); i++) {
      s = s.concat("-");
    }

    System.out.println(loop(s, n));
  }

  // ---
  // ---------
  // --- (int)Math.pow(3, n) - (int)Math.pow(3, n-1) --- (int)Math.pow(3, n) - 2 * (int)Math.pow(3, n-1) ---

  static String loop(String s, int n) {
    if (n == 0) {
      return "-";
    }
    int front = (int)Math.pow(3, n) - (int)Math.pow(3, n-1);
    StringBuilder sb = new StringBuilder(s);
    for (int i = front; i < front + (int)Math.pow(3, n - 1); i++) {
      sb.setCharAt(i, ' ');
    }
    s = sb.toString();

    if (front == 1) {
      return s;
    } else {

    }
  }
}
