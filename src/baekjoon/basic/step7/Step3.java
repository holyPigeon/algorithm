package baekjoon.basic.step7;

import java.io.*;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int n1 = Integer.parseInt(str);
    int n2 = 1; // 반복 실행 횟수
    int k = 1; // 대각선 실행 횟수
    int x = 1, y = 1; // 분수의 분모 분자
    int state = 1; // 1. 동쪽 / 2. 남서쪽 / 3. 남쪽 / 4. 북동쪽

    while(n2 != n1) {
      if (state == 1) {
        y++;
        n2++;
        state = 2;
      } else if (state == 2) {
        for (int i = 0; i < k; i++) {
          if (n2 == n1) {
            break;
          }
          x++;
          y--;
          n2++;
        }
        k++;
        state = 3;
      } else if (state == 3) {
        x++;
        n2++;
        state = 4;
      } else {
        for (int i = 0; i < k; i++) {
          if (n2 == n1) {
            break;
          }
          x--;
          y++;
          n2++;
        }
        k++;
        state = 1;
      }
    }

    bw.write(x + "/" + y);

    bw.flush();
  }


}
