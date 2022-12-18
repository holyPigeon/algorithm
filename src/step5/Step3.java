package step5;

import java.io.*;

public class Step3 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String stringN = br.readLine();
    int n = Integer.parseInt(stringN);

    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (checkNum(i)) {
        count++;
      }
    }
    bw.write(String.valueOf(count));

    bw.flush();
  }

  static boolean checkNum(int n) {
    int n1 = n % 10;
    int n10 = (n % 100 - n1) / 10;
    int n100 = (n % 1000 - 10 * n10 - n1) / 100;

    if (n < 10) {
      return true;
    } else if (n < 100) {
      return true;
    } else if (n < 1000) {
      return n10 - n1 == n100 - n10;
    } else if (n == 1000) {
      return false;
    } else {
      return false;
    }
  }
}
