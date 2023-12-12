package baekjoon.basic0.basic.step8;

import java.io.*;
import java.util.StringTokenizer;

public class Step4 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str, " ");
    int n1 = Integer.parseInt(st.nextToken());
    int n2 = Integer.parseInt(st.nextToken());

    for (int i = n1; i <= n2; i++) {
        make_prime(i);
    }
  }

  public static void make_prime(int number) {

    // 0 과 1 은 소수가 아니므로 종료
    if (number < 2) {
      return;
    }

    // 2 는 소수다
    if (number == 2) {
      System.out.println(number);
      return;
    }


    // 제곱근 함수 : Math.sqrt()
    for (int i = 2; i <= Math.sqrt(number); i++) {

      // 소수가 아닐경우 종료
      if (number % i == 0) {
        return;
      }
    }
    // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
    System.out.println(number);
    return;
  }
}
