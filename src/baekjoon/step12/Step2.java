package baekjoon.step12;

import java.io.*;

public class Step2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int input = Integer.parseInt(br.readLine());

    int n = 0;

    for (int i = 0; i < input; i++) {
      if (constructer(i) == input) {
        n = i;
        break;
      }
    }



    System.out.println(n);
  }

  static int constructer(int n) {
    int origin = n, sum = 0;

    while(n > 0) {
      sum += n % 10;
      n /= 10;
    }

    sum += origin;

    return sum;
  }
}
