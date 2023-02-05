package baekjoon.step5;

import java.io.*;
import java.util.Arrays;

public class Step2 {
  public static void main(String[] args) throws IOException {
    int[] num = new int[10000];
    Arrays.fill(num, 0);
    for (int i = 1; i <= 10000; i++) {
      checkNum(i, num);
    }
    for (int i = 0; i < 10000; i++) {
      if (num[i] == 0) {
        System.out.println(i + 1);
      }
    }
  }

  static void checkNum(int n, int[] num) { // 33
    int n1 = n % 10; // 3
    int n10 = (n % 100 - n1) / 10; // 3
    int n100 = (n % 1000 - 10 * n10 - n1) / 100; // 0
    int n1000 = (n % 10000 - 100 * n100 - 10 * n10 - n1 ) / 1000; // 0

    int result = n + n1 + n10 + n100 + n1000;

    if (result <= 10000) {
      num[result - 1] = 1;
    }
  }
}

