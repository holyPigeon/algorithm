package baekjoon.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step6 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = reader.readLine().split(" ");
    int x1 = Integer.parseInt(str[0]);
    int x2 = Integer.parseInt(str[1]);

    System.out.println(x1 + x2);
    System.out.println(x1 - x2);
    System.out.println(x1 * x2);
    System.out.println(x1 / x2);
    System.out.println(x1 % x2);

  }
}