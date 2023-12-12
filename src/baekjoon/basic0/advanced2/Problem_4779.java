package baekjoon.basic0.advanced2;

import java.io.*;

/*
  - n이 0일 경우 "-"을 반환한다.
  - n이 1일 경우 len = 3이므로 len(3) / 3 인덱스를 공백으로 교체, 남은 선이 길이가 1이라면 멈춘다. 아니라면 남은 선 길이의 3분의 1을 구해서 공백으로 교체
  - n이 2일 경우 len = 9이므로
  - 결과: n = 3일 경우 loop(2) + loop(3)에서 앞 뒤 짜른 거 + loop(2)를 한다.
 */

public class Problem_4779 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    String input = "";

    while((input = br.readLine()) != null) {
      int n = Integer.parseInt(input);
      sb.append(loop(n)).append("\n");
    }

    bw.write(sb.toString());
    bw.close();
  }

  // ---
  // ---------
  // --- (int)Math.pow(3, n) - (int)Math.pow(3, n-1) --- (int)Math.pow(3, n) - 2 * (int)Math.pow(3, n-1) ---

  static String loop(int n) {
    if (n == 0) { // n = 0일 때는 예외적으로 "-" 반환
      return "-";
    }

    String s = "";
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < (int)Math.pow(3, n) / 3; i++) { // n에 따른 초기 문자열 생성
      sb.append(" ");
    }
//    int front = (int)Math.pow(3, n) - 2 * (int)Math.pow(3, n-1);
//    int rear = (int)Math.pow(3, n) - (int)Math.pow(3, n-1);
//    StringBuilder sb = new StringBuilder(s);
//    for (int i = front; i < front + (int)Math.pow(3, n - 1); i++) {
//      sb.setCharAt(i, ' ');
//    }
//    s = sb.toString();
//    s = s.substring(front, rear);
    // 중간 로직 삭제
    // -> 애초에 3^n의 1/3만큼만 공백으로 만들고 나머지 2/3은 loop(n-1)로 채우면 되는 거였는데
    // 사용하지도 않을 앞의 1/3과 뒤의 1/3을 생성하고 자르는 작업을 반복하는 실수를 함 -> 삭제
    String loop = loop(n-1); // loop(n-1)을 2번 사용할 것이므로 두 번 계산하지 않게 한 번 계산한 값을 변수에 저장
    sb.insert(0, loop);
    sb.append(loop);

    return sb.toString();
  }
}
