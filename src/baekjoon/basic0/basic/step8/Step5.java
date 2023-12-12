package baekjoon.basic0.basic.step8;

import java.io.*;

public class Step5 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int num;

    while(true) {
      String str = br.readLine();
      int n1 = Integer.parseInt(str);
      int n2 = 2 * n1;
      num = 0;

      if (n1 == 0) {
        break;
      }

      for (int i = n1 + 1; i <= n2; i++) {
        if(check_prime(i)) {
          num++;
        }
      }
      System.out.println(num);
    }
  }

  static boolean check_prime(int number) {

    // 0 과 1 은 소수가 아니므로 종료
    if (number < 2) {
      return false;
    } else if (number == 2) {
      return true;
    } else {
      for (int i = 2; i <= Math.sqrt(number); i++) {

        // 소수가 아닐경우 종료
        if (number % i == 0) {
          return false;
        }
      }
      // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
      return true;
    }
  }
}
