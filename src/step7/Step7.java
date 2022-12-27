package step7;

import java.io.*;

// 설탕 N 킬로그램 배달
// 3kg 봉지 / 5kg 봉지

public class Step7 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String str = br.readLine();
    int n = Integer.parseInt(str);
    int x5 = 0, x3 = 0;
    int result = 0;
    int count = 0;
    int no = 0;

    if (n < 5) { // n이 5보다 작다면
      if (n == 3) {
        x3 = 1;
        result = x3;
      } else if (n == 4) {
        result = -1;
      }
    } else if (n == 5) {
      x5 = 1;
      result = x5;
    } else { // n이 5보다 크다면
      if (n % 5 == 0) { // n이 5로 나누어 떨어진다면
        x5 = n / 5;
      } else { // n이 5로 나누어 떨어지지 않는다면
        while (n > 0) {
          n -= 3;
          count++;
          if (n % 5 == 0) {
            x5 = n / 5;
            no = 0;
            break;
          }
          no = 1;
        }
        x3 = count;
      }

      if (no == 1) {
        result = -1;
      } else {
        result = x5 + x3;
      }
    }

    bw.write(String.valueOf(result));

    bw.flush();
  }
}