package baekjoon.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1 {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    String[] str = reader.readLine().split(" ");
    int x = Integer.parseInt(str[0]);
    int y = Integer.parseInt(str[1]);

    if (x > y) {
      System.out.println(">");
    } else if (x < y) {
      System.out.println("<");
    } else {
      System.out.println("==");
    }
  }
}