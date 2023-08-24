package baekjoon.practice1;

import java.util.Scanner;

public class Problem_27433 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    sc.close();
    System.out.print(factorial(n));
  }

  public static long factorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * factorial(n - 1);
  }
}
